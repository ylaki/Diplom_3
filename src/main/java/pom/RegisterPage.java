package pom;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private static final String registerURL = Constants.registerURL;
    private By nameBy = Constants.nameBy;
    private By passwordBy = Constants.passwordBy;
    private By registerButton = Constants.registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage open() {
        driver.get(registerURL);
        if (!driver.getCurrentUrl().equals(registerURL)) {
            throw new IllegalStateException("This is not Register Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
        return this;
    }

    public void RegistrationForm(String userName,String userEmail, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(nameBy).sendKeys(userName);
        driver.findElement(nameBy).sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(userEmail);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public String registrationWithRedirect(String userName,String userEmail, String password) {
        RegistrationForm(userName,userEmail,password);
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='Вход']")));
        return "Redirect to LoginPage successful";
    }
}