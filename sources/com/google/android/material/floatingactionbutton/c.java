package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.ArrayList;
import sf.b;
import tf.g;
import tf.k;

class c extends b {
    private StateListAnimator O;

    static class a extends g {
        a(k kVar) {
            super(kVar);
        }

        public boolean isStateful() {
            return true;
        }
    }

    c(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    @NonNull
    private StateListAnimator i0(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(b.I, j0(f10, f12));
        stateListAnimator.addState(b.J, j0(f10, f11));
        stateListAnimator.addState(b.K, j0(f10, f11));
        stateListAnimator.addState(b.L, j0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f19751w, "elevation", new float[]{f10}).setDuration(0));
        arrayList.add(ObjectAnimator.ofFloat(this.f19751w, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(b.D);
        stateListAnimator.addState(b.M, animatorSet);
        stateListAnimator.addState(b.N, j0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator j0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f19751w, "elevation", new float[]{f10}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f19751w, View.TRANSLATION_Z, new float[]{f11}).setDuration(100));
        animatorSet.setInterpolator(b.D);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        e0();
    }

    /* access modifiers changed from: package-private */
    public void D(int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    public void E(float f10, float f11, float f12) {
        if (this.f19751w.getStateListAnimator() == this.O) {
            StateListAnimator i02 = i0(f10, f11, f12);
            this.O = i02;
            this.f19751w.setStateListAnimator(i02);
        }
        if (Y()) {
            e0();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void U(ColorStateList colorStateList) {
        Drawable drawable = this.f19731c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(rf.b.d(colorStateList));
        } else {
            super.U(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Y() {
        return this.f19752x.b() || !a0();
    }

    /* access modifiers changed from: package-private */
    public void c0() {
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a h0(int i10, ColorStateList colorStateList) {
        Context context = this.f19751w.getContext();
        a aVar = new a((k) h.g(this.f19729a));
        aVar.e(androidx.core.content.a.getColor(context, bf.c.design_fab_stroke_top_outer_color), androidx.core.content.a.getColor(context, bf.c.design_fab_stroke_top_inner_color), androidx.core.content.a.getColor(context, bf.c.design_fab_stroke_end_inner_color), androidx.core.content.a.getColor(context, bf.c.design_fab_stroke_end_outer_color));
        aVar.d((float) i10);
        aVar.c(colorStateList);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public g k0() {
        return new a((k) h.g(this.f19729a));
    }

    public float m() {
        return this.f19751w.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull Rect rect) {
        if (this.f19752x.b()) {
            super.r(rect);
        } else if (!a0()) {
            int sizeDimension = (this.f19739k - this.f19751w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        g k02 = k0();
        this.f19730b = k02;
        k02.setTintList(colorStateList);
        if (mode != null) {
            this.f19730b.setTintMode(mode);
        }
        this.f19730b.Q(this.f19751w.getContext());
        if (i10 > 0) {
            this.f19732d = h0(i10, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) h.g(this.f19732d), (Drawable) h.g(this.f19730b)});
        } else {
            this.f19732d = null;
            drawable = this.f19730b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(rf.b.d(colorStateList2), drawable, (Drawable) null);
        this.f19731c = rippleDrawable;
        this.f19733e = rippleDrawable;
    }

    /* access modifiers changed from: package-private */
    public void z() {
    }
}
