package g6;

import com.coffeemeetsbagel.models.entities.SubscriptionState;
import kotlin.jvm.internal.j;

public final class o {
    public final SubscriptionState a(int i10) {
        return SubscriptionState.Companion.fromApiKey(Integer.valueOf(i10));
    }

    public final int b(SubscriptionState subscriptionState) {
        j.g(subscriptionState, "subscriptionState");
        return subscriptionState.getApiKey();
    }
}
