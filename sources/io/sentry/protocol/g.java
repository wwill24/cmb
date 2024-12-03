package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class g implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final transient Thread f31464a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31465b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31466c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31467d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Boolean f31468e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Object> f31469f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f31470g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f31471h;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f31472j;

    public static final class a implements s0<g> {
        /* renamed from: b */
        public g a(y0 y0Var, h0 h0Var) throws Exception {
            g gVar = new g();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1724546052:
                        if (y10.equals("description")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3076010:
                        if (y10.equals("data")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3347973:
                        if (y10.equals("meta")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 692803388:
                        if (y10.equals("handled")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 989128517:
                        if (y10.equals("synthetic")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1297152568:
                        if (y10.equals("help_link")) {
                            c10 = 6;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = gVar.f31466c = y0Var.H0();
                        break;
                    case 1:
                        Map unused2 = gVar.f31470g = b.b((Map) y0Var.B0());
                        break;
                    case 2:
                        Map unused3 = gVar.f31469f = b.b((Map) y0Var.B0());
                        break;
                    case 3:
                        String unused4 = gVar.f31465b = y0Var.H0();
                        break;
                    case 4:
                        Boolean unused5 = gVar.f31468e = y0Var.m0();
                        break;
                    case 5:
                        Boolean unused6 = gVar.f31471h = y0Var.m0();
                        break;
                    case 6:
                        String unused7 = gVar.f31467d = y0Var.H0();
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
            gVar.k(hashMap);
            return gVar;
        }
    }

    public g() {
        this((Thread) null);
    }

    public Boolean h() {
        return this.f31468e;
    }

    public void i(Boolean bool) {
        this.f31468e = bool;
    }

    public void j(String str) {
        this.f31465b = str;
    }

    public void k(Map<String, Object> map) {
        this.f31472j = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31465b != null) {
            a1Var.N("type").I(this.f31465b);
        }
        if (this.f31466c != null) {
            a1Var.N("description").I(this.f31466c);
        }
        if (this.f31467d != null) {
            a1Var.N("help_link").I(this.f31467d);
        }
        if (this.f31468e != null) {
            a1Var.N("handled").F(this.f31468e);
        }
        if (this.f31469f != null) {
            a1Var.N("meta").O(h0Var, this.f31469f);
        }
        if (this.f31470g != null) {
            a1Var.N("data").O(h0Var, this.f31470g);
        }
        if (this.f31471h != null) {
            a1Var.N("synthetic").F(this.f31471h);
        }
        Map<String, Object> map = this.f31472j;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31472j.get(next));
            }
        }
        a1Var.h();
    }

    public g(Thread thread) {
        this.f31464a = thread;
    }
}
