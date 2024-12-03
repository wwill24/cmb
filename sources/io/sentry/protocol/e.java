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

public final class e implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31451a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f31452b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31453c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31454d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Integer f31455e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31456f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Boolean f31457g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f31458h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f31459j;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, Object> f31460k;

    public static final class a implements s0<e> {
        /* renamed from: b */
        public e a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            e eVar = new e();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1421884745:
                        if (y10.equals("npot_support")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1085970574:
                        if (y10.equals("vendor_id")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1009234244:
                        if (y10.equals("multi_threaded_rendering")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3355:
                        if (y10.equals("id")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 59480866:
                        if (y10.equals("vendor_name")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 351608024:
                        if (y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 967446079:
                        if (y10.equals("api_type")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 1418777727:
                        if (y10.equals("memory_size")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = eVar.f31459j = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = eVar.f31453c = y0Var.H0();
                        break;
                    case 2:
                        Boolean unused3 = eVar.f31457g = y0Var.m0();
                        break;
                    case 3:
                        Integer unused4 = eVar.f31452b = y0Var.u0();
                        break;
                    case 4:
                        String unused5 = eVar.f31451a = y0Var.H0();
                        break;
                    case 5:
                        String unused6 = eVar.f31454d = y0Var.H0();
                        break;
                    case 6:
                        String unused7 = eVar.f31458h = y0Var.H0();
                        break;
                    case 7:
                        String unused8 = eVar.f31456f = y0Var.H0();
                        break;
                    case 8:
                        Integer unused9 = eVar.f31455e = y0Var.u0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            eVar.j(concurrentHashMap);
            y0Var.h();
            return eVar;
        }
    }

    public e() {
    }

    e(e eVar) {
        this.f31451a = eVar.f31451a;
        this.f31452b = eVar.f31452b;
        this.f31453c = eVar.f31453c;
        this.f31454d = eVar.f31454d;
        this.f31455e = eVar.f31455e;
        this.f31456f = eVar.f31456f;
        this.f31457g = eVar.f31457g;
        this.f31458h = eVar.f31458h;
        this.f31459j = eVar.f31459j;
        this.f31460k = b.b(eVar.f31460k);
    }

    public void j(Map<String, Object> map) {
        this.f31460k = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31451a != null) {
            a1Var.N("name").I(this.f31451a);
        }
        if (this.f31452b != null) {
            a1Var.N("id").G(this.f31452b);
        }
        if (this.f31453c != null) {
            a1Var.N("vendor_id").I(this.f31453c);
        }
        if (this.f31454d != null) {
            a1Var.N("vendor_name").I(this.f31454d);
        }
        if (this.f31455e != null) {
            a1Var.N("memory_size").G(this.f31455e);
        }
        if (this.f31456f != null) {
            a1Var.N("api_type").I(this.f31456f);
        }
        if (this.f31457g != null) {
            a1Var.N("multi_threaded_rendering").F(this.f31457g);
        }
        if (this.f31458h != null) {
            a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31458h);
        }
        if (this.f31459j != null) {
            a1Var.N("npot_support").I(this.f31459j);
        }
        Map<String, Object> map = this.f31460k;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31460k.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
