package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.b;
import bf.l;
import com.google.android.material.internal.r;
import qf.c;
import tf.g;
import tf.k;
import tf.n;

class a {

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f19362u = true;

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f19363v = false;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f19364a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private k f19365b;

    /* renamed from: c  reason: collision with root package name */
    private int f19366c;

    /* renamed from: d  reason: collision with root package name */
    private int f19367d;

    /* renamed from: e  reason: collision with root package name */
    private int f19368e;

    /* renamed from: f  reason: collision with root package name */
    private int f19369f;

    /* renamed from: g  reason: collision with root package name */
    private int f19370g;

    /* renamed from: h  reason: collision with root package name */
    private int f19371h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f19372i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f19373j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f19374k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f19375l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f19376m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19377n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19378o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19379p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19380q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f19381r = true;

    /* renamed from: s  reason: collision with root package name */
    private LayerDrawable f19382s;

    /* renamed from: t  reason: collision with root package name */
    private int f19383t;

    a(MaterialButton materialButton, @NonNull k kVar) {
        this.f19364a = materialButton;
        this.f19365b = kVar;
    }

    private void G(int i10, int i11) {
        int G = n0.G(this.f19364a);
        int paddingTop = this.f19364a.getPaddingTop();
        int F = n0.F(this.f19364a);
        int paddingBottom = this.f19364a.getPaddingBottom();
        int i12 = this.f19368e;
        int i13 = this.f19369f;
        this.f19369f = i11;
        this.f19368e = i10;
        if (!this.f19378o) {
            H();
        }
        n0.I0(this.f19364a, G, (paddingTop + i10) - i12, F, (paddingBottom + i11) - i13);
    }

    private void H() {
        this.f19364a.setInternalBackground(a());
        g f10 = f();
        if (f10 != null) {
            f10.a0((float) this.f19383t);
            f10.setState(this.f19364a.getDrawableState());
        }
    }

    private void I(@NonNull k kVar) {
        if (!f19363v || this.f19378o) {
            if (f() != null) {
                f().setShapeAppearanceModel(kVar);
            }
            if (n() != null) {
                n().setShapeAppearanceModel(kVar);
            }
            if (e() != null) {
                e().setShapeAppearanceModel(kVar);
                return;
            }
            return;
        }
        int G = n0.G(this.f19364a);
        int paddingTop = this.f19364a.getPaddingTop();
        int F = n0.F(this.f19364a);
        int paddingBottom = this.f19364a.getPaddingBottom();
        H();
        n0.I0(this.f19364a, G, paddingTop, F, paddingBottom);
    }

    private void J() {
        int i10;
        g f10 = f();
        g n10 = n();
        if (f10 != null) {
            f10.i0((float) this.f19371h, this.f19374k);
            if (n10 != null) {
                float f11 = (float) this.f19371h;
                if (this.f19377n) {
                    i10 = hf.a.d(this.f19364a, b.colorSurface);
                } else {
                    i10 = 0;
                }
                n10.h0(f11, i10);
            }
        }
    }

