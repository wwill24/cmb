package w2;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f18164a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f18165b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f18166c;

    public a() {
        this.f18164a = new PointF();
        this.f18165b = new PointF();
        this.f18166c = new PointF();
    }

    public PointF a() {
        return this.f18164a;
    }

    public PointF b() {
        return this.f18165b;
    }

    public PointF c() {
        return this.f18166c;
    }

    public void d(float f10, float f11) {
        this.f18164a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f18165b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f18166c.set(f10, f11);
    }

    @SuppressLint({"DefaultLocale"})
    @NonNull
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", new Object[]{Float.valueOf(this.f18166c.x), Float.valueOf(this.f18166c.y), Float.valueOf(this.f18164a.x), Float.valueOf(this.f18164a.y), Float.valueOf(this.f18165b.x), Float.valueOf(this.f18165b.y)});
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f18164a = pointF;
        this.f18165b = pointF2;
        this.f18166c = pointF3;
    }
}
