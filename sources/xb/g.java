package xb;

import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellInteractor;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;

public final class g extends s<k, l> implements a {

    /* renamed from: f  reason: collision with root package name */
    private final PurchaseSource f42144f;

    /* renamed from: g  reason: collision with root package name */
    private final List<c> f42145g;

    /* renamed from: h  reason: collision with root package name */
    private final PremiumUpsellInteractor.a f42146h;

    /* renamed from: j  reason: collision with root package name */
    private final Pair<a, c> f42147j;

    /* renamed from: k  reason: collision with root package name */
    public SubscriptionRepository f42148k;

    /* renamed from: l  reason: collision with root package name */
    public UserRepository f42149l;

    /* renamed from: m  reason: collision with root package name */
    public PremiumUpsellAnalytics f42150m;

    public g(PurchaseSource purchaseSource, List<c> list, PremiumUpsellInteractor.a aVar, Pair<a, c> pair) {
        j.g(purchaseSource, "purchaseSource");
        j.g(list, "bundles");
        j.g(aVar, "callbackListener");
        this.f42144f = purchaseSource;
        this.f42145g = list;
        this.f42146h = aVar;
        this.f42147j = pair;
    }

    public final PremiumUpsellAnalytics H1() {
        PremiumUpsellAnalytics premiumUpsellAnalytics = this.f42150m;
        if (premiumUpsellAnalytics != null) {
            return premiumUpsellAnalytics;
        }
        j.y("tracker");
        return null;
    }

    public void g1(c cVar) {
        j.g(cVar, "bundle");
        this.f42146h.b(cVar);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        c cVar = (c) CollectionsKt___CollectionsKt.Y(this.f42145g);
        H1().m(PremiumUpsellAnalytics.DropOffPoint.COMPARE_PLAN);
        Pair<a, c> pair = this.f42147j;
        if (pair != null) {
            ((k) this.f7875e).m(pair.d(), cVar);
            return;
        }
        ((k) this.f7875e).l((c) CollectionsKt___CollectionsKt.N(this.f42145g), cVar);
    }
}
