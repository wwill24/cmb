package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f20441a = 0;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20442a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20443b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ lf.a f20444c;

        a(View view, int i10, lf.a aVar) {
            this.f20442a = view;
            this.f20443b = i10;
            this.f20444c = aVar;
        }

        public boolean onPreDraw() {
            this.f20442a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f20441a == this.f20443b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                lf.a aVar = this.f20444c;
                expandableBehavior.H((View) aVar, this.f20442a, aVar.b(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    private boolean F(boolean z10) {
        if (z10) {
            int i10 = this.f20441a;
            if (i10 == 0 || i10 == 2) {
                return true;
            }
            return false;
        } else if (this.f20441a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public lf.a G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> r10 = coordinatorLayout.r(view);
        int size = r10.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = r10.get(i10);
            if (e(coordinatorLayout, view, view2)) {
                return (lf.a) view2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean H(View view, View view2, boolean z10, boolean z11);

    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i10;
        lf.a aVar = (lf.a) view2;
        if (!F(aVar.b())) {
            return false;
        }
        if (aVar.b()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        this.f20441a = i10;
        return H((View) aVar, view, aVar.b(), true);
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
        lf.a G;
        int i11;
        if (n0.W(view) || (G = G(coordinatorLayout, view)) == null || !F(G.b())) {
            return false;
        }
        if (G.b()) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        this.f20441a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
