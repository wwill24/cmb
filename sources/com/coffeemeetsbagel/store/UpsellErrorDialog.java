package com.coffeemeetsbagel.store;

import android.content.Context;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class UpsellErrorDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final UpsellErrorDialog f36742a = new UpsellErrorDialog();

    private UpsellErrorDialog() {
    }

    public final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(m0.ic_upsell_error_dialog);
        String string = context.getString(r0.premium_upsell_error_title);
        j.f(string, "context.getString(R.stri…emium_upsell_error_title)");
        String string2 = context.getString(r0.premium_upsell_error_text);
        j.f(string2, "context.getString(R.stri…remium_upsell_error_text)");
        String string3 = context.getString(r0.premium_upsell_error_primary_cta);
        j.f(string3, "context.getString(R.stri…upsell_error_primary_cta)");
        aVar.b(context, primaryCtaStyle, valueOf, string, string2, string3, UpsellErrorDialog$show$1.f36743a, context.getString(r0.premium_upsell_error_secondary_cta), new UpsellErrorDialog$show$2(context), UpsellErrorDialog$show$3.f36744a);
    }
}
