package US_403;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_403  {

    @Test(dataProvider = "Logout", groups = {"Logout", "Smoke"})
    public void TC_01(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti
        TC_403_Elements elements = new TC_403_Elements(driver);

        LogTutma.info("TC_01 Başladı");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        elements.userName.sendKeys(username);
        elements.password.sendKeys(password);
        elements.inpatientWard.click();
        elements.loginBTN.click();
        MyFunc.Bekle(1);
        elements.logoutBtn.click();

        MyFunc.Bekle(3);
        driver.quit();
    }

    @DataProvider
    Object[] Logout() {
        Object[][] Logout = {{"admin", "Admin123"}};
        return Logout;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
