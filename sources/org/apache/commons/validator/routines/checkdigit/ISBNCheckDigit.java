package org.apache.commons.validator.routines.checkdigit;

import java.io.Serializable;

public final class ISBNCheckDigit implements CheckDigit, Serializable {
    public static final CheckDigit ISBN10_CHECK_DIGIT = ISBN10CheckDigit.ISBN10_CHECK_DIGIT;
    public static final CheckDigit ISBN13_CHECK_DIGIT = EAN13CheckDigit.EAN13_CHECK_DIGIT;
    public static final CheckDigit ISBN_CHECK_DIGIT = new ISBNCheckDigit();
    private static final long serialVersionUID = 1391849166205184558L;

    public String calculate(String str) throws CheckDigitException {
        if (str == null || str.length() == 0) {
            throw new CheckDigitException("ISBN Code is missing");
        } else if (str.length() == 9) {
            return ISBN10_CHECK_DIGIT.calculate(str);
        } else {
            if (str.length() == 12) {
                return ISBN13_CHECK_DIGIT.calculate(str);
            }
            throw new CheckDigitException("Invalid ISBN Length = " + str.length());
        }
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 10) {
            return ISBN10_CHECK_DIGIT.isValid(str);
        }
        if (str.length() == 13) {
            return ISBN13_CHECK_DIGIT.isValid(str);
        }
        return false;
    }
}
