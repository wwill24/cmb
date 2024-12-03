package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import bf.b;
import bf.k;
import tf.h;
import tf.n;

public class MaterialCardView extends CardView implements Checkable, n {

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f19384q = {16842911};

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f19385t = {16842912};

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f19386w = {b.state_dragged};

    /* renamed from: x  reason: collision with root package name */
    private static final int f19387x = k.Widget_MaterialComponents_CardView;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final b f19388k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19389l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19390m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19391n;

    /* renamed from: p  reason: collision with root package name */
    private a f19392p;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z10);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.materialCardViewStyle);
    }

    private void f() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f19388k.k();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f19388k.l().getBounds());
        return rectF;
    }

    public boolean g() {
        b bVar = this.f19388k;
        return bVar != null && bVar.F();
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f19388k.m();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f19388k.n();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f19388k.o();
    }

    public int getCheckedIconGravity() {
        return this.f19388k.p();
    }

    public int getCheckedIconMargin() {
        return this.f19388k.q();
    }

    public int getCheckedIconSize() {
        return this.f19388k.r();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f19388k.s();
    }

    public int getContentPaddingBottom() {
        return this.f19388k.C().bottom;
    }

    public int getContentPaddingLeft() {
        return this.f19388k.C().left;
    }

    public int getContentPaddingRight() {
        return this.f19388k.C().right;
    }

    public int getContentPaddingTop() {
        return this.f19388k.C().top;
    }

    public float getProgress() {
        return this.f19388k.w();
    }

    public float getRadius() {
        return this.f19388k.u();
    }

    public ColorStateList getRippleColor() {
        return this.f19388k.x();
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        return this.f19388k.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f19388k.z();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f19388k.A();
    }

    public int getStrokeWidth() {
        return this.f19388k.B();
    }

    public boolean h() {
        return this.f19391n;
    }

    /* access modifiers changed from: package-private */
    public void i(int i10, int i11, int i12, int i13) {
        super.d(i10, i11, i12, i13);
    }

    public boolean isChecked() {
        return this.f19390m;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f19388k.l());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (g()) {
            View.mergeDrawableStates(onCreateDrawableState, f19384q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f19385t);
        }
        if (h()) {
            View.mergeDrawableStates(onCreateDrawableState, f19386w);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f19388k.K(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f19389l) {
            if (!this.f19388k.E()) {
                this.f19388k.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i10) {
        this.f19388k.M(ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f19388k.h0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f19388k.N(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f19388k.O(z10);
    }

    public void setChecked(boolean z10) {
        if (this.f19390m != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f19388k.R(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.f19388k.p() != i10) {
            this.f19388k.S(i10);
        }
    }

    public void setCheckedIconMargin(int i10) {
        this.f19388k.T(i10);
    }

    public void setCheckedIconMarginResource(int i10) {
        if (i10 != -1) {
            this.f19388k.T(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(int i10) {
        this.f19388k.R(e.a.b(getContext(), i10));
    }

    public void setCheckedIconSize(int i10) {
        this.f19388k.U(i10);
    }

    public void setCheckedIconSizeResource(int i10) {
        if (i10 != 0) {
            this.f19388k.U(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f19388k.V(colorStateList);
    }

    public void setClickable(boolean z10) {
        super.setClickable(z10);
        b bVar = this.f19388k;
        if (bVar != null) {
            bVar.f0();
        }
    }

    public void setDragged(boolean z10) {
        if (this.f19391n != z10) {
            this.f19391n = z10;
            refreshDrawableState();
            f();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f19388k.j0();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f19392p = aVar;
    }

    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f19388k.j0();
        this.f19388k.g0();
    }

    public void setProgress(float f10) {
        this.f19388k.X(f10);
    }

    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f19388k.W(f10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f19388k.Y(colorStateList);
    }

    public void setRippleColorResource(int i10) {
        this.f19388k.Y(e.a.a(getContext(), i10));
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        setClipToOutline(kVar.u(getBoundsAsRectF()));
        this.f19388k.Z(kVar);
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(int i10) {
        this.f19388k.b0(i10);
        invalidate();
    }

    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f19388k.j0();
        this.f19388k.g0();
    }

    public void toggle() {
        if (g() && isEnabled()) {
            this.f19390m = !this.f19390m;
            refreshDrawableState();
            f();
            this.f19388k.Q(this.f19390m, true);
            a aVar = this.f19392p;
            if (aVar != null) {
                aVar.a(this, this.f19390m);
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = f19387x
            android.content.Context r8 = wf.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f19390m = r8
            r7.f19391n = r8
            r0 = 1
            r7.f19389l = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = bf.l.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.b r0 = new com.google.android.material.card.b
            r0.<init>(r7, r9, r10, r6)
            r7.f19388k = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.M(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.c0(r9, r10, r1, r2)
            r0.J(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f19388k.M(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f19388k.a0(colorStateList);
        invalidate();
    }
}
