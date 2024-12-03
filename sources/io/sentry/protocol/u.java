package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.t;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

public final class u implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Long f31557a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f31558b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31559c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31560d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Boolean f31561e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Boolean f31562f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Boolean f31563g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f31564h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public t f31565j;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, Object> f31566k;

    public static final class a implements s0<u> {
        /* renamed from: b */
        public u a(y0 y0Var, h0 h0Var) throws Exception {
            u uVar = new u();
            y0Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1339353468:
                        if (y10.equals("daemon")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1165461084:
                        if (y10.equals(JingleS5BTransportCandidate.ATTR_PRIORITY)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3355:
                        if (y10.equals("id")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3343801:
                        if (y10.equals("main")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 109757585:
                        if (y10.equals("state")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1025385094:
                        if (y10.equals("crashed")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1126940025:
                        if (y10.equals("current")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 2055832509:
                        if (y10.equals("stacktrace")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        Boolean unused = uVar.f31563g = y0Var.m0();
                        break;
                    case 1:
                        Integer unused2 = uVar.f31558b = y0Var.u0();
                        break;
                    case 2:
                        Long unused3 = uVar.f31557a = y0Var.x0();
                        break;
                    case 3:
                        Boolean unused4 = uVar.f31564h = y0Var.m0();
                        break;
                    case 4:
                        String unused5 = uVar.f31559c = y0Var.H0();
                        break;
                    case 5:
                        String unused6 = uVar.f31560d = y0Var.H0();
                        break;
                    case 6:
                        Boolean unused7 = uVar.f31561e = y0Var.m0();
                        break;
                    case 7:
                        Boolean unused8 = uVar.f31562f = y0Var.m0();
                        break;
                    case 8:
                        t unused9 = uVar.f31565j = (t) y0Var.E0(h0Var, new t.a());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            uVar.v(concurrentHashMap);
            y0Var.h();
            return uVar;
        }
    }

    public Long j() {
        return this.f31557a;
    }

    public Boolean k() {
        return this.f31562f;
    }

    public Boolean l() {
        return this.f31564h;
    }

    public void m(Boolean bool) {
        this.f31561e = bool;
    }

    public void n(Boolean bool) {
        this.f31562f = bool;
    }

    public void o(Boolean bool) {
        this.f31563g = bool;
    }

    public void p(Long l10) {
        this.f31557a = l10;
    }

    public void q(Boolean bool) {
        this.f31564h = bool;
    }

    public void r(String str) {
        this.f31559c = str;
    }

    public void s(Integer num) {
        this.f31558b = num;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31557a != null) {
            a1Var.N("id").G(this.f31557a);
        }
        if (this.f31558b != null) {
            a1Var.N(JingleS5BTransportCandidate.ATTR_PRIORITY).G(this.f31558b);
        }
        if (this.f31559c != null) {
            a1Var.N("name").I(this.f31559c);
        }
        if (this.f31560d != null) {
            a1Var.N("state").I(this.f31560d);
        }
        if (this.f31561e != null) {
            a1Var.N("crashed").F(this.f31561e);
        }
        if (this.f31562f != null) {
            a1Var.N("current").F(this.f31562f);
        }
        if (this.f31563g != null) {
            a1Var.N("daemon").F(this.f31563g);
        }
        if (this.f31564h != null) {
            a1Var.N("main").F(this.f31564h);
        }
        if (this.f31565j != null) {
            a1Var.N("stacktrace").O(h0Var, this.f31565j);
        }
        Map<String, Object> map = this.f31566k;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31566k.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public void t(t tVar) {
        this.f31565j = tVar;
    }

    public void u(String str) {
        this.f31560d = str;
    }

    public void v(Map<String, Object> map) {
        this.f31566k = map;
    }
}
