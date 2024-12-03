package com.coffeemeetsbagel.like_pass.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import ba.f;
import j5.x;
import java.util.ArrayList;
import java.util.List;
import lc.m;
import q5.q;

public class CustomFabLikeButton extends FrameLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f14049a = io.reactivex.subjects.a.C0();

    /* renamed from: b  reason: collision with root package name */
    private ImageView f14050b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f14051c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f14052d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f14053e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AnimatorSet f14054f;

    /* renamed from: g  reason: collision with root package name */
    private int f14055g;

    /* renamed from: h  reason: collision with root package name */
    private int f14056h;

    /* renamed from: j  reason: collision with root package name */
    private int f14057j;

    /* renamed from: k  reason: collision with root package name */
    private int f14058k;

    class a extends q {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            CustomFabLikeButton.this.f14053e = false;
            CustomFabLikeButton.this.f14051c = false;
            CustomFabLikeButton.this.f14054f = null;
        }
    }

    class b extends q {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            CustomFabLikeButton.this.f14052d = false;
            CustomFabLikeButton.this.f14051c = true;
            CustomFabLikeButton.this.f14054f = null;
            CustomFabLikeButton.this.setVisibility(8);
        }
    }

    public CustomFabLikeButton(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(attributeSet);
    }

    private List<Animator> h(float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleX", new float[]{f10, f11}));
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleY", new float[]{f10, f11}));
        return arrayList;
    }

    private void i(List<Animator> list, Animator.AnimatorListener animatorListener, long j10) {
        AnimatorSet animatorSet = this.f14054f;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f14054f = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f14054f = animatorSet2;
        animatorSet2.playTogether(list);
        this.f14054f.addListener(animatorListener);
        this.f14054f.setDuration(j10);
        this.f14054f.start();
    }

    private void k(AttributeSet attributeSet) {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.CustomFabLikeButton);
            this.f14055g = obtainStyledAttributes.getDimensionPixelSize(f.CustomFabLikeButton_stroke_width, 0);
            this.f14056h = obtainStyledAttributes.getColor(f.CustomFabLikeButton_stroke_color, 0);
            this.f14057j = obtainStyledAttributes.getColor(f.CustomFabLikeButton_background_color, 0);
            this.f14058k = obtainStyledAttributes.getDimensionPixelSize(f.CustomFabLikeButton_elevation, 0);
            int resourceId = obtainStyledAttributes.getResourceId(f.CustomFabLikeButton_img_src, 0);
            i12 = obtainStyledAttributes.getColor(f.CustomFabLikeButton_img_tint, 0);
            i11 = obtainStyledAttributes.getDimensionPixelSize(f.CustomFabLikeButton_img_width, 0);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f.CustomFabLikeButton_img_height, 0);
            obtainStyledAttributes.recycle();
            i10 = dimensionPixelSize;
            i13 = resourceId;
        } else {
            Resources resources = getResources();
            this.f14055g = resources.getDimensionPixelSize(ba.b.give_take_button_stroke_width);
            this.f14056h = resources.getColor(ba.a.blue_cmb);
            this.f14057j = resources.getColor(ba.a.gray_background);
            this.f14058k = m.f41114a.a(getContext(), 8.0f);
            i10 = 0;
            i12 = 0;
            i11 = 0;
        }
        ImageView imageView = new ImageView(getContext());
        this.f14050b = imageView;
        if (i13 != 0) {
            imageView.setImageResource(i13);
        }
        if (i12 != 0) {
            this.f14050b.setColorFilter(i12);
        }
        int i14 = this.f14058k;
        if (i14 != 0) {
            setElevation(i14);
        }
        if (i11 <= 0 || i10 <= 0) {
            addView(this.f14050b);
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i10);
        layoutParams.gravity = 17;
        addView(this.f14050b, layoutParams);
    }

    public void a() {
        l(200);
    }

    public void c() {
        j(200);
    }

    public qj.q<x> g() {
        return this.f14049a.P();
    }

    public void j(long j10) {
        if (!this.f14051c && !this.f14052d) {
            this.f14052d = true;
            i(h(1.0f, 0.0f), new b(), j10);
        }
    }

    public void l(long j10) {
        if (!this.f14053e) {
            this.f14053e = true;
            setVisibility(0);
            i(h(0.0f, 1.0f), new a(), j10);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setCornerRadius((float) (i10 / 2));
        gradientDrawable.setStroke(this.f14055g, this.f14056h);
        gradientDrawable.setColor(this.f14057j);
        setBackground(gradientDrawable);
        q5.f.e(this);
        setElevation(this.f14058k);
    }

    public boolean performClick() {
        this.f14049a.d(x.a());
        return super.performClick();
    }

    public void setElevation(int i10) {
        this.f14058k = i10;
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            setImageTint(androidx.core.content.a.getColor(getContext(), ba.a.main_color));
        } else {
            setImageTint(androidx.core.content.a.getColor(getContext(), ba.a.gray));
        }
    }

    public void setImageResource(int i10) {
        this.f14050b.setImageResource(i10);
    }

    public void setImageTint(int i10) {
        this.f14050b.setColorFilter(i10);
    }

    public void setStrokeColor(int i10) {
        this.f14056h = i10;
        if (getBackground() != null) {
            ((GradientDrawable) getBackground()).setStroke(this.f14055g, i10);
        }
        invalidate();
    }
}
