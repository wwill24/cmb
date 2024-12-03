package g9;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.internal.security.CertificateUtil;
import ga.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import nc.b;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f15257a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15258b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15259c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15260d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15261e;

    /* renamed from: f  reason: collision with root package name */
    private final TimeZone f15262f;

    /* renamed from: g  reason: collision with root package name */
    private SimpleDateFormat f15263g;

    /* renamed from: h  reason: collision with root package name */
    private SimpleDateFormat f15264h;

    /* renamed from: i  reason: collision with root package name */
    private Pattern f15265i;

    public a(TimeZone timeZone, b bVar, String str, String str2, String str3, String str4) {
        this.f15257a = bVar;
        this.f15258b = str;
        this.f15259c = str2;
        this.f15260d = str3;
        this.f15261e = str4;
        this.f15262f = timeZone;
    }

    private String f(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    private String g() {
        StringBuilder sb2 = new StringBuilder(j().format(new Date(this.f15257a.getCurrentTimeMillis())));
        if (h().matcher(sb2).matches()) {
            sb2.insert(sb2.length() - 2, CertificateUtil.DELIMITER);
        }
        return sb2.toString();
    }

    private Pattern h() {
        if (this.f15265i == null) {
            this.f15265i = Pattern.compile(".*[0-9]{4}$");
        }
        return this.f15265i;
    }

    private SimpleDateFormat i() {
        if (this.f15264h == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_PATTERN, Locale.US);
            this.f15264h = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f15262f);
        }
        return this.f15264h;
    }

    private SimpleDateFormat j() {
        if (this.f15263g == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZZZ", Locale.US);
            this.f15263g = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f15262f);
        }
        return this.f15263g;
    }

    public String a() {
        return String.format("android RLCS: %s OsVersion: %s AppVersion: %s Brand: %s Model: %s CurrentTime: %s", new Object[]{"1.0", this.f15258b, this.f15259c, this.f15260d, this.f15261e, g()});
    }

    public String b(String str, String str2) {
        return String.format("%s %s: %s", new Object[]{g(), f(str), str2});
    }

    public String c() {
        Date date = new Date(this.f15257a.getCurrentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.setTimeZone(this.f15262f);
        gregorianCalendar.add(5, -1);
        return String.format("%s.cmblog", new Object[]{i().format(gregorianCalendar.getTime())});
    }

    public String d() {
        return String.format("%s.cmblog", new Object[]{i().format(new Date(this.f15257a.getCurrentTimeMillis()))});
    }

    public String e(String str, boolean z10, String str2) {
        String str3 = z10 ? "> " : "< ";
        return b(str, str3 + str2);
    }
}
