package io.sentry;

import io.sentry.protocol.o;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class x4 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final o f31799a;

    /* renamed from: b  reason: collision with root package name */
    private String f31800b;

    /* renamed from: c  reason: collision with root package name */
    private String f31801c;

    /* renamed from: d  reason: collision with root package name */
    private String f31802d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f31803e;

    public static final class a implements s0<x4> {
        /* renamed from: b */
        public x4 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            o oVar = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -602415628:
                        if (y10.equals("comments")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 96619420:
                        if (y10.equals("email")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 278118624:
                        if (y10.equals("event_id")) {
                            c10 = 3;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        str3 = y0Var.H0();
                        break;
                    case 1:
                        str = y0Var.H0();
                        break;
                    case 2:
                        str2 = y0Var.H0();
                        break;
                    case 3:
                        oVar = new o.a().a(y0Var, h0Var);
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            y0Var.h();
            if (oVar != null) {
                x4 x4Var = new x4(oVar, str, str2, str3);
                x4Var.a(hashMap);
                return x4Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            h0Var.b(SentryLevel.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public x4(o oVar, String str, String str2, String str3) {
        this.f31799a = oVar;
        this.f31800b = str;
        this.f31801c = str2;
        this.f31802d = str3;
    }

    public void a(Map<String, Object> map) {
        this.f31803e = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("event_id");
        this.f31799a.serialize(a1Var, h0Var);
        if (this.f31800b != null) {
            a1Var.N("name").I(this.f31800b);
        }
        if (this.f31801c != null) {
            a1Var.N("email").I(this.f31801c);
        }
        if (this.f31802d != null) {
            a1Var.N("comments").I(this.f31802d);
        }
        Map<String, Object> map = this.f31803e;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31803e.get(next));
            }
        }
        a1Var.h();
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.f31799a + ", name='" + this.f31800b + '\'' + ", email='" + this.f31801c + '\'' + ", comments='" + this.f31802d + '\'' + '}';
    }
}
