package d9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c7.d;
import com.coffeemeetsbagel.bakery.Bakery;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lc.g;
import mc.b;
import okhttp3.l;
import okhttp3.m;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smackx.message_fastening.element.ExternalElement;
import retrofit2.s;

public abstract class c implements d {

    /* renamed from: m  reason: collision with root package name */
    private static String f14499m;

    /* renamed from: a  reason: collision with root package name */
    protected s f14500a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.google.gson.d f14501b;

    /* renamed from: c  reason: collision with root package name */
    protected final tn.a f14502c;

    /* renamed from: d  reason: collision with root package name */
    private final b f14503d;

    /* renamed from: e  reason: collision with root package name */
    private final hb.c f14504e;

    /* renamed from: f  reason: collision with root package name */
    private final e9.a f14505f;

    /* renamed from: g  reason: collision with root package name */
    private String f14506g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f14507h;

    /* renamed from: i  reason: collision with root package name */
    private List<u> f14508i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public c7.b f14509j;

    /* renamed from: k  reason: collision with root package name */
    private final List<c7.c> f14510k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private final List<u> f14511l = new ArrayList();

    private class a implements m {
        private a() {
        }

        public List<l> a(t tVar) {
            l b10 = c.this.f14509j.b();
            if (b10 != null) {
                return Collections.singletonList(b10);
            }
            return Collections.emptyList();
        }

        public void b(t tVar, List<l> list) {
            if (c.this.f14509j != null) {
                for (l next : list) {
                    if (next.i().equals("sessionid")) {
                        c.this.f14509j.a(next);
                    }
                }
            }
        }
    }

    c(b bVar, hb.c cVar, ka.a aVar) {
        this.f14503d = bVar;
        this.f14504e = cVar;
        com.google.gson.d b10 = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();
        this.f14501b = b10;
        this.f14502c = tn.a.f(b10);
        this.f14505f = new e9.a(Collections.emptyMap(), aVar);
    }

    private Map<String, String> f() {
        HashMap hashMap = new HashMap();
        m(hashMap);
        k(hashMap);
        j(hashMap);
        l(hashMap);
        for (c7.c a10 : this.f14510k) {
            Map<String, String> a11 = a10.a();
            if (a11 != null) {
                hashMap.putAll(a11);
            }
        }
        return hashMap;
    }

    private void g(@NonNull String str) {
        if (o() || !str.equals(h())) {
            if (str.equals(h())) {
                str = h();
            }
            Map<String, String> f10 = f();
            this.f14505f.a(f10);
            this.f14507h = f10;
            this.f14506g = str;
            ArrayList arrayList = new ArrayList();
            this.f14508i = arrayList;
            arrayList.addAll(this.f14511l);
            x.a e10 = new x.a().a(this.f14505f).a(new e9.d()).e(new a());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            x.a O = e10.J(30, timeUnit).O(30, timeUnit);
            for (u b10 : this.f14511l) {
                O.b(b10);
            }
            n(str, O);
        }
    }

    private String h() {
        return this.f14503d.a().b();
    }

    private static String i() {
        if (f14499m == null) {
            try {
                Context f12 = Bakery.j().f1();
                PackageManager packageManager = f12.getPackageManager();
                String packageName = f12.getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    f14499m = String.valueOf(packageManager.getInstallSourceInfo(packageName).getInitiatingPackageName());
                } else {
                    f14499m = packageManager.getInstallerPackageName(packageName);
                }
            } catch (Exception unused) {
                fa.a.f("BaseCmbRetrofit", "Unable to load install source API: " + Build.VERSION.SDK_INT);
                f14499m = ExternalElement.ELEMENT;
            }
        }
        return f14499m;
    }

    private void j(Map<String, String> map) {
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
        map.put("Accept-Language", str + HelpFormatter.DEFAULT_OPT_PREFIX + str2);
    }

    private void k(Map<String, String> map) {
        if (!TextUtils.isEmpty(h5.l.j())) {
            map.put("Facebook-Auth-Token", h5.l.j());
        }
    }

    private void l(Map<String, String> map) {
        if (g.c() && Bakery.w().M().d(g.c())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Impersonating user: ");
            sb2.append(Bakery.w().M().j(g.c()));
            map.put("Impersonate-Profile-Id", Bakery.w().M().j(g.c()));
        }
    }

    private void m(Map<String, String> map) {
        map.put("Charset", "utf-8");
        map.put("AppStore-Version", "6.32.0.13778");
        map.put("App-Version", String.valueOf(13778));
        map.put("Install-Source", String.valueOf(i()));
        map.put("Device-Name", Build.MANUFACTURER + " " + Build.MODEL);
        map.put("Client", "Android");
        map.put("Accept", "application/json");
    }

    private boolean o() {
        List<u> list;
        if (this.f14500a == null) {
            return true;
        }
        String h10 = h();
        String str = this.f14506g;
        if (str != null && str.equals(h10)) {
            Map<String, String> f10 = f();
            Map<String, String> map = this.f14507h;
            if (map == null || !map.equals(f10) || (list = this.f14508i) == null || !list.equals(this.f14511l)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void a(c7.c cVar) {
        this.f14510k.add(cVar);
        this.f14505f.a(f());
    }

    public void b(c7.b bVar) {
        this.f14509j = bVar;
    }

    public <T> T c(Class<T> cls) {
        g(h());
        return this.f14500a.b(cls);
    }

    public void d(u uVar) {
        this.f14511l.add(uVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void n(String str, x.a aVar);
}
