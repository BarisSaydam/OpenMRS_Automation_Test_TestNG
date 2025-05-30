package US_404;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_404_RegisterAPatient_Elementleri {

    public TC_404_RegisterAPatient_Elementleri(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement registerPatient;

    @FindBy(css = "[name='givenName']")
    public WebElement firstName;

    @FindBy(css = "[name='familyName']")
    public WebElement familyName;

    @FindBy(css = "[id='next-button'] icon")
    public WebElement nextBttn;

    @FindBy(css = "[id='gender-field']> :nth-child(1)")
    public WebElement gender;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDay;

    @FindBy(css = "[name='birthdateMonth']> :nth-child(2)")
    public WebElement birthMonth;

    @FindBy(css = "[name='birthdateYear']")
    public WebElement birthYear;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "cityVillage")
    public WebElement city;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(css = "[name='phoneNumber']")
    public WebElement patientPhoneNumber;

    @FindBy(css = "[id='relationship_type']> :nth-child(2)")
    public WebElement relationType;

    @FindBy(css = "[placeholder='Person Name']")
    public WebElement personName;

    @FindBy(id = "submit")
    public WebElement confirm;
}
