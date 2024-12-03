package h5;

import org.apache.commons.validator.routines.EmailValidator;

public class h {
    public static boolean a(String str) {
        return EmailValidator.getInstance().isValid(str);
    }
}
