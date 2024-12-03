package lc;

import android.text.TextUtils;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.models.enums.HttpMethod;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.m;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

public class e {

    /* renamed from: a  reason: collision with root package name */
    static x f41109a;

    static class a implements m {
        a() {
        }

        public List<l> a(t tVar) {
            if (!tVar.i().equals(x4.a.f18539c)) {
                return Collections.emptyList();
            }
            l g10 = Bakery.w().g().g();
            if (g10 == null || g10.f() <= System.currentTimeMillis()) {
                return Collections.emptyList();
            }
            return Collections.singletonList(g10);
        }

        public void b(t tVar, List<l> list) {
            if (tVar.i().equals(x4.a.f18539c) && !CollectionUtils.isEmpty((List) tVar.n()) && tVar.n().get(0).equals(FirebaseAnalytics.Event.LOGIN)) {
                for (l next : list) {
                    if (next.i().equals("sessionid")) {
                        Bakery.w().g().f(next);
                    }
                }
            }
        }
    }

    static final class b implements u {
        b() {
        }

        public a0 intercept(u.a aVar) throws IOException {
            y g10 = aVar.g();
            y.a h10 = g10.h();
            Set<String> g11 = g10.e().g();
            Map<String, String> d10 = i1.d();
            for (String next : d10.keySet()) {
                String str = d10.get(next);
                if (!TextUtils.isEmpty(str) && !g11.contains(next)) {
                    h10.a(next, str);
                }
            }
            return aVar.a(h10.b());
        }
    }

    public static void a(y.a aVar) {
        Map<String, String> a10 = i1.a(i1.d());
        for (String next : a10.keySet()) {
            String str = a10.get(next);
            if (!TextUtils.isEmpty(str)) {
                aVar.a(next, str);
            }
        }
    }

    public static void b() {
        f41109a = null;
    }

    public static y c(String str, HttpMethod httpMethod, String str2, String str3) {
        y.a q10 = new y.a().q(str);
        a(q10);
        if (!TextUtils.isEmpty(h5.l.k())) {
            q10.a("Facebook-Auth-Token-Expires", h5.l.k());
        }
        if (!TextUtils.isEmpty(str3)) {
            q10.a("Request-Id", str3);
        }
        if (httpMethod != HttpMethod.GET) {
            if (str2 == null) {
                str2 = "";
            }
            q10.h(httpMethod.toString(), z.d(x4.a.f18538b, str2));
        }
        return q10.b();
    }
}
