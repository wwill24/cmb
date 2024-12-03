package com.google.protobuf;

import java.io.IOException;

class h1 extends f1<g1, g1> {
    h1() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public g1 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public int h(g1 g1Var) {
        return g1Var.d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public int i(g1 g1Var) {
        return g1Var.e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public g1 k(g1 g1Var, g1 g1Var2) {
        if (g1.c().equals(g1Var2)) {
            return g1Var;
        }
        if (g1.c().equals(g1Var)) {
            return g1.n(g1Var, g1Var2);
        }
        return g1Var.k(g1Var2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public g1 n() {
        return g1.o();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void o(Object obj, g1 g1Var) {
        p(obj, g1Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void p(Object obj, g1 g1Var) {
        ((GeneratedMessageLite) obj).unknownFields = g1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public g1 r(g1 g1Var) {
        g1Var.h();
        return g1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void s(g1 g1Var, Writer writer) throws IOException {
        g1Var.t(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void t(g1 g1Var, Writer writer) throws IOException {
        g1Var.v(writer);
    }

    /* access modifiers changed from: package-private */
    public void j(Object obj) {
        g(obj).h();
    }

    /* access modifiers changed from: package-private */
    public boolean q(y0 y0Var) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void a(g1 g1Var, int i10, int i11) {
        g1Var.r(WireFormat.c(i10, 5), Integer.valueOf(i11));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void b(g1 g1Var, int i10, long j10) {
        g1Var.r(WireFormat.c(i10, 1), Long.valueOf(j10));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void c(g1 g1Var, int i10, g1 g1Var2) {
        g1Var.r(WireFormat.c(i10, 3), g1Var2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void d(g1 g1Var, int i10, ByteString byteString) {
        g1Var.r(WireFormat.c(i10, 2), byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void e(g1 g1Var, int i10, long j10) {
        g1Var.r(WireFormat.c(i10, 0), Long.valueOf(j10));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public g1 f(Object obj) {
        g1 A = g(obj);
        if (A != g1.c()) {
            return A;
        }
        g1 o10 = g1.o();
        p(obj, o10);
        return o10;
    }
}
