package io.sentry;

import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a2 implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f30817a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f30818b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f30819c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f30820d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Long f30821e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Long f30822f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Long f30823g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Object> f30824h;

    public static final class a implements s0<a2> {
        /* renamed from: b */
        public a2 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            a2 a2Var = new a2();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -112372011:
                        if (y10.equals("relative_start_ns")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -84607876:
                        if (y10.equals("relative_end_ns")) {
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
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (y10.equals("trace_id")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 1566648660:
                        if (y10.equals("relative_cpu_end_ms")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1902256621:
                        if (y10.equals("relative_cpu_start_ms")) {
                            c10 = 6;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        Long x02 = y0Var.x0();
                        if (x02 == null) {
                            break;
                        } else {
                            Long unused = a2Var.f30820d = x02;
                            break;
                        }
                    case 1:
                        Long x03 = y0Var.x0();
                        if (x03 == null) {
                            break;
                        } else {
                            Long unused2 = a2Var.f30821e = x03;
                            break;
                        }
                    case 2:
                        String H0 = y0Var.H0();
                        if (H0 == null) {
                            break;
                        } else {
                            String unused3 = a2Var.f30817a = H0;
                            break;
                        }
                    case 3:
                        String H02 = y0Var.H0();
                        if (H02 == null) {
                            break;
                        } else {
                            String unused4 = a2Var.f30819c = H02;
                            break;
                        }
                    case 4:
                        String H03 = y0Var.H0();
                        if (H03 == null) {
                            break;
                        } else {
                            String unused5 = a2Var.f30818b = H03;
                            break;
                        }
                    case 5:
                        Long x04 = y0Var.x0();
                        if (x04 == null) {
                            break;
                        } else {
                            Long unused6 = a2Var.f30823g = x04;
                            break;
                        }
                    case 6:
                        Long x05 = y0Var.x0();
                        if (x05 == null) {
                            break;
                        } else {
                            Long unused7 = a2Var.f30822f = x05;
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
            a2Var.j(concurrentHashMap);
            y0Var.h();
            return a2Var;
        }
    }

    public a2() {
        this(p1.p(), 0L, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a2.class != obj.getClass()) {
            return false;
        }
        a2 a2Var = (a2) obj;
        if (!this.f30817a.equals(a2Var.f30817a) || !this.f30818b.equals(a2Var.f30818b) || !this.f30819c.equals(a2Var.f30819c) || !this.f30820d.equals(a2Var.f30820d) || !this.f30822f.equals(a2Var.f30822f) || !l.a(this.f30823g, a2Var.f30823g) || !l.a(this.f30821e, a2Var.f30821e) || !l.a(this.f30824h, a2Var.f30824h)) {
            return false;
        }
        return true;
    }

    public String h() {
        return this.f30817a;
    }

    public int hashCode() {
        return l.b(this.f30817a, this.f30818b, this.f30819c, this.f30820d, this.f30821e, this.f30822f, this.f30823g, this.f30824h);
    }

    public void i(Long l10, Long l11, Long l12, Long l13) {
        if (this.f30821e == null) {
            this.f30821e = Long.valueOf(l10.longValue() - l11.longValue());
            this.f30820d = Long.valueOf(this.f30820d.longValue() - l11.longValue());
            this.f30823g = Long.valueOf(l12.longValue() - l13.longValue());
            this.f30822f = Long.valueOf(this.f30822f.longValue() - l13.longValue());
        }
    }

    public void j(Map<String, Object> map) {
        this.f30824h = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("id").O(h0Var, this.f30817a);
        a1Var.N("trace_id").O(h0Var, this.f30818b);
        a1Var.N("name").O(h0Var, this.f30819c);
        a1Var.N("relative_start_ns").O(h0Var, this.f30820d);
        a1Var.N("relative_end_ns").O(h0Var, this.f30821e);
        a1Var.N("relative_cpu_start_ms").O(h0Var, this.f30822f);
        a1Var.N("relative_cpu_end_ms").O(h0Var, this.f30823g);
        Map<String, Object> map = this.f30824h;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f30824h.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public a2(n0 n0Var, Long l10, Long l11) {
        this.f30817a = n0Var.d().toString();
        this.f30818b = n0Var.m().j().toString();
        this.f30819c = n0Var.getName();
        this.f30820d = l10;
        this.f30822f = l11;
    }
}
