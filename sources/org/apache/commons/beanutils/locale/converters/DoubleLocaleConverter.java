package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;

public class DoubleLocaleConverter extends DecimalLocaleConverter {
    public DoubleLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        if (number instanceof Long) {
            return new Double(number.doubleValue());
        }
        return number;
    }

    public DoubleLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public DoubleLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DoubleLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public DoubleLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DoubleLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public DoubleLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DoubleLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public DoubleLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
