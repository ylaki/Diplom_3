import client.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StepsTest {

    @Step("URL redirect check")
    public void compareURL(String expectedURL, String currentURL) {
        assertThat(expectedURL, is(currentURL));
    }

    @Step("Check if element shown on the page")
    public void verifyElementDisplayed(boolean elementToDisplay) {
        assertTrue("Element not found", elementToDisplay);
    }

}