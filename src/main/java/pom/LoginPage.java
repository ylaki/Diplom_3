package pom;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    private static final String loginURL = Constants.loginURL;
    private By messageBy = By.tagName("h2");
    private By nameBy = By.name("name");
    private By passwordBy = By.name("Пароль");
    private final By loginButton = Constants.loginButton;
    private final By makeOrderButton = Constants.makeOrderButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(loginURL);
        if (!driver.getCurrentUrl().equals(loginURL)) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
        return this;
    }

    public String loginForm(String userName, String password) {
        driver.findElement(nameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButton).click();
        (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(makeOrderButton));
        return "Redirect to MainPage successful";
    }
}