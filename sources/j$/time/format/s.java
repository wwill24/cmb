package j$.time.format;

import com.mparticle.kits.AppsFlyerKit;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.o;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

final class s implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private final m f42665a;

    /* renamed from: b  reason: collision with root package name */
    private final H f42666b;

    /* renamed from: c  reason: collision with root package name */
    private final C f42667c;

    /* renamed from: d  reason: collision with root package name */
    private volatile k f42668d;

    s(m mVar, H h10, C c10) {
        this.f42665a = mVar;
        this.f42666b = h10;
        this.f42667c = c10;
    }

    public final boolean b(A a10, StringBuilder sb2) {
        String str;
        g gVar;
        Long e10 = a10.e(this.f42665a);
        if (e10 == null) {
            return false;
        }
        f fVar = (f) a10.d().k(o.a());
        if (fVar == null || fVar == (gVar = g.f42585a)) {
            str = this.f42667c.d(this.f42665a, e10.longValue(), this.f42666b, a10.c());
        } else {
            C c10 = this.f42667c;
            m mVar = this.f42665a;
            long longValue = e10.longValue();
            H h10 = this.f42666b;
            Locale c11 = a10.c();
            c10.getClass();
            str = (fVar == gVar || !(mVar instanceof a)) ? c10.d(mVar, longValue, h10, c11) : null;
        }
        if (str == null) {
            if (this.f42668d == null) {
                this.f42668d = new k(this.f42665a, 1, 19, 1);
            }
            return this.f42668d.b(a10, sb2);
        }
        sb2.append(str);
        return true;
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        g gVar;
        int length = charSequence.length();
        if (i10 < 0 || i10 > length) {
            throw new IndexOutOfBoundsException();
        }
        Iterator it = null;
        H h10 = xVar.l() ? this.f42666b : null;
        f h11 = xVar.h();
        if (h11 == null || h11 == (gVar = g.f42585a)) {
            it = this.f42667c.e(this.f42665a, h10, xVar.i());
        } else {
            C c10 = this.f42667c;
            m mVar = this.f42665a;
            Locale i11 = xVar.i();
            c10.getClass();
            if (h11 == gVar || !(mVar instanceof a)) {
                it = c10.e(mVar, h10, i11);
            }
        }
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (xVar.s(str, 0, charSequence, i10, str.length())) {
                    return xVar.o(this.f42665a, ((Long) entry.getValue()).longValue(), i10, str.length() + i10);
                }
            }
            if (xVar.l()) {
                return ~i10;
            }
        }
        if (this.f42668d == null) {
            this.f42668d = new k(this.f42665a, 1, 19, 1);
        }
        return this.f42668d.d(xVar, charSequence, i10);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2;
        if (this.f42666b == H.FULL) {
            sb2 = j$.time.a.a("Text(");
            obj = this.f42665a;
        } else {
            sb2 = j$.time.a.a("Text(");
            sb2.append(this.f42665a);
            sb2.append(AppsFlyerKit.COMMA);
            obj = this.f42666b;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
