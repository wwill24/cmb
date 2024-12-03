package t4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.n;
import com.clevertap.android.sdk.p;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final c f17804a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f17805b;

    /* renamed from: c  reason: collision with root package name */
    private final n f17806c;

    /* renamed from: d  reason: collision with root package name */
    private final p f17807d;

    /* renamed from: e  reason: collision with root package name */
    private final q4.b f17808e;

    public b(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, q4.b bVar, n nVar, c cVar) {
        this.f17804a = cVar;
        this.f17805b = cleverTapInstanceConfig;
        this.f17807d = cleverTapInstanceConfig.n();
        this.f17808e = bVar;
        this.f17806c = nVar;
    }

    public void a(org.json.b bVar, String str, Context context) {
        if (str == null) {
            this.f17807d.t(this.f17805b.e(), "Problem processing queue response, response is null");
            return;
        }
        try {
            p pVar = this.f17807d;
            String e10 = this.f17805b.e();
            pVar.t(e10, "Trying to process response: " + str);
            org.json.b bVar2 = new org.json.b(str);
            this.f17804a.a(bVar2, str, context);
            this.f17806c.U(context, bVar2);
        } catch (Throwable th2) {
            this.f17808e.v();
            this.f17807d.u(this.f17805b.e(), "Problem process send queue response", th2);
        }
    }
}
