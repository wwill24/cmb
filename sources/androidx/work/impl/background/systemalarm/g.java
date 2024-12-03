package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.impl.e;
import androidx.work.impl.e0;
import androidx.work.impl.r;
import androidx.work.impl.w;
import b2.f;
import g2.m;
import h2.a0;
import h2.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class g implements e {

    /* renamed from: l  reason: collision with root package name */
    static final String f7456l = f.i("SystemAlarmDispatcher");

    /* renamed from: a  reason: collision with root package name */
    final Context f7457a;

    /* renamed from: b  reason: collision with root package name */
    final i2.b f7458b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f7459c;

    /* renamed from: d  reason: collision with root package name */
    private final r f7460d;

    /* renamed from: e  reason: collision with root package name */
    private final e0 f7461e;

    /* renamed from: f  reason: collision with root package name */
    final b f7462f;

    /* renamed from: g  reason: collision with root package name */
    final List<Intent> f7463g;

    /* renamed from: h  reason: collision with root package name */
    Intent f7464h;

    /* renamed from: j  reason: collision with root package name */
    private c f7465j;

    /* renamed from: k  reason: collision with root package name */
    private w f7466k;

    class a implements Runnable {
        a() {
        }

        public void run() {
            d dVar;
            Executor executor;
            synchronized (g.this.f7463g) {
                g gVar = g.this;
                gVar.f7464h = gVar.f7463g.get(0);
            }
            Intent intent = g.this.f7464h;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = g.this.f7464h.getIntExtra("KEY_START_ID", 0);
                f e10 = f.e();
                String str = g.f7456l;
                e10.a(str, "Processing command " + g.this.f7464h + ", " + intExtra);
                Context context = g.this.f7457a;
                PowerManager.WakeLock b10 = u.b(context, action + " (" + intExtra + ")");
                try {
                    f e11 = f.e();
                    e11.a(str, "Acquiring operation wake lock (" + action + ") " + b10);
                    b10.acquire();
                    g gVar2 = g.this;
                    gVar2.f7462f.o(gVar2.f7464h, intExtra, gVar2);
                    f e12 = f.e();
                    e12.a(str, "Releasing operation wake lock (" + action + ") " + b10);
                    b10.release();
                    executor = g.this.f7458b.a();
                    dVar = new d(g.this);
                } catch (Throwable th2) {
                    f e13 = f.e();
                    String str2 = g.f7456l;
                    e13.a(str2, "Releasing operation wake lock (" + action + ") " + b10);
                    b10.release();
                    g.this.f7458b.a().execute(new d(g.this));
                    throw th2;
                }
                executor.execute(dVar);
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final g f7468a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f7469b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7470c;

        b(@NonNull g gVar, @NonNull Intent intent, int i10) {
            this.f7468a = gVar;
            this.f7469b = intent;
            this.f7470c = i10;
        }

        public void run() {
            this.f7468a.b(this.f7469b, this.f7470c);
        }
    }

    interface c {
        void b();
    }

    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final g f7471a;

        d(@NonNull g gVar) {
            this.f7471a = gVar;
        }

        public void run() {
            this.f7471a.d();
        }
    }

    g(@NonNull Context context) {
        this(context, (r) null, (e0) null);
    }

    private void c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(@NonNull String str) {
        c();
        synchronized (this.f7463g) {
            for (Intent action : this.f7463g) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void k() {
        c();
        PowerManager.WakeLock b10 = u.b(this.f7457a, "ProcessCommand");
        try {
            b10.acquire();
            this.f7461e.p().c(new a());
        } finally {
            b10.release();
        }
    }

    public void a(@NonNull m mVar, boolean z10) {
        this.f7458b.a().execute(new b(this, b.d(this.f7457a, mVar, z10), 0));
    }

    public boolean b(@NonNull Intent intent, int i10) {
        f e10 = f.e();
        String str = f7456l;
        e10.a(str, "Adding command " + intent + " (" + i10 + ")");
        c();
        String action = intent.getAction();
        boolean z10 = false;
        if (TextUtils.isEmpty(action)) {
            f.e().k(str, "Unknown command. Ignoring");
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i10);
            synchronized (this.f7463g) {
                if (!this.f7463g.isEmpty()) {
                    z10 = true;
                }
                this.f7463g.add(intent);
                if (!z10) {
                    k();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        f e10 = f.e();
        String str = f7456l;
        e10.a(str, "Checking if commands are complete.");
        c();
        synchronized (this.f7463g) {
            if (this.f7464h != null) {
                f e11 = f.e();
                e11.a(str, "Removing command " + this.f7464h);
                if (this.f7463g.remove(0).equals(this.f7464h)) {
                    this.f7464h = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            i2.a b10 = this.f7458b.b();
            if (!this.f7462f.n() && this.f7463g.isEmpty() && !b10.s0()) {
                f.e().a(str, "No more commands & intents.");
                c cVar = this.f7465j;
                if (cVar != null) {
                    cVar.b();
                }
            } else if (!this.f7463g.isEmpty()) {
                k();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public r e() {
        return this.f7460d;
    }

    /* access modifiers changed from: package-private */
    public i2.b f() {
        return this.f7458b;
    }

    /* access modifiers changed from: package-private */
    public e0 g() {
        return this.f7461e;
    }

    /* access modifiers changed from: package-private */
    public a0 h() {
        return this.f7459c;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        f.e().a(f7456l, "Destroying SystemAlarmDispatcher");
        this.f7460d.n(this);
        this.f7465j = null;
    }

    /* access modifiers changed from: package-private */
    public void l(@NonNull c cVar) {
        if (this.f7465j != null) {
            f.e().c(f7456l, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            this.f7465j = cVar;
        }
    }

    g(@NonNull Context context, r rVar, e0 e0Var) {
        Context applicationContext = context.getApplicationContext();
        this.f7457a = applicationContext;
        this.f7466k = new w();
        this.f7462f = new b(applicationContext, this.f7466k);
        e0Var = e0Var == null ? e0.j(context) : e0Var;
        this.f7461e = e0Var;
        this.f7459c = new a0(e0Var.h().k());
        rVar = rVar == null ? e0Var.l() : rVar;
        this.f7460d = rVar;
        this.f7458b = e0Var.p();
        rVar.g(this);
        this.f7463g = new ArrayList();
        this.f7464h = null;
    }
}
