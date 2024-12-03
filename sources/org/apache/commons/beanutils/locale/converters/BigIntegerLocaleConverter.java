package org.apache.commons.beanutils.locale.converters;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class BigIntegerLocaleConverter extends DecimalLocaleConverter {
    public BigIntegerLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof BigInteger)) {
            return parse;
        }
        if (parse instanceof Number) {
            return BigInteger.valueOf(((Number) parse).longValue());
        }
        try {
            return new BigInteger(parse.toString());
        } catch (NumberFormatException unused) {
            throw new ConversionException("Suplied number is not of type BigInteger: " + parse);
        }
    }

    public BigIntegerLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public BigIntegerLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public BigIntegerLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public BigIntegerLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public BigIntegerLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public BigIntegerLocaleConverter(Object obj) {
        this(obj, false);
    }

    public BigIntegerLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public BigIntegerLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public BigIntegerLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public BigIntegerLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public BigIntegerLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
