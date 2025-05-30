package US_410;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_410_CrossTesting extends BaseDriverParameter {


    @Test(dataProvider = "datalarim", groups = {"Regression", "Appointment"})
    public void TimeZone(String username, String password, String patientname) {
        LogTutma.info("TimeZone testi basladi");
        TC_410_InCorrect_TimeZone_Elementleri tz = new TC_410_InCorrect_TimeZone_Elementleri(driver);

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        tz.username.sendKeys(username);
        tz.password.sendKeys(password);
        tz.inpatientWard.click();
        tz.loginButton.click();
        tz.appointmentScheduling.click();
        tz.manageAppointments.click();
        tz.searchName.sendKeys(patientname);
        tz.selectPatient.click();

        Assert.assertTrue(tz.timeZoneMsg.getText().contains("Your computer is not set to the right time zone. "), "Boyle Bir Mesaj Bulunamadi");
        System.out.println("tz.timeZoneMsg.getText() = " + tz.timeZoneMsg.getText());

        LogTutma.info("TimeZone testi bitti");
    }

    @DataProvider
    Object[] datalarim() {
        Object[][] bilgiler = {{"Admin", "Admin123", "Johan Cruijff"}};

        return bilgiler;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.

}
