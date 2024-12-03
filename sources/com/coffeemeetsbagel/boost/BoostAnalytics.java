package com.coffeemeetsbagel.boost;

import a7.a;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import gk.h;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class BoostAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private final a f11408a;

    public enum BoostResultType {
        SUCCESSFUL("purchased"),
        FAIlED(StreamManagement.Failed.ELEMENT),
        CANCELLED_INSUFFICIENT_FUNDS("cancelled_insufficient_funds"),
        CANCELLED_SUFFICIENT_FUNDS("cancelled_sufficient_funds");
        
        private final String value;

        private BoostResultType(String str) {
            this.value = str;
        }

        public final String b() {
            return this.value;
        }
    }

    public BoostAnalytics(a aVar) {
        j.g(aVar, "analytics");
        this.f11408a = aVar;
    }

    private final void b(BoostResultType boostResultType, BoostPaymentType boostPaymentType) {
        Map map;
        if (boostPaymentType != null) {
            map = h0.l(h.a(MamElements.MamResultExtension.ELEMENT, boostResultType.b()), h.a("payment", boostPaymentType.b()));
        } else {
            map = g0.f(h.a(MamElements.MamResultExtension.ELEMENT, boostResultType.b()));
        }
        this.f11408a.trackEvent("Boost Purchase Sheet", map);
    }

    public final void a() {
        this.f11408a.d("Boost Purchase Sheet - Boost Me Tapped");
    }

    public final void c(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            b(BoostResultType.CANCELLED_SUFFICIENT_FUNDS, (BoostPaymentType) null);
        } else {
            b(BoostResultType.CANCELLED_INSUFFICIENT_FUNDS, (BoostPaymentType) null);
        }
    }

    public final void d(BoostPaymentType boostPaymentType) {
        j.g(boostPaymentType, "paymentType");
        b(BoostResultType.SUCCESSFUL, boostPaymentType);
    }

    public final void e(BoostPaymentType boostPaymentType) {
        j.g(boostPaymentType, "paymentType");
        b(BoostResultType.FAIlED, boostPaymentType);
    }

    public final void f() {
        this.f11408a.d("Boost Purchase Sheet - Dismiss Tapped");
    }

    public final void g() {
        this.f11408a.trackEvent("Not Enough Beans Tapped", h0.l(h.a("source", PurchaseType.BOOST.a()), h.a("Destination Flow", "Bean Shop Flow")));
    }

    public final void h() {
        this.f11408a.trackEvent("Not Enough Beans Viewed", h0.l(h.a("source", PurchaseType.BOOST.a()), h.a("Destination Flow", "Bean Shop Flow")));
    }
}
