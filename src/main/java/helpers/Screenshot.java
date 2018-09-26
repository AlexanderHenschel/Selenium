package helpers;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDate;

public class Screenshot extends TestWatcher {

    private WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
        driver.quit();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            LocalDate localDate = LocalDate.now();
            String filename = getClass().getName() + localDate +  ".png";
            FileUtils.copyFile(source, new File("C:\\Users\\alexa\\Desktop\\Markant\\" + filename));

            System.out.println("Screenshot taken");
            driver.quit();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
