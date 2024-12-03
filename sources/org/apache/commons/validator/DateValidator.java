package org.apache.commons.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateValidator {
    private static final DateValidator DATE_VALIDATOR = new DateValidator();

    protected DateValidator() {
    }

    public static DateValidator getInstance() {
        return DATE_VALIDATOR;
    }

    public boolean isValid(String str, String str2, boolean z10) {
        if (!(str == null || str2 == null || str2.length() <= 0)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            simpleDateFormat.setLenient(false);
            try {
                simpleDateFormat.parse(str);
                if (!z10 || str2.length() == str.length()) {
                    return true;
                }
                return false;
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    public boolean isValid(String str, Locale locale) {
        DateFormat dateFormat;
        if (str == null) {
            return false;
        }
        if (locale != null) {
            dateFormat = DateFormat.getDateInstance(3, locale);
        } else {
            dateFormat = DateFormat.getDateInstance(3, Locale.getDefault());
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(str);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }
}
