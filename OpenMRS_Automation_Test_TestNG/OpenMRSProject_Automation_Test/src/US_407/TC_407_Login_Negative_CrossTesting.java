package US_407;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_407_Login_Negative_CrossTesting extends BaseDriverParameter {

    // Burada ki Test te Kullanici adini buyuk kucuk fark etmeksizin yazdigimizda login oldugunu gordum.
    // Sonuc olarak bu sekil de giris yapmamasi gerek. Ama sonuc basarili bir sekilde sisteme giris yapildi.
    @Test(dataProvider = "Data4", groups = {"Smoke", "PatientManagement"})
    public void Test(String username, String password) {

        As_a_Admin_Login_Accaount(username, password);
    }

    @DataProvider
    Object[] Data4() {
        Object[][] data1 = {{"aDmIn", "Admin123"}}; // burada bir buyuk bir kucuk harfle kullanici adini girdim
        return data1;
    }

    public void As_a_Admin_Login_Accaount(String username, String password) {
        WebDriver driver = new ChromeDriver();
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
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.

}
