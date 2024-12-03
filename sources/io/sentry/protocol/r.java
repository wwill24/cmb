package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.g;
import io.sentry.h0;
import io.sentry.i4;
import io.sentry.l4;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.util.l;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class r implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Double f31526a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f31527b;

    /* renamed from: c  reason: collision with root package name */
    private final o f31528c;

    /* renamed from: d  reason: collision with root package name */
    private final l4 f31529d;

    /* renamed from: e  reason: collision with root package name */
    private final l4 f31530e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31531f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31532g;

    /* renamed from: h  reason: collision with root package name */
    private final SpanStatus f31533h;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, String> f31534j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Object> f31535k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, Object> f31536l;

    public static final class a implements s0<r> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.util.HashMap} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: io.sentry.l4} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: io.sentry.SpanStatus} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.util.Map} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.Map} */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bc, code lost:
            r14 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
            r12 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c0, code lost:
            r11 = r18;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.sentry.protocol.r a(io.sentry.y0 r21, io.sentry.h0 r22) throws java.lang.Exception {
            /*
                r20 = this;
                r0 = r20
                r1 = r21
                r2 = r22
                r21.b()
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                r15 = 0
            L_0x0014:
                io.sentry.vendor.gson.stream.JsonToken r13 = r21.J()
                io.sentry.vendor.gson.stream.JsonToken r3 = io.sentry.vendor.gson.stream.JsonToken.NAME
                java.lang.String r0 = "trace_id"
                r16 = r14
                java.lang.String r14 = "op"
                r17 = r12
                java.lang.String r12 = "start_timestamp"
                r18 = r11
                java.lang.String r11 = "span_id"
                if (r13 != r3) goto L_0x013a
                java.lang.String r3 = r21.y()
                r3.hashCode()
                r13 = -1
                int r19 = r3.hashCode()
                switch(r19) {
                    case -2011840976: goto L_0x009c;
                    case -1757797477: goto L_0x0091;
                    case -1724546052: goto L_0x0086;
                    case -1526966919: goto L_0x007d;
                    case -892481550: goto L_0x0072;
                    case 3553: goto L_0x0069;
                    case 3076010: goto L_0x005e;
                    case 3552281: goto L_0x0053;
                    case 55126294: goto L_0x0047;
                    case 1270300245: goto L_0x003b;
                    default: goto L_0x0039;
                }
            L_0x0039:
                goto L_0x00a4
            L_0x003b:
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x0043
                goto L_0x00a4
            L_0x0043:
                r13 = 9
                goto L_0x00a4
            L_0x0047:
                java.lang.String r0 = "timestamp"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x0050
                goto L_0x00a4
            L_0x0050:
                r13 = 8
                goto L_0x00a4
            L_0x0053:
                java.lang.String r0 = "tags"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x005c
                goto L_0x00a4
            L_0x005c:
                r13 = 7
                goto L_0x00a4
            L_0x005e:
                java.lang.String r0 = "data"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x0067
                goto L_0x00a4
            L_0x0067:
                r13 = 6
                goto L_0x00a4
            L_0x0069:
                boolean r0 = r3.equals(r14)
                if (r0 != 0) goto L_0x0070
                goto L_0x00a4
            L_0x0070:
                r13 = 5
                goto L_0x00a4
            L_0x0072:
                java.lang.String r0 = "status"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x007b
                goto L_0x00a4
            L_0x007b:
                r13 = 4
                goto L_0x00a4
            L_0x007d:
                boolean r0 = r3.equals(r12)
                if (r0 != 0) goto L_0x0084
                goto L_0x00a4
            L_0x0084:
                r13 = 3
                goto L_0x00a4
            L_0x0086:
                java.lang.String r0 = "description"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x008f
                goto L_0x00a4
            L_0x008f:
                r13 = 2
                goto L_0x00a4
            L_0x0091:
                java.lang.String r0 = "parent_span_id"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x009a
                goto L_0x00a4
            L_0x009a:
                r13 = 1
                goto L_0x00a4
            L_0x009c:
                boolean r0 = r3.equals(r11)
                if (r0 != 0) goto L_0x00a3
                goto L_0x00a4
            L_0x00a3:
                r13 = 0
            L_0x00a4:
                switch(r13) {
                    case 0: goto L_0x012c;
                    case 1: goto L_0x011f;
                    case 2: goto L_0x0116;
                    case 3: goto L_0x00ff;
                    case 4: goto L_0x00f0;
                    case 5: goto L_0x00eb;
                    case 6: goto L_0x00e3;
                    case 7: goto L_0x00db;
                    case 8: goto L_0x00c4;
                    case 9: goto L_0x00b3;
                    default: goto L_0x00a7;
                }
            L_0x00a7:
                if (r15 != 0) goto L_0x00af
                java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
                r0.<init>()
                r15 = r0
            L_0x00af:
                r1.N0(r2, r15, r3)
                goto L_0x00bc
            L_0x00b3:
                io.sentry.protocol.o$a r0 = new io.sentry.protocol.o$a
                r0.<init>()
                io.sentry.protocol.o r7 = r0.a(r1, r2)
            L_0x00bc:
                r14 = r16
            L_0x00be:
                r12 = r17
            L_0x00c0:
                r11 = r18
                goto L_0x0136
            L_0x00c4:
                java.lang.Double r6 = r21.r0()     // Catch:{ NumberFormatException -> 0x00c9 }
                goto L_0x00bc
            L_0x00c9:
                java.util.Date r0 = r21.q0(r22)
                if (r0 == 0) goto L_0x00d9
                double r11 = io.sentry.g.b(r0)
                java.lang.Double r0 = java.lang.Double.valueOf(r11)
                r6 = r0
                goto L_0x00bc
            L_0x00d9:
                r6 = 0
                goto L_0x00bc
            L_0x00db:
                java.lang.Object r0 = r21.B0()
                r4 = r0
                java.util.Map r4 = (java.util.Map) r4
                goto L_0x00bc
            L_0x00e3:
                java.lang.Object r0 = r21.B0()
                r14 = r0
                java.util.Map r14 = (java.util.Map) r14
                goto L_0x00be
            L_0x00eb:
                java.lang.String r10 = r21.H0()
                goto L_0x00bc
            L_0x00f0:
                io.sentry.SpanStatus$a r0 = new io.sentry.SpanStatus$a
                r0.<init>()
                java.lang.Object r0 = r1.E0(r2, r0)
                r12 = r0
                io.sentry.SpanStatus r12 = (io.sentry.SpanStatus) r12
                r14 = r16
                goto L_0x00c0
            L_0x00ff:
                java.lang.Double r5 = r21.r0()     // Catch:{ NumberFormatException -> 0x0104 }
                goto L_0x00bc
            L_0x0104:
                java.util.Date r0 = r21.q0(r22)
                if (r0 == 0) goto L_0x0114
                double r11 = io.sentry.g.b(r0)
                java.lang.Double r0 = java.lang.Double.valueOf(r11)
                r5 = r0
                goto L_0x00bc
            L_0x0114:
                r5 = 0
                goto L_0x00bc
            L_0x0116:
                java.lang.String r11 = r21.H0()
                r14 = r16
                r12 = r17
                goto L_0x0136
            L_0x011f:
                io.sentry.l4$a r0 = new io.sentry.l4$a
                r0.<init>()
                java.lang.Object r0 = r1.E0(r2, r0)
                r9 = r0
                io.sentry.l4 r9 = (io.sentry.l4) r9
                goto L_0x00bc
            L_0x012c:
                io.sentry.l4$a r0 = new io.sentry.l4$a
                r0.<init>()
                io.sentry.l4 r8 = r0.a(r1, r2)
                goto L_0x00bc
            L_0x0136:
                r0 = r20
                goto L_0x0014
            L_0x013a:
                if (r5 == 0) goto L_0x0175
                if (r7 == 0) goto L_0x016d
                if (r8 == 0) goto L_0x0166
                if (r10 == 0) goto L_0x015f
                if (r4 != 0) goto L_0x014b
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r13 = r0
                goto L_0x014c
            L_0x014b:
                r13 = r4
            L_0x014c:
                io.sentry.protocol.r r0 = new io.sentry.protocol.r
                r4 = r0
                r11 = r18
                r12 = r17
                r14 = r16
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                r0.c(r15)
                r21.h()
                return r0
            L_0x015f:
                r0 = r20
                java.lang.Exception r1 = r0.c(r14, r2)
                throw r1
            L_0x0166:
                r0 = r20
                java.lang.Exception r1 = r0.c(r11, r2)
                throw r1
            L_0x016d:
                r1 = r0
                r0 = r20
                java.lang.Exception r1 = r0.c(r1, r2)
                throw r1
            L_0x0175:
                r0 = r20
                java.lang.Exception r1 = r0.c(r12, r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.protocol.r.a.a(io.sentry.y0, io.sentry.h0):io.sentry.protocol.r");
        }
    }

    public r(i4 i4Var) {
        this(i4Var, i4Var.p());
    }

    private BigDecimal a(Double d10) {
        return BigDecimal.valueOf(d10.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public String b() {
        return this.f31531f;
    }

    public void c(Map<String, Object> map) {
        this.f31536l = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("start_timestamp").O(h0Var, a(this.f31526a));
        if (this.f31527b != null) {
            a1Var.N("timestamp").O(h0Var, a(this.f31527b));
        }
        a1Var.N("trace_id").O(h0Var, this.f31528c);
        a1Var.N("span_id").O(h0Var, this.f31529d);
        if (this.f31530e != null) {
            a1Var.N("parent_span_id").O(h0Var, this.f31530e);
        }
        a1Var.N("op").I(this.f31531f);
        if (this.f31532g != null) {
            a1Var.N("description").I(this.f31532g);
        }
        if (this.f31533h != null) {
            a1Var.N("status").O(h0Var, this.f31533h);
        }
        if (!this.f31534j.isEmpty()) {
            a1Var.N("tags").O(h0Var, this.f31534j);
        }
        if (this.f31535k != null) {
            a1Var.N("data").O(h0Var, this.f31535k);
        }
        Map<String, Object> map = this.f31536l;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31536l.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    @ApiStatus.Internal
    public r(i4 i4Var, Map<String, Object> map) {
        l.c(i4Var, "span is required");
        this.f31532g = i4Var.getDescription();
        this.f31531f = i4Var.r();
        this.f31529d = i4Var.v();
        this.f31530e = i4Var.t();
        this.f31528c = i4Var.x();
        this.f31533h = i4Var.getStatus();
        Map<String, String> b10 = b.b(i4Var.w());
        this.f31534j = b10 == null ? new ConcurrentHashMap<>() : b10;
        this.f31527b = Double.valueOf(g.l(i4Var.getStartDate().e(i4Var.n())));
        this.f31526a = Double.valueOf(g.l(i4Var.getStartDate().h()));
        this.f31535k = map;
    }

    @ApiStatus.Internal
    public r(Double d10, Double d11, o oVar, l4 l4Var, l4 l4Var2, String str, String str2, SpanStatus spanStatus, Map<String, String> map, Map<String, Object> map2) {
        this.f31526a = d10;
        this.f31527b = d11;
        this.f31528c = oVar;
        this.f31529d = l4Var;
        this.f31530e = l4Var2;
        this.f31531f = str;
        this.f31532g = str2;
        this.f31533h = spanStatus;
        this.f31534j = map;
        this.f31535k = map2;
    }
}
