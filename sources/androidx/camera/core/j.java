package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;

final class j extends SurfaceRequest.e {

    /* renamed from: a  reason: collision with root package name */
    private final int f2740a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f2741b;

    j(int i10, Surface surface) {
        this.f2740a = i10;
        if (surface != null) {
            this.f2741b = surface;
            return;
        }
        throw new NullPointerException("Null surface");
    }

    public int a() {
        return this.f2740a;
    }

    @NonNull
    public Surface b() {
        return this.f2741b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.e)) {
            return false;
        }
        SurfaceRequest.e eVar = (SurfaceRequest.e) obj;
        if (this.f2740a != eVar.a() || !this.f2741b.equals(eVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2740a ^ 1000003) * 1000003) ^ this.f2741b.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.f2740a + ", surface=" + this.f2741b + "}";
    }
}
