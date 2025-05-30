package US_401;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class TC_401 {

    @Test(dataProvider = "Data", groups = {"Smoke", "Login"})
    public void Test1(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        TC_401_Elements elements = new TC_401_Elements(driver);
        LogTutma.info("TC_01 Başladı");

        driver.get("https://openmrs.org");
        elements.demo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");

        MyFunc.Bekle(2);
        elements.explore.click();
        MyFunc.Bekle(2);

        elements.explore2.click();
        MyFunc.Bekle(2);
        elements.username.sendKeys(username);
        elements.password.sendKeys(password);
        elements.login.click();

        Assert.assertTrue(elements.location.getText().contains("You must choose a location!"));

        elements.inpatient.click();
        elements.username.clear();
        elements.password.clear();
        MyFunc.Bekle(2);

        elements.username.sendKeys(username);
        elements.password.sendKeys(password);
        elements.login.click();

        Assert.assertTrue(elements.error.getText().contains("Invalid username/password. Please try again."));

        LogTutma.info("TC_01 Tamamlandı");

        MyFunc.Bekle(3);
        driver.quit();

    }

    @DataProvider
    Object[] Data() {
        Object[][] data = {{"Gamze", "1234"}, {"Gmze", "2s321"}, {"", ""}, {"Gamzee", "12121"}, {"g111", "5474647"}};
        return data;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
