package MY_SITE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }
}
