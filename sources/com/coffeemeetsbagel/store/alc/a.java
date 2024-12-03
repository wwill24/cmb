package com.coffeemeetsbagel.store.alc;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import gk.h;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f36766a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseContract.Analytics f36767b;

    public a(a7.a aVar, FirebaseContract.Analytics analytics) {
        j.g(aVar, "analytics");
        j.g(analytics, "firebase");
        this.f36766a = aVar;
        this.f36767b = analytics;
    }

    public final void a(String str, int i10, int i11) {
        j.g(str, "itemName");
        this.f36766a.j("Purchased Item", h0.l(h.a("item", str), h.a("beans", String.valueOf(i11)), h.a(FirebaseAnalytics.Param.QUANTITY, String.valueOf(i10)), h.a(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT)));
        this.f36767b.logSpendingVirtualCurrency((long) i10, "instant like failure", (long) i11);
    }

    public final void b(String str, int i10, int i11) {
        j.g(str, "itemName");
        this.f36766a.j("Purchased Item", h0.l(h.a("item", str), h.a("beans", String.valueOf(i11)), h.a(FirebaseAnalytics.Param.QUANTITY, String.valueOf(i10)), h.a(MamElements.MamResultExtension.ELEMENT, "succeeded")));
        this.f36766a.trackEvent(AFInAppEventType.SPENT_CREDIT, h0.l(h.a(AFInAppEventParameterName.CONTENT_ID, str), h.a(AFInAppEventParameterName.PRICE, String.valueOf(i11))));
        this.f36767b.logSpendingVirtualCurrency((long) i10, "instant like success", (long) i11);
    }
}
