package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.n;
import androidx.core.view.c0;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.k;
import bf.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tf.h;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    private static final int F = k.Widget_Design_AppBarLayout;
    private int[] B;
    private Drawable C;
    private final float D;
    private Behavior E;

    /* renamed from: a  reason: collision with root package name */
    private int f19010a;

    /* renamed from: b  reason: collision with root package name */
    private int f19011b;

    /* renamed from: c  reason: collision with root package name */
    private int f19012c;

    /* renamed from: d  reason: collision with root package name */
    private int f19013d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19014e;

    /* renamed from: f  reason: collision with root package name */
    private int f19015f;

    /* renamed from: g  reason: collision with root package name */
    private k2 f19016g;

    /* renamed from: h  reason: collision with root package name */
    private List<b> f19017h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19018j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19019k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19020l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19021m;

    /* renamed from: n  reason: collision with root package name */
    private int f19022n;

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<View> f19023p;

    /* renamed from: q  reason: collision with root package name */
    private final ColorStateList f19024q;

    /* renamed from: t  reason: collision with root package name */
    private ValueAnimator f19025t;

    /* renamed from: w  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f19026w;

    /* renamed from: x  reason: collision with root package name */
    private final List<f> f19027x;

    /* renamed from: y  reason: collision with root package name */
    private final long f19028y;

    /* renamed from: z  reason: collision with root package name */
    private final TimeInterpolator f19029z;

    protected static class BaseBehavior<T extends AppBarLayout> extends e<T> {
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f19030k;

        /* renamed from: l  reason: collision with root package name */
        private int f19031l;

        /* renamed from: m  reason: collision with root package name */
        private ValueAnimator f19032m;

        /* renamed from: n  reason: collision with root package name */
        private SavedState f19033n;

        /* renamed from: o  reason: collision with root package name */
        private WeakReference<View> f19034o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public boolean f19035p;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f19041a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f19042b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f19041a = coordinatorLayout;
                this.f19042b = appBarLayout;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f19041a, this.f19042b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends androidx.core.view.a {
            b() {
            }

            public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
                super.g(view, kVar);
                kVar.u0(BaseBehavior.this.f19035p);
                kVar.a0(ScrollView.class.getName());
            }
        }

        class c implements n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f19045a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f19046b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f19047c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f19048d;

            c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
                this.f19045a = coordinatorLayout;
                this.f19046b = appBarLayout;
                this.f19047c = view;
                this.f19048d = i10;
            }

            public boolean a(@NonNull View view, n.a aVar) {
                BaseBehavior.this.q(this.f19045a, this.f19046b, this.f19047c, 0, this.f19048d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class d implements n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f19050a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f19051b;

            d(AppBarLayout appBarLayout, boolean z10) {
                this.f19050a = appBarLayout;
                this.f19051b = z10;
            }

            public boolean a(@NonNull View view, n.a aVar) {
                this.f19050a.setExpanded(this.f19051b);
                return true;
            }
        }

        public BaseBehavior() {
        }

        private boolean A0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            List<View> s10 = coordinatorLayout.s(t10);
            int size = s10.size();
            int i10 = 0;
            while (i10 < size) {
                CoordinatorLayout.c f10 = ((CoordinatorLayout.f) s10.get(i10).getLayoutParams()).f();
                if (!(f10 instanceof ScrollingViewBehavior)) {
                    i10++;
                } else if (((ScrollingViewBehavior) f10).K() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void B0(CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            int topInset = t10.getTopInset() + t10.getPaddingTop();
            int M = M() - topInset;
            int h02 = h0(t10, M);
            if (h02 >= 0) {
                View childAt = t10.getChildAt(h02);
                e eVar = (e) childAt.getLayoutParams();
                int c10 = eVar.c();
                if ((c10 & 17) == 17) {
                    int i10 = -childAt.getTop();
                    int i11 = -childAt.getBottom();
                    if (h02 == 0 && n0.y(t10) && n0.y(childAt)) {
                        i10 -= t10.getTopInset();
                    }
                    if (c0(c10, 2)) {
                        i11 += n0.C(childAt);
                    } else if (c0(c10, 5)) {
                        int C = n0.C(childAt) + i11;
                        if (M < C) {
                            i10 = C;
                        } else {
                            i11 = C;
                        }
                    }
                    if (c0(c10, 32)) {
                        i10 += eVar.topMargin;
                        i11 -= eVar.bottomMargin;
                    }
                    X(coordinatorLayout, t10, v0.a.b(Z(M, i11, i10) + topInset, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void C0(CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            View i02;
            n0.m0(coordinatorLayout, k.a.f4771q.b());
            n0.m0(coordinatorLayout, k.a.f4772r.b());
            if (t10.getTotalScrollRange() != 0 && (i02 = i0(coordinatorLayout)) != null && d0(t10)) {
                if (!n0.Q(coordinatorLayout)) {
                    n0.s0(coordinatorLayout, new b());
                }
                this.f19035p = V(coordinatorLayout, t10, i02);
            }
        }

        private void D0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, boolean z10) {
            View g02 = g0(t10, i10);
            boolean z11 = false;
            if (g02 != null) {
                int c10 = ((e) g02.getLayoutParams()).c();
                if ((c10 & 1) != 0) {
                    int C = n0.C(g02);
                    if (i11 <= 0 || (c10 & 12) == 0 ? !((c10 & 2) == 0 || (-i10) < (g02.getBottom() - C) - t10.getTopInset()) : (-i10) >= (g02.getBottom() - C) - t10.getTopInset()) {
                        z11 = true;
                    }
                }
            }
            if (t10.p()) {
                z11 = t10.D(f0(coordinatorLayout));
            }
            boolean A = t10.A(z11);
            if (z10 || (A && A0(coordinatorLayout, t10))) {
                t10.jumpDrawablesToCurrentState();
            }
        }

        private boolean V(CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull View view) {
            boolean z10 = false;
            if (M() != (-t10.getTotalScrollRange())) {
                W(coordinatorLayout, t10, k.a.f4771q, false);
                z10 = true;
            }
            if (M() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i10 = -t10.getDownNestedPreScrollRange();
                    if (i10 != 0) {
                        n0.o0(coordinatorLayout, k.a.f4772r, (CharSequence) null, new c(coordinatorLayout, t10, view, i10));
                        return true;
                    }
                } else {
                    W(coordinatorLayout, t10, k.a.f4772r, true);
                    return true;
                }
            }
            return z10;
        }

        private void W(CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull k.a aVar, boolean z10) {
            n0.o0(coordinatorLayout, aVar, (CharSequence) null, new d(t10, z10));
        }

        private void X(CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, float f10) {
            int i11;
            int abs = Math.abs(M() - i10);
            float abs2 = Math.abs(f10);
            if (abs2 > 0.0f) {
                i11 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i11 = (int) (((((float) abs) / ((float) t10.getHeight())) + 1.0f) * 150.0f);
            }
            Y(coordinatorLayout, t10, i10, i11);
        }

        private void Y(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int M = M();
            if (M == i10) {
                ValueAnimator valueAnimator = this.f19032m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f19032m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f19032m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f19032m = valueAnimator3;
                valueAnimator3.setInterpolator(cf.a.f18981e);
                this.f19032m.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f19032m.setDuration((long) Math.min(i11, 600));
            this.f19032m.setIntValues(new int[]{M, i10});
            this.f19032m.start();
        }

        private int Z(int i10, int i11, int i12) {
            return i10 < (i11 + i12) / 2 ? i11 : i12;
        }

        private boolean b0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull View view) {
            if (!t10.l() || coordinatorLayout.getHeight() - view.getHeight() > t10.getHeight()) {
                return false;
            }
            return true;
        }

        private static boolean c0(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        private boolean d0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((e) appBarLayout.getChildAt(i10).getLayoutParams()).f19056a != 0) {
                    return true;
                }
            }
            return false;
        }

        private void e0(KeyEvent keyEvent, View view, AppBarLayout appBarLayout) {
            if (keyEvent.getAction() == 0 || keyEvent.getAction() == 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19 || keyCode == 280 || keyCode == 92) {
                    if (((double) view.getScrollY()) < ((double) view.getMeasuredHeight()) * 0.1d) {
                        appBarLayout.setExpanded(true);
                    }
                } else if ((keyCode == 20 || keyCode == 281 || keyCode == 93) && view.getScrollY() > 0) {
                    appBarLayout.setExpanded(false);
                }
            }
        }

        private View f0(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof c0) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View g0(@NonNull AppBarLayout appBarLayout, int i10) {
            int abs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int h0(@NonNull T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (c0(eVar.c(), 32)) {
                    top -= eVar.topMargin;
                    bottom += eVar.bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        private View i0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int l0(@NonNull T t10, int i10) {
            int abs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i12);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator d10 = eVar.d();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i12++;
                } else if (d10 != null) {
                    int c10 = eVar.c();
                    if ((c10 & 1) != 0) {
                        i11 = 0 + childAt.getHeight() + eVar.topMargin + eVar.bottomMargin;
                        if ((c10 & 2) != 0) {
                            i11 -= n0.C(childAt);
                        }
                    }
                    if (n0.y(childAt)) {
                        i11 -= t10.getTopInset();
                    }
                    if (i11 > 0) {
                        float f10 = (float) i11;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * d10.getInterpolation(((float) (abs - childAt.getTop())) / f10)));
                    }
                }
            }
            return i10;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean m0(View view, AppBarLayout appBarLayout, View view2, KeyEvent keyEvent) {
            e0(keyEvent, view, appBarLayout);
            return false;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean n0(View view, AppBarLayout appBarLayout, View view2, int i10, KeyEvent keyEvent) {
            e0(keyEvent, view, appBarLayout);
            return false;
        }

        /* access modifiers changed from: package-private */
        public int M() {
            return E() + this.f19030k;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a0 */
        public boolean H(T t10) {
            WeakReference<View> weakReference = this.f19034o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j0 */
        public int K(@NonNull T t10) {
            return -t10.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k0 */
        public int L(@NonNull T t10) {
            return t10.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o0 */
        public void N(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            B0(coordinatorLayout, t10);
            if (t10.p()) {
                t10.A(t10.D(f0(coordinatorLayout)));
            }
        }

        /* renamed from: p0 */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10) {
            boolean z10;
            int i11;
            boolean l10 = super.l(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            SavedState savedState = this.f19033n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    if ((pendingAction & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if ((pendingAction & 2) != 0) {
                        int i12 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            X(coordinatorLayout, t10, i12, 0.0f);
                        } else {
                            P(coordinatorLayout, t10, i12);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            X(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (savedState.f19036c) {
                P(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (savedState.f19037d) {
                P(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(savedState.f19038e);
                int i13 = -childAt.getBottom();
                if (this.f19033n.f19040g) {
                    i11 = n0.C(childAt) + t10.getTopInset();
                } else {
                    i11 = Math.round(((float) childAt.getHeight()) * this.f19033n.f19039f);
                }
                P(coordinatorLayout, t10, i13 + i11);
            }
            t10.w();
            this.f19033n = null;
            G(v0.a.b(E(), -t10.getTotalScrollRange(), 0));
            D0(coordinatorLayout, t10, E(), 0, true);
            t10.s(E());
            C0(coordinatorLayout, t10);
            View f02 = f0(coordinatorLayout);
            if (f02 != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    f02.addOnUnhandledKeyEventListener(new c(this, f02, t10));
                } else {
                    f02.setOnKeyListener(new d(this, f02, t10));
                }
            }
            return l10;
        }

        /* renamed from: q0 */
        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, int i12, int i13) {
            if (((CoordinatorLayout.f) t10.getLayoutParams()).height != -2) {
                return super.m(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.J(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        /* renamed from: r0 */
        public void q(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int i14;
            if (i11 != 0) {
                if (i11 < 0) {
                    i14 = -t10.getTotalScrollRange();
                    i13 = t10.getDownNestedPreScrollRange() + i14;
                } else {
                    i14 = -t10.getUpNestedPreScrollRange();
                    i13 = 0;
                }
                int i15 = i14;
                int i16 = i13;
                if (i15 != i16) {
                    iArr[1] = O(coordinatorLayout, t10, i11, i15, i16);
                }
            }
            if (t10.p()) {
                t10.A(t10.D(view));
            }
        }

        /* renamed from: s0 */
        public void t(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = O(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                C0(coordinatorLayout, t10);
            }
        }

        /* renamed from: t0 */
        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                x0((SavedState) parcelable, true);
                super.x(coordinatorLayout, t10, this.f19033n.a());
                return;
            }
            super.x(coordinatorLayout, t10, parcelable);
            this.f19033n = null;
        }

        /* renamed from: u0 */
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10) {
            Parcelable y10 = super.y(coordinatorLayout, t10);
            SavedState y02 = y0(y10, t10);
            if (y02 == null) {
                return y10;
            }
            return y02;
        }

        /* renamed from: v0 */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, @NonNull View view, View view2, int i10, int i11) {
            boolean z10;
            ValueAnimator valueAnimator;
            if ((i10 & 2) == 0 || (!t10.p() && !b0(coordinatorLayout, t10, view))) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && (valueAnimator = this.f19032m) != null) {
                valueAnimator.cancel();
            }
            this.f19034o = null;
            this.f19031l = i11;
            return z10;
        }

        /* renamed from: w0 */
        public void C(CoordinatorLayout coordinatorLayout, @NonNull T t10, View view, int i10) {
            if (this.f19031l == 0 || i10 == 1) {
                B0(coordinatorLayout, t10);
                if (t10.p()) {
                    t10.A(t10.D(view));
                }
            }
            this.f19034o = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        public void x0(SavedState savedState, boolean z10) {
            if (this.f19033n == null || z10) {
                this.f19033n = savedState;
            }
        }

        /* access modifiers changed from: package-private */
        public SavedState y0(Parcelable parcelable, @NonNull T t10) {
            boolean z10;
            boolean z11;
            int E = E();
            int childCount = t10.getChildCount();
            boolean z12 = false;
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E > 0 || bottom < 0) {
                    i10++;
                } else {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f4962b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (E == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    savedState.f19037d = z10;
                    if (z10 || (-E) < t10.getTotalScrollRange()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    savedState.f19036c = z11;
                    savedState.f19038e = i10;
                    if (bottom == n0.C(childAt) + t10.getTopInset()) {
                        z12 = true;
                    }
                    savedState.f19040g = z12;
                    savedState.f19039f = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z0 */
        public int Q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t10, int i10, int i11, int i12) {
            int i13;
            int M = M();
            int i14 = 0;
            if (i11 == 0 || M < i11 || M > i12) {
                this.f19030k = 0;
            } else {
                int b10 = v0.a.b(i10, i11, i12);
                if (M != b10) {
                    if (t10.j()) {
                        i13 = l0(t10, b10);
                    } else {
                        i13 = b10;
                    }
                    boolean G = G(i13);
                    int i15 = M - b10;
                    this.f19030k = b10 - i13;
                    int i16 = 1;
                    if (G) {
                        while (i14 < t10.getChildCount()) {
                            e eVar = (e) t10.getChildAt(i14).getLayoutParams();
                            c b11 = eVar.b();
                            if (!(b11 == null || (eVar.c() & 1) == 0)) {
                                b11.a(t10, t10.getChildAt(i14), (float) E());
                            }
                            i14++;
                        }
                    }
                    if (!G && t10.j()) {
                        coordinatorLayout.f(t10);
                    }
                    t10.s(E());
                    if (b10 < M) {
                        i16 = -1;
                    }
                    D0(coordinatorLayout, t10, b10, i16, false);
                    i14 = i15;
                }
            }
            C0(coordinatorLayout, t10);
            return i14;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            boolean f19036c;

            /* renamed from: d  reason: collision with root package name */
            boolean f19037d;

            /* renamed from: e  reason: collision with root package name */
            int f19038e;

            /* renamed from: f  reason: collision with root package name */
            float f19039f;

            /* renamed from: g  reason: collision with root package name */
            boolean f19040g;

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
                boolean z10 = true;
                this.f19036c = parcel.readByte() != 0;
                this.f19037d = parcel.readByte() != 0;
                this.f19038e = parcel.readInt();
                this.f19039f = parcel.readFloat();
                this.f19040g = parcel.readByte() == 0 ? false : z10;
            }

            public void writeToParcel(@NonNull Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f19036c ? (byte) 1 : 0);
                parcel.writeByte(this.f19037d ? (byte) 1 : 0);
                parcel.writeInt(this.f19038e);
                parcel.writeFloat(this.f19039f);
                parcel.writeByte(this.f19040g ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        public /* bridge */ /* synthetic */ boolean G(int i10) {
            return super.G(i10);
        }

        public /* bridge */ /* synthetic */ boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ boolean p0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i10) {
            return super.l(coordinatorLayout, appBarLayout, i10);
        }

        public /* bridge */ /* synthetic */ boolean q0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.m(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        public /* bridge */ /* synthetic */ void r0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.q(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        public /* bridge */ /* synthetic */ void s0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        public /* bridge */ /* synthetic */ void t0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable u0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean v0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i10, int i11) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        public /* bridge */ /* synthetic */ void w0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i10) {
            super.C(coordinatorLayout, appBarLayout, view, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends f {
        public ScrollingViewBehavior() {
        }

        private static int R(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                return ((BaseBehavior) f10).M();
            }
            return 0;
        }

        private void S(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                n0.d0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f10).f19030k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.p()) {
                    appBarLayout.A(appBarLayout.D(view));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float J(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) R) / ((float) i10)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        public int L(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.L(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Q */
        public AppBarLayout H(@NonNull List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                n0.m0(coordinatorLayout, k.a.f4771q.b());
                n0.m0(coordinatorLayout, k.a.f4772r.b());
                n0.s0(coordinatorLayout, (androidx.core.view.a) null);
            }
        }

        public /* bridge */ /* synthetic */ boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
            return super.l(coordinatorLayout, view, i10);
        }

        public /* bridge */ /* synthetic */ boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10, int i11, int i12, int i13) {
            return super.m(coordinatorLayout, view, i10, i11, i12, i13);
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z10) {
            AppBarLayout Q = H(coordinatorLayout.r(view));
            if (Q != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f19111d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    Q.x(false, !z10);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrollingViewBehavior_Layout);
            O(obtainStyledAttributes.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
    }

    class a implements h0 {
        a() {
        }

        public k2 a(View view, k2 k2Var) {
            return AppBarLayout.this.t(k2Var);
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    public static abstract class c {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f10);
    }

    public static class d extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f19054a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f19055b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f10) {
            b(this.f19054a, appBarLayout, view);
            float abs = ((float) this.f19054a.top) - Math.abs(f10);
            if (abs <= 0.0f) {
                float a10 = 1.0f - v0.a.a(Math.abs(abs / ((float) this.f19054a.height())), 0.0f, 1.0f);
                float height = (-abs) - ((((float) this.f19054a.height()) * 0.3f) * (1.0f - (a10 * a10)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f19055b);
                this.f19055b.offset(0, (int) (-height));
                n0.z0(view, this.f19055b);
                return;
            }
            n0.z0(view, (Rect) null);
            view.setTranslationY(0.0f);
        }
    }

    public interface f {
        void a(float f10, int i10);
    }

    public interface g extends b<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.appBarLayoutStyle);
    }

    private boolean C() {
        return this.C != null && getTopInset() > 0;
    }

    private boolean E() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || n0.y(childAt)) {
            return false;
        }
        return true;
    }

    private void F(float f10, float f11) {
        ValueAnimator valueAnimator = this.f19025t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f10, f11});
        this.f19025t = ofFloat;
        ofFloat.setDuration(this.f19028y);
        this.f19025t.setInterpolator(this.f19029z);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f19026w;
        if (animatorUpdateListener != null) {
            this.f19025t.addUpdateListener(animatorUpdateListener);
        }
        this.f19025t.start();
    }

    private void G() {
        setWillNotDraw(!C());
    }

    private void e() {
        WeakReference<View> weakReference = this.f19023p;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f19023p = null;
    }

    private View f(View view) {
        int i10;
        View view2;
        if (this.f19023p == null && (i10 = this.f19022n) != -1) {
            if (view != null) {
                view2 = view.findViewById(i10);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f19022n);
            }
            if (view2 != null) {
                this.f19023p = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.f19023p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean k() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((e) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void m(tf.g gVar) {
        int i10;
        if (this.f19020l) {
            i10 = 255;
        } else {
            i10 = 0;
        }
        gVar.setAlpha(i10);
        gVar.b0(this.f19024q);
        this.f19026w = new a(this, gVar);
    }

    private void n(Context context, tf.g gVar) {
        gVar.Q(context);
        this.f19026w = new b(this, gVar);
    }

    private void o() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.E;
        if (behavior == null || this.f19011b == -1 || this.f19015f != 0) {
            savedState = null;
        } else {
            savedState = behavior.y0(AbsSavedState.f4962b, this);
        }
        this.f19011b = -1;
        this.f19012c = -1;
        this.f19013d = -1;
        if (savedState != null) {
            this.E.x0(savedState, false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(tf.g gVar, ValueAnimator valueAnimator) {
        int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        gVar.setAlpha(floatValue);
        for (f next : this.f19027x) {
            if (gVar.x() != null) {
                next.a(0.0f, gVar.x().withAlpha(floatValue).getDefaultColor());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(tf.g gVar, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        gVar.a0(floatValue);
        Drawable drawable = this.C;
        if (drawable instanceof tf.g) {
            ((tf.g) drawable).a0(floatValue);
        }
        for (f a10 : this.f19027x) {
            a10.a(floatValue, gVar.A());
        }
    }

    private void y(boolean z10, boolean z11, boolean z12) {
        int i10;
        int i11;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        int i12 = 0;
        if (z11) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        int i13 = i10 | i11;
        if (z12) {
            i12 = 8;
        }
        this.f19015f = i13 | i12;
        requestLayout();
    }

    private boolean z(boolean z10) {
        if (this.f19019k == z10) {
            return false;
        }
        this.f19019k = z10;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean A(boolean z10) {
        return B(z10, !this.f19018j);
    }

    /* access modifiers changed from: package-private */
    public boolean B(boolean z10, boolean z11) {
        float f10;
        float f11;
        if (!z11 || this.f19020l == z10) {
            return false;
        }
        this.f19020l = z10;
        refreshDrawableState();
        if (!this.f19021m || !(getBackground() instanceof tf.g)) {
            return true;
        }
        float f12 = 0.0f;
        if (this.f19024q != null) {
            if (z10) {
                f11 = 0.0f;
            } else {
                f11 = 255.0f;
            }
            if (z10) {
                f12 = 255.0f;
            }
            F(f11, f12);
            return true;
        }
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = this.D;
        }
        if (z10) {
            f12 = this.D;
        }
        F(f10, f12);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean D(View view) {
        View f10 = f(view);
        if (f10 != null) {
            view = f10;
        }
        if (view == null || (!view.canScrollVertically(-1) && view.getScrollY() <= 0)) {
            return false;
        }
        return true;
    }

    public void c(b bVar) {
        if (this.f19017h == null) {
            this.f19017h = new ArrayList();
        }
        if (bVar != null && !this.f19017h.contains(bVar)) {
            this.f19017h.add(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void d(g gVar) {
        c(gVar);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (C()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f19010a));
            this.C.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @NonNull
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.E = behavior;
        return behavior;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i10;
        int C2;
        int i11 = this.f19012c;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f19056a;
                if ((i13 & 5) == 5) {
                    int i14 = eVar.topMargin + eVar.bottomMargin;
                    if ((i13 & 8) != 0) {
                        C2 = n0.C(childAt);
                    } else if ((i13 & 2) != 0) {
                        C2 = measuredHeight - n0.C(childAt);
                    } else {
                        i10 = i14 + measuredHeight;
                        if (childCount == 0 && n0.y(childAt)) {
                            i10 = Math.min(i10, measuredHeight - getTopInset());
                        }
                        i12 += i10;
                    }
                    i10 = i14 + C2;
                    i10 = Math.min(i10, measuredHeight - getTopInset());
                    i12 += i10;
                } else if (i12 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, i12);
        this.f19012c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i10 = this.f19013d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin;
                int i13 = eVar.f19056a;
                if ((i13 & 1) == 0) {
                    break;
                }
                i12 += measuredHeight;
                if ((i13 & 2) != 0) {
                    i12 -= n0.C(childAt);
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f19013d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f19022n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int C2 = n0.C(this);
        if (C2 == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                C2 = n0.C(getChildAt(childCount - 1));
            } else {
                C2 = 0;
            }
            if (C2 == 0) {
                return getHeight() / 3;
            }
        }
        return (C2 * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f19015f;
    }

    public Drawable getStatusBarForeground() {
        return this.C;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        k2 k2Var = this.f19016g;
        if (k2Var != null) {
            return k2Var.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f19011b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f19056a;
                if ((i13 & 1) == 0) {
                    break;
                }
                i12 += measuredHeight + eVar.topMargin + eVar.bottomMargin;
                if (i11 == 0 && n0.y(childAt)) {
                    i12 -= getTopInset();
                }
                if ((i13 & 2) != 0) {
                    i12 -= n0.C(childAt);
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f19011b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* renamed from: h */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new e((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f19014e;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int i11;
        int i12;
        if (this.B == null) {
            this.B = new int[4];
        }
        int[] iArr = this.B;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f19019k;
        int i13 = bf.b.state_liftable;
        if (!z10) {
            i13 = -i13;
        }
        iArr[0] = i13;
        if (!z10 || !this.f19020l) {
            i11 = -bf.b.state_lifted;
        } else {
            i11 = bf.b.state_lifted;
        }
        iArr[1] = i11;
        int i14 = bf.b.state_collapsible;
        if (!z10) {
            i14 = -i14;
        }
        iArr[2] = i14;
        if (!z10 || !this.f19020l) {
            i12 = -bf.b.state_collapsed;
        } else {
            i12 = bf.b.state_collapsed;
        }
        iArr[3] = i12;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (n0.y(this) && E()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                n0.d0(getChildAt(childCount), topInset);
            }
        }
        o();
        this.f19014e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            } else if (((e) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f19014e = true;
                break;
            } else {
                i14++;
            }
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f19018j) {
            if (!this.f19021m && !k()) {
                z11 = false;
            }
            z(z11);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && n0.y(this) && E()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = v0.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        o();
    }

    public boolean p() {
        return this.f19021m;
    }

    /* access modifiers changed from: package-private */
    public void s(int i10) {
        this.f19010a = i10;
        if (!willNotDraw()) {
            n0.j0(this);
        }
        List<b> list = this.f19017h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = this.f19017h.get(i11);
                if (bVar != null) {
                    bVar.a(this, i10);
                }
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        h.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        x(z10, n0.W(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f19021m = z10;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f19022n = -1;
        if (view == null) {
            e();
        } else {
            this.f19023p = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f19022n = i10;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f19018j = z10;
    }

    public void setOrientation(int i10) {
        if (i10 == 1) {
            super.setOrientation(i10);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.C;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.C = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.C.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.C, n0.B(this));
                Drawable drawable4 = this.C;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.C.setCallback(this);
            }
            G();
            n0.j0(this);
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(e.a.b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        i.b(this, f10);
    }

    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    /* access modifiers changed from: package-private */
    public k2 t(k2 k2Var) {
        k2 k2Var2;
        if (n0.y(this)) {
            k2Var2 = k2Var;
        } else {
            k2Var2 = null;
        }
        if (!androidx.core.util.c.a(this.f19016g, k2Var2)) {
            this.f19016g = k2Var2;
            G();
            requestLayout();
        }
        return k2Var;
    }

    public void u(b bVar) {
        List<b> list = this.f19017h;
        if (list != null && bVar != null) {
            list.remove(bVar);
        }
    }

    public void v(g gVar) {
        u(gVar);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.C;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f19015f = 0;
    }

    public void x(boolean z10, boolean z11) {
        y(z10, z11, true);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = F
            android.content.Context r10 = wf.a.c(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.f19011b = r10
            r9.f19012c = r10
            r9.f19013d = r10
            r6 = 0
            r9.f19015f = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.f19027x = r0
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r0 = r9.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L_0x002f
            com.google.android.material.appbar.i.a(r9)
        L_0x002f:
            com.google.android.material.appbar.i.c(r9, r11, r12, r4)
            int[] r2 = bf.l.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r12 = bf.l.AppBarLayout_android_background
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            androidx.core.view.n0.w0(r9, r12)
            int r12 = bf.l.AppBarLayout_liftOnScrollColor
            android.content.res.ColorStateList r12 = qf.c.a(r7, r11, r12)
            r9.f19024q = r12
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            boolean r0 = r0 instanceof android.graphics.drawable.ColorDrawable
            if (r0 == 0) goto L_0x0078
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r0 = (android.graphics.drawable.ColorDrawable) r0
            tf.g r1 = new tf.g
            r1.<init>()
            int r0 = r0.getColor()
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.b0(r0)
            if (r12 == 0) goto L_0x0072
            r9.m(r1)
            goto L_0x0075
        L_0x0072:
            r9.n(r7, r1)
        L_0x0075:
            androidx.core.view.n0.w0(r9, r1)
        L_0x0078:
            int r12 = bf.b.motionDurationMedium2
            android.content.res.Resources r0 = r9.getResources()
            int r1 = bf.g.app_bar_elevation_anim_duration
            int r0 = r0.getInteger(r1)
            int r12 = of.a.f(r7, r12, r0)
            long r0 = (long) r12
            r9.f19028y = r0
            int r12 = bf.b.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r0 = cf.a.f18977a
            android.animation.TimeInterpolator r12 = of.a.g(r7, r12, r0)
            r9.f19029z = r12
            int r12 = bf.l.AppBarLayout_expanded
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x00a4
            boolean r12 = r11.getBoolean(r12, r6)
            r9.y(r12, r6, r6)
        L_0x00a4:
            int r12 = bf.l.AppBarLayout_elevation
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x00b4
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            com.google.android.material.appbar.i.b(r9, r12)
        L_0x00b4:
            r12 = 26
            if (r8 < r12) goto L_0x00d6
            int r12 = bf.l.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x00c7
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        L_0x00c7:
            int r12 = bf.l.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L_0x00d6
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        L_0x00d6:
            android.content.res.Resources r12 = r9.getResources()
            int r0 = bf.d.design_appbar_elevation
            float r12 = r12.getDimension(r0)
            r9.D = r12
            int r12 = bf.l.AppBarLayout_liftOnScroll
            boolean r12 = r11.getBoolean(r12, r6)
            r9.f19021m = r12
            int r12 = bf.l.AppBarLayout_liftOnScrollTargetViewId
            int r10 = r11.getResourceId(r12, r10)
            r9.f19022n = r10
            int r10 = bf.l.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$a r10 = new com.google.android.material.appbar.AppBarLayout$a
            r10.<init>()
            androidx.core.view.n0.H0(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f19056a = 1;

        /* renamed from: b  reason: collision with root package name */
        private c f19057b;

        /* renamed from: c  reason: collision with root package name */
        Interpolator f19058c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppBarLayout_Layout);
            this.f19056a = obtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(obtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i10 = l.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.f19058c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i10, 0));
            }
            obtainStyledAttributes.recycle();
        }

        private c a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f19057b;
        }

        public int c() {
            return this.f19056a;
        }

        public Interpolator d() {
            return this.f19058c;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int i10 = this.f19056a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        public void f(int i10) {
            this.f19057b = a(i10);
        }

        public void g(int i10) {
            this.f19056a = i10;
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
