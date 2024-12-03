package org.apache.commons.validator.routines;

import java.math.BigDecimal;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalValidator extends AbstractNumberValidator {
    private static final BigDecimalValidator VALIDATOR = new BigDecimalValidator();
    private static final long serialVersionUID = -670320911490506772L;

    public BigDecimalValidator() {
        this(true);
    }

    public static BigDecimalValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(BigDecimal bigDecimal, double d10, double d11) {
        return bigDecimal.doubleValue() >= d10 && bigDecimal.doubleValue() <= d11;
    }

    public boolean maxValue(BigDecimal bigDecimal, double d10) {
        return bigDecimal.doubleValue() <= d10;
    }

    public boolean minValue(BigDecimal bigDecimal, double d10) {
        return bigDecimal.doubleValue() >= d10;
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        BigDecimal bigDecimal;
        if (obj instanceof Long) {
            bigDecimal = BigDecimal.valueOf(((Long) obj).longValue());
        } else {
            bigDecimal = new BigDecimal(obj.toString());
        }
        int determineScale = determineScale((NumberFormat) format2);
        if (determineScale >= 0) {
            return bigDecimal.setScale(determineScale, 1);
        }
        return bigDecimal;
    }

    public BigDecimal validate(String str) {
        return (BigDecimal) parse(str, (String) null, (Locale) null);
    }

    public BigDecimalValidator(boolean z10) {
        this(z10, 0, true);
    }

    public BigDecimal validate(String str, String str2) {
        return (BigDecimal) parse(str, str2, (Locale) null);
    }

    protected BigDecimalValidator(boolean z10, int i10, boolean z11) {
        super(z10, i10, z11);
    }

    public BigDecimal validate(String str, Locale locale) {
        return (BigDecimal) parse(str, (String) null, locale);
    }

    public BigDecimal validate(String str, String str2, Locale locale) {
        return (BigDecimal) parse(str, str2, locale);
    }
}
