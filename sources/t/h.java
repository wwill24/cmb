package t;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.h1;
import androidx.camera.core.impl.n;
import java.util.List;
import java.util.concurrent.Executor;

final class h extends p0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f17570a;

    /* renamed from: b  reason: collision with root package name */
    private final h1.m f17571b;

    /* renamed from: c  reason: collision with root package name */
    private final h1.n f17572c;

    /* renamed from: d  reason: collision with root package name */
    private final h1.o f17573d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f17574e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f17575f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17576g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17577h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17578i;

    /* renamed from: j  reason: collision with root package name */
    private final List<n> f17579j;

    h(Executor executor, h1.m mVar, h1.n nVar, h1.o oVar, Rect rect, Matrix matrix, int i10, int i11, int i12, List<n> list) {
        if (executor != null) {
            this.f17570a = executor;
            this.f17571b = mVar;
            this.f17572c = nVar;
            this.f17573d = oVar;
            if (rect != null) {
                this.f17574e = rect;
                if (matrix != null) {
                    this.f17575f = matrix;
                    this.f17576g = i10;
                    this.f17577h = i11;
                    this.f17578i = i12;
                    if (list != null) {
                        this.f17579j = list;
                        return;
                    }
                    throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
                }
                throw new NullPointerException("Null sensorToBufferTransform");
            }
            throw new NullPointerException("Null cropRect");
        }
        throw new NullPointerException("Null appExecutor");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Executor d() {
        return this.f17570a;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f17578i;
    }

    public boolean equals(Object obj) {
        h1.m mVar;
        h1.n nVar;
        h1.o oVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        if (!this.f17570a.equals(p0Var.d()) || ((mVar = this.f17571b) != null ? !mVar.equals(p0Var.g()) : p0Var.g() != null) || ((nVar = this.f17572c) != null ? !nVar.equals(p0Var.i()) : p0Var.i() != null) || ((oVar = this.f17573d) != null ? !oVar.equals(p0Var.j()) : p0Var.j() != null) || !this.f17574e.equals(p0Var.f()) || !this.f17575f.equals(p0Var.l()) || this.f17576g != p0Var.k() || this.f17577h != p0Var.h() || this.f17578i != p0Var.e() || !this.f17579j.equals(p0Var.m())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect f() {
        return this.f17574e;
    }

    /* access modifiers changed from: package-private */
    public h1.m g() {
        return this.f17571b;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f17577h;
    }

    public int hashCode() {
        int i10;
        int i11;
        int hashCode = (this.f17570a.hashCode() ^ 1000003) * 1000003;
        h1.m mVar = this.f17571b;
        int i12 = 0;
        if (mVar == null) {
            i10 = 0;
        } else {
            i10 = mVar.hashCode();
        }
        int i13 = (hashCode ^ i10) * 1000003;
        h1.n nVar = this.f17572c;
        if (nVar == null) {
            i11 = 0;
        } else {
            i11 = nVar.hashCode();
        }
        int i14 = (i13 ^ i11) * 1000003;
        h1.o oVar = this.f17573d;
        if (oVar != null) {
            i12 = oVar.hashCode();
        }
        return ((((((((((((i14 ^ i12) * 1000003) ^ this.f17574e.hashCode()) * 1000003) ^ this.f17575f.hashCode()) * 1000003) ^ this.f17576g) * 1000003) ^ this.f17577h) * 1000003) ^ this.f17578i) * 1000003) ^ this.f17579j.hashCode();
    }

    /* access modifiers changed from: package-private */
    public h1.n i() {
        return this.f17572c;
    }

    /* access modifiers changed from: package-private */
    public h1.o j() {
        return this.f17573d;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f17576g;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Matrix l() {
        return this.f17575f;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<n> m() {
        return this.f17579j;
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.f17570a + ", inMemoryCallback=" + this.f17571b + ", onDiskCallback=" + this.f17572c + ", outputFileOptions=" + this.f17573d + ", cropRect=" + this.f17574e + ", sensorToBufferTransform=" + this.f17575f + ", rotationDegrees=" + this.f17576g + ", jpegQuality=" + this.f17577h + ", captureMode=" + this.f17578i + ", sessionConfigCameraCaptureCallbacks=" + this.f17579j + "}";
    }
}
