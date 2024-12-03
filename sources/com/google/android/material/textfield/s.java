package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.h1;
import androidx.core.view.accessibility.c;
import androidx.core.view.n0;
import bf.f;
import bf.h;
import bf.j;
import bf.l;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.o;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressLint({"ViewConstructor"})
class s extends LinearLayout {
    private c.b B;
    /* access modifiers changed from: private */
    public final TextWatcher C = new a();
    private final TextInputLayout.g D;

    /* renamed from: a  reason: collision with root package name */
    final TextInputLayout f20320a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f20321b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final CheckableImageButton f20322c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f20323d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f20324e;

    /* renamed from: f  reason: collision with root package name */
    private View.OnLongClickListener f20325f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final CheckableImageButton f20326g;

    /* renamed from: h  reason: collision with root package name */
    private final d f20327h;

    /* renamed from: j  reason: collision with root package name */
    private int f20328j = 0;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashSet<TextInputLayout.h> f20329k = new LinkedHashSet<>();

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f20330l;

    /* renamed from: m  reason: collision with root package name */
    private PorterDuff.Mode f20331m;

    /* renamed from: n  reason: collision with root package name */
    private int f20332n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    private ImageView.ScaleType f20333p;

    /* renamed from: q  reason: collision with root package name */
    private View.OnLongClickListener f20334q;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f20335t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private final TextView f20336w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f20337x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public EditText f20338y;

    /* renamed from: z  reason: collision with root package name */
    private final AccessibilityManager f20339z;

    class a extends o {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            s.this.m().a(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            s.this.m().b(charSequence, i10, i11, i12);
        }
    }

    class b implements TextInputLayout.g {
        b() {
        }

