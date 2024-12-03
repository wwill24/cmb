package com.appyvet.rangebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import net.bytebuddy.jar.asm.Opcodes;

public class RangeBar extends View {
    private int B = (((int) ((5.0f - 0.0f) / 1.0f)) + 1);
    private c C;
    private c D;
    private a E;
    private b F;
    private d G;
    private e H;
    private HashMap<Float, String> I;
    private int J;
    private int K;
    private boolean L = true;
    /* access modifiers changed from: private */
    public float M = 16.0f;
    private float N = 24.0f;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private float U;
    private float V;
    private e3.a W;

    /* renamed from: a  reason: collision with root package name */
    private float f9074a = 1.0f;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f9075a0 = true;

    /* renamed from: b  reason: collision with root package name */
    private float f9076b = 0.0f;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f9077b0 = true;

    /* renamed from: c  reason: collision with root package name */
    private float f9078c = 5.0f;

    /* renamed from: c0  reason: collision with root package name */
    private f f9079c0 = new a();

    /* renamed from: d  reason: collision with root package name */
    private float f9080d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f9081e = 2.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f9082f = -3355444;

    /* renamed from: g  reason: collision with root package name */
    private int f9083g = -12627531;

    /* renamed from: h  reason: collision with root package name */
    private int f9084h = -1;

    /* renamed from: j  reason: collision with root package name */
    private float f9085j = 4.0f;

    /* renamed from: k  reason: collision with root package name */
    private int f9086k = -12627531;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f9087l = 12.0f;

    /* renamed from: m  reason: collision with root package name */
    private int f9088m = -16777216;

    /* renamed from: n  reason: collision with root package name */
    private float f9089n = 12.0f;

    /* renamed from: p  reason: collision with root package name */
    private int f9090p = -12627531;

    /* renamed from: q  reason: collision with root package name */
    private float f9091q = 5.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f9092t = 8.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f9093w = 24.0f;

    /* renamed from: x  reason: collision with root package name */
    private boolean f9094x = true;

    /* renamed from: y  reason: collision with root package name */
    private int f9095y = 500;

    /* renamed from: z  reason: collision with root package name */
    private int f9096z = Opcodes.FCMPG;

    class a implements f {
        a() {
        }

