package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Locale;

public class DoubleValidator extends AbstractNumberValidator {
    private static final DoubleValidator VALIDATOR = new DoubleValidator();
    private static final long serialVersionUID = 5867946581318211330L;

    public DoubleValidator() {
        this(true, 0);
    }

    public static DoubleValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(double d10, double d11, double d12) {
        return d10 >= d11 && d10 <= d12;
    }

    public boolean isInRange(Double d10, double d11, double d12) {
        return isInRange(d10.doubleValue(), d11, d12);
    }

    public boolean maxValue(double d10, double d11) {
        return d10 <= d11;
    }

    public boolean maxValue(Double d10, double d11) {
        return maxValue(d10.doubleValue(), d11);
    }

    public boolean minValue(double d10, double d11) {
        return d10 >= d11;
    }

    public boolean minValue(Double d10, double d11) {
        return minValue(d10.doubleValue(), d11);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        if (obj instanceof Double) {
            return obj;
        }
        return new Double(((Number) obj).doubleValue());
    }

    public Double validate(String str) {
        return (Double) parse(str, (String) null, (Locale) null);
    }

    public DoubleValidator(boolean z10, int i10) {
        super(z10, i10, true);
    }

    public Double validate(String str, String str2) {
        return (Double) parse(str, str2, (Locale) null);
    }

    public Double validate(String str, Locale locale) {
        return (Double) parse(str, (String) null, locale);
    }

    public Double validate(String str, String str2, Locale locale) {
        return (Double) parse(str, str2, locale);
    }
}
