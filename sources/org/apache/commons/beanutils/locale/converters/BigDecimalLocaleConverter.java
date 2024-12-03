package org.apache.commons.beanutils.locale.converters;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

public class BigDecimalLocaleConverter extends DecimalLocaleConverter {
    public BigDecimalLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof BigDecimal)) {
            return parse;
        }
        try {
            return new BigDecimal(parse.toString());
        } catch (NumberFormatException unused) {
            throw new ConversionException("Suplied number is not of type BigDecimal: " + parse);
        }
    }

    public BigDecimalLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public BigDecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public BigDecimalLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public BigDecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public BigDecimalLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
    }

    public BigDecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public BigDecimalLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
    }
}
