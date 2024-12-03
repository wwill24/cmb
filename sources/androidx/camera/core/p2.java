package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.w1;
import androidx.camera.core.impl.x0;
import java.util.concurrent.ScheduledExecutorService;
import u.c;
import u.d;
import u.f;

final class p2 extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    final Object f2855m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private final x0.a f2856n;

    /* renamed from: o  reason: collision with root package name */
    boolean f2857o;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private final Size f2858p;

    /* renamed from: q  reason: collision with root package name */
    private final y1 f2859q;

    /* renamed from: r  reason: collision with root package name */
    private final Surface f2860r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f2861s;

    /* renamed from: t  reason: collision with root package name */
    final f0 f2862t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    final e0 f2863u;

    /* renamed from: v  reason: collision with root package name */
    private final n f2864v;

    /* renamed from: w  reason: collision with root package name */
    private final DeferrableSurface f2865w;

    /* renamed from: x  reason: collision with root package name */
    private String f2866x;

    class a implements c<Surface> {
        a() {
        }

        /* renamed from: a */
        public void onSuccess(Surface surface) {
            synchronized (p2.this.f2855m) {
                p2.this.f2863u.a(surface, 1);
            }
        }

        public void onFailure(@NonNull Throwable th2) {
            v1.d("ProcessingSurfaceTextur", "Failed to extract Listenable<Surface>.", th2);
        }
    }

    p2(int i10, int i11, int i12, Handler handler, @NonNull f0 f0Var, @NonNull e0 e0Var, @NonNull DeferrableSurface deferrableSurface, @NonNull String str) {
        super(new Size(i10, i11), i12);
        m2 m2Var = new m2(this);
        this.f2856n = m2Var;
        this.f2857o = false;
        Size size = new Size(i10, i11);
        this.f2858p = size;
        if (handler != null) {
            this.f2861s = handler;
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.f2861s = new Handler(myLooper);
            } else {
                throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            }
        }
        ScheduledExecutorService e10 = androidx.camera.core.impl.utils.executor.a.e(this.f2861s);
        y1 y1Var = new y1(i10, i11, i12, 2);
        this.f2859q = y1Var;
        y1Var.f(m2Var, e10);
        this.f2860r = y1Var.getSurface();
        this.f2864v = y1Var.m();
        this.f2863u = e0Var;
        e0Var.c(size);
        this.f2862t = f0Var;
        this.f2865w = deferrableSurface;
        this.f2866x = str;
        f.b(deferrableSurface.h(), new a(), androidx.camera.core.impl.utils.executor.a.a());
        i().addListener(new n2(this), androidx.camera.core.impl.utils.executor.a.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(x0 x0Var) {
        synchronized (this.f2855m) {
            t(x0Var);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Surface v(Surface surface) {
        return this.f2860r;
    }

    /* access modifiers changed from: private */
    public void w() {
        synchronized (this.f2855m) {
            if (!this.f2857o) {
                this.f2859q.d();
                this.f2859q.close();
                this.f2860r.release();
                this.f2865w.c();
                this.f2857o = true;
            }
        }
    }

    @NonNull
    public zf.a<Surface> n() {
        return d.a(this.f2865w.h()).d(new o2(this), androidx.camera.core.impl.utils.executor.a.a());
    }

    /* access modifiers changed from: package-private */
    public n s() {
        n nVar;
        synchronized (this.f2855m) {
            if (!this.f2857o) {
                nVar = this.f2864v;
            } else {
                throw new IllegalStateException("ProcessingSurface already released!");
            }
        }
        return nVar;
    }

    /* access modifiers changed from: package-private */
    public void t(x0 x0Var) {
        if (!this.f2857o) {
            o1 o1Var = null;
            try {
                o1Var = x0Var.g();
            } catch (IllegalStateException e10) {
                v1.d("ProcessingSurfaceTextur", "Failed to acquire next image.", e10);
            }
            if (o1Var != null) {
                l1 z12 = o1Var.z1();
                if (z12 == null) {
                    o1Var.close();
                    return;
                }
                Integer num = (Integer) z12.c().c(this.f2866x);
                if (num == null) {
                    o1Var.close();
                } else if (this.f2862t.getId() != num.intValue()) {
                    v1.l("ProcessingSurfaceTextur", "ImageProxyBundle does not contain this id: " + num);
                    o1Var.close();
                } else {
                    w1 w1Var = new w1(o1Var, this.f2866x);
                    try {
                        j();
                        this.f2863u.d(w1Var);
                        w1Var.c();
                        d();
                    } catch (DeferrableSurface.SurfaceClosedException unused) {
                        v1.a("ProcessingSurfaceTextur", "The ProcessingSurface has been closed. Don't process the incoming image.");
                        w1Var.c();
                    }
                }
            }
        }
    }
}
