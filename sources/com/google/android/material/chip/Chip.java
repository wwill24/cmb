package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import bf.j;
import bf.l;
import cf.h;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.material.chip.a;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.internal.r;
import com.leanplum.internal.Constants;
import java.util.List;
import qf.d;
import qf.f;
import tf.n;

public class Chip extends AppCompatCheckBox implements a.C0234a, n, k<Chip> {
    private static final int E = bf.k.Widget_MaterialComponents_Chip_Action;
    /* access modifiers changed from: private */
    public static final Rect F = new Rect();
    private static final int[] G = {16842913};
    private static final int[] H = {16842911};
    private final Rect B;
    private final RectF C;
    private final f D;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f19439e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f19440f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f19441g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f19442h;

    /* renamed from: j  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f19443j;

    /* renamed from: k  reason: collision with root package name */
    private k.a<Chip> f19444k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19445l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19446m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19447n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f19448p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19449q;

    /* renamed from: t  reason: collision with root package name */
    private int f19450t;

    /* renamed from: w  reason: collision with root package name */
    private int f19451w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f19452x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    private final c f19453y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f19454z;

    class a extends f {
        a() {
        }

        public void a(int i10) {
        }

        public void b(@NonNull Typeface typeface, boolean z10) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            if (chip.f19439e.Q2()) {
                charSequence = Chip.this.f19439e.l1();
            } else {
                charSequence = Chip.this.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.f19439e != null) {
                Chip.this.f19439e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends z0.a {
        c(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int B(float f10, float f11) {
            return (!Chip.this.n() || !Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 0 : 1;
        }

        /* access modifiers changed from: protected */
        public void C(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f19442h != null) {
                list.add(1);
            }
        }

        /* access modifiers changed from: protected */
        public boolean J(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.u();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void M(@NonNull androidx.core.view.accessibility.k kVar) {
            kVar.Y(Chip.this.r());
            kVar.b0(Chip.this.isClickable());
            kVar.a0(Chip.this.getAccessibilityClassName());
            kVar.y0(Chip.this.getText());
        }

        /* access modifiers changed from: protected */
        public void N(int i10, @NonNull androidx.core.view.accessibility.k kVar) {
            CharSequence charSequence = "";
            if (i10 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    kVar.e0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i11 = j.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    kVar.e0(context.getString(i11, objArr).trim());
                }
                kVar.W(Chip.this.getCloseIconTouchBoundsInt());
                kVar.b(k.a.f4763i);
                kVar.g0(Chip.this.isEnabled());
                return;
            }
            kVar.e0(charSequence);
            kVar.W(Chip.F);
        }

        /* access modifiers changed from: protected */
        public void O(int i10, boolean z10) {
            if (i10 == 1) {
                boolean unused = Chip.this.f19448p = z10;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.chipStyle);
    }

    private void A() {
        this.f19441g = new RippleDrawable(rf.b.d(this.f19439e.j1()), getBackgroundDrawable(), (Drawable) null);
        this.f19439e.P2(false);
        n0.w0(this, this.f19441g);
        B();
    }

    private void B() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f19439e) != null) {
            int N0 = (int) (aVar.N0() + this.f19439e.n1() + this.f19439e.u0());
            int S0 = (int) (this.f19439e.S0() + this.f19439e.o1() + this.f19439e.q0());
            if (this.f19440f != null) {
                Rect rect = new Rect();
                this.f19440f.getPadding(rect);
                S0 += rect.left;
                N0 += rect.right;
            }
            n0.I0(this, S0, getPaddingTop(), N0, getPaddingBottom());
        }
    }

