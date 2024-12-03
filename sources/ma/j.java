package ma;

import com.coffeemeetsbagel.subscription.network.models.BenefitsResponse;
import com.coffeemeetsbagel.subscription.network.models.SubscriptionResponse;
import qj.w;
import vn.f;

public interface j {
    @f("/v5/subscriptions/benefits")
    w<BenefitsResponse> a();

    @f("/v5/subscriptions")
    w<SubscriptionResponse> b();
}
