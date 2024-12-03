package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class l implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31500a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f31501b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f31502c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Integer f31503d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f31504e;

    public static final class a implements s0<l> {
        /* renamed from: b */
        public l a(y0 y0Var, h0 h0Var) throws Exception {
            l lVar = new l();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case 270207856:
                        if (y10.equals("sdk_name")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 696101379:
                        if (y10.equals("version_patchlevel")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 1111241618:
                        if (y10.equals("version_major")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 1111483790:
                        if (y10.equals("version_minor")) {
                            c10 = 3;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = lVar.f31500a = y0Var.H0();
                        break;
                    case 1:
                        Integer unused2 = lVar.f31503d = y0Var.u0();
                        break;
                    case 2:
                        Integer unused3 = lVar.f31501b = y0Var.u0();
                        break;
                    case 3:
                        Integer unused4 = lVar.f31502c = y0Var.u0();
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
            lVar.e(hashMap);
            return lVar;
        }
    }

    public void e(Map<String, Object> map) {
        this.f31504e = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31500a != null) {
            a1Var.N("sdk_name").I(this.f31500a);
        }
        if (this.f31501b != null) {
            a1Var.N("version_major").G(this.f31501b);
        }
        if (this.f31502c != null) {
            a1Var.N("version_minor").G(this.f31502c);
        }
        if (this.f31503d != null) {
            a1Var.N("version_patchlevel").G(this.f31503d);
        }
        Map<String, Object> map = this.f31504e;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31504e.get(next));
            }
        }
        a1Var.h();
    }
}
