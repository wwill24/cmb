package com.coffeemeetsbagel.today_view.card.actioncards;

import gk.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0462a f37276b = new C0462a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f37277a;

    /* renamed from: com.coffeemeetsbagel.today_view.card.actioncards.a$a  reason: collision with other inner class name */
    public static final class C0462a {
        private C0462a() {
        }

        public /* synthetic */ C0462a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(a7.a aVar) {
        j.g(aVar, "analyticsManager");
        this.f37277a = aVar;
    }

    public final void a(int i10) {
        this.f37277a.trackEvent("No Eligible Action Card Found", g0.f(h.a("card_count", String.valueOf(i10))));
    }
}
