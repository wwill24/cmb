package com.coffeemeetsbagel.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.RelativeLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import pa.a;

public class OnboardingBaseLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public CmbImageView f35643a;

    /* renamed from: b  reason: collision with root package name */
    public CmbImageView f35644b;

    public OnboardingBaseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() {
        post(new a(this, getContext().getResources().getDimensionPixelSize(R.dimen.video_overflow_touch_padding)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i10) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.f35643a.getHitRect(rect);
        this.f35644b.getHitRect(rect2);
        rect2.top -= i10;
        rect2.bottom -= i10;
        rect2.left += i10;
        rect2.right += i10;
        rect.top -= i10;
        rect.bottom -= i10;
        rect.left += i10;
        rect.right += i10;
        setTouchDelegate(new TouchDelegate(rect, this.f35643a));
        setTouchDelegate(new TouchDelegate(rect2, this.f35644b));
    }

    public void d(boolean z10, boolean z11) {
        int i10;
        this.f35644b.setClickable(z10);
        this.f35644b.setEnabled(z10);
        Drawable drawable = getResources().getDrawable(R.drawable.gray_arrow);
        if (this.f35644b.getDrawable() != null) {
            drawable = this.f35644b.getDrawable();
        }
        Resources resources = getContext().getResources();
        if (z10) {
            i10 = R.color.main_color;
        } else {
            i10 = R.color.gray;
        }
        drawable.setColorFilter(resources.getColor(i10), PorterDuff.Mode.SRC_ATOP);
        this.f35644b.setImageDrawable(drawable);
    }

    public void e() {
        this.f35644b.setVisibility(4);
    }

    public void f(View view, boolean z10) {
        int dimension = (int) getResources().getDimension(R.dimen.margin_xxxxxxxxxsmall);
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        if (gradientDrawable != null) {
            if (z10) {
                gradientDrawable.setStroke(dimension, getResources().getColor(R.color.error_color));
            } else {
                gradientDrawable.setStroke(dimension, getResources().getColor(R.color.phone_number_input_grey_stroke));
            }
            view.setBackground(gradientDrawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f35643a = (CmbImageView) findViewById(R.id.onboarding_back_button);
        CmbImageView cmbImageView = (CmbImageView) findViewById(R.id.onboarding_next_button);
        this.f35644b = cmbImageView;
        cmbImageView.setRotation(180.0f);
        b();
    }

    public void setBackButtonEnabled(boolean z10) {
        Drawable drawable;
        int i10;
        this.f35643a.setClickable(z10);
        this.f35643a.setEnabled(z10);
        if (this.f35643a.getDrawable() != null) {
            drawable = this.f35643a.getDrawable();
        } else {
            drawable = getResources().getDrawable(R.drawable.gray_arrow);
        }
        Resources resources = getContext().getResources();
        if (z10) {
            i10 = R.color.main_color;
        } else {
            i10 = R.color.gray;
        }
        drawable.setColorFilter(resources.getColor(i10), PorterDuff.Mode.SRC_ATOP);
        this.f35643a.setImageDrawable(drawable);
    }
}
