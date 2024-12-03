package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.kits.AppsFlyerKit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.b;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f10646a = new SimpleDateFormat("ddMMyyyy", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f10647b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10648c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f10649d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f10650e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, Integer> f10651f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private int f10652g = 0;

    class a implements Callable<Void> {
        a() {
        }

        /* renamed from: a */
        public Void call() {
            m mVar = m.this;
            mVar.s(mVar.f10649d);
            return null;
        }
    }

    m(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        this.f10647b = cleverTapInstanceConfig;
        this.f10648c = context;
        this.f10649d = str;
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig).c().f("initInAppFCManager", new a());
    }

    private String h() {
        return this.f10647b.e();
    }

    private p i() {
        return this.f10647b.n();
    }

    private int[] j(String str) {
        String string = s.h(this.f10648c, m("counts_per_inapp", this.f10649d)).getString(str, (String) null);
        if (string == null) {
            return new int[]{0, 0};
        }
        try {
            String[] split = string.split(AppsFlyerKit.COMMA);
            if (split.length != 2) {
                return new int[]{0, 0};
            }
            return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        } catch (Throwable unused) {
            return new int[]{0, 0};
        }
    }

    private String k(CTInAppNotification cTInAppNotification) {
        if (cTInAppNotification.o() != null && !cTInAppNotification.o().isEmpty()) {
            try {
                return cTInAppNotification.o();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private int l(String str, int i10) {
        if (!this.f10647b.t()) {
            return s.c(this.f10648c, v(str), i10);
        }
        int c10 = s.c(this.f10648c, v(str), -1000);
        if (c10 != -1000) {
            return c10;
        }
        return s.c(this.f10648c, str, i10);
    }

    private String m(String str, String str2) {
        return str + CertificateUtil.DELIMITER + str2;
    }

    private String n(String str, String str2) {
        if (!this.f10647b.t()) {
            return s.i(this.f10648c, v(str), str2);
        }
        String i10 = s.i(this.f10648c, v(str), str2);
        if (i10 != null) {
            return i10;
        }
        return s.i(this.f10648c, str, str2);
    }

    private boolean o(CTInAppNotification cTInAppNotification) {
        String k10 = k(cTInAppNotification);
        if (k10 == null) {
            return false;
        }
        if (l(m("istc_inapp", this.f10649d), 0) >= l(m("istmcd_inapp", this.f10649d), 1)) {
            return true;
        }
        try {
            int E = cTInAppNotification.E();
            if (E != -1 && j(k10)[0] >= E) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean p(CTInAppNotification cTInAppNotification) {
        String k10 = k(cTInAppNotification);
        if (k10 == null || cTInAppNotification.F() == -1) {
            return false;
        }
        try {
            if (j(k10)[1] >= cTInAppNotification.F()) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean q(CTInAppNotification cTInAppNotification) {
        int i10;
        String k10 = k(cTInAppNotification);
        if (k10 == null) {
            return false;
        }
        if (this.f10650e.contains(k10)) {
            return true;
        }
        try {
            if (cTInAppNotification.t() >= 0) {
                i10 = cTInAppNotification.t();
            } else {
                i10 = 1000;
            }
            Integer num = this.f10651f.get(k10);
            if (num != null && num.intValue() >= i10) {
                return true;
            }
            if (this.f10652g >= l(m("imc", this.f10649d), 1)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void r(String str) {
        int[] j10 = j(str);
        j10[0] = j10[0] + 1;
        j10[1] = j10[1] + 1;
        SharedPreferences.Editor edit = s.h(this.f10648c, m("counts_per_inapp", this.f10649d)).edit();
        edit.putString(str, j10[0] + AppsFlyerKit.COMMA + j10[1]);
        s.l(edit);
    }

    /* access modifiers changed from: private */
    public void s(String str) {
        p i10 = i();
        i10.t(this.f10647b.e() + ":async_deviceID", "InAppFCManager init() called");
        try {
            t(str);
            String format2 = this.f10646a.format(new Date());
            if (!format2.equals(n(m("ict_date", str), "20140428"))) {
                s.p(this.f10648c, v(m("ict_date", str)), format2);
                s.n(this.f10648c, v(m("istc_inapp", str)), 0);
                SharedPreferences h10 = s.h(this.f10648c, m("counts_per_inapp", str));
                SharedPreferences.Editor edit = h10.edit();
                Map<String, ?> all = h10.getAll();
                for (String next : all.keySet()) {
                    Object obj = all.get(next);
                    if (!(obj instanceof String)) {
                        edit.remove(next);
                    } else {
                        String[] split = ((String) obj).split(AppsFlyerKit.COMMA);
                        if (split.length != 2) {
                            edit.remove(next);
                        } else {
                            try {
                                edit.putString(next, "0," + split[1]);
                            } catch (Throwable th2) {
                                p i11 = i();
                                String h11 = h();
                                i11.u(h11, "Failed to reset todayCount for inapp " + next, th2);
                            }
                        }
                    }
                }
                s.l(edit);
            }
        } catch (Exception e10) {
            p i12 = i();
            String h12 = h();
            i12.t(h12, "Failed to init inapp manager " + e10.getLocalizedMessage());
        }
    }

    private void t(String str) {
        if (n(v(m("ict_date", str)), (String) null) == null && n("ict_date", (String) null) != null) {
            p.o("Migrating InAppFC Prefs");
            s.p(this.f10648c, v(m("ict_date", str)), n("ict_date", "20140428"));
            s.n(this.f10648c, v(m("istc_inapp", str)), l(v("istc_inapp"), 0));
            SharedPreferences h10 = s.h(this.f10648c, "counts_per_inapp");
            SharedPreferences.Editor edit = h10.edit();
            SharedPreferences.Editor edit2 = s.h(this.f10648c, m("counts_per_inapp", str)).edit();
            Map<String, ?> all = h10.getAll();
            for (String next : all.keySet()) {
                Object obj = all.get(next);
                if (!(obj instanceof String)) {
                    edit.remove(next);
                } else if (((String) obj).split(AppsFlyerKit.COMMA).length != 2) {
                    edit.remove(next);
                } else {
                    edit2.putString(next, obj.toString());
                }
            }
            s.l(edit2);
            edit.clear().apply();
        }
    }

    private String v(String str) {
        return str + CertificateUtil.DELIMITER + h();
    }

    public void c(Context context, b bVar) {
        try {
            bVar.put("imp", l(m("istc_inapp", this.f10649d), 0));
            org.json.a aVar = new org.json.a();
            Map<String, ?> all = s.h(context, m("counts_per_inapp", this.f10649d)).getAll();
            for (String next : all.keySet()) {
                Object obj = all.get(next);
                if (obj instanceof String) {
                    String[] split = ((String) obj).split(AppsFlyerKit.COMMA);
                    if (split.length == 2) {
                        org.json.a aVar2 = new org.json.a();
                        aVar2.C(0, next);
                        aVar2.B(1, Integer.parseInt(split[0]));
                        aVar2.B(2, Integer.parseInt(split[1]));
                        aVar.E(aVar2);
                    }
                }
            }
            bVar.put("tlc", (Object) aVar);
        } catch (Throwable th2) {
            p.r("Failed to attach FC to header", th2);
        }
    }

    public boolean d(CTInAppNotification cTInAppNotification) {
        if (cTInAppNotification == null) {
            return false;
        }
        try {
            if (k(cTInAppNotification) == null || cTInAppNotification.M()) {
                return true;
            }
            if (q(cTInAppNotification) || p(cTInAppNotification) || o(cTInAppNotification)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public void e(String str) {
        this.f10651f.clear();
        this.f10652g = 0;
        this.f10650e.clear();
        this.f10649d = str;
        s(str);
    }

    public void f(CTInAppNotification cTInAppNotification) {
        String o10 = cTInAppNotification.o();
        if (o10 != null) {
            this.f10650e.add(o10.toString());
        }
    }

    public void g(Context context, CTInAppNotification cTInAppNotification) {
        String k10 = k(cTInAppNotification);
        if (k10 != null) {
            this.f10652g++;
            Integer num = this.f10651f.get(k10);
            if (num == null) {
                num = 1;
            }
            this.f10651f.put(k10, Integer.valueOf(num.intValue() + 1));
            r(k10);
            s.n(context, v(m("istc_inapp", this.f10649d)), l(m("istc_inapp", this.f10649d), 0) + 1);
        }
    }

    public void u(Context context, b bVar) {
        try {
            if (bVar.has("inapp_stale")) {
                org.json.a jSONArray = bVar.getJSONArray("inapp_stale");
                SharedPreferences.Editor edit = s.h(context, m("counts_per_inapp", this.f10649d)).edit();
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof Integer) {
                        edit.remove("" + obj);
                        p.a("Purged stale in-app - " + obj);
                    } else if (obj instanceof String) {
                        edit.remove((String) obj);
                        p.a("Purged stale in-app - " + obj);
                    }
                }
                s.l(edit);
            }
        } catch (Throwable th2) {
            p.r("Failed to purge out stale targets", th2);
        }
    }

    public synchronized void w(Context context, int i10, int i11) {
        s.n(context, v(m("istmcd_inapp", this.f10649d)), i10);
        s.n(context, v(m("imc", this.f10649d)), i11);
    }
}
