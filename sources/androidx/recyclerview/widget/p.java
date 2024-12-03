package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class p extends RecyclerView.y {

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f6695i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f6696j = new DecelerateInterpolator();
    @SuppressLint({"UnknownNullness"})

    /* renamed from: k  reason: collision with root package name */
    protected PointF f6697k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f6698l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6699m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f6700n;

    /* renamed from: o  reason: collision with root package name */
    protected int f6701o = 0;

    /* renamed from: p  reason: collision with root package name */
    protected int f6702p = 0;

    @SuppressLint({"UnknownNullness"})
    public p(Context context) {
        this.f6698l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f6699m) {
            this.f6700n = v(this.f6698l);
            this.f6699m = true;
        }
        return this.f6700n;
    }

    private int y(int i10, int i11) {
        int i12 = i10 - i11;
        if (i10 * i12 <= 0) {
            return 0;
        }
        return i12;
    }

    /* access modifiers changed from: protected */
    public int B() {
        PointF pointF = this.f6697k;
        if (pointF != null) {
            float f10 = pointF.y;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void C(RecyclerView.y.a aVar) {
        PointF a10 = a(f());
        if (a10 == null || (a10.x == 0.0f && a10.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a10);
        this.f6697k = a10;
        this.f6701o = (int) (a10.x * 10000.0f);
        this.f6702p = (int) (a10.y * 10000.0f);
        aVar.d((int) (((float) this.f6701o) * 1.2f), (int) (((float) this.f6702p) * 1.2f), (int) (((float) x(10000)) * 1.2f), this.f6695i);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void l(int i10, int i11, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f6701o = y(this.f6701o, i10);
        int y10 = y(this.f6702p, i11);
        this.f6702p = y10;
        if (this.f6701o == 0 && y10 == 0) {
            C(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
    }

    /* access modifiers changed from: protected */
    public void n() {
        this.f6702p = 0;
        this.f6701o = 0;
        this.f6697k = null;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int t10 = t(view, z());
        int u10 = u(view, B());
        int w10 = w((int) Math.sqrt((double) ((t10 * t10) + (u10 * u10))));
        if (w10 > 0) {
            aVar.d(-t10, -u10, w10, this.f6696j);
        }
    }

    public int s(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 == 0) {
            int i15 = i12 - i10;
            if (i15 > 0) {
                return i15;
            }
            int i16 = i13 - i11;
            if (i16 < 0) {
                return i16;
            }
            return 0;
        } else if (i14 == 1) {
            return i13 - i11;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int t(View view, int i10) {
        RecyclerView.o e10 = e();
        if (e10 == null || !e10.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e10.R(view) - pVar.leftMargin, e10.U(view) + pVar.rightMargin, e10.f0(), e10.p0() - e10.g0(), i10);
    }

    @SuppressLint({"UnknownNullness"})
    public int u(View view, int i10) {
        RecyclerView.o e10 = e();
        if (e10 == null || !e10.m()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(e10.V(view) - pVar.topMargin, e10.P(view) + pVar.bottomMargin, e10.h0(), e10.X() - e10.e0(), i10);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int w(int i10) {
        return (int) Math.ceil(((double) x(i10)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int x(int i10) {
        return (int) Math.ceil((double) (((float) Math.abs(i10)) * A()));
    }

    /* access modifiers changed from: protected */
    public int z() {
        PointF pointF = this.f6697k;
        if (pointF != null) {
            float f10 = pointF.x;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
