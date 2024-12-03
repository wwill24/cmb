package c3;

import android.view.Choreographer;
import com.airbnb.lottie.c;
import com.airbnb.lottie.h;

public class g extends c implements Choreographer.FrameCallback {

    /* renamed from: d  reason: collision with root package name */
    private float f7929d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7930e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f7931f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f7932g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f7933h = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f7934j = 0;

    /* renamed from: k  reason: collision with root package name */
    private float f7935k = -2.14748365E9f;

    /* renamed from: l  reason: collision with root package name */
    private float f7936l = 2.14748365E9f;

    /* renamed from: m  reason: collision with root package name */
    private h f7937m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f7938n = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7939p = false;

    private void I() {
        if (this.f7937m != null) {
            float f10 = this.f7933h;
            if (f10 < this.f7935k || f10 > this.f7936l) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f7935k), Float.valueOf(this.f7936l), Float.valueOf(this.f7933h)}));
            }
        }
    }

    private float p() {
        h hVar = this.f7937m;
        if (hVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / hVar.i()) / Math.abs(this.f7929d);
    }

    private boolean t() {
        return s() < 0.0f;
    }

    public void A() {
        G(-s());
    }

    public void B(h hVar) {
        boolean z10;
        if (this.f7937m == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7937m = hVar;
        if (z10) {
            E(Math.max(this.f7935k, hVar.p()), Math.min(this.f7936l, hVar.f()));
        } else {
            E((float) ((int) hVar.p()), (float) ((int) hVar.f()));
        }
        float f10 = this.f7933h;
        this.f7933h = 0.0f;
        this.f7932g = 0.0f;
        C((float) ((int) f10));
        i();
    }

    public void C(float f10) {
        if (this.f7932g != f10) {
            float b10 = i.b(f10, r(), q());
            this.f7932g = b10;
            if (this.f7939p) {
                b10 = (float) Math.floor((double) b10);
            }
            this.f7933h = b10;
            this.f7931f = 0;
            i();
        }
    }

    public void D(float f10) {
        E(this.f7935k, f10);
    }

    public void E(float f10, float f11) {
        float f12;
        float f13;
        if (f10 <= f11) {
            h hVar = this.f7937m;
            if (hVar == null) {
                f12 = -3.4028235E38f;
            } else {
                f12 = hVar.p();
            }
            h hVar2 = this.f7937m;
            if (hVar2 == null) {
                f13 = Float.MAX_VALUE;
            } else {
                f13 = hVar2.f();
            }
            float b10 = i.b(f10, f12, f13);
            float b11 = i.b(f11, f12, f13);
            if (b10 != this.f7935k || b11 != this.f7936l) {
                this.f7935k = b10;
                this.f7936l = b11;
                C((float) ((int) i.b(this.f7933h, b10, b11)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f10), Float.valueOf(f11)}));
    }

    public void F(int i10) {
        E((float) i10, (float) ((int) this.f7936l));
    }

    public void G(float f10) {
        this.f7929d = f10;
    }

    public void H(boolean z10) {
        this.f7939p = z10;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        b(t());
    }

    public void cancel() {
        a();
        x();
    }

    public void doFrame(long j10) {
        float f10;
        float f11;
        w();
        if (this.f7937m != null && isRunning()) {
            c.a("LottieValueAnimator#doFrame");
            long j11 = this.f7931f;
            long j12 = 0;
            if (j11 != 0) {
                j12 = j10 - j11;
            }
            float p10 = ((float) j12) / p();
            float f12 = this.f7932g;
            if (t()) {
                p10 = -p10;
            }
            float f13 = f12 + p10;
            boolean z10 = !i.d(f13, r(), q());
            float f14 = this.f7932g;
            float b10 = i.b(f13, r(), q());
            this.f7932g = b10;
            if (this.f7939p) {
                b10 = (float) Math.floor((double) b10);
            }
            this.f7933h = b10;
            this.f7931f = j10;
            if (!this.f7939p || this.f7932g != f14) {
                i();
            }
            if (z10) {
                if (getRepeatCount() == -1 || this.f7934j < getRepeatCount()) {
                    d();
                    this.f7934j++;
                    if (getRepeatMode() == 2) {
                        this.f7930e = !this.f7930e;
                        A();
                    } else {
                        if (t()) {
                            f10 = q();
                        } else {
                            f10 = r();
                        }
                        this.f7932g = f10;
                        this.f7933h = f10;
                    }
                    this.f7931f = j10;
                } else {
                    if (this.f7929d < 0.0f) {
                        f11 = r();
                    } else {
                        f11 = q();
                    }
                    this.f7932g = f11;
                    this.f7933h = f11;
                    x();
                    b(t());
                }
            }
            I();
            c.b("LottieValueAnimator#doFrame");
        }
    }

    public float getAnimatedFraction() {
        float r10;
        float q10;
        float r11;
        if (this.f7937m == null) {
            return 0.0f;
        }
        if (t()) {
            r10 = q() - this.f7933h;
            q10 = q();
            r11 = r();
        } else {
            r10 = this.f7933h - r();
            q10 = q();
            r11 = r();
        }
        return r10 / (q10 - r11);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(l());
    }

    public long getDuration() {
        h hVar = this.f7937m;
        if (hVar == null) {
            return 0;
        }
        return (long) hVar.d();
    }

    public boolean isRunning() {
        return this.f7938n;
    }

    public void j() {
        this.f7937m = null;
        this.f7935k = -2.14748365E9f;
        this.f7936l = 2.14748365E9f;
    }

    public void k() {
        x();
        b(t());
    }

    public float l() {
        h hVar = this.f7937m;
        if (hVar == null) {
            return 0.0f;
        }
        return (this.f7933h - hVar.p()) / (this.f7937m.f() - this.f7937m.p());
    }

    public float o() {
        return this.f7933h;
    }

    public float q() {
        h hVar = this.f7937m;
        if (hVar == null) {
            return 0.0f;
        }
        float f10 = this.f7936l;
        if (f10 == 2.14748365E9f) {
            return hVar.f();
        }
        return f10;
    }

    public float r() {
        h hVar = this.f7937m;
        if (hVar == null) {
            return 0.0f;
        }
        float f10 = this.f7935k;
        if (f10 == -2.14748365E9f) {
            return hVar.p();
        }
        return f10;
    }

    public float s() {
        return this.f7929d;
    }

    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 != 2 && this.f7930e) {
            this.f7930e = false;
            A();
        }
    }

    public void u() {
        x();
        c();
    }

    public void v() {
        float f10;
        this.f7938n = true;
        h(t());
        if (t()) {
            f10 = q();
        } else {
            f10 = r();
        }
        C((float) ((int) f10));
        this.f7931f = 0;
        this.f7934j = 0;
        w();
    }

    /* access modifiers changed from: protected */
    public void w() {
        if (isRunning()) {
            y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        y(true);
    }

    /* access modifiers changed from: protected */
    public void y(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f7938n = false;
        }
    }

    public void z() {
        this.f7938n = true;
        w();
        this.f7931f = 0;
        if (t() && o() == r()) {
            C(q());
        } else if (!t() && o() == q()) {
            C(r());
        }
        e();
    }
}
