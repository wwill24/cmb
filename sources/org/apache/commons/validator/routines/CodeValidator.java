package org.apache.commons.validator.routines;

import java.io.Serializable;
import org.apache.commons.validator.routines.checkdigit.CheckDigit;

public final class CodeValidator implements Serializable {
    private static final long serialVersionUID = 446960910870938233L;
    private final CheckDigit checkdigit;
    private final int maxLength;
    private final int minLength;
    private final RegexValidator regexValidator;

    public CodeValidator(String str, CheckDigit checkDigit) {
        this(str, -1, -1, checkDigit);
    }

    public CheckDigit getCheckDigit() {
        return this.checkdigit;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public RegexValidator getRegexValidator() {
        return this.regexValidator;
    }

    public boolean isValid(String str) {
        return validate(str) != null;
    }

    public Object validate(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        RegexValidator regexValidator2 = this.regexValidator;
        if (regexValidator2 != null && (trim = regexValidator2.validate(trim)) == null) {
            return null;
        }
        if ((this.minLength >= 0 && trim.length() < this.minLength) || (this.maxLength >= 0 && trim.length() > this.maxLength)) {
            return null;
        }
        CheckDigit checkDigit = this.checkdigit;
        if (checkDigit == null || checkDigit.isValid(trim)) {
            return trim;
        }
        return null;
    }

    public CodeValidator(String str, int i10, CheckDigit checkDigit) {
        this(str, i10, i10, checkDigit);
    }

    public CodeValidator(String str, int i10, int i11, CheckDigit checkDigit) {
        if (str == null || str.length() <= 0) {
            this.regexValidator = null;
        } else {
            this.regexValidator = new RegexValidator(str);
        }
        this.minLength = i10;
        this.maxLength = i11;
        this.checkdigit = checkDigit;
    }

    public CodeValidator(RegexValidator regexValidator2, CheckDigit checkDigit) {
        this(regexValidator2, -1, -1, checkDigit);
    }

    public CodeValidator(RegexValidator regexValidator2, int i10, CheckDigit checkDigit) {
        this(regexValidator2, i10, i10, checkDigit);
    }

    public CodeValidator(RegexValidator regexValidator2, int i10, int i11, CheckDigit checkDigit) {
        this.regexValidator = regexValidator2;
        this.minLength = i10;
        this.maxLength = i11;
        this.checkdigit = checkDigit;
    }
}
