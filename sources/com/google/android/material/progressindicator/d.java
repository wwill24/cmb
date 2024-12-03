package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.annotation.NonNull;

final class d extends i<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f19938l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f19939m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f19940n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property<d, Float> f19941o;

    /* renamed from: p  reason: collision with root package name */
    private static final Property<d, Float> f19942p;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f19943d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f19944e;

    /* renamed from: f  reason: collision with root package name */
    private final j1.b f19945f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final b f19946g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f19947h = 0;

    /* renamed from: i  reason: collision with root package name */
    private float f19948i;

    /* renamed from: j  reason: collision with root package name */
    private float f19949j;

    /* renamed from: k  reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f19950k = null;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            int unused = dVar.f19947h = (dVar.f19947h + 4) % d.this.f19946g.f19930c.length;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            androidx.vectordrawable.graphics.drawable.b bVar = dVar.f19950k;
            if (bVar != null) {
                bVar.b(dVar.f19980a);
            }
        }
    }

    class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        /* renamed from: b */
        public void set(d dVar, Float f10) {
            dVar.t(f10.floatValue());
        }
    }

    /* renamed from: com.google.android.material.progressindicator.d$d  reason: collision with other inner class name */
    class C0240d extends Property<d, Float> {
        C0240d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        /* renamed from: b */
        public void set(d dVar, Float f10) {
            dVar.u(f10.floatValue());
        }
    }

    static {
        Class<Float> cls = Float.class;
        f19941o = new c(cls, "animationFraction");
        f19942p = new C0240d(cls, "completeEndFraction");
    }

    public d(@NonNull e eVar) {
        super(1);
        this.f19946g = eVar;
        this.f19945f = new j1.b();
    }

    /* access modifiers changed from: private */
    public float o() {
        return this.f19948i;
    }

    /* access modifiers changed from: private */
    public float p() {
        return this.f19949j;
    }

    private void q() {
        if (this.f19943d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19941o, new float[]{0.0f, 1.0f});
            this.f19943d = ofFloat;
            ofFloat.setDuration(5400);
            this.f19943d.setInterpolator((TimeInterpolator) null);
            this.f19943d.setRepeatCount(-1);
            this.f19943d.addListener(new a());
        }
        if (this.f19944e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f19942p, new float[]{0.0f, 1.0f});
            this.f19944e = ofFloat2;
            ofFloat2.setDuration(333);
            this.f19944e.setInterpolator(this.f19945f);
            this.f19944e.addListener(new b());
        }
    }

    private void r(int i10) {
        int i11 = 0;
        while (i11 < 4) {
            float b10 = b(i10, f19940n[i11], 333);
            if (b10 < 0.0f || b10 > 1.0f) {
                i11++;
            } else {
                int i12 = i11 + this.f19947h;
                int[] iArr = this.f19946g.f19930c;
                int length = i12 % iArr.length;
                this.f19982c[0] = cf.c.b().evaluate(this.f19945f.getInterpolation(b10), Integer.valueOf(hf.a.a(iArr[length], this.f19980a.getAlpha())), Integer.valueOf(hf.a.a(this.f19946g.f19930c[(length + 1) % iArr.length], this.f19980a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void u(float f10) {
        this.f19949j = f10;
    }

    private void v(int i10) {
        float[] fArr = this.f19981b;
        float f10 = this.f19948i;
        fArr[0] = (f10 * 1520.0f) - 0.21875f;
        fArr[1] = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f19938l[i11], 667);
            float[] fArr2 = this.f19981b;
            fArr2[1] = fArr2[1] + (this.f19945f.getInterpolation(b10) * 250.0f);
            float b11 = b(i10, f19939m[i11], 667);
            float[] fArr3 = this.f19981b;
            fArr3[0] = fArr3[0] + (this.f19945f.getInterpolation(b11) * 250.0f);
        }
        float[] fArr4 = this.f19981b;
        float f11 = fArr4[0];
        float f12 = fArr4[1];
        float f13 = f11 + ((f12 - f11) * this.f19949j);
        fArr4[0] = f13;
        fArr4[0] = f13 / 360.0f;
        fArr4[1] = f12 / 360.0f;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        ObjectAnimator objectAnimator = this.f19943d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        s();
    }

    public void d(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        this.f19950k = bVar;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ObjectAnimator objectAnimator = this.f19944e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f19980a.isVisible()) {
                this.f19944e.start();
            } else {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        q();
        s();
        this.f19943d.start();
    }

    public void h() {
        this.f19950k = null;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f19947h = 0;
        this.f19982c[0] = hf.a.a(this.f19946g.f19930c[0], this.f19980a.getAlpha());
        this.f19949j = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void t(float f10) {
        this.f19948i = f10;
        int i10 = (int) (f10 * 5400.0f);
        v(i10);
        r(i10);
        this.f19980a.invalidateSelf();
    }
}
