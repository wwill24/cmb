package l4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.n;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.r;
import com.coffeemeetsbagel.models.NetworkProfile;
import i4.m;
import i4.x;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import p4.g;

public class d extends a implements m {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f16006a = null;

    /* renamed from: b  reason: collision with root package name */
    private final com.clevertap.android.sdk.db.a f16007b;

    /* renamed from: c  reason: collision with root package name */
    private final j f16008c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CleverTapInstanceConfig f16009d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f16010e;

    /* renamed from: f  reason: collision with root package name */
    private final i4.e f16011f;

    /* renamed from: g  reason: collision with root package name */
    private final l f16012g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final c f16013h;

    /* renamed from: i  reason: collision with root package name */
    private final n f16014i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final p f16015j;

    /* renamed from: k  reason: collision with root package name */
    private g f16016k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final u4.a f16017l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final q4.a f16018m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final r f16019n;

    /* renamed from: o  reason: collision with root package name */
    private final w4.d f16020o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f16021p = null;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventGroup f16022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f16023b;

        a(EventGroup eventGroup, Context context) {
            this.f16022a = eventGroup;
            this.f16023b = context;
        }

        /* renamed from: a */
        public Void call() {
            if (this.f16022a == EventGroup.PUSH_NOTIFICATION_VIEWED) {
                d.this.f16015j.t(d.this.f16009d.e(), "Pushing Notification Viewed event onto queue flush sync");
            } else {
                d.this.f16015j.t(d.this.f16009d.e(), "Pushing event onto queue flush sync");
            }
            d.this.b(this.f16023b, this.f16022a);
            return null;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EventGroup f16026b;

        b(Context context, EventGroup eventGroup) {
            this.f16025a = context;
            this.f16026b = eventGroup;
        }

        public void run() {
            d.this.f16018m.a(this.f16025a, this.f16026b);
        }
    }

    class c implements Callable<Void> {
        c() {
        }

        /* renamed from: a */
        public Void call() {
            try {
                d.this.f16009d.n().t(d.this.f16009d.e(), "Queuing daily events");
                d.this.c((org.json.b) null, false);
            } catch (Throwable th2) {
                d.this.f16009d.n().u(d.this.f16009d.e(), "Daily profile sync failed", th2);
            }
            return null;
        }
    }

    /* renamed from: l4.d$d  reason: collision with other inner class name */
    class C0168d implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ org.json.b f16029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16030b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f16031c;

        /* renamed from: l4.d$d$a */
        class a implements Runnable {

            /* renamed from: l4.d$d$a$a  reason: collision with other inner class name */
            class C0169a implements Callable<Void> {
                C0169a() {
                }

                /* renamed from: a */
                public Void call() {
                    d.this.f16019n.d(C0168d.this.f16031c);
                    d.this.d();
                    C0168d dVar = C0168d.this;
                    d.this.l(dVar.f16031c, dVar.f16029a, dVar.f16030b);
                    return null;
                }
            }

            a() {
            }

            public void run() {
                com.clevertap.android.sdk.task.a.a(d.this.f16009d).c().f("queueEventWithDelay", new C0169a());
            }
        }

        C0168d(org.json.b bVar, int i10, Context context) {
            this.f16029a = bVar;
            this.f16030b = i10;
            this.f16031c = context;
        }

