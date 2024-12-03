package io.sentry;

import io.sentry.d;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.c;
import io.sentry.protocol.j;
import io.sentry.protocol.m;
import io.sentry.protocol.o;
import io.sentry.protocol.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

public abstract class p2 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public o f31373a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Contexts f31374b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public m f31375c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public j f31376d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f31377e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31378f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f31379g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f31380h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public x f31381j;

    /* renamed from: k  reason: collision with root package name */
    protected transient Throwable f31382k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f31383l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f31384m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public List<d> f31385n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public c f31386p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Map<String, Object> f31387q;

    public static final class a {
        public boolean a(p2 p2Var, String str, y0 y0Var, h0 h0Var) throws Exception {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1840434063:
                    if (str.equals("debug_meta")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -758770169:
                    if (str.equals("server_name")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -567312220:
                    if (str.equals("contexts")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -85904877:
                    if (str.equals("environment")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case -51457840:
                    if (str.equals("breadcrumbs")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 113722:
                    if (str.equals("sdk")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 3083686:
                    if (str.equals("dist")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 3552281:
                    if (str.equals("tags")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (str.equals("user")) {
                        c10 = 8;
                        break;
                    }
                    break;
                case 96965648:
                    if (str.equals("extra")) {
                        c10 = 9;
                        break;
                    }
                    break;
                case 278118624:
                    if (str.equals("event_id")) {
                        c10 = 10;
                        break;
                    }
                    break;
                case 1090594823:
                    if (str.equals("release")) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 1095692943:
                    if (str.equals("request")) {
                        c10 = 12;
                        break;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        c10 = 13;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    c unused = p2Var.f31386p = (c) y0Var.E0(h0Var, new c.a());
                    return true;
                case 1:
                    String unused2 = p2Var.f31383l = y0Var.H0();
                    return true;
                case 2:
                    p2Var.f31374b.putAll(new Contexts.a().a(y0Var, h0Var));
                    return true;
                case 3:
                    String unused3 = p2Var.f31379g = y0Var.H0();
                    return true;
                case 4:
                    List unused4 = p2Var.f31385n = y0Var.v0(h0Var, new d.a());
                    return true;
                case 5:
                    m unused5 = p2Var.f31375c = (m) y0Var.E0(h0Var, new m.a());
                    return true;
                case 6:
                    String unused6 = p2Var.f31384m = y0Var.H0();
                    return true;
                case 7:
                    Map unused7 = p2Var.f31377e = io.sentry.util.b.b((Map) y0Var.B0());
                    return true;
                case 8:
                    x unused8 = p2Var.f31381j = (x) y0Var.E0(h0Var, new x.a());
                    return true;
                case 9:
                    Map unused9 = p2Var.f31387q = io.sentry.util.b.b((Map) y0Var.B0());
                    return true;
                case 10:
                    o unused10 = p2Var.f31373a = (o) y0Var.E0(h0Var, new o.a());
                    return true;
                case 11:
                    String unused11 = p2Var.f31378f = y0Var.H0();
                    return true;
                case 12:
                    j unused12 = p2Var.f31376d = (j) y0Var.E0(h0Var, new j.a());
                    return true;
                case 13:
                    String unused13 = p2Var.f31380h = y0Var.H0();
                    return true;
                default:
                    return false;
            }
        }
    }

    public static final class b {
        public void a(p2 p2Var, a1 a1Var, h0 h0Var) throws IOException {
            if (p2Var.f31373a != null) {
                a1Var.N("event_id").O(h0Var, p2Var.f31373a);
            }
            a1Var.N("contexts").O(h0Var, p2Var.f31374b);
            if (p2Var.f31375c != null) {
                a1Var.N("sdk").O(h0Var, p2Var.f31375c);
            }
            if (p2Var.f31376d != null) {
                a1Var.N("request").O(h0Var, p2Var.f31376d);
            }
            if (p2Var.f31377e != null && !p2Var.f31377e.isEmpty()) {
                a1Var.N("tags").O(h0Var, p2Var.f31377e);
            }
            if (p2Var.f31378f != null) {
                a1Var.N("release").I(p2Var.f31378f);
            }
            if (p2Var.f31379g != null) {
                a1Var.N("environment").I(p2Var.f31379g);
            }
            if (p2Var.f31380h != null) {
                a1Var.N("platform").I(p2Var.f31380h);
            }
            if (p2Var.f31381j != null) {
                a1Var.N("user").O(h0Var, p2Var.f31381j);
            }
            if (p2Var.f31383l != null) {
                a1Var.N("server_name").I(p2Var.f31383l);
            }
            if (p2Var.f31384m != null) {
                a1Var.N("dist").I(p2Var.f31384m);
            }
            if (p2Var.f31385n != null && !p2Var.f31385n.isEmpty()) {
                a1Var.N("breadcrumbs").O(h0Var, p2Var.f31385n);
            }
            if (p2Var.f31386p != null) {
                a1Var.N("debug_meta").O(h0Var, p2Var.f31386p);
            }
            if (p2Var.f31387q != null && !p2Var.f31387q.isEmpty()) {
                a1Var.N("extra").O(h0Var, p2Var.f31387q);
            }
        }
    }

    protected p2(o oVar) {
        this.f31374b = new Contexts();
        this.f31373a = oVar;
    }

    public List<d> B() {
        return this.f31385n;
    }

    public Contexts C() {
        return this.f31374b;
    }

    public c D() {
        return this.f31386p;
    }

    public String E() {
        return this.f31384m;
    }

    public String F() {
        return this.f31379g;
    }

    public o G() {
        return this.f31373a;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> H() {
        return this.f31387q;
    }

    public String I() {
        return this.f31380h;
    }

    public String J() {
        return this.f31378f;
    }

    public j K() {
        return this.f31376d;
    }

    public m L() {
        return this.f31375c;
    }

    public String M() {
        return this.f31383l;
    }

    @ApiStatus.Internal
    public Map<String, String> N() {
        return this.f31377e;
    }

    public Throwable O() {
        Throwable th2 = this.f31382k;
        if (th2 instanceof ExceptionMechanismException) {
            return ((ExceptionMechanismException) th2).c();
        }
        return th2;
    }

    @ApiStatus.Internal
    public Throwable P() {
        return this.f31382k;
    }

    public x Q() {
        return this.f31381j;
    }

    public void R(List<d> list) {
        this.f31385n = io.sentry.util.b.a(list);
    }

    public void S(c cVar) {
        this.f31386p = cVar;
    }

    public void T(String str) {
        this.f31384m = str;
    }

    public void U(String str) {
        this.f31379g = str;
    }

    public void V(String str, Object obj) {
        if (this.f31387q == null) {
            this.f31387q = new HashMap();
        }
        this.f31387q.put(str, obj);
    }

    public void W(Map<String, Object> map) {
        this.f31387q = io.sentry.util.b.c(map);
    }

    public void X(String str) {
        this.f31380h = str;
    }

    public void Y(String str) {
        this.f31378f = str;
    }

    public void Z(j jVar) {
        this.f31376d = jVar;
    }

    public void a0(m mVar) {
        this.f31375c = mVar;
    }

    public void b0(String str) {
        this.f31383l = str;
    }

    public void c0(String str, String str2) {
        if (this.f31377e == null) {
            this.f31377e = new HashMap();
        }
        this.f31377e.put(str, str2);
    }

    public void d0(Map<String, String> map) {
        this.f31377e = io.sentry.util.b.c(map);
    }

    public void e0(x xVar) {
        this.f31381j = xVar;
    }

    protected p2() {
        this(new o());
    }
}
