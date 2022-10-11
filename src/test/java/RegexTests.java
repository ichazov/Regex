import regex.RegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTests {
    String emailAddress = "Rnrlla1994@gmail.com";
    String ipAddress = "192.168.31.1";
    String creditCardNumber = "1111222233334444";

    @Test
    void verifyEmailAddressPatternMatchesRegex() {
        assertTrue(RegexMatcher.stringRegexMatcher(emailAddress, RegexMatcher.EMAIL_REGEX));
    }

    @Test
    void verifyEmailAddressPatternDoesNotMatchRegex() {
        assertFalse(RegexMatcher.stringRegexMatcher(emailAddress.replace('@', '$'), RegexMatcher.EMAIL_REGEX));
    }

    @Test
    void verifyIpPatternMatchesRegex() {
        assertTrue(RegexMatcher.stringRegexMatcher(ipAddress, RegexMatcher.IP_REGEX));
    }

    @Test
    void verifyIpPatternDoesNotMatchRegex() {
        assertFalse(RegexMatcher.stringRegexMatcher(ipAddress.replaceFirst(".{4}$", ""), RegexMatcher.IP_REGEX));
    }

    @Test
    void verifyCreditCardPatternMatchesRegex() {
        assertTrue(RegexMatcher.stringRegexMatcher(creditCardNumber, RegexMatcher.CREDIT_CARD_REGEX));
    }

    @Test
    void verifyWhitespaceDelimitedCreditCardPatternMatchesRegex() {
        assertTrue(RegexMatcher
                .stringRegexMatcher(RegexMatcher
                        .creditCardNumberDelimiter(creditCardNumber, ' '), RegexMatcher.CREDIT_CARD_REGEX));
    }

    @Test
    void verifyDashDelimitedCreditCardPatternMatchesRegex() {
        assertTrue(RegexMatcher
                .stringRegexMatcher(RegexMatcher
                        .creditCardNumberDelimiter(creditCardNumber, '-'), RegexMatcher.CREDIT_CARD_REGEX));
    }

    @Test
    void verifyCreditCardPatternDoesNotMatchRegex() {
        assertFalse(RegexMatcher.stringRegexMatcher("UA" + creditCardNumber, RegexMatcher.CREDIT_CARD_REGEX));
    }

    @Test
    void verifyPeriodDelimitedCreditCardPatternDoesNotMatchRegex() {
        assertFalse(RegexMatcher
                .stringRegexMatcher(RegexMatcher
                        .creditCardNumberDelimiter(creditCardNumber, '.'), RegexMatcher.CREDIT_CARD_REGEX));
    }
}
