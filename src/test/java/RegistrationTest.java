import constants.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import models.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPage;
import pom.RegisterPage;
import client.*;
import org.openqa.selenium.WebElement;
import static client.UserGenerator.randomUser;
import static utils.WebDriverCreator.createWebDriver;
public class RegistrationTest {
    private WebDriver driver;
    User user = new User();
    StepsTest stepsTest = new StepsTest();
    private static final String mainPageURL = Constants.URL;
    private static final String BASE_URL = Constants.BASE_URL;


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
    @DisplayName("Register new user")
    @Description("Successful new user register")
    public void SuccessfulUserRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.open();
        UserData userData = randomUser();

        registerPage.registrationWithRedirect(userData.getName(),userData.getEmail(), userData.getPassword());
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
    @DisplayName("Register new user")
    @Description("Failed new user register")
    public void FailedUserRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        UserData userData = randomUser();

        registerPage.RegistrationForm(userData.getName(), userData.getEmail(), "12345");
        WebElement invalidPassword = driver.findElement(By.xpath("//*[contains(text(), 'Некорректный пароль')]"));
        boolean invalidPasswordCheck = invalidPassword.isDisplayed();

        stepsTest.verifyElementDisplayed(invalidPasswordCheck);
    }
}

