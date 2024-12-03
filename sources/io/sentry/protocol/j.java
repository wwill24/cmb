package io.sentry.protocol;

import com.google.firebase.analytics.FirebaseAnalytics;
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
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

public final class j implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31484a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31485b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31486c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Object f31487d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31488e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f31489f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f31490g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Long f31491h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f31492j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f31493k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, Object> f31494l;

    public static final class a implements s0<j> {
        /* renamed from: b */
        public j a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            j jVar = new j();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1650269616:
                        if (y10.equals("fragment")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1077554975:
                        if (y10.equals(FirebaseAnalytics.Param.METHOD)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 100589:
                        if (y10.equals("env")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 116079:
                        if (y10.equals("url")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3076010:
                        if (y10.equals("data")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 106069776:
                        if (y10.equals("other")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 795307910:
                        if (y10.equals(HeadersExtension.ELEMENT)) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 952189583:
                        if (y10.equals("cookies")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 1252988030:
                        if (y10.equals("body_size")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case 1595298664:
                        if (y10.equals("query_string")) {
                            c10 = 9;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = jVar.f31493k = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = jVar.f31485b = y0Var.H0();
                        break;
                    case 2:
                        Map map = (Map) y0Var.B0();
                        if (map == null) {
                            break;
                        } else {
                            Map unused3 = jVar.f31490g = b.b(map);
                            break;
                        }
                    case 3:
                        String unused4 = jVar.f31484a = y0Var.H0();
                        break;
                    case 4:
                        Object unused5 = jVar.f31487d = y0Var.B0();
                        break;
                    case 5:
                        Map map2 = (Map) y0Var.B0();
                        if (map2 == null) {
                            break;
                        } else {
                            Map unused6 = jVar.f31492j = b.b(map2);
                            break;
                        }
                    case 6:
                        Map map3 = (Map) y0Var.B0();
                        if (map3 == null) {
                            break;
                        } else {
                            Map unused7 = jVar.f31489f = b.b(map3);
                            break;
                        }
                    case 7:
                        String unused8 = jVar.f31488e = y0Var.H0();
                        break;
                    case 8:
                        Long unused9 = jVar.f31491h = y0Var.x0();
                        break;
                    case 9:
                        String unused10 = jVar.f31486c = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            jVar.l(concurrentHashMap);
            y0Var.h();
            return jVar;
        }
    }

    public j() {
    }

    public j(j jVar) {
        this.f31484a = jVar.f31484a;
        this.f31488e = jVar.f31488e;
        this.f31485b = jVar.f31485b;
        this.f31486c = jVar.f31486c;
        this.f31489f = b.b(jVar.f31489f);
        this.f31490g = b.b(jVar.f31490g);
        this.f31492j = b.b(jVar.f31492j);
        this.f31494l = b.b(jVar.f31494l);
        this.f31487d = jVar.f31487d;
        this.f31493k = jVar.f31493k;
        this.f31491h = jVar.f31491h;
    }

    public Map<String, String> k() {
        return this.f31489f;
    }

    public void l(Map<String, Object> map) {
        this.f31494l = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31484a != null) {
            a1Var.N("url").I(this.f31484a);
        }
        if (this.f31485b != null) {
            a1Var.N(FirebaseAnalytics.Param.METHOD).I(this.f31485b);
        }
        if (this.f31486c != null) {
            a1Var.N("query_string").I(this.f31486c);
        }
        if (this.f31487d != null) {
            a1Var.N("data").O(h0Var, this.f31487d);
        }
        if (this.f31488e != null) {
            a1Var.N("cookies").I(this.f31488e);
        }
        if (this.f31489f != null) {
            a1Var.N(HeadersExtension.ELEMENT).O(h0Var, this.f31489f);
        }
        if (this.f31490g != null) {
            a1Var.N("env").O(h0Var, this.f31490g);
        }
        if (this.f31492j != null) {
            a1Var.N("other").O(h0Var, this.f31492j);
        }
        if (this.f31493k != null) {
            a1Var.N("fragment").O(h0Var, this.f31493k);
        }
        if (this.f31491h != null) {
            a1Var.N("body_size").O(h0Var, this.f31491h);
        }
        Map<String, Object> map = this.f31494l;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31494l.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
