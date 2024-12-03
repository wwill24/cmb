package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f20446b;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            AnimatorSet unused = ExpandableTransformationBehavior.this.f20446b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    public boolean H(View view, View view2, boolean z10, boolean z11) {
        boolean z12;
        AnimatorSet animatorSet = this.f20446b;
        if (animatorSet != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet J = J(view, view2, z10, z12);
        this.f20446b = J;
        J.addListener(new a());
        this.f20446b.start();
        if (!z11) {
            this.f20446b.end();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract AnimatorSet J(View view, View view2, boolean z10, boolean z11);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
