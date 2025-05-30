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

public class TC_406_CrossTesting extends BaseDriverParameter {

    @Test(dataProvider = "data" , groups = {"Smoke","PatientManagement"})
    public void MyAccount(String username, String password) {
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

    }

    @DataProvider
    Object[] data() {
        Object[][] data = {{"admin","Admin123"}};
        return data;

    }

    public static Logger LogTutma = LogManager.getLogger();
}