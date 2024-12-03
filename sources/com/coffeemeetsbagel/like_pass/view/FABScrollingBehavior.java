package com.coffeemeetsbagel.like_pass.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import ba.b;
import ba.d;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

public class FABScrollingBehavior extends CoordinatorLayout.c<LinearLayout> {

    /* renamed from: a  reason: collision with root package name */
    private final int f14061a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f14062b = new ArrayList();

    public FABScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14061a = context.getResources().getDimensionPixelSize(b.vertical_scroll_behavior_minimum) * -1;
    }

    private float E(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout) {
        List<View> r10 = coordinatorLayout.r(linearLayout);
        float f10 = 0.0f;
        for (int i10 = 0; i10 < r10.size(); i10++) {
            View view = r10.get(i10);
            if (view instanceof Snackbar.SnackbarLayout) {
                f10 = Math.min(f10, n0.L(view) - ((float) view.getHeight()));
            }
        }
        return f10;
    }

    /* renamed from: F */
    public boolean e(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    /* renamed from: G */
    public boolean h(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view) {
        linearLayout.setTranslationY(E(coordinatorLayout, linearLayout));
        return super.h(coordinatorLayout, linearLayout, view);
    }

    /* renamed from: H */
    public void i(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view) {
        if (view instanceof Snackbar.SnackbarLayout) {
            linearLayout.setTranslationY(0.0f);
        }
    }

    /* renamed from: I */
    public void r(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, int i10, int i11, int i12, int i13) {
        super.r(coordinatorLayout, linearLayout, view, i10, i11, i12, i13);
        ViewGroup viewGroup = (ViewGroup) linearLayout.findViewById(d.linearLayout_buttons_pass_like);
        if (i11 > 0 || linearLayout.getVisibility() != 0) {
            linearLayout.setVisibility(0);
            for (int i14 = 0; i14 < viewGroup.getChildCount(); i14++) {
                c cVar = (c) viewGroup.getChildAt(i14);
                if (cVar.getVisibility() == 0) {
                    this.f14062b.add(cVar);
                    cVar.c();
                }
            }
        } else if (i11 <= this.f14061a) {
            for (c a10 : this.f14062b) {
                a10.a();
            }
        }
    }

    /* renamed from: J */
    public boolean z(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, View view, View view2, int i10) {
        return i10 == 2 || super.z(coordinatorLayout, linearLayout, view, view2, i10);
    }
}
