package a0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.p;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import u.f;
import zf.a;

public class u extends DeferrableSurface {

    /* renamed from: m  reason: collision with root package name */
    private final a<Surface> f95m;

    /* renamed from: n  reason: collision with root package name */
    CallbackToFutureAdapter.a<Surface> f96n;

    /* renamed from: o  reason: collision with root package name */
    private final Matrix f97o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f98p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f99q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f100r;

    /* renamed from: s  reason: collision with root package name */
    private final int f101s;

    /* renamed from: t  reason: collision with root package name */
    private int f102t;

    /* renamed from: u  reason: collision with root package name */
    private z f103u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f104v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f105w = false;

    /* renamed from: x  reason: collision with root package name */
    private SurfaceRequest f106x;

    public u(int i10, @NonNull Size size, int i11, @NonNull Matrix matrix, boolean z10, @NonNull Rect rect, int i12, boolean z11) {
        super(size, i11);
        this.f101s = i10;
        this.f97o = matrix;
        this.f98p = z10;
        this.f99q = rect;
        this.f102t = i12;
        this.f100r = z11;
        this.f95m = CallbackToFutureAdapter.a(new q(this, size));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D() {
        z zVar = this.f103u;
        if (zVar != null) {
            zVar.j();
            this.f103u = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ a E(SurfaceOutput.GlTransformOptions glTransformOptions, Size size, Rect rect, int i10, boolean z10, Surface surface) throws Exception {
        h.g(surface);
        try {
            j();
            z zVar = new z(surface, C(), x(), B(), glTransformOptions, size, rect, i10, z10);
            zVar.g().addListener(new t(this), androidx.camera.core.impl.utils.executor.a.a());
            this.f103u = zVar;
            return f.h(zVar);
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            return f.f(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object F(Size size, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f96n = aVar;
        return "SettableFuture size: " + size + " hashCode: " + hashCode();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void G(DeferrableSurface deferrableSurface) {
        deferrableSurface.d();
        deferrableSurface.c();
    }

    private void H() {
        SurfaceRequest surfaceRequest = this.f106x;
        if (surfaceRequest != null) {
            surfaceRequest.y(SurfaceRequest.f.d(this.f99q, this.f102t, -1));
        }
    }

    @NonNull
    public Matrix A() {
        return this.f97o;
    }

    @NonNull
    public Size B() {
        return f();
    }

    public int C() {
        return this.f101s;
    }

    public void I(@NonNull DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        p.a();
        J(deferrableSurface.h());
        deferrableSurface.j();
        i().addListener(new r(deferrableSurface), androidx.camera.core.impl.utils.executor.a.a());
    }

    public void J(@NonNull a<Surface> aVar) {
        p.a();
        h.j(!this.f104v, "Provider can only be linked once.");
        this.f104v = true;
        f.k(aVar, this.f96n);
    }

    public void K(int i10) {
        p.a();
        if (this.f102t != i10) {
            this.f102t = i10;
            H();
        }
    }

    public final void c() {
        super.c();
        androidx.camera.core.impl.utils.executor.a.d().execute(new p(this));
    }

    /* access modifiers changed from: protected */
    @NonNull
    public a<Surface> n() {
        return this.f95m;
    }

    @NonNull
    public a<SurfaceOutput> t(@NonNull SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull Size size, @NonNull Rect rect, int i10, boolean z10) {
        p.a();
        h.j(!this.f105w, "Consumer can only be linked once.");
        this.f105w = true;
        return f.p(h(), new s(this, glTransformOptions, size, rect, i10, z10), androidx.camera.core.impl.utils.executor.a.d());
    }

    @NonNull
    public SurfaceRequest u(@NonNull CameraInternal cameraInternal) {
        return v(cameraInternal, (Range<Integer>) null);
    }

    @NonNull
    public SurfaceRequest v(@NonNull CameraInternal cameraInternal, Range<Integer> range) {
        p.a();
        SurfaceRequest surfaceRequest = new SurfaceRequest(B(), cameraInternal, true, range);
        try {
            I(surfaceRequest.k());
            this.f106x = surfaceRequest;
            H();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            throw new AssertionError("Surface is somehow already closed", e10);
        }
    }

    @NonNull
    public Rect w() {
        return this.f99q;
    }

    public int x() {
        return g();
    }

    public boolean y() {
        return this.f100r;
    }

    public int z() {
        return this.f102t;
    }
}
