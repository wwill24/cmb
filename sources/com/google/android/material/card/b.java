package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.f;
import bf.l;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import qf.c;
import tf.d;
import tf.e;
import tf.g;
import tf.j;
import tf.k;

class b {
    private static final Drawable A;

    /* renamed from: z  reason: collision with root package name */
    private static final double f19394z = Math.cos(Math.toRadians(45.0d));
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f19395a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f19396b = new Rect();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final g f19397c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final g f19398d;

    /* renamed from: e  reason: collision with root package name */
    private int f19399e;

    /* renamed from: f  reason: collision with root package name */
    private int f19400f;

    /* renamed from: g  reason: collision with root package name */
    private int f19401g;

    /* renamed from: h  reason: collision with root package name */
    private int f19402h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f19403i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f19404j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f19405k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f19406l;

    /* renamed from: m  reason: collision with root package name */
    private k f19407m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f19408n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f19409o;

    /* renamed from: p  reason: collision with root package name */
    private LayerDrawable f19410p;

    /* renamed from: q  reason: collision with root package name */
    private g f19411q;

    /* renamed from: r  reason: collision with root package name */
    private g f19412r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19413s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f19414t;

    /* renamed from: u  reason: collision with root package name */
    private ValueAnimator f19415u;

    /* renamed from: v  reason: collision with root package name */
    private final TimeInterpolator f19416v;

    /* renamed from: w  reason: collision with root package name */
    private final int f19417w;

    /* renamed from: x  reason: collision with root package name */
    private final int f19418x;

    /* renamed from: y  reason: collision with root package name */
    private float f19419y = 0.0f;

    class a extends InsetDrawable {
        a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        public int getMinimumHeight() {
            return -1;
        }

        public int getMinimumWidth() {
            return -1;
        }

        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        A = colorDrawable;
    }

