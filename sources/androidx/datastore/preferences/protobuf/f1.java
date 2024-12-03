package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class f1 {

    /* renamed from: f  reason: collision with root package name */
    private static final f1 f5255f = new f1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f5256a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f5257b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f5258c;

    /* renamed from: d  reason: collision with root package name */
    private int f5259d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5260e;

    private f1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i10;
        int i11 = this.f5256a;
        int[] iArr = this.f5257b;
        if (i11 == iArr.length) {
            if (i11 < 4) {
                i10 = 8;
            } else {
                i10 = i11 >> 1;
            }
            int i12 = i11 + i10;
            this.f5257b = Arrays.copyOf(iArr, i12);
            this.f5258c = Arrays.copyOf(this.f5258c, i12);
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

    public static f1 e() {
        return f5255f;
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

    static f1 k(f1 f1Var, f1 f1Var2) {
        int i10 = f1Var.f5256a + f1Var2.f5256a;
        int[] copyOf = Arrays.copyOf(f1Var.f5257b, i10);
        System.arraycopy(f1Var2.f5257b, 0, copyOf, f1Var.f5256a, f1Var2.f5256a);
        Object[] copyOf2 = Arrays.copyOf(f1Var.f5258c, i10);
        System.arraycopy(f1Var2.f5258c, 0, copyOf2, f1Var.f5256a, f1Var2.f5256a);
        return new f1(i10, copyOf, copyOf2, true);
    }

    static f1 l() {
        return new f1();
    }

    private static void p(int i10, Object obj, Writer writer) throws IOException {
        int a10 = WireFormat.a(i10);
        int b10 = WireFormat.b(i10);
        if (b10 == 0) {
            writer.u(a10, ((Long) obj).longValue());
        } else if (b10 == 1) {
            writer.s(a10, ((Long) obj).longValue());
        } else if (b10 == 2) {
            writer.K(a10, (ByteString) obj);
        } else if (b10 != 3) {
            if (b10 == 5) {
                writer.c(a10, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.d());
        } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
            writer.x(a10);
            ((f1) obj).q(writer);
            writer.C(a10);
        } else {
            writer.C(a10);
            ((f1) obj).q(writer);
            writer.x(a10);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f5260e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        int i10 = this.f5256a;
        if (i10 != f1Var.f5256a || !c(this.f5257b, f1Var.f5257b, i10) || !d(this.f5258c, f1Var.f5258c, this.f5256a)) {
            return false;
        }
        return true;
    }

    public int f() {
        int i10;
        int i11 = this.f5259d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f5256a; i13++) {
            int i14 = this.f5257b[i13];
            int a10 = WireFormat.a(i14);
            int b10 = WireFormat.b(i14);
            if (b10 == 0) {
                i10 = CodedOutputStream.Y(a10, ((Long) this.f5258c[i13]).longValue());
            } else if (b10 == 1) {
                i10 = CodedOutputStream.o(a10, ((Long) this.f5258c[i13]).longValue());
            } else if (b10 == 2) {
                i10 = CodedOutputStream.g(a10, (ByteString) this.f5258c[i13]);
            } else if (b10 == 3) {
                i10 = (CodedOutputStream.V(a10) * 2) + ((f1) this.f5258c[i13]).f();
            } else if (b10 == 5) {
                i10 = CodedOutputStream.m(a10, ((Integer) this.f5258c[i13]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.d());
            }
            i12 += i10;
        }
        this.f5259d = i12;
        return i12;
    }

    public int g() {
        int i10 = this.f5259d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f5256a; i12++) {
            i11 += CodedOutputStream.J(WireFormat.a(this.f5257b[i12]), (ByteString) this.f5258c[i12]);
        }
        this.f5259d = i11;
        return i11;
    }

    public int hashCode() {
        int i10 = this.f5256a;
        return ((((527 + i10) * 31) + h(this.f5257b, i10)) * 31) + i(this.f5258c, this.f5256a);
    }

    public void j() {
        this.f5260e = false;
    }

    /* access modifiers changed from: package-private */
    public final void m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f5256a; i11++) {
            m0.c(sb2, i10, String.valueOf(WireFormat.a(this.f5257b[i11])), this.f5258c[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int i10, Object obj) {
        a();
        b();
        int[] iArr = this.f5257b;
        int i11 = this.f5256a;
        iArr[i11] = i10;
        this.f5258c[i11] = obj;
        this.f5256a = i11 + 1;
    }

    /* access modifiers changed from: package-private */
    public void o(Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i10 = this.f5256a - 1; i10 >= 0; i10--) {
                writer.b(WireFormat.a(this.f5257b[i10]), this.f5258c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f5256a; i11++) {
            writer.b(WireFormat.a(this.f5257b[i11]), this.f5258c[i11]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f5256a != 0) {
            if (writer.t() == Writer.FieldOrder.ASCENDING) {
                for (int i10 = 0; i10 < this.f5256a; i10++) {
                    p(this.f5257b[i10], this.f5258c[i10], writer);
                }
                return;
            }
            for (int i11 = this.f5256a - 1; i11 >= 0; i11--) {
                p(this.f5257b[i11], this.f5258c[i11], writer);
            }
        }
    }

    private f1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f5259d = -1;
        this.f5256a = i10;
        this.f5257b = iArr;
        this.f5258c = objArr;
        this.f5260e = z10;
    }
}
