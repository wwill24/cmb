package org.apache.commons.validator.routines;

import java.io.Serializable;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.EAN13CheckDigit;
import org.apache.commons.validator.routines.checkdigit.ISSNCheckDigit;

public class ISSNValidator implements Serializable {
    private static final String ISSN_REGEX = "(?:ISSN )?(\\d{4})-(\\d{3}[0-9X])$";
    private static final ISSNValidator ISSN_VALIDATOR = new ISSNValidator();
    private static final CodeValidator issnValidator = new CodeValidator(ISSN_REGEX, 8, ISSNCheckDigit.ISSN_CHECK_DIGIT);
    private static final long serialVersionUID = 4319515687976420405L;

    public static ISSNValidator getInstance() {
        return ISSN_VALIDATOR;
    }

    public String convertToEAN13(String str, String str2) {
        if (str2 == null || !str2.matches("\\d\\d")) {
            throw new IllegalArgumentException("Suffix must be two digits: '" + str2 + "'");
        }
        Object validate = validate(str);
        if (validate == null) {
            return null;
        }
        String obj = validate.toString();
        String str3 = "977" + obj.substring(0, obj.length() - 1) + str2;
        try {
            return str3 + EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(str3);
        } catch (CheckDigitException e10) {
            throw new IllegalArgumentException("Check digit error for '" + str3 + "' - " + e10.getMessage());
        }
    }

    public boolean isValid(String str) {
        return issnValidator.isValid(str);
    }

    public Object validate(String str) {
        return issnValidator.validate(str);
    }
}
