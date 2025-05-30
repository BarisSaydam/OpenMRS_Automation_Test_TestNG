package US_404;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_404  {

    @Test(dataProvider = "datalarim", groups = {"Regression"})
    public void registerAPatient(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        LogTutma.info("registerAPatient testi basladi");

        TC_404_RegisterAPatient_Elementleri rp = new TC_404_RegisterAPatient_Elementleri(driver);

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        rp.userName.sendKeys(username);
        rp.passWord.sendKeys(password);
        rp.inpatientWard.click();
        rp.loginButton.click();
        rp.registerPatient.click();
        rp.firstName.sendKeys("Johan");
        rp.familyName.sendKeys("Cruijff");
        rp.nextBttn.click();
        rp.gender.click();
        rp.nextBttn.click();
        rp.birthDay.sendKeys("01");
        rp.birthMonth.click();
        rp.birthYear.sendKeys("1950");
        rp.nextBttn.click();
        rp.address.sendKeys("Dam Square");
        rp.city.sendKeys("Amsterdam");
        rp.country.sendKeys("Netherlands");
        rp.nextBttn.click();
        rp.patientPhoneNumber.sendKeys("020123456");
        rp.nextBttn.click();
        rp.relationType.click();
        rp.personName.sendKeys("Nistelrooy");
        rp.nextBttn.click();
        rp.confirm.click();

        MyFunc.Bekle(2);

        WebElement hastaIsmi = driver.findElement(By.cssSelector("[class='PersonName-familyName']"));
        WebElement hastaID = driver.findElement(By.xpath("//*[text()='Patient ID']"));


        Assert.assertTrue(hastaIsmi.getText().contains("Cruijff"), "Boyle bir isim ile bir kayit yok");
        Assert.assertTrue(hastaID.getText().contains("Patient ID"), "Boyle bir ID ile bir kayit yok");

        System.out.println("Isim = " + hastaIsmi.getText());
        System.out.println("ID = " + hastaID.getText());

        LogTutma.info("registerAPatient testi bitti");

        MyFunc.Bekle(3);
        driver.quit();
    }

    @DataProvider
    Object[] datalarim() {
        Object[][] bilgiler = {{"Admin", "Admin123"}};

        return bilgiler;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
