package a0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.i;

final class b<T> extends o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f11a;

    /* renamed from: b  reason: collision with root package name */
    private final i f12b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f14d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f15e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f17g;

    /* renamed from: h  reason: collision with root package name */
    private final p f18h;

    b(T t10, i iVar, int i10, Size size, Rect rect, int i11, Matrix matrix, p pVar) {
        if (t10 != null) {
            this.f11a = t10;
            this.f12b = iVar;
            this.f13c = i10;
            if (size != null) {
                this.f14d = size;
                if (rect != null) {
                    this.f15e = rect;
                    this.f16f = i11;
                    if (matrix != null) {
                        this.f17g = matrix;
                        if (pVar != null) {
                            this.f18h = pVar;
                            return;
                        }
                        throw new NullPointerException("Null cameraCaptureResult");
                    }
                    throw new NullPointerException("Null sensorToBufferTransform");
                }
                throw new NullPointerException("Null cropRect");
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null data");
    }

    @NonNull
    public p a() {
        return this.f18h;
    }

    @NonNull
    public Rect b() {
        return this.f15e;
    }

    @NonNull
    public T c() {
        return this.f11a;
    }

    public i d() {
        return this.f12b;
    }

    public int e() {
        return this.f13c;
    }

    public boolean equals(Object obj) {
        i iVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.f11a.equals(oVar.c()) || ((iVar = this.f12b) != null ? !iVar.equals(oVar.d()) : oVar.d() != null) || this.f13c != oVar.e() || !this.f14d.equals(oVar.h()) || !this.f15e.equals(oVar.b()) || this.f16f != oVar.f() || !this.f17g.equals(oVar.g()) || !this.f18h.equals(oVar.a())) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f16f;
    }

    @NonNull
    public Matrix g() {
        return this.f17g;
    }

    @NonNull
    public Size h() {
        return this.f14d;
    }

    public int hashCode() {
        int i10;
        int hashCode = (this.f11a.hashCode() ^ 1000003) * 1000003;
        i iVar = this.f12b;
        if (iVar == null) {
            i10 = 0;
        } else {
            i10 = iVar.hashCode();
        }
        return ((((((((((((hashCode ^ i10) * 1000003) ^ this.f13c) * 1000003) ^ this.f14d.hashCode()) * 1000003) ^ this.f15e.hashCode()) * 1000003) ^ this.f16f) * 1000003) ^ this.f17g.hashCode()) * 1000003) ^ this.f18h.hashCode();
    }

    public String toString() {
        return "Packet{data=" + this.f11a + ", exif=" + this.f12b + ", format=" + this.f13c + ", size=" + this.f14d + ", cropRect=" + this.f15e + ", rotationDegrees=" + this.f16f + ", sensorToBufferTransform=" + this.f17g + ", cameraCaptureResult=" + this.f18h + "}";
    }
}
