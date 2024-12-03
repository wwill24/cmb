package com.coffeemeetsbagel.cmbbottomnav.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.e2;
import androidx.core.view.h2;
import androidx.core.view.n0;
import com.coffeemeetsbagel.utils.model.Optional;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import j1.c;
import v5.g;

public class AHBottomNavigationBehavior<V extends View> extends VerticalScrollingBehavior<V> {

    /* renamed from: s  reason: collision with root package name */
    private static final Interpolator f11511s = new c();

    /* renamed from: e  reason: collision with root package name */
    private int f11512e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11513f = false;

    /* renamed from: g  reason: collision with root package name */
    private e2 f11514g;

    /* renamed from: h  reason: collision with root package name */
    private TabLayout f11515h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Snackbar.SnackbarLayout f11516i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public FloatingActionButton f11517j;

    /* renamed from: k  reason: collision with root package name */
    private int f11518k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11519l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f11520m = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f11521n = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f11522o = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f11523p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11524q = true;

    /* renamed from: r  reason: collision with root package name */
    private Optional<Integer> f11525r = Optional.a();

    class a implements h2 {
        a() {
        }

        public void a(View view) {
            if (AHBottomNavigationBehavior.this.f11516i != null && (AHBottomNavigationBehavior.this.f11516i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                AHBottomNavigationBehavior.this.f11520m = ((float) view.getMeasuredHeight()) - view.getTranslationY();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AHBottomNavigationBehavior.this.f11516i.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (int) AHBottomNavigationBehavior.this.f11520m);
                AHBottomNavigationBehavior.this.f11516i.requestLayout();
            }
            if (AHBottomNavigationBehavior.this.f11517j != null && (AHBottomNavigationBehavior.this.f11517j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) AHBottomNavigationBehavior.this.f11517j.getLayoutParams();
                AHBottomNavigationBehavior aHBottomNavigationBehavior = AHBottomNavigationBehavior.this;
                aHBottomNavigationBehavior.f11521n = (aHBottomNavigationBehavior.f11522o - view.getTranslationY()) + AHBottomNavigationBehavior.this.f11523p;
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, (int) AHBottomNavigationBehavior.this.f11521n);
                AHBottomNavigationBehavior.this.f11517j.requestLayout();
            }
        }
    }

    class b implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f11527a;

        b(View view) {
            this.f11527a = view;
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (AHBottomNavigationBehavior.this.f11517j != null && (AHBottomNavigationBehavior.this.f11517j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AHBottomNavigationBehavior.this.f11517j.getLayoutParams();
                AHBottomNavigationBehavior.this.f11523p = ((float) i13) - view.getY();
                AHBottomNavigationBehavior aHBottomNavigationBehavior = AHBottomNavigationBehavior.this;
                aHBottomNavigationBehavior.f11521n = (aHBottomNavigationBehavior.f11522o - this.f11527a.getTranslationY()) + AHBottomNavigationBehavior.this.f11523p;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (int) AHBottomNavigationBehavior.this.f11521n);
                AHBottomNavigationBehavior.this.f11517j.requestLayout();
            }
        }
    }

    public AHBottomNavigationBehavior() {
    }

    private void Q(V v10, int i10, boolean z10, boolean z11) {
        if (this.f11524q || z10) {
            R(v10, z11);
            this.f11514g.m((float) i10).l();
        }
    }

    private void R(V v10, boolean z10) {
        e2 e2Var = this.f11514g;
        long j10 = 300;
        if (e2Var == null) {
            e2 e10 = n0.e(v10);
            this.f11514g = e10;
            if (!z10) {
                j10 = 0;
            }
            e10.f(j10);
            this.f11514g.k(new a());
            this.f11514g.g(f11511s);
            return;
        }
        if (!z10) {
            j10 = 0;
        }
        e2Var.f(j10);
        this.f11514g.c();
    }

    private TabLayout S(View view) {
        int i10 = this.f11512e;
        if (i10 == 0) {
            return null;
        }
        return (TabLayout) view.findViewById(i10);
    }

    private void T(V v10, int i10) {
        int i11;
        if (this.f11524q) {
            if (i10 == -1 && this.f11513f) {
                this.f11513f = false;
                Q(v10, 0, false, true);
            } else if (i10 == 1 && !this.f11513f) {
                this.f11513f = true;
                if (this.f11525r.d()) {
                    i11 = this.f11525r.c().intValue();
                } else {
                    i11 = v10.getHeight();
                }
                Q(v10, i11, false, true);
            }
        }
    }

    public void E(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
    }

    /* access modifiers changed from: protected */
    public boolean F(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, int i10) {
        T(v10, i10);
        return true;
    }

    public void G(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        T(v10, i10);
    }

    public void U(V v10, int i10, boolean z10) {
        if (!this.f11513f) {
            this.f11513f = true;
            Q(v10, i10, true, z10);
        }
    }

    public void V(V v10, boolean z10) {
        if (this.f11513f) {
            this.f11513f = false;
            Q(v10, 0, true, z10);
        }
    }

    public void W(boolean z10) {
        this.f11524q = z10;
    }

    public void X(View view) {
        if (view != null && (view instanceof FloatingActionButton)) {
            this.f11517j = (FloatingActionButton) view;
            if (!this.f11519l && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                this.f11519l = true;
                this.f11522o = (float) ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }
    }

    public void Y(View view, View view2) {
        if (view2 != null && (view2 instanceof Snackbar.SnackbarLayout)) {
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view2;
            this.f11516i = snackbarLayout;
            snackbarLayout.addOnLayoutChangeListener(new b(view));
            if (this.f11518k == -1) {
                this.f11518k = view2.getHeight();
            }
            int measuredHeight = (int) (((float) view.getMeasuredHeight()) - view.getTranslationY());
            if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, measuredHeight);
                view2.requestLayout();
            }
        }
    }

    public boolean e(CoordinatorLayout coordinatorLayout, V v10, View view) {
        Y(v10, view);
        X(view);
        return super.e(coordinatorLayout, v10, view);
    }

    public boolean h(CoordinatorLayout coordinatorLayout, V v10, View view) {
        return super.h(coordinatorLayout, v10, view);
    }

    public void i(CoordinatorLayout coordinatorLayout, V v10, View view) {
        super.i(coordinatorLayout, v10, view);
    }

    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean l10 = super.l(coordinatorLayout, v10, i10);
        if (this.f11515h == null && this.f11512e != -1) {
            this.f11515h = S(v10);
        }
        return l10;
    }

    public void r(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        super.r(coordinatorLayout, v10, view, i10, i11, i12, i13);
        if (i11 < 0) {
            T(v10, -1);
        } else if (i11 > 0) {
            T(v10, 1);
        }
    }

    public boolean z(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        return i10 == 2 || super.z(coordinatorLayout, v10, view, view2, i10);
    }

    public AHBottomNavigationBehavior(boolean z10, int i10) {
        this.f11524q = z10;
        this.f11525r = Optional.e(Integer.valueOf(i10));
    }

    public AHBottomNavigationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.AHBottomNavigationBehavior_Params);
        this.f11512e = obtainStyledAttributes.getResourceId(g.AHBottomNavigationBehavior_Params_tabLayoutId, -1);
        obtainStyledAttributes.recycle();
    }
}
