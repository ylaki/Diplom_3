package pom;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;
    private final By constructorButton = Constants.constructorButton;
    private final By makeOrderButton = Constants.makeOrderButton;
    private final By accountLogo = Constants.accountLogo;
    private final By exitButton = Constants.exitButton;
    private final By loginPageHeader = Constants.loginPageHeader;
    public AccountPage(WebDriver webDriver) {
        this.driver = webDriver;
        }

        public void clickToConstructor() {
            driver.findElement(constructorButton).click();
            (new WebDriverWait(driver,Duration.ofSeconds(5)))
                    .until(ExpectedConditions.elementToBeClickable(makeOrderButton));
        }

        public void clickToLogo() {
        driver.findElement(accountLogo).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(makeOrderButton));
    }

    public void clickToExitButton() {
        driver.findElement(exitButton).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(loginPageHeader));
    }

}
