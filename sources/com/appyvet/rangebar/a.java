package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f9102a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f9103b;

    /* renamed from: c  reason: collision with root package name */
    private final float f9104c;

    /* renamed from: d  reason: collision with root package name */
    private final float f9105d;

    /* renamed from: e  reason: collision with root package name */
    private final float f9106e;

    /* renamed from: f  reason: collision with root package name */
    private int f9107f;

    /* renamed from: g  reason: collision with root package name */
    private float f9108g;

    /* renamed from: h  reason: collision with root package name */
    private final float f9109h;

    public a(Context context, float f10, float f11, float f12, int i10, float f13, int i11, float f14, int i12) {
        this.f9104c = f10;
        this.f9105d = f10 + f12;
        this.f9106e = f11;
        int i13 = i10 - 1;
        this.f9107f = i13;
        this.f9108g = f12 / ((float) i13);
        this.f9109h = TypedValue.applyDimension(1, f13, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f9102a = paint;
        paint.setColor(i12);
        paint.setStrokeWidth(f14);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f9103b = paint2;
        paint2.setColor(i11);
        paint2.setStrokeWidth(f14);
        paint2.setAntiAlias(true);
    }

    public void a(Canvas canvas) {
        float f10 = this.f9104c;
        float f11 = this.f9106e;
        canvas.drawLine(f10, f11, this.f9105d, f11, this.f9102a);
    }

    public void b(Canvas canvas) {
        for (int i10 = 0; i10 < this.f9107f; i10++) {
            canvas.drawCircle((((float) i10) * this.f9108g) + this.f9104c, this.f9106e, this.f9109h, this.f9103b);
        }
        canvas.drawCircle(this.f9105d, this.f9106e, this.f9109h, this.f9103b);
    }

    public float c() {
        return this.f9104c;
    }

    public float d(c cVar) {
        return this.f9104c + (((float) e(cVar)) * this.f9108g);
    }

    public int e(c cVar) {
        float x10 = cVar.getX() - this.f9104c;
        float f10 = this.f9108g;
        return (int) ((x10 + (f10 / 2.0f)) / f10);
    }

    public float f() {
        return this.f9105d;
    }
}
