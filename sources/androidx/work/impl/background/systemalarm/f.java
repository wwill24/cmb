package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.work.impl.background.systemalarm.g;
import androidx.work.impl.v;
import com.facebook.AuthenticationTokenClaims;
import d2.c;
import d2.e;
import f2.n;
import g2.m;
import g2.u;
import g2.x;
import h2.a0;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class f implements c, a0.a {

    /* renamed from: n  reason: collision with root package name */
    private static final String f7443n = b2.f.i("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f7444a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7445b;

    /* renamed from: c  reason: collision with root package name */
    private final m f7446c;

    /* renamed from: d  reason: collision with root package name */
    private final g f7447d;

    /* renamed from: e  reason: collision with root package name */
    private final e f7448e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f7449f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private int f7450g = 0;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f7451h;

    /* renamed from: j  reason: collision with root package name */
    private final Executor f7452j;

    /* renamed from: k  reason: collision with root package name */
    private PowerManager.WakeLock f7453k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7454l = false;

    /* renamed from: m  reason: collision with root package name */
    private final v f7455m;

    f(@NonNull Context context, int i10, @NonNull g gVar, @NonNull v vVar) {
        this.f7444a = context;
        this.f7445b = i10;
        this.f7447d = gVar;
        this.f7446c = vVar.a();
        this.f7455m = vVar;
        n n10 = gVar.g().n();
        this.f7451h = gVar.f().b();
        this.f7452j = gVar.f().a();
        this.f7448e = new e(n10, (c) this);
    }

    private void e() {
        synchronized (this.f7449f) {
            this.f7448e.reset();
            this.f7447d.h().b(this.f7446c);
            PowerManager.WakeLock wakeLock = this.f7453k;
            if (wakeLock != null && wakeLock.isHeld()) {
                b2.f e10 = b2.f.e();
                String str = f7443n;
                e10.a(str, "Releasing wakelock " + this.f7453k + "for WorkSpec " + this.f7446c);
                this.f7453k.release();
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.f7450g == 0) {
            this.f7450g = 1;
            b2.f e10 = b2.f.e();
            String str = f7443n;
            e10.a(str, "onAllConstraintsMet for " + this.f7446c);
            if (this.f7447d.e().p(this.f7455m)) {
                this.f7447d.h().a(this.f7446c, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, this);
            } else {
                e();
            }
        } else {
            b2.f e11 = b2.f.e();
            String str2 = f7443n;
            e11.a(str2, "Already started work for " + this.f7446c);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        String b10 = this.f7446c.b();
        if (this.f7450g < 2) {
            this.f7450g = 2;
            b2.f e10 = b2.f.e();
            String str = f7443n;
            e10.a(str, "Stopping work for WorkSpec " + b10);
            this.f7452j.execute(new g.b(this.f7447d, b.f(this.f7444a, this.f7446c), this.f7445b));
            if (this.f7447d.e().k(this.f7446c.b())) {
                b2.f e11 = b2.f.e();
                e11.a(str, "WorkSpec " + b10 + " needs to be rescheduled");
                this.f7452j.execute(new g.b(this.f7447d, b.e(this.f7444a, this.f7446c), this.f7445b));
                return;
            }
            b2.f e12 = b2.f.e();
            e12.a(str, "Processor does not have WorkSpec " + b10 + ". No need to reschedule");
            return;
        }
        b2.f e13 = b2.f.e();
        String str2 = f7443n;
        e13.a(str2, "Already stopped work for " + b10);
    }

    public void a(@NonNull m mVar) {
        b2.f e10 = b2.f.e();
        String str = f7443n;
        e10.a(str, "Exceeded time limits on execution for " + mVar);
        this.f7451h.execute(new d(this));
    }

    public void b(@NonNull List<u> list) {
        this.f7451h.execute(new d(this));
    }

    public void f(@NonNull List<u> list) {
        for (u a10 : list) {
            if (x.a(a10).equals(this.f7446c)) {
                this.f7451h.execute(new e(this));
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        String b10 = this.f7446c.b();
        Context context = this.f7444a;
        this.f7453k = h2.u.b(context, b10 + " (" + this.f7445b + ")");
        b2.f e10 = b2.f.e();
        String str = f7443n;
        e10.a(str, "Acquiring wakelock " + this.f7453k + "for WorkSpec " + b10);
        this.f7453k.acquire();
        u h10 = this.f7447d.g().o().K().h(b10);
        if (h10 == null) {
            this.f7451h.execute(new d(this));
            return;
        }
        boolean h11 = h10.h();
        this.f7454l = h11;
        if (!h11) {
            b2.f e11 = b2.f.e();
            e11.a(str, "No constraints for " + b10);
            f(Collections.singletonList(h10));
            return;
        }
        this.f7448e.a(Collections.singletonList(h10));
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z10) {
        b2.f e10 = b2.f.e();
        String str = f7443n;
        e10.a(str, "onExecuted " + this.f7446c + ", " + z10);
        e();
        if (z10) {
            this.f7452j.execute(new g.b(this.f7447d, b.e(this.f7444a, this.f7446c), this.f7445b));
        }
        if (this.f7454l) {
            this.f7452j.execute(new g.b(this.f7447d, b.b(this.f7444a), this.f7445b));
        }
    }
}
