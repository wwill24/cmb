package org.apache.commons.beanutils.locale.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringLocaleConverter extends BaseLocaleConverter {
    private final Log log;

    public StringLocaleConverter() {
        this(false);
    }

    private DecimalFormat getDecimalFormat(Locale locale, String str) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        if (str == null) {
            this.log.debug("No pattern provided, using default.");
        } else if (this.locPattern) {
            decimalFormat.applyLocalizedPattern(str);
        } else {
            decimalFormat.applyPattern(str);
        }
        return decimalFormat;
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger) || (obj instanceof Byte) || (obj instanceof Short)) {
            return getDecimalFormat(this.locale, str).format(((Number) obj).longValue());
        }
        if ((obj instanceof Double) || (obj instanceof BigDecimal) || (obj instanceof Float)) {
            return getDecimalFormat(this.locale, str).format(((Number) obj).doubleValue());
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat(str, this.locale).format(obj);
        }
        return obj.toString();
    }

    public StringLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public StringLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public StringLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public StringLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public StringLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
        this.log = LogFactory.getLog(StringLocaleConverter.class);
    }

    public StringLocaleConverter(Object obj) {
        this(obj, false);
    }

    public StringLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public StringLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public StringLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public StringLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public StringLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
        this.log = LogFactory.getLog(StringLocaleConverter.class);
    }
}
