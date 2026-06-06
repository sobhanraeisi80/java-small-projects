package ir.ac.kntu.lms;


import java.time.Year;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-_+\\.]+@([\\w-]+\\.)+[\\w-]{2,8}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("(?:\\+98|0|98)\\d{9}");
    private static final Pattern ISBN_PATTERN = Pattern.compile("(?:978|979)\\d{10}");
    private static final Pattern ISSN_PATTERN = Pattern.compile("\\d{4}-\\d{3}[X0-9]$");
    private static final Pattern MEMBER_ID_PATTERN = Pattern.compile("(?:GST|STU|FAC)-\\d{6}");
    private static final Pattern ITEM_ID_PATTERN = Pattern.compile("(?:BOK|EBK|MAG|AUD)-\\d{8}");
    private static final Pattern PUBLISH_YEAR_PATTERN = Pattern.compile("\\d{4}");
    private static final Pattern DOWNLOAD_URL_PATTERN = Pattern.compile("^https:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]+\\.[a-zA-Z0-9()]+\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    public static boolean isEmailValid(String email) {
        if (email == null) {return false;}

        return EMAIL_PATTERN.matcher(email).matches();
    } 

    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null) {return false;}

        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    public static boolean isIsbnValid(String ISBN) {
        if (ISBN == null){return false;}
        
        return ISBN_PATTERN.matcher(ISBN).matches();
    }

    public static boolean isIssnValid(String ISSN) {
        if (ISSN == null){return false;}
        
        return ISSN_PATTERN.matcher(ISSN).matches();
    }

    public static boolean isMemberIdValid(String id) {
        if (id == null) {return false;}

        return MEMBER_ID_PATTERN.matcher(id).matches();
    }

    public static boolean isItemIdValid(String itemId) {
        if (itemId == null) {return false;}

        return ITEM_ID_PATTERN.matcher(itemId).matches();
    }

    public static boolean isPublishYearValid(String year) {
        if (year == null) {return false;}
        
        boolean isValid = PUBLISH_YEAR_PATTERN.matcher(year).matches() && // check is year has 4 digits or not
                          Integer.parseInt(year) <= Year.now().getValue() && // check is year smaller equals current year
                          1450 <= Integer.parseInt(year); // check is year bigger equals 1450
        return isValid;
    }

    public static boolean isUrlValid(String url) {
        if (url == null) {return false;}

        return DOWNLOAD_URL_PATTERN.matcher(url).matches();
    }

    public static boolean isPasswordValid(String password) {
        if (password == null) {return false;}

        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
