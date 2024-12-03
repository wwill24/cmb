package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.e;
import androidx.core.view.k2;
import androidx.core.view.n0;
import java.util.List;
import v0.a;

abstract class f extends g<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f19111d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    final Rect f19112e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private int f19113f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f19114g;

    public f() {
    }

    private static int N(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
        View H = H(coordinatorLayout.r(view));
        if (H != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f19111d;
            rect.set(coordinatorLayout.getPaddingLeft() + fVar.leftMargin, H.getBottom() + fVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - fVar.rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - fVar.bottomMargin);
            k2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && n0.y(coordinatorLayout) && !n0.y(view)) {
                rect.left += lastWindowInsets.i();
                rect.right -= lastWindowInsets.j();
            }
            Rect rect2 = this.f19112e;
            e.a(N(fVar.f4364c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f19113f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view, i10);
        this.f19113f = 0;
    }

    /* access modifiers changed from: package-private */
    public abstract View H(List<View> list);

    /* access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f19114g == 0) {
            return 0;
        }
        float J = J(view);
        int i10 = this.f19114g;
        return a.b((int) (J * ((float) i10)), 0, i10);
    }

    /* access modifiers changed from: package-private */
    public float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f19114g;
    }

    /* access modifiers changed from: package-private */
    public int L(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int M() {
        return this.f19113f;
    }

    public final void O(int i10) {
        this.f19114g = i10;
    }

    /* access modifiers changed from: protected */
    public boolean P() {
        return false;
    }

    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10, int i11, int i12, int i13) {
        View H;
        int i14;
        k2 lastWindowInsets;
        int i15 = view.getLayoutParams().height;
        if ((i15 != -1 && i15 != -2) || (H = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (n0.y(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.k() + lastWindowInsets.h();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            view.setTranslationY(0.0f);
            L -= measuredHeight;
        }
        if (i15 == -1) {
            i14 = 1073741824;
        } else {
            i14 = Integer.MIN_VALUE;
        }
        coordinatorLayout.J(view, i10, i11, View.MeasureSpec.makeMeasureSpec(L, i14), i13);
        return true;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