    private void C() {
        TextPaint paint = getPaint();
        a aVar = this.f19439e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.D);
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Constants.Params.BACKGROUND);
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
            } else {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.C.setEmpty();
        if (n() && this.f19442h != null) {
            this.f19439e.c1(this.C);
        }
        return this.C;
    }

    /* access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.B.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.B;
    }

    private d getTextAppearance() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.m1();
        }
        return null;
    }

    private void j(@NonNull a aVar) {
        aVar.t2(this);
    }

    @NonNull
    private int[] k() {
        int isEnabled = isEnabled();
        if (this.f19448p) {
            isEnabled++;
        }
        if (this.f19447n) {
            isEnabled++;
        }
        if (this.f19446m) {
            isEnabled++;
        }
        if (isChecked()) {
            isEnabled++;
        }
        int[] iArr = new int[isEnabled];
        int i10 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i10 = 1;
        }
        if (this.f19448p) {
            iArr[i10] = 16842908;
            i10++;
        }
        if (this.f19447n) {
            iArr[i10] = 16843623;
            i10++;
        }
        if (this.f19446m) {
            iArr[i10] = 16842919;
            i10++;
        }
        if (isChecked()) {
            iArr[i10] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f19440f && this.f19439e.getCallback() == null) {
            this.f19439e.setCallback(this.f19440f);
        }
    }

    /* access modifiers changed from: private */
    public boolean n() {
        a aVar = this.f19439e;
        return (aVar == null || aVar.V0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i10) {
        TypedArray i11 = p.i(context, attributeSet, l.Chip, i10, E, new int[0]);
        this.f19449q = i11.getBoolean(l.Chip_ensureMinTouchTargetSize, false);
        this.f19451w = (int) Math.ceil((double) i11.getDimension(l.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) r.c(getContext(), 48))));
        i11.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i10, int i11, int i12, int i13) {
        this.f19440f = new InsetDrawable(this.f19439e, i10, i11, i12, i13);
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f19447n != z10) {
            this.f19447n = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f19446m != z10) {
            this.f19446m = z10;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton compoundButton, boolean z10) {
        k.a<Chip> aVar = this.f19444k;
        if (aVar != null) {
            aVar.a(this, z10);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f19443j;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    private void v() {
        if (this.f19440f != null) {
            this.f19440f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(a aVar) {
        if (aVar != null) {
            aVar.t2((a.C0234a) null);
        }
    }

    private void y() {
        if (!n() || !s() || this.f19442h == null) {
            n0.s0(this, (androidx.core.view.a) null);
            this.f19454z = false;
            return;
        }
        n0.s0(this, this.f19453y);
        this.f19454z = true;
    }

    private void z() {
        if (rf.b.f24443a) {
            A();
            return;
        }
        this.f19439e.P2(true);
        n0.w0(this, getBackgroundDrawable());
        B();
        m();
    }

    public void a() {
        l(this.f19451w);
        requestLayout();
        invalidateOutline();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f19454z) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (this.f19453y.v(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f19454z) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f19453y.w(keyEvent) || this.f19453y.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        a aVar = this.f19439e;
        if (aVar == null || !aVar.t1()) {
            z10 = false;
        } else {
            z10 = this.f19439e.p2(k());
        }
        if (z10) {
            invalidate();
        }
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f19452x)) {
            return this.f19452x;
        }
        if (r()) {
            ViewParent parent = getParent();
            if (!(parent instanceof ChipGroup) || !((ChipGroup) parent).i()) {
                return "android.widget.Button";
            }
            return "android.widget.RadioButton";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return "android.view.View";
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f19440f;
        if (insetDrawable == null) {
            return this.f19439e;
        }
        return insetDrawable;
    }

    public Drawable getCheckedIcon() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.J0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.M0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f19439e;
    }

    public float getChipEndPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.N0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public float getChipIconSize() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.Q0();
        }
        return null;
    }

    public float getChipMinHeight() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.S0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.U0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public void getFocusedRect(@NonNull Rect rect) {
        if (!this.f19454z || !(this.f19453y.A() == 1 || this.f19453y.x() == 1)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(getCloseIconTouchBoundsInt());
        }
    }

    public h getHideMotionSpec() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.g1();
        }
        return null;
    }

    public float getIconEndPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.i1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        return this.f19439e.E();
    }

    public h getShowMotionSpec() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.k1();
        }
        return null;
    }

    public float getTextEndPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.n1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        a aVar = this.f19439e;
        if (aVar != null) {
            return aVar.o1();
        }
        return 0.0f;
    }

    public boolean l(int i10) {
        int i11;
        this.f19451w = i10;
        int i12 = 0;
        if (!w()) {
            if (this.f19440f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int max = Math.max(0, i10 - this.f19439e.getIntrinsicHeight());
        int max2 = Math.max(0, i10 - this.f19439e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            if (max2 > 0) {
                i11 = max2 / 2;
            } else {
                i11 = 0;
            }
            if (max > 0) {
                i12 = max / 2;
            }
            if (this.f19440f != null) {
                Rect rect = new Rect();
                this.f19440f.getPadding(rect);
                if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                    z();
                    return true;
                }
            }
            if (getMinHeight() != i10) {
                setMinHeight(i10);
            }
            if (getMinWidth() != i10) {
                setMinWidth(i10);
            }
            q(i11, i12, i11, i12);
            z();
            return true;
        }
        if (this.f19440f != null) {
            v();
        } else {
            z();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tf.h.f(this, this.f19439e);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        if (r()) {
            View.mergeDrawableStates(onCreateDrawableState, H);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f19454z) {
            this.f19453y.I(z10, i10, rect);
        }
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            androidx.core.view.accessibility.k C0 = androidx.core.view.accessibility.k.C0(accessibilityNodeInfo);
            if (chipGroup.c()) {
                i10 = chipGroup.g(this);
            } else {
                i10 = -1;
            }
            C0.d0(k.c.a(chipGroup.b(this), 1, i10, 1, false, isChecked()));
        }
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i10) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), CloseCodes.PROTOCOL_ERROR);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f19450t != i10) {
            this.f19450t = i10;
            B();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.f19446m
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.f19446m
            if (r0 == 0) goto L_0x0034
            r5.u()
            r0 = r3
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = r3
            goto L_0x0041
        L_0x0040:
            r0 = r2
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = r3
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        a aVar = this.f19439e;
        return aVar != null && aVar.s1();
    }

    public boolean s() {
        a aVar = this.f19439e;
        return aVar != null && aVar.u1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f19452x = charSequence;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f19441g) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i10) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f19441g) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.B1(z10);
        }
    }

    public void setCheckableResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.C1(i10);
        }
    }

    public void setChecked(boolean z10) {
        a aVar = this.f19439e;
        if (aVar == null) {
            this.f19445l = z10;
        } else if (aVar.s1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.D1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.E1(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.F1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.G1(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.H1(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.J1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.K1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.L1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.M1(i10);
        }
    }

    public void setChipDrawable(@NonNull a aVar) {
        a aVar2 = this.f19439e;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f19439e = aVar;
            aVar.E2(false);
            j(this.f19439e);
            l(this.f19451w);
        }
    }

    public void setChipEndPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.N1(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.O1(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.P1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.Q1(i10);
        }
    }

    public void setChipIconSize(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.R1(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.S1(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.T1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.U1(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.V1(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.X1(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.Y1(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.Z1(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.a2(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.b2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.c2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.d2(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.e2(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.g2(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.h2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.i2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.j2(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.k2(i10);
        }
        y();
    }

    public void setCloseIconSize(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.l2(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.m2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.n2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.o2(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.q2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.r2(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.a0(f10);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f19439e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                a aVar = this.f19439e;
                if (aVar != null) {
                    aVar.u2(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f19449q = z10;
        l(this.f19451w);
    }

    public void setGravity(int i10) {
        if (i10 == 8388627) {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(h hVar) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.v2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.w2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.x2(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.y2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.z2(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.A2(i10);
        }
    }

    public void setInternalOnCheckedChangeListener(k.a<Chip> aVar) {
        this.f19444k = aVar;
    }

    public void setLayoutDirection(int i10) {
        if (this.f19439e != null) {
            super.setLayoutDirection(i10);
        }
    }

    public void setLines(int i10) {
        if (i10 <= 1) {
            super.setLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i10) {
        if (i10 <= 1) {
            super.setMaxLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.B2(i10);
        }
    }

    public void setMinLines(int i10) {
        if (i10 <= 1) {
            super.setMinLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f19443j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f19442h = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.C2(colorStateList);
        }
        if (!this.f19439e.q1()) {
            A();
        }
    }

    public void setRippleColorResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.D2(i10);
            if (!this.f19439e.q1()) {
                A();
            }
        }
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        this.f19439e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.F2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.G2(i10);
        }
    }

    public void setSingleLine(boolean z10) {
        if (z10) {
            super.setSingleLine(z10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        a aVar = this.f19439e;
        if (aVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (aVar.Q2()) {
                charSequence2 = null;
            } else {
                charSequence2 = charSequence;
            }
            super.setText(charSequence2, bufferType);
            a aVar2 = this.f19439e;
            if (aVar2 != null) {
                aVar2.H2(charSequence);
            }
        }
    }

    public void setTextAppearance(d dVar) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.I2(dVar);
        }
        C();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.K2(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.L2(i10);
        }
    }

    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.M2(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        C();
    }

    public void setTextStartPadding(float f10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.N2(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.O2(i10);
        }
    }

    public boolean u() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f19442h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f19454z) {
            this.f19453y.U(1, 1);
        }
        return z10;
    }

    public boolean w() {
        return this.f19449q;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = E
            android.content.Context r7 = wf.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r6.B = r7
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>()
            r6.C = r7
            com.google.android.material.chip.Chip$a r7 = new com.google.android.material.chip.Chip$a
            r7.<init>()
            r6.D = r7
            android.content.Context r0 = r6.getContext()
            r6.D(r8)
            com.google.android.material.chip.a r7 = com.google.android.material.chip.a.z0(r0, r8, r9, r4)
            r6.o(r0, r8, r9)
            r6.setChipDrawable(r7)
            float r1 = androidx.core.view.n0.w(r6)
            r7.a0(r1)
            int[] r2 = bf.l.Chip
            r1 = 0
            int[] r5 = new int[r1]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r9 = bf.l.Chip_shapeAppearance
            boolean r9 = r8.hasValue(r9)
            r8.recycle()
            com.google.android.material.chip.Chip$c r8 = new com.google.android.material.chip.Chip$c
            r8.<init>(r6)
            r6.f19453y = r8
            r6.y()
            if (r9 != 0) goto L_0x0059
            r6.p()
        L_0x0059:
            boolean r8 = r6.f19445l
            r6.setChecked(r8)
            java.lang.CharSequence r8 = r7.l1()
            r6.setText(r8)
            android.text.TextUtils$TruncateAt r7 = r7.f1()
            r6.setEllipsize(r7)
            r6.C()
            com.google.android.material.chip.a r7 = r6.f19439e
            boolean r7 = r7.Q2()
            if (r7 != 0) goto L_0x007e
            r7 = 1
            r6.setLines(r7)
            r6.setHorizontallyScrolling(r7)
        L_0x007e:
            r7 = 8388627(0x800013, float:1.175497E-38)
            r6.setGravity(r7)
            r6.B()
            boolean r7 = r6.w()
            if (r7 == 0) goto L_0x0092
            int r7 = r6.f19451w
            r6.setMinHeight(r7)
        L_0x0092:
            int r7 = androidx.core.view.n0.B(r6)
            r6.f19450t = r7
            ef.a r7 = new ef.a
            r7.<init>(r6)
            super.setOnCheckedChangeListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCloseIconVisible(boolean z10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.s2(z10);
        }
        y();
    }

    public void setCheckedIconVisible(boolean z10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.I1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.W1(z10);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.J2(i10);
        }
        C();
    }

    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        a aVar = this.f19439e;
        if (aVar != null) {
            aVar.J2(i10);
        }
        C();
    }
}
