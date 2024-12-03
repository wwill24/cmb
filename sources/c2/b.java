package c2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.a;
import androidx.work.impl.e;
import androidx.work.impl.e0;
import androidx.work.impl.t;
import androidx.work.impl.v;
import androidx.work.impl.w;
import b2.f;
import com.mparticle.kits.AppsFlyerKit;
import d2.c;
import d2.d;
import f2.n;
import g2.m;
import g2.u;
import g2.x;
import h2.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b implements t, c, e {

    /* renamed from: k  reason: collision with root package name */
    private static final String f7914k = f.i("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f7915a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f7916b;

    /* renamed from: c  reason: collision with root package name */
    private final d f7917c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<u> f7918d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private a f7919e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7920f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f7921g;

    /* renamed from: h  reason: collision with root package name */
    private final w f7922h = new w();

    /* renamed from: j  reason: collision with root package name */
    Boolean f7923j;

    public b(@NonNull Context context, @NonNull a aVar, @NonNull n nVar, @NonNull e0 e0Var) {
        this.f7915a = context;
        this.f7916b = e0Var;
        this.f7917c = new d2.e(nVar, (c) this);
        this.f7919e = new a(this, aVar.k());
        this.f7921g = new Object();
    }

    private void g() {
        this.f7923j = Boolean.valueOf(p.b(this.f7915a, this.f7916b.h()));
    }

    private void h() {
        if (!this.f7920f) {
            this.f7916b.l().g(this);
            this.f7920f = true;
        }
    }

    private void i(@NonNull m mVar) {
        synchronized (this.f7921g) {
            Iterator<u> it = this.f7918d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                u next = it.next();
                if (x.a(next).equals(mVar)) {
                    f e10 = f.e();
                    String str = f7914k;
                    e10.a(str, "Stopping tracking for " + mVar);
                    this.f7918d.remove(next);
                    this.f7917c.a(this.f7918d);
                    break;
                }
            }
        }
    }

    public void a(@NonNull m mVar, boolean z10) {
        this.f7922h.b(mVar);
        i(mVar);
    }

    public void b(@NonNull List<u> list) {
        for (u a10 : list) {
            m a11 = x.a(a10);
            f e10 = f.e();
            String str = f7914k;
            e10.a(str, "Constraints not met: Cancelling work ID " + a11);
            v b10 = this.f7922h.b(a11);
            if (b10 != null) {
                this.f7916b.x(b10);
            }
        }
    }

    public void c(@NonNull String str) {
        if (this.f7923j == null) {
            g();
        }
        if (!this.f7923j.booleanValue()) {
            f.e().f(f7914k, "Ignoring schedule request in non-main process");
            return;
        }
        h();
        f e10 = f.e();
        String str2 = f7914k;
        e10.a(str2, "Cancelling work ID " + str);
        a aVar = this.f7919e;
        if (aVar != null) {
            aVar.b(str);
        }
        for (v x10 : this.f7922h.c(str)) {
            this.f7916b.x(x10);
        }
    }

    public void d(@NonNull u... uVarArr) {
        if (this.f7923j == null) {
            g();
        }
        if (!this.f7923j.booleanValue()) {
            f.e().f(f7914k, "Ignoring schedule request in a secondary process");
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (u uVar : uVarArr) {
            if (!this.f7922h.a(x.a(uVar))) {
                long c10 = uVar.c();
                long currentTimeMillis = System.currentTimeMillis();
                if (uVar.f15078b == WorkInfo.State.ENQUEUED) {
                    if (currentTimeMillis < c10) {
                        a aVar = this.f7919e;
                        if (aVar != null) {
                            aVar.a(uVar);
                        }
                    } else if (uVar.h()) {
                        if (uVar.f15086j.h()) {
                            f.e().a(f7914k, "Ignoring " + uVar + ". Requires device idle.");
                        } else if (uVar.f15086j.e()) {
                            f.e().a(f7914k, "Ignoring " + uVar + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(uVar);
                            hashSet2.add(uVar.f15077a);
                        }
                    } else if (!this.f7922h.a(x.a(uVar))) {
                        f.e().a(f7914k, "Starting work for " + uVar.f15077a);
                        this.f7916b.u(this.f7922h.e(uVar));
                    }
                }
            }
        }
        synchronized (this.f7921g) {
            if (!hashSet.isEmpty()) {
                String join = TextUtils.join(AppsFlyerKit.COMMA, hashSet2);
                f.e().a(f7914k, "Starting tracking for " + join);
                this.f7918d.addAll(hashSet);
                this.f7917c.a(this.f7918d);
            }
        }
    }

    public boolean e() {
        return false;
    }

    public void f(@NonNull List<u> list) {
        for (u a10 : list) {
            m a11 = x.a(a10);
            if (!this.f7922h.a(a11)) {
                f e10 = f.e();
                String str = f7914k;
                e10.a(str, "Constraints met: Scheduling work ID " + a11);
                this.f7916b.u(this.f7922h.d(a11));
            }
        }
    }
}
