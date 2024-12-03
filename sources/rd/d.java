package rd;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class d extends zzbs {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41841a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f41842b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f41843c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final zzez f41844d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final y f41845e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public zzfr f41846f;

    d(zzbv zzbv, String str, zzez zzez) {
        super(zzbv);
        HashMap hashMap = new HashMap();
        this.f41842b = hashMap;
        if (str != null) {
            hashMap.put("&tid", str);
        }
        hashMap.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hashMap.put("&a", Integer.toString(new Random().nextInt(a.e.API_PRIORITY_OTHER) + 1));
        this.f41844d = new zzez(60, 2000, "tracking", zzC());
        this.f41845e = new y(this, zzbv);
    }

    private static String F(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (!key.startsWith("&") || key.length() < 2) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    private static void g(Map<String, String> map, Map<String, String> map2) {
        p.k(map2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String F = F(next);
                if (F != null) {
                    map2.put(F, (String) next.getValue());
                }
            }
        }
    }

    public void b(boolean z10) {
        this.f41845e.e(z10);
    }

    public void c(@NonNull Map<String, String> map) {
        boolean z10;
        long currentTimeMillis = zzC().currentTimeMillis();
        if (zzp().i()) {
            zzF("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean k10 = zzp().k();
        HashMap hashMap = new HashMap();
        g(this.f41842b, hashMap);
        g(map, hashMap);
        String str = this.f41842b.get("useSecure");
        int i10 = 1;
        if (str == null || str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES) || (!str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no") && !str.equalsIgnoreCase("0"))) {
            z10 = true;
        } else {
            z10 = false;
        }
        Map<String, String> map2 = this.f41843c;
        p.k(hashMap);
        for (Map.Entry next : map2.entrySet()) {
            String F = F(next);
            if (F != null && !hashMap.containsKey(F)) {
                hashMap.put(F, (String) next.getValue());
            }
        }
        this.f41843c.clear();
        String str2 = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str2)) {
            zzz().zzc(hashMap, "Missing hit type parameter");
            return;
        }
        String str3 = (String) hashMap.get("tid");
        if (!TextUtils.isEmpty(str3)) {
            boolean z11 = this.f41841a;
            synchronized (this) {
                if ("screenview".equalsIgnoreCase(str2) || "pageview".equalsIgnoreCase(str2) || "appview".equalsIgnoreCase(str2) || TextUtils.isEmpty(str2)) {
                    String str4 = this.f41842b.get("&a");
                    p.k(str4);
                    int parseInt = Integer.parseInt(str4) + 1;
                    if (parseInt < Integer.MAX_VALUE) {
                        i10 = parseInt;
                    }
                    this.f41842b.put("&a", Integer.toString(i10));
                }
            }
            zzq().i(new x(this, hashMap, z11, str2, currentTimeMillis, k10, z10, str3));
            return;
        }
        zzz().zzc(hashMap, "Missing tracking id parameter");
    }

    public void e(@NonNull String str, @NonNull String str2) {
        p.l(str, "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.f41842b.put(str, str2);
        }
    }

    public void f(@NonNull Uri uri) {
        String str;
        if (uri != null && !uri.isOpaque()) {
            String queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String valueOf = String.valueOf(queryParameter);
                if (valueOf.length() != 0) {
                    str = "http://hostname/?".concat(valueOf);
                } else {
                    str = new String("http://hostname/?");
                }
                Uri parse = Uri.parse(str);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.f41843c.put("&ci", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.f41843c.put("&anid", queryParameter3);
                }
                String queryParameter4 = parse.getQueryParameter("utm_campaign");
                if (queryParameter4 != null) {
                    this.f41843c.put("&cn", queryParameter4);
                }
                String queryParameter5 = parse.getQueryParameter("utm_content");
                if (queryParameter5 != null) {
                    this.f41843c.put("&cc", queryParameter5);
                }
                String queryParameter6 = parse.getQueryParameter("utm_medium");
                if (queryParameter6 != null) {
                    this.f41843c.put("&cm", queryParameter6);
                }
                String queryParameter7 = parse.getQueryParameter("utm_source");
                if (queryParameter7 != null) {
                    this.f41843c.put("&cs", queryParameter7);
                }
                String queryParameter8 = parse.getQueryParameter("utm_term");
                if (queryParameter8 != null) {
                    this.f41843c.put("&ck", queryParameter8);
                }
                String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.f41843c.put("&dclid", queryParameter9);
                }
                String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.f41843c.put("&gclid", queryParameter10);
                }
                String queryParameter11 = parse.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (queryParameter11 != null) {
                    this.f41843c.put("&aclid", queryParameter11);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.f41845e.zzX();
        String zza = zzB().zza();
        if (zza != null) {
            e("&an", zza);
        }
        String zzb = zzB().zzb();
        if (zzb != null) {
            e("&av", zzb);
        }
    }
}
