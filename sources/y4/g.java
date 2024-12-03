package y4;

import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import kotlin.Pair;
import vj.f;

public final /* synthetic */ class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityMain f18686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionBenefitAttribution f18687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PurchaseSource f18688c;

    public /* synthetic */ g(ActivityMain activityMain, SubscriptionBenefitAttribution subscriptionBenefitAttribution, PurchaseSource purchaseSource) {
        this.f18686a = activityMain;
        this.f18687b = subscriptionBenefitAttribution;
        this.f18688c = purchaseSource;
    }

    public final void accept(Object obj) {
        this.f18686a.O3(this.f18687b, this.f18688c, (Pair) obj);
    }
}
