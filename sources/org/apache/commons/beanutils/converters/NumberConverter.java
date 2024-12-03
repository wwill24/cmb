package org.apache.commons.beanutils.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;

public abstract class NumberConverter extends AbstractConverter {
    private static final Integer ONE = new Integer(1);
    private static final Integer ZERO = new Integer(0);
    private final boolean allowDecimals;
    private Locale locale;
    private String pattern;
    private boolean useLocaleFormat;

    public NumberConverter(boolean z10) {
        this.allowDecimals = z10;
    }

    private NumberFormat getFormat() {
        NumberFormat numberFormat;
        if (this.pattern != null) {
            if (this.locale == null) {
                if (log().isDebugEnabled()) {
                    Log log = log();
                    log.debug("    Using pattern '" + this.pattern + "'");
                }
                numberFormat = new DecimalFormat(this.pattern);
            } else {
                if (log().isDebugEnabled()) {
                    Log log2 = log();
                    log2.debug("    Using pattern '" + this.pattern + "'" + " with Locale[" + this.locale + "]");
                }
                numberFormat = new DecimalFormat(this.pattern, new DecimalFormatSymbols(this.locale));
            }
        } else if (this.locale == null) {
            if (log().isDebugEnabled()) {
                log().debug("    Using default Locale format");
            }
            numberFormat = NumberFormat.getInstance();
        } else {
            if (log().isDebugEnabled()) {
                Log log3 = log();
                log3.debug("    Using Locale[" + this.locale + "] format");
            }
            numberFormat = NumberFormat.getInstance(this.locale);
        }
        if (!this.allowDecimals) {
            numberFormat.setParseIntegerOnly(true);
        }
        return numberFormat;
    }

