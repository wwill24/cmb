package wb;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import fk.a;

public final class d implements fj.d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SubscriptionRepository> f42112a;

    public d(a<SubscriptionRepository> aVar) {
        this.f42112a = aVar;
    }

    public static d a(a<SubscriptionRepository> aVar) {
        return new d(aVar);
    }

    public static c c(SubscriptionRepository subscriptionRepository) {
        return new c(subscriptionRepository);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f42112a.get());
    }
}
