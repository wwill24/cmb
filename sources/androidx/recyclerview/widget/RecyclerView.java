package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.ScrollingView;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import androidx.core.view.y1;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.a0;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.v;
import androidx.recyclerview.widget.z;
import com.google.android.gms.common.api.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.bytebuddy.jar.asm.Opcodes;

public class RecyclerView extends ViewGroup implements ScrollingView, androidx.core.view.c0 {
    private static final int[] K0 = {16843830};
    private static final float L0 = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    static final boolean M0 = false;
    static final boolean N0 = true;
    static final boolean O0 = true;
    static final boolean P0 = true;
    private static final boolean Q0 = false;
    private static final boolean R0 = false;
    private static final Class<?>[] S0;
    static final Interpolator T0 = new c();
    static final a0 U0 = new a0();
    private androidx.core.view.d0 A0;
    boolean B;
    private final int[] B0;
    boolean C;
    private final int[] C0;
    boolean D;
    final int[] D0;
    private int E;
    final List<d0> E0;
    boolean F;
    private Runnable F0;
    boolean G;
    private boolean G0;
    private boolean H;
    private int H0;
    private int I;
    private int I0;
    boolean J;
    private final a0.b J0;
    private final AccessibilityManager K;
    private List<q> L;
    boolean M;
    boolean N;
    private int O;
    private int P;
    @NonNull
    private k Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    l V;
    private int W;

    /* renamed from: a  reason: collision with root package name */
    private final float f6237a;

    /* renamed from: a0  reason: collision with root package name */
    private int f6238a0;

    /* renamed from: b  reason: collision with root package name */
    private final x f6239b;

    /* renamed from: b0  reason: collision with root package name */
    private VelocityTracker f6240b0;

    /* renamed from: c  reason: collision with root package name */
    final v f6241c;

    /* renamed from: c0  reason: collision with root package name */
    private int f6242c0;

    /* renamed from: d  reason: collision with root package name */
    SavedState f6243d;

    /* renamed from: d0  reason: collision with root package name */
    private int f6244d0;

    /* renamed from: e  reason: collision with root package name */
    a f6245e;

    /* renamed from: e0  reason: collision with root package name */
    private int f6246e0;

    /* renamed from: f  reason: collision with root package name */
    f f6247f;

    /* renamed from: f0  reason: collision with root package name */
    private int f6248f0;

    /* renamed from: g  reason: collision with root package name */
    final a0 f6249g;

    /* renamed from: g0  reason: collision with root package name */
    private int f6250g0;

    /* renamed from: h  reason: collision with root package name */
    boolean f6251h;

    /* renamed from: h0  reason: collision with root package name */
    private r f6252h0;

    /* renamed from: i0  reason: collision with root package name */
    private final int f6253i0;

    /* renamed from: j  reason: collision with root package name */
    final Runnable f6254j;

    /* renamed from: j0  reason: collision with root package name */
    private final int f6255j0;

    /* renamed from: k  reason: collision with root package name */
    final Rect f6256k;

    /* renamed from: k0  reason: collision with root package name */
    private float f6257k0;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f6258l;

    /* renamed from: l0  reason: collision with root package name */
    private float f6259l0;

    /* renamed from: m  reason: collision with root package name */
    final RectF f6260m;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f6261m0;

    /* renamed from: n  reason: collision with root package name */
    Adapter f6262n;

    /* renamed from: n0  reason: collision with root package name */
    final c0 f6263n0;

    /* renamed from: o0  reason: collision with root package name */
    k f6264o0;

    /* renamed from: p  reason: collision with root package name */
    o f6265p;

    /* renamed from: p0  reason: collision with root package name */
    k.b f6266p0;

    /* renamed from: q  reason: collision with root package name */
    w f6267q;

    /* renamed from: q0  reason: collision with root package name */
    final z f6268q0;

    /* renamed from: r0  reason: collision with root package name */
    private t f6269r0;

    /* renamed from: s0  reason: collision with root package name */
    private List<t> f6270s0;

    /* renamed from: t  reason: collision with root package name */
    final List<w> f6271t;

    /* renamed from: t0  reason: collision with root package name */
    boolean f6272t0;

    /* renamed from: u0  reason: collision with root package name */
    boolean f6273u0;

    /* renamed from: v0  reason: collision with root package name */
    private l.b f6274v0;

    /* renamed from: w  reason: collision with root package name */
    final ArrayList<n> f6275w;

    /* renamed from: w0  reason: collision with root package name */
    boolean f6276w0;

    /* renamed from: x  reason: collision with root package name */
    private final ArrayList<s> f6277x;

    /* renamed from: x0  reason: collision with root package name */
    v f6278x0;

    /* renamed from: y  reason: collision with root package name */
    private s f6279y;

    /* renamed from: y0  reason: collision with root package name */
    private j f6280y0;

    /* renamed from: z  reason: collision with root package name */
    boolean f6281z;

    /* renamed from: z0  reason: collision with root package name */
    private final int[] f6282z0;

    public static abstract class Adapter<VH extends d0> {

        /* renamed from: a  reason: collision with root package name */
        private final h f6283a = new h();

        /* renamed from: b  reason: collision with root package name */
        private boolean f6284b = false;

        /* renamed from: c  reason: collision with root package name */
        private StateRestorationPolicy f6285c = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public void A(@NonNull VH vh2) {
        }

        public void B(@NonNull VH vh2) {
        }

        public void C(@NonNull VH vh2) {
        }

        public void D(@NonNull i iVar) {
            this.f6283a.registerObserver(iVar);
        }

        public void E(boolean z10) {
            if (!j()) {
                this.f6284b = z10;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void F(@NonNull i iVar) {
            this.f6283a.unregisterObserver(iVar);
        }

        public final void c(@NonNull VH vh2, int i10) {
            boolean z10;
            if (vh2.f6320s == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                vh2.f6304c = i10;
                if (k()) {
                    vh2.f6306e = h(i10);
                }
                vh2.O(1, 519);
                androidx.core.os.m.a("RV OnBindView");
            }
            vh2.f6320s = this;
            w(vh2, i10, vh2.x());
            if (z10) {
                vh2.i();
                ViewGroup.LayoutParams layoutParams = vh2.f6302a.getLayoutParams();
                if (layoutParams instanceof p) {
                    ((p) layoutParams).f6361c = true;
                }
                androidx.core.os.m.b();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            int i10 = g.f6323a[this.f6285c.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 != 2) {
                return true;
            }
            if (g() > 0) {
                return true;
            }
            return false;
        }

        @NonNull
        public final VH e(@NonNull ViewGroup viewGroup, int i10) {
            try {
                androidx.core.os.m.a("RV CreateView");
                VH x10 = x(viewGroup, i10);
                if (x10.f6302a.getParent() == null) {
                    x10.f6307f = i10;
                    return x10;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.m.b();
            }
        }

        public int f(@NonNull Adapter<? extends d0> adapter, @NonNull d0 d0Var, int i10) {
            if (adapter == this) {
                return i10;
            }
            return -1;
        }

        public abstract int g();

        public long h(int i10) {
            return -1;
        }

        public int i(int i10) {
            return 0;
        }

        public final boolean j() {
            return this.f6283a.a();
        }

        public final boolean k() {
            return this.f6284b;
        }

        public final void l() {
            this.f6283a.b();
        }

        public final void m(int i10) {
            this.f6283a.d(i10, 1);
        }

        public final void n(int i10, Object obj) {
            this.f6283a.e(i10, 1, obj);
        }

        public final void o(int i10, int i11) {
            this.f6283a.c(i10, i11);
        }

        public final void p(int i10, int i11) {
            this.f6283a.d(i10, i11);
        }

        public final void q(int i10, int i11, Object obj) {
            this.f6283a.e(i10, i11, obj);
        }

        public final void r(int i10, int i11) {
            this.f6283a.f(i10, i11);
        }

        public final void s(int i10, int i11) {
            this.f6283a.g(i10, i11);
        }

        public final void t(int i10) {
            this.f6283a.g(i10, 1);
        }

        public void u(@NonNull RecyclerView recyclerView) {
        }

        public abstract void v(@NonNull VH vh2, int i10);

        public void w(@NonNull VH vh2, int i10, @NonNull List<Object> list) {
            v(vh2, i10);
        }

        @NonNull
        public abstract VH x(@NonNull ViewGroup viewGroup, int i10);

        public void y(@NonNull RecyclerView recyclerView) {
        }

        public boolean z(@NonNull VH vh2) {
            return false;
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.D && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f6281z) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.G) {
                    recyclerView2.F = true;
                } else {
                    recyclerView2.z();
                }
            }
        }
    }

    static class a0 extends k {
        a0() {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            l lVar = RecyclerView.this.V;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.f6276w0 = false;
        }
    }

    public static abstract class b0 {
    }

    class c implements Interpolator {
        c() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f6293a;

        /* renamed from: b  reason: collision with root package name */
        private int f6294b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f6295c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f6296d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6297e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6298f = false;

        c0() {
            Interpolator interpolator = RecyclerView.T0;
            this.f6296d = interpolator;
            this.f6295c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i10, int i11) {
            boolean z10;
            int i12;
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            if (abs > abs2) {
                z10 = true;
            } else {
                z10 = false;
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (z10) {
                i12 = recyclerView.getWidth();
            } else {
                i12 = recyclerView.getHeight();
            }
            if (!z10) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) i12)) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            n0.k0(RecyclerView.this, this);
        }

