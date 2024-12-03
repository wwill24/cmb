package com.coffeemeetsbagel.behaviors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import com.coffeemeetsbagel.cmbbottomnav.component.CmbBottomNavView;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

public class BottomGradientBehavior extends CoordinatorLayout.c<View> {
    public BottomGradientBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private float E(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r10 = coordinatorLayout.r(view);
        float f10 = 0.0f;
        for (int i10 = 0; i10 < r10.size(); i10++) {
            View view2 = r10.get(i10);
            if ((view2 instanceof CmbBottomNavView) && n0.L(view2) > 0.0f) {
                f10 = Math.min(f10, n0.L(view2) - ((float) view2.getHeight())) + ((float) view2.getHeight());
            }
        }
        return f10;
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof CmbBottomNavView;
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        view.setTranslationY(E(coordinatorLayout, view));
        return false;
    }

    public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view2 instanceof Snackbar.SnackbarLayout) {
            view.setTranslationY(0.0f);
        }
    }
}
