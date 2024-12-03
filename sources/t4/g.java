package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import i4.b;
import i4.i;
import org.json.a;

public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17812a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final b f17813b;

    /* renamed from: c  reason: collision with root package name */
    private final c f17814c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f17815d;

    /* renamed from: e  reason: collision with root package name */
    private final i f17816e;

    /* renamed from: f  reason: collision with root package name */
    private final p f17817f;

    public g(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, b bVar, i iVar) {
        this.f17814c = cVar;
        this.f17815d = cleverTapInstanceConfig;
        this.f17817f = cleverTapInstanceConfig.n();
        this.f17813b = bVar;
        this.f17816e = iVar;
    }

    private void b(a aVar) {
        if (aVar == null || aVar.o() == 0) {
            this.f17817f.t(this.f17815d.e(), "DisplayUnit : Can't parse Display Units, jsonArray is either empty or null");
            return;
        }
        synchronized (this.f17812a) {
            if (this.f17816e.c() == null) {
                this.f17816e.k(new k4.a());
            }
        }
        this.f17813b.o(this.f17816e.c().b(aVar));
    }

    public void a(org.json.b bVar, String str, Context context) {
        this.f17817f.t(this.f17815d.e(), "Processing Display Unit items...");
        if (this.f17815d.p()) {
            this.f17817f.t(this.f17815d.e(), "CleverTap instance is configured to analytics only, not processing Display Unit response");
            this.f17814c.a(bVar, str, context);
        } else if (bVar == null) {
            this.f17817f.t(this.f17815d.e(), "DisplayUnit : Can't parse Display Unit Response, JSON response object is null");
        } else if (!bVar.has("adUnit_notifs")) {
            this.f17817f.t(this.f17815d.e(), "DisplayUnit : JSON object doesn't contain the Display Units key");
            this.f17814c.a(bVar, str, context);
        } else {
            try {
                this.f17817f.t(this.f17815d.e(), "DisplayUnit : Processing Display Unit response");
                b(bVar.getJSONArray("adUnit_notifs"));
            } catch (Throwable th2) {
                this.f17817f.u(this.f17815d.e(), "DisplayUnit : Failed to parse response", th2);
            }
            this.f17814c.a(bVar, str, context);
        }
    }
}
