package t4;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.s;
import i4.i;
import java.util.concurrent.Callable;
import org.apache.commons.validator.Field;
import org.json.JSONException;
import org.json.b;

public class j extends d {

    /* renamed from: a  reason: collision with root package name */
    private final c f17826a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f17827b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final i f17828c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17829d;

    /* renamed from: e  reason: collision with root package name */
    private final p f17830e;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f17831a;

        a(Context context) {
            this.f17831a = context;
        }

        /* renamed from: a */
        public Void call() {
            j.this.f17828c.g().s(this.f17831a);
            return null;
        }
    }

    public j(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, i iVar, boolean z10) {
        this.f17826a = cVar;
        this.f17827b = cleverTapInstanceConfig;
        this.f17830e = cleverTapInstanceConfig.n();
        this.f17828c = iVar;
        this.f17829d = z10;
    }

    public void a(b bVar, String str, Context context) {
        int i10;
        try {
            if (this.f17827b.p()) {
                this.f17830e.t(this.f17827b.e(), "CleverTap instance is configured to analytics only, not processing inapp messages");
                this.f17826a.a(bVar, str, context);
                return;
            }
            this.f17830e.t(this.f17827b.e(), "InApp: Processing response");
            if (!bVar.has("inapp_notifs")) {
                this.f17830e.t(this.f17827b.e(), "InApp: Response JSON object doesn't contain the inapp key, failing");
                this.f17826a.a(bVar, str, context);
                return;
            }
            int i11 = 10;
            if (!bVar.has("imc") || !(bVar.get("imc") instanceof Integer)) {
                i10 = 10;
            } else {
                i10 = bVar.getInt("imc");
            }
            if (bVar.has("imp") && (bVar.get("imp") instanceof Integer)) {
                i11 = bVar.getInt("imp");
            }
            if (this.f17829d || this.f17828c.h() == null) {
                this.f17830e.t(this.f17827b.e(), "controllerManager.getInAppFCManager() is NULL, not Updating InAppFC Limits");
            } else {
                p.o("Updating InAppFC Limits");
                this.f17828c.h().w(context, i11, i10);
                this.f17828c.h().u(context, bVar);
            }
            org.json.a jSONArray = bVar.getJSONArray("inapp_notifs");
            SharedPreferences.Editor edit = s.g(context).edit();
            try {
                org.json.a aVar = new org.json.a(s.k(context, this.f17827b, "inApp", Field.TOKEN_INDEXED));
                if (jSONArray != null && jSONArray.o() > 0) {
                    for (int i12 = 0; i12 < jSONArray.o(); i12++) {
                        aVar.E(jSONArray.j(i12));
                    }
                }
                edit.putString(s.s(this.f17827b, "inApp"), aVar.toString());
                s.l(edit);
            } catch (JSONException unused) {
                p.o("InAppManager: Malformed inapp notification");
            } catch (Throwable th2) {
                this.f17830e.t(this.f17827b.e(), "InApp: Failed to parse the in-app notifications properly");
                this.f17830e.u(this.f17827b.e(), "InAppManager: Reason: " + th2.getMessage(), th2);
            }
            com.clevertap.android.sdk.task.a.a(this.f17827b).d("TAG_FEATURE_IN_APPS").f("InAppResponse#processResponse", new a(context));
            this.f17826a.a(bVar, str, context);
        } catch (JSONException unused2) {
            this.f17830e.f(this.f17827b.e(), "InApp: In-app key didn't contain a valid JSON array");
            this.f17826a.a(bVar, str, context);
        } catch (Throwable th3) {
            p.r("InAppManager: Failed to parse response", th3);
        }
    }
}
