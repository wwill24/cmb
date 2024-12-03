package com.coffeemeetsbagel.new_user_experience.introductions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextInputEditText;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.new_user_experience.OnboardingTextInputLayout;
import com.coffeemeetsbagel.new_user_experience.introductions.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class IntroductionsPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35083e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35084f;

    /* renamed from: g  reason: collision with root package name */
    private final String f35085g;

    /* renamed from: h  reason: collision with root package name */
    private View f35086h;

    public interface a {
        void H0(String str);

        void Y0();

        void a();

        void r0(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntroductionsPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35083e = aVar;
        String string = viewGroup.getContext().getString(R.string.name_input_error);
        j.f(string, "view.context.getString(R.string.name_input_error)");
        this.f35084f = string;
        String string2 = viewGroup.getContext().getString(R.string.onboarding_save_error);
        j.f(string2, "view.context.getString(R…ng.onboarding_save_error)");
        this.f35085g = string2;
    }

    /* access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final String q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final String t(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void v(IntroductionsPresenter introductionsPresenter, View view) {
        j.g(introductionsPresenter, "this$0");
        introductionsPresenter.f35083e.Y0();
    }

    public final void A() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        View view = this.f35086h;
        if (view != null && (animate = view.animate()) != null && (duration = animate.setDuration(150)) != null) {
            duration.alpha(0.0f);
        }
    }

    public final void B() {
        ((OnboardingTextInputLayout) ((ViewGroup) this.f7869c).findViewById(R.id.first_name_container)).y0(false);
    }

    public final void C() {
        ((OnboardingTextInputLayout) ((ViewGroup) this.f7869c).findViewById(R.id.last_name_container)).y0(false);
    }

    public final void D(String str, Function0<Unit> function0) {
        String str2 = str;
        j.g(str2, "firstName");
        Function0<Unit> function02 = function0;
        j.g(function02, "primaryClickListener");
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        String string = ((ViewGroup) this.f7869c).getContext().getString(R.string.onboarding_name_confirm_dialog_title, new Object[]{str2});
        j.f(string, "view.context.getString(R…_dialog_title, firstName)");
        String string2 = ((ViewGroup) this.f7869c).getContext().getString(R.string.onboarding_name_confirm_dialog_body);
        j.f(string2, "view.context.getString(R…name_confirm_dialog_body)");
        String string3 = ((ViewGroup) this.f7869c).getContext().getString(R.string.onboarding_name_confirm_dialog_confirm);
        j.f(string3, "view.context.getString(R…e_confirm_dialog_confirm)");
        DialogPrimarySecondaryVertical.a.d(aVar, context, primaryCtaStyle, (Integer) null, string, string2, string3, function02, ((ViewGroup) this.f7869c).getContext().getString(R.string.onboarding_name_confirm_dialog_cancel), (Function0) null, (Function0) null, 512, (Object) null);
    }

    public final void E() {
        ((OnboardingTextInputLayout) ((ViewGroup) this.f7869c).findViewById(R.id.first_name_container)).y0(true);
    }

    public final void F() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        View view = this.f35086h;
        if (view != null && (animate = view.animate()) != null && (duration = animate.setDuration(150)) != null) {
            duration.alpha(1.0f);
        }
    }

    public final void G() {
        ((OnboardingTextInputLayout) ((ViewGroup) this.f7869c).findViewById(R.id.last_name_container)).y0(true);
    }

    public final void H(r.a aVar) {
        j.g(aVar, "tracker");
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        new r(context, aVar).show();
    }

    public final void I(String str, String str2) {
        ((CmbTextInputEditText) ((ViewGroup) this.f7869c).findViewById(R.id.first_name)).setText(str);
        ((CmbTextInputEditText) ((ViewGroup) this.f7869c).findViewById(R.id.last_name)).setText(str2);
    }

    public final void J(boolean z10) {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(z10);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.introductions_message)).setText(t9.a.onboardingIntroductionsHeader);
        CmbButton cmbButton = (CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button);
        cmbButton.setEnabled(false);
        ((com.uber.autodispose.p) cmbButton.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new j(new IntroductionsPresenter$didLoad$1(this)));
        ((com.uber.autodispose.p) ((CmbTextInputEditText) ((ViewGroup) this.f7869c).findViewById(R.id.first_name)).g().W(new k(IntroductionsPresenter$didLoad$2.f35087a)).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l(new IntroductionsPresenter$didLoad$3(this)));
        ((com.uber.autodispose.p) ((CmbTextInputEditText) ((ViewGroup) this.f7869c).findViewById(R.id.last_name)).g().W(new m(IntroductionsPresenter$didLoad$4.f35088a)).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new n(new IntroductionsPresenter$didLoad$5(this)));
        View findViewById = ((ViewGroup) this.f7869c).findViewById(R.id.last_name_explanation_button);
        this.f35086h = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new o(this));
        }
    }

    public final String w() {
        return this.f35084f;
    }

    public final a y() {
        return this.f35083e;
    }

    public final String z() {
        return this.f35085g;
    }
}
