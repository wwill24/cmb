package b7;

import androidx.annotation.NonNull;
import c7.d;
import com.coffeemeetsbagel.feature.analyticstracking.models.AnalyticsTrackingFlowBody;
import com.coffeemeetsbagel.feature.analyticstracking.models.AnalyticsTrackingResponse;
import retrofit2.b;
import retrofit2.r;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final d f7881a;

    /* renamed from: b7.a$a  reason: collision with other inner class name */
    class C0089a implements retrofit2.d<AnalyticsTrackingResponse> {
        C0089a() {
        }

        public void onFailure(@NonNull b<AnalyticsTrackingResponse> bVar, @NonNull Throwable th2) {
            fa.a.g("AnalyticsTrackingApi", "Failed to post to /analytics for flow latency", th2);
        }

        public void onResponse(@NonNull b<AnalyticsTrackingResponse> bVar, @NonNull r<AnalyticsTrackingResponse> rVar) {
            rVar.g();
        }
    }

    public a(d dVar) {
        this.f7881a = dVar;
    }

    private e b() {
        return (e) this.f7881a.c(e.class);
    }

    public void a(String str, long j10, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Event ");
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" Latency ");
        sb2.append(j10);
        b().a(new AnalyticsTrackingFlowBody(str, j10, str2)).L(new C0089a());
    }
}
