package US_411;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_411_TimeZone_Elementleri {

    public TC_411_TimeZone_Elementleri(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@class='icon-calendar'])[2]")
    public WebElement appointmentScheduling;

    @FindBy(css = "[id='appointmentschedulingui-manageAppointments-app']")
    public WebElement manageAppointments;

    @FindBy(css = "[id='patient-search']")
    public WebElement searchName;

    @FindBy(xpath = "//*[text()='Johan Cruijff']")
    public WebElement selectPatient;

    @FindBy(css = "[id='time-zone-warning']>:nth-child(1)>:nth-child(1)>:nth-child(2)")
    public WebElement timeZoneMsg;

}
