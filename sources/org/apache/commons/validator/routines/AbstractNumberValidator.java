package org.apache.commons.validator.routines;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class AbstractNumberValidator extends AbstractFormatValidator {
    public static final int CURRENCY_FORMAT = 1;
    public static final int PERCENT_FORMAT = 2;
    public static final int STANDARD_FORMAT = 0;
    private static final long serialVersionUID = -3088817875906765463L;
    private final boolean allowFractions;
    private final int formatType;

    public AbstractNumberValidator(boolean z10, int i10, boolean z11) {
        super(z10);
        this.allowFractions = z11;
        this.formatType = i10;
    }

    /* access modifiers changed from: protected */
    public int determineScale(NumberFormat numberFormat) {
        if (!isStrict()) {
            return -1;
        }
        if (!isAllowFractions() || numberFormat.isParseIntegerOnly()) {
            return 0;
        }
        int minimumFractionDigits = numberFormat.getMinimumFractionDigits();
        if (minimumFractionDigits != numberFormat.getMaximumFractionDigits()) {
            return -1;
        }
        if (numberFormat instanceof DecimalFormat) {
            int multiplier = ((DecimalFormat) numberFormat).getMultiplier();
            if (multiplier != 100) {
                if (multiplier == 1000) {
                    return minimumFractionDigits + 3;
                }
                return minimumFractionDigits;
            }
        } else if (this.formatType != 2) {
            return minimumFractionDigits;
        }
        return minimumFractionDigits + 2;
    }

    /* access modifiers changed from: protected */
    public Format getFormat(String str, Locale locale) {
        NumberFormat numberFormat;
        DecimalFormat decimalFormat;
        if (!(str != null && str.length() > 0)) {
            numberFormat = (NumberFormat) getFormat(locale);
        } else {
            if (locale == null) {
                decimalFormat = new DecimalFormat(str);
            } else {
                decimalFormat = new DecimalFormat(str, new DecimalFormatSymbols(locale));
            }
            numberFormat = decimalFormat;
        }
        if (determineScale(numberFormat) == 0) {
            numberFormat.setParseIntegerOnly(true);
        }
        return numberFormat;
    }

    public int getFormatType() {
        return this.formatType;
    }

    public boolean isAllowFractions() {
        return this.allowFractions;
    }

    public boolean isInRange(Number number, Number number2, Number number3) {
        return minValue(number, number2) && maxValue(number, number3);
    }

    public boolean isValid(String str, String str2, Locale locale) {
        return parse(str, str2, locale) != null;
    }

    public boolean maxValue(Number number, Number number2) {
        if (isAllowFractions()) {
            if (number.doubleValue() <= number2.doubleValue()) {
                return true;
            }
            return false;
        } else if (number.longValue() <= number2.longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean minValue(Number number, Number number2) {
        if (isAllowFractions()) {
            if (number.doubleValue() >= number2.doubleValue()) {
                return true;
            }
            return false;
        } else if (number.longValue() >= number2.longValue()) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Object parse(String str, String str2, Locale locale) {
        String str3;
        if (str == null) {
            str3 = null;
        } else {
            str3 = str.trim();
        }
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        return parse(str3, getFormat(str2, locale));
    }

    /* access modifiers changed from: protected */
    public abstract Object processParsedValue(Object obj, Format format2);

    /* access modifiers changed from: protected */
    public Format getFormat(Locale locale) {
        int i10 = this.formatType;
        if (i10 != 1) {
            if (i10 != 2) {
                if (locale == null) {
                    return NumberFormat.getInstance();
                }
                return NumberFormat.getInstance(locale);
            } else if (locale == null) {
                return NumberFormat.getPercentInstance();
            } else {
                return NumberFormat.getPercentInstance(locale);
            }
        } else if (locale == null) {
            return NumberFormat.getCurrencyInstance();
        } else {
            return NumberFormat.getCurrencyInstance(locale);
        }
    }
}
