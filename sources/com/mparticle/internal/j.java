package com.mparticle.internal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.c;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.d0;
import com.mparticle.identity.AliasRequest;
import com.mparticle.internal.PushRegistrationHelper;
import com.mparticle.internal.g;
import com.mparticle.k;
import com.mparticle.kits.ReportingMessage;
import com.mparticle.messaging.ProviderCloudMessage;
import com.mparticle.s;
import com.mparticle.s0;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;
import org.json.JSONException;

public class j implements k, ReportingManager {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Context f22485k;

    /* renamed from: l  reason: collision with root package name */
    static SharedPreferences f22486l;

    /* renamed from: m  reason: collision with root package name */
    static volatile boolean f22487m;

    /* renamed from: n  reason: collision with root package name */
    private static HandlerThread f22488n;

    /* renamed from: o  reason: collision with root package name */
    private static HandlerThread f22489o;

    /* renamed from: p  reason: collision with root package name */
    private static BroadcastReceiver f22490p;

    /* renamed from: q  reason: collision with root package name */
    private static String f22491q = OfflineMessageRequest.ELEMENT;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static double f22492r;

    /* renamed from: s  reason: collision with root package name */
    private static long f22493s = MPUtility.millitime();

    /* renamed from: t  reason: collision with root package name */
    private static TelephonyManager f22494t;

    /* renamed from: a  reason: collision with root package name */
    private final c f22495a;

    /* renamed from: b  reason: collision with root package name */
    private a f22496b;

    /* renamed from: c  reason: collision with root package name */
    private b f22497c;

    /* renamed from: d  reason: collision with root package name */
    private d0 f22498d;

    /* renamed from: e  reason: collision with root package name */
    private MParticle.OperatingSystem f22499e;

    /* renamed from: f  reason: collision with root package name */
    i f22500f;

    /* renamed from: g  reason: collision with root package name */
    public o f22501g;

    /* renamed from: h  reason: collision with root package name */
    private Location f22502h;

    /* renamed from: i  reason: collision with root package name */
    MParticle.InstallType f22503i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22504j;

    class a implements k.b {
        a() {
        }

        public void a() {
        }

        public void a(String str) {
            if (j.f22485k != null) {
                k.a(j.f22485k.getApplicationContext(), str);
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        String f22506a;

        /* renamed from: b  reason: collision with root package name */
        Long f22507b;

        /* renamed from: c  reason: collision with root package name */
        Number f22508c;

        b(String str, Long l10, Number number) {
            this.f22506a = str;
            this.f22507b = l10;
            this.f22508c = number;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        long f22509a;

        /* renamed from: b  reason: collision with root package name */
        List<? extends JsonReportingMessage> f22510b;

        public c(List<? extends JsonReportingMessage> list, long j10) {
            this.f22509a = j10;
            this.f22510b = list;
        }
    }

    @SuppressLint({"MissingPermission"})
    private class d extends BroadcastReceiver {
        private d() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    j.this.a(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
                } else if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    double unused = j.f22492r = ((double) intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) intent.getIntExtra("scale", -1));
                }
            } catch (Exception unused2) {
            }
        }

