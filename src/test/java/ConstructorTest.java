import client.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import static utils.WebDriverCreator.createWebDriver;

public class ConstructorTest {
    private WebDriver driver;
    StepsTest stepsTest = new StepsTest();

    @Before
    public void setup() {
        driver = createWebDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown () {
        driver.quit();
    }

    @Test
    @DisplayName("Constructor buns test")
    @Description("Open buns section")
    public void clickBunsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickToSauces();
        mainPage.clickToBuns();
        WebElement bunsElement = driver.findElement(By.xpath("//h2[text()='Булки']"));
        boolean bunsDisplayed = bunsElement.isDisplayed();
        stepsTest.verifyElementDisplayed(bunsDisplayed);
    }

    @Test
    @DisplayName("Constructor sauces test")
    @Description("Open sauces section")
    public void clickSaucesTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickToSauces();
        WebElement saucesElement = driver.findElement(By.xpath("//h2[text()='Соусы']"));
        boolean saucesDisplayed = saucesElement.isDisplayed();
        stepsTest.verifyElementDisplayed(saucesDisplayed);
    }

    @Test
    @DisplayName("Constructor toppings test")
    @Description("Open toppings section")
    public void clickToppingsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickToToppings();
        WebElement toppingsElement = driver.findElement(By.xpath("//h2[text()='Начинки']"));
        boolean toppingsDisplayed = toppingsElement.isDisplayed();
        stepsTest.verifyElementDisplayed(toppingsDisplayed);
    }
}