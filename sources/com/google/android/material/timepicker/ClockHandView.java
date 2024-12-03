package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.n0;
import bf.d;
import bf.k;
import bf.l;
import com.google.android.material.internal.r;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private int B;

    /* renamed from: a  reason: collision with root package name */
    private final int f20405a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeInterpolator f20406b;

    /* renamed from: c  reason: collision with root package name */
    private final ValueAnimator f20407c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20408d;

    /* renamed from: e  reason: collision with root package name */
    private float f20409e;

    /* renamed from: f  reason: collision with root package name */
    private float f20410f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20411g;

    /* renamed from: h  reason: collision with root package name */
    private final int f20412h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20413j;

    /* renamed from: k  reason: collision with root package name */
    private final List<c> f20414k;

    /* renamed from: l  reason: collision with root package name */
    private final int f20415l;

    /* renamed from: m  reason: collision with root package name */
    private final float f20416m;

    /* renamed from: n  reason: collision with root package name */
    private final Paint f20417n;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f20418p;

    /* renamed from: q  reason: collision with root package name */
    private final int f20419q;

    /* renamed from: t  reason: collision with root package name */
    private float f20420t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f20421w;

    /* renamed from: x  reason: collision with root package name */
    private b f20422x;

    /* renamed from: y  reason: collision with root package name */
    private double f20423y;

    /* renamed from: z  reason: collision with root package name */
    private int f20424z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void a(float f10, boolean z10);
    }

    public interface c {
        void a(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.materialClockStyle);
    }

    private void c(float f10, float f11) {
        int i10 = 2;
        if (nf.a.a((float) (getWidth() / 2), (float) (getHeight() / 2), f10, f11) > ((float) h(2)) + r.c(getContext(), 12)) {
            i10 = 1;
        }
        this.B = i10;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int h10 = h(this.B);
        float f10 = (float) width;
        float f11 = (float) h10;
        float f12 = (float) height;
        this.f20417n.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.f20423y)) * f11) + f10, (f11 * ((float) Math.sin(this.f20423y))) + f12, (float) this.f20415l, this.f20417n);
        double sin = Math.sin(this.f20423y);
        double cos = Math.cos(this.f20423y);
        double d10 = (double) ((float) (h10 - this.f20415l));
        float f13 = (float) (width + ((int) (cos * d10)));
        float f14 = (float) (height + ((int) (d10 * sin)));
        this.f20417n.setStrokeWidth((float) this.f20419q);
        canvas.drawLine(f10, f12, f13, f14, this.f20417n);
        canvas.drawCircle(f10, f12, this.f20416m, this.f20417n);
    }

    private int f(float f10, float f11) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f11 - ((float) (getHeight() / 2))), (double) (f10 - ((float) (getWidth() / 2)))))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }

    private int h(int i10) {
        return i10 == 2 ? Math.round(((float) this.f20424z) * 0.66f) : this.f20424z;
    }

    private Pair<Float, Float> j(float f10) {
        float g10 = g();
        if (Math.abs(g10 - f10) > 180.0f) {
            if (g10 > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (g10 < 180.0f && f10 > 180.0f) {
                g10 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(g10), Float.valueOf(f10));
    }

    private boolean k(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float f12 = (float) f(f10, f11);
        boolean z14 = false;
        if (g() != f12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11 && z13) {
            return true;
        }
        if (!z13 && !z10) {
            return false;
        }
        if (z12 && this.f20408d) {
            z14 = true;
        }
        o(f12, z14);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void p(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f20420t = f11;
        this.f20423y = Math.toRadians((double) (f11 - 90.0f));
        float h10 = (float) h(this.B);
        float width = ((float) (getWidth() / 2)) + (((float) Math.cos(this.f20423y)) * h10);
        float height = ((float) (getHeight() / 2)) + (h10 * ((float) Math.sin(this.f20423y)));
        RectF rectF = this.f20418p;
        int i10 = this.f20415l;
        rectF.set(width - ((float) i10), height - ((float) i10), width + ((float) i10), height + ((float) i10));
        for (c a10 : this.f20414k) {
            a10.a(f11, z10);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.f20414k.add(cVar);
    }

    public RectF e() {
        return this.f20418p;
    }

    public float g() {
        return this.f20420t;
    }

    public int i() {
        return this.f20415l;
    }

    public void m(int i10) {
        this.f20424z = i10;
        invalidate();
    }

    public void n(float f10) {
        o(f10, false);
    }

    public void o(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f20407c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            p(f10, false);
            return;
        }
        Pair<Float, Float> j10 = j(f10);
        this.f20407c.setFloatValues(new float[]{((Float) j10.first).floatValue(), ((Float) j10.second).floatValue()});
        this.f20407c.setDuration((long) this.f20405a);
        this.f20407c.setInterpolator(this.f20406b);
        this.f20407c.addUpdateListener(new a(this));
        this.f20407c.addListener(new a());
        this.f20407c.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f20407c.isRunning()) {
            n(g());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        b bVar;
        boolean z13;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f20409e = x10;
            this.f20410f = y10;
            this.f20411g = true;
            this.f20421w = false;
            z12 = false;
            z11 = false;
            z10 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f20409e);
            int i11 = (int) (y10 - this.f20410f);
            if ((i10 * i10) + (i11 * i11) > this.f20412h) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.f20411g = z13;
            boolean z14 = this.f20421w;
            if (actionMasked == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (this.f20413j) {
                c(x10, y10);
            }
            z10 = false;
            z11 = z14;
        } else {
            z12 = false;
            z11 = false;
            z10 = false;
        }
        boolean k10 = k(x10, y10, z11, z10, z12) | this.f20421w;
        this.f20421w = k10;
        if (k10 && z12 && (bVar = this.f20422x) != null) {
            bVar.a((float) f(x10, y10), this.f20411g);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z10) {
        if (this.f20413j && !z10) {
            this.B = 1;
        }
        this.f20413j = z10;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20407c = new ValueAnimator();
        this.f20414k = new ArrayList();
        Paint paint = new Paint();
        this.f20417n = paint;
        this.f20418p = new RectF();
        this.B = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockHandView, i10, k.Widget_MaterialComponents_TimePicker_Clock);
        this.f20405a = of.a.f(context, bf.b.motionDurationLong2, 200);
        this.f20406b = of.a.g(context, bf.b.motionEasingEmphasizedInterpolator, cf.a.f18978b);
        this.f20424z = obtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_materialCircleRadius, 0);
        this.f20415l = obtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f20419q = resources.getDimensionPixelSize(d.material_clock_hand_stroke_width);
        this.f20416m = (float) resources.getDimensionPixelSize(d.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(l.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f20412h = ViewConfiguration.get(context).getScaledTouchSlop();
        n0.D0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
