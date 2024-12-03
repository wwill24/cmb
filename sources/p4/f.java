package p4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.c;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.n;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.r;
import i4.b;
import i4.e;
import i4.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import w4.d;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final Object f17006q = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f17007a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f17008b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final l4.a f17009c;

    /* renamed from: d  reason: collision with root package name */
    private final e f17010d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final b f17011e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final CleverTapInstanceConfig f17012f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f17013g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final i f17014h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final j f17015i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final com.clevertap.android.sdk.db.a f17016j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final l f17017k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final n f17018l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final com.clevertap.android.sdk.pushnotification.j f17019m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final r f17020n;

    /* renamed from: o  reason: collision with root package name */
    private final d f17021o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f17022p = null;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f17023a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17024b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17025c;

        a(Map map, String str, String str2) {
            this.f17023a = map;
            this.f17024b = str;
            this.f17025c = str2;
        }

        /* renamed from: a */
        public Void call() {
            String str;
            try {
                p n10 = f.this.f17012f.n();
                String e10 = f.this.f17012f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("asyncProfileSwitchUser:[profile ");
                sb2.append(this.f17023a);
                sb2.append(" with Cached GUID ");
                if (this.f17024b != null) {
                    str = f.this.f17007a;
                } else {
                    str = "NULL and cleverTapID " + this.f17025c;
                }
                sb2.append(str);
                n10.t(e10, sb2.toString());
                f.this.f17015i.P(false);
                f.this.f17019m.w(false);
                f.this.f17009c.b(f.this.f17013g, EventGroup.REGULAR);
                f.this.f17009c.b(f.this.f17013g, EventGroup.PUSH_NOTIFICATION_VIEWED);
                f.this.f17016j.a(f.this.f17013g);
                f.this.f17018l.m();
                j.H(1);
                f.this.f17020n.c();
                if (this.f17024b != null) {
                    f.this.f17017k.j(this.f17024b);
                    f.this.f17011e.p(this.f17024b);
                } else if (f.this.f17012f.k()) {
                    f.this.f17017k.i(this.f17025c);
                } else {
                    f.this.f17017k.h();
                }
                f.this.f17011e.p(f.this.f17017k.x());
                f.this.f17017k.Y();
                f.this.f17008b.w();
                if (this.f17023a != null) {
                    f.this.f17008b.I(this.f17023a);
                }
                f.this.f17019m.w(true);
                synchronized (f.f17006q) {
                    String unused = f.this.f17022p = null;
                }
                f.this.A();
                f.this.z();
                f.this.B();
                f.this.x();
                f.this.y();
                f.this.f17014h.h().e(f.this.f17017k.x());
            } catch (Throwable th2) {
                f.this.f17012f.n().u(f.this.f17012f.e(), "Reset Profile error", th2);
            }
            return null;
        }
    }

    public f(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, d dVar, l4.a aVar, c cVar, j jVar, i iVar, r rVar, n nVar, b bVar, com.clevertap.android.sdk.db.b bVar2, e eVar) {
        this.f17012f = cleverTapInstanceConfig;
        this.f17013g = context;
        this.f17017k = lVar;
        this.f17021o = dVar;
        this.f17009c = aVar;
        this.f17008b = cVar;
        this.f17015i = jVar;
        this.f17019m = iVar.i();
        this.f17020n = rVar;
        this.f17018l = nVar;
        this.f17011e = bVar;
        this.f17016j = bVar2;
        this.f17014h = iVar;
        this.f17010d = eVar;
    }

    /* access modifiers changed from: private */
    public void A() {
        synchronized (this.f17010d.b()) {
            this.f17014h.m((n4.d) null);
        }
        this.f17014h.j();
    }

    /* access modifiers changed from: private */
    public void B() {
        if (this.f17012f.p()) {
            this.f17012f.n().f(this.f17012f.e(), "Product Config is not enabled for this instance");
            return;
        }
        if (this.f17014h.f() != null) {
            this.f17014h.f().t();
        }
        this.f17014h.n(com.clevertap.android.sdk.product_config.a.a(this.f17013g, this.f17017k, this.f17012f, this.f17008b, this.f17015i, this.f17011e));
        this.f17012f.n().t(this.f17012f.e(), "Product Config reset");
    }

    private void a(Map<String, Object> map, String str) {
        if (map != null) {
            try {
                String x10 = this.f17017k.x();
                if (x10 != null) {
                    boolean z10 = false;
                    g gVar = new g(this.f17013g, this.f17012f, this.f17017k);
                    b a10 = c.a(this.f17013g, this.f17012f, this.f17017k, this.f17021o);
                    for (String next : map.keySet()) {
                        Object obj = map.get(next);
                        if (a10.a(next)) {
                            String str2 = null;
                            if (obj != null) {
                                try {
                                    str2 = obj.toString();
                                } catch (Throwable unused) {
                                    continue;
                                }
                            }
                            if (str2 != null && str2.length() > 0) {
                                z10 = true;
                                String e10 = gVar.e(next, str2);
                                this.f17007a = e10;
                                if (e10 == null) {
                                }
                            }
                        }
                    }
                    if (this.f17017k.R() || (z10 && !gVar.f())) {
                        String str3 = this.f17007a;
                        if (str3 == null || !str3.equals(x10)) {
                            String obj2 = map.toString();
                            if (v(obj2)) {
                                p n10 = this.f17012f.n();
                                String e11 = this.f17012f.e();
                                n10.f(e11, "Already processing onUserLogin for " + obj2);
                                return;
                            }
                            synchronized (f17006q) {
                                this.f17022p = obj2;
                            }
                            p n11 = this.f17012f.n();
                            String e12 = this.f17012f.e();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("onUserLogin: queuing reset profile for ");
                            sb2.append(obj2);
                            sb2.append(" with Cached GUID ");
                            String str4 = this.f17007a;
                            if (str4 == null) {
                                str4 = "NULL";
                            }
                            sb2.append(str4);
                            n11.t(e12, sb2.toString());
                            u(map, this.f17007a, str);
                            return;
                        }
                        p n12 = this.f17012f.n();
                        String e13 = this.f17012f.e();
                        n12.f(e13, "onUserLogin: " + map.toString() + " maps to current device id " + x10 + " pushing on current profile");
                        this.f17008b.I(map);
                        return;
                    }
                    this.f17012f.n().f(this.f17012f.e(), "onUserLogin: no identifier provided or device is anonymous, pushing on current user profile");
                    this.f17008b.I(map);
                }
            } catch (Throwable th2) {
                this.f17012f.n().u(this.f17012f.e(), "onUserLogin failed", th2);
            }
        }
    }

    private boolean v(String str) {
        boolean z10;
        synchronized (f17006q) {
            String str2 = this.f17022p;
            if (str2 == null || !str2.equals(str)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.f17014h.c() != null) {
            this.f17014h.c().a();
        } else {
            this.f17012f.n().t(this.f17012f.e(), "DisplayUnit : Can't reset Display Units, DisplayUnitcontroller is null");
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        m4.a d10 = this.f17014h.d();
        if (d10 == null || !d10.m()) {
            this.f17012f.n().t(this.f17012f.e(), "DisplayUnit : Can't reset Display Units, CTFeatureFlagsController is null");
            return;
        }
        d10.o(this.f17017k.x());
        d10.e();
    }

    public void u(Map<String, Object> map, String str, String str2) {
        com.clevertap.android.sdk.task.a.a(this.f17012f).c().f("resetProfile", new a(map, str, str2));
    }

    public void w(Map<String, Object> map, String str) {
        if (this.f17012f.k()) {
            if (str == null) {
                p.j("CLEVERTAP_USE_CUSTOM_ID has been specified in the AndroidManifest.xml Please call onUserlogin() and pass a custom CleverTap ID");
            }
        } else if (str != null) {
            p.j("CLEVERTAP_USE_CUSTOM_ID has not been specified in the AndroidManifest.xml Please call CleverTapAPI.defaultInstance() without a custom CleverTap ID");
        }
        a(map, str);
    }

    public void x() {
        Iterator<w4.b> it = this.f17017k.M().iterator();
        while (it.hasNext()) {
            this.f17021o.b(it.next());
        }
    }
}
