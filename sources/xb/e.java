package xb;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellInteractor;
import java.util.List;
import kotlin.Pair;
import ub.h;

public final class e extends b6.c<l, a> {

    public interface a {
        UserRepository C();

        PremiumUpsellAnalytics S();

        SubscriptionRepository Z();
    }

    public interface b extends j<g> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final h f42142a;

        /* renamed from: b  reason: collision with root package name */
        private final a f42143b;

        public c(h hVar, a aVar) {
            kotlin.jvm.internal.j.g(hVar, "binding");
            kotlin.jvm.internal.j.g(aVar, "userInteractionListener");
            this.f42142a = hVar;
            this.f42143b = aVar;
        }

        public final k a() {
            return new k(this.f42142a, this.f42143b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final l b(ViewGroup viewGroup, PurchaseSource purchaseSource, List<vb.c> list, PremiumUpsellInteractor.a aVar, Pair<vb.a, vb.c> pair) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(purchaseSource, "purchaseSource");
        kotlin.jvm.internal.j.g(list, "bundles");
        kotlin.jvm.internal.j.g(aVar, "callbackListener");
        g gVar = new g(purchaseSource, list, aVar, pair);
        h c10 = h.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = c.a().c(new c(c10, gVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(c10, a10, gVar);
    }
}
