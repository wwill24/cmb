package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import bf.l;

public class i extends LinearLayoutCompat {
    boolean B;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f19874t;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f19875w;

    /* renamed from: x  reason: collision with root package name */
    private final Rect f19876x;

    /* renamed from: y  reason: collision with root package name */
    private int f19877y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f19878z;

    public i(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f19874t;
        if (drawable != null) {
            if (this.B) {
                this.B = false;
                Rect rect = this.f19875w;
                Rect rect2 = this.f19876x;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f19878z) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f19877y, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f19874t;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f19874t;
        if (drawable != null && drawable.isStateful()) {
            this.f19874t.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f19874t;
    }

    public int getForegroundGravity() {
        return this.f19877y;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f19874t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.B = z10 | this.B;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.B = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f19874t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f19874t);
            }
            this.f19874t = drawable;
            this.B = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f19877y == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i10) {
        if (this.f19877y != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f19877y = i10;
            if (i10 == 119 && this.f19874t != null) {
                this.f19874t.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19874t;
    }

    public i(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19875w = new Rect();
        this.f19876x = new Rect();
        this.f19877y = 119;
        this.f19878z = true;
        this.B = false;
        TypedArray i11 = p.i(context, attributeSet, l.ForegroundLinearLayout, i10, 0, new int[0]);
        this.f19877y = i11.getInt(l.ForegroundLinearLayout_android_foregroundGravity, this.f19877y);
        Drawable drawable = i11.getDrawable(l.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f19878z = i11.getBoolean(l.ForegroundLinearLayout_foregroundInsidePadding, true);
        i11.recycle();
    }
}
