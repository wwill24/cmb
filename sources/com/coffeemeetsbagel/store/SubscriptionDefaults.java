package com.coffeemeetsbagel.store;

import android.content.Context;
import android.content.res.Resources;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import vb.b;

public final class SubscriptionDefaults {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36739a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f36740b;

    /* renamed from: c  reason: collision with root package name */
    private final f f36741c = b.b(new SubscriptionDefaults$subscriptionBenefits$2(this));

    public SubscriptionDefaults(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f36739a = context;
        Resources resources = context.getResources();
        j.f(resources, "context.resources");
        this.f36740b = resources;
    }

    /* access modifiers changed from: private */
    public final b d() {
        List j10 = q.j();
        String string = this.f36740b.getString(r0.cmb_premium_activity_report_explanation);
        j.f(string, "resources.getString(R.st…ivity_report_explanation)");
        String string2 = this.f36740b.getString(r0.cmb_premium_activity_report);
        j.f(string2, "resources.getString(R.st…_premium_activity_report)");
        return new b("activity_reports", j10, string, "", "", string2, (String) null);
    }

    /* access modifiers changed from: private */
    public final b f() {
        List j10 = q.j();
        String string = this.f36740b.getString(r0.likes_you_description);
        j.f(string, "resources.getString(R.st…ng.likes_you_description)");
        String string2 = this.f36740b.getString(r0.likes_you_title);
        j.f(string2, "resources.getString(R.string.likes_you_title)");
        return new b("likes_you", j10, string, "", "", string2, (String) null);
    }

    /* access modifiers changed from: private */
    public final b g() {
        List j10 = q.j();
        String string = this.f36740b.getString(r0.cmb_premium_read_receipt_explanation);
        j.f(string, "resources.getString(R.st…read_receipt_explanation)");
        String string2 = this.f36740b.getString(r0.cmb_premium_read_receipt);
        j.f(string2, "resources.getString(R.st…cmb_premium_read_receipt)");
        return new b("read_receipt", j10, string, "", "", string2, (String) null);
    }

    public final Map<String, b> e() {
        return (Map) this.f36741c.getValue();
    }
}
