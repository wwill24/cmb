package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import androidx.core.view.n0;
import d.j;

class v extends q {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1450d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1451e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1452f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1453g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1454h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1455i = false;

    v(SeekBar seekBar) {
        super(seekBar);
        this.f1450d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1451e;
        if (drawable == null) {
            return;
        }
        if (this.f1454h || this.f1455i) {
            Drawable r10 = a.r(drawable.mutate());
            this.f1451e = r10;
            if (this.f1454h) {
                a.o(r10, this.f1452f);
            }
            if (this.f1455i) {
                a.p(this.f1451e, this.f1453g);
            }
            if (this.f1451e.isStateful()) {
                this.f1451e.setState(this.f1450d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f1450d.getContext();
        int[] iArr = j.AppCompatSeekBar;
        h1 v10 = h1.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f1450d;
        n0.q0(seekBar, seekBar.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        Drawable h10 = v10.h(j.AppCompatSeekBar_android_thumb);
        if (h10 != null) {
            this.f1450d.setThumb(h10);
        }
        j(v10.g(j.AppCompatSeekBar_tickMark));
        int i11 = j.AppCompatSeekBar_tickMarkTintMode;
        if (v10.s(i11)) {
            this.f1453g = k0.e(v10.k(i11, -1), this.f1453g);
            this.f1455i = true;
        }
        int i12 = j.AppCompatSeekBar_tickMarkTint;
        if (v10.s(i12)) {
            this.f1452f = v10.c(i12);
            this.f1454h = true;
        }
        v10.w();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i10;
        if (this.f1451e != null) {
            int max = this.f1450d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1451e.getIntrinsicWidth();
                int intrinsicHeight = this.f1451e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i10 = intrinsicWidth / 2;
                } else {
                    i10 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f1451e.setBounds(-i10, -i11, i10, i11);
                float width = ((float) ((this.f1450d.getWidth() - this.f1450d.getPaddingLeft()) - this.f1450d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1450d.getPaddingLeft(), (float) (this.f1450d.getHeight() / 2));
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1451e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1451e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1450d.getDrawableState())) {
            this.f1450d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1451e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1451e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1451e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1450d);
            a.m(drawable, n0.B(this.f1450d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1450d.getDrawableState());
            }
            f();
        }
        this.f1450d.invalidate();
    }
}
