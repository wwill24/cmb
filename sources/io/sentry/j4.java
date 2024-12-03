package io.sentry;

import io.sentry.SpanStatus;
import io.sentry.l4;
import io.sentry.protocol.o;
import io.sentry.util.b;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

public class j4 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final o f31306a;

    /* renamed from: b  reason: collision with root package name */
    private final l4 f31307b;

    /* renamed from: c  reason: collision with root package name */
    private final l4 f31308c;

    /* renamed from: d  reason: collision with root package name */
    private transient r4 f31309d;

    /* renamed from: e  reason: collision with root package name */
    protected String f31310e;

    /* renamed from: f  reason: collision with root package name */
    protected String f31311f;

    /* renamed from: g  reason: collision with root package name */
    protected SpanStatus f31312g;

    /* renamed from: h  reason: collision with root package name */
    protected Map<String, String> f31313h;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f31314j;

    public static final class a implements s0<j4> {
        /* renamed from: b */
        public j4 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            o oVar = null;
            l4 l4Var = null;
            String str = null;
            l4 l4Var2 = null;
            String str2 = null;
            SpanStatus spanStatus = null;
            Map<String, String> map = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -2011840976:
                        if (y10.equals("span_id")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1757797477:
                        if (y10.equals("parent_span_id")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1724546052:
                        if (y10.equals("description")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -892481550:
                        if (y10.equals("status")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3553:
                        if (y10.equals("op")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 3552281:
                        if (y10.equals("tags")) {
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
                }
                switch (c10) {
                    case 0:
                        l4Var = new l4.a().a(y0Var, h0Var);
                        break;
                    case 1:
                        l4Var2 = (l4) y0Var.E0(h0Var, new l4.a());
                        break;
                    case 2:
                        str2 = y0Var.G();
                        break;
                    case 3:
                        spanStatus = (SpanStatus) y0Var.E0(h0Var, new SpanStatus.a());
                        break;
                    case 4:
                        str = y0Var.G();
                        break;
                    case 5:
                        map = b.b((Map) y0Var.B0());
                        break;
                    case 6:
                        oVar = new o.a().a(y0Var, h0Var);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            if (oVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            } else if (l4Var == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            } else if (str != null) {
                j4 j4Var = new j4(oVar, l4Var, str, l4Var2, (r4) null);
                j4Var.k(str2);
                j4Var.m(spanStatus);
                if (map != null) {
                    j4Var.f31313h = map;
                }
                j4Var.n(concurrentHashMap);
                y0Var.h();
                return j4Var;
            } else {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"op\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"op\"", illegalStateException3);
                throw illegalStateException3;
            }
        }
    }

    public j4(String str) {
        this(new o(), new l4(), str, (l4) null, (r4) null);
    }

    public String a() {
        return this.f31311f;
    }

    public String b() {
        return this.f31310e;
    }

    public l4 c() {
        return this.f31308c;
    }

    public Boolean d() {
        r4 r4Var = this.f31309d;
        if (r4Var == null) {
            return null;
        }
        return r4Var.a();
    }

    public Boolean e() {
        r4 r4Var = this.f31309d;
        if (r4Var == null) {
            return null;
        }
        return r4Var.c();
    }

    public r4 f() {
        return this.f31309d;
    }

    public l4 g() {
        return this.f31307b;
    }

    public SpanStatus h() {
        return this.f31312g;
    }

    public Map<String, String> i() {
        return this.f31313h;
    }

    public o j() {
        return this.f31306a;
    }

    public void k(String str) {
        this.f31311f = str;
    }

    @ApiStatus.Internal
    public void l(r4 r4Var) {
        this.f31309d = r4Var;
    }

    public void m(SpanStatus spanStatus) {
        this.f31312g = spanStatus;
    }

    public void n(Map<String, Object> map) {
        this.f31314j = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("trace_id");
        this.f31306a.serialize(a1Var, h0Var);
        a1Var.N("span_id");
        this.f31307b.serialize(a1Var, h0Var);
        if (this.f31308c != null) {
            a1Var.N("parent_span_id");
            this.f31308c.serialize(a1Var, h0Var);
        }
        a1Var.N("op").I(this.f31310e);
        if (this.f31311f != null) {
            a1Var.N("description").I(this.f31311f);
        }
        if (this.f31312g != null) {
            a1Var.N("status").O(h0Var, this.f31312g);
        }
        if (!this.f31313h.isEmpty()) {
            a1Var.N("tags").O(h0Var, this.f31313h);
        }
        Map<String, Object> map = this.f31314j;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31314j.get(next));
            }
        }
        a1Var.h();
    }

    public j4(o oVar, l4 l4Var, String str, l4 l4Var2, r4 r4Var) {
        this(oVar, l4Var, l4Var2, str, (String) null, r4Var, (SpanStatus) null);
    }

    @ApiStatus.Internal
    public j4(o oVar, l4 l4Var, l4 l4Var2, String str, String str2, r4 r4Var, SpanStatus spanStatus) {
        this.f31313h = new ConcurrentHashMap();
        this.f31306a = (o) l.c(oVar, "traceId is required");
        this.f31307b = (l4) l.c(l4Var, "spanId is required");
        this.f31310e = (String) l.c(str, "operation is required");
        this.f31308c = l4Var2;
        this.f31309d = r4Var;
        this.f31311f = str2;
        this.f31312g = spanStatus;
    }

    public j4(j4 j4Var) {
        this.f31313h = new ConcurrentHashMap();
        this.f31306a = j4Var.f31306a;
        this.f31307b = j4Var.f31307b;
        this.f31308c = j4Var.f31308c;
        this.f31309d = j4Var.f31309d;
        this.f31310e = j4Var.f31310e;
        this.f31311f = j4Var.f31311f;
        this.f31312g = j4Var.f31312g;
        Map<String, String> b10 = b.b(j4Var.f31313h);
        if (b10 != null) {
            this.f31313h = b10;
        }
    }
}
