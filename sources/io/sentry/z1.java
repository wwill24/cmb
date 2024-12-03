package io.sentry;

import com.coffeemeetsbagel.models.constants.Extra;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.a2;
import io.sentry.profilemeasurements.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class z1 implements c1 {
    /* access modifiers changed from: private */
    public String B;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public String F;
    /* access modifiers changed from: private */
    public final Map<String, io.sentry.profilemeasurements.a> G;
    /* access modifiers changed from: private */
    public String H;
    private Map<String, Object> I;

    /* renamed from: a  reason: collision with root package name */
    private final File f31820a;

    /* renamed from: b  reason: collision with root package name */
    private final Callable<List<Integer>> f31821b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f31822c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31823d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31824e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31825f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f31826g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f31827h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f31828j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f31829k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f31830l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public List<Integer> f31831m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f31832n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f31833p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f31834q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public List<a2> f31835t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f31836w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public String f31837x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public String f31838y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public String f31839z;

    public static final class b implements s0<z1> {
        /* renamed from: b */
        public z1 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            z1 z1Var = new z1();
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -2133529830:
                        if (y10.equals("device_manufacturer")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1981468849:
                        if (y10.equals("android_api_level")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1430655860:
                        if (y10.equals("build_id")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1172160413:
                        if (y10.equals("device_locale")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1102636175:
                        if (y10.equals(Extra.PROFILE_ID)) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -716656436:
                        if (y10.equals("device_os_build_number")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -591076352:
                        if (y10.equals("device_model")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -512511455:
                        if (y10.equals("device_is_emulator")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -478065584:
                        if (y10.equals("duration_ns")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case -362243017:
                        if (y10.equals("measurements")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case -332426004:
                        if (y10.equals("device_physical_memory_bytes")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case -212264198:
                        if (y10.equals("device_cpu_frequencies")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case -102985484:
                        if (y10.equals("version_code")) {
                            c10 = 12;
                            break;
                        }
                        break;
                    case -102670958:
                        if (y10.equals("version_name")) {
                            c10 = 13;
                            break;
                        }
                        break;
                    case -85904877:
                        if (y10.equals("environment")) {
                            c10 = 14;
                            break;
                        }
                        break;
                    case 508853068:
                        if (y10.equals("transaction_name")) {
                            c10 = 15;
                            break;
                        }
                        break;
                    case 796476189:
                        if (y10.equals("device_os_name")) {
                            c10 = 16;
                            break;
                        }
                        break;
                    case 839674195:
                        if (y10.equals("architecture")) {
                            c10 = 17;
                            break;
                        }
                        break;
                    case 1010584092:
                        if (y10.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                            c10 = 18;
                            break;
                        }
                        break;
                    case 1052553990:
                        if (y10.equals("device_os_version")) {
                            c10 = 19;
                            break;
                        }
                        break;
                    case 1163928186:
                        if (y10.equals("truncation_reason")) {
                            c10 = 20;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (y10.equals("trace_id")) {
                            c10 = 21;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (y10.equals("platform")) {
                            c10 = 22;
                            break;
                        }
                        break;
                    case 1953158756:
                        if (y10.equals("sampled_profile")) {
                            c10 = 23;
                            break;
                        }
                        break;
                    case 1954122069:
                        if (y10.equals("transactions")) {
                            c10 = 24;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String H0 = y0Var.H0();
                        if (H0 == null) {
                            break;
                        } else {
                            String unused = z1Var.f31824e = H0;
                            break;
                        }
                    case 1:
                        Integer u02 = y0Var.u0();
                        if (u02 == null) {
                            break;
                        } else {
                            int unused2 = z1Var.f31822c = u02.intValue();
                            break;
                        }
                    case 2:
                        String H02 = y0Var.H0();
                        if (H02 == null) {
                            break;
                        } else {
                            String unused3 = z1Var.f31834q = H02;
                            break;
                        }
                    case 3:
                        String H03 = y0Var.H0();
                        if (H03 == null) {
                            break;
                        } else {
                            String unused4 = z1Var.f31823d = H03;
                            break;
                        }
                    case 4:
                        String H04 = y0Var.H0();
                        if (H04 == null) {
                            break;
                        } else {
                            String unused5 = z1Var.D = H04;
                            break;
                        }
                    case 5:
                        String H05 = y0Var.H0();
                        if (H05 == null) {
                            break;
                        } else {
                            String unused6 = z1Var.f31826g = H05;
                            break;
                        }
                    case 6:
                        String H06 = y0Var.H0();
                        if (H06 == null) {
                            break;
                        } else {
                            String unused7 = z1Var.f31825f = H06;
                            break;
                        }
                    case 7:
                        Boolean m02 = y0Var.m0();
                        if (m02 == null) {
                            break;
                        } else {
                            boolean unused8 = z1Var.f31829k = m02.booleanValue();
                            break;
                        }
                    case 8:
                        String H07 = y0Var.H0();
                        if (H07 == null) {
                            break;
                        } else {
                            String unused9 = z1Var.f31837x = H07;
                            break;
                        }
                    case 9:
                        Map A0 = y0Var.A0(h0Var, new a.C0360a());
                        if (A0 == null) {
                            break;
                        } else {
                            z1Var.G.putAll(A0);
                            break;
                        }
                    case 10:
                        String H08 = y0Var.H0();
                        if (H08 == null) {
                            break;
                        } else {
                            String unused10 = z1Var.f31832n = H08;
                            break;
                        }
                    case 11:
                        List list = (List) y0Var.B0();
                        if (list == null) {
                            break;
                        } else {
                            List unused11 = z1Var.f31831m = list;
                            break;
                        }
                    case 12:
                        String H09 = y0Var.H0();
                        if (H09 == null) {
                            break;
                        } else {
                            String unused12 = z1Var.f31838y = H09;
                            break;
                        }
                    case 13:
                        String H010 = y0Var.H0();
                        if (H010 == null) {
                            break;
                        } else {
                            String unused13 = z1Var.f31839z = H010;
                            break;
                        }
                    case 14:
                        String H011 = y0Var.H0();
                        if (H011 == null) {
                            break;
                        } else {
                            String unused14 = z1Var.E = H011;
                            break;
                        }
                    case 15:
                        String H012 = y0Var.H0();
                        if (H012 == null) {
                            break;
                        } else {
                            String unused15 = z1Var.f31836w = H012;
                            break;
                        }
                    case 16:
                        String H013 = y0Var.H0();
                        if (H013 == null) {
                            break;
                        } else {
                            String unused16 = z1Var.f31827h = H013;
                            break;
                        }
                    case 17:
                        String H014 = y0Var.H0();
                        if (H014 == null) {
                            break;
                        } else {
                            String unused17 = z1Var.f31830l = H014;
                            break;
                        }
                    case 18:
                        String H015 = y0Var.H0();
                        if (H015 == null) {
                            break;
                        } else {
                            String unused18 = z1Var.B = H015;
                            break;
                        }
                    case 19:
                        String H016 = y0Var.H0();
                        if (H016 == null) {
                            break;
                        } else {
                            String unused19 = z1Var.f31828j = H016;
                            break;
                        }
                    case 20:
                        String H017 = y0Var.H0();
                        if (H017 == null) {
                            break;
                        } else {
                            String unused20 = z1Var.F = H017;
                            break;
                        }
                    case 21:
                        String H018 = y0Var.H0();
                        if (H018 == null) {
                            break;
                        } else {
                            String unused21 = z1Var.C = H018;
                            break;
                        }
                    case 22:
                        String H019 = y0Var.H0();
                        if (H019 == null) {
                            break;
                        } else {
                            String unused22 = z1Var.f31833p = H019;
                            break;
                        }
                    case 23:
                        String H020 = y0Var.H0();
                        if (H020 == null) {
                            break;
                        } else {
                            String unused23 = z1Var.H = H020;
                            break;
                        }
                    case 24:
                        List v02 = y0Var.v0(h0Var, new a2.a());
                        if (v02 == null) {
                            break;
                        } else {
                            z1Var.f31835t.addAll(v02);
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            z1Var.H(concurrentHashMap);
            y0Var.h();
            return z1Var;
        }
    }

    private boolean D() {
        if (this.F.equals("normal") || this.F.equals("timeout") || this.F.equals("backgrounded")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List E() throws Exception {
        return new ArrayList();
    }

    public String A() {
        return this.D;
    }

    public File B() {
        return this.f31820a;
    }

    public String C() {
        return this.B;
    }

    public void F() {
        try {
            this.f31831m = this.f31821b.call();
        } catch (Throwable unused) {
        }
    }

    public void G(String str) {
        this.H = str;
    }

    public void H(Map<String, Object> map) {
        this.I = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("android_api_level").O(h0Var, Integer.valueOf(this.f31822c));
        a1Var.N("device_locale").O(h0Var, this.f31823d);
        a1Var.N("device_manufacturer").I(this.f31824e);
        a1Var.N("device_model").I(this.f31825f);
        a1Var.N("device_os_build_number").I(this.f31826g);
        a1Var.N("device_os_name").I(this.f31827h);
        a1Var.N("device_os_version").I(this.f31828j);
        a1Var.N("device_is_emulator").J(this.f31829k);
        a1Var.N("architecture").O(h0Var, this.f31830l);
        a1Var.N("device_cpu_frequencies").O(h0Var, this.f31831m);
        a1Var.N("device_physical_memory_bytes").I(this.f31832n);
        a1Var.N("platform").I(this.f31833p);
        a1Var.N("build_id").I(this.f31834q);
        a1Var.N("transaction_name").I(this.f31836w);
        a1Var.N("duration_ns").I(this.f31837x);
        a1Var.N("version_name").I(this.f31839z);
        a1Var.N("version_code").I(this.f31838y);
        if (!this.f31835t.isEmpty()) {
            a1Var.N("transactions").O(h0Var, this.f31835t);
        }
        a1Var.N(FirebaseAnalytics.Param.TRANSACTION_ID).I(this.B);
        a1Var.N("trace_id").I(this.C);
        a1Var.N(Extra.PROFILE_ID).I(this.D);
        a1Var.N("environment").I(this.E);
        a1Var.N("truncation_reason").I(this.F);
        if (this.H != null) {
            a1Var.N("sampled_profile").I(this.H);
        }
        a1Var.N("measurements").O(h0Var, this.G);
        Map<String, Object> map = this.I;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.I.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    private z1() {
        this(new File("dummy"), p1.p());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z1(java.io.File r19, io.sentry.n0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r20
            java.util.ArrayList r4 = new java.util.ArrayList
            r2 = r4
            r4.<init>()
            io.sentry.y1 r4 = new io.sentry.y1
            r7 = r4
            r4.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r17 = r4
            r4.<init>()
            java.lang.String r4 = "0"
            r5 = 0
            java.lang.String r6 = ""
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r16 = "normal"
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.z1.<init>(java.io.File, io.sentry.n0):void");
    }

    public z1(File file, List<a2> list, n0 n0Var, String str, int i10, String str2, Callable<List<Integer>> callable, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, Map<String, io.sentry.profilemeasurements.a> map) {
        this.f31831m = new ArrayList();
        this.H = null;
        this.f31820a = file;
        this.f31830l = str2;
        this.f31821b = callable;
        this.f31822c = i10;
        this.f31823d = Locale.getDefault().toString();
        String str11 = "";
        this.f31824e = str3 != null ? str3 : str11;
        this.f31825f = str4 != null ? str4 : str11;
        this.f31828j = str5 != null ? str5 : str11;
        this.f31829k = bool != null ? bool.booleanValue() : false;
        this.f31832n = str6 != null ? str6 : "0";
        this.f31826g = str11;
        this.f31827h = "android";
        this.f31833p = "android";
        this.f31834q = str7 != null ? str7 : str11;
        this.f31835t = list;
        this.f31836w = n0Var.getName();
        this.f31837x = str;
        this.f31838y = str11;
        this.f31839z = str8 != null ? str8 : str11;
        this.B = n0Var.d().toString();
        this.C = n0Var.m().j().toString();
        this.D = UUID.randomUUID().toString();
        this.E = str9 != null ? str9 : "production";
        this.F = str10;
        if (!D()) {
            this.F = "normal";
        }
        this.G = map;
    }
}
