package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f9110a;

    /* renamed from: b  reason: collision with root package name */
    private final float f9111b;

    public b(Context context, float f10, float f11, int i10) {
        float applyDimension = TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f9110a = paint;
        paint.setColor(i10);
        paint.setStrokeWidth(applyDimension);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        this.f9111b = f10;
    }

    public void a(Canvas canvas, float f10, c cVar) {
        canvas.drawLine(f10, this.f9111b, cVar.getX(), this.f9111b, this.f9110a);
    }

    public void b(Canvas canvas, c cVar, c cVar2) {
        canvas.drawLine(cVar.getX(), this.f9111b, cVar2.getX(), this.f9111b, this.f9110a);
    }
}
