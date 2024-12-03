package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.List;
import we.l;

final class q5 {
    private long A;
    private long B;
    private long C;
    private long D;
    private String E;
    private boolean F;
    private long G;
    private long H;

    /* renamed from: a  reason: collision with root package name */
    private final u4 f40175a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40176b;

    /* renamed from: c  reason: collision with root package name */
    private String f40177c;

    /* renamed from: d  reason: collision with root package name */
    private String f40178d;

    /* renamed from: e  reason: collision with root package name */
    private String f40179e;

    /* renamed from: f  reason: collision with root package name */
    private String f40180f;

    /* renamed from: g  reason: collision with root package name */
    private long f40181g;

    /* renamed from: h  reason: collision with root package name */
    private long f40182h;

    /* renamed from: i  reason: collision with root package name */
    private long f40183i;

    /* renamed from: j  reason: collision with root package name */
    private String f40184j;

    /* renamed from: k  reason: collision with root package name */
    private long f40185k;

    /* renamed from: l  reason: collision with root package name */
    private String f40186l;

    /* renamed from: m  reason: collision with root package name */
    private long f40187m;

    /* renamed from: n  reason: collision with root package name */
    private long f40188n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f40189o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f40190p;

    /* renamed from: q  reason: collision with root package name */
    private String f40191q;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f40192r;

    /* renamed from: s  reason: collision with root package name */
    private long f40193s;

    /* renamed from: t  reason: collision with root package name */
    private List f40194t;

    /* renamed from: u  reason: collision with root package name */
    private String f40195u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f40196v;

    /* renamed from: w  reason: collision with root package name */
    private long f40197w;

    /* renamed from: x  reason: collision with root package name */
    private long f40198x;

    /* renamed from: y  reason: collision with root package name */
    private long f40199y;

    /* renamed from: z  reason: collision with root package name */
    private long f40200z;

    q5(u4 u4Var, String str) {
        p.k(u4Var);
        p.g(str);
        this.f40175a = u4Var;
        this.f40176b = str;
        u4Var.f().h();
    }

    public final long A() {
        this.f40175a.f().h();
        return 0;
    }

