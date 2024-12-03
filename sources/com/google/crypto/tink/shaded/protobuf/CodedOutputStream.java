package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Utf8;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class CodedOutputStream extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f20623c = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f20624d = j1.C();

    /* renamed from: a  reason: collision with root package name */
    k f20625a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20626b;

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }

        OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    private static class b extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f20627e;

        /* renamed from: f  reason: collision with root package name */
        private final int f20628f;

        /* renamed from: g  reason: collision with root package name */
        private final int f20629g;

        /* renamed from: h  reason: collision with root package name */
        private int f20630h;

        b(byte[] bArr, int i10, int i11) {
            super();
            if (bArr != null) {
                int i12 = i10 + i11;
                if ((i10 | i11 | (bArr.length - i12)) >= 0) {
                    this.f20627e = bArr;
                    this.f20628f = i10;
                    this.f20630h = i10;
                    this.f20629g = i12;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)}));
            }
            throw new NullPointerException("buffer");
        }

        /* access modifiers changed from: package-private */
        public final void A0(int i10, l0 l0Var, z0 z0Var) throws IOException {
            M0(i10, 2);
            O0(((a) l0Var).c(z0Var));
            z0Var.g(l0Var, this.f20625a);
        }

        public final void B0(int i10, l0 l0Var) throws IOException {
            M0(1, 3);
            N0(2, i10);
            T0(3, l0Var);
            M0(1, 4);
        }

        public final void C0(int i10, ByteString byteString) throws IOException {
            M0(1, 3);
            N0(2, i10);
            j0(3, byteString);
            M0(1, 4);
        }

        public final void L0(int i10, String str) throws IOException {
            M0(i10, 2);
            V0(str);
        }

        public final void M0(int i10, int i11) throws IOException {
            O0(WireFormat.c(i10, i11));
        }

        public final void N0(int i10, int i11) throws IOException {
            M0(i10, 0);
            O0(i11);
        }

        public final void O0(int i10) throws IOException {
            if (!CodedOutputStream.f20624d || d.c() || f0() < 5) {
                while ((i10 & -128) != 0) {
                    byte[] bArr = this.f20627e;
                    int i11 = this.f20630h;
                    this.f20630h = i11 + 1;
                    bArr[i11] = (byte) ((i10 & Opcodes.LAND) | 128);
                    i10 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20627e;
                    int i12 = this.f20630h;
                    this.f20630h = i12 + 1;
                    bArr2[i12] = (byte) i10;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), 1}), e10);
                }
            } else if ((i10 & -128) == 0) {
                byte[] bArr3 = this.f20627e;
                int i13 = this.f20630h;
                this.f20630h = i13 + 1;
                j1.H(bArr3, (long) i13, (byte) i10);
            } else {
                byte[] bArr4 = this.f20627e;
                int i14 = this.f20630h;
                this.f20630h = i14 + 1;
                j1.H(bArr4, (long) i14, (byte) (i10 | 128));
                int i15 = i10 >>> 7;
                if ((i15 & -128) == 0) {
                    byte[] bArr5 = this.f20627e;
                    int i16 = this.f20630h;
                    this.f20630h = i16 + 1;
                    j1.H(bArr5, (long) i16, (byte) i15);
                    return;
                }
                byte[] bArr6 = this.f20627e;
                int i17 = this.f20630h;
                this.f20630h = i17 + 1;
                j1.H(bArr6, (long) i17, (byte) (i15 | 128));
                int i18 = i15 >>> 7;
                if ((i18 & -128) == 0) {
                    byte[] bArr7 = this.f20627e;
                    int i19 = this.f20630h;
                    this.f20630h = i19 + 1;
                    j1.H(bArr7, (long) i19, (byte) i18);
                    return;
                }
                byte[] bArr8 = this.f20627e;
                int i20 = this.f20630h;
                this.f20630h = i20 + 1;
                j1.H(bArr8, (long) i20, (byte) (i18 | 128));
                int i21 = i18 >>> 7;
                if ((i21 & -128) == 0) {
                    byte[] bArr9 = this.f20627e;
                    int i22 = this.f20630h;
                    this.f20630h = i22 + 1;
                    j1.H(bArr9, (long) i22, (byte) i21);
                    return;
                }
                byte[] bArr10 = this.f20627e;
                int i23 = this.f20630h;
                this.f20630h = i23 + 1;
                j1.H(bArr10, (long) i23, (byte) (i21 | 128));
                byte[] bArr11 = this.f20627e;
                int i24 = this.f20630h;
                this.f20630h = i24 + 1;
                j1.H(bArr11, (long) i24, (byte) (i21 >>> 7));
            }
        }

        public final void P0(int i10, long j10) throws IOException {
            M0(i10, 0);
            Q0(j10);
        }

        public final void Q0(long j10) throws IOException {
            if (!CodedOutputStream.f20624d || f0() < 10) {
                while ((j10 & -128) != 0) {
                    byte[] bArr = this.f20627e;
                    int i10 = this.f20630h;
                    this.f20630h = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) & Opcodes.LAND) | 128);
                    j10 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20627e;
                    int i11 = this.f20630h;
                    this.f20630h = i11 + 1;
                    bArr2[i11] = (byte) ((int) j10);
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), 1}), e10);
                }
            } else {
                while ((j10 & -128) != 0) {
                    byte[] bArr3 = this.f20627e;
                    int i12 = this.f20630h;
                    this.f20630h = i12 + 1;
                    j1.H(bArr3, (long) i12, (byte) ((((int) j10) & Opcodes.LAND) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr4 = this.f20627e;
                int i13 = this.f20630h;
                this.f20630h = i13 + 1;
                j1.H(bArr4, (long) i13, (byte) ((int) j10));
            }
        }

        public final void R0(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f20627e, this.f20630h, i11);
                this.f20630h += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), Integer.valueOf(i11)}), e10);
            }
        }

        public final void S0(ByteString byteString) throws IOException {
            O0(byteString.size());
            byteString.K(this);
        }

        public final void T0(int i10, l0 l0Var) throws IOException {
            M0(i10, 2);
            U0(l0Var);
        }

        public final void U0(l0 l0Var) throws IOException {
            O0(l0Var.getSerializedSize());
            l0Var.a(this);
        }

        public final void V0(String str) throws IOException {
            int i10 = this.f20630h;
            try {
                int W = CodedOutputStream.W(str.length() * 3);
                int W2 = CodedOutputStream.W(str.length());
                if (W2 == W) {
                    int i11 = i10 + W2;
                    this.f20630h = i11;
                    int f10 = Utf8.f(str, this.f20627e, i11, f0());
                    this.f20630h = i10;
                    O0((f10 - i10) - W2);
                    this.f20630h = f10;
                    return;
                }
                O0(Utf8.g(str));
                this.f20630h = Utf8.f(str, this.f20627e, this.f20630h, f0());
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f20630h = i10;
                b0(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            R0(bArr, i10, i11);
        }

        public final int f0() {
            return this.f20629g - this.f20630h;
        }

        public final void g0(byte b10) throws IOException {
            try {
                byte[] bArr = this.f20627e;
                int i10 = this.f20630h;
                this.f20630h = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), 1}), e10);
            }
        }

        public final void h0(int i10, boolean z10) throws IOException {
            M0(i10, 0);
            g0(z10 ? (byte) 1 : 0);
        }

        public final void j0(int i10, ByteString byteString) throws IOException {
            M0(i10, 2);
            S0(byteString);
        }

        public final void o0(int i10, int i11) throws IOException {
            M0(i10, 5);
            p0(i11);
        }

        public final void p0(int i10) throws IOException {
            try {
                byte[] bArr = this.f20627e;
                int i11 = this.f20630h;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f20630h = i14 + 1;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), 1}), e10);
            }
        }

        public final void q0(int i10, long j10) throws IOException {
            M0(i10, 1);
            r0(j10);
        }

        public final void r0(long j10) throws IOException {
            try {
                byte[] bArr = this.f20627e;
                int i10 = this.f20630h;
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f20630h = i17 + 1;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20630h), Integer.valueOf(this.f20629g), 1}), e10);
            }
        }

        public final void w0(int i10, int i11) throws IOException {
            M0(i10, 0);
            x0(i11);
        }

        public final void x0(int i10) throws IOException {
            if (i10 >= 0) {
                O0(i10);
            } else {
                Q0((long) i10);
            }
        }
    }

    public static int A(int i10, z zVar) {
        return U(i10) + B(zVar);
    }

    public static int B(z zVar) {
        return C(zVar.b());
    }

    static int C(int i10) {
        return W(i10) + i10;
    }

    public static int D(int i10, l0 l0Var) {
        return (U(1) * 2) + V(2, i10) + E(3, l0Var);
    }

    public static int E(int i10, l0 l0Var) {
        return U(i10) + G(l0Var);
    }

    static int F(int i10, l0 l0Var, z0 z0Var) {
        return U(i10) + H(l0Var, z0Var);
    }

    public static int G(l0 l0Var) {
        return C(l0Var.getSerializedSize());
    }

    static int H(l0 l0Var, z0 z0Var) {
        return C(((a) l0Var).c(z0Var));
    }

    public static int I(int i10, ByteString byteString) {
        return (U(1) * 2) + V(2, i10) + g(3, byteString);
    }

    @Deprecated
    public static int J(int i10) {
        return W(i10);
    }

    public static int K(int i10, int i11) {
        return U(i10) + L(i11);
    }

    public static int L(int i10) {
        return 4;
    }

    public static int M(int i10, long j10) {
        return U(i10) + N(j10);
    }

    public static int N(long j10) {
        return 8;
    }

    public static int O(int i10, int i11) {
        return U(i10) + P(i11);
    }

    public static int P(int i10) {
        return W(Z(i10));
    }

    public static int Q(int i10, long j10) {
        return U(i10) + R(j10);
    }

    public static int R(long j10) {
        return Y(a0(j10));
    }

    public static int S(int i10, String str) {
        return U(i10) + T(str);
    }

    public static int T(String str) {
        int i10;
        try {
            i10 = Utf8.g(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i10 = str.getBytes(x.f20917a).length;
        }
        return C(i10);
    }

    public static int U(int i10) {
        return W(WireFormat.c(i10, 0));
    }

    public static int V(int i10, int i11) {
        return U(i10) + W(i11);
    }

    public static int W(int i10) {
        if ((i10 & -128) == 0) {
            return 1;
        }
        if ((i10 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i10) == 0) {
            return 3;
        }
        return (i10 & -268435456) == 0 ? 4 : 5;
    }

    public static int X(int i10, long j10) {
        return U(i10) + Y(j10);
    }

    public static int Y(long j10) {
        int i10;
        if ((-128 & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if ((-34359738368L & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if ((-2097152 & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & -16384) != 0 ? i10 + 1 : i10;
    }

    public static int Z(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long a0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int d(int i10, boolean z10) {
        return U(i10) + e(z10);
    }

    public static CodedOutputStream d0(byte[] bArr) {
        return e0(bArr, 0, bArr.length);
    }

    public static int e(boolean z10) {
        return 1;
    }

    public static CodedOutputStream e0(byte[] bArr, int i10, int i11) {
        return new b(bArr, i10, i11);
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static int g(int i10, ByteString byteString) {
        return U(i10) + h(byteString);
    }

    public static int h(ByteString byteString) {
        return C(byteString.size());
    }

    public static int i(int i10, double d10) {
        return U(i10) + j(d10);
    }

    public static int j(double d10) {
        return 8;
    }

    public static int k(int i10, int i11) {
        return U(i10) + l(i11);
    }

    public static int l(int i10) {
        return w(i10);
    }

    public static int m(int i10, int i11) {
        return U(i10) + n(i11);
    }

    public static int n(int i10) {
        return 4;
    }

    public static int o(int i10, long j10) {
        return U(i10) + p(j10);
    }

    public static int p(long j10) {
        return 8;
    }

    public static int q(int i10, float f10) {
        return U(i10) + r(f10);
    }

    public static int r(float f10) {
        return 4;
    }

    @Deprecated
    static int s(int i10, l0 l0Var, z0 z0Var) {
        return (U(i10) * 2) + u(l0Var, z0Var);
    }

    @Deprecated
    public static int t(l0 l0Var) {
        return l0Var.getSerializedSize();
    }

    @Deprecated
    static int u(l0 l0Var, z0 z0Var) {
        return ((a) l0Var).c(z0Var);
    }

    public static int v(int i10, int i11) {
        return U(i10) + w(i11);
    }

    public static int w(int i10) {
        if (i10 >= 0) {
            return W(i10);
        }
        return 10;
    }

    public static int x(int i10, long j10) {
        return U(i10) + y(j10);
    }

    public static int y(long j10) {
        return Y(j10);
    }

    public static int z(int i10, z zVar) {
        return (U(1) * 2) + V(2, i10) + A(3, zVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void A0(int i10, l0 l0Var, z0 z0Var) throws IOException;

    public abstract void B0(int i10, l0 l0Var) throws IOException;

    public abstract void C0(int i10, ByteString byteString) throws IOException;

    public final void D0(int i10, int i11) throws IOException {
        o0(i10, i11);
    }

    public final void E0(int i10) throws IOException {
        p0(i10);
    }

    public final void F0(int i10, long j10) throws IOException {
        q0(i10, j10);
    }

    public final void G0(long j10) throws IOException {
        r0(j10);
    }

    public final void H0(int i10, int i11) throws IOException {
        N0(i10, Z(i11));
    }

    public final void I0(int i10) throws IOException {
        O0(Z(i10));
    }

    public final void J0(int i10, long j10) throws IOException {
        P0(i10, a0(j10));
    }

    public final void K0(long j10) throws IOException {
        Q0(a0(j10));
    }

    public abstract void L0(int i10, String str) throws IOException;

    public abstract void M0(int i10, int i11) throws IOException;

    public abstract void N0(int i10, int i11) throws IOException;

    public abstract void O0(int i10) throws IOException;

    public abstract void P0(int i10, long j10) throws IOException;

    public abstract void Q0(long j10) throws IOException;

    public abstract void a(byte[] bArr, int i10, int i11) throws IOException;

    /* access modifiers changed from: package-private */
    public final void b0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f20623c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(x.f20917a);
        try {
            O0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new OutOfSpaceException(e10);
        } catch (OutOfSpaceException e11) {
            throw e11;
        }
    }

    public final void c() {
        if (f0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c0() {
        return this.f20626b;
    }

    public abstract int f0();

    public abstract void g0(byte b10) throws IOException;

    public abstract void h0(int i10, boolean z10) throws IOException;

    public final void i0(boolean z10) throws IOException {
        g0(z10 ? (byte) 1 : 0);
    }

    public abstract void j0(int i10, ByteString byteString) throws IOException;

    public final void k0(int i10, double d10) throws IOException {
        q0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void l0(double d10) throws IOException {
        r0(Double.doubleToRawLongBits(d10));
    }

    public final void m0(int i10, int i11) throws IOException {
        w0(i10, i11);
    }

    public final void n0(int i10) throws IOException {
        x0(i10);
    }

    public abstract void o0(int i10, int i11) throws IOException;

    public abstract void p0(int i10) throws IOException;

    public abstract void q0(int i10, long j10) throws IOException;

    public abstract void r0(long j10) throws IOException;

    public final void s0(int i10, float f10) throws IOException {
        o0(i10, Float.floatToRawIntBits(f10));
    }

    public final void t0(float f10) throws IOException {
        p0(Float.floatToRawIntBits(f10));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void u0(int i10, l0 l0Var, z0 z0Var) throws IOException {
        M0(i10, 3);
        v0(l0Var, z0Var);
        M0(i10, 4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void v0(l0 l0Var, z0 z0Var) throws IOException {
        z0Var.g(l0Var, this.f20625a);
    }

    public abstract void w0(int i10, int i11) throws IOException;

    public abstract void x0(int i10) throws IOException;

    public final void y0(int i10, long j10) throws IOException {
        P0(i10, j10);
    }

    public final void z0(long j10) throws IOException {
        Q0(j10);
    }

    private CodedOutputStream() {
    }
}
