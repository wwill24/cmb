package com.coffeemeetsbagel.activity_reports.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.util.d;
import c5.e;
import com.mparticle.identity.IdentityHttpResponse;
import e5.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class OnOffView extends View {

    /* renamed from: l  reason: collision with root package name */
    public static final a f10967l = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Paint f10968a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f10969b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f10970c;

    /* renamed from: d  reason: collision with root package name */
    private float f10971d;

    /* renamed from: e  reason: collision with root package name */
    private float f10972e;

    /* renamed from: f  reason: collision with root package name */
    private float f10973f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10974g;

    /* renamed from: h  reason: collision with root package name */
    private double f10975h;

    /* renamed from: j  reason: collision with root package name */
    private double f10976j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AnimatorSet f10977k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnOffView f10978a;

        b(OnOffView onOffView) {
            this.f10978a = onOffView;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            this.f10978a.f10977k = null;
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animation");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animation");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnOffView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        int dimensionPixelSize = getResources().getDimensionPixelSize(c5.b.on_off_default_circle_stroke);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c5.b.on_off_default_small_circle_length);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(c5.b.on_off_default_needle_stroke_width);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.OnOffView);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr…s, R.styleable.OnOffView)");
            this.f10971d = (float) obtainStyledAttributes.getDimensionPixelSize(e.CircleBasedView_circle_stroke, dimensionPixelSize);
            this.f10972e = (float) obtainStyledAttributes.getDimensionPixelSize(e.CircleBasedView_small_circle_length, dimensionPixelSize2);
            this.f10973f = (float) obtainStyledAttributes.getDimensionPixelSize(e.OnOffView_needle_stroke_width, dimensionPixelSize3);
            obtainStyledAttributes.recycle();
        } else {
            this.f10971d = (float) dimensionPixelSize;
            this.f10972e = (float) dimensionPixelSize2;
            this.f10973f = (float) dimensionPixelSize3;
        }
        Paint paint = new Paint();
        this.f10968a = paint;
        j.d(paint);
        paint.setColor(context.getResources().getColor(c5.a.white));
        Paint paint2 = this.f10968a;
        j.d(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f10968a;
        j.d(paint3);
        paint3.setStrokeWidth(this.f10971d);
        Paint paint4 = this.f10968a;
        j.d(paint4);
        paint4.setAntiAlias(true);
        i(d(90.0d), e(90.0d));
    }

    private final double d(double d10) {
        return getNeedleLength() * Math.cos(Math.toRadians(d10));
    }

    private final double e(double d10) {
        return getNeedleLength() * Math.sin(Math.toRadians(d10));
    }

    private final double f(int i10) {
        return this.f10975h + ((double) i10);
    }

    private final double g(int i10) {
        return ((double) i10) - this.f10976j;
    }

    private final Point getNeedleCenter() {
        return new Point(getWidth() / 2, (int) ((((float) getHeight()) - (((float) getHeight()) / 4.0f)) - (this.f10972e / ((float) 2))));
    }

    private final int getNeedleColor() {
        if (this.f10974g) {
            return getContext().getResources().getColor(c5.a.white);
        }
        return getContext().getResources().getColor(c5.a.white);
    }

    private final Paint getNeedleHeadPaint() {
        if (this.f10969b == null) {
            Paint paint = new Paint();
            this.f10969b = paint;
            j.d(paint);
            paint.setColor(getNeedleColor());
            Paint paint2 = this.f10969b;
            j.d(paint2);
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.f10969b;
            j.d(paint3);
            paint3.setAntiAlias(true);
        }
        Paint paint4 = this.f10969b;
        j.d(paint4);
        return paint4;
    }

    private final double getNeedleLength() {
        return (double) (this.f10972e * ((float) 2));
    }

    private final Paint getNeedlePaint() {
        if (this.f10970c == null) {
            Paint paint = new Paint();
            this.f10970c = paint;
            j.d(paint);
            paint.setColor(getNeedleColor());
            Paint paint2 = this.f10970c;
            j.d(paint2);
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = this.f10970c;
            j.d(paint3);
            paint3.setStrokeWidth(this.f10973f);
            Paint paint4 = this.f10970c;
            j.d(paint4);
            paint4.setStrokeCap(Paint.Cap.ROUND);
            Paint paint5 = this.f10970c;
            j.d(paint5);
            paint5.setAntiAlias(true);
        }
        Paint paint6 = this.f10970c;
        j.d(paint6);
        return paint6;
    }

    private final d<Point, Point> h(Point point) {
        return new d<>(point, new Point((int) f(point.x), (int) g(point.y)));
    }

    private final void i(double d10, double d11) {
        this.f10975h = d10;
        this.f10976j = d11;
        invalidate();
    }

    /* access modifiers changed from: private */
    public static final void k(OnOffView onOffView, ValueAnimator valueAnimator) {
        j.g(onOffView, "this$0");
        j.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        onOffView.i((double) ((Float) animatedValue).floatValue(), onOffView.f10976j);
    }

    /* access modifiers changed from: private */
    public static final void l(OnOffView onOffView, ValueAnimator valueAnimator) {
        j.g(onOffView, "this$0");
        j.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        onOffView.i(onOffView.f10975h, (double) ((Float) animatedValue).floatValue());
    }

    public final void j(boolean z10, boolean z11) {
        AnimatorSet animatorSet = this.f10977k;
        if (animatorSet != null) {
            j.d(animatorSet);
            animatorSet.cancel();
            this.f10977k = null;
            i(d(90.0d), e(90.0d));
        }
        double d10 = -d(55.0d);
        double e10 = e(55.0d);
        double d11 = d(55.0d);
        if (!z10) {
            d11 = -d11;
        }
        double e11 = e(55.0d);
        if (z11) {
            this.f10977k = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) d10, (float) d11});
            ofFloat.addUpdateListener(new c(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) e10, (float) e11});
            ofFloat2.addUpdateListener(new e5.d(this));
            AnimatorSet animatorSet2 = this.f10977k;
            j.d(animatorSet2);
            animatorSet2.playTogether(new Animator[]{ofFloat, ofFloat2});
            AnimatorSet animatorSet3 = this.f10977k;
            j.d(animatorSet3);
            animatorSet3.addListener(new b(this));
            AnimatorSet animatorSet4 = this.f10977k;
            j.d(animatorSet4);
            animatorSet4.start();
            return;
        }
        i(d11, e11);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        super.onDraw(canvas);
        float f10 = (float) 2;
        float width = ((float) (getWidth() / 2)) - (this.f10971d / f10);
        Paint paint = this.f10968a;
        j.d(paint);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), width, paint);
        Point needleCenter = getNeedleCenter();
        canvas.drawCircle((float) needleCenter.x, (float) needleCenter.y, this.f10972e / f10, getNeedleHeadPaint());
        d<Point, Point> h10 = h(needleCenter);
        Point point = (Point) h10.f4735a;
        Point point2 = (Point) h10.f4736b;
        canvas.drawLine((float) point.x, (float) point.y, (float) point2.x, (float) point2.y, getNeedlePaint());
    }

    public final void setIsColorOn(boolean z10) {
        this.f10974g = z10;
        this.f10970c = null;
        this.f10969b = null;
        invalidate();
    }
}