        /* renamed from: a */
        public Void call() {
            if (d.this.f16013h.c(this.f16029a, this.f16030b)) {
                return null;
            }
            if (d.this.f16013h.b(this.f16029a, this.f16030b)) {
                p n10 = d.this.f16009d.n();
                String e10 = d.this.f16009d.e();
                n10.f(e10, "App Launched not yet processed, re-queuing event " + this.f16029a + "after 2s");
                d.this.f16017l.postDelayed(new a(), 2000);
            } else {
                int i10 = this.f16030b;
                if (i10 == 7) {
                    d.this.l(this.f16031c, this.f16029a, i10);
                } else {
                    d.this.f16019n.d(this.f16031c);
                    d.this.d();
                    d.this.l(this.f16031c, this.f16029a, this.f16030b);
                }
            }
            return null;
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16035a;

        e(Context context) {
            this.f16035a = context;
        }

        public void run() {
            d.this.o(this.f16035a, EventGroup.REGULAR);
            d.this.o(this.f16035a, EventGroup.PUSH_NOTIFICATION_VIEWED);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16037a;

        f(Context context) {
            this.f16037a = context;
        }

        public void run() {
            d.this.f16009d.n().t(d.this.f16009d.e(), "Pushing Notification Viewed event onto queue flush async");
            d.this.o(this.f16037a, EventGroup.PUSH_NOTIFICATION_VIEWED);
        }
    }

    public d(com.clevertap.android.sdk.db.a aVar, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, c cVar, r rVar, i4.b bVar, u4.a aVar2, l lVar, w4.d dVar, q4.b bVar2, j jVar, i4.e eVar, n nVar) {
        this.f16007b = aVar;
        this.f16010e = context;
        this.f16009d = cleverTapInstanceConfig;
        this.f16013h = cVar;
        this.f16019n = rVar;
        this.f16017l = aVar2;
        this.f16012g = lVar;
        this.f16020o = dVar;
        this.f16018m = bVar2;
        this.f16014i = nVar;
        this.f16015j = cleverTapInstanceConfig.n();
        this.f16008c = jVar;
        this.f16011f = eVar;
        bVar.q(this);
    }

    private void m(org.json.b bVar, Context context) {
        try {
            bVar.put("mc", x.m());
        } catch (Throwable unused) {
        }
        try {
            bVar.put("nt", (Object) x.k(context));
        } catch (Throwable unused2) {
        }
    }

    private void n(Context context, org.json.b bVar) {
        try {
            if ("event".equals(bVar.getString("type")) && "App Launched".equals(bVar.getString("evtName"))) {
                bVar.put("pai", (Object) context.getPackageName());
            }
        } catch (Throwable unused) {
        }
    }

    private String p() {
        return this.f16012g.x();
    }

    private void u(Context context) {
        if (this.f16021p == null) {
            this.f16021p = new f(context);
        }
        this.f16017l.removeCallbacks(this.f16021p);
        this.f16017l.post(this.f16021p);
    }

    private void x(Context context, org.json.b bVar, int i10) {
        if (i10 == 4) {
            this.f16014i.B(context, bVar, i10);
        }
    }

    public void a(Context context) {
        v(context);
    }

    public void b(Context context, EventGroup eventGroup) {
        if (!q4.b.x(context)) {
            this.f16015j.t(this.f16009d.e(), "Network connectivity unavailable. Will retry later");
        } else if (this.f16008c.F()) {
            this.f16015j.f(this.f16009d.e(), "CleverTap Instance has been set to offline, won't send events queue");
        } else if (this.f16018m.d(eventGroup)) {
            this.f16018m.c(eventGroup, new b(context, eventGroup));
        } else {
            this.f16015j.t(this.f16009d.e(), "Pushing Notification Viewed event onto queue DB flush");
            this.f16018m.a(context, eventGroup);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5 = r9.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r8.f16009d.n().t(r8.f16009d.e(), "FATAL: Creating basic profile update event failed!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00ae */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(org.json.b r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = r8.p()     // Catch:{ all -> 0x00c0 }
            org.json.b r1 = new org.json.b     // Catch:{ all -> 0x00c0 }
            r1.<init>()     // Catch:{ all -> 0x00c0 }
            if (r9 == 0) goto L_0x0068
            int r2 = r9.length()     // Catch:{ all -> 0x00c0 }
            if (r2 <= 0) goto L_0x0068
            java.util.Iterator r2 = r9.keys()     // Catch:{ all -> 0x00c0 }
            android.content.Context r3 = r8.f16010e     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r8.f16009d     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.l r5 = r8.f16012g     // Catch:{ all -> 0x00c0 }
            w4.d r6 = r8.f16020o     // Catch:{ all -> 0x00c0 }
            p4.b r3 = p4.c.a(r3, r4, r5, r6)     // Catch:{ all -> 0x00c0 }
            p4.g r4 = new p4.g     // Catch:{ all -> 0x00c0 }
            android.content.Context r5 = r8.f16010e     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r8.f16009d     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.l r7 = r8.f16012g     // Catch:{ all -> 0x00c0 }
            r4.<init>(r5, r6, r7)     // Catch:{ all -> 0x00c0 }
            r8.w(r4)     // Catch:{ all -> 0x00c0 }
        L_0x002f:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00c0 }
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00c0 }
            r5 = 0
            org.json.b r5 = r9.getJSONObject(r4)     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            java.lang.Object r5 = r9.get(r4)     // Catch:{ JSONException -> 0x0045 }
        L_0x0045:
            if (r5 == 0) goto L_0x002f
            r1.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x00c0 }
            boolean r6 = r3.a(r4)     // Catch:{ all -> 0x00c0 }
            if (r6 == 0) goto L_0x005a
            if (r10 == 0) goto L_0x005a
            p4.g r5 = r8.q()     // Catch:{ all -> 0x002f }
            r5.j(r0, r4)     // Catch:{ all -> 0x002f }
            goto L_0x002f
        L_0x005a:
            if (r6 == 0) goto L_0x002f
            p4.g r6 = r8.q()     // Catch:{ all -> 0x002f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x002f }
            r6.a(r0, r4, r5)     // Catch:{ all -> 0x002f }
            goto L_0x002f
        L_0x0068:
            com.clevertap.android.sdk.l r9 = r8.f16012g     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r9 = r9.r()     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x007d
            boolean r0 = r9.equals(r10)     // Catch:{ JSONException -> 0x00ae }
            if (r0 != 0) goto L_0x007d
            java.lang.String r0 = "Carrier"
            r1.put((java.lang.String) r0, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x00ae }
        L_0x007d:
            com.clevertap.android.sdk.l r9 = r8.f16012g     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r9 = r9.u()     // Catch:{ JSONException -> 0x00ae }
            if (r9 == 0) goto L_0x0090
            boolean r10 = r9.equals(r10)     // Catch:{ JSONException -> 0x00ae }
            if (r10 != 0) goto L_0x0090
            java.lang.String r10 = "cc"
            r1.put((java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x00ae }
        L_0x0090:
            java.lang.String r9 = "tz"
            java.util.TimeZone r10 = java.util.TimeZone.getDefault()     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r10 = r10.getID()     // Catch:{ JSONException -> 0x00ae }
            r1.put((java.lang.String) r9, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00ae }
            org.json.b r9 = new org.json.b     // Catch:{ JSONException -> 0x00ae }
            r9.<init>()     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r10 = "profile"
            r9.put((java.lang.String) r10, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00ae }
            android.content.Context r10 = r8.f16010e     // Catch:{ JSONException -> 0x00ae }
            r0 = 3
            r8.e(r10, r9, r0)     // Catch:{ JSONException -> 0x00ae }
            goto L_0x00d2
        L_0x00ae:
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r8.f16009d     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.p r9 = r9.n()     // Catch:{ all -> 0x00c0 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = r8.f16009d     // Catch:{ all -> 0x00c0 }
            java.lang.String r10 = r10.e()     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "FATAL: Creating basic profile update event failed!"
            r9.t(r10, r0)     // Catch:{ all -> 0x00c0 }
            goto L_0x00d2
        L_0x00c0:
            r9 = move-exception
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = r8.f16009d
            com.clevertap.android.sdk.p r10 = r10.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r8.f16009d
            java.lang.String r0 = r0.e()
            java.lang.String r1 = "Basic profile sync"
            r10.u(r0, r1, r9)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.d.c(org.json.b, boolean):void");
    }

    public void d() {
        if (!this.f16008c.v()) {
            com.clevertap.android.sdk.task.a.a(this.f16009d).c().f("CleverTapAPI#pushInitialEventsAsync", new c());
        }
    }

    public Future<?> e(Context context, org.json.b bVar, int i10) {
        return com.clevertap.android.sdk.task.a.a(this.f16009d).c().l("queueEvent", new C0168d(bVar, i10, context));
    }

    public void l(Context context, org.json.b bVar, int i10) {
        if (i10 == 6) {
            this.f16009d.n().t(this.f16009d.e(), "Pushing Notification Viewed event onto separate queue");
            t(context, bVar);
            return;
        }
        s(context, bVar, i10);
    }

    public void o(Context context, EventGroup eventGroup) {
        com.clevertap.android.sdk.task.a.a(this.f16009d).c().f("CommsManager#flushQueueAsync", new a(eventGroup, context));
    }

    public g q() {
        return this.f16016k;
    }

    public int r() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public void s(Context context, org.json.b bVar, int i10) {
        String str;
        synchronized (this.f16011f.a()) {
            try {
                if (j.e() == 0) {
                    j.H(1);
                }
                if (i10 == 1) {
                    str = DataLayout.ELEMENT;
                } else if (i10 == 2) {
                    str = Ping.ELEMENT;
                    m(bVar, context);
                    if (bVar.has("bk")) {
                        this.f16008c.L(true);
                        bVar.remove("bk");
                    }
                    if (this.f16008c.E()) {
                        bVar.put("gf", true);
                        this.f16008c.X(false);
                        bVar.put("gfSDKVersion", this.f16008c.l());
                        this.f16008c.S(0);
                    }
                } else {
                    str = i10 == 3 ? "profile" : i10 == 5 ? "data" : "event";
                }
                String s10 = this.f16008c.s();
                if (s10 != null) {
                    bVar.put("n", (Object) s10);
                }
                bVar.put("s", this.f16008c.k());
                bVar.put("pg", j.e());
                bVar.put("type", (Object) str);
                bVar.put("ep", r());
                bVar.put(NetworkProfile.FEMALE, this.f16008c.C());
                bVar.put("lsl", this.f16008c.o());
                n(context, bVar);
                w4.b a10 = this.f16020o.a();
                if (a10 != null) {
                    bVar.put("wzrk_error", (Object) v4.a.c(a10));
                }
                this.f16014i.J(bVar);
                this.f16007b.d(context, bVar, i10);
                x(context, bVar, i10);
                v(context);
            } catch (Throwable th2) {
                p n10 = this.f16009d.n();
                String e10 = this.f16009d.e();
                n10.u(e10, "Failed to queue event: " + bVar.toString(), th2);
            }
        }
    }

    public void t(Context context, org.json.b bVar) {
        synchronized (this.f16011f.a()) {
            try {
                bVar.put("s", this.f16008c.k());
                bVar.put("type", (Object) "event");
                bVar.put("ep", r());
                w4.b a10 = this.f16020o.a();
                if (a10 != null) {
                    bVar.put("wzrk_error", (Object) v4.a.c(a10));
                }
                this.f16009d.n().t(this.f16009d.e(), "Pushing Notification Viewed event onto DB");
                this.f16007b.e(context, bVar);
                this.f16009d.n().t(this.f16009d.e(), "Pushing Notification Viewed event onto queue flush");
                u(context);
            } catch (Throwable th2) {
                p n10 = this.f16009d.n();
                String e10 = this.f16009d.e();
                n10.u(e10, "Failed to queue notification viewed event: " + bVar.toString(), th2);
            }
        }
    }

    public void v(Context context) {
        if (this.f16006a == null) {
            this.f16006a = new e(context);
        }
        this.f16017l.removeCallbacks(this.f16006a);
        this.f16017l.postDelayed(this.f16006a, (long) this.f16018m.b());
        this.f16015j.t(this.f16009d.e(), "Scheduling delayed queue flush on main event loop");
    }

    public void w(g gVar) {
        this.f16016k = gVar;
    }
}
