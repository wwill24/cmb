package com.coffeemeetsbagel.instant_like;

import a7.a;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import gk.h;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f14024a;

    public d(a aVar) {
        j.g(aVar, "analytics");
        this.f14024a = aVar;
    }

    private final void a(InstantLikeResultType instantLikeResultType, boolean z10, InstantLikePaymentType instantLikePaymentType) {
        Map map;
        String str = "post_like";
        if (instantLikePaymentType != null) {
            Pair[] pairArr = new Pair[3];
            pairArr[0] = h.a(MamElements.MamResultExtension.ELEMENT, instantLikeResultType.b());
            pairArr[1] = h.a("payment", instantLikePaymentType.b());
            if (!z10) {
                str = "pre_like";
            }
            pairArr[2] = h.a("feature_source", str);
            map = h0.l(pairArr);
        } else {
            Pair[] pairArr2 = new Pair[2];
            pairArr2[0] = h.a(MamElements.MamResultExtension.ELEMENT, instantLikeResultType.b());
            if (!z10) {
                str = "pre_like";
            }
            pairArr2[1] = h.a("feature_source", str);
            map = h0.l(pairArr2);
        }
        this.f14024a.trackEvent("Instant Like Sheet", map);
    }

    public final void b(boolean z10, Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            a(InstantLikeResultType.CANCELLED_SUFFICIENT_FUNDS, z10, (InstantLikePaymentType) null);
        } else {
            a(InstantLikeResultType.CANCELLED_INSUFFICIENT_FUNDS, z10, (InstantLikePaymentType) null);
        }
    }

    public final void c(boolean z10, InstantLikePaymentType instantLikePaymentType) {
        j.g(instantLikePaymentType, "paymentType");
        a(InstantLikeResultType.SUCCESSFUL, z10, instantLikePaymentType);
    }

    public final void d(boolean z10, InstantLikePaymentType instantLikePaymentType) {
        j.g(instantLikePaymentType, "paymentType");
        a(InstantLikeResultType.FAIlED, z10, instantLikePaymentType);
    }

    public final void e() {
        this.f14024a.trackEvent("Not Enough Beans Tapped", h0.l(h.a("source", PurchaseType.INSTANT_LIKE.a()), h.a("Destination Flow", "Bean Shop Flow")));
    }

    public final void f() {
        this.f14024a.trackEvent("Not Enough Beans Viewed", h0.l(h.a("source", PurchaseType.INSTANT_LIKE.a()), h.a("Destination Flow", "Bean Shop Flow")));
    }

    public final void g() {
        this.f14024a.trackEvent("like_profile", h0.l(h.a("source", ModelDeeplinkData.VALUE_PAGE_SUGGESTED), h.a("type", "instant"), h.a("timestamp", String.valueOf(System.currentTimeMillis() / ((long) 1000)))));
    }

    public final void h() {
        this.f14024a.trackEvent("Instant Like Upsell Alert", h0.i());
    }
}
