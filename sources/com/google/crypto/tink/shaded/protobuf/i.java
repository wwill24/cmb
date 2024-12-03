package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.Arrays;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    int f20807a;

    /* renamed from: b  reason: collision with root package name */
    int f20808b;

    /* renamed from: c  reason: collision with root package name */
    int f20809c;

    /* renamed from: d  reason: collision with root package name */
    j f20810d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20811e;

    private static final class b extends i {

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f20812f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f20813g;

        /* renamed from: h  reason: collision with root package name */
        private int f20814h;

        /* renamed from: i  reason: collision with root package name */
        private int f20815i;

        /* renamed from: j  reason: collision with root package name */
        private int f20816j;

        /* renamed from: k  reason: collision with root package name */
        private int f20817k;

        /* renamed from: l  reason: collision with root package name */
        private int f20818l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f20819m;

        /* renamed from: n  reason: collision with root package name */
        private int f20820n;

        private void K() {
            int i10 = this.f20814h + this.f20815i;
            this.f20814h = i10;
            int i11 = i10 - this.f20817k;
            int i12 = this.f20820n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f20815i = i13;
                this.f20814h = i10 - i13;
                return;
            }
            this.f20815i = 0;
        }

        private void N() throws IOException {
            if (this.f20814h - this.f20816j >= 10) {
                O();
            } else {
                P();
            }
        }

        private void O() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                byte[] bArr = this.f20812f;
                int i11 = this.f20816j;
                this.f20816j = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void P() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (D() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public int A() throws IOException {
            return H();
        }

        public long B() throws IOException {
            return I();
        }

        public boolean C(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                N();
                return true;
            } else if (b10 == 1) {
                M(8);
                return true;
            } else if (b10 == 2) {
                M(H());
                return true;
            } else if (b10 == 3) {
                L();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    M(4);
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public byte D() throws IOException {
            int i10 = this.f20816j;
            if (i10 != this.f20814h) {
                byte[] bArr = this.f20812f;
                this.f20816j = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.j();
        }

        public byte[] E(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f20814h;
                int i12 = this.f20816j;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f20816j = i13;
                    return Arrays.copyOfRange(this.f20812f, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.j();
            } else if (i10 == 0) {
                return x.f20919c;
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }

        public int F() throws IOException {
            int i10 = this.f20816j;
            if (this.f20814h - i10 >= 4) {
                byte[] bArr = this.f20812f;
                this.f20816j = i10 + 4;
                return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
            }
            throw InvalidProtocolBufferException.j();
        }

        public long G() throws IOException {
            int i10 = this.f20816j;
            if (this.f20814h - i10 >= 8) {
                byte[] bArr = this.f20812f;
                this.f20816j = i10 + 8;
                return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.j();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int H() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f20816j
                int r1 = r5.f20814h
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f20812f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f20816j = r3
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
                long r0 = r5.J()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f20816j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.i.b.H():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long I() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f20816j
                int r1 = r11.f20814h
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f20812f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f20816j = r3
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
                long r0 = r11.J()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f20816j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.i.b.I():long");
        }

        /* access modifiers changed from: package-private */
        public long J() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte D = D();
                j10 |= ((long) (D & Byte.MAX_VALUE)) << i10;
                if ((D & 128) == 0) {
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
        public void L() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.z()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.C(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.i.b.L():void");
        }

        public void M(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f20814h;
                int i12 = this.f20816j;
                if (i10 <= i11 - i12) {
                    this.f20816j = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f20818l != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        public int d() {
            return this.f20816j - this.f20817k;
        }

        public boolean e() throws IOException {
            return this.f20816j == this.f20814h;
        }

        public void i(int i10) {
            this.f20820n = i10;
            K();
        }

        public int j(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int d10 = i10 + d();
                int i11 = this.f20820n;
                if (d10 <= i11) {
                    this.f20820n = d10;
                    K();
                    return i11;
                }
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.f();
        }

        public boolean k() throws IOException {
            return I() != 0;
        }

        public ByteString l() throws IOException {
            ByteString byteString;
            int H = H();
            if (H > 0) {
                int i10 = this.f20814h;
                int i11 = this.f20816j;
                if (H <= i10 - i11) {
                    if (!this.f20813g || !this.f20819m) {
                        byteString = ByteString.j(this.f20812f, i11, H);
                    } else {
                        byteString = ByteString.J(this.f20812f, i11, H);
                    }
                    this.f20816j += H;
                    return byteString;
                }
            }
            if (H == 0) {
                return ByteString.f20615a;
            }
            return ByteString.H(E(H));
        }

        public double m() throws IOException {
            return Double.longBitsToDouble(G());
        }

        public int n() throws IOException {
            return H();
        }

        public int o() throws IOException {
            return F();
        }

        public long p() throws IOException {
            return G();
        }

        public float q() throws IOException {
            return Float.intBitsToFloat(F());
        }

        public int r() throws IOException {
            return H();
        }

        public long s() throws IOException {
            return I();
        }

        public int t() throws IOException {
            return F();
        }

        public long u() throws IOException {
            return G();
        }

        public int v() throws IOException {
            return i.b(H());
        }

        public long w() throws IOException {
            return i.c(I());
        }

        public String x() throws IOException {
            int H = H();
            if (H > 0) {
                int i10 = this.f20814h;
                int i11 = this.f20816j;
                if (H <= i10 - i11) {
                    String str = new String(this.f20812f, i11, H, x.f20917a);
                    this.f20816j += H;
                    return str;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        public String y() throws IOException {
            int H = H();
            if (H > 0) {
                int i10 = this.f20814h;
                int i11 = this.f20816j;
                if (H <= i10 - i11) {
                    String e10 = Utf8.e(this.f20812f, i11, H);
                    this.f20816j += H;
                    return e10;
                }
            }
            if (H == 0) {
                return "";
            }
            if (H <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }

        public int z() throws IOException {
            if (e()) {
                this.f20818l = 0;
                return 0;
            }
            int H = H();
            this.f20818l = H;
            if (WireFormat.a(H) != 0) {
                return this.f20818l;
            }
            throw InvalidProtocolBufferException.b();
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f20820n = a.e.API_PRIORITY_OTHER;
            this.f20812f = bArr;
            this.f20814h = i11 + i10;
            this.f20816j = i10;
            this.f20817k = i10;
            this.f20813g = z10;
        }
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static i f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public static i g(byte[] bArr, int i10, int i11) {
        return h(bArr, i10, i11, false);
    }

    static i h(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.j(i11);
            return bVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract int A() throws IOException;

    public abstract long B() throws IOException;

    public abstract boolean C(int i10) throws IOException;

    public abstract void a(int i10) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void i(int i10);

    public abstract int j(int i10) throws InvalidProtocolBufferException;

    public abstract boolean k() throws IOException;

    public abstract ByteString l() throws IOException;

    public abstract double m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract float q() throws IOException;

    public abstract int r() throws IOException;

    public abstract long s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract String x() throws IOException;

    public abstract String y() throws IOException;

    public abstract int z() throws IOException;

    private i() {
        this.f20808b = 100;
        this.f20809c = a.e.API_PRIORITY_OTHER;
        this.f20811e = false;
    }
}
