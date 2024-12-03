package org.apache.commons.validator.routines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

public class CreditCardValidator implements Serializable {
    public static final long AMEX = 1;
    public static final CodeValidator AMEX_VALIDATOR;
    public static final long DINERS = 16;
    public static final CodeValidator DINERS_VALIDATOR;
    public static final long DISCOVER = 8;
    private static final RegexValidator DISCOVER_REGEX;
    public static final CodeValidator DISCOVER_VALIDATOR;
    private static final CheckDigit LUHN_VALIDATOR;
    public static final long MASTERCARD = 4;
    public static final CodeValidator MASTERCARD_VALIDATOR;
    public static final long NONE = 0;
    public static final long VISA = 2;
    public static final CodeValidator VISA_VALIDATOR;
    public static final long VPAY = 32;
    public static final CodeValidator VPAY_VALIDATOR;
    private static final long serialVersionUID = 5955978921148959496L;
    private final List<CodeValidator> cardTypes;

    static {
        CheckDigit checkDigit = LuhnCheckDigit.LUHN_CHECK_DIGIT;
        LUHN_VALIDATOR = checkDigit;
        AMEX_VALIDATOR = new CodeValidator("^(3[47]\\d{13})$", checkDigit);
        DINERS_VALIDATOR = new CodeValidator("^(30[0-5]\\d{11}|3095\\d{10}|36\\d{12}|3[8-9]\\d{12})$", checkDigit);
        RegexValidator regexValidator = new RegexValidator(new String[]{"^(6011\\d{12})$", "^(64[4-9]\\d{13})$", "^(65\\d{14})$"});
        DISCOVER_REGEX = regexValidator;
        DISCOVER_VALIDATOR = new CodeValidator(regexValidator, checkDigit);
        MASTERCARD_VALIDATOR = new CodeValidator("^(5[1-5]\\d{14})$", checkDigit);
        VISA_VALIDATOR = new CodeValidator("^(4)(\\d{12}|\\d{15})$", checkDigit);
        VPAY_VALIDATOR = new CodeValidator("^(4)(\\d{12,18})$", checkDigit);
    }

    public CreditCardValidator() {
        this(15);
    }

    private boolean isOn(long j10, long j11) {
        return (j10 & j11) > 0;
    }

    public boolean isValid(String str) {
        if (!(str == null || str.length() == 0)) {
            for (CodeValidator isValid : this.cardTypes) {
                if (isValid.isValid(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object validate(String str) {
        if (!(str == null || str.length() == 0)) {
            for (CodeValidator validate : this.cardTypes) {
                Object validate2 = validate.validate(str);
                if (validate2 != null) {
                    return validate2;
                }
            }
        }
        return null;
    }

    public CreditCardValidator(long j10) {
        ArrayList arrayList = new ArrayList();
        this.cardTypes = arrayList;
        if (isOn(j10, 2)) {
            arrayList.add(VISA_VALIDATOR);
        }
        if (isOn(j10, 32)) {
            arrayList.add(VPAY_VALIDATOR);
        }
        if (isOn(j10, 1)) {
            arrayList.add(AMEX_VALIDATOR);
        }
        if (isOn(j10, 4)) {
            arrayList.add(MASTERCARD_VALIDATOR);
        }
        if (isOn(j10, 8)) {
            arrayList.add(DISCOVER_VALIDATOR);
        }
        if (isOn(j10, 16)) {
            arrayList.add(DINERS_VALIDATOR);
        }
    }

    public CreditCardValidator(CodeValidator[] codeValidatorArr) {
        ArrayList arrayList = new ArrayList();
        this.cardTypes = arrayList;
        if (codeValidatorArr != null) {
            Collections.addAll(arrayList, codeValidatorArr);
            return;
        }
        throw new IllegalArgumentException("Card validators are missing");
    }
}
