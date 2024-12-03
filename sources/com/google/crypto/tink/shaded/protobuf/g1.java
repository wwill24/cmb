package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class g1 {

    /* renamed from: f  reason: collision with root package name */
    private static final g1 f20801f = new g1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f20802a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f20803b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f20804c;

    /* renamed from: d  reason: collision with root package name */
    private int f20805d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20806e;

    private g1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i10;
        int i11 = this.f20802a;
        int[] iArr = this.f20803b;
        if (i11 == iArr.length) {
            if (i11 < 4) {
                i10 = 8;
            } else {
                i10 = i11 >> 1;
            }
            int i12 = i11 + i10;
            this.f20803b = Arrays.copyOf(iArr, i12);
            this.f20804c = Arrays.copyOf(this.f20804c, i12);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static g1 e() {
        return f20801f;
    }

    private static int h(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    private static int i(Object[] objArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + objArr[i12].hashCode();
        }
        return i11;
    }

    static g1 k(g1 g1Var, g1 g1Var2) {
        int i10 = g1Var.f20802a + g1Var2.f20802a;
        int[] copyOf = Arrays.copyOf(g1Var.f20803b, i10);
        System.arraycopy(g1Var2.f20803b, 0, copyOf, g1Var.f20802a, g1Var2.f20802a);
        Object[] copyOf2 = Arrays.copyOf(g1Var.f20804c, i10);
        System.arraycopy(g1Var2.f20804c, 0, copyOf2, g1Var.f20802a, g1Var2.f20802a);
        return new g1(i10, copyOf, copyOf2, true);
    }

    static g1 l() {
        return new g1();
    }

    private static void p(int i10, Object obj, Writer writer) throws IOException {
        int a10 = WireFormat.a(i10);
        int b10 = WireFormat.b(i10);
        if (b10 == 0) {
            writer.u(a10, ((Long) obj).longValue());
        } else if (b10 == 1) {
            writer.s(a10, ((Long) obj).longValue());
        } else if (b10 == 2) {
            writer.M(a10, (ByteString) obj);
        } else if (b10 != 3) {
            if (b10 == 5) {
                writer.c(a10, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.d());
        } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
            writer.x(a10);
            ((g1) obj).q(writer);
            writer.C(a10);
        } else {
            writer.C(a10);
            ((g1) obj).q(writer);
            writer.x(a10);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f20806e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        int i10 = this.f20802a;
        if (i10 != g1Var.f20802a || !c(this.f20803b, g1Var.f20803b, i10) || !d(this.f20804c, g1Var.f20804c, this.f20802a)) {
            return false;
        }
        return true;
    }

    public int f() {
        int i10;
        int i11 = this.f20805d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f20802a; i13++) {
            int i14 = this.f20803b[i13];
            int a10 = WireFormat.a(i14);
            int b10 = WireFormat.b(i14);
            if (b10 == 0) {
                i10 = CodedOutputStream.X(a10, ((Long) this.f20804c[i13]).longValue());
            } else if (b10 == 1) {
                i10 = CodedOutputStream.o(a10, ((Long) this.f20804c[i13]).longValue());
            } else if (b10 == 2) {
                i10 = CodedOutputStream.g(a10, (ByteString) this.f20804c[i13]);
            } else if (b10 == 3) {
                i10 = (CodedOutputStream.U(a10) * 2) + ((g1) this.f20804c[i13]).f();
            } else if (b10 == 5) {
                i10 = CodedOutputStream.m(a10, ((Integer) this.f20804c[i13]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.d());
            }
            i12 += i10;
        }
        this.f20805d = i12;
        return i12;
    }

    public int g() {
        int i10 = this.f20805d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f20802a; i12++) {
            i11 += CodedOutputStream.I(WireFormat.a(this.f20803b[i12]), (ByteString) this.f20804c[i12]);
        }
        this.f20805d = i11;
        return i11;
    }

    public int hashCode() {
        int i10 = this.f20802a;
        return ((((527 + i10) * 31) + h(this.f20803b, i10)) * 31) + i(this.f20804c, this.f20802a);
    }

    public void j() {
        this.f20806e = false;
    }

    /* access modifiers changed from: package-private */
    public final void m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f20802a; i11++) {
            n0.c(sb2, i10, String.valueOf(WireFormat.a(this.f20803b[i11])), this.f20804c[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int i10, Object obj) {
        a();
        b();
        int[] iArr = this.f20803b;
        int i11 = this.f20802a;
        iArr[i11] = i10;
        this.f20804c[i11] = obj;
        this.f20802a = i11 + 1;
    }

    /* access modifiers changed from: package-private */
    public void o(Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i10 = this.f20802a - 1; i10 >= 0; i10--) {
                writer.b(WireFormat.a(this.f20803b[i10]), this.f20804c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f20802a; i11++) {
            writer.b(WireFormat.a(this.f20803b[i11]), this.f20804c[i11]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f20802a != 0) {
            if (writer.t() == Writer.FieldOrder.ASCENDING) {
                for (int i10 = 0; i10 < this.f20802a; i10++) {
                    p(this.f20803b[i10], this.f20804c[i10], writer);
                }
                return;
            }
            for (int i11 = this.f20802a - 1; i11 >= 0; i11--) {
                p(this.f20803b[i11], this.f20804c[i11], writer);
            }
        }
    }

    private g1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f20805d = -1;
        this.f20802a = i10;
        this.f20803b = iArr;
        this.f20804c = objArr;
        this.f20806e = z10;
    }
}
