package f;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class a extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f14616a;

    public a(Drawable drawable) {
        a(drawable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f14616a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f14616a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f14616a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f14616a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f14616a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f14616a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f14616a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f14616a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f14616a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f14616a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f14616a.getPadding(rect);
    }

    public int[] getState() {
        return this.f14616a.getState();
    }

    public Region getTransparentRegion() {
        return this.f14616a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return androidx.core.graphics.drawable.a.h(this.f14616a);
    }

    public boolean isStateful() {
        return this.f14616a.isStateful();
    }

    public void jumpToCurrentState() {
        this.f14616a.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f14616a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        return this.f14616a.setLevel(i10);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        this.f14616a.setAlpha(i10);
    }

    public void setAutoMirrored(boolean z10) {
        androidx.core.graphics.drawable.a.j(this.f14616a, z10);
    }

    public void setChangingConfigurations(int i10) {
        this.f14616a.setChangingConfigurations(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14616a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z10) {
        this.f14616a.setDither(z10);
    }

    public void setFilterBitmap(boolean z10) {
        this.f14616a.setFilterBitmap(z10);
    }

    public void setHotspot(float f10, float f11) {
        androidx.core.graphics.drawable.a.k(this.f14616a, f10, f11);
    }

    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        androidx.core.graphics.drawable.a.l(this.f14616a, i10, i11, i12, i13);
    }

    public boolean setState(int[] iArr) {
        return this.f14616a.setState(iArr);
    }

    public void setTint(int i10) {
        androidx.core.graphics.drawable.a.n(this.f14616a, i10);
    }

    public void setTintList(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.f14616a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        androidx.core.graphics.drawable.a.p(this.f14616a, mode);
    }

    public boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f14616a.setVisible(z10, z11);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
