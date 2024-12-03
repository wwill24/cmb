package com.withpersona.sdk2.inquiry.governmentid.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.governmentid.h0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ti.b;
import ti.n;

public final class ScanningView extends View {

    /* renamed from: h  reason: collision with root package name */
    public static final a f26024h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f26025a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private SweepGradient f26026b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f26027c;

    /* renamed from: d  reason: collision with root package name */
    private Path f26028d;

    /* renamed from: e  reason: collision with root package name */
    private float f26029e;

    /* renamed from: f  reason: collision with root package name */
    private float f26030f = ((float) b.a(8.0d));

    /* renamed from: g  reason: collision with root package name */
    private int f26031g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ScanningView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        j.f(context2, IdentityHttpResponse.CONTEXT);
        this.f26031g = n.d(context2, h0.colorPrimary, (TypedValue) null, false, 6, (Object) null);
        this.f26026b = b();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) b.a(3.0d));
        paint.setShader(this.f26026b);
        this.f26027c = paint;
        this.f26028d = c();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(4000);
        ofFloat.addUpdateListener(new a(this));
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
    }

    private final SweepGradient b() {
        return new SweepGradient(0.5f, 0.5f, new int[]{-1, -1, this.f26031g}, new float[]{0.0f, 0.5f, 1.0f});
    }

    private final Path c() {
        Path path = new Path();
        float strokeWidth = this.f26027c.getStrokeWidth();
        float f10 = strokeWidth / 2.0f;
        if (((float) getWidth()) > strokeWidth && ((float) getHeight()) > strokeWidth) {
            float f11 = this.f26030f;
            float[] fArr = {f11, f11, f11, f11, f11, f11, f11, f11};
            path.addRoundRect(f10, f10, ((float) getWidth()) - f10, ((float) getHeight()) - f10, fArr, Path.Direction.CW);
        }
        return path;
    }

    /* access modifiers changed from: private */
    public static final void d(ScanningView scanningView, ValueAnimator valueAnimator) {
        j.g(scanningView, "this$0");
        j.g(valueAnimator, "it");
        scanningView.setAnimationRotation(valueAnimator.getAnimatedFraction() * 360.0f);
    }

    private final void e() {
        SweepGradient b10 = b();
        this.f26026b = b10;
        this.f26027c.setShader(b10);
        f();
        invalidate();
    }

    private final void f() {
        int max = Integer.max(getWidth(), getHeight());
        this.f26025a.setRotate(this.f26029e, 0.5f, 0.5f);
        float f10 = (float) max;
        this.f26025a.postScale(f10, f10);
        this.f26026b.setLocalMatrix(this.f26025a);
        invalidate();
    }

    private final void g() {
        this.f26028d = c();
        invalidate();
    }

    private final void setAnimationRotation(float f10) {
        boolean z10;
        if (this.f26029e == f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f26029e = f10;
            f();
        }
    }

    public final float getCornerRadius() {
        return this.f26030f;
    }

    public final int getHighlightColor() {
        return this.f26031g;
    }

    public final float getStrokeWidth() {
        return this.f26027c.getStrokeWidth();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawPath(this.f26028d, this.f26027c);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        g();
        f();
    }

    public final void setCornerRadius(float f10) {
        boolean z10;
        if (this.f26030f == f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f26030f = f10;
            g();
        }
    }

    public final void setHighlightColor(int i10) {
        if (this.f26031g != i10) {
            this.f26031g = i10;
            e();
        }
    }

    public final void setStrokeWidth(float f10) {
        boolean z10;
        if (this.f26027c.getStrokeWidth() == f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f26027c.setStrokeWidth(f10);
            invalidate();
        }
    }
}
