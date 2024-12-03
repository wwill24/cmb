package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.k;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.f0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements f0 {
    public static boolean B0;
    ArrayList<Integer> A0;
    Interpolator F;
    Interpolator G;
    float H;
    /* access modifiers changed from: private */
    public int I;
    int J;
    /* access modifiers changed from: private */
    public int K;
    private boolean L;
    HashMap<View, g> M;
    private long N;
    private float O;
    float P;
    float Q;
    private long R;
    float S;
    private boolean T;
    boolean U;
    private d V;
    int W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f3994a0;

    /* renamed from: b0  reason: collision with root package name */
    private b f3995b0;

    /* renamed from: c0  reason: collision with root package name */
    boolean f3996c0;

    /* renamed from: d0  reason: collision with root package name */
    float f3997d0;

    /* renamed from: e0  reason: collision with root package name */
    float f3998e0;

    /* renamed from: f0  reason: collision with root package name */
    long f3999f0;

    /* renamed from: g0  reason: collision with root package name */
    float f4000g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f4001h0;

    /* renamed from: i0  reason: collision with root package name */
    private ArrayList<h> f4002i0;

    /* renamed from: j0  reason: collision with root package name */
    private ArrayList<h> f4003j0;

    /* renamed from: k0  reason: collision with root package name */
    private ArrayList<h> f4004k0;

    /* renamed from: l0  reason: collision with root package name */
    private CopyOnWriteArrayList<d> f4005l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f4006m0;

    /* renamed from: n0  reason: collision with root package name */
    private float f4007n0;

    /* renamed from: o0  reason: collision with root package name */
    boolean f4008o0;

    /* renamed from: p0  reason: collision with root package name */
    protected boolean f4009p0;

    /* renamed from: q0  reason: collision with root package name */
    float f4010q0;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f4011r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public c f4012s0;

    /* renamed from: t0  reason: collision with root package name */
    private Runnable f4013t0;

    /* renamed from: u0  reason: collision with root package name */
    private int[] f4014u0;

    /* renamed from: v0  reason: collision with root package name */
    int f4015v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f4016w0;

    /* renamed from: x0  reason: collision with root package name */
    private boolean f4017x0;

    /* renamed from: y0  reason: collision with root package name */
    TransitionState f4018y0;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f4019z0;

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            MotionLayout.this.f4012s0.a();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4026a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4026a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4026a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4026a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4026a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.b.<clinit>():void");
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        float f4027a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f4028b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f4029c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f4030d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f4031e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f4032f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f4033g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f4034h = "motion.EndState";

        c() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10 = this.f4029c;
            if (!(i10 == -1 && this.f4030d == -1)) {
                if (i10 == -1) {
                    MotionLayout.this.O(this.f4030d);
                } else {
                    int i11 = this.f4030d;
                    if (i11 == -1) {
                        MotionLayout.this.L(i10, -1, -1);
                    } else {
                        MotionLayout.this.M(i10, i11);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.f4028b)) {
                MotionLayout.this.K(this.f4027a, this.f4028b);
                this.f4027a = Float.NaN;
                this.f4028b = Float.NaN;
                this.f4029c = -1;
                this.f4030d = -1;
            } else if (!Float.isNaN(this.f4027a)) {
                MotionLayout.this.setProgress(this.f4027a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f4027a);
            bundle.putFloat("motion.velocity", this.f4028b);
            bundle.putInt("motion.StartState", this.f4029c);
            bundle.putInt("motion.EndState", this.f4030d);
            return bundle;
        }

        public void c() {
            this.f4030d = MotionLayout.this.K;
            this.f4029c = MotionLayout.this.I;
            this.f4028b = MotionLayout.this.getVelocity();
            this.f4027a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f4030d = i10;
        }

        public void e(float f10) {
            this.f4027a = f10;
        }

        public void f(int i10) {
            this.f4029c = i10;
        }

        public void g(Bundle bundle) {
            this.f4027a = bundle.getFloat("motion.progress");
            this.f4028b = bundle.getFloat("motion.velocity");
            this.f4029c = bundle.getInt("motion.StartState");
            this.f4030d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f4028b = f10;
        }
    }

    public interface d {
        void a(MotionLayout motionLayout, int i10, int i11, float f10);

        void b(MotionLayout motionLayout, int i10);

        void c(MotionLayout motionLayout, int i10, int i11);
    }

    private void G() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.V != null || ((copyOnWriteArrayList = this.f4005l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f4007n0 != this.P) {
            if (this.f4006m0 != -1) {
                d dVar = this.V;
                if (dVar != null) {
                    dVar.c(this, this.I, this.K);
                }
                CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f4005l0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<d> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().c(this, this.I, this.K);
                    }
                }
                this.f4008o0 = true;
            }
            this.f4006m0 = -1;
            float f10 = this.P;
            this.f4007n0 = f10;
            d dVar2 = this.V;
            if (dVar2 != null) {
                dVar2.a(this, this.I, this.K, f10);
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList3 = this.f4005l0;
            if (copyOnWriteArrayList3 != null) {
                Iterator<d> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.I, this.K, this.P);
                }
            }
            this.f4008o0 = true;
        }
    }

    private void J() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if (this.V != null || ((copyOnWriteArrayList = this.f4005l0) != null && !copyOnWriteArrayList.isEmpty())) {
            this.f4008o0 = false;
            Iterator<Integer> it = this.A0.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                d dVar = this.V;
                if (dVar != null) {
                    dVar.b(this, next.intValue());
                }
                CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f4005l0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<d> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().b(this, next.intValue());
                    }
                }
            }
            this.A0.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void E(float f10) {
    }

    /* access modifiers changed from: package-private */
    public void F(boolean z10) {
        boolean z11;
        boolean z12;
        float f10;
        boolean z13;
        boolean z14;
        float f11;
        boolean z15;
        int i10;
        int i11;
        float f12;
        boolean z16;
        if (this.R == -1) {
            this.R = getNanoTime();
        }
        float f13 = this.Q;
        if (f13 > 0.0f && f13 < 1.0f) {
            this.J = -1;
        }
        if (this.f4001h0 || (this.U && (z10 || this.S != f13))) {
            float signum = Math.signum(this.S - f13);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.F;
            if (!(interpolator instanceof i)) {
                f10 = ((((float) (nanoTime - this.R)) * signum) * 1.0E-9f) / this.O;
            } else {
                f10 = 0.0f;
            }
            float f14 = this.Q + f10;
            if (this.T) {
                f14 = this.S;
            }
            int i12 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i12 <= 0 || f14 < this.S) && (signum > 0.0f || f14 > this.S)) {
                z13 = false;
            } else {
                f14 = this.S;
                this.U = false;
                z13 = true;
            }
            this.Q = f14;
            this.P = f14;
            this.R = nanoTime;
            if (interpolator == null || z13) {
                this.H = f10;
            } else {
                if (this.f3994a0) {
                    f12 = interpolator.getInterpolation(((float) (nanoTime - this.N)) * 1.0E-9f);
                    Interpolator interpolator2 = this.F;
                    interpolator2.getClass();
                    this.Q = f12;
                    this.R = nanoTime;
                    if (interpolator2 instanceof i) {
                        float a10 = ((i) interpolator2).a();
                        this.H = a10;
                        int i13 = ((Math.abs(a10) * this.O) > 1.0E-5f ? 1 : ((Math.abs(a10) * this.O) == 1.0E-5f ? 0 : -1));
                        if (a10 <= 0.0f || f12 < 1.0f) {
                            z16 = false;
                        } else {
                            this.Q = 1.0f;
                            z16 = false;
                            this.U = false;
                            f12 = 1.0f;
                        }
                        if (a10 < 0.0f && f12 <= 0.0f) {
                            this.Q = 0.0f;
                            this.U = z16;
                            f14 = 0.0f;
                        }
                    }
                } else {
                    f12 = interpolator.getInterpolation(f14);
                    Interpolator interpolator3 = this.F;
                    if (interpolator3 instanceof i) {
                        this.H = ((i) interpolator3).a();
                    } else {
                        this.H = ((interpolator3.getInterpolation(f14 + f10) - f12) * signum) / f10;
                    }
                }
                f14 = f12;
            }
            if (Math.abs(this.H) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if ((i12 > 0 && f14 >= this.S) || (signum <= 0.0f && f14 <= this.S)) {
                f14 = this.S;
                this.U = false;
            }
            if (f14 >= 1.0f || f14 <= 0.0f) {
                z14 = false;
                this.U = false;
                setState(TransitionState.FINISHED);
            } else {
                z14 = false;
            }
            int childCount = getChildCount();
            this.f4001h0 = z14;
            long nanoTime2 = getNanoTime();
            this.f4010q0 = f14;
            Interpolator interpolator4 = this.G;
            if (interpolator4 == null) {
                f11 = f14;
            } else {
                f11 = interpolator4.getInterpolation(f14);
            }
            Interpolator interpolator5 = this.G;
            if (interpolator5 != null) {
                float interpolation = interpolator5.getInterpolation((signum / this.O) + f14);
                this.H = interpolation;
                this.H = interpolation - this.G.getInterpolation(f14);
            }
            for (int i14 = z14; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                g gVar = this.M.get(childAt);
                if (gVar != null) {
                    this.f4001h0 |= gVar.c(childAt, f11, nanoTime2, (n0.c) null);
                }
            }
            if ((i12 <= 0 || f14 < this.S) && (signum > 0.0f || f14 > this.S)) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (!this.f4001h0 && !this.U && z15) {
                setState(TransitionState.FINISHED);
            }
            if (this.f4009p0) {
                requestLayout();
            }
            z11 = true;
            boolean z17 = this.f4001h0 | (!z15);
            this.f4001h0 = z17;
            if (f14 <= 0.0f && (i11 = this.I) != -1 && this.J != i11) {
                this.J = i11;
                throw null;
            } else if (((double) f14) < 1.0d || this.J == (i10 = this.K)) {
                if (z17 || this.U) {
                    invalidate();
                } else if ((i12 > 0 && f14 == 1.0f) || (signum < 0.0f && f14 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
                if (!this.f4001h0 && !this.U && ((i12 > 0 && f14 == 1.0f) || (signum < 0.0f && f14 == 0.0f))) {
                    I();
                }
            } else {
                this.J = i10;
                throw null;
            }
        } else {
            z11 = true;
        }
        float f15 = this.Q;
        if (f15 >= 1.0f) {
            int i15 = this.J;
            int i16 = this.K;
            if (i15 == i16) {
                z11 = false;
            }
            this.J = i16;
        } else if (f15 <= 0.0f) {
            int i17 = this.J;
            int i18 = this.I;
            if (i17 == i18) {
                z11 = false;
            }
            this.J = i18;
        } else {
            z12 = false;
            this.f4019z0 |= z12;
            if (z12 && !this.f4011r0) {
                requestLayout();
            }
            this.P = this.Q;
        }
        z12 = z11;
        this.f4019z0 |= z12;
        requestLayout();
        this.P = this.Q;
    }

    /* access modifiers changed from: protected */
    public void H() {
        int i10;
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.V != null || ((copyOnWriteArrayList = this.f4005l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f4006m0 == -1) {
            this.f4006m0 = this.J;
            if (!this.A0.isEmpty()) {
                ArrayList<Integer> arrayList = this.A0;
                i10 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.J;
            if (!(i10 == i11 || i11 == -1)) {
                this.A0.add(Integer.valueOf(i11));
            }
        }
        J();
        Runnable runnable = this.f4013t0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f4014u0;
        if (iArr != null && this.f4015v0 > 0) {
            O(iArr[0]);
            int[] iArr2 = this.f4014u0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f4015v0--;
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
    }

    public void K(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.f4012s0 == null) {
                this.f4012s0 = new c();
            }
            this.f4012s0.e(f10);
            this.f4012s0.h(f11);
            return;
        }
        setProgress(f10);
        setState(TransitionState.MOVING);
        this.H = f11;
        float f12 = 0.0f;
        int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i10 != 0) {
            if (i10 > 0) {
                f12 = 1.0f;
            }
            E(f12);
        } else if (f10 != 0.0f && f10 != 1.0f) {
            if (f10 > 0.5f) {
                f12 = 1.0f;
            }
            E(f12);
        }
    }

    public void L(int i10, int i11, int i12) {
        setState(TransitionState.SETUP);
        this.J = i10;
        this.I = -1;
        this.K = -1;
        androidx.constraintlayout.widget.b bVar = this.f4125l;
        if (bVar != null) {
            bVar.d(i10, (float) i11, (float) i12);
        }
    }

    public void M(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f4012s0 == null) {
                this.f4012s0 = new c();
            }
            this.f4012s0.f(i10);
            this.f4012s0.d(i11);
        }
    }

    public void N() {
        E(1.0f);
        this.f4013t0 = null;
    }

    public void O(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f4012s0 == null) {
                this.f4012s0 = new c();
            }
            this.f4012s0.d(i10);
            return;
        }
        P(i10, -1, -1);
    }

    public void P(int i10, int i11, int i12) {
        Q(i10, i11, i12, -1);
    }

    public void Q(int i10, int i11, int i12, int i13) {
        int i14 = this.J;
        if (i14 != i10) {
            if (this.I == i10) {
                E(0.0f);
                if (i13 > 0) {
                    this.O = ((float) i13) / 1000.0f;
                }
            } else if (this.K == i10) {
                E(1.0f);
                if (i13 > 0) {
                    this.O = ((float) i13) / 1000.0f;
                }
            } else {
                this.K = i10;
                if (i14 != -1) {
                    M(i14, i10);
                    E(1.0f);
                    this.Q = 0.0f;
                    N();
                    if (i13 > 0) {
                        this.O = ((float) i13) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.f3994a0 = false;
                this.S = 1.0f;
                this.P = 0.0f;
                this.Q = 0.0f;
                this.R = getNanoTime();
                this.N = getNanoTime();
                this.T = false;
                this.F = null;
                if (i13 == -1) {
                    throw null;
                }
                this.I = -1;
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        ArrayList<h> arrayList = this.f4004k0;
        if (arrayList != null) {
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().w(canvas);
            }
        }
        F(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.J;
    }

    public ArrayList<k.a> getDefinedTransitions() {
        return null;
    }

    public b getDesignTool() {
        if (this.f3995b0 == null) {
            this.f3995b0 = new b(this);
        }
        return this.f3995b0;
    }

    public int getEndState() {
        return this.K;
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.Q;
    }

    public k getScene() {
        return null;
    }

    public int getStartState() {
        return this.I;
    }

    public float getTargetPosition() {
        return this.S;
    }

    public Bundle getTransitionState() {
        if (this.f4012s0 == null) {
            this.f4012s0 = new c();
        }
        this.f4012s0.c();
        return this.f4012s0.b();
    }

    public long getTransitionTimeMs() {
        return (long) (this.O * 1000.0f);
    }

    public float getVelocity() {
        return this.H;
    }

    public void i(@NonNull View view, @NonNull View view2, int i10, int i11) {
        this.f3999f0 = getNanoTime();
        this.f4000g0 = 0.0f;
        this.f3997d0 = 0.0f;
        this.f3998e0 = 0.0f;
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j(@NonNull View view, int i10) {
    }

    public void k(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
    }

    public void m(@NonNull View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (!(!this.f3996c0 && i10 == 0 && i11 == 0)) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.f3996c0 = false;
    }

    public void n(@NonNull View view, int i10, int i11, int i12, int i13, int i14) {
    }

    public boolean o(@NonNull View view, @NonNull View view2, int i10, int i11) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f4016w0 = display.getRotation();
        }
        I();
        c cVar = this.f4012s0;
        if (cVar == null) {
            return;
        }
        if (this.f4017x0) {
            post(new a());
        } else {
            cVar.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f4011r0 = true;
        try {
            super.onLayout(z10, i10, i11, i12, i13);
        } finally {
            this.f4011r0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View view, float f10, float f11) {
        return false;
    }

    public void onRtlPropertiesChanged(int i10) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof h) {
            h hVar = (h) view;
            if (this.f4005l0 == null) {
                this.f4005l0 = new CopyOnWriteArrayList<>();
            }
            this.f4005l0.add(hVar);
            if (hVar.v()) {
                if (this.f4002i0 == null) {
                    this.f4002i0 = new ArrayList<>();
                }
                this.f4002i0.add(hVar);
            }
            if (hVar.u()) {
                if (this.f4003j0 == null) {
                    this.f4003j0 = new ArrayList<>();
                }
                this.f4003j0.add(hVar);
            }
            if (hVar.t()) {
                if (this.f4004k0 == null) {
                    this.f4004k0 = new ArrayList<>();
                }
                this.f4004k0.add(hVar);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<h> arrayList = this.f4002i0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<h> arrayList2 = this.f4003j0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void requestLayout() {
        if (!this.f4009p0) {
            int i10 = this.J;
        }
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        this.W = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f4017x0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.L = z10;
    }

    public void setInterpolatedProgress(float f10) {
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<h> arrayList = this.f4003j0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4003j0.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<h> arrayList = this.f4002i0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4002i0.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i10 >= 0) {
            int i11 = (f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1));
        }
        if (!isAttachedToWindow()) {
            if (this.f4012s0 == null) {
                this.f4012s0 = new c();
            }
            this.f4012s0.e(f10);
        } else if (i10 <= 0) {
            if (this.Q == 1.0f && this.J == this.K) {
                setState(TransitionState.MOVING);
            }
            this.J = this.I;
            if (this.Q == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            if (this.Q == 0.0f && this.J == this.I) {
                setState(TransitionState.MOVING);
            }
            this.J = this.K;
            if (this.Q == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.J = -1;
            setState(TransitionState.MOVING);
        }
    }

    public void setScene(k kVar) {
        r();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void setStartState(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f4012s0 == null) {
                this.f4012s0 = new c();
            }
            this.f4012s0.f(i10);
            this.f4012s0.d(i10);
            return;
        }
        this.J = i10;
    }

    /* access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.J != -1) {
            TransitionState transitionState3 = this.f4018y0;
            this.f4018y0 = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                G();
            }
            int i10 = b.f4026a[transitionState3.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (transitionState == transitionState4) {
                    G();
                }
                if (transitionState == transitionState2) {
                    H();
                }
            } else if (i10 == 3 && transitionState == transitionState2) {
                H();
            }
        }
    }

    public void setTransition(int i10) {
    }

    /* access modifiers changed from: protected */
    public void setTransition(k.a aVar) {
        throw null;
    }

    public void setTransitionDuration(int i10) {
    }

    public void setTransitionListener(d dVar) {
        this.V = dVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f4012s0 == null) {
            this.f4012s0 = new c();
        }
        this.f4012s0.g(bundle);
        if (isAttachedToWindow()) {
            this.f4012s0.a();
        }
    }

    /* access modifiers changed from: protected */
    public void t(int i10) {
        this.f4125l = null;
    }

    public String toString() {
        Context context = getContext();
        return a.a(context, this.I) + "->" + a.a(context, this.K) + " (pos:" + this.Q + " Dpos/Dt:" + this.H;
    }
}
