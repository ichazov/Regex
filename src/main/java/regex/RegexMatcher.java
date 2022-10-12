package regex;

public class RegexMatcher {
    public static final String CREDIT_CARD_REGEX = "^(\\d{4}-??){4}$|^(\\d{4} ??){4}$|^(\\d{16})$";
    public static final String IP_REGEX = "^(\\d{3}\\.){2}(\\d{1,3}\\.*?){2}$";
    public static final String EMAIL_REGEX = "^[\\w.]+@[a-z]+\\.[a-z]{3}$";

    private RegexMatcher() {
        throw new IllegalStateException("Utility class");
    }
    public static boolean stringRegexMatcher(String input, String regex) {
        return input.matches(regex);
    }
    public static String creditCardNumberDelimiter(String creditCardNumber, char delimiter) {
        return creditCardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
    }
}
