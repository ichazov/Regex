package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactUsPage extends BasePage {
    @FindBy (xpath = "//span[@class='font-size-22']")
    private static WebElement address;
    private static final Map<String, String> structuredAddress = new HashMap<>();
    public static final String ADDRESS_REGEX = "(.*) • (.[^,]*),\\n(.[^,]*), (\\w+) (\\w+) • (\\w+)";
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    public static String getAddressString() {
        return address.getText();
    }
    public static Map<String, String> getAddress() {
        Matcher matcher = Pattern
                .compile(ADDRESS_REGEX)
                .matcher(address.getText());

        if (matcher.find()) {
            structuredAddress.put("Street:", matcher.group(1));
            structuredAddress.put("Apartment:", matcher.group(2));
            structuredAddress.put("City:", matcher.group(3));
            structuredAddress.put("State:", matcher.group(4));
            structuredAddress.put("Postal Code:", matcher.group(5));
            structuredAddress.put("Country:", matcher.group(6));
        }

        return structuredAddress;
    }
}