    public b(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f19395a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, i10, i11);
        this.f19397c = gVar;
        gVar.Q(materialCardView.getContext());
        gVar.g0(-12303292);
        k.b v10 = gVar.E().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, l.CardView, i10, bf.k.CardView);
        int i12 = l.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i12)) {
            v10.o(obtainStyledAttributes.getDimension(i12, 0.0f));
        }
        this.f19398d = new g();
        Z(v10.m());
        this.f19416v = of.a.g(materialCardView.getContext(), bf.b.motionEasingLinearInterpolator, cf.a.f18977a);
        this.f19417w = of.a.f(materialCardView.getContext(), bf.b.motionDurationShort2, MessageTemplateConstants.Values.CENTER_POPUP_WIDTH);
        this.f19418x = of.a.f(materialCardView.getContext(), bf.b.motionDurationShort1, MessageTemplateConstants.Values.CENTER_POPUP_WIDTH);
        obtainStyledAttributes.recycle();
    }

    @NonNull
    private Drawable D(Drawable drawable) {
        int i10;
        int i11;
        if (this.f19395a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) f());
            i11 = (int) Math.ceil((double) e());
            i10 = ceil;
        } else {
            i11 = 0;
            i10 = 0;
        }
        return new a(drawable, i11, i10, i11, i10);
    }

    private boolean G() {
        return (this.f19401g & 80) == 80;
    }

    private boolean H() {
        return (this.f19401g & 8388613) == 8388613;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f19404j.setAlpha((int) (255.0f * floatValue));
        this.f19419y = floatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.f19407m.q(), this.f19397c.J()), d(this.f19407m.s(), this.f19397c.K())), Math.max(d(this.f19407m.k(), this.f19397c.t()), d(this.f19407m.i(), this.f19397c.s())));
    }

    private float d(d dVar, float f10) {
        if (dVar instanceof j) {
            return (float) ((1.0d - f19394z) * ((double) f10));
        }
        if (dVar instanceof e) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        return this.f19395a.getPreventCornerOverlap() && !g();
    }

    private float e() {
        float f10;
        float maxCardElevation = this.f19395a.getMaxCardElevation();
        if (e0()) {
            f10 = c();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    private boolean e0() {
        if (!this.f19395a.getPreventCornerOverlap() || !g() || !this.f19395a.getUseCompatPadding()) {
            return false;
        }
        return true;
    }

    private float f() {
        float f10;
        float maxCardElevation = this.f19395a.getMaxCardElevation() * 1.5f;
        if (e0()) {
            f10 = c();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    private boolean g() {
        return this.f19397c.T();
    }

    @NonNull
    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        g j10 = j();
        this.f19411q = j10;
        j10.b0(this.f19405k);
        stateListDrawable.addState(new int[]{16842919}, this.f19411q);
        return stateListDrawable;
    }

    @NonNull
    private Drawable i() {
        if (!rf.b.f24443a) {
            return h();
        }
        this.f19412r = j();
        return new RippleDrawable(this.f19405k, (Drawable) null, this.f19412r);
    }

    private void i0(Drawable drawable) {
        if (this.f19395a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f19395a.getForeground()).setDrawable(drawable);
        } else {
            this.f19395a.setForeground(D(drawable));
        }
    }

    @NonNull
    private g j() {
        return new g(this.f19407m);
    }

    private void k0() {
        Drawable drawable;
        if (!rf.b.f24443a || (drawable = this.f19409o) == null) {
            g gVar = this.f19411q;
            if (gVar != null) {
                gVar.b0(this.f19405k);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.f19405k);
    }

    @NonNull
    private Drawable t() {
        if (this.f19409o == null) {
            this.f19409o = i();
        }
        if (this.f19410p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f19409o, this.f19398d, this.f19404j});
            this.f19410p = layerDrawable;
            layerDrawable.setId(2, f.mtrl_card_checked_layer_id);
        }
        return this.f19410p;
    }

    private float v() {
        if (!this.f19395a.getPreventCornerOverlap() || !this.f19395a.getUseCompatPadding()) {
            return 0.0f;
        }
        return (float) ((1.0d - f19394z) * ((double) this.f19395a.getCardViewRadius()));
    }

    /* access modifiers changed from: package-private */
    public ColorStateList A() {
        return this.f19408n;
    }

    /* access modifiers changed from: package-private */
    public int B() {
        return this.f19402h;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect C() {
        return this.f19396b;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return this.f19413s;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.f19414t;
    }

    /* access modifiers changed from: package-private */
    public void J(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList a10 = c.a(this.f19395a.getContext(), typedArray, l.MaterialCardView_strokeColor);
        this.f19408n = a10;
        if (a10 == null) {
            this.f19408n = ColorStateList.valueOf(-1);
        }
        this.f19402h = typedArray.getDimensionPixelSize(l.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(l.MaterialCardView_android_checkable, false);
        this.f19414t = z10;
        this.f19395a.setLongClickable(z10);
        this.f19406l = c.a(this.f19395a.getContext(), typedArray, l.MaterialCardView_checkedIconTint);
        R(c.d(this.f19395a.getContext(), typedArray, l.MaterialCardView_checkedIcon));
        U(typedArray.getDimensionPixelSize(l.MaterialCardView_checkedIconSize, 0));
        T(typedArray.getDimensionPixelSize(l.MaterialCardView_checkedIconMargin, 0));
        this.f19401g = typedArray.getInteger(l.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList a11 = c.a(this.f19395a.getContext(), typedArray, l.MaterialCardView_rippleColor);
        this.f19405k = a11;
        if (a11 == null) {
            this.f19405k = ColorStateList.valueOf(hf.a.d(this.f19395a, bf.b.colorControlHighlight));
        }
        N(c.a(this.f19395a.getContext(), typedArray, l.MaterialCardView_cardForegroundColor));
        k0();
        h0();
        l0();
        this.f19395a.setBackgroundInternal(D(this.f19397c));
        if (this.f19395a.isClickable()) {
            drawable = t();
        } else {
            drawable = this.f19398d;
        }
        this.f19403i = drawable;
        this.f19395a.setForeground(D(drawable));
    }

    /* access modifiers changed from: package-private */
    public void K(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if (this.f19410p != null) {
            int i19 = 0;
            if (this.f19395a.getUseCompatPadding()) {
                i12 = (int) Math.ceil((double) (f() * 2.0f));
                i19 = (int) Math.ceil((double) (e() * 2.0f));
            } else {
                i12 = 0;
            }
            if (H()) {
                i13 = ((i10 - this.f19399e) - this.f19400f) - i19;
            } else {
                i13 = this.f19399e;
            }
            if (G()) {
                i14 = this.f19399e;
            } else {
                i14 = ((i11 - this.f19399e) - this.f19400f) - i12;
            }
            int i20 = i14;
            if (H()) {
                i15 = this.f19399e;
            } else {
                i15 = ((i10 - this.f19399e) - this.f19400f) - i19;
            }
            if (G()) {
                i16 = ((i11 - this.f19399e) - this.f19400f) - i12;
            } else {
                i16 = this.f19399e;
            }
            int i21 = i16;
            if (n0.B(this.f19395a) == 1) {
                i18 = i15;
                i17 = i13;
            } else {
                i17 = i15;
                i18 = i13;
            }
            this.f19410p.setLayerInset(2, i18, i21, i17, i20);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z10) {
        this.f19413s = z10;
    }

    /* access modifiers changed from: package-private */
    public void M(ColorStateList colorStateList) {
        this.f19397c.b0(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void N(ColorStateList colorStateList) {
        g gVar = this.f19398d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.b0(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z10) {
        this.f19414t = z10;
    }

    public void P(boolean z10) {
        Q(z10, false);
    }

    public void Q(boolean z10, boolean z11) {
        int i10;
        float f10;
        Drawable drawable = this.f19404j;
        if (drawable == null) {
            return;
        }
        if (z11) {
            b(z10);
            return;
        }
        if (z10) {
            i10 = 255;
        } else {
            i10 = 0;
        }
        drawable.setAlpha(i10);
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        this.f19419y = f10;
    }

    /* access modifiers changed from: package-private */
    public void R(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f19404j = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f19406l);
            P(this.f19395a.isChecked());
        } else {
            this.f19404j = A;
        }
        LayerDrawable layerDrawable = this.f19410p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(f.mtrl_card_checked_layer_id, this.f19404j);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i10) {
        this.f19401g = i10;
        K(this.f19395a.getMeasuredWidth(), this.f19395a.getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void T(int i10) {
        this.f19399e = i10;
    }

    /* access modifiers changed from: package-private */
    public void U(int i10) {
        this.f19400f = i10;
    }

    /* access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        this.f19406l = colorStateList;
        Drawable drawable = this.f19404j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void W(float f10) {
        Z(this.f19407m.w(f10));
        this.f19403i.invalidateSelf();
        if (e0() || d0()) {
            g0();
        }
        if (e0()) {
            j0();
        }
    }

    /* access modifiers changed from: package-private */
    public void X(float f10) {
        this.f19397c.c0(f10);
        g gVar = this.f19398d;
        if (gVar != null) {
            gVar.c0(f10);
        }
        g gVar2 = this.f19412r;
        if (gVar2 != null) {
            gVar2.c0(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(ColorStateList colorStateList) {
        this.f19405k = colorStateList;
        k0();
    }

    /* access modifiers changed from: package-private */
    public void Z(@NonNull k kVar) {
        this.f19407m = kVar;
        this.f19397c.setShapeAppearanceModel(kVar);
        g gVar = this.f19397c;
        gVar.f0(!gVar.T());
        g gVar2 = this.f19398d;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(kVar);
        }
        g gVar3 = this.f19412r;
        if (gVar3 != null) {
            gVar3.setShapeAppearanceModel(kVar);
        }
        g gVar4 = this.f19411q;
        if (gVar4 != null) {
            gVar4.setShapeAppearanceModel(kVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(ColorStateList colorStateList) {
        if (this.f19408n != colorStateList) {
            this.f19408n = colorStateList;
            l0();
        }
    }

    public void b(boolean z10) {
        float f10;
        float f11;
        int i10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        if (z10) {
            f11 = 1.0f - this.f19419y;
        } else {
            f11 = this.f19419y;
        }
        ValueAnimator valueAnimator = this.f19415u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f19415u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f19419y, f10});
        this.f19415u = ofFloat;
        ofFloat.addUpdateListener(new a(this));
        this.f19415u.setInterpolator(this.f19416v);
        ValueAnimator valueAnimator2 = this.f19415u;
        if (z10) {
            i10 = this.f19417w;
        } else {
            i10 = this.f19418x;
        }
        valueAnimator2.setDuration((long) (((float) i10) * f11));
        this.f19415u.start();
    }

    /* access modifiers changed from: package-private */
    public void b0(int i10) {
        if (i10 != this.f19402h) {
            this.f19402h = i10;
            l0();
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(int i10, int i11, int i12, int i13) {
        this.f19396b.set(i10, i11, i12, i13);
        g0();
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        Drawable drawable;
        Drawable drawable2 = this.f19403i;
        if (this.f19395a.isClickable()) {
            drawable = t();
        } else {
            drawable = this.f19398d;
        }
        this.f19403i = drawable;
        if (drawable2 != drawable) {
            i0(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        boolean z10;
        float f10;
        if (d0() || e0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f10 = c();
        } else {
            f10 = 0.0f;
        }
        int v10 = (int) (f10 - v());
        MaterialCardView materialCardView = this.f19395a;
        Rect rect = this.f19396b;
        materialCardView.i(rect.left + v10, rect.top + v10, rect.right + v10, rect.bottom + v10);
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        this.f19397c.a0(this.f19395a.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public void j0() {
        if (!E()) {
            this.f19395a.setBackgroundInternal(D(this.f19397c));
        }
        this.f19395a.setForeground(D(this.f19403i));
    }

    /* access modifiers changed from: package-private */
    public void k() {
        Drawable drawable = this.f19409o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f19409o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f19409o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public g l() {
        return this.f19397c;
    }

    /* access modifiers changed from: package-private */
    public void l0() {
        this.f19398d.i0((float) this.f19402h, this.f19408n);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList m() {
        return this.f19397c.x();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList n() {
        return this.f19398d.x();
    }

    /* access modifiers changed from: package-private */
    public Drawable o() {
        return this.f19404j;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f19401g;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f19399e;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.f19400f;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList s() {
        return this.f19406l;
    }

    /* access modifiers changed from: package-private */
    public float u() {
        return this.f19397c.J();
    }

    /* access modifiers changed from: package-private */
    public float w() {
        return this.f19397c.y();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f19405k;
    }

    /* access modifiers changed from: package-private */
    public k y() {
        return this.f19407m;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        ColorStateList colorStateList = this.f19408n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
