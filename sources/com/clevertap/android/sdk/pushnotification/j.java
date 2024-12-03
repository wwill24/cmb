package com.clevertap.android.sdk.pushnotification;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService;
import com.clevertap.android.sdk.s;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.leanplum.internal.Constants;
import i4.i;
import i4.x;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.json.JSONException;

public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<PushConstants.PushType> f10728a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<PushConstants.PushType> f10729b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<b> f10730c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<PushConstants.PushType> f10731d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.clevertap.android.sdk.c f10732e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final com.clevertap.android.sdk.db.a f10733f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final CleverTapInstanceConfig f10734g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f10735h;

    /* renamed from: i  reason: collision with root package name */
    private e f10736i = new d();

    /* renamed from: j  reason: collision with root package name */
    private final w4.d f10737j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f10738k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private final Object f10739l = new Object();

    /* renamed from: m  reason: collision with root package name */
    private CleverTapAPI.h f10740m;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10741a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PushConstants.PushType f10742b;

        a(String str, PushConstants.PushType pushType) {
            this.f10741a = str;
            this.f10742b = pushType;
        }

        /* renamed from: a */
        public Void call() {
            if (j.this.n(this.f10741a, this.f10742b)) {
                return null;
            }
            String e10 = this.f10742b.e();
            if (TextUtils.isEmpty(e10)) {
                return null;
            }
            s.q(j.this.f10735h, s.s(j.this.f10734g, e10), this.f10741a);
            CleverTapInstanceConfig g10 = j.this.f10734g;
            g10.A("PushProvider", this.f10742b + "Cached New Token successfully " + this.f10741a);
            return null;
        }
    }

    class b implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f10744a;

        b(Bundle bundle) {
            this.f10744a = bundle;
        }

        /* renamed from: a */
        public Void call() {
            String string = this.f10744a.getString("nm");
            if (string == null) {
                string = "";
            }
            if (string.isEmpty()) {
                j.this.f10734g.n().t(j.this.f10734g.e(), "Push notification message is empty, not rendering");
                j.this.f10733f.c(j.this.f10735h).L();
                String string2 = this.f10744a.getString("pf", "");
                if (TextUtils.isEmpty(string2)) {
                    return null;
                }
                j jVar = j.this;
                jVar.X(jVar.f10735h, Integer.parseInt(string2));
                return null;
            }
            String string3 = this.f10744a.getString("wzrk_pid");
            Bundle bundle = this.f10744a;
            String string4 = bundle.getString("wzrk_ttl", ((System.currentTimeMillis() + 345600000) / 1000) + "");
            long parseLong = Long.parseLong(string4);
            DBAdapter c10 = j.this.f10733f.c(j.this.f10735h);
            p n10 = j.this.f10734g.n();
            n10.s("Storing Push Notification..." + string3 + " - with ttl - " + string4);
            c10.K(string3, parseLong);
            return null;
        }
    }

    class c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10746a;

        c(Context context) {
            this.f10746a = context;
        }

        /* renamed from: a */
        public Void call() {
            j.this.f10734g.n().s("Creating job");
            j.this.p(this.f10746a);
            return null;
        }
    }

    class d implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10748a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JobParameters f10749b;

        d(Context context, JobParameters jobParameters) {
            this.f10748a = context;
            this.f10749b = jobParameters;
        }

        /* renamed from: a */
        public Void call() {
            if (!j.this.G()) {
                p.p(j.this.f10734g.e(), "Token is not present, not running the Job");
                return null;
            }
            Calendar instance = Calendar.getInstance();
            int i10 = instance.get(11);
            int i11 = instance.get(12);
            j jVar = j.this;
            Date j10 = jVar.L(i10 + CertificateUtil.DELIMITER + i11);
            if (j.this.H(j.this.L("22:00"), j.this.L("06:00"), j10)) {
                p.p(j.this.f10734g.e(), "Job Service won't run in default DND hours");
                return null;
            }
            long E = j.this.f10733f.c(this.f10748a).E();
            if (E == 0 || E > System.currentTimeMillis() - 86400000) {
                try {
                    org.json.b bVar = new org.json.b();
                    bVar.put("bk", 1);
                    j.this.f10732e.N(bVar);
                    int i12 = 134217728;
                    if (Build.VERSION.SDK_INT >= 31) {
                        i12 = 167772160;
                    }
                    if (this.f10749b == null) {
                        int m10 = j.this.B(this.f10748a);
                        AlarmManager alarmManager = (AlarmManager) this.f10748a.getSystemService("alarm");
                        Intent intent = new Intent("com.clevertap.BG_EVENT");
                        intent.setPackage(this.f10748a.getPackageName());
                        PendingIntent service = PendingIntent.getService(this.f10748a, j.this.f10734g.e().hashCode(), intent, i12);
                        if (alarmManager != null) {
                            alarmManager.cancel(service);
                        }
                        Intent intent2 = new Intent("com.clevertap.BG_EVENT");
                        intent2.setPackage(this.f10748a.getPackageName());
                        PendingIntent service2 = PendingIntent.getService(this.f10748a, j.this.f10734g.e().hashCode(), intent2, i12);
                        if (!(alarmManager == null || m10 == -1)) {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            long j11 = ((long) m10) * DateUtils.MILLIS_IN_MINUTE;
                            alarmManager.setInexactRepeating(2, elapsedRealtime + j11, j11, service2);
                        }
                    }
                } catch (JSONException unused) {
                    p.o("Unable to raise background Ping event");
                }
            }
            return null;
        }
    }

    class e implements Callable<Void> {
        e() {
        }

        /* renamed from: a */
        public Void call() {
            j jVar = j.this;
            jVar.p(jVar.f10735h);
            return null;
        }
    }

    class f implements Callable<Void> {
        f() {
        }

        /* renamed from: a */
        public Void call() {
            j.this.P();
            j.this.Q();
            return null;
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10753a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType[] r0 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10753a = r0
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType r1 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.FCM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10753a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType r1 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.XPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10753a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType r1 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.HPS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10753a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType r1 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.BPS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10753a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.clevertap.android.sdk.pushnotification.PushConstants$PushType r1 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.ADM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.j.g.<clinit>():void");
        }
    }

    private j(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, com.clevertap.android.sdk.db.a aVar, w4.d dVar, com.clevertap.android.sdk.c cVar) {
        this.f10735h = context;
        this.f10734g = cleverTapInstanceConfig;
        this.f10733f = aVar;
        this.f10737j = dVar;
        this.f10732e = cVar;
        F();
    }

    private static JobInfo A(int i10, JobScheduler jobScheduler) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            if (next.getId() == i10) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int B(Context context) {
        return s.c(context, "pf", 240);
    }

    private void E() {
        v();
        t(q());
        u();
    }

    private void F() {
        if (this.f10734g.q() && !this.f10734g.p()) {
            com.clevertap.android.sdk.task.a.a(this.f10734g).c().f("createOrResetJobScheduler", new e());
        }
    }

    /* access modifiers changed from: private */
    public boolean H(Date date, Date date2, Date date3) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date3);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTime(date2);
        if (date2.compareTo(date) < 0) {
            if (instance2.compareTo(instance3) < 0) {
                instance2.add(5, 1);
            }
            instance3.add(5, 1);
        }
        if (instance2.compareTo(instance) < 0 || instance2.compareTo(instance3) >= 0) {
            return false;
        }
        return true;
    }

    private boolean I(b bVar) {
        if (40606 < bVar.minSDKSupportVersionCode()) {
            this.f10734g.A("PushProvider", "Provider: %s version %s does not match the SDK version %s. Make sure all CleverTap dependencies are the same version.");
            return false;
        }
        int i10 = g.f10753a[bVar.getPushType().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            if (bVar.getPlatform() != 1) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.A("PushProvider", "Invalid Provider: " + bVar.getClass() + " delivery is only available for Android platforms." + bVar.getPushType());
                return false;
            }
        } else if (i10 == 5 && bVar.getPlatform() != 2) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10734g;
            cleverTapInstanceConfig2.A("PushProvider", "Invalid Provider: " + bVar.getClass() + " ADM delivery is only available for Amazon platforms." + bVar.getPushType());
            return false;
        }
        return true;
    }

    @NonNull
    public static j J(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, com.clevertap.android.sdk.db.a aVar, w4.d dVar, com.clevertap.android.sdk.c cVar, i iVar) {
        j jVar = new j(context, cleverTapInstanceConfig, aVar, dVar, cVar);
        jVar.E();
        iVar.q(jVar);
        return jVar;
    }

    /* access modifiers changed from: private */
    public Date L(String str) {
        try {
            return new SimpleDateFormat("HH:mm", Locale.US).parse(str);
        } catch (ParseException unused) {
            return new Date(0);
        }
    }

    private void N(String str, boolean z10, PushConstants.PushType pushType) {
        String str2;
        if (pushType != null) {
            if (TextUtils.isEmpty(str)) {
                str = z(pushType);
            }
            if (!TextUtils.isEmpty(str)) {
                synchronized (this.f10738k) {
                    org.json.b bVar = new org.json.b();
                    org.json.b bVar2 = new org.json.b();
                    if (z10) {
                        str2 = "register";
                    } else {
                        str2 = IoTUnregister.ELEMENT;
                    }
                    try {
                        bVar2.put("action", (Object) str2);
                        bVar2.put("id", (Object) str);
                        bVar2.put("type", (Object) pushType.h());
                        if (pushType == PushConstants.PushType.XPS) {
                            this.f10734g.n().s("PushProviders: pushDeviceTokenEvent requesting device region");
                            bVar2.put(Constants.Keys.REGION, (Object) pushType.d());
                        }
                        bVar.put("data", (Object) bVar2);
                        p n10 = this.f10734g.n();
                        String e10 = this.f10734g.e();
                        n10.t(e10, pushType + str2 + " device token " + str);
                        this.f10732e.L(bVar);
                    } catch (Throwable th2) {
                        p n11 = this.f10734g.n();
                        String e11 = this.f10734g.e();
                        n11.u(e11, pushType + str2 + " device token failed", th2);
                    }
                }
            }
        }
    }

    private void O() {
        com.clevertap.android.sdk.task.a.a(this.f10734g).a().f("PushProviders#refreshAllTokens", new f());
    }

    /* access modifiers changed from: private */
    public void P() {
        Iterator<b> it = this.f10730c.iterator();
        while (it.hasNext()) {
            b next = it.next();
            try {
                next.requestToken();
            } catch (Throwable th2) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.B("PushProvider", "Token Refresh error " + next, th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        Iterator<PushConstants.PushType> it = this.f10731d.iterator();
        while (it.hasNext()) {
            PushConstants.PushType next = it.next();
            try {
                N(z(next), true, next);
            } catch (Throwable th2) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.B("PushProvider", "Token Refresh error " + next, th2);
            }
        }
    }

    private void R(String str, PushConstants.PushType pushType) {
        N(str, true, pushType);
        o(str, pushType);
    }

    private void T(Context context, int i10) {
        s.n(context, "pf", i10);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:48|49|50|51) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x010f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void V(android.content.Context r17, android.os.Bundle r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = r18
            r1 = r19
            java.lang.String r2 = " to notificationId int: "
            java.lang.String r3 = "Converting collapse_key: "
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r7.getSystemService(r4)
            r9 = r4
            android.app.NotificationManager r9 = (android.app.NotificationManager) r9
            if (r9 != 0) goto L_0x0029
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r0.f10734g
            com.clevertap.android.sdk.p r1 = r1.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            java.lang.String r2 = r2.e()
            java.lang.String r3 = "Unable to render notification, Notification Manager is null."
            r1.f(r2, r3)
            return
        L_0x0029:
            java.lang.String r4 = "wzrk_cid"
            java.lang.String r10 = ""
            java.lang.String r4 = r8.getString(r4, r10)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            r11 = 1
            r12 = 0
            if (r5 < r6) goto L_0x003b
            r13 = r11
            goto L_0x003c
        L_0x003b:
            r13 = r12
        L_0x003c:
            r14 = 512(0x200, float:7.175E-43)
            if (r5 < r6) goto L_0x007d
            boolean r5 = r4.isEmpty()
            r6 = -1
            if (r5 == 0) goto L_0x004e
            r5 = 8
            java.lang.String r15 = r18.toString()
            goto L_0x005a
        L_0x004e:
            android.app.NotificationChannel r5 = r9.getNotificationChannel(r4)
            if (r5 != 0) goto L_0x0058
            r5 = 9
            r15 = r4
            goto L_0x005a
        L_0x0058:
            r5 = r6
            r15 = r10
        L_0x005a:
            if (r5 == r6) goto L_0x007d
            java.lang.String[] r1 = new java.lang.String[r11]
            r1[r12] = r15
            w4.b r1 = w4.c.b(r14, r5, r1)
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            com.clevertap.android.sdk.p r2 = r2.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g
            java.lang.String r3 = r3.e()
            java.lang.String r4 = r1.b()
            r2.f(r3, r4)
            w4.d r2 = r0.f10737j
            r2.b(r1)
            return
        L_0x007d:
            com.clevertap.android.sdk.q r5 = com.clevertap.android.sdk.q.h(r17)     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = r5.j()     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x009e
            android.content.res.Resources r6 = r17.getResources()     // Catch:{ all -> 0x00a4 }
            java.lang.String r15 = "drawable"
            java.lang.String r14 = r17.getPackageName()     // Catch:{ all -> 0x00a4 }
            int r5 = r6.getIdentifier(r5, r15, r14)     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x0098
            goto L_0x00a8
        L_0x0098:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            throw r5     // Catch:{ all -> 0x00a4 }
        L_0x009e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            throw r5     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            int r5 = com.clevertap.android.sdk.l.n(r17)
        L_0x00a8:
            com.clevertap.android.sdk.pushnotification.e r6 = r0.f10736i
            r6.f(r5, r7)
            java.lang.String r5 = "pr"
            java.lang.String r5 = r8.getString(r5)
            if (r5 == 0) goto L_0x00c5
            java.lang.String r6 = "high"
            boolean r6 = r5.equals(r6)
            java.lang.String r14 = "max"
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x00c6
            r6 = 2
            goto L_0x00c6
        L_0x00c5:
            r6 = r12
        L_0x00c6:
            r5 = -1000(0xfffffffffffffc18, float:NaN)
            if (r1 != r5) goto L_0x0168
            com.clevertap.android.sdk.pushnotification.e r14 = r0.f10736i     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.Object r14 = r14.g(r8)     // Catch:{ NumberFormatException -> 0x018d }
            if (r14 == 0) goto L_0x018d
            boolean r15 = r14 instanceof java.lang.Number     // Catch:{ NumberFormatException -> 0x018d }
            if (r15 == 0) goto L_0x00de
            r2 = r14
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ NumberFormatException -> 0x018d }
            int r1 = r2.intValue()     // Catch:{ NumberFormatException -> 0x018d }
            goto L_0x013b
        L_0x00de:
            boolean r15 = r14 instanceof java.lang.String     // Catch:{ NumberFormatException -> 0x018d }
            if (r15 == 0) goto L_0x013b
            java.lang.String r15 = r14.toString()     // Catch:{ NumberFormatException -> 0x010f }
            int r1 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x010f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r15 = r0.f10734g     // Catch:{ NumberFormatException -> 0x010f }
            com.clevertap.android.sdk.p r15 = r15.n()     // Catch:{ NumberFormatException -> 0x010f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r0.f10734g     // Catch:{ NumberFormatException -> 0x010f }
            java.lang.String r12 = r12.e()     // Catch:{ NumberFormatException -> 0x010f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x010f }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x010f }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x010f }
            r11.append(r14)     // Catch:{ NumberFormatException -> 0x010f }
            r11.append(r2)     // Catch:{ NumberFormatException -> 0x010f }
            r11.append(r1)     // Catch:{ NumberFormatException -> 0x010f }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x010f }
            r15.t(r12, r11)     // Catch:{ NumberFormatException -> 0x010f }
            goto L_0x013b
        L_0x010f:
            java.lang.String r11 = r14.toString()     // Catch:{ NumberFormatException -> 0x018d }
            int r1 = r11.hashCode()     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.CleverTapInstanceConfig r11 = r0.f10734g     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.p r11 = r11.n()     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r0.f10734g     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r12 = r12.e()     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x018d }
            r15.<init>()     // Catch:{ NumberFormatException -> 0x018d }
            r15.append(r3)     // Catch:{ NumberFormatException -> 0x018d }
            r15.append(r14)     // Catch:{ NumberFormatException -> 0x018d }
            r15.append(r2)     // Catch:{ NumberFormatException -> 0x018d }
            r15.append(r1)     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r2 = r15.toString()     // Catch:{ NumberFormatException -> 0x018d }
            r11.t(r12, r2)     // Catch:{ NumberFormatException -> 0x018d }
        L_0x013b:
            int r1 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.p r2 = r2.n()     // Catch:{ NumberFormatException -> 0x018d }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r3 = r3.e()     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x018d }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r12 = "Creating the notification id: "
            r11.append(r12)     // Catch:{ NumberFormatException -> 0x018d }
            r11.append(r1)     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r12 = " from collapse_key: "
            r11.append(r12)     // Catch:{ NumberFormatException -> 0x018d }
            r11.append(r14)     // Catch:{ NumberFormatException -> 0x018d }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x018d }
            r2.f(r3, r11)     // Catch:{ NumberFormatException -> 0x018d }
            goto L_0x018d
        L_0x0168:
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            com.clevertap.android.sdk.p r2 = r2.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g
            java.lang.String r3 = r3.e()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Have user provided notificationId: "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r12 = " won't use collapse_key (if any) as basis for notificationId"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r2.f(r3, r11)
        L_0x018d:
            if (r1 != r5) goto L_0x01b7
            double r1 = java.lang.Math.random()
            r11 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r1 * r11
            int r1 = (int) r1
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            com.clevertap.android.sdk.p r2 = r2.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g
            java.lang.String r3 = r3.e()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = "Setting random notificationId: "
            r5.append(r11)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r2.f(r3, r5)
        L_0x01b7:
            r11 = r1
            if (r13 == 0) goto L_0x01e3
            androidx.core.app.p$e r1 = new androidx.core.app.p$e
            r1.<init>(r7, r4)
            java.lang.String r2 = "wzrk_bi"
            r3 = 0
            java.lang.String r2 = r8.getString(r2, r3)
            if (r2 == 0) goto L_0x01d1
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x01d1 }
            if (r2 < 0) goto L_0x01d1
            r1.g(r2)     // Catch:{ all -> 0x01d1 }
        L_0x01d1:
            java.lang.String r2 = "wzrk_bc"
            java.lang.String r2 = r8.getString(r2, r3)
            if (r2 == 0) goto L_0x01e8
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x01e8 }
            if (r2 < 0) goto L_0x01e8
            r1.t(r2)     // Catch:{ all -> 0x01e8 }
            goto L_0x01e8
        L_0x01e3:
            androidx.core.app.p$e r1 = new androidx.core.app.p$e
            r1.<init>(r7)
        L_0x01e8:
            r1.v(r6)
            com.clevertap.android.sdk.pushnotification.e r2 = r0.f10736i
            boolean r3 = r2 instanceof o4.b
            if (r3 == 0) goto L_0x01f9
            o4.b r2 = (o4.b) r2
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g
            androidx.core.app.p$e r1 = r2.a(r7, r8, r1, r3)
        L_0x01f9:
            r4 = r1
            com.clevertap.android.sdk.pushnotification.e r1 = r0.f10736i
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r0.f10734g
            r2 = r18
            r3 = r17
            r6 = r11
            androidx.core.app.p$e r1 = r1.e(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x020a
            return
        L_0x020a:
            android.app.Notification r1 = r1.b()
            r9.notify(r11, r1)
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            com.clevertap.android.sdk.p r2 = r2.n()
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r0.f10734g
            java.lang.String r3 = r3.e()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Rendered notification: "
            r4.append(r5)
            java.lang.String r1 = r1.toString()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.f(r3, r1)
            java.lang.String r1 = "extras_from"
            java.lang.String r1 = r8.getString(r1)
            if (r1 == 0) goto L_0x0245
            java.lang.String r2 = "PTReceiver"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02f4
        L_0x0245:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 345600000(0x14997000, double:1.70749087E-315)
            long r2 = r2 + r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "wzrk_ttl"
            java.lang.String r1 = r8.getString(r2, r1)
            long r2 = java.lang.Long.parseLong(r1)
            java.lang.String r4 = "wzrk_pid"
            java.lang.String r4 = r8.getString(r4)
            com.clevertap.android.sdk.db.a r5 = r0.f10733f
            com.clevertap.android.sdk.db.DBAdapter r5 = r5.c(r7)
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r0.f10734g
            com.clevertap.android.sdk.p r6 = r6.n()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Storing Push Notification..."
            r7.append(r9)
            r7.append(r4)
            java.lang.String r9 = " - with ttl - "
            r7.append(r9)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            r6.s(r1)
            r5.K(r4, r2)
            java.lang.String r1 = "wzrk_rnv"
            java.lang.String r1 = r8.getString(r1, r10)
            java.lang.String r2 = "true"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x02cd
            r1 = 10
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = r18.toString()
            r4 = 0
            r2[r4] = r3
            r3 = 512(0x200, float:7.175E-43)
            w4.b r1 = w4.c.b(r3, r1, r2)
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.f10734g
            com.clevertap.android.sdk.p r2 = r2.n()
            java.lang.String r3 = r1.b()
            r2.e(r3)
            w4.d r2 = r0.f10737j
            r2.b(r1)
            return
        L_0x02cd:
            com.clevertap.android.sdk.c r1 = r0.f10732e
            r1.H(r8)
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r0.f10734g
            com.clevertap.android.sdk.p r1 = r1.n()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Rendered Push Notification... from nh_source = "
            r2.append(r3)
            java.lang.String r3 = "nh_source"
            java.lang.String r4 = "source not available"
            java.lang.String r3 = r8.getString(r3, r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.s(r2)
        L_0x02f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.j.V(android.content.Context, android.os.Bundle, int):void");
    }

    /* access modifiers changed from: private */
    public boolean n(String str, PushConstants.PushType pushType) {
        boolean z10;
        if (TextUtils.isEmpty(str) || pushType == null || !str.equalsIgnoreCase(z(pushType))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (pushType != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
            cleverTapInstanceConfig.A("PushProvider", pushType + "Token Already available value: " + z10);
        }
        return z10;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void p(Context context) {
        boolean z10;
        Context context2 = context;
        int c10 = s.c(context2, "pfjobid", -1);
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        if (Build.VERSION.SDK_INT < 26) {
            if (c10 >= 0) {
                jobScheduler.cancel(c10);
                s.n(context2, "pfjobid", -1);
            }
            this.f10734g.n().f(this.f10734g.e(), "Push Amplification feature is not supported below Oreo");
        } else if (jobScheduler != null) {
            int B = B(context);
            if (c10 < 0 && B < 0) {
                return;
            }
            if (B < 0) {
                jobScheduler.cancel(c10);
                s.n(context2, "pfjobid", -1);
                return;
            }
            ComponentName componentName = new ComponentName(context2, CTBackgroundJobService.class);
            if (c10 >= 0 || B <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            JobInfo A = A(c10, jobScheduler);
            if (!(A == null || A.getIntervalMillis() == ((long) B) * DateUtils.MILLIS_IN_MINUTE)) {
                jobScheduler.cancel(c10);
                s.n(context2, "pfjobid", -1);
                z10 = true;
            }
            if (z10) {
                int hashCode = this.f10734g.e().hashCode();
                JobInfo.Builder builder = new JobInfo.Builder(hashCode, componentName);
                builder.setRequiredNetworkType(1);
                builder.setRequiresCharging(false);
                builder.setPeriodic(((long) B) * DateUtils.MILLIS_IN_MINUTE, 300000);
                JobInfo.Builder unused = builder.setRequiresBatteryNotLow(true);
                if (x.s(context2, "android.permission.RECEIVE_BOOT_COMPLETED")) {
                    builder.setPersisted(true);
                }
                if (jobScheduler.schedule(builder.build()) == 1) {
                    String e10 = this.f10734g.e();
                    p.b(e10, "Job scheduled - " + hashCode);
                    s.n(context2, "pfjobid", hashCode);
                    return;
                }
                String e11 = this.f10734g.e();
                p.b(e11, "Job not scheduled - " + hashCode);
            }
        }
    }

    @NonNull
    private List<b> q() {
        ArrayList arrayList = new ArrayList();
        Iterator<PushConstants.PushType> it = this.f10728a.iterator();
        while (it.hasNext()) {
            b y10 = y(it.next(), true);
            if (y10 != null) {
                arrayList.add(y10);
            }
        }
        Iterator<PushConstants.PushType> it2 = this.f10729b.iterator();
        while (it2.hasNext()) {
            PushConstants.PushType next = it2.next();
            PushConstants.PushType pushType = PushConstants.PushType.XPS;
            if (next == pushType && !TextUtils.isEmpty(z(pushType))) {
                b y11 = y(next, false);
                if (y11 instanceof k) {
                    ((k) y11).a(this.f10735h);
                    CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                    cleverTapInstanceConfig.A("PushProvider", "unregistering existing token for disabled " + next);
                }
            }
        }
        return arrayList;
    }

    private void r(String str, PushConstants.PushType pushType) {
        if (this.f10740m != null) {
            p n10 = this.f10734g.n();
            String e10 = this.f10734g.e();
            n10.f(e10, "Notifying devicePushTokenDidRefresh: " + str);
            this.f10740m.a(str, pushType);
        }
    }

    private void t(List<b> list) {
        if (list.isEmpty()) {
            this.f10734g.A("PushProvider", "No push providers found!. Make sure to install at least one push provider");
            return;
        }
        for (b next : list) {
            if (!I(next)) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.A("PushProvider", "Invalid Provider: " + next.getClass());
            } else if (!next.isSupported()) {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10734g;
                cleverTapInstanceConfig2.A("PushProvider", "Unsupported Provider: " + next.getClass());
            } else if (next.isAvailable()) {
                CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f10734g;
                cleverTapInstanceConfig3.A("PushProvider", "Available Provider: " + next.getClass());
                this.f10730c.add(next);
            } else {
                CleverTapInstanceConfig cleverTapInstanceConfig4 = this.f10734g;
                cleverTapInstanceConfig4.A("PushProvider", "Unavailable Provider: " + next.getClass());
            }
        }
    }

    private void u() {
        this.f10731d.addAll(this.f10728a);
        Iterator<b> it = this.f10730c.iterator();
        while (it.hasNext()) {
            this.f10731d.remove(it.next().getPushType());
        }
    }

    private void v() {
        for (PushConstants.PushType pushType : i.c(this.f10734g.h())) {
            String b10 = pushType.b();
            try {
                Class.forName(b10);
                this.f10728a.add(pushType);
                this.f10734g.A("PushProvider", "SDK Class Available :" + b10);
                if (pushType.c() == 3) {
                    this.f10728a.remove(pushType);
                    this.f10729b.add(pushType);
                    this.f10734g.A("PushProvider", "disabling " + pushType + " due to flag set as PushConstants.NO_DEVICES");
                }
                if (pushType.c() == 2 && !v4.d.e(this.f10735h)) {
                    this.f10728a.remove(pushType);
                    this.f10729b.add(pushType);
                    this.f10734g.A("PushProvider", "disabling " + pushType + " due to flag set as PushConstants.XIAOMI_MIUI_DEVICES");
                }
            } catch (Exception e10) {
                this.f10734g.A("PushProvider", "SDK class Not available " + b10 + " Exception:" + e10.getClass().getName());
            }
        }
    }

    private b y(PushConstants.PushType pushType, boolean z10) {
        b bVar;
        Class<c> cls = c.class;
        String a10 = pushType.a();
        b bVar2 = null;
        try {
            Class<?> cls2 = Class.forName(a10);
            if (z10) {
                bVar = (b) cls2.getConstructor(new Class[]{cls, Context.class, CleverTapInstanceConfig.class}).newInstance(new Object[]{this, this.f10735h, this.f10734g});
            } else {
                bVar = (b) cls2.getConstructor(new Class[]{cls, Context.class, CleverTapInstanceConfig.class, Boolean.class}).newInstance(new Object[]{this, this.f10735h, this.f10734g, Boolean.FALSE});
            }
            bVar2 = bVar;
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
            cleverTapInstanceConfig.A("PushProvider", "Found provider:" + a10);
        } catch (InstantiationException unused) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10734g;
            cleverTapInstanceConfig2.A("PushProvider", "Unable to create provider InstantiationException" + a10);
        } catch (IllegalAccessException unused2) {
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f10734g;
            cleverTapInstanceConfig3.A("PushProvider", "Unable to create provider IllegalAccessException" + a10);
        } catch (ClassNotFoundException unused3) {
            CleverTapInstanceConfig cleverTapInstanceConfig4 = this.f10734g;
            cleverTapInstanceConfig4.A("PushProvider", "Unable to create provider ClassNotFoundException" + a10);
        } catch (Exception e10) {
            CleverTapInstanceConfig cleverTapInstanceConfig5 = this.f10734g;
            cleverTapInstanceConfig5.A("PushProvider", "Unable to create provider " + a10 + " Exception:" + e10.getClass().getName());
        }
        return bVar2;
    }

    @NonNull
    public Object C() {
        return this.f10739l;
    }

    public void D(String str, PushConstants.PushType pushType, boolean z10) {
        if (z10) {
            R(str, pushType);
        } else {
            W(str, pushType);
        }
    }

    public boolean G() {
        Iterator<PushConstants.PushType> it = x().iterator();
        while (it.hasNext()) {
            if (z(it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    public void K() {
        O();
    }

    public void M(Bundle bundle) {
        com.clevertap.android.sdk.task.a.a(this.f10734g).c().f("customHandlePushAmplification", new b(bundle));
    }

    public void S(Context context, JobParameters jobParameters) {
        com.clevertap.android.sdk.task.a.a(this.f10734g).c().f("runningJobService", new d(context, jobParameters));
    }

    public void U(@NonNull e eVar) {
        this.f10736i = eVar;
    }

    public void W(String str, PushConstants.PushType pushType) {
        N(str, false, pushType);
    }

    public void X(Context context, int i10) {
        p n10 = this.f10734g.n();
        n10.s("Ping frequency received - " + i10);
        p n11 = this.f10734g.n();
        n11.s("Stored Ping Frequency - " + B(context));
        if (i10 != B(context)) {
            T(context, i10);
            if (this.f10734g.q() && !this.f10734g.p()) {
                com.clevertap.android.sdk.task.a.a(this.f10734g).c().f("createOrResetJobScheduler", new c(context));
            }
        }
    }

    public void a(String str, PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str)) {
            s(str, pushType);
            r(str, pushType);
        }
    }

    public void b(Context context, Bundle bundle, int i10) {
        if (bundle != null && bundle.get("wzrk_pn") != null) {
            if (this.f10734g.p()) {
                this.f10734g.n().f(this.f10734g.e(), "Instance is set for Analytics only, cannot create notification");
                return;
            }
            try {
                if (bundle.getString("wzrk_pn_s", "").equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                    this.f10732e.H(bundle);
                    return;
                }
                String string = bundle.getString("extras_from");
                if (string == null || !string.equals("PTReceiver")) {
                    p n10 = this.f10734g.n();
                    String e10 = this.f10734g.e();
                    n10.f(e10, "Handling notification: " + bundle);
                    p n11 = this.f10734g.n();
                    String e11 = this.f10734g.e();
                    n11.f(e11, "Handling notification::nh_source = " + bundle.getString("nh_source", "source not available"));
                    if (bundle.getString("wzrk_pid") == null || !this.f10733f.c(context).x(bundle.getString("wzrk_pid"))) {
                        String h10 = this.f10736i.h(bundle);
                        if (h10 == null) {
                            h10 = "";
                        }
                        if (h10.isEmpty()) {
                            this.f10734g.n().t(this.f10734g.e(), "Push notification message is empty, not rendering");
                            this.f10733f.c(context).L();
                            String string2 = bundle.getString("pf", "");
                            if (!TextUtils.isEmpty(string2)) {
                                X(context, Integer.parseInt(string2));
                                return;
                            }
                            return;
                        }
                    } else {
                        this.f10734g.n().f(this.f10734g.e(), "Push Notification already rendered, not showing again");
                        return;
                    }
                }
                if (this.f10736i.c(bundle, context).isEmpty()) {
                    String str = context.getApplicationInfo().name;
                }
                V(context, bundle, i10);
            } catch (Throwable th2) {
                this.f10734g.n().g(this.f10734g.e(), "Couldn't render notification: ", th2);
            }
        }
    }

    public void o(String str, PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str) && pushType != null) {
            try {
                com.clevertap.android.sdk.task.a.a(this.f10734g).a().f("PushProviders#cacheToken", new a(str, pushType));
            } catch (Throwable th2) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.B("PushProvider", pushType + "Unable to cache token " + str, th2);
            }
        }
    }

    public void s(String str, PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str) && pushType != null) {
            int i10 = g.f10753a[pushType.ordinal()];
            if (i10 == 1) {
                D(str, PushConstants.PushType.FCM, true);
            } else if (i10 == 2) {
                D(str, PushConstants.PushType.XPS, true);
            } else if (i10 == 3) {
                D(str, PushConstants.PushType.HPS, true);
            } else if (i10 == 4) {
                D(str, PushConstants.PushType.BPS, true);
            } else if (i10 == 5) {
                D(str, PushConstants.PushType.ADM, true);
            }
        }
    }

    public void w(boolean z10) {
        Iterator<PushConstants.PushType> it = this.f10728a.iterator();
        while (it.hasNext()) {
            N((String) null, z10, it.next());
        }
    }

    @NonNull
    public ArrayList<PushConstants.PushType> x() {
        ArrayList<PushConstants.PushType> arrayList = new ArrayList<>();
        Iterator<b> it = this.f10730c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPushType());
        }
        return arrayList;
    }

    public String z(PushConstants.PushType pushType) {
        if (pushType != null) {
            String e10 = pushType.e();
            if (!TextUtils.isEmpty(e10)) {
                String k10 = s.k(this.f10735h, this.f10734g, e10, (String) null);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f10734g;
                cleverTapInstanceConfig.A("PushProvider", pushType + "getting Cached Token - " + k10);
                return k10;
            }
        }
        if (pushType != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f10734g;
            cleverTapInstanceConfig2.A("PushProvider", pushType + " Unable to find cached Token for type ");
        }
        return null;
    }
}
