package com.withpersona.sdk2.inquiry.selfie.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.selfie.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class ProgressArcView extends View {

    /* renamed from: j  reason: collision with root package name */
    public static final a f27449j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Paint f27450a;

    /* renamed from: b  reason: collision with root package name */
    private final float f27451b;

    /* renamed from: c  reason: collision with root package name */
    private final float f27452c;

    /* renamed from: d  reason: collision with root package name */
    private float f27453d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f27454e;

    /* renamed from: f  reason: collision with root package name */
    private ValueAnimator f27455f;

    /* renamed from: g  reason: collision with root package name */
    private ValueAnimator f27456g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f27457h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private float f27458a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ValueAnimator f27459b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProgressArcView f27460c;

        b(ValueAnimator valueAnimator, ProgressArcView progressArcView) {
            this.f27459b = valueAnimator;
            this.f27460c = progressArcView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.g(valueAnimator, "animator");
            Object animatedValue = this.f27459b.getAnimatedValue();
            j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            float abs = Math.abs(floatValue - this.f27458a);
            float b10 = this.f27460c.f27457h;
            ProgressArcView progressArcView = this.f27460c;
            progressArcView.f27457h = (progressArcView.f27457h + abs) % ((float) 360);
            if (b10 > this.f27460c.f27457h) {
                this.f27460c.f27457h = 0.0f;
                valueAnimator.cancel();
            }
            this.f27458a = floatValue;
            this.f27460c.invalidate();
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function0 f27461a;

        c(Function0 function0) {
            j.g(function0, "function");
            this.f27461a = function0;
        }

        public final /* synthetic */ void run() {
            this.f27461a.invoke();
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private float f27462a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ValueAnimator f27463b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProgressArcView f27464c;

        d(ValueAnimator valueAnimator, ProgressArcView progressArcView) {
            this.f27463b = valueAnimator;
            this.f27464c = progressArcView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.g(valueAnimator, "animator");
            Object animatedValue = this.f27463b.getAnimatedValue();
            j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            float abs = Math.abs(floatValue - this.f27462a);
            ProgressArcView progressArcView = this.f27464c;
            progressArcView.f27457h = (progressArcView.f27457h + abs) % ((float) 360);
            this.f27462a = floatValue;
            this.f27464c.invalidate();
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0 f27465a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressArcView f27466b;

        public e(Function0 function0, ProgressArcView progressArcView) {
            this.f27465a = function0;
            this.f27466b = progressArcView;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animator");
            Function0 function0 = this.f27465a;
            if (function0 != null) {
                this.f27466b.postDelayed(new c(function0), 100);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animator");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProgressArcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressArcView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void d() {
        boolean z10;
        if (this.f27457h == 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new b(ofFloat, this));
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(2);
            ofFloat.start();
            this.f27456g = ofFloat;
        }
    }

    public static /* synthetic */ void g(ProgressArcView progressArcView, float f10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        progressArcView.f(f10, function0);
    }

    private final void h(float f10, Function0<Unit> function0) {
        boolean z10;
        if (this.f27453d == f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ValueAnimator valueAnimator = this.f27454e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            float f11 = this.f27453d;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f10});
            ofFloat.setDuration((long) (((float) 1000) * (Math.abs(f10 - f11) / 100.0f)));
            ofFloat.addUpdateListener(new b(this, ofFloat));
            j.f(ofFloat, "setProgressInternal$lambda$8");
            ofFloat.addListener(new e(function0, this));
            ofFloat.start();
            this.f27454e = ofFloat;
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void i(ProgressArcView progressArcView, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        j.g(progressArcView, "this$0");
        j.g(valueAnimator2, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        j.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        progressArcView.f27453d = ((Float) animatedValue).floatValue();
        progressArcView.invalidate();
    }

    public final void e() {
        ValueAnimator valueAnimator = this.f27456g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f27455f;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        h(25.0f, (Function0<Unit>) null);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new d(ofFloat, this));
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.start();
        this.f27455f = ofFloat;
    }

    public final void f(float f10, Function0<Unit> function0) {
        ValueAnimator valueAnimator = this.f27455f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        d();
        h(f10, function0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        float min = (this.f27451b * ((float) Math.min(getWidth(), getHeight()))) - (this.f27450a.getStrokeWidth() / ((float) 2));
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        canvas.drawArc(width - min, height - min, width + min, height + min, this.f27452c + this.f27457h, (this.f27453d * ((float) 360)) / 100.0f, false, this.f27450a);
    }

    public final void setStrokeColor(int i10) {
        this.f27450a.setColor(i10);
    }

    public final void setStrokeWidth(float f10) {
        this.f27450a.setStrokeWidth(f10);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressArcView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        Paint paint = new Paint(1);
        this.f27450a = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ProgressArcView, i10, 0);
        j.f(obtainStyledAttributes, "context.obtainStyledAttr…ArcView, defStyleAttr, 0)");
        try {
            this.f27451b = obtainStyledAttributes.getFloat(m.ProgressArcView_innerCircleSize, 0.4f);
            this.f27452c = obtainStyledAttributes.getFloat(m.ProgressArcView_startAngle, 270.0f);
            this.f27453d = obtainStyledAttributes.getFloat(m.ProgressArcView_progress, 0.0f);
            paint.setColor(obtainStyledAttributes.getColor(m.ProgressArcView_strokeColor, -1));
            paint.setStrokeWidth((float) obtainStyledAttributes.getDimensionPixelSize(m.ProgressArcView_strokeWidth, 4));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            obtainStyledAttributes.recycle();
            setWillNotDraw(false);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
