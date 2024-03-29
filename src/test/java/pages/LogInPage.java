package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;
import wrappers.SeleniumWrapper;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.*;

public class LogInPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//
    private By loginPageTitle = By.xpath("//div[@class=\"page-title\"]");
    private By alreadyRegisteredHeader = By.xpath("//h2[text()=\"Already registered?\"]");
    private By createAccountButton = By.xpath("//a[@title=\"Create an Account\"]");
    private By emailInputField = By.id("email");
    private By passwordInputField = By.id("pass");
    private By loginButton = By.xpath("//button[@title=\"Login\"]");
    private By forgotPasswordHyperlink = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/forgotpassword/\"]");
    private By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private By emailRequiredErrorMessage = By.id("advice-required-entry-email");
    private By emailInvalidErrorMessage = By.id("advice-validate-email-email");
    private By passwordRequiredErrorMessage = By.id("advice-required-entry-pass");
    private By credentialsInvalidErrorMessage = By.xpath("//li[@class=\"error-msg\"]");

    //____________________PRIVATE METHODS____________________//



    //____________________PUBLIC METHODS____________________//
    public String getCurrentUrl() {
        return SeleniumWrapper.getCurrentUrl();
    }
    public void clickCreateAccountButton() {
        click(createAccountButton);
    }
    public void enterEmail(String string) {
        sendKeys(emailInputField, string);
    }
    public void enterPassword(String string) {
        sendKeys(passwordInputField, string);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        waitsWrapper.waitElementToBeClickable(loginButton, 1);
        click(loginButton);
    }
    public void clearPasswordInputField() {
        clear(passwordInputField);
    }
    public void clearEmailInputField() {
        clear(emailInputField);
    }
    public void loginUser(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }
    public void clearCredentialsInputFields() {
        clearEmailInputField();
        clearPasswordInputField();
    }
    public boolean loginButtonIsDisplayed() {
        return isElementDisplayed(loginButton);
    }
    public String getEmailRequiredErrorMessage() {
        return getText(emailRequiredErrorMessage);
    }
    public boolean emailRequiredErrorMessageIsDisplayed() {
        waitsWrapper.waitElementToBeVisible(emailRequiredErrorMessage, 1);
        return isElementDisplayed(emailRequiredErrorMessage);
    }
    public String getPasswordRequiredErrorMessage() {
        return getText(passwordRequiredErrorMessage);
    }
    public boolean passwordInputErrorIsDisplayed() {
        waitsWrapper.waitElementToBeVisible(passwordRequiredErrorMessage, 1);
        return isElementDisplayed(passwordRequiredErrorMessage);
    }
    public String getCredentialsInvalidErrorMessage() {
        return getText(credentialsInvalidErrorMessage);
    }
    public void clickForgotPassword() {
        click(forgotPasswordHyperlink);
    }
    public void clickRememberMeCheckbox() {
        click(rememberMeCheckbox);
    }
    public String getAlreadyRegisteredHeader() {
        return getText(alreadyRegisteredHeader);
    }
    public String getLoginPageTitle() {
        return getText(loginPageTitle);
    }
    public boolean credentialsInvalidErrorMessageIsDisplayed() {
        return isElementDisplayed(credentialsInvalidErrorMessage);
    }
}
