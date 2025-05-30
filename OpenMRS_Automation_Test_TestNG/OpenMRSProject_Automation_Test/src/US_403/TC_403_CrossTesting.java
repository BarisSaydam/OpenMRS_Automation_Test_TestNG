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

public class TC_403_CrossTesting extends BaseDriverParameter {

    @Test(dataProvider = "Logout", groups = {"Logout", "Smoke"})
    public void TC_01(String username, String password) {
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
    }

    @DataProvider
    Object[] Logout() {
        Object[][] Logout = {{"admin", "Admin123"}};
        return Logout;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
