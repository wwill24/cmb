package com.mparticle.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.stetho.server.http.HttpHeaders;
import com.mparticle.MParticle;
import com.mparticle.SdkListener;
import com.mparticle.b0;
import com.mparticle.internal.f;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.networking.b;
import com.mparticle.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;

public class g extends com.mparticle.networking.b implements f {

    /* renamed from: r  reason: collision with root package name */
    private static String f22464r;

    /* renamed from: f  reason: collision with root package name */
    private final b f22465f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22466g;

    /* renamed from: h  reason: collision with root package name */
    private b0 f22467h;

    /* renamed from: i  reason: collision with root package name */
    private b0 f22468i;

    /* renamed from: j  reason: collision with root package name */
    private b0 f22469j;

    /* renamed from: k  reason: collision with root package name */
    private final String f22470k;

    /* renamed from: l  reason: collision with root package name */
    private final SharedPreferences f22471l;

    /* renamed from: m  reason: collision with root package name */
    private final String f22472m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f22473n;

    /* renamed from: o  reason: collision with root package name */
    Integer f22474o = null;

    /* renamed from: p  reason: collision with root package name */
    private org.json.b f22475p;

    /* renamed from: q  reason: collision with root package name */
    private long f22476q = -1;

    public final class a extends Exception {
        a() {
            super("mParticle configuration request failed.");
        }
    }

    public static final class b extends Exception {
        b() {
            super("No API key and/or API secret.");
        }
    }

    public static final class c extends Exception {
        c() {
            super("This device is being sampled.");
        }
    }

    public final class d extends Exception {
        d() {
            super("mParticle servers are busy, API connections have been throttled.");
        }
    }

    public g(b bVar, SharedPreferences sharedPreferences, Context context) throws MalformedURLException, b {
        super(context, bVar);
        this.f22473n = context;
        this.f22465f = bVar;
        String k10 = bVar.k();
        this.f22466g = k10;
        this.f22471l = sharedPreferences;
        String j10 = bVar.j();
        this.f22472m = j10;
        this.f22470k = "mParticle Android SDK/5.53.0";
        if (MPUtility.isEmpty((CharSequence) j10) || MPUtility.isEmpty((CharSequence) k10)) {
            throw new b();
        }
    }

