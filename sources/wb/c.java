package wb;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.internal.j;
import qj.h;
import vb.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final SubscriptionRepository f42111a;

    public c(SubscriptionRepository subscriptionRepository) {
        j.g(subscriptionRepository, "subscriptionRepository");
        this.f42111a = subscriptionRepository;
    }

    public final h<Optional<a>> a() {
        h<Optional<a>> v10 = this.f42111a.T().v();
        j.f(v10, "subscriptionRepository.g…().distinctUntilChanged()");
        return v10;
    }
}
