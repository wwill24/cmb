package c9;

import android.content.Context;
import android.text.TextUtils;
import c9.d;
import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.uber.autodispose.m;
import hb.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qj.a;
import qj.f;
import u6.l;

public class i implements d, h1.b {

    /* renamed from: a  reason: collision with root package name */
    private final c f8003a;

    /* renamed from: b  reason: collision with root package name */
    private final d7.c f8004b;

    /* renamed from: c  reason: collision with root package name */
    private final l f8005c;

    /* renamed from: d  reason: collision with root package name */
    private final ma.i f8006d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Resource> f8007e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<d.a> f8008f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Context f8009g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8010h = i.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private final AuthenticationScopeProvider f8011i;

    /* renamed from: j  reason: collision with root package name */
    private int f8012j;

    public i(c cVar, Context context, d7.c cVar2, l lVar, ma.i iVar, AuthenticationScopeProvider authenticationScopeProvider) {
        this.f8003a = cVar;
        this.f8009g = context;
        this.f8004b = cVar2;
        this.f8005c = lVar;
        this.f8006d = iVar;
        this.f8011i = authenticationScopeProvider;
    }

    private boolean j() {
        String language = this.f8009g.getResources().getConfiguration().locale.getLanguage();
        String r10 = this.f8003a.r("device_language");
        String country = this.f8009g.getResources().getConfiguration().locale.getCountry();
        String r11 = this.f8003a.r("device_country");
        if (TextUtils.isEmpty(r10) || TextUtils.isEmpty(r11)) {
            return true;
        }
        boolean z10 = !language.equals(r10);
        boolean z11 = !country.equals(r11);
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(List list) throws Exception {
        this.f8005c.a(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f l(List list, Map map) throws Exception {
        if (map != null) {
            this.f8012j = map.size();
            for (String str : map.keySet()) {
                for (Resource resource : (List) map.get(str)) {
                    resource.setListName(str);
                    if (str.equals(ResourceType.UNSUPPORTED_CHAT_MESSAGE_PLACEHOLDERS.getListName())) {
                        this.f8007e.add(resource);
                    }
                    list.add(resource);
                }
            }
        }
        return a.w(new h(this, list));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() throws Exception {
        for (d.a L : this.f8008f) {
            L.L();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(Throwable th2) throws Exception {
        fa.a.g(this.f8010h, "Unable to fetch resources", th2);
    }

    public void P() {
    }

    public void S() {
        if (j()) {
            c();
            String country = this.f8009g.getResources().getConfiguration().locale.getCountry();
            String language = this.f8009g.getResources().getConfiguration().locale.getLanguage();
            this.f8003a.w("device_country", country);
            this.f8003a.w("device_language", language);
        } else if (this.f8012j == 0) {
            c();
        }
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Resource key : this.f8007e) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    public void b(d.a aVar) {
        this.f8008f.remove(aVar);
    }

    public void c() {
        if (this.f8004b.isLoggedIn()) {
            ((m) this.f8006d.a().K(dk.a.c()).w(new e(this, new ArrayList())).j(com.uber.autodispose.a.a(this.f8011i))).f(new f(this), new g(this));
        }
    }

    public void d(d.a aVar) {
        if (!this.f8008f.contains(aVar)) {
            this.f8008f.add(aVar);
        }
    }

    public Map<String, String> e(List<Resource> list) {
        HashMap hashMap = new HashMap(list.size());
        for (Resource next : list) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }
}
