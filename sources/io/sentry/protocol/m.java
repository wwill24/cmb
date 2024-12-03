package io.sentry.protocol;

import com.facebook.internal.ServerProtocol;
import io.sentry.SentryLevel;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.p;
import io.sentry.s0;
import io.sentry.u3;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class m implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private String f31505a;

    /* renamed from: b  reason: collision with root package name */
    private String f31506b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Set<p> f31507c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f31508d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f31509e;

    public static final class a implements s0<m> {
        /* renamed from: b */
        public m a(y0 y0Var, h0 h0Var) throws Exception {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            y0Var.b();
            String str = null;
            String str2 = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 351608024:
                        if (y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 750867693:
                        if (y10.equals("packages")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 1487029535:
                        if (y10.equals("integrations")) {
                            c10 = 3;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        str = y0Var.G();
                        break;
                    case 1:
                        str2 = y0Var.G();
                        break;
                    case 2:
                        List v02 = y0Var.v0(h0Var, new p.a());
                        if (v02 == null) {
                            break;
                        } else {
                            arrayList.addAll(v02);
                            break;
                        }
                    case 3:
                        List list = (List) y0Var.B0();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            y0Var.h();
            if (str == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            } else if (str2 != null) {
                m mVar = new m(str, str2);
                Set unused = mVar.f31507c = new CopyOnWriteArraySet(arrayList);
                Set unused2 = mVar.f31508d = new CopyOnWriteArraySet(arrayList2);
                mVar.i(hashMap);
                return mVar;
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
        }
    }

    public m(String str, String str2) {
        this.f31505a = (String) l.c(str, "name is required.");
        this.f31506b = (String) l.c(str2, "version is required.");
    }

    public static m k(m mVar, String str, String str2) {
        l.c(str, "name is required.");
        l.c(str2, "version is required.");
        if (mVar == null) {
            return new m(str, str2);
        }
        mVar.h(str);
        mVar.j(str2);
        return mVar;
    }

    public void c(String str, String str2) {
        u3.c().b(str, str2);
    }

    public Set<String> d() {
        Set<String> set = this.f31508d;
        if (set != null) {
            return set;
        }
        return u3.c().d();
    }

    public String e() {
        return this.f31505a;
    }

    public Set<p> f() {
        Set<p> set = this.f31507c;
        if (set != null) {
            return set;
        }
        return u3.c().e();
    }

    public String g() {
        return this.f31506b;
    }

    public void h(String str) {
        this.f31505a = (String) l.c(str, "name is required.");
    }

    public void i(Map<String, Object> map) {
        this.f31509e = map;
    }

    public void j(String str) {
        this.f31506b = (String) l.c(str, "version is required.");
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("name").I(this.f31505a);
        a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31506b);
        Set<p> f10 = f();
        Set<String> d10 = d();
        if (!f10.isEmpty()) {
            a1Var.N("packages").O(h0Var, f10);
        }
        if (!d10.isEmpty()) {
            a1Var.N("integrations").O(h0Var, d10);
        }
        Map<String, Object> map = this.f31509e;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31509e.get(next));
            }
        }
        a1Var.h();
    }
}
