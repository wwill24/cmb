package xb;

import android.content.Context;
import android.view.View;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter;
import kotlin.jvm.internal.j;
import ub.h;
import vb.c;

public final class k extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final h f42155e;

    /* renamed from: f  reason: collision with root package name */
    private final a f42156f;

    /* renamed from: g  reason: collision with root package name */
    private SubscriptionComparisonsAdapter f42157g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(h hVar, a aVar) {
        super(hVar.getRoot());
        j.g(hVar, "subscriptionComparisionsBinding");
        j.g(aVar, "userInteractionListener");
        this.f42155e = hVar;
        this.f42156f = aVar;
    }

    private final void n(c cVar, c cVar2) {
        this.f42155e.f41995c.setOnClickListener(new i(this, cVar2));
        this.f42155e.f41996d.setOnClickListener(new j(this, cVar));
    }

    /* access modifiers changed from: private */
    public static final void o(k kVar, c cVar, View view) {
        j.g(kVar, "this$0");
        j.g(cVar, "$upsellBundle");
        kVar.f42156f.g1(cVar);
    }

    /* access modifiers changed from: private */
    public static final void p(k kVar, c cVar, View view) {
        j.g(kVar, "this$0");
        j.g(cVar, "$baseBundle");
        kVar.f42156f.g1(cVar);
    }

    private final void q(String str, String str2, String str3, String str4) {
        boolean z10;
        this.f42155e.f42001j.setText(str);
        this.f42155e.f41997e.setText(str2);
        this.f42155e.f41995c.setText(str3);
        this.f42155e.f41996d.setText(str4);
        if (str4.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f42155e.f41996d.setVisibility(8);
        } else {
            this.f42155e.f41996d.setVisibility(0);
        }
    }

    public final void l(c cVar, c cVar2) {
        j.g(cVar, "baseBundle");
        j.g(cVar2, "upsellBundle");
        Context context = this.f42155e.getRoot().getContext();
        SubscriptionComparisonsAdapter subscriptionComparisonsAdapter = new SubscriptionComparisonsAdapter(false, cVar, cVar2);
        this.f42157g = subscriptionComparisonsAdapter;
        this.f42155e.f41994b.setAdapter(subscriptionComparisonsAdapter);
        SubscriptionComparisonsAdapter subscriptionComparisonsAdapter2 = this.f42157g;
        if (subscriptionComparisonsAdapter2 == null) {
            j.y("adapter");
            subscriptionComparisonsAdapter2 = null;
        }
        subscriptionComparisonsAdapter2.J(cVar2.a());
        n(cVar, cVar2);
        String string = context.getString(R.string.premium_upsell_comparison_title, new Object[]{cVar2.d(), cVar.d()});
        j.f(string, "context.getString(R.stri…le.name, baseBundle.name)");
        String string2 = context.getString(R.string.premium_upsell_comparison_text, new Object[]{cVar2.d(), cVar.d()});
        j.f(string2, "context.getString(R.stri…le.name, baseBundle.name)");
        String string3 = context.getString(R.string.premium_upsell_continue_with, new Object[]{cVar2.d()});
        j.f(string3, "context.getString(R.stri…_with, upsellBundle.name)");
        String string4 = context.getString(R.string.premium_upsell_continue_with, new Object[]{cVar.d()});
        j.f(string4, "context.getString(R.stri…ue_with, baseBundle.name)");
        q(string, string2, string3, string4);
    }

    public final void m(c cVar, c cVar2) {
        j.g(cVar, "baseBundle");
        j.g(cVar2, "upsellBundle");
        Context context = this.f42155e.getRoot().getContext();
        SubscriptionComparisonsAdapter subscriptionComparisonsAdapter = new SubscriptionComparisonsAdapter(true, cVar, cVar2);
        this.f42157g = subscriptionComparisonsAdapter;
        this.f42155e.f41994b.setAdapter(subscriptionComparisonsAdapter);
        SubscriptionComparisonsAdapter subscriptionComparisonsAdapter2 = this.f42157g;
        if (subscriptionComparisonsAdapter2 == null) {
            j.y("adapter");
            subscriptionComparisonsAdapter2 = null;
        }
        subscriptionComparisonsAdapter2.J(cVar2.a());
        n(cVar, cVar2);
        String string = context.getString(R.string.premium_upsell_upgrade_title, new Object[]{cVar2.d()});
        j.f(string, "context.getString(R.stri…title, upsellBundle.name)");
        String string2 = context.getString(R.string.premium_upsell_upgrade_text, new Object[]{cVar.d()});
        j.f(string2, "context.getString(R.stri…de_text, baseBundle.name)");
        String string3 = context.getString(R.string.premium_upsell_continue_with, new Object[]{cVar2.d()});
        j.f(string3, "context.getString(R.stri…_with, upsellBundle.name)");
        q(string, string2, string3, "");
    }
}
