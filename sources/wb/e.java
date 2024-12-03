package wb;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import kotlin.jvm.internal.j;
import qj.a;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final SubscriptionRepository f42113a;

    public e(SubscriptionRepository subscriptionRepository) {
        j.g(subscriptionRepository, "repository");
        this.f42113a = subscriptionRepository;
    }

    public final a a() {
        return this.f42113a.C0(true);
    }
}
