package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import tf.k;
import tf.l;

class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final l f19712a = l.k();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f19713b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f19714c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f19715d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f19716e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f19717f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f19718g = new b();

    /* renamed from: h  reason: collision with root package name */
    float f19719h;

    /* renamed from: i  reason: collision with root package name */
    private int f19720i;

    /* renamed from: j  reason: collision with root package name */
    private int f19721j;

    /* renamed from: k  reason: collision with root package name */
    private int f19722k;

    /* renamed from: l  reason: collision with root package name */
    private int f19723l;

    /* renamed from: m  reason: collision with root package name */
    private int f19724m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19725n = true;

    /* renamed from: o  reason: collision with root package name */
    private k f19726o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f19727p;

    private class b extends Drawable.ConstantState {
        private b() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return a.this;
        }
    }

    a(k kVar) {
        this.f19726o = kVar;
        Paint paint = new Paint(1);
        this.f19713b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect rect = this.f19715d;
        copyBounds(rect);
        float height = this.f19719h / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{androidx.core.graphics.a.h(this.f19720i, this.f19724m), androidx.core.graphics.a.h(this.f19721j, this.f19724m), androidx.core.graphics.a.h(androidx.core.graphics.a.l(this.f19721j, 0), this.f19724m), androidx.core.graphics.a.h(androidx.core.graphics.a.l(this.f19723l, 0), this.f19724m), androidx.core.graphics.a.h(this.f19723l, this.f19724m), androidx.core.graphics.a.h(this.f19722k, this.f19724m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF b() {
        this.f19717f.set(getBounds());
        return this.f19717f;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f19724m = colorStateList.getColorForState(getState(), this.f19724m);
        }
        this.f19727p = colorStateList;
        this.f19725n = true;
        invalidateSelf();
    }

    public void d(float f10) {
        if (this.f19719h != f10) {
            this.f19719h = f10;
            this.f19713b.setStrokeWidth(f10 * 1.3333f);
            this.f19725n = true;
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.f19725n) {
            this.f19713b.setShader(a());
            this.f19725n = false;
        }
        float strokeWidth = this.f19713b.getStrokeWidth() / 2.0f;
        copyBounds(this.f19715d);
        this.f19716e.set(this.f19715d);
        float min = Math.min(this.f19726o.r().a(b()), this.f19716e.width() / 2.0f);
        if (this.f19726o.u(b())) {
            this.f19716e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f19716e, min, min, this.f19713b);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i10, int i11, int i12, int i13) {
        this.f19720i = i10;
        this.f19721j = i11;
        this.f19722k = i12;
        this.f19723l = i13;
    }

    public void f(k kVar) {
        this.f19726o = kVar;
        invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f19718g;
    }

    public int getOpacity() {
        return this.f19719h > 0.0f ? -3 : -2;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f19726o.u(b())) {
            outline.setRoundRect(getBounds(), this.f19726o.r().a(b()));
            return;
        }
        copyBounds(this.f19715d);
        this.f19716e.set(this.f19715d);
        this.f19712a.d(this.f19726o, 1.0f, this.f19716e, this.f19714c);
        jf.b.f(outline, this.f19714c);
    }

    public boolean getPadding(@NonNull Rect rect) {
        if (!this.f19726o.u(b())) {
            return true;
        }
        int round = Math.round(this.f19719h);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f19727p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f19725n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f19727p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f19724m)) == this.f19724m)) {
            this.f19725n = true;
            this.f19724m = colorForState;
        }
        if (this.f19725n) {
            invalidateSelf();
        }
        return this.f19725n;
    }

    public void setAlpha(int i10) {
        this.f19713b.setAlpha(i10);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19713b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
