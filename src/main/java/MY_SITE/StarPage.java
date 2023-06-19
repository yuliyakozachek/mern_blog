package MY_SITE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarPage {

    public StarPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header_action_login")
    private WebElement logInButton;

    public void clickOnLoginButton(){
        logInButton.click();
    }

}
