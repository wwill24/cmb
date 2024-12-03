package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.d0;
import androidx.core.view.n0;
import androidx.core.widget.l;
import bf.d;
import bf.f;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;
import qf.c;

final class v {
    private ColorStateList A;
    private Typeface B;

    /* renamed from: a  reason: collision with root package name */
    private final int f20351a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20352b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20353c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f20354d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f20355e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f20356f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f20357g;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f20358h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f20359i;

    /* renamed from: j  reason: collision with root package name */
    private int f20360j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f20361k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Animator f20362l;

    /* renamed from: m  reason: collision with root package name */
    private final float f20363m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f20364n;

    /* renamed from: o  reason: collision with root package name */
    private int f20365o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f20366p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20367q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f20368r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f20369s;

    /* renamed from: t  reason: collision with root package name */
    private int f20370t;

    /* renamed from: u  reason: collision with root package name */
    private int f20371u;

    /* renamed from: v  reason: collision with root package name */
    private ColorStateList f20372v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f20373w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f20374x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f20375y;

    /* renamed from: z  reason: collision with root package name */
    private int f20376z;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20377a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f20378b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f20379c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f20380d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f20377a = i10;
            this.f20378b = textView;
            this.f20379c = i11;
            this.f20380d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            int unused = v.this.f20364n = this.f20377a;
            Animator unused2 = v.this.f20362l = null;
            TextView textView = this.f20378b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f20379c == 1 && v.this.f20368r != null) {
                    v.this.f20368r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f20380d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f20380d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f20380d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f20380d.setAlpha(0.0f);
            }
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = v.this.f20358h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public v(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f20357g = context;
        this.f20358h = textInputLayout;
        this.f20363m = (float) context.getResources().getDimensionPixelSize(d.design_textinput_caption_translate_y);
        int i10 = bf.b.motionDurationShort4;
        this.f20351a = of.a.f(context, i10, 217);
        this.f20352b = of.a.f(context, bf.b.motionDurationMedium4, Opcodes.GOTO);
        this.f20353c = of.a.f(context, i10, Opcodes.GOTO);
        int i11 = bf.b.motionEasingEmphasizedDecelerateInterpolator;
        this.f20354d = of.a.g(context, i11, cf.a.f18980d);
        TimeInterpolator timeInterpolator = cf.a.f18977a;
        this.f20355e = of.a.g(context, i11, timeInterpolator);
        this.f20356f = of.a.g(context, bf.b.motionEasingLinearInterpolator, timeInterpolator);
    }

    private void D(int i10, int i11) {
        TextView m10;
        TextView m11;
        if (i10 != i11) {
            if (!(i11 == 0 || (m11 = m(i11)) == null)) {
                m11.setVisibility(0);
                m11.setAlpha(1.0f);
            }
            if (!(i10 == 0 || (m10 = m(i10)) == null)) {
                m10.setVisibility(4);
                if (i10 == 1) {
                    m10.setText((CharSequence) null);
                }
            }
            this.f20364n = i11;
        }
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, @NonNull CharSequence charSequence) {
        if (!n0.W(this.f20358h) || !this.f20358h.isEnabled() || (this.f20365o == this.f20364n && textView != null && TextUtils.equals(textView.getText(), charSequence))) {
            return false;
        }
        return true;
    }

    private void S(int i10, int i11, boolean z10) {
        boolean z11 = z10;
        if (i10 != i11) {
            if (z11) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f20362l = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i12 = i10;
                int i13 = i11;
                i(arrayList2, this.f20374x, this.f20375y, 2, i12, i13);
                i(arrayList2, this.f20367q, this.f20368r, 1, i12, i13);
                cf.b.a(animatorSet, arrayList);
                animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
                animatorSet.start();
            } else {
                D(i10, i11);
            }
            this.f20358h.n0();
            this.f20358h.r0(z11);
            this.f20358h.x0();
        }
    }

    private boolean g() {
        return (this.f20359i == null || this.f20358h.getEditText() == null) ? false : true;
    }

    private void i(@NonNull List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        boolean z11;
        boolean z12;
        if (textView != null && z10) {
            boolean z13 = false;
            if (i10 == i12 || i10 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i12 == i10) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                ObjectAnimator j10 = j(textView, z12);
                if (i10 == i12 && i11 != 0) {
                    z13 = true;
                }
                if (z13) {
                    j10.setStartDelay((long) this.f20353c);
                }
                list.add(j10);
                if (i12 == i10 && i11 != 0) {
                    ObjectAnimator k10 = k(textView);
                    k10.setStartDelay((long) this.f20353c);
                    list.add(k10);
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z10) {
        float f10;
        int i10;
        TimeInterpolator timeInterpolator;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{f10});
        if (z10) {
            i10 = this.f20352b;
        } else {
            i10 = this.f20353c;
        }
        ofFloat.setDuration((long) i10);
        if (z10) {
            timeInterpolator = this.f20355e;
        } else {
            timeInterpolator = this.f20356f;
        }
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f20363m, 0.0f});
        ofFloat.setDuration((long) this.f20351a);
        ofFloat.setInterpolator(this.f20354d);
        return ofFloat;
    }

    private TextView m(int i10) {
        if (i10 == 1) {
            return this.f20368r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f20375y;
    }

    private int v(boolean z10, int i10, int i11) {
        return z10 ? this.f20357g.getResources().getDimensionPixelSize(i10) : i11;
    }

    private boolean y(int i10) {
        if (i10 != 1 || this.f20368r == null || TextUtils.isEmpty(this.f20366p)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f20367q;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return this.f20374x;
    }

    /* access modifiers changed from: package-private */
    public void C(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f20359i != null) {
            if (!z(i10) || (frameLayout = this.f20361k) == null) {
                this.f20359i.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i11 = this.f20360j - 1;
            this.f20360j = i11;
            O(this.f20359i, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public void E(int i10) {
        this.f20370t = i10;
        TextView textView = this.f20368r;
        if (textView != null) {
            n0.u0(textView, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(CharSequence charSequence) {
        this.f20369s = charSequence;
        TextView textView = this.f20368r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(boolean z10) {
        if (this.f20367q != z10) {
            h();
            if (z10) {
                d0 d0Var = new d0(this.f20357g);
                this.f20368r = d0Var;
                d0Var.setId(f.textinput_error);
                this.f20368r.setTextAlignment(5);
                Typeface typeface = this.B;
                if (typeface != null) {
                    this.f20368r.setTypeface(typeface);
                }
                H(this.f20371u);
                I(this.f20372v);
                F(this.f20369s);
                E(this.f20370t);
                this.f20368r.setVisibility(4);
                e(this.f20368r, 0);
            } else {
                w();
                C(this.f20368r, 0);
                this.f20368r = null;
                this.f20358h.n0();
                this.f20358h.x0();
            }
            this.f20367q = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i10) {
        this.f20371u = i10;
        TextView textView = this.f20368r;
        if (textView != null) {
            this.f20358h.a0(textView, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        this.f20372v = colorStateList;
        TextView textView = this.f20368r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int i10) {
        this.f20376z = i10;
        TextView textView = this.f20375y;
        if (textView != null) {
            l.s(textView, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (this.f20374x != z10) {
            h();
            if (z10) {
                d0 d0Var = new d0(this.f20357g);
                this.f20375y = d0Var;
                d0Var.setId(f.textinput_helper_text);
                this.f20375y.setTextAlignment(5);
                Typeface typeface = this.B;
                if (typeface != null) {
                    this.f20375y.setTypeface(typeface);
                }
                this.f20375y.setVisibility(4);
                n0.u0(this.f20375y, 1);
                J(this.f20376z);
                L(this.A);
                e(this.f20375y, 1);
                this.f20375y.setAccessibilityDelegate(new b());
            } else {
                x();
                C(this.f20375y, 1);
                this.f20375y = null;
                this.f20358h.n0();
                this.f20358h.x0();
            }
            this.f20374x = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f20375y;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f20368r, typeface);
            M(this.f20375y, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        h();
        this.f20366p = charSequence;
        this.f20368r.setText(charSequence);
        int i10 = this.f20364n;
        if (i10 != 1) {
            this.f20365o = 1;
        }
        S(i10, this.f20365o, P(this.f20368r, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void R(CharSequence charSequence) {
        h();
        this.f20373w = charSequence;
        this.f20375y.setText(charSequence);
        int i10 = this.f20364n;
        if (i10 != 2) {
            this.f20365o = 2;
        }
        S(i10, this.f20365o, P(this.f20375y, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void e(TextView textView, int i10) {
        if (this.f20359i == null && this.f20361k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f20357g);
            this.f20359i = linearLayout;
            linearLayout.setOrientation(0);
            this.f20358h.addView(this.f20359i, -1, -2);
            this.f20361k = new FrameLayout(this.f20357g);
            this.f20359i.addView(this.f20361k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f20358h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f20361k.setVisibility(0);
            this.f20361k.addView(textView);
        } else {
            this.f20359i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f20359i.setVisibility(0);
        this.f20360j++;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f20358h.getEditText();
            boolean g10 = c.g(this.f20357g);
            LinearLayout linearLayout = this.f20359i;
            int i10 = d.material_helper_text_font_1_3_padding_horizontal;
            n0.I0(linearLayout, v(g10, i10, n0.G(editText)), v(g10, d.material_helper_text_font_1_3_padding_top, this.f20357g.getResources().getDimensionPixelSize(d.material_helper_text_default_padding_top)), v(g10, i10, n0.F(editText)), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Animator animator = this.f20362l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f20365o);
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f20370t;
    }

    /* access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f20369s;
    }

    /* access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f20366p;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f20368r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList r() {
        TextView textView = this.f20368r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence s() {
        return this.f20373w;
    }

    /* access modifiers changed from: package-private */
    public View t() {
        return this.f20375y;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        TextView textView = this.f20375y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f20366p = null;
        h();
        if (this.f20364n == 1) {
            if (!this.f20374x || TextUtils.isEmpty(this.f20373w)) {
                this.f20365o = 0;
            } else {
                this.f20365o = 2;
            }
        }
        S(this.f20364n, this.f20365o, P(this.f20368r, ""));
    }

    /* access modifiers changed from: package-private */
    public void x() {
        h();
        int i10 = this.f20364n;
        if (i10 == 2) {
            this.f20365o = 0;
        }
        S(i10, this.f20365o, P(this.f20375y, ""));
    }

    /* access modifiers changed from: package-private */
    public boolean z(int i10) {
        return i10 == 0 || i10 == 1;
    }
}
