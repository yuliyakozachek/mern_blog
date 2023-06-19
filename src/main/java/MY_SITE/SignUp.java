package MY_SITE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    public SignUp(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text() = 'Підтвердити']")
    private WebElement regButton;

    @FindBy(className = "email_field")
    private WebElement emailField;

    @FindBy(className = "password_field")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text() = 'Уже авторизовані?']")
    private WebElement loginButton;

    @FindBy(className = "invalid_email")
    private WebElement invalidNameMassage;

    public void registerUser(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
    public void regButtonClick(){
        regButton.click();
    }
    public void loginButtonClick(){
        loginButton.click();
    }

}
