package com.coffeemeetsbagel.store;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class UpsellErrorDialog$show$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpsellErrorDialog$show$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final void invoke() {
        new d.a().a().a(this.$context, Uri.parse(this.$context.getString(r0.zendesk_url_request)));
    }
}
