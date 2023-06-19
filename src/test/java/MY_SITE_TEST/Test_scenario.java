package MY_SITE_TEST;

import MY_SITE.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_scenario {

    WebDriver driver;
    Screenshots screenshots;
    StarPage starPage;
    LogIn logIn;
    SignUp signUp;
    MainPage mainPage;

    private String site = "https://localhost:3000";


    @BeforeClass
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        //Вхід в аккаунт
        String email = "testaccaunt@gmail.com", password = "qweqweqwe";
        driver.get(site);
        starPage = new StarPage(driver);
        starPage.clickOnLoginButton();
        logIn = new LogIn(driver);
        logIn.logIn(email,password);
        logIn.logInButtonClick();
    }

    @Test
    public void test2(){
        //Реестрація нового аккаунта
        String email = "testaccaunt1@gmail.com", password = "qweqweqwe";
        driver.get(site);
        starPage = new StarPage(driver);
        starPage.clickOnLoginButton();
        logIn = new LogIn(driver);
        logIn.regButtonClick();
        signUp = new SignUp(driver);
        signUp.registerUser(email,password);
        signUp.regButtonClick();
    }

        @AfterClass
        public void endTest() throws IOException, InterruptedException {
        screenshots = new Screenshots();
        screenshots.screenshotes(driver,"EndTest");
        driver.quit();
    }


}
