package io.sentry;

import io.sentry.protocol.o;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public final class p4 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final o f31393a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31394b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31395c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31396d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31397e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31398f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31399g;

    /* renamed from: h  reason: collision with root package name */
    private final String f31400h;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f31401j;

    public static final class b implements s0<p4> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* renamed from: b */
        public p4 a(y0 y0Var, h0 h0Var) throws Exception {
            String str;
            String str2;
            y0 y0Var2 = y0Var;
            h0 h0Var2 = h0Var;
            y0Var.b();
            c cVar = null;
            String str3 = null;
            o oVar = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -795593025:
                        if (y10.equals("user_segment")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -147132913:
                        if (y10.equals("user_id")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -85904877:
                        if (y10.equals("environment")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3599307:
                        if (y10.equals("user")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 153193045:
                        if (y10.equals("sample_rate")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 1090594823:
                        if (y10.equals("release")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (y10.equals("trace_id")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1904812937:
                        if (y10.equals("public_key")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (y10.equals("transaction")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        str4 = y0Var.H0();
                        break;
                    case 1:
                        str3 = y0Var.H0();
                        break;
                    case 2:
                        str7 = y0Var.H0();
                        break;
                    case 3:
                        cVar = (c) y0Var2.E0(h0Var2, new c.a());
                        break;
                    case 4:
                        str9 = y0Var.H0();
                        break;
                    case 5:
                        str6 = y0Var.H0();
                        break;
                    case 6:
                        oVar = new o.a().a(y0Var2, h0Var2);
                        break;
                    case 7:
                        str5 = y0Var.G();
                        break;
                    case 8:
                        str8 = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var2.N0(h0Var2, concurrentHashMap, y10);
                        break;
                }
            }
            if (oVar == null) {
                throw c("trace_id", h0Var2);
            } else if (str5 != null) {
                if (cVar != null) {
                    if (str3 == null) {
                        str3 = cVar.a();
                    }
                    if (str4 == null) {
                        str = cVar.b();
                        str2 = str3;
                        p4 p4Var = new p4(oVar, str5, str6, str7, str2, str, str8, str9);
                        p4Var.b(concurrentHashMap);
                        y0Var.h();
                        return p4Var;
                    }
                }
                str2 = str3;
                str = str4;
                p4 p4Var2 = new p4(oVar, str5, str6, str7, str2, str, str8, str9);
                p4Var2.b(concurrentHashMap);
                y0Var.h();
                return p4Var2;
            } else {
                throw c("public_key", h0Var2);
            }
        }
    }

    @Deprecated
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private String f31402a;

        /* renamed from: b  reason: collision with root package name */
        private String f31403b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, Object> f31404c;

        public static final class a implements s0<c> {
            /* renamed from: b */
            public c a(y0 y0Var, h0 h0Var) throws Exception {
                y0Var.b();
                String str = null;
                String str2 = null;
                ConcurrentHashMap concurrentHashMap = null;
                while (y0Var.J() == JsonToken.NAME) {
                    String y10 = y0Var.y();
                    y10.hashCode();
                    if (y10.equals("id")) {
                        str = y0Var.H0();
                    } else if (!y10.equals("segment")) {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                    } else {
                        str2 = y0Var.H0();
                    }
                }
                c cVar = new c(str, str2);
                cVar.c(concurrentHashMap);
                y0Var.h();
                return cVar;
            }
        }

        public String a() {
            return this.f31402a;
        }

        public String b() {
            return this.f31403b;
        }

        public void c(Map<String, Object> map) {
            this.f31404c = map;
        }

        private c(String str, String str2) {
            this.f31402a = str;
            this.f31403b = str2;
        }
    }

    p4(o oVar, String str) {
        this(oVar, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
    }

    public String a() {
        return this.f31400h;
    }

    public void b(Map<String, Object> map) {
        this.f31401j = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("trace_id").O(h0Var, this.f31393a);
        a1Var.N("public_key").I(this.f31394b);
        if (this.f31395c != null) {
            a1Var.N("release").I(this.f31395c);
        }
        if (this.f31396d != null) {
            a1Var.N("environment").I(this.f31396d);
        }
        if (this.f31397e != null) {
            a1Var.N("user_id").I(this.f31397e);
        }
        if (this.f31398f != null) {
            a1Var.N("user_segment").I(this.f31398f);
        }
        if (this.f31399g != null) {
            a1Var.N("transaction").I(this.f31399g);
        }
        if (this.f31400h != null) {
            a1Var.N("sample_rate").I(this.f31400h);
        }
        Map<String, Object> map = this.f31401j;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31401j.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    p4(o oVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f31393a = oVar;
        this.f31394b = str;
        this.f31395c = str2;
        this.f31396d = str3;
        this.f31397e = str4;
        this.f31398f = str5;
        this.f31399g = str6;
        this.f31400h = str7;
    }
}
