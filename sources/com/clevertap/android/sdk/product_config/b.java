package com.clevertap.android.sdk.product_config;

import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;
import u4.d;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CleverTapInstanceConfig f10700a;

    /* renamed from: b  reason: collision with root package name */
    private String f10701b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v4.b f10702c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f10703d = Collections.synchronizedMap(new HashMap());

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v4.b f10704a;

        a(v4.b bVar) {
            this.f10704a = bVar;
        }

        /* renamed from: a */
        public Void call() {
            synchronized (this) {
                try {
                    String f10 = b.this.f();
                    this.f10704a.a(f10);
                    p n10 = b.this.f10700a.n();
                    String a10 = c.a(b.this.f10700a);
                    n10.t(a10, "Deleted settings file" + f10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    p n11 = b.this.f10700a.n();
                    String a11 = c.a(b.this.f10700a);
                    n11.t(a11, "Error while resetting settings" + e10.getLocalizedMessage());
                }
            }
            return null;
        }
    }

    /* renamed from: com.clevertap.android.sdk.product_config.b$b  reason: collision with other inner class name */
    class C0123b implements Callable<Boolean> {
        C0123b() {
        }

        /* renamed from: a */
        public Boolean call() {
            try {
                HashMap hashMap = new HashMap(b.this.f10703d);
                hashMap.remove("fetch_min_interval_seconds");
                b.this.f10702c.c(b.this.e(), "config_settings.json", new org.json.b((Map<?, ?>) hashMap));
                return Boolean.TRUE;
            } catch (Exception e10) {
                e10.printStackTrace();
                p n10 = b.this.f10700a.n();
                String a10 = c.a(b.this.f10700a);
                n10.t(a10, "UpdateConfigToFile failed: " + e10.getLocalizedMessage());
                return Boolean.FALSE;
            }
        }
    }

    class c implements d<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                p n10 = b.this.f10700a.n();
                String a10 = c.a(b.this.f10700a);
                n10.t(a10, "Product Config settings: writing Success " + b.this.f10703d);
                return;
            }
            b.this.f10700a.n().t(c.a(b.this.f10700a), "Product Config settings: writing Failed");
        }
    }

    b(String str, CleverTapInstanceConfig cleverTapInstanceConfig, v4.b bVar) {
        this.f10701b = str;
        this.f10700a = cleverTapInstanceConfig;
        this.f10702c = bVar;
        l();
    }

    private synchronized int j() {
        int i10;
        i10 = 5;
        String str = this.f10703d.get("rc_n");
        try {
            if (!TextUtils.isEmpty(str)) {
                i10 = (int) Double.parseDouble(str);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            p n10 = this.f10700a.n();
            String a10 = c.a(this.f10700a);
            n10.t(a10, "GetNoOfCallsInAllowedWindow failed: " + e10.getLocalizedMessage());
        }
        return i10;
    }

    private synchronized int k() {
        int i10;
        i10 = 60;
        String str = this.f10703d.get("rc_w");
        try {
            if (!TextUtils.isEmpty(str)) {
                i10 = (int) Double.parseDouble(str);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            p n10 = this.f10700a.n();
            String a10 = c.a(this.f10700a);
            n10.t(a10, "GetWindowIntervalInMinutes failed: " + e10.getLocalizedMessage());
        }
        return i10;
    }

    private synchronized void s(int i10) {
        long j10 = (long) j();
        if (i10 > 0 && j10 != ((long) i10)) {
            this.f10703d.put("rc_n", String.valueOf(i10));
            v();
        }
    }

    private void t(String str, int i10) {
        str.hashCode();
        if (str.equals("rc_n")) {
            s(i10);
        } else if (str.equals("rc_w")) {
            u(i10);
        }
    }

    private synchronized void u(int i10) {
        int k10 = k();
        if (i10 > 0 && k10 != i10) {
            this.f10703d.put("rc_w", String.valueOf(i10));
            v();
        }
    }

    private synchronized void v() {
        com.clevertap.android.sdk.task.a.a(this.f10700a).a().e(new c()).f("ProductConfigSettings#updateConfigToFile", new C0123b());
    }

    /* access modifiers changed from: package-private */
    public void d(v4.b bVar) {
        if (bVar != null) {
            com.clevertap.android.sdk.task.a.a(this.f10700a).a().f("ProductConfigSettings#eraseStoredSettingsFile", new a(bVar));
            return;
        }
        throw new IllegalArgumentException("FileUtils can't be null");
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return "Product_Config_" + this.f10700a.e() + JavaConstant.Dynamic.DEFAULT_NAME + this.f10701b;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return e() + RemoteSettings.FORWARD_SLASH_STRING + "config_settings.json";
    }

    public String g() {
        return this.f10701b;
    }

    /* access modifiers changed from: package-private */
    public org.json.b h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new org.json.b(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            p n10 = this.f10700a.n();
            String a10 = c.a(this.f10700a);
            n10.t(a10, "LoadSettings failed: " + e10.getLocalizedMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized long i() {
        long j10;
        j10 = 0;
        String str = this.f10703d.get("ts");
        try {
            if (!TextUtils.isEmpty(str)) {
                j10 = (long) Double.parseDouble(str);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            p n10 = this.f10700a.n();
            String a10 = c.a(this.f10700a);
            n10.t(a10, "GetLastFetchTimeStampInMillis failed: " + e10.getLocalizedMessage());
        }
        return j10;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f10703d.put("rc_n", String.valueOf(5));
        this.f10703d.put("rc_w", String.valueOf(60));
        this.f10703d.put("ts", String.valueOf(0));
        this.f10703d.put("fetch_min_interval_seconds", String.valueOf(r4.a.f17272a));
        p n10 = this.f10700a.n();
        String a10 = c.a(this.f10700a);
        n10.t(a10, "Settings loaded with default values: " + this.f10703d);
    }

    /* access modifiers changed from: package-private */
    public synchronized void m(v4.b bVar) {
        if (bVar != null) {
            try {
                n(h(bVar.b(f())));
            } catch (Exception e10) {
                e10.printStackTrace();
                p n10 = this.f10700a.n();
                String a10 = c.a(this.f10700a);
                n10.t(a10, "LoadSettings failed while reading file: " + e10.getLocalizedMessage());
            }
        } else {
            throw new IllegalArgumentException("fileutils can't be null");
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void n(org.json.b bVar) {
        if (bVar != null) {
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    try {
                        String valueOf = String.valueOf(bVar.get(next));
                        if (!TextUtils.isEmpty(valueOf)) {
                            this.f10703d.put(next, valueOf);
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        p n10 = this.f10700a.n();
                        String a10 = c.a(this.f10700a);
                        n10.t(a10, "Failed loading setting for key " + next + " Error: " + e10.getLocalizedMessage());
                    }
                }
            }
            p n11 = this.f10700a.n();
            String a11 = c.a(this.f10700a);
            n11.t(a11, "LoadSettings completed with settings: " + this.f10703d);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(v4.b bVar) {
        l();
        d(bVar);
    }

    /* access modifiers changed from: package-private */
    public void p(org.json.b bVar) {
        if (bVar != null) {
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!TextUtils.isEmpty(next)) {
                        Object obj = bVar.get(next);
                        if (obj instanceof Number) {
                            int doubleValue = (int) ((Number) obj).doubleValue();
                            if ("rc_n".equalsIgnoreCase(next) || "rc_w".equalsIgnoreCase(next)) {
                                t(next, doubleValue);
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    p n10 = this.f10700a.n();
                    String a10 = c.a(this.f10700a);
                    n10.t(a10, "Product Config setARPValue failed " + e10.getLocalizedMessage());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
        this.f10701b = str;
    }

    /* access modifiers changed from: package-private */
    public synchronized void r(long j10) {
        long i10 = i();
        if (j10 >= 0 && i10 != j10) {
            this.f10703d.put("ts", String.valueOf(j10));
            v();
        }
    }
}
