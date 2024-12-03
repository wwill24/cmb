package n4;

import android.text.TextUtils;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.inbox.CTInboxMessageContent;
import com.clevertap.android.sdk.p;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f16440a;

    /* renamed from: b  reason: collision with root package name */
    private long f16441b;

    /* renamed from: c  reason: collision with root package name */
    private long f16442c;

    /* renamed from: d  reason: collision with root package name */
    private String f16443d;

    /* renamed from: e  reason: collision with root package name */
    private b f16444e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16445f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f16446g;

    /* renamed from: h  reason: collision with root package name */
    private String f16447h;

    /* renamed from: i  reason: collision with root package name */
    private b f16448i;

    public e() {
        this.f16446g = new ArrayList();
    }

    private static b i(b bVar) throws JSONException {
        b bVar2 = new b();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith("wzrk_")) {
                bVar2.put(next, bVar.get(next));
            }
        }
        return bVar2;
    }

    static e k(b bVar, String str) {
        String str2;
        long j10;
        long j11;
        b bVar2;
        String str3;
        a aVar;
        b bVar3 = bVar;
        try {
            if (bVar3.has("_id")) {
                str2 = bVar3.getString("_id");
            } else {
                str2 = null;
            }
            if (bVar3.has("date")) {
                j10 = (long) bVar3.getInt("date");
            } else {
                j10 = System.currentTimeMillis() / 1000;
            }
            long j12 = j10;
            if (bVar3.has("wzrk_ttl")) {
                j11 = (long) bVar3.getInt("wzrk_ttl");
            } else {
                j11 = (System.currentTimeMillis() + 86400000) / 1000;
            }
            long j13 = j11;
            if (bVar3.has(SDKConstants.PARAM_DEBUG_MESSAGE)) {
                bVar2 = bVar3.getJSONObject(SDKConstants.PARAM_DEBUG_MESSAGE);
            } else {
                bVar2 = null;
            }
            ArrayList arrayList = new ArrayList();
            if (bVar2 != null) {
                if (bVar2.has("tags")) {
                    aVar = bVar2.getJSONArray("tags");
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    for (int i10 = 0; i10 < aVar.o(); i10++) {
                        arrayList.add(aVar.n(i10));
                    }
                }
            }
            if (bVar3.has("wzrk_id")) {
                str3 = bVar3.getString("wzrk_id");
            } else {
                str3 = "0_0";
            }
            if (str3.equalsIgnoreCase("0_0")) {
                bVar3.put("wzrk_id", (Object) str3);
            }
            b i11 = i(bVar);
            if (str2 == null) {
                return null;
            }
            return new e(str2, bVar2, false, j12, j13, str, arrayList, str3, i11);
        } catch (JSONException e10) {
            p.a("Unable to parse Notification inbox message to CTMessageDao - " + e10.getLocalizedMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        p.a("CTMessageDAO:containsVideoOrAudio() called");
        CTInboxMessageContent cTInboxMessageContent = new CTInboxMessage(v()).e().get(0);
        if (cTInboxMessageContent.x() || cTInboxMessageContent.t()) {
            return true;
        }
        return false;
    }

    public String b() {
        return this.f16440a;
    }

    public long c() {
        return this.f16441b;
    }

    public long d() {
        return this.f16442c;
    }

    public String e() {
        return this.f16443d;
    }

    public b f() {
        return this.f16444e;
    }

    public String g() {
        return TextUtils.join(AppsFlyerKit.COMMA, this.f16446g);
    }

    public String h() {
        return this.f16447h;
    }

    public b j() {
        return this.f16448i;
    }

    public int l() {
        return this.f16445f ? 1 : 0;
    }

    public void m(String str) {
        this.f16440a = str;
    }

    public void n(long j10) {
        this.f16441b = j10;
    }

    public void o(long j10) {
        this.f16442c = j10;
    }

    public void p(String str) {
        this.f16443d = str;
    }

    public void q(b bVar) {
        this.f16444e = bVar;
    }

    public void r(int i10) {
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        this.f16445f = z10;
    }

    public void s(String str) {
        this.f16446g.addAll(Arrays.asList(str.split(AppsFlyerKit.COMMA)));
    }

    public void t(String str) {
        this.f16447h = str;
    }

    public void u(b bVar) {
        this.f16448i = bVar;
    }

    public b v() {
        b bVar = new b();
        try {
            bVar.put("id", (Object) this.f16443d);
            bVar.put(SDKConstants.PARAM_DEBUG_MESSAGE, (Object) this.f16444e);
            bVar.put(Constants.Keys.IS_READ, this.f16445f);
            bVar.put("date", this.f16441b);
            bVar.put("wzrk_ttl", this.f16442c);
            a aVar = new a();
            for (int i10 = 0; i10 < this.f16446g.size(); i10++) {
                aVar.E(this.f16446g.get(i10));
            }
            bVar.put("tags", (Object) aVar);
            bVar.put("wzrk_id", (Object) this.f16440a);
            bVar.put("wzrkParams", (Object) this.f16448i);
            return bVar;
        } catch (JSONException e10) {
            p.o("Unable to convert CTMessageDao to JSON - " + e10.getLocalizedMessage());
            return bVar;
        }
    }

    private e(String str, b bVar, boolean z10, long j10, long j11, String str2, List<String> list, String str3, b bVar2) {
        new ArrayList();
        this.f16443d = str;
        this.f16444e = bVar;
        this.f16445f = z10;
        this.f16441b = j10;
        this.f16442c = j11;
        this.f16447h = str2;
        this.f16446g = list;
        this.f16440a = str3;
        this.f16448i = bVar2;
    }
}
