package io.sentry.protocol;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class z implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31586a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31587b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31588c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31589d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Double f31590e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Double f31591f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Double f31592g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Double f31593h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f31594j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Double f31595k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public List<z> f31596l;

    /* renamed from: m  reason: collision with root package name */
    private Map<String, Object> f31597m;

    public static final class a implements s0<z> {
        /* renamed from: b */
        public z a(y0 y0Var, h0 h0Var) throws Exception {
            z zVar = new z();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1784982718:
                        if (y10.equals("rendering_system")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1618432855:
                        if (y10.equals("identifier")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (y10.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 120:
                        if (y10.equals("x")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 121:
                        if (y10.equals("y")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 114586:
                        if (y10.equals("tag")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 92909918:
                        if (y10.equals("alpha")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 113126854:
                        if (y10.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case 1659526655:
                        if (y10.equals("children")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case 1941332754:
                        if (y10.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) {
                            c10 = 10;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = zVar.f31586a = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = zVar.f31588c = y0Var.H0();
                        break;
                    case 2:
                        Double unused3 = zVar.f31591f = y0Var.r0();
                        break;
                    case 3:
                        Double unused4 = zVar.f31592g = y0Var.r0();
                        break;
                    case 4:
                        Double unused5 = zVar.f31593h = y0Var.r0();
                        break;
                    case 5:
                        String unused6 = zVar.f31589d = y0Var.H0();
                        break;
                    case 6:
                        String unused7 = zVar.f31587b = y0Var.H0();
                        break;
                    case 7:
                        Double unused8 = zVar.f31595k = y0Var.r0();
                        break;
                    case 8:
                        Double unused9 = zVar.f31590e = y0Var.r0();
                        break;
                    case 9:
                        List unused10 = zVar.f31596l = y0Var.v0(h0Var, this);
                        break;
                    case 10:
                        String unused11 = zVar.f31594j = y0Var.H0();
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
            zVar.q(hashMap);
            return zVar;
        }
    }

    public void l(Double d10) {
        this.f31595k = d10;
    }

    public void m(List<z> list) {
        this.f31596l = list;
    }

    public void n(Double d10) {
        this.f31591f = d10;
    }

    public void o(String str) {
        this.f31588c = str;
    }

    public void p(String str) {
        this.f31587b = str;
    }

    public void q(Map<String, Object> map) {
        this.f31597m = map;
    }

    public void r(String str) {
        this.f31594j = str;
    }

    public void s(Double d10) {
        this.f31590e = d10;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31586a != null) {
            a1Var.N("rendering_system").I(this.f31586a);
        }
        if (this.f31587b != null) {
            a1Var.N("type").I(this.f31587b);
        }
        if (this.f31588c != null) {
            a1Var.N("identifier").I(this.f31588c);
        }
        if (this.f31589d != null) {
            a1Var.N("tag").I(this.f31589d);
        }
        if (this.f31590e != null) {
            a1Var.N(ViewHierarchyConstants.DIMENSION_WIDTH_KEY).G(this.f31590e);
        }
        if (this.f31591f != null) {
            a1Var.N(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY).G(this.f31591f);
        }
        if (this.f31592g != null) {
            a1Var.N("x").G(this.f31592g);
        }
        if (this.f31593h != null) {
            a1Var.N("y").G(this.f31593h);
        }
        if (this.f31594j != null) {
            a1Var.N(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY).I(this.f31594j);
        }
        if (this.f31595k != null) {
            a1Var.N("alpha").G(this.f31595k);
        }
        List<z> list = this.f31596l;
        if (list != null && !list.isEmpty()) {
            a1Var.N("children").O(h0Var, this.f31596l);
        }
        Map<String, Object> map = this.f31597m;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31597m.get(next));
            }
        }
        a1Var.h();
    }

    public void t(Double d10) {
        this.f31592g = d10;
    }

    public void u(Double d10) {
        this.f31593h = d10;
    }
}
