package ed;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import ed.v;
import fd.h;
import fd.j;
import gd.d;
import java.util.concurrent.Executor;
import kd.c;
import ld.o;
import ld.p;
import ld.s;
import ld.t;
import ld.u;
import md.g;
import md.i;
import md.m0;
import md.n0;
import md.u0;

final class e extends v {

    /* renamed from: a  reason: collision with root package name */
    private fk.a<Executor> f40731a;

    /* renamed from: b  reason: collision with root package name */
    private fk.a<Context> f40732b;

    /* renamed from: c  reason: collision with root package name */
    private fk.a f40733c;

    /* renamed from: d  reason: collision with root package name */
    private fk.a f40734d;

    /* renamed from: e  reason: collision with root package name */
    private fk.a f40735e;

    /* renamed from: f  reason: collision with root package name */
    private fk.a<String> f40736f;

    /* renamed from: g  reason: collision with root package name */
    private fk.a<m0> f40737g;

    /* renamed from: h  reason: collision with root package name */
    private fk.a<SchedulerConfig> f40738h;

    /* renamed from: j  reason: collision with root package name */
    private fk.a<u> f40739j;

    /* renamed from: k  reason: collision with root package name */
    private fk.a<c> f40740k;

    /* renamed from: l  reason: collision with root package name */
    private fk.a<o> f40741l;

    /* renamed from: m  reason: collision with root package name */
    private fk.a<s> f40742m;

    /* renamed from: n  reason: collision with root package name */
    private fk.a<u> f40743n;

    private static final class b implements v.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f40744a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.f40744a = (Context) d.b(context);
            return this;
        }

        public v build() {
            d.a(this.f40744a, Context.class);
            return new e(this.f40744a);
        }
    }

    public static v.a c() {
        return new b();
    }

    private void e(Context context) {
        this.f40731a = gd.a.a(k.a());
        gd.b a10 = gd.c.a(context);
        this.f40732b = a10;
        h a11 = h.a(a10, od.c.a(), od.d.a());
        this.f40733c = a11;
        this.f40734d = gd.a.a(j.a(this.f40732b, a11));
        this.f40735e = u0.a(this.f40732b, g.a(), i.a());
        this.f40736f = gd.a.a(md.h.a(this.f40732b));
        this.f40737g = gd.a.a(n0.a(od.c.a(), od.d.a(), md.j.a(), this.f40735e, this.f40736f));
        kd.g b10 = kd.g.b(od.c.a());
        this.f40738h = b10;
        kd.i a12 = kd.i.a(this.f40732b, this.f40737g, b10, od.d.a());
        this.f40739j = a12;
        fk.a<Executor> aVar = this.f40731a;
        fk.a aVar2 = this.f40734d;
        fk.a<m0> aVar3 = this.f40737g;
        this.f40740k = kd.d.a(aVar, aVar2, a12, aVar3, aVar3);
        fk.a<Context> aVar4 = this.f40732b;
        fk.a aVar5 = this.f40734d;
        fk.a<m0> aVar6 = this.f40737g;
        this.f40741l = p.a(aVar4, aVar5, aVar6, this.f40739j, this.f40731a, aVar6, od.c.a(), od.d.a(), this.f40737g);
        fk.a<Executor> aVar7 = this.f40731a;
        fk.a<m0> aVar8 = this.f40737g;
        this.f40742m = t.a(aVar7, aVar8, this.f40739j, aVar8);
        this.f40743n = gd.a.a(w.a(od.c.a(), od.d.a(), this.f40740k, this.f40741l, this.f40742m));
    }

    /* access modifiers changed from: package-private */
    public md.d a() {
        return this.f40737g.get();
    }

    /* access modifiers changed from: package-private */
    public u b() {
        return this.f40743n.get();
    }

    private e(Context context) {
        e(context);
    }
}
