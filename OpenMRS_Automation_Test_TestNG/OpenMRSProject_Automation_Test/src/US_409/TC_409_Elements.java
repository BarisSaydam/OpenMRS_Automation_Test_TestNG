package US_409;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_409_Elements {

    public TC_409_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    public WebElement registerPatient;

    @FindBy(name = "givenName")
    public WebElement givenName;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginBTN;

    @FindBy(id = "next-button")
    public WebElement nextBtn;

    @FindBy(id = "gender-field")
    public WebElement gender;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    public WebElement birthMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement birthYear;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "submit")
    public WebElement confirmBtn;

    @FindBy(xpath = "//div[@class='float-sm-right']//span")
    public WebElement patientID;

    @FindBy(id = "coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
    public WebElement dataMngBtn;

    @FindBy(id = "coreapps-mergePatientsHomepageLink-app")
    public WebElement mergePatientBtn;

    @FindBy(id = "patient1-text")
    public WebElement firstIDWrite;

    @FindBy(id = "patient2-text")
    public WebElement secondIDWrite;


    @FindBy(id = "first-patient")
    public WebElement firstPatient;

    @FindBy(id = "confirm-button")
    public WebElement continueBtn;

    @FindBy(id = "patient-search-clear-button")
    public WebElement forContinue;

    @FindBy(xpath = "//div[@class='float-sm-right']//span")
    public WebElement firstPatientID;

    @FindBy(xpath = "(//div[@class='float-sm-right']//span)[2]")
    public WebElement secondPatientID;
}
