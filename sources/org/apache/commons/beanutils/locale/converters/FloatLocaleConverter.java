package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class FloatLocaleConverter extends DecimalLocaleConverter {
    public FloatLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        double doubleValue = number.doubleValue();
        if (doubleValue < 0.0d) {
            doubleValue *= -1.0d;
        }
        if (doubleValue == 0.0d || (doubleValue >= 1.401298464324817E-45d && doubleValue <= 3.4028234663852886E38d)) {
            return new Float(number.floatValue());
        }
        throw new ConversionException("Supplied number is not of type Float: " + number);
    }

    public FloatLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public FloatLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public FloatLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public FloatLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public FloatLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public FloatLocaleConverter(Object obj) {
        this(obj, false);
    }

    public FloatLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public FloatLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public FloatLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public FloatLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public FloatLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
