package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import bf.b;
import bf.g;
import com.google.android.material.internal.p;

class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f19125a = {16843848};

    static void a(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(@NonNull View view, float f10) {
        int integer = view.getResources().getInteger(g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = (long) integer;
        stateListAnimator.addState(new int[]{16842910, b.state_liftable, -b.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(j10));
        stateListAnimator.addState(new int[]{16842910}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f10}).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(@NonNull View view, AttributeSet attributeSet, int i10, int i11) {
        Context context = view.getContext();
        TypedArray i12 = p.i(context, attributeSet, f19125a, i10, i11, new int[0]);
        try {
            if (i12.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, i12.getResourceId(0, 0)));
            }
        } finally {
            i12.recycle();
        }
    }
}
