package com.coffeemeetsbagel.activity_reports.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c5.e;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DottedCircleView extends View {

    /* renamed from: k  reason: collision with root package name */
    public static final a f10949k = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f10950a = 12;

    /* renamed from: b  reason: collision with root package name */
    private int f10951b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f10952c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f10953d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f10954e;

    /* renamed from: f  reason: collision with root package name */
    private int f10955f;

    /* renamed from: g  reason: collision with root package name */
    private Path f10956g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f10957h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10958j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int b(int i10) {
            return (int) (((double) i10) * 6.283185307179586d);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DottedCircleView f10959a;

        b(DottedCircleView dottedCircleView) {
            this.f10959a = dottedCircleView;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            this.f10959a.f10957h = null;
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animation");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DottedCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        int dimensionPixelSize = getResources().getDimensionPixelSize(c5.b.dotted_circle_default_circle_stroke);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c5.b.dotted_circle_default_small_circle_length);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.DottedCircleView);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr…yleable.DottedCircleView)");
            f10 = (float) obtainStyledAttributes.getDimensionPixelSize(e.CircleBasedView_circle_stroke, dimensionPixelSize);
            this.f10951b = obtainStyledAttributes.getDimensionPixelSize(e.CircleBasedView_small_circle_length, dimensionPixelSize2);
            obtainStyledAttributes.recycle();
        } else {
            f10 = (float) dimensionPixelSize;
            this.f10951b = dimensionPixelSize2;
        }
        Paint paint = new Paint();
        this.f10952c = paint;
        j.d(paint);
        paint.setColor(context.getResources().getColor(c5.a.white));
        Paint paint2 = this.f10952c;
        j.d(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f10952c;
        j.d(paint3);
        paint3.setStrokeWidth(f10);
        Paint paint4 = this.f10952c;
        j.d(paint4);
        paint4.setAntiAlias(true);
    }

    private final float c(double d10) {
        return (float) (((double) 360.0f) * d10);
    }

    private final float d() {
        return (c(getPercentageOn()) - 0.049804688f) + ((float) this.f10951b);
    }

    private final float e(float f10) {
        return 270.0f - f10;
    }

    private final float f() {
        return c(getPercentageOn());
    }

    private final RectF getCircleRectF() {
        if (this.f10954e == null) {
            int i10 = this.f10951b;
            this.f10954e = new RectF((float) i10, (float) i10, (float) (getWidth() - this.f10951b), (float) (getHeight() - this.f10951b));
        }
        RectF rectF = this.f10954e;
        j.d(rectF);
        return rectF;
    }

    private final double getPercentageOn() {
        return ((double) this.f10955f) / ((double) this.f10950a);
    }

    private final int getSmallCircleColor() {
        if (this.f10958j) {
            return getContext().getResources().getColor(c5.a.white);
        }
        return getContext().getResources().getColor(c5.a.white);
    }

    private final Paint getSmallCirclePaint() {
        if (this.f10953d == null) {
            Paint paint = new Paint();
            this.f10953d = paint;
            j.d(paint);
            paint.setColor(getSmallCircleColor());
            Paint paint2 = this.f10953d;
            j.d(paint2);
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = this.f10953d;
            j.d(paint3);
            paint3.setStrokeWidth((float) this.f10951b);
            Path smallCirclePath = getSmallCirclePath();
            float smallCircleSpacing = getSmallCircleSpacing();
            Paint paint4 = this.f10953d;
            j.d(paint4);
            paint4.setPathEffect(new PathDashPathEffect(smallCirclePath, smallCircleSpacing, (float) (this.f10951b / 2), PathDashPathEffect.Style.TRANSLATE));
            Paint paint5 = this.f10953d;
            j.d(paint5);
            paint5.setAntiAlias(true);
        }
        Paint paint6 = this.f10953d;
        j.d(paint6);
        return paint6;
    }

    private final Path getSmallCirclePath() {
        if (this.f10956g == null) {
            Path path = new Path();
            this.f10956g = path;
            j.d(path);
            path.addCircle(0.0f, 0.0f, (float) (this.f10951b / 2), Path.Direction.CCW);
            Path path2 = this.f10956g;
            j.d(path2);
            path2.close();
        }
        Path path3 = this.f10956g;
        j.d(path3);
        return path3;
    }

    private final float getSmallCircleSpacing() {
        int a10 = f10949k.b(getWidth() / 2);
        int i10 = this.f10951b;
        int i11 = this.f10950a;
        return (float) (((a10 - (i10 * i11)) / i11) + (i10 / 2));
    }

    /* access modifiers changed from: private */
    public static final void h(DottedCircleView dottedCircleView, ValueAnimator valueAnimator) {
        j.g(dottedCircleView, "this$0");
        j.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        dottedCircleView.setNumDotsOnAndInvalidate(((Integer) animatedValue).intValue());
    }

    private final void setNumDotsOnAndInvalidate(int i10) {
        this.f10955f = i10;
        this.f10953d = null;
        this.f10954e = null;
        invalidate();
    }

    public final void g(int i10, boolean z10) {
        boolean z11;
        if (i10 < 0 || i10 > this.f10950a) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("num dots on must be between [0, " + this.f10950a + PropertyUtils.INDEXED_DELIM2).toString());
        } else if (z10) {
            ValueAnimator valueAnimator = this.f10957h;
            if (valueAnimator != null) {
                j.d(valueAnimator);
                valueAnimator.cancel();
                setNumDotsOnAndInvalidate(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i10});
            ofInt.setDuration(300);
            ofInt.addUpdateListener(new e5.a(this));
            ofInt.addListener(new b(this));
            ofInt.start();
            this.f10957h = ofInt;
        } else {
            setNumDotsOnAndInvalidate(i10);
        }
    }

    public final int getMaxNumDots() {
        return this.f10950a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        super.onDraw(canvas);
        int i10 = this.f10955f;
        if (i10 == this.f10950a) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - this.f10951b), getSmallCirclePaint());
        } else if (i10 == 0) {
            Paint paint = this.f10952c;
            j.d(paint);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - this.f10951b), paint);
        } else {
            float d10 = d();
            float e10 = e(d10);
            RectF circleRectF = getCircleRectF();
            Paint paint2 = this.f10952c;
            j.d(paint2);
            Canvas canvas2 = canvas;
            canvas2.drawArc(circleRectF, d10, e10, false, paint2);
            canvas2.drawArc(getCircleRectF(), -90.0f, f(), false, getSmallCirclePaint());
        }
    }

    public final void setIsColorOn(boolean z10) {
        this.f10958j = z10;
        this.f10953d = null;
    }
}
