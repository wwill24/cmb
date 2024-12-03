package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.annotation.NonNull;

public abstract class a2 {

    /* renamed from: a  reason: collision with root package name */
    private Rational f2173a;

    public a2() {
        this((Rational) null);
    }

    public static float d() {
        return 0.15f;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract PointF a(float f10, float f11);

    @NonNull
    public final z1 b(float f10, float f11) {
        return c(f10, f11, d());
    }

    @NonNull
    public final z1 c(float f10, float f11, float f12) {
        PointF a10 = a(f10, f11);
        return new z1(a10.x, a10.y, f12, this.f2173a);
    }

    public a2(Rational rational) {
        this.f2173a = rational;
    }
}
