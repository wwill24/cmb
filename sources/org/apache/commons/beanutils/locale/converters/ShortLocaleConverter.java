package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class ShortLocaleConverter extends DecimalLocaleConverter {
    public ShortLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof Short)) {
            return parse;
        }
        Number number = (Number) parse;
        if (number.longValue() == ((long) number.shortValue())) {
            return new Short(number.shortValue());
        }
        throw new ConversionException("Supplied number is not of type Short: " + number.longValue());
    }

    public ShortLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public ShortLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public ShortLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public ShortLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public ShortLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public ShortLocaleConverter(Object obj) {
        this(obj, false);
    }

    public ShortLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public ShortLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
