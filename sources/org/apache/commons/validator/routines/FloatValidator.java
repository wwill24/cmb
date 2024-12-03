package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class FloatValidator extends AbstractNumberValidator {
    private static final FloatValidator VALIDATOR = new FloatValidator();
    private static final long serialVersionUID = -4513245432806414267L;

    public FloatValidator() {
        this(true, 0);
    }

    public static FloatValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    public boolean isInRange(Float f10, float f11, float f12) {
        return isInRange(f10.floatValue(), f11, f12);
    }

    public boolean maxValue(float f10, float f11) {
        return f10 <= f11;
    }

    public boolean maxValue(Float f10, float f11) {
        return maxValue(f10.floatValue(), f11);
    }

    public boolean minValue(float f10, float f11) {
        return f10 >= f11;
    }

    public boolean minValue(Float f10, float f11) {
        return minValue(f10.floatValue(), f11);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        double doubleValue = ((Number) obj).doubleValue();
        if (doubleValue > 0.0d) {
            if (doubleValue < 1.401298464324817E-45d || doubleValue > 3.4028234663852886E38d) {
                return null;
            }
        } else if (doubleValue < 0.0d) {
            double d10 = -1.0d * doubleValue;
            if (d10 < 1.401298464324817E-45d || d10 > 3.4028234663852886E38d) {
                return null;
            }
        }
        return new Float((float) doubleValue);
    }

    public Float validate(String str) {
        return (Float) parse(str, (String) null, (Locale) null);
    }

    public FloatValidator(boolean z10, int i10) {
        super(z10, i10, true);
    }

    public Float validate(String str, String str2) {
        return (Float) parse(str, str2, (Locale) null);
    }

    public Float validate(String str, Locale locale) {
        return (Float) parse(str, (String) null, locale);
    }

    public Float validate(String str, String str2, Locale locale) {
        return (Float) parse(str, str2, locale);
    }
}
