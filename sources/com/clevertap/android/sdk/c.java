package com.clevertap.android.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.validation.Validator;
import com.coffeemeetsbagel.models.util.FacebookParse;
import i4.i;
import i4.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import t4.g;
import t4.j;
import t4.k;

public class c extends i4.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i4.e f10119a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f10120b = new HashMap<>(8);

    /* renamed from: c  reason: collision with root package name */
    private final l4.a f10121c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final i4.b f10122d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final CleverTapInstanceConfig f10123e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Context f10124f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final i f10125g;

    /* renamed from: h  reason: collision with root package name */
    private final j f10126h;

    /* renamed from: i  reason: collision with root package name */
    private final l f10127i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final n f10128j;

    /* renamed from: k  reason: collision with root package name */
    private final w4.d f10129k;

    /* renamed from: l  reason: collision with root package name */
    private final Validator f10130l;

    /* renamed from: m  reason: collision with root package name */
    private final HashMap<String, Object> f10131m = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private final Object f10132n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private final HashMap<String, Object> f10133o = new HashMap<>();

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f10135b;

        a(String str, ArrayList arrayList) {
            this.f10134a = str;
            this.f10135b = arrayList;
        }

        /* renamed from: a */
        public Void call() {
            String str;
            if (c.this.f10128j.v(this.f10134a) != null) {
                str = "$add";
            } else {
                str = "$set";
            }
            c.this.g(this.f10135b, this.f10134a, str);
            return null;
        }
    }

    class b implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f10137a;

        b(Bundle bundle) {
            this.f10137a = bundle;
        }

        /* renamed from: a */
        public Void call() {
            try {
                p.o("Received in-app via push payload: " + this.f10137a.getString("wzrk_inapp"));
                org.json.b bVar = new org.json.b();
                org.json.a aVar = new org.json.a();
                bVar.put("inapp_notifs", (Object) aVar);
                aVar.E(new org.json.b(this.f10137a.getString("wzrk_inapp")));
                new j(new t4.e(), c.this.f10123e, c.this.f10125g, true).a(bVar, (String) null, c.this.f10124f);
            } catch (Throwable th2) {
                p.r("Failed to display inapp notification from push notification payload", th2);
            }
            return null;
        }
    }

    /* renamed from: com.clevertap.android.sdk.c$c  reason: collision with other inner class name */
    class C0116c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f10139a;

        C0116c(Bundle bundle) {
            this.f10139a = bundle;
        }

        /* renamed from: a */
        public Void call() {
            try {
                p.o("Received inbox via push payload: " + this.f10139a.getString("wzrk_inbox"));
                org.json.b bVar = new org.json.b();
                org.json.a aVar = new org.json.a();
                bVar.put("inbox_notifs", (Object) aVar);
                org.json.b bVar2 = new org.json.b(this.f10139a.getString("wzrk_inbox"));
                bVar2.put("_id", (Object) String.valueOf(System.currentTimeMillis() / 1000));
                aVar.E(bVar2);
                new k(new t4.e(), c.this.f10123e, c.this.f10119a, c.this.f10122d, c.this.f10125g).a(bVar, (String) null, c.this.f10124f);
            } catch (Throwable th2) {
                p.r("Failed to process inbox message from push notification payload", th2);
            }
            return null;
        }
    }

    class d implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f10141a;

        d(Map map) {
            this.f10141a = map;
        }

        /* renamed from: a */
        public Void call() {
            c.this.h(this.f10141a);
            return null;
        }
    }

    class e implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10143a;

        e(String str) {
            this.f10143a = str;
        }

        /* renamed from: a */
        public Void call() {
            c.this.i(this.f10143a);
            return null;
        }
    }

    c(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l4.a aVar, Validator validator, w4.d dVar, j jVar, n nVar, l lVar, i4.b bVar, i iVar, i4.e eVar) {
        this.f10124f = context;
        this.f10123e = cleverTapInstanceConfig;
        this.f10121c = aVar;
        this.f10130l = validator;
        this.f10129k = dVar;
        this.f10126h = jVar;
        this.f10128j = nVar;
        this.f10127i = lVar;
        this.f10122d = bVar;
        this.f10119a = eVar;
        this.f10125g = iVar;
    }

    private org.json.a b(ArrayList<String> arrayList, String str) {
        String str2;
        if (!(arrayList == null || str == null)) {
            try {
                org.json.a aVar = new org.json.a();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next == null) {
                        next = "";
                    }
                    w4.b d10 = this.f10130l.d(next);
                    if (d10.a() != 0) {
                        this.f10129k.b(d10);
                    }
                    if (d10.c() != null) {
                        str2 = d10.c().toString();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        if (!str2.isEmpty()) {
                            aVar.E(str2);
                        }
                    }
                    d(str);
                    return null;
                }
                return aVar;
            } catch (Throwable th2) {
                this.f10123e.n().u(this.f10123e.e(), "Error cleaning multi values for key " + str, th2);
                d(str);
            }
        }
        return null;
    }

    private org.json.a c(String str, String str2) {
        boolean equals = str2.equals("$remove");
        boolean equals2 = str2.equals("$add");
        if (!equals && !equals2) {
            return new org.json.a();
        }
        Object f10 = f(str);
        org.json.a aVar = null;
        if (f10 == null) {
            if (equals) {
                return null;
            }
            return new org.json.a();
        } else if (f10 instanceof org.json.a) {
            return (org.json.a) f10;
        } else {
            if (equals2) {
                aVar = new org.json.a();
            }
            String j10 = j(f10);
            if (j10 != null) {
                return new org.json.a().E(j10);
            }
            return aVar;
        }
    }

    private void e(String str) {
        this.f10129k.b(w4.c.b(523, 23, str));
        p n10 = this.f10123e.n();
        String e10 = this.f10123e.e();
        n10.f(e10, "Invalid multi-value property key " + str + " profile multi value operation aborted");
    }

    private Object f(String str) {
        return this.f10128j.v(str);
    }

    /* access modifiers changed from: private */
    public void g(ArrayList<String> arrayList, String str, String str2) {
        String str3;
        if (str != null) {
            if (arrayList == null || arrayList.isEmpty()) {
                d(str);
                return;
            }
            w4.b c10 = this.f10130l.c(str);
            if (c10.a() != 0) {
                this.f10129k.b(c10);
            }
            if (c10.c() != null) {
                str3 = c10.c().toString();
            } else {
                str3 = null;
            }
            if (str3 == null || str3.isEmpty()) {
                e(str);
                return;
            }
            try {
                k(c(str3, str2), b(arrayList, str3), arrayList, str3, str2);
            } catch (Throwable th2) {
                p n10 = this.f10123e.n();
                String e10 = this.f10123e.e();
                n10.u(e10, "Error handling multi value operation for key " + str3, th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(Map<String, Object> map) {
        String str;
        if (map != null && !map.isEmpty()) {
            try {
                org.json.b bVar = new org.json.b();
                org.json.b bVar2 = new org.json.b();
                for (String next : map.keySet()) {
                    Object obj = map.get(next);
                    w4.b e10 = this.f10130l.e(next);
                    String obj2 = e10.c().toString();
                    if (e10.a() != 0) {
                        this.f10129k.b(e10);
                    }
                    if (obj2.isEmpty()) {
                        w4.b b10 = w4.c.b(512, 2, new String[0]);
                        this.f10129k.b(b10);
                        this.f10123e.n().f(this.f10123e.e(), b10.b());
                    } else {
                        try {
                            w4.b f10 = this.f10130l.f(obj, Validator.ValidationContext.Profile);
                            Object c10 = f10.c();
                            if (f10.a() != 0) {
                                this.f10129k.b(f10);
                            }
                            String str2 = c10;
                            if (obj2.equalsIgnoreCase("Phone")) {
                                String obj3 = c10.toString();
                                String u10 = this.f10127i.u();
                                if ((u10 == null || u10.isEmpty()) && !obj3.startsWith("+")) {
                                    w4.b b11 = w4.c.b(512, 4, obj3);
                                    this.f10129k.b(b11);
                                    this.f10123e.n().f(this.f10123e.e(), b11.b());
                                }
                                p n10 = this.f10123e.n();
                                String e11 = this.f10123e.e();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Profile phone is: ");
                                sb2.append(obj3);
                                sb2.append(" device country code is: ");
                                if (u10 == null) {
                                    u10 = "null";
                                }
                                sb2.append(u10);
                                n10.t(e11, sb2.toString());
                                str2 = obj3;
                            }
                            bVar2.put(obj2, str2);
                            bVar.put(obj2, str2);
                        } catch (Throwable unused) {
                            String[] strArr = new String[2];
                            if (obj != null) {
                                str = obj.toString();
                            } else {
                                str = "";
                            }
                            strArr[0] = str;
                            strArr[1] = obj2;
                            w4.b b12 = w4.c.b(512, 3, strArr);
                            this.f10129k.b(b12);
                            this.f10123e.n().f(this.f10123e.e(), b12.b());
                        }
                    }
                }
                p n11 = this.f10123e.n();
                String e12 = this.f10123e.e();
                n11.t(e12, "Constructed custom profile: " + bVar.toString());
                if (bVar2.length() > 0) {
                    this.f10128j.N(bVar2);
                }
                this.f10121c.c(bVar, false);
            } catch (Exception e13) {
                this.f10129k.b(w4.c.b(512, 5, new String[0]));
                p n12 = this.f10123e.n();
                String e14 = this.f10123e.e();
                n12.f(e14, "Invalid phone number: " + e13.getLocalizedMessage());
            } catch (Throwable th2) {
                this.f10123e.n().u(this.f10123e.e(), "Failed to push profile", th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(String str) {
        if (str == null) {
            str = "";
        }
        try {
            w4.b e10 = this.f10130l.e(str);
            str = e10.c().toString();
            if (str.isEmpty()) {
                w4.b b10 = w4.c.b(512, 6, new String[0]);
                this.f10129k.b(b10);
                this.f10123e.n().f(this.f10123e.e(), b10.b());
                return;
            }
            if (e10.a() != 0) {
                this.f10129k.b(e10);
            }
            if (str.toLowerCase().contains("identity")) {
                p n10 = this.f10123e.n();
                String e11 = this.f10123e.e();
                n10.t(e11, "Cannot remove value for key " + str + " from user profile");
                return;
            }
            this.f10128j.G(str);
            this.f10121c.c(new org.json.b().put(str, (Object) new org.json.b().put("$delete", true)), true);
            p n11 = this.f10123e.n();
            String e12 = this.f10123e.e();
            n11.t(e12, "removing value for key " + str + " from user profile");
        } catch (Throwable th2) {
            p n12 = this.f10123e.n();
            String e13 = this.f10123e.e();
            n12.u(e13, "Failed to remove profile value for key " + str, th2);
        }
    }

    private String j(Object obj) {
        String k10 = v4.a.k(obj);
        if (k10 == null) {
            return k10;
        }
        w4.b d10 = this.f10130l.d(k10);
        if (d10.a() != 0) {
            this.f10129k.b(d10);
        }
        if (d10.c() != null) {
            return d10.c().toString();
        }
        return null;
    }

    private void k(org.json.a aVar, org.json.a aVar2, ArrayList<String> arrayList, String str, String str2) {
        String str3;
        if (aVar != null && aVar2 != null && arrayList != null && str != null && str2 != null) {
            try {
                if (str2.equals("$remove")) {
                    str3 = "multiValuePropertyRemoveValues";
                } else {
                    str3 = "multiValuePropertyAddValues";
                }
                w4.b j10 = this.f10130l.j(aVar, aVar2, str3, str);
                if (j10.a() != 0) {
                    this.f10129k.b(j10);
                }
                org.json.a aVar3 = (org.json.a) j10.c();
                if (aVar3 != null) {
                    if (aVar3.o() > 0) {
                        this.f10128j.L(str, aVar3);
                        org.json.b bVar = new org.json.b();
                        bVar.put(str2, (Object) new org.json.a((Collection<?>) arrayList));
                        org.json.b bVar2 = new org.json.b();
                        bVar2.put(str, (Object) bVar);
                        this.f10121c.c(bVar2, false);
                        p n10 = this.f10123e.n();
                        String e10 = this.f10123e.e();
                        n10.t(e10, "Constructed multi-value profile push: " + bVar2.toString());
                    }
                }
                this.f10128j.G(str);
                org.json.b bVar3 = new org.json.b();
                bVar3.put(str2, (Object) new org.json.a((Collection<?>) arrayList));
                org.json.b bVar22 = new org.json.b();
                bVar22.put(str, (Object) bVar3);
                this.f10121c.c(bVar22, false);
                p n102 = this.f10123e.n();
                String e102 = this.f10123e.e();
                n102.t(e102, "Constructed multi-value profile push: " + bVar22.toString());
            } catch (Throwable th2) {
                p n11 = this.f10123e.n();
                String e11 = this.f10123e.e();
                n11.u(e11, "Error pushing multiValue for key " + str, th2);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean v(android.os.Bundle r9, java.util.HashMap<java.lang.String, java.lang.Object> r10, int r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f10132n
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = "wzrk_id"
            java.lang.String r9 = r9.getString(r2)     // Catch:{ all -> 0x002e }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002e }
            boolean r4 = r10.containsKey(r9)     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0027
            java.lang.Object r4 = r10.get(r9)     // Catch:{ all -> 0x002e }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x002e }
            long r4 = r4.longValue()     // Catch:{ all -> 0x002e }
            long r4 = r2 - r4
            long r6 = (long) r11     // Catch:{ all -> 0x002e }
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0027
            r11 = 1
            r1 = r11
        L_0x0027:
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x002e }
            r10.put(r9, r11)     // Catch:{ all -> 0x002e }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r1
        L_0x0030:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.c.v(android.os.Bundle, java.util.HashMap, int):boolean");
    }

    private void x(Bundle bundle) {
        try {
            new g(new t4.e(), this.f10123e, this.f10122d, this.f10125g).a(v4.a.a(bundle), (String) null, this.f10124f);
        } catch (Throwable th2) {
            p.r("Failed to process Display Unit from push notification payload", th2);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void A(Uri uri, boolean z10) {
        if (uri != null) {
            try {
                org.json.b b10 = v4.e.b(uri);
                if (b10.has("us")) {
                    this.f10126h.b0(b10.get("us").toString());
                }
                if (b10.has("um")) {
                    this.f10126h.Y(b10.get("um").toString());
                }
                if (b10.has("uc")) {
                    this.f10126h.M(b10.get("uc").toString());
                }
                b10.put("referrer", (Object) uri.toString());
                if (z10) {
                    b10.put("install", true);
                }
                J(b10);
            } catch (Throwable th2) {
                this.f10123e.n().u(this.f10123e.e(), "Failed to push deep link", th2);
            }
        } else {
            return;
        }
        return;
    }

    public void B(String str, Map<String, Object> map) {
        String obj;
        Object obj2;
        String obj3;
        String str2;
        if (str != null && !str.equals("")) {
            w4.b i10 = this.f10130l.i(str);
            if (i10.a() > 0) {
                this.f10129k.b(i10);
                return;
            }
            w4.b h10 = this.f10130l.h(str);
            if (h10.a() > 0) {
                this.f10129k.b(h10);
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            org.json.b bVar = new org.json.b();
            try {
                w4.b b10 = this.f10130l.b(str);
                if (b10.a() != 0) {
                    bVar.put("wzrk_error", (Object) v4.a.c(b10));
                }
                obj = b10.c().toString();
                org.json.b bVar2 = new org.json.b();
                for (String next : map.keySet()) {
                    obj2 = map.get(next);
                    w4.b e10 = this.f10130l.e(next);
                    obj3 = e10.c().toString();
                    if (e10.a() != 0) {
                        bVar.put("wzrk_error", (Object) v4.a.c(e10));
                    }
                    w4.b f10 = this.f10130l.f(obj2, Validator.ValidationContext.Event);
                    Object c10 = f10.c();
                    if (f10.a() != 0) {
                        bVar.put("wzrk_error", (Object) v4.a.c(f10));
                    }
                    bVar2.put(obj3, c10);
                }
                bVar.put("evtName", (Object) obj);
                bVar.put("evtData", (Object) bVar2);
                this.f10121c.e(this.f10124f, bVar, 4);
            } catch (IllegalArgumentException unused) {
                String[] strArr = new String[3];
                strArr[0] = obj;
                strArr[1] = obj3;
                if (obj2 != null) {
                    str2 = obj2.toString();
                } else {
                    str2 = "";
                }
                strArr[2] = str2;
                w4.b b11 = w4.c.b(512, 7, strArr);
                this.f10123e.n().f(this.f10123e.e(), b11.b());
                this.f10129k.b(b11);
            } catch (Throwable unused2) {
            }
        }
    }

    public void C(boolean z10, CTInAppNotification cTInAppNotification, Bundle bundle) {
        org.json.b bVar = new org.json.b();
        try {
            org.json.b f10 = v4.a.f(cTInAppNotification);
            if (bundle != null) {
                for (String next : bundle.keySet()) {
                    Object obj = bundle.get(next);
                    if (obj != null) {
                        f10.put(next, obj);
                    }
                }
            }
            if (z10) {
                try {
                    this.f10126h.c0(f10);
                } catch (Throwable unused) {
                }
                bVar.put("evtName", (Object) "Notification Clicked");
            } else {
                bVar.put("evtName", (Object) "Notification Viewed");
            }
            bVar.put("evtData", (Object) f10);
            this.f10121c.e(this.f10124f, bVar, 4);
        } catch (Throwable unused2) {
        }
    }

    /* access modifiers changed from: package-private */
    public void D(boolean z10, CTInboxMessage cTInboxMessage, Bundle bundle) {
        org.json.b bVar = new org.json.b();
        try {
            org.json.b g10 = v4.a.g(cTInboxMessage);
            if (bundle != null) {
                for (String next : bundle.keySet()) {
                    Object obj = bundle.get(next);
                    if (obj != null) {
                        g10.put(next, obj);
                    }
                }
            }
            if (z10) {
                try {
                    this.f10126h.c0(g10);
                } catch (Throwable unused) {
                }
                bVar.put("evtName", (Object) "Notification Clicked");
            } else {
                bVar.put("evtName", (Object) "Notification Viewed");
            }
            bVar.put("evtData", (Object) g10);
            this.f10121c.e(this.f10124f, bVar, 4);
        } catch (Throwable unused2) {
        }
    }

    public void E(String str) {
        try {
            p n10 = this.f10123e.n();
            String e10 = this.f10123e.e();
            n10.t(e10, "Referrer received: " + str);
            if (str != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!this.f10120b.containsKey(str) || currentTimeMillis - this.f10120b.get(str).intValue() >= 10) {
                    this.f10120b.put(str, Integer.valueOf(currentTimeMillis));
                    A(Uri.parse("wzrk://track?install=true&" + str), true);
                    return;
                }
                this.f10123e.n().t(this.f10123e.e(), "Skipping install referrer due to duplicate within 10 seconds");
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void F(String str, String str2, String str3) {
        if (str != null || str2 != null || str3 != null) {
            try {
                if (s.c(this.f10124f, "app_install_status", 0) != 0) {
                    p.a("Install referrer has already been set. Will not override it");
                    return;
                }
                s.n(this.f10124f, "app_install_status", 1);
                if (str != null) {
                    str = Uri.encode(str);
                }
                if (str2 != null) {
                    str2 = Uri.encode(str2);
                }
                if (str3 != null) {
                    str3 = Uri.encode(str3);
                }
                String str4 = "wzrk://track?install=true";
                if (str != null) {
                    str4 = str4 + "&utm_source=" + str;
                }
                if (str2 != null) {
                    str4 = str4 + "&utm_medium=" + str2;
                }
                if (str3 != null) {
                    str4 = str4 + "&utm_campaign=" + str3;
                }
                A(Uri.parse(str4), true);
            } catch (Throwable th2) {
                p.r("Failed to push install referrer", th2);
            }
        } else {
            return;
        }
        return;
    }

    public void G(Bundle bundle) {
        String str;
        boolean z10;
        if (this.f10123e.p()) {
            this.f10123e.n().f(this.f10123e.e(), "is Analytics Only - will not process Notification Clicked event.");
        } else if (bundle == null || bundle.isEmpty() || bundle.get("wzrk_pn") == null) {
            p n10 = this.f10123e.n();
            String e10 = this.f10123e.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Push notification: ");
            if (bundle == null) {
                str = "NULL";
            } else {
                str = bundle.toString();
            }
            sb2.append(str);
            sb2.append(" not from CleverTap - will not process Notification Clicked event.");
            n10.f(e10, sb2.toString());
        } else {
            String str2 = null;
            try {
                str2 = bundle.getString("wzrk_acct_id");
            } catch (Throwable unused) {
            }
            if ((str2 != null || !this.f10123e.t()) && !this.f10123e.e().equals(str2)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                this.f10123e.n().f(this.f10123e.e(), "Push notification not targeted at this instance, not processing Notification Clicked Event");
            } else if (bundle.containsKey("wzrk_inapp")) {
                com.clevertap.android.sdk.task.a.a(this.f10123e).c().f("testInappNotification", new b(bundle));
            } else if (bundle.containsKey("wzrk_inbox")) {
                com.clevertap.android.sdk.task.a.a(this.f10123e).c().f("testInboxNotification", new C0116c(bundle));
            } else if (bundle.containsKey("wzrk_adunit")) {
                x(bundle);
            } else if (!bundle.containsKey("wzrk_id") || bundle.getString("wzrk_id") == null) {
                p n11 = this.f10123e.n();
                String e11 = this.f10123e.e();
                n11.f(e11, "Push notification ID Tag is null, not processing Notification Clicked event for:  " + bundle.toString());
            } else if (v(bundle, this.f10131m, FacebookParse.FB_NO_LIMIT)) {
                p n12 = this.f10123e.n();
                String e12 = this.f10123e.e();
                n12.f(e12, "Already processed Notification Clicked event for " + bundle.toString() + ", dropping duplicate.");
            } else {
                org.json.b bVar = new org.json.b();
                org.json.b bVar2 = new org.json.b();
                try {
                    for (String next : bundle.keySet()) {
                        if (next.startsWith("wzrk_")) {
                            bVar2.put(next, bundle.get(next));
                        }
                    }
                    bVar.put("evtName", (Object) "Notification Clicked");
                    bVar.put("evtData", (Object) bVar2);
                    this.f10121c.e(this.f10124f, bVar, 4);
                    this.f10126h.c0(v4.a.e(bundle));
                } catch (Throwable unused2) {
                }
                if (this.f10122d.l() != null) {
                    this.f10122d.l().a(x.c(bundle));
                } else {
                    p.a("CTPushNotificationListener is not set");
                }
            }
        }
    }

    public void H(Bundle bundle) {
        String str;
        if (bundle == null || bundle.isEmpty() || bundle.get("wzrk_pn") == null) {
            p n10 = this.f10123e.n();
            String e10 = this.f10123e.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Push notification: ");
            if (bundle == null) {
                str = "NULL";
            } else {
                str = bundle.toString();
            }
            sb2.append(str);
            sb2.append(" not from CleverTap - will not process Notification Viewed event.");
            n10.f(e10, sb2.toString());
        } else if (!bundle.containsKey("wzrk_id") || bundle.getString("wzrk_id") == null) {
            p n11 = this.f10123e.n();
            String e11 = this.f10123e.e();
            n11.f(e11, "Push notification ID Tag is null, not processing Notification Viewed event for:  " + bundle.toString());
        } else if (v(bundle, this.f10133o, 2000)) {
            p n12 = this.f10123e.n();
            String e12 = this.f10123e.e();
            n12.f(e12, "Already processed Notification Viewed event for " + bundle.toString() + ", dropping duplicate.");
        } else {
            p n13 = this.f10123e.n();
            n13.e("Recording Notification Viewed event for notification:  " + bundle.toString());
            org.json.b bVar = new org.json.b();
            try {
                org.json.b e13 = v4.a.e(bundle);
                bVar.put("evtName", (Object) "Notification Viewed");
                bVar.put("evtData", (Object) e13);
            } catch (Throwable unused) {
            }
            this.f10126h.V(bundle.getString("wzrk_pid"));
            this.f10121c.e(this.f10124f, bVar, 6);
        }
    }

    public void I(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            com.clevertap.android.sdk.task.a.a(this.f10123e).c().f("profilePush", new d(map));
        }
    }

    /* access modifiers changed from: package-private */
    public void J(org.json.b bVar) {
        try {
            org.json.b bVar2 = new org.json.b();
            if (bVar != null && bVar.length() > 0) {
                Iterator<String> keys = bVar.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        bVar2.put(next, (Object) bVar.getString(next));
                    } catch (ClassCastException unused) {
                    }
                }
            }
            this.f10121c.e(this.f10124f, bVar2, 1);
        } catch (Throwable unused2) {
        }
    }

    public void K(String str) {
        com.clevertap.android.sdk.task.a.a(this.f10123e).c().f("removeValueForKey", new e(str));
    }

    public void L(org.json.b bVar) {
        this.f10121c.e(this.f10124f, bVar, 5);
    }

    public void M(org.json.b bVar) {
        this.f10121c.e(this.f10124f, bVar, 7);
    }

    public void N(org.json.b bVar) {
        this.f10121c.e(this.f10124f, bVar, 2);
    }

    public void a() {
        if (!this.f10123e.p()) {
            org.json.b bVar = new org.json.b();
            org.json.b bVar2 = new org.json.b();
            try {
                bVar2.put("t", 1);
                bVar.put("evtName", (Object) "wzrk_fetch");
                bVar.put("evtData", (Object) bVar2);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            M(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        w4.b b10 = w4.c.b(512, 1, str);
        this.f10129k.b(b10);
        this.f10123e.n().f(this.f10123e.e(), b10.b());
    }

    public void u(String str, ArrayList<String> arrayList) {
        com.clevertap.android.sdk.task.a.a(this.f10123e).c().f("addMultiValuesForKey", new a(str, arrayList));
    }

    public void w() {
        this.f10126h.K(false);
        y();
    }

    public void y() {
        if (this.f10123e.u()) {
            this.f10126h.K(true);
            this.f10123e.n().f(this.f10123e.e(), "App Launched Events disabled in the Android Manifest file");
        } else if (this.f10126h.y()) {
            this.f10123e.n().t(this.f10123e.e(), "App Launched has already been triggered. Will not trigger it ");
        } else {
            this.f10123e.n().t(this.f10123e.e(), "Firing App Launched event");
            this.f10126h.K(true);
            org.json.b bVar = new org.json.b();
            try {
                bVar.put("evtName", (Object) "App Launched");
                bVar.put("evtData", (Object) this.f10127i.o());
            } catch (Throwable unused) {
            }
            this.f10121c.e(this.f10124f, bVar, 4);
        }
    }

    /* access modifiers changed from: package-private */
    public void z(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        String str;
        int i10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        String str2;
        Object obj;
        String obj2;
        HashMap<String, Object> hashMap2 = hashMap;
        if (hashMap2 == null || arrayList == null) {
            this.f10123e.n().f(this.f10123e.e(), "Invalid Charged event: details and or items is null");
            return;
        }
        if (arrayList.size() > 50) {
            w4.b a10 = w4.c.a(522);
            this.f10123e.n().f(this.f10123e.e(), a10.b());
            this.f10129k.b(a10);
        }
        org.json.b bVar = new org.json.b();
        org.json.b bVar2 = new org.json.b();
        try {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                str = "";
                i10 = 2;
                z10 = true;
                z11 = false;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                obj = hashMap2.get(next);
                w4.b e10 = this.f10130l.e(next);
                obj2 = e10.c().toString();
                if (e10.a() != 0) {
                    bVar2.put("wzrk_error", (Object) v4.a.c(e10));
                }
                w4.b f10 = this.f10130l.f(obj, Validator.ValidationContext.Event);
                Object c10 = f10.c();
                if (f10.a() != 0) {
                    bVar2.put("wzrk_error", (Object) v4.a.c(f10));
                }
                bVar.put(obj2, c10);
            }
            org.json.a aVar = new org.json.a();
            Iterator<HashMap<String, Object>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                HashMap next2 = it2.next();
                org.json.b bVar3 = new org.json.b();
                for (String str3 : next2.keySet()) {
                    Object obj3 = next2.get(str3);
                    w4.b e11 = this.f10130l.e(str3);
                    String obj4 = e11.c().toString();
                    if (e11.a() != 0) {
                        bVar2.put("wzrk_error", (Object) v4.a.c(e11));
                    }
                    try {
                        w4.b f11 = this.f10130l.f(obj3, Validator.ValidationContext.Event);
                        Object c11 = f11.c();
                        if (f11.a() != 0) {
                            bVar2.put("wzrk_error", (Object) v4.a.c(f11));
                        }
                        bVar3.put(obj4, c11);
                        z13 = true;
                        z12 = false;
                    } catch (IllegalArgumentException unused) {
                        String[] strArr = new String[i10];
                        strArr[0] = obj4;
                        if (obj3 != null) {
                            str2 = obj3.toString();
                        } else {
                            str2 = str;
                        }
                        strArr[1] = str2;
                        w4.b b10 = w4.c.b(511, 15, strArr);
                        this.f10123e.n().f(this.f10123e.e(), b10.b());
                        this.f10129k.b(b10);
                        z13 = true;
                        z12 = false;
                        i10 = 2;
                    }
                }
                aVar.E(bVar3);
                z10 = z13;
                z11 = z12;
                i10 = 2;
            }
            bVar.put("Items", (Object) aVar);
            bVar2.put("evtName", (Object) "Charged");
            bVar2.put("evtData", (Object) bVar);
            this.f10121c.e(this.f10124f, bVar2, 4);
        } catch (IllegalArgumentException unused2) {
            String[] strArr2 = new String[3];
            strArr2[0] = "Charged";
            strArr2[1] = obj2;
            if (obj != null) {
                str = obj.toString();
            }
            strArr2[2] = str;
            w4.b b11 = w4.c.b(511, 7, strArr2);
            this.f10129k.b(b11);
            this.f10123e.n().f(this.f10123e.e(), b11.b());
        } catch (Throwable unused3) {
        }
    }
}
