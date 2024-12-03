package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class IntegerLocaleConverter extends DecimalLocaleConverter {
    public IntegerLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        if (number.longValue() == ((long) number.intValue())) {
            return new Integer(number.intValue());
        }
        throw new ConversionException("Suplied number is not of type Integer: " + number.longValue());
    }

    public IntegerLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public IntegerLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public IntegerLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public IntegerLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public IntegerLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public IntegerLocaleConverter(Object obj) {
        this(obj, false);
    }

    public IntegerLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public IntegerLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