    @NonNull
    private InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f19366c, this.f19368e, this.f19367d, this.f19369f);
    }

    private Drawable a() {
        int i10;
        g gVar = new g(this.f19365b);
        gVar.Q(this.f19364a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.f19373j);
        PorterDuff.Mode mode = this.f19372i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.i0((float) this.f19371h, this.f19374k);
        g gVar2 = new g(this.f19365b);
        gVar2.setTint(0);
        float f10 = (float) this.f19371h;
        if (this.f19377n) {
            i10 = hf.a.d(this.f19364a, b.colorSurface);
        } else {
            i10 = 0;
        }
        gVar2.h0(f10, i10);
        if (f19362u) {
            g gVar3 = new g(this.f19365b);
            this.f19376m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(rf.b.d(this.f19375l), K(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f19376m);
            this.f19382s = rippleDrawable;
            return rippleDrawable;
        }
        rf.a aVar = new rf.a(this.f19365b);
        this.f19376m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, rf.b.d(this.f19375l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f19376m});
        this.f19382s = layerDrawable;
        return K(layerDrawable);
    }

    private g g(boolean z10) {
        LayerDrawable layerDrawable = this.f19382s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f19362u) {
            return (g) ((LayerDrawable) ((InsetDrawable) this.f19382s.getDrawable(0)).getDrawable()).getDrawable(z10 ^ true ? 1 : 0);
        }
        return (g) this.f19382s.getDrawable(z10 ^ true ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z10) {
        this.f19377n = z10;
        J();
    }

    /* access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        if (this.f19374k != colorStateList) {
            this.f19374k = colorStateList;
            J();
        }
    }

    /* access modifiers changed from: package-private */
    public void C(int i10) {
        if (this.f19371h != i10) {
            this.f19371h = i10;
            J();
        }
    }

    /* access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        if (this.f19373j != colorStateList) {
            this.f19373j = colorStateList;
            if (f() != null) {
                androidx.core.graphics.drawable.a.o(f(), this.f19373j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        if (this.f19372i != mode) {
            this.f19372i = mode;
            if (f() != null && this.f19372i != null) {
                androidx.core.graphics.drawable.a.p(f(), this.f19372i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F(boolean z10) {
        this.f19381r = z10;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f19370g;
    }

    public int c() {
        return this.f19369f;
    }

    public int d() {
        return this.f19368e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f19382s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.f19382s.getNumberOfLayers() > 2) {
            return (n) this.f19382s.getDrawable(2);
        }
        return (n) this.f19382s.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public g f() {
        return g(false);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f19375l;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public k i() {
        return this.f19365b;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f19374k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f19371h;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f19373j;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f19372i;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f19378o;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f19380q;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f19381r;
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull TypedArray typedArray) {
        this.f19366c = typedArray.getDimensionPixelOffset(l.MaterialButton_android_insetLeft, 0);
        this.f19367d = typedArray.getDimensionPixelOffset(l.MaterialButton_android_insetRight, 0);
        this.f19368e = typedArray.getDimensionPixelOffset(l.MaterialButton_android_insetTop, 0);
        this.f19369f = typedArray.getDimensionPixelOffset(l.MaterialButton_android_insetBottom, 0);
        int i10 = l.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f19370g = dimensionPixelSize;
            z(this.f19365b.w((float) dimensionPixelSize));
            this.f19379p = true;
        }
        this.f19371h = typedArray.getDimensionPixelSize(l.MaterialButton_strokeWidth, 0);
        this.f19372i = r.j(typedArray.getInt(l.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f19373j = c.a(this.f19364a.getContext(), typedArray, l.MaterialButton_backgroundTint);
        this.f19374k = c.a(this.f19364a.getContext(), typedArray, l.MaterialButton_strokeColor);
        this.f19375l = c.a(this.f19364a.getContext(), typedArray, l.MaterialButton_rippleColor);
        this.f19380q = typedArray.getBoolean(l.MaterialButton_android_checkable, false);
        this.f19383t = typedArray.getDimensionPixelSize(l.MaterialButton_elevation, 0);
        this.f19381r = typedArray.getBoolean(l.MaterialButton_toggleCheckedStateOnClick, true);
        int G = n0.G(this.f19364a);
        int paddingTop = this.f19364a.getPaddingTop();
        int F = n0.F(this.f19364a);
        int paddingBottom = this.f19364a.getPaddingBottom();
        if (typedArray.hasValue(l.MaterialButton_android_background)) {
            t();
        } else {
            H();
        }
        n0.I0(this.f19364a, G + this.f19366c, paddingTop + this.f19368e, F + this.f19367d, paddingBottom + this.f19369f);
    }

    /* access modifiers changed from: package-private */
    public void s(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f19378o = true;
        this.f19364a.setSupportBackgroundTintList(this.f19373j);
        this.f19364a.setSupportBackgroundTintMode(this.f19372i);
    }

    /* access modifiers changed from: package-private */
    public void u(boolean z10) {
        this.f19380q = z10;
    }

    /* access modifiers changed from: package-private */
    public void v(int i10) {
        if (!this.f19379p || this.f19370g != i10) {
            this.f19370g = i10;
            this.f19379p = true;
            z(this.f19365b.w((float) i10));
        }
    }

    public void w(int i10) {
        G(this.f19368e, i10);
    }

    public void x(int i10) {
        G(i10, this.f19369f);
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.f19375l != colorStateList) {
            this.f19375l = colorStateList;
            boolean z10 = f19362u;
            if (z10 && (this.f19364a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f19364a.getBackground()).setColor(rf.b.d(colorStateList));
            } else if (!z10 && (this.f19364a.getBackground() instanceof rf.a)) {
                ((rf.a) this.f19364a.getBackground()).setTintList(rf.b.d(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z(@NonNull k kVar) {
        this.f19365b = kVar;
        I(kVar);
    }
}
