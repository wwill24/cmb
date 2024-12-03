package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class CodedOutputStream extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f5072c = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5073d = i1.C();

    /* renamed from: a  reason: collision with root package name */
    j f5074a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5075b;

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }

        OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    private static abstract class b extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f5076e;

        /* renamed from: f  reason: collision with root package name */
        final int f5077f;

        /* renamed from: g  reason: collision with root package name */
        int f5078g;

        /* renamed from: h  reason: collision with root package name */
        int f5079h;

        b(int i10) {
            super();
            if (i10 >= 0) {
                byte[] bArr = new byte[Math.max(i10, 20)];
                this.f5076e = bArr;
                this.f5077f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void b1(byte b10) {
            byte[] bArr = this.f5076e;
            int i10 = this.f5078g;
            this.f5078g = i10 + 1;
            bArr[i10] = b10;
            this.f5079h++;
        }

        /* access modifiers changed from: package-private */
        public final void c1(int i10) {
            byte[] bArr = this.f5076e;
            int i11 = this.f5078g;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f5078g = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
            this.f5079h += 4;
        }

        /* access modifiers changed from: package-private */
        public final void d1(long j10) {
            byte[] bArr = this.f5076e;
            int i10 = this.f5078g;
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((int) (j10 & 255));
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((int) ((j10 >> 8) & 255));
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((int) ((j10 >> 16) & 255));
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((int) (255 & (j10 >> 24)));
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f5078g = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            this.f5079h += 8;
        }

        /* access modifiers changed from: package-private */
        public final void e1(int i10) {
            if (i10 >= 0) {
                g1(i10);
            } else {
                h1((long) i10);
            }
        }

        /* access modifiers changed from: package-private */
        public final void f1(int i10, int i11) {
            g1(WireFormat.c(i10, i11));
        }

        /* access modifiers changed from: package-private */
        public final void g1(int i10) {
            if (CodedOutputStream.f5073d) {
                long j10 = (long) this.f5078g;
                while ((i10 & -128) != 0) {
                    byte[] bArr = this.f5076e;
                    int i11 = this.f5078g;
                    this.f5078g = i11 + 1;
                    i1.H(bArr, (long) i11, (byte) ((i10 & Opcodes.LAND) | 128));
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.f5076e;
                int i12 = this.f5078g;
                this.f5078g = i12 + 1;
                i1.H(bArr2, (long) i12, (byte) i10);
                this.f5079h += (int) (((long) this.f5078g) - j10);
                return;
            }
            while ((i10 & -128) != 0) {
                byte[] bArr3 = this.f5076e;
                int i13 = this.f5078g;
                this.f5078g = i13 + 1;
                bArr3[i13] = (byte) ((i10 & Opcodes.LAND) | 128);
                this.f5079h++;
                i10 >>>= 7;
            }
            byte[] bArr4 = this.f5076e;
            int i14 = this.f5078g;
            this.f5078g = i14 + 1;
            bArr4[i14] = (byte) i10;
            this.f5079h++;
        }

        /* access modifiers changed from: package-private */
        public final void h1(long j10) {
            if (CodedOutputStream.f5073d) {
                long j11 = (long) this.f5078g;
                while ((j10 & -128) != 0) {
                    byte[] bArr = this.f5076e;
                    int i10 = this.f5078g;
                    this.f5078g = i10 + 1;
                    i1.H(bArr, (long) i10, (byte) ((((int) j10) & Opcodes.LAND) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f5076e;
                int i11 = this.f5078g;
                this.f5078g = i11 + 1;
                i1.H(bArr2, (long) i11, (byte) ((int) j10));
                this.f5079h += (int) (((long) this.f5078g) - j11);
                return;
            }
            while ((j10 & -128) != 0) {
                byte[] bArr3 = this.f5076e;
                int i12 = this.f5078g;
                this.f5078g = i12 + 1;
                bArr3[i12] = (byte) ((((int) j10) & Opcodes.LAND) | 128);
                this.f5079h++;
                j10 >>>= 7;
            }
            byte[] bArr4 = this.f5076e;
            int i13 = this.f5078g;
            this.f5078g = i13 + 1;
            bArr4[i13] = (byte) ((int) j10);
            this.f5079h++;
        }

        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class c extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f5080e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5081f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5082g;

        /* renamed from: h  reason: collision with root package name */
        private int f5083h;

        c(byte[] bArr, int i10, int i11) {
            super();
            if (bArr != null) {
                int i12 = i10 + i11;
                if ((i10 | i11 | (bArr.length - i12)) >= 0) {
                    this.f5080e = bArr;
                    this.f5081f = i10;
                    this.f5083h = i10;
                    this.f5082g = i12;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void E0(int i10, int i11) throws IOException {
            W0(i10, 0);
            F0(i11);
        }

        public final void F0(int i10) throws IOException {
            if (i10 >= 0) {
                Y0(i10);
            } else {
                a1((long) i10);
            }
        }

        /* access modifiers changed from: package-private */
        public final void I0(int i10, k0 k0Var, y0 y0Var) throws IOException {
            W0(i10, 2);
            Y0(((a) k0Var).d(y0Var));
            y0Var.f(k0Var, this.f5074a);
        }

        public final void J0(k0 k0Var) throws IOException {
            Y0(k0Var.getSerializedSize());
            k0Var.a(this);
        }

        public final void K0(int i10, k0 k0Var) throws IOException {
            W0(1, 3);
            X0(2, i10);
            c1(3, k0Var);
            W0(1, 4);
        }

        public final void L0(int i10, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i10);
            o0(3, byteString);
            W0(1, 4);
        }

        public final void U0(int i10, String str) throws IOException {
            W0(i10, 2);
            V0(str);
        }

        public final void V0(String str) throws IOException {
            int i10 = this.f5083h;
            try {
                int X = CodedOutputStream.X(str.length() * 3);
                int X2 = CodedOutputStream.X(str.length());
                if (X2 == X) {
                    int i11 = i10 + X2;
                    this.f5083h = i11;
                    int f10 = Utf8.f(str, this.f5080e, i11, i0());
                    this.f5083h = i10;
                    Y0((f10 - i10) - X2);
                    this.f5083h = f10;
                    return;
                }
                Y0(Utf8.g(str));
                this.f5083h = Utf8.f(str, this.f5080e, this.f5083h, i0());
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f5083h = i10;
                d0(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        public final void W0(int i10, int i11) throws IOException {
            Y0(WireFormat.c(i10, i11));
        }

        public final void X0(int i10, int i11) throws IOException {
            W0(i10, 0);
            Y0(i11);
        }

        public final void Y0(int i10) throws IOException {
            if (!CodedOutputStream.f5073d || d.c() || i0() < 5) {
                while ((i10 & -128) != 0) {
                    byte[] bArr = this.f5080e;
                    int i11 = this.f5083h;
                    this.f5083h = i11 + 1;
                    bArr[i11] = (byte) ((i10 & Opcodes.LAND) | 128);
                    i10 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f5080e;
                    int i12 = this.f5083h;
                    this.f5083h = i12 + 1;
                    bArr2[i12] = (byte) i10;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), 1}), e10);
                }
            } else if ((i10 & -128) == 0) {
                byte[] bArr3 = this.f5080e;
                int i13 = this.f5083h;
                this.f5083h = i13 + 1;
                i1.H(bArr3, (long) i13, (byte) i10);
            } else {
                byte[] bArr4 = this.f5080e;
                int i14 = this.f5083h;
                this.f5083h = i14 + 1;
                i1.H(bArr4, (long) i14, (byte) (i10 | 128));
                int i15 = i10 >>> 7;
                if ((i15 & -128) == 0) {
                    byte[] bArr5 = this.f5080e;
                    int i16 = this.f5083h;
                    this.f5083h = i16 + 1;
                    i1.H(bArr5, (long) i16, (byte) i15);
                    return;
                }
                byte[] bArr6 = this.f5080e;
                int i17 = this.f5083h;
                this.f5083h = i17 + 1;
                i1.H(bArr6, (long) i17, (byte) (i15 | 128));
                int i18 = i15 >>> 7;
                if ((i18 & -128) == 0) {
                    byte[] bArr7 = this.f5080e;
                    int i19 = this.f5083h;
                    this.f5083h = i19 + 1;
                    i1.H(bArr7, (long) i19, (byte) i18);
                    return;
                }
                byte[] bArr8 = this.f5080e;
                int i20 = this.f5083h;
                this.f5083h = i20 + 1;
                i1.H(bArr8, (long) i20, (byte) (i18 | 128));
                int i21 = i18 >>> 7;
                if ((i21 & -128) == 0) {
                    byte[] bArr9 = this.f5080e;
                    int i22 = this.f5083h;
                    this.f5083h = i22 + 1;
                    i1.H(bArr9, (long) i22, (byte) i21);
                    return;
                }
                byte[] bArr10 = this.f5080e;
                int i23 = this.f5083h;
                this.f5083h = i23 + 1;
                i1.H(bArr10, (long) i23, (byte) (i21 | 128));
                byte[] bArr11 = this.f5080e;
                int i24 = this.f5083h;
                this.f5083h = i24 + 1;
                i1.H(bArr11, (long) i24, (byte) (i21 >>> 7));
            }
        }

        public final void Z0(int i10, long j10) throws IOException {
            W0(i10, 0);
            a1(j10);
        }

        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            b1(bArr, i10, i11);
        }

        public final void a1(long j10) throws IOException {
            if (!CodedOutputStream.f5073d || i0() < 10) {
                while ((j10 & -128) != 0) {
                    byte[] bArr = this.f5080e;
                    int i10 = this.f5083h;
                    this.f5083h = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) & Opcodes.LAND) | 128);
                    j10 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f5080e;
                    int i11 = this.f5083h;
                    this.f5083h = i11 + 1;
                    bArr2[i11] = (byte) ((int) j10);
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), 1}), e10);
                }
            } else {
                while ((j10 & -128) != 0) {
                    byte[] bArr3 = this.f5080e;
                    int i12 = this.f5083h;
                    this.f5083h = i12 + 1;
                    i1.H(bArr3, (long) i12, (byte) ((((int) j10) & Opcodes.LAND) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr4 = this.f5080e;
                int i13 = this.f5083h;
                this.f5083h = i13 + 1;
                i1.H(bArr4, (long) i13, (byte) ((int) j10));
            }
        }

        public final void b1(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f5080e, this.f5083h, i11);
                this.f5083h += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), Integer.valueOf(i11)}), e10);
            }
        }

        public void c0() {
        }

        public final void c1(int i10, k0 k0Var) throws IOException {
            W0(i10, 2);
            J0(k0Var);
        }

        public final int i0() {
            return this.f5082g - this.f5083h;
        }

        public final void j0(byte b10) throws IOException {
            try {
                byte[] bArr = this.f5080e;
                int i10 = this.f5083h;
                this.f5083h = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), 1}), e10);
            }
        }

        public final void k0(int i10, boolean z10) throws IOException {
            W0(i10, 0);
            j0(z10 ? (byte) 1 : 0);
        }

        public final void n0(byte[] bArr, int i10, int i11) throws IOException {
            Y0(i11);
            b1(bArr, i10, i11);
        }

        public final void o0(int i10, ByteString byteString) throws IOException {
            W0(i10, 2);
            p0(byteString);
        }

        public final void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.J(this);
        }

        public final void u0(int i10, int i11) throws IOException {
            W0(i10, 5);
            v0(i11);
        }

        public final void v0(int i10) throws IOException {
            try {
                byte[] bArr = this.f5080e;
                int i11 = this.f5083h;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f5083h = i14 + 1;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), 1}), e10);
            }
        }

        public final void w0(int i10, long j10) throws IOException {
            W0(i10, 1);
            x0(j10);
        }

        public final void x0(long j10) throws IOException {
            try {
                byte[] bArr = this.f5080e;
                int i10 = this.f5083h;
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
                this.f5083h = i17 + 1;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5083h), Integer.valueOf(this.f5082g), 1}), e10);
            }
        }
    }

    private static final class d extends b {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f5084i;

        d(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream != null) {
                this.f5084i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void i1() throws IOException {
            this.f5084i.write(this.f5076e, 0, this.f5078g);
            this.f5078g = 0;
        }

        private void j1(int i10) throws IOException {
            if (this.f5077f - this.f5078g < i10) {
                i1();
            }
        }

        public void E0(int i10, int i11) throws IOException {
            j1(20);
            f1(i10, 0);
            e1(i11);
        }

        public void F0(int i10) throws IOException {
            if (i10 >= 0) {
                Y0(i10);
            } else {
                a1((long) i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void I0(int i10, k0 k0Var, y0 y0Var) throws IOException {
            W0(i10, 2);
            m1(k0Var, y0Var);
        }

        public void J0(k0 k0Var) throws IOException {
            Y0(k0Var.getSerializedSize());
            k0Var.a(this);
        }

        public void K0(int i10, k0 k0Var) throws IOException {
            W0(1, 3);
            X0(2, i10);
            l1(3, k0Var);
            W0(1, 4);
        }

        public void L0(int i10, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i10);
            o0(3, byteString);
            W0(1, 4);
        }

        public void U0(int i10, String str) throws IOException {
            W0(i10, 2);
            V0(str);
        }

        public void V0(String str) throws IOException {
            int i10;
            int i11;
            try {
                int length = str.length() * 3;
                int X = CodedOutputStream.X(length);
                int i12 = X + length;
                int i13 = this.f5077f;
                if (i12 > i13) {
                    byte[] bArr = new byte[length];
                    int f10 = Utf8.f(str, bArr, 0, length);
                    Y0(f10);
                    a(bArr, 0, f10);
                    return;
                }
                if (i12 > i13 - this.f5078g) {
                    i1();
                }
                int X2 = CodedOutputStream.X(str.length());
                i10 = this.f5078g;
                if (X2 == X) {
                    int i14 = i10 + X2;
                    this.f5078g = i14;
                    int f11 = Utf8.f(str, this.f5076e, i14, this.f5077f - i14);
                    this.f5078g = i10;
                    i11 = (f11 - i10) - X2;
                    g1(i11);
                    this.f5078g = f11;
                } else {
                    i11 = Utf8.g(str);
                    g1(i11);
                    this.f5078g = Utf8.f(str, this.f5076e, this.f5078g, i11);
                }
                this.f5079h += i11;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f5079h -= this.f5078g - i10;
                this.f5078g = i10;
                throw e10;
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            } catch (Utf8.UnpairedSurrogateException e12) {
                d0(str, e12);
            }
        }

        public void W0(int i10, int i11) throws IOException {
            Y0(WireFormat.c(i10, i11));
        }

        public void X0(int i10, int i11) throws IOException {
            j1(20);
            f1(i10, 0);
            g1(i11);
        }

        public void Y0(int i10) throws IOException {
            j1(5);
            g1(i10);
        }

        public void Z0(int i10, long j10) throws IOException {
            j1(20);
            f1(i10, 0);
            h1(j10);
        }

        public void a(byte[] bArr, int i10, int i11) throws IOException {
            k1(bArr, i10, i11);
        }

        public void a1(long j10) throws IOException {
            j1(10);
            h1(j10);
        }

        public void c0() throws IOException {
            if (this.f5078g > 0) {
                i1();
            }
        }

        public void j0(byte b10) throws IOException {
            if (this.f5078g == this.f5077f) {
                i1();
            }
            b1(b10);
        }

        public void k0(int i10, boolean z10) throws IOException {
            j1(11);
            f1(i10, 0);
            b1(z10 ? (byte) 1 : 0);
        }

        public void k1(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f5077f;
            int i13 = this.f5078g;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.f5076e, i13, i11);
                this.f5078g += i11;
                this.f5079h += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.f5076e, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f5078g = this.f5077f;
            this.f5079h += i14;
            i1();
            if (i16 <= this.f5077f) {
                System.arraycopy(bArr, i15, this.f5076e, 0, i16);
                this.f5078g = i16;
            } else {
                this.f5084i.write(bArr, i15, i16);
            }
            this.f5079h += i16;
        }

        public void l1(int i10, k0 k0Var) throws IOException {
            W0(i10, 2);
            J0(k0Var);
        }

        /* access modifiers changed from: package-private */
        public void m1(k0 k0Var, y0 y0Var) throws IOException {
            Y0(((a) k0Var).d(y0Var));
            y0Var.f(k0Var, this.f5074a);
        }

        public void n0(byte[] bArr, int i10, int i11) throws IOException {
            Y0(i11);
            k1(bArr, i10, i11);
        }

        public void o0(int i10, ByteString byteString) throws IOException {
            W0(i10, 2);
            p0(byteString);
        }

        public void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.J(this);
        }

        public void u0(int i10, int i11) throws IOException {
            j1(14);
            f1(i10, 5);
            c1(i11);
        }

        public void v0(int i10) throws IOException {
            j1(4);
            c1(i10);
        }

        public void w0(int i10, long j10) throws IOException {
            j1(18);
            f1(i10, 1);
            d1(j10);
        }

        public void x0(long j10) throws IOException {
            j1(8);
            d1(j10);
        }
    }

    public static int A(int i10, y yVar) {
        return V(i10) + B(yVar);
    }

    public static int B(y yVar) {
        return C(yVar.b());
    }

    static int C(int i10) {
        return X(i10) + i10;
    }

    public static int D(int i10, k0 k0Var) {
        return (V(1) * 2) + W(2, i10) + E(3, k0Var);
    }

    public static int E(int i10, k0 k0Var) {
        return V(i10) + G(k0Var);
    }

    static int F(int i10, k0 k0Var, y0 y0Var) {
        return V(i10) + H(k0Var, y0Var);
    }

    public static int G(k0 k0Var) {
        return C(k0Var.getSerializedSize());
    }

    static int H(k0 k0Var, y0 y0Var) {
        return C(((a) k0Var).d(y0Var));
    }

    static int I(int i10) {
        return i10 > 4096 ? Opcodes.ACC_SYNTHETIC : i10;
    }

    public static int J(int i10, ByteString byteString) {
        return (V(1) * 2) + W(2, i10) + g(3, byteString);
    }

    @Deprecated
    public static int K(int i10) {
        return X(i10);
    }

    public static int L(int i10, int i11) {
        return V(i10) + M(i11);
    }

    public static int M(int i10) {
        return 4;
    }

    public static int N(int i10, long j10) {
        return V(i10) + O(j10);
    }

    public static int O(long j10) {
        return 8;
    }

    public static int P(int i10, int i11) {
        return V(i10) + Q(i11);
    }

    public static int Q(int i10) {
        return X(a0(i10));
    }

    public static int R(int i10, long j10) {
        return V(i10) + S(j10);
    }

    public static int S(long j10) {
        return Z(b0(j10));
    }

    public static int T(int i10, String str) {
        return V(i10) + U(str);
    }

    public static int U(String str) {
        int i10;
        try {
            i10 = Utf8.g(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i10 = str.getBytes(w.f5382a).length;
        }
        return C(i10);
    }

    public static int V(int i10) {
        return X(WireFormat.c(i10, 0));
    }

    public static int W(int i10, int i11) {
        return V(i10) + X(i11);
    }

    public static int X(int i10) {
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

    public static int Y(int i10, long j10) {
        return V(i10) + Z(j10);
    }

    public static int Z(long j10) {
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

    public static int a0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long b0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int d(int i10, boolean z10) {
        return V(i10) + e(z10);
    }

    public static int e(boolean z10) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static CodedOutputStream f0(OutputStream outputStream, int i10) {
        return new d(outputStream, i10);
    }

    public static int g(int i10, ByteString byteString) {
        return V(i10) + h(byteString);
    }

    public static CodedOutputStream g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(ByteString byteString) {
        return C(byteString.size());
    }

    public static CodedOutputStream h0(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static int i(int i10, double d10) {
        return V(i10) + j(d10);
    }

    public static int j(double d10) {
        return 8;
    }

    public static int k(int i10, int i11) {
        return V(i10) + l(i11);
    }

    public static int l(int i10) {
        return w(i10);
    }

    public static int m(int i10, int i11) {
        return V(i10) + n(i11);
    }

    public static int n(int i10) {
        return 4;
    }

    public static int o(int i10, long j10) {
        return V(i10) + p(j10);
    }

    public static int p(long j10) {
        return 8;
    }

    public static int q(int i10, float f10) {
        return V(i10) + r(f10);
    }

    public static int r(float f10) {
        return 4;
    }

    @Deprecated
    static int s(int i10, k0 k0Var, y0 y0Var) {
        return (V(i10) * 2) + u(k0Var, y0Var);
    }

    @Deprecated
    public static int t(k0 k0Var) {
        return k0Var.getSerializedSize();
    }

    @Deprecated
    static int u(k0 k0Var, y0 y0Var) {
        return ((a) k0Var).d(y0Var);
    }

    public static int v(int i10, int i11) {
        return V(i10) + w(i11);
    }

    public static int w(int i10) {
        if (i10 >= 0) {
            return X(i10);
        }
        return 10;
    }

    public static int x(int i10, long j10) {
        return V(i10) + y(j10);
    }

    public static int y(long j10) {
        return Z(j10);
    }

    public static int z(int i10, y yVar) {
        return (V(1) * 2) + W(2, i10) + A(3, yVar);
    }

    @Deprecated
    public final void A0(int i10, k0 k0Var) throws IOException {
        W0(i10, 3);
        C0(k0Var);
        W0(i10, 4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void B0(int i10, k0 k0Var, y0 y0Var) throws IOException {
        W0(i10, 3);
        D0(k0Var, y0Var);
        W0(i10, 4);
    }

    @Deprecated
    public final void C0(k0 k0Var) throws IOException {
        k0Var.a(this);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void D0(k0 k0Var, y0 y0Var) throws IOException {
        y0Var.f(k0Var, this.f5074a);
    }

    public abstract void E0(int i10, int i11) throws IOException;

    public abstract void F0(int i10) throws IOException;

    public final void G0(int i10, long j10) throws IOException {
        Z0(i10, j10);
    }

    public final void H0(long j10) throws IOException {
        a1(j10);
    }

    /* access modifiers changed from: package-private */
    public abstract void I0(int i10, k0 k0Var, y0 y0Var) throws IOException;

    public abstract void J0(k0 k0Var) throws IOException;

    public abstract void K0(int i10, k0 k0Var) throws IOException;

    public abstract void L0(int i10, ByteString byteString) throws IOException;

    public final void M0(int i10, int i11) throws IOException {
        u0(i10, i11);
    }

    public final void N0(int i10) throws IOException {
        v0(i10);
    }

    public final void O0(int i10, long j10) throws IOException {
        w0(i10, j10);
    }

    public final void P0(long j10) throws IOException {
        x0(j10);
    }

    public final void Q0(int i10, int i11) throws IOException {
        X0(i10, a0(i11));
    }

    public final void R0(int i10) throws IOException {
        Y0(a0(i10));
    }

    public final void S0(int i10, long j10) throws IOException {
        Z0(i10, b0(j10));
    }

    public final void T0(long j10) throws IOException {
        a1(b0(j10));
    }

    public abstract void U0(int i10, String str) throws IOException;

    public abstract void V0(String str) throws IOException;

    public abstract void W0(int i10, int i11) throws IOException;

    public abstract void X0(int i10, int i11) throws IOException;

    public abstract void Y0(int i10) throws IOException;

    public abstract void Z0(int i10, long j10) throws IOException;

    public abstract void a(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void a1(long j10) throws IOException;

    public final void c() {
        if (i0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void c0() throws IOException;

    /* access modifiers changed from: package-private */
    public final void d0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f5072c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(w.f5382a);
        try {
            Y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new OutOfSpaceException(e10);
        } catch (OutOfSpaceException e11) {
            throw e11;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e0() {
        return this.f5075b;
    }

    public abstract int i0();

    public abstract void j0(byte b10) throws IOException;

    public abstract void k0(int i10, boolean z10) throws IOException;

    public final void l0(boolean z10) throws IOException {
        j0(z10 ? (byte) 1 : 0);
    }

    public final void m0(byte[] bArr) throws IOException {
        n0(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public abstract void n0(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void o0(int i10, ByteString byteString) throws IOException;

    public abstract void p0(ByteString byteString) throws IOException;

    public final void q0(int i10, double d10) throws IOException {
        w0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void r0(double d10) throws IOException {
        x0(Double.doubleToRawLongBits(d10));
    }

    public final void s0(int i10, int i11) throws IOException {
        E0(i10, i11);
    }

    public final void t0(int i10) throws IOException {
        F0(i10);
    }

    public abstract void u0(int i10, int i11) throws IOException;

    public abstract void v0(int i10) throws IOException;

    public abstract void w0(int i10, long j10) throws IOException;

    public abstract void x0(long j10) throws IOException;

    public final void y0(int i10, float f10) throws IOException {
        u0(i10, Float.floatToRawIntBits(f10));
    }

    public final void z0(float f10) throws IOException {
        v0(Float.floatToRawIntBits(f10));
    }

    private CodedOutputStream() {
    }
}
