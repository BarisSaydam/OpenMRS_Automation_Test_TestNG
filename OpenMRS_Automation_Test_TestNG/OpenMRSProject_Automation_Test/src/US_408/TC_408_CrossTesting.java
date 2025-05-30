package US_408;

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


public class TC_408_CrossTesting extends BaseDriverParameter {

    @Test(dataProvider = "Data", groups = {"Regression", "PatientManagement"})
    public void TC_01(String username, String password) {
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

    }

    @DataProvider
    Object[] Data() {
        Object[][] data = {{"Admin", "Admin123"}};
        return data;
    }

    public static Logger LogTutma = LogManager.getLogger();      //Logları ekliceğim nesneyi başlattım.
}
