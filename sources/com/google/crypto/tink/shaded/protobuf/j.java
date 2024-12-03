package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.f0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class j implements y0 {

    /* renamed from: a  reason: collision with root package name */
    private final i f20829a;

    /* renamed from: b  reason: collision with root package name */
    private int f20830b;

    /* renamed from: c  reason: collision with root package name */
    private int f20831c;

    /* renamed from: d  reason: collision with root package name */
    private int f20832d = 0;

    private j(i iVar) {
        i iVar2 = (i) x.b(iVar, "input");
        this.f20829a = iVar2;
        iVar2.f20810d = this;
    }

    public static j Q(i iVar) {
        j jVar = iVar.f20810d;
        if (jVar != null) {
            return jVar;
        }
        return new j(iVar);
    }

    private <T> T R(z0<T> z0Var, o oVar) throws IOException {
        int i10 = this.f20831c;
        this.f20831c = WireFormat.c(WireFormat.a(this.f20830b), 4);
        try {
            T newInstance = z0Var.newInstance();
            z0Var.f(newInstance, this, oVar);
            z0Var.b(newInstance);
            if (this.f20830b == this.f20831c) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.g();
        } finally {
            this.f20831c = i10;
        }
    }

    private <T> T S(z0<T> z0Var, o oVar) throws IOException {
        int A = this.f20829a.A();
        i iVar = this.f20829a;
        if (iVar.f20807a < iVar.f20808b) {
            int j10 = iVar.j(A);
            T newInstance = z0Var.newInstance();
            this.f20829a.f20807a++;
            z0Var.f(newInstance, this, oVar);
            z0Var.b(newInstance);
            this.f20829a.a(0);
            i iVar2 = this.f20829a;
            iVar2.f20807a--;
            iVar2.i(j10);
            return newInstance;
        }
        throw InvalidProtocolBufferException.h();
    }

    private void U(int i10) throws IOException {
        if (this.f20829a.d() != i10) {
            throw InvalidProtocolBufferException.j();
        }
    }

    private void V(int i10) throws IOException {
        if (WireFormat.b(this.f20830b) != i10) {
            throw InvalidProtocolBufferException.d();
        }
    }

    private void W(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    private void X(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    public int A() throws IOException {
        int i10 = this.f20832d;
        if (i10 != 0) {
            this.f20830b = i10;
            this.f20832d = 0;
        } else {
            this.f20830b = this.f20829a.z();
        }
        int i11 = this.f20830b;
        if (i11 == 0 || i11 == this.f20831c) {
            return a.e.API_PRIORITY_OTHER;
        }
        return WireFormat.a(i11);
    }

    public void B(List<String> list) throws IOException {
        T(list, false);
    }

    public void C(List<Float> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof u) {
            u uVar = (u) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 2) {
                int A = this.f20829a.A();
                W(A);
                int d10 = this.f20829a.d() + A;
                do {
                    uVar.g(this.f20829a.q());
                } while (this.f20829a.d() < d10);
            } else if (b10 == 5) {
                do {
                    uVar.g(this.f20829a.q());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 2) {
                int A2 = this.f20829a.A();
                W(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Float.valueOf(this.f20829a.q()));
                } while (this.f20829a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Float.valueOf(this.f20829a.q()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public boolean D() throws IOException {
        int i10;
        if (this.f20829a.e() || (i10 = this.f20830b) == this.f20831c) {
            return false;
        }
        return this.f20829a.C(i10);
    }

    public int E() throws IOException {
        V(5);
        return this.f20829a.t();
    }

    public void F(List<ByteString> list) throws IOException {
        int z10;
        if (WireFormat.b(this.f20830b) == 2) {
            do {
                list.add(o());
                if (!this.f20829a.e()) {
                    z10 = this.f20829a.z();
                } else {
                    return;
                }
            } while (z10 == this.f20830b);
            this.f20832d = z10;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public void G(List<Double> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof l) {
            l lVar = (l) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 1) {
                do {
                    lVar.g(this.f20829a.m());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int A = this.f20829a.A();
                X(A);
                int d10 = this.f20829a.d() + A;
                do {
                    lVar.g(this.f20829a.m());
                } while (this.f20829a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 1) {
                do {
                    list.add(Double.valueOf(this.f20829a.m()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int A2 = this.f20829a.A();
                X(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Double.valueOf(this.f20829a.m()));
                } while (this.f20829a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public long H() throws IOException {
        V(0);
        return this.f20829a.s();
    }

    public String I() throws IOException {
        V(2);
        return this.f20829a.y();
    }

    public <T> T J(z0<T> z0Var, o oVar) throws IOException {
        V(3);
        return R(z0Var, oVar);
    }

    public <T> T K(Class<T> cls, o oVar) throws IOException {
        V(3);
        return R(v0.a().d(cls), oVar);
    }

    public <K, V> void L(Map<K, V> map, f0.a<K, V> aVar, o oVar) throws IOException {
        V(2);
        this.f20829a.j(this.f20829a.A());
        throw null;
    }

    public <T> void M(List<T> list, z0<T> z0Var, o oVar) throws IOException {
        int z10;
        if (WireFormat.b(this.f20830b) == 2) {
            int i10 = this.f20830b;
            do {
                list.add(S(z0Var, oVar));
                if (!this.f20829a.e() && this.f20832d == 0) {
                    z10 = this.f20829a.z();
                } else {
                    return;
                }
            } while (z10 == i10);
            this.f20832d = z10;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public <T> T N(z0<T> z0Var, o oVar) throws IOException {
        V(2);
        return S(z0Var, oVar);
    }

    public <T> T O(Class<T> cls, o oVar) throws IOException {
        V(2);
        return S(v0.a().d(cls), oVar);
    }

    public <T> void P(List<T> list, z0<T> z0Var, o oVar) throws IOException {
        int z10;
        if (WireFormat.b(this.f20830b) == 3) {
            int i10 = this.f20830b;
            do {
                list.add(R(z0Var, oVar));
                if (!this.f20829a.e() && this.f20832d == 0) {
                    z10 = this.f20829a.z();
                } else {
                    return;
                }
            } while (z10 == i10);
            this.f20832d = z10;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public void T(List<String> list, boolean z10) throws IOException {
        String str;
        int z11;
        int z12;
        if (WireFormat.b(this.f20830b) != 2) {
            throw InvalidProtocolBufferException.d();
        } else if (!(list instanceof b0) || z10) {
            do {
                if (z10) {
                    str = I();
                } else {
                    str = z();
                }
                list.add(str);
                if (!this.f20829a.e()) {
                    z11 = this.f20829a.z();
                } else {
                    return;
                }
            } while (z11 == this.f20830b);
            this.f20832d = z11;
        } else {
            b0 b0Var = (b0) list;
            do {
                b0Var.F1(o());
                if (!this.f20829a.e()) {
                    z12 = this.f20829a.z();
                } else {
                    return;
                }
            } while (z12 == this.f20830b);
            this.f20832d = z12;
        }
    }

    public int a() {
        return this.f20830b;
    }

    public long b() throws IOException {
        V(1);
        return this.f20829a.p();
    }

    public void c(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 2) {
                int A = this.f20829a.A();
                W(A);
                int d10 = this.f20829a.d() + A;
                do {
                    wVar.U0(this.f20829a.t());
                } while (this.f20829a.d() < d10);
            } else if (b10 == 5) {
                do {
                    wVar.U0(this.f20829a.t());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 2) {
                int A2 = this.f20829a.A();
                W(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Integer.valueOf(this.f20829a.t()));
                } while (this.f20829a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20829a.t()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void d(List<Long> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f20829a.w());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    d0Var.i(this.f20829a.w());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f20829a.w()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Long.valueOf(this.f20829a.w()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public boolean e() throws IOException {
        V(0);
        return this.f20829a.k();
    }

    public long f() throws IOException {
        V(1);
        return this.f20829a.u();
    }

    public void g(List<Long> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f20829a.B());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    d0Var.i(this.f20829a.B());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f20829a.B()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Long.valueOf(this.f20829a.B()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int h() throws IOException {
        V(0);
        return this.f20829a.A();
    }

    public void i(List<Long> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f20829a.s());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    d0Var.i(this.f20829a.s());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f20829a.s()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Long.valueOf(this.f20829a.s()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void j(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    wVar.U0(this.f20829a.n());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    wVar.U0(this.f20829a.n());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20829a.n()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Integer.valueOf(this.f20829a.n()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int k() throws IOException {
        V(0);
        return this.f20829a.n();
    }

    public int l() throws IOException {
        V(0);
        return this.f20829a.v();
    }

    public void m(List<Boolean> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof g) {
            g gVar = (g) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    gVar.i(this.f20829a.k());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    gVar.i(this.f20829a.k());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f20829a.k()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Boolean.valueOf(this.f20829a.k()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void n(List<String> list) throws IOException {
        T(list, true);
    }

    public ByteString o() throws IOException {
        V(2);
        return this.f20829a.l();
    }

    public int p() throws IOException {
        V(0);
        return this.f20829a.r();
    }

    public void q(List<Long> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 1) {
                do {
                    d0Var.i(this.f20829a.p());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int A = this.f20829a.A();
                X(A);
                int d10 = this.f20829a.d() + A;
                do {
                    d0Var.i(this.f20829a.p());
                } while (this.f20829a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f20829a.p()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int A2 = this.f20829a.A();
                X(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Long.valueOf(this.f20829a.p()));
                } while (this.f20829a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void r(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    wVar.U0(this.f20829a.v());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    wVar.U0(this.f20829a.v());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20829a.v()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Integer.valueOf(this.f20829a.v()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public double readDouble() throws IOException {
        V(1);
        return this.f20829a.m();
    }

    public float readFloat() throws IOException {
        V(5);
        return this.f20829a.q();
    }

    public long s() throws IOException {
        V(0);
        return this.f20829a.B();
    }

    public void t(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    wVar.U0(this.f20829a.A());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    wVar.U0(this.f20829a.A());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20829a.A()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Integer.valueOf(this.f20829a.A()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int u() throws IOException {
        V(5);
        return this.f20829a.o();
    }

    public void v(List<Long> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 1) {
                do {
                    d0Var.i(this.f20829a.u());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int A = this.f20829a.A();
                X(A);
                int d10 = this.f20829a.d() + A;
                do {
                    d0Var.i(this.f20829a.u());
                } while (this.f20829a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f20829a.u()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int A2 = this.f20829a.A();
                X(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Long.valueOf(this.f20829a.u()));
                } while (this.f20829a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void w(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 0) {
                do {
                    wVar.U0(this.f20829a.r());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else if (b10 == 2) {
                int d10 = this.f20829a.d() + this.f20829a.A();
                do {
                    wVar.U0(this.f20829a.r());
                } while (this.f20829a.d() < d10);
                U(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20829a.r()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else if (b11 == 2) {
                int d11 = this.f20829a.d() + this.f20829a.A();
                do {
                    list.add(Integer.valueOf(this.f20829a.r()));
                } while (this.f20829a.d() < d11);
                U(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void x(List<Integer> list) throws IOException {
        int z10;
        int z11;
        if (list instanceof w) {
            w wVar = (w) list;
            int b10 = WireFormat.b(this.f20830b);
            if (b10 == 2) {
                int A = this.f20829a.A();
                W(A);
                int d10 = this.f20829a.d() + A;
                do {
                    wVar.U0(this.f20829a.o());
                } while (this.f20829a.d() < d10);
            } else if (b10 == 5) {
                do {
                    wVar.U0(this.f20829a.o());
                    if (!this.f20829a.e()) {
                        z11 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z11 == this.f20830b);
                this.f20832d = z11;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f20830b);
            if (b11 == 2) {
                int A2 = this.f20829a.A();
                W(A2);
                int d11 = this.f20829a.d() + A2;
                do {
                    list.add(Integer.valueOf(this.f20829a.o()));
                } while (this.f20829a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20829a.o()));
                    if (!this.f20829a.e()) {
                        z10 = this.f20829a.z();
                    } else {
                        return;
                    }
                } while (z10 == this.f20830b);
                this.f20832d = z10;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public long y() throws IOException {
        V(0);
        return this.f20829a.w();
    }

    public String z() throws IOException {
        V(2);
        return this.f20829a.x();
    }
}
