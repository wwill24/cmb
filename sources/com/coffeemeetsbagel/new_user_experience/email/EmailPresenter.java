package com.coffeemeetsbagel.new_user_experience.email;

import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageButton;
import com.coffeemeetsbagel.cmb_views.CmbTextInputEditText;
import j5.x;
import java.util.Arrays;
import java.util.IllegalFormatException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import qj.q;

public final class EmailPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f34961e;

    /* renamed from: f  reason: collision with root package name */
    private final String f34962f;

    /* renamed from: g  reason: collision with root package name */
    private final String f34963g;

    public interface a {
        void L0(String str);

        void a();

        void w0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f34961e = aVar;
        String string = viewGroup.getContext().getString(R.string.onboarding_save_error);
        j.f(string, "view.context.getString(R…ng.onboarding_save_error)");
        this.f34962f = string;
        String string2 = viewGroup.getContext().getString(R.string.contains_emoji_error);
        j.f(string2, "view.context.getString(R…ing.contains_emoji_error)");
        this.f34963g = string2;
    }

    /* access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final String o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        q<x> a10;
        q<x> a02;
        com.uber.autodispose.p pVar;
        super.d();
        CmbButton cmbButton = (CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button);
        if (cmbButton != null) {
            cmbButton.setEnabled(false);
        }
        if (!(cmbButton == null || (a10 = cmbButton.a()) == null || (a02 = a10.a0(sj.a.a())) == null || (pVar = (com.uber.autodispose.p) a02.g(com.uber.autodispose.a.a(this))) == null)) {
            pVar.c(new h(new EmailPresenter$didLoad$1(this)));
        }
        ((com.uber.autodispose.p) ((CmbTextInputEditText) ((ViewGroup) this.f7869c).findViewById(R.id.email_input)).g().a0(sj.a.a()).W(new i(EmailPresenter$didLoad$2.f34964a)).g(com.uber.autodispose.a.a(this))).c(new j(new EmailPresenter$didLoad$3(this)));
        ((com.uber.autodispose.p) ((CmbImageButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new EmailPresenter$didLoad$4(this)));
    }

    public final void r(boolean z10) {
        CmbButton cmbButton = (CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button);
        if (cmbButton != null) {
            cmbButton.setEnabled(z10);
        }
    }

    public final String t() {
        return this.f34963g;
    }

    public final a u() {
        return this.f34961e;
    }

    public final String v() {
        return this.f34962f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r3 == true) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "email"
            kotlin.jvm.internal.j.g(r5, r0)
            V r0 = r4.f7869c
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = 2131296773(0x7f090205, float:1.8211472E38)
            android.view.View r0 = r0.findViewById(r1)
            com.coffeemeetsbagel.new_user_experience.OnboardingTextInputLayout r0 = (com.coffeemeetsbagel.new_user_experience.OnboardingTextInputLayout) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002e
            android.widget.EditText r3 = r0.getEditText()
            if (r3 == 0) goto L_0x002e
            android.text.Editable r3 = r3.getText()
            if (r3 == 0) goto L_0x002e
            int r3 = r3.length()
            if (r3 != 0) goto L_0x002a
            r3 = r1
            goto L_0x002b
        L_0x002a:
            r3 = r2
        L_0x002b:
            if (r3 != r1) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            if (r1 == 0) goto L_0x003a
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x003a
            r0.setText(r5)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.email.EmailPresenter.w(java.lang.String):void");
    }

    public final void y(String str) {
        String str2;
        j.g(str, "name");
        try {
            o oVar = o.f32141a;
            String str3 = t9.a.onboardingEmailHeader;
            j.f(str3, "onboardingEmailHeader");
            str2 = String.format(str3, Arrays.copyOf(new Object[]{str}, 1));
            j.f(str2, "format(format, *args)");
        } catch (IllegalFormatException e10) {
            fa.a.f40771d.f(e10);
            str2 = t9.a.onboardingEmailHeader;
            j.f(str2, "{\n            // Probabl…dingEmailHeader\n        }");
        }
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message)).setText(str2);
    }
}
