package ma;

import com.coffeemeetsbagel.suggested.models.RefillBagelsNetwork;
import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import qj.w;
import vn.f;
import vn.t;

public interface k {
    @f("/v5/suggested/limits")
    w<SuggestedLimitsNetworkResponse> a();

    @f("/v5/suggested/refill_bagels")
    w<RefillBagelsNetwork> b(@t("page") String str);
}
