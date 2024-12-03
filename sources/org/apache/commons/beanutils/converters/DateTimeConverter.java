package org.apache.commons.beanutils.converters;

import com.mparticle.kits.MPSideloadedKit;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;

public abstract class DateTimeConverter extends AbstractConverter {
    private String displayPatterns;
    private Locale locale;
    private String[] patterns;
    private TimeZone timeZone;
    private boolean useLocaleFormat;

    public DateTimeConverter() {
    }

    private void logFormat(String str, DateFormat dateFormat) {
        if (log().isDebugEnabled()) {
            StringBuilder sb2 = new StringBuilder(45);
            sb2.append("    ");
            sb2.append(str);
            sb2.append(" with Format");
            if (dateFormat instanceof SimpleDateFormat) {
                sb2.append("[");
                sb2.append(((SimpleDateFormat) dateFormat).toPattern());
                sb2.append("]");
            }
            sb2.append(" for ");
            if (this.locale == null) {
                sb2.append("default locale");
            } else {
                sb2.append("locale[");
                sb2.append(this.locale);
                sb2.append("]");
            }
            if (this.timeZone != null) {
                sb2.append(", TimeZone[");
                sb2.append(this.timeZone);
                sb2.append("]");
            }
            log().debug(sb2.toString());
        }
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str) throws Exception {
        Exception exc = null;
        int i10 = 0;
        while (true) {
            String[] strArr = this.patterns;
            if (i10 < strArr.length) {
                try {
                    return parse(cls, cls2, str, getFormat(strArr[i10]));
                } catch (Exception e10) {
                    if (exc == null) {
                        exc = e10;
                    }
                    i10++;
                }
            } else if (strArr.length > 1) {
                throw new ConversionException("Error converting '" + toString(cls) + "' to '" + toString(cls2) + "' using  patterns '" + this.displayPatterns + "'");
            } else {
                throw exc;
            }
        }
    }

