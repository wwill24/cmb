package m4;

import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.task.Task;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.ReportingMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final CleverTapInstanceConfig f16324a;

    /* renamed from: b  reason: collision with root package name */
    String f16325b;

    /* renamed from: c  reason: collision with root package name */
    boolean f16326c = false;

    /* renamed from: d  reason: collision with root package name */
    final i4.a f16327d;

    /* renamed from: e  reason: collision with root package name */
    final i4.b f16328e;

    /* renamed from: f  reason: collision with root package name */
    v4.b f16329f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, Boolean> f16330g = Collections.synchronizedMap(new HashMap());

    /* renamed from: m4.a$a  reason: collision with other inner class name */
    class C0172a implements Callable<Void> {
        C0172a() {
        }

        /* renamed from: a */
        public Void call() {
            try {
                a.this.f16327d.a();
                return null;
            } catch (Exception e10) {
                a.this.i().t(a.this.k(), e10.getLocalizedMessage());
                return null;
            }
        }
    }

    class b implements u4.d<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            a.this.f16326c = bool.booleanValue();
        }
    }

    class c implements Callable<Boolean> {
        c() {
        }

        /* renamed from: a */
        public Boolean call() {
            Boolean bool;
            synchronized (this) {
                a.this.i().t(a.this.k(), "Feature flags init is called");
                String h10 = a.this.h();
                try {
                    a.this.f16330g.clear();
                    String b10 = a.this.f16329f.b(h10);
                    if (!TextUtils.isEmpty(b10)) {
                        org.json.a jSONArray = new org.json.b(b10).getJSONArray("kv");
                        if (jSONArray != null && jSONArray.o() > 0) {
                            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                                org.json.b bVar = (org.json.b) jSONArray.get(i10);
                                if (bVar != null) {
                                    String string = bVar.getString("n");
                                    String string2 = bVar.getString(ReportingMessage.MessageType.SCREEN_VIEW);
                                    if (!TextUtils.isEmpty(string)) {
                                        a.this.f16330g.put(string, Boolean.valueOf(Boolean.parseBoolean(string2)));
                                    }
                                }
                            }
                        }
                        p b11 = a.this.i();
                        String a10 = a.this.k();
                        b11.t(a10, "Feature flags initialized from file " + h10 + " with configs  " + a.this.f16330g);
                    } else {
                        p b12 = a.this.i();
                        String a11 = a.this.k();
                        b12.t(a11, "Feature flags file is empty-" + h10);
                    }
                    bool = Boolean.TRUE;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    p b13 = a.this.i();
                    String a12 = a.this.k();
                    b13.t(a12, "UnArchiveData failed file- " + h10 + " " + e10.getLocalizedMessage());
                    return Boolean.FALSE;
                }
            }
            return bool;
        }
    }

    class d implements Callable<Void> {
        d() {
        }

        /* renamed from: a */
        public Void call() {
            try {
                if (a.this.f16328e.d() == null) {
                    return null;
                }
                a.this.f16328e.d().a();
                return null;
            } catch (Exception e10) {
                a.this.i().t(a.this.k(), e10.getLocalizedMessage());
                return null;
            }
        }
    }

    a(String str, CleverTapInstanceConfig cleverTapInstanceConfig, i4.b bVar, i4.a aVar, v4.b bVar2) {
        this.f16325b = str;
        this.f16324a = cleverTapInstanceConfig;
        this.f16328e = bVar;
        this.f16327d = aVar;
        this.f16329f = bVar2;
        l();
    }

    private synchronized void d(org.json.b bVar) {
        if (bVar != null) {
            try {
                this.f16329f.c(f(), g(), bVar);
                p i10 = i();
                String k10 = k();
                i10.t(k10, "Feature flags saved into file-[" + h() + "]" + this.f16330g);
            } catch (Exception e10) {
                e10.printStackTrace();
                p i11 = i();
                String k11 = k();
                i11.t(k11, "ArchiveData failed - " + e10.getLocalizedMessage());
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    public p i() {
        return this.f16324a.n();
    }

    /* access modifiers changed from: private */
    public String k() {
        return this.f16324a.e() + "[Feature Flag]";
    }

    private void n() {
        if (this.f16328e.d() != null) {
            com.clevertap.android.sdk.task.a.a(this.f16324a).b().f("notifyFeatureFlagUpdate", new d());
        }
    }

    public void e() {
        com.clevertap.android.sdk.task.a.a(this.f16324a).b().f("fetchFeatureFlags", new C0172a());
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return "Feature_Flag_" + this.f16324a.e() + JavaConstant.Dynamic.DEFAULT_NAME + this.f16325b;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return "ff_cache.json";
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return f() + RemoteSettings.FORWARD_SLASH_STRING + g();
    }

    public String j() {
        return this.f16325b;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (!TextUtils.isEmpty(this.f16325b)) {
            Task a10 = com.clevertap.android.sdk.task.a.a(this.f16324a).a();
            a10.e(new b());
            a10.f("initFeatureFlags", new c());
        }
    }

    public boolean m() {
        return this.f16326c;
    }

    public void o(String str) {
        this.f16325b = str;
        l();
    }

    public void p(String str) {
        if (!this.f16326c) {
            this.f16325b = str;
            l();
        }
    }

    public synchronized void q(org.json.b bVar) throws JSONException {
        org.json.a jSONArray = bVar.getJSONArray("kv");
        int i10 = 0;
        while (i10 < jSONArray.o()) {
            try {
                org.json.b j10 = jSONArray.j(i10);
                this.f16330g.put(j10.getString("n"), Boolean.valueOf(j10.getBoolean(ReportingMessage.MessageType.SCREEN_VIEW)));
                i10++;
            } catch (JSONException e10) {
                p i11 = i();
                String k10 = k();
                i11.t(k10, "Error parsing Feature Flag array " + e10.getLocalizedMessage());
            }
        }
        p i12 = i();
        String k11 = k();
        i12.t(k11, "Updating feature flags..." + this.f16330g);
        d(bVar);
        n();
    }
}
