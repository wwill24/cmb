package q4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.n;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.s;
import com.clevertap.android.sdk.validation.Validator;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.stetho.server.http.HttpHeaders;
import i4.e;
import i4.i;
import i4.x;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import t4.c;
import t4.f;
import t4.g;
import t4.h;
import t4.k;
import t4.m;
import w4.d;

public class b extends a {

    /* renamed from: n  reason: collision with root package name */
    private static SSLSocketFactory f17149n;

    /* renamed from: o  reason: collision with root package name */
    private static SSLContext f17150o;

    /* renamed from: a  reason: collision with root package name */
    private final i4.b f17151a;

    /* renamed from: b  reason: collision with root package name */
    private c f17152b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f17153c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17154d;

    /* renamed from: e  reason: collision with root package name */
    private final i f17155e;

    /* renamed from: f  reason: collision with root package name */
    private final j f17156f;

    /* renamed from: g  reason: collision with root package name */
    private int f17157g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final com.clevertap.android.sdk.db.a f17158h;

    /* renamed from: i  reason: collision with root package name */
    private final l f17159i;

    /* renamed from: j  reason: collision with root package name */
    private final p f17160j;

    /* renamed from: k  reason: collision with root package name */
    private int f17161k = 0;

    /* renamed from: l  reason: collision with root package name */
    private final d f17162l;

    /* renamed from: m  reason: collision with root package name */
    private int f17163m = 0;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f17164a;

        a(Context context) {
            this.f17164a = context;
        }

