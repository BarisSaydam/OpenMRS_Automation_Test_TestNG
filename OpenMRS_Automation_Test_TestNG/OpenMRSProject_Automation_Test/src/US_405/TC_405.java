package US_405;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_405  {

    @Test(dataProvider = "data", groups = {"Smoke"})
    public void MyAccount(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 5 sn mühlet: elementi bulma mühleti

        TC_405_Elements elements = new TC_405_Elements(driver);
        LogTutma.info("TC_01 MyAccount Test Basladi.");

        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(2);

        elements.UserName.sendKeys(username);
        elements.Password.sendKeys(password);

        List<WebElement> loc = elements.Locations;
        int rnd = (int) (Math.random() * loc.size());

        elements.Locations.get(rnd).click();
        elements.Login.click();
        new Actions(driver).moveToElement(elements.AccountIcon).build().perform();

        elements.MyAccount.click();
        elements.ChangePassword.click();
        new Actions(driver).moveToElement(elements.AccountIcon).build().perform();

        elements.MyAccount.click();
        elements.MyLanguages.click();

        LogTutma.info("TC_01 MyAccount Test Bitti.");

        MyFunc.Bekle(3);
        driver.quit();

    }

    @DataProvider
    Object[] data() {
        Object[][] data = {{"Admin", "Admin123"}};
        return data;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