    private <T> T toDate(Class<T> cls, long j10) {
        Calendar calendar;
        if (cls.equals(Date.class)) {
            return cls.cast(new Date(j10));
        }
        if (cls.equals(java.sql.Date.class)) {
            return cls.cast(new java.sql.Date(j10));
        }
        if (cls.equals(Time.class)) {
            return cls.cast(new Time(j10));
        }
        if (cls.equals(Timestamp.class)) {
            return cls.cast(new Timestamp(j10));
        }
        if (cls.equals(Calendar.class)) {
            Locale locale2 = this.locale;
            if (locale2 == null && this.timeZone == null) {
                calendar = Calendar.getInstance();
            } else if (locale2 == null) {
                calendar = Calendar.getInstance(this.timeZone);
            } else {
                TimeZone timeZone2 = this.timeZone;
                if (timeZone2 == null) {
                    calendar = Calendar.getInstance(locale2);
                } else {
                    calendar = Calendar.getInstance(timeZone2, locale2);
                }
            }
            calendar.setTime(new Date(j10));
            calendar.setLenient(false);
            return cls.cast(calendar);
        }
        String str = toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str);
        }
        throw new ConversionException(str);
    }

    /* access modifiers changed from: protected */
    public String convertToString(Object obj) throws Throwable {
        Date date;
        String str;
        DateFormat dateFormat;
        if (obj instanceof Date) {
            date = (Date) obj;
        } else if (obj instanceof Calendar) {
            date = ((Calendar) obj).getTime();
        } else if (obj instanceof Long) {
            date = new Date(((Long) obj).longValue());
        } else {
            date = null;
        }
        if (!this.useLocaleFormat || date == null) {
            str = obj.toString();
            if (log().isDebugEnabled()) {
                Log log = log();
                log.debug("    Converted  to String using toString() '" + str + "'");
            }
        } else {
            String[] strArr = this.patterns;
            if (strArr == null || strArr.length <= 0) {
                dateFormat = getFormat(this.locale, this.timeZone);
            } else {
                dateFormat = getFormat(strArr[0]);
            }
            logFormat("Formatting", dateFormat);
            str = dateFormat.format(date);
            if (log().isDebugEnabled()) {
                Log log2 = log();
                log2.debug("    Converted  to String using format '" + str + "'");
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public <T> T convertToType(Class<T> cls, Object obj) throws Exception {
        Calendar calendar;
        Class<?> cls2 = obj.getClass();
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            return toDate(cls, ((timestamp.getTime() / 1000) * 1000) + ((long) (timestamp.getNanos() / MPSideloadedKit.MIN_SIDELOADED_KIT)));
        } else if (obj instanceof Date) {
            return toDate(cls, ((Date) obj).getTime());
        } else {
            if (obj instanceof Calendar) {
                return toDate(cls, ((Calendar) obj).getTime().getTime());
            }
            if (obj instanceof Long) {
                return toDate(cls, ((Long) obj).longValue());
            }
            String trim = obj.toString().trim();
            if (trim.length() == 0) {
                return handleMissing(cls);
            }
            if (!this.useLocaleFormat) {
                return toDate(cls, trim);
            }
            String[] strArr = this.patterns;
            if (strArr == null || strArr.length <= 0) {
                calendar = parse(cls2, cls, trim, getFormat(this.locale, this.timeZone));
            } else {
                calendar = parse(cls2, cls, trim);
            }
            if (Calendar.class.isAssignableFrom(cls)) {
                return cls.cast(calendar);
            }
            return toDate(cls, calendar.getTime().getTime());
        }
    }

    /* access modifiers changed from: protected */
    public DateFormat getFormat(Locale locale2, TimeZone timeZone2) {
        DateFormat dateFormat;
        if (locale2 == null) {
            dateFormat = DateFormat.getDateInstance(3);
        } else {
            dateFormat = DateFormat.getDateInstance(3, locale2);
        }
        if (timeZone2 != null) {
            dateFormat.setTimeZone(timeZone2);
        }
        return dateFormat;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String[] getPatterns() {
        return this.patterns;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setLocale(Locale locale2) {
        this.locale = locale2;
        setUseLocaleFormat(true);
    }

    public void setPattern(String str) {
        setPatterns(new String[]{str});
    }

    public void setPatterns(String[] strArr) {
        this.patterns = strArr;
        if (strArr != null && strArr.length > 1) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(strArr[i10]);
            }
            this.displayPatterns = sb2.toString();
        }
        setUseLocaleFormat(true);
    }

    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
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
        if (this.displayPatterns != null) {
            sb2.append(", Patterns={");
            sb2.append(this.displayPatterns);
            sb2.append('}');
        }
        if (this.locale != null) {
            sb2.append(", Locale=");
            sb2.append(this.locale);
        }
        if (this.timeZone != null) {
            sb2.append(", TimeZone=");
            sb2.append(this.timeZone);
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public DateTimeConverter(Object obj) {
        super(obj);
    }

    private DateFormat getFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        TimeZone timeZone2 = this.timeZone;
        if (timeZone2 != null) {
            simpleDateFormat.setTimeZone(timeZone2);
        }
        return simpleDateFormat;
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str, DateFormat dateFormat) {
        logFormat("Parsing", dateFormat);
        dateFormat.setLenient(false);
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = dateFormat.parse(str, parsePosition);
        if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() == str.length() && parse != null) {
            return dateFormat.getCalendar();
        }
        String str2 = "Error converting '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (dateFormat instanceof SimpleDateFormat) {
            str2 = str2 + " using pattern '" + ((SimpleDateFormat) dateFormat).toPattern() + "'";
        }
        if (log().isDebugEnabled()) {
            log().debug("    " + str2);
        }
        throw new ConversionException(str2);
    }

    private <T> T toDate(Class<T> cls, String str) {
        if (cls.equals(java.sql.Date.class)) {
            try {
                return cls.cast(java.sql.Date.valueOf(str));
            } catch (IllegalArgumentException unused) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd] to create a java.sql.Date");
            }
        } else if (cls.equals(Time.class)) {
            try {
                return cls.cast(Time.valueOf(str));
            } catch (IllegalArgumentException unused2) {
                throw new ConversionException("String must be in JDBC format [HH:mm:ss] to create a java.sql.Time");
            }
        } else if (cls.equals(Timestamp.class)) {
            try {
                return cls.cast(Timestamp.valueOf(str));
            } catch (IllegalArgumentException unused3) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd HH:mm:ss.fffffffff] to create a java.sql.Timestamp");
            }
        } else {
            String str2 = toString(getClass()) + " does not support default String to '" + toString(cls) + "' conversion.";
            if (log().isWarnEnabled()) {
                log().warn("    " + str2);
                log().warn("    (N.B. Re-configure Converter or use alternative implementation)");
            }
            throw new ConversionException(str2);
        }
    }
}
