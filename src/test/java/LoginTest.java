import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import models.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import client.*;
import pom.MainPage;
import static client.UserGenerator.randomUser;
import static utils.WebDriverCreator.createWebDriver;

public class LoginTest {
    private WebDriver driver;
    User user = new User();
    StepsTest stepsTest = new StepsTest();
    String mainPageURL = "https://stellarburgers.nomoreparties.site/";
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setup() {
        driver = createWebDriver();
        driver.manage().window().maximize();
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void tearDown () {
        driver.quit();
    }

    @Test
    @DisplayName("Login test")
    @Description("Login via loginButton on the MainPage")
    public void loginViaLoginButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickLoginToAccountButton();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        String currentURL = driver.getCurrentUrl();
        String expectedURL = mainPageURL;
        stepsTest.compareURL(expectedURL,currentURL);

        UserData loginCredentials = new UserData()
                .withEmail(userData.getEmail())
                .withPassword(userData.getPassword());
        Response loginResponse = user.login(loginCredentials);
        ResponseBody body = loginResponse.getBody();
        String bearerToken = body.path("accessToken");

        user.delete(bearerToken);
    }

    @Test
    @DisplayName("Login test")
    @Description("Login via Account link on the MainPage")
    public void loginViaAccountLinkOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickLoginToAccountLinkNoAuth();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        String currentURL = driver.getCurrentUrl();
        String expectedURL = mainPageURL;
        stepsTest.compareURL(expectedURL,currentURL);

        UserData loginCredentials = new UserData()
                .withEmail(userData.getEmail())
                .withPassword(userData.getPassword());
        Response loginResponse = user.login(loginCredentials);
        ResponseBody body = loginResponse.getBody();
        String bearerToken = body.path("accessToken");

        user.delete(bearerToken);
    }

    @Test
    @DisplayName("Login test")
    @Description("Login via ForgotPasswordPage")
    public void loginViaForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.passwordRestoreClick();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        String currentURL = driver.getCurrentUrl();
        String expectedURL = mainPageURL;
        stepsTest.compareURL(expectedURL,currentURL);

        UserData loginCredentials = new UserData()
                .withEmail(userData.getEmail())
                .withPassword(userData.getPassword());
        Response loginResponse = user.login(loginCredentials);
        ResponseBody body = loginResponse.getBody();
        String bearerToken = body.path("accessToken");

        user.delete(bearerToken);
    }
}

