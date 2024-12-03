package androidx.camera.core;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;

final class k extends SurfaceRequest.f {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f2779a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2780b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2781c;

    k(Rect rect, int i10, int i11) {
        if (rect != null) {
            this.f2779a = rect;
            this.f2780b = i10;
            this.f2781c = i11;
            return;
        }
        throw new NullPointerException("Null cropRect");
    }

    @NonNull
    public Rect a() {
        return this.f2779a;
    }

    public int b() {
        return this.f2780b;
    }

    public int c() {
        return this.f2781c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.f)) {
            return false;
        }
        SurfaceRequest.f fVar = (SurfaceRequest.f) obj;
        if (this.f2779a.equals(fVar.a()) && this.f2780b == fVar.b() && this.f2781c == fVar.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f2779a.hashCode() ^ 1000003) * 1000003) ^ this.f2780b) * 1000003) ^ this.f2781c;
    }

    public String toString() {
        return "TransformationInfo{cropRect=" + this.f2779a + ", rotationDegrees=" + this.f2780b + ", targetRotation=" + this.f2781c + "}";
    }
}
