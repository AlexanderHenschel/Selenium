package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        initPage();
    }

    private void initPage() {
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

}
