package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

abstract class g extends Drawable implements Animatable {

    /* renamed from: q  reason: collision with root package name */
    private static final Property<g, Float> f19961q = new c(Float.class, "growFraction");

    /* renamed from: a  reason: collision with root package name */
    final Context f19962a;

    /* renamed from: b  reason: collision with root package name */
    final b f19963b;

    /* renamed from: c  reason: collision with root package name */
    pf.a f19964c;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f19965d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f19966e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19967f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19968g;

    /* renamed from: h  reason: collision with root package name */
    private float f19969h;

    /* renamed from: j  reason: collision with root package name */
    private List<androidx.vectordrawable.graphics.drawable.b> f19970j;

    /* renamed from: k  reason: collision with root package name */
    private androidx.vectordrawable.graphics.drawable.b f19971k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19972l;

    /* renamed from: m  reason: collision with root package name */
    private float f19973m;

    /* renamed from: n  reason: collision with root package name */
    final Paint f19974n = new Paint();

    /* renamed from: p  reason: collision with root package name */
    private int f19975p;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g.this.f();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            boolean unused = g.super.setVisible(false, false);
            g.this.e();
        }
    }

    class c extends Property<g, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(g gVar) {
            return Float.valueOf(gVar.h());
        }

        /* renamed from: b */
        public void set(g gVar, Float f10) {
            gVar.n(f10.floatValue());
        }
    }

    g(@NonNull Context context, @NonNull b bVar) {
        this.f19962a = context;
        this.f19963b = bVar;
        this.f19964c = new pf.a();
        setAlpha(255);
    }

    private void d(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f19972l;
        this.f19972l = true;
        for (ValueAnimator cancel : valueAnimatorArr) {
            cancel.cancel();
        }
        this.f19972l = z10;
    }

    /* access modifiers changed from: private */
    public void e() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f19971k;
        if (bVar != null) {
            bVar.b(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f19970j;
        if (list != null && !this.f19972l) {
            for (androidx.vectordrawable.graphics.drawable.b b10 : list) {
                b10.b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f19971k;
        if (bVar != null) {
            bVar.c(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f19970j;
        if (list != null && !this.f19972l) {
            for (androidx.vectordrawable.graphics.drawable.b c10 : list) {
                c10.c(this);
            }
        }
    }

    private void g(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f19972l;
        this.f19972l = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.f19972l = z10;
    }

    private void l() {
        if (this.f19965d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19961q, new float[]{0.0f, 1.0f});
            this.f19965d = ofFloat;
            ofFloat.setDuration(500);
            this.f19965d.setInterpolator(cf.a.f18978b);
            p(this.f19965d);
        }
        if (this.f19966e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f19961q, new float[]{1.0f, 0.0f});
            this.f19966e = ofFloat2;
            ofFloat2.setDuration(500);
            this.f19966e.setInterpolator(cf.a.f18978b);
            o(this.f19966e);
        }
    }

    private void o(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f19966e;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f19966e = valueAnimator;
            valueAnimator.addListener(new b());
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void p(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f19965d;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f19965d = valueAnimator;
            valueAnimator.addListener(new a());
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public int getAlpha() {
        return this.f19975p;
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        if (!this.f19963b.b() && !this.f19963b.a()) {
            return 1.0f;
        }
        if (this.f19968g || this.f19967f) {
            return this.f19969h;
        }
        return this.f19973m;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f19966e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f19968g;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f19965d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f19967f;
    }

    public void m(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        if (this.f19970j == null) {
            this.f19970j = new ArrayList();
        }
        if (!this.f19970j.contains(bVar)) {
            this.f19970j.add(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(float f10) {
        if (this.f19973m != f10) {
            this.f19973m = f10;
            invalidateSelf();
        }
    }

    public boolean q(boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float a10 = this.f19964c.a(this.f19962a.getContentResolver());
        if (!z12 || a10 <= 0.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        return r(z10, z11, z13);
    }

    /* access modifiers changed from: package-private */
    public boolean r(boolean z10, boolean z11, boolean z12) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z13;
        boolean z14;
        l();
        if (!isVisible() && !z10) {
            return false;
        }
        if (z10) {
            valueAnimator = this.f19965d;
        } else {
            valueAnimator = this.f19966e;
        }
        if (z10) {
            valueAnimator2 = this.f19966e;
        } else {
            valueAnimator2 = this.f19965d;
        }
        if (!z12) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z10, false);
        } else if (z12 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (!z10 || super.setVisible(z10, false)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z10) {
                z14 = this.f19963b.b();
            } else {
                z14 = this.f19963b.a();
            }
            if (!z14) {
                g(valueAnimator);
                return z13;
            }
            if (z11 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z13;
        }
    }

    public boolean s(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f19970j;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f19970j.remove(bVar);
        if (!this.f19970j.isEmpty()) {
            return true;
        }
        this.f19970j = null;
        return true;
    }

    public void setAlpha(int i10) {
        this.f19975p = i10;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19974n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setVisible(boolean z10, boolean z11) {
        return q(z10, z11, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
