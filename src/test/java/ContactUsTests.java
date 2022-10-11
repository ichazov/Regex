import org.junit.jupiter.api.Test;
import pages.ContactUsPage;


import static org.junit.jupiter.api.Assertions.*;

class ContactUsTests extends BaseTest{

    ContactUsPage contactUsPage = new ContactUsPage(chromeDriver);

    @Test
    void verifyAddressMatchesRegex() {
        ContactUsPage.getAddress();
        assertTrue(ContactUsPage
                .getAddressString()
                .matches(ContactUsPage.ADDRESS_REGEX));
    }

    @Test
    void verifyStreetMatchesGivenValue() {
        assertEquals("41 University Drive", ContactUsPage.getAddress().get("Street:"));
    }

    @Test
    void verifyApartmentMatchesGivenValue() {
        assertEquals("Suite 202", ContactUsPage.getAddress().get("Apartment:"));
    }

    @Test
    void verifyCityMatchesGivenValue() {
        assertEquals("Newtown", ContactUsPage.getAddress().get("City:"));
    }

    @Test
    void verifyStateMatchesGivenValue() {
        assertEquals("PA", ContactUsPage.getAddress().get("State:"));
    }

    @Test
    void verifyPostalCodeMatchesGivenValue() {
        assertEquals("18940", ContactUsPage.getAddress().get("Postal Code:"));
    }

    @Test
    void verifyCountryMatchesGivenValue() {
        assertEquals("USA", ContactUsPage.getAddress().get("Country:"));
    }
}
