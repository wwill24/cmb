package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import bf.d;
import bf.f;
import bf.h;
import bf.l;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import qf.c;

class ClockFaceView extends d implements ClockHandView.c {
    /* access modifiers changed from: private */
    public final ClockHandView I;
    /* access modifiers changed from: private */
    public final Rect J;
    private final RectF K;
    private final Rect L;
    /* access modifiers changed from: private */
    public final SparseArray<TextView> M;
    private final androidx.core.view.a N;
    private final int[] O;
    private final float[] P;
    /* access modifiers changed from: private */
    public final int Q;
    private final int R;
    private final int S;
    private final int T;
    private String[] U;
    private float V;
    private final ColorStateList W;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.F(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.I.i()) - ClockFaceView.this.Q);
            return true;
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        public void g(View view, @NonNull k kVar) {
            super.g(view, kVar);
            int intValue = ((Integer) view.getTag(f.material_value_index)).intValue();
            if (intValue > 0) {
                kVar.z0((View) ClockFaceView.this.M.get(intValue - 1));
            }
            kVar.d0(k.c.a(0, 1, intValue, 1, false, view.isSelected()));
            kVar.b0(true);
            kVar.b(k.a.f4763i);
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.j(view, i10, bundle);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.J);
            long j10 = uptimeMillis;
            float centerX = (float) ClockFaceView.this.J.centerX();
            float centerY = (float) ClockFaceView.this.J.centerY();
            ClockFaceView.this.I.onTouchEvent(MotionEvent.obtain(uptimeMillis, j10, 0, centerX, centerY, 0));
            ClockFaceView.this.I.onTouchEvent(MotionEvent.obtain(uptimeMillis, j10, 1, centerX, centerY, 0));
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.materialClockStyle);
    }

    private void N() {
        boolean z10;
        RectF e10 = this.I.e();
        TextView P2 = P(e10);
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            TextView textView = this.M.get(i10);
            if (textView != null) {
                if (textView == P2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                textView.setSelected(z10);
                textView.getPaint().setShader(O(e10, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient O(RectF rectF, TextView textView) {
        textView.getHitRect(this.J);
        this.K.set(this.J);
        textView.getLineBounds(0, this.L);
        RectF rectF2 = this.K;
        Rect rect = this.L;
        rectF2.inset((float) rect.left, (float) rect.top);
        if (!RectF.intersects(rectF, this.K)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.K.left, rectF.centerY() - this.K.top, rectF.width() * 0.5f, this.O, this.P, Shader.TileMode.CLAMP);
    }

    private TextView P(RectF rectF) {
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            TextView textView2 = this.M.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(this.J);
                this.K.set(this.J);
                this.K.union(rectF);
                float width = this.K.width() * this.K.height();
                if (width < f10) {
                    textView = textView2;
                    f10 = width;
                }
            }
        }
        return textView;
    }

    private static float Q(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    private void S(int i10) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.M.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.U.length, size); i11++) {
            TextView textView = this.M.get(i11);
            if (i11 >= this.U.length) {
                removeView(textView);
                this.M.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(h.material_clockface_textview, this, false);
                    this.M.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.U[i11]);
                textView.setTag(f.material_value_index, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(f.material_clock_level, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                n0.s0(textView, this.N);
                textView.setTextColor(this.W);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, new Object[]{this.U[i11]}));
                }
            }
        }
        this.I.q(z10);
    }

    public void F(int i10) {
        if (i10 != E()) {
            super.F(i10);
            this.I.m(E());
        }
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            this.M.get(i10).setVisibility(0);
        }
    }

    public void R(String[] strArr, int i10) {
        this.U = strArr;
        S(i10);
    }

    public void a(float f10, boolean z10) {
        if (Math.abs(this.V - f10) > 0.001f) {
            this.V = f10;
            N();
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        k.C0(accessibilityNodeInfo).c0(k.b.a(1, this.U.length, false, 1));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        N();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int Q2 = (int) (((float) this.T) / Q(((float) this.R) / ((float) displayMetrics.heightPixels), ((float) this.S) / ((float) displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Q2, 1073741824);
        setMeasuredDimension(Q2, Q2);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.J = new Rect();
        this.K = new RectF();
        this.L = new Rect();
        this.M = new SparseArray<>();
        this.P = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockFaceView, i10, bf.k.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a10 = c.a(context, obtainStyledAttributes, l.ClockFaceView_clockNumberTextColor);
        this.W = a10;
        LayoutInflater.from(context).inflate(h.material_clockface_view, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.material_clock_hand);
        this.I = clockHandView;
        this.Q = resources.getDimensionPixelSize(d.material_clock_hand_padding);
        int colorForState = a10.getColorForState(new int[]{16842913}, a10.getDefaultColor());
        this.O = new int[]{colorForState, colorForState, a10.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = e.a.a(context, bf.c.material_timepicker_clockface).getDefaultColor();
        ColorStateList a11 = c.a(context, obtainStyledAttributes, l.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a11 != null ? a11.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.N = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        R(strArr, 0);
        this.R = resources.getDimensionPixelSize(d.material_time_picker_minimum_screen_height);
        this.S = resources.getDimensionPixelSize(d.material_time_picker_minimum_screen_width);
        this.T = resources.getDimensionPixelSize(d.material_clock_size);
    }
}