        public String a(String str) {
            if (str.length() > 4) {
                return str.substring(0, 4);
            }
            return str;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f9098a;

        b(c cVar) {
            this.f9098a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = RangeBar.this.f9087l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f9098a.g(RangeBar.this.f9087l, RangeBar.this.M * valueAnimator.getAnimatedFraction());
            RangeBar.this.invalidate();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f9100a;

        c(c cVar) {
            this.f9100a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = RangeBar.this.f9087l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f9100a.g(RangeBar.this.f9087l, RangeBar.this.M - (RangeBar.this.M * valueAnimator.getAnimatedFraction()));
            RangeBar.this.invalidate();
        }
    }

    public interface d {
        void a(RangeBar rangeBar, int i10, int i11, String str, String str2);
    }

    public interface e {
        String a(RangeBar rangeBar, int i10);
    }

    public interface f {
        String a(String str);
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o(context, attributeSet);
    }

    private void d() {
        this.E = new a(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.B, this.f9074a, this.f9088m, this.f9081e, this.f9082f);
        invalidate();
    }

    private void e() {
        this.F = new b(getContext(), getYPos(), this.f9085j, this.f9086k);
        invalidate();
    }

    private void f() {
        Context context = getContext();
        float yPos = getYPos();
        if (this.L) {
            c cVar = new c(context);
            this.C = cVar;
            cVar.b(context, yPos, 0.0f, this.f9083g, this.f9084h, this.f9091q, this.f9090p, this.f9092t, this.f9093w, false);
        }
        c cVar2 = new c(context);
        this.D = cVar2;
        cVar2.b(context, yPos, 0.0f, this.f9083g, this.f9084h, this.f9091q, this.f9090p, this.f9092t, this.f9093w, false);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        if (this.L) {
            this.C.setX(((((float) this.J) / ((float) (this.B - 1))) * barLength) + marginLeft);
            this.C.h(g(this.J));
        }
        this.D.setX(marginLeft + ((((float) this.K) / ((float) (this.B - 1))) * barLength));
        this.D.h(g(this.K));
        invalidate();
    }

    private String g(int i10) {
        float f10;
        e eVar = this.H;
        if (eVar != null) {
            return eVar.a(this, i10);
        }
        if (i10 == this.B - 1) {
            f10 = this.f9078c;
        } else {
            f10 = (((float) i10) * this.f9080d) + this.f9076b;
        }
        String str = this.I.get(Float.valueOf(f10));
        if (str == null) {
            double d10 = (double) f10;
            if (d10 == Math.ceil(d10)) {
                str = String.valueOf((int) f10);
            } else {
                str = String.valueOf(f10);
            }
        }
        return this.f9079c0.a(str);
    }

    private float getBarLength() {
        return ((float) getWidth()) - (getMarginLeft() * 2.0f);
    }

    private float getMarginLeft() {
        return Math.max(this.f9089n, this.f9091q);
    }

    private float getYPos() {
        return ((float) getHeight()) - this.N;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h(int r2, int r3) {
        /*
            r1 = this;
            if (r2 < 0) goto L_0x000d
            int r0 = r1.B
            if (r2 >= r0) goto L_0x000d
            if (r3 < 0) goto L_0x000d
            if (r3 < r0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r2 = 0
            goto L_0x000e
        L_0x000d:
            r2 = 1
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appyvet.rangebar.RangeBar.h(int, int):boolean");
    }

    private boolean i(int i10) {
        return i10 > 1;
    }

    private void j(c cVar, float f10) {
        if (f10 >= this.E.c() && f10 <= this.E.f() && cVar != null) {
            cVar.setX(f10);
            invalidate();
        }
    }

    private void k(float f10, float f11) {
        if (this.L) {
            if (!this.D.isPressed() && this.C.c(f10, f11)) {
                n(this.C);
            } else if (!this.C.isPressed() && this.D.c(f10, f11)) {
                n(this.D);
            }
        } else if (this.D.c(f10, f11)) {
            n(this.D);
        }
    }

    private void l(float f10) {
        int i10;
        if (this.L && this.C.isPressed()) {
            j(this.C, f10);
        } else if (this.D.isPressed()) {
            j(this.D, f10);
        }
        if (this.L && this.C.getX() > this.D.getX()) {
            c cVar = this.C;
            this.C = this.D;
            this.D = cVar;
        }
        int i11 = 0;
        if (this.L) {
            i10 = this.E.e(this.C);
        } else {
            i10 = 0;
        }
        int e10 = this.E.e(this.D);
        int left = getLeft() + getPaddingLeft();
        int right = (getRight() - getPaddingRight()) - left;
        if (f10 <= ((float) left)) {
            j(this.C, this.E.c());
        } else {
            if (f10 >= ((float) right)) {
                e10 = getTickCount() - 1;
                j(this.D, this.E.f());
            }
            i11 = i10;
        }
        if (i11 != this.J || e10 != this.K) {
            this.J = i11;
            this.K = e10;
            if (this.L) {
                this.C.h(g(i11));
            }
            this.D.h(g(this.K));
            d dVar = this.G;
            if (dVar != null) {
                int i12 = this.J;
                dVar.a(this, i12, this.K, g(i12), g(this.K));
            }
        }
    }

    private void m(float f10, float f11) {
        float f12;
        int i10;
        if (this.L && this.C.isPressed()) {
            p(this.C);
        } else if (this.D.isPressed()) {
            p(this.D);
        } else {
            if (this.L) {
                f12 = Math.abs(this.C.getX() - f10);
            } else {
                f12 = 0.0f;
            }
            if (f12 >= Math.abs(this.D.getX() - f10)) {
                this.D.setX(f10);
                p(this.D);
            } else if (this.L) {
                this.C.setX(f10);
                p(this.C);
            }
            if (this.L) {
                i10 = this.E.e(this.C);
            } else {
                i10 = 0;
            }
            int i11 = i10;
            int e10 = this.E.e(this.D);
            if (i11 != this.J || e10 != this.K) {
                this.J = i11;
                this.K = e10;
                d dVar = this.G;
                if (dVar != null) {
                    dVar.a(this, i11, e10, g(i11), g(this.K));
                }
            }
        }
    }

    private void n(c cVar) {
        if (this.f9094x) {
            this.f9094x = false;
        }
        if (this.f9077b0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f9089n});
            ofFloat.addUpdateListener(new b(cVar));
            ofFloat.start();
        }
        cVar.d();
    }

    private void o(Context context, AttributeSet attributeSet) {
        if (this.I == null) {
            this.I = new HashMap<>();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e3.c.RangeBar, 0, 0);
        try {
            float f10 = obtainStyledAttributes.getFloat(e3.c.RangeBar_tickStart, 0.0f);
            float f11 = obtainStyledAttributes.getFloat(e3.c.RangeBar_tickEnd, 5.0f);
            float f12 = obtainStyledAttributes.getFloat(e3.c.RangeBar_tickInterval, 1.0f);
            int i10 = ((int) ((f11 - f10) / f12)) + 1;
            if (i(i10)) {
                this.B = i10;
                this.f9076b = f10;
                this.f9078c = f11;
                this.f9080d = f12;
                this.J = 0;
                int i11 = i10 - 1;
                this.K = i11;
                d dVar = this.G;
                if (dVar != null) {
                    dVar.a(this, 0, i11, g(0), g(this.K));
                }
            }
            this.f9074a = obtainStyledAttributes.getDimension(e3.c.RangeBar_tickHeight, 1.0f);
            this.f9081e = obtainStyledAttributes.getDimension(e3.c.RangeBar_barWeight, 2.0f);
            this.f9082f = obtainStyledAttributes.getColor(e3.c.RangeBar_rangeBarColor, -3355444);
            this.f9084h = obtainStyledAttributes.getColor(e3.c.RangeBar_textColor, -1);
            this.f9083g = obtainStyledAttributes.getColor(e3.c.RangeBar_pinColor, -12627531);
            this.P = this.f9082f;
            this.f9091q = obtainStyledAttributes.getDimension(e3.c.RangeBar_selectorSize, TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()));
            int color = obtainStyledAttributes.getColor(e3.c.RangeBar_selectorColor, -12627531);
            this.f9090p = color;
            this.R = color;
            int color2 = obtainStyledAttributes.getColor(e3.c.RangeBar_tickColor, -16777216);
            this.f9088m = color2;
            this.Q = color2;
            this.f9085j = obtainStyledAttributes.getDimension(e3.c.RangeBar_connectingLineWeight, 4.0f);
            int color3 = obtainStyledAttributes.getColor(e3.c.RangeBar_connectingLineColor, -12627531);
            this.f9086k = color3;
            this.O = color3;
            this.f9089n = obtainStyledAttributes.getDimension(e3.c.RangeBar_pinRadius, TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics()));
            this.M = obtainStyledAttributes.getDimension(e3.c.RangeBar_pinPadding, TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
            this.N = obtainStyledAttributes.getDimension(e3.c.RangeBar_rangeBarPaddingBottom, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
            int i12 = e3.c.RangeBar_rangeBar;
            this.L = obtainStyledAttributes.getBoolean(i12, true);
            this.f9077b0 = obtainStyledAttributes.getBoolean(e3.c.RangeBar_temporaryPins, true);
            float f13 = getResources().getDisplayMetrics().density;
            this.f9092t = obtainStyledAttributes.getDimension(e3.c.RangeBar_pinMinFont, 8.0f * f13);
            this.f9093w = obtainStyledAttributes.getDimension(e3.c.RangeBar_pinMaxFont, f13 * 24.0f);
            this.L = obtainStyledAttributes.getBoolean(i12, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void p(c cVar) {
        cVar.setX(this.E.d(cVar));
        cVar.h(g(this.E.e(cVar)));
        if (this.f9077b0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f9089n, 0.0f});
            ofFloat.addUpdateListener(new c(cVar));
            ofFloat.start();
        } else {
            invalidate();
        }
        cVar.e();
    }

    private boolean s(float f10, float f11) {
        float f12 = this.f9076b;
        if (f10 >= f12) {
            float f13 = this.f9078c;
            return f10 > f13 || f11 < f12 || f11 > f13;
        }
    }

    public int getLeftIndex() {
        return this.J;
    }

    public String getLeftPinValue() {
        return g(this.J);
    }

    public int getRightIndex() {
        return this.K;
    }

    public String getRightPinValue() {
        return g(this.K);
    }

    public int getTickCount() {
        return this.B;
    }

    public float getTickEnd() {
        return this.f9078c;
    }

    public double getTickInterval() {
        return (double) this.f9080d;
    }

    public float getTickStart() {
        return this.f9076b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.E.a(canvas);
        if (this.L) {
            this.F.b(canvas, this.C, this.D);
            if (this.f9075a0) {
                this.E.b(canvas);
            }
            this.C.draw(canvas);
        } else {
            this.F.a(canvas, getMarginLeft(), this.D);
            if (this.f9075a0) {
                this.E.b(canvas);
            }
        }
        this.D.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (!(mode == Integer.MIN_VALUE || mode == 1073741824)) {
            size = this.f9095y;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.f9096z, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.f9096z;
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.B = bundle.getInt("TICK_COUNT");
            this.f9076b = bundle.getFloat("TICK_START");
            this.f9078c = bundle.getFloat("TICK_END");
            this.f9080d = bundle.getFloat("TICK_INTERVAL");
            this.f9088m = bundle.getInt("TICK_COLOR");
            this.f9074a = bundle.getFloat("TICK_HEIGHT_DP");
            this.f9081e = bundle.getFloat("BAR_WEIGHT");
            this.f9082f = bundle.getInt("BAR_COLOR");
            this.f9091q = bundle.getFloat("CIRCLE_SIZE");
            this.f9090p = bundle.getInt("CIRCLE_COLOR");
            this.f9085j = bundle.getFloat("CONNECTING_LINE_WEIGHT");
            this.f9086k = bundle.getInt("CONNECTING_LINE_COLOR");
            this.f9087l = bundle.getFloat("THUMB_RADIUS_DP");
            this.f9089n = bundle.getFloat("EXPANDED_PIN_RADIUS_DP");
            this.M = bundle.getFloat("PIN_PADDING");
            this.N = bundle.getFloat("BAR_PADDING_BOTTOM");
            this.L = bundle.getBoolean("IS_RANGE_BAR");
            this.f9077b0 = bundle.getBoolean("ARE_PINS_TEMPORARY");
            this.J = bundle.getInt("LEFT_INDEX");
            this.K = bundle.getInt("RIGHT_INDEX");
            this.f9094x = bundle.getBoolean("FIRST_SET_TICK_COUNT");
            this.f9092t = bundle.getFloat("MIN_PIN_FONT");
            this.f9093w = bundle.getFloat("MAX_PIN_FONT");
            q(this.J, this.K);
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.B);
        bundle.putFloat("TICK_START", this.f9076b);
        bundle.putFloat("TICK_END", this.f9078c);
        bundle.putFloat("TICK_INTERVAL", this.f9080d);
        bundle.putInt("TICK_COLOR", this.f9088m);
        bundle.putFloat("TICK_HEIGHT_DP", this.f9074a);
        bundle.putFloat("BAR_WEIGHT", this.f9081e);
        bundle.putInt("BAR_COLOR", this.f9082f);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.f9085j);
        bundle.putInt("CONNECTING_LINE_COLOR", this.f9086k);
        bundle.putFloat("CIRCLE_SIZE", this.f9091q);
        bundle.putInt("CIRCLE_COLOR", this.f9090p);
        bundle.putFloat("THUMB_RADIUS_DP", this.f9087l);
        bundle.putFloat("EXPANDED_PIN_RADIUS_DP", this.f9089n);
        bundle.putFloat("PIN_PADDING", this.M);
        bundle.putFloat("BAR_PADDING_BOTTOM", this.N);
        bundle.putBoolean("IS_RANGE_BAR", this.L);
        bundle.putBoolean("ARE_PINS_TEMPORARY", this.f9077b0);
        bundle.putInt("LEFT_INDEX", this.J);
        bundle.putInt("RIGHT_INDEX", this.K);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.f9094x);
        bundle.putFloat("MIN_PIN_FONT", this.f9092t);
        bundle.putFloat("MAX_PIN_FONT", this.f9093w);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        d dVar;
        super.onSizeChanged(i10, i11, i12, i13);
        Context context = getContext();
        float f10 = this.f9089n / getResources().getDisplayMetrics().density;
        float f11 = ((float) i11) - this.N;
        if (this.L) {
            c cVar = new c(context);
            this.C = cVar;
            cVar.f(this.W);
            this.C.b(context, f11, f10, this.f9083g, this.f9084h, this.f9091q, this.f9090p, this.f9092t, this.f9093w, this.f9077b0);
        }
        c cVar2 = new c(context);
        this.D = cVar2;
        cVar2.f(this.W);
        Context context2 = context;
        this.D.b(context2, f11, f10, this.f9083g, this.f9084h, this.f9091q, this.f9090p, this.f9092t, this.f9093w, this.f9077b0);
        float max = Math.max(this.f9089n, this.f9091q);
        float f12 = ((float) i10) - (2.0f * max);
        this.E = new a(context2, max, f11, f12, this.B, this.f9074a, this.f9088m, this.f9081e, this.f9082f);
        if (this.L) {
            this.C.setX(((((float) this.J) / ((float) (this.B - 1))) * f12) + max);
            this.C.h(g(this.J));
        }
        this.D.setX(max + ((((float) this.K) / ((float) (this.B - 1))) * f12));
        this.D.h(g(this.K));
        if (this.L) {
            i14 = this.E.e(this.C);
        } else {
            i14 = 0;
        }
        int e10 = this.E.e(this.D);
        int i15 = this.J;
        if (!((i14 == i15 && e10 == this.K) || (dVar = this.G) == null)) {
            dVar.a(this, i15, this.K, g(i15), g(this.K));
        }
        this.F = new b(context, f11, this.f9085j, this.f9086k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.S = 0;
            this.T = 0;
            this.U = motionEvent.getX();
            this.V = motionEvent.getY();
            k(motionEvent.getX(), motionEvent.getY());
            return true;
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            m(motionEvent.getX(), motionEvent.getY());
            return true;
        } else if (action == 2) {
            l(motionEvent.getX());
            getParent().requestDisallowInterceptTouchEvent(true);
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.S = (int) (((float) this.S) + Math.abs(x10 - this.U));
            int abs = (int) (((float) this.T) + Math.abs(y10 - this.V));
            this.T = abs;
            this.U = x10;
            this.V = y10;
            if (this.S >= abs) {
                return true;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        } else if (action != 3) {
            return false;
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
            m(motionEvent.getX(), motionEvent.getY());
            return true;
        }
    }

    public void q(int i10, int i11) {
        if (!h(i10, i11)) {
            if (this.f9094x) {
                this.f9094x = false;
            }
            this.J = i10;
            this.K = i11;
            f();
            d dVar = this.G;
            if (dVar != null) {
                int i12 = this.J;
                dVar.a(this, i12, this.K, g(i12), g(this.K));
            }
            invalidate();
            requestLayout();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Pin index left ");
        sb2.append(i10);
        sb2.append(", or right ");
        sb2.append(i11);
        sb2.append(" is out of bounds. Check that it is greater than the minimum (");
        sb2.append(this.f9076b);
        sb2.append(") and less than the maximum value (");
        sb2.append(this.f9078c);
        sb2.append(")");
        throw new IllegalArgumentException("Pin index left " + i10 + ", or right " + i11 + " is out of bounds. Check that it is greater than the minimum (" + this.f9076b + ") and less than the maximum value (" + this.f9078c + ")");
    }

    public void r(float f10, float f11) {
        if (!s(f10, f11)) {
            if (this.f9094x) {
                this.f9094x = false;
            }
            float f12 = this.f9076b;
            float f13 = this.f9080d;
            this.J = (int) ((f10 - f12) / f13);
            this.K = (int) ((f11 - f12) / f13);
            f();
            d dVar = this.G;
            if (dVar != null) {
                int i10 = this.J;
                dVar.a(this, i10, this.K, g(i10), g(this.K));
            }
            invalidate();
            requestLayout();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Pin value left ");
        sb2.append(f10);
        sb2.append(", or right ");
        sb2.append(f11);
        sb2.append(" is out of bounds. Check that it is greater than the minimum (");
        sb2.append(this.f9076b);
        sb2.append(") and less than the maximum value (");
        sb2.append(this.f9078c);
        sb2.append(")");
        throw new IllegalArgumentException("Pin value left " + f10 + ", or right " + f11 + " is out of bounds. Check that it is greater than the minimum (" + this.f9076b + ") and less than the maximum value (" + this.f9078c + ")");
    }

    public void setBarColor(int i10) {
        this.f9082f = i10;
        d();
    }

    public void setBarWeight(float f10) {
        this.f9081e = f10;
        d();
    }

    public void setConnectingLineColor(int i10) {
        this.f9086k = i10;
        e();
    }

    public void setConnectingLineWeight(float f10) {
        this.f9085j = f10;
        e();
    }

    public void setDrawTicks(boolean z10) {
        this.f9075a0 = z10;
    }

    public void setEnabled(boolean z10) {
        if (!z10) {
            this.f9082f = -3355444;
            this.f9086k = -3355444;
            this.f9090p = -3355444;
            this.f9088m = -3355444;
        } else {
            this.f9082f = this.P;
            this.f9086k = this.O;
            this.f9090p = this.R;
            this.f9088m = this.Q;
        }
        d();
        f();
        e();
        super.setEnabled(z10);
    }

    public void setFormatter(e3.a aVar) {
        c cVar = this.C;
        if (cVar != null) {
            cVar.f(aVar);
        }
        c cVar2 = this.D;
        if (cVar2 != null) {
            cVar2.f(aVar);
        }
        this.W = aVar;
    }

    public void setOnRangeBarChangeListener(d dVar) {
        this.G = dVar;
    }

    public void setPinColor(int i10) {
        this.f9083g = i10;
        f();
    }

    public void setPinRadius(float f10) {
        this.f9089n = f10;
        f();
    }

    public void setPinTextColor(int i10) {
        this.f9084h = i10;
        f();
    }

    public void setPinTextFormatter(f fVar) {
        this.f9079c0 = fVar;
    }

    public void setPinTextListener(e eVar) {
        this.H = eVar;
    }

    public void setRangeBarEnabled(boolean z10) {
        this.L = z10;
        invalidate();
    }

    public void setSeekPinByIndex(int i10) {
        if (i10 < 0 || i10 > this.B) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pin index ");
            sb2.append(i10);
            sb2.append(" is out of bounds. Check that it is greater than the minimum (");
            sb2.append(0);
            sb2.append(") and less than the maximum value (");
            sb2.append(this.B);
            sb2.append(")");
            throw new IllegalArgumentException("Pin index " + i10 + " is out of bounds. Check that it is greater than the minimum (" + 0 + ") and less than the maximum value (" + this.B + ")");
        }
        if (this.f9094x) {
            this.f9094x = false;
        }
        this.K = i10;
        f();
        d dVar = this.G;
        if (dVar != null) {
            int i11 = this.J;
            dVar.a(this, i11, this.K, g(i11), g(this.K));
        }
        invalidate();
        requestLayout();
    }

    public void setSeekPinByValue(float f10) {
        if (f10 <= this.f9078c) {
            float f11 = this.f9076b;
            if (f10 >= f11) {
                if (this.f9094x) {
                    this.f9094x = false;
                }
                this.K = (int) ((f10 - f11) / this.f9080d);
                f();
                d dVar = this.G;
                if (dVar != null) {
                    int i10 = this.J;
                    dVar.a(this, i10, this.K, g(i10), g(this.K));
                }
                invalidate();
                requestLayout();
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Pin value ");
        sb2.append(f10);
        sb2.append(" is out of bounds. Check that it is greater than the minimum (");
        sb2.append(this.f9076b);
        sb2.append(") and less than the maximum value (");
        sb2.append(this.f9078c);
        sb2.append(")");
        throw new IllegalArgumentException("Pin value " + f10 + " is out of bounds. Check that it is greater than the minimum (" + this.f9076b + ") and less than the maximum value (" + this.f9078c + ")");
    }

    public void setSelectorColor(int i10) {
        this.f9090p = i10;
        f();
    }

    public void setTemporaryPins(boolean z10) {
        this.f9077b0 = z10;
        invalidate();
    }

    public void setTickColor(int i10) {
        this.f9088m = i10;
        d();
    }

    public void setTickEnd(float f10) {
        int i10 = ((int) ((f10 - this.f9076b) / this.f9080d)) + 1;
        if (i(i10)) {
            this.B = i10;
            this.f9078c = f10;
            if (this.f9094x) {
                this.J = 0;
                int i11 = i10 - 1;
                this.K = i11;
                d dVar = this.G;
                if (dVar != null) {
                    dVar.a(this, 0, i11, g(0), g(this.K));
                }
            }
            if (h(this.J, this.K)) {
                this.J = 0;
                int i12 = this.B - 1;
                this.K = i12;
                d dVar2 = this.G;
                if (dVar2 != null) {
                    dVar2.a(this, 0, i12, g(0), g(this.K));
                }
            }
            d();
            f();
            return;
        }
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }

    public void setTickHeight(float f10) {
        this.f9074a = f10;
        d();
    }

    public void setTickInterval(float f10) {
        int i10 = ((int) ((this.f9078c - this.f9076b) / f10)) + 1;
        if (i(i10)) {
            this.B = i10;
            this.f9080d = f10;
            if (this.f9094x) {
                this.J = 0;
                int i11 = i10 - 1;
                this.K = i11;
                d dVar = this.G;
                if (dVar != null) {
                    dVar.a(this, 0, i11, g(0), g(this.K));
                }
            }
            if (h(this.J, this.K)) {
                this.J = 0;
                int i12 = this.B - 1;
                this.K = i12;
                d dVar2 = this.G;
                if (dVar2 != null) {
                    dVar2.a(this, 0, i12, g(0), g(this.K));
                }
            }
            d();
            f();
            return;
        }
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }

    public void setTickStart(float f10) {
        int i10 = ((int) ((this.f9078c - f10) / this.f9080d)) + 1;
        if (i(i10)) {
            this.B = i10;
            this.f9076b = f10;
            if (this.f9094x) {
                this.J = 0;
                int i11 = i10 - 1;
                this.K = i11;
                d dVar = this.G;
                if (dVar != null) {
                    dVar.a(this, 0, i11, g(0), g(this.K));
                }
            }
            if (h(this.J, this.K)) {
                this.J = 0;
                int i12 = this.B - 1;
                this.K = i12;
                d dVar2 = this.G;
                if (dVar2 != null) {
                    dVar2.a(this, 0, i12, g(0), g(this.K));
                }
            }
            d();
            f();
            return;
        }
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }
}
