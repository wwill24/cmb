package y4;

import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import java.util.function.Predicate;
import vb.b;

public final /* synthetic */ class n implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionBenefitAttribution f18704a;

    public /* synthetic */ n(SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        this.f18704a = subscriptionBenefitAttribution;
    }

    public final boolean test(Object obj) {
        return ((b) obj).a().contains(this.f18704a.c());
    }
}
