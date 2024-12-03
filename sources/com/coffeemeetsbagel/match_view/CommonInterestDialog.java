package com.coffeemeetsbagel.match_view;

import android.content.Context;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class CommonInterestDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final CommonInterestDialog f34595a = new CommonInterestDialog();

    private CommonInterestDialog() {
    }

    public final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(R.drawable.ic_common_interests_dialog);
        String string = context.getString(R.string.common_interest_title);
        j.f(string, "context.getString(R.string.common_interest_title)");
        String string2 = context.getString(R.string.common_interest_body);
        j.f(string2, "context.getString(R.string.common_interest_body)");
        String string3 = context.getString(R.string.common_interest_cta);
        j.f(string3, "context.getString(R.string.common_interest_cta)");
        DialogPrimarySecondaryVertical.a.d(aVar, context, primaryCtaStyle, valueOf, string, string2, string3, CommonInterestDialog$show$1.f34596a, (String) null, (Function0) null, (Function0) null, 896, (Object) null);
    }
}
