package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.t;
import com.google.crypto.tink.shaded.protobuf.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class p0<T> implements z0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f20889a;

    /* renamed from: b  reason: collision with root package name */
    private final f1<?, ?> f20890b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20891c;

    /* renamed from: d  reason: collision with root package name */
    private final p<?> f20892d;

    private p0(f1<?, ?> f1Var, p<?> pVar, l0 l0Var) {
        this.f20890b = f1Var;
        this.f20891c = pVar.e(l0Var);
        this.f20892d = pVar;
        this.f20889a = l0Var;
    }

    private <UT, UB> int h(f1<UT, UB> f1Var, T t10) {
        return f1Var.i(f1Var.g(t10));
    }

    private <UT, UB, ET extends t.b<ET>> void i(f1<UT, UB> f1Var, p<ET> pVar, T t10, y0 y0Var, o oVar) throws IOException {
        UB f10 = f1Var.f(t10);
        t<ET> d10 = pVar.d(t10);
        do {
            try {
                if (y0Var.A() == Integer.MAX_VALUE) {
                    f1Var.o(t10, f10);
                    return;
                }
            } finally {
                f1Var.o(t10, f10);
            }
        } while (k(y0Var, oVar, pVar, d10, f1Var, f10));
    }

    static <T> p0<T> j(f1<?, ?> f1Var, p<?> pVar, l0 l0Var) {
        return new p0<>(f1Var, pVar, l0Var);
    }

    private <UT, UB, ET extends t.b<ET>> boolean k(y0 y0Var, o oVar, p<ET> pVar, t<ET> tVar, f1<UT, UB> f1Var, UB ub2) throws IOException {
        int a10 = y0Var.a();
        if (a10 == WireFormat.f20703a) {
            int i10 = 0;
            Object obj = null;
            ByteString byteString = null;
            while (y0Var.A() != Integer.MAX_VALUE) {
                int a11 = y0Var.a();
                if (a11 == WireFormat.f20705c) {
                    i10 = y0Var.h();
                    obj = pVar.b(oVar, this.f20889a, i10);
                } else if (a11 == WireFormat.f20706d) {
                    if (obj != null) {
                        pVar.h(y0Var, obj, oVar, tVar);
                    } else {
                        byteString = y0Var.o();
                    }
                } else if (!y0Var.D()) {
                    break;
                }
            }
            if (y0Var.a() == WireFormat.f20704b) {
                if (byteString != null) {
                    if (obj != null) {
                        pVar.i(byteString, obj, oVar, tVar);
                    } else {
                        f1Var.d(ub2, i10, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.a();
        } else if (WireFormat.b(a10) != 2) {
            return y0Var.D();
        } else {
            Object b10 = pVar.b(oVar, this.f20889a, WireFormat.a(a10));
            if (b10 == null) {
                return f1Var.m(ub2, y0Var);
            }
            pVar.h(y0Var, b10, oVar, tVar);
            return true;
        }
    }

    private <UT, UB> void l(f1<UT, UB> f1Var, T t10, Writer writer) throws IOException {
        f1Var.s(f1Var.g(t10), writer);
    }

    public void a(T t10, T t11) {
        b1.G(this.f20890b, t10, t11);
        if (this.f20891c) {
            b1.E(this.f20892d, t10, t11);
        }
    }

    public void b(T t10) {
        this.f20890b.j(t10);
        this.f20892d.f(t10);
    }

    public final boolean c(T t10) {
        return this.f20892d.c(t10).o();
    }

    public int d(T t10) {
        int h10 = h(this.f20890b, t10) + 0;
        if (this.f20891c) {
            return h10 + this.f20892d.c(t10).j();
        }
        return h10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(T r11, byte[] r12, int r13, int r14, com.google.crypto.tink.shaded.protobuf.e.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite r0 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite) r0
            com.google.crypto.tink.shaded.protobuf.g1 r1 = r0.unknownFields
            com.google.crypto.tink.shaded.protobuf.g1 r2 = com.google.crypto.tink.shaded.protobuf.g1.e()
            if (r1 != r2) goto L_0x0011
            com.google.crypto.tink.shaded.protobuf.g1 r1 = com.google.crypto.tink.shaded.protobuf.g1.l()
            r0.unknownFields = r1
        L_0x0011:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$c r11 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.c) r11
            com.google.crypto.tink.shaded.protobuf.t r11 = r11.C()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r13, r15)
            int r13 = r15.f20783a
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.f20703a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L_0x0066
            com.google.crypto.tink.shaded.protobuf.p<?> r2 = r10.f20892d
            com.google.crypto.tink.shaded.protobuf.o r3 = r15.f20786d
            com.google.crypto.tink.shaded.protobuf.l0 r5 = r10.f20889a
            int r6 = com.google.crypto.tink.shaded.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$e r8 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.e) r8
            if (r8 == 0) goto L_0x005b
            com.google.crypto.tink.shaded.protobuf.v0 r13 = com.google.crypto.tink.shaded.protobuf.v0.a()
            com.google.crypto.tink.shaded.protobuf.l0 r2 = r8.b()
            java.lang.Class r2 = r2.getClass()
            com.google.crypto.tink.shaded.protobuf.z0 r13 = r13.d(r2)
            int r13 = com.google.crypto.tink.shaded.protobuf.e.p(r13, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r2 = r8.f20686b
            java.lang.Object r3 = r15.f20785c
            r11.w(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.crypto.tink.shaded.protobuf.e.G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = com.google.crypto.tink.shaded.protobuf.e.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r4, r15)
            int r6 = r15.f20783a
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.a(r6)
            int r8 = com.google.crypto.tink.shaded.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            com.google.crypto.tink.shaded.protobuf.v0 r6 = com.google.crypto.tink.shaded.protobuf.v0.a()
            com.google.crypto.tink.shaded.protobuf.l0 r7 = r2.b()
            java.lang.Class r7 = r7.getClass()
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r6.d(r7)
            int r4 = com.google.crypto.tink.shaded.protobuf.e.p(r6, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r6 = r2.f20686b
            java.lang.Object r7 = r15.f20785c
            r11.w(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = com.google.crypto.tink.shaded.protobuf.e.b(r12, r4, r15)
            java.lang.Object r3 = r15.f20785c
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r4, r15)
            int r13 = r15.f20783a
            com.google.crypto.tink.shaded.protobuf.p<?> r2 = r10.f20892d
            com.google.crypto.tink.shaded.protobuf.o r6 = r15.f20786d
            com.google.crypto.tink.shaded.protobuf.l0 r7 = r10.f20889a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$e r2 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.e) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.f20704b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = com.google.crypto.tink.shaded.protobuf.e.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = com.google.crypto.tink.shaded.protobuf.WireFormat.c(r13, r5)
            r1.n(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r11 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.p0.e(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$b):void");
    }

    public boolean equals(T t10, T t11) {
        if (!this.f20890b.g(t10).equals(this.f20890b.g(t11))) {
            return false;
        }
        if (this.f20891c) {
            return this.f20892d.c(t10).equals(this.f20892d.c(t11));
        }
        return true;
    }

    public void f(T t10, y0 y0Var, o oVar) throws IOException {
        i(this.f20890b, this.f20892d, t10, y0Var, oVar);
    }

    public void g(T t10, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> r10 = this.f20892d.c(t10).r();
        while (r10.hasNext()) {
            Map.Entry next = r10.next();
            t.b bVar = (t.b) next.getKey();
            if (bVar.m() != WireFormat.JavaType.MESSAGE || bVar.f() || bVar.n()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof y.b) {
                writer.b(bVar.getNumber(), ((y.b) next).a().e());
            } else {
                writer.b(bVar.getNumber(), next.getValue());
            }
        }
        l(this.f20890b, t10, writer);
    }

    public int hashCode(T t10) {
        int hashCode = this.f20890b.g(t10).hashCode();
        if (this.f20891c) {
            return (hashCode * 53) + this.f20892d.c(t10).hashCode();
        }
        return hashCode;
    }

    public T newInstance() {
        return this.f20889a.newBuilderForType().buildPartial();
    }
}
