package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class g1 {

    /* renamed from: f  reason: collision with root package name */
    private static final g1 f21802f = new g1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f21803a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f21804b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f21805c;

    /* renamed from: d  reason: collision with root package name */
    private int f21806d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21807e;

    private g1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i10) {
        int[] iArr = this.f21804b;
        if (i10 > iArr.length) {
            int i11 = this.f21803a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f21804b = Arrays.copyOf(iArr, i10);
            this.f21805c = Arrays.copyOf(this.f21805c, i10);
        }
    }

    public static g1 c() {
        return f21802f;
    }

    private static int f(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    private static int g(Object[] objArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + objArr[i12].hashCode();
        }
        return i11;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private com.google.protobuf.g1 j(com.google.protobuf.h r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.F()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.i(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g1.j(com.google.protobuf.h):com.google.protobuf.g1");
    }

    static g1 n(g1 g1Var, g1 g1Var2) {
        int i10 = g1Var.f21803a + g1Var2.f21803a;
        int[] copyOf = Arrays.copyOf(g1Var.f21804b, i10);
        System.arraycopy(g1Var2.f21804b, 0, copyOf, g1Var.f21803a, g1Var2.f21803a);
        Object[] copyOf2 = Arrays.copyOf(g1Var.f21805c, i10);
        System.arraycopy(g1Var2.f21805c, 0, copyOf2, g1Var.f21803a, g1Var2.f21803a);
        return new g1(i10, copyOf, copyOf2, true);
    }

    static g1 o() {
        return new g1();
    }

    private static boolean p(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static boolean s(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static void u(int i10, Object obj, Writer writer) throws IOException {
        int a10 = WireFormat.a(i10);
        int b10 = WireFormat.b(i10);
        if (b10 == 0) {
            writer.u(a10, ((Long) obj).longValue());
        } else if (b10 == 1) {
            writer.s(a10, ((Long) obj).longValue());
        } else if (b10 == 2) {
            writer.L(a10, (ByteString) obj);
        } else if (b10 != 3) {
            if (b10 == 5) {
                writer.c(a10, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.e());
        } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
            writer.x(a10);
            ((g1) obj).v(writer);
            writer.C(a10);
        } else {
            writer.C(a10);
            ((g1) obj).v(writer);
            writer.x(a10);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f21807e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int i10;
        int i11 = this.f21806d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f21803a; i13++) {
            int i14 = this.f21804b[i13];
            int a10 = WireFormat.a(i14);
            int b10 = WireFormat.b(i14);
            if (b10 == 0) {
                i10 = CodedOutputStream.Y(a10, ((Long) this.f21805c[i13]).longValue());
            } else if (b10 == 1) {
                i10 = CodedOutputStream.p(a10, ((Long) this.f21805c[i13]).longValue());
            } else if (b10 == 2) {
                i10 = CodedOutputStream.h(a10, (ByteString) this.f21805c[i13]);
            } else if (b10 == 3) {
                i10 = (CodedOutputStream.V(a10) * 2) + ((g1) this.f21805c[i13]).d();
            } else if (b10 == 5) {
                i10 = CodedOutputStream.n(a10, ((Integer) this.f21805c[i13]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.e());
            }
            i12 += i10;
        }
        this.f21806d = i12;
        return i12;
    }

    public int e() {
        int i10 = this.f21806d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f21803a; i12++) {
            i11 += CodedOutputStream.K(WireFormat.a(this.f21804b[i12]), (ByteString) this.f21805c[i12]);
        }
        this.f21806d = i11;
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        int i10 = this.f21803a;
        if (i10 != g1Var.f21803a || !s(this.f21804b, g1Var.f21804b, i10) || !p(this.f21805c, g1Var.f21805c, this.f21803a)) {
            return false;
        }
        return true;
    }

    public void h() {
        this.f21807e = false;
    }

    public int hashCode() {
        int i10 = this.f21803a;
        return ((((527 + i10) * 31) + f(this.f21804b, i10)) * 31) + g(this.f21805c, this.f21803a);
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i10, h hVar) throws IOException {
        a();
        int a10 = WireFormat.a(i10);
        int b10 = WireFormat.b(i10);
        if (b10 == 0) {
            r(i10, Long.valueOf(hVar.x()));
            return true;
        } else if (b10 == 1) {
            r(i10, Long.valueOf(hVar.u()));
            return true;
        } else if (b10 == 2) {
            r(i10, hVar.q());
            return true;
        } else if (b10 == 3) {
            g1 g1Var = new g1();
            g1Var.j(hVar);
            hVar.a(WireFormat.c(a10, 4));
            r(i10, g1Var);
            return true;
        } else if (b10 == 4) {
            return false;
        } else {
            if (b10 == 5) {
                r(i10, Integer.valueOf(hVar.t()));
                return true;
            }
            throw InvalidProtocolBufferException.e();
        }
    }

    /* access modifiers changed from: package-private */
    public g1 k(g1 g1Var) {
        if (g1Var.equals(c())) {
            return this;
        }
        a();
        int i10 = this.f21803a + g1Var.f21803a;
        b(i10);
        System.arraycopy(g1Var.f21804b, 0, this.f21804b, this.f21803a, g1Var.f21803a);
        System.arraycopy(g1Var.f21805c, 0, this.f21805c, this.f21803a, g1Var.f21803a);
        this.f21803a = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public g1 l(int i10, ByteString byteString) {
        a();
        if (i10 != 0) {
            r(WireFormat.c(i10, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public g1 m(int i10, int i11) {
        a();
        if (i10 != 0) {
            r(WireFormat.c(i10, 0), Long.valueOf((long) i11));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public final void q(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f21803a; i11++) {
            n0.d(sb2, i10, String.valueOf(WireFormat.a(this.f21804b[i11])), this.f21805c[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i10, Object obj) {
        a();
        b(this.f21803a + 1);
        int[] iArr = this.f21804b;
        int i11 = this.f21803a;
        iArr[i11] = i10;
        this.f21805c[i11] = obj;
        this.f21803a = i11 + 1;
    }

    /* access modifiers changed from: package-private */
    public void t(Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i10 = this.f21803a - 1; i10 >= 0; i10--) {
                writer.b(WireFormat.a(this.f21804b[i10]), this.f21805c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f21803a; i11++) {
            writer.b(WireFormat.a(this.f21804b[i11]), this.f21805c[i11]);
        }
    }

    public void v(Writer writer) throws IOException {
        if (this.f21803a != 0) {
            if (writer.t() == Writer.FieldOrder.ASCENDING) {
                for (int i10 = 0; i10 < this.f21803a; i10++) {
                    u(this.f21804b[i10], this.f21805c[i10], writer);
                }
                return;
            }
            for (int i11 = this.f21803a - 1; i11 >= 0; i11--) {
                u(this.f21804b[i11], this.f21805c[i11], writer);
            }
        }
    }

    private g1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f21806d = -1;
        this.f21803a = i10;
        this.f21804b = iArr;
        this.f21805c = objArr;
        this.f21807e = z10;
    }
}
