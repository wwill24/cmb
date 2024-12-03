package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.c;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import bf.b;
import bf.e;
import bf.j;
import com.google.android.material.internal.CheckableImageButton;

class q extends t {

    /* renamed from: s  reason: collision with root package name */
    private static final boolean f20304s = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f20305e;

    /* renamed from: f  reason: collision with root package name */
    private final int f20306f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f20307g;

    /* renamed from: h  reason: collision with root package name */
    private AutoCompleteTextView f20308h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f20309i = new j(this);

    /* renamed from: j  reason: collision with root package name */
    private final View.OnFocusChangeListener f20310j = new k(this);

    /* renamed from: k  reason: collision with root package name */
    private final c.b f20311k = new l(this);

    /* renamed from: l  reason: collision with root package name */
    private boolean f20312l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20313m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20314n;

    /* renamed from: o  reason: collision with root package name */
    private long f20315o = Long.MAX_VALUE;

    /* renamed from: p  reason: collision with root package name */
    private AccessibilityManager f20316p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f20317q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public ValueAnimator f20318r;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            q.this.r();
            q.this.f20318r.start();
        }
    }

    q(@NonNull s sVar) {
        super(sVar);
        Context context = sVar.getContext();
        int i10 = b.motionDurationShort3;
        this.f20306f = of.a.f(context, i10, 67);
        this.f20305e = of.a.f(sVar.getContext(), i10, 50);
        this.f20307g = of.a.g(sVar.getContext(), b.motionEasingLinearInterpolator, cf.a.f18977a);
    }

    @NonNull
    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i10, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f20307g);
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(new m(this));
        return ofFloat;
    }

    private void F() {
        this.f20318r = E(this.f20306f, 0.0f, 1.0f);
        ValueAnimator E = E(this.f20305e, 1.0f, 0.0f);
        this.f20317q = E;
        E.addListener(new a());
    }

    private boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f20315o;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f20308h.isPopupShowing();
        O(isPopupShowing);
        this.f20313m = isPopupShowing;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f20350d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f20312l = z10;
        r();
        if (!z10) {
            O(false);
            this.f20313m = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        int i10;
        AutoCompleteTextView autoCompleteTextView = this.f20308h;
        if (autoCompleteTextView != null && !r.a(autoCompleteTextView)) {
            CheckableImageButton checkableImageButton = this.f20350d;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            n0.D0(checkableImageButton, i10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f20313m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z10) {
        if (this.f20314n != z10) {
            this.f20314n = z10;
            this.f20318r.cancel();
            this.f20317q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void P() {
        this.f20308h.setOnTouchListener(new o(this));
        if (f20304s) {
            this.f20308h.setOnDismissListener(new p(this));
        }
        this.f20308h.setThreshold(0);
    }

    private void Q() {
        if (this.f20308h != null) {
            if (G()) {
                this.f20313m = false;
            }
            if (!this.f20313m) {
                if (f20304s) {
                    O(!this.f20314n);
                } else {
                    this.f20314n = !this.f20314n;
                    r();
                }
                if (this.f20314n) {
                    this.f20308h.requestFocus();
                    this.f20308h.showDropDown();
                    return;
                }
                this.f20308h.dismissDropDown();
                return;
            }
            this.f20313m = false;
        }
    }

    private void R() {
        this.f20313m = true;
        this.f20315o = System.currentTimeMillis();
    }

    public void a(Editable editable) {
        if (this.f20316p.isTouchExplorationEnabled() && r.a(this.f20308h) && !this.f20350d.hasFocus()) {
            this.f20308h.dismissDropDown();
        }
        this.f20308h.post(new n(this));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return j.exposed_dropdown_menu_content_description;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return f20304s ? e.mtrl_dropdown_arrow : e.mtrl_ic_arrow_drop_down;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f20310j;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f20309i;
    }

    public c.b h() {
        return this.f20311k;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i10) {
        return i10 != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f20312l;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f20314n;
    }

    public void n(EditText editText) {
        this.f20308h = D(editText);
        P();
        this.f20347a.setErrorIconDrawable((Drawable) null);
        if (!r.a(editText) && this.f20316p.isTouchExplorationEnabled()) {
            n0.D0(this.f20350d, 2);
        }
        this.f20347a.setEndIconVisible(true);
    }

    public void o(View view, @NonNull k kVar) {
        if (!r.a(this.f20308h)) {
            kVar.a0(Spinner.class.getName());
        }
        if (kVar.L()) {
            kVar.l0((CharSequence) null);
        }
    }

    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 1 && this.f20316p.isEnabled() && !r.a(this.f20308h)) {
            Q();
            R();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        F();
        this.f20316p = (AccessibilityManager) this.f20349c.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f20308h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
            if (f20304s) {
                this.f20308h.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
            }
        }
    }
}
