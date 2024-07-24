package pom;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    protected WebDriver driver;
    private static final String forgotPasswordURL = Constants.forgotPasswordURL;
    private final By loginLink = Constants.loginLink;
    private final By loginPageHeader = Constants.loginPageHeader;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPasswordPage open() {
        driver.get(forgotPasswordURL);
        if (!driver.getCurrentUrl().equals(forgotPasswordURL)) {
            throw new IllegalStateException("This is not Sign In Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
        return this;
    }

    public void passwordRestoreClick() {
        driver.findElement(loginLink).click();
        (new WebDriverWait(driver,Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(loginPageHeader));
    }
}