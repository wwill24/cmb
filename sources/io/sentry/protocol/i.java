package io.sentry.protocol;

import com.facebook.internal.ServerProtocol;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31477a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31478b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31479c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31480d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31481e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Boolean f31482f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Object> f31483g;

    public static final class a implements s0<i> {
        /* renamed from: b */
        public i a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            i iVar = new i();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -925311743:
                        if (y10.equals("rooted")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -339173787:
                        if (y10.equals("raw_description")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 94094958:
                        if (y10.equals("build")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 351608024:
                        if (y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 2015527638:
                        if (y10.equals("kernel_version")) {
                            c10 = 5;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        Boolean unused = iVar.f31482f = y0Var.m0();
                        break;
                    case 1:
                        String unused2 = iVar.f31479c = y0Var.H0();
                        break;
                    case 2:
                        String unused3 = iVar.f31477a = y0Var.H0();
                        break;
                    case 3:
                        String unused4 = iVar.f31480d = y0Var.H0();
                        break;
                    case 4:
                        String unused5 = iVar.f31478b = y0Var.H0();
                        break;
                    case 5:
                        String unused6 = iVar.f31481e = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            iVar.l(concurrentHashMap);
            y0Var.h();
            return iVar;
        }
    }

    public i() {
    }

    i(i iVar) {
        this.f31477a = iVar.f31477a;
        this.f31478b = iVar.f31478b;
        this.f31479c = iVar.f31479c;
        this.f31480d = iVar.f31480d;
        this.f31481e = iVar.f31481e;
        this.f31482f = iVar.f31482f;
        this.f31483g = b.b(iVar.f31483g);
    }

    public String g() {
        return this.f31477a;
    }

    public void h(String str) {
        this.f31480d = str;
    }

    public void i(String str) {
        this.f31481e = str;
    }

    public void j(String str) {
        this.f31477a = str;
    }

    public void k(Boolean bool) {
        this.f31482f = bool;
    }

    public void l(Map<String, Object> map) {
        this.f31483g = map;
    }

    public void m(String str) {
        this.f31478b = str;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31477a != null) {
            a1Var.N("name").I(this.f31477a);
        }
        if (this.f31478b != null) {
            a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31478b);
        }
        if (this.f31479c != null) {
            a1Var.N("raw_description").I(this.f31479c);
        }
        if (this.f31480d != null) {
            a1Var.N("build").I(this.f31480d);
        }
        if (this.f31481e != null) {
            a1Var.N("kernel_version").I(this.f31481e);
        }
        if (this.f31482f != null) {
            a1Var.N("rooted").F(this.f31482f);
        }
        Map<String, Object> map = this.f31483g;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31483g.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
