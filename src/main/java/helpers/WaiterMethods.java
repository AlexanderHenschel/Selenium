package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class WaiterMethods {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int DEFAULT_POLLING = 1;

    private WebDriver driver;

    public WaiterMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntillElementToBeClickable(WebElement Element) {
        FluentWait<WebDriver> ClickableWait = new FluentWait<>(driver)
                .withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(DEFAULT_POLLING, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        ClickableWait.until(ExpectedConditions.elementToBeClickable(Element));
    }

}
