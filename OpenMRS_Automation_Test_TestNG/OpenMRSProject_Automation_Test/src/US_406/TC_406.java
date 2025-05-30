package US_406;

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

public class TC_406  {

    @Test(dataProvider = "data" , groups = {"Smoke","PatientManagement"})
    public void MyAccount(String username, String password) {

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        TC_406_Elements elements = new TC_406_Elements(driver);
        LogTutma.info("TC_01 MyAccount Test Basladi.");

        elements.userName.sendKeys(username);

        elements.password.sendKeys(password);

        elements.inpatientWard.click();

        elements.loginbutton.click();

        elements.FindPatientRecord.click();

        elements.PatientSearch.sendKeys("Emma Hostert 100 HTR");

        wait.until(ExpectedConditions.textToBePresentInElement(elements.NoMatching,"No matching records found"));

        Assert.assertEquals(elements.NoMatching.getText(), "No matching records found");
        LogTutma.info("TC_01 MyAccount Test Bitti.");

        MyFunc.Bekle(3);
        driver.quit();

    }

    @DataProvider
    Object[] data() {
        Object[][] data = {{"admin","Admin123"}};
        return data;

    }
    public static WebDriver driver = new ChromeDriver();
    public static Logger LogTutma = LogManager.getLogger();
    public static WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
}