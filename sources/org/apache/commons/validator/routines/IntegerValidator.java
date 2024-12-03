package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class IntegerValidator extends AbstractNumberValidator {
    private static final IntegerValidator VALIDATOR = new IntegerValidator();
    private static final long serialVersionUID = 422081746310306596L;

    public IntegerValidator() {
        this(true, 0);
    }

    public static IntegerValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(int i10, int i11, int i12) {
        return i10 >= i11 && i10 <= i12;
    }

    public boolean isInRange(Integer num, int i10, int i11) {
        return isInRange(num.intValue(), i10, i11);
    }

    public boolean maxValue(int i10, int i11) {
        return i10 <= i11;
    }

    public boolean maxValue(Integer num, int i10) {
        return maxValue(num.intValue(), i10);
    }

    public boolean minValue(int i10, int i11) {
        return i10 >= i11;
    }

    public boolean minValue(Integer num, int i10) {
        return minValue(num.intValue(), i10);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        long longValue = ((Number) obj).longValue();
        if (longValue < -2147483648L || longValue > 2147483647L) {
            return null;
        }
        return new Integer((int) longValue);
    }

    public Integer validate(String str) {
        return (Integer) parse(str, (String) null, (Locale) null);
    }

    public IntegerValidator(boolean z10, int i10) {
        super(z10, i10, false);
    }

    public Integer validate(String str, String str2) {
        return (Integer) parse(str, str2, (Locale) null);
    }

    public Integer validate(String str, Locale locale) {
        return (Integer) parse(str, (String) null, locale);
    }

    public Integer validate(String str, String str2, Locale locale) {
        return (Integer) parse(str, str2, locale);
    }
}
