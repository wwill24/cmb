package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.f4;
import io.sentry.g;
import io.sentry.h0;
import io.sentry.i4;
import io.sentry.j4;
import io.sentry.p2;
import io.sentry.protocol.f;
import io.sentry.protocol.r;
import io.sentry.protocol.w;
import io.sentry.r4;
import io.sentry.s0;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class v extends p2 implements c1 {
    /* access modifiers changed from: private */
    public final Map<String, f> B;
    /* access modifiers changed from: private */
    public w C;
    private Map<String, Object> D;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public String f31567t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Double f31568w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Double f31569x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final List<r> f31570y;

    /* renamed from: z  reason: collision with root package name */
    private final String f31571z;

    public static final class a implements s0<v> {
        /* renamed from: b */
        public v a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            v vVar = new v("", Double.valueOf(0.0d), (Double) null, new ArrayList(), new HashMap(), new w(TransactionNameSource.CUSTOM.apiName()));
            p2.a aVar = new p2.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1526966919:
                        if (y10.equals("start_timestamp")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -362243017:
                        if (y10.equals("measurements")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (y10.equals("timestamp")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 109638249:
                        if (y10.equals("spans")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 508716399:
                        if (y10.equals("transaction_info")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (y10.equals("transaction")) {
                            c10 = 6;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        try {
                            Double r02 = y0Var.r0();
                            if (r02 == null) {
                                break;
                            } else {
                                Double unused = vVar.f31568w = r02;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            Date q02 = y0Var.q0(h0Var);
                            if (q02 == null) {
                                break;
                            } else {
                                Double unused3 = vVar.f31568w = Double.valueOf(g.b(q02));
                                break;
                            }
                        }
                    case 1:
                        Map A0 = y0Var.A0(h0Var, new f.a());
                        if (A0 == null) {
                            break;
                        } else {
                            vVar.B.putAll(A0);
                            break;
                        }
                    case 2:
                        y0Var.G();
                        break;
                    case 3:
                        try {
                            Double r03 = y0Var.r0();
                            if (r03 == null) {
                                break;
                            } else {
                                Double unused4 = vVar.f31569x = r03;
                                break;
                            }
                        } catch (NumberFormatException unused5) {
                            Date q03 = y0Var.q0(h0Var);
                            if (q03 == null) {
                                break;
                            } else {
                                Double unused6 = vVar.f31569x = Double.valueOf(g.b(q03));
                                break;
                            }
                        }
                    case 4:
                        List v02 = y0Var.v0(h0Var, new r.a());
                        if (v02 == null) {
                            break;
                        } else {
                            vVar.f31570y.addAll(v02);
                            break;
                        }
                    case 5:
                        w unused7 = vVar.C = new w.a().a(y0Var, h0Var);
                        break;
                    case 6:
                        String unused8 = vVar.f31567t = y0Var.H0();
                        break;
                    default:
                        if (!aVar.a(vVar, y10, y0Var, h0Var)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            y0Var.N0(h0Var, concurrentHashMap, y10);
                            break;
                        } else {
                            break;
                        }
                }
            }
            vVar.r0(concurrentHashMap);
            y0Var.h();
            return vVar;
        }
    }

    public v(f4 f4Var) {
        super(f4Var.d());
        this.f31570y = new ArrayList();
        this.f31571z = "transaction";
        this.B = new HashMap();
        l.c(f4Var, "sentryTracer is required");
        this.f31568w = Double.valueOf(g.l(f4Var.getStartDate().h()));
        this.f31569x = Double.valueOf(g.l(f4Var.getStartDate().e(f4Var.n())));
        this.f31567t = f4Var.getName();
        for (i4 next : f4Var.x()) {
            if (Boolean.TRUE.equals(next.z())) {
                this.f31570y.add(new r(next));
            }
        }
        Contexts C2 = C();
        C2.putAll(f4Var.y());
        j4 m10 = f4Var.m();
        C2.n(new j4(m10.j(), m10.g(), m10.c(), m10.b(), m10.a(), m10.f(), m10.h()));
        for (Map.Entry next2 : m10.i().entrySet()) {
            c0((String) next2.getKey(), (String) next2.getValue());
        }
        Map<String, Object> z10 = f4Var.z();
        if (z10 != null) {
            for (Map.Entry next3 : z10.entrySet()) {
                V((String) next3.getKey(), next3.getValue());
            }
        }
        this.C = new w(f4Var.e().apiName());
    }

    private BigDecimal l0(Double d10) {
        return BigDecimal.valueOf(d10.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public Map<String, f> m0() {
        return this.B;
    }

    public r4 n0() {
        j4 e10 = C().e();
        if (e10 == null) {
            return null;
        }
        return e10.f();
    }

    public List<r> o0() {
        return this.f31570y;
    }

    public boolean p0() {
        return this.f31569x != null;
    }

    public boolean q0() {
        r4 n02 = n0();
        if (n02 == null) {
            return false;
        }
        return n02.c().booleanValue();
    }

    public void r0(Map<String, Object> map) {
        this.D = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31567t != null) {
            a1Var.N("transaction").I(this.f31567t);
        }
        a1Var.N("start_timestamp").O(h0Var, l0(this.f31568w));
        if (this.f31569x != null) {
            a1Var.N("timestamp").O(h0Var, l0(this.f31569x));
        }
        if (!this.f31570y.isEmpty()) {
            a1Var.N("spans").O(h0Var, this.f31570y);
        }
        a1Var.N("type").I("transaction");
        if (!this.B.isEmpty()) {
            a1Var.N("measurements").O(h0Var, this.B);
        }
        a1Var.N("transaction_info").O(h0Var, this.C);
        new p2.b().a(this, a1Var, h0Var);
        Map<String, Object> map = this.D;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.D.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    @ApiStatus.Internal
    public v(String str, Double d10, Double d11, List<r> list, Map<String, f> map, w wVar) {
        ArrayList arrayList = new ArrayList();
        this.f31570y = arrayList;
        this.f31571z = "transaction";
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        this.f31567t = str;
        this.f31568w = d10;
        this.f31569x = d11;
        arrayList.addAll(list);
        hashMap.putAll(map);
        this.C = wVar;
    }
}
