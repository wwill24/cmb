package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import i4.b;

public class i extends d {

    /* renamed from: a  reason: collision with root package name */
    private final b f17822a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17823b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f17824c;

    /* renamed from: d  reason: collision with root package name */
    private final p f17825d;

    public i(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, b bVar) {
        this.f17823b = cVar;
        this.f17824c = cleverTapInstanceConfig;
        this.f17825d = cleverTapInstanceConfig.n();
        this.f17822a = bVar;
    }

    public void a(org.json.b bVar, String str, Context context) {
        this.f17825d.t(this.f17824c.e(), "Processing GeoFences response...");
        if (this.f17824c.p()) {
            this.f17825d.t(this.f17824c.e(), "CleverTap instance is configured to analytics only, not processing geofence response");
            this.f17823b.a(bVar, str, context);
        } else if (bVar == null) {
            this.f17825d.t(this.f17824c.e(), "Geofences : Can't parse Geofences Response, JSON response object is null");
        } else if (!bVar.has("geofences")) {
            this.f17825d.t(this.f17824c.e(), "Geofences : JSON object doesn't contain the Geofences key");
            this.f17823b.a(bVar, str, context);
        } else {
            try {
                if (this.f17822a.e() != null) {
                    org.json.b bVar2 = new org.json.b();
                    bVar2.put("geofences", (Object) bVar.getJSONArray("geofences"));
                    this.f17825d.t(this.f17824c.e(), "Geofences : Processing Geofences response");
                    this.f17822a.e().b(bVar2);
                } else {
                    this.f17825d.f(this.f17824c.e(), "Geofences : Geofence SDK has not been initialized to handle the response");
                }
            } catch (Throwable th2) {
                this.f17825d.u(this.f17824c.e(), "Geofences : Failed to handle Geofences response", th2);
            }
            this.f17823b.a(bVar, str, context);
        }
    }
}
