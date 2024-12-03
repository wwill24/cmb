package org.jxmpp.util;

import com.coffeemeetsbagel.models.util.DateUtils;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmppDateTime {

    /* renamed from: a  reason: collision with root package name */
    private static final DateFormatType f24274a;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f24275b;

    /* renamed from: c  reason: collision with root package name */
    private static final DateFormatType f24276c;

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f24277d;

    /* renamed from: e  reason: collision with root package name */
    private static final DateFormatType f24278e;

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f24279f;

    /* renamed from: g  reason: collision with root package name */
    private static final DateFormatType f24280g;

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f24281h;

    /* renamed from: i  reason: collision with root package name */
    private static final DateFormatType f24282i;

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f24283j;

    /* renamed from: k  reason: collision with root package name */
    private static final DateFormatType f24284k;

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f24285l;

    /* renamed from: m  reason: collision with root package name */
    private static final DateFormatType f24286m;

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f24287n;

    /* renamed from: o  reason: collision with root package name */
    private static final TimeZone f24288o = DesugarTimeZone.getTimeZone("UTC");

    /* renamed from: p  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f24289p = new a();

    /* renamed from: q  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f24290q = new b();

    /* renamed from: r  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f24291r = new c();

    /* renamed from: s  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f24292s = new d();

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f24293t = Pattern.compile("^\\d+T\\d+:\\d+:\\d+$");

    /* renamed from: u  reason: collision with root package name */
    private static final List<f> f24294u;

    /* renamed from: v  reason: collision with root package name */
    private static final Pattern f24295v = Pattern.compile(".*\\.(\\d{1,})(Z|((\\+|-)\\d{4}))");

    private enum DateFormatType {
        XEP_0082_DATE_PROFILE(DateUtils.DATE_PATTERN),
        XEP_0082_DATETIME_PROFILE("yyyy-MM-dd'T'HH:mm:ssZ"),
        XEP_0082_DATETIME_MILLIS_PROFILE("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        XEP_0082_TIME_PROFILE("hh:mm:ss"),
        XEP_0082_TIME_ZONE_PROFILE("hh:mm:ssZ"),
        XEP_0082_TIME_MILLIS_PROFILE("hh:mm:ss.SSS"),
        XEP_0082_TIME_MILLIS_ZONE_PROFILE("hh:mm:ss.SSSZ"),
        XEP_0091_DATETIME("yyyyMMdd'T'HH:mm:ss");
        
        private final boolean CONVERT_TIMEZONE;
        private final ThreadLocal<DateFormat> FORMATTER;
        /* access modifiers changed from: private */
        public final String FORMAT_STRING;
        private final boolean HANDLE_MILLIS;

        class a extends ThreadLocal<DateFormat> {
            a() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public DateFormat initialValue() {
                return XmppDateTime.d(DateFormatType.this.FORMAT_STRING);
            }
        }

        private DateFormatType(String str) {
            this.FORMAT_STRING = str;
            this.FORMATTER = new a();
            this.CONVERT_TIMEZONE = str.charAt(str.length() - 1) != 'Z' ? false : true;
            this.HANDLE_MILLIS = str.contains("SSS");
        }

        /* access modifiers changed from: private */
        public String d(Date date) {
            String format2 = this.FORMATTER.get().format(date);
            if (this.CONVERT_TIMEZONE) {
                return XmppDateTime.e(format2);
            }
            return format2;
        }

        /* access modifiers changed from: private */
        public Date e(String str) throws ParseException {
            if (this.CONVERT_TIMEZONE) {
                str = XmppDateTime.f(str);
            }
            if (this.HANDLE_MILLIS) {
                str = XmppDateTime.k(str);
            }
            return this.FORMATTER.get().parse(str);
        }
    }

    class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            return XmppDateTime.d("yyyyMMdd'T'HH:mm:ss");
        }
    }

    class b extends ThreadLocal<DateFormat> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            return XmppDateTime.d("yyyyMd'T'HH:mm:ss");
        }
    }

    class c extends ThreadLocal<DateFormat> {
        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            DateFormat a10 = XmppDateTime.d("yyyyMdd'T'HH:mm:ss");
            a10.setLenient(false);
            return a10;
        }
    }

    class d extends ThreadLocal<DateFormat> {
        d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            DateFormat a10 = XmppDateTime.d("yyyyMMd'T'HH:mm:ss");
            a10.setLenient(false);
            return a10;
        }
    }

    class e implements Comparator<Calendar> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Calendar f24306a;

        e(Calendar calendar) {
            this.f24306a = calendar;
        }

        /* renamed from: a */
        public int compare(Calendar calendar, Calendar calendar2) {
            return Long.valueOf(this.f24306a.getTimeInMillis() - calendar.getTimeInMillis()).compareTo(Long.valueOf(this.f24306a.getTimeInMillis() - calendar2.getTimeInMillis()));
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        final Pattern f24307a;

        /* renamed from: b  reason: collision with root package name */
        final DateFormatType f24308b;

        f(Pattern pattern, DateFormatType dateFormatType) {
            this.f24307a = pattern;
            this.f24308b = dateFormatType;
        }
    }

    static {
        DateFormatType dateFormatType = DateFormatType.XEP_0082_DATE_PROFILE;
        f24274a = dateFormatType;
        Pattern compile = Pattern.compile("^\\d+-\\d+-\\d+$");
        f24275b = compile;
        DateFormatType dateFormatType2 = DateFormatType.XEP_0082_TIME_MILLIS_ZONE_PROFILE;
        f24276c = dateFormatType2;
        Pattern compile2 = Pattern.compile("^(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        f24277d = compile2;
        DateFormatType dateFormatType3 = DateFormatType.XEP_0082_TIME_MILLIS_PROFILE;
        f24278e = dateFormatType3;
        Pattern compile3 = Pattern.compile("^(\\d+:){2}\\d+.\\d+$");
        f24279f = compile3;
        DateFormatType dateFormatType4 = DateFormatType.XEP_0082_TIME_ZONE_PROFILE;
        f24280g = dateFormatType4;
        Pattern compile4 = Pattern.compile("^(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        f24281h = compile4;
        DateFormatType dateFormatType5 = DateFormatType.XEP_0082_TIME_PROFILE;
        f24282i = dateFormatType5;
        Pattern compile5 = Pattern.compile("^(\\d+:){2}\\d+$");
        f24283j = compile5;
        DateFormatType dateFormatType6 = DateFormatType.XEP_0082_DATETIME_MILLIS_PROFILE;
        f24284k = dateFormatType6;
        Pattern compile6 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        f24285l = compile6;
        DateFormatType dateFormatType7 = DateFormatType.XEP_0082_DATETIME_PROFILE;
        f24286m = dateFormatType7;
        Pattern compile7 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        f24287n = compile7;
        ArrayList arrayList = new ArrayList();
        f24294u = arrayList;
        arrayList.add(new f(compile, dateFormatType));
        arrayList.add(new f(compile6, dateFormatType6));
        arrayList.add(new f(compile7, dateFormatType7));
        arrayList.add(new f(compile2, dateFormatType2));
        arrayList.add(new f(compile3, dateFormatType3));
        arrayList.add(new f(compile4, dateFormatType4));
        arrayList.add(new f(compile5, dateFormatType5));
    }

    public static String c(TimeZone timeZone) {
        int rawOffset = timeZone.getRawOffset();
        int i10 = rawOffset / 3600000;
        return String.format("%+d:%02d", new Object[]{Integer.valueOf(i10), Integer.valueOf(Math.abs((rawOffset / 60000) - (i10 * 60)))});
    }

    /* access modifiers changed from: private */
    public static DateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(f24288o);
        return simpleDateFormat;
    }

    public static String e(String str) {
        int length = str.length();
        int i10 = length - 2;
        return (str.substring(0, i10) + ':') + str.substring(i10, length);
    }

    public static String f(String str) {
        if (str.charAt(str.length() - 1) == 'Z') {
            return str.replace("Z", "+0000");
        }
        return str.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
    }

    private static Calendar g(Calendar calendar, List<Calendar> list) {
        Collections.sort(list, new e(calendar));
        return list.get(0);
    }

    private static List<Calendar> h(Calendar calendar, Calendar... calendarArr) {
        ArrayList arrayList = new ArrayList();
        for (Calendar calendar2 : calendarArr) {
            if (calendar2 != null && calendar2.before(calendar)) {
                arrayList.add(calendar2);
            }
        }
        return arrayList;
    }

    public static String i(Date date) {
        return f24284k.d(date);
    }

    private static Date j(String str, int i10) throws ParseException {
        if (i10 == 6) {
            return f24290q.get().parse(str);
        }
        Calendar instance = Calendar.getInstance();
        List<Calendar> h10 = h(instance, n(str, f24291r.get()), n(str, f24292s.get()));
        if (!h10.isEmpty()) {
            return g(instance, h10).getTime();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String k(String str) {
        int length;
        Matcher matcher = f24295v.matcher(str);
        if (!matcher.matches() || (length = matcher.group(1).length()) == 3) {
            return str;
        }
        int indexOf = str.indexOf(".");
        StringBuilder sb2 = new StringBuilder((str.length() - length) + 3);
        if (length > 3) {
            sb2.append(str.substring(0, indexOf + 4));
        } else {
            sb2.append(str.substring(0, indexOf + length + 1));
            for (int i10 = length; i10 < 3; i10++) {
                sb2.append('0');
            }
        }
        sb2.append(str.substring(indexOf + length + 1));
        return sb2.toString();
    }

    public static Date l(String str) throws ParseException {
        if (f24293t.matcher(str).matches()) {
            int length = str.split("T")[0].length();
            if (length >= 8) {
                return f24289p.get().parse(str);
            }
            Date j10 = j(str, length);
            if (j10 != null) {
                return j10;
            }
        }
        return m(str);
    }

    public static Date m(String str) throws ParseException {
        for (f next : f24294u) {
            if (next.f24307a.matcher(str).matches()) {
                return next.f24308b.e(str);
            }
        }
        return f24286m.e(str);
    }

    private static Calendar n(String str, DateFormat dateFormat) {
        try {
            dateFormat.parse(str);
            return dateFormat.getCalendar();
        } catch (ParseException unused) {
            return null;
        }
    }
}
