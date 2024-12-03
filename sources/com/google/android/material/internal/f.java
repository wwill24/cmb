package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

public class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f19866a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f19867b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f19868c;

    /* renamed from: d  reason: collision with root package name */
    private float f19869d;

    public void a(float f10) {
        if (this.f19869d != f10) {
            this.f19869d = f10;
            g.a(f10, this.f19868c);
            this.f19866a.setAlpha((int) (this.f19868c[0] * 255.0f));
            this.f19867b.setAlpha((int) (this.f19868c[1] * 255.0f));
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        this.f19866a.draw(canvas);
        this.f19867b.draw(canvas);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f19866a.getIntrinsicHeight(), this.f19867b.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f19866a.getIntrinsicWidth(), this.f19867b.getIntrinsicWidth());
    }

    public int getMinimumHeight() {
        return Math.max(this.f19866a.getMinimumHeight(), this.f19867b.getMinimumHeight());
    }

    public int getMinimumWidth() {
        return Math.max(this.f19866a.getMinimumWidth(), this.f19867b.getMinimumWidth());
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.f19866a.isStateful() || this.f19867b.isStateful();
    }

    public void setAlpha(int i10) {
        if (this.f19869d <= 0.5f) {
            this.f19866a.setAlpha(i10);
            this.f19867b.setAlpha(0);
        } else {
            this.f19866a.setAlpha(0);
            this.f19867b.setAlpha(i10);
        }
        invalidateSelf();
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f19866a.setBounds(i10, i11, i12, i13);
        this.f19867b.setBounds(i10, i11, i12, i13);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19866a.setColorFilter(colorFilter);
        this.f19867b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setState(int[] iArr) {
        boolean state = this.f19866a.setState(iArr);
        boolean state2 = this.f19867b.setState(iArr);
        if (state || state2) {
            return true;
        }
        return false;
    }
}
