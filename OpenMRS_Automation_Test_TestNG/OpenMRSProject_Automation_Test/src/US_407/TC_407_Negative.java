package US_407;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_407_Negative  {
    public static WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "Data1", groups = {"Smoke", "PatientManagement"})
    public void Test(String username, String password) {

        As_a_Admin_Login_Accaount(username, password);
        Find_And_Delete_User();
    }

    public void As_a_Admin_Login_Accaount(String username, String password) {

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        TC_407_Elements elements = new TC_407_Elements(driver);
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys(username);
        elements.password.sendKeys(password);
        elements.inpatientWard.click();
        elements.loginBTN.click();

        MyFunc.Bekle(3);
        driver.quit();
    }

    @DataProvider
    Object[] Data1() {
        Object[][] data1 = {{"Admin", "Admin123"}};
        return data1;
    }

    public void Find_And_Delete_User() {
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        TC_407_Elements elements = new TC_407_Elements(driver);
        elements.findPatientRecord.click();
        elements.searchBtn.sendKeys("test1");
        elements.firstPatient.click();
        elements.deletePatiens.click();
        wait.until(ExpectedConditions.visibilityOf(elements.deleteReason));
        elements.deleteReason.sendKeys("?!1"); // burada rakam veya ozel isaret girdigimizde de ayni sekilde hastayi silebiliyoruz.
        //Örnek Silme Sebepleri:
        //Gizlilik
        //Hatalı Bilgi
        //İlişkilendirme Hatası
        //Vefat: Decease
        //Hasta Talebi
        //Hukuki Gerekçe
        //Güvenlik İhlali
        //Veritabanı Sorunu

        //  Yukarida da belirtildigi gibi ornek silme sebepleri bulunmaktadir.
        // Fakat herhangi ozel karakter veya integer girdi dahi olsa hasta basari ile silinmektedir.

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmDelete));
        elements.confirmDelete.click();

        Assert.assertEquals(elements.successfulDelete.getText(), "Patient has been deleted successfully");

        MyFunc.Bekle(3);
        driver.quit();

        // Sonuc olarak bu test basarisiz olmasi gerek ama hasta basarili bir sekilde silindi
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
    public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
}
