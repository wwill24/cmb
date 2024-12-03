package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class o0<T> implements y0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f5354a;

    /* renamed from: b  reason: collision with root package name */
    private final e1<?, ?> f5355b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5356c;

    /* renamed from: d  reason: collision with root package name */
    private final o<?> f5357d;

    private o0(e1<?, ?> e1Var, o<?> oVar, k0 k0Var) {
        this.f5355b = e1Var;
        this.f5356c = oVar.e(k0Var);
        this.f5357d = oVar;
        this.f5354a = k0Var;
    }

    private <UT, UB> int g(e1<UT, UB> e1Var, T t10) {
        return e1Var.i(e1Var.g(t10));
    }

    private <UT, UB, ET extends s.b<ET>> void h(e1<UT, UB> e1Var, o<ET> oVar, T t10, x0 x0Var, n nVar) throws IOException {
        UB f10 = e1Var.f(t10);
        s<ET> d10 = oVar.d(t10);
        do {
            try {
                if (x0Var.A() == Integer.MAX_VALUE) {
                    e1Var.o(t10, f10);
                    return;
                }
            } finally {
                e1Var.o(t10, f10);
            }
        } while (j(x0Var, nVar, oVar, d10, e1Var, f10));
    }

    static <T> o0<T> i(e1<?, ?> e1Var, o<?> oVar, k0 k0Var) {
        return new o0<>(e1Var, oVar, k0Var);
    }

    private <UT, UB, ET extends s.b<ET>> boolean j(x0 x0Var, n nVar, o<ET> oVar, s<ET> sVar, e1<UT, UB> e1Var, UB ub2) throws IOException {
        int a10 = x0Var.a();
        if (a10 == WireFormat.f5157a) {
            int i10 = 0;
            Object obj = null;
            ByteString byteString = null;
            while (x0Var.A() != Integer.MAX_VALUE) {
                int a11 = x0Var.a();
                if (a11 == WireFormat.f5159c) {
                    i10 = x0Var.h();
                    obj = oVar.b(nVar, this.f5354a, i10);
                } else if (a11 == WireFormat.f5160d) {
                    if (obj != null) {
                        oVar.h(x0Var, obj, nVar, sVar);
                    } else {
                        byteString = x0Var.o();
                    }
                } else if (!x0Var.D()) {
                    break;
                }
            }
            if (x0Var.a() == WireFormat.f5158b) {
                if (byteString != null) {
                    if (obj != null) {
                        oVar.i(byteString, obj, nVar, sVar);
                    } else {
                        e1Var.d(ub2, i10, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.a();
        } else if (WireFormat.b(a10) != 2) {
            return x0Var.D();
        } else {
            Object b10 = oVar.b(nVar, this.f5354a, WireFormat.a(a10));
            if (b10 == null) {
                return e1Var.m(ub2, x0Var);
            }
            oVar.h(x0Var, b10, nVar, sVar);
            return true;
        }
    }

    private <UT, UB> void k(e1<UT, UB> e1Var, T t10, Writer writer) throws IOException {
        e1Var.s(e1Var.g(t10), writer);
    }

    public void a(T t10, T t11) {
        a1.G(this.f5355b, t10, t11);
        if (this.f5356c) {
            a1.E(this.f5357d, t10, t11);
        }
    }

    public void b(T t10) {
        this.f5355b.j(t10);
        this.f5357d.f(t10);
    }

    public final boolean c(T t10) {
        return this.f5357d.c(t10).p();
    }

    public int d(T t10) {
        int g10 = g(this.f5355b, t10) + 0;
        if (this.f5356c) {
            return g10 + this.f5357d.c(t10).j();
        }
        return g10;
    }

    public void e(T t10, x0 x0Var, n nVar) throws IOException {
        h(this.f5355b, this.f5357d, t10, x0Var, nVar);
    }

    public boolean equals(T t10, T t11) {
        if (!this.f5355b.g(t10).equals(this.f5355b.g(t11))) {
            return false;
        }
        if (this.f5356c) {
            return this.f5357d.c(t10).equals(this.f5357d.c(t11));
        }
        return true;
    }

    public void f(T t10, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> s10 = this.f5357d.c(t10).s();
        while (s10.hasNext()) {
            Map.Entry next = s10.next();
            s.b bVar = (s.b) next.getKey();
            if (bVar.m() != WireFormat.JavaType.MESSAGE || bVar.f() || bVar.n()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof x.b) {
                writer.b(bVar.getNumber(), ((x.b) next).a().e());
            } else {
                writer.b(bVar.getNumber(), next.getValue());
            }
        }
        k(this.f5355b, t10, writer);
    }

    public int hashCode(T t10) {
        int hashCode = this.f5355b.g(t10).hashCode();
        if (this.f5356c) {
            return (hashCode * 53) + this.f5357d.c(t10).hashCode();
        }
        return hashCode;
    }

    public T newInstance() {
        return this.f5354a.newBuilderForType().buildPartial();
    }
}
