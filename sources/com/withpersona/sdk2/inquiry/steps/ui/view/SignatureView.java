package com.withpersona.sdk2.inquiry.steps.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.material.card.MaterialCardView;
import com.mparticle.kits.ReportingMessage;
import kotlin.jvm.internal.j;
import ti.b;

public final class SignatureView extends MaterialCardView {
    private RectF B = new RectF();
    private Path C = new Path();
    private final Paint D = new Paint(4);
    private final Paint E = new Paint();
    private float F;
    private float G;

    /* renamed from: y  reason: collision with root package name */
    private Bitmap f29266y;

    /* renamed from: z  reason: collision with root package name */
    private Canvas f29267z;

    public SignatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context, attributeSet);
    }

    private final Rect k() {
        RectF rectF = new RectF(this.B.left - this.E.getStrokeWidth(), this.B.top - this.E.getStrokeWidth(), this.B.right + this.E.getStrokeWidth(), this.B.bottom + this.E.getStrokeWidth());
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    private final void l(Canvas canvas) {
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(-3355444);
        paint.setStrokeWidth(4.0f);
        float a10 = (float) b.a(24.0d);
        float a11 = (float) b.a(20.0d);
        float height = ((float) canvas.getHeight()) - a10;
        canvas.drawLine(a11, ((float) canvas.getHeight()) - a10, ((float) canvas.getWidth()) - a11, height, paint);
        canvas.restore();
    }

    private final void n(Context context, AttributeSet attributeSet) {
        this.E.setAntiAlias(true);
        this.E.setDither(true);
        this.E.setColor(-16777216);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeJoin(Paint.Join.ROUND);
        this.E.setStrokeCap(Paint.Cap.ROUND);
        this.E.setStrokeWidth(5.0f);
    }

    private final boolean o() {
        return this.B.isEmpty();
    }

    private final void p(float f10, float f11) {
        this.C.lineTo(f10, f11);
        this.F = f10;
        this.G = f11;
    }

    private final void q(float f10, float f11) {
        this.C.reset();
        this.C.moveTo(f10, f11);
        this.F = f10;
        this.G = f11;
    }

    private final void r() {
        Canvas canvas = this.f29267z;
        if (canvas != null) {
            if (!this.C.isEmpty()) {
                this.C.lineTo(this.F, this.G);
                canvas.drawPath(this.C, this.E);
            } else {
                this.C.moveTo(this.F - 0.5f, this.G - 0.5f);
                this.C.lineTo(this.F, this.G);
                canvas.drawPoint(this.F, this.G, this.E);
            }
            s();
            this.C.reset();
        }
    }

    private final void s() {
        RectF rectF = new RectF();
        this.C.computeBounds(rectF, true);
        if (!this.C.isEmpty()) {
            float f10 = (float) 2;
            rectF.inset((-this.E.getStrokeWidth()) / f10, (-this.E.getStrokeWidth()) / f10);
        }
        rectF.sort();
        this.B.union(rectF);
        this.B.sort();
    }

    public final void j() {
        Canvas canvas = this.f29267z;
        if (canvas != null) {
            this.C.reset();
            this.B = new RectF();
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }

    public final Bitmap m() {
        Bitmap bitmap = this.f29266y;
        if (o() || bitmap == null) {
            return null;
        }
        s();
        Rect k10 = k();
        Rect rect = new Rect(0, 0, k10.width(), k10.height());
        Bitmap createBitmap = Bitmap.createBitmap(k10.width(), k10.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.drawBitmap(bitmap, k10, rect, (Paint) null);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawColor(0);
            Bitmap bitmap = this.f29266y;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.D);
            }
            l(canvas);
            canvas.drawPath(this.C, this.E);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 > 0 && i11 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            this.f29266y = createBitmap;
            this.f29267z = new Canvas(createBitmap);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        j.g(motionEvent, ReportingMessage.MessageType.EVENT);
        super.onTouchEvent(motionEvent);
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            q(x10, y10);
            invalidate();
        } else if (action == 1) {
            r();
            invalidate();
        } else if (action == 2) {
            p(x10, y10);
            invalidate();
        }
        return true;
    }
}