        public void b(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f6294b = 0;
            this.f6293a = 0;
            Interpolator interpolator = this.f6296d;
            Interpolator interpolator2 = RecyclerView.T0;
            if (interpolator != interpolator2) {
                this.f6296d = interpolator2;
                this.f6295c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f6295c.fling(0, 0, i10, i11, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
            d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f6297e) {
                this.f6298f = true;
            } else {
                c();
            }
        }

        public void e(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.T0;
            }
            if (this.f6296d != interpolator) {
                this.f6296d = interpolator;
                this.f6295c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f6294b = 0;
            this.f6293a = 0;
            RecyclerView.this.setScrollState(2);
            this.f6295c.startScroll(0, 0, i10, i11, i13);
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f6295c.abortAnimation();
        }

        public void run() {
            int i10;
            int i11;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            int i12;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f6265p == null) {
                f();
                return;
            }
            this.f6298f = false;
            this.f6297e = true;
            recyclerView.z();
            OverScroller overScroller = this.f6295c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i13 = currX - this.f6293a;
                int i14 = currY - this.f6294b;
                this.f6293a = currX;
                this.f6294b = currY;
                int w10 = RecyclerView.this.w(i13);
                int y10 = RecyclerView.this.y(i14);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.D0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.K(w10, y10, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.D0;
                    w10 -= iArr2[0];
                    y10 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.v(w10, y10);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f6262n != null) {
                    int[] iArr3 = recyclerView3.D0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.r1(w10, y10, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.D0;
                    i10 = iArr4[0];
                    i11 = iArr4[1];
                    w10 -= i10;
                    y10 -= i11;
                    y yVar = recyclerView4.f6265p.f6341g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int b10 = RecyclerView.this.f6268q0.b();
                        if (b10 == 0) {
                            yVar.r();
                        } else if (yVar.f() >= b10) {
                            yVar.p(b10 - 1);
                            yVar.j(i10, i11);
                        } else {
                            yVar.j(i10, i11);
                        }
                    }
                } else {
                    i11 = 0;
                    i10 = 0;
                }
                if (!RecyclerView.this.f6275w.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.D0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.L(i10, i11, w10, y10, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.D0;
                int i15 = w10 - iArr6[0];
                int i16 = y10 - iArr6[1];
                if (!(i10 == 0 && i11 == 0)) {
                    recyclerView6.N(i10, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (overScroller.isFinished() || ((z10 || i15 != 0) && (z11 || i16 != 0))) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                y yVar2 = RecyclerView.this.f6265p.f6341g;
                if (yVar2 == null || !yVar2.g()) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13 || !z12) {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    k kVar = recyclerView7.f6264o0;
                    if (kVar != null) {
                        kVar.f(recyclerView7, i10, i11);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i15 < 0) {
                            i12 = -currVelocity;
                        } else if (i15 > 0) {
                            i12 = currVelocity;
                        } else {
                            i12 = 0;
                        }
                        if (i16 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i16 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.b(i12, currVelocity);
                    }
                    if (RecyclerView.P0) {
                        RecyclerView.this.f6266p0.b();
                    }
                }
            }
            y yVar3 = RecyclerView.this.f6265p.f6341g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f6297e = false;
            if (this.f6298f) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.G1(1);
        }
    }

    class d implements a0.b {
        d() {
        }

        public void a(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.n(d0Var, cVar, cVar2);
        }

        public void b(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f6265p.n1(d0Var.f6302a, recyclerView.f6241c);
        }

        public void c(d0 d0Var, @NonNull l.c cVar, l.c cVar2) {
            RecyclerView.this.f6241c.O(d0Var);
            RecyclerView.this.p(d0Var, cVar, cVar2);
        }

        public void d(d0 d0Var, @NonNull l.c cVar, @NonNull l.c cVar2) {
            d0Var.P(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.M) {
                if (recyclerView.V.b(d0Var, d0Var, cVar, cVar2)) {
                    RecyclerView.this.U0();
                }
            } else if (recyclerView.V.d(d0Var, cVar, cVar2)) {
                RecyclerView.this.U0();
            }
        }
    }

    public static abstract class d0 {

        /* renamed from: t  reason: collision with root package name */
        private static final List<Object> f6301t = Collections.emptyList();
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final View f6302a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f6303b;

        /* renamed from: c  reason: collision with root package name */
        int f6304c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f6305d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f6306e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f6307f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f6308g = -1;

        /* renamed from: h  reason: collision with root package name */
        d0 f6309h = null;

        /* renamed from: i  reason: collision with root package name */
        d0 f6310i = null;

        /* renamed from: j  reason: collision with root package name */
        int f6311j;

        /* renamed from: k  reason: collision with root package name */
        List<Object> f6312k = null;

        /* renamed from: l  reason: collision with root package name */
        List<Object> f6313l = null;

        /* renamed from: m  reason: collision with root package name */
        private int f6314m = 0;

        /* renamed from: n  reason: collision with root package name */
        v f6315n = null;

        /* renamed from: o  reason: collision with root package name */
        boolean f6316o = false;

        /* renamed from: p  reason: collision with root package name */
        private int f6317p = 0;

        /* renamed from: q  reason: collision with root package name */
        int f6318q = -1;

        /* renamed from: r  reason: collision with root package name */
        RecyclerView f6319r;

        /* renamed from: s  reason: collision with root package name */
        Adapter<? extends d0> f6320s;

        public d0(@NonNull View view) {
            if (view != null) {
                this.f6302a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void l() {
            if (this.f6312k == null) {
                ArrayList arrayList = new ArrayList();
                this.f6312k = arrayList;
                this.f6313l = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean A() {
            return (this.f6302a.getParent() == null || this.f6302a.getParent() == this.f6319r) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean B() {
            return (this.f6311j & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean C() {
            return (this.f6311j & 4) != 0;
        }

        public final boolean D() {
            if ((this.f6311j & 16) != 0 || n0.T(this.f6302a)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean E() {
            return (this.f6311j & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean F() {
            return this.f6315n != null;
        }

        /* access modifiers changed from: package-private */
        public boolean G() {
            return (this.f6311j & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean H() {
            return (this.f6311j & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean I() {
            return (this.f6311j & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void J(int i10, boolean z10) {
            if (this.f6305d == -1) {
                this.f6305d = this.f6304c;
            }
            if (this.f6308g == -1) {
                this.f6308g = this.f6304c;
            }
            if (z10) {
                this.f6308g += i10;
            }
            this.f6304c += i10;
            if (this.f6302a.getLayoutParams() != null) {
                ((p) this.f6302a.getLayoutParams()).f6361c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void K(RecyclerView recyclerView) {
            int i10 = this.f6318q;
            if (i10 != -1) {
                this.f6317p = i10;
            } else {
                this.f6317p = n0.z(this.f6302a);
            }
            recyclerView.u1(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void L(RecyclerView recyclerView) {
            recyclerView.u1(this, this.f6317p);
            this.f6317p = 0;
        }

        /* access modifiers changed from: package-private */
        public void M() {
            this.f6311j = 0;
            this.f6304c = -1;
            this.f6305d = -1;
            this.f6306e = -1;
            this.f6308g = -1;
            this.f6314m = 0;
            this.f6309h = null;
            this.f6310i = null;
            i();
            this.f6317p = 0;
            this.f6318q = -1;
            RecyclerView.t(this);
        }

        /* access modifiers changed from: package-private */
        public void N() {
            if (this.f6305d == -1) {
                this.f6305d = this.f6304c;
            }
        }

        /* access modifiers changed from: package-private */
        public void O(int i10, int i11) {
            this.f6311j = (i10 & i11) | (this.f6311j & (~i11));
        }

        public final void P(boolean z10) {
            int i10;
            int i11 = this.f6314m;
            if (z10) {
                i10 = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
            this.f6314m = i10;
            if (i10 < 0) {
                this.f6314m = 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb2.append(this);
            } else if (!z10 && i10 == 1) {
                this.f6311j |= 16;
            } else if (z10 && i10 == 0) {
                this.f6311j &= -17;
            }
        }

        /* access modifiers changed from: package-private */
        public void Q(v vVar, boolean z10) {
            this.f6315n = vVar;
            this.f6316o = z10;
        }

        /* access modifiers changed from: package-private */
        public boolean R() {
            return (this.f6311j & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean S() {
            return (this.f6311j & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void T() {
            this.f6315n.O(this);
        }

        /* access modifiers changed from: package-private */
        public boolean U() {
            return (this.f6311j & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void f(Object obj) {
            if (obj == null) {
                g(1024);
            } else if ((1024 & this.f6311j) == 0) {
                l();
                this.f6312k.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(int i10) {
            this.f6311j = i10 | this.f6311j;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f6305d = -1;
            this.f6308g = -1;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            List<Object> list = this.f6312k;
            if (list != null) {
                list.clear();
            }
            this.f6311j &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            this.f6311j &= -33;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f6311j &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            return (this.f6311j & 16) == 0 && n0.T(this.f6302a);
        }

        /* access modifiers changed from: package-private */
        public void n(int i10, int i11, boolean z10) {
            g(8);
            J(i11, z10);
            this.f6304c = i10;
        }

        public final int o() {
            RecyclerView recyclerView = this.f6319r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.h0(this);
        }

        @Deprecated
        public final int q() {
            return r();
        }

        public final int r() {
            RecyclerView recyclerView;
            Adapter adapter;
            int h02;
            if (this.f6320s == null || (recyclerView = this.f6319r) == null || (adapter = recyclerView.getAdapter()) == null || (h02 = this.f6319r.h0(this)) == -1) {
                return -1;
            }
            return adapter.f(this.f6320s, this, h02);
        }

        public final long s() {
            return this.f6306e;
        }

        public final int t() {
            return this.f6307f;
        }

        public String toString() {
            String str;
            String str2;
            if (getClass().isAnonymousClass()) {
                str = "ViewHolder";
            } else {
                str = getClass().getSimpleName();
            }
            StringBuilder sb2 = new StringBuilder(str + "{" + Integer.toHexString(hashCode()) + " position=" + this.f6304c + " id=" + this.f6306e + ", oldPos=" + this.f6305d + ", pLpos:" + this.f6308g);
            if (F()) {
                sb2.append(" scrap ");
                if (this.f6316o) {
                    str2 = "[changeScrap]";
                } else {
                    str2 = "[attachedScrap]";
                }
                sb2.append(str2);
            }
            if (C()) {
                sb2.append(" invalid");
            }
            if (!B()) {
                sb2.append(" unbound");
            }
            if (I()) {
                sb2.append(" update");
            }
            if (E()) {
                sb2.append(" removed");
            }
            if (S()) {
                sb2.append(" ignored");
            }
            if (G()) {
                sb2.append(" tmpDetached");
            }
            if (!D()) {
                sb2.append(" not recyclable(" + this.f6314m + ")");
            }
            if (z()) {
                sb2.append(" undefined adapter position");
            }
            if (this.f6302a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public final int u() {
            int i10 = this.f6308g;
            return i10 == -1 ? this.f6304c : i10;
        }

        public final int v() {
            return this.f6305d;
        }

        @Deprecated
        public final int w() {
            int i10 = this.f6308g;
            return i10 == -1 ? this.f6304c : i10;
        }

        /* access modifiers changed from: package-private */
        public List<Object> x() {
            if ((this.f6311j & 1024) != 0) {
                return f6301t;
            }
            List<Object> list = this.f6312k;
            if (list == null || list.size() == 0) {
                return f6301t;
            }
            return this.f6313l;
        }

        /* access modifiers changed from: package-private */
        public boolean y(int i10) {
            return (i10 & this.f6311j) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean z() {
            return (this.f6311j & 512) != 0 || C();
        }
    }

    class e implements f.b {
        e() {
        }

        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        public void b(View view) {
            d0 l02 = RecyclerView.l0(view);
            if (l02 != null) {
                l02.K(RecyclerView.this);
            }
        }

        public d0 c(View view) {
            return RecyclerView.l0(view);
        }

        public void d(int i10) {
            d0 l02;
            View a10 = a(i10);
            if (!(a10 == null || (l02 = RecyclerView.l0(a10)) == null)) {
                if (!l02.G() || l02.S()) {
                    l02.g(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + l02 + RecyclerView.this.U());
                }
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        public void e(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.D(view);
        }

        public void f() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View a10 = a(i10);
                RecyclerView.this.E(a10);
                a10.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        public int g(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        public int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        public void h(View view) {
            d0 l02 = RecyclerView.l0(view);
            if (l02 != null) {
                l02.L(RecyclerView.this);
            }
        }

        public void i(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.E(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        public void j(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            d0 l02 = RecyclerView.l0(view);
            if (l02 != null) {
                if (l02.G() || l02.S()) {
                    l02.k();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + l02 + RecyclerView.this.U());
                }
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }
    }

    class f implements a.C0070a {
        f() {
        }

        public void a(int i10, int i11) {
            RecyclerView.this.K0(i10, i11);
            RecyclerView.this.f6272t0 = true;
        }

        public void b(a.b bVar) {
            i(bVar);
        }

        public void c(a.b bVar) {
            i(bVar);
        }

        public void d(int i10, int i11) {
            RecyclerView.this.L0(i10, i11, false);
            RecyclerView.this.f6272t0 = true;
        }

        public void e(int i10, int i11, Object obj) {
            RecyclerView.this.J1(i10, i11, obj);
            RecyclerView.this.f6273u0 = true;
        }

        public d0 f(int i10) {
            d0 f02 = RecyclerView.this.f0(i10, true);
            if (f02 != null && !RecyclerView.this.f6247f.n(f02.f6302a)) {
                return f02;
            }
            return null;
        }

        public void g(int i10, int i11) {
            RecyclerView.this.J0(i10, i11);
            RecyclerView.this.f6272t0 = true;
        }

        public void h(int i10, int i11) {
            RecyclerView.this.L0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f6272t0 = true;
            recyclerView.f6268q0.f6397d += i11;
        }

        /* access modifiers changed from: package-private */
        public void i(a.b bVar) {
            int i10 = bVar.f6459a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f6265p.S0(recyclerView, bVar.f6460b, bVar.f6462d);
            } else if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f6265p.V0(recyclerView2, bVar.f6460b, bVar.f6462d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f6265p.X0(recyclerView3, bVar.f6460b, bVar.f6462d, bVar.f6461c);
            } else if (i10 == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f6265p.U0(recyclerView4, bVar.f6460b, bVar.f6462d, 1);
            }
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6323a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6323a = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6323a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g.<clinit>():void");
        }
    }

    static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((i) this.mObservers.get(size)).a();
            }
        }

        public void c(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((i) this.mObservers.get(size)).e(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, (Object) null);
        }

        public void e(int i10, int i11, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((i) this.mObservers.get(size)).c(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((i) this.mObservers.get(size)).d(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((i) this.mObservers.get(size)).f(i10, i11);
            }
        }
    }

    public static abstract class i {
        public void a() {
        }

        public void b(int i10, int i11) {
        }

        public void c(int i10, int i11, Object obj) {
            b(i10, i11);
        }

        public void d(int i10, int i11) {
        }

        public void e(int i10, int i11, int i12) {
        }

        public void f(int i10, int i11) {
        }
    }

    public interface j {
        int a(int i10, int i11);
    }

    public static class k {
        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect a(@NonNull RecyclerView recyclerView, int i10) {
            throw null;
        }
    }

    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private b f6324a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f6325b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f6326c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f6327d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f6328e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f6329f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(@NonNull d0 d0Var);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f6330a;

            /* renamed from: b  reason: collision with root package name */
            public int f6331b;

            /* renamed from: c  reason: collision with root package name */
            public int f6332c;

            /* renamed from: d  reason: collision with root package name */
            public int f6333d;

            @NonNull
            public c a(@NonNull d0 d0Var) {
                return b(d0Var, 0);
            }

            @NonNull
            public c b(@NonNull d0 d0Var, int i10) {
                View view = d0Var.f6302a;
                this.f6330a = view.getLeft();
                this.f6331b = view.getTop();
                this.f6332c = view.getRight();
                this.f6333d = view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i10 = d0Var.f6311j & 14;
            if (d0Var.C()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int v10 = d0Var.v();
            int o10 = d0Var.o();
            if (v10 == -1 || o10 == -1 || v10 == o10) {
                return i10;
            }
            return i10 | 2048;
        }

        public abstract boolean a(@NonNull d0 d0Var, c cVar, @NonNull c cVar2);

        public abstract boolean b(@NonNull d0 d0Var, @NonNull d0 d0Var2, @NonNull c cVar, @NonNull c cVar2);

        public abstract boolean c(@NonNull d0 d0Var, @NonNull c cVar, c cVar2);

        public abstract boolean d(@NonNull d0 d0Var, @NonNull c cVar, @NonNull c cVar2);

        public abstract boolean f(@NonNull d0 d0Var);

        public boolean g(@NonNull d0 d0Var, @NonNull List<Object> list) {
            return f(d0Var);
        }

        public final void h(@NonNull d0 d0Var) {
            s(d0Var);
            b bVar = this.f6324a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f6325b.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f6325b.get(i10).a();
            }
            this.f6325b.clear();
        }

        public abstract void j(@NonNull d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f6326c;
        }

        public long m() {
            return this.f6329f;
        }

        public long n() {
            return this.f6328e;
        }

        public long o() {
            return this.f6327d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean p10 = p();
            if (aVar != null) {
                if (!p10) {
                    aVar.a();
                } else {
                    this.f6325b.add(aVar);
                }
            }
            return p10;
        }

        @NonNull
        public c r() {
            return new c();
        }

        public void s(@NonNull d0 d0Var) {
        }

        @NonNull
        public c t(@NonNull z zVar, @NonNull d0 d0Var) {
            return r().a(d0Var);
        }

        @NonNull
        public c u(@NonNull z zVar, @NonNull d0 d0Var, int i10, @NonNull List<Object> list) {
            return r().a(d0Var);
        }

        public abstract void v();

        /* access modifiers changed from: package-private */
        public void w(b bVar) {
            this.f6324a = bVar;
        }
    }

    private class m implements l.b {
        m() {
        }

        public void a(d0 d0Var) {
            d0Var.P(true);
            if (d0Var.f6309h != null && d0Var.f6310i == null) {
                d0Var.f6309h = null;
            }
            d0Var.f6310i = null;
            if (!d0Var.R() && !RecyclerView.this.f1(d0Var.f6302a) && d0Var.G()) {
                RecyclerView.this.removeDetachedView(d0Var.f6302a, false);
            }
        }
    }

    public static abstract class n {
        @Deprecated
        public void f(@NonNull Rect rect, int i10, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull z zVar) {
            f(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void h(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull z zVar) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull z zVar) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        f f6335a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f6336b;

        /* renamed from: c  reason: collision with root package name */
        private final z.b f6337c;

        /* renamed from: d  reason: collision with root package name */
        private final z.b f6338d;

        /* renamed from: e  reason: collision with root package name */
        z f6339e;

        /* renamed from: f  reason: collision with root package name */
        z f6340f;

        /* renamed from: g  reason: collision with root package name */
        y f6341g;

        /* renamed from: h  reason: collision with root package name */
        boolean f6342h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f6343i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f6344j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6345k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f6346l = true;

        /* renamed from: m  reason: collision with root package name */
        int f6347m;

        /* renamed from: n  reason: collision with root package name */
        boolean f6348n;

        /* renamed from: o  reason: collision with root package name */
        private int f6349o;

        /* renamed from: p  reason: collision with root package name */
        private int f6350p;

        /* renamed from: q  reason: collision with root package name */
        private int f6351q;

        /* renamed from: r  reason: collision with root package name */
        private int f6352r;

        class a implements z.b {
            a() {
            }

            public View a(int i10) {
                return o.this.J(i10);
            }

            public int b(View view) {
                return o.this.R(view) - ((p) view.getLayoutParams()).leftMargin;
            }

            public int c() {
                return o.this.f0();
            }

            public int d() {
                return o.this.p0() - o.this.g0();
            }

            public int e(View view) {
                return o.this.U(view) + ((p) view.getLayoutParams()).rightMargin;
            }
        }

        class b implements z.b {
            b() {
            }

            public View a(int i10) {
                return o.this.J(i10);
            }

            public int b(View view) {
                return o.this.V(view) - ((p) view.getLayoutParams()).topMargin;
            }

            public int c() {
                return o.this.h0();
            }

            public int d() {
                return o.this.X() - o.this.e0();
            }

            public int e(View view) {
                return o.this.P(view) + ((p) view.getLayoutParams()).bottomMargin;
            }
        }

        public interface c {
            void a(int i10, int i11);
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f6355a;

            /* renamed from: b  reason: collision with root package name */
            public int f6356b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f6357c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f6358d;
        }

        public o() {
            a aVar = new a();
            this.f6337c = aVar;
            b bVar = new b();
            this.f6338d = bVar;
            this.f6339e = new z(aVar);
            this.f6340f = new z(bVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int L(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0020
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0020
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001e
            L_0x001c:
                r5 = r3
                goto L_0x0031
            L_0x001e:
                if (r7 != r1) goto L_0x0022
            L_0x0020:
                r7 = r4
                goto L_0x0031
            L_0x0022:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x0029
                goto L_0x002c
            L_0x0029:
                r7 = r4
                r5 = r6
                goto L_0x0031
            L_0x002c:
                r7 = r4
                r5 = r2
                goto L_0x0031
            L_0x002f:
                r5 = r6
                r7 = r5
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.L(int, int, int, int, boolean):int");
        }

        private int[] M(View view, Rect rect) {
            int[] iArr = new int[2];
            int f02 = f0();
            int h02 = h0();
            int p02 = p0() - g0();
            int X = X() - e0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i10 = left - f02;
            int min = Math.min(0, i10);
            int i11 = top - h02;
            int min2 = Math.min(0, i11);
            int i12 = width - p02;
            int max = Math.max(0, i12);
            int max2 = Math.max(0, height - X);
            if (a0() != 1) {
                if (min == 0) {
                    min = Math.min(i10, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i12);
            }
            if (min2 == 0) {
                min2 = Math.min(i11, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void g(View view, int i10, boolean z10) {
            d0 l02 = RecyclerView.l0(view);
            if (z10 || l02.E()) {
                this.f6336b.f6249g.b(l02);
            } else {
                this.f6336b.f6249g.p(l02);
            }
            p pVar = (p) view.getLayoutParams();
            if (l02.U() || l02.F()) {
                if (l02.F()) {
                    l02.T();
                } else {
                    l02.j();
                }
                this.f6335a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f6336b) {
                int m10 = this.f6335a.m(view);
                if (i10 == -1) {
                    i10 = this.f6335a.g();
                }
                if (m10 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f6336b.indexOfChild(view) + this.f6336b.U());
                } else if (m10 != i10) {
                    this.f6336b.f6265p.C0(m10, i10);
                }
            } else {
                this.f6335a.a(view, i10, false);
                pVar.f6361c = true;
                y yVar = this.f6341g;
                if (yVar != null && yVar.h()) {
                    this.f6341g.k(view);
                }
            }
            if (pVar.f6362d) {
                l02.f6302a.invalidate();
                pVar.f6362d = false;
            }
        }

        public static d j0(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.d.RecyclerView, i10, i11);
            dVar.f6355a = obtainStyledAttributes.getInt(o1.d.RecyclerView_android_orientation, 1);
            dVar.f6356b = obtainStyledAttributes.getInt(o1.d.RecyclerView_spanCount, 1);
            dVar.f6357c = obtainStyledAttributes.getBoolean(o1.d.RecyclerView_reverseLayout, false);
            dVar.f6358d = obtainStyledAttributes.getBoolean(o1.d.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int o(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i11, i12));
            }
            if (mode != 1073741824) {
                return Math.max(i11, i12);
            }
            return size;
        }

        private boolean u0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int f02 = f0();
            int h02 = h0();
            int p02 = p0() - g0();
            int X = X() - e0();
            Rect rect = this.f6336b.f6256k;
            Q(focusedChild, rect);
            if (rect.left - i10 >= p02 || rect.right - i10 <= f02 || rect.top - i11 >= X || rect.bottom - i11 <= h02) {
                return false;
            }
            return true;
        }

        private void w1(v vVar, int i10, View view) {
            d0 l02 = RecyclerView.l0(view);
            if (!l02.S()) {
                if (!l02.C() || l02.E() || this.f6336b.f6262n.k()) {
                    y(i10);
                    vVar.I(view);
                    this.f6336b.f6249g.k(l02);
                    return;
                }
                r1(i10);
                vVar.H(l02);
            }
        }

        private static boolean x0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode == 1073741824 && size == i10) {
                    return true;
                }
                return false;
            } else if (size >= i10) {
                return true;
            } else {
                return false;
            }
        }

        private void z(int i10, @NonNull View view) {
            this.f6335a.d(i10);
        }

        /* access modifiers changed from: package-private */
        public void A(RecyclerView recyclerView) {
            this.f6343i = true;
            H0(recyclerView);
        }

        public void A0(@NonNull View view, int i10, int i11, int i12, int i13) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f6360b;
            view.layout(i10 + rect.left + pVar.leftMargin, i11 + rect.top + pVar.topMargin, (i12 - rect.right) - pVar.rightMargin, (i13 - rect.bottom) - pVar.bottomMargin);
        }

        /* access modifiers changed from: package-private */
        public void A1(RecyclerView recyclerView) {
            B1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public void B(RecyclerView recyclerView, v vVar) {
            this.f6343i = false;
            J0(recyclerView, vVar);
        }

        public void B0(@NonNull View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect q02 = this.f6336b.q0(view);
            int i12 = i10 + q02.left + q02.right;
            int i13 = i11 + q02.top + q02.bottom;
            int L = L(p0(), q0(), f0() + g0() + pVar.leftMargin + pVar.rightMargin + i12, pVar.width, l());
            int L2 = L(X(), Y(), h0() + e0() + pVar.topMargin + pVar.bottomMargin + i13, pVar.height, m());
            if (G1(view, L, L2, pVar)) {
                view.measure(L, L2);
            }
        }

        /* access modifiers changed from: package-private */
        public void B1(int i10, int i11) {
            this.f6351q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f6349o = mode;
            if (mode == 0 && !RecyclerView.N0) {
                this.f6351q = 0;
            }
            this.f6352r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f6350p = mode2;
            if (mode2 == 0 && !RecyclerView.N0) {
                this.f6352r = 0;
            }
        }

        public View C(@NonNull View view) {
            View X;
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView == null || (X = recyclerView.X(view)) == null || this.f6335a.n(X)) {
                return null;
            }
            return X;
        }

        public void C0(int i10, int i11) {
            View J = J(i10);
            if (J != null) {
                y(i10);
                i(J, i11);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f6336b.toString());
        }

        public void C1(int i10, int i11) {
            this.f6336b.setMeasuredDimension(i10, i11);
        }

        public View D(int i10) {
            int K = K();
            for (int i11 = 0; i11 < K; i11++) {
                View J = J(i11);
                d0 l02 = RecyclerView.l0(J);
                if (l02 != null && l02.u() == i10 && !l02.S() && (this.f6336b.f6268q0.e() || !l02.E())) {
                    return J;
                }
            }
            return null;
        }

        public void D0(int i10) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                recyclerView.H0(i10);
            }
        }

        public void D1(Rect rect, int i10, int i11) {
            C1(o(i10, rect.width() + f0() + g0(), d0()), o(i11, rect.height() + h0() + e0(), c0()));
        }

        @SuppressLint({"UnknownNullness"})
        public abstract p E();

        public void E0(int i10) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                recyclerView.I0(i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void E1(int i10, int i11) {
            int K = K();
            if (K == 0) {
                this.f6336b.B(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MIN_VALUE;
            for (int i16 = 0; i16 < K; i16++) {
                View J = J(i16);
                Rect rect = this.f6336b.f6256k;
                Q(J, rect);
                int i17 = rect.left;
                if (i17 < i13) {
                    i13 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i14) {
                    i14 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i15) {
                    i15 = i20;
                }
            }
            this.f6336b.f6256k.set(i13, i14, i12, i15);
            D1(this.f6336b.f6256k, i10, i11);
        }

        @SuppressLint({"UnknownNullness"})
        public p F(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void F0(Adapter adapter, Adapter adapter2) {
        }

        /* access modifiers changed from: package-private */
        public void F1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f6336b = null;
                this.f6335a = null;
                this.f6351q = 0;
                this.f6352r = 0;
            } else {
                this.f6336b = recyclerView;
                this.f6335a = recyclerView.f6247f;
                this.f6351q = recyclerView.getWidth();
                this.f6352r = recyclerView.getHeight();
            }
            this.f6349o = 1073741824;
            this.f6350p = 1073741824;
        }

        @SuppressLint({"UnknownNullness"})
        public p G(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new p(layoutParams);
        }

        public boolean G0(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean G1(View view, int i10, int i11, p pVar) {
            if (view.isLayoutRequested() || !this.f6345k || !x0(view.getWidth(), i10, pVar.width) || !x0(view.getHeight(), i11, pVar.height)) {
                return true;
            }
            return false;
        }

        public int H() {
            return -1;
        }

        public void H0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean H1() {
            return false;
        }

        public int I(@NonNull View view) {
            return ((p) view.getLayoutParams()).f6360b.bottom;
        }

        @Deprecated
        public void I0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean I1(View view, int i10, int i11, p pVar) {
            if (!this.f6345k || !x0(view.getMeasuredWidth(), i10, pVar.width) || !x0(view.getMeasuredHeight(), i11, pVar.height)) {
                return true;
            }
            return false;
        }

        public View J(int i10) {
            f fVar = this.f6335a;
            if (fVar != null) {
                return fVar.f(i10);
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public void J0(RecyclerView recyclerView, v vVar) {
            I0(recyclerView);
        }

        @SuppressLint({"UnknownNullness"})
        public void J1(RecyclerView recyclerView, z zVar, int i10) {
        }

        public int K() {
            f fVar = this.f6335a;
            if (fVar != null) {
                return fVar.g();
            }
            return 0;
        }

        public View K0(@NonNull View view, int i10, @NonNull v vVar, @NonNull z zVar) {
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public void K1(y yVar) {
            y yVar2 = this.f6341g;
            if (!(yVar2 == null || yVar == yVar2 || !yVar2.h())) {
                this.f6341g.r();
            }
            this.f6341g = yVar;
            yVar.q(this.f6336b, this);
        }

        public void L0(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6336b;
            M0(recyclerView.f6241c, recyclerView.f6268q0, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void L1() {
            y yVar = this.f6341g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public void M0(@NonNull v vVar, @NonNull z zVar, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z10 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f6336b.canScrollVertically(-1) && !this.f6336b.canScrollHorizontally(-1) && !this.f6336b.canScrollHorizontally(1)) {
                    z10 = false;
                }
                accessibilityEvent.setScrollable(z10);
                Adapter adapter = this.f6336b.f6262n;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.g());
                }
            }
        }

        public boolean M1() {
            return false;
        }

        public boolean N() {
            RecyclerView recyclerView = this.f6336b;
            return recyclerView != null && recyclerView.f6251h;
        }

        /* access modifiers changed from: package-private */
        public void N0(androidx.core.view.accessibility.k kVar) {
            RecyclerView recyclerView = this.f6336b;
            O0(recyclerView.f6241c, recyclerView.f6268q0, kVar);
        }

        public int O(@NonNull v vVar, @NonNull z zVar) {
            return -1;
        }

        public void O0(@NonNull v vVar, @NonNull z zVar, @NonNull androidx.core.view.accessibility.k kVar) {
            if (this.f6336b.canScrollVertically(-1) || this.f6336b.canScrollHorizontally(-1)) {
                kVar.a(8192);
                kVar.u0(true);
            }
            if (this.f6336b.canScrollVertically(1) || this.f6336b.canScrollHorizontally(1)) {
                kVar.a(Opcodes.ACC_SYNTHETIC);
                kVar.u0(true);
            }
            kVar.c0(k.b.a(l0(vVar, zVar), O(vVar, zVar), w0(vVar, zVar), m0(vVar, zVar)));
        }

        public int P(@NonNull View view) {
            return view.getBottom() + I(view);
        }

        /* access modifiers changed from: package-private */
        public void P0(View view, androidx.core.view.accessibility.k kVar) {
            d0 l02 = RecyclerView.l0(view);
            if (l02 != null && !l02.E() && !this.f6335a.n(l02.f6302a)) {
                RecyclerView recyclerView = this.f6336b;
                Q0(recyclerView.f6241c, recyclerView.f6268q0, view, kVar);
            }
        }

        public void Q(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.n0(view, rect);
        }

        public void Q0(@NonNull v vVar, @NonNull z zVar, @NonNull View view, @NonNull androidx.core.view.accessibility.k kVar) {
        }

        public int R(@NonNull View view) {
            return view.getLeft() - b0(view);
        }

        public View R0(@NonNull View view, int i10) {
            return null;
        }

        public int S(@NonNull View view) {
            Rect rect = ((p) view.getLayoutParams()).f6360b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void S0(@NonNull RecyclerView recyclerView, int i10, int i11) {
        }

        public int T(@NonNull View view) {
            Rect rect = ((p) view.getLayoutParams()).f6360b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void T0(@NonNull RecyclerView recyclerView) {
        }

        public int U(@NonNull View view) {
            return view.getRight() + k0(view);
        }

        public void U0(@NonNull RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public int V(@NonNull View view) {
            return view.getTop() - n0(view);
        }

        public void V0(@NonNull RecyclerView recyclerView, int i10, int i11) {
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f6335a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void W0(@NonNull RecyclerView recyclerView, int i10, int i11) {
        }

        public int X() {
            return this.f6352r;
        }

        public void X0(@NonNull RecyclerView recyclerView, int i10, int i11, Object obj) {
            W0(recyclerView, i10, i11);
        }

        public int Y() {
            return this.f6350p;
        }

        @SuppressLint({"UnknownNullness"})
        public void Y0(v vVar, z zVar) {
        }

        public int Z() {
            Adapter adapter;
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.g();
            }
            return 0;
        }

        @SuppressLint({"UnknownNullness"})
        public void Z0(z zVar) {
        }

        public int a0() {
            return n0.B(this.f6336b);
        }

        public void a1(@NonNull v vVar, @NonNull z zVar, int i10, int i11) {
            this.f6336b.B(i10, i11);
        }

        public int b0(@NonNull View view) {
            return ((p) view.getLayoutParams()).f6360b.left;
        }

        @Deprecated
        public boolean b1(@NonNull RecyclerView recyclerView, @NonNull View view, View view2) {
            return y0() || recyclerView.B0();
        }

        @SuppressLint({"UnknownNullness"})
        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return n0.C(this.f6336b);
        }

        public boolean c1(@NonNull RecyclerView recyclerView, @NonNull z zVar, @NonNull View view, View view2) {
            return b1(recyclerView, view, view2);
        }

        @SuppressLint({"UnknownNullness"})
        public void d(View view, int i10) {
            g(view, i10, true);
        }

        public int d0() {
            return n0.D(this.f6336b);
        }

        @SuppressLint({"UnknownNullness"})
        public void d1(Parcelable parcelable) {
        }

        @SuppressLint({"UnknownNullness"})
        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable e1() {
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public void f(View view, int i10) {
            g(view, i10, false);
        }

        public int f0() {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void f1(int i10) {
        }

        public int g0() {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void g1(y yVar) {
            if (this.f6341g == yVar) {
                this.f6341g = null;
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void h(String str) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                recyclerView.q(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean h1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f6336b;
            return i1(recyclerView.f6241c, recyclerView.f6268q0, i10, bundle);
        }

        public void i(@NonNull View view, int i10) {
            j(view, i10, (p) view.getLayoutParams());
        }

        public int i0(@NonNull View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean i1(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.v r9, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.z r10, int r11, android.os.Bundle r12) {
            /*
                r8 = this;
                androidx.recyclerview.widget.RecyclerView r9 = r8.f6336b
                r10 = 0
                if (r9 != 0) goto L_0x0006
                return r10
            L_0x0006:
                int r9 = r8.X()
                int r12 = r8.p0()
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r8.f6336b
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L_0x002f
                androidx.recyclerview.widget.RecyclerView r1 = r8.f6336b
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L_0x002f
                int r9 = r0.height()
                int r12 = r0.width()
            L_0x002f:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r11 == r0) goto L_0x0065
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r0) goto L_0x003b
                r3 = r10
                r4 = r3
                goto L_0x0091
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f6336b
                r0 = -1
                boolean r11 = r11.canScrollVertically(r0)
                if (r11 == 0) goto L_0x0050
                int r11 = r8.h0()
                int r9 = r9 - r11
                int r11 = r8.e0()
                int r9 = r9 - r11
                int r9 = -r9
                goto L_0x0051
            L_0x0050:
                r9 = r10
            L_0x0051:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f6336b
                boolean r11 = r11.canScrollHorizontally(r0)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.f0()
                int r12 = r12 - r11
                int r11 = r8.g0()
                int r12 = r12 - r11
                int r11 = -r12
                goto L_0x008c
            L_0x0065:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f6336b
                boolean r11 = r11.canScrollVertically(r1)
                if (r11 == 0) goto L_0x0078
                int r11 = r8.h0()
                int r9 = r9 - r11
                int r11 = r8.e0()
                int r9 = r9 - r11
                goto L_0x0079
            L_0x0078:
                r9 = r10
            L_0x0079:
                androidx.recyclerview.widget.RecyclerView r11 = r8.f6336b
                boolean r11 = r11.canScrollHorizontally(r1)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.f0()
                int r12 = r12 - r11
                int r11 = r8.g0()
                int r11 = r12 - r11
            L_0x008c:
                r4 = r9
                r3 = r11
                goto L_0x0091
            L_0x008f:
                r4 = r9
                r3 = r10
            L_0x0091:
                if (r4 != 0) goto L_0x0096
                if (r3 != 0) goto L_0x0096
                return r10
            L_0x0096:
                androidx.recyclerview.widget.RecyclerView r2 = r8.f6336b
                r5 = 0
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = 1
                r2.A1(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.i1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, int, android.os.Bundle):boolean");
        }

        public void j(@NonNull View view, int i10, p pVar) {
            d0 l02 = RecyclerView.l0(view);
            if (l02.E()) {
                this.f6336b.f6249g.b(l02);
            } else {
                this.f6336b.f6249g.p(l02);
            }
            this.f6335a.c(view, i10, pVar, l02.E());
        }

        /* access modifiers changed from: package-private */
        public boolean j1(@NonNull View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f6336b;
            return k1(recyclerView.f6241c, recyclerView.f6268q0, view, i10, bundle);
        }

        public void k(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.q0(view));
            }
        }

        public int k0(@NonNull View view) {
            return ((p) view.getLayoutParams()).f6360b.right;
        }

        public boolean k1(@NonNull v vVar, @NonNull z zVar, @NonNull View view, int i10, Bundle bundle) {
            return false;
        }

        public boolean l() {
            return false;
        }

        public int l0(@NonNull v vVar, @NonNull z zVar) {
            return -1;
        }

        public void l1(@NonNull v vVar) {
            for (int K = K() - 1; K >= 0; K--) {
                if (!RecyclerView.l0(J(K)).S()) {
                    o1(K, vVar);
                }
            }
        }

        public boolean m() {
            return false;
        }

        public int m0(@NonNull v vVar, @NonNull z zVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void m1(v vVar) {
            int j10 = vVar.j();
            for (int i10 = j10 - 1; i10 >= 0; i10--) {
                View n10 = vVar.n(i10);
                d0 l02 = RecyclerView.l0(n10);
                if (!l02.S()) {
                    l02.P(false);
                    if (l02.G()) {
                        this.f6336b.removeDetachedView(n10, false);
                    }
                    l lVar = this.f6336b.V;
                    if (lVar != null) {
                        lVar.j(l02);
                    }
                    l02.P(true);
                    vVar.D(n10);
                }
            }
            vVar.e();
            if (j10 > 0) {
                this.f6336b.invalidate();
            }
        }

        public boolean n(p pVar) {
            return pVar != null;
        }

        public int n0(@NonNull View view) {
            return ((p) view.getLayoutParams()).f6360b.top;
        }

        public void n1(@NonNull View view, @NonNull v vVar) {
            q1(view);
            vVar.G(view);
        }

        public void o0(@NonNull View view, boolean z10, @NonNull Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((p) view.getLayoutParams()).f6360b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f6336b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f6336b.f6260m;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void o1(int i10, @NonNull v vVar) {
            View J = J(i10);
            r1(i10);
            vVar.G(J);
        }

        @SuppressLint({"UnknownNullness"})
        public void p(int i10, int i11, z zVar, c cVar) {
        }

        public int p0() {
            return this.f6351q;
        }

        public boolean p1(Runnable runnable) {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void q(int i10, c cVar) {
        }

        public int q0() {
            return this.f6349o;
        }

        @SuppressLint({"UnknownNullness"})
        public void q1(View view) {
            this.f6335a.p(view);
        }

        public int r(@NonNull z zVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean r0() {
            int K = K();
            for (int i10 = 0; i10 < K; i10++) {
                ViewGroup.LayoutParams layoutParams = J(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void r1(int i10) {
            if (J(i10) != null) {
                this.f6335a.q(i10);
            }
        }

        public int s(@NonNull z zVar) {
            return 0;
        }

        public boolean s0() {
            return this.f6343i;
        }

        public boolean s1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10) {
            return t1(recyclerView, view, rect, z10, false);
        }

        public int t(@NonNull z zVar) {
            return 0;
        }

        public boolean t0() {
            return this.f6344j;
        }

        public boolean t1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10, boolean z11) {
            int[] M = M(view, rect);
            int i10 = M[0];
            int i11 = M[1];
            if ((z11 && !u0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.x1(i10, i11);
            }
            return true;
        }

        public int u(@NonNull z zVar) {
            return 0;
        }

        public void u1() {
            RecyclerView recyclerView = this.f6336b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int v(@NonNull z zVar) {
            return 0;
        }

        public final boolean v0() {
            return this.f6346l;
        }

        public void v1() {
            this.f6342h = true;
        }

        public int w(@NonNull z zVar) {
            return 0;
        }

        public boolean w0(@NonNull v vVar, @NonNull z zVar) {
            return false;
        }

        public void x(@NonNull v vVar) {
            for (int K = K() - 1; K >= 0; K--) {
                w1(vVar, K, J(K));
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int x1(int i10, v vVar, z zVar) {
            return 0;
        }

        public void y(int i10) {
            z(i10, J(i10));
        }

        public boolean y0() {
            y yVar = this.f6341g;
            return yVar != null && yVar.h();
        }

        public void y1(int i10) {
        }

        public boolean z0(@NonNull View view, boolean z10, boolean z11) {
            boolean z12;
            if (!this.f6339e.b(view, 24579) || !this.f6340f.b(view, 24579)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z10) {
                return z12;
            }
            return !z12;
        }

        @SuppressLint({"UnknownNullness"})
        public int z1(int i10, v vVar, z zVar) {
            return 0;
        }
    }

    public interface q {
        void b(@NonNull View view);

        void d(@NonNull View view);
    }

    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    public interface s {
        void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void e(boolean z10);
    }

    public static abstract class t {
        public void a(@NonNull RecyclerView recyclerView, int i10) {
        }

        public void b(@NonNull RecyclerView recyclerView, int i10, int i11) {
        }
    }

    public static class u {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f6363a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f6364b = 0;

        /* renamed from: c  reason: collision with root package name */
        Set<Adapter<?>> f6365c = Collections.newSetFromMap(new IdentityHashMap());

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<d0> f6366a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f6367b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f6368c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f6369d = 0;

            a() {
            }
        }

        private a i(int i10) {
            a aVar = this.f6363a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f6363a.put(i10, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6364b++;
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull Adapter<?> adapter) {
            this.f6365c.add(adapter);
        }

        public void c() {
            for (int i10 = 0; i10 < this.f6363a.size(); i10++) {
                a valueAt = this.f6363a.valueAt(i10);
                Iterator<d0> it = valueAt.f6366a.iterator();
                while (it.hasNext()) {
                    y0.a.a(it.next().f6302a);
                }
                valueAt.f6366a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f6364b--;
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull Adapter<?> adapter, boolean z10) {
            this.f6365c.remove(adapter);
            if (this.f6365c.size() == 0 && !z10) {
                for (int i10 = 0; i10 < this.f6363a.size(); i10++) {
                    SparseArray<a> sparseArray = this.f6363a;
                    ArrayList<d0> arrayList = sparseArray.get(sparseArray.keyAt(i10)).f6366a;
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        y0.a.a(arrayList.get(i11).f6302a);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(int i10, long j10) {
            a i11 = i(i10);
            i11.f6369d = l(i11.f6369d, j10);
        }

        /* access modifiers changed from: package-private */
        public void g(int i10, long j10) {
            a i11 = i(i10);
            i11.f6368c = l(i11.f6368c, j10);
        }

        public d0 h(int i10) {
            a aVar = this.f6363a.get(i10);
            if (aVar == null || aVar.f6366a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f6366a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).A()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void j(Adapter<?> adapter, Adapter<?> adapter2, boolean z10) {
            if (adapter != null) {
                d();
            }
            if (!z10 && this.f6364b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(d0 d0Var) {
            int t10 = d0Var.t();
            ArrayList<d0> arrayList = i(t10).f6366a;
            if (this.f6363a.get(t10).f6367b <= arrayList.size()) {
                y0.a.a(d0Var.f6302a);
                return;
            }
            d0Var.M();
            arrayList.add(d0Var);
        }

        /* access modifiers changed from: package-private */
        public long l(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        /* access modifiers changed from: package-private */
        public boolean m(int i10, long j10, long j11) {
            long j12 = i(i10).f6369d;
            return j12 == 0 || j10 + j12 < j11;
        }

        /* access modifiers changed from: package-private */
        public boolean n(int i10, long j10, long j11) {
            long j12 = i(i10).f6368c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    public final class v {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<d0> f6370a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<d0> f6371b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<d0> f6372c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<d0> f6373d;

        /* renamed from: e  reason: collision with root package name */
        private int f6374e;

        /* renamed from: f  reason: collision with root package name */
        int f6375f;

        /* renamed from: g  reason: collision with root package name */
        u f6376g;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f6370a = arrayList;
            this.f6373d = Collections.unmodifiableList(arrayList);
            this.f6374e = 2;
            this.f6375f = 2;
        }

        private void B(Adapter<?> adapter) {
            C(adapter, false);
        }

        private void C(Adapter<?> adapter, boolean z10) {
            u uVar = this.f6376g;
            if (uVar != null) {
                uVar.e(adapter, z10);
            }
        }

        private boolean M(@NonNull d0 d0Var, int i10, int i11, long j10) {
            d0Var.f6320s = null;
            d0Var.f6319r = RecyclerView.this;
            int t10 = d0Var.t();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f6376g.m(t10, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f6262n.c(d0Var, i10);
            this.f6376g.f(d0Var.t(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.f6268q0.e()) {
                return true;
            }
            d0Var.f6308g = i11;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.A0()) {
                View view = d0Var.f6302a;
                if (n0.z(view) == 0) {
                    n0.D0(view, 1);
                }
                v vVar = RecyclerView.this.f6278x0;
                if (vVar != null) {
                    androidx.core.view.a n10 = vVar.n();
                    if (n10 instanceof v.a) {
                        ((v.a) n10).o(view);
                    }
                    n0.s0(view, n10);
                }
            }
        }

        private void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.f6302a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        private void u() {
            if (this.f6376g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f6262n != null && recyclerView.isAttachedToWindow()) {
                    this.f6376g.b(RecyclerView.this.f6262n);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void A() {
            for (int i10 = 0; i10 < this.f6372c.size(); i10++) {
                y0.a.a(this.f6372c.get(i10).f6302a);
            }
            B(RecyclerView.this.f6262n);
        }

        /* access modifiers changed from: package-private */
        public void D(View view) {
            d0 l02 = RecyclerView.l0(view);
            l02.f6315n = null;
            l02.f6316o = false;
            l02.j();
            H(l02);
        }

        /* access modifiers changed from: package-private */
        public void E() {
            for (int size = this.f6372c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f6372c.clear();
            if (RecyclerView.P0) {
                RecyclerView.this.f6266p0.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void F(int i10) {
            a(this.f6372c.get(i10), true);
            this.f6372c.remove(i10);
        }

        public void G(@NonNull View view) {
            d0 l02 = RecyclerView.l0(view);
            if (l02.G()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (l02.F()) {
                l02.T();
            } else if (l02.U()) {
                l02.j();
            }
            H(l02);
            if (RecyclerView.this.V != null && !l02.D()) {
                RecyclerView.this.V.j(l02);
            }
        }

        /* access modifiers changed from: package-private */
        public void H(d0 d0Var) {
            boolean z10;
            boolean z11;
            boolean z12 = false;
            boolean z13 = true;
            if (d0Var.F() || d0Var.f6302a.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(d0Var.F());
                sb2.append(" isAttached:");
                if (d0Var.f6302a.getParent() != null) {
                    z12 = true;
                }
                sb2.append(z12);
                sb2.append(RecyclerView.this.U());
                throw new IllegalArgumentException(sb2.toString());
            } else if (d0Var.G()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.U());
            } else if (!d0Var.S()) {
                boolean m10 = d0Var.m();
                Adapter adapter = RecyclerView.this.f6262n;
                if (adapter == null || !m10 || !adapter.z(d0Var)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10 || d0Var.D()) {
                    if (this.f6375f <= 0 || d0Var.y(526)) {
                        z11 = false;
                    } else {
                        int size = this.f6372c.size();
                        if (size >= this.f6375f && size > 0) {
                            F(0);
                            size--;
                        }
                        if (RecyclerView.P0 && size > 0 && !RecyclerView.this.f6266p0.d(d0Var.f6304c)) {
                            int i10 = size - 1;
                            while (i10 >= 0) {
                                if (!RecyclerView.this.f6266p0.d(this.f6372c.get(i10).f6304c)) {
                                    break;
                                }
                                i10--;
                            }
                            size = i10 + 1;
                        }
                        this.f6372c.add(size, d0Var);
                        z11 = true;
                    }
                    if (!z11) {
                        a(d0Var, true);
                    } else {
                        z13 = false;
                    }
                    z12 = z11;
                } else {
                    z13 = false;
                }
                RecyclerView.this.f6249g.q(d0Var);
                if (!z12 && !z13 && m10) {
                    y0.a.a(d0Var.f6302a);
                    d0Var.f6320s = null;
                    d0Var.f6319r = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.U());
            }
        }

        /* access modifiers changed from: package-private */
        public void I(View view) {
            d0 l02 = RecyclerView.l0(view);
            if (!l02.y(12) && l02.H() && !RecyclerView.this.r(l02)) {
                if (this.f6371b == null) {
                    this.f6371b = new ArrayList<>();
                }
                l02.Q(this, true);
                this.f6371b.add(l02);
            } else if (!l02.C() || l02.E() || RecyclerView.this.f6262n.k()) {
                l02.Q(this, false);
                this.f6370a.add(l02);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.U());
            }
        }

        /* access modifiers changed from: package-private */
        public void J(u uVar) {
            B(RecyclerView.this.f6262n);
            u uVar2 = this.f6376g;
            if (uVar2 != null) {
                uVar2.d();
            }
            this.f6376g = uVar;
            if (!(uVar == null || RecyclerView.this.getAdapter() == null)) {
                this.f6376g.a();
            }
            u();
        }

        /* access modifiers changed from: package-private */
        public void K(b0 b0Var) {
        }

        public void L(int i10) {
            this.f6374e = i10;
            P();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x014d  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0179  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01a9  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.d0 N(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x01da
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f6268q0
                int r1 = r1.b()
                if (r3 >= r1) goto L_0x01da
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f6268q0
                boolean r1 = r1.e()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$d0 r1 = r16.h(r17)
                if (r1 == 0) goto L_0x0028
                r4 = r7
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = r8
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$d0 r1 = r16.m(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.Q(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.g(r5)
                boolean r5 = r1.F()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.f6302a
                r5.removeDetachedView(r9, r8)
                r1.T()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.U()
                if (r5 == 0) goto L_0x0057
                r1.j()
            L_0x0057:
                r6.H(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = r7
            L_0x005d:
                if (r1 != 0) goto L_0x012c
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f6245e
                int r5 = r5.m(r3)
                if (r5 < 0) goto L_0x00f4
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f6262n
                int r9 = r9.g()
                if (r5 >= r9) goto L_0x00f4
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f6262n
                int r9 = r9.i(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.f6262n
                boolean r10 = r10.k()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.f6262n
                long r10 = r1.h(r5)
                androidx.recyclerview.widget.RecyclerView$d0 r1 = r6.l(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.f6304c = r5
                r4 = r7
            L_0x0096:
                if (r1 != 0) goto L_0x00ad
                androidx.recyclerview.widget.RecyclerView$u r0 = r16.i()
                androidx.recyclerview.widget.RecyclerView$d0 r0 = r0.h(r9)
                if (r0 == 0) goto L_0x00ac
                r0.M()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.M0
                if (r1 == 0) goto L_0x00ac
                r6.r(r0)
            L_0x00ac:
                r1 = r0
            L_0x00ad:
                if (r1 != 0) goto L_0x012c
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x00cb
                androidx.recyclerview.widget.RecyclerView$u r10 = r6.f6376g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.n(r11, r12, r14)
                if (r5 != 0) goto L_0x00cb
                return r2
            L_0x00cb:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r2.f6262n
                androidx.recyclerview.widget.RecyclerView$d0 r2 = r5.e(r2, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.P0
                if (r5 == 0) goto L_0x00e6
                android.view.View r5 = r2.f6302a
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.b0(r5)
                if (r5 == 0) goto L_0x00e6
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.f6303b = r10
            L_0x00e6:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$u r5 = r6.f6376g
                long r10 = r10 - r0
                r5.g(r9, r10)
                r9 = r2
                goto L_0x012d
            L_0x00f4:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f6268q0
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.U()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x012c:
                r9 = r1
            L_0x012d:
                r10 = r4
                if (r10 == 0) goto L_0x0166
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f6268q0
                boolean r0 = r0.e()
                if (r0 != 0) goto L_0x0166
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.y(r0)
                if (r1 == 0) goto L_0x0166
                r9.O(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f6268q0
                boolean r0 = r0.f6404k
                if (r0 == 0) goto L_0x0166
                int r0 = androidx.recyclerview.widget.RecyclerView.l.e(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$l r2 = r1.V
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f6268q0
                java.util.List r4 = r9.x()
                androidx.recyclerview.widget.RecyclerView$l$c r0 = r2.u(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.Z0(r9, r0)
            L_0x0166:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f6268q0
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0179
                boolean r0 = r9.B()
                if (r0 == 0) goto L_0x0179
                r9.f6308g = r3
                goto L_0x018c
            L_0x0179:
                boolean r0 = r9.B()
                if (r0 == 0) goto L_0x018e
                boolean r0 = r9.I()
                if (r0 != 0) goto L_0x018e
                boolean r0 = r9.C()
                if (r0 == 0) goto L_0x018c
                goto L_0x018e
            L_0x018c:
                r0 = r8
                goto L_0x01a1
            L_0x018e:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f6245e
                int r2 = r0.m(r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.M(r1, r2, r3, r4)
            L_0x01a1:
                android.view.View r1 = r9.f6302a
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x01b7
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.p) r1
                android.view.View r2 = r9.f6302a
                r2.setLayoutParams(r1)
                goto L_0x01cf
            L_0x01b7:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x01cd
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.p) r1
                android.view.View r2 = r9.f6302a
                r2.setLayoutParams(r1)
                goto L_0x01cf
            L_0x01cd:
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.p) r1
            L_0x01cf:
                r1.f6359a = r9
                if (r10 == 0) goto L_0x01d6
                if (r0 == 0) goto L_0x01d6
                goto L_0x01d7
            L_0x01d6:
                r7 = r8
            L_0x01d7:
                r1.f6362d = r7
                return r9
            L_0x01da:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f6268q0
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.U()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.N(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        /* access modifiers changed from: package-private */
        public void O(d0 d0Var) {
            if (d0Var.f6316o) {
                this.f6371b.remove(d0Var);
            } else {
                this.f6370a.remove(d0Var);
            }
            d0Var.f6315n = null;
            d0Var.f6316o = false;
            d0Var.j();
        }

        /* access modifiers changed from: package-private */
        public void P() {
            int i10;
            o oVar = RecyclerView.this.f6265p;
            if (oVar != null) {
                i10 = oVar.f6347m;
            } else {
                i10 = 0;
            }
            this.f6375f = this.f6374e + i10;
            for (int size = this.f6372c.size() - 1; size >= 0 && this.f6372c.size() > this.f6375f; size--) {
                F(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean Q(d0 d0Var) {
            if (d0Var.E()) {
                return RecyclerView.this.f6268q0.e();
            }
            int i10 = d0Var.f6304c;
            if (i10 < 0 || i10 >= RecyclerView.this.f6262n.g()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.U());
            } else if (!RecyclerView.this.f6268q0.e() && RecyclerView.this.f6262n.i(d0Var.f6304c) != d0Var.t()) {
                return false;
            } else {
                if (!RecyclerView.this.f6262n.k()) {
                    return true;
                }
                if (d0Var.s() == RecyclerView.this.f6262n.h(d0Var.f6304c)) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void R(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f6372c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f6372c.get(size);
                if (d0Var != null && (i12 = d0Var.f6304c) >= i10 && i12 < i13) {
                    d0Var.g(2);
                    F(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull d0 d0Var, boolean z10) {
            androidx.core.view.a aVar;
            RecyclerView.t(d0Var);
            View view = d0Var.f6302a;
            v vVar = RecyclerView.this.f6278x0;
            if (vVar != null) {
                androidx.core.view.a n10 = vVar.n();
                if (n10 instanceof v.a) {
                    aVar = ((v.a) n10).n(view);
                } else {
                    aVar = null;
                }
                n0.s0(view, aVar);
            }
            if (z10) {
                g(d0Var);
            }
            d0Var.f6320s = null;
            d0Var.f6319r = null;
            i().k(d0Var);
        }

        public void c() {
            this.f6370a.clear();
            E();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int size = this.f6372c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f6372c.get(i10).h();
            }
            int size2 = this.f6370a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f6370a.get(i11).h();
            }
            ArrayList<d0> arrayList = this.f6371b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f6371b.get(i12).h();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f6370a.clear();
            ArrayList<d0> arrayList = this.f6371b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 < 0 || i10 >= RecyclerView.this.f6268q0.b()) {
                throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f6268q0.b() + RecyclerView.this.U());
            } else if (!RecyclerView.this.f6268q0.e()) {
                return i10;
            } else {
                return RecyclerView.this.f6245e.m(i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull d0 d0Var) {
            w wVar = RecyclerView.this.f6267q;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            int size = RecyclerView.this.f6271t.size();
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.this.f6271t.get(i10).a(d0Var);
            }
            Adapter adapter = RecyclerView.this.f6262n;
            if (adapter != null) {
                adapter.C(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f6268q0 != null) {
                recyclerView.f6249g.q(d0Var);
            }
        }

        /* access modifiers changed from: package-private */
        public d0 h(int i10) {
            int size;
            int m10;
            ArrayList<d0> arrayList = this.f6371b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i11 = 0;
                int i12 = 0;
                while (i12 < size) {
                    d0 d0Var = this.f6371b.get(i12);
                    if (d0Var.U() || d0Var.u() != i10) {
                        i12++;
                    } else {
                        d0Var.g(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f6262n.k() && (m10 = RecyclerView.this.f6245e.m(i10)) > 0 && m10 < RecyclerView.this.f6262n.g()) {
                    long h10 = RecyclerView.this.f6262n.h(m10);
                    while (i11 < size) {
                        d0 d0Var2 = this.f6371b.get(i11);
                        if (d0Var2.U() || d0Var2.s() != h10) {
                            i11++;
                        } else {
                            d0Var2.g(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public u i() {
            if (this.f6376g == null) {
                this.f6376g = new u();
                u();
            }
            return this.f6376g;
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return this.f6370a.size();
        }

        @NonNull
        public List<d0> k() {
            return this.f6373d;
        }

        /* access modifiers changed from: package-private */
        public d0 l(long j10, int i10, boolean z10) {
            for (int size = this.f6370a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f6370a.get(size);
                if (d0Var.s() == j10 && !d0Var.U()) {
                    if (i10 == d0Var.t()) {
                        d0Var.g(32);
                        if (d0Var.E() && !RecyclerView.this.f6268q0.e()) {
                            d0Var.O(2, 14);
                        }
                        return d0Var;
                    } else if (!z10) {
                        this.f6370a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f6302a, false);
                        D(d0Var.f6302a);
                    }
                }
            }
            int size2 = this.f6372c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f6372c.get(size2);
                if (d0Var2.s() == j10 && !d0Var2.A()) {
                    if (i10 == d0Var2.t()) {
                        if (!z10) {
                            this.f6372c.remove(size2);
                        }
                        return d0Var2;
                    } else if (!z10) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public d0 m(int i10, boolean z10) {
            View e10;
            int size = this.f6370a.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                d0 d0Var = this.f6370a.get(i12);
                if (d0Var.U() || d0Var.u() != i10 || d0Var.C() || (!RecyclerView.this.f6268q0.f6401h && d0Var.E())) {
                    i12++;
                } else {
                    d0Var.g(32);
                    return d0Var;
                }
            }
            if (z10 || (e10 = RecyclerView.this.f6247f.e(i10)) == null) {
                int size2 = this.f6372c.size();
                while (i11 < size2) {
                    d0 d0Var2 = this.f6372c.get(i11);
                    if (d0Var2.C() || d0Var2.u() != i10 || d0Var2.A()) {
                        i11++;
                    } else {
                        if (!z10) {
                            this.f6372c.remove(i11);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 l02 = RecyclerView.l0(e10);
            RecyclerView.this.f6247f.s(e10);
            int m10 = RecyclerView.this.f6247f.m(e10);
            if (m10 != -1) {
                RecyclerView.this.f6247f.d(m10);
                I(e10);
                l02.g(8224);
                return l02;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + l02 + RecyclerView.this.U());
        }

        /* access modifiers changed from: package-private */
        public View n(int i10) {
            return this.f6370a.get(i10).f6302a;
        }

        @NonNull
        public View o(int i10) {
            return p(i10, false);
        }

        /* access modifiers changed from: package-private */
        public View p(int i10, boolean z10) {
            return N(i10, z10, Long.MAX_VALUE).f6302a;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f6372c.size();
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) this.f6372c.get(i10).f6302a.getLayoutParams();
                if (pVar != null) {
                    pVar.f6361c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int size = this.f6372c.size();
            for (int i10 = 0; i10 < size; i10++) {
                d0 d0Var = this.f6372c.get(i10);
                if (d0Var != null) {
                    d0Var.g(6);
                    d0Var.f((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.f6262n;
            if (adapter == null || !adapter.k()) {
                E();
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i10, int i11) {
            int size = this.f6372c.size();
            for (int i12 = 0; i12 < size; i12++) {
                d0 d0Var = this.f6372c.get(i12);
                if (d0Var != null && d0Var.f6304c >= i10) {
                    d0Var.J(i11, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void w(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i14 = -1;
                i13 = i10;
                i12 = i11;
            } else {
                i14 = 1;
                i12 = i10;
                i13 = i11;
            }
            int size = this.f6372c.size();
            for (int i16 = 0; i16 < size; i16++) {
                d0 d0Var = this.f6372c.get(i16);
                if (d0Var != null && (i15 = d0Var.f6304c) >= i13 && i15 <= i12) {
                    if (i15 == i10) {
                        d0Var.J(i11 - i10, false);
                    } else {
                        d0Var.J(i14, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void x(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f6372c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f6372c.get(size);
                if (d0Var != null) {
                    int i13 = d0Var.f6304c;
                    if (i13 >= i12) {
                        d0Var.J(-i11, z10);
                    } else if (i13 >= i10) {
                        d0Var.g(8);
                        F(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void y(Adapter<?> adapter, Adapter<?> adapter2, boolean z10) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z10);
            u();
        }

        /* access modifiers changed from: package-private */
        public void z() {
            u();
        }
    }

    public interface w {
        void a(@NonNull d0 d0Var);
    }

    private class x extends i {
        x() {
        }

        public void a() {
            RecyclerView.this.q((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f6268q0.f6400g = true;
            recyclerView.X0(true);
            if (!RecyclerView.this.f6245e.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.q((String) null);
            if (RecyclerView.this.f6245e.r(i10, i11, obj)) {
                g();
            }
        }

        public void d(int i10, int i11) {
            RecyclerView.this.q((String) null);
            if (RecyclerView.this.f6245e.s(i10, i11)) {
                g();
            }
        }

        public void e(int i10, int i11, int i12) {
            RecyclerView.this.q((String) null);
            if (RecyclerView.this.f6245e.t(i10, i11, i12)) {
                g();
            }
        }

        public void f(int i10, int i11) {
            RecyclerView.this.q((String) null);
            if (RecyclerView.this.f6245e.u(i10, i11)) {
                g();
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (RecyclerView.O0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.B && recyclerView.f6281z) {
                    n0.k0(recyclerView, recyclerView.f6254j);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.J = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class y {

        /* renamed from: a  reason: collision with root package name */
        private int f6379a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f6380b;

        /* renamed from: c  reason: collision with root package name */
        private o f6381c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6382d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6383e;

        /* renamed from: f  reason: collision with root package name */
        private View f6384f;

        /* renamed from: g  reason: collision with root package name */
        private final a f6385g = new a(0, 0);

        /* renamed from: h  reason: collision with root package name */
        private boolean f6386h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f6387a;

            /* renamed from: b  reason: collision with root package name */
            private int f6388b;

            /* renamed from: c  reason: collision with root package name */
            private int f6389c;

            /* renamed from: d  reason: collision with root package name */
            private int f6390d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f6391e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f6392f;

            /* renamed from: g  reason: collision with root package name */
            private int f6393g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, (Interpolator) null);
            }

            private void e() {
                if (this.f6391e != null && this.f6389c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f6389c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f6390d >= 0;
            }

            public void b(int i10) {
                this.f6390d = i10;
            }

            /* access modifiers changed from: package-private */
            public void c(RecyclerView recyclerView) {
                int i10 = this.f6390d;
                if (i10 >= 0) {
                    this.f6390d = -1;
                    recyclerView.D0(i10);
                    this.f6392f = false;
                } else if (this.f6392f) {
                    e();
                    recyclerView.f6263n0.e(this.f6387a, this.f6388b, this.f6389c, this.f6391e);
                    this.f6393g++;
                    this.f6392f = false;
                } else {
                    this.f6393g = 0;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f6387a = i10;
                this.f6388b = i11;
                this.f6389c = i12;
                this.f6391e = interpolator;
                this.f6392f = true;
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f6390d = -1;
                this.f6392f = false;
                this.f6393g = 0;
                this.f6387a = i10;
                this.f6388b = i11;
                this.f6389c = i12;
                this.f6391e = interpolator;
            }
        }

        public interface b {
            PointF a(int i10);
        }

        public PointF a(int i10) {
            o e10 = e();
            if (e10 instanceof b) {
                return ((b) e10).a(i10);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb2.append(b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f6380b.f6265p.D(i10);
        }

        public int c() {
            return this.f6380b.f6265p.K();
        }

        public int d(View view) {
            return this.f6380b.j0(view);
        }

        public o e() {
            return this.f6381c;
        }

        public int f() {
            return this.f6379a;
        }

        public boolean g() {
            return this.f6382d;
        }

        public boolean h() {
            return this.f6383e;
        }

        /* access modifiers changed from: protected */
        public void i(@NonNull PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void j(int i10, int i11) {
            PointF a10;
            RecyclerView recyclerView = this.f6380b;
            if (this.f6379a == -1 || recyclerView == null) {
                r();
            }
            if (this.f6382d && this.f6384f == null && this.f6381c != null && (a10 = a(this.f6379a)) != null) {
                float f10 = a10.x;
                if (!(f10 == 0.0f && a10.y == 0.0f)) {
                    recyclerView.r1((int) Math.signum(f10), (int) Math.signum(a10.y), (int[]) null);
                }
            }
            this.f6382d = false;
            View view = this.f6384f;
            if (view != null) {
                if (d(view) == this.f6379a) {
                    o(this.f6384f, recyclerView.f6268q0, this.f6385g);
                    this.f6385g.c(recyclerView);
                    r();
                } else {
                    this.f6384f = null;
                }
            }
            if (this.f6383e) {
                l(i10, i11, recyclerView.f6268q0, this.f6385g);
                boolean a11 = this.f6385g.a();
                this.f6385g.c(recyclerView);
                if (a11 && this.f6383e) {
                    this.f6382d = true;
                    recyclerView.f6263n0.d();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void k(View view) {
            if (d(view) == f()) {
                this.f6384f = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void l(int i10, int i11, @NonNull z zVar, @NonNull a aVar);

        /* access modifiers changed from: protected */
        public abstract void m();

        /* access modifiers changed from: protected */
        public abstract void n();

        /* access modifiers changed from: protected */
        public abstract void o(@NonNull View view, @NonNull z zVar, @NonNull a aVar);

        public void p(int i10) {
            this.f6379a = i10;
        }

        /* access modifiers changed from: package-private */
        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f6263n0.f();
            if (this.f6386h) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("An instance of ");
                sb2.append(getClass().getSimpleName());
                sb2.append(" was started more than once. Each instance of");
                sb2.append(getClass().getSimpleName());
                sb2.append(" is intended to only be used once. You should create a new instance for each use.");
            }
            this.f6380b = recyclerView;
            this.f6381c = oVar;
            int i10 = this.f6379a;
            if (i10 != -1) {
                recyclerView.f6268q0.f6394a = i10;
                this.f6383e = true;
                this.f6382d = true;
                this.f6384f = b(f());
                m();
                this.f6380b.f6263n0.d();
                this.f6386h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void r() {
            if (this.f6383e) {
                this.f6383e = false;
                n();
                this.f6380b.f6268q0.f6394a = -1;
                this.f6384f = null;
                this.f6379a = -1;
                this.f6382d = false;
                this.f6381c.g1(this);
                this.f6381c = null;
                this.f6380b = null;
            }
        }
    }

    public static class z {

        /* renamed from: a  reason: collision with root package name */
        int f6394a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f6395b;

        /* renamed from: c  reason: collision with root package name */
        int f6396c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f6397d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f6398e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f6399f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f6400g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f6401h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f6402i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f6403j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f6404k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f6405l = false;

        /* renamed from: m  reason: collision with root package name */
        int f6406m;

        /* renamed from: n  reason: collision with root package name */
        long f6407n;

        /* renamed from: o  reason: collision with root package name */
        int f6408o;

        /* renamed from: p  reason: collision with root package name */
        int f6409p;

        /* renamed from: q  reason: collision with root package name */
        int f6410q;

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            if ((this.f6398e & i10) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f6398e));
            }
        }

        public int b() {
            if (this.f6401h) {
                return this.f6396c - this.f6397d;
            }
            return this.f6399f;
        }

        public int c() {
            return this.f6394a;
        }

        public boolean d() {
            return this.f6394a != -1;
        }

        public boolean e() {
            return this.f6401h;
        }

        /* access modifiers changed from: package-private */
        public void f(Adapter adapter) {
            this.f6398e = 1;
            this.f6399f = adapter.g();
            this.f6401h = false;
            this.f6402i = false;
            this.f6403j = false;
        }

        public boolean g() {
            return this.f6405l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f6394a + ", mData=" + this.f6395b + ", mItemCount=" + this.f6399f + ", mIsMeasuring=" + this.f6403j + ", mPreviousLayoutItemCount=" + this.f6396c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f6397d + ", mStructureChanged=" + this.f6400g + ", mInPreLayout=" + this.f6401h + ", mRunSimpleAnimations=" + this.f6404k + ", mRunPredictiveAnimations=" + this.f6405l + '}';
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            K0 = r1
            r1 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r1 = java.lang.Math.log(r1)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r1 = r1 / r4
            float r1 = (float) r1
            L0 = r1
            M0 = r3
            N0 = r0
            O0 = r0
            P0 = r0
            Q0 = r3
            R0 = r3
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            S0 = r1
            androidx.recyclerview.widget.RecyclerView$c r0 = new androidx.recyclerview.widget.RecyclerView$c
            r0.<init>()
            T0 = r0
            androidx.recyclerview.widget.RecyclerView$a0 r0 = new androidx.recyclerview.widget.RecyclerView$a0
            r0.<init>()
            U0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String p02 = p0(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(p02, false, classLoader).asSubclass(o.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(S0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                    } catch (NoSuchMethodException e10) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e11) {
                    e11.initCause(e10);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + p02, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + p02, e12);
                } catch (InvocationTargetException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + p02, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + p02, e14);
                } catch (IllegalAccessException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + p02, e15);
                } catch (ClassCastException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + p02, e16);
                }
            }
        }
    }

    private boolean C(int i10, int i11) {
        a0(this.f6282z0);
        int[] iArr = this.f6282z0;
        if (iArr[0] == i10 && iArr[1] == i11) {
            return false;
        }
        return true;
    }

    private boolean C0(View view, View view2, int i10) {
        int i11;
        int i12;
        if (view2 == null || view2 == this || view2 == view || X(view2) == null) {
            return false;
        }
        if (view == null || X(view) == null) {
            return true;
        }
        this.f6256k.set(0, 0, view.getWidth(), view.getHeight());
        this.f6258l.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f6256k);
        offsetDescendantRectToMyCoords(view2, this.f6258l);
        char c10 = 65535;
        if (this.f6265p.a0() == 1) {
            i11 = -1;
        } else {
            i11 = 1;
        }
        Rect rect = this.f6256k;
        int i13 = rect.left;
        Rect rect2 = this.f6258l;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i12 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            if ((i15 > i16 || i13 >= i16) && i13 > i14) {
                i12 = -1;
            } else {
                i12 = 0;
            }
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i10 + U());
                            } else if (c10 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i12 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c10 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i12 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c10 > 0 || (c10 == 0 && i12 * i11 > 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c10 < 0 || (c10 == 0 && i12 * i11 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean E1(MotionEvent motionEvent) {
        boolean z10;
        EdgeEffect edgeEffect = this.R;
        if (edgeEffect == null || androidx.core.widget.e.b(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z10 = false;
        } else {
            androidx.core.widget.e.d(this.R, 0.0f, 1.0f - (motionEvent.getY() / ((float) getHeight())));
            z10 = true;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (!(edgeEffect2 == null || androidx.core.widget.e.b(edgeEffect2) == 0.0f || canScrollHorizontally(1))) {
            androidx.core.widget.e.d(this.T, 0.0f, motionEvent.getY() / ((float) getHeight()));
            z10 = true;
        }
        EdgeEffect edgeEffect3 = this.S;
        if (!(edgeEffect3 == null || androidx.core.widget.e.b(edgeEffect3) == 0.0f || canScrollVertically(-1))) {
            androidx.core.widget.e.d(this.S, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z10 = true;
        }
        EdgeEffect edgeEffect4 = this.U;
        if (edgeEffect4 == null || androidx.core.widget.e.b(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z10;
        }
        androidx.core.widget.e.d(this.U, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void F() {
        int i10 = this.I;
        this.I = 0;
        if (i10 != 0 && A0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            androidx.core.view.accessibility.b.b(obtain, i10);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void G0(int i10, int i11, MotionEvent motionEvent, int i12) {
        boolean z10;
        float f10;
        float f11;
        int i13;
        int i14;
        int i15;
        o oVar = this.f6265p;
        if (oVar != null && !this.G) {
            int[] iArr = this.D0;
            int i16 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean l10 = oVar.l();
            boolean m10 = this.f6265p.m();
            if (m10) {
                z10 = l10 | true;
            } else {
                z10 = l10;
            }
            if (motionEvent == null) {
                f10 = ((float) getHeight()) / 2.0f;
            } else {
                f10 = motionEvent.getY();
            }
            if (motionEvent == null) {
                f11 = ((float) getWidth()) / 2.0f;
            } else {
                f11 = motionEvent.getX();
            }
            int c12 = i10 - c1(i10, f10);
            int d12 = i11 - d1(i11, f11);
            D1(z10 ? 1 : 0, i12);
            if (l10) {
                i13 = c12;
            } else {
                i13 = 0;
            }
            if (m10) {
                i14 = d12;
            } else {
                i14 = 0;
            }
            if (K(i13, i14, this.D0, this.B0, i12)) {
                int[] iArr2 = this.D0;
                c12 -= iArr2[0];
                d12 -= iArr2[1];
            }
            if (l10) {
                i15 = c12;
            } else {
                i15 = 0;
            }
            if (m10) {
                i16 = d12;
            }
            q1(i15, i16, motionEvent, i12);
            k kVar = this.f6264o0;
            if (!(kVar == null || (c12 == 0 && d12 == 0))) {
                kVar.f(this, c12, d12);
            }
            G1(i12);
        }
    }

    private void H() {
        boolean z10 = true;
        this.f6268q0.a(1);
        V(this.f6268q0);
        this.f6268q0.f6403j = false;
        C1();
        this.f6249g.f();
        O0();
        W0();
        o1();
        z zVar = this.f6268q0;
        if (!zVar.f6404k || !this.f6273u0) {
            z10 = false;
        }
        zVar.f6402i = z10;
        this.f6273u0 = false;
        this.f6272t0 = false;
        zVar.f6401h = zVar.f6405l;
        zVar.f6399f = this.f6262n.g();
        a0(this.f6282z0);
        if (this.f6268q0.f6404k) {
            int g10 = this.f6247f.g();
            for (int i10 = 0; i10 < g10; i10++) {
                d0 l02 = l0(this.f6247f.f(i10));
                if (!l02.S() && (!l02.C() || this.f6262n.k())) {
                    this.f6249g.e(l02, this.V.u(this.f6268q0, l02, l.e(l02), l02.x()));
                    if (this.f6268q0.f6402i && l02.H() && !l02.E() && !l02.S() && !l02.C()) {
                        this.f6249g.c(i0(l02), l02);
                    }
                }
            }
        }
        if (this.f6268q0.f6405l) {
            p1();
            z zVar2 = this.f6268q0;
            boolean z11 = zVar2.f6400g;
            zVar2.f6400g = false;
            this.f6265p.Y0(this.f6241c, zVar2);
            this.f6268q0.f6400g = z11;
            for (int i11 = 0; i11 < this.f6247f.g(); i11++) {
                d0 l03 = l0(this.f6247f.f(i11));
                if (!l03.S() && !this.f6249g.i(l03)) {
                    int e10 = l.e(l03);
                    boolean y10 = l03.y(8192);
                    if (!y10) {
                        e10 |= Opcodes.ACC_SYNTHETIC;
                    }
                    l.c u10 = this.V.u(this.f6268q0, l03, e10, l03.x());
                    if (y10) {
                        Z0(l03, u10);
                    } else {
                        this.f6249g.a(l03, u10);
                    }
                }
            }
            u();
        } else {
            u();
        }
        P0();
        F1(false);
        this.f6268q0.f6398e = 2;
    }

    private void I() {
        boolean z10;
        C1();
        O0();
        this.f6268q0.a(6);
        this.f6245e.j();
        this.f6268q0.f6399f = this.f6262n.g();
        this.f6268q0.f6397d = 0;
        if (this.f6243d != null && this.f6262n.d()) {
            Parcelable parcelable = this.f6243d.f6290c;
            if (parcelable != null) {
                this.f6265p.d1(parcelable);
            }
            this.f6243d = null;
        }
        z zVar = this.f6268q0;
        zVar.f6401h = false;
        this.f6265p.Y0(this.f6241c, zVar);
        z zVar2 = this.f6268q0;
        zVar2.f6400g = false;
        if (!zVar2.f6404k || this.V == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        zVar2.f6404k = z10;
        zVar2.f6398e = 4;
        P0();
        F1(false);
    }

    private void I1() {
        this.f6263n0.f();
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.L1();
        }
    }

    private void J() {
        this.f6268q0.a(4);
        C1();
        O0();
        z zVar = this.f6268q0;
        zVar.f6398e = 1;
        if (zVar.f6404k) {
            for (int g10 = this.f6247f.g() - 1; g10 >= 0; g10--) {
                d0 l02 = l0(this.f6247f.f(g10));
                if (!l02.S()) {
                    long i02 = i0(l02);
                    l.c t10 = this.V.t(this.f6268q0, l02);
                    d0 g11 = this.f6249g.g(i02);
                    if (g11 == null || g11.S()) {
                        this.f6249g.d(l02, t10);
                    } else {
                        boolean h10 = this.f6249g.h(g11);
                        boolean h11 = this.f6249g.h(l02);
                        if (!h10 || g11 != l02) {
                            l.c n10 = this.f6249g.n(g11);
                            this.f6249g.d(l02, t10);
                            l.c m10 = this.f6249g.m(l02);
                            if (n10 == null) {
                                s0(i02, l02, g11);
                            } else {
                                o(g11, l02, n10, m10, h10, h11);
                            }
                        } else {
                            this.f6249g.d(l02, t10);
                        }
                    }
                }
            }
            this.f6249g.o(this.J0);
        }
        this.f6265p.m1(this.f6241c);
        z zVar2 = this.f6268q0;
        zVar2.f6396c = zVar2.f6399f;
        this.M = false;
        this.N = false;
        zVar2.f6404k = false;
        zVar2.f6405l = false;
        this.f6265p.f6342h = false;
        ArrayList<d0> arrayList = this.f6241c.f6371b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f6265p;
        if (oVar.f6348n) {
            oVar.f6347m = 0;
            oVar.f6348n = false;
            this.f6241c.P();
        }
        this.f6265p.Z0(this.f6268q0);
        P0();
        F1(false);
        this.f6249g.f();
        int[] iArr = this.f6282z0;
        if (C(iArr[0], iArr[1])) {
            N(0, 0);
        }
        a1();
        m1();
    }

    private boolean P(MotionEvent motionEvent) {
        s sVar = this.f6279y;
        if (sVar != null) {
            sVar.a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f6279y = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return Z(motionEvent);
        }
    }

    private void R0(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f6238a0) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f6238a0 = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f6246e0 = x10;
            this.f6242c0 = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f6248f0 = y10;
            this.f6244d0 = y10;
        }
    }

    private boolean V0() {
        return this.V != null && this.f6265p.M1();
    }

    private void W0() {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.M) {
            this.f6245e.y();
            if (this.N) {
                this.f6265p.T0(this);
            }
        }
        if (V0()) {
            this.f6245e.w();
        } else {
            this.f6245e.j();
        }
        boolean z13 = false;
        if (this.f6272t0 || this.f6273u0) {
            z10 = true;
        } else {
            z10 = false;
        }
        z zVar = this.f6268q0;
        if (!this.D || this.V == null || ((!(z12 = this.M) && !z10 && !this.f6265p.f6342h) || (z12 && !this.f6262n.k()))) {
            z11 = false;
        } else {
            z11 = true;
        }
        zVar.f6404k = z11;
        z zVar2 = this.f6268q0;
        if (zVar2.f6404k && z10 && !this.M && V0()) {
            z13 = true;
        }
        zVar2.f6405l = z13;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Y0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L_0x0021
            r6.R()
            android.widget.EdgeEffect r1 = r6.R
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.e.d(r1, r4, r9)
        L_0x001f:
            r9 = r3
            goto L_0x003c
        L_0x0021:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x003b
            r6.S()
            android.widget.EdgeEffect r1 = r6.T
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.e.d(r1, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0056
            r6.T()
            android.widget.EdgeEffect r9 = r6.S
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.e.d(r9, r1, r7)
            goto L_0x0072
        L_0x0056:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0071
            r6.Q()
            android.widget.EdgeEffect r9 = r6.U
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.e.d(r9, r1, r2)
            goto L_0x0072
        L_0x0071:
            r3 = r9
        L_0x0072:
            if (r3 != 0) goto L_0x007c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.view.n0.j0(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Y0(float, float, float, float):void");
    }

    private boolean Z(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f6277x.size();
        int i10 = 0;
        while (i10 < size) {
            s sVar = this.f6277x.get(i10);
            if (!sVar.c(this, motionEvent) || action == 3) {
                i10++;
            } else {
                this.f6279y = sVar;
                return true;
            }
        }
        return false;
    }

    private void a0(int[] iArr) {
        int g10 = this.f6247f.g();
        if (g10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = a.e.API_PRIORITY_OTHER;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < g10; i12++) {
            d0 l02 = l0(this.f6247f.f(i12));
            if (!l02.S()) {
                int u10 = l02.u();
                if (u10 < i10) {
                    i10 = u10;
                }
                if (u10 > i11) {
                    i11 = u10;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    private void a1() {
        d0 d0Var;
        View findViewById;
        if (this.f6261m0 && this.f6262n != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!R0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f6247f.n(focusedChild)) {
                            return;
                        }
                    } else if (this.f6247f.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                if (this.f6268q0.f6407n == -1 || !this.f6262n.k()) {
                    d0Var = null;
                } else {
                    d0Var = e0(this.f6268q0.f6407n);
                }
                if (d0Var != null && !this.f6247f.n(d0Var.f6302a) && d0Var.f6302a.hasFocusable()) {
                    view = d0Var.f6302a;
                } else if (this.f6247f.g() > 0) {
                    view = c0();
                }
                if (view != null) {
                    int i10 = this.f6268q0.f6408o;
                    if (!(((long) i10) == -1 || (findViewById = view.findViewById(i10)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    static RecyclerView b0(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView b02 = b0(viewGroup.getChildAt(i10));
            if (b02 != null) {
                return b02;
            }
        }
        return null;
    }

    private void b1() {
        boolean z10;
        EdgeEffect edgeEffect = this.R;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.R.isFinished();
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.S;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.S.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.U;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.U.isFinished();
        }
        if (z10) {
            n0.j0(this);
        }
    }

    private View c0() {
        d0 d02;
        z zVar = this.f6268q0;
        int i10 = zVar.f6406m;
        if (i10 == -1) {
            i10 = 0;
        }
        int b10 = zVar.b();
        int i11 = i10;
        while (i11 < b10) {
            d0 d03 = d0(i11);
            if (d03 == null) {
                break;
            } else if (d03.f6302a.hasFocusable()) {
                return d03.f6302a;
            } else {
                i11++;
            }
        }
        int min = Math.min(b10, i10);
        while (true) {
            min--;
            if (min < 0 || (d02 = d0(min)) == null) {
                return null;
            }
            if (d02.f6302a.hasFocusable()) {
                return d02.f6302a;
            }
        }
    }

    private int c1(int i10, float f10) {
        float height = f10 / ((float) getHeight());
        float width = ((float) i10) / ((float) getWidth());
        EdgeEffect edgeEffect = this.R;
        float f11 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.e.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.T;
            if (!(edgeEffect2 == null || androidx.core.widget.e.b(edgeEffect2) == 0.0f)) {
                if (canScrollHorizontally(1)) {
                    this.T.onRelease();
                } else {
                    float d10 = androidx.core.widget.e.d(this.T, width, height);
                    if (androidx.core.widget.e.b(this.T) == 0.0f) {
                        this.T.onRelease();
                    }
                    f11 = d10;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.R.onRelease();
            } else {
                float f12 = -androidx.core.widget.e.d(this.R, -width, 1.0f - height);
                if (androidx.core.widget.e.b(this.R) == 0.0f) {
                    this.R.onRelease();
                }
                f11 = f12;
            }
            invalidate();
        }
        return Math.round(f11 * ((float) getWidth()));
    }

    private int d1(int i10, float f10) {
        float width = f10 / ((float) getWidth());
        float height = ((float) i10) / ((float) getHeight());
        EdgeEffect edgeEffect = this.S;
        float f11 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.e.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.U;
            if (!(edgeEffect2 == null || androidx.core.widget.e.b(edgeEffect2) == 0.0f)) {
                if (canScrollVertically(1)) {
                    this.U.onRelease();
                } else {
                    float d10 = androidx.core.widget.e.d(this.U, height, 1.0f - width);
                    if (androidx.core.widget.e.b(this.U) == 0.0f) {
                        this.U.onRelease();
                    }
                    f11 = d10;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.S.onRelease();
            } else {
                float f12 = -androidx.core.widget.e.d(this.S, -height, width);
                if (androidx.core.widget.e.b(this.S) == 0.0f) {
                    this.S.onRelease();
                }
                f11 = f12;
            }
            invalidate();
        }
        return Math.round(f11 * ((float) getHeight()));
    }

    private void g(d0 d0Var) {
        boolean z10;
        View view = d0Var.f6302a;
        if (view.getParent() == this) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f6241c.O(k0(view));
        if (d0Var.G()) {
            this.f6247f.c(view, -1, view.getLayoutParams(), true);
        } else if (!z10) {
            this.f6247f.b(view, true);
        } else {
            this.f6247f.k(view);
        }
    }

    private androidx.core.view.d0 getScrollingChildHelper() {
        if (this.A0 == null) {
            this.A0 = new androidx.core.view.d0(this);
        }
        return this.A0;
    }

    static d0 l0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f6359a;
    }

    private void l1(@NonNull View view, View view2) {
        View view3;
        boolean z10;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.f6256k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f6361c) {
                Rect rect = pVar.f6360b;
                Rect rect2 = this.f6256k;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f6256k);
            offsetRectIntoDescendantCoords(view, this.f6256k);
        }
        o oVar = this.f6265p;
        Rect rect3 = this.f6256k;
        boolean z11 = !this.D;
        if (view2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        oVar.t1(this, view, rect3, z11, z10);
    }

    private void m1() {
        z zVar = this.f6268q0;
        zVar.f6407n = -1;
        zVar.f6406m = -1;
        zVar.f6408o = -1;
    }

    static void n0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f6360b;
        rect.set((view.getLeft() - rect2.left) - pVar.leftMargin, (view.getTop() - rect2.top) - pVar.topMargin, view.getRight() + rect2.right + pVar.rightMargin, view.getBottom() + rect2.bottom + pVar.bottomMargin);
    }

    private void n1() {
        VelocityTracker velocityTracker = this.f6240b0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        G1(0);
        b1();
    }

    private void o(@NonNull d0 d0Var, @NonNull d0 d0Var2, @NonNull l.c cVar, @NonNull l.c cVar2, boolean z10, boolean z11) {
        d0Var.P(false);
        if (z10) {
            g(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z11) {
                g(d0Var2);
            }
            d0Var.f6309h = d0Var2;
            g(d0Var);
            this.f6241c.O(d0Var);
            d0Var2.P(false);
            d0Var2.f6310i = d0Var;
        }
        if (this.V.b(d0Var, d0Var2, cVar, cVar2)) {
            U0();
        }
    }

    private int o0(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private void o1() {
        View view;
        long j10;
        int i10;
        d0 d0Var = null;
        if (!this.f6261m0 || !hasFocus() || this.f6262n == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        if (view != null) {
            d0Var = Y(view);
        }
        if (d0Var == null) {
            m1();
            return;
        }
        z zVar = this.f6268q0;
        if (this.f6262n.k()) {
            j10 = d0Var.s();
        } else {
            j10 = -1;
        }
        zVar.f6407n = j10;
        z zVar2 = this.f6268q0;
        if (this.M) {
            i10 = -1;
        } else if (d0Var.E()) {
            i10 = d0Var.f6305d;
        } else {
            i10 = d0Var.o();
        }
        zVar2.f6406m = i10;
        this.f6268q0.f6408o = o0(d0Var.f6302a);
    }

    private String p0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private float r0(int i10) {
        double log = Math.log((double) ((((float) Math.abs(i10)) * 0.35f) / (this.f6237a * 0.015f)));
        float f10 = L0;
        return (float) (((double) (this.f6237a * 0.015f)) * Math.exp((((double) f10) / (((double) f10) - 1.0d)) * log));
    }

    private void s() {
        n1();
        setScrollState(0);
    }

    private void s0(long j10, d0 d0Var, d0 d0Var2) {
        int g10 = this.f6247f.g();
        for (int i10 = 0; i10 < g10; i10++) {
            d0 l02 = l0(this.f6247f.f(i10));
            if (l02 != d0Var && i0(l02) == j10) {
                Adapter adapter = this.f6262n;
                if (adapter == null || !adapter.k()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + l02 + " \n View Holder 2:" + d0Var + U());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + l02 + " \n View Holder 2:" + d0Var + U());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb2.append(d0Var2);
        sb2.append(" cannot be found but it is necessary for ");
        sb2.append(d0Var);
        sb2.append(U());
    }

    static void t(@NonNull d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f6303b;
        if (weakReference != null) {
            View view = weakReference.get();
            while (view != null) {
                if (view != d0Var.f6302a) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                    } else {
                        view = null;
                    }
                } else {
                    return;
                }
            }
            d0Var.f6303b = null;
        }
    }

    private void t1(Adapter<?> adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.f6262n;
        if (adapter2 != null) {
            adapter2.F(this.f6239b);
            this.f6262n.y(this);
        }
        if (!z10 || z11) {
            e1();
        }
        this.f6245e.y();
        Adapter adapter3 = this.f6262n;
        this.f6262n = adapter;
        if (adapter != null) {
            adapter.D(this.f6239b);
            adapter.u(this);
        }
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.F0(adapter3, this.f6262n);
        }
        this.f6241c.y(adapter3, this.f6262n, z10);
        this.f6268q0.f6400g = true;
    }

    private boolean u0() {
        int g10 = this.f6247f.g();
        for (int i10 = 0; i10 < g10; i10++) {
            d0 l02 = l0(this.f6247f.f(i10));
            if (l02 != null && !l02.S() && l02.H()) {
                return true;
            }
        }
        return false;
    }

    private boolean v1(@NonNull EdgeEffect edgeEffect, int i10, int i11) {
        if (i10 > 0) {
            return true;
        }
        if (r0(-i10) < androidx.core.widget.e.b(edgeEffect) * ((float) i11)) {
            return true;
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void w0() {
        if (n0.A(this) == 0) {
            n0.E0(this, 8);
        }
    }

    private int x(int i10, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i11) {
        if (i10 > 0 && edgeEffect != null && androidx.core.widget.e.b(edgeEffect) != 0.0f) {
            int round = Math.round((((float) (-i11)) / 4.0f) * androidx.core.widget.e.d(edgeEffect, (((float) (-i10)) * 4.0f) / ((float) i11), 0.5f));
            if (round != i10) {
                edgeEffect.finish();
            }
            return i10 - round;
        } else if (i10 >= 0 || edgeEffect2 == null || androidx.core.widget.e.b(edgeEffect2) == 0.0f) {
            return i10;
        } else {
            float f10 = (float) i11;
            int round2 = Math.round((f10 / 4.0f) * androidx.core.widget.e.d(edgeEffect2, (((float) i10) * 4.0f) / f10, 0.5f));
            if (round2 != i10) {
                edgeEffect2.finish();
            }
            return i10 - round2;
        }
    }

    private void x0() {
        this.f6247f = new f(new e());
    }

    /* access modifiers changed from: package-private */
    public boolean A0() {
        AccessibilityManager accessibilityManager = this.K;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* access modifiers changed from: package-private */
    public void A1(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        boolean z11;
        o oVar = this.f6265p;
        if (oVar != null && !this.G) {
            int i13 = 0;
            if (!oVar.l()) {
                i10 = 0;
            }
            if (!this.f6265p.m()) {
                i11 = 0;
            }
            if (i10 != 0 || i11 != 0) {
                if (i12 == Integer.MIN_VALUE || i12 > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (z10) {
                        if (i10 != 0) {
                            i13 = 1;
                        }
                        if (i11 != 0) {
                            i13 |= 2;
                        }
                        D1(i13, 1);
                    }
                    this.f6263n0.e(i10, i11, i12, interpolator);
                    return;
                }
                scrollBy(i10, i11);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void B(int i10, int i11) {
        setMeasuredDimension(o.o(i10, getPaddingLeft() + getPaddingRight(), n0.D(this)), o.o(i11, getPaddingTop() + getPaddingBottom(), n0.C(this)));
    }

    public boolean B0() {
        return this.O > 0;
    }

    public void B1(int i10) {
        o oVar;
        if (!this.G && (oVar = this.f6265p) != null) {
            oVar.J1(this, this.f6268q0, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void C1() {
        int i10 = this.E + 1;
        this.E = i10;
        if (i10 == 1 && !this.G) {
            this.F = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void D(View view) {
        d0 l02 = l0(view);
        M0(view);
        Adapter adapter = this.f6262n;
        if (!(adapter == null || l02 == null)) {
            adapter.A(l02);
        }
        List<q> list = this.L;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.L.get(size).d(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(int i10) {
        if (this.f6265p != null) {
            setScrollState(2);
            this.f6265p.y1(i10);
            awakenScrollBars();
        }
    }

    public boolean D1(int i10, int i11) {
        return getScrollingChildHelper().p(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void E(View view) {
        d0 l02 = l0(view);
        N0(view);
        Adapter adapter = this.f6262n;
        if (!(adapter == null || l02 == null)) {
            adapter.B(l02);
        }
        List<q> list = this.L;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.L.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E0() {
        int j10 = this.f6247f.j();
        for (int i10 = 0; i10 < j10; i10++) {
            ((p) this.f6247f.i(i10).getLayoutParams()).f6361c = true;
        }
        this.f6241c.s();
    }

    /* access modifiers changed from: package-private */
    public void F0() {
        int j10 = this.f6247f.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 l02 = l0(this.f6247f.i(i10));
            if (l02 != null && !l02.S()) {
                l02.g(6);
            }
        }
        E0();
        this.f6241c.t();
    }

    /* access modifiers changed from: package-private */
    public void F1(boolean z10) {
        if (this.E < 1) {
            this.E = 1;
        }
        if (!z10 && !this.G) {
            this.F = false;
        }
        if (this.E == 1) {
            if (z10 && this.F && !this.G && this.f6265p != null && this.f6262n != null) {
                G();
            }
            if (!this.G) {
                this.F = false;
            }
        }
        this.E--;
    }

    /* access modifiers changed from: package-private */
    public void G() {
        boolean z10;
        if (this.f6262n != null && this.f6265p != null) {
            this.f6268q0.f6403j = false;
            if (!this.G0 || (this.H0 == getWidth() && this.I0 == getHeight())) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.H0 = 0;
            this.I0 = 0;
            this.G0 = false;
            if (this.f6268q0.f6398e == 1) {
                H();
                this.f6265p.A1(this);
                I();
            } else if (this.f6245e.q() || z10 || this.f6265p.p0() != getWidth() || this.f6265p.X() != getHeight()) {
                this.f6265p.A1(this);
                I();
            } else {
                this.f6265p.A1(this);
            }
            J();
        }
    }

    public void G1(int i10) {
        getScrollingChildHelper().r(i10);
    }

    public void H0(int i10) {
        int g10 = this.f6247f.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f6247f.f(i11).offsetLeftAndRight(i10);
        }
    }

    public void H1() {
        setScrollState(0);
        I1();
    }

    public void I0(int i10) {
        int g10 = this.f6247f.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f6247f.f(i11).offsetTopAndBottom(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void J0(int i10, int i11) {
        int j10 = this.f6247f.j();
        for (int i12 = 0; i12 < j10; i12++) {
            d0 l02 = l0(this.f6247f.i(i12));
            if (l02 != null && !l02.S() && l02.f6304c >= i10) {
                l02.J(i11, false);
                this.f6268q0.f6400g = true;
            }
        }
        this.f6241c.v(i10, i11);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void J1(int i10, int i11, Object obj) {
        int i12;
        int j10 = this.f6247f.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < j10; i14++) {
            View i15 = this.f6247f.i(i14);
            d0 l02 = l0(i15);
            if (l02 != null && !l02.S() && (i12 = l02.f6304c) >= i10 && i12 < i13) {
                l02.g(2);
                l02.f(obj);
                ((p) i15.getLayoutParams()).f6361c = true;
            }
        }
        this.f6241c.R(i10, i11);
    }

    public boolean K(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    /* access modifiers changed from: package-private */
    public void K0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int j10 = this.f6247f.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < j10; i16++) {
            d0 l02 = l0(this.f6247f.i(i16));
            if (l02 != null && (i15 = l02.f6304c) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    l02.J(i11 - i10, false);
                } else {
                    l02.J(i14, false);
                }
                this.f6268q0.f6400g = true;
            }
        }
        this.f6241c.w(i10, i11);
        requestLayout();
    }

    public final void L(int i10, int i11, int i12, int i13, int[] iArr, int i14, @NonNull int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    /* access modifiers changed from: package-private */
    public void L0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int j10 = this.f6247f.j();
        for (int i13 = 0; i13 < j10; i13++) {
            d0 l02 = l0(this.f6247f.i(i13));
            if (l02 != null && !l02.S()) {
                int i14 = l02.f6304c;
                if (i14 >= i12) {
                    l02.J(-i11, z10);
                    this.f6268q0.f6400g = true;
                } else if (i14 >= i10) {
                    l02.n(i10 - 1, -i11, z10);
                    this.f6268q0.f6400g = true;
                }
            }
        }
        this.f6241c.x(i10, i11, z10);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void M(int i10) {
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.f1(i10);
        }
        S0(i10);
        t tVar = this.f6269r0;
        if (tVar != null) {
            tVar.a(this, i10);
        }
        List<t> list = this.f6270s0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f6270s0.get(size).a(this, i10);
            }
        }
    }

    public void M0(@NonNull View view) {
    }

    /* access modifiers changed from: package-private */
    public void N(int i10, int i11) {
        this.P++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        T0(i10, i11);
        t tVar = this.f6269r0;
        if (tVar != null) {
            tVar.b(this, i10, i11);
        }
        List<t> list = this.f6270s0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f6270s0.get(size).b(this, i10, i11);
            }
        }
        this.P--;
    }

    public void N0(@NonNull View view) {
    }

    /* access modifiers changed from: package-private */
    public void O() {
        int i10;
        for (int size = this.E0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.E0.get(size);
            if (d0Var.f6302a.getParent() == this && !d0Var.S() && (i10 = d0Var.f6318q) != -1) {
                n0.D0(d0Var.f6302a, i10);
                d0Var.f6318q = -1;
            }
        }
        this.E0.clear();
    }

    /* access modifiers changed from: package-private */
    public void O0() {
        this.O++;
    }

    /* access modifiers changed from: package-private */
    public void P0() {
        Q0(true);
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        if (this.U == null) {
            EdgeEffect a10 = this.Q.a(this, 3);
            this.U = a10;
            if (this.f6251h) {
                a10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a10.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Q0(boolean z10) {
        int i10 = this.O - 1;
        this.O = i10;
        if (i10 < 1) {
            this.O = 0;
            if (z10) {
                F();
                O();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        if (this.R == null) {
            EdgeEffect a10 = this.Q.a(this, 0);
            this.R = a10;
            if (this.f6251h) {
                a10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a10.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        if (this.T == null) {
            EdgeEffect a10 = this.Q.a(this, 2);
            this.T = a10;
            if (this.f6251h) {
                a10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a10.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void S0(int i10) {
    }

    /* access modifiers changed from: package-private */
    public void T() {
        if (this.S == null) {
            EdgeEffect a10 = this.Q.a(this, 1);
            this.S = a10;
            if (this.f6251h) {
                a10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a10.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void T0(int i10, int i11) {
    }

    /* access modifiers changed from: package-private */
    public String U() {
        return " " + super.toString() + ", adapter:" + this.f6262n + ", layout:" + this.f6265p + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public void U0() {
        if (!this.f6276w0 && this.f6281z) {
            n0.k0(this, this.F0);
            this.f6276w0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void V(z zVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f6263n0.f6295c;
            zVar.f6409p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f6410q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        zVar.f6409p = 0;
        zVar.f6410q = 0;
    }

    public View W(float f10, float f11) {
        for (int g10 = this.f6247f.g() - 1; g10 >= 0; g10--) {
            View f12 = this.f6247f.f(g10);
            float translationX = f12.getTranslationX();
            float translationY = f12.getTranslationY();
            if (f10 >= ((float) f12.getLeft()) + translationX && f10 <= ((float) f12.getRight()) + translationX && f11 >= ((float) f12.getTop()) + translationY && f11 <= ((float) f12.getBottom()) + translationY) {
                return f12;
            }
        }
        return null;
    }

    public View X(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void X0(boolean z10) {
        this.N = z10 | this.N;
        this.M = true;
        F0();
    }

    public d0 Y(@NonNull View view) {
        View X = X(view);
        if (X == null) {
            return null;
        }
        return k0(X);
    }

    /* access modifiers changed from: package-private */
    public void Z0(d0 d0Var, l.c cVar) {
        d0Var.O(0, 8192);
        if (this.f6268q0.f6402i && d0Var.H() && !d0Var.E() && !d0Var.S()) {
            this.f6249g.c(i0(d0Var), d0Var);
        }
        this.f6249g.e(d0Var, cVar);
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        o oVar = this.f6265p;
        if (oVar == null || !oVar.G0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i10, int i11) {
        if (i10 < 0) {
            R();
            if (this.R.isFinished()) {
                this.R.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            S();
            if (this.T.isFinished()) {
                this.T.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            T();
            if (this.S.isFinished()) {
                this.S.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            Q();
            if (this.U.isFinished()) {
                this.U.onAbsorb(i11);
            }
        }
        if (i10 != 0 || i11 != 0) {
            n0.j0(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f6265p.n((p) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.l()) {
            return this.f6265p.r(this.f6268q0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.l()) {
            return this.f6265p.s(this.f6268q0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.l()) {
            return this.f6265p.t(this.f6268q0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.m()) {
            return this.f6265p.u(this.f6268q0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.m()) {
            return this.f6265p.v(this.f6268q0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        o oVar = this.f6265p;
        if (oVar != null && oVar.m()) {
            return this.f6265p.w(this.f6268q0);
        }
        return 0;
    }

    public d0 d0(int i10) {
        d0 d0Var = null;
        if (this.M) {
            return null;
        }
        int j10 = this.f6247f.j();
        for (int i11 = 0; i11 < j10; i11++) {
            d0 l02 = l0(this.f6247f.i(i11));
            if (l02 != null && !l02.E() && h0(l02) == i10) {
                if (!this.f6247f.n(l02.f6302a)) {
                    return l02;
                }
                d0Var = l02;
            }
        }
        return d0Var;
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        int i11;
        super.draw(canvas);
        int size = this.f6275w.size();
        boolean z13 = false;
        for (int i12 = 0; i12 < size; i12++) {
            this.f6275w.get(i12).k(canvas, this, this.f6268q0);
        }
        EdgeEffect edgeEffect = this.R;
        boolean z14 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            if (this.f6251h) {
                i11 = getPaddingBottom();
            } else {
                i11 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i11), 0.0f);
            EdgeEffect edgeEffect2 = this.R;
            if (edgeEffect2 == null || !edgeEffect2.draw(canvas)) {
                z10 = false;
            } else {
                z10 = true;
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.S;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f6251h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.S;
            if (edgeEffect4 == null || !edgeEffect4.draw(canvas)) {
                z12 = false;
            } else {
                z12 = true;
            }
            z10 |= z12;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.T;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f6251h) {
                i10 = getPaddingTop();
            } else {
                i10 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) i10, (float) (-width));
            EdgeEffect edgeEffect6 = this.T;
            if (edgeEffect6 == null || !edgeEffect6.draw(canvas)) {
                z11 = false;
            } else {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.U;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f6251h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.U;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z13 = true;
            }
            z10 |= z13;
            canvas.restoreToCount(save4);
        }
        if (z10 || this.V == null || this.f6275w.size() <= 0 || !this.V.p()) {
            z14 = z10;
        }
        if (z14) {
            n0.j0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public d0 e0(long j10) {
        Adapter adapter = this.f6262n;
        d0 d0Var = null;
        if (adapter != null && adapter.k()) {
            int j11 = this.f6247f.j();
            for (int i10 = 0; i10 < j11; i10++) {
                d0 l02 = l0(this.f6247f.i(i10));
                if (l02 != null && !l02.E() && l02.s() == j10) {
                    if (!this.f6247f.n(l02.f6302a)) {
                        return l02;
                    }
                    d0Var = l02;
                }
            }
        }
        return d0Var;
    }

    /* access modifiers changed from: package-private */
    public void e1() {
        l lVar = this.V;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.l1(this.f6241c);
            this.f6265p.m1(this.f6241c);
        }
        this.f6241c.c();
    }

    /* access modifiers changed from: package-private */
    public d0 f0(int i10, boolean z10) {
        int j10 = this.f6247f.j();
        d0 d0Var = null;
        for (int i11 = 0; i11 < j10; i11++) {
            d0 l02 = l0(this.f6247f.i(i11));
            if (l02 != null && !l02.E()) {
                if (z10) {
                    if (l02.f6304c != i10) {
                        continue;
                    }
                } else if (l02.u() != i10) {
                    continue;
                }
                if (!this.f6247f.n(l02.f6302a)) {
                    return l02;
                }
                d0Var = l02;
            }
        }
        return d0Var;
    }

    /* access modifiers changed from: package-private */
    public boolean f1(View view) {
        C1();
        boolean r10 = this.f6247f.r(view);
        if (r10) {
            d0 l02 = l0(view);
            this.f6241c.O(l02);
            this.f6241c.H(l02);
        }
        F1(!r10);
        return r10;
    }

    public View focusSearch(View view, int i10) {
        boolean z10;
        View view2;
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        int i12;
        View R02 = this.f6265p.R0(view, i10);
        if (R02 != null) {
            return R02;
        }
        boolean z14 = true;
        if (this.f6262n == null || this.f6265p == null || B0() || this.G) {
            z10 = false;
        } else {
            z10 = true;
        }
        FocusFinder instance = FocusFinder.getInstance();
        if (!z10 || !(i10 == 2 || i10 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i10);
            if (findNextFocus != null || !z10) {
                view2 = findNextFocus;
            } else {
                z();
                if (X(view) == null) {
                    return null;
                }
                C1();
                view2 = this.f6265p.K0(view, i10, this.f6241c, this.f6268q0);
                F1(false);
            }
        } else {
            if (this.f6265p.m()) {
                if (i10 == 2) {
                    i12 = Opcodes.IXOR;
                } else {
                    i12 = 33;
                }
                if (instance.findNextFocus(this, view, i12) == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (Q0) {
                    i10 = i12;
                }
            } else {
                z11 = false;
            }
            if (!z11 && this.f6265p.l()) {
                if (this.f6265p.a0() == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (i10 == 2) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z12 ^ z13) {
                    i11 = 66;
                } else {
                    i11 = 17;
                }
                if (instance.findNextFocus(this, view, i11) != null) {
                    z14 = false;
                }
                if (Q0) {
                    i10 = i11;
                }
                z11 = z14;
            }
            if (z11) {
                z();
                if (X(view) == null) {
                    return null;
                }
                C1();
                this.f6265p.K0(view, i10, this.f6241c, this.f6268q0);
                F1(false);
            }
            view2 = instance.findNextFocus(this, view, i10);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (C0(view, view2, i10)) {
                return view2;
            }
            return super.focusSearch(view, i10);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        } else {
            l1(view2, (View) null);
            return view;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g0(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r7.f6265p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = r7.G
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r0 = r0.l()
            androidx.recyclerview.widget.RecyclerView$o r2 = r7.f6265p
            boolean r2 = r2.m()
            if (r0 == 0) goto L_0x001f
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.f6253i0
            if (r3 >= r4) goto L_0x0020
        L_0x001f:
            r8 = r1
        L_0x0020:
            if (r2 == 0) goto L_0x002a
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.f6253i0
            if (r3 >= r4) goto L_0x002b
        L_0x002a:
            r9 = r1
        L_0x002b:
            if (r8 != 0) goto L_0x0030
            if (r9 != 0) goto L_0x0030
            return r1
        L_0x0030:
            r3 = 0
            if (r8 == 0) goto L_0x0073
            android.widget.EdgeEffect r4 = r7.R
            if (r4 == 0) goto L_0x0055
            float r4 = androidx.core.widget.e.b(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0055
            android.widget.EdgeEffect r4 = r7.R
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.v1(r4, r5, r6)
            if (r4 == 0) goto L_0x0052
            android.widget.EdgeEffect r8 = r7.R
            r8.onAbsorb(r5)
        L_0x0051:
            r8 = r1
        L_0x0052:
            r4 = r8
            r8 = r1
            goto L_0x0074
        L_0x0055:
            android.widget.EdgeEffect r4 = r7.T
            if (r4 == 0) goto L_0x0073
            float r4 = androidx.core.widget.e.b(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0073
            android.widget.EdgeEffect r4 = r7.T
            int r5 = r7.getWidth()
            boolean r4 = r7.v1(r4, r8, r5)
            if (r4 == 0) goto L_0x0052
            android.widget.EdgeEffect r4 = r7.T
            r4.onAbsorb(r8)
            goto L_0x0051
        L_0x0073:
            r4 = r1
        L_0x0074:
            if (r9 == 0) goto L_0x00b5
            android.widget.EdgeEffect r5 = r7.S
            if (r5 == 0) goto L_0x0097
            float r5 = androidx.core.widget.e.b(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0097
            android.widget.EdgeEffect r3 = r7.S
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.v1(r3, r5, r6)
            if (r3 == 0) goto L_0x0095
            android.widget.EdgeEffect r9 = r7.S
            r9.onAbsorb(r5)
        L_0x0094:
            r9 = r1
        L_0x0095:
            r3 = r1
            goto L_0x00b7
        L_0x0097:
            android.widget.EdgeEffect r5 = r7.U
            if (r5 == 0) goto L_0x00b5
            float r5 = androidx.core.widget.e.b(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00b5
            android.widget.EdgeEffect r3 = r7.U
            int r5 = r7.getHeight()
            boolean r3 = r7.v1(r3, r9, r5)
            if (r3 == 0) goto L_0x0095
            android.widget.EdgeEffect r3 = r7.U
            r3.onAbsorb(r9)
            goto L_0x0094
        L_0x00b5:
            r3 = r9
            r9 = r1
        L_0x00b7:
            if (r4 != 0) goto L_0x00bb
            if (r9 == 0) goto L_0x00d6
        L_0x00bb:
            int r5 = r7.f6255j0
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.f6255j0
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.RecyclerView$c0 r5 = r7.f6263n0
            r5.b(r4, r9)
        L_0x00d6:
            r5 = 1
            if (r8 != 0) goto L_0x00e1
            if (r3 != 0) goto L_0x00e1
            if (r4 != 0) goto L_0x00df
            if (r9 == 0) goto L_0x00e0
        L_0x00df:
            r1 = r5
        L_0x00e0:
            return r1
        L_0x00e1:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x0124
            if (r0 != 0) goto L_0x00f0
            if (r2 == 0) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r6 = r1
            goto L_0x00f1
        L_0x00f0:
            r6 = r5
        L_0x00f1:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView$r r9 = r7.f6252h0
            if (r9 == 0) goto L_0x00ff
            boolean r9 = r9.a(r8, r3)
            if (r9 == 0) goto L_0x00ff
            return r5
        L_0x00ff:
            if (r6 == 0) goto L_0x0124
            if (r2 == 0) goto L_0x0105
            r0 = r0 | 2
        L_0x0105:
            r7.D1(r0, r5)
            int r9 = r7.f6255j0
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.f6255j0
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.RecyclerView$c0 r0 = r7.f6263n0
            r0.b(r8, r9)
            return r5
        L_0x0124:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(int, int):boolean");
    }

    public void g1(@NonNull n nVar) {
        boolean z10;
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.f6275w.remove(nVar);
        if (this.f6275w.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            setWillNotDraw(z10);
        }
        E0();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f6265p;
        if (oVar != null) {
            return oVar.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + U());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f6265p;
        if (oVar != null) {
            return oVar.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + U());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f6262n;
    }

    public int getBaseline() {
        o oVar = this.f6265p;
        if (oVar != null) {
            return oVar.H();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f6280y0;
        if (jVar == null) {
            return super.getChildDrawingOrder(i10, i11);
        }
        return jVar.a(i10, i11);
    }

    public boolean getClipToPadding() {
        return this.f6251h;
    }

    public v getCompatAccessibilityDelegate() {
        return this.f6278x0;
    }

    @NonNull
    public k getEdgeEffectFactory() {
        return this.Q;
    }

    public l getItemAnimator() {
        return this.V;
    }

    public int getItemDecorationCount() {
        return this.f6275w.size();
    }

    public o getLayoutManager() {
        return this.f6265p;
    }

    public int getMaxFlingVelocity() {
        return this.f6255j0;
    }

    public int getMinFlingVelocity() {
        return this.f6253i0;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (P0) {
            return System.nanoTime();
        }
        return 0;
    }

    public r getOnFlingListener() {
        return this.f6252h0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f6261m0;
    }

    @NonNull
    public u getRecycledViewPool() {
        return this.f6241c.i();
    }

    public int getScrollState() {
        return this.W;
    }

    public void h(@NonNull n nVar) {
        i(nVar, -1);
    }

    /* access modifiers changed from: package-private */
    public int h0(d0 d0Var) {
        if (d0Var.y(524) || !d0Var.B()) {
            return -1;
        }
        return this.f6245e.e(d0Var.f6304c);
    }

    public void h1(@NonNull q qVar) {
        List<q> list = this.L;
        if (list != null) {
            list.remove(qVar);
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(@NonNull n nVar, int i10) {
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f6275w.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f6275w.add(nVar);
        } else {
            this.f6275w.add(i10, nVar);
        }
        E0();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public long i0(d0 d0Var) {
        return this.f6262n.k() ? d0Var.s() : (long) d0Var.f6304c;
    }

    public void i1(@NonNull s sVar) {
        this.f6277x.remove(sVar);
        if (this.f6279y == sVar) {
            this.f6279y = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.f6281z;
    }

    public final boolean isLayoutSuppressed() {
        return this.G;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(@NonNull q qVar) {
        if (this.L == null) {
            this.L = new ArrayList();
        }
        this.L.add(qVar);
    }

    public int j0(@NonNull View view) {
        d0 l02 = l0(view);
        if (l02 != null) {
            return l02.u();
        }
        return -1;
    }

    public void j1(@NonNull t tVar) {
        List<t> list = this.f6270s0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void k(@NonNull s sVar) {
        this.f6277x.add(sVar);
    }

    public d0 k0(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return l0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* access modifiers changed from: package-private */
    public void k1() {
        d0 d0Var;
        int g10 = this.f6247f.g();
        for (int i10 = 0; i10 < g10; i10++) {
            View f10 = this.f6247f.f(i10);
            d0 k02 = k0(f10);
            if (!(k02 == null || (d0Var = k02.f6310i) == null)) {
                View view = d0Var.f6302a;
                int left = f10.getLeft();
                int top = f10.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void l(@NonNull t tVar) {
        if (this.f6270s0 == null) {
            this.f6270s0 = new ArrayList();
        }
        this.f6270s0.add(tVar);
    }

    public void m(@NonNull w wVar) {
        boolean z10;
        if (wVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.b(z10, "'listener' arg cannot be null.");
        this.f6271t.add(wVar);
    }

    public void m0(@NonNull View view, @NonNull Rect rect) {
        n0(view, rect);
    }

    /* access modifiers changed from: package-private */
    public void n(@NonNull d0 d0Var, l.c cVar, @NonNull l.c cVar2) {
        d0Var.P(false);
        if (this.V.a(d0Var, cVar, cVar2)) {
            U0();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O = 0;
        boolean z10 = true;
        this.f6281z = true;
        if (!this.D || isLayoutRequested()) {
            z10 = false;
        }
        this.D = z10;
        this.f6241c.z();
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.A(this);
        }
        this.f6276w0 = false;
        if (P0) {
            ThreadLocal<k> threadLocal = k.f6616e;
            k kVar = threadLocal.get();
            this.f6264o0 = kVar;
            if (kVar == null) {
                this.f6264o0 = new k();
                Display v10 = n0.v(this);
                float f10 = 60.0f;
                if (!isInEditMode() && v10 != null) {
                    float refreshRate = v10.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f10 = refreshRate;
                    }
                }
                k kVar2 = this.f6264o0;
                kVar2.f6620c = (long) (1.0E9f / f10);
                threadLocal.set(kVar2);
            }
            this.f6264o0.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        l lVar = this.V;
        if (lVar != null) {
            lVar.k();
        }
        H1();
        this.f6281z = false;
        o oVar = this.f6265p;
        if (oVar != null) {
            oVar.B(this, this.f6241c);
        }
        this.E0.clear();
        removeCallbacks(this.F0);
        this.f6249g.j();
        this.f6241c.A();
        y0.a.b(this);
        if (P0 && (kVar = this.f6264o0) != null) {
            kVar.j(this);
            this.f6264o0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f6275w.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6275w.get(i10).i(canvas, this, this.f6268q0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float f11;
        if (this.f6265p != null && !this.G && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.f6265p.m()) {
                    f11 = -motionEvent.getAxisValue(9);
                } else {
                    f11 = 0.0f;
                }
                if (this.f6265p.l()) {
                    f10 = motionEvent.getAxisValue(10);
                    if (!(f11 == 0.0f && f10 == 0.0f)) {
                        G0((int) (f10 * this.f6257k0), (int) (f11 * this.f6259l0), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f6265p.m()) {
                        f11 = -axisValue;
                    } else if (this.f6265p.l()) {
                        f10 = axisValue;
                        f11 = 0.0f;
                        G0((int) (f10 * this.f6257k0), (int) (f11 * this.f6259l0), motionEvent, 1);
                    }
                }
                f11 = 0.0f;
                f10 = 0.0f;
                G0((int) (f10 * this.f6257k0), (int) (f11 * this.f6259l0), motionEvent, 1);
            }
            f10 = 0.0f;
            G0((int) (f10 * this.f6257k0), (int) (f11 * this.f6259l0), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.G) {
            return false;
        }
        this.f6279y = null;
        if (Z(motionEvent)) {
            s();
            return true;
        }
        o oVar = this.f6265p;
        if (oVar == null) {
            return false;
        }
        boolean l10 = oVar.l();
        boolean m10 = this.f6265p.m();
        if (this.f6240b0 == null) {
            this.f6240b0 = VelocityTracker.obtain();
        }
        this.f6240b0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.H) {
                this.H = false;
            }
            this.f6238a0 = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f6246e0 = x10;
            this.f6242c0 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f6248f0 = y10;
            this.f6244d0 = y10;
            if (E1(motionEvent) || this.W == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                G1(1);
            }
            int[] iArr = this.C0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (m10) {
                l10 |= true;
            }
            D1(l10 ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.f6240b0.clear();
            G1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f6238a0);
            if (findPointerIndex < 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error processing scroll; pointer index for id ");
                sb2.append(this.f6238a0);
                sb2.append(" not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.W != 1) {
                int i10 = x11 - this.f6242c0;
                int i11 = y11 - this.f6244d0;
                if (!l10 || Math.abs(i10) <= this.f6250g0) {
                    z10 = false;
                } else {
                    this.f6246e0 = x11;
                    z10 = true;
                }
                if (m10 && Math.abs(i11) > this.f6250g0) {
                    this.f6248f0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            s();
        } else if (actionMasked == 5) {
            this.f6238a0 = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f6246e0 = x12;
            this.f6242c0 = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f6248f0 = y12;
            this.f6244d0 = y12;
        } else if (actionMasked == 6) {
            R0(motionEvent);
        }
        if (this.W == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        androidx.core.os.m.a("RV OnLayout");
        G();
        androidx.core.os.m.b();
        this.D = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        o oVar = this.f6265p;
        if (oVar == null) {
            B(i10, i11);
            return;
        }
        boolean z10 = false;
        if (oVar.t0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f6265p.a1(this.f6241c, this.f6268q0, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.G0 = z10;
            if (!z10 && this.f6262n != null) {
                if (this.f6268q0.f6398e == 1) {
                    H();
                }
                this.f6265p.B1(i10, i11);
                this.f6268q0.f6403j = true;
                I();
                this.f6265p.E1(i10, i11);
                if (this.f6265p.H1()) {
                    this.f6265p.B1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f6268q0.f6403j = true;
                    I();
                    this.f6265p.E1(i10, i11);
                }
                this.H0 = getMeasuredWidth();
                this.I0 = getMeasuredHeight();
            }
        } else if (this.B) {
            this.f6265p.a1(this.f6241c, this.f6268q0, i10, i11);
        } else {
            if (this.J) {
                C1();
                O0();
                W0();
                P0();
                z zVar = this.f6268q0;
                if (zVar.f6405l) {
                    zVar.f6401h = true;
                } else {
                    this.f6245e.j();
                    this.f6268q0.f6401h = false;
                }
                this.J = false;
                F1(false);
            } else if (this.f6268q0.f6405l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.f6262n;
            if (adapter != null) {
                this.f6268q0.f6399f = adapter.g();
            } else {
                this.f6268q0.f6399f = 0;
            }
            C1();
            this.f6265p.a1(this.f6241c, this.f6268q0, i10, i11);
            F1(false);
            this.f6268q0.f6401h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (B0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f6243d = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f6243d;
        if (savedState2 != null) {
            savedState.c(savedState2);
        } else {
            o oVar = this.f6265p;
            if (oVar != null) {
                savedState.f6290c = oVar.e1();
            } else {
                savedState.f6290c = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12 || i11 != i13) {
            z0();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.G
            r8 = 0
            if (r0 != 0) goto L_0x01e9
            boolean r0 = r6.H
            if (r0 == 0) goto L_0x000f
            goto L_0x01e9
        L_0x000f:
            boolean r0 = r17.P(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.s()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$o r0 = r6.f6265p
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.l()
            androidx.recyclerview.widget.RecyclerView$o r0 = r6.f6265p
            boolean r11 = r0.m()
            android.view.VelocityTracker r0 = r6.f6240b0
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f6240b0 = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.C0
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.C0
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01bd
            if (r0 == r9) goto L_0x017b
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01de
        L_0x0066:
            r17.R0(r18)
            goto L_0x01de
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.f6238a0 = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f6246e0 = r0
            r6.f6242c0 = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f6248f0 = r0
            r6.f6244d0 = r0
            goto L_0x01de
        L_0x0087:
            r17.s()
            goto L_0x01de
        L_0x008c:
            int r0 = r6.f6238a0
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.f6238a0
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            return r8
        L_0x00a9:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.f6246e0
            int r0 = r0 - r13
            int r1 = r6.f6248f0
            int r1 = r1 - r14
            int r2 = r6.W
            if (r2 == r9) goto L_0x00f2
            if (r10 == 0) goto L_0x00d6
            if (r0 <= 0) goto L_0x00cb
            int r2 = r6.f6250g0
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00d2
        L_0x00cb:
            int r2 = r6.f6250g0
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00d2:
            if (r0 == 0) goto L_0x00d6
            r2 = r9
            goto L_0x00d7
        L_0x00d6:
            r2 = r8
        L_0x00d7:
            if (r11 == 0) goto L_0x00ed
            if (r1 <= 0) goto L_0x00e3
            int r3 = r6.f6250g0
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00ea
        L_0x00e3:
            int r3 = r6.f6250g0
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00ea:
            if (r1 == 0) goto L_0x00ed
            r2 = r9
        L_0x00ed:
            if (r2 == 0) goto L_0x00f2
            r6.setScrollState(r9)
        L_0x00f2:
            int r2 = r6.W
            if (r2 != r9) goto L_0x01de
            int[] r2 = r6.D0
            r2[r8] = r8
            r2[r9] = r8
            float r2 = r18.getY()
            int r2 = r6.c1(r0, r2)
            int r15 = r0 - r2
            float r0 = r18.getX()
            int r0 = r6.d1(r1, r0)
            int r16 = r1 - r0
            if (r10 == 0) goto L_0x0114
            r1 = r15
            goto L_0x0115
        L_0x0114:
            r1 = r8
        L_0x0115:
            if (r11 == 0) goto L_0x011a
            r2 = r16
            goto L_0x011b
        L_0x011a:
            r2 = r8
        L_0x011b:
            int[] r3 = r6.D0
            int[] r4 = r6.B0
            r5 = 0
            r0 = r17
            boolean r0 = r0.K(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x014a
            int[] r0 = r6.D0
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.C0
            r1 = r0[r8]
            int[] r2 = r6.B0
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x014a:
            r0 = r16
            int[] r1 = r6.B0
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.f6246e0 = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.f6248f0 = r14
            if (r10 == 0) goto L_0x015c
            r1 = r15
            goto L_0x015d
        L_0x015c:
            r1 = r8
        L_0x015d:
            if (r11 == 0) goto L_0x0161
            r2 = r0
            goto L_0x0162
        L_0x0161:
            r2 = r8
        L_0x0162:
            boolean r1 = r6.q1(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x016f
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x016f:
            androidx.recyclerview.widget.k r1 = r6.f6264o0
            if (r1 == 0) goto L_0x01de
            if (r15 != 0) goto L_0x0177
            if (r0 == 0) goto L_0x01de
        L_0x0177:
            r1.f(r6, r15, r0)
            goto L_0x01de
        L_0x017b:
            android.view.VelocityTracker r0 = r6.f6240b0
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.f6240b0
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.f6255j0
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0197
            android.view.VelocityTracker r1 = r6.f6240b0
            int r2 = r6.f6238a0
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0198
        L_0x0197:
            r1 = r0
        L_0x0198:
            if (r11 == 0) goto L_0x01a4
            android.view.VelocityTracker r2 = r6.f6240b0
            int r3 = r6.f6238a0
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01a5
        L_0x01a4:
            r2 = r0
        L_0x01a5:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01ad
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01b5
        L_0x01ad:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.g0(r0, r1)
            if (r0 != 0) goto L_0x01b8
        L_0x01b5:
            r6.setScrollState(r8)
        L_0x01b8:
            r17.n1()
            r8 = r9
            goto L_0x01de
        L_0x01bd:
            int r0 = r7.getPointerId(r8)
            r6.f6238a0 = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f6246e0 = r0
            r6.f6242c0 = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f6248f0 = r0
            r6.f6244d0 = r0
            if (r11 == 0) goto L_0x01db
            r10 = r10 | 2
        L_0x01db:
            r6.D1(r10, r8)
        L_0x01de:
            if (r8 != 0) goto L_0x01e5
            android.view.VelocityTracker r0 = r6.f6240b0
            r0.addMovement(r12)
        L_0x01e5:
            r12.recycle()
            return r9
        L_0x01e9:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull d0 d0Var, @NonNull l.c cVar, l.c cVar2) {
        g(d0Var);
        d0Var.P(false);
        if (this.V.c(d0Var, cVar, cVar2)) {
            U0();
        }
    }

    /* access modifiers changed from: package-private */
    public void p1() {
        int j10 = this.f6247f.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 l02 = l0(this.f6247f.i(i10));
            if (!l02.S()) {
                l02.N();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
        if (B0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + U());
            }
            throw new IllegalStateException(str);
        } else if (this.P > 0) {
            new IllegalStateException("" + U());
        }
    }

    /* access modifiers changed from: package-private */
    public Rect q0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f6361c) {
            return pVar.f6360b;
        }
        if (this.f6268q0.e() && (pVar.b() || pVar.d())) {
            return pVar.f6360b;
        }
        Rect rect = pVar.f6360b;
        rect.set(0, 0, 0, 0);
        int size = this.f6275w.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6256k.set(0, 0, 0, 0);
            this.f6275w.get(i10).g(this.f6256k, view, this, this.f6268q0);
            int i11 = rect.left;
            Rect rect2 = this.f6256k;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f6361c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public boolean q1(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z10;
        int i17 = i10;
        int i18 = i11;
        MotionEvent motionEvent2 = motionEvent;
        z();
        if (this.f6262n != null) {
            int[] iArr = this.D0;
            iArr[0] = 0;
            iArr[1] = 0;
            r1(i17, i18, iArr);
            int[] iArr2 = this.D0;
            int i19 = iArr2[0];
            int i20 = iArr2[1];
            i16 = i20;
            i15 = i19;
            i14 = i17 - i19;
            i13 = i18 - i20;
        } else {
            i16 = 0;
            i15 = 0;
            i14 = 0;
            i13 = 0;
        }
        if (!this.f6275w.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.D0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        L(i15, i16, i14, i13, this.B0, i12, iArr3);
        int[] iArr4 = this.D0;
        int i21 = iArr4[0];
        int i22 = i14 - i21;
        int i23 = iArr4[1];
        int i24 = i13 - i23;
        if (i21 == 0 && i23 == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i25 = this.f6246e0;
        int[] iArr5 = this.B0;
        int i26 = iArr5[0];
        this.f6246e0 = i25 - i26;
        int i27 = this.f6248f0;
        int i28 = iArr5[1];
        this.f6248f0 = i27 - i28;
        int[] iArr6 = this.C0;
        iArr6[0] = iArr6[0] + i26;
        iArr6[1] = iArr6[1] + i28;
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !androidx.core.view.b0.b(motionEvent2, 8194)) {
                Y0(motionEvent.getX(), (float) i22, motionEvent.getY(), (float) i24);
            }
            v(i10, i11);
        }
        if (!(i15 == 0 && i16 == 0)) {
            N(i15, i16);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z10 && i15 == 0 && i16 == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean r(d0 d0Var) {
        l lVar = this.V;
        if (lVar == null || lVar.g(d0Var, d0Var.x())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r1(int i10, int i11, int[] iArr) {
        int i12;
        int i13;
        C1();
        O0();
        androidx.core.os.m.a("RV Scroll");
        V(this.f6268q0);
        if (i10 != 0) {
            i12 = this.f6265p.x1(i10, this.f6241c, this.f6268q0);
        } else {
            i12 = 0;
        }
        if (i11 != 0) {
            i13 = this.f6265p.z1(i11, this.f6241c, this.f6268q0);
        } else {
            i13 = 0;
        }
        androidx.core.os.m.b();
        k1();
        P0();
        F1(false);
        if (iArr != null) {
            iArr[0] = i12;
            iArr[1] = i13;
        }
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z10) {
        d0 l02 = l0(view);
        if (l02 != null) {
            if (l02.G()) {
                l02.k();
            } else if (!l02.S()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + l02 + U());
            }
        }
        view.clearAnimation();
        E(view);
        super.removeDetachedView(view, z10);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f6265p.c1(this, this.f6268q0, view, view2) && view2 != null) {
            l1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f6265p.s1(this, view, rect, z10);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f6277x.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6277x.get(i10).e(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void requestLayout() {
        if (this.E != 0 || this.G) {
            this.F = true;
        } else {
            super.requestLayout();
        }
    }

    public void s1(int i10) {
        if (!this.G) {
            H1();
            o oVar = this.f6265p;
            if (oVar != null) {
                oVar.y1(i10);
                awakenScrollBars();
            }
        }
    }

    public void scrollBy(int i10, int i11) {
        o oVar = this.f6265p;
        if (oVar != null && !this.G) {
            boolean l10 = oVar.l();
            boolean m10 = this.f6265p.m();
            if (l10 || m10) {
                if (!l10) {
                    i10 = 0;
                }
                if (!m10) {
                    i11 = 0;
                }
                q1(i10, i11, (MotionEvent) null, 0);
            }
        }
    }

    public void scrollTo(int i10, int i11) {
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!w1(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(v vVar) {
        this.f6278x0 = vVar;
        n0.s0(this, vVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        t1(adapter, false, true);
        X0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        boolean z10;
        if (jVar != this.f6280y0) {
            this.f6280y0 = jVar;
            if (jVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            setChildrenDrawingOrderEnabled(z10);
        }
    }

    public void setClipToPadding(boolean z10) {
        if (z10 != this.f6251h) {
            z0();
        }
        this.f6251h = z10;
        super.setClipToPadding(z10);
        if (this.D) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull k kVar) {
        androidx.core.util.h.g(kVar);
        this.Q = kVar;
        z0();
    }

    public void setHasFixedSize(boolean z10) {
        this.B = z10;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.V;
        if (lVar2 != null) {
            lVar2.k();
            this.V.w((l.b) null);
        }
        this.V = lVar;
        if (lVar != null) {
            lVar.w(this.f6274v0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f6241c.L(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(o oVar) {
        if (oVar != this.f6265p) {
            H1();
            if (this.f6265p != null) {
                l lVar = this.V;
                if (lVar != null) {
                    lVar.k();
                }
                this.f6265p.l1(this.f6241c);
                this.f6265p.m1(this.f6241c);
                this.f6241c.c();
                if (this.f6281z) {
                    this.f6265p.B(this, this.f6241c);
                }
                this.f6265p.F1((RecyclerView) null);
                this.f6265p = null;
            } else {
                this.f6241c.c();
            }
            this.f6247f.o();
            this.f6265p = oVar;
            if (oVar != null) {
                if (oVar.f6336b == null) {
                    oVar.F1(this);
                    if (this.f6281z) {
                        this.f6265p.A(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f6336b.U());
                }
            }
            this.f6241c.P();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m(z10);
    }

    public void setOnFlingListener(r rVar) {
        this.f6252h0 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f6269r0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f6261m0 = z10;
    }

    public void setRecycledViewPool(u uVar) {
        this.f6241c.J(uVar);
    }

    @Deprecated
    public void setRecyclerListener(w wVar) {
        this.f6267q = wVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i10) {
        if (i10 != this.W) {
            this.W = i10;
            if (i10 != 2) {
                I1();
            }
            M(i10);
        }
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 != 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setScrollingTouchSlop(): bad argument constant ");
                sb2.append(i10);
                sb2.append("; using default value");
            } else {
                this.f6250g0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f6250g0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f6241c.K(b0Var);
    }

    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    public final void suppressLayout(boolean z10) {
        if (z10 != this.G) {
            q("Do not suppressLayout in layout or scroll");
            if (!z10) {
                this.G = false;
                if (!(!this.F || this.f6265p == null || this.f6262n == null)) {
                    requestLayout();
                }
                this.F = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.G = true;
            this.H = true;
            H1();
        }
    }

    public boolean t0() {
        if (!this.D || this.M || this.f6245e.p()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        int j10 = this.f6247f.j();
        for (int i10 = 0; i10 < j10; i10++) {
            d0 l02 = l0(this.f6247f.i(i10));
            if (!l02.S()) {
                l02.h();
            }
        }
        this.f6241c.d();
    }

    /* access modifiers changed from: package-private */
    public boolean u1(d0 d0Var, int i10) {
        if (B0()) {
            d0Var.f6318q = i10;
            this.E0.add(d0Var);
            return false;
        }
        n0.D0(d0Var.f6302a, i10);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void v(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.R;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.R.onRelease();
            z10 = this.R.isFinished();
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.T.onRelease();
            z10 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.S;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.S.onRelease();
            z10 |= this.S.isFinished();
        }
        EdgeEffect edgeEffect4 = this.U;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.U.onRelease();
            z10 |= this.U.isFinished();
        }
        if (z10) {
            n0.j0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void v0() {
        this.f6245e = new a(new f());
    }

    /* access modifiers changed from: package-private */
    public int w(int i10) {
        return x(i10, this.R, this.T, getWidth());
    }

    /* access modifiers changed from: package-private */
    public boolean w1(AccessibilityEvent accessibilityEvent) {
        int i10;
        int i11 = 0;
        if (!B0()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i10 = androidx.core.view.accessibility.b.a(accessibilityEvent);
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            i11 = i10;
        }
        this.I |= i11;
        return true;
    }

    public void x1(int i10, int i11) {
        y1(i10, i11, (Interpolator) null);
    }

    /* access modifiers changed from: package-private */
    public int y(int i10) {
        return x(i10, this.S, this.U, getHeight());
    }

    /* access modifiers changed from: package-private */
    public void y0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + U());
        }
        Resources resources = getContext().getResources();
        new j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(o1.b.fastscroll_default_thickness), resources.getDimensionPixelSize(o1.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(o1.b.fastscroll_margin));
    }

    public void y1(int i10, int i11, Interpolator interpolator) {
        z1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (!this.D || this.M) {
            androidx.core.os.m.a("RV FullInvalidate");
            G();
            androidx.core.os.m.b();
        } else if (this.f6245e.p()) {
            if (this.f6245e.o(4) && !this.f6245e.o(11)) {
                androidx.core.os.m.a("RV PartialInvalidate");
                C1();
                O0();
                this.f6245e.w();
                if (!this.F) {
                    if (u0()) {
                        G();
                    } else {
                        this.f6245e.i();
                    }
                }
                F1(true);
                P0();
                androidx.core.os.m.b();
            } else if (this.f6245e.p()) {
                androidx.core.os.m.a("RV FullInvalidate");
                G();
                androidx.core.os.m.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z0() {
        this.U = null;
        this.S = null;
        this.T = null;
        this.R = null;
    }

    public void z1(int i10, int i11, Interpolator interpolator, int i12) {
        A1(i10, i11, interpolator, i12, false);
    }

    public RecyclerView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, o1.a.recyclerViewStyle);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f6290c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6290c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void c(SavedState savedState) {
            this.f6290c = savedState.f6290c;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f6290c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int i11 = i10;
        this.f6239b = new x();
        this.f6241c = new v();
        this.f6249g = new a0();
        this.f6254j = new a();
        this.f6256k = new Rect();
        this.f6258l = new Rect();
        this.f6260m = new RectF();
        this.f6271t = new ArrayList();
        this.f6275w = new ArrayList<>();
        this.f6277x = new ArrayList<>();
        this.E = 0;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = U0;
        this.V = new g();
        this.W = 0;
        this.f6238a0 = -1;
        this.f6257k0 = Float.MIN_VALUE;
        this.f6259l0 = Float.MIN_VALUE;
        this.f6261m0 = true;
        this.f6263n0 = new c0();
        this.f6266p0 = P0 ? new k.b() : null;
        this.f6268q0 = new z();
        this.f6272t0 = false;
        this.f6273u0 = false;
        this.f6274v0 = new m();
        this.f6276w0 = false;
        this.f6282z0 = new int[2];
        this.B0 = new int[2];
        this.C0 = new int[2];
        this.D0 = new int[2];
        this.E0 = new ArrayList();
        this.F0 = new b();
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6250g0 = viewConfiguration.getScaledTouchSlop();
        this.f6257k0 = y1.b(viewConfiguration, context2);
        this.f6259l0 = y1.d(viewConfiguration, context2);
        this.f6253i0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6255j0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6237a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.V.w(this.f6274v0);
        v0();
        x0();
        w0();
        if (n0.z(this) == 0) {
            n0.D0(this, 1);
        }
        this.K = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new v(this));
        int[] iArr = o1.d.RecyclerView;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, iArr, i11, 0);
        n0.q0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        String string = obtainStyledAttributes.getString(o1.d.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(o1.d.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(Opcodes.ASM4);
        }
        this.f6251h = obtainStyledAttributes.getBoolean(o1.d.RecyclerView_android_clipToPadding, true);
        boolean z10 = obtainStyledAttributes.getBoolean(o1.d.RecyclerView_fastScrollEnabled, false);
        this.C = z10;
        if (z10) {
            y0((StateListDrawable) obtainStyledAttributes.getDrawable(o1.d.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(o1.d.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(o1.d.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(o1.d.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        A(context, string, attributeSet, i10, 0);
        int[] iArr2 = K0;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, iArr2, i11, 0);
        n0.q0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i10, 0);
        boolean z11 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z11);
        y0.a.d(this, true);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        d0 f6359a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f6360b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f6361c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f6362d = false;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f6359a.u();
        }

        public boolean b() {
            return this.f6359a.H();
        }

        public boolean c() {
            return this.f6359a.E();
        }

        public boolean d() {
            return this.f6359a.C();
        }

        public p(int i10, int i11) {
            super(i10, i11);
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public p(p pVar) {
            super(pVar);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f6265p;
        if (oVar != null) {
            return oVar.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + U());
    }
}
