package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraState;

final class f extends CameraState {

    /* renamed from: a  reason: collision with root package name */
    private final CameraState.Type f2229a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraState.a f2230b;

    f(CameraState.Type type, CameraState.a aVar) {
        if (type != null) {
            this.f2229a = type;
            this.f2230b = aVar;
            return;
        }
        throw new NullPointerException("Null type");
    }

    public CameraState.a c() {
        return this.f2230b;
    }

    @NonNull
    public CameraState.Type d() {
        return this.f2229a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState)) {
            return false;
        }
        CameraState cameraState = (CameraState) obj;
        if (this.f2229a.equals(cameraState.d())) {
            CameraState.a aVar = this.f2230b;
            if (aVar == null) {
                if (cameraState.c() == null) {
                    return true;
                }
            } else if (aVar.equals(cameraState.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = (this.f2229a.hashCode() ^ 1000003) * 1000003;
        CameraState.a aVar = this.f2230b;
        if (aVar == null) {
            i10 = 0;
        } else {
            i10 = aVar.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "CameraState{type=" + this.f2229a + ", error=" + this.f2230b + "}";
    }
}
