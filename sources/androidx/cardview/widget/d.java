package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f3551a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f3552b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f3553c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f3554d;

    /* renamed from: e  reason: collision with root package name */
    private float f3555e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3556f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3557g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f3558h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f3559i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f3560j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f3561k = PorterDuff.Mode.SRC_IN;

    d(ColorStateList colorStateList, float f10) {
        this.f3551a = f10;
        this.f3552b = new Paint(5);
        e(colorStateList);
        this.f3553c = new RectF();
        this.f3554d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3558h = colorStateList;
        this.f3552b.setColor(colorStateList.getColorForState(getState(), this.f3558h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3553c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f3554d.set(rect);
        if (this.f3556f) {
            float b10 = e.b(this.f3555e, this.f3551a, this.f3557g);
            this.f3554d.inset((int) Math.ceil((double) e.a(this.f3555e, this.f3551a, this.f3557g)), (int) Math.ceil((double) b10));
            this.f3553c.set(this.f3554d);
        }
    }

    public ColorStateList b() {
        return this.f3558h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f3555e;
    }

    public float d() {
        return this.f3551a;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f3552b;
        if (this.f3559i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f3559i);
            z10 = true;
        }
        RectF rectF = this.f3553c;
        float f10 = this.f3551a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 != this.f3555e || this.f3556f != z10 || this.f3557g != z11) {
            this.f3555e = f10;
            this.f3556f = z10;
            this.f3557g = z11;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3554d, this.f3551a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 != this.f3551a) {
            this.f3551a = f10;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3560j;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.f3558h) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3558h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f3552b.getColor()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f3552b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3560j;
        if (colorStateList2 == null || (mode = this.f3561k) == null) {
            return z10;
        }
        this.f3559i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i10) {
        this.f3552b.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3552b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f3560j = colorStateList;
        this.f3559i = a(colorStateList, this.f3561k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f3561k = mode;
        this.f3559i = a(this.f3560j, mode);
        invalidateSelf();
    }
}
