package MY_SITE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    public LogIn(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text() = 'Войти']")
    private WebElement logInButton;

    @FindBy(className = "email_field")
    private WebElement emailField;

    @FindBy(className = "password_field")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text() = 'Немає облікового запису?']")
    private WebElement regButton;

    @FindBy(className = "invalid_email")
    private WebElement invalidNameMassage;

    public void logIn(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
    public void logInButtonClick(){
        logInButton.click();
    }
    public void regButtonClick(){
        regButton.click();
    }
    public String setErrorNameText(){
        return invalidNameMassage.getText();
    }
    public boolean InvalidMassageName(){
        return invalidNameMassage.isDisplayed();
    }


}
