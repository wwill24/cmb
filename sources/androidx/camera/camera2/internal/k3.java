package androidx.camera.camera2.internal;

import androidx.camera.core.l3;

class k3 implements l3 {

    /* renamed from: a  reason: collision with root package name */
    private float f1836a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1837b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1838c;

    /* renamed from: d  reason: collision with root package name */
    private float f1839d;

    k3(float f10, float f11) {
        this.f1837b = f10;
        this.f1838c = f11;
    }

    private float e(float f10) {
        float f11 = this.f1837b;
        float f12 = this.f1838c;
        if (f11 == f12) {
            return 0.0f;
        }
        if (f10 == f11) {
            return 1.0f;
        }
        if (f10 == f12) {
            return 0.0f;
        }
        float f13 = 1.0f / f12;
        return ((1.0f / f10) - f13) / ((1.0f / f11) - f13);
    }

    public float a() {
        return this.f1837b;
    }

    public float b() {
        return this.f1839d;
    }

    public float c() {
        return this.f1838c;
    }

    public float d() {
        return this.f1836a;
    }

    /* access modifiers changed from: package-private */
    public void f(float f10) throws IllegalArgumentException {
        if (f10 > this.f1837b || f10 < this.f1838c) {
            throw new IllegalArgumentException("Requested zoomRatio " + f10 + " is not within valid range [" + this.f1838c + " , " + this.f1837b + "]");
        }
        this.f1836a = f10;
        this.f1839d = e(f10);
    }
}
