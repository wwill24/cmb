package com.coffeemeetsbagel.cmbbottomnav.behavior;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.k2;

public abstract class VerticalScrollingBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f11529a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f11530b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f11531c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f11532d = 0;

    public VerticalScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void B(CoordinatorLayout coordinatorLayout, V v10, View view) {
        super.B(coordinatorLayout, v10, view);
    }

    public abstract void E(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12);

    /* access modifiers changed from: protected */
    public abstract boolean F(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, int i10);

    public abstract void G(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12);

    public k2 f(CoordinatorLayout coordinatorLayout, V v10, k2 k2Var) {
        return super.f(coordinatorLayout, v10, k2Var);
    }

    public boolean n(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
        int i10;
        super.n(coordinatorLayout, v10, view, f10, f11, z10);
        if (f11 > 0.0f) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        int i11 = i10;
        this.f11532d = i11;
        return F(coordinatorLayout, v10, view, f10, f11, i11);
    }

    public boolean o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        return super.o(coordinatorLayout, v10, view, f10, f11);
    }

    public void p(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        super.p(coordinatorLayout, v10, view, i10, i11, iArr);
        if (i11 > 0 && this.f11530b < 0) {
            this.f11530b = 0;
            this.f11532d = 1;
        } else if (i11 < 0 && this.f11530b > 0) {
            this.f11530b = 0;
            this.f11532d = -1;
        }
        this.f11530b += i11;
        E(coordinatorLayout, v10, view, i10, i11, iArr, this.f11532d);
    }

    public void r(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        super.r(coordinatorLayout, v10, view, i10, i11, i12, i13);
        if (i13 > 0 && this.f11529a < 0) {
            this.f11529a = 0;
            this.f11531c = 1;
        } else if (i13 < 0 && this.f11529a > 0) {
            this.f11529a = 0;
            this.f11531c = -1;
        }
        int i14 = this.f11529a + i13;
        this.f11529a = i14;
        G(coordinatorLayout, v10, this.f11531c, i11, i14);
    }

    public void u(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        super.u(coordinatorLayout, v10, view, view2, i10);
    }

    public Parcelable y(CoordinatorLayout coordinatorLayout, V v10) {
        return super.y(coordinatorLayout, v10);
    }

    public boolean z(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        return (i10 & 2) != 0;
    }

    public VerticalScrollingBehavior() {
    }
}
