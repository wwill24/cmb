package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class SurfaceRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2102a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f2103b;

    /* renamed from: c  reason: collision with root package name */
    private final Range<Integer> f2104c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2105d;

    /* renamed from: e  reason: collision with root package name */
    private final CameraInternal f2106e;

    /* renamed from: f  reason: collision with root package name */
    final zf.a<Surface> f2107f;

    /* renamed from: g  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Surface> f2108g;

    /* renamed from: h  reason: collision with root package name */
    private final zf.a<Void> f2109h;

    /* renamed from: i  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Void> f2110i;

    /* renamed from: j  reason: collision with root package name */
    private final DeferrableSurface f2111j;

    /* renamed from: k  reason: collision with root package name */
    private f f2112k;

    /* renamed from: l  reason: collision with root package name */
    private g f2113l;

    /* renamed from: m  reason: collision with root package name */
    private Executor f2114m;

    private static final class RequestCancelledException extends RuntimeException {
        RequestCancelledException(@NonNull String str, @NonNull Throwable th2) {
            super(str, th2);
        }
    }

    class a implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f2115a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ zf.a f2116b;

        a(CallbackToFutureAdapter.a aVar, zf.a aVar2) {
            this.f2115a = aVar;
            this.f2116b = aVar2;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            h.i(this.f2115a.c(null));
        }

        public void onFailure(@NonNull Throwable th2) {
            if (th2 instanceof RequestCancelledException) {
                h.i(this.f2116b.cancel(false));
            } else {
                h.i(this.f2115a.c(null));
            }
        }
    }

    class b extends DeferrableSurface {
        b(Size size, int i10) {
            super(size, i10);
        }

        /* access modifiers changed from: protected */
        @NonNull
        public zf.a<Surface> n() {
            return SurfaceRequest.this.f2107f;
        }
    }

    class c implements u.c<Surface> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ zf.a f2119a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f2120b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f2121c;

        c(zf.a aVar, CallbackToFutureAdapter.a aVar2, String str) {
            this.f2119a = aVar;
            this.f2120b = aVar2;
            this.f2121c = str;
        }

        /* renamed from: a */
        public void onSuccess(Surface surface) {
            u.f.k(this.f2119a, this.f2120b);
        }

        public void onFailure(@NonNull Throwable th2) {
            if (th2 instanceof CancellationException) {
                CallbackToFutureAdapter.a aVar = this.f2120b;
                h.i(aVar.f(new RequestCancelledException(this.f2121c + " cancelled.", th2)));
                return;
            }
            this.f2120b.c(null);
        }
    }

    class d implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.core.util.a f2123a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Surface f2124b;

        d(androidx.core.util.a aVar, Surface surface) {
            this.f2123a = aVar;
            this.f2124b = surface;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f2123a.accept(e.c(0, this.f2124b));
        }

        public void onFailure(@NonNull Throwable th2) {
            h.j(th2 instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th2);
            this.f2123a.accept(e.c(1, this.f2124b));
        }
    }

    public static abstract class e {
        e() {
        }

        @NonNull
        static e c(int i10, @NonNull Surface surface) {
            return new j(i10, surface);
        }

        public abstract int a();

        @NonNull
        public abstract Surface b();
    }

    public static abstract class f {
        f() {
        }

        @NonNull
        public static f d(@NonNull Rect rect, int i10, int i11) {
            return new k(rect, i10, i11);
        }

        @NonNull
        public abstract Rect a();

        public abstract int b();

        public abstract int c();
    }

    public interface g {
        void a(@NonNull f fVar);
    }

    public SurfaceRequest(@NonNull Size size, @NonNull CameraInternal cameraInternal, boolean z10) {
        this(size, cameraInternal, z10, (Range<Integer>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f2107f.cancel(true);
    }

    @SuppressLint({"PairedRegistration"})
    public void i(@NonNull Executor executor, @NonNull Runnable runnable) {
        this.f2110i.a(runnable, executor);
    }

    @NonNull
    public CameraInternal j() {
        return this.f2106e;
    }

    @NonNull
    public DeferrableSurface k() {
        return this.f2111j;
    }

    public Range<Integer> l() {
        return this.f2104c;
    }

    @NonNull
    public Size m() {
        return this.f2103b;
    }

    public boolean n() {
        return this.f2105d;
    }

    public void w(@NonNull Surface surface, @NonNull Executor executor, @NonNull androidx.core.util.a<e> aVar) {
        if (this.f2108g.c(surface) || this.f2107f.isCancelled()) {
            u.f.b(this.f2109h, new d(aVar, surface), executor);
            return;
        }
        h.i(this.f2107f.isDone());
        try {
            this.f2107f.get();
            executor.execute(new c3(aVar, surface));
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new d3(aVar, surface));
        }
    }

    public void x(@NonNull Executor executor, @NonNull g gVar) {
        f fVar;
        synchronized (this.f2102a) {
            this.f2113l = gVar;
            this.f2114m = executor;
            fVar = this.f2112k;
        }
        if (fVar != null) {
            executor.execute(new e3(gVar, fVar));
        }
    }

    public void y(@NonNull f fVar) {
        g gVar;
        Executor executor;
        synchronized (this.f2102a) {
            this.f2112k = fVar;
            gVar = this.f2113l;
            executor = this.f2114m;
        }
        if (gVar != null && executor != null) {
            executor.execute(new b3(gVar, fVar));
        }
    }

    public boolean z() {
        return this.f2108g.f(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public SurfaceRequest(@NonNull Size size, @NonNull CameraInternal cameraInternal, boolean z10, Range<Integer> range) {
        this.f2102a = new Object();
        this.f2103b = size;
        this.f2106e = cameraInternal;
        this.f2105d = z10;
        this.f2104c = range;
        String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        AtomicReference atomicReference = new AtomicReference((Object) null);
        zf.a a10 = CallbackToFutureAdapter.a(new x2(atomicReference, str));
        CallbackToFutureAdapter.a<Void> aVar = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
        this.f2110i = aVar;
        AtomicReference atomicReference2 = new AtomicReference((Object) null);
        zf.a<Void> a11 = CallbackToFutureAdapter.a(new y2(atomicReference2, str));
        this.f2109h = a11;
        u.f.b(a11, new a(aVar, a10), androidx.camera.core.impl.utils.executor.a.a());
        AtomicReference atomicReference3 = new AtomicReference((Object) null);
        zf.a<Surface> a12 = CallbackToFutureAdapter.a(new z2(atomicReference3, str));
        this.f2107f = a12;
        this.f2108g = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference3.get());
        b bVar = new b(size, 34);
        this.f2111j = bVar;
        zf.a<Void> i10 = bVar.i();
        u.f.b(a12, new c(i10, (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference2.get()), str), androidx.camera.core.impl.utils.executor.a.a());
        i10.addListener(new a3(this), androidx.camera.core.impl.utils.executor.a.a());
    }
}