    private void c(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            if (bVar.has("msgs")) {
                org.json.a jSONArray = bVar.getJSONArray("msgs");
                Logger.verbose("Uploading message batch...");
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    Logger.verbose("Message type: " + ((org.json.b) jSONArray.get(i10)).getString("dt"));
                }
            } else if (bVar.has("sh")) {
                org.json.a jSONArray2 = bVar.getJSONArray("sh");
                Logger.verbose("Uploading session history batch...");
                for (int i11 = 0; i11 < jSONArray2.o(); i11++) {
                    Logger.verbose("Message type: " + ((org.json.b) jSONArray2.get(i11)).getString("dt") + " SID: " + ((org.json.b) jSONArray2.get(i11)).optString("sid"));
                }
            }
        } catch (JSONException unused) {
        }
    }

    private void d() throws c {
        if (this.f22474o == null) {
            this.f22474o = Integer.valueOf(MPUtility.hashFnv1A(MPUtility.getRampUdid(this.f22473n).getBytes()).mod(BigInteger.valueOf(100)).intValue());
        }
        int p10 = this.f22465f.p();
        if (p10 > 0 && p10 < 100 && this.f22474o.intValue() > this.f22465f.p()) {
            throw new c();
        }
    }

    private String f() {
        if (f22464r == null) {
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                Set<Integer> supportedKits = instance.Internal().c().getSupportedKits();
                if (supportedKits != null && supportedKits.size() > 0) {
                    StringBuilder sb2 = new StringBuilder(supportedKits.size() * 3);
                    Iterator<Integer> it = supportedKits.iterator();
                    while (it.hasNext()) {
                        sb2.append(it.next());
                        if (it.hasNext()) {
                            sb2.append(AppsFlyerKit.COMMA);
                        }
                    }
                    f22464r = sb2.toString();
                }
            } else {
                f22464r = "";
            }
        }
        return f22464r;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0191, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0192, code lost:
        com.mparticle.internal.Logger.error("Config request failed " + r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0191 A[ExcHandler: AssertionError (r1v0 'e' java.lang.AssertionError A[CUSTOM_DECLARE]), Splitter:B:7:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r8) throws java.io.IOException, com.mparticle.internal.g.a {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0021
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.f22476q
            long r0 = r0 - r2
            r2 = 600000(0x927c0, double:2.964394E-318)
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0017
            long r0 = java.lang.System.currentTimeMillis()
            r7.f22476q = r0
            goto L_0x0021
        L_0x0017:
            java.lang.String r8 = "Config request deferred, not enough time has elapsed since last request."
            java.lang.String[] r8 = new java.lang.String[]{r8}
            com.mparticle.internal.Logger.verbose(r8)
            return
        L_0x0021:
            r8 = 0
            r0 = 1
            com.mparticle.b0 r1 = r7.f22467h     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            if (r1 != 0) goto L_0x002f
            com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.CONFIG     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.b0 r1 = r7.b(r1)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r7.f22467h = r1     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x002f:
            com.mparticle.b0 r1 = r7.f22467h     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.u r1 = r1.c()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.b r2 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r2 = r2.o()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.a((java.lang.Integer) r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.b r2 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r2 = r2.o()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.b((java.lang.Integer) r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r2 = "x-mp-env"
            com.mparticle.MParticle$Environment r3 = com.mparticle.internal.b.u()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r3 = r3.getValue()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.a(r2, r3)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r2 = r7.f()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            boolean r3 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            if (r3 != 0) goto L_0x006f
            java.lang.String r3 = "x-mp-kits"
            r1.a(r3, r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x006f:
            java.lang.String r2 = "User-Agent"
            java.lang.String r3 = r7.f22470k     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.a(r2, r3)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.b r2 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r2 = r2.v()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            if (r2 == 0) goto L_0x0083
            java.lang.String r3 = "If-None-Match"
            r1.a(r3, r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x0083:
            com.mparticle.internal.b r2 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r2 = r2.y()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            if (r2 == 0) goto L_0x0090
            java.lang.String r3 = "If-Modified-Since"
            r1.a(r3, r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x0090:
            r2 = 0
            r7.a(r1, r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = "Config request attempt:\nURL- "
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.b0 r4 = r7.f22467h     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r2[r8] = r3     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.Logger.verbose(r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            boolean r2 = com.mparticle.internal.listeners.InternalListenerManager.isEnabled()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            if (r2 == 0) goto L_0x00d0
            com.mparticle.l r2 = com.mparticle.internal.listeners.InternalListenerManager.getListener()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.SdkListener$Endpoint r3 = com.mparticle.SdkListener.Endpoint.CONFIG     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.b0 r4 = r1.h()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            org.json.b r5 = new org.json.b     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r2.onNetworkRequestStarted(r3, r4, r5, r6)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x00d0:
            com.mparticle.networking.b$b r2 = com.mparticle.networking.b.C0262b.CONFIG     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r7.a((com.mparticle.networking.b.C0262b) r2, (com.mparticle.u) r1, (boolean) r0)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            org.json.b r2 = new org.json.b     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r3 = r1.d()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            org.json.b r2 = com.mparticle.internal.MPUtility.getJsonResponse((com.mparticle.u) r1)     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
            com.mparticle.l r4 = com.mparticle.internal.listeners.InternalListenerManager.getListener()     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
            com.mparticle.SdkListener$Endpoint r5 = com.mparticle.SdkListener.Endpoint.CONFIG     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
            com.mparticle.b0 r6 = r1.h()     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
            r4.onNetworkRequestFinished(r5, r6, r2, r3)     // Catch:{ Exception -> 0x00f3, AssertionError -> 0x0191 }
        L_0x00f3:
            r4 = 200(0xc8, float:2.8E-43)
            java.lang.String r5 = ": "
            if (r3 < r4) goto L_0x0145
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 >= r4) goto L_0x0145
            r7.a((org.json.b) r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r6 = "Config result: \n "
            r4.append(r6)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r6 = r1.d()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.append(r6)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r5 = r1.f()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r5 = "\nresponse:\n"
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r5 = r2.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.append(r5)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3[r8] = r4     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.Logger.verbose(r3)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r3 = "ETag"
            java.lang.String r3 = r1.b((java.lang.String) r3)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = "Last-Modified"
            java.lang.String r1 = r1.b((java.lang.String) r4)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.b r4 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r4.a(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            goto L_0x01c2
        L_0x0145:
            int r2 = r1.d()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3 = 400(0x190, float:5.6E-43)
            if (r2 == r3) goto L_0x018b
            int r2 = r1.d()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3 = 304(0x130, float:4.26E-43)
            if (r2 != r3) goto L_0x0164
            com.mparticle.internal.b r1 = r7.f22465f     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.f()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r1 = "Config request deferred, configuration already up-to-date."
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.Logger.verbose(r1)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            goto L_0x01c2
        L_0x0164:
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r4 = "Config request failed- "
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            int r4 = r1.d()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.append(r5)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r1 = r1.f()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r3.append(r1)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            java.lang.String r1 = r3.toString()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r2[r8] = r1     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            com.mparticle.internal.Logger.error(r2)     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            goto L_0x01c2
        L_0x018b:
            com.mparticle.internal.g$a r1 = new com.mparticle.internal.g$a     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            r1.<init>()     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
            throw r1     // Catch:{ MalformedURLException -> 0x01b9, JSONException -> 0x01af, AssertionError -> 0x0191 }
        L_0x0191:
            r1 = move-exception
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Config request failed "
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0[r8] = r1
            com.mparticle.internal.Logger.error(r0)
            goto L_0x01c2
        L_0x01af:
            java.lang.String r8 = "Config request failed to process response message JSON."
            java.lang.String[] r8 = new java.lang.String[]{r8}
            com.mparticle.internal.Logger.error(r8)
            goto L_0x01c2
        L_0x01b9:
            java.lang.String r8 = "Error constructing config service URL."
            java.lang.String[] r8 = new java.lang.String[]{r8}
            com.mparticle.internal.Logger.error(r8)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.g.a(boolean):void");
    }

    public void b() throws IOException, a {
        a(false);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.b e() {
        /*
            r7 = this;
            org.json.b r0 = r7.f22475p
            if (r0 != 0) goto L_0x00bb
            com.mparticle.internal.b r0 = r7.f22465f
            com.mparticle.internal.p r0 = r0.T()
            java.lang.String r0 = r0.d()
            boolean r1 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r0)
            if (r1 == 0) goto L_0x002d
            org.json.b r0 = new org.json.b
            r0.<init>()
            r7.f22475p = r0
            com.mparticle.internal.b r0 = r7.f22465f
            com.mparticle.internal.p r0 = r0.T()
            org.json.b r1 = r7.f22475p
            java.lang.String r1 = r1.toString()
            r0.b((java.lang.String) r1)
            org.json.b r0 = r7.f22475p
            return r0
        L_0x002d:
            org.json.b r1 = new org.json.b     // Catch:{ JSONException -> 0x0035 }
            r1.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0035 }
            r7.f22475p = r1     // Catch:{ JSONException -> 0x0035 }
            goto L_0x003c
        L_0x0035:
            org.json.b r0 = new org.json.b
            r0.<init>()
            r7.f22475p = r0
        L_0x003c:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r1 = 1
            r2 = 1990(0x7c6, float:2.789E-42)
            r0.set(r1, r2)
            java.util.Date r0 = r0.getTime()
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy"
            r1.<init>(r2)
            org.json.b r2 = r7.f22475p
            java.util.Iterator r2 = r2.keys()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x005c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r2.next()     // Catch:{  }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{  }
            org.json.b r5 = r7.f22475p     // Catch:{  }
            java.lang.Object r5 = r5.get(r4)     // Catch:{  }
            boolean r5 = r5 instanceof org.json.b     // Catch:{  }
            if (r5 == 0) goto L_0x005c
            org.json.b r5 = r7.f22475p     // Catch:{  }
            java.lang.Object r5 = r5.get(r4)     // Catch:{  }
            org.json.b r5 = (org.json.b) r5     // Catch:{  }
            java.lang.String r6 = "e"
            java.lang.String r5 = r5.getString(r6)     // Catch:{  }
            java.util.Date r5 = r1.parse(r5)     // Catch:{ JSONException -> 0x005c }
            boolean r5 = r5.before(r0)     // Catch:{ JSONException -> 0x005c }
            if (r5 == 0) goto L_0x005c
            r3.add(r4)     // Catch:{ JSONException -> 0x005c }
            goto L_0x005c
        L_0x008e:
            java.util.Iterator r0 = r3.iterator()
        L_0x0092:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            org.json.b r2 = r7.f22475p
            r2.remove(r1)
            goto L_0x0092
        L_0x00a4:
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x00b9
            com.mparticle.internal.b r0 = r7.f22465f
            com.mparticle.internal.p r0 = r0.T()
            org.json.b r1 = r7.f22475p
            java.lang.String r1 = r1.toString()
            r0.b((java.lang.String) r1)
        L_0x00b9:
            org.json.b r0 = r7.f22475p
        L_0x00bb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.g.e():org.json.b");
    }

    public f.a b(String str) throws IOException, d, c {
        String str2;
        String str3 = "";
        b.C0262b bVar = b.C0262b.ALIAS;
        c(bVar);
        Logger.verbose("Identity alias request:\n" + str);
        if (this.f22469j == null) {
            this.f22469j = b(bVar);
        }
        u c10 = this.f22469j.c();
        c10.a(Integer.valueOf(this.f22465f.o()));
        c10.b(Integer.valueOf(this.f22465f.o()));
        c10.a(Boolean.TRUE);
        c10.a("POST");
        c10.a(HttpHeaders.CONTENT_TYPE, "application/json");
        c10.a("Content-Encoding", "gzip");
        c10.a("User-Agent", this.f22470k);
        a(c10, str);
        try {
            str2 = c10.h().toString();
            try {
                InternalListenerManager.getListener().onNetworkRequestStarted(SdkListener.Endpoint.EVENTS, str2, new org.json.b(str), str);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = str3;
        }
        u a10 = a(b.C0262b.ALIAS, c10, str, false);
        int d10 = a10.d();
        org.json.b bVar2 = new org.json.b();
        if (d10 < 200 || d10 >= 300) {
            bVar2 = MPUtility.getJsonResponse(a10);
            if (bVar2 != null) {
                str3 = bVar2.optString("message");
            }
            Logger.error("Alias Request failed- " + d10 + ": " + str3);
        } else {
            Logger.verbose("Alias Request response: \n " + a10.d() + ": " + a10.f());
        }
        InternalListenerManager.getListener().onNetworkRequestFinished(SdkListener.Endpoint.EVENTS, str2, bVar2, d10);
        return new f.a(d10, str3);
    }

    /* access modifiers changed from: package-private */
    public void c(b.C0262b bVar) throws d {
        if (System.currentTimeMillis() < a(bVar)) {
            throw new d();
        }
    }

    public void b(org.json.b bVar) {
        if (bVar != null) {
            try {
                org.json.b e10 = e();
                Iterator<String> keys = bVar.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    e10.put(next, (Object) bVar.getJSONObject(next));
                }
                this.f22475p = e10;
                this.f22465f.T().b(this.f22475p.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public org.json.b a() {
        try {
            Logger.debug("Starting Segment Network request");
            b.C0262b bVar = b.C0262b.AUDIENCE;
            u c10 = b(bVar).c();
            c10.a(Integer.valueOf(this.f22465f.o()));
            c10.b(Integer.valueOf(this.f22465f.o()));
            c10.a("User-Agent", this.f22470k);
            a(c10, (String) null);
            a(bVar, c10, true);
            if (c10.d() == 403) {
                Logger.error("Segment call forbidden: is Segmentation enabled for your account?");
            }
            org.json.b jsonResponse = MPUtility.getJsonResponse(c10);
            a(jsonResponse);
            return jsonResponse;
        } catch (Exception e10) {
            Logger.error("Segment call failed: " + e10.getMessage());
            return null;
        }
    }

    public int a(String str) throws IOException, d, c {
        b.C0262b bVar = b.C0262b.EVENTS;
        c(bVar);
        d();
        if (this.f22468i == null) {
            this.f22468i = b(bVar);
        }
        u c10 = this.f22468i.c();
        c10.a(Integer.valueOf(this.f22465f.o()));
        c10.b(Integer.valueOf(this.f22465f.o()));
        c10.a(Boolean.TRUE);
        c10.a("POST");
        c10.a(HttpHeaders.CONTENT_TYPE, "application/json");
        c10.a("Content-Encoding", "gzip");
        c10.a("User-Agent", this.f22470k);
        String h10 = this.f22465f.h();
        if (!MPUtility.isEmpty((CharSequence) h10)) {
            c10.a("x-mp-kits", h10);
        }
        String f10 = f();
        if (!MPUtility.isEmpty((CharSequence) f10)) {
            c10.a("x-mp-bundled-kits", f10);
        }
        a(c10, str);
        c(str);
        try {
            InternalListenerManager.getListener().onNetworkRequestStarted(SdkListener.Endpoint.EVENTS, c10.h().toString(), new org.json.b(str), str);
        } catch (Exception unused) {
        }
        a(b.C0262b.EVENTS, c10, str, true);
        Logger.verbose("Upload request attempt:\nURL- " + this.f22468i.toString());
        Logger.verbose(str);
        int d10 = c10.d();
        if (d10 < 200 || d10 >= 300) {
            Logger.error("Upload request failed- " + d10 + ": " + c10.f());
            try {
                InternalListenerManager.getListener().onNetworkRequestFinished(SdkListener.Endpoint.EVENTS, c10.h().b(), new org.json.b().put("message", (Object) c10.f()), d10);
            } catch (Exception unused2) {
            }
        } else {
            org.json.b jsonResponse = MPUtility.getJsonResponse(c10);
            if (InternalListenerManager.isEnabled()) {
                InternalListenerManager.getListener().onNetworkRequestFinished(SdkListener.Endpoint.EVENTS, c10.h().toString(), jsonResponse, d10);
            }
            Logger.verbose("Upload result response: \n" + c10.d() + ": " + c10.f() + "\nresponse:\n" + jsonResponse.toString());
            a(jsonResponse);
        }
        return c10.d();
    }

    /* access modifiers changed from: package-private */
    public void a(u uVar, String str) {
        try {
            String c10 = c();
            uVar.a("Date", c10);
            uVar.a("x-mp-signature", a(uVar, c10, str, this.f22466g));
        } catch (InvalidKeyException unused) {
            Logger.error("Error signing message.");
        } catch (NoSuchAlgorithmException unused2) {
            Logger.error("Error signing message.");
        } catch (UnsupportedEncodingException unused3) {
            Logger.error("Error signing message.");
        }
    }

    private void a(org.json.b bVar) {
        try {
            if (bVar.has("ci")) {
                b(bVar.getJSONObject("ci").optJSONObject("ck"));
            }
        } catch (JSONException unused) {
        }
    }
}
