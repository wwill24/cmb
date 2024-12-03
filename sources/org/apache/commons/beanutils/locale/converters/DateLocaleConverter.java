package org.apache.commons.beanutils.locale.converters;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateLocaleConverter extends BaseLocaleConverter {
    private static final String DEFAULT_PATTERN_CHARS = initDefaultChars();
    boolean isLenient;
    private final Log log;

    public DateLocaleConverter() {
        this(false);
    }

    private String convertLocalizedPattern(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        String localPatternChars = new DateFormatSymbols(locale).getLocalPatternChars();
        String str2 = DEFAULT_PATTERN_CHARS;
        if (str2.equals(localPatternChars)) {
            return str;
        }
        try {
            return convertPattern(str, localPatternChars, str2);
        } catch (Exception e10) {
            Log log2 = this.log;
            log2.debug("Converting pattern '" + str + "' for " + locale, e10);
            return null;
        }
    }

    private String convertPattern(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (z10) {
                if (charAt == '\'') {
                    z10 = false;
                }
            } else if (charAt == '\'') {
                z10 = true;
            } else if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                int indexOf = str2.indexOf(charAt);
                if (indexOf != -1) {
                    charAt = str3.charAt(indexOf);
                } else {
                    throw new IllegalArgumentException("Illegal pattern character '" + charAt + "'");
                }
            }
            sb2.append(charAt);
        }
        if (!z10) {
            return sb2.toString();
        }
        throw new IllegalArgumentException("Unfinished quote in pattern");
    }

    private static String initDefaultChars() {
        return new DateFormatSymbols(Locale.US).getLocalPatternChars();
    }

    public boolean isLenient() {
        return this.isLenient;
    }

    /* access modifiers changed from: protected */
    public Object parse(Object obj, String str) throws ParseException {
        DateFormat dateFormat;
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (this.locPattern) {
            str = convertLocalizedPattern(str, this.locale);
        }
        if (str == null) {
            dateFormat = DateFormat.getDateInstance(3, this.locale);
        } else {
            dateFormat = new SimpleDateFormat(str, this.locale);
        }
        dateFormat.setLenient(this.isLenient);
        ParsePosition parsePosition = new ParsePosition(0);
        String obj2 = obj.toString();
        Object parseObject = dateFormat.parseObject(obj2, parsePosition);
        if (parsePosition.getErrorIndex() > -1) {
            throw new ConversionException("Error parsing date '" + obj + "' at position=" + parsePosition.getErrorIndex());
        } else if (parsePosition.getIndex() >= obj2.length()) {
            return parseObject;
        } else {
            throw new ConversionException("Date '" + obj + "' contains unparsed characters from position=" + parsePosition.getIndex());
        }
    }

    public void setLenient(boolean z10) {
        this.isLenient = z10;
    }

    public DateLocaleConverter(boolean z10) {
        this(Locale.getDefault(), z10);
    }

    public DateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DateLocaleConverter(Locale locale, boolean z10) {
        this(locale, (String) null, z10);
    }

    public DateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DateLocaleConverter(Locale locale, String str, boolean z10) {
        super(locale, str, z10);
        this.log = LogFactory.getLog(DateLocaleConverter.class);
        this.isLenient = false;
    }

    public DateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DateLocaleConverter(Object obj, boolean z10) {
        this(obj, Locale.getDefault(), z10);
    }

    public DateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, boolean z10) {
        this(obj, locale, (String) null, z10);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str, boolean z10) {
        super(obj, locale, str, z10);
        this.log = LogFactory.getLog(DateLocaleConverter.class);
        this.isLenient = false;
    }
}
