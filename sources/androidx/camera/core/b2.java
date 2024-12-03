package androidx.camera.core;

import android.graphics.Matrix;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;

class b2 extends d {

    /* renamed from: d  reason: collision with root package name */
    private volatile a2 f2184d = null;

    /* renamed from: e  reason: collision with root package name */
    private volatile Long f2185e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile Integer f2186f = null;

    /* renamed from: g  reason: collision with root package name */
    private volatile Matrix f2187g = null;

    b2(@NonNull ImageReader imageReader) {
        super(imageReader);
    }

    private o1 l(o1 o1Var) {
        a2 a2Var;
        long j10;
        int i10;
        Matrix matrix;
        l1 z12 = o1Var.z1();
        if (this.f2184d != null) {
            a2Var = this.f2184d;
        } else {
            a2Var = z12.c();
        }
        if (this.f2185e != null) {
            j10 = this.f2185e.longValue();
        } else {
            j10 = z12.getTimestamp();
        }
        if (this.f2186f != null) {
            i10 = this.f2186f.intValue();
        } else {
            i10 = z12.a();
        }
        if (this.f2187g != null) {
            matrix = this.f2187g;
        } else {
            matrix = z12.d();
        }
        return new t2(o1Var, u1.e(a2Var, j10, i10, matrix));
    }

    public o1 b() {
        return l(super.g());
    }

    public o1 g() {
        return l(super.g());
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull a2 a2Var) {
        this.f2184d = a2Var;
    }
}
