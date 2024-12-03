package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.n;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.j;
import bf.k;
import bf.l;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import z0.c;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: h0  reason: collision with root package name */
    private static final int f19250h0 = k.Widget_Design_BottomSheet_Modal;
    private boolean A;
    private final BottomSheetBehavior<V>.defpackage.g B = new g(this, (a) null);
    private ValueAnimator C;
    int D;
    int E;
    int F;
    float G = 0.5f;
    int H;
    float I = -1.0f;
    boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public boolean L = true;
    int M = 4;
    int N = 4;
    z0.c O;
    private boolean P;
    private int Q;
    private boolean R;
    private float S = 0.1f;
    private int T;
    int U;
    int V;
    WeakReference<V> W;
    WeakReference<View> X;
    WeakReference<View> Y;
    @NonNull
    private final ArrayList<f> Z = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private int f19251a = 0;

    /* renamed from: a0  reason: collision with root package name */
    private VelocityTracker f19252a0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f19253b = true;

    /* renamed from: b0  reason: collision with root package name */
    int f19254b0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19255c = false;

    /* renamed from: c0  reason: collision with root package name */
    private int f19256c0;

    /* renamed from: d  reason: collision with root package name */
    private float f19257d;

    /* renamed from: d0  reason: collision with root package name */
    boolean f19258d0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f19259e;

    /* renamed from: e0  reason: collision with root package name */
    private Map<View, Integer> f19260e0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f19261f;

    /* renamed from: f0  reason: collision with root package name */
    final SparseIntArray f19262f0 = new SparseIntArray();

    /* renamed from: g  reason: collision with root package name */
    private boolean f19263g;

    /* renamed from: g0  reason: collision with root package name */
    private final c.C0226c f19264g0 = new d();

    /* renamed from: h  reason: collision with root package name */
    private int f19265h;

    /* renamed from: i  reason: collision with root package name */
    private int f19266i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public tf.g f19267j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f19268k;

    /* renamed from: l  reason: collision with root package name */
    private int f19269l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f19270m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f19271n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19272o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f19273p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f19274q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f19275r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19276s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f19277t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f19278u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f19279v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f19280w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f19281x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f19282y;

    /* renamed from: z  reason: collision with root package name */
    private tf.k f19283z;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f19289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19290b;

        a(View view, int i10) {
            this.f19289a = view;
            this.f19290b = i10;
        }

        public void run() {
            BottomSheetBehavior.this.Z0(this.f19289a, this.f19290b, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f19267j != null) {
                BottomSheetBehavior.this.f19267j.c0(floatValue);
            }
        }
    }

    class c implements r.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19293a;

        c(boolean z10) {
            this.f19293a = z10;
        }

        public k2 a(View view, k2 k2Var, r.e eVar) {
            boolean z10;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            androidx.core.graphics.b f10 = k2Var.f(k2.m.d());
            androidx.core.graphics.b f11 = k2Var.f(k2.m.c());
            int unused = BottomSheetBehavior.this.f19281x = f10.f4589b;
            boolean i15 = r.i(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f19273p) {
                int unused2 = BottomSheetBehavior.this.f19280w = k2Var.h();
                paddingBottom = eVar.f19902d + BottomSheetBehavior.this.f19280w;
            }
            if (BottomSheetBehavior.this.f19274q) {
                if (i15) {
                    i14 = eVar.f19901c;
                } else {
                    i14 = eVar.f19899a;
                }
                paddingLeft = i14 + f10.f4588a;
            }
            if (BottomSheetBehavior.this.f19275r) {
                if (i15) {
                    i13 = eVar.f19899a;
                } else {
                    i13 = eVar.f19901c;
                }
                paddingRight = i13 + f10.f4590c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z11 = true;
            if (!BottomSheetBehavior.this.f19277t || marginLayoutParams.leftMargin == (i12 = f10.f4588a)) {
                z10 = false;
            } else {
                marginLayoutParams.leftMargin = i12;
                z10 = true;
            }
            if (BottomSheetBehavior.this.f19278u && marginLayoutParams.rightMargin != (i11 = f10.f4590c)) {
                marginLayoutParams.rightMargin = i11;
                z10 = true;
            }
            if (!BottomSheetBehavior.this.f19279v || marginLayoutParams.topMargin == (i10 = f10.f4589b)) {
                z11 = z10;
            } else {
                marginLayoutParams.topMargin = i10;
            }
            if (z11) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f19293a) {
                int unused3 = BottomSheetBehavior.this.f19271n = f11.f4591d;
            }
            if (BottomSheetBehavior.this.f19273p || this.f19293a) {
                BottomSheetBehavior.this.e1(false);
            }
            return k2Var;
        }
    }

    class d extends c.C0226c {

        /* renamed from: a  reason: collision with root package name */
        private long f19295a;

        d() {
        }

        private boolean n(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.V + bottomSheetBehavior.m0()) / 2;
        }

        public int a(@NonNull View view, int i10, int i11) {
            return view.getLeft();
        }

        public int b(@NonNull View view, int i10, int i11) {
            return v0.a.b(i10, BottomSheetBehavior.this.m0(), e(view));
        }

        public int e(@NonNull View view) {
            if (BottomSheetBehavior.this.d0()) {
                return BottomSheetBehavior.this.V;
            }
            return BottomSheetBehavior.this.H;
        }

        public void j(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.L) {
                BottomSheetBehavior.this.R0(1);
            }
        }

        public void k(@NonNull View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.i0(i11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
            if (r9 > r7.f19296b.F) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.f19296b.m0()) < java.lang.Math.abs(r8.getTop() - r7.f19296b.F)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
            if (r7.f19296b.X0() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f1, code lost:
            if (java.lang.Math.abs(r9 - r7.f19296b.E) < java.lang.Math.abs(r9 - r7.f19296b.H)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x010d, code lost:
            if (r7.f19296b.X0() != false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0127, code lost:
            if (r7.f19296b.X0() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
            if (r10.U0(r0, (((float) r9) * 100.0f) / ((float) r10.V)) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 6
                r3 = 3
                r4 = 4
                if (r1 >= 0) goto L_0x003f
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.f19253b
                if (r9 == 0) goto L_0x0013
            L_0x0010:
                r2 = r3
                goto L_0x012a
            L_0x0013:
                int r9 = r8.getTop()
                long r0 = java.lang.System.currentTimeMillis()
                long r5 = r7.f19295a
                long r0 = r0 - r5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.X0()
                if (r10 == 0) goto L_0x0037
                float r9 = (float) r9
                r10 = 1120403456(0x42c80000, float:100.0)
                float r9 = r9 * r10
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r2 = r10.V
                float r2 = (float) r2
                float r9 = r9 / r2
                boolean r9 = r10.U0(r0, r9)
                if (r9 == 0) goto L_0x00ad
                goto L_0x0010
            L_0x0037:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.F
                if (r9 <= r10) goto L_0x0010
                goto L_0x012a
            L_0x003f:
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r1.J
                if (r5 == 0) goto L_0x0094
                boolean r1 = r1.W0(r8, r10)
                if (r1 == 0) goto L_0x0094
                float r9 = java.lang.Math.abs(r9)
                float r0 = java.lang.Math.abs(r10)
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x0062
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f19259e
                float r9 = (float) r9
                int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r9 > 0) goto L_0x0068
            L_0x0062:
                boolean r9 = r7.n(r8)
                if (r9 == 0) goto L_0x006b
            L_0x0068:
                r2 = 5
                goto L_0x012a
            L_0x006b:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.f19253b
                if (r9 == 0) goto L_0x0074
                goto L_0x0010
            L_0x0074:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.m0()
                int r9 = r9 - r10
                int r9 = java.lang.Math.abs(r9)
                int r10 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.F
                int r10 = r10 - r0
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x012a
                goto L_0x0010
            L_0x0094:
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x00d2
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x00a5
                goto L_0x00d2
            L_0x00a5:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.f19253b
                if (r9 == 0) goto L_0x00b0
            L_0x00ad:
                r2 = r4
                goto L_0x012a
            L_0x00b0:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.F
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.H
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X0()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x00d2:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.f19253b
                if (r10 == 0) goto L_0x00f5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.E
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.H
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                goto L_0x0010
            L_0x00f5:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r10.F
                if (r9 >= r0) goto L_0x0110
                int r10 = r10.H
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0107
                goto L_0x0010
            L_0x0107:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X0()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x0110:
                int r10 = r9 - r0
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.H
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.X0()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x012a:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r9.Y0()
                r9.Z0(r8, r2, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        public boolean m(@NonNull View view, int i10) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.M;
            if (i11 == 1 || bottomSheetBehavior.f19258d0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f19254b0 == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.Y;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f19295a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.W;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    class e implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19297a;

        e(int i10) {
            this.f19297a = i10;
        }

        public boolean a(@NonNull View view, n.a aVar) {
            BottomSheetBehavior.this.Q0(this.f19297a);
            return true;
        }
    }

    public static abstract class f {
        /* access modifiers changed from: package-private */
        public void a(@NonNull View view) {
        }

        public abstract void b(@NonNull View view, float f10);

        public abstract void c(@NonNull View view, int i10);
    }

    public BottomSheetBehavior() {
    }

    private void A0() {
        this.f19254b0 = -1;
        VelocityTracker velocityTracker = this.f19252a0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f19252a0 = null;
        }
    }

    private void B0(@NonNull SavedState savedState) {
        int i10 = this.f19251a;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f19261f = savedState.f19285d;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f19253b = savedState.f19286e;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.J = savedState.f19287f;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.K = savedState.f19288g;
            }
        }
    }

    private void C0(V v10, Runnable runnable) {
        if (w0(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void T0(@NonNull View view) {
        boolean z10;
        if (Build.VERSION.SDK_INT < 29 || t0() || this.f19263g) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f19273p || this.f19274q || this.f19275r || this.f19277t || this.f19278u || this.f19279v || z10) {
            r.b(view, new c(z10));
        }
    }

    private boolean V0() {
        return this.O != null && (this.L || this.M == 1);
    }

    private int X(View view, int i10, int i11) {
        return n0.c(view, view.getResources().getString(i10), f0(i11));
    }

    private void Z() {
        int b02 = b0();
        if (this.f19253b) {
            this.H = Math.max(this.V - b02, this.E);
        } else {
            this.H = this.V - b02;
        }
    }

    /* access modifiers changed from: private */
    public void Z0(View view, int i10, boolean z10) {
        boolean z11;
        int q02 = q0(i10);
        z0.c cVar = this.O;
        if (cVar == null || (!z10 ? !cVar.H(view, view.getLeft(), q02) : !cVar.F(view.getLeft(), q02))) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            R0(2);
            c1(i10, true);
            this.B.c(i10);
            return;
        }
        R0(i10);
    }

    private void a0() {
        this.F = (int) (((float) this.V) * (1.0f - this.G));
    }

    private void a1() {
        WeakReference<V> weakReference = this.W;
        if (weakReference != null) {
            b1((View) weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.X;
        if (weakReference2 != null) {
            b1(weakReference2.get(), 1);
        }
    }

    private int b0() {
        int i10;
        if (this.f19263g) {
            return Math.min(Math.max(this.f19265h, this.V - ((this.U * 9) / 16)), this.T) + this.f19280w;
        }
        if (this.f19272o || this.f19273p || (i10 = this.f19271n) <= 0) {
            return this.f19261f + this.f19280w;
        }
        return Math.max(this.f19261f, i10 + this.f19266i);
    }

    private void b1(View view, int i10) {
        if (view != null) {
            e0(view, i10);
            int i11 = 6;
            if (!this.f19253b && this.M != 6) {
                this.f19262f0.put(i10, X(view, j.bottomsheet_action_expand_halfway, 6));
            }
            if (this.J && v0() && this.M != 5) {
                z0(view, k.a.f4779y, 5);
            }
            int i12 = this.M;
            if (i12 == 3) {
                if (this.f19253b) {
                    i11 = 4;
                }
                z0(view, k.a.f4778x, i11);
            } else if (i12 == 4) {
                if (this.f19253b) {
                    i11 = 3;
                }
                z0(view, k.a.f4777w, i11);
            } else if (i12 == 6) {
                z0(view, k.a.f4778x, 4);
                z0(view, k.a.f4777w, 3);
            }
        }
    }

    private float c0(int i10) {
        float f10;
        float f11;
        int i11 = this.H;
        if (i10 > i11 || i11 == m0()) {
            int i12 = this.H;
            f10 = (float) (i12 - i10);
            f11 = (float) (this.V - i12);
        } else {
            int i13 = this.H;
            f10 = (float) (i13 - i10);
            f11 = (float) (i13 - m0());
        }
        return f10 / f11;
    }

    private void c1(int i10, boolean z10) {
        boolean s02;
        ValueAnimator valueAnimator;
        if (i10 != 2 && this.A != (s02 = s0()) && this.f19267j != null) {
            this.A = s02;
            float f10 = 0.0f;
            if (!z10 || (valueAnimator = this.C) == null) {
                ValueAnimator valueAnimator2 = this.C;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.C.cancel();
                }
                tf.g gVar = this.f19267j;
                if (!this.A) {
                    f10 = 1.0f;
                }
                gVar.c0(f10);
            } else if (valueAnimator.isRunning()) {
                this.C.reverse();
            } else {
                if (!s02) {
                    f10 = 1.0f;
                }
                this.C.setFloatValues(new float[]{1.0f - f10, f10});
                this.C.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean d0() {
        return u0() && v0();
    }

    private void d1(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.W;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z10) {
                    if (this.f19260e0 == null) {
                        this.f19260e0 = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    V childAt = coordinatorLayout.getChildAt(i10);
                    if (childAt != this.W.get()) {
                        if (z10) {
                            this.f19260e0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.f19255c) {
                                n0.D0(childAt, 4);
                            }
                        } else if (this.f19255c && (map = this.f19260e0) != null && map.containsKey(childAt)) {
                            n0.D0(childAt, this.f19260e0.get(childAt).intValue());
                        }
                    }
                }
                if (!z10) {
                    this.f19260e0 = null;
                } else if (this.f19255c) {
                    ((View) this.W.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    private void e0(View view, int i10) {
        if (view != null) {
            n0.m0(view, Opcodes.ASM8);
            n0.m0(view, Opcodes.ASM4);
            n0.m0(view, 1048576);
            int i11 = this.f19262f0.get(i10, -1);
            if (i11 != -1) {
                n0.m0(view, i11);
                this.f19262f0.delete(i10);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e1(boolean z10) {
        View view;
        if (this.W != null) {
            Z();
            if (this.M == 4 && (view = (View) this.W.get()) != null) {
                if (z10) {
                    Q0(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    private n f0(int i10) {
        return new e(i10);
    }

    private void g0(@NonNull Context context) {
        if (this.f19283z != null) {
            tf.g gVar = new tf.g(this.f19283z);
            this.f19267j = gVar;
            gVar.Q(context);
            ColorStateList colorStateList = this.f19268k;
            if (colorStateList != null) {
                this.f19267j.b0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f19267j.setTint(typedValue.data);
        }
    }

    private void h0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.C = ofFloat;
        ofFloat.setDuration(500);
        this.C.addUpdateListener(new b());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> k0(@NonNull V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int l0(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    private int q0(int i10) {
        if (i10 == 3) {
            return m0();
        }
        if (i10 == 4) {
            return this.H;
        }
        if (i10 == 5) {
            return this.V;
        }
        if (i10 == 6) {
            return this.F;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    private float r0() {
        VelocityTracker velocityTracker = this.f19252a0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f19257d);
        return this.f19252a0.getYVelocity(this.f19254b0);
    }

    private boolean s0() {
        return this.M == 3 && (this.f19282y || m0() == 0);
    }

    private boolean w0(V v10) {
        ViewParent parent = v10.getParent();
        if (parent == null || !parent.isLayoutRequested() || !n0.V(v10)) {
            return false;
        }
        return true;
    }

    private void z0(View view, k.a aVar, int i10) {
        n0.o0(view, aVar, (CharSequence) null, f0(i10));
    }

    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        this.Q = 0;
        this.R = false;
        if ((i10 & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r4.getTop() <= r2.F) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.H)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (X0() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.H)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.F) < java.lang.Math.abs(r3 - r2.H)) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.m0()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.R0(r0)
            return
        L_0x000f:
            boolean r3 = r2.x0()
            if (r3 == 0) goto L_0x0024
            java.lang.ref.WeakReference<android.view.View> r3 = r2.Y
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x0023
            boolean r3 = r2.R
            if (r3 != 0) goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            int r3 = r2.Q
            r5 = 6
            r6 = 4
            if (r3 <= 0) goto L_0x003a
            boolean r3 = r2.f19253b
            if (r3 == 0) goto L_0x0030
            goto L_0x00aa
        L_0x0030:
            int r3 = r4.getTop()
            int r6 = r2.F
            if (r3 <= r6) goto L_0x00aa
            goto L_0x00a9
        L_0x003a:
            boolean r3 = r2.J
            if (r3 == 0) goto L_0x004a
            float r3 = r2.r0()
            boolean r3 = r2.W0(r4, r3)
            if (r3 == 0) goto L_0x004a
            r0 = 5
            goto L_0x00aa
        L_0x004a:
            int r3 = r2.Q
            if (r3 != 0) goto L_0x008e
            int r3 = r4.getTop()
            boolean r1 = r2.f19253b
            if (r1 == 0) goto L_0x0068
            int r5 = r2.E
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L_0x0092
            goto L_0x00aa
        L_0x0068:
            int r1 = r2.F
            if (r3 >= r1) goto L_0x007e
            int r1 = r2.H
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L_0x0077
            goto L_0x00aa
        L_0x0077:
            boolean r3 = r2.X0()
            if (r3 == 0) goto L_0x00a9
            goto L_0x0092
        L_0x007e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
            goto L_0x00a9
        L_0x008e:
            boolean r3 = r2.f19253b
            if (r3 == 0) goto L_0x0094
        L_0x0092:
            r0 = r6
            goto L_0x00aa
        L_0x0094:
            int r3 = r4.getTop()
            int r0 = r2.F
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
        L_0x00a9:
            r0 = r5
        L_0x00aa:
            r3 = 0
            r2.Z0(r4, r0, r3)
            r2.R = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.M == 1 && actionMasked == 0) {
            return true;
        }
        if (V0()) {
            this.O.z(motionEvent);
        }
        if (actionMasked == 0) {
            A0();
        }
        if (this.f19252a0 == null) {
            this.f19252a0 = VelocityTracker.obtain();
        }
        this.f19252a0.addMovement(motionEvent);
        if (V0() && actionMasked == 2 && !this.P && Math.abs(((float) this.f19256c0) - motionEvent.getY()) > ((float) this.O.u())) {
            this.O.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    public void D0(boolean z10) {
        this.L = z10;
    }

    public void E0(int i10) {
        if (i10 >= 0) {
            this.D = i10;
            c1(this.M, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void F0(boolean z10) {
        int i10;
        if (this.f19253b != z10) {
            this.f19253b = z10;
            if (this.W != null) {
                Z();
            }
            if (!this.f19253b || this.M != 6) {
                i10 = this.M;
            } else {
                i10 = 3;
            }
            R0(i10);
            c1(this.M, true);
            a1();
        }
    }

    public void G0(boolean z10) {
        this.f19272o = z10;
    }

    public void H0(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.G = f10;
        if (this.W != null) {
            a0();
        }
    }

    public void I0(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            if (!z10 && this.M == 5) {
                Q0(4);
            }
            a1();
        }
    }

    public void J0(int i10) {
        this.f19270m = i10;
    }

    public void K0(int i10) {
        this.f19269l = i10;
    }

    public void L0(int i10) {
        M0(i10, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M0(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f19263g
            if (r4 != 0) goto L_0x0015
            r3.f19263g = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.f19263g
            if (r2 != 0) goto L_0x0017
            int r2 = r3.f19261f
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = r1
            goto L_0x001f
        L_0x0017:
            r3.f19263g = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f19261f = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.e1(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.M0(int, boolean):void");
    }

    public void N0(int i10) {
        this.f19251a = i10;
    }

    public void O0(int i10) {
        this.f19259e = i10;
    }

    public void P0(boolean z10) {
        this.K = z10;
    }

    public void Q0(int i10) {
        String str;
        int i11;
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            if (i10 == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            sb2.append(str);
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        } else if (this.J || i10 != 5) {
            if (i10 != 6 || !this.f19253b || q0(i10) > this.E) {
                i11 = i10;
            } else {
                i11 = 3;
            }
            WeakReference<V> weakReference = this.W;
            if (weakReference == null || weakReference.get() == null) {
                R0(i10);
                return;
            }
            View view = (View) this.W.get();
            C0(view, new a(view, i11));
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot set state: ");
            sb3.append(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void R0(int i10) {
        View view;
        if (this.M != i10) {
            this.M = i10;
            if (i10 == 4 || i10 == 3 || i10 == 6 || (this.J && i10 == 5)) {
                this.N = i10;
            }
            WeakReference<V> weakReference = this.W;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i10 == 3) {
                    d1(true);
                } else if (i10 == 6 || i10 == 5 || i10 == 4) {
                    d1(false);
                }
                c1(i10, true);
                for (int i11 = 0; i11 < this.Z.size(); i11++) {
                    this.Z.get(i11).c(view, i10);
                }
                a1();
            }
        }
    }

    public void S0(boolean z10) {
        this.f19255c = z10;
    }

    public boolean U0(long j10, float f10) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean W0(@NonNull View view, float f10) {
        if (this.K) {
            return true;
        }
        if (!v0() || view.getTop() < this.H) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f10 * this.S)) - ((float) this.H)) / ((float) b0()) > 0.5f) {
            return true;
        }
        return false;
    }

    public boolean X0() {
        return false;
    }

    public void Y(@NonNull f fVar) {
        if (!this.Z.contains(fVar)) {
            this.Z.add(fVar);
        }
    }

    public boolean Y0() {
        return true;
    }

    public void g(@NonNull CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.W = null;
        this.O = null;
    }

    /* access modifiers changed from: package-private */
    public void i0(int i10) {
        View view = (View) this.W.get();
        if (view != null && !this.Z.isEmpty()) {
            float c02 = c0(i10);
            for (int i11 = 0; i11 < this.Z.size(); i11++) {
                this.Z.get(i11).b(view, c02);
            }
        }
    }

    public void j() {
        super.j();
        this.W = null;
        this.O = null;
    }

    /* access modifiers changed from: package-private */
    public View j0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (n0.X(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View j02 = j0(viewGroup.getChildAt(i10));
                if (j02 != null) {
                    return j02;
                }
            }
        }
        return null;
    }

    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        z0.c cVar;
        boolean z10;
        View view;
        if (!v10.isShown() || !this.L) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            A0();
        }
        if (this.f19252a0 == null) {
            this.f19252a0 = VelocityTracker.obtain();
        }
        this.f19252a0.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f19256c0 = (int) motionEvent.getY();
            if (this.M != 2) {
                WeakReference<View> weakReference = this.Y;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.B(view, x10, this.f19256c0)) {
                    this.f19254b0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f19258d0 = true;
                }
            }
            if (this.f19254b0 != -1 || coordinatorLayout.B(v10, x10, this.f19256c0)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.P = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f19258d0 = false;
            this.f19254b0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (!this.P && (cVar = this.O) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Y;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.P || this.M == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || Math.abs(((float) this.f19256c0) - motionEvent.getY()) <= ((float) this.O.u())) {
            return false;
        }
        return true;
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        if (n0.y(coordinatorLayout) && !n0.y(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.f19265h = coordinatorLayout.getResources().getDimensionPixelSize(bf.d.design_bottom_sheet_peek_height_min);
            T0(v10);
            this.W = new WeakReference<>(v10);
            tf.g gVar = this.f19267j;
            if (gVar != null) {
                n0.w0(v10, gVar);
                tf.g gVar2 = this.f19267j;
                float f10 = this.I;
                if (f10 == -1.0f) {
                    f10 = n0.w(v10);
                }
                gVar2.a0(f10);
            } else {
                ColorStateList colorStateList = this.f19268k;
                if (colorStateList != null) {
                    n0.x0(v10, colorStateList);
                }
            }
            a1();
            if (n0.z(v10) == 0) {
                n0.D0(v10, 1);
            }
        }
        if (this.O == null) {
            this.O = z0.c.m(coordinatorLayout, this.f19264g0);
        }
        int top = v10.getTop();
        coordinatorLayout.I(v10, i10);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.T = height;
        int i11 = this.V;
        int i12 = i11 - height;
        int i13 = this.f19281x;
        if (i12 < i13) {
            if (this.f19276s) {
                this.T = i11;
            } else {
                this.T = i11 - i13;
            }
        }
        this.E = Math.max(0, i11 - this.T);
        a0();
        Z();
        int i14 = this.M;
        if (i14 == 3) {
            n0.d0(v10, m0());
        } else if (i14 == 6) {
            n0.d0(v10, this.F);
        } else if (this.J && i14 == 5) {
            n0.d0(v10, this.V);
        } else if (i14 == 4) {
            n0.d0(v10, this.H);
        } else if (i14 == 1 || i14 == 2) {
            n0.d0(v10, top - v10.getTop());
        }
        c1(this.M, false);
        this.Y = new WeakReference<>(j0(v10));
        for (int i15 = 0; i15 < this.Z.size(); i15++) {
            this.Z.get(i15).a(v10);
        }
        return true;
    }

    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(l0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f19269l, marginLayoutParams.width), l0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f19270m, marginLayoutParams.height));
        return true;
    }

    public int m0() {
        int i10;
        if (this.f19253b) {
            return this.E;
        }
        int i11 = this.D;
        if (this.f19276s) {
            i10 = 0;
        } else {
            i10 = this.f19281x;
        }
        return Math.max(i11, i10);
    }

    /* access modifiers changed from: package-private */
    public tf.g n0() {
        return this.f19267j;
    }

    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (!x0() || (weakReference = this.Y) == null || view != weakReference.get()) {
            return false;
        }
        if (this.M != 3 || super.o(coordinatorLayout, v10, view, f10, f11)) {
            return true;
        }
        return false;
    }

    public int o0() {
        if (this.f19263g) {
            return -1;
        }
        return this.f19261f;
    }

    public int p0() {
        return this.M;
    }

    public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        View view2;
        if (i12 != 1) {
            WeakReference<View> weakReference = this.Y;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (!x0() || view == view2) {
                int top = v10.getTop();
                int i13 = top - i11;
                if (i11 > 0) {
                    if (i13 < m0()) {
                        int m02 = top - m0();
                        iArr[1] = m02;
                        n0.d0(v10, -m02);
                        R0(3);
                    } else if (this.L) {
                        iArr[1] = i11;
                        n0.d0(v10, -i11);
                        R0(1);
                    } else {
                        return;
                    }
                } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                    if (i13 > this.H && !d0()) {
                        int i14 = top - this.H;
                        iArr[1] = i14;
                        n0.d0(v10, -i14);
                        R0(4);
                    } else if (this.L) {
                        iArr[1] = i11;
                        n0.d0(v10, -i11);
                        R0(1);
                    } else {
                        return;
                    }
                }
                i0(v10.getTop());
                this.Q = i11;
                this.R = true;
            }
        }
    }

    public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
    }

    public boolean t0() {
        return this.f19272o;
    }

    public boolean u0() {
        return this.J;
    }

    public boolean v0() {
        return true;
    }

    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, v10, savedState.a());
        B0(savedState);
        int i10 = savedState.f19284c;
        if (i10 == 1 || i10 == 2) {
            this.M = 4;
            this.N = 4;
            return;
        }
        this.M = i10;
        this.N = i10;
    }

    public boolean x0() {
        return true;
    }

    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
        return new SavedState(super.y(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    public void y0(@NonNull f fVar) {
        this.Z.remove(fVar);
    }

    private class g {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f19299a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f19300b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f19301c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                boolean unused = g.this.f19300b = false;
                z0.c cVar = BottomSheetBehavior.this.O;
                if (cVar == null || !cVar.k(true)) {
                    g gVar = g.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.M == 2) {
                        bottomSheetBehavior.R0(gVar.f19299a);
                        return;
                    }
                    return;
                }
                g gVar2 = g.this;
                gVar2.c(gVar2.f19299a);
            }
        }

        private g() {
            this.f19301c = new a();
        }

        /* access modifiers changed from: package-private */
        public void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.W;
            if (weakReference != null && weakReference.get() != null) {
                this.f19299a = i10;
                if (!this.f19300b) {
                    n0.k0((View) BottomSheetBehavior.this.W.get(), this.f19301c);
                    this.f19300b = true;
                }
            }
        }

        /* synthetic */ g(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        final int f19284c;

        /* renamed from: d  reason: collision with root package name */
        int f19285d;

        /* renamed from: e  reason: collision with root package name */
        boolean f19286e;

        /* renamed from: f  reason: collision with root package name */
        boolean f19287f;

        /* renamed from: g  reason: collision with root package name */
        boolean f19288g;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19284c = parcel.readInt();
            this.f19285d = parcel.readInt();
            boolean z10 = false;
            this.f19286e = parcel.readInt() == 1;
            this.f19287f = parcel.readInt() == 1;
            this.f19288g = parcel.readInt() == 1 ? true : z10;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19284c);
            parcel.writeInt(this.f19285d);
            parcel.writeInt(this.f19286e ? 1 : 0);
            parcel.writeInt(this.f19287f ? 1 : 0);
            parcel.writeInt(this.f19288g ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f19284c = bottomSheetBehavior.M;
            this.f19285d = bottomSheetBehavior.f19261f;
            this.f19286e = bottomSheetBehavior.f19253b;
            this.f19287f = bottomSheetBehavior.J;
            this.f19288g = bottomSheetBehavior.K;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.f19266i = context.getResources().getDimensionPixelSize(bf.d.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.BottomSheetBehavior_Layout);
        int i11 = l.BottomSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f19268k = qf.c.a(context, obtainStyledAttributes, i11);
        }
        if (obtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f19283z = tf.k.e(context, attributeSet, bf.b.bottomSheetStyle, f19250h0).m();
        }
        g0(context);
        h0();
        this.I = obtainStyledAttributes.getDimension(l.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = l.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i12)) {
            K0(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = l.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i13)) {
            J0(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = l.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i14);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            L0(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        } else {
            L0(i10);
        }
        I0(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_hideable, false));
        G0(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        F0(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        P0(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        D0(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_draggable, true));
        N0(obtainStyledAttributes.getInt(l.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        H0(obtainStyledAttributes.getFloat(l.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = l.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i15);
        if (peekValue2 == null || peekValue2.type != 16) {
            E0(obtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        } else {
            E0(peekValue2.data);
        }
        O0(obtainStyledAttributes.getInt(l.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.f19273p = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f19274q = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f19275r = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f19276s = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f19277t = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f19278u = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f19279v = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.f19282y = obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.f19257d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
