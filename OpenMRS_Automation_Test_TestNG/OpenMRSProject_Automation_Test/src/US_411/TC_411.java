package US_411;

import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_411 {
    public WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "datalarim", groups = {"Regression", "Appointment"})
    public void TimeZone(String username, String password, String patientname) {

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        LogTutma.info("TimeZone testi basladi");
        TC_411_TimeZone_Elementleri tz = new TC_411_TimeZone_Elementleri(driver);

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        tz.username.sendKeys(username);
        tz.password.sendKeys(password);
        tz.inpatientWard.click();
        tz.loginButton.click();
        tz.appointmentScheduling.click();
        tz.manageAppointments.click();
        tz.searchName.sendKeys(patientname);
        tz.selectPatient.click();

        Assert.assertFalse(tz.timeZoneMsg.getText().contains("Your computer is not set to the right time zone. "), "Saat dilimi hatasi alindi!");

        LogTutma.info("TimeZone testi bitti");

        MyFunc.Bekle(3);
        driver.quit();
    }

    @DataProvider
    Object[] datalarim() {
        Object[][] bilgiler = {{"Admin", "Admin123", "Johan Cruijff"}};

        return bilgiler;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
