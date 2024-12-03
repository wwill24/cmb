package org.apache.commons.validator.routines;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateValidator extends AbstractCalendarValidator {
    private static final DateValidator VALIDATOR = new DateValidator();
    private static final long serialVersionUID = -3966328400469953190L;

    public DateValidator() {
        this(true, 3);
    }

    private Calendar getCalendar(Date date, TimeZone timeZone) {
        Calendar calendar;
        if (timeZone != null) {
            calendar = Calendar.getInstance(timeZone);
        } else {
            calendar = Calendar.getInstance();
        }
        calendar.setTime(date);
        return calendar;
    }

    public static DateValidator getInstance() {
        return VALIDATOR;
    }

    public int compareDates(Date date, Date date2, TimeZone timeZone) {
        return compare(getCalendar(date, timeZone), getCalendar(date2, timeZone), 5);
    }

    public int compareMonths(Date date, Date date2, TimeZone timeZone) {
        return compare(getCalendar(date, timeZone), getCalendar(date2, timeZone), 2);
    }

    public int compareQuarters(Date date, Date date2, TimeZone timeZone) {
        return compareQuarters(date, date2, timeZone, 1);
    }

    public int compareWeeks(Date date, Date date2, TimeZone timeZone) {
        return compare(getCalendar(date, timeZone), getCalendar(date2, timeZone), 3);
    }

    public int compareYears(Date date, Date date2, TimeZone timeZone) {
        return compare(getCalendar(date, timeZone), getCalendar(date2, timeZone), 1);
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        return obj;
    }

    public Date validate(String str) {
        return (Date) parse(str, (String) null, (Locale) null, (TimeZone) null);
    }

    public DateValidator(boolean z10, int i10) {
        super(z10, i10, -1);
    }

    public int compareQuarters(Date date, Date date2, TimeZone timeZone, int i10) {
        return super.compareQuarters(getCalendar(date, timeZone), getCalendar(date2, timeZone), i10);
    }

    public Date validate(String str, TimeZone timeZone) {
        return (Date) parse(str, (String) null, (Locale) null, timeZone);
    }

    public Date validate(String str, String str2) {
        return (Date) parse(str, str2, (Locale) null, (TimeZone) null);
    }

    public Date validate(String str, String str2, TimeZone timeZone) {
        return (Date) parse(str, str2, (Locale) null, timeZone);
    }

    public Date validate(String str, Locale locale) {
        return (Date) parse(str, (String) null, locale, (TimeZone) null);
    }

    public Date validate(String str, Locale locale, TimeZone timeZone) {
        return (Date) parse(str, (String) null, locale, timeZone);
    }

    public Date validate(String str, String str2, Locale locale) {
        return (Date) parse(str, str2, locale, (TimeZone) null);
    }

    public Date validate(String str, String str2, Locale locale, TimeZone timeZone) {
        return (Date) parse(str, str2, locale, timeZone);
    }
}
