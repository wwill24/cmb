package org.apache.commons.beanutils.locale.converters;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DecimalLocaleConverter extends BaseLocaleConverter {
    private final Log log;

    public DecimalLocaleConverter() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        if (obj instanceof Number) {
            return obj;
        }
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(this.locale);
        if (str == null) {
            this.log.debug("No pattern provided, using default.");
        } else if (this.locPattern) {
            decimalFormat.applyLocalizedPattern(str);
        } else {
            decimalFormat.applyPattern(str);
        }
        return decimalFormat.parse((String) obj);
    }

    public DecimalLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public DecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DecimalLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public DecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DecimalLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
        this.log = LogFactory.getLog(DecimalLocaleConverter.class);
    }

    public DecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DecimalLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public DecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
        this.log = LogFactory.getLog(DecimalLocaleConverter.class);
    }
}
