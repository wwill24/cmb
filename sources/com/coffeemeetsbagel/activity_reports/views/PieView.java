package com.coffeemeetsbagel.activity_reports.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c5.e;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class PieView extends View {

    /* renamed from: h  reason: collision with root package name */
    public static final a f10979h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f10980a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10981b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f10982c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f10983d;

    /* renamed from: e  reason: collision with root package name */
    private float f10984e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f10985f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10986g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PieView f10987a;

        b(PieView pieView) {
            this.f10987a = pieView;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            this.f10987a.f10985f = null;
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animation");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        int dimensionPixelSize = getResources().getDimensionPixelSize(c5.b.pie_view_default_inner_circle_length);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c5.b.pie_view_default_outer_circle_stroke);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.PieView);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.PieView)");
            this.f10980a = obtainStyledAttributes.getDimensionPixelSize(e.PieView_inner_circle_length, dimensionPixelSize);
            this.f10981b = obtainStyledAttributes.getDimensionPixelSize(e.PieView_outer_circle_stroke, dimensionPixelSize2);
            obtainStyledAttributes.recycle();
        } else {
            this.f10980a = dimensionPixelSize;
            this.f10981b = dimensionPixelSize2;
        }
        Paint paint = new Paint();
        this.f10982c = paint;
        paint.setColor(context.getResources().getColor(c5.a.white));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.f10981b);
        paint.setAntiAlias(true);
    }

    /* access modifiers changed from: private */
    public static final void d(PieView pieView, ValueAnimator valueAnimator) {
        j.g(pieView, "this$0");
        j.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        pieView.setSweepAngleAndInvalidate(((Float) animatedValue).floatValue());
    }

    private final int getColoredInColor() {
        if (this.f10986g) {
            return getContext().getResources().getColor(c5.a.white);
        }
        return getContext().getResources().getColor(c5.a.white);
    }

    private final Paint getColoredInPaint() {
        if (this.f10983d == null) {
            Paint paint = new Paint();
            this.f10983d = paint;
            j.d(paint);
            paint.setColor(getColoredInColor());
            Paint paint2 = this.f10983d;
            j.d(paint2);
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.f10983d;
            j.d(paint3);
            paint3.setAntiAlias(true);
        }
        Paint paint4 = this.f10983d;
        j.d(paint4);
        return paint4;
    }

    private final void setSweepAngleAndInvalidate(float f10) {
        this.f10984e = f10;
        invalidate();
    }

    public final void c(float f10, boolean z10) {
        boolean z11;
        if (f10 < 0.0f || f10 > 1.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            float f11 = f10 * 360.0f;
            if (z10) {
                ValueAnimator valueAnimator = this.f10985f;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                setSweepAngleAndInvalidate(0.0f);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, f11});
                if (ofFloat != null) {
                    ofFloat.setDuration(300);
                    ofFloat.addUpdateListener(new e5.e(this));
                    ofFloat.addListener(new b(this));
                    ofFloat.start();
                } else {
                    ofFloat = null;
                }
                this.f10985f = ofFloat;
                return;
            }
            setSweepAngleAndInvalidate(f11);
            return;
        }
        throw new IllegalArgumentException("percentage must be between 0f and 1.0f inclusive".toString());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z10;
        j.g(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - (this.f10981b / 2)), this.f10982c);
        if (this.f10980a > getWidth() || this.f10980a > getHeight()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            int width = (getWidth() - this.f10980a) / 2;
            Rect rect = new Rect();
            rect.left = width;
            rect.right = getWidth() - width;
            rect.top = width;
            rect.bottom = getHeight() - width;
            canvas.drawArc(new RectF(rect), -90.0f, this.f10984e, true, getColoredInPaint());
            return;
        }
        throw new IllegalStateException("inner circle cannot be bigger than total view length".toString());
    }

    public final void setIsColorOn(boolean z10) {
        this.f10986g = z10;
        this.f10983d = null;
        invalidate();
    }
}
