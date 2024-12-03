package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import b2.d;
import b2.f;
import g2.m;
import g2.u;
import g2.v;
import h2.n;
import h2.t;
import h2.x;
import h2.y;
import h2.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class h0 implements Runnable {

    /* renamed from: y  reason: collision with root package name */
    static final String f7536y = f.i("WorkerWrapper");

    /* renamed from: a  reason: collision with root package name */
    Context f7537a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7538b;

    /* renamed from: c  reason: collision with root package name */
    private List<t> f7539c;

    /* renamed from: d  reason: collision with root package name */
    private WorkerParameters.a f7540d;

    /* renamed from: e  reason: collision with root package name */
    u f7541e;

    /* renamed from: f  reason: collision with root package name */
    androidx.work.c f7542f;

    /* renamed from: g  reason: collision with root package name */
    i2.b f7543g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    c.a f7544h = c.a.a();

    /* renamed from: j  reason: collision with root package name */
    private androidx.work.a f7545j;

    /* renamed from: k  reason: collision with root package name */
    private androidx.work.impl.foreground.a f7546k;

    /* renamed from: l  reason: collision with root package name */
    private WorkDatabase f7547l;

    /* renamed from: m  reason: collision with root package name */
    private v f7548m;

    /* renamed from: n  reason: collision with root package name */
    private g2.b f7549n;

    /* renamed from: p  reason: collision with root package name */
    private List<String> f7550p;

    /* renamed from: q  reason: collision with root package name */
    private String f7551q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    androidx.work.impl.utils.futures.a<Boolean> f7552t = androidx.work.impl.utils.futures.a.s();
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    final androidx.work.impl.utils.futures.a<c.a> f7553w = androidx.work.impl.utils.futures.a.s();

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f7554x;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ zf.a f7555a;

        a(zf.a aVar) {
            this.f7555a = aVar;
        }

        public void run() {
            if (!h0.this.f7553w.isCancelled()) {
                try {
                    this.f7555a.get();
                    f e10 = f.e();
                    String str = h0.f7536y;
                    e10.a(str, "Starting work for " + h0.this.f7541e.f15079c);
                    h0 h0Var = h0.this;
                    h0Var.f7553w.q(h0Var.f7542f.m());
                } catch (Throwable th2) {
                    h0.this.f7553w.p(th2);
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7557a;

        b(String str) {
            this.f7557a = str;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                c.a aVar = h0.this.f7553w.get();
                if (aVar == null) {
                    f e10 = f.e();
                    String str = h0.f7536y;
                    e10.c(str, h0.this.f7541e.f15079c + " returned a null result. Treating it as a failure.");
                } else {
                    f e11 = f.e();
                    String str2 = h0.f7536y;
                    e11.a(str2, h0.this.f7541e.f15079c + " returned a " + aVar + ".");
                    h0.this.f7544h = aVar;
                }
            } catch (CancellationException e12) {
                f e13 = f.e();
                String str3 = h0.f7536y;
                e13.g(str3, this.f7557a + " was cancelled", e12);
            } catch (InterruptedException | ExecutionException e14) {
                f e15 = f.e();
                String str4 = h0.f7536y;
                e15.d(str4, this.f7557a + " failed because it threw an exception/error", e14);
            } catch (Throwable th2) {
                h0.this.j();
                throw th2;
            }
            h0.this.j();
        }
    }

    public static class c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        Context f7559a;

        /* renamed from: b  reason: collision with root package name */
        androidx.work.c f7560b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        androidx.work.impl.foreground.a f7561c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        i2.b f7562d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        androidx.work.a f7563e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f7564f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        u f7565g;

        /* renamed from: h  reason: collision with root package name */
        List<t> f7566h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final List<String> f7567i;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        WorkerParameters.a f7568j = new WorkerParameters.a();

        public c(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull i2.b bVar, @NonNull androidx.work.impl.foreground.a aVar2, @NonNull WorkDatabase workDatabase, @NonNull u uVar, @NonNull List<String> list) {
            this.f7559a = context.getApplicationContext();
            this.f7562d = bVar;
            this.f7561c = aVar2;
            this.f7563e = aVar;
            this.f7564f = workDatabase;
            this.f7565g = uVar;
            this.f7567i = list;
        }

        @NonNull
        public h0 b() {
            return new h0(this);
        }

        @NonNull
        public c c(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f7568j = aVar;
            }
            return this;
        }

        @NonNull
        public c d(@NonNull List<t> list) {
            this.f7566h = list;
            return this;
        }
    }

    h0(@NonNull c cVar) {
        this.f7537a = cVar.f7559a;
        this.f7543g = cVar.f7562d;
        this.f7546k = cVar.f7561c;
        u uVar = cVar.f7565g;
        this.f7541e = uVar;
        this.f7538b = uVar.f15077a;
        this.f7539c = cVar.f7566h;
        this.f7540d = cVar.f7568j;
        this.f7542f = cVar.f7560b;
        this.f7545j = cVar.f7563e;
        WorkDatabase workDatabase = cVar.f7564f;
        this.f7547l = workDatabase;
        this.f7548m = workDatabase.K();
        this.f7549n = this.f7547l.F();
        this.f7550p = cVar.f7567i;
    }

    private String b(List<String> list) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.f7538b);
        sb2.append(", tags={ ");
        boolean z10 = true;
        for (String next : list) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(next);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    private void f(c.a aVar) {
        if (aVar instanceof c.a.C0083c) {
            f e10 = f.e();
            String str = f7536y;
            e10.f(str, "Worker result SUCCESS for " + this.f7551q);
            if (this.f7541e.j()) {
                l();
            } else {
                q();
            }
        } else if (aVar instanceof c.a.b) {
            f e11 = f.e();
            String str2 = f7536y;
            e11.f(str2, "Worker result RETRY for " + this.f7551q);
            k();
        } else {
            f e12 = f.e();
            String str3 = f7536y;
            e12.f(str3, "Worker result FAILURE for " + this.f7551q);
            if (this.f7541e.j()) {
                l();
            } else {
                p();
            }
        }
    }

    private void h(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f7548m.g(str2) != WorkInfo.State.CANCELLED) {
                this.f7548m.p(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f7549n.a(str2));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(zf.a aVar) {
        if (this.f7553w.isCancelled()) {
            aVar.cancel(true);
        }
    }

    private void k() {
        this.f7547l.e();
        try {
            this.f7548m.p(WorkInfo.State.ENQUEUED, this.f7538b);
            this.f7548m.i(this.f7538b, System.currentTimeMillis());
            this.f7548m.m(this.f7538b, -1);
            this.f7547l.C();
        } finally {
            this.f7547l.j();
            m(true);
        }
    }

    private void l() {
        this.f7547l.e();
        try {
            this.f7548m.i(this.f7538b, System.currentTimeMillis());
            this.f7548m.p(WorkInfo.State.ENQUEUED, this.f7538b);
            this.f7548m.t(this.f7538b);
            this.f7548m.b(this.f7538b);
            this.f7548m.m(this.f7538b, -1);
            this.f7547l.C();
        } finally {
            this.f7547l.j();
            m(false);
        }
    }

    /* JADX INFO: finally extract failed */
    private void m(boolean z10) {
        this.f7547l.e();
        try {
            if (!this.f7547l.K().s()) {
                n.a(this.f7537a, RescheduleReceiver.class, false);
            }
            if (z10) {
                this.f7548m.p(WorkInfo.State.ENQUEUED, this.f7538b);
                this.f7548m.m(this.f7538b, -1);
            }
            if (!(this.f7541e == null || this.f7542f == null || !this.f7546k.c(this.f7538b))) {
                this.f7546k.b(this.f7538b);
            }
            this.f7547l.C();
            this.f7547l.j();
            this.f7552t.o(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            this.f7547l.j();
            throw th2;
        }
    }

    private void n() {
        WorkInfo.State g10 = this.f7548m.g(this.f7538b);
        if (g10 == WorkInfo.State.RUNNING) {
            f e10 = f.e();
            String str = f7536y;
            e10.a(str, "Status for " + this.f7538b + " is RUNNING; not doing any work and rescheduling for later execution");
            m(true);
            return;
        }
        f e11 = f.e();
        String str2 = f7536y;
        e11.a(str2, "Status for " + this.f7538b + " is " + g10 + " ; not doing any work");
        m(false);
    }

    private void o() {
        androidx.work.b b10;
        if (!r()) {
            this.f7547l.e();
            try {
                u uVar = this.f7541e;
                if (uVar.f15078b != WorkInfo.State.ENQUEUED) {
                    n();
                    this.f7547l.C();
                    f e10 = f.e();
                    String str = f7536y;
                    e10.a(str, this.f7541e.f15079c + " is not in ENQUEUED state. Nothing more to do");
                } else if ((uVar.j() || this.f7541e.i()) && System.currentTimeMillis() < this.f7541e.c()) {
                    f.e().a(f7536y, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f7541e.f15079c}));
                    m(true);
                    this.f7547l.C();
                    this.f7547l.j();
                } else {
                    this.f7547l.C();
                    this.f7547l.j();
                    if (this.f7541e.j()) {
                        b10 = this.f7541e.f15081e;
                    } else {
                        d b11 = this.f7545j.f().b(this.f7541e.f15080d);
                        if (b11 == null) {
                            f e11 = f.e();
                            String str2 = f7536y;
                            e11.c(str2, "Could not create Input Merger " + this.f7541e.f15080d);
                            p();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f7541e.f15081e);
                        arrayList.addAll(this.f7548m.j(this.f7538b));
                        b10 = b11.b(arrayList);
                    }
                    androidx.work.b bVar = b10;
                    UUID fromString = UUID.fromString(this.f7538b);
                    List<String> list = this.f7550p;
                    WorkerParameters.a aVar = this.f7540d;
                    u uVar2 = this.f7541e;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, bVar, list, aVar, uVar2.f15087k, uVar2.f(), this.f7545j.d(), this.f7543g, this.f7545j.n(), new z(this.f7547l, this.f7543g), new y(this.f7547l, this.f7546k, this.f7543g));
                    if (this.f7542f == null) {
                        this.f7542f = this.f7545j.n().b(this.f7537a, this.f7541e.f15079c, workerParameters);
                    }
                    androidx.work.c cVar = this.f7542f;
                    if (cVar == null) {
                        f e12 = f.e();
                        String str3 = f7536y;
                        e12.c(str3, "Could not create Worker " + this.f7541e.f15079c);
                        p();
                    } else if (cVar.j()) {
                        f e13 = f.e();
                        String str4 = f7536y;
                        e13.c(str4, "Received an already-used Worker " + this.f7541e.f15079c + "; Worker Factory should return new instances");
                        p();
                    } else {
                        this.f7542f.l();
                        if (!s()) {
                            n();
                        } else if (!r()) {
                            x xVar = new x(this.f7537a, this.f7541e, this.f7542f, workerParameters.b(), this.f7543g);
                            this.f7543g.a().execute(xVar);
                            zf.a<Void> b12 = xVar.b();
                            this.f7553w.addListener(new g0(this, b12), new t());
                            b12.addListener(new a(b12), this.f7543g.a());
                            this.f7553w.addListener(new b(this.f7551q), this.f7543g.b());
                        }
                    }
                }
            } finally {
                this.f7547l.j();
            }
        }
    }

    private void q() {
        this.f7547l.e();
        try {
            this.f7548m.p(WorkInfo.State.SUCCEEDED, this.f7538b);
            this.f7548m.q(this.f7538b, ((c.a.C0083c) this.f7544h).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.f7549n.a(this.f7538b)) {
                if (this.f7548m.g(next) == WorkInfo.State.BLOCKED && this.f7549n.c(next)) {
                    f e10 = f.e();
                    String str = f7536y;
                    e10.f(str, "Setting status to enqueued for " + next);
                    this.f7548m.p(WorkInfo.State.ENQUEUED, next);
                    this.f7548m.i(next, currentTimeMillis);
                }
            }
            this.f7547l.C();
        } finally {
            this.f7547l.j();
            m(false);
        }
    }

    private boolean r() {
        if (!this.f7554x) {
            return false;
        }
        f e10 = f.e();
        String str = f7536y;
        e10.a(str, "Work interrupted for " + this.f7551q);
        WorkInfo.State g10 = this.f7548m.g(this.f7538b);
        if (g10 == null) {
            m(false);
        } else {
            m(!g10.b());
        }
        return true;
    }

    private boolean s() {
        boolean z10;
        this.f7547l.e();
        try {
            if (this.f7548m.g(this.f7538b) == WorkInfo.State.ENQUEUED) {
                this.f7548m.p(WorkInfo.State.RUNNING, this.f7538b);
                this.f7548m.u(this.f7538b);
                z10 = true;
            } else {
                z10 = false;
            }
            this.f7547l.C();
            return z10;
        } finally {
            this.f7547l.j();
        }
    }

    @NonNull
    public zf.a<Boolean> c() {
        return this.f7552t;
    }

    @NonNull
    public m d() {
        return g2.x.a(this.f7541e);
    }

    @NonNull
    public u e() {
        return this.f7541e;
    }

    public void g() {
        this.f7554x = true;
        r();
        this.f7553w.cancel(true);
        if (this.f7542f == null || !this.f7553w.isCancelled()) {
            f.e().a(f7536y, "WorkSpec " + this.f7541e + " is already done. Not interrupting.");
            return;
        }
        this.f7542f.n();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (!r()) {
            this.f7547l.e();
            try {
                WorkInfo.State g10 = this.f7548m.g(this.f7538b);
                this.f7547l.J().a(this.f7538b);
                if (g10 == null) {
                    m(false);
                } else if (g10 == WorkInfo.State.RUNNING) {
                    f(this.f7544h);
                } else if (!g10.b()) {
                    k();
                }
                this.f7547l.C();
            } finally {
                this.f7547l.j();
            }
        }
        List<t> list = this.f7539c;
        if (list != null) {
            for (t c10 : list) {
                c10.c(this.f7538b);
            }
            u.b(this.f7545j, this.f7547l, this.f7539c);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f7547l.e();
        try {
            h(this.f7538b);
            this.f7548m.q(this.f7538b, ((c.a.C0082a) this.f7544h).e());
            this.f7547l.C();
        } finally {
            this.f7547l.j();
            m(false);
        }
    }

    public void run() {
        this.f7551q = b(this.f7550p);
        o();
    }
}
