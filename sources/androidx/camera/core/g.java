package androidx.camera.core;

import androidx.camera.core.CameraState;

final class g extends CameraState.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f2259a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f2260b;

    g(int i10, Throwable th2) {
        this.f2259a = i10;
        this.f2260b = th2;
    }

    public Throwable c() {
        return this.f2260b;
    }

    public int d() {
        return this.f2259a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.a)) {
            return false;
        }
        CameraState.a aVar = (CameraState.a) obj;
        if (this.f2259a == aVar.d()) {
            Throwable th2 = this.f2260b;
            if (th2 == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (th2.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11 = (this.f2259a ^ 1000003) * 1000003;
        Throwable th2 = this.f2260b;
        if (th2 == null) {
            i10 = 0;
        } else {
            i10 = th2.hashCode();
        }
        return i11 ^ i10;
    }

    public String toString() {
        return "StateError{code=" + this.f2259a + ", cause=" + this.f2260b + "}";
    }
}
