package com.coffeemeetsbagel.bakery;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import d7.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lc.g;
import okhttp3.l;
import org.apache.commons.cli.HelpFormatter;

public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f11219a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<UpgradeContract.Manager.UpgradeListener> f11220b = new ArrayList();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11221a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.coffeemeetsbagel.bakery.Bakery$CmbEndpointsPointToType[] r0 = com.coffeemeetsbagel.bakery.Bakery.CmbEndpointsPointToType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11221a = r0
                com.coffeemeetsbagel.bakery.Bakery$CmbEndpointsPointToType r1 = com.coffeemeetsbagel.bakery.Bakery.CmbEndpointsPointToType.STAGING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11221a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.bakery.Bakery$CmbEndpointsPointToType r1 = com.coffeemeetsbagel.bakery.Bakery.CmbEndpointsPointToType.PRODUCTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11221a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.bakery.Bakery$CmbEndpointsPointToType r1 = com.coffeemeetsbagel.bakery.Bakery.CmbEndpointsPointToType.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.bakery.i1.a.<clinit>():void");
        }
    }

    public static class b {
        public static String a() {
            return x4.a.f18540d + FirebaseAnalytics.Event.LOGIN;
        }
    }

    static {
        g();
    }

    public static Map<String, String> a(Map<String, String> map) {
        c g10 = Bakery.w().g();
        String e10 = g10.e();
        if (!TextUtils.isEmpty(e10)) {
            map.put("Authorization", "Bearer " + e10);
        }
        l g11 = g10.g();
        if (g11 == null || (g11.n() != null && g11.n().length() == 0)) {
            fa.a.f("ManagerApi", "#session cookie null!");
            return map;
        }
        String n10 = g11.n();
        map.put("Cookie", "sessionid=" + n10);
        return map;
    }

    public static void b(UpgradeContract.Manager.UpgradeListener upgradeListener) {
        List<UpgradeContract.Manager.UpgradeListener> list = f11220b;
        if (!list.contains(upgradeListener)) {
            list.add(upgradeListener);
        }
    }

    public static void c() {
        f11219a = null;
    }

    public static Map<String, String> d() {
        String id2;
        Map<String, String> map = f11219a;
        if (map == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            f11219a = concurrentHashMap;
            concurrentHashMap.put("Charset", "utf-8");
            f11219a.put("AppStore-Version", "6.32.0.13778");
            f11219a.put("App-Version", String.valueOf(13778));
            Map<String, String> map2 = f11219a;
            map2.put("Device-Name", Build.MANUFACTURER + " " + Build.MODEL);
            f11219a.put("Client", "Android");
            f11219a.put("Accept", "application/json");
            f11219a.put("Bundle-Id", Bakery.w().getPackageName());
            if (h5.l.j() != null) {
                f11219a.put("Facebook-Auth-Token", h5.l.j());
            }
        } else {
            map.remove("Request-Id");
        }
        f();
        if (g.c() && Bakery.w().M().d(g.c())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Impersonating user: ");
            sb2.append(Bakery.w().M().j(g.c()));
            f11219a.put("Impersonate-Profile-Id", Bakery.w().M().j(g.c()));
        }
        NetworkProfile j10 = Bakery.w().G().j();
        if (!(j10 == null || (id2 = j10.getId()) == null)) {
            f11219a.put("Profile-Id", id2);
        }
        return f11219a;
    }

    public static boolean e(int i10) {
        return i10 == 432 || i10 == 503 || i10 == 502;
    }

    private static void f() {
        String str;
        String str2;
        Locale locale = Bakery.w().getResources().getConfiguration().locale;
        if (!TextUtils.isEmpty(locale.getLanguage())) {
            str = locale.getLanguage();
        } else {
            str = "en";
        }
        if (!TextUtils.isEmpty(locale.getCountry())) {
            str2 = locale.getCountry();
        } else {
            str2 = "US";
        }
        Map<String, String> map = f11219a;
        map.put("Accept-Language", str + HelpFormatter.DEFAULT_OPT_PREFIX + str2);
    }

    public static void g() {
        Bakery.CmbEndpointsPointToType p10 = Bakery.p();
        int i10 = a.f11221a[p10.ordinal()];
        if (i10 == 1) {
            j();
        } else if (i10 == 2) {
            k();
        } else if (i10 == 3) {
            i(p10.b());
        } else {
            throw new IllegalStateException("not sure what to point to");
        }
    }

    public static void h(UpgradeContract.Manager.UpgradeListener upgradeListener) {
        List<UpgradeContract.Manager.UpgradeListener> list = f11220b;
        if (list.contains(upgradeListener)) {
            list.remove(upgradeListener);
        }
    }

    private static void i(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ip=");
        sb2.append(str);
        Uri parse = Uri.parse(str);
        String uri = parse.toString();
        if (!uri.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            uri = uri + RemoteSettings.FORWARD_SLASH_STRING;
        }
        x4.a.f18540d = uri;
        x4.a.f18539c = parse.getHost();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("API_URL_BASE=");
        sb3.append(x4.a.f18540d);
        sb3.append(" API_HOST=");
        sb3.append(x4.a.f18539c);
    }

    private static void j() {
        x4.a.f18540d = "https://apibaking.coffeemeetsbagel.com/";
        x4.a.f18539c = "apibaking.coffeemeetsbagel.com";
        x4.a.f18541e = "baking-chat.coffeemeetsbagel.com";
    }

    private static void k() {
        if (g.c()) {
            x4.a.f18540d = "https://api.coffeemeetsbagel.com/";
            x4.a.f18539c = "api.coffeemeetsbagel.com";
            x4.a.f18541e = "chat.coffeemeetsbagel.com";
            return;
        }
        x4.a.f18540d = "https://api.coffeemeetsbagel.com/";
        x4.a.f18539c = "api.coffeemeetsbagel.com";
        x4.a.f18541e = "chat.coffeemeetsbagel.com";
    }
}
