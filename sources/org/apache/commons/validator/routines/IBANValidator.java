package org.apache.commons.validator.routines;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

public class IBANValidator {
    private static final Validator[] DEFAULT_FORMATS = {new Validator("AL", 28, "AL\\d{10}[A-Z0-9]{16}"), new Validator("AD", 24, "AD\\d{10}[A-Z0-9]{12}"), new Validator("AT", 20, "AT\\d{18}"), new Validator("AZ", 28, "AZ\\d{2}[A-Z]{4}[A-Z0-9]{20}"), new Validator("BH", 22, "BH\\d{2}[A-Z]{4}[A-Z0-9]{14}"), new Validator("BE", 16, "BE\\d{14}"), new Validator("BA", 20, "BA\\d{18}"), new Validator("BR", 29, "BR\\d{25}[A-Z]{1}[A-Z0-9]{1}"), new Validator("BG", 22, "BG\\d{2}[A-Z]{4}\\d{6}[A-Z0-9]{8}"), new Validator("CR", 21, "CR\\d{19}"), new Validator("HR", 21, "HR\\d{19}"), new Validator("CY", 28, "CY\\d{10}[A-Z0-9]{16}"), new Validator("CZ", 24, "CZ\\d{22}"), new Validator("DK", 18, "DK\\d{16}"), new Validator("FO", 18, "FO\\d{16}"), new Validator("GL", 18, "GL\\d{16}"), new Validator("DO", 28, "DO\\d{2}[A-Z0-9]{4}\\d{20}"), new Validator("EE", 20, "EE\\d{18}"), new Validator("FI", 18, "FI\\d{16}"), new Validator("FR", 27, "FR\\d{12}[A-Z0-9]{11}\\d{2}"), new Validator("GE", 22, "GE\\d{2}[A-Z]{2}\\d{16}"), new Validator("DE", 22, "DE\\d{20}"), new Validator("GI", 23, "GI\\d{2}[A-Z]{4}[A-Z0-9]{15}"), new Validator("GR", 27, "GR\\d{9}[A-Z0-9]{16}"), new Validator("GT", 28, "GT\\d{2}[A-Z0-9]{24}"), new Validator("HU", 28, "HU\\d{26}"), new Validator("IS", 26, "IS\\d{24}"), new Validator("IE", 22, "IE\\d{2}[A-Z]{4}\\d{14}"), new Validator("IL", 23, "IL\\d{21}"), new Validator("IT", 27, "IT\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}"), new Validator("JO", 30, "JO\\d{2}[A-Z]{4}\\d{4}[A-Z0-9]{18}"), new Validator("KZ", 20, "KZ\\d{5}[A-Z0-9]{13}"), new Validator("XK", 20, "XK\\d{18}"), new Validator("KW", 30, "KW\\d{2}[A-Z]{4}[A-Z0-9]{22}"), new Validator("LV", 21, "LV\\d{2}[A-Z]{4}[A-Z0-9]{13}"), new Validator("LB", 28, "LB\\d{6}[A-Z0-9]{20}"), new Validator("LI", 21, "LI\\d{7}[A-Z0-9]{12}"), new Validator("LT", 20, "LT\\d{18}"), new Validator("LU", 20, "LU\\d{5}[A-Z0-9]{13}"), new Validator("MK", 19, "MK\\d{5}[A-Z0-9]{10}\\d{2}"), new Validator("MT", 31, "MT\\d{2}[A-Z]{4}\\d{5}[A-Z0-9]{18}"), new Validator("MR", 27, "MR13\\d{23}"), new Validator("MU", 30, "MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}"), new Validator("MD", 24, "MD\\d{2}[A-Z0-9]{20}"), new Validator("MC", 27, "MC\\d{12}[A-Z0-9]{11}\\d{2}"), new Validator("ME", 22, "ME\\d{20}"), new Validator("NL", 18, "NL\\d{2}[A-Z]{4}\\d{10}"), new Validator("NO", 15, "NO\\d{13}"), new Validator("PK", 24, "PK\\d{2}[A-Z]{4}[A-Z0-9]{16}"), new Validator("PS", 29, "PS\\d{2}[A-Z]{4}[A-Z0-9]{21}"), new Validator("PL", 28, "PL\\d{26}"), new Validator("PT", 25, "PT\\d{23}"), new Validator("QA", 29, "QA\\d{2}[A-Z]{4}[A-Z0-9]{21}"), new Validator("RO", 24, "RO\\d{2}[A-Z]{4}[A-Z0-9]{16}"), new Validator("LC", 32, "LC\\d{2}[A-Z]{4}\\d{24}"), new Validator("SM", 27, "SM\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}"), new Validator("ST", 25, "ST\\d{23}"), new Validator("SA", 24, "SA\\d{4}[A-Z0-9]{18}"), new Validator("RS", 22, "RS\\d{20}"), new Validator("SK", 24, "SK\\d{22}"), new Validator("SI", 19, "SI\\d{17}"), new Validator("ES", 24, "ES\\d{22}"), new Validator("SE", 24, "SE\\d{22}"), new Validator("CH", 21, "CH\\d{7}[A-Z0-9]{12}"), new Validator("TL", 23, "TL\\d{21}"), new Validator("TN", 24, "TN59\\d{20}"), new Validator("TR", 26, "TR\\d{8}[A-Z0-9]{16}"), new Validator("AE", 23, "AE\\d{21}"), new Validator("GB", 22, "GB\\d{2}[A-Z]{4}\\d{14}"), new Validator("VG", 24, "VG\\d{2}[A-Z]{4}\\d{16}")};
    public static final IBANValidator DEFAULT_IBAN_VALIDATOR = new IBANValidator();
    private final Map<String, Validator> formatValidators;

