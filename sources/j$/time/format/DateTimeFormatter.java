package j$.time.format;

import com.leanplum.internal.Constants;
import j$.time.ZoneId;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.d;
import j$.time.i;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.j;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;

public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME;

    /* renamed from: h  reason: collision with root package name */
    public static final DateTimeFormatter f42600h;

    /* renamed from: a  reason: collision with root package name */
    private final C0528f f42601a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f42602b;

    /* renamed from: c  reason: collision with root package name */
    private final D f42603c;

    /* renamed from: d  reason: collision with root package name */
    private final F f42604d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f42605e = null;

    /* renamed from: f  reason: collision with root package name */
    private final f f42606f;

    /* renamed from: g  reason: collision with root package name */
    private final ZoneId f42607g;

    static {
        w wVar = new w();
        a aVar = a.YEAR;
        wVar.m(aVar, 4, 10, 5);
        wVar.e(SignatureVisitor.SUPER);
        a aVar2 = a.MONTH_OF_YEAR;
        wVar.l(aVar2, 2);
        wVar.e(SignatureVisitor.SUPER);
        a aVar3 = a.DAY_OF_MONTH;
        wVar.l(aVar3, 2);
        F f10 = F.STRICT;
        g gVar = g.f42585a;
        DateTimeFormatter u10 = wVar.u(f10, gVar);
        ISO_LOCAL_DATE = u10;
        w wVar2 = new w();
        wVar2.q();
        wVar2.a(u10);
        wVar2.h();
        wVar2.u(f10, gVar);
        w wVar3 = new w();
        wVar3.q();
        wVar3.a(u10);
        wVar3.p();
        wVar3.h();
        wVar3.u(f10, gVar);
        w wVar4 = new w();
        a aVar4 = a.HOUR_OF_DAY;
        wVar4.l(aVar4, 2);
        wVar4.e(':');
        a aVar5 = a.MINUTE_OF_HOUR;
        wVar4.l(aVar5, 2);
        wVar4.p();
        wVar4.e(':');
        a aVar6 = a.SECOND_OF_MINUTE;
        wVar4.l(aVar6, 2);
        wVar4.p();
        wVar4.b(a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter u11 = wVar4.u(f10, (g) null);
        w wVar5 = new w();
        wVar5.q();
        wVar5.a(u11);
        wVar5.h();
        wVar5.u(f10, (g) null);
        w wVar6 = new w();
        wVar6.q();
        wVar6.a(u11);
        wVar6.p();
        wVar6.h();
        wVar6.u(f10, (g) null);
        w wVar7 = new w();
        wVar7.q();
        wVar7.a(u10);
        wVar7.e('T');
        wVar7.a(u11);
        DateTimeFormatter u12 = wVar7.u(f10, gVar);
        w wVar8 = new w();
        wVar8.q();
        wVar8.a(u12);
        wVar8.h();
        DateTimeFormatter u13 = wVar8.u(f10, gVar);
        ISO_OFFSET_DATE_TIME = u13;
        w wVar9 = new w();
        wVar9.a(u13);
        wVar9.p();
        wVar9.e('[');
        wVar9.r();
        wVar9.n();
        wVar9.e(PropertyUtils.INDEXED_DELIM2);
        wVar9.u(f10, gVar);
        w wVar10 = new w();
        wVar10.a(u12);
        wVar10.p();
        wVar10.h();
        wVar10.p();
        wVar10.e('[');
        wVar10.r();
        wVar10.n();
        wVar10.e(PropertyUtils.INDEXED_DELIM2);
        ISO_DATE_TIME = wVar10.u(f10, gVar);
        w wVar11 = new w();
        wVar11.q();
        wVar11.m(aVar, 4, 10, 5);
        wVar11.e(SignatureVisitor.SUPER);
        wVar11.l(a.DAY_OF_YEAR, 3);
        wVar11.p();
        wVar11.h();
        wVar11.u(f10, gVar);
        w wVar12 = new w();
        wVar12.q();
        wVar12.m(j.f42734c, 4, 10, 5);
        wVar12.f("-W");
        wVar12.l(j.f42733b, 2);
        wVar12.e(SignatureVisitor.SUPER);
        a aVar7 = a.DAY_OF_WEEK;
        wVar12.l(aVar7, 1);
        wVar12.p();
        wVar12.h();
        wVar12.u(f10, gVar);
        w wVar13 = new w();
        wVar13.q();
        wVar13.c();
        f42600h = wVar13.u(f10, (g) null);
        w wVar14 = new w();
        wVar14.q();
        wVar14.l(aVar, 4);
        wVar14.l(aVar2, 2);
        wVar14.l(aVar3, 2);
        wVar14.p();
        wVar14.g("+HHMMss", "Z");
        wVar14.u(f10, gVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        g gVar2 = gVar;
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        w wVar15 = new w();
        wVar15.q();
        wVar15.s();
        wVar15.p();
        wVar15.j(aVar7, hashMap);
        wVar15.f(", ");
        wVar15.o();
        wVar15.m(aVar3, 1, 2, 4);
        wVar15.e(' ');
        wVar15.j(aVar2, hashMap2);
        wVar15.e(' ');
        wVar15.l(aVar, 4);
        wVar15.e(' ');
        wVar15.l(aVar4, 2);
        wVar15.e(':');
        wVar15.l(aVar5, 2);
        wVar15.p();
        wVar15.e(':');
        wVar15.l(aVar6, 2);
        wVar15.o();
        wVar15.e(' ');
        wVar15.g("+HHMM", "GMT");
        wVar15.u(F.SMART, gVar2);
    }

    DateTimeFormatter(C0528f fVar, Locale locale, F f10, g gVar) {
        D d10 = D.f42599a;
        this.f42601a = fVar;
        Objects.requireNonNull(locale, Constants.Keys.LOCALE);
        this.f42602b = locale;
        this.f42603c = d10;
        Objects.requireNonNull(f10, "resolverStyle");
        this.f42604d = f10;
        this.f42606f = gVar;
        this.f42607g = null;
    }

    private TemporalAccessor g(CharSequence charSequence) {
        String str;
        ParsePosition parsePosition = new ParsePosition(0);
        Objects.requireNonNull(charSequence, "text");
        x xVar = new x(this);
        int d10 = this.f42601a.d(xVar, charSequence, parsePosition.getIndex());
        if (d10 < 0) {
            parsePosition.setErrorIndex(~d10);
            xVar = null;
        } else {
            parsePosition.setIndex(d10);
        }
        if (xVar != null && parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() >= charSequence.length()) {
            return xVar.t(this.f42604d, this.f42605e);
        }
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        if (parsePosition.getErrorIndex() >= 0) {
            String str2 = "Text '" + str + "' could not be parsed at index " + parsePosition.getErrorIndex();
            parsePosition.getErrorIndex();
            throw new y(str2, charSequence);
        }
        String str3 = "Text '" + str + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
        parsePosition.getIndex();
        throw new y(str3, charSequence);
    }

    public static DateTimeFormatter ofPattern(String str) {
        w wVar = new w();
        wVar.i(str);
        return wVar.t();
    }

    public final String a(TemporalAccessor temporalAccessor) {
        StringBuilder sb2 = new StringBuilder(32);
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            this.f42601a.b(new A(temporalAccessor, this), sb2);
            return sb2.toString();
        } catch (IOException e10) {
            throw new d(e10.getMessage(), e10);
        }
    }

    public final f b() {
        return this.f42606f;
    }

    public final D c() {
        return this.f42603c;
    }

    public final Locale d() {
        return this.f42602b;
    }

    public final ZoneId e() {
        return this.f42607g;
    }

    public final Object f(CharSequence charSequence, i iVar) {
        String str;
        Objects.requireNonNull(charSequence, "text");
        try {
            return ((E) g(charSequence)).k(iVar);
        } catch (y e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (charSequence.length() > 64) {
                str = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                str = charSequence.toString();
            }
            throw new y("Text '" + str + "' could not be parsed: " + e11.getMessage(), charSequence, e11);
        }
    }

    /* access modifiers changed from: package-private */
    public final C0528f h() {
        return this.f42601a.a();
    }

    public final String toString() {
        String fVar = this.f42601a.toString();
        return fVar.startsWith("[") ? fVar : fVar.substring(1, fVar.length() - 1);
    }
}
