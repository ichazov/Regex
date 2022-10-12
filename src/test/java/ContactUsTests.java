import org.junit.jupiter.api.Test;
import pages.ContactUsPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ContactUsTests extends BaseTest {

    ContactUsPage contactUsPage = new ContactUsPage(chromeDriver);
    Map<String, String> epamAddress = ContactUsPage.getAddress();

    @Test
    void verifyAddressMatchesRegex() {
        ContactUsPage.getAddress();
        assertTrue(ContactUsPage
                .getAddressString()
                .matches(ContactUsPage.ADDRESS_REGEX));
    }

    @Test
    void verifyStreetMatchesGivenValue() {
        assertEquals("41 University Drive", epamAddress.get("Street:"));
    }

    @Test
    void verifyApartmentMatchesGivenValue() {
        assertEquals("Suite 202", epamAddress.get("Apartment:"));
    }

    @Test
    void verifyCityMatchesGivenValue() {
        assertEquals("Newtown", epamAddress.get("City:"));
    }

    @Test
    void verifyStateMatchesGivenValue() {
        assertEquals("PA", epamAddress.get("State:"));
    }

    @Test
    void verifyPostalCodeMatchesGivenValue() {
        assertEquals("18940", epamAddress.get("Postal Code:"));
    }

    @Test
    void verifyCountryMatchesGivenValue() {
        assertEquals("USA", epamAddress.get("Country:"));
    }
}