    public static class Validator {
        private static final int MAX_LEN = 34;
        private static final int MIN_LEN = 8;
        final String countryCode;
        final int lengthOfIBAN;
        final RegexValidator validator;

        public Validator(String str, int i10, String str2) {
            if (str.length() != 2 || !Character.isUpperCase(str.charAt(0)) || !Character.isUpperCase(str.charAt(1))) {
                throw new IllegalArgumentException("Invalid country Code; must be exactly 2 upper-case characters");
            } else if (i10 > 34 || i10 < 8) {
                throw new IllegalArgumentException("Invalid length parameter, must be in range 8 to 34 inclusive: " + i10);
            } else if (str2.startsWith(str)) {
                this.countryCode = str;
                this.lengthOfIBAN = i10;
                this.validator = new RegexValidator(str2);
            } else {
                throw new IllegalArgumentException("countryCode '" + str + "' does not agree with format: " + str2);
            }
        }
    }

    public IBANValidator() {
        this(DEFAULT_FORMATS);
    }

    private Map<String, Validator> createValidators(Validator[] validatorArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Validator validator : validatorArr) {
            concurrentHashMap.put(validator.countryCode, validator);
        }
        return concurrentHashMap;
    }

    public static IBANValidator getInstance() {
        return DEFAULT_IBAN_VALIDATOR;
    }

    public Validator[] getDefaultValidators() {
        Validator[] validatorArr = DEFAULT_FORMATS;
        return (Validator[]) Arrays.copyOf(validatorArr, validatorArr.length);
    }

    public Validator getValidator(String str) {
        if (str == null || str.length() < 2) {
            return null;
        }
        return this.formatValidators.get(str.substring(0, 2));
    }

    public boolean hasValidator(String str) {
        return getValidator(str) != null;
    }

    public boolean isValid(String str) {
        Validator validator = getValidator(str);
        if (validator == null || str.length() != validator.lengthOfIBAN || !validator.validator.isValid(str)) {
            return false;
        }
        return IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(str);
    }

    public Validator setValidator(Validator validator) {
        if (this != DEFAULT_IBAN_VALIDATOR) {
            return this.formatValidators.put(validator.countryCode, validator);
        }
        throw new IllegalStateException("The singleton validator cannot be modified");
    }

    public IBANValidator(Validator[] validatorArr) {
        this.formatValidators = createValidators(validatorArr);
    }

    public Validator setValidator(String str, int i10, String str2) {
        if (this == DEFAULT_IBAN_VALIDATOR) {
            throw new IllegalStateException("The singleton validator cannot be modified");
        } else if (i10 < 0) {
            return this.formatValidators.remove(str);
        } else {
            return setValidator(new Validator(str, i10, str2));
        }
    }
}
