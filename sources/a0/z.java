package a0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.utils.o;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

final class z implements SurfaceOutput {

    /* renamed from: a  reason: collision with root package name */
    private final Object f111a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Surface f112b;

    /* renamed from: c  reason: collision with root package name */
    private final int f113c;

    /* renamed from: d  reason: collision with root package name */
    private final int f114d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Size f115e;

    /* renamed from: f  reason: collision with root package name */
    private final SurfaceOutput.GlTransformOptions f116f;

    /* renamed from: g  reason: collision with root package name */
    private final Size f117g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f118h;

    /* renamed from: i  reason: collision with root package name */
    private final int f119i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f120j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final float[] f121k = new float[16];

    /* renamed from: l  reason: collision with root package name */
    private androidx.core.util.a<SurfaceOutput.a> f122l;

    /* renamed from: m  reason: collision with root package name */
    private Executor f123m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f124n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f125o = false;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private final zf.a<Void> f126p;

    /* renamed from: q  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Void> f127q;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f128a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.SurfaceOutput$GlTransformOptions[] r0 = androidx.camera.core.SurfaceOutput.GlTransformOptions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f128a = r0
                androidx.camera.core.SurfaceOutput$GlTransformOptions r1 = androidx.camera.core.SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f128a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.SurfaceOutput$GlTransformOptions r1 = androidx.camera.core.SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a0.z.a.<clinit>():void");
        }
    }

    z(@NonNull Surface surface, int i10, int i11, @NonNull Size size, @NonNull SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull Size size2, @NonNull Rect rect, int i12, boolean z10) {
        this.f112b = surface;
        this.f113c = i10;
        this.f114d = i11;
        this.f115e = size;
        this.f116f = glTransformOptions;
        this.f117g = size2;
        this.f118h = new Rect(rect);
        this.f120j = z10;
        if (glTransformOptions == SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING) {
            this.f119i = i12;
            f();
        } else {
            this.f119i = 0;
        }
        this.f126p = CallbackToFutureAdapter.a(new x(this));
    }

    private void f() {
        Matrix.setIdentityM(this.f121k, 0);
        Matrix.translateM(this.f121k, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(this.f121k, 0, 1.0f, -1.0f, 1.0f);
        o.c(this.f121k, (float) this.f119i, 0.5f, 0.5f);
        if (this.f120j) {
            Matrix.translateM(this.f121k, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(this.f121k, 0, -1.0f, 1.0f, 1.0f);
        }
        Size k10 = q.k(this.f117g, this.f119i);
        android.graphics.Matrix d10 = q.d(q.n(this.f117g), q.n(k10), this.f119i, this.f120j);
        RectF rectF = new RectF(this.f118h);
        d10.mapRect(rectF);
        float width = rectF.left / ((float) k10.getWidth());
        float height = ((((float) k10.getHeight()) - rectF.height()) - rectF.top) / ((float) k10.getHeight());
        float height2 = rectF.height() / ((float) k10.getHeight());
        Matrix.translateM(this.f121k, 0, width, height, 0.0f);
        Matrix.scaleM(this.f121k, 0, rectF.width() / ((float) k10.getWidth()), height2, 1.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object h(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f127q = aVar;
        return "SurfaceOutputImpl close future complete";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(AtomicReference atomicReference) {
        ((androidx.core.util.a) atomicReference.get()).accept(SurfaceOutput.a.c(0, this));
    }

    public int a() {
        return this.f119i;
    }

    public void b(@NonNull float[] fArr, @NonNull float[] fArr2) {
        int i10 = a.f128a[this.f116f.ordinal()];
        if (i10 == 1) {
            System.arraycopy(fArr2, 0, fArr, 0, 16);
        } else if (i10 == 2) {
            System.arraycopy(this.f121k, 0, fArr, 0, 16);
        } else {
            throw new AssertionError("Unknown GlTransformOptions: " + this.f116f);
        }
    }

    @NonNull
    public Surface c(@NonNull Executor executor, @NonNull androidx.core.util.a<SurfaceOutput.a> aVar) {
        boolean z10;
        synchronized (this.f111a) {
            this.f123m = executor;
            this.f122l = aVar;
            z10 = this.f124n;
        }
        if (z10) {
            j();
        }
        return this.f112b;
    }

    public void close() {
        synchronized (this.f111a) {
            if (!this.f125o) {
                this.f125o = true;
            }
        }
        this.f127q.c(null);
    }

    @NonNull
    public zf.a<Void> g() {
        return this.f126p;
    }

    public void j() {
        Executor executor;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.f111a) {
            if (this.f123m != null) {
                androidx.core.util.a<SurfaceOutput.a> aVar = this.f122l;
                if (aVar != null) {
                    if (!this.f125o) {
                        atomicReference.set(aVar);
                        executor = this.f123m;
                        this.f124n = false;
                    }
                    executor = null;
                }
            }
            this.f124n = true;
            executor = null;
        }
        if (executor != null) {
            try {
                executor.execute(new y(this, atomicReference));
            } catch (RejectedExecutionException e10) {
                v1.b("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e10);
            }
        }
    }
}