        public void a(@NonNull TextInputLayout textInputLayout) {
            if (s.this.f20338y != textInputLayout.getEditText()) {
                if (s.this.f20338y != null) {
                    s.this.f20338y.removeTextChangedListener(s.this.C);
                    if (s.this.f20338y.getOnFocusChangeListener() == s.this.m().e()) {
                        s.this.f20338y.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                    }
                }
                EditText unused = s.this.f20338y = textInputLayout.getEditText();
                if (s.this.f20338y != null) {
                    s.this.f20338y.addTextChangedListener(s.this.C);
                }
                s.this.m().n(s.this.f20338y);
                s sVar = s.this;
                sVar.g0(sVar.m());
            }
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        public void onViewAttachedToWindow(View view) {
            s.this.g();
        }

        public void onViewDetachedFromWindow(View view) {
            s.this.L();
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<t> f20343a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private final s f20344b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f20345c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20346d;

        d(s sVar, h1 h1Var) {
            this.f20344b = sVar;
            this.f20345c = h1Var.n(l.TextInputLayout_endIconDrawable, 0);
            this.f20346d = h1Var.n(l.TextInputLayout_passwordToggleDrawable, 0);
        }

        private t b(int i10) {
            if (i10 == -1) {
                return new g(this.f20344b);
            }
            if (i10 == 0) {
                return new w(this.f20344b);
            }
            if (i10 == 1) {
                return new y(this.f20344b, this.f20346d);
            }
            if (i10 == 2) {
                return new f(this.f20344b);
            }
            if (i10 == 3) {
                return new q(this.f20344b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
        }

        /* access modifiers changed from: package-private */
        public t c(int i10) {
            t tVar = this.f20343a.get(i10);
            if (tVar != null) {
                return tVar;
            }
            t b10 = b(i10);
            this.f20343a.append(i10, b10);
            return b10;
        }
    }

    s(TextInputLayout textInputLayout, h1 h1Var) {
        super(textInputLayout.getContext());
        b bVar = new b();
        this.D = bVar;
        this.f20339z = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f20320a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f20321b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton i10 = i(this, from, f.text_input_error_icon);
        this.f20322c = i10;
        CheckableImageButton i11 = i(frameLayout, from, f.text_input_end_icon);
        this.f20326g = i11;
        this.f20327h = new d(this, h1Var);
        d0 d0Var = new d0(getContext());
        this.f20336w = d0Var;
        B(h1Var);
        A(h1Var);
        C(h1Var);
        frameLayout.addView(i11);
        addView(d0Var);
        addView(frameLayout);
        addView(i10);
        textInputLayout.h(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void A(h1 h1Var) {
        int i10 = l.TextInputLayout_passwordToggleEnabled;
        if (!h1Var.s(i10)) {
            int i11 = l.TextInputLayout_endIconTint;
            if (h1Var.s(i11)) {
                this.f20330l = qf.c.b(getContext(), h1Var, i11);
            }
            int i12 = l.TextInputLayout_endIconTintMode;
            if (h1Var.s(i12)) {
                this.f20331m = r.j(h1Var.k(i12, -1), (PorterDuff.Mode) null);
            }
        }
        int i13 = l.TextInputLayout_endIconMode;
        if (h1Var.s(i13)) {
            T(h1Var.k(i13, 0));
            int i14 = l.TextInputLayout_endIconContentDescription;
            if (h1Var.s(i14)) {
                P(h1Var.p(i14));
            }
            N(h1Var.a(l.TextInputLayout_endIconCheckable, true));
        } else if (h1Var.s(i10)) {
            int i15 = l.TextInputLayout_passwordToggleTint;
            if (h1Var.s(i15)) {
                this.f20330l = qf.c.b(getContext(), h1Var, i15);
            }
            int i16 = l.TextInputLayout_passwordToggleTintMode;
            if (h1Var.s(i16)) {
                this.f20331m = r.j(h1Var.k(i16, -1), (PorterDuff.Mode) null);
            }
            T(h1Var.a(i10, false) ? 1 : 0);
            P(h1Var.p(l.TextInputLayout_passwordToggleContentDescription));
        }
        S(h1Var.f(l.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(bf.d.mtrl_min_touch_target_size)));
        int i17 = l.TextInputLayout_endIconScaleType;
        if (h1Var.s(i17)) {
            W(u.b(h1Var.k(i17, -1)));
        }
    }

    private void B(h1 h1Var) {
        int i10 = l.TextInputLayout_errorIconTint;
        if (h1Var.s(i10)) {
            this.f20323d = qf.c.b(getContext(), h1Var, i10);
        }
        int i11 = l.TextInputLayout_errorIconTintMode;
        if (h1Var.s(i11)) {
            this.f20324e = r.j(h1Var.k(i11, -1), (PorterDuff.Mode) null);
        }
        int i12 = l.TextInputLayout_errorIconDrawable;
        if (h1Var.s(i12)) {
            b0(h1Var.g(i12));
        }
        this.f20322c.setContentDescription(getResources().getText(j.error_icon_content_description));
        n0.D0(this.f20322c, 2);
        this.f20322c.setClickable(false);
        this.f20322c.setPressable(false);
        this.f20322c.setFocusable(false);
    }

    private void C(h1 h1Var) {
        this.f20336w.setVisibility(8);
        this.f20336w.setId(f.textinput_suffix_text);
        this.f20336w.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        n0.u0(this.f20336w, 1);
        p0(h1Var.n(l.TextInputLayout_suffixTextAppearance, 0));
        int i10 = l.TextInputLayout_suffixTextColor;
        if (h1Var.s(i10)) {
            q0(h1Var.c(i10));
        }
        o0(h1Var.p(l.TextInputLayout_suffixText));
    }

    /* access modifiers changed from: private */
    public void L() {
        AccessibilityManager accessibilityManager;
        c.b bVar = this.B;
        if (bVar != null && (accessibilityManager = this.f20339z) != null) {
            androidx.core.view.accessibility.c.b(accessibilityManager, bVar);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.B != null && this.f20339z != null && n0.V(this)) {
            androidx.core.view.accessibility.c.a(this.f20339z, this.B);
        }
    }

    /* access modifiers changed from: private */
    public void g0(t tVar) {
        if (this.f20338y != null) {
            if (tVar.e() != null) {
                this.f20338y.setOnFocusChangeListener(tVar.e());
            }
            if (tVar.g() != null) {
                this.f20326g.setOnFocusChangeListener(tVar.g());
            }
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(h.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        u.e(checkableImageButton);
        if (qf.c.g(getContext())) {
            androidx.core.view.h.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i10) {
        Iterator<TextInputLayout.h> it = this.f20329k.iterator();
        while (it.hasNext()) {
            it.next().a(this.f20320a, i10);
        }
    }

    private void r0(@NonNull t tVar) {
        tVar.s();
        this.B = tVar.h();
        g();
    }

    private void s0(@NonNull t tVar) {
        L();
        this.B = null;
        tVar.u();
    }

    private int t(t tVar) {
        int a10 = this.f20327h.f20345c;
        if (a10 == 0) {
            return tVar.d();
        }
        return a10;
    }

    private void t0(boolean z10) {
        if (!z10 || n() == null) {
            u.a(this.f20320a, this.f20326g, this.f20330l, this.f20331m);
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(n()).mutate();
        androidx.core.graphics.drawable.a.n(mutate, this.f20320a.getErrorCurrentTextColors());
        this.f20326g.setImageDrawable(mutate);
    }

    private void u0() {
        int i10;
        boolean z10;
        boolean z11;
        FrameLayout frameLayout = this.f20321b;
        int i11 = 8;
        if (this.f20326g.getVisibility() != 0 || F()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        frameLayout.setVisibility(i10);
        if (this.f20335t == null || this.f20337x) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (E() || F() || !z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 0;
        }
        setVisibility(i11);
    }

    private void v0() {
        boolean z10;
        int i10 = 0;
        if (s() == null || !this.f20320a.M() || !this.f20320a.b0()) {
            z10 = false;
        } else {
            z10 = true;
        }
        CheckableImageButton checkableImageButton = this.f20322c;
        if (!z10) {
            i10 = 8;
        }
        checkableImageButton.setVisibility(i10);
        u0();
        w0();
        if (!z()) {
            this.f20320a.m0();
        }
    }

    private void x0() {
        int i10;
        int visibility = this.f20336w.getVisibility();
        boolean z10 = false;
        if (this.f20335t == null || this.f20337x) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (visibility != i10) {
            t m10 = m();
            if (i10 == 0) {
                z10 = true;
            }
            m10.q(z10);
        }
        u0();
        this.f20336w.setVisibility(i10);
        this.f20320a.m0();
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return z() && this.f20326g.isChecked();
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return this.f20321b.getVisibility() == 0 && this.f20326g.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.f20322c.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void G(boolean z10) {
        this.f20337x = z10;
        x0();
    }

    /* access modifiers changed from: package-private */
    public void H() {
        v0();
        J();
        I();
        if (m().t()) {
            t0(this.f20320a.b0());
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        u.d(this.f20320a, this.f20326g, this.f20330l);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        u.d(this.f20320a, this.f20322c, this.f20323d);
    }

    /* access modifiers changed from: package-private */
    public void K(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean isChecked;
        t m10 = m();
        boolean z12 = true;
        if (!m10.l() || (isChecked = this.f20326g.isChecked()) == m10.m()) {
            z11 = false;
        } else {
            this.f20326g.setChecked(!isChecked);
            z11 = true;
        }
        if (!m10.j() || (isActivated = this.f20326g.isActivated()) == m10.k()) {
            z12 = z11;
        } else {
            M(!isActivated);
        }
        if (z10 || z12) {
            I();
        }
    }

    /* access modifiers changed from: package-private */
    public void M(boolean z10) {
        this.f20326g.setActivated(z10);
    }

    /* access modifiers changed from: package-private */
    public void N(boolean z10) {
        this.f20326g.setCheckable(z10);
    }

    /* access modifiers changed from: package-private */
    public void O(int i10) {
        P(i10 != 0 ? getResources().getText(i10) : null);
    }

    /* access modifiers changed from: package-private */
    public void P(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f20326g.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(int i10) {
        R(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    /* access modifiers changed from: package-private */
    public void R(Drawable drawable) {
        this.f20326g.setImageDrawable(drawable);
        if (drawable != null) {
            u.a(this.f20320a, this.f20326g, this.f20330l, this.f20331m);
            I();
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i10 != this.f20332n) {
            this.f20332n = i10;
            u.g(this.f20326g, i10);
            u.g(this.f20322c, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int i10) {
        boolean z10;
        if (this.f20328j != i10) {
            s0(m());
            int i11 = this.f20328j;
            this.f20328j = i10;
            j(i11);
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Z(z10);
            t m10 = m();
            Q(t(m10));
            O(m10.c());
            N(m10.l());
            if (m10.i(this.f20320a.getBoxBackgroundMode())) {
                r0(m10);
                U(m10.f());
                EditText editText = this.f20338y;
                if (editText != null) {
                    m10.n(editText);
                    g0(m10);
                }
                u.a(this.f20320a, this.f20326g, this.f20330l, this.f20331m);
                K(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.f20320a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void U(View.OnClickListener onClickListener) {
        u.h(this.f20326g, onClickListener, this.f20334q);
    }

    /* access modifiers changed from: package-private */
    public void V(View.OnLongClickListener onLongClickListener) {
        this.f20334q = onLongClickListener;
        u.i(this.f20326g, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void W(@NonNull ImageView.ScaleType scaleType) {
        this.f20333p = scaleType;
        u.j(this.f20326g, scaleType);
        u.j(this.f20322c, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void X(ColorStateList colorStateList) {
        if (this.f20330l != colorStateList) {
            this.f20330l = colorStateList;
            u.a(this.f20320a, this.f20326g, colorStateList, this.f20331m);
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(PorterDuff.Mode mode) {
        if (this.f20331m != mode) {
            this.f20331m = mode;
            u.a(this.f20320a, this.f20326g, this.f20330l, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(boolean z10) {
        int i10;
        if (E() != z10) {
            CheckableImageButton checkableImageButton = this.f20326g;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            u0();
            w0();
            this.f20320a.m0();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = e.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        b0(drawable);
        J();
    }

    /* access modifiers changed from: package-private */
    public void b0(Drawable drawable) {
        this.f20322c.setImageDrawable(drawable);
        v0();
        u.a(this.f20320a, this.f20322c, this.f20323d, this.f20324e);
    }

    /* access modifiers changed from: package-private */
    public void c0(View.OnClickListener onClickListener) {
        u.h(this.f20322c, onClickListener, this.f20325f);
    }

    /* access modifiers changed from: package-private */
    public void d0(View.OnLongClickListener onLongClickListener) {
        this.f20325f = onLongClickListener;
        u.i(this.f20322c, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void e0(ColorStateList colorStateList) {
        if (this.f20323d != colorStateList) {
            this.f20323d = colorStateList;
            u.a(this.f20320a, this.f20322c, colorStateList, this.f20324e);
        }
    }

    /* access modifiers changed from: package-private */
    public void f0(PorterDuff.Mode mode) {
        if (this.f20324e != mode) {
            this.f20324e = mode;
            u.a(this.f20320a, this.f20322c, this.f20323d, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f20326g.performClick();
        this.f20326g.jumpDrawablesToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public void h0(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        i0(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void i0(CharSequence charSequence) {
        this.f20326g.setContentDescription(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void j0(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = e.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        k0(drawable);
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton k() {
        if (F()) {
            return this.f20322c;
        }
        if (!z() || !E()) {
            return null;
        }
        return this.f20326g;
    }

    /* access modifiers changed from: package-private */
    public void k0(Drawable drawable) {
        this.f20326g.setImageDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public CharSequence l() {
        return this.f20326g.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void l0(boolean z10) {
        if (z10 && this.f20328j != 1) {
            T(1);
        } else if (!z10) {
            T(0);
        }
    }

    /* access modifiers changed from: package-private */
    public t m() {
        return this.f20327h.c(this.f20328j);
    }

    /* access modifiers changed from: package-private */
    public void m0(ColorStateList colorStateList) {
        this.f20330l = colorStateList;
        u.a(this.f20320a, this.f20326g, colorStateList, this.f20331m);
    }

    /* access modifiers changed from: package-private */
    public Drawable n() {
        return this.f20326g.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void n0(PorterDuff.Mode mode) {
        this.f20331m = mode;
        u.a(this.f20320a, this.f20326g, this.f20330l, mode);
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f20332n;
    }

    /* access modifiers changed from: package-private */
    public void o0(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f20335t = charSequence2;
        this.f20336w.setText(charSequence);
        x0();
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f20328j;
    }

    /* access modifiers changed from: package-private */
    public void p0(int i10) {
        androidx.core.widget.l.s(this.f20336w, i10);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType q() {
        return this.f20333p;
    }

    /* access modifiers changed from: package-private */
    public void q0(@NonNull ColorStateList colorStateList) {
        this.f20336w.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton r() {
        return this.f20326g;
    }

    /* access modifiers changed from: package-private */
    public Drawable s() {
        return this.f20322c.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public CharSequence u() {
        return this.f20326g.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public Drawable v() {
        return this.f20326g.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public CharSequence w() {
        return this.f20335t;
    }

    /* access modifiers changed from: package-private */
    public void w0() {
        int i10;
        if (this.f20320a.f20234d != null) {
            if (E() || F()) {
                i10 = 0;
            } else {
                i10 = n0.F(this.f20320a.f20234d);
            }
            n0.I0(this.f20336w, getContext().getResources().getDimensionPixelSize(bf.d.material_input_text_to_prefix_suffix_padding), this.f20320a.f20234d.getPaddingTop(), i10, this.f20320a.f20234d.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f20336w.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public TextView y() {
        return this.f20336w;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return this.f20328j != 0;
    }
}
