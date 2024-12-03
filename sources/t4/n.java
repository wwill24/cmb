package t4;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.db.a;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.h;
import i4.b;
import i4.i;
import java.util.Iterator;
import org.json.JSONException;

public class n extends d {

    /* renamed from: a  reason: collision with root package name */
    private final b f17849a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17850b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f17851c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17852d;

    /* renamed from: e  reason: collision with root package name */
    private final p f17853e;

    /* renamed from: f  reason: collision with root package name */
    private final i f17854f;

    /* renamed from: g  reason: collision with root package name */
    private final a f17855g;

    public n(c cVar, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, a aVar, b bVar, i iVar) {
        this.f17850b = cVar;
        this.f17852d = context;
        this.f17851c = cleverTapInstanceConfig;
        this.f17853e = cleverTapInstanceConfig.n();
        this.f17855g = aVar;
        this.f17849a = bVar;
        this.f17854f = iVar;
    }

    private void b(org.json.a aVar) {
        int i10 = 0;
        while (i10 < aVar.o()) {
            try {
                Bundle bundle = new Bundle();
                org.json.b j10 = aVar.j(i10);
                if (j10.has("wzrk_ttl")) {
                    bundle.putLong("wzrk_ttl", j10.getLong("wzrk_ttl"));
                }
                Iterator<String> keys = j10.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    bundle.putString(obj, j10.getString(obj));
                }
                if (!bundle.isEmpty()) {
                    if (!this.f17855g.c(this.f17852d).x(j10.getString("wzrk_pid"))) {
                        this.f17853e.s("Creating Push Notification locally");
                        if (this.f17849a.k() != null) {
                            this.f17849a.k().a(bundle);
                        } else {
                            h.d().c(this.f17852d, bundle, PushConstants.PushType.FCM.toString());
                        }
                        i10++;
                    }
                }
                p pVar = this.f17853e;
                String e10 = this.f17851c.e();
                pVar.t(e10, "Push Notification already shown, ignoring local notification :" + j10.getString("wzrk_pid"));
                i10++;
            } catch (JSONException unused) {
                this.f17853e.t(this.f17851c.e(), "Error parsing push notification JSON");
                return;
            }
        }
    }

    public void a(org.json.b bVar, String str, Context context) {
        if (this.f17851c.p()) {
            this.f17853e.t(this.f17851c.e(), "CleverTap instance is configured to analytics only, not processing push amp response");
            this.f17850b.a(bVar, str, context);
            return;
        }
        try {
            if (bVar.has("pushamp_notifs")) {
                this.f17853e.t(this.f17851c.e(), "Processing pushamp messages...");
                org.json.b jSONObject = bVar.getJSONObject("pushamp_notifs");
                org.json.a jSONArray = jSONObject.getJSONArray("list");
                if (jSONArray.o() > 0) {
                    this.f17853e.t(this.f17851c.e(), "Handling Push payload locally");
                    b(jSONArray);
                }
                if (jSONObject.has("pf")) {
                    this.f17854f.i().X(context, jSONObject.getInt("pf"));
                }
                if (jSONObject.has("ack")) {
                    boolean z10 = jSONObject.getBoolean("ack");
                    p pVar = this.f17853e;
                    pVar.s("Received ACK -" + z10);
                    if (z10) {
                        org.json.a d10 = v4.a.d(this.f17855g.c(context));
                        String[] strArr = new String[0];
                        if (d10 != null) {
                            strArr = new String[d10.o()];
                        }
                        for (int i10 = 0; i10 < strArr.length; i10++) {
                            strArr[i10] = d10.n(i10);
                        }
                        this.f17853e.s("Updating RTL values...");
                        this.f17855g.c(context).N(strArr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f17850b.a(bVar, str, context);
    }
}