        /* renamed from: a */
        public Void call() {
            b.this.f17158h.a(this.f17164a);
            return null;
        }
    }

    public b(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, j jVar, d dVar, i iVar, com.clevertap.android.sdk.db.a aVar, i4.b bVar, e eVar, Validator validator, n nVar) {
        CleverTapInstanceConfig cleverTapInstanceConfig2 = cleverTapInstanceConfig;
        l lVar2 = lVar;
        j jVar2 = jVar;
        i iVar2 = iVar;
        i4.b bVar2 = bVar;
        this.f17154d = context;
        this.f17153c = cleverTapInstanceConfig2;
        this.f17159i = lVar2;
        this.f17151a = bVar2;
        this.f17160j = cleverTapInstanceConfig.n();
        this.f17156f = jVar2;
        this.f17162l = dVar;
        this.f17155e = iVar2;
        this.f17158h = aVar;
        CleverTapInstanceConfig cleverTapInstanceConfig3 = cleverTapInstanceConfig;
        C(new t4.b(context, cleverTapInstanceConfig, lVar, this, nVar, new t4.j(new t4.l(new t4.a(new f(new k(new t4.n(new g(new h(new m(new t4.i(new t4.e(), cleverTapInstanceConfig2, bVar2), cleverTapInstanceConfig2, jVar2, iVar2), cleverTapInstanceConfig2, iVar2), cleverTapInstanceConfig2, bVar2, iVar2), context, cleverTapInstanceConfig, aVar, bVar, iVar), cleverTapInstanceConfig3, eVar, bVar2, iVar2), cleverTapInstanceConfig2), cleverTapInstanceConfig3, this, validator, iVar2), cleverTapInstanceConfig2, lVar2, this), cleverTapInstanceConfig2, iVar2, false)));
    }

    private void I(Context context, boolean z10) {
        if (z10) {
            s.n(context, s.s(this.f17153c, "comms_mtd"), (int) (System.currentTimeMillis() / 1000));
            D(context, (String) null);
            com.clevertap.android.sdk.task.a.a(this.f17153c).c().f("CommsManager#setMuted", new a(context));
            return;
        }
        s.n(context, s.s(this.f17153c, "comms_mtd"), 0);
    }

    private org.json.b g() {
        SharedPreferences sharedPreferences;
        try {
            String r10 = r();
            if (r10 == null) {
                return null;
            }
            if (!s.h(this.f17154d, r10).getAll().isEmpty()) {
                sharedPreferences = s.h(this.f17154d, r10);
            } else {
                sharedPreferences = y(r10, q());
            }
            Map<String, ?> all = sharedPreferences.getAll();
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if ((value instanceof Number) && ((Number) value).intValue() == -1) {
                    it.remove();
                }
            }
            org.json.b bVar = new org.json.b((Map<?, ?>) all);
            p pVar = this.f17160j;
            String e10 = this.f17153c.e();
            pVar.t(e10, "Fetched ARP for namespace key: " + r10 + " values: " + all.toString());
            return bVar;
        } catch (Throwable th2) {
            this.f17160j.u(this.f17153c.e(), "Failed to construct ARP object", th2);
            return null;
        }
    }

    private long n() {
        return s.f(this.f17154d, this.f17153c, "comms_i", 0, "IJ");
    }

    private long o() {
        return s.f(this.f17154d, this.f17153c, "comms_j", 0, "IJ");
    }

    private String q() {
        String e10 = this.f17153c.e();
        if (e10 == null) {
            return null;
        }
        p pVar = this.f17160j;
        String e11 = this.f17153c.e();
        pVar.t(e11, "Old ARP Key = ARP:" + e10);
        return "ARP:" + e10;
    }

    private static SSLSocketFactory s(SSLContext sSLContext) {
        if (sSLContext == null) {
            return null;
        }
        if (f17149n == null) {
            try {
                f17149n = sSLContext.getSocketFactory();
                p.a("Pinning SSL session to DigiCertGlobalRoot CA certificate");
            } catch (Throwable th2) {
                p.d("Issue in pinning SSL,", th2);
            }
        }
        return f17149n;
    }

    private static synchronized SSLContext t() {
        SSLContext sSLContext;
        synchronized (b.class) {
            if (f17150o == null) {
                f17150o = new c().a();
            }
            sSLContext = f17150o;
        }
        return sSLContext;
    }

    public static boolean x(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private SharedPreferences y(String str, String str2) {
        SharedPreferences h10 = s.h(this.f17154d, str2);
        SharedPreferences h11 = s.h(this.f17154d, str);
        SharedPreferences.Editor edit = h11.edit();
        for (Map.Entry next : h10.getAll().entrySet()) {
            Object value = next.getValue();
            if (value instanceof Number) {
                edit.putInt((String) next.getKey(), ((Number) value).intValue());
            } else if (value instanceof String) {
                String str3 = (String) value;
                if (str3.length() < 100) {
                    edit.putString((String) next.getKey(), str3);
                } else {
                    p pVar = this.f17160j;
                    String e10 = this.f17153c.e();
                    pVar.t(e10, "ARP update for key " + ((String) next.getKey()) + " rejected (string value too long)");
                }
            } else if (value instanceof Boolean) {
                edit.putBoolean((String) next.getKey(), ((Boolean) value).booleanValue());
            } else {
                p pVar2 = this.f17160j;
                String e11 = this.f17153c.e();
                pVar2.t(e11, "ARP update for key " + ((String) next.getKey()) + " rejected (invalid data type)");
            }
        }
        p pVar3 = this.f17160j;
        String e12 = this.f17153c.e();
        pVar3.t(e12, "Completed ARP update for namespace key: " + str + "");
        s.l(edit);
        h10.edit().clear().apply();
        return h11;
    }

    /* access modifiers changed from: package-private */
    public boolean A(Context context, HttpsURLConnection httpsURLConnection) {
        String headerField = httpsURLConnection.getHeaderField("X-WZRK-MUTE");
        if (headerField != null && headerField.trim().length() > 0) {
            if (headerField.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                I(context, true);
                return false;
            }
            I(context, false);
        }
        String headerField2 = httpsURLConnection.getHeaderField("X-WZRK-RD");
        p.o("Getting domain from header - " + headerField2);
        if (!(headerField2 == null || headerField2.trim().length() == 0)) {
            String headerField3 = httpsURLConnection.getHeaderField("X-WZRK-SPIKY-RD");
            p.o("Getting spiky domain from header - " + headerField3);
            I(context, false);
            D(context, headerField2);
            p.o("Setting spiky domain from header as -" + headerField3);
            if (headerField3 == null) {
                K(context, headerField2);
            } else {
                K(context, headerField3);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01fa A[SYNTHETIC, Splitter:B:72:0x01fa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean B(android.content.Context r11, com.clevertap.android.sdk.events.EventGroup r12, org.json.a r13) {
        /*
            r10 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0213
            int r1 = r13.o()
            if (r1 > 0) goto L_0x000b
            goto L_0x0213
        L_0x000b:
            com.clevertap.android.sdk.l r1 = r10.f17159i
            java.lang.String r1 = r1.x()
            if (r1 != 0) goto L_0x0021
            com.clevertap.android.sdk.p r11 = r10.f17160j
            com.clevertap.android.sdk.CleverTapInstanceConfig r12 = r10.f17153c
            java.lang.String r12 = r12.e()
            java.lang.String r13 = "CleverTap Id not finalized, unable to send queue"
            r11.f(r12, r13)
            return r0
        L_0x0021:
            r1 = 0
            r2 = 1
            java.lang.String r3 = r10.l(r0, r12)     // Catch:{ all -> 0x01d7 }
            if (r3 != 0) goto L_0x0037
            com.clevertap.android.sdk.p r12 = r10.f17160j     // Catch:{ all -> 0x01d7 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.f17153c     // Catch:{ all -> 0x01d7 }
            java.lang.String r13 = r13.e()     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "Problem configuring queue endpoint, unable to send queue"
            r12.f(r13, r3)     // Catch:{ all -> 0x01d7 }
            return r0
        L_0x0037:
            javax.net.ssl.HttpsURLConnection r4 = r10.f(r3)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = r10.w(r11, r13)     // Catch:{ all -> 0x01d4 }
            if (r5 != 0) goto L_0x005b
            com.clevertap.android.sdk.p r12 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.e()     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "Problem configuring queue request, unable to send queue"
            r12.f(r13, r1)     // Catch:{ all -> 0x01d4 }
            if (r4 == 0) goto L_0x005a
            java.io.InputStream r11 = r4.getInputStream()     // Catch:{ all -> 0x005a }
            r11.close()     // Catch:{ all -> 0x005a }
            r4.disconnect()     // Catch:{ all -> 0x005a }
        L_0x005a:
            return r0
        L_0x005b:
            com.clevertap.android.sdk.p r6 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r7 = r7.e()     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r8.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r9 = "Send queue contains "
            r8.append(r9)     // Catch:{ all -> 0x01d4 }
            int r9 = r13.o()     // Catch:{ all -> 0x01d4 }
            r8.append(r9)     // Catch:{ all -> 0x01d4 }
            java.lang.String r9 = " items: "
            r8.append(r9)     // Catch:{ all -> 0x01d4 }
            r8.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01d4 }
            r6.f(r7, r8)     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.p r6 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r7 = r7.e()     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r8.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r9 = "Sending queue to: "
            r8.append(r9)     // Catch:{ all -> 0x01d4 }
            r8.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x01d4 }
            r6.f(r7, r3)     // Catch:{ all -> 0x01d4 }
            r4.setDoOutput(r2)     // Catch:{ all -> 0x01d4 }
            java.io.OutputStream r3 = r4.getOutputStream()     // Catch:{ all -> 0x01d4 }
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ all -> 0x01d4 }
            r3.write(r5)     // Catch:{ all -> 0x01d4 }
            int r3 = r4.getResponseCode()     // Catch:{ all -> 0x01d4 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 != r5) goto L_0x01bd
            java.lang.String r3 = "X-WZRK-RD"
            java.lang.String r3 = r4.getHeaderField(r3)     // Catch:{ all -> 0x01d4 }
            if (r3 == 0) goto L_0x00fe
            java.lang.String r5 = r3.trim()     // Catch:{ all -> 0x01d4 }
            int r5 = r5.length()     // Catch:{ all -> 0x01d4 }
            if (r5 <= 0) goto L_0x00fe
            boolean r5 = r10.u(r3)     // Catch:{ all -> 0x01d4 }
            if (r5 == 0) goto L_0x00fe
            r10.D(r11, r3)     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.p r12 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.e()     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "The domain has changed to "
            r1.append(r5)     // Catch:{ all -> 0x01d4 }
            r1.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = ". The request will be retried shortly."
            r1.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            r12.f(r13, r1)     // Catch:{ all -> 0x01d4 }
            java.io.InputStream r11 = r4.getInputStream()     // Catch:{ all -> 0x00fd }
            r11.close()     // Catch:{ all -> 0x00fd }
            r4.disconnect()     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            return r0
        L_0x00fe:
            boolean r3 = r10.A(r11, r4)     // Catch:{ all -> 0x01d4 }
            if (r3 == 0) goto L_0x0130
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x01d4 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x01d4 }
            java.io.InputStream r6 = r4.getInputStream()     // Catch:{ all -> 0x01d4 }
            java.lang.String r7 = "utf-8"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x01d4 }
            r3.<init>(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r5.<init>()     // Catch:{ all -> 0x01d4 }
        L_0x0119:
            java.lang.String r6 = r3.readLine()     // Catch:{ all -> 0x01d4 }
            if (r6 == 0) goto L_0x0123
            r5.append(r6)     // Catch:{ all -> 0x01d4 }
            goto L_0x0119
        L_0x0123:
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x01d4 }
            t4.c r5 = r10.h()     // Catch:{ all -> 0x01d4 }
            android.content.Context r6 = r10.f17154d     // Catch:{ all -> 0x01d4 }
            r5.a(r1, r3, r6)     // Catch:{ all -> 0x01d4 }
        L_0x0130:
            int r1 = r10.i()     // Catch:{ all -> 0x01d4 }
            r10.H(r1)     // Catch:{ all -> 0x01d4 }
            int r1 = r10.i()     // Catch:{ all -> 0x01d4 }
            r10.E(r1)     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.events.EventGroup r1 = com.clevertap.android.sdk.events.EventGroup.PUSH_NOTIFICATION_VIEWED     // Catch:{ all -> 0x01d4 }
            if (r12 != r1) goto L_0x01a1
            int r12 = r13.o()     // Catch:{ all -> 0x01d4 }
            int r12 = r12 - r2
            org.json.b r12 = r13.j(r12)     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = "evtData"
            org.json.b r12 = r12.optJSONObject(r13)     // Catch:{ all -> 0x01d4 }
            if (r12 == 0) goto L_0x0194
            java.lang.String r13 = "wzrk_pid"
            java.lang.String r12 = r12.optString(r13)     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.j r13 = r10.f17156f     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.n()     // Catch:{ all -> 0x01d4 }
            if (r13 == 0) goto L_0x0194
            com.clevertap.android.sdk.j r13 = r10.f17156f     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.n()     // Catch:{ all -> 0x01d4 }
            boolean r13 = r13.equals(r12)     // Catch:{ all -> 0x01d4 }
            if (r13 == 0) goto L_0x0194
            i4.b r13 = r10.f17151a     // Catch:{ all -> 0x01d4 }
            o4.e r13 = r13.h()     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.p r1 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r5.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r6 = "push notification viewed event sent successfully for push id = "
            r5.append(r6)     // Catch:{ all -> 0x01d4 }
            r5.append(r12)     // Catch:{ all -> 0x01d4 }
            java.lang.String r12 = r5.toString()     // Catch:{ all -> 0x01d4 }
            r1.t(r3, r12)     // Catch:{ all -> 0x01d4 }
            if (r13 == 0) goto L_0x0194
            r13.a(r2)     // Catch:{ all -> 0x01d4 }
        L_0x0194:
            com.clevertap.android.sdk.p r12 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.e()     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "push notification viewed event sent successfully"
            r12.t(r13, r1)     // Catch:{ all -> 0x01d4 }
        L_0x01a1:
            com.clevertap.android.sdk.p r12 = r10.f17160j     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r10.f17153c     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.e()     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "Queue sent successfully"
            r12.f(r13, r1)     // Catch:{ all -> 0x01d4 }
            r10.f17163m = r0     // Catch:{ all -> 0x01d4 }
            r10.f17161k = r0     // Catch:{ all -> 0x01d4 }
            java.io.InputStream r11 = r4.getInputStream()     // Catch:{ all -> 0x01bc }
            r11.close()     // Catch:{ all -> 0x01bc }
            r4.disconnect()     // Catch:{ all -> 0x01bc }
        L_0x01bc:
            return r2
        L_0x01bd:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r13.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "Response code is not 200. It is "
            r13.append(r1)     // Catch:{ all -> 0x01d4 }
            r13.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01d4 }
            r12.<init>(r13)     // Catch:{ all -> 0x01d4 }
            throw r12     // Catch:{ all -> 0x01d4 }
        L_0x01d4:
            r12 = move-exception
            r1 = r4
            goto L_0x01d8
        L_0x01d7:
            r12 = move-exception
        L_0x01d8:
            com.clevertap.android.sdk.p r13 = r10.f17160j     // Catch:{ all -> 0x0205 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r10.f17153c     // Catch:{ all -> 0x0205 }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x0205 }
            java.lang.String r4 = "An exception occurred while sending the queue, will retry: "
            r13.g(r3, r4, r12)     // Catch:{ all -> 0x0205 }
            int r12 = r10.f17163m     // Catch:{ all -> 0x0205 }
            int r12 = r12 + r2
            r10.f17163m = r12     // Catch:{ all -> 0x0205 }
            int r12 = r10.f17161k     // Catch:{ all -> 0x0205 }
            int r12 = r12 + r2
            r10.f17161k = r12     // Catch:{ all -> 0x0205 }
            i4.b r12 = r10.f17151a     // Catch:{ all -> 0x0205 }
            i4.m r12 = r12.c()     // Catch:{ all -> 0x0205 }
            r12.a(r11)     // Catch:{ all -> 0x0205 }
            if (r1 == 0) goto L_0x0204
            java.io.InputStream r11 = r1.getInputStream()     // Catch:{ all -> 0x0204 }
            r11.close()     // Catch:{ all -> 0x0204 }
            r1.disconnect()     // Catch:{ all -> 0x0204 }
        L_0x0204:
            return r0
        L_0x0205:
            r11 = move-exception
            if (r1 == 0) goto L_0x0212
            java.io.InputStream r12 = r1.getInputStream()     // Catch:{ all -> 0x0212 }
            r12.close()     // Catch:{ all -> 0x0212 }
            r1.disconnect()     // Catch:{ all -> 0x0212 }
        L_0x0212:
            throw r11
        L_0x0213:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.b.B(android.content.Context, com.clevertap.android.sdk.events.EventGroup, org.json.a):boolean");
    }

    /* access modifiers changed from: package-private */
    public void C(c cVar) {
        this.f17152b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void D(Context context, String str) {
        p pVar = this.f17160j;
        String e10 = this.f17153c.e();
        pVar.t(e10, "Setting domain to " + str);
        s.p(context, s.s(this.f17153c, "comms_dmn"), str);
        if (this.f17151a.m() == null) {
            return;
        }
        if (str != null) {
            this.f17151a.m().a(x.q(str));
        } else {
            this.f17151a.m().b();
        }
    }

    /* access modifiers changed from: package-private */
    public void E(int i10) {
        if (m() <= 0) {
            s.n(this.f17154d, s.s(this.f17153c, "comms_first_ts"), i10);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public void F(Context context, long j10) {
        SharedPreferences.Editor edit = s.h(context, "IJ").edit();
        edit.putLong(s.s(this.f17153c, "comms_i"), j10);
        s.l(edit);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void G(Context context, long j10) {
        SharedPreferences.Editor edit = s.h(context, "IJ").edit();
        edit.putLong(s.s(this.f17153c, "comms_j"), j10);
        s.l(edit);
    }

    /* access modifiers changed from: package-private */
    public void H(int i10) {
        s.n(this.f17154d, s.s(this.f17153c, "comms_last_ts"), i10);
    }

    /* access modifiers changed from: package-private */
    public void J(int i10) {
        this.f17163m = i10;
    }

    /* access modifiers changed from: package-private */
    public void K(Context context, String str) {
        p pVar = this.f17160j;
        String e10 = this.f17153c.e();
        pVar.t(e10, "Setting spiky domain to " + str);
        s.p(context, s.s(this.f17153c, "comms_dmn_spiky"), str);
    }

    public void a(Context context, EventGroup eventGroup) {
        this.f17153c.n().t(this.f17153c.e(), "Somebody has invoked me to send the queue to CleverTap servers");
        com.clevertap.android.sdk.db.c cVar = null;
        boolean z10 = true;
        while (z10) {
            cVar = this.f17158h.b(context, 50, cVar, eventGroup);
            if (cVar == null || cVar.d().booleanValue()) {
                this.f17153c.n().t(this.f17153c.e(), "No events in the queue, failing");
                return;
            }
            org.json.a a10 = cVar.a();
            if (a10 == null || a10.o() <= 0) {
                this.f17153c.n().t(this.f17153c.e(), "No events in the queue, failing");
                return;
            }
            z10 = B(context, eventGroup, a10);
        }
    }

    public int b() {
        p pVar = this.f17160j;
        String e10 = this.f17153c.e();
        pVar.f(e10, "Network retry #" + this.f17161k);
        if (this.f17161k < 10) {
            p pVar2 = this.f17160j;
            String e11 = this.f17153c.e();
            pVar2.f(e11, "Failure count is " + this.f17161k + ". Setting delay frequency to 1s");
            return 1000;
        } else if (this.f17153c.f() == null) {
            this.f17160j.f(this.f17153c.e(), "Setting delay frequency to 1s");
            return 1000;
        } else {
            int nextInt = ((new SecureRandom().nextInt(10) + 1) * 1000) + 0;
            if (nextInt < 600000) {
                p pVar3 = this.f17160j;
                String e12 = this.f17153c.e();
                pVar3.f(e12, "Setting delay frequency to " + nextInt);
                return nextInt;
            }
            p pVar4 = this.f17160j;
            String e13 = this.f17153c.e();
            pVar4.f(e13, "Setting delay frequency to " + 1000);
            return 1000;
        }
    }

    public void c(EventGroup eventGroup, Runnable runnable) {
        this.f17163m = 0;
        z(this.f17154d, eventGroup, runnable);
    }

    public boolean d(EventGroup eventGroup) {
        boolean z10;
        String k10 = k(eventGroup);
        if (this.f17163m > 5) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            D(this.f17154d, (String) null);
        }
        if (k10 == null || z10) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public HttpsURLConnection f(String str) throws IOException {
        SSLContext t10;
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        httpsURLConnection.setRequestProperty("X-CleverTap-Account-ID", this.f17153c.e());
        httpsURLConnection.setRequestProperty("X-CleverTap-Token", this.f17153c.g());
        httpsURLConnection.setInstanceFollowRedirects(false);
        if (this.f17153c.x() && (t10 = t()) != null) {
            httpsURLConnection.setSSLSocketFactory(s(t10));
        }
        return httpsURLConnection;
    }

    /* access modifiers changed from: package-private */
    public c h() {
        return this.f17152b;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f17157g;
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z10, EventGroup eventGroup) {
        boolean z11;
        String k10 = k(eventGroup);
        if (k10 == null || k10.trim().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && !z10) {
            return null;
        }
        if (z11) {
            return "wzrkt.com/hello";
        }
        return k10 + "/a1";
    }

    public String k(EventGroup eventGroup) {
        try {
            String f10 = this.f17153c.f();
            if (f10 != null && f10.trim().length() > 0) {
                J(0);
                if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
                    return f10.trim().toLowerCase() + eventGroup.httpResource + "." + "wzrkt.com";
                }
                return f10.trim().toLowerCase() + "." + "wzrkt.com";
            }
        } catch (Throwable unused) {
        }
        if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
            return s.k(this.f17154d, this.f17153c, "comms_dmn_spiky", (String) null);
        }
        return s.k(this.f17154d, this.f17153c, "comms_dmn", (String) null);
    }

    /* access modifiers changed from: package-private */
    public String l(boolean z10, EventGroup eventGroup) {
        String j10 = j(z10, eventGroup);
        if (j10 == null) {
            this.f17160j.t(this.f17153c.e(), "Unable to configure endpoint, domain is null");
            return null;
        }
        String e10 = this.f17153c.e();
        if (e10 == null) {
            this.f17160j.t(this.f17153c.e(), "Unable to configure endpoint, accountID is null");
            return null;
        }
        String str = ("https://" + j10 + "?os=Android&t=" + this.f17159i.L()) + "&z=" + e10;
        if (d(eventGroup)) {
            return str;
        }
        this.f17157g = (int) (System.currentTimeMillis() / 1000);
        return str + "&ts=" + i();
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return s.d(this.f17154d, this.f17153c, "comms_first_ts", 0);
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return s.d(this.f17154d, this.f17153c, "comms_last_ts", 0);
    }

    public String r() {
        String e10 = this.f17153c.e();
        if (e10 == null) {
            return null;
        }
        p pVar = this.f17160j;
        String e11 = this.f17153c.e();
        pVar.t(e11, "New ARP Key = ARP:" + e10 + CertificateUtil.DELIMITER + this.f17159i.x());
        return "ARP:" + e10 + CertificateUtil.DELIMITER + this.f17159i.x();
    }

    /* access modifiers changed from: package-private */
    public boolean u(String str) {
        return !str.equals(s.k(this.f17154d, this.f17153c, "comms_dmn", (String) null));
    }

    public void v() {
        this.f17163m++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec A[Catch:{ all -> 0x0147, all -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010f A[Catch:{ all -> 0x0147, all -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0162 A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016f A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x017c A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0187 A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b6 A[Catch:{ all -> 0x0147, all -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c5 A[Catch:{ all -> 0x0147, all -> 0x0207 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String w(android.content.Context r8, org.json.a r9) {
        /*
            r7 = this;
            org.json.b r0 = new org.json.b     // Catch:{ all -> 0x0207 }
            r0.<init>()     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.l r1 = r7.f17159i     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = r1.x()     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x001b
            java.lang.String r2 = ""
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0207 }
            if (r2 != 0) goto L_0x001b
            java.lang.String r2 = "g"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0207 }
            goto L_0x0028
        L_0x001b:
            com.clevertap.android.sdk.p r1 = r7.f17160j     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x0207 }
            java.lang.String r3 = "CRITICAL: Couldn't finalise on a device ID! Using error device ID instead!"
            r1.t(r2, r3)     // Catch:{ all -> 0x0207 }
        L_0x0028:
            java.lang.String r1 = "type"
            java.lang.String r2 = "meta"
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.l r1 = r7.f17159i     // Catch:{ all -> 0x0207 }
            org.json.b r1 = r1.o()     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = "af"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            java.util.HashMap r1 = r1.f()     // Catch:{ all -> 0x0207 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0207 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0207 }
        L_0x0048:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0207 }
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0207 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0207 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0207 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0207 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x0207 }
            goto L_0x0048
        L_0x0062:
            long r1 = r7.n()     // Catch:{ all -> 0x0207 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0071
            java.lang.String r5 = "_i"
            r0.put((java.lang.String) r5, (long) r1)     // Catch:{ all -> 0x0207 }
        L_0x0071:
            long r1 = r7.o()     // Catch:{ all -> 0x0207 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x007e
            java.lang.String r3 = "_j"
            r0.put((java.lang.String) r3, (long) r1)     // Catch:{ all -> 0x0207 }
        L_0x007e:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = r1.e()     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = r2.g()     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x01f8
            if (r2 != 0) goto L_0x0090
            goto L_0x01f8
        L_0x0090:
            java.lang.String r3 = "id"
            r0.put((java.lang.String) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "tk"
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "l_ts"
            int r2 = r7.p()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "f_ts"
            int r2 = r7.m()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "ct_pi"
            android.content.Context r2 = r7.f17154d     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r7.f17153c     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.l r4 = r7.f17159i     // Catch:{ all -> 0x0207 }
            w4.d r5 = r7.f17162l     // Catch:{ all -> 0x0207 }
            p4.b r2 = p4.c.a(r2, r3, r4, r5)     // Catch:{ all -> 0x0207 }
            p4.d r2 = r2.b()     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "ddnd"
            com.clevertap.android.sdk.l r2 = r7.f17159i     // Catch:{ all -> 0x0207 }
            boolean r2 = r2.I()     // Catch:{ all -> 0x0207 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x00e0
            i4.i r2 = r7.f17155e     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.pushnotification.j r2 = r2.i()     // Catch:{ all -> 0x0207 }
            boolean r2 = r2.G()     // Catch:{ all -> 0x0207 }
            if (r2 != 0) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r2 = r3
            goto L_0x00e1
        L_0x00e0:
            r2 = r4
        L_0x00e1:
            r0.put((java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            boolean r1 = r1.z()     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = "bk"
            r0.put((java.lang.String) r1, (int) r4)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            r1.L(r3)     // Catch:{ all -> 0x0207 }
        L_0x00f6:
            java.lang.String r1 = "rtl"
            com.clevertap.android.sdk.db.a r2 = r7.f17158h     // Catch:{ all -> 0x0207 }
            android.content.Context r5 = r7.f17154d     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.db.DBAdapter r2 = r2.c(r5)     // Catch:{ all -> 0x0207 }
            org.json.a r2 = v4.a.d(r2)     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            boolean r1 = r1.D()     // Catch:{ all -> 0x0207 }
            if (r1 != 0) goto L_0x0125
            java.lang.String r1 = "rct"
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x0207 }
            long r5 = r2.r()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (long) r5)     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "ait"
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x0207 }
            long r5 = r2.g()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (long) r5)     // Catch:{ all -> 0x0207 }
        L_0x0125:
            java.lang.String r1 = "frs"
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x0207 }
            boolean r2 = r2.B()     // Catch:{ all -> 0x0207 }
            r0.put((java.lang.String) r1, (boolean) r2)     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            r1.Q(r3)     // Catch:{ all -> 0x0207 }
            org.json.b r1 = r7.g()     // Catch:{ all -> 0x0147 }
            if (r1 == 0) goto L_0x0155
            int r2 = r1.length()     // Catch:{ all -> 0x0147 }
            if (r2 <= 0) goto L_0x0155
            java.lang.String r2 = "arp"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0147 }
            goto L_0x0155
        L_0x0147:
            r1 = move-exception
            com.clevertap.android.sdk.p r2 = r7.f17160j     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x0207 }
            java.lang.String r5 = "Failed to attach ARP"
            r2.u(r3, r5, r1)     // Catch:{ all -> 0x0207 }
        L_0x0155:
            org.json.b r1 = new org.json.b     // Catch:{ all -> 0x0207 }
            r1.<init>()     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x018d }
            java.lang.String r2 = r2.t()     // Catch:{ all -> 0x018d }
            if (r2 == 0) goto L_0x0167
            java.lang.String r3 = "us"
            r1.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x018d }
        L_0x0167:
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x018d }
            java.lang.String r2 = r2.q()     // Catch:{ all -> 0x018d }
            if (r2 == 0) goto L_0x0174
            java.lang.String r3 = "um"
            r1.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x018d }
        L_0x0174:
            com.clevertap.android.sdk.j r2 = r7.f17156f     // Catch:{ all -> 0x018d }
            java.lang.String r2 = r2.h()     // Catch:{ all -> 0x018d }
            if (r2 == 0) goto L_0x0181
            java.lang.String r3 = "uc"
            r1.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x018d }
        L_0x0181:
            int r2 = r1.length()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x019b
            java.lang.String r2 = "ref"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x018d }
            goto L_0x019b
        L_0x018d:
            r1 = move-exception
            com.clevertap.android.sdk.p r2 = r7.f17160j     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x0207 }
            java.lang.String r5 = "Failed to attach ref"
            r2.u(r3, r5, r1)     // Catch:{ all -> 0x0207 }
        L_0x019b:
            com.clevertap.android.sdk.j r1 = r7.f17156f     // Catch:{ all -> 0x0207 }
            org.json.b r1 = r1.u()     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x01ae
            int r2 = r1.length()     // Catch:{ all -> 0x0207 }
            if (r2 <= 0) goto L_0x01ae
            java.lang.String r2 = "wzrk_ref"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0207 }
        L_0x01ae:
            i4.i r1 = r7.f17155e     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.m r1 = r1.h()     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x01c5
            java.lang.String r1 = "Attaching InAppFC to Header"
            com.clevertap.android.sdk.p.o(r1)     // Catch:{ all -> 0x0207 }
            i4.i r1 = r7.f17155e     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.m r1 = r1.h()     // Catch:{ all -> 0x0207 }
            r1.c(r8, r0)     // Catch:{ all -> 0x0207 }
            goto L_0x01d2
        L_0x01c5:
            com.clevertap.android.sdk.p r8 = r7.f17160j     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = r1.e()     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = "controllerManager.getInAppFCManager() is NULL, not Attaching InAppFC to Header"
            r8.t(r1, r2)     // Catch:{ all -> 0x0207 }
        L_0x01d2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0207 }
            r8.<init>()     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "["
            r8.append(r1)     // Catch:{ all -> 0x0207 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0207 }
            r8.append(r0)     // Catch:{ all -> 0x0207 }
            java.lang.String r0 = ", "
            r8.append(r0)     // Catch:{ all -> 0x0207 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0207 }
            java.lang.String r0 = r0.substring(r4)     // Catch:{ all -> 0x0207 }
            r8.append(r0)     // Catch:{ all -> 0x0207 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0207 }
            return r8
        L_0x01f8:
            com.clevertap.android.sdk.p r8 = r7.f17160j     // Catch:{ all -> 0x0207 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r7.f17153c     // Catch:{ all -> 0x0207 }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x0207 }
            java.lang.String r1 = "Account ID/token not found, unable to configure queue request"
            r8.f(r0, r1)     // Catch:{ all -> 0x0207 }
            r8 = 0
            return r8
        L_0x0207:
            r8 = move-exception
            com.clevertap.android.sdk.p r0 = r7.f17160j
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.f17153c
            java.lang.String r1 = r1.e()
            java.lang.String r2 = "CommsManager: Failed to attach header"
            r0.u(r1, r2, r8)
            java.lang.String r8 = r9.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.b.w(android.content.Context, org.json.a):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void z(Context context, EventGroup eventGroup, Runnable runnable) {
        InputStream inputStream;
        String l10 = l(true, eventGroup);
        if (l10 == null) {
            this.f17160j.t(this.f17153c.e(), "Unable to perform handshake, endpoint is null");
        }
        p pVar = this.f17160j;
        String e10 = this.f17153c.e();
        pVar.t(e10, "Performing handshake with " + l10);
        HttpsURLConnection httpsURLConnection = null;
        try {
            httpsURLConnection = f(l10);
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode != 200) {
                p pVar2 = this.f17160j;
                String e11 = this.f17153c.e();
                pVar2.t(e11, "Invalid HTTP status code received for handshake - " + responseCode);
                try {
                    httpsURLConnection.getInputStream().close();
                    httpsURLConnection.disconnect();
                } catch (Throwable unused) {
                }
            } else {
                this.f17160j.t(this.f17153c.e(), "Received success from handshake :)");
                if (A(context, httpsURLConnection)) {
                    this.f17160j.t(this.f17153c.e(), "We are not muted");
                    runnable.run();
                }
                inputStream = httpsURLConnection.getInputStream();
                inputStream.close();
                httpsURLConnection.disconnect();
            }
        } catch (Throwable unused2) {
        }
    }
}
