package io.sentry;

import com.mparticle.identity.IdentityHttpResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;

public final class Session implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Date f30789a;

    /* renamed from: b  reason: collision with root package name */
    private Date f30790b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f30791c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30792d;

    /* renamed from: e  reason: collision with root package name */
    private final UUID f30793e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f30794f;

    /* renamed from: g  reason: collision with root package name */
    private State f30795g;

    /* renamed from: h  reason: collision with root package name */
    private Long f30796h;

    /* renamed from: j  reason: collision with root package name */
    private Double f30797j;

    /* renamed from: k  reason: collision with root package name */
    private final String f30798k;

    /* renamed from: l  reason: collision with root package name */
    private String f30799l;

    /* renamed from: m  reason: collision with root package name */
    private final String f30800m;

    /* renamed from: n  reason: collision with root package name */
    private final String f30801n;

    /* renamed from: p  reason: collision with root package name */
    private String f30802p;

    /* renamed from: q  reason: collision with root package name */
    private final Object f30803q;

    /* renamed from: t  reason: collision with root package name */
    private Map<String, Object> f30804t;

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public static final class a implements s0<Session> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.sentry.Session a(io.sentry.y0 r28, io.sentry.h0 r29) throws java.lang.Exception {
            /*
                r27 = this;
                r0 = r27
                r1 = r29
                r28.b()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
            L_0x0018:
                io.sentry.vendor.gson.stream.JsonToken r2 = r28.J()
                io.sentry.vendor.gson.stream.JsonToken r0 = io.sentry.vendor.gson.stream.JsonToken.NAME
                r18 = r15
                java.lang.String r15 = "release"
                r19 = r14
                java.lang.String r14 = "status"
                r20 = r13
                java.lang.String r13 = "errors"
                r21 = r12
                java.lang.String r12 = "started"
                if (r2 != r0) goto L_0x01c7
                java.lang.String r0 = r28.y()
                r0.hashCode()
                int r2 = r0.hashCode()
                r22 = 3
                r23 = 2
                r24 = -1
                r25 = r11
                r11 = 1
                r26 = 0
                switch(r2) {
                    case -1992012396: goto L_0x00bd;
                    case -1897185151: goto L_0x00b4;
                    case -1294635157: goto L_0x00aa;
                    case -892481550: goto L_0x00a0;
                    case 99455: goto L_0x0095;
                    case 113759: goto L_0x008a;
                    case 113870: goto L_0x007f;
                    case 3237136: goto L_0x0074;
                    case 55126294: goto L_0x0067;
                    case 93152418: goto L_0x005a;
                    case 213717026: goto L_0x004d;
                    default: goto L_0x0049;
                }
            L_0x0049:
                r2 = r24
                goto L_0x00c8
            L_0x004d:
                java.lang.String r2 = "abnormal_mechanism"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0056
                goto L_0x0049
            L_0x0056:
                r2 = 10
                goto L_0x00c8
            L_0x005a:
                java.lang.String r2 = "attrs"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0063
                goto L_0x0049
            L_0x0063:
                r2 = 9
                goto L_0x00c8
            L_0x0067:
                java.lang.String r2 = "timestamp"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0070
                goto L_0x0049
            L_0x0070:
                r2 = 8
                goto L_0x00c8
            L_0x0074:
                java.lang.String r2 = "init"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x007d
                goto L_0x0049
            L_0x007d:
                r2 = 7
                goto L_0x00c8
            L_0x007f:
                java.lang.String r2 = "sid"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0088
                goto L_0x0049
            L_0x0088:
                r2 = 6
                goto L_0x00c8
            L_0x008a:
                java.lang.String r2 = "seq"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x0093
                goto L_0x0049
            L_0x0093:
                r2 = 5
                goto L_0x00c8
            L_0x0095:
                java.lang.String r2 = "did"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x009e
                goto L_0x0049
            L_0x009e:
                r2 = 4
                goto L_0x00c8
            L_0x00a0:
                boolean r2 = r0.equals(r14)
                if (r2 != 0) goto L_0x00a7
                goto L_0x0049
            L_0x00a7:
                r2 = r22
                goto L_0x00c8
            L_0x00aa:
                boolean r2 = r0.equals(r13)
                if (r2 != 0) goto L_0x00b1
                goto L_0x0049
            L_0x00b1:
                r2 = r23
                goto L_0x00c8
            L_0x00b4:
                boolean r2 = r0.equals(r12)
                if (r2 != 0) goto L_0x00bb
                goto L_0x0049
            L_0x00bb:
                r2 = r11
                goto L_0x00c8
            L_0x00bd:
                java.lang.String r2 = "duration"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x00c6
                goto L_0x0049
            L_0x00c6:
                r2 = r26
            L_0x00c8:
                switch(r2) {
                    case 0: goto L_0x01b6;
                    case 1: goto L_0x01af;
                    case 2: goto L_0x01a8;
                    case 3: goto L_0x0197;
                    case 4: goto L_0x0186;
                    case 5: goto L_0x0177;
                    case 6: goto L_0x015f;
                    case 7: goto L_0x0158;
                    case 8: goto L_0x0151;
                    case 9: goto L_0x00e2;
                    case 10: goto L_0x00da;
                    default: goto L_0x00cb;
                }
            L_0x00cb:
                if (r7 != 0) goto L_0x00d3
                java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
                r2.<init>()
                r7 = r2
            L_0x00d3:
                r2 = r28
                r2.N0(r1, r7, r0)
                goto L_0x018c
            L_0x00da:
                r2 = r28
                java.lang.String r17 = r28.H0()
                goto L_0x018c
            L_0x00e2:
                r2 = r28
                r28.b()
                r14 = r19
                r13 = r20
            L_0x00eb:
                io.sentry.vendor.gson.stream.JsonToken r0 = r28.J()
                io.sentry.vendor.gson.stream.JsonToken r12 = io.sentry.vendor.gson.stream.JsonToken.NAME
                if (r0 != r12) goto L_0x014b
                java.lang.String r0 = r28.y()
                r0.hashCode()
                int r12 = r0.hashCode()
                switch(r12) {
                    case -85904877: goto L_0x0125;
                    case 1090594823: goto L_0x011c;
                    case 1480014044: goto L_0x0110;
                    case 1917799825: goto L_0x0104;
                    default: goto L_0x0101;
                }
            L_0x0101:
                r0 = r24
                goto L_0x0130
            L_0x0104:
                java.lang.String r12 = "user_agent"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x010d
                goto L_0x0101
            L_0x010d:
                r0 = r22
                goto L_0x0130
            L_0x0110:
                java.lang.String r12 = "ip_address"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x0119
                goto L_0x0101
            L_0x0119:
                r0 = r23
                goto L_0x0130
            L_0x011c:
                boolean r0 = r0.equals(r15)
                if (r0 != 0) goto L_0x0123
                goto L_0x0101
            L_0x0123:
                r0 = r11
                goto L_0x0130
            L_0x0125:
                java.lang.String r12 = "environment"
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x012e
                goto L_0x0101
            L_0x012e:
                r0 = r26
            L_0x0130:
                switch(r0) {
                    case 0: goto L_0x0146;
                    case 1: goto L_0x0141;
                    case 2: goto L_0x013c;
                    case 3: goto L_0x0137;
                    default: goto L_0x0133;
                }
            L_0x0133:
                r28.f0()
                goto L_0x00eb
            L_0x0137:
                java.lang.String r14 = r28.H0()
                goto L_0x00eb
            L_0x013c:
                java.lang.String r13 = r28.H0()
                goto L_0x00eb
            L_0x0141:
                java.lang.String r16 = r28.H0()
                goto L_0x00eb
            L_0x0146:
                java.lang.String r18 = r28.H0()
                goto L_0x00eb
            L_0x014b:
                r28.h()
                r15 = r18
                goto L_0x0192
            L_0x0151:
                r2 = r28
                java.util.Date r6 = r28.q0(r29)
                goto L_0x018c
            L_0x0158:
                r2 = r28
                java.lang.Boolean r10 = r28.m0()
                goto L_0x018c
            L_0x015f:
                r2 = r28
                java.lang.String r0 = r28.H0()     // Catch:{ IllegalArgumentException -> 0x016a }
                java.util.UUID r9 = java.util.UUID.fromString(r0)     // Catch:{ IllegalArgumentException -> 0x016b }
                goto L_0x018c
            L_0x016a:
                r0 = 0
            L_0x016b:
                io.sentry.SentryLevel r12 = io.sentry.SentryLevel.ERROR
                java.lang.Object[] r11 = new java.lang.Object[r11]
                r11[r26] = r0
                java.lang.String r0 = "%s sid is not valid."
                r1.c(r12, r0, r11)
                goto L_0x018c
            L_0x0177:
                r2 = r28
                java.lang.Long r11 = r28.x0()
                r15 = r18
                r14 = r19
                r13 = r20
                r12 = r21
                goto L_0x01c3
            L_0x0186:
                r2 = r28
                java.lang.String r8 = r28.H0()
            L_0x018c:
                r15 = r18
                r14 = r19
                r13 = r20
            L_0x0192:
                r12 = r21
            L_0x0194:
                r11 = r25
                goto L_0x01c3
            L_0x0197:
                r2 = r28
                java.lang.String r0 = r28.H0()
                java.lang.String r0 = io.sentry.util.p.b(r0)
                if (r0 == 0) goto L_0x018c
                io.sentry.Session$State r4 = io.sentry.Session.State.valueOf(r0)
                goto L_0x018c
            L_0x01a8:
                r2 = r28
                java.lang.Integer r3 = r28.u0()
                goto L_0x018c
            L_0x01af:
                r2 = r28
                java.util.Date r5 = r28.q0(r29)
                goto L_0x018c
            L_0x01b6:
                r2 = r28
                java.lang.Double r12 = r28.r0()
                r15 = r18
                r14 = r19
                r13 = r20
                goto L_0x0194
            L_0x01c3:
                r0 = r27
                goto L_0x0018
            L_0x01c7:
                r2 = r28
                r25 = r11
                if (r4 == 0) goto L_0x0206
                if (r5 == 0) goto L_0x01ff
                if (r3 == 0) goto L_0x01f8
                if (r16 == 0) goto L_0x01f1
                io.sentry.Session r0 = new io.sentry.Session
                int r1 = r3.intValue()
                r3 = r0
                r15 = r7
                r7 = r1
                r11 = r25
                r12 = r21
                r13 = r20
                r14 = r19
                r1 = r15
                r15 = r18
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                r0.m(r1)
                r28.h()
                return r0
            L_0x01f1:
                r0 = r27
                java.lang.Exception r1 = r0.c(r15, r1)
                throw r1
            L_0x01f8:
                r0 = r27
                java.lang.Exception r1 = r0.c(r13, r1)
                throw r1
            L_0x01ff:
                r0 = r27
                java.lang.Exception r1 = r0.c(r12, r1)
                throw r1
            L_0x0206:
                r0 = r27
                java.lang.Exception r1 = r0.c(r14, r1)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.a.a(io.sentry.y0, io.sentry.h0):io.sentry.Session");
        }
    }

    public Session(State state, Date date, Date date2, int i10, String str, UUID uuid, Boolean bool, Long l10, Double d10, String str2, String str3, String str4, String str5, String str6) {
        this.f30803q = new Object();
        this.f30795g = state;
        this.f30789a = date;
        this.f30790b = date2;
        this.f30791c = new AtomicInteger(i10);
        this.f30792d = str;
        this.f30793e = uuid;
        this.f30794f = bool;
        this.f30796h = l10;
        this.f30797j = d10;
        this.f30798k = str2;
        this.f30799l = str3;
        this.f30800m = str4;
        this.f30801n = str5;
        this.f30802p = str6;
    }

    private double a(Date date) {
        return ((double) Math.abs(date.getTime() - this.f30789a.getTime())) / 1000.0d;
    }

    private long h(Date date) {
        long time = date.getTime();
        if (time < 0) {
            return Math.abs(time);
        }
        return time;
    }

    /* renamed from: b */
    public Session clone() {
        return new Session(this.f30795g, this.f30789a, this.f30790b, this.f30791c.get(), this.f30792d, this.f30793e, this.f30794f, this.f30796h, this.f30797j, this.f30798k, this.f30799l, this.f30800m, this.f30801n, this.f30802p);
    }

    public void c() {
        d(g.c());
    }

    public void d(Date date) {
        synchronized (this.f30803q) {
            this.f30794f = null;
            if (this.f30795g == State.Ok) {
                this.f30795g = State.Exited;
            }
            if (date != null) {
                this.f30790b = date;
            } else {
                this.f30790b = g.c();
            }
            Date date2 = this.f30790b;
            if (date2 != null) {
                this.f30797j = Double.valueOf(a(date2));
                this.f30796h = Long.valueOf(h(this.f30790b));
            }
        }
    }

    public int e() {
        return this.f30791c.get();
    }

    public Boolean f() {
        return this.f30794f;
    }

    public String g() {
        return this.f30801n;
    }

    public UUID i() {
        return this.f30793e;
    }

    public Date j() {
        Date date = this.f30789a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public State k() {
        return this.f30795g;
    }

    @ApiStatus.Internal
    public void l() {
        this.f30794f = Boolean.TRUE;
    }

    public void m(Map<String, Object> map) {
        this.f30804t = map;
    }

    public boolean n(State state, String str, boolean z10) {
        return o(state, str, z10, (String) null);
    }

    public boolean o(State state, String str, boolean z10, String str2) {
        boolean z11;
        synchronized (this.f30803q) {
            boolean z12 = false;
            z11 = true;
            if (state != null) {
                try {
                    this.f30795g = state;
                    z12 = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (str != null) {
                this.f30799l = str;
                z12 = true;
            }
            if (z10) {
                this.f30791c.addAndGet(1);
                z12 = true;
            }
            if (str2 != null) {
                this.f30802p = str2;
            } else {
                z11 = z12;
            }
            if (z11) {
                this.f30794f = null;
                Date c10 = g.c();
                this.f30790b = c10;
                if (c10 != null) {
                    this.f30796h = Long.valueOf(h(c10));
                }
            }
        }
        return z11;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f30793e != null) {
            a1Var.N("sid").I(this.f30793e.toString());
        }
        if (this.f30792d != null) {
            a1Var.N("did").I(this.f30792d);
        }
        if (this.f30794f != null) {
            a1Var.N("init").F(this.f30794f);
        }
        a1Var.N("started").O(h0Var, this.f30789a);
        a1Var.N("status").O(h0Var, this.f30795g.name().toLowerCase(Locale.ROOT));
        if (this.f30796h != null) {
            a1Var.N("seq").G(this.f30796h);
        }
        a1Var.N(IdentityHttpResponse.ERRORS).E((long) this.f30791c.intValue());
        if (this.f30797j != null) {
            a1Var.N("duration").G(this.f30797j);
        }
        if (this.f30790b != null) {
            a1Var.N("timestamp").O(h0Var, this.f30790b);
        }
        if (this.f30802p != null) {
            a1Var.N("abnormal_mechanism").O(h0Var, this.f30802p);
        }
        a1Var.N("attrs");
        a1Var.e();
        a1Var.N("release").O(h0Var, this.f30801n);
        if (this.f30800m != null) {
            a1Var.N("environment").O(h0Var, this.f30800m);
        }
        if (this.f30798k != null) {
            a1Var.N("ip_address").O(h0Var, this.f30798k);
        }
        if (this.f30799l != null) {
            a1Var.N("user_agent").O(h0Var, this.f30799l);
        }
        a1Var.h();
        Map<String, Object> map = this.f30804t;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f30804t.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Session(java.lang.String r16, io.sentry.protocol.x r17, java.lang.String r18, java.lang.String r19) {
        /*
            r15 = this;
            io.sentry.Session$State r1 = io.sentry.Session.State.Ok
            java.util.Date r2 = io.sentry.g.c()
            java.util.Date r3 = io.sentry.g.c()
            java.util.UUID r6 = java.util.UUID.randomUUID()
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            if (r17 == 0) goto L_0x0017
            java.lang.String r0 = r17.m()
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r10 = r0
            r11 = 0
            r14 = 0
            r4 = 0
            r8 = 0
            r9 = 0
            r0 = r15
            r5 = r16
            r12 = r18
            r13 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.<init>(java.lang.String, io.sentry.protocol.x, java.lang.String, java.lang.String):void");
    }
}
