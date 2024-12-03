package androidx.datastore.preferences.protobuf;

import java.io.IOException;

abstract class e1<T, B> {
    e1() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(B b10, int i10, int i11);

    /* access modifiers changed from: package-private */
    public abstract void b(B b10, int i10, long j10);

    /* access modifiers changed from: package-private */
    public abstract void c(B b10, int i10, T t10);

    /* access modifiers changed from: package-private */
    public abstract void d(B b10, int i10, ByteString byteString);

    /* access modifiers changed from: package-private */
    public abstract void e(B b10, int i10, long j10);

    /* access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int h(T t10);

    /* access modifiers changed from: package-private */
    public abstract int i(T t10);

    /* access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T k(T t10, T t11);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(B r3, androidx.datastore.preferences.protobuf.x0 r4) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.A()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.e1.l(java.lang.Object, androidx.datastore.preferences.protobuf.x0):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean m(B b10, x0 x0Var) throws IOException {
        int a10 = x0Var.a();
        int a11 = WireFormat.a(a10);
        int b11 = WireFormat.b(a10);
        if (b11 == 0) {
            e(b10, a11, x0Var.H());
            return true;
        } else if (b11 == 1) {
            b(b10, a11, x0Var.b());
            return true;
        } else if (b11 == 2) {
            d(b10, a11, x0Var.o());
            return true;
        } else if (b11 == 3) {
            Object n10 = n();
            int c10 = WireFormat.c(a11, 4);
            l(n10, x0Var);
            if (c10 == x0Var.a()) {
                c(b10, a11, r(n10));
                return true;
            }
            throw InvalidProtocolBufferException.a();
        } else if (b11 == 4) {
            return false;
        } else {
            if (b11 == 5) {
                a(b10, a11, x0Var.u());
                return true;
            }
            throw InvalidProtocolBufferException.d();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract B n();

    /* access modifiers changed from: package-private */
    public abstract void o(Object obj, B b10);

    /* access modifiers changed from: package-private */
    public abstract void p(Object obj, T t10);

    /* access modifiers changed from: package-private */
    public abstract boolean q(x0 x0Var);

    /* access modifiers changed from: package-private */
    public abstract T r(B b10);

    /* access modifiers changed from: package-private */
    public abstract void s(T t10, Writer writer) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void t(T t10, Writer writer) throws IOException;
}
