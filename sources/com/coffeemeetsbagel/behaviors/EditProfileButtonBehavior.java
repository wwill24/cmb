package com.coffeemeetsbagel.behaviors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

public class EditProfileButtonBehavior extends CoordinatorLayout.c<ImageView> {
    public EditProfileButtonBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private float E(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r10 = coordinatorLayout.r(view);
        float f10 = 0.0f;
        for (int i10 = 0; i10 < r10.size(); i10++) {
            View view2 = r10.get(i10);
            if (view2 instanceof Snackbar.SnackbarLayout) {
                f10 = Math.min(f10, n0.L(view2) - ((float) view2.getHeight()));
            }
        }
        return f10;
    }

    /* renamed from: F */
    public boolean e(CoordinatorLayout coordinatorLayout, ImageView imageView, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    /* renamed from: G */
    public boolean h(CoordinatorLayout coordinatorLayout, ImageView imageView, View view) {
        imageView.setTranslationY(E(coordinatorLayout, imageView));
        return false;
    }

    /* renamed from: H */
    public void i(CoordinatorLayout coordinatorLayout, ImageView imageView, View view) {
        if (view instanceof Snackbar.SnackbarLayout) {
            imageView.setTranslationY(0.0f);
        }
    }
}
