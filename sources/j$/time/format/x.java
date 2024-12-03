package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import j$.time.temporal.m;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.jivesoftware.smackx.xdata.FormField;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private DateTimeFormatter f42689a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f42690b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42691c = true;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f42692d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f42693e;

    x(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f42692d = arrayList;
        this.f42693e = null;
        this.f42689a = dateTimeFormatter;
        arrayList.add(new E());
    }

    static boolean c(char c10, char c11) {
        return c10 == c11 || Character.toUpperCase(c10) == Character.toUpperCase(c11) || Character.toLowerCase(c10) == Character.toLowerCase(c11);
    }

    private E e() {
        ArrayList arrayList = this.f42692d;
        return (E) arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public final void a(p pVar) {
        if (this.f42693e == null) {
            this.f42693e = new ArrayList();
        }
        this.f42693e.add(pVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean b(char c10, char c11) {
        return this.f42690b ? c10 == c11 : c(c10, c11);
    }

    /* access modifiers changed from: package-private */
    public final x d() {
        x xVar = new x(this.f42689a);
        xVar.f42690b = this.f42690b;
        xVar.f42691c = this.f42691c;
        return xVar;
    }

    /* access modifiers changed from: package-private */
    public final void f(boolean z10) {
        ArrayList arrayList;
        int i10;
        if (z10) {
            arrayList = this.f42692d;
            i10 = arrayList.size() - 2;
        } else {
            arrayList = this.f42692d;
            i10 = arrayList.size() - 1;
        }
        arrayList.remove(i10);
    }

    /* access modifiers changed from: package-private */
    public final D g() {
        return this.f42689a.c();
    }

    /* access modifiers changed from: package-private */
    public final f h() {
        f fVar = e().f42610c;
        if (fVar != null) {
            return fVar;
        }
        f b10 = this.f42689a.b();
        return b10 == null ? g.f42585a : b10;
    }

    /* access modifiers changed from: package-private */
    public final Locale i() {
        return this.f42689a.d();
    }

    /* access modifiers changed from: package-private */
    public final Long j(a aVar) {
        return (Long) e().f42608a.get(aVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f42690b;
    }

    /* access modifiers changed from: package-private */
    public final boolean l() {
        return this.f42691c;
    }

    /* access modifiers changed from: package-private */
    public final void m(boolean z10) {
        this.f42690b = z10;
    }

    /* access modifiers changed from: package-private */
    public final void n(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        e().f42609b = zoneId;
    }

    /* access modifiers changed from: package-private */
    public final int o(m mVar, long j10, int i10, int i11) {
        Objects.requireNonNull(mVar, FormField.ELEMENT);
        Long l10 = (Long) e().f42608a.put(mVar, Long.valueOf(j10));
        return (l10 == null || l10.longValue() == j10) ? i11 : ~i10;
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        e().getClass();
    }

    /* access modifiers changed from: package-private */
    public final void q(boolean z10) {
        this.f42691c = z10;
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        ArrayList arrayList = this.f42692d;
        E e10 = e();
        e10.getClass();
        E e11 = new E();
        e11.f42608a.putAll(e10.f42608a);
        e11.f42609b = e10.f42609b;
        e11.f42610c = e10.f42610c;
        arrayList.add(e11);
    }

    /* access modifiers changed from: package-private */
    public final boolean s(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12) {
        if (i10 + i12 > charSequence.length() || i11 + i12 > charSequence2.length()) {
            return false;
        }
        if (this.f42690b) {
            for (int i13 = 0; i13 < i12; i13++) {
                if (charSequence.charAt(i10 + i13) != charSequence2.charAt(i11 + i13)) {
                    return false;
                }
            }
            return true;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            char charAt = charSequence.charAt(i10 + i14);
            char charAt2 = charSequence2.charAt(i11 + i14);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final TemporalAccessor t(F f10, Set set) {
        E e10 = e();
        e10.f42610c = h();
        ZoneId zoneId = e10.f42609b;
        if (zoneId == null) {
            zoneId = this.f42689a.e();
        }
        e10.f42609b = zoneId;
        e10.h(f10, set);
        return e10;
    }

    public final String toString() {
        return e().toString();
    }
}
