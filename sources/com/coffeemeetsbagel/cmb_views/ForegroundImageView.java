package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import q5.p;

public class ForegroundImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f11510a;

    public ForegroundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.ForegroundImageView);
        Drawable drawable = obtainStyledAttributes.getDrawable(p.ForegroundImageView_com_coffeemeetsbagel_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f11510a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11510a;
        if (drawable != null && drawable.isStateful()) {
            this.f11510a.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11510a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Drawable drawable = this.f11510a;
        if (drawable != null) {
            drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f11510a;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
            invalidate();
        }
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f11510a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f11510a);
            }
            this.f11510a = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundResource(int i10) {
        setForeground(getContext().getResources().getDrawable(i10));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11510a;
    }
}
