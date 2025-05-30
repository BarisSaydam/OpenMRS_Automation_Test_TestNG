package US_402;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_402_Elements {
    public TC_402_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='menu-item tg-header-button-wrap tg-header-button-one']")
    public WebElement demo;

    @FindBy(xpath = "//*[text()='Explore OpenMRS 2']")
    public WebElement explore;

    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    public WebElement explore2;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginButton")
    public WebElement login;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatient;
}
