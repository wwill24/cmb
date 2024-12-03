package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    int f5261a;

    /* renamed from: b  reason: collision with root package name */
    int f5262b;

    /* renamed from: c  reason: collision with root package name */
    int f5263c;

    /* renamed from: d  reason: collision with root package name */
    i f5264d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5265e;

    private static final class b extends h {

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f5266f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f5267g;

        /* renamed from: h  reason: collision with root package name */
        private int f5268h;

        /* renamed from: i  reason: collision with root package name */
        private int f5269i;

        /* renamed from: j  reason: collision with root package name */
        private int f5270j;

        /* renamed from: k  reason: collision with root package name */
        private int f5271k;

        /* renamed from: l  reason: collision with root package name */
        private int f5272l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f5273m;

        /* renamed from: n  reason: collision with root package name */
        private int f5274n;

        private void M() {
            int i10 = this.f5268h + this.f5269i;
            this.f5268h = i10;
            int i11 = i10 - this.f5271k;
            int i12 = this.f5274n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f5269i = i13;
                this.f5268h = i10 - i13;
                return;
            }
            this.f5269i = 0;
        }

        private void P() throws IOException {
            if (this.f5268h - this.f5270j >= 10) {
                Q();
            } else {
                R();
            }
        }

        private void Q() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                byte[] bArr = this.f5266f;
                int i11 = this.f5270j;
                this.f5270j = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void R() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (F() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public String A() throws IOException {
            int J = J();
            if (J > 0) {
                int i10 = this.f5268h;
                int i11 = this.f5270j;
                if (J <= i10 - i11) {
                    String e10 = Utf8.e(this.f5266f, i11, J);
                    this.f5270j += J;
                    return e10;
                }
            }
            if (J == 0) {
                return "";
            }
            if (J <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        public int B() throws IOException {
            if (e()) {
                this.f5272l = 0;
                return 0;
            }
            int J = J();
            this.f5272l = J;
            if (WireFormat.a(J) != 0) {
                return this.f5272l;
            }
            throw InvalidProtocolBufferException.b();
        }

        public int C() throws IOException {
            return J();
        }

        public long D() throws IOException {
            return K();
        }

        public boolean E(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                P();
                return true;
            } else if (b10 == 1) {
                O(8);
                return true;
            } else if (b10 == 2) {
                O(J());
                return true;
            } else if (b10 == 3) {
                N();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    O(4);
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public byte F() throws IOException {
            int i10 = this.f5270j;
            if (i10 != this.f5268h) {
                byte[] bArr = this.f5266f;
                this.f5270j = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.k();
        }

        public byte[] G(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f5268h;
                int i12 = this.f5270j;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f5270j = i13;
                    return Arrays.copyOfRange(this.f5266f, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.k();
            } else if (i10 == 0) {
                return w.f5384c;
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }

        public int H() throws IOException {
            int i10 = this.f5270j;
            if (this.f5268h - i10 >= 4) {
                byte[] bArr = this.f5266f;
                this.f5270j = i10 + 4;
                return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
            }
            throw InvalidProtocolBufferException.k();
        }

        public long I() throws IOException {
            int i10 = this.f5270j;
            if (this.f5268h - i10 >= 8) {
                byte[] bArr = this.f5266f;
                this.f5270j = i10 + 8;
                return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.k();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int J() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f5270j
                int r1 = r5.f5268h
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f5266f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f5270j = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.L()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f5270j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.b.J():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long K() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f5270j
                int r1 = r11.f5268h
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f5266f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f5270j = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.L()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f5270j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.b.K():long");
        }

        /* access modifiers changed from: package-private */
        public long L() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte F = F();
                j10 |= ((long) (F & Byte.MAX_VALUE)) << i10;
                if ((F & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void N() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.B()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.E(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.b.N():void");
        }

        public void O(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f5268h;
                int i12 = this.f5270j;
                if (i10 <= i11 - i12) {
                    this.f5270j = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f5272l != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        public int d() {
            return this.f5270j - this.f5271k;
        }

        public boolean e() throws IOException {
            return this.f5270j == this.f5268h;
        }

        public void k(int i10) {
            this.f5274n = i10;
            M();
        }

        public int l(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int d10 = i10 + d();
                int i11 = this.f5274n;
                if (d10 <= i11) {
                    this.f5274n = d10;
                    M();
                    return i11;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        public boolean m() throws IOException {
            return K() != 0;
        }

        public ByteString n() throws IOException {
            ByteString byteString;
            int J = J();
            if (J > 0) {
                int i10 = this.f5268h;
                int i11 = this.f5270j;
                if (J <= i10 - i11) {
                    if (!this.f5267g || !this.f5273m) {
                        byteString = ByteString.j(this.f5266f, i11, J);
                    } else {
                        byteString = ByteString.H(this.f5266f, i11, J);
                    }
                    this.f5270j += J;
                    return byteString;
                }
            }
            if (J == 0) {
                return ByteString.f5064a;
            }
            return ByteString.D(G(J));
        }

        public double o() throws IOException {
            return Double.longBitsToDouble(I());
        }

        public int p() throws IOException {
            return J();
        }

        public int q() throws IOException {
            return H();
        }

        public long r() throws IOException {
            return I();
        }

        public float s() throws IOException {
            return Float.intBitsToFloat(H());
        }

        public int t() throws IOException {
            return J();
        }

        public long u() throws IOException {
            return K();
        }

        public int v() throws IOException {
            return H();
        }

        public long w() throws IOException {
            return I();
        }

        public int x() throws IOException {
            return h.b(J());
        }

        public long y() throws IOException {
            return h.c(K());
        }

        public String z() throws IOException {
            int J = J();
            if (J > 0) {
                int i10 = this.f5268h;
                int i11 = this.f5270j;
                if (J <= i10 - i11) {
                    String str = new String(this.f5266f, i11, J, w.f5382a);
                    this.f5270j += J;
                    return str;
                }
            }
            if (J == 0) {
                return "";
            }
            if (J < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f5274n = a.e.API_PRIORITY_OTHER;
            this.f5266f = bArr;
            this.f5268h = i11 + i10;
            this.f5270j = i10;
            this.f5271k = i10;
            this.f5267g = z10;
        }
    }

    private static final class c extends h {

        /* renamed from: f  reason: collision with root package name */
        private final InputStream f5275f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f5276g;

        /* renamed from: h  reason: collision with root package name */
        private int f5277h;

        /* renamed from: i  reason: collision with root package name */
        private int f5278i;

        /* renamed from: j  reason: collision with root package name */
        private int f5279j;

        /* renamed from: k  reason: collision with root package name */
        private int f5280k;

        /* renamed from: l  reason: collision with root package name */
        private int f5281l;

        /* renamed from: m  reason: collision with root package name */
        private int f5282m;

        /* renamed from: n  reason: collision with root package name */
        private a f5283n;

        private interface a {
            void a();
        }

        private ByteString F(int i10) throws IOException {
            byte[] I = I(i10);
            if (I != null) {
                return ByteString.i(I);
            }
            int i11 = this.f5279j;
            int i12 = this.f5277h;
            int i13 = i12 - i11;
            this.f5281l += i12;
            this.f5279j = 0;
            this.f5277h = 0;
            List<byte[]> J = J(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f5276g, i11, bArr, 0, i13);
            for (byte[] next : J) {
                System.arraycopy(next, 0, bArr, i13, next.length);
                i13 += next.length;
            }
            return ByteString.D(bArr);
        }

        private byte[] H(int i10, boolean z10) throws IOException {
            byte[] I = I(i10);
            if (I == null) {
                int i11 = this.f5279j;
                int i12 = this.f5277h;
                int i13 = i12 - i11;
                this.f5281l += i12;
                this.f5279j = 0;
                this.f5277h = 0;
                List<byte[]> J = J(i10 - i13);
                byte[] bArr = new byte[i10];
                System.arraycopy(this.f5276g, i11, bArr, 0, i13);
                for (byte[] next : J) {
                    System.arraycopy(next, 0, bArr, i13, next.length);
                    i13 += next.length;
                }
                return bArr;
            } else if (z10) {
                return (byte[]) I.clone();
            } else {
                return I;
            }
        }

        private byte[] I(int i10) throws IOException {
            if (i10 == 0) {
                return w.f5384c;
            }
            if (i10 >= 0) {
                int i11 = this.f5281l;
                int i12 = this.f5279j;
                int i13 = i11 + i12 + i10;
                if (i13 - this.f5263c <= 0) {
                    int i14 = this.f5282m;
                    if (i13 <= i14) {
                        int i15 = this.f5277h - i12;
                        int i16 = i10 - i15;
                        if (i16 >= 4096 && i16 > this.f5275f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i10];
                        System.arraycopy(this.f5276g, this.f5279j, bArr, 0, i15);
                        this.f5281l += this.f5277h;
                        this.f5279j = 0;
                        this.f5277h = 0;
                        while (i15 < i10) {
                            int read = this.f5275f.read(bArr, i15, i10 - i15);
                            if (read != -1) {
                                this.f5281l += read;
                                i15 += read;
                            } else {
                                throw InvalidProtocolBufferException.k();
                            }
                        }
                        return bArr;
                    }
                    S((i14 - i11) - i12);
                    throw InvalidProtocolBufferException.k();
                }
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.f();
        }

        private List<byte[]> J(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, Opcodes.ACC_SYNTHETIC);
                byte[] bArr = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    int read = this.f5275f.read(bArr, i11, min - i11);
                    if (read != -1) {
                        this.f5281l += read;
                        i11 += read;
                    } else {
                        throw InvalidProtocolBufferException.k();
                    }
                }
                i10 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void P() {
            int i10 = this.f5277h + this.f5278i;
            this.f5277h = i10;
            int i11 = this.f5281l + i10;
            int i12 = this.f5282m;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f5278i = i13;
                this.f5277h = i10 - i13;
                return;
            }
            this.f5278i = 0;
        }

        private void Q(int i10) throws IOException {
            if (X(i10)) {
                return;
            }
            if (i10 > (this.f5263c - this.f5281l) - this.f5279j) {
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.k();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f5275f.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void T(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.f5281l
                int r1 = r8.f5279j
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.f5282m
                if (r2 > r3) goto L_0x008d
                androidx.datastore.preferences.protobuf.h$c$a r2 = r8.f5283n
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.f5281l = r0
                int r0 = r8.f5277h
                int r0 = r0 - r1
                r8.f5277h = r3
                r8.f5279j = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f5275f     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = r1.skip(r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r0 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r0
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.f5275f     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.f5281l
                int r0 = r0 + r3
                r8.f5281l = r0
                r8.P()
                throw r9
            L_0x0067:
                int r0 = r8.f5281l
                int r0 = r0 + r3
                r8.f5281l = r0
                r8.P()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.f5277h
                int r1 = r8.f5279j
                int r1 = r0 - r1
                r8.f5279j = r0
                r0 = 1
                r8.Q(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.f5277h
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.f5279j = r3
                r8.Q(r0)
                goto L_0x007d
            L_0x008a:
                r8.f5279j = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.S(r3)
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.k()
                throw r9
            L_0x0097:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.f()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.c.T(int):void");
        }

        private void U() throws IOException {
            if (this.f5277h - this.f5279j >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                byte[] bArr = this.f5276g;
                int i11 = this.f5279j;
                this.f5279j = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void W() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (G() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private boolean X(int i10) throws IOException {
            int i11 = this.f5279j;
            if (i11 + i10 > this.f5277h) {
                int i12 = this.f5263c;
                int i13 = this.f5281l;
                if (i10 > (i12 - i13) - i11 || i13 + i11 + i10 > this.f5282m) {
                    return false;
                }
                a aVar = this.f5283n;
                if (aVar != null) {
                    aVar.a();
                }
                int i14 = this.f5279j;
                if (i14 > 0) {
                    int i15 = this.f5277h;
                    if (i15 > i14) {
                        byte[] bArr = this.f5276g;
                        System.arraycopy(bArr, i14, bArr, 0, i15 - i14);
                    }
                    this.f5281l += i14;
                    this.f5277h -= i14;
                    this.f5279j = 0;
                }
                InputStream inputStream = this.f5275f;
                byte[] bArr2 = this.f5276g;
                int i16 = this.f5277h;
                int read = inputStream.read(bArr2, i16, Math.min(bArr2.length - i16, (this.f5263c - this.f5281l) - i16));
                if (read == 0 || read < -1 || read > this.f5276g.length) {
                    throw new IllegalStateException(this.f5275f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f5277h += read;
                    P();
                    if (this.f5277h >= i10) {
                        return true;
                    }
                    return X(i10);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
            }
        }

        public String A() throws IOException {
            byte[] bArr;
            int M = M();
            int i10 = this.f5279j;
            int i11 = this.f5277h;
            if (M <= i11 - i10 && M > 0) {
                bArr = this.f5276g;
                this.f5279j = i10 + M;
            } else if (M == 0) {
                return "";
            } else {
                if (M <= i11) {
                    Q(M);
                    bArr = this.f5276g;
                    this.f5279j = M + 0;
                } else {
                    bArr = H(M, false);
                }
                i10 = 0;
            }
            return Utf8.e(bArr, i10, M);
        }

        public int B() throws IOException {
            if (e()) {
                this.f5280k = 0;
                return 0;
            }
            int M = M();
            this.f5280k = M;
            if (WireFormat.a(M) != 0) {
                return this.f5280k;
            }
            throw InvalidProtocolBufferException.b();
        }

        public int C() throws IOException {
            return M();
        }

        public long D() throws IOException {
            return N();
        }

        public boolean E(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                U();
                return true;
            } else if (b10 == 1) {
                S(8);
                return true;
            } else if (b10 == 2) {
                S(M());
                return true;
            } else if (b10 == 3) {
                R();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    S(4);
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public byte G() throws IOException {
            if (this.f5279j == this.f5277h) {
                Q(1);
            }
            byte[] bArr = this.f5276g;
            int i10 = this.f5279j;
            this.f5279j = i10 + 1;
            return bArr[i10];
        }

        public int K() throws IOException {
            int i10 = this.f5279j;
            if (this.f5277h - i10 < 4) {
                Q(4);
                i10 = this.f5279j;
            }
            byte[] bArr = this.f5276g;
            this.f5279j = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
        }

        public long L() throws IOException {
            int i10 = this.f5279j;
            if (this.f5277h - i10 < 8) {
                Q(8);
                i10 = this.f5279j;
            }
            byte[] bArr = this.f5276g;
            this.f5279j = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int M() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f5279j
                int r1 = r5.f5277h
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f5276g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f5279j = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.O()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f5279j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.c.M():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long N() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f5279j
                int r1 = r11.f5277h
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f5276g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f5279j = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.O()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f5279j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.c.N():long");
        }

        /* access modifiers changed from: package-private */
        public long O() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte G = G();
                j10 |= ((long) (G & Byte.MAX_VALUE)) << i10;
                if ((G & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void R() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.B()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.E(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.c.R():void");
        }

        public void S(int i10) throws IOException {
            int i11 = this.f5277h;
            int i12 = this.f5279j;
            if (i10 > i11 - i12 || i10 < 0) {
                T(i10);
            } else {
                this.f5279j = i12 + i10;
            }
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f5280k != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        public int d() {
            return this.f5281l + this.f5279j;
        }

        public boolean e() throws IOException {
            return this.f5279j == this.f5277h && !X(1);
        }

        public void k(int i10) {
            this.f5282m = i10;
            P();
        }

        public int l(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int i11 = i10 + this.f5281l + this.f5279j;
                int i12 = this.f5282m;
                if (i11 <= i12) {
                    this.f5282m = i11;
                    P();
                    return i12;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        public boolean m() throws IOException {
            return N() != 0;
        }

        public ByteString n() throws IOException {
            int M = M();
            int i10 = this.f5277h;
            int i11 = this.f5279j;
            if (M <= i10 - i11 && M > 0) {
                ByteString j10 = ByteString.j(this.f5276g, i11, M);
                this.f5279j += M;
                return j10;
            } else if (M == 0) {
                return ByteString.f5064a;
            } else {
                return F(M);
            }
        }

        public double o() throws IOException {
            return Double.longBitsToDouble(L());
        }

        public int p() throws IOException {
            return M();
        }

        public int q() throws IOException {
            return K();
        }

        public long r() throws IOException {
            return L();
        }

        public float s() throws IOException {
            return Float.intBitsToFloat(K());
        }

        public int t() throws IOException {
            return M();
        }

        public long u() throws IOException {
            return N();
        }

        public int v() throws IOException {
            return K();
        }

        public long w() throws IOException {
            return L();
        }

        public int x() throws IOException {
            return h.b(M());
        }

        public long y() throws IOException {
            return h.c(N());
        }

        public String z() throws IOException {
            int M = M();
            if (M > 0) {
                int i10 = this.f5277h;
                int i11 = this.f5279j;
                if (M <= i10 - i11) {
                    String str = new String(this.f5276g, i11, M, w.f5382a);
                    this.f5279j += M;
                    return str;
                }
            }
            if (M == 0) {
                return "";
            }
            if (M > this.f5277h) {
                return new String(H(M, false), w.f5382a);
            }
            Q(M);
            String str2 = new String(this.f5276g, this.f5279j, M, w.f5382a);
            this.f5279j += M;
            return str2;
        }

        private c(InputStream inputStream, int i10) {
            super();
            this.f5282m = a.e.API_PRIORITY_OTHER;
            this.f5283n = null;
            w.b(inputStream, "input");
            this.f5275f = inputStream;
            this.f5276g = new byte[i10];
            this.f5277h = 0;
            this.f5279j = 0;
            this.f5281l = 0;
        }
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static h f(InputStream inputStream) {
        return g(inputStream, Opcodes.ACC_SYNTHETIC);
    }

    public static h g(InputStream inputStream, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return h(w.f5384c);
        } else {
            return new c(inputStream, i10);
        }
    }

    public static h h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static h i(byte[] bArr, int i10, int i11) {
        return j(bArr, i10, i11, false);
    }

    static h j(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.l(i11);
            return bVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract String A() throws IOException;

    public abstract int B() throws IOException;

    public abstract int C() throws IOException;

    public abstract long D() throws IOException;

    public abstract boolean E(int i10) throws IOException;

    public abstract void a(int i10) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void k(int i10);

    public abstract int l(int i10) throws InvalidProtocolBufferException;

    public abstract boolean m() throws IOException;

    public abstract ByteString n() throws IOException;

    public abstract double o() throws IOException;

    public abstract int p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract float s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract String z() throws IOException;

    private h() {
        this.f5262b = 100;
        this.f5263c = a.e.API_PRIORITY_OTHER;
        this.f5265e = false;
    }
}
