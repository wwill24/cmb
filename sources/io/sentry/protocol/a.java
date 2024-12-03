package io.sentry.protocol;

import com.facebook.internal.NativeProtocol;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31431a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Date f31432b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31433c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31434d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31435e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31436f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f31437g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f31438h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Boolean f31439j;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, Object> f31440k;

    /* renamed from: io.sentry.protocol.a$a  reason: collision with other inner class name */
    public static final class C0361a implements s0<a> {
        /* renamed from: b */
        public a a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1898053579:
                        if (y10.equals("device_app_hash")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -901870406:
                        if (y10.equals("app_version")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -650544995:
                        if (y10.equals("in_foreground")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -470395285:
                        if (y10.equals("build_type")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 746297735:
                        if (y10.equals("app_identifier")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 791585128:
                        if (y10.equals("app_start_time")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1133704324:
                        if (y10.equals("permissions")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1167648233:
                        if (y10.equals(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 1826866896:
                        if (y10.equals("app_build")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = aVar.f31433c = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = aVar.f31436f = y0Var.H0();
                        break;
                    case 2:
                        Boolean unused3 = aVar.f31439j = y0Var.m0();
                        break;
                    case 3:
                        String unused4 = aVar.f31434d = y0Var.H0();
                        break;
                    case 4:
                        String unused5 = aVar.f31431a = y0Var.H0();
                        break;
                    case 5:
                        Date unused6 = aVar.f31432b = y0Var.q0(h0Var);
                        break;
                    case 6:
                        Map unused7 = aVar.f31438h = b.b((Map) y0Var.B0());
                        break;
                    case 7:
                        String unused8 = aVar.f31435e = y0Var.H0();
                        break;
                    case 8:
                        String unused9 = aVar.f31437g = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            aVar.r(concurrentHashMap);
            y0Var.h();
            return aVar;
        }
    }

    public a() {
    }

    a(a aVar) {
        this.f31437g = aVar.f31437g;
        this.f31431a = aVar.f31431a;
        this.f31435e = aVar.f31435e;
        this.f31432b = aVar.f31432b;
        this.f31436f = aVar.f31436f;
        this.f31434d = aVar.f31434d;
        this.f31433c = aVar.f31433c;
        this.f31438h = b.b(aVar.f31438h);
        this.f31439j = aVar.f31439j;
        this.f31440k = b.b(aVar.f31440k);
    }

    public Boolean j() {
        return this.f31439j;
    }

    public void k(String str) {
        this.f31437g = str;
    }

    public void l(String str) {
        this.f31431a = str;
    }

    public void m(String str) {
        this.f31435e = str;
    }

    public void n(Date date) {
        this.f31432b = date;
    }

    public void o(String str) {
        this.f31436f = str;
    }

    public void p(Boolean bool) {
        this.f31439j = bool;
    }

    public void q(Map<String, String> map) {
        this.f31438h = map;
    }

    public void r(Map<String, Object> map) {
        this.f31440k = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31431a != null) {
            a1Var.N("app_identifier").I(this.f31431a);
        }
        if (this.f31432b != null) {
            a1Var.N("app_start_time").O(h0Var, this.f31432b);
        }
        if (this.f31433c != null) {
            a1Var.N("device_app_hash").I(this.f31433c);
        }
        if (this.f31434d != null) {
            a1Var.N("build_type").I(this.f31434d);
        }
        if (this.f31435e != null) {
            a1Var.N(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING).I(this.f31435e);
        }
        if (this.f31436f != null) {
            a1Var.N("app_version").I(this.f31436f);
        }
        if (this.f31437g != null) {
            a1Var.N("app_build").I(this.f31437g);
        }
        Map<String, String> map = this.f31438h;
        if (map != null && !map.isEmpty()) {
            a1Var.N("permissions").O(h0Var, this.f31438h);
        }
        if (this.f31439j != null) {
            a1Var.N("in_foreground").F(this.f31439j);
        }
        Map<String, Object> map2 = this.f31440k;
        if (map2 != null) {
            for (String next : map2.keySet()) {
                a1Var.N(next).O(h0Var, this.f31440k.get(next));
            }
        }
        a1Var.h();
    }
}
