package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.h1;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import bf.d;
import bf.f;
import bf.h;
import bf.l;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import qf.c;

@SuppressLint({"ViewConstructor"})
class z extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f20387a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f20388b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f20389c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckableImageButton f20390d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f20391e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f20392f;

    /* renamed from: g  reason: collision with root package name */
    private int f20393g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private ImageView.ScaleType f20394h;

    /* renamed from: j  reason: collision with root package name */
    private View.OnLongClickListener f20395j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20396k;

    z(TextInputLayout textInputLayout, h1 h1Var) {
        super(textInputLayout.getContext());
        this.f20387a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(h.design_text_input_start_icon, this, false);
        this.f20390d = checkableImageButton;
        u.e(checkableImageButton);
        d0 d0Var = new d0(getContext());
        this.f20388b = d0Var;
        i(h1Var);
        h(h1Var);
        addView(checkableImageButton);
        addView(d0Var);
    }

    private void B() {
        int i10;
        boolean z10;
        int i11 = 8;
        if (this.f20389c == null || this.f20396k) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (this.f20390d.getVisibility() == 0 || i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i11 = 0;
        }
        setVisibility(i11);
        this.f20388b.setVisibility(i10);
        this.f20387a.m0();
    }

    private void h(h1 h1Var) {
        this.f20388b.setVisibility(8);
        this.f20388b.setId(f.textinput_prefix_text);
        this.f20388b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        n0.u0(this.f20388b, 1);
        n(h1Var.n(l.TextInputLayout_prefixTextAppearance, 0));
        int i10 = l.TextInputLayout_prefixTextColor;
        if (h1Var.s(i10)) {
            o(h1Var.c(i10));
        }
        m(h1Var.p(l.TextInputLayout_prefixText));
    }

    private void i(h1 h1Var) {
        if (c.g(getContext())) {
            androidx.core.view.h.c((ViewGroup.MarginLayoutParams) this.f20390d.getLayoutParams(), 0);
        }
        t((View.OnClickListener) null);
        u((View.OnLongClickListener) null);
        int i10 = l.TextInputLayout_startIconTint;
        if (h1Var.s(i10)) {
            this.f20391e = c.b(getContext(), h1Var, i10);
        }
        int i11 = l.TextInputLayout_startIconTintMode;
        if (h1Var.s(i11)) {
            this.f20392f = r.j(h1Var.k(i11, -1), (PorterDuff.Mode) null);
        }
        int i12 = l.TextInputLayout_startIconDrawable;
        if (h1Var.s(i12)) {
            r(h1Var.g(i12));
            int i13 = l.TextInputLayout_startIconContentDescription;
            if (h1Var.s(i13)) {
                q(h1Var.p(i13));
            }
            p(h1Var.a(l.TextInputLayout_startIconCheckable, true));
        }
        s(h1Var.f(l.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(d.mtrl_min_touch_target_size)));
        int i14 = l.TextInputLayout_startIconScaleType;
        if (h1Var.s(i14)) {
            v(u.b(h1Var.k(i14, -1)));
        }
    }

    /* access modifiers changed from: package-private */
    public void A() {
        int i10;
        EditText editText = this.f20387a.f20234d;
        if (editText != null) {
            if (j()) {
                i10 = 0;
            } else {
                i10 = n0.G(editText);
            }
            n0.I0(this.f20388b, i10, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(d.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f20389c;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f20388b.getTextColors();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TextView c() {
        return this.f20388b;
    }

    /* access modifiers changed from: package-private */
    public CharSequence d() {
        return this.f20390d.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public Drawable e() {
        return this.f20390d.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f20393g;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType g() {
        return this.f20394h;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f20390d.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void k(boolean z10) {
        this.f20396k = z10;
        B();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        u.d(this.f20387a, this.f20390d, this.f20391e);
    }

    /* access modifiers changed from: package-private */
    public void m(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f20389c = charSequence2;
        this.f20388b.setText(charSequence);
        B();
    }

    /* access modifiers changed from: package-private */
    public void n(int i10) {
        androidx.core.widget.l.s(this.f20388b, i10);
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull ColorStateList colorStateList) {
        this.f20388b.setTextColor(colorStateList);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        A();
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z10) {
        this.f20390d.setCheckable(z10);
    }

    /* access modifiers changed from: package-private */
    public void q(CharSequence charSequence) {
        if (d() != charSequence) {
            this.f20390d.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        this.f20390d.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f20387a, this.f20390d, this.f20391e, this.f20392f);
            y(true);
            l();
            return;
        }
        y(false);
        t((View.OnClickListener) null);
        u((View.OnLongClickListener) null);
        q((CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public void s(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i10 != this.f20393g) {
            this.f20393g = i10;
            u.g(this.f20390d, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(View.OnClickListener onClickListener) {
        u.h(this.f20390d, onClickListener, this.f20395j);
    }

    /* access modifiers changed from: package-private */
    public void u(View.OnLongClickListener onLongClickListener) {
        this.f20395j = onLongClickListener;
        u.i(this.f20390d, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull ImageView.ScaleType scaleType) {
        this.f20394h = scaleType;
        u.j(this.f20390d, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f20391e != colorStateList) {
            this.f20391e = colorStateList;
            u.a(this.f20387a, this.f20390d, colorStateList, this.f20392f);
        }
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f20392f != mode) {
            this.f20392f = mode;
            u.a(this.f20387a, this.f20390d, this.f20391e, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(boolean z10) {
        int i10;
        if (j() != z10) {
            CheckableImageButton checkableImageButton = this.f20390d;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            A();
            B();
        }
    }

    /* access modifiers changed from: package-private */
    public void z(@NonNull k kVar) {
        if (this.f20388b.getVisibility() == 0) {
            kVar.m0(this.f20388b);
            kVar.z0(this.f20388b);
            return;
        }
        kVar.z0(this.f20390d);
    }
}
