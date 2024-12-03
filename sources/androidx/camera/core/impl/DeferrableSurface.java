package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicInteger;
import u.f;
import zf.a;

public abstract class DeferrableSurface {

    /* renamed from: i  reason: collision with root package name */
    public static final Size f2399i = new Size(0, 0);

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f2400j = v1.f("DeferrableSurface");

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f2401k = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicInteger f2402l = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private final Object f2403a;

    /* renamed from: b  reason: collision with root package name */
    private int f2404b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2405c;

    /* renamed from: d  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Void> f2406d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Void> f2407e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Size f2408f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2409g;

    /* renamed from: h  reason: collision with root package name */
    Class<?> f2410h;

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(@NonNull String str, @NonNull DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        @NonNull
        public DeferrableSurface a() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(@NonNull String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(f2399i, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object k(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f2403a) {
            this.f2406d = aVar;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(String str) {
        try {
            this.f2407e.get();
            m("Surface terminated", f2402l.decrementAndGet(), f2401k.get());
        } catch (Exception e10) {
            v1.c("DeferrableSurface", "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.f2403a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", new Object[]{this, Boolean.valueOf(this.f2405c), Integer.valueOf(this.f2404b)}), e10);
            }
        }
    }

    private void m(@NonNull String str, int i10, int i11) {
        if (!f2400j && v1.f("DeferrableSurface")) {
            v1.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        v1.a("DeferrableSurface", str + "[total_surfaces=" + i10 + ", used_surfaces=" + i11 + "](" + this + "}");
    }

    public void c() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f2403a) {
            if (!this.f2405c) {
                this.f2405c = true;
                if (this.f2404b == 0) {
                    aVar = this.f2406d;
                    this.f2406d = null;
                } else {
                    aVar = null;
                }
                if (v1.f("DeferrableSurface")) {
                    v1.a("DeferrableSurface", "surface closed,  useCount=" + this.f2404b + " closed=true " + this);
                }
            } else {
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public void d() {
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f2403a) {
            int i10 = this.f2404b;
            if (i10 != 0) {
                int i11 = i10 - 1;
                this.f2404b = i11;
                if (i11 != 0 || !this.f2405c) {
                    aVar = null;
                } else {
                    aVar = this.f2406d;
                    this.f2406d = null;
                }
                if (v1.f("DeferrableSurface")) {
                    v1.a("DeferrableSurface", "use count-1,  useCount=" + this.f2404b + " closed=" + this.f2405c + " " + this);
                    if (this.f2404b == 0) {
                        m("Surface no longer in use", f2402l.get(), f2401k.decrementAndGet());
                    }
                }
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public Class<?> e() {
        return this.f2410h;
    }

    @NonNull
    public Size f() {
        return this.f2408f;
    }

    public int g() {
        return this.f2409g;
    }

    @NonNull
    public final a<Surface> h() {
        synchronized (this.f2403a) {
            if (this.f2405c) {
                a<Surface> f10 = f.f(new SurfaceClosedException("DeferrableSurface already closed.", this));
                return f10;
            }
            a<Surface> n10 = n();
            return n10;
        }
    }

    @NonNull
    public a<Void> i() {
        return f.j(this.f2407e);
    }

    public void j() throws SurfaceClosedException {
        synchronized (this.f2403a) {
            int i10 = this.f2404b;
            if (i10 == 0) {
                if (this.f2405c) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
            }
            this.f2404b = i10 + 1;
            if (v1.f("DeferrableSurface")) {
                if (this.f2404b == 1) {
                    m("New surface in use", f2402l.get(), f2401k.incrementAndGet());
                }
                v1.a("DeferrableSurface", "use count+1, useCount=" + this.f2404b + " " + this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract a<Surface> n();

    public void o(@NonNull Class<?> cls) {
        this.f2410h = cls;
    }

    public DeferrableSurface(@NonNull Size size, int i10) {
        this.f2403a = new Object();
        this.f2404b = 0;
        this.f2405c = false;
        this.f2408f = size;
        this.f2409g = i10;
        a<Void> a10 = CallbackToFutureAdapter.a(new i0(this));
        this.f2407e = a10;
        if (v1.f("DeferrableSurface")) {
            m("Surface created", f2402l.incrementAndGet(), f2401k.get());
            a10.addListener(new j0(this, Log.getStackTraceString(new Exception())), androidx.camera.core.impl.utils.executor.a.a());
        }
    }
}
