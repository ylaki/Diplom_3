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
import static utils.WebDriverCreator.createWebDriver;
import pom.AccountPage;
import pom.LoginPage;
import client.*;
import pom.MainPage;
import static client.UserGenerator.randomUser;

public class AccountTest {
    private WebDriver driver;
    User user = new User();
    StepsTest stepsTest = new StepsTest();
    String mainPageURL = "https://stellarburgers.nomoreparties.site/";
    String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
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
    @DisplayName("Account test")
    @Description("Redirect from Account page to the Constructor via Constructor button")
    public void redirectToConstructorViaConstructorButtonTest() {
        AccountPage accountPage = new AccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        mainPage.clickLoginToAccountLink();
        accountPage.clickToConstructor();
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
    @DisplayName("Account test")
    @Description("Redirect from Account page to the Constructor via Logo")
    public void redirectToConstructorViaLogoTest() {
        AccountPage accountPage = new AccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        mainPage.clickLoginToAccountLink();
        accountPage.clickToLogo();
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
    @DisplayName("Exit button test")
    @Description("Click exit button to to check logoff")
    public void exitButtonTest() {
        AccountPage accountPage = new AccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        UserData userData = randomUser();
        user.create(userData);

        loginPage.loginForm(userData.getEmail(), userData.getPassword());
        mainPage.clickLoginToAccountLink();
        accountPage.clickToExitButton();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = loginPageURL;
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