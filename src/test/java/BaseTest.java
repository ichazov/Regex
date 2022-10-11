import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver chromeDriver = new ChromeDriver();
    @BeforeAll
    static void setUp() {
        chromeDriver.get("https://www.epam.com/about/who-we-are/contact");
        chromeDriver.manage().window().maximize();
    }
    @AfterAll
    static void tearDown() {
        chromeDriver.quit();
    }
}
