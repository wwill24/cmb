package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.s;
import com.google.protobuf.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class p0<T> implements z0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f21928a;

    /* renamed from: b  reason: collision with root package name */
    private final f1<?, ?> f21929b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21930c;

    /* renamed from: d  reason: collision with root package name */
    private final o<?> f21931d;

    private p0(f1<?, ?> f1Var, o<?> oVar, l0 l0Var) {
        this.f21929b = f1Var;
        this.f21930c = oVar.e(l0Var);
        this.f21931d = oVar;
        this.f21928a = l0Var;
    }

    private <UT, UB> int h(f1<UT, UB> f1Var, T t10) {
        return f1Var.i(f1Var.g(t10));
    }

    private <UT, UB, ET extends s.b<ET>> void i(f1<UT, UB> f1Var, o<ET> oVar, T t10, y0 y0Var, n nVar) throws IOException {
        UB f10 = f1Var.f(t10);
        s<ET> d10 = oVar.d(t10);
        do {
            try {
                if (y0Var.A() == Integer.MAX_VALUE) {
                    f1Var.o(t10, f10);
                    return;
                }
            } finally {
                f1Var.o(t10, f10);
            }
        } while (k(y0Var, nVar, oVar, d10, f1Var, f10));
    }

    static <T> p0<T> j(f1<?, ?> f1Var, o<?> oVar, l0 l0Var) {
        return new p0<>(f1Var, oVar, l0Var);
    }

    private <UT, UB, ET extends s.b<ET>> boolean k(y0 y0Var, n nVar, o<ET> oVar, s<ET> sVar, f1<UT, UB> f1Var, UB ub2) throws IOException {
        int a10 = y0Var.a();
        if (a10 == WireFormat.f21702a) {
            int i10 = 0;
            Object obj = null;
            ByteString byteString = null;
            while (y0Var.A() != Integer.MAX_VALUE) {
                int a11 = y0Var.a();
                if (a11 == WireFormat.f21704c) {
                    i10 = y0Var.h();
                    obj = oVar.b(nVar, this.f21928a, i10);
                } else if (a11 == WireFormat.f21705d) {
                    if (obj != null) {
                        oVar.h(y0Var, obj, nVar, sVar);
                    } else {
                        byteString = y0Var.o();
                    }
                } else if (!y0Var.D()) {
                    break;
                }
            }
            if (y0Var.a() == WireFormat.f21703b) {
                if (byteString != null) {
                    if (obj != null) {
                        oVar.i(byteString, obj, nVar, sVar);
                    } else {
                        f1Var.d(ub2, i10, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.b();
        } else if (WireFormat.b(a10) != 2) {
            return y0Var.D();
        } else {
            Object b10 = oVar.b(nVar, this.f21928a, WireFormat.a(a10));
            if (b10 == null) {
                return f1Var.m(ub2, y0Var);
            }
            oVar.h(y0Var, b10, nVar, sVar);
            return true;
        }
    }

    private <UT, UB> void l(f1<UT, UB> f1Var, T t10, Writer writer) throws IOException {
        f1Var.s(f1Var.g(t10), writer);
    }

    public void a(T t10, T t11) {
        b1.G(this.f21929b, t10, t11);
        if (this.f21930c) {
            b1.E(this.f21931d, t10, t11);
        }
    }

    public void b(T t10) {
        this.f21929b.j(t10);
        this.f21931d.f(t10);
    }

    public final boolean c(T t10) {
        return this.f21931d.c(t10).p();
    }

    public int d(T t10) {
        int h10 = h(this.f21929b, t10) + 0;
        if (this.f21930c) {
            return h10 + this.f21931d.c(t10).j();
        }
        return h10;
    }

    public void e(T t10, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> t11 = this.f21931d.c(t10).t();
        while (t11.hasNext()) {
            Map.Entry next = t11.next();
            s.b bVar = (s.b) next.getKey();
            if (bVar.m() != WireFormat.JavaType.MESSAGE || bVar.f() || bVar.n()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof y.b) {
                writer.b(bVar.getNumber(), ((y.b) next).a().e());
            } else {
                writer.b(bVar.getNumber(), next.getValue());
            }
        }
        l(this.f21929b, t10, writer);
    }

    public boolean equals(T t10, T t11) {
        if (!this.f21929b.g(t10).equals(this.f21929b.g(t11))) {
            return false;
        }
        if (this.f21930c) {
            return this.f21931d.c(t10).equals(this.f21931d.c(t11));
        }
        return true;
    }

    public void f(T t10, y0 y0Var, n nVar) throws IOException {
        i(this.f21929b, this.f21931d, t10, y0Var, nVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.protobuf.GeneratedMessageLite$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(T r11, byte[] r12, int r13, int r14, com.google.protobuf.e.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.g1 r1 = r0.unknownFields
            com.google.protobuf.g1 r2 = com.google.protobuf.g1.c()
            if (r1 != r2) goto L_0x0011
            com.google.protobuf.g1 r1 = com.google.protobuf.g1.o()
            r0.unknownFields = r1
        L_0x0011:
            com.google.protobuf.GeneratedMessageLite$c r11 = (com.google.protobuf.GeneratedMessageLite.c) r11
            com.google.protobuf.s r11 = r11.a()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = com.google.protobuf.e.I(r12, r13, r15)
            int r13 = r15.f21784a
            int r3 = com.google.protobuf.WireFormat.f21702a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = com.google.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L_0x0066
            com.google.protobuf.o<?> r2 = r10.f21931d
            com.google.protobuf.n r3 = r15.f21787d
            com.google.protobuf.l0 r5 = r10.f21928a
            int r6 = com.google.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$e r8 = (com.google.protobuf.GeneratedMessageLite.e) r8
            if (r8 == 0) goto L_0x005b
            com.google.protobuf.v0 r13 = com.google.protobuf.v0.a()
            com.google.protobuf.l0 r2 = r8.c()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.z0 r13 = r13.c(r2)
            int r13 = com.google.protobuf.e.p(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$d r2 = r8.f21678d
            java.lang.Object r3 = r15.f21786c
            r11.y(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.e.G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = com.google.protobuf.e.P(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = com.google.protobuf.e.I(r12, r4, r15)
            int r6 = r15.f21784a
            int r7 = com.google.protobuf.WireFormat.a(r6)
            int r8 = com.google.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            com.google.protobuf.v0 r6 = com.google.protobuf.v0.a()
            com.google.protobuf.l0 r7 = r2.c()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.z0 r6 = r6.c(r7)
            int r4 = com.google.protobuf.e.p(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$d r6 = r2.f21678d
            java.lang.Object r7 = r15.f21786c
            r11.y(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = com.google.protobuf.e.b(r12, r4, r15)
            java.lang.Object r3 = r15.f21786c
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = com.google.protobuf.e.I(r12, r4, r15)
            int r13 = r15.f21784a
            com.google.protobuf.o<?> r2 = r10.f21931d
            com.google.protobuf.n r6 = r15.f21787d
            com.google.protobuf.l0 r7 = r10.f21928a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$e r2 = (com.google.protobuf.GeneratedMessageLite.e) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = com.google.protobuf.WireFormat.f21703b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = com.google.protobuf.e.P(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = com.google.protobuf.WireFormat.c(r13, r5)
            r1.r(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.p0.g(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):void");
    }

    public int hashCode(T t10) {
        int hashCode = this.f21929b.g(t10).hashCode();
        if (this.f21930c) {
            return (hashCode * 53) + this.f21931d.c(t10).hashCode();
        }
        return hashCode;
    }

    public T newInstance() {
        l0 l0Var = this.f21928a;
        if (l0Var instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) l0Var).newMutableInstance();
        }
        return l0Var.newBuilderForType().buildPartial();
    }
}
