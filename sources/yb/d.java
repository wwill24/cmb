package yb;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f42163a = new d();

    private d() {
    }

    public final SuggestedLimitsEntity a(SuggestedLimitsNetworkResponse suggestedLimitsNetworkResponse) {
        j.g(suggestedLimitsNetworkResponse, "networkLimits");
        return new SuggestedLimitsEntity(0, suggestedLimitsNetworkResponse.getRemainingLikes(), suggestedLimitsNetworkResponse.getRemainingViews(), suggestedLimitsNetworkResponse.getNumBagelsRequiredForUpsell(), 1, (DefaultConstructorMarker) null);
    }
}
