package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.n0;

public abstract class a implements View.OnTouchListener {

    /* renamed from: x  reason: collision with root package name */
    private static final int f4925x = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0049a f4926a = new C0049a();

    /* renamed from: b  reason: collision with root package name */
    private final Interpolator f4927b = new AccelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    final View f4928c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f4929d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f4930e = {0.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    private float[] f4931f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g  reason: collision with root package name */
    private int f4932g;

    /* renamed from: h  reason: collision with root package name */
    private int f4933h;

    /* renamed from: j  reason: collision with root package name */
    private float[] f4934j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f4935k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    private float[] f4936l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m  reason: collision with root package name */
    private boolean f4937m;

    /* renamed from: n  reason: collision with root package name */
    boolean f4938n;

    /* renamed from: p  reason: collision with root package name */
    boolean f4939p;

    /* renamed from: q  reason: collision with root package name */
    boolean f4940q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4941t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4942w;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0049a {

        /* renamed from: a  reason: collision with root package name */
        private int f4943a;

        /* renamed from: b  reason: collision with root package name */
        private int f4944b;

        /* renamed from: c  reason: collision with root package name */
        private float f4945c;

        /* renamed from: d  reason: collision with root package name */
        private float f4946d;

        /* renamed from: e  reason: collision with root package name */
        private long f4947e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f4948f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f4949g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f4950h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f4951i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f4952j;

        /* renamed from: k  reason: collision with root package name */
        private int f4953k;

        C0049a() {
        }

        private float e(long j10) {
            long j11 = this.f4947e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f4951i;
            if (j12 < 0 || j10 < j12) {
                return a.e(((float) (j10 - j11)) / ((float) this.f4943a), 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f4952j;
            return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / ((float) this.f4953k), 0.0f, 1.0f));
        }

        private float g(float f10) {
            return (-4.0f * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f4948f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                this.f4948f = currentAnimationTimeMillis;
                float f10 = ((float) (currentAnimationTimeMillis - this.f4948f)) * g10;
                this.f4949g = (int) (this.f4945c * f10);
                this.f4950h = (int) (f10 * this.f4946d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f4949g;
        }

        public int c() {
            return this.f4950h;
        }

        public int d() {
            float f10 = this.f4945c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f4946d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            if (this.f4951i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.f4951i + ((long) this.f4953k)) {
                return false;
            }
            return true;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f4953k = a.f((int) (currentAnimationTimeMillis - this.f4947e), 0, this.f4944b);
            this.f4952j = e(currentAnimationTimeMillis);
            this.f4951i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f4944b = i10;
        }

        public void k(int i10) {
            this.f4943a = i10;
        }

        public void l(float f10, float f11) {
            this.f4945c = f10;
            this.f4946d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f4947e = currentAnimationTimeMillis;
            this.f4951i = -1;
            this.f4948f = currentAnimationTimeMillis;
            this.f4952j = 0.5f;
            this.f4949g = 0;
            this.f4950h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f4940q) {
                if (aVar.f4938n) {
                    aVar.f4938n = false;
                    aVar.f4926a.m();
                }
                C0049a aVar2 = a.this.f4926a;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f4940q = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f4939p) {
                    aVar3.f4939p = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                n0.k0(a.this.f4928c, this);
            }
        }
    }

    public a(@NonNull View view) {
        this.f4928c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (float) ((int) ((1575.0f * f10) + 0.5f));
        o(f11, f11);
        float f12 = (float) ((int) ((f10 * 315.0f) + 0.5f));
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f4925x);
        r(500);
        q(500);
    }

    private float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f4930e[i10], f11, this.f4931f[i10], f10);
        int i11 = (h10 > 0.0f ? 1 : (h10 == 0.0f ? 0 : -1));
        if (i11 == 0) {
            return 0.0f;
        }
        float f13 = this.f4934j[i10];
        float f14 = this.f4935k[i10];
        float f15 = this.f4936l[i10];
        float f16 = f13 * f12;
        if (i11 > 0) {
            return e(h10 * f16, f14, f15);
        }
        return -e((-h10) * f16, f14, f15);
    }

    static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f4932g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (!this.f4940q || i10 != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    private float h(float f10, float f11, float f12, float f13) {
        float f14;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            f14 = -this.f4927b.getInterpolation(-g10);
        } else if (g10 <= 0.0f) {
            return 0.0f;
        } else {
            f14 = this.f4927b.getInterpolation(g10);
        }
        return e(f14, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f4938n) {
            this.f4940q = false;
        } else {
            this.f4926a.i();
        }
    }

    private void v() {
        int i10;
        if (this.f4929d == null) {
            this.f4929d = new b();
        }
        this.f4940q = true;
        this.f4938n = true;
        if (this.f4937m || (i10 = this.f4933h) <= 0) {
            this.f4929d.run();
        } else {
            n0.l0(this.f4928c, this.f4929d, (long) i10);
        }
        this.f4937m = true;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f4928c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i10, int i11);

    @NonNull
    public a k(int i10) {
        this.f4933h = i10;
        return this;
    }

    @NonNull
    public a l(int i10) {
        this.f4932g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f4941t && !z10) {
            i();
        }
        this.f4941t = z10;
        return this;
    }

    @NonNull
    public a n(float f10, float f11) {
        float[] fArr = this.f4931f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @NonNull
    public a o(float f10, float f11) {
        float[] fArr = this.f4936l;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f4941t
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f4939p = r2
            r5.f4937m = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f4928c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f4928c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f4926a
            r7.l(r0, r6)
            boolean r6 = r5.f4940q
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f4942w
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f4940q
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @NonNull
    public a p(float f10, float f11) {
        float[] fArr = this.f4935k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    @NonNull
    public a q(int i10) {
        this.f4926a.j(i10);
        return this;
    }

    @NonNull
    public a r(int i10) {
        this.f4926a.k(i10);
        return this;
    }

    @NonNull
    public a s(float f10, float f11) {
        float[] fArr = this.f4930e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @NonNull
    public a t(float f10, float f11) {
        float[] fArr = this.f4934j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        C0049a aVar = this.f4926a;
        int f10 = aVar.f();
        int d10 = aVar.d();
        if ((f10 == 0 || !b(f10)) && (d10 == 0 || !a(d10))) {
            return false;
        }
        return true;
    }
}
