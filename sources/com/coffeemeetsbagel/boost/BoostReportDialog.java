package com.coffeemeetsbagel.boost;

import android.content.Context;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.google.firebase.database.core.ValidationPath;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class BoostReportDialog {
    public final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(j.ic_boost_report);
        String string = context.getString(m.boost_report_title);
        j.f(string, "context.getString(R.string.boost_report_title)");
        String string2 = context.getString(m.boost_report_body);
        j.f(string2, "context.getString(R.string.boost_report_body)");
        String string3 = context.getString(m.boost_report_secondary_cta);
        j.f(string3, "context.getString(R.stri…ost_report_secondary_cta)");
        DialogPrimarySecondaryVertical.a.d(aVar, context, primaryCtaStyle, valueOf, string, string2, string3, BoostReportDialog$showReport$1.f11434a, (String) null, (Function0) null, (Function0) null, 896, (Object) null);
    }

    public final void b(Context context, Function0<Unit> function0) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(function0, "primaryClickListener");
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(j.ic_boost_report);
        String string = context.getString(m.boost_report_title);
        j.f(string, "context.getString(R.string.boost_report_title)");
        String string2 = context.getString(m.boost_report_body);
        j.f(string2, "context.getString(R.string.boost_report_body)");
        String string3 = context.getString(m.boost_report_primary_cta, new Object[]{3});
        j.f(string3, "context.getString(R.stri…st_report_primary_cta, 3)");
        DialogPrimarySecondaryVertical.a.d(aVar, context, primaryCtaStyle, valueOf, string, string2, string3, function0, context.getString(m.boost_report_secondary_cta), (Function0) null, (Function0) null, ValidationPath.MAX_PATH_LENGTH_BYTES, (Object) null);
    }
}
