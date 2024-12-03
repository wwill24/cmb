package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.p;
import i4.i;
import org.json.JSONException;
import org.json.b;

public class m extends d {

    /* renamed from: a  reason: collision with root package name */
    private final c f17844a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f17845b;

    /* renamed from: c  reason: collision with root package name */
    private final j f17846c;

    /* renamed from: d  reason: collision with root package name */
    private final p f17847d;

    /* renamed from: e  reason: collision with root package name */
    private final i f17848e;

    public m(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, j jVar, i iVar) {
        this.f17844a = cVar;
        this.f17845b = cleverTapInstanceConfig;
        this.f17847d = cleverTapInstanceConfig.n();
        this.f17846c = jVar;
        this.f17848e = iVar;
    }

    private void b() {
        if (this.f17846c.G()) {
            if (this.f17848e.f() != null) {
                this.f17848e.f().o();
            }
            this.f17846c.Z(false);
        }
    }

    private void c(b bVar) throws JSONException {
        if (bVar.getJSONArray("kv") == null || this.f17848e.f() == null) {
            b();
        } else {
            this.f17848e.f().p(bVar);
        }
    }

    public void a(b bVar, String str, Context context) {
        this.f17847d.t(this.f17845b.e(), "Processing Product Config response...");
        if (this.f17845b.p()) {
            this.f17847d.t(this.f17845b.e(), "CleverTap instance is configured to analytics only, not processing Product Config response");
            this.f17844a.a(bVar, str, context);
        } else if (bVar == null) {
            this.f17847d.t(this.f17845b.e(), "Product Config : Can't parse Product Config Response, JSON response object is null");
            b();
        } else if (!bVar.has("pc_notifs")) {
            this.f17847d.t(this.f17845b.e(), "Product Config : JSON object doesn't contain the Product Config key");
            b();
            this.f17844a.a(bVar, str, context);
        } else {
            try {
                this.f17847d.t(this.f17845b.e(), "Product Config : Processing Product Config response");
                c(bVar.getJSONObject("pc_notifs"));
            } catch (Throwable th2) {
                b();
                this.f17847d.u(this.f17845b.e(), "Product Config : Failed to parse Product Config response", th2);
            }
            this.f17844a.a(bVar, str, context);
        }
    }
}
