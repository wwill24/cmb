package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class ByteValidator extends AbstractNumberValidator {
    private static final ByteValidator VALIDATOR = new ByteValidator();
    private static final long serialVersionUID = 7001640945881854649L;

    public ByteValidator() {
        this(true, 0);
    }

    public static ByteValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(byte b10, byte b11, byte b12) {
        return b10 >= b11 && b10 <= b12;
    }

    public boolean isInRange(Byte b10, byte b11, byte b12) {
        return isInRange(b10.byteValue(), b11, b12);
    }

    public boolean maxValue(byte b10, byte b11) {
        return b10 <= b11;
    }

    public boolean maxValue(Byte b10, byte b11) {
        return maxValue(b10.byteValue(), b11);
    }

    public boolean minValue(byte b10, byte b11) {
        return b10 >= b11;
    }

    public boolean minValue(Byte b10, byte b11) {
        return minValue(b10.byteValue(), b11);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        long longValue = ((Number) obj).longValue();
        if (longValue < -128 || longValue > 127) {
            return null;
        }
        return new Byte((byte) ((int) longValue));
    }

    public Byte validate(String str) {
        return (Byte) parse(str, (String) null, (Locale) null);
    }

    public ByteValidator(boolean z10, int i10) {
        super(z10, i10, false);
    }

    public Byte validate(String str, String str2) {
        return (Byte) parse(str, str2, (Locale) null);
    }

    public Byte validate(String str, Locale locale) {
        return (Byte) parse(str, (String) null, locale);
    }

    public Byte validate(String str, String str2, Locale locale) {
        return (Byte) parse(str, str2, locale);
    }
}
