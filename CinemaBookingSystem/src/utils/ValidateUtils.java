package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String PHONENUMBER_REGEX = "((84|0)[3|5|7|8|9])+([0-9]{8})\\b";
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

    public static boolean isPhoneNumber(String number) {
        return Pattern.matches(PHONENUMBER_REGEX, number);
    }
    public static boolean isUserName(String username){
        return Pattern.matches(USERNAME_REGEX,username);
    }
}
