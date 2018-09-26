package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VacancyPage extends AbstractPage{

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div[3]/div/div/div[2]/table/tbody")
    private WebElement getVacanciesTable;

    public VacancyPage(WebDriver driver) {
        super(driver);
    }

    public int getVacanciesAmount() {
        WebElement table = getVacanciesTable;
        List<WebElement> allVacanciesInTable = table.findElements(By.tagName("tr"));
        return allVacanciesInTable.size();
    }

}
