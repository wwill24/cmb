package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import bf.e;
import bf.j;
import net.bytebuddy.jar.asm.Opcodes;

class f extends t {

    /* renamed from: e  reason: collision with root package name */
    private final int f20286e;

    /* renamed from: f  reason: collision with root package name */
    private final int f20287f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f20288g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TimeInterpolator f20289h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f20290i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f20291j = new d(this);

    /* renamed from: k  reason: collision with root package name */
    private final View.OnFocusChangeListener f20292k = new e(this);

    /* renamed from: l  reason: collision with root package name */
    private AnimatorSet f20293l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f20294m;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationStart(Animator animator) {
            f.this.f20348b.Z(true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            f.this.f20348b.Z(false);
        }
    }

    f(@NonNull s sVar) {
        super(sVar);
        Context context = sVar.getContext();
        int i10 = bf.b.motionDurationShort3;
        this.f20286e = of.a.f(context, i10, 100);
        this.f20287f = of.a.f(sVar.getContext(), i10, Opcodes.FCMPG);
        this.f20288g = of.a.g(sVar.getContext(), bf.b.motionEasingLinearInterpolator, cf.a.f18977a);
        this.f20289h = of.a.g(sVar.getContext(), bf.b.motionEasingEmphasizedInterpolator, cf.a.f18980d);
    }

    private void A(boolean z10) {
        boolean z11;
        if (this.f20348b.E() == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && !this.f20293l.isRunning()) {
            this.f20294m.cancel();
            this.f20293l.start();
            if (z11) {
                this.f20293l.end();
            }
        } else if (!z10) {
            this.f20293l.cancel();
            this.f20294m.start();
            if (z11) {
                this.f20294m.end();
            }
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f20288g);
        ofFloat.setDuration((long) this.f20286e);
        ofFloat.addUpdateListener(new c(this));
        return ofFloat;
    }

    private ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(this.f20289h);
        ofFloat.setDuration((long) this.f20287f);
        ofFloat.addUpdateListener(new b(this));
        return ofFloat;
    }

    private void D() {
        ValueAnimator C = C();
        ValueAnimator B = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20293l = animatorSet;
        animatorSet.playTogether(new Animator[]{C, B});
        this.f20293l.addListener(new a());
        ValueAnimator B2 = B(1.0f, 0.0f);
        this.f20294m = B2;
        B2.addListener(new b());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f20350d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f20350d.setScaleX(floatValue);
        this.f20350d.setScaleY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f20290i;
        if (editText != null) {
            Editable text = editText.getText();
            if (text != null) {
                text.clear();
            }
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f20290i;
        if (editText == null || ((!editText.hasFocus() && !this.f20350d.hasFocus()) || this.f20290i.getText().length() <= 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Editable editable) {
        if (this.f20348b.w() == null) {
            A(J());
        }
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return j.clear_text_end_icon_content_description;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return e.mtrl_ic_cancel;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f20292k;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f20291j;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return this.f20292k;
    }

    public void n(EditText editText) {
        this.f20290i = editText;
        this.f20347a.setEndIconVisible(J());
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z10) {
        if (this.f20348b.w() != null) {
            A(z10);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        D();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f20290i;
        if (editText != null) {
            editText.post(new a(this));
        }
    }
}
