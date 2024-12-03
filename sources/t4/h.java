package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import i4.i;
import org.json.JSONException;
import org.json.b;

public class h extends d {

    /* renamed from: a  reason: collision with root package name */
    private final c f17818a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f17819b;

    /* renamed from: c  reason: collision with root package name */
    private final p f17820c;

    /* renamed from: d  reason: collision with root package name */
    private final i f17821d;

    public h(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, i iVar) {
        this.f17818a = cVar;
        this.f17819b = cleverTapInstanceConfig;
        this.f17820c = cleverTapInstanceConfig.n();
        this.f17821d = iVar;
    }

    private void b(b bVar) throws JSONException {
        if (bVar.getJSONArray("kv") == null || this.f17821d.d() == null) {
            this.f17819b.n().t(this.f17819b.e(), "Feature Flag : Can't parse feature flags, CTFeatureFlagsController is null");
        } else {
            this.f17821d.d().q(bVar);
        }
    }

    public void a(b bVar, String str, Context context) {
        this.f17820c.t(this.f17819b.e(), "Processing Feature Flags response...");
        if (this.f17819b.p()) {
            this.f17820c.t(this.f17819b.e(), "CleverTap instance is configured to analytics only, not processing Feature Flags response");
            this.f17818a.a(bVar, str, context);
        } else if (bVar == null) {
            this.f17820c.t(this.f17819b.e(), "Feature Flag : Can't parse Feature Flags Response, JSON response object is null");
        } else if (!bVar.has("ff_notifs")) {
            this.f17820c.t(this.f17819b.e(), "Feature Flag : JSON object doesn't contain the Feature Flags key");
            this.f17818a.a(bVar, str, context);
        } else {
            try {
                this.f17820c.t(this.f17819b.e(), "Feature Flag : Processing Feature Flags response");
                b(bVar.getJSONObject("ff_notifs"));
            } catch (Throwable th2) {
                this.f17820c.u(this.f17819b.e(), "Feature Flag : Failed to parse response", th2);
            }
            this.f17818a.a(bVar, str, context);
        }
    }
}
