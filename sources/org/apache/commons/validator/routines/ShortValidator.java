package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class ShortValidator extends AbstractNumberValidator {
    private static final ShortValidator VALIDATOR = new ShortValidator();
    private static final long serialVersionUID = -5227510699747787066L;

    public ShortValidator() {
        this(true, 0);
    }

    public static ShortValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(Short sh2, short s10, short s11) {
        return isInRange(sh2.shortValue(), s10, s11);
    }

    public boolean isInRange(short s10, short s11, short s12) {
        return s10 >= s11 && s10 <= s12;
    }

    public boolean maxValue(Short sh2, short s10) {
        return maxValue(sh2.shortValue(), s10);
    }

    public boolean maxValue(short s10, short s11) {
        return s10 <= s11;
    }

    public boolean minValue(Short sh2, short s10) {
        return minValue(sh2.shortValue(), s10);
    }

    public boolean minValue(short s10, short s11) {
        return s10 >= s11;
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        long longValue = ((Number) obj).longValue();
        if (longValue < -32768 || longValue > 32767) {
            return null;
        }
        return new Short((short) ((int) longValue));
    }

    public Short validate(String str) {
        return (Short) parse(str, (String) null, (Locale) null);
    }

    public ShortValidator(boolean z10, int i10) {
        super(z10, i10, false);
    }

    public Short validate(String str, String str2) {
        return (Short) parse(str, str2, (Locale) null);
    }

    public Short validate(String str, Locale locale) {
        return (Short) parse(str, (String) null, locale);
    }

    public Short validate(String str, String str2, Locale locale) {
        return (Short) parse(str, str2, locale);
    }
}
