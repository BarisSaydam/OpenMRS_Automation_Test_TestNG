package US_408;

import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class TC_408 {

    public WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "Data", groups = {"Regression", "PatientManagement"})
    public void TC_01(String username, String password) {

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        TC_408_Elements elements = new TC_408_Elements(driver);

        LogTutma.info("TC_01 Başladı");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys(username);
        elements.password.sendKeys(password);
        elements.inpatientWard.click();
        elements.loginBTN.click();

        elements.findPatientRecord.click();
        String[] table = elements.dataTables.getText().split("of");
        int updtTable = Integer.parseInt(table[1].replaceAll("[^0-9]", ""));

        Assert.assertEquals(elements.table.size(), updtTable, "Bilgi ile satır sayısı uyuşmuyor");

        LogTutma.info("TC_01 Tamamlandı");

        MyFunc.Bekle(3);
        driver.quit();

    }

    @DataProvider
    Object[] Data() {
        Object[][] data = {{"Admin", "Admin123"}};
        return data;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
