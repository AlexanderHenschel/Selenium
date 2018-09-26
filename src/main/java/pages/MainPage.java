package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"menu-1233-1\"]")
    private WebElement vacancies;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickVacancies() {
        vacancies.click();
    }

}
