package com.coffeemeetsbagel.upsell_banner;

import b6.s;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.upsell_banner.UpsellBannerPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class i extends s<UpsellBannerPresenter, n> implements UpsellBannerPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    private final String f37566f;

    /* renamed from: g  reason: collision with root package name */
    private final a f37567g;

    /* renamed from: h  reason: collision with root package name */
    public a7.a f37568h;

    /* renamed from: j  reason: collision with root package name */
    private final String f37569j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, String> f37570k;

    /* renamed from: l  reason: collision with root package name */
    private final PurchaseSource f37571l;

    public interface a {
        void a();

        void b();
    }

    public i(boolean z10, String str, a aVar) {
        j.g(str, "screenSource");
        j.g(aVar, "parentListener");
        this.f37566f = str;
        this.f37567g = aVar;
        String simpleName = i.class.getSimpleName();
        j.f(simpleName, "this::class.java.simpleName");
        this.f37569j = simpleName;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f37570k = linkedHashMap;
        PurchaseSource purchaseSource = new PurchaseSource();
        purchaseSource.d("Subscription Banner");
        purchaseSource.e(str);
        this.f37571l = purchaseSource;
        linkedHashMap.put("is_free_trial", String.valueOf(z10));
        String c10 = purchaseSource.c();
        j.f(c10, "purchaseSource.screenSource");
        linkedHashMap.put("screen source", c10);
        String a10 = purchaseSource.a();
        j.f(a10, "purchaseSource.featureSource");
        linkedHashMap.put("feature source", a10);
    }

    public final a7.a H1() {
        a7.a aVar = this.f37568h;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public void n0() {
        H1().trackEvent("Subscription Banner - Dismissed", this.f37570k);
        fa.a.f40771d.a(this.f37569j, "Hiding in response to user action.");
        ((UpsellBannerPresenter) this.f7875e).r();
        this.f37567g.b();
    }

    public void t() {
        H1().trackEvent("Subscription Banner - Action Tapped", this.f37570k);
        this.f37567g.a();
    }
}
