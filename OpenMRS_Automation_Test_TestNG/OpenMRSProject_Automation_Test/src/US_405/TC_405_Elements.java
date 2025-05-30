package US_405;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TC_405_Elements {
    public TC_405_Elements(WebDriver driver) {PageFactory.initElements(driver,this);}

    @FindBy(id = "username")
    public WebElement UserName;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = "ul[id='sessionLocation'] li")
    public List<WebElement> Locations;

    @FindBy(id = "loginButton")
    public WebElement Login;

    @FindBy(css = "div[id='navbarSupportedContent']>ul>[class='nav-item identifier']")
    public WebElement AccountIcon;

    @FindBy(linkText = "My Account")
    public WebElement MyAccount;

    @FindBy(linkText = "Change Password")
    public WebElement ChangePassword;

    @FindBy(linkText = "My Languages")
    public WebElement MyLanguages;
}
