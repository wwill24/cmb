package com.coffeemeetsbagel.activity_reports.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import c5.b;
import c5.e;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class MessageView extends View {

    /* renamed from: g  reason: collision with root package name */
    public static final a f10960g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f10961a;

    /* renamed from: b  reason: collision with root package name */
    private int f10962b;

    /* renamed from: c  reason: collision with root package name */
    private int f10963c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f10964d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f10965e;

    /* renamed from: f  reason: collision with root package name */
    private ValueAnimator f10966f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        int dimensionPixelSize = getResources().getDimensionPixelSize(b.messages_view_default_dot_length);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.MessageView);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.MessageView)");
            this.f10963c = obtainStyledAttributes.getDimensionPixelSize(e.PieView_inner_circle_length, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            return;
        }
        this.f10963c = dimensionPixelSize;
    }

    private final Point b(int i10) {
        return new Point(c(i10), getDotY());
    }

    private final int c(int i10) {
        if (this.f10964d == null) {
            double width = ((double) getWidth()) / 2.0d;
            int i11 = this.f10963c;
            double d10 = ((double) i11) * 0.8d;
            this.f10964d = new int[]{((int) ((width - ((double) i11)) - d10)) - 2, ((int) width) - 2, ((int) ((width + ((double) i11)) + d10)) - 2};
        }
        int[] iArr = this.f10964d;
        j.d(iArr);
        return iArr[i10];
    }

    /* access modifiers changed from: private */
    public static final void e(MessageView messageView, ValueAnimator valueAnimator) {
        j.g(messageView, "this$0");
        j.g(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        messageView.setNumDotsOnAndInvalidate(((Integer) animatedValue).intValue());
    }

    private final int getDotColor() {
        if (this.f10961a) {
            return getContext().getResources().getColor(c5.a.white);
        }
        return getContext().getResources().getColor(c5.a.white);
    }

    private final Paint getDotPaint() {
        if (this.f10965e == null) {
            Paint paint = new Paint();
            this.f10965e = paint;
            j.d(paint);
            paint.setColor(getDotColor());
            Paint paint2 = this.f10965e;
            j.d(paint2);
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.f10965e;
            j.d(paint3);
            paint3.setAntiAlias(true);
        }
        Paint paint4 = this.f10965e;
        j.d(paint4);
        return paint4;
    }

    private final int getDotY() {
        return ((int) ((((double) getHeight()) / 2.0d) - (((double) this.f10963c) / 3.0d))) + 2;
    }

    private final void setNumDotsOnAndInvalidate(int i10) {
        this.f10962b = i10;
        invalidate();
    }

    public final void d(int i10, boolean z10) {
        boolean z11;
        if (i10 < 0 || i10 > 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            ValueAnimator valueAnimator = this.f10966f;
            if (valueAnimator != null) {
                j.d(valueAnimator);
                valueAnimator.cancel();
                this.f10966f = null;
                setNumDotsOnAndInvalidate(0);
            }
            if (z10) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i10});
                ofInt.setDuration(300);
                ofInt.addUpdateListener(new e5.b(this));
                ofInt.start();
                this.f10966f = ofInt;
                return;
            }
            setNumDotsOnAndInvalidate(i10);
            return;
        }
        throw new IllegalArgumentException("num dots must be >= 0 and < 3".toString());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        super.onDraw(canvas);
        int i10 = this.f10962b;
        for (int i11 = 0; i11 < i10; i11++) {
            Point b10 = b(i11);
            canvas.drawCircle((float) b10.x, (float) b10.y, (float) (this.f10963c / 2), getDotPaint());
        }
    }

    public final void setIsColorOn(boolean z10) {
        this.f10961a = z10;
        this.f10965e = null;
        invalidate();
    }
}
