package com.withpersona.sdk2.inquiry.selfie.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.selfie.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class CircleMaskView extends View {

    /* renamed from: f  reason: collision with root package name */
    public static final a f27443f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f27444a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27445b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f27446c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f27447d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f27448e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CircleMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircleMaskView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final long b(float f10) {
        return c.d((Math.abs(getScaleX() - f10) / 4.0f) * ((float) 500));
    }

    private final Bitmap c() {
        boolean z10;
        Bitmap bitmap = this.f27446c;
        if (bitmap != null) {
            if (bitmap.getWidth() == getWidth() && bitmap.getHeight() == getHeight()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                bitmap = null;
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(this.f27445b);
        canvas.drawCircle(((float) canvas.getWidth()) / 2.0f, ((float) canvas.getHeight()) / 2.0f, this.f27444a * ((float) Math.min(canvas.getWidth(), canvas.getHeight())), this.f27448e);
        this.f27446c = createBitmap;
        j.f(createBitmap, "createBitmap(\n      widt…}\n      mask = this\n    }");
        return createBitmap;
    }

    public static /* synthetic */ void e(CircleMaskView circleMaskView, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        circleMaskView.d(z10, function0);
    }

    /* access modifiers changed from: private */
    public static final void f(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void d(boolean z10, Function0<Unit> function0) {
        if (z10) {
            ViewPropertyAnimator animate = animate();
            animate.setDuration(b(1.0f));
            animate.scaleX(1.0f);
            animate.scaleY(1.0f);
            animate.withEndAction(new a(function0));
            animate.start();
            return;
        }
        getAnimation().cancel();
        setScaleX(1.0f);
        setScaleY(1.0f);
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean g() {
        if (!(getScaleX() == 5.0f)) {
            return true;
        }
        return !((getScaleY() > 5.0f ? 1 : (getScaleY() == 5.0f ? 0 : -1)) == 0);
    }

    public final void h() {
        boolean z10;
        boolean z11 = true;
        if (getScaleX() == 5.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (getScaleY() != 5.0f) {
                z11 = false;
            }
            if (z11) {
                return;
            }
        }
        ViewPropertyAnimator animate = animate();
        animate.setDuration(b(5.0f));
        animate.scaleX(5.0f);
        animate.scaleY(5.0f);
        animate.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        canvas.drawBitmap(c(), 0.0f, 0.0f, this.f27447d);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircleMaskView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f27447d = new Paint(7);
        Paint paint = new Paint(1);
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f27448e = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.CircleMaskView, i10, 0);
        j.f(obtainStyledAttributes, "context.obtainStyledAttr…askView, defStyleAttr, 0)");
        try {
            this.f27444a = obtainStyledAttributes.getFloat(m.CircleMaskView_circleSize, 0.4f);
            this.f27445b = obtainStyledAttributes.getColor(m.CircleMaskView_maskColor, -16777216);
            obtainStyledAttributes.recycle();
            setWillNotDraw(false);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
