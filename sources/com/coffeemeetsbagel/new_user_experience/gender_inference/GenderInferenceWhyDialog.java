package com.coffeemeetsbagel.new_user_experience.gender_inference;

import android.content.Context;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class GenderInferenceWhyDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final GenderInferenceWhyDialog f35035a = new GenderInferenceWhyDialog();

    private GenderInferenceWhyDialog() {
    }

    public final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(R.drawable.ic_gender_inference_why);
        String string = context.getString(R.string.gender_pref_dialog_title);
        j.f(string, "context.getString(R.stri…gender_pref_dialog_title)");
        String string2 = context.getString(R.string.gender_pref_dialog_body);
        j.f(string2, "context.getString(R.stri….gender_pref_dialog_body)");
        String string3 = context.getString(R.string.premium_upsell_error_primary_cta);
        j.f(string3, "context.getString(R.stri…upsell_error_primary_cta)");
        DialogPrimarySecondaryVertical.a.d(aVar, context, primaryCtaStyle, valueOf, string, string2, string3, GenderInferenceWhyDialog$show$1.f35036a, (String) null, (Function0) null, (Function0) null, 896, (Object) null);
    }
}
