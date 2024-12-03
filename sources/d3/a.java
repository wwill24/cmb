package d3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h f14405a;

    /* renamed from: b  reason: collision with root package name */
    public final T f14406b;

    /* renamed from: c  reason: collision with root package name */
    public T f14407c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f14408d;

    /* renamed from: e  reason: collision with root package name */
    public final Interpolator f14409e;

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator f14410f;

    /* renamed from: g  reason: collision with root package name */
    public final float f14411g;

    /* renamed from: h  reason: collision with root package name */
    public Float f14412h;

    /* renamed from: i  reason: collision with root package name */
    private float f14413i;

    /* renamed from: j  reason: collision with root package name */
    private float f14414j;

    /* renamed from: k  reason: collision with root package name */
    private int f14415k;

    /* renamed from: l  reason: collision with root package name */
    private int f14416l;

    /* renamed from: m  reason: collision with root package name */
    private float f14417m;

    /* renamed from: n  reason: collision with root package name */
    private float f14418n;

    /* renamed from: o  reason: collision with root package name */
    public PointF f14419o;

    /* renamed from: p  reason: collision with root package name */
    public PointF f14420p;

    public a(h hVar, T t10, T t11, Interpolator interpolator, float f10, Float f11) {
        this.f14413i = -3987645.8f;
        this.f14414j = -3987645.8f;
        this.f14415k = 784923401;
        this.f14416l = 784923401;
        this.f14417m = Float.MIN_VALUE;
        this.f14418n = Float.MIN_VALUE;
        this.f14419o = null;
        this.f14420p = null;
        this.f14405a = hVar;
        this.f14406b = t10;
        this.f14407c = t11;
        this.f14408d = interpolator;
        this.f14409e = null;
        this.f14410f = null;
        this.f14411g = f10;
        this.f14412h = f11;
    }

    public boolean a(float f10) {
        return f10 >= f() && f10 < c();
    }

    public a<T> b(T t10, T t11) {
        return new a<>(t10, t11);
    }

    public float c() {
        if (this.f14405a == null) {
            return 1.0f;
        }
        if (this.f14418n == Float.MIN_VALUE) {
            if (this.f14412h == null) {
                this.f14418n = 1.0f;
            } else {
                this.f14418n = f() + ((this.f14412h.floatValue() - this.f14411g) / this.f14405a.e());
            }
        }
        return this.f14418n;
    }

    public float d() {
        if (this.f14414j == -3987645.8f) {
            this.f14414j = ((Float) this.f14407c).floatValue();
        }
        return this.f14414j;
    }

    public int e() {
        if (this.f14416l == 784923401) {
            this.f14416l = ((Integer) this.f14407c).intValue();
        }
        return this.f14416l;
    }

    public float f() {
        h hVar = this.f14405a;
        if (hVar == null) {
            return 0.0f;
        }
        if (this.f14417m == Float.MIN_VALUE) {
            this.f14417m = (this.f14411g - hVar.p()) / this.f14405a.e();
        }
        return this.f14417m;
    }

    public float g() {
        if (this.f14413i == -3987645.8f) {
            this.f14413i = ((Float) this.f14406b).floatValue();
        }
        return this.f14413i;
    }

    public int h() {
        if (this.f14415k == 784923401) {
            this.f14415k = ((Integer) this.f14406b).intValue();
        }
        return this.f14415k;
    }

    public boolean i() {
        return this.f14408d == null && this.f14409e == null && this.f14410f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f14406b + ", endValue=" + this.f14407c + ", startFrame=" + this.f14411g + ", endFrame=" + this.f14412h + ", interpolator=" + this.f14408d + '}';
    }

    public a(h hVar, T t10, T t11, Interpolator interpolator, Interpolator interpolator2, float f10, Float f11) {
        this.f14413i = -3987645.8f;
        this.f14414j = -3987645.8f;
        this.f14415k = 784923401;
        this.f14416l = 784923401;
        this.f14417m = Float.MIN_VALUE;
        this.f14418n = Float.MIN_VALUE;
        this.f14419o = null;
        this.f14420p = null;
        this.f14405a = hVar;
        this.f14406b = t10;
        this.f14407c = t11;
        this.f14408d = null;
        this.f14409e = interpolator;
        this.f14410f = interpolator2;
        this.f14411g = f10;
        this.f14412h = f11;
    }

    protected a(h hVar, T t10, T t11, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f10, Float f11) {
        this.f14413i = -3987645.8f;
        this.f14414j = -3987645.8f;
        this.f14415k = 784923401;
        this.f14416l = 784923401;
        this.f14417m = Float.MIN_VALUE;
        this.f14418n = Float.MIN_VALUE;
        this.f14419o = null;
        this.f14420p = null;
        this.f14405a = hVar;
        this.f14406b = t10;
        this.f14407c = t11;
        this.f14408d = interpolator;
        this.f14409e = interpolator2;
        this.f14410f = interpolator3;
        this.f14411g = f10;
        this.f14412h = f11;
    }

    public a(T t10) {
        this.f14413i = -3987645.8f;
        this.f14414j = -3987645.8f;
        this.f14415k = 784923401;
        this.f14416l = 784923401;
        this.f14417m = Float.MIN_VALUE;
        this.f14418n = Float.MIN_VALUE;
        this.f14419o = null;
        this.f14420p = null;
        this.f14405a = null;
        this.f14406b = t10;
        this.f14407c = t10;
        this.f14408d = null;
        this.f14409e = null;
        this.f14410f = null;
        this.f14411g = Float.MIN_VALUE;
        this.f14412h = Float.valueOf(Float.MAX_VALUE);
    }

    private a(T t10, T t11) {
        this.f14413i = -3987645.8f;
        this.f14414j = -3987645.8f;
        this.f14415k = 784923401;
        this.f14416l = 784923401;
        this.f14417m = Float.MIN_VALUE;
        this.f14418n = Float.MIN_VALUE;
        this.f14419o = null;
        this.f14420p = null;
        this.f14405a = null;
        this.f14406b = t10;
        this.f14407c = t11;
        this.f14408d = null;
        this.f14409e = null;
        this.f14410f = null;
        this.f14411g = Float.MIN_VALUE;
        this.f14412h = Float.valueOf(Float.MAX_VALUE);
    }
}
