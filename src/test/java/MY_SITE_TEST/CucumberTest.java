package MY_SITE_TEST;

import MY_SITE.LogIn;
import MY_SITE.MainPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.AssertJUnit.assertTrue;

public class CucumberTest {
    WebDriver driver;
    LogIn logIn;
    MainPage mainPage;



    private String site = "https://localhost:3000";

    @Before
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
    }

    @Then("Користувач знаходиться на сторінкі входу")
    public void givenUserOnRegistrationPage() {
        driver.get(site);

    }
    @When("Користувач знаходиться на сторінці входу")
    public void givenUserIsOnRegistrationPage() {
        driver.get(site);

    }
    @Then("Користувач вводить свої дані: {string} та {string}")
    public void enterUserData(String email, String password) {
        logIn = new LogIn(driver);
        logIn.logIn(email,password);
    }
    @Then("Користувач натискає кнопку 'Ввійти'")
    public void whenUserClicksRegisterButton() {
        logIn = new LogIn(driver);
        logIn.logInButtonClick();
    }
    @Then("Користувач повинен бачити головну сторінку")
    public void thenUserSeesSuccessfulRegistrationMessage() {
        mainPage = new MainPage(driver);
    }

    @Then("Користувач повинен бачити повідомлення про невдалий вхід")
    public void thenUserCanLoginWithEnteredData() {
        logIn = new LogIn(driver);
        logIn.InvalidMassageName();
    }
}