        /* synthetic */ d(j jVar, a aVar) {
            this();
        }
    }

    static {
        z();
    }

    public j() {
        this.f22497c = null;
        this.f22503i = MParticle.InstallType.AutoDetect;
        this.f22504j = false;
        this.f22495a = new c(this.f22499e);
    }

    public static void h() {
        HandlerThread handlerThread = f22488n;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        HandlerThread handlerThread2 = f22489o;
        if (handlerThread2 != null) {
            handlerThread2.quit();
        }
        z();
    }

    public static org.json.b n() throws JSONException {
        org.json.b bVar = new org.json.b();
        try {
            if (!f22487m) {
                bVar.put("fds", MPUtility.getAvailableInternalDisk(f22485k));
                bVar.put("efds", MPUtility.getAvailableExternalDisk(f22485k));
                Runtime runtime = Runtime.getRuntime();
                bVar.put("amt", runtime.totalMemory());
                bVar.put("ama", runtime.freeMemory());
                bVar.put("amm", runtime.maxMemory());
            }
            bVar.put("sma", MPUtility.getAvailableMemory(f22485k));
            bVar.put("tsm", q());
            bVar.put("bl", f22492r);
            bVar.put("tss", MPUtility.millitime() - f22493s);
            String gpsEnabled = MPUtility.getGpsEnabled(f22485k);
            if (gpsEnabled != null) {
                bVar.put("gps", Boolean.parseBoolean(gpsEnabled));
            }
            bVar.put("dct", (Object) f22491q);
            int orientation = MPUtility.getOrientation(f22485k);
            bVar.put("so", orientation);
            bVar.put("sbo", orientation);
            bVar.put("sml", MPUtility.isSystemMemoryLow(f22485k));
            bVar.put("smt", o());
            Integer networkType = MPUtility.getNetworkType(f22485k, p());
            if (networkType != null) {
                bVar.put("ant", (Object) networkType);
            }
        } catch (OutOfMemoryError unused) {
            Logger.error("Out of memory");
        }
        return bVar;
    }

    public static long o() {
        long j10 = f22486l.getLong("mp::memthreshold", -1);
        if (j10 >= 0) {
            return j10;
        }
        long systemMemoryThreshold = MPUtility.getSystemMemoryThreshold(f22485k);
        SharedPreferences.Editor edit = f22486l.edit();
        edit.putLong("mp::memthreshold", systemMemoryThreshold);
        edit.apply();
        return systemMemoryThreshold;
    }

    private static TelephonyManager p() {
        if (f22494t == null) {
            f22494t = (TelephonyManager) f22485k.getSystemService("phone");
        }
        return f22494t;
    }

    public static long q() {
        long j10 = f22486l.getLong("mp::totalmem", -1);
        if (j10 >= 0) {
            return j10;
        }
        long totalMemory = MPUtility.getTotalMemory(f22485k);
        SharedPreferences.Editor edit = f22486l.edit();
        edit.putLong("mp::totalmem", totalMemory);
        edit.apply();
        return totalMemory;
    }

    private static void z() {
        f22488n = new HandlerThread("mParticleMessageHandler", 10);
        f22489o = new HandlerThread("mParticleUploadHandler", 10);
        f22488n.start();
        f22489o.start();
    }

    public void A() {
        this.f22501g.removeMessages(1, Long.valueOf(this.f22497c.E()));
        o oVar = this.f22501g;
        oVar.sendMessageDelayed(oVar.obtainMessage(1, Long.valueOf(this.f22497c.E())), 10000);
    }

    public com.mparticle.c b(InternalSession internalSession) {
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.SESSION_START).a(this.f22496b.j().mSessionStartTime).a(internalSession, this.f22502h, this.f22497c.E());
            SharedPreferences.Editor edit = f22486l.edit();
            long n10 = this.f22497c.T().n();
            if (n10 > 0) {
                a10.put("psl", n10 / 1000);
                this.f22497c.T().a();
            }
            String o10 = this.f22497c.T().o();
            this.f22497c.T().e(internalSession.mSessionID);
            if (!MPUtility.isEmpty((CharSequence) o10)) {
                a10.put("pid", (Object) o10);
            }
            long e10 = this.f22497c.T().e(-1);
            this.f22497c.T().h(internalSession.mSessionStartTime);
            if (e10 > 0) {
                a10.put("pss", e10);
            }
            edit.apply();
            if (v()) {
                b(false);
                try {
                    com.mparticle.c g10 = g();
                    i iVar = this.f22500f;
                    iVar.sendMessage(iVar.obtainMessage(0, g10));
                } catch (JSONException unused) {
                    Logger.warning("Failed to create First Run Message.");
                }
            } else {
                i iVar2 = this.f22500f;
                iVar2.sendMessage(iVar2.obtainMessage(4, Long.valueOf(this.f22497c.E())));
            }
            i iVar3 = this.f22500f;
            iVar3.sendMessage(iVar3.obtainMessage(0, a10));
            this.f22497c.T().E();
            return a10;
        } catch (JSONException unused2) {
            Logger.warning("Failed to create mParticle start session message.");
            return null;
        }
    }

    public void c(InternalSession internalSession) {
        try {
            this.f22497c.T().g(internalSession.getForegroundTime());
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(2, internalSession));
        } catch (Exception unused) {
            Logger.warning("Failed to send update session end message.");
        }
    }

    public String d() throws g.b {
        String j10 = this.f22497c.j();
        if (!MPUtility.isEmpty((CharSequence) j10)) {
            return j10;
        }
        throw new g.b();
    }

    @SuppressLint({"MissingPermission"})
    public void e() {
        try {
            if (!this.f22504j) {
                this.f22504j = true;
                Intent registerReceiver = f22485k.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                f22492r = ((double) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) registerReceiver.getIntExtra("scale", -1));
                f22490p = new d(this, (a) null);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                if (MPUtility.checkPermission(f22485k, "android.permission.ACCESS_NETWORK_STATE")) {
                    a(((ConnectivityManager) f22485k.getSystemService("connectivity")).getActiveNetworkInfo());
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                }
                f22485k.registerReceiver(f22490p, intentFilter);
                k.a(f22485k, (k.b) new a());
            }
        } catch (Exception unused) {
        }
    }

    public com.mparticle.c g() throws JSONException {
        return new c.a(ReportingMessage.MessageType.FIRST_RUN).a(this.f22496b.j().mSessionStartTime).a(f22491q).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
    }

    public void i() {
        i iVar = this.f22500f;
        if (iVar != null) {
            iVar.a(true);
        }
        o oVar = this.f22501g;
        if (oVar != null) {
            oVar.a(true);
        }
    }

    public void j() {
        i iVar = this.f22500f;
        iVar.sendMessage(iVar.obtainMessage(14));
    }

    public Location k() {
        return this.f22502h;
    }

    public d0 l() {
        return this.f22498d;
    }

    public void log(JsonReportingMessage jsonReportingMessage) {
        if (jsonReportingMessage != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(jsonReportingMessage);
            logAll(arrayList);
        }
    }

    public void logAll(List<? extends JsonReportingMessage> list) {
        if (list != null && list.size() > 0) {
            boolean isDevEnv = MPUtility.isDevEnv();
            String str = this.f22496b.j().mSessionID;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((JsonReportingMessage) list.get(i10)).setDevMode(isDevEnv);
                ((JsonReportingMessage) list.get(i10)).setSessionId(str);
            }
            this.f22500f.sendMessage(this.f22500f.obtainMessage(9, new c(list, this.f22497c.E())));
        }
    }

    public Handler m() {
        return this.f22500f;
    }

    public void r() {
        this.f22501g.sendEmptyMessageDelayed(6, 10000);
    }

    public void s() {
        String str = this.f22496b.j().mSessionID;
        if (this.f22496b.j().isActive()) {
            this.f22500f.sendMessage(this.f22500f.obtainMessage(13, str));
        }
    }

    public boolean t() {
        return f22487m;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        SharedPreferences sharedPreferences = f22486l;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mp::firstrun::ast");
        sb2.append(this.f22497c.j());
        return sharedPreferences.getBoolean(sb2.toString(), true) && w();
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        SharedPreferences sharedPreferences = f22486l;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mp::firstrun::message");
        sb2.append(this.f22497c.j());
        return sharedPreferences.getBoolean(sb2.toString(), true) && w();
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        SharedPreferences sharedPreferences = f22486l;
        return sharedPreferences.getBoolean("mp::firstrun::" + this.f22497c.j(), true);
    }

    public void x() {
        this.f22501g.sendEmptyMessage(4);
    }

    public void y() {
        InternalSession j10 = this.f22496b.j();
        if (j10.mSessionAttributes != null) {
            try {
                org.json.b bVar = new org.json.b();
                bVar.put("sid", (Object) this.f22496b.j().mSessionID);
                bVar.put("attrs", (Object) j10.mSessionAttributes);
                i iVar = this.f22500f;
                iVar.sendMessage(iVar.obtainMessage(1, bVar));
            } catch (JSONException unused) {
                Logger.warning("Failed to send update session attributes message.");
            }
        }
    }

    public void a(InternalSession internalSession) {
        c(internalSession);
        AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(internalSession.mSessionID, internalSession.getMpids());
        i iVar = this.f22500f;
        iVar.sendMessage(iVar.obtainMessage(3, 1, 1, simpleEntry));
    }

    public void c() {
        this.f22501g.removeMessages(1);
        MParticle.getInstance().upload();
    }

    public j(b bVar, a aVar, d dVar, boolean z10, d0 d0Var, MParticleOptions mParticleOptions) {
        this.f22497c = null;
        this.f22503i = MParticle.InstallType.AutoDetect;
        this.f22504j = false;
        f22487m = z10;
        MParticle.OperatingSystem operatingSystem = mParticleOptions.getOperatingSystem();
        this.f22499e = operatingSystem;
        this.f22495a = new c(operatingSystem);
        f22485k = mParticleOptions.getContext().getApplicationContext();
        this.f22497c = bVar;
        this.f22496b = aVar;
        aVar.a(this);
        this.f22498d = d0Var;
        this.f22500f = new i(f22488n.getLooper(), this, mParticleOptions.getContext(), d0Var, mParticleOptions.getDataplanId(), mParticleOptions.getDataplanVersion());
        this.f22501g = new o(mParticleOptions.getContext(), f22489o.getLooper(), bVar, aVar, this, d0Var, dVar);
        f22486l = mParticleOptions.getContext().getSharedPreferences("mParticlePrefs", 0);
        this.f22503i = mParticleOptions.getInstallType();
    }

    public com.mparticle.c a(MPEvent mPEvent, String str) {
        if (mPEvent == null) {
            return null;
        }
        try {
            com.mparticle.c a10 = mPEvent.getMessage().a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("est", this.f22496b.j().mLastEventTime);
            if (str != null) {
                a10.put("cn", (Object) str);
            }
            int i10 = f22486l.getInt("mp::events::counter", 0);
            a10.put("en", i10);
            f22486l.edit().putInt("mp::events::counter", i10 + 1).apply();
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle log event message.");
            return null;
        }
    }

    public com.mparticle.c a(CommerceEvent commerceEvent) {
        if (commerceEvent == null) {
            return null;
        }
        try {
            com.mparticle.c a10 = commerceEvent.getMessage().a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle log event message.");
            return null;
        }
    }

    public com.mparticle.c a(MPEvent mPEvent, boolean z10) {
        if (mPEvent == null || mPEvent.getEventName() == null) {
            return null;
        }
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.SCREEN_VIEW).a(this.f22496b.j().mLastEventTime).b(mPEvent.getEventName()).a(mPEvent.getCustomFlags()).a(MPUtility.enforceAttributeConstraints(mPEvent.getCustomAttributeStrings())).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("est", this.f22496b.j().mLastEventTime);
            a10.put("el", 0);
            a10.put("t", (Object) z10 ? "activity_started" : "activity_stopped");
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle log event message.");
            return null;
        }
    }

    public void b(String str, long j10) {
        d0.e eVar = new d0.e();
        eVar.f22296a = str;
        eVar.f22297b = System.currentTimeMillis();
        eVar.f22298c = j10;
        this.f22500f.sendMessage(this.f22500f.obtainMessage(10, eVar));
    }

    public synchronized c b() {
        return this.f22495a;
    }

    public com.mparticle.c a(String str) {
        if (str == null) {
            return null;
        }
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.BREADCRUMB).a(this.f22496b.j().mLastEventTime).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("est", this.f22496b.j().mLastEventTime);
            a10.put("sn", this.f22497c.T().e());
            a10.put("l", (Object) str);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            i iVar2 = this.f22500f;
            iVar2.sendMessage(iVar2.obtainMessage(5, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle breadcrumb message.");
            return null;
        }
    }

    public org.json.a b(long j10) {
        return this.f22497c.e(j10);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        SharedPreferences.Editor edit = f22486l.edit();
        SharedPreferences.Editor putBoolean = edit.putBoolean("mp::firstrun::message" + this.f22497c.j(), z10);
        putBoolean.remove("mp::firstrun::" + this.f22497c.j()).apply();
    }

    public com.mparticle.c a(long j10, boolean z10) {
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.OPT_OUT).a(j10).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("s", z10);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle opt out message.");
            return null;
        }
    }

    public com.mparticle.c a(String str, Throwable th2, org.json.b bVar) {
        return a(str, th2, bVar, true);
    }

    public com.mparticle.c a(String str, Throwable th2, org.json.b bVar, boolean z10) {
        try {
            com.mparticle.c a10 = new c.a("x").a(this.f22496b.j().mLastEventTime).a(bVar).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            String str2 = "error";
            if (th2 != null) {
                a10.put(NetworkProfile.MALE, (Object) th2.getMessage());
                if (!z10) {
                    str2 = "fatal";
                }
                a10.put("s", (Object) str2);
                a10.put("c", (Object) th2.getClass().getCanonicalName());
                StringWriter stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                a10.put(UserDataStore.STATE, (Object) stringWriter.toString());
                a10.put("eh", (Object) String.valueOf(z10));
                a10.put("sn", this.f22497c.T().e());
                i iVar = this.f22500f;
                iVar.sendMessage(iVar.obtainMessage(0, a10));
            } else if (str != null) {
                a10.put("s", (Object) str2);
                a10.put(NetworkProfile.MALE, (Object) str);
                i iVar2 = this.f22500f;
                iVar2.sendMessage(iVar2.obtainMessage(0, a10));
            }
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle error message.");
            return null;
        }
    }

    public com.mparticle.c a(long j10, String str, String str2, long j11, long j12, long j13, String str3) {
        if (MPUtility.isEmpty((CharSequence) str2) || MPUtility.isEmpty((CharSequence) str)) {
            return null;
        }
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.NETWORK_PERFORMNACE).a(j10).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put(ReportingMessage.MessageType.SCREEN_VIEW, (Object) str);
            a10.put("url", (Object) str2);
            a10.put("te", j11);
            a10.put("bo", j12);
            a10.put("bi", j13);
            if (str3 != null) {
                a10.put("d", (Object) str3);
            }
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle network performance message.");
            return null;
        }
    }

    public com.mparticle.c a(String str, boolean z10) {
        if (MPUtility.isEmpty((CharSequence) str)) {
            return null;
        }
        try {
            this.f22497c.b(str);
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.PUSH_REGISTRATION).a(System.currentTimeMillis()).a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("to", (Object) str);
            a10.put("tot", (Object) "google");
            a10.put(StreamManagement.AckRequest.ELEMENT, z10);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle push registration message.");
            return null;
        }
    }

    public void a() {
        o oVar = this.f22501g;
        oVar.sendMessage(oVar.obtainMessage(1, 1, 0, Long.valueOf(this.f22497c.E())));
    }

    public void a(Location location) {
        this.f22502h = location;
        Logger.debug("Received location update: " + location);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f4 A[Catch:{ JSONException -> 0x011b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mparticle.c a(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, long r23, long r25, int r27) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r23
            r5 = r25
            r7 = r27
            java.lang.String r8 = "mp::initupgrade"
            java.lang.String r9 = "app_init"
            java.lang.String r10 = "mp::crashed_in_foreground"
            boolean r11 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r18)
            if (r11 != 0) goto L_0x0124
            com.mparticle.c$a r11 = new com.mparticle.c$a     // Catch:{ JSONException -> 0x011b }
            java.lang.String r12 = "ast"
            r11.<init>(r12)     // Catch:{ JSONException -> 0x011b }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x011b }
            com.mparticle.d r11 = r11.a((long) r12)     // Catch:{ JSONException -> 0x011b }
            com.mparticle.internal.a r12 = r0.f22496b     // Catch:{ JSONException -> 0x011b }
            com.mparticle.internal.InternalSession r12 = r12.j()     // Catch:{ JSONException -> 0x011b }
            android.location.Location r13 = r0.f22502h     // Catch:{ JSONException -> 0x011b }
            com.mparticle.internal.b r14 = r0.f22497c     // Catch:{ JSONException -> 0x011b }
            long r14 = r14.E()     // Catch:{ JSONException -> 0x011b }
            com.mparticle.c r11 = r11.a(r12, r13, r14)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r12 = "t"
            r11.put((java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x011b }
            if (r2 == 0) goto L_0x0045
            java.lang.String r12 = "cn"
            r11.put((java.lang.String) r12, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x011b }
        L_0x0045:
            android.content.SharedPreferences r2 = f22486l     // Catch:{ JSONException -> 0x011b }
            r12 = 0
            boolean r2 = r2.getBoolean(r10, r12)     // Catch:{ JSONException -> 0x011b }
            boolean r13 = r1.equals(r9)     // Catch:{ JSONException -> 0x011b }
            r14 = 1
            if (r13 != 0) goto L_0x005b
            java.lang.String r13 = "app_fore"
            boolean r13 = r1.equals(r13)     // Catch:{ JSONException -> 0x011b }
            if (r13 == 0) goto L_0x0098
        L_0x005b:
            android.content.SharedPreferences r13 = f22486l     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r13 = r13.edit()     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r13 = r13.putBoolean(r10, r14)     // Catch:{ JSONException -> 0x011b }
            r13.apply()     // Catch:{ JSONException -> 0x011b }
            java.lang.String r13 = "lr"
            r15 = r20
            r11.put((java.lang.String) r13, (java.lang.Object) r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r13 = "lpr"
            r15 = r21
            r11.put((java.lang.String) r13, (java.lang.Object) r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r13 = "srp"
            r15 = r22
            r11.put((java.lang.String) r13, (java.lang.Object) r15)     // Catch:{ JSONException -> 0x011b }
            r15 = 0
            int r13 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r13 <= 0) goto L_0x0088
            java.lang.String r13 = "pft"
            r11.put((java.lang.String) r13, (long) r3)     // Catch:{ JSONException -> 0x011b }
        L_0x0088:
            int r3 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x0091
            java.lang.String r3 = "tls"
            r11.put((java.lang.String) r3, (long) r5)     // Catch:{ JSONException -> 0x011b }
        L_0x0091:
            if (r7 < 0) goto L_0x0098
            java.lang.String r3 = "nsi"
            r11.put((java.lang.String) r3, (int) r7)     // Catch:{ JSONException -> 0x011b }
        L_0x0098:
            boolean r3 = r1.equals(r9)     // Catch:{ JSONException -> 0x011b }
            if (r3 == 0) goto L_0x00fc
            android.content.SharedPreferences r3 = f22486l     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ JSONException -> 0x011b }
            boolean r4 = r17.u()     // Catch:{ JSONException -> 0x011b }
            if (r4 != 0) goto L_0x00af
            java.lang.String r4 = "sc"
            r11.put((java.lang.String) r4, (boolean) r2)     // Catch:{ JSONException -> 0x011b }
        L_0x00af:
            android.content.Context r2 = f22485k     // Catch:{ NameNotFoundException -> 0x00c2 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00c2 }
            android.content.Context r4 = f22485k     // Catch:{ NameNotFoundException -> 0x00c2 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x00c2 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r4, r12)     // Catch:{ NameNotFoundException -> 0x00c2 }
            int r2 = r2.versionCode     // Catch:{ NameNotFoundException -> 0x00c2 }
            goto L_0x00c3
        L_0x00c2:
            r2 = r12
        L_0x00c3:
            android.content.SharedPreferences r4 = f22486l     // Catch:{ JSONException -> 0x011b }
            int r4 = r4.getInt(r8, r2)     // Catch:{ JSONException -> 0x011b }
            if (r2 == r4) goto L_0x00cd
            r4 = r14
            goto L_0x00ce
        L_0x00cd:
            r4 = r12
        L_0x00ce:
            android.content.SharedPreferences$Editor r2 = r3.putInt(r8, r2)     // Catch:{ JSONException -> 0x011b }
            r2.apply()     // Catch:{ JSONException -> 0x011b }
            if (r4 != 0) goto L_0x00e4
            com.mparticle.MParticle$InstallType r2 = r0.f22503i     // Catch:{ JSONException -> 0x011b }
            com.mparticle.MParticle$InstallType r3 = com.mparticle.MParticle.InstallType.KnownUpgrade     // Catch:{ JSONException -> 0x011b }
            if (r2 != r3) goto L_0x00de
            goto L_0x00e5
        L_0x00de:
            com.mparticle.MParticle$InstallType r3 = com.mparticle.MParticle.InstallType.KnownInstall     // Catch:{ JSONException -> 0x011b }
            if (r2 != r3) goto L_0x00e4
            r14 = r12
            goto L_0x00e5
        L_0x00e4:
            r14 = r4
        L_0x00e5:
            java.lang.String r2 = "ifr"
            boolean r3 = r17.u()     // Catch:{ JSONException -> 0x011b }
            r11.put((java.lang.String) r2, (boolean) r3)     // Catch:{ JSONException -> 0x011b }
            boolean r2 = r17.u()     // Catch:{ JSONException -> 0x011b }
            if (r2 == 0) goto L_0x00f7
            r0.a((boolean) r12)     // Catch:{ JSONException -> 0x011b }
        L_0x00f7:
            java.lang.String r2 = "iu"
            r11.put((java.lang.String) r2, (boolean) r14)     // Catch:{ JSONException -> 0x011b }
        L_0x00fc:
            java.lang.String r2 = "app_back"
            boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x011b }
            if (r1 == 0) goto L_0x0111
            android.content.SharedPreferences r1 = f22486l     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r1 = r1.putBoolean(r10, r12)     // Catch:{ JSONException -> 0x011b }
            r1.apply()     // Catch:{ JSONException -> 0x011b }
        L_0x0111:
            com.mparticle.internal.i r1 = r0.f22500f     // Catch:{ JSONException -> 0x011b }
            android.os.Message r2 = r1.obtainMessage(r12, r11)     // Catch:{ JSONException -> 0x011b }
            r1.sendMessage(r2)     // Catch:{ JSONException -> 0x011b }
            return r11
        L_0x011b:
            java.lang.String r1 = "Failed to create mParticle state transition message."
            java.lang.String[] r1 = new java.lang.String[]{r1}
            com.mparticle.internal.Logger.warning(r1)
        L_0x0124:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.j.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, int):com.mparticle.c");
    }

    public void a(ProviderCloudMessage providerCloudMessage, String str) {
        String str2;
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.PUSH_RECEIVED).a(System.currentTimeMillis()).b("gcm").a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("pay", (Object) providerCloudMessage.getRedactedJsonPayload().toString());
            a10.put("t", (Object) DeliveryReceipt.ELEMENT);
            PushRegistrationHelper.PushRegistration M = this.f22497c.M();
            if (!(M == null || (str2 = M.instanceId) == null || str2.length() <= 0)) {
                a10.put("to", (Object) M.instanceId);
            }
            a10.put("as", (Object) str);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
        } catch (JSONException unused) {
        }
    }

    public void a(int i10, String str, String str2, int i11) {
        String str3;
        try {
            com.mparticle.c a10 = new c.a(ReportingMessage.MessageType.PUSH_RECEIVED).a(System.currentTimeMillis()).b("gcm").a(this.f22496b.j(), this.f22502h, this.f22497c.E());
            a10.put("pay", (Object) str);
            a10.put("bhv", i11);
            a10.put("content_id", i10);
            a10.put("t", (Object) DeliveryReceipt.ELEMENT);
            PushRegistrationHelper.PushRegistration M = this.f22497c.M();
            if (!(M == null || (str3 = M.instanceId) == null || str3.length() <= 0)) {
                a10.put("to", (Object) M.instanceId);
            }
            a10.put("as", (Object) str2);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: finally extract failed */
    public com.mparticle.c a(org.json.b bVar, org.json.b bVar2, org.json.a aVar, long j10) {
        try {
            com.mparticle.c a10 = new c.a("uic").a(System.currentTimeMillis()).a(this.f22496b.j(), this.f22502h, j10);
            if (bVar != null) {
                a10.put("ni", (Object) bVar);
            } else {
                a10.put("ni", org.json.b.NULL);
            }
            if (bVar2 != null) {
                a10.put("oi", (Object) bVar2);
            } else {
                a10.put("oi", org.json.b.NULL);
            }
            a10.put("ui", (Object) aVar);
            i iVar = this.f22500f;
            iVar.sendMessage(iVar.obtainMessage(0, a10));
            org.json.a a11 = this.f22497c.a(aVar, j10);
            if (a11 != null) {
                this.f22497c.b(a11, j10);
            }
            this.f22497c.b(aVar, j10);
            return a10;
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle user-identity-change message.");
            this.f22497c.b(aVar, j10);
            return null;
        } catch (Throwable th2) {
            this.f22497c.b(aVar, j10);
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[Catch:{ JSONException -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A[Catch:{ JSONException -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mparticle.c a(java.lang.String r3, java.lang.Object r4, java.lang.Object r5, boolean r6, boolean r7, long r8, long r10) {
        /*
            r2 = this;
            com.mparticle.c$a r0 = new com.mparticle.c$a     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r1 = "uac"
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0099 }
            com.mparticle.d r8 = r0.a((long) r8)     // Catch:{ JSONException -> 0x0099 }
            com.mparticle.internal.a r9 = r2.f22496b     // Catch:{ JSONException -> 0x0099 }
            com.mparticle.internal.InternalSession r9 = r9.j()     // Catch:{ JSONException -> 0x0099 }
            android.location.Location r0 = r2.f22502h     // Catch:{ JSONException -> 0x0099 }
            com.mparticle.c r8 = r8.a(r9, r0, r10)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r9 = "n"
            r8.put((java.lang.String) r9, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0099 }
            r3 = 0
            if (r4 == 0) goto L_0x0046
            if (r6 == 0) goto L_0x0022
            goto L_0x0046
        L_0x0022:
            boolean r9 = r4 instanceof java.util.List     // Catch:{ JSONException -> 0x0099 }
            if (r9 == 0) goto L_0x0048
            org.json.a r9 = new org.json.a     // Catch:{ JSONException -> 0x0099 }
            r9.<init>()     // Catch:{ JSONException -> 0x0099 }
            r0 = r3
        L_0x002c:
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ JSONException -> 0x0099 }
            int r1 = r1.size()     // Catch:{ JSONException -> 0x0099 }
            if (r0 >= r1) goto L_0x0044
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ JSONException -> 0x0099 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0099 }
            r9.E(r1)     // Catch:{ JSONException -> 0x0099 }
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0044:
            r4 = r9
            goto L_0x0048
        L_0x0046:
            java.lang.Object r4 = org.json.b.NULL     // Catch:{ JSONException -> 0x0099 }
        L_0x0048:
            java.lang.String r9 = "nv"
            r8.put((java.lang.String) r9, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x0099 }
            if (r5 != 0) goto L_0x0052
            java.lang.Object r5 = org.json.b.NULL     // Catch:{ JSONException -> 0x0099 }
            goto L_0x0075
        L_0x0052:
            boolean r4 = r5 instanceof java.util.List     // Catch:{ JSONException -> 0x0099 }
            if (r4 == 0) goto L_0x0075
            org.json.a r4 = new org.json.a     // Catch:{ JSONException -> 0x0099 }
            r4.<init>()     // Catch:{ JSONException -> 0x0099 }
            r9 = r3
        L_0x005c:
            r0 = r5
            java.util.List r0 = (java.util.List) r0     // Catch:{ JSONException -> 0x0099 }
            int r0 = r0.size()     // Catch:{ JSONException -> 0x0099 }
            if (r9 >= r0) goto L_0x0074
            r0 = r5
            java.util.List r0 = (java.util.List) r0     // Catch:{ JSONException -> 0x0099 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0099 }
            r4.E(r0)     // Catch:{ JSONException -> 0x0099 }
            int r9 = r9 + 1
            goto L_0x005c
        L_0x0074:
            r5 = r4
        L_0x0075:
            java.lang.String r4 = "ov"
            r8.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r4 = "d"
            r8.put((java.lang.String) r4, (boolean) r6)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r4 = "na"
            r8.put((java.lang.String) r4, (boolean) r7)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r4 = "ua"
            com.mparticle.d0 r5 = r2.f22498d     // Catch:{ JSONException -> 0x0099 }
            org.json.b r5 = r5.a((long) r10)     // Catch:{ JSONException -> 0x0099 }
            r8.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0099 }
            com.mparticle.internal.i r4 = r2.f22500f     // Catch:{ JSONException -> 0x0099 }
            android.os.Message r3 = r4.obtainMessage(r3, r8)     // Catch:{ JSONException -> 0x0099 }
            r4.a((android.os.Message) r3)     // Catch:{ JSONException -> 0x0099 }
            return r8
        L_0x0099:
            java.lang.String r3 = "Failed to create mParticle user-attribute-change message."
            java.lang.String[] r3 = new java.lang.String[]{r3}
            com.mparticle.internal.Logger.warning(r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.j.a(java.lang.String, java.lang.Object, java.lang.Object, boolean, boolean, long, long):com.mparticle.c");
    }

    public void a(com.mparticle.c cVar) {
        if (this.f22497c.a(cVar)) {
            this.f22501g.removeMessages(5, Long.valueOf(this.f22497c.E()));
            o oVar = this.f22501g;
            oVar.sendMessageDelayed(oVar.obtainMessage(5, 1, 0, Long.valueOf(this.f22497c.E())), 5000);
        }
    }

    public Map<String, Object> a(s0 s0Var, long j10) {
        return this.f22498d.a(s0Var, j10);
    }

    public void a(String str, long j10) {
        org.json.a aVar;
        try {
            aVar = new org.json.a(this.f22497c.f(j10).g());
        } catch (Exception unused) {
            aVar = new org.json.a();
        }
        aVar.E(str);
        this.f22497c.f(j10).c(aVar.toString());
    }

    public void a(String str, Object obj, long j10, boolean z10) {
        d0.f fVar = new d0.f();
        fVar.f22301c = System.currentTimeMillis();
        fVar.f22302d = j10;
        if (obj instanceof List) {
            HashMap hashMap = new HashMap();
            fVar.f22300b = hashMap;
            hashMap.put(str, (List) obj);
        } else {
            HashMap hashMap2 = new HashMap();
            fVar.f22299a = hashMap2;
            hashMap2.put(str, obj);
        }
        if (z10) {
            this.f22500f.a(fVar);
            return;
        }
        this.f22500f.sendMessage(this.f22500f.obtainMessage(11, fVar));
    }

    public void a(String str, Number number, long j10) {
        this.f22500f.sendMessage(this.f22500f.obtainMessage(12, new b(str, Long.valueOf(j10), number)));
    }

    public Map<MParticle.IdentityType, String> a(long j10) {
        return this.f22497c.d(j10);
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        this.f22500f.post(runnable);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z10) {
        SharedPreferences.Editor edit = f22486l.edit();
        SharedPreferences.Editor putBoolean = edit.putBoolean("mp::firstrun::ast" + this.f22497c.j(), z10);
        putBoolean.remove("mp::firstrun::" + this.f22497c.j()).apply();
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            String typeName = networkInfo.getTypeName();
            if (networkInfo.getSubtype() != 0) {
                typeName = typeName + RemoteSettings.FORWARD_SLASH_STRING + networkInfo.getSubtypeName();
            }
            f22491q = typeName.toLowerCase(Locale.US);
            this.f22501g.c(networkInfo.isConnectedOrConnecting());
            return;
        }
        f22491q = OfflineMessageRequest.ELEMENT;
        this.f22501g.c(false);
    }

    public void a(AliasRequest aliasRequest) {
        try {
            this.f22500f.sendMessage(this.f22501g.obtainMessage(15, new s(aliasRequest, this.f22497c.t(), this.f22497c.j())));
        } catch (JSONException unused) {
            Logger.warning("Failed to create mParticle opt out message");
        }
    }
}
