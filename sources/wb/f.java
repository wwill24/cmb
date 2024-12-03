package wb;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import fj.d;
import fk.a;

public final class f implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SubscriptionRepository> f42114a;

    public f(a<SubscriptionRepository> aVar) {
        this.f42114a = aVar;
    }

    public static f a(a<SubscriptionRepository> aVar) {
        return new f(aVar);
    }

    public static e c(SubscriptionRepository subscriptionRepository) {
        return new e(subscriptionRepository);
    }

    /* renamed from: b */
    public e get() {
        return c(this.f42114a.get());
    }
}
