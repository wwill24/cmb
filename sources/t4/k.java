package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import i4.b;
import i4.e;
import i4.i;
import org.json.a;

public class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17833a;

    /* renamed from: b  reason: collision with root package name */
    private final b f17834b;

    /* renamed from: c  reason: collision with root package name */
    private final c f17835c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f17836d;

    /* renamed from: e  reason: collision with root package name */
    private final p f17837e;

    /* renamed from: f  reason: collision with root package name */
    private final i f17838f;

    public k(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, e eVar, b bVar, i iVar) {
        this.f17835c = cVar;
        this.f17836d = cleverTapInstanceConfig;
        this.f17834b = bVar;
        this.f17837e = cleverTapInstanceConfig.n();
        this.f17833a = eVar.b();
        this.f17838f = iVar;
    }

    private void b(a aVar) {
        synchronized (this.f17833a) {
            if (this.f17838f.e() == null) {
                this.f17838f.j();
            }
            if (this.f17838f.e() != null && this.f17838f.e().q(aVar)) {
                this.f17834b.b();
            }
        }
    }

    public void a(org.json.b bVar, String str, Context context) {
        if (this.f17836d.p()) {
            this.f17837e.t(this.f17836d.e(), "CleverTap instance is configured to analytics only, not processing inbox messages");
            this.f17835c.a(bVar, str, context);
            return;
        }
        this.f17837e.t(this.f17836d.e(), "Inbox: Processing response");
        if (!bVar.has("inbox_notifs")) {
            this.f17837e.t(this.f17836d.e(), "Inbox: Response JSON object doesn't contain the inbox key");
            this.f17835c.a(bVar, str, context);
            return;
        }
        try {
            b(bVar.getJSONArray("inbox_notifs"));
        } catch (Throwable th2) {
            this.f17837e.u(this.f17836d.e(), "InboxResponse: Failed to parse response", th2);
        }
        this.f17835c.a(bVar, str, context);
    }
}
