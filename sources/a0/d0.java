package a0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.impl.utils.q;
import androidx.core.util.h;
import java.util.Collections;
import u.c;
import u.f;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceOutput.GlTransformOptions f26a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final a0 f27b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final CameraInternal f28c;

    /* renamed from: d  reason: collision with root package name */
    private w f29d;

    /* renamed from: e  reason: collision with root package name */
    private w f30e;

    class a implements c<SurfaceOutput> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SurfaceRequest f31a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f32b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u f33c;

        a(SurfaceRequest surfaceRequest, u uVar, u uVar2) {
            this.f31a = surfaceRequest;
            this.f32b = uVar;
            this.f33c = uVar2;
        }

        /* renamed from: a */
        public void onSuccess(SurfaceOutput surfaceOutput) {
            h.g(surfaceOutput);
            d0.this.f27b.b(surfaceOutput);
            d0.this.f27b.a(this.f31a);
            d0.this.h(this.f32b, this.f31a, this.f33c, surfaceOutput);
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f31a.z();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35a;

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
                f35a = r0
                androidx.camera.core.SurfaceOutput$GlTransformOptions r1 = androidx.camera.core.SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.SurfaceOutput$GlTransformOptions r1 = androidx.camera.core.SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a0.d0.b.<clinit>():void");
        }
    }

    public d0(@NonNull CameraInternal cameraInternal, @NonNull SurfaceOutput.GlTransformOptions glTransformOptions, @NonNull a0 a0Var) {
        this.f28c = cameraInternal;
        this.f26a = glTransformOptions;
        this.f27b = a0Var;
    }

    @NonNull
    private u c(@NonNull u uVar) {
        Size size;
        int i10 = b.f35a[this.f26a.ordinal()];
        if (i10 == 1) {
            Size B = uVar.B();
            Rect w10 = uVar.w();
            int z10 = uVar.z();
            boolean y10 = uVar.y();
            if (q.f(z10)) {
                size = new Size(w10.height(), w10.width());
            } else {
                size = q.h(w10);
            }
            Size size2 = size;
            Matrix matrix = new Matrix(uVar.A());
            matrix.postConcat(q.d(q.n(B), new RectF(w10), z10, y10));
            return new u(uVar.C(), size2, uVar.x(), matrix, false, q.l(size2), 0, false);
        } else if (i10 == 2) {
            return new u(uVar.C(), uVar.B(), uVar.x(), uVar.A(), false, uVar.w(), uVar.z(), uVar.y());
        } else {
            throw new AssertionError("Unknown GlTransformOptions: " + this.f26a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        w wVar = this.f29d;
        if (wVar != null) {
            for (u c10 : wVar.b()) {
                c10.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(SurfaceOutput surfaceOutput, u uVar, u uVar2, SurfaceRequest.f fVar) {
        int b10 = fVar.b() - surfaceOutput.a();
        if (uVar.y()) {
            b10 = -b10;
        }
        uVar2.K(q.q(b10));
    }

    private void g(@NonNull u uVar, @NonNull u uVar2) {
        u uVar3 = uVar2;
        f.b(uVar3.t(this.f26a, uVar.B(), uVar.w(), uVar.z(), uVar.y()), new a(uVar.u(this.f28c), uVar, uVar2), androidx.camera.core.impl.utils.executor.a.d());
    }

    public void f() {
        this.f27b.release();
        androidx.camera.core.impl.utils.executor.a.d().execute(new b0(this));
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull u uVar, @NonNull SurfaceRequest surfaceRequest, @NonNull u uVar2, @NonNull SurfaceOutput surfaceOutput) {
        surfaceRequest.x(androidx.camera.core.impl.utils.executor.a.d(), new c0(surfaceOutput, uVar, uVar2));
    }

    @NonNull
    public w i(@NonNull w wVar) {
        p.a();
        boolean z10 = true;
        if (wVar.b().size() != 1) {
            z10 = false;
        }
        h.b(z10, "Multiple input stream not supported yet.");
        this.f30e = wVar;
        u uVar = wVar.b().get(0);
        u c10 = c(uVar);
        g(uVar, c10);
        w a10 = w.a(Collections.singletonList(c10));
        this.f29d = a10;
        return a10;
    }
}