    private Number parse(Class<?> cls, Class<?> cls2, String str, NumberFormat numberFormat) {
        ParsePosition parsePosition = new ParsePosition(0);
        Number parse = numberFormat.parse(str, parsePosition);
        if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() == str.length() && parse != null) {
            return parse;
        }
        String str2 = "Error converting from '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (numberFormat instanceof DecimalFormat) {
            str2 = str2 + " using pattern '" + ((DecimalFormat) numberFormat).toPattern() + "'";
        }
        if (this.locale != null) {
            str2 = str2 + " for locale=[" + this.locale + "]";
        }
        if (log().isDebugEnabled()) {
            log().debug("    " + str2);
        }
        throw new ConversionException(str2);
    }

    private <T> T toNumber(Class<?> cls, Class<T> cls2, Number number) {
        if (cls2.equals(number.getClass())) {
            return cls2.cast(number);
        }
        if (cls2.equals(Byte.class)) {
            long longValue = number.longValue();
            if (longValue > 127) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            } else if (longValue >= -128) {
                return cls2.cast(new Byte(number.byteValue()));
            } else {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
            }
        } else if (cls2.equals(Short.class)) {
            long longValue2 = number.longValue();
            if (longValue2 > 32767) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            } else if (longValue2 >= -32768) {
                return cls2.cast(new Short(number.shortValue()));
            } else {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
            }
        } else if (cls2.equals(Integer.class)) {
            long longValue3 = number.longValue();
            if (longValue3 > 2147483647L) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            } else if (longValue3 >= -2147483648L) {
                return cls2.cast(new Integer(number.intValue()));
            } else {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
            }
        } else if (cls2.equals(Long.class)) {
            return cls2.cast(new Long(number.longValue()));
        } else {
            if (cls2.equals(Float.class)) {
                if (number.doubleValue() <= 3.4028234663852886E38d) {
                    return cls2.cast(new Float(number.floatValue()));
                }
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            } else if (cls2.equals(Double.class)) {
                return cls2.cast(new Double(number.doubleValue()));
            } else {
                if (cls2.equals(BigDecimal.class)) {
                    if ((number instanceof Float) || (number instanceof Double)) {
                        return cls2.cast(new BigDecimal(number.toString()));
                    }
                    if (number instanceof BigInteger) {
                        return cls2.cast(new BigDecimal((BigInteger) number));
                    }
                    return cls2.cast(BigDecimal.valueOf(number.longValue()));
                } else if (!cls2.equals(BigInteger.class)) {
                    String str = toString(getClass()) + " cannot handle conversion to '" + toString(cls2) + "'";
                    if (log().isWarnEnabled()) {
                        log().warn("    " + str);
                    }
                    throw new ConversionException(str);
                } else if (number instanceof BigDecimal) {
                    return cls2.cast(((BigDecimal) number).toBigInteger());
                } else {
                    return cls2.cast(BigInteger.valueOf(number.longValue()));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) throws Throwable {
        String str;
        if (!this.useLocaleFormat || !(obj instanceof Number)) {
            str = obj.toString();
            if (log().isDebugEnabled()) {
                Log log = log();
                log.debug("    Converted  to String using toString() '" + str + "'");
            }
        } else {
            NumberFormat format2 = getFormat();
            format2.setGroupingUsed(false);
            str = format2.format(obj);
            if (log().isDebugEnabled()) {
                Log log2 = log();
                log2.debug("    Converted  to String using format '" + str + "'");
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        Number number;
        Integer num;
        Class<Long> cls2 = Long.class;
        Class cls3 = obj.getClass();
        if (obj instanceof Number) {
            return toNumber((Class<?>) cls3, cls, (Number) obj);
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                num = ONE;
            } else {
                num = ZERO;
            }
            return toNumber((Class<?>) cls3, cls, (Number) num);
        } else if ((obj instanceof Date) && cls2.equals(cls)) {
            return cls.cast(new Long(((Date) obj).getTime()));
        } else {
            if ((obj instanceof Calendar) && cls2.equals(cls)) {
                return cls.cast(new Long(((Calendar) obj).getTime().getTime()));
            }
            String trim = obj.toString().trim();
            if (trim.length() == 0) {
                return handleMissing(cls);
            }
            if (this.useLocaleFormat) {
                number = parse(cls3, cls, trim, getFormat());
            } else {
                if (log().isDebugEnabled()) {
                    log().debug("    No NumberFormat, using default conversion");
                }
                number = toNumber((Class<?>) cls3, (Class<?>) cls, trim);
            }
            return toNumber((Class<?>) cls3, cls, number);
        }
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    public boolean isAllowDecimals() {
        return this.allowDecimals;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
        setUseLocaleFormat(true);
    }

    public void setPattern(String str) {
        this.pattern = str;
        setUseLocaleFormat(true);
    }

    public void setUseLocaleFormat(boolean z10) {
        this.useLocaleFormat = z10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toString(getClass()));
        sb2.append("[UseDefault=");
        sb2.append(isUseDefault());
        sb2.append(", UseLocaleFormat=");
        sb2.append(this.useLocaleFormat);
        if (this.pattern != null) {
            sb2.append(", Pattern=");
            sb2.append(this.pattern);
        }
        if (this.locale != null) {
            sb2.append(", Locale=");
            sb2.append(this.locale);
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public NumberConverter(boolean z10, Object obj) {
        this.allowDecimals = z10;
        setDefaultValue(obj);
    }

    private Number toNumber(Class<?> cls, Class<?> cls2, String str) {
        if (cls2.equals(Byte.class)) {
            return new Byte(str);
        }
        if (cls2.equals(Short.class)) {
            return new Short(str);
        }
        if (cls2.equals(Integer.class)) {
            return new Integer(str);
        }
        if (cls2.equals(Long.class)) {
            return new Long(str);
        }
        if (cls2.equals(Float.class)) {
            return new Float(str);
        }
        if (cls2.equals(Double.class)) {
            return new Double(str);
        }
        if (cls2.equals(BigDecimal.class)) {
            return new BigDecimal(str);
        }
        if (cls2.equals(BigInteger.class)) {
            return new BigInteger(str);
        }
        String str2 = toString(getClass()) + " cannot handle conversion from '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str2);
        }
        throw new ConversionException(str2);
    }
}
