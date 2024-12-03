package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;

final class k extends z1 {

    /* renamed from: a  reason: collision with root package name */
    private final Size f2554a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f2555b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f2556c;

    k(Size size, Size size2, Size size3) {
        if (size != null) {
            this.f2554a = size;
            if (size2 != null) {
                this.f2555b = size2;
                if (size3 != null) {
                    this.f2556c = size3;
                    return;
                }
                throw new NullPointerException("Null recordSize");
            }
            throw new NullPointerException("Null previewSize");
        }
        throw new NullPointerException("Null analysisSize");
    }

    @NonNull
    public Size b() {
        return this.f2554a;
    }

    @NonNull
    public Size c() {
        return this.f2555b;
    }

    @NonNull
    public Size d() {
        return this.f2556c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        if (!this.f2554a.equals(z1Var.b()) || !this.f2555b.equals(z1Var.c()) || !this.f2556c.equals(z1Var.d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f2554a.hashCode() ^ 1000003) * 1000003) ^ this.f2555b.hashCode()) * 1000003) ^ this.f2556c.hashCode();
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.f2554a + ", previewSize=" + this.f2555b + ", recordSize=" + this.f2556c + "}";
    }
}
