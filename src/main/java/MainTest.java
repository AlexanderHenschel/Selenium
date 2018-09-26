import helpers.Screenshot;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ObjectTemplate;
import pages.VacancyPage;

import static org.junit.Assert.assertTrue;

public class MainTest implements ObjectTemplate {

    private static WebDriver webdriver;
    private MainPage mainPage;
    private VacancyPage vacancyPage;

    @Rule
    public TestRule screenshotTaker = new Screenshot(webdriver);

    @BeforeClass
    public static void setUpOnce() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexa\\Desktop\\Markant\\chromedriver_win32\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        initPageObjects();
    }

    @Test
    public void checkAmountOfOpenVacancies() {
        webdriver.get("https://www.markant-karriere.com/de");
        mainPage.clickVacancies();
        System.out.println(vacancyPage.getVacanciesAmount());
        assertTrue(vacancyPage.getVacanciesAmount() > 0);
    }

    @Override
    public void initPageObjects() {
        mainPage = new MainPage(webdriver);
        vacancyPage = new VacancyPage(webdriver);
    }
}
