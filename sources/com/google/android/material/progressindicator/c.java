package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import hf.a;

final class c extends h<e> {

    /* renamed from: c  reason: collision with root package name */
    private int f19934c = 1;

    /* renamed from: d  reason: collision with root package name */
    private float f19935d;

    /* renamed from: e  reason: collision with root package name */
    private float f19936e;

    /* renamed from: f  reason: collision with root package name */
    private float f19937f;

    public c(@NonNull e eVar) {
        super(eVar);
    }

    private void h(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        canvas.save();
        canvas.rotate(f12);
        float f13 = this.f19937f;
        float f14 = f10 / 2.0f;
        canvas.drawRoundRect(new RectF(f13 - f14, f11, f13 + f14, -f11), f11, f11, paint);
        canvas.restore();
    }

    private int i() {
        S s10 = this.f19978a;
        return ((e) s10).f19953g + (((e) s10).f19954h * 2);
    }

    public void a(@NonNull Canvas canvas, @NonNull Rect rect, float f10) {
        int i10;
        float width = ((float) rect.width()) / ((float) e());
        float height = ((float) rect.height()) / ((float) d());
        S s10 = this.f19978a;
        float f11 = (((float) ((e) s10).f19953g) / 2.0f) + ((float) ((e) s10).f19954h);
        canvas.translate((f11 * width) + ((float) rect.left), (f11 * height) + ((float) rect.top));
        canvas.scale(width, height);
        canvas.rotate(-90.0f);
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        S s11 = this.f19978a;
        if (((e) s11).f19955i == 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        this.f19934c = i10;
        this.f19935d = ((float) ((e) s11).f19928a) * f10;
        this.f19936e = ((float) ((e) s11).f19929b) * f10;
        this.f19937f = ((float) (((e) s11).f19953g - ((e) s11).f19928a)) / 2.0f;
        if ((this.f19979b.k() && ((e) this.f19978a).f19932e == 2) || (this.f19979b.j() && ((e) this.f19978a).f19933f == 1)) {
            this.f19937f += ((1.0f - f10) * ((float) ((e) this.f19978a).f19928a)) / 2.0f;
        } else if ((this.f19979b.k() && ((e) this.f19978a).f19932e == 1) || (this.f19979b.j() && ((e) this.f19978a).f19933f == 2)) {
            this.f19937f -= ((1.0f - f10) * ((float) ((e) this.f19978a).f19928a)) / 2.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, float f10, float f11, int i10) {
        float f12;
        Paint paint2 = paint;
        if (f10 != f11) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i10);
            paint.setStrokeWidth(this.f19935d);
            int i11 = this.f19934c;
            float f13 = f10 * 360.0f * ((float) i11);
            if (f11 >= f10) {
                f12 = f11 - f10;
            } else {
                f12 = (1.0f + f11) - f10;
            }
            float f14 = f12 * 360.0f * ((float) i11);
            float f15 = this.f19937f;
            canvas.drawArc(new RectF(-f15, -f15, f15, f15), f13, f14, false, paint);
            if (this.f19936e > 0.0f && Math.abs(f14) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                h(canvas2, paint3, this.f19935d, this.f19936e, f13);
                h(canvas2, paint3, this.f19935d, this.f19936e, f13 + f14);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a10 = a.a(((e) this.f19978a).f19931d, this.f19979b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a10);
        paint.setStrokeWidth(this.f19935d);
        float f10 = this.f19937f;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), 0.0f, 360.0f, false, paint);
    }

    public int d() {
        return i();
    }

    public int e() {
        return i();
    }
}
