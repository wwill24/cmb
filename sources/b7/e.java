package b7;

import com.coffeemeetsbagel.feature.analyticstracking.models.AnalyticsTrackingFlowBody;
import com.coffeemeetsbagel.feature.analyticstracking.models.AnalyticsTrackingResponse;
import retrofit2.b;
import vn.a;
import vn.o;

public interface e {
    @o("/analytics/flowlatency")
    b<AnalyticsTrackingResponse> a(@a AnalyticsTrackingFlowBody analyticsTrackingFlowBody);
}
