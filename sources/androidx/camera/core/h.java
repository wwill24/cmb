package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;

final class h extends u1 {

    /* renamed from: a  reason: collision with root package name */
    private final a2 f2265a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2266b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2267c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f2268d;

    h(a2 a2Var, long j10, int i10, Matrix matrix) {
        if (a2Var != null) {
            this.f2265a = a2Var;
            this.f2266b = j10;
            this.f2267c = i10;
            if (matrix != null) {
                this.f2268d = matrix;
                return;
            }
            throw new NullPointerException("Null sensorToBufferTransformMatrix");
        }
        throw new NullPointerException("Null tagBundle");
    }

    public int a() {
        return this.f2267c;
    }

    @NonNull
    public a2 c() {
        return this.f2265a;
    }

    @NonNull
    public Matrix d() {
        return this.f2268d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        if (!this.f2265a.equals(u1Var.c()) || this.f2266b != u1Var.getTimestamp() || this.f2267c != u1Var.a() || !this.f2268d.equals(u1Var.d())) {
            return false;
        }
        return true;
    }

    public long getTimestamp() {
        return this.f2266b;
    }

    public int hashCode() {
        long j10 = this.f2266b;
        return ((((((this.f2265a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ this.f2267c) * 1000003) ^ this.f2268d.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.f2265a + ", timestamp=" + this.f2266b + ", rotationDegrees=" + this.f2267c + ", sensorToBufferTransformMatrix=" + this.f2268d + "}";
    }
}
