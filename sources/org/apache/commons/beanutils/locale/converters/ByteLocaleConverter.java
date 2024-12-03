package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class ByteLocaleConverter extends DecimalLocaleConverter {
    public ByteLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        if (number.longValue() == ((long) number.byteValue())) {
            return new Byte(number.byteValue());
        }
        throw new ConversionException("Supplied number is not of type Byte: " + number.longValue());
    }

    public ByteLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public ByteLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public ByteLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public ByteLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public ByteLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public ByteLocaleConverter(Object obj) {
        this(obj, false);
    }

    public ByteLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public ByteLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public ByteLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public ByteLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public ByteLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