    public final void B(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.E, str);
        this.E = str;
    }

    public final void C(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40183i != j10;
        this.f40183i = j10;
    }

    public final void D(long j10) {
        boolean z10;
        boolean z11 = true;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.a(z10);
        this.f40175a.f().h();
        boolean z12 = this.F;
        if (this.f40181g == j10) {
            z11 = false;
        }
        this.F = z12 | z11;
        this.f40181g = j10;
    }

    public final void E(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40182h != j10;
        this.f40182h = j10;
    }

    public final void F(boolean z10) {
        this.f40175a.f().h();
        this.F |= this.f40189o != z10;
        this.f40189o = z10;
    }

    public final void G(Boolean bool) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40192r, bool);
        this.f40192r = bool;
    }

    public final void H(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40179e, str);
        this.f40179e = str;
    }

    public final void I(List list) {
        ArrayList arrayList;
        this.f40175a.f().h();
        if (!l.a(this.f40194t, list)) {
            this.F = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f40194t = arrayList;
        }
    }

    public final void J(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40195u, str);
        this.f40195u = str;
    }

    public final void K(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40198x != j10;
        this.f40198x = j10;
    }

    public final void L(boolean z10) {
        this.f40175a.f().h();
        this.F |= this.f40196v != z10;
        this.f40196v = z10;
    }

    public final void M(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40197w != j10;
        this.f40197w = j10;
    }

    public final boolean N() {
        this.f40175a.f().h();
        return this.f40190p;
    }

    public final boolean O() {
        this.f40175a.f().h();
        return this.f40189o;
    }

    public final boolean P() {
        this.f40175a.f().h();
        return this.F;
    }

    public final boolean Q() {
        this.f40175a.f().h();
        return this.f40196v;
    }

    public final long R() {
        this.f40175a.f().h();
        return this.f40185k;
    }

    public final long S() {
        this.f40175a.f().h();
        return this.G;
    }

    public final long T() {
        this.f40175a.f().h();
        return this.B;
    }

    public final long U() {
        this.f40175a.f().h();
        return this.C;
    }

    public final long V() {
        this.f40175a.f().h();
        return this.A;
    }

    public final long W() {
        this.f40175a.f().h();
        return this.f40200z;
    }

    public final long X() {
        this.f40175a.f().h();
        return this.D;
    }

    public final long Y() {
        this.f40175a.f().h();
        return this.f40199y;
    }

    public final long Z() {
        this.f40175a.f().h();
        return this.f40188n;
    }

    public final String a() {
        this.f40175a.f().h();
        return this.f40178d;
    }

    public final long a0() {
        this.f40175a.f().h();
        return this.f40193s;
    }

    public final String b() {
        this.f40175a.f().h();
        return this.E;
    }

    public final long b0() {
        this.f40175a.f().h();
        return this.H;
    }

    public final String c() {
        this.f40175a.f().h();
        return this.f40179e;
    }

    public final long c0() {
        this.f40175a.f().h();
        return this.f40187m;
    }

    public final String d() {
        this.f40175a.f().h();
        return this.f40195u;
    }

    public final long d0() {
        this.f40175a.f().h();
        return this.f40183i;
    }

    public final List e() {
        this.f40175a.f().h();
        return this.f40194t;
    }

    public final long e0() {
        this.f40175a.f().h();
        return this.f40181g;
    }

    public final void f() {
        this.f40175a.f().h();
        this.F = false;
    }

    public final long f0() {
        this.f40175a.f().h();
        return this.f40182h;
    }

    public final void g() {
        this.f40175a.f().h();
        long j10 = this.f40181g + 1;
        if (j10 > 2147483647L) {
            this.f40175a.d().w().b("Bundle index overflow. appId", q3.z(this.f40176b));
            j10 = 0;
        }
        this.F = true;
        this.f40181g = j10;
    }

    public final long g0() {
        this.f40175a.f().h();
        return this.f40198x;
    }

    public final void h(String str) {
        this.f40175a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ l.a(this.f40191q, str);
        this.f40191q = str;
    }

    public final long h0() {
        this.f40175a.f().h();
        return this.f40197w;
    }

    public final void i(boolean z10) {
        this.f40175a.f().h();
        this.F |= this.f40190p != z10;
        this.f40190p = z10;
    }

    public final Boolean i0() {
        this.f40175a.f().h();
        return this.f40192r;
    }

    public final void j(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40177c, str);
        this.f40177c = str;
    }

    public final String j0() {
        this.f40175a.f().h();
        return this.f40191q;
    }

    public final void k(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40186l, str);
        this.f40186l = str;
    }

    public final String k0() {
        this.f40175a.f().h();
        String str = this.E;
        B((String) null);
        return str;
    }

    public final void l(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40184j, str);
        this.f40184j = str;
    }

    public final String l0() {
        this.f40175a.f().h();
        return this.f40176b;
    }

    public final void m(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40185k != j10;
        this.f40185k = j10;
    }

    public final String m0() {
        this.f40175a.f().h();
        return this.f40177c;
    }

    public final void n(long j10) {
        this.f40175a.f().h();
        this.F |= this.G != j10;
        this.G = j10;
    }

    public final String n0() {
        this.f40175a.f().h();
        return this.f40186l;
    }

    public final void o(long j10) {
        this.f40175a.f().h();
        this.F |= this.B != j10;
        this.B = j10;
    }

    public final String o0() {
        this.f40175a.f().h();
        return this.f40184j;
    }

    public final void p(long j10) {
        this.f40175a.f().h();
        this.F |= this.C != j10;
        this.C = j10;
    }

    public final String p0() {
        this.f40175a.f().h();
        return this.f40180f;
    }

    public final void q(long j10) {
        this.f40175a.f().h();
        this.F |= this.A != j10;
        this.A = j10;
    }

    public final void r(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40200z != j10;
        this.f40200z = j10;
    }

    public final void s(long j10) {
        this.f40175a.f().h();
        this.F |= this.D != j10;
        this.D = j10;
    }

    public final void t(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40199y != j10;
        this.f40199y = j10;
    }

    public final void u(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40188n != j10;
        this.f40188n = j10;
    }

    public final void v(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40193s != j10;
        this.f40193s = j10;
    }

    public final void w(long j10) {
        this.f40175a.f().h();
        this.F |= this.H != j10;
        this.H = j10;
    }

    public final void x(String str) {
        this.f40175a.f().h();
        this.F |= !l.a(this.f40180f, str);
        this.f40180f = str;
    }

    public final void y(String str) {
        this.f40175a.f().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.F |= true ^ l.a(this.f40178d, str);
        this.f40178d = str;
    }

    public final void z(long j10) {
        this.f40175a.f().h();
        this.F |= this.f40187m != j10;
        this.f40187m = j10;
    }
}
