package wb;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import fj.d;
import fk.a;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SubscriptionRepository> f42110a;

    public b(a<SubscriptionRepository> aVar) {
        this.f42110a = aVar;
    }

    public static b a(a<SubscriptionRepository> aVar) {
        return new b(aVar);
    }

    public static a c(SubscriptionRepository subscriptionRepository) {
        return new a(subscriptionRepository);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f42110a.get());
    }
}
