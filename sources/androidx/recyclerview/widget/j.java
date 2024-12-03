package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.recyclerview.widget.RecyclerView;

class j extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* renamed from: a  reason: collision with root package name */
    private final int f6585a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6586b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f6587c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f6588d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6589e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6590f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f6591g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f6592h;

    /* renamed from: i  reason: collision with root package name */
    private final int f6593i;

    /* renamed from: j  reason: collision with root package name */
    private final int f6594j;

    /* renamed from: k  reason: collision with root package name */
    int f6595k;

    /* renamed from: l  reason: collision with root package name */
    int f6596l;

    /* renamed from: m  reason: collision with root package name */
    float f6597m;

    /* renamed from: n  reason: collision with root package name */
    int f6598n;

    /* renamed from: o  reason: collision with root package name */
    int f6599o;

    /* renamed from: p  reason: collision with root package name */
    float f6600p;

    /* renamed from: q  reason: collision with root package name */
    private int f6601q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f6602r = 0;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f6603s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6604t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6605u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f6606v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f6607w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f6608x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f6609y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f6610z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            j.this.s(500);
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
            j.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6613a = false;

        c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f6613a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f6613a) {
                this.f6613a = false;
            } else if (((Float) j.this.f6610z.getAnimatedValue()).floatValue() == 0.0f) {
                j jVar = j.this;
                jVar.A = 0;
                jVar.A(0);
            } else {
                j jVar2 = j.this;
                jVar2.A = 2;
                jVar2.x();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j.this.f6587c.setAlpha(floatValue);
            j.this.f6588d.setAlpha(floatValue);
            j.this.x();
        }
    }

    j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f6610z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f6587c = stateListDrawable;
        this.f6588d = drawable;
        this.f6591g = stateListDrawable2;
        this.f6592h = drawable2;
        this.f6589e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f6590f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f6593i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f6594j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f6585a = i11;
        this.f6586b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    private void B() {
        this.f6603s.h(this);
        this.f6603s.k(this);
        this.f6603s.l(this.C);
    }

    private void E(float f10) {
        int[] r10 = r();
        float max = Math.max((float) r10[0], Math.min((float) r10[1], f10));
        if (Math.abs(((float) this.f6596l) - max) >= 2.0f) {
            int z10 = z(this.f6597m, max, r10, this.f6603s.computeVerticalScrollRange(), this.f6603s.computeVerticalScrollOffset(), this.f6602r);
            if (z10 != 0) {
                this.f6603s.scrollBy(0, z10);
            }
            this.f6597m = max;
        }
    }

    private void m() {
        this.f6603s.removeCallbacks(this.B);
    }

    private void n() {
        this.f6603s.g1(this);
        this.f6603s.i1(this);
        this.f6603s.j1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i10 = this.f6602r;
        int i11 = this.f6593i;
        int i12 = i10 - i11;
        int i13 = this.f6599o;
        int i14 = this.f6598n;
        int i15 = i13 - (i14 / 2);
        this.f6591g.setBounds(0, 0, i14, i11);
        this.f6592h.setBounds(0, 0, this.f6601q, this.f6594j);
        canvas.translate(0.0f, (float) i12);
        this.f6592h.draw(canvas);
        canvas.translate((float) i15, 0.0f);
        this.f6591g.draw(canvas);
        canvas.translate((float) (-i15), (float) (-i12));
    }

    private void p(Canvas canvas) {
        int i10 = this.f6601q;
        int i11 = this.f6589e;
        int i12 = i10 - i11;
        int i13 = this.f6596l;
        int i14 = this.f6595k;
        int i15 = i13 - (i14 / 2);
        this.f6587c.setBounds(0, 0, i11, i14);
        this.f6588d.setBounds(0, 0, this.f6590f, this.f6602r);
        if (u()) {
            this.f6588d.draw(canvas);
            canvas.translate((float) this.f6589e, (float) i15);
            canvas.scale(-1.0f, 1.0f);
            this.f6587c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float) (-this.f6589e), (float) (-i15));
            return;
        }
        canvas.translate((float) i12, 0.0f);
        this.f6588d.draw(canvas);
        canvas.translate(0.0f, (float) i15);
        this.f6587c.draw(canvas);
        canvas.translate((float) (-i12), (float) (-i15));
    }

    private int[] q() {
        int[] iArr = this.f6609y;
        int i10 = this.f6586b;
        iArr[0] = i10;
        iArr[1] = this.f6601q - i10;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f6608x;
        int i10 = this.f6586b;
        iArr[0] = i10;
        iArr[1] = this.f6602r - i10;
        return iArr;
    }

    private void t(float f10) {
        int[] q10 = q();
        float max = Math.max((float) q10[0], Math.min((float) q10[1], f10));
        if (Math.abs(((float) this.f6599o) - max) >= 2.0f) {
            int z10 = z(this.f6600p, max, q10, this.f6603s.computeHorizontalScrollRange(), this.f6603s.computeHorizontalScrollOffset(), this.f6601q);
            if (z10 != 0) {
                this.f6603s.scrollBy(z10, 0);
            }
            this.f6600p = max;
        }
    }

    private boolean u() {
        return n0.B(this.f6603s) == 1;
    }

    private void y(int i10) {
        m();
        this.f6603s.postDelayed(this.B, (long) i10);
    }

    private int z(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / ((float) i13)) * ((float) i14));
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    /* access modifiers changed from: package-private */
    public void A(int i10) {
        if (i10 == 2 && this.f6606v != 2) {
            this.f6587c.setState(D);
            m();
        }
        if (i10 == 0) {
            x();
        } else {
            C();
        }
        if (this.f6606v == 2 && i10 != 2) {
            this.f6587c.setState(E);
            y(1200);
        } else if (i10 == 1) {
            y(1500);
        }
        this.f6606v = i10;
    }

    public void C() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f6610z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f6610z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f6610z.setDuration(500);
        this.f6610z.setStartDelay(0);
        this.f6610z.start();
    }

    /* access modifiers changed from: package-private */
    public void D(int i10, int i11) {
        boolean z10;
        boolean z11;
        int computeVerticalScrollRange = this.f6603s.computeVerticalScrollRange();
        int i12 = this.f6602r;
        if (computeVerticalScrollRange - i12 <= 0 || i12 < this.f6585a) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f6604t = z10;
        int computeHorizontalScrollRange = this.f6603s.computeHorizontalScrollRange();
        int i13 = this.f6601q;
        if (computeHorizontalScrollRange - i13 <= 0 || i13 < this.f6585a) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f6605u = z11;
        boolean z12 = this.f6604t;
        if (z12 || z11) {
            if (z12) {
                float f10 = (float) i12;
                this.f6596l = (int) ((f10 * (((float) i11) + (f10 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f6595k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (this.f6605u) {
                float f11 = (float) i13;
                this.f6599o = (int) ((f11 * (((float) i10) + (f11 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f6598n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
            }
            int i14 = this.f6606v;
            if (i14 == 0 || i14 == 1) {
                A(1);
            }
        } else if (this.f6606v != 0) {
            A(0);
        }
    }

    public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f6606v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean w10 = w(motionEvent.getX(), motionEvent.getY());
                boolean v10 = v(motionEvent.getX(), motionEvent.getY());
                if (w10 || v10) {
                    if (v10) {
                        this.f6607w = 1;
                        this.f6600p = (float) ((int) motionEvent.getX());
                    } else if (w10) {
                        this.f6607w = 2;
                        this.f6597m = (float) ((int) motionEvent.getY());
                    }
                    A(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f6606v == 2) {
                this.f6597m = 0.0f;
                this.f6600p = 0.0f;
                A(1);
                this.f6607w = 0;
            } else if (motionEvent.getAction() == 2 && this.f6606v == 2) {
                C();
                if (this.f6607w == 1) {
                    t(motionEvent.getX());
                }
                if (this.f6607w == 2) {
                    E(motionEvent.getY());
                }
            }
        }
    }

    public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i10 = this.f6606v;
        if (i10 == 1) {
            boolean w10 = w(motionEvent.getX(), motionEvent.getY());
            boolean v10 = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!w10 && !v10) {
                return false;
            }
            if (v10) {
                this.f6607w = 1;
                this.f6600p = (float) ((int) motionEvent.getX());
            } else if (w10) {
                this.f6607w = 2;
                this.f6597m = (float) ((int) motionEvent.getY());
            }
            A(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    public void e(boolean z10) {
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f6601q != this.f6603s.getWidth() || this.f6602r != this.f6603s.getHeight()) {
            this.f6601q = this.f6603s.getWidth();
            this.f6602r = this.f6603s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.f6604t) {
                p(canvas);
            }
            if (this.f6605u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6603s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                n();
            }
            this.f6603s = recyclerView;
            if (recyclerView != null) {
                B();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f6610z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f6610z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f6610z.setDuration((long) i10);
        this.f6610z.start();
    }

    /* access modifiers changed from: package-private */
    public boolean v(float f10, float f11) {
        if (f11 >= ((float) (this.f6602r - this.f6593i))) {
            int i10 = this.f6599o;
            int i11 = this.f6598n;
            return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) (i10 + (i11 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean w(float f10, float f11) {
        if (!u() ? f10 >= ((float) (this.f6601q - this.f6589e)) : f10 <= ((float) this.f6589e)) {
            int i10 = this.f6596l;
            int i11 = this.f6595k;
            return f11 >= ((float) (i10 - (i11 / 2))) && f11 <= ((float) (i10 + (i11 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.f6603s.invalidate();
    }
}
