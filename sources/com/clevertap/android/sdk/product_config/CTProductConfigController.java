package com.clevertap.android.sdk.product_config;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.p;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.ReportingMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;

public class CTProductConfigController {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, String> f10678a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    final Map<String, String> f10679b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    AtomicBoolean f10680c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    final v4.b f10681d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final CleverTapInstanceConfig f10682e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f10683f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f10684g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private final i4.a f10685h;

    /* renamed from: i  reason: collision with root package name */
    private final i4.b f10686i;

    /* renamed from: j  reason: collision with root package name */
    private final j f10687j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final b f10688k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f10689l = Collections.synchronizedMap(new HashMap());

    private enum PROCESSING_STATE {
        INIT,
        FETCHED,
        ACTIVATED
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10694a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.clevertap.android.sdk.product_config.CTProductConfigController$PROCESSING_STATE[] r0 = com.clevertap.android.sdk.product_config.CTProductConfigController.PROCESSING_STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10694a = r0
                com.clevertap.android.sdk.product_config.CTProductConfigController$PROCESSING_STATE r1 = com.clevertap.android.sdk.product_config.CTProductConfigController.PROCESSING_STATE.INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10694a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.product_config.CTProductConfigController$PROCESSING_STATE r1 = com.clevertap.android.sdk.product_config.CTProductConfigController.PROCESSING_STATE.FETCHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10694a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.product_config.CTProductConfigController$PROCESSING_STATE r1 = com.clevertap.android.sdk.product_config.CTProductConfigController.PROCESSING_STATE.ACTIVATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.product_config.CTProductConfigController.a.<clinit>():void");
        }
    }

    class b implements Callable<Void> {
        b() {
        }

        /* renamed from: a */
        public Void call() {
            synchronized (this) {
                try {
                    HashMap hashMap = new HashMap();
                    if (!CTProductConfigController.this.f10689l.isEmpty()) {
                        hashMap.putAll(CTProductConfigController.this.f10689l);
                        CTProductConfigController.this.f10689l.clear();
                    } else {
                        CTProductConfigController cTProductConfigController = CTProductConfigController.this;
                        hashMap = cTProductConfigController.k(cTProductConfigController.h());
                    }
                    CTProductConfigController.this.f10678a.clear();
                    if (!CTProductConfigController.this.f10679b.isEmpty()) {
                        CTProductConfigController cTProductConfigController2 = CTProductConfigController.this;
                        cTProductConfigController2.f10678a.putAll(cTProductConfigController2.f10679b);
                    }
                    CTProductConfigController.this.f10678a.putAll(hashMap);
                    p n10 = CTProductConfigController.this.f10682e.n();
                    String a10 = c.a(CTProductConfigController.this.f10682e);
                    n10.t(a10, "Activated successfully with configs: " + CTProductConfigController.this.f10678a);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    p n11 = CTProductConfigController.this.f10682e.n();
                    String a11 = c.a(CTProductConfigController.this.f10682e);
                    n11.t(a11, "Activate failed: " + e10.getLocalizedMessage());
                }
            }
            return null;
        }
    }

    class c implements u4.d<Void> {
        c() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            CTProductConfigController.this.u(PROCESSING_STATE.ACTIVATED);
        }
    }

    class d implements Callable<Void> {
        d() {
        }

        /* renamed from: a */
        public Void call() {
            CTProductConfigController.this.f10682e.n().t(c.a(CTProductConfigController.this.f10682e), "Product Config: fetch Success");
            CTProductConfigController.this.u(PROCESSING_STATE.FETCHED);
            return null;
        }
    }

    class e implements Callable<Boolean> {
        e() {
        }

        /* renamed from: a */
        public Boolean call() {
            Boolean bool;
            synchronized (this) {
                try {
                    if (!CTProductConfigController.this.f10679b.isEmpty()) {
                        CTProductConfigController cTProductConfigController = CTProductConfigController.this;
                        cTProductConfigController.f10678a.putAll(cTProductConfigController.f10679b);
                    }
                    CTProductConfigController cTProductConfigController2 = CTProductConfigController.this;
                    HashMap b10 = cTProductConfigController2.k(cTProductConfigController2.h());
                    if (!b10.isEmpty()) {
                        CTProductConfigController.this.f10689l.putAll(b10);
                    }
                    p n10 = CTProductConfigController.this.f10682e.n();
                    String a10 = c.a(CTProductConfigController.this.f10682e);
                    n10.t(a10, "Loaded configs ready to be applied: " + CTProductConfigController.this.f10689l);
                    CTProductConfigController.this.f10688k.m(CTProductConfigController.this.f10681d);
                    CTProductConfigController.this.f10680c.set(true);
                    bool = Boolean.TRUE;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    p n11 = CTProductConfigController.this.f10682e.n();
                    String a11 = c.a(CTProductConfigController.this.f10682e);
                    n11.t(a11, "InitAsync failed - " + e10.getLocalizedMessage());
                    return Boolean.FALSE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return bool;
        }
    }

    class f implements u4.d<Boolean> {
        f() {
        }

        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            CTProductConfigController.this.u(PROCESSING_STATE.INIT);
        }
    }

    CTProductConfigController(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, i4.a aVar, j jVar, i4.b bVar, b bVar2, v4.b bVar3) {
        this.f10683f = context;
        this.f10682e = cleverTapInstanceConfig;
        this.f10687j = jVar;
        this.f10686i = bVar;
        this.f10685h = aVar;
        this.f10688k = bVar2;
        this.f10681d = bVar3;
        l();
    }

    private HashMap<String, String> g(org.json.b bVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            org.json.a jSONArray = bVar.getJSONArray("kv");
            if (jSONArray != null && jSONArray.o() > 0) {
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    try {
                        org.json.b bVar2 = (org.json.b) jSONArray.get(i10);
                        if (bVar2 != null) {
                            String string = bVar2.getString("n");
                            String string2 = bVar2.getString(ReportingMessage.MessageType.SCREEN_VIEW);
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(string, string2);
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        p n10 = this.f10682e.n();
                        String a10 = c.a(this.f10682e);
                        n10.t(a10, "ConvertServerJsonToMap failed: " + e10.getLocalizedMessage());
                    }
                }
            }
            return hashMap;
        } catch (JSONException e11) {
            e11.printStackTrace();
            p n11 = this.f10682e.n();
            String a11 = c.a(this.f10682e);
            n11.t(a11, "ConvertServerJsonToMap failed - " + e11.getLocalizedMessage());
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> k(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String b10 = this.f10681d.b(str);
            p n10 = this.f10682e.n();
            String a10 = c.a(this.f10682e);
            n10.t(a10, "GetStoredValues reading file success:[ " + str + "]--[Content]" + b10);
            if (!TextUtils.isEmpty(b10)) {
                try {
                    org.json.b bVar = new org.json.b(b10);
                    Iterator<String> keys = bVar.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            try {
                                String valueOf = String.valueOf(bVar.get(next));
                                if (!TextUtils.isEmpty(valueOf)) {
                                    hashMap.put(next, valueOf);
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                p n11 = this.f10682e.n();
                                String a11 = c.a(this.f10682e);
                                n11.t(a11, "GetStoredValues for key " + next + " while parsing json: " + e10.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    p n12 = this.f10682e.n();
                    String a12 = c.a(this.f10682e);
                    n12.t(a12, "GetStoredValues failed due to malformed json: " + e11.getLocalizedMessage());
                }
            }
            return hashMap;
        } catch (Exception e12) {
            e12.printStackTrace();
            p n13 = this.f10682e.n();
            String a13 = c.a(this.f10682e);
            n13.t(a13, "GetStoredValues reading file failed: " + e12.getLocalizedMessage());
            return hashMap;
        }
    }

    private void n() {
        if (this.f10686i.j() != null) {
            this.f10686i.j().a();
        }
    }

    private void q() {
        if (this.f10686i.j() != null) {
            this.f10686i.j().b();
        }
    }

    private void r() {
        if (this.f10686i.j() != null) {
            this.f10682e.n().t(this.f10682e.e(), "Product Config initialized");
            this.f10686i.j().c();
        }
    }

    private synchronized void s(org.json.b bVar) {
        HashMap<String, String> g10 = g(bVar);
        this.f10689l.clear();
        this.f10689l.putAll(g10);
        p n10 = this.f10682e.n();
        String a10 = c.a(this.f10682e);
        n10.t(a10, "Product Config: Fetched response:" + bVar);
        Integer num = null;
        try {
            num = (Integer) bVar.get("ts");
        } catch (Exception e10) {
            e10.printStackTrace();
            p n11 = this.f10682e.n();
            String a11 = c.a(this.f10682e);
            n11.t(a11, "ParseFetchedResponse failed: " + e10.getLocalizedMessage());
        }
        if (num != null) {
            this.f10688k.r(((long) num.intValue()) * 1000);
        }
    }

    /* access modifiers changed from: private */
    public void u(PROCESSING_STATE processing_state) {
        if (processing_state != null) {
            int i10 = a.f10694a[processing_state.ordinal()];
            if (i10 == 1) {
                r();
            } else if (i10 == 2) {
                q();
            } else if (i10 == 3) {
                n();
            }
        }
    }

    public void f() {
        if (!TextUtils.isEmpty(this.f10688k.g())) {
            com.clevertap.android.sdk.task.a.a(this.f10682e).a().e(new c()).f("activateProductConfigs", new b());
        }
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return i() + RemoteSettings.FORWARD_SLASH_STRING + "activated.json";
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return "Product_Config_" + this.f10682e.e() + JavaConstant.Dynamic.DEFAULT_NAME + this.f10688k.g();
    }

    public b j() {
        return this.f10688k;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (!TextUtils.isEmpty(this.f10688k.g())) {
            com.clevertap.android.sdk.task.a.a(this.f10682e).a().e(new f()).f("ProductConfig#initAsync", new e());
        }
    }

    public boolean m() {
        return this.f10680c.get();
    }

    public void o() {
        this.f10684g.compareAndSet(true, false);
        this.f10682e.n().t(c.a(this.f10682e), "Fetch Failed");
    }

    public void p(org.json.b bVar) {
        if (!TextUtils.isEmpty(this.f10688k.g())) {
            synchronized (this) {
                if (bVar != null) {
                    try {
                        s(bVar);
                        this.f10681d.c(i(), "activated.json", new org.json.b((Map<?, ?>) this.f10689l));
                        p n10 = this.f10682e.n();
                        String a10 = c.a(this.f10682e);
                        n10.t(a10, "Fetch file-[" + h() + "] write success: " + this.f10689l);
                        com.clevertap.android.sdk.task.a.a(this.f10682e).b().f("sendPCFetchSuccessCallback", new d());
                        if (this.f10684g.getAndSet(false)) {
                            f();
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        this.f10682e.n().t(c.a(this.f10682e), "Product Config: fetch Failed");
                        u(PROCESSING_STATE.FETCHED);
                        this.f10684g.compareAndSet(true, false);
                    }
                }
            }
        }
    }

    public void t() {
        this.f10688k.o(this.f10681d);
    }

    public void v(org.json.b bVar) {
        this.f10688k.p(bVar);
    }

    public void w(String str) {
        if (!m() && !TextUtils.isEmpty(str)) {
            this.f10688k.q(str);
            l();
        }
    }
}
