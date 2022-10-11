package pages;

import org.openqa.selenium.support.PageFactory;
import waits.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends PageFactory{
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }
    public void waitUntilPageIsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(CustomConditions.jQueryAJAXsCompleted());
    }
    public String getPageUrl() {
        waitUntilPageIsLoaded();
        return driver.getCurrentUrl();
    }
}
