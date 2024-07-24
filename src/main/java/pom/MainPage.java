package pom;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private static final String URL = Constants.URL;
    private static final By loginPageHeader = Constants.loginPageHeader;
    private static final By loginToAccountButton = Constants.loginToAccountButton;
    private static final By accountLink = Constants.accountLink;
    private static final By exitButton = Constants.exitButton;
    private static final By bunsTab = Constants.bunsTab;
    private static final By bunsHeader = Constants.bunsHeader;
    private static final By saucesTab = Constants.saucesTab;
    private static final By saucesHeader = Constants.saucesHeader;
    private static final By toppingsTab = Constants.toppingsTab;
    private static final By toppingsHeader = Constants.toppingsHeader;

    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public void clickLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(loginPageHeader));
    }

    public void clickLoginToAccountLinkNoAuth() {
        driver.findElement(accountLink).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(loginPageHeader));
    }

    public void clickLoginToAccountLink() {
        driver.findElement(accountLink).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
    }

    public void clickToBuns() {
        driver.findElement(bunsTab).click();
        (new WebDriverWait(driver,Duration.ofSeconds(1)))
                .until(ExpectedConditions.elementToBeClickable(bunsHeader));
    }

    public void clickToSauces() {
        driver.findElement(saucesTab).click();
        (new WebDriverWait(driver,Duration.ofSeconds(1)))
                .until(ExpectedConditions.elementToBeClickable(saucesHeader));
    }
    public void clickToToppings() {
        driver.findElement(toppingsTab).click();
        (new WebDriverWait(driver,Duration.ofSeconds(1)))
                .until(ExpectedConditions.elementToBeClickable(toppingsHeader));
    }

}