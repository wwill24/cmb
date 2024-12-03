package io.sentry.protocol;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.leanplum.internal.Constants;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class Device implements c1 {
    /* access modifiers changed from: private */
    public Integer B;
    /* access modifiers changed from: private */
    public Integer C;
    /* access modifiers changed from: private */
    public Float D;
    /* access modifiers changed from: private */
    public Integer E;
    /* access modifiers changed from: private */
    public Date F;
    /* access modifiers changed from: private */
    public TimeZone G;
    /* access modifiers changed from: private */
    public String H;
    /* access modifiers changed from: private */
    @Deprecated
    public String I;
    /* access modifiers changed from: private */
    public String J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public Float L;
    /* access modifiers changed from: private */
    public Integer M;
    /* access modifiers changed from: private */
    public Double N;
    /* access modifiers changed from: private */
    public String O;
    private Map<String, Object> P;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31411a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31412b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31413c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31414d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31415e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31416f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String[] f31417g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Float f31418h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Boolean f31419j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Boolean f31420k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public DeviceOrientation f31421l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Boolean f31422m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Long f31423n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Long f31424p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Long f31425q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Boolean f31426t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Long f31427w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Long f31428x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public Long f31429y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public Long f31430z;

    public enum DeviceOrientation implements c1 {
        PORTRAIT,
        LANDSCAPE;

        public static final class a implements s0<DeviceOrientation> {
            /* renamed from: b */
            public DeviceOrientation a(y0 y0Var, h0 h0Var) throws Exception {
                return DeviceOrientation.valueOf(y0Var.G().toUpperCase(Locale.ROOT));
            }
        }

        public void serialize(a1 a1Var, h0 h0Var) throws IOException {
            a1Var.I(toString().toLowerCase(Locale.ROOT));
        }
    }

    public static final class a implements s0<Device> {
        /* renamed from: b */
        public Device a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            Device device = new Device();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -2076227591:
                        if (y10.equals(Constants.Keys.TIMEZONE)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -2012489734:
                        if (y10.equals("boot_time")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1981332476:
                        if (y10.equals("simulator")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1969347631:
                        if (y10.equals("manufacturer")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1613589672:
                        if (y10.equals("language")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1608004830:
                        if (y10.equals("processor_count")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -1439500848:
                        if (y10.equals("orientation")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -1410521534:
                        if (y10.equals("battery_temperature")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -1281860764:
                        if (y10.equals("family")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case -1097462182:
                        if (y10.equals(Constants.Keys.LOCALE)) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case -1012222381:
                        if (y10.equals("online")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case -877252910:
                        if (y10.equals("battery_level")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case -619038223:
                        if (y10.equals("model_id")) {
                            c10 = 12;
                            break;
                        }
                        break;
                    case -568274923:
                        if (y10.equals("screen_density")) {
                            c10 = 13;
                            break;
                        }
                        break;
                    case -417046774:
                        if (y10.equals("screen_dpi")) {
                            c10 = 14;
                            break;
                        }
                        break;
                    case -136523212:
                        if (y10.equals("free_memory")) {
                            c10 = 15;
                            break;
                        }
                        break;
                    case 3355:
                        if (y10.equals("id")) {
                            c10 = 16;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 17;
                            break;
                        }
                        break;
                    case 59142220:
                        if (y10.equals("low_memory")) {
                            c10 = 18;
                            break;
                        }
                        break;
                    case 93076189:
                        if (y10.equals("archs")) {
                            c10 = 19;
                            break;
                        }
                        break;
                    case 93997959:
                        if (y10.equals("brand")) {
                            c10 = 20;
                            break;
                        }
                        break;
                    case 104069929:
                        if (y10.equals(DeviceRequestsHelper.DEVICE_INFO_MODEL)) {
                            c10 = 21;
                            break;
                        }
                        break;
                    case 115746789:
                        if (y10.equals("cpu_description")) {
                            c10 = 22;
                            break;
                        }
                        break;
                    case 244497903:
                        if (y10.equals("processor_frequency")) {
                            c10 = 23;
                            break;
                        }
                        break;
                    case 731866107:
                        if (y10.equals("connection_type")) {
                            c10 = 24;
                            break;
                        }
                        break;
                    case 817830969:
                        if (y10.equals("screen_width_pixels")) {
                            c10 = 25;
                            break;
                        }
                        break;
                    case 823882553:
                        if (y10.equals("external_storage_size")) {
                            c10 = 26;
                            break;
                        }
                        break;
                    case 897428293:
                        if (y10.equals("storage_size")) {
                            c10 = 27;
                            break;
                        }
                        break;
                    case 1331465768:
                        if (y10.equals("usable_memory")) {
                            c10 = 28;
                            break;
                        }
                        break;
                    case 1418777727:
                        if (y10.equals("memory_size")) {
                            c10 = 29;
                            break;
                        }
                        break;
                    case 1436115569:
                        if (y10.equals("charging")) {
                            c10 = 30;
                            break;
                        }
                        break;
                    case 1450613660:
                        if (y10.equals("external_free_storage")) {
                            c10 = 31;
                            break;
                        }
                        break;
                    case 1524159400:
                        if (y10.equals("free_storage")) {
                            c10 = ' ';
                            break;
                        }
                        break;
                    case 1556284978:
                        if (y10.equals("screen_height_pixels")) {
                            c10 = '!';
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        TimeZone unused = device.G = y0Var.I0(h0Var);
                        break;
                    case 1:
                        if (y0Var.J() != JsonToken.STRING) {
                            break;
                        } else {
                            Date unused2 = device.F = y0Var.q0(h0Var);
                            break;
                        }
                    case 2:
                        Boolean unused3 = device.f31422m = y0Var.m0();
                        break;
                    case 3:
                        String unused4 = device.f31412b = y0Var.H0();
                        break;
                    case 4:
                        String unused5 = device.I = y0Var.H0();
                        break;
                    case 5:
                        Integer unused6 = device.M = y0Var.u0();
                        break;
                    case 6:
                        DeviceOrientation unused7 = device.f31421l = (DeviceOrientation) y0Var.E0(h0Var, new DeviceOrientation.a());
                        break;
                    case 7:
                        Float unused8 = device.L = y0Var.t0();
                        break;
                    case 8:
                        String unused9 = device.f31414d = y0Var.H0();
                        break;
                    case 9:
                        String unused10 = device.J = y0Var.H0();
                        break;
                    case 10:
                        Boolean unused11 = device.f31420k = y0Var.m0();
                        break;
                    case 11:
                        Float unused12 = device.f31418h = y0Var.t0();
                        break;
                    case 12:
                        String unused13 = device.f31416f = y0Var.H0();
                        break;
                    case 13:
                        Float unused14 = device.D = y0Var.t0();
                        break;
                    case 14:
                        Integer unused15 = device.E = y0Var.u0();
                        break;
                    case 15:
                        Long unused16 = device.f31424p = y0Var.x0();
                        break;
                    case 16:
                        String unused17 = device.H = y0Var.H0();
                        break;
                    case 17:
                        String unused18 = device.f31411a = y0Var.H0();
                        break;
                    case 18:
                        Boolean unused19 = device.f31426t = y0Var.m0();
                        break;
                    case 19:
                        List list = (List) y0Var.B0();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            String[] unused20 = device.f31417g = strArr;
                            break;
                        }
                    case 20:
                        String unused21 = device.f31413c = y0Var.H0();
                        break;
                    case 21:
                        String unused22 = device.f31415e = y0Var.H0();
                        break;
                    case 22:
                        String unused23 = device.O = y0Var.H0();
                        break;
                    case 23:
                        Double unused24 = device.N = y0Var.r0();
                        break;
                    case 24:
                        String unused25 = device.K = y0Var.H0();
                        break;
                    case 25:
                        Integer unused26 = device.B = y0Var.u0();
                        break;
                    case 26:
                        Long unused27 = device.f31429y = y0Var.x0();
                        break;
                    case 27:
                        Long unused28 = device.f31427w = y0Var.x0();
                        break;
                    case 28:
                        Long unused29 = device.f31425q = y0Var.x0();
                        break;
                    case 29:
                        Long unused30 = device.f31423n = y0Var.x0();
                        break;
                    case 30:
                        Boolean unused31 = device.f31419j = y0Var.m0();
                        break;
                    case 31:
                        Long unused32 = device.f31430z = y0Var.x0();
                        break;
                    case ' ':
                        Long unused33 = device.f31428x = y0Var.x0();
                        break;
                    case '!':
                        Integer unused34 = device.C = y0Var.u0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            device.s0(concurrentHashMap);
            y0Var.h();
            return device;
        }
    }

    public Device() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.TimeZone} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Device(io.sentry.protocol.Device r3) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = r3.f31411a
            r2.f31411a = r0
            java.lang.String r0 = r3.f31412b
            r2.f31412b = r0
            java.lang.String r0 = r3.f31413c
            r2.f31413c = r0
            java.lang.String r0 = r3.f31414d
            r2.f31414d = r0
            java.lang.String r0 = r3.f31415e
            r2.f31415e = r0
            java.lang.String r0 = r3.f31416f
            r2.f31416f = r0
            java.lang.Boolean r0 = r3.f31419j
            r2.f31419j = r0
            java.lang.Boolean r0 = r3.f31420k
            r2.f31420k = r0
            io.sentry.protocol.Device$DeviceOrientation r0 = r3.f31421l
            r2.f31421l = r0
            java.lang.Boolean r0 = r3.f31422m
            r2.f31422m = r0
            java.lang.Long r0 = r3.f31423n
            r2.f31423n = r0
            java.lang.Long r0 = r3.f31424p
            r2.f31424p = r0
            java.lang.Long r0 = r3.f31425q
            r2.f31425q = r0
            java.lang.Boolean r0 = r3.f31426t
            r2.f31426t = r0
            java.lang.Long r0 = r3.f31427w
            r2.f31427w = r0
            java.lang.Long r0 = r3.f31428x
            r2.f31428x = r0
            java.lang.Long r0 = r3.f31429y
            r2.f31429y = r0
            java.lang.Long r0 = r3.f31430z
            r2.f31430z = r0
            java.lang.Integer r0 = r3.B
            r2.B = r0
            java.lang.Integer r0 = r3.C
            r2.C = r0
            java.lang.Float r0 = r3.D
            r2.D = r0
            java.lang.Integer r0 = r3.E
            r2.E = r0
            java.util.Date r0 = r3.F
            r2.F = r0
            java.lang.String r0 = r3.H
            r2.H = r0
            java.lang.String r0 = r3.I
            r2.I = r0
            java.lang.String r0 = r3.K
            r2.K = r0
            java.lang.Float r0 = r3.L
            r2.L = r0
            java.lang.Float r0 = r3.f31418h
            r2.f31418h = r0
            java.lang.String[] r0 = r3.f31417g
            r1 = 0
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r0.clone()
            java.lang.String[] r0 = (java.lang.String[]) r0
            goto L_0x0080
        L_0x007f:
            r0 = r1
        L_0x0080:
            r2.f31417g = r0
            java.lang.String r0 = r3.J
            r2.J = r0
            java.util.TimeZone r0 = r3.G
            if (r0 == 0) goto L_0x0091
            java.lang.Object r0 = r0.clone()
            r1 = r0
            java.util.TimeZone r1 = (java.util.TimeZone) r1
        L_0x0091:
            r2.G = r1
            java.lang.Integer r0 = r3.M
            r2.M = r0
            java.lang.Double r0 = r3.N
            r2.N = r0
            java.lang.String r0 = r3.O
            r2.O = r0
            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.P
            java.util.Map r3 = io.sentry.util.b.b(r3)
            r2.P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.protocol.Device.<init>(io.sentry.protocol.Device):void");
    }

    public String I() {
        return this.K;
    }

    public String J() {
        return this.H;
    }

    public String K() {
        return this.I;
    }

    public String L() {
        return this.J;
    }

    public void M(String[] strArr) {
        this.f31417g = strArr;
    }

    public void N(Float f10) {
        this.f31418h = f10;
    }

    public void O(Float f10) {
        this.L = f10;
    }

    public void P(Date date) {
        this.F = date;
    }

    public void Q(String str) {
        this.f31413c = str;
    }

    public void R(Boolean bool) {
        this.f31419j = bool;
    }

    public void S(String str) {
        this.K = str;
    }

    public void T(Long l10) {
        this.f31430z = l10;
    }

    public void U(Long l10) {
        this.f31429y = l10;
    }

    public void V(String str) {
        this.f31414d = str;
    }

    public void W(Long l10) {
        this.f31424p = l10;
    }

    public void X(Long l10) {
        this.f31428x = l10;
    }

    public void Y(String str) {
        this.H = str;
    }

    public void Z(String str) {
        this.I = str;
    }

    public void a0(String str) {
        this.J = str;
    }

    public void b0(Boolean bool) {
        this.f31426t = bool;
    }

    public void c0(String str) {
        this.f31412b = str;
    }

    public void d0(Long l10) {
        this.f31423n = l10;
    }

    public void e0(String str) {
        this.f31415e = str;
    }

    public void f0(String str) {
        this.f31416f = str;
    }

    public void g0(String str) {
        this.f31411a = str;
    }

    public void h0(Boolean bool) {
        this.f31420k = bool;
    }

    public void i0(DeviceOrientation deviceOrientation) {
        this.f31421l = deviceOrientation;
    }

    public void j0(Integer num) {
        this.M = num;
    }

    public void k0(Double d10) {
        this.N = d10;
    }

    public void l0(Float f10) {
        this.D = f10;
    }

    public void m0(Integer num) {
        this.E = num;
    }

    public void n0(Integer num) {
        this.C = num;
    }

    public void o0(Integer num) {
        this.B = num;
    }

    public void p0(Boolean bool) {
        this.f31422m = bool;
    }

    public void q0(Long l10) {
        this.f31427w = l10;
    }

    public void r0(TimeZone timeZone) {
        this.G = timeZone;
    }

    public void s0(Map<String, Object> map) {
        this.P = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31411a != null) {
            a1Var.N("name").I(this.f31411a);
        }
        if (this.f31412b != null) {
            a1Var.N("manufacturer").I(this.f31412b);
        }
        if (this.f31413c != null) {
            a1Var.N("brand").I(this.f31413c);
        }
        if (this.f31414d != null) {
            a1Var.N("family").I(this.f31414d);
        }
        if (this.f31415e != null) {
            a1Var.N(DeviceRequestsHelper.DEVICE_INFO_MODEL).I(this.f31415e);
        }
        if (this.f31416f != null) {
            a1Var.N("model_id").I(this.f31416f);
        }
        if (this.f31417g != null) {
            a1Var.N("archs").O(h0Var, this.f31417g);
        }
        if (this.f31418h != null) {
            a1Var.N("battery_level").G(this.f31418h);
        }
        if (this.f31419j != null) {
            a1Var.N("charging").F(this.f31419j);
        }
        if (this.f31420k != null) {
            a1Var.N("online").F(this.f31420k);
        }
        if (this.f31421l != null) {
            a1Var.N("orientation").O(h0Var, this.f31421l);
        }
        if (this.f31422m != null) {
            a1Var.N("simulator").F(this.f31422m);
        }
        if (this.f31423n != null) {
            a1Var.N("memory_size").G(this.f31423n);
        }
        if (this.f31424p != null) {
            a1Var.N("free_memory").G(this.f31424p);
        }
        if (this.f31425q != null) {
            a1Var.N("usable_memory").G(this.f31425q);
        }
        if (this.f31426t != null) {
            a1Var.N("low_memory").F(this.f31426t);
        }
        if (this.f31427w != null) {
            a1Var.N("storage_size").G(this.f31427w);
        }
        if (this.f31428x != null) {
            a1Var.N("free_storage").G(this.f31428x);
        }
        if (this.f31429y != null) {
            a1Var.N("external_storage_size").G(this.f31429y);
        }
        if (this.f31430z != null) {
            a1Var.N("external_free_storage").G(this.f31430z);
        }
        if (this.B != null) {
            a1Var.N("screen_width_pixels").G(this.B);
        }
        if (this.C != null) {
            a1Var.N("screen_height_pixels").G(this.C);
        }
        if (this.D != null) {
            a1Var.N("screen_density").G(this.D);
        }
        if (this.E != null) {
            a1Var.N("screen_dpi").G(this.E);
        }
        if (this.F != null) {
            a1Var.N("boot_time").O(h0Var, this.F);
        }
        if (this.G != null) {
            a1Var.N(Constants.Keys.TIMEZONE).O(h0Var, this.G);
        }
        if (this.H != null) {
            a1Var.N("id").I(this.H);
        }
        if (this.I != null) {
            a1Var.N("language").I(this.I);
        }
        if (this.K != null) {
            a1Var.N("connection_type").I(this.K);
        }
        if (this.L != null) {
            a1Var.N("battery_temperature").G(this.L);
        }
        if (this.J != null) {
            a1Var.N(Constants.Keys.LOCALE).I(this.J);
        }
        if (this.M != null) {
            a1Var.N("processor_count").G(this.M);
        }
        if (this.N != null) {
            a1Var.N("processor_frequency").G(this.N);
        }
        if (this.O != null) {
            a1Var.N("cpu_description").I(this.O);
        }
        Map<String, Object> map = this.P;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.P.get(next));
            }
        }
        a1Var.h();
    }
}
