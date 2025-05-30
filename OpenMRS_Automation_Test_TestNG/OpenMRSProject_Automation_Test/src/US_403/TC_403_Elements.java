package US_403;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_403_Elements {
    public TC_403_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginBTN;

    @FindBy(xpath = "//a[contains(@href, 'logout.action')]")
    public WebElement logoutBtn;


}
