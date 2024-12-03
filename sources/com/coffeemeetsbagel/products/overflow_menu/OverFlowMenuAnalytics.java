package com.coffeemeetsbagel.products.overflow_menu;

import gk.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class OverFlowMenuAnalytics {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35904b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f35905a;

    public enum Location {
        PROFILE,
        CHAT
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OverFlowMenuAnalytics(a7.a aVar) {
        j.g(aVar, "analyticsManager");
        this.f35905a = aVar;
    }

    public final void a(String str, Location location) {
        j.g(str, "itemName");
        j.g(location, "location");
        this.f35905a.trackEvent("Overflow Menu Click", h0.l(h.a("location", location.toString()), h.a("item", str)));
    }
}
