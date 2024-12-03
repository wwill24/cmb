package com.appyvet.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import e3.a;
import e3.b;

class c extends View {
    private boolean B = false;

    /* renamed from: a  reason: collision with root package name */
    private float f9112a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9113b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f9114c;

    /* renamed from: d  reason: collision with root package name */
    private float f9115d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f9116e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f9117f;

    /* renamed from: g  reason: collision with root package name */
    private String f9118g;

    /* renamed from: h  reason: collision with root package name */
    private int f9119h;

    /* renamed from: j  reason: collision with root package name */
    private ColorFilter f9120j;

    /* renamed from: k  reason: collision with root package name */
    private float f9121k;

    /* renamed from: l  reason: collision with root package name */
    private float f9122l;

    /* renamed from: m  reason: collision with root package name */
    private Rect f9123m = new Rect();

    /* renamed from: n  reason: collision with root package name */
    private Resources f9124n;

    /* renamed from: p  reason: collision with root package name */
    private float f9125p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f9126q;

    /* renamed from: t  reason: collision with root package name */
    private float f9127t;

    /* renamed from: w  reason: collision with root package name */
    private a f9128w;

    /* renamed from: x  reason: collision with root package name */
    private float f9129x = 8.0f;

    /* renamed from: y  reason: collision with root package name */
    private float f9130y = 24.0f;

    /* renamed from: z  reason: collision with root package name */
    private boolean f9131z;

    public c(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        if (r5 > r0) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Paint r3, java.lang.String r4, float r5) {
        /*
            r2 = this;
            r0 = 1092616192(0x41200000, float:10.0)
            r3.setTextSize(r0)
            float r4 = r3.measureText(r4)
            r0 = 1090519040(0x41000000, float:8.0)
            float r5 = r5 * r0
            float r5 = r5 / r4
            float r4 = r2.f9125p
            float r5 = r5 / r4
            float r0 = r2.f9129x
            int r1 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0018
        L_0x0016:
            r5 = r0
            goto L_0x001f
        L_0x0018:
            float r0 = r2.f9130y
            int r1 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x001f
            goto L_0x0016
        L_0x001f:
            float r5 = r5 * r4
            r3.setTextSize(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appyvet.rangebar.c.a(android.graphics.Paint, java.lang.String, float):void");
    }

    public void b(Context context, float f10, float f11, int i10, int i11, float f12, int i12, float f13, float f14, boolean z10) {
        this.f9124n = context.getResources();
        this.f9117f = androidx.core.content.a.getDrawable(context, b.rotate);
        float f15 = getResources().getDisplayMetrics().density;
        this.f9125p = f15;
        this.f9129x = f13 / f15;
        this.f9130y = f14 / f15;
        this.f9131z = z10;
        this.f9121k = (float) ((int) TypedValue.applyDimension(1, 15.0f, this.f9124n.getDisplayMetrics()));
        this.f9127t = f12;
        this.f9122l = (float) ((int) TypedValue.applyDimension(1, 3.5f, this.f9124n.getDisplayMetrics()));
        if (f11 == -1.0f) {
            this.f9119h = (int) TypedValue.applyDimension(1, 14.0f, this.f9124n.getDisplayMetrics());
        } else {
            this.f9119h = (int) TypedValue.applyDimension(1, f11, this.f9124n.getDisplayMetrics());
        }
        Paint paint = new Paint();
        this.f9116e = paint;
        paint.setColor(i11);
        this.f9116e.setAntiAlias(true);
        this.f9116e.setTextSize((float) ((int) TypedValue.applyDimension(2, 15.0f, this.f9124n.getDisplayMetrics())));
        Paint paint2 = new Paint();
        this.f9126q = paint2;
        paint2.setColor(i12);
        this.f9126q.setAntiAlias(true);
        this.f9120j = new LightingColorFilter(i10, i10);
        this.f9112a = TypedValue.applyDimension(1, (float) ((int) Math.max(24.0f, (float) this.f9119h)), this.f9124n.getDisplayMetrics());
        this.f9114c = f10;
    }

    public boolean c(float f10, float f11) {
        if (Math.abs(f10 - this.f9115d) > this.f9112a || Math.abs((f11 - this.f9114c) + this.f9121k) > this.f9112a) {
            return false;
        }
        return true;
    }

    public void d() {
        this.f9113b = true;
        this.B = true;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(this.f9115d, this.f9114c, this.f9127t, this.f9126q);
        int i10 = this.f9119h;
        if (i10 > 0 && (this.B || !this.f9131z)) {
            Rect rect = this.f9123m;
            float f10 = this.f9115d;
            float f11 = this.f9114c;
            float f12 = this.f9121k;
            rect.set(((int) f10) - i10, (((int) f11) - (i10 * 2)) - ((int) f12), ((int) f10) + i10, ((int) f11) - ((int) f12));
            this.f9117f.setBounds(this.f9123m);
            String str = this.f9118g;
            a aVar = this.f9128w;
            if (aVar != null) {
                str = aVar.a(str);
            }
            a(this.f9116e, str, (float) this.f9123m.width());
            this.f9116e.getTextBounds(str, 0, str.length(), this.f9123m);
            this.f9116e.setTextAlign(Paint.Align.CENTER);
            this.f9117f.setColorFilter(this.f9120j);
            this.f9117f.draw(canvas);
            canvas.drawText(str, this.f9115d, ((this.f9114c - ((float) this.f9119h)) - this.f9121k) + this.f9122l, this.f9116e);
        }
        super.draw(canvas);
    }

    public void e() {
        this.f9113b = false;
    }

    public void f(a aVar) {
        this.f9128w = aVar;
    }

    public void g(float f10, float f11) {
        this.f9121k = (float) ((int) f11);
        this.f9119h = (int) f10;
        invalidate();
    }

    public float getX() {
        return this.f9115d;
    }

    public void h(String str) {
        this.f9118g = str;
    }

    public boolean isPressed() {
        return this.f9113b;
    }

    public void setX(float f10) {
        this.f9115d = f10;
    }
}
