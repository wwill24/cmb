package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class h {

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f21808f = 100;

    /* renamed from: a  reason: collision with root package name */
    int f21809a;

    /* renamed from: b  reason: collision with root package name */
    int f21810b;

    /* renamed from: c  reason: collision with root package name */
    int f21811c;

    /* renamed from: d  reason: collision with root package name */
    i f21812d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21813e;

    private static final class b extends h {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f21814g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f21815h;

        /* renamed from: i  reason: collision with root package name */
        private int f21816i;

        /* renamed from: j  reason: collision with root package name */
        private int f21817j;

        /* renamed from: k  reason: collision with root package name */
        private int f21818k;

        /* renamed from: l  reason: collision with root package name */
        private int f21819l;

        /* renamed from: m  reason: collision with root package name */
        private int f21820m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f21821n;

        /* renamed from: o  reason: collision with root package name */
        private int f21822o;

        private void Q() {
            int i10 = this.f21816i + this.f21817j;
            this.f21816i = i10;
            int i11 = i10 - this.f21819l;
            int i12 = this.f21822o;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f21817j = i13;
                this.f21816i = i10 - i13;
                return;
            }
            this.f21817j = 0;
        }

        private void T() throws IOException {
            if (this.f21816i - this.f21818k >= 10) {
                U();
            } else {
                V();
            }
        }

        private void U() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                byte[] bArr = this.f21814g;
                int i11 = this.f21818k;
                this.f21818k = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void V() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (J() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public long A() throws IOException {
            return M();
        }

        public int B() throws IOException {
            return h.b(N());
        }

        public long C() throws IOException {
            return h.c(O());
        }

        public String D() throws IOException {
            int N = N();
            if (N > 0) {
                int i10 = this.f21816i;
                int i11 = this.f21818k;
                if (N <= i10 - i11) {
                    String str = new String(this.f21814g, i11, N, w.f21953b);
                    this.f21818k += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        public String E() throws IOException {
            int N = N();
            if (N > 0) {
                int i10 = this.f21816i;
                int i11 = this.f21818k;
                if (N <= i10 - i11) {
                    String h10 = Utf8.h(this.f21814g, i11, N);
                    this.f21818k += N;
                    return h10;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        public int F() throws IOException {
            if (e()) {
                this.f21820m = 0;
                return 0;
            }
            int N = N();
            this.f21820m = N;
            if (WireFormat.a(N) != 0) {
                return this.f21820m;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int G() throws IOException {
            return N();
        }

        public long H() throws IOException {
            return O();
        }

        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                T();
                return true;
            } else if (b10 == 1) {
                S(8);
                return true;
            } else if (b10 == 2) {
                S(N());
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
                throw InvalidProtocolBufferException.e();
            }
        }

        public byte J() throws IOException {
            int i10 = this.f21818k;
            if (i10 != this.f21816i) {
                byte[] bArr = this.f21814g;
                this.f21818k = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.m();
        }

        public byte[] K(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f21816i;
                int i12 = this.f21818k;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f21818k = i13;
                    return Arrays.copyOfRange(this.f21814g, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.m();
            } else if (i10 == 0) {
                return w.f21955d;
            } else {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int L() throws IOException {
            int i10 = this.f21818k;
            if (this.f21816i - i10 >= 4) {
                byte[] bArr = this.f21814g;
                this.f21818k = i10 + 4;
                return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
            }
            throw InvalidProtocolBufferException.m();
        }

        public long M() throws IOException {
            int i10 = this.f21818k;
            if (this.f21816i - i10 >= 8) {
                byte[] bArr = this.f21814g;
                this.f21818k = i10 + 8;
                return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int N() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f21818k
                int r1 = r5.f21816i
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f21814g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f21818k = r3
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
                long r0 = r5.P()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f21818k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.b.N():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long O() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f21818k
                int r1 = r11.f21816i
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f21814g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f21818k = r3
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
                long r0 = r11.P()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f21818k = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.b.O():long");
        }

        /* access modifiers changed from: package-private */
        public long P() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte J = J();
                j10 |= ((long) (J & Byte.MAX_VALUE)) << i10;
                if ((J & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.f();
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
                int r0 = r1.F()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.I(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.b.R():void");
        }

        public void S(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f21816i;
                int i12 = this.f21818k;
                if (i10 <= i11 - i12) {
                    this.f21818k = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f21820m != i10) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public int d() {
            return this.f21818k - this.f21819l;
        }

        public boolean e() throws IOException {
            return this.f21818k == this.f21816i;
        }

        public void n(int i10) {
            this.f21822o = i10;
            Q();
        }

        public int o(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int d10 = i10 + d();
                if (d10 >= 0) {
                    int i11 = this.f21822o;
                    if (d10 <= i11) {
                        this.f21822o = d10;
                        Q();
                        return i11;
                    }
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean p() throws IOException {
            return O() != 0;
        }

        public ByteString q() throws IOException {
            ByteString byteString;
            int N = N();
            if (N > 0) {
                int i10 = this.f21816i;
                int i11 = this.f21818k;
                if (N <= i10 - i11) {
                    if (!this.f21815h || !this.f21821n) {
                        byteString = ByteString.r(this.f21814g, i11, N);
                    } else {
                        byteString = ByteString.X(this.f21814g, i11, N);
                    }
                    this.f21818k += N;
                    return byteString;
                }
            }
            if (N == 0) {
                return ByteString.f21603a;
            }
            return ByteString.W(K(N));
        }

        public double r() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int s() throws IOException {
            return N();
        }

        public int t() throws IOException {
            return L();
        }

        public long u() throws IOException {
            return M();
        }

        public float v() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public int w() throws IOException {
            return N();
        }

        public long x() throws IOException {
            return O();
        }

        public int z() throws IOException {
            return L();
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f21822o = a.e.API_PRIORITY_OTHER;
            this.f21814g = bArr;
            this.f21816i = i11 + i10;
            this.f21818k = i10;
            this.f21819l = i10;
            this.f21815h = z10;
        }
    }

    private static final class c extends h {

        /* renamed from: g  reason: collision with root package name */
        private final Iterable<ByteBuffer> f21823g;

        /* renamed from: h  reason: collision with root package name */
        private final Iterator<ByteBuffer> f21824h;

        /* renamed from: i  reason: collision with root package name */
        private ByteBuffer f21825i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f21826j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f21827k;

        /* renamed from: l  reason: collision with root package name */
        private int f21828l;

        /* renamed from: m  reason: collision with root package name */
        private int f21829m;

        /* renamed from: n  reason: collision with root package name */
        private int f21830n;

        /* renamed from: o  reason: collision with root package name */
        private int f21831o;

        /* renamed from: p  reason: collision with root package name */
        private int f21832p;

        /* renamed from: q  reason: collision with root package name */
        private int f21833q;

        /* renamed from: r  reason: collision with root package name */
        private long f21834r;

        /* renamed from: s  reason: collision with root package name */
        private long f21835s;

        /* renamed from: t  reason: collision with root package name */
        private long f21836t;

        /* renamed from: u  reason: collision with root package name */
        private long f21837u;

        private long J() {
            return this.f21837u - this.f21834r;
        }

        private void K() throws InvalidProtocolBufferException {
            if (this.f21824h.hasNext()) {
                Y();
                return;
            }
            throw InvalidProtocolBufferException.m();
        }

        private void M(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 >= 0 && i11 <= T()) {
                int i12 = i11;
                while (i12 > 0) {
                    if (J() == 0) {
                        K();
                    }
                    int min = Math.min(i12, (int) J());
                    long j10 = (long) min;
                    j1.p(this.f21834r, bArr, (long) ((i11 - i12) + i10), j10);
                    i12 -= min;
                    this.f21834r += j10;
                }
            } else if (i11 > 0) {
                throw InvalidProtocolBufferException.m();
            } else if (i11 != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void S() {
            int i10 = this.f21828l + this.f21829m;
            this.f21828l = i10;
            int i11 = i10 - this.f21833q;
            int i12 = this.f21830n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f21829m = i13;
                this.f21828l = i10 - i13;
                return;
            }
            this.f21829m = 0;
        }

        private int T() {
            return (int) ((((long) (this.f21828l - this.f21832p)) - this.f21834r) + this.f21835s);
        }

        private void W() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (L() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
            r2.position(r0);
            r2.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0023 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer X(int r4, int r5) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f21825i
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f21825i
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f21825i
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r3.f21825i     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.position(r0)
                r2.limit(r1)
                return r4
            L_0x0021:
                r4 = move-exception
                goto L_0x0028
            L_0x0023:
                com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.m()     // Catch:{ all -> 0x0021 }
                throw r4     // Catch:{ all -> 0x0021 }
            L_0x0028:
                r2.position(r0)
                r2.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.c.X(int, int):java.nio.ByteBuffer");
        }

        private void Y() {
            ByteBuffer next = this.f21824h.next();
            this.f21825i = next;
            this.f21832p += (int) (this.f21834r - this.f21835s);
            long position = (long) next.position();
            this.f21834r = position;
            this.f21835s = position;
            this.f21837u = (long) this.f21825i.limit();
            long k10 = j1.k(this.f21825i);
            this.f21836t = k10;
            this.f21834r += k10;
            this.f21835s += k10;
            this.f21837u += k10;
        }

        public long A() throws IOException {
            return O();
        }

        public int B() throws IOException {
            return h.b(P());
        }

        public long C() throws IOException {
            return h.c(Q());
        }

        public String D() throws IOException {
            int P = P();
            if (P > 0) {
                long j10 = (long) P;
                long j11 = this.f21837u;
                long j12 = this.f21834r;
                if (j10 <= j11 - j12) {
                    byte[] bArr = new byte[P];
                    j1.p(j12, bArr, 0, j10);
                    String str = new String(bArr, w.f21953b);
                    this.f21834r += j10;
                    return str;
                }
            }
            if (P > 0 && P <= T()) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return new String(bArr2, w.f21953b);
            } else if (P == 0) {
                return "";
            } else {
                if (P < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        public String E() throws IOException {
            int P = P();
            if (P > 0) {
                long j10 = (long) P;
                long j11 = this.f21837u;
                long j12 = this.f21834r;
                if (j10 <= j11 - j12) {
                    String g10 = Utf8.g(this.f21825i, (int) (j12 - this.f21835s), P);
                    this.f21834r += j10;
                    return g10;
                }
            }
            if (P >= 0 && P <= T()) {
                byte[] bArr = new byte[P];
                M(bArr, 0, P);
                return Utf8.h(bArr, 0, P);
            } else if (P == 0) {
                return "";
            } else {
                if (P <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        public int F() throws IOException {
            if (e()) {
                this.f21831o = 0;
                return 0;
            }
            int P = P();
            this.f21831o = P;
            if (WireFormat.a(P) != 0) {
                return this.f21831o;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int G() throws IOException {
            return P();
        }

        public long H() throws IOException {
            return Q();
        }

        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                W();
                return true;
            } else if (b10 == 1) {
                V(8);
                return true;
            } else if (b10 == 2) {
                V(P());
                return true;
            } else if (b10 == 3) {
                U();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    V(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public byte L() throws IOException {
            if (J() == 0) {
                K();
            }
            long j10 = this.f21834r;
            this.f21834r = 1 + j10;
            return j1.w(j10);
        }

        public int N() throws IOException {
            if (J() < 4) {
                return (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << Tnaf.POW_2_WIDTH) | ((L() & 255) << 24);
            }
            long j10 = this.f21834r;
            this.f21834r = 4 + j10;
            return ((j1.w(j10 + 3) & 255) << 24) | (j1.w(j10) & 255) | ((j1.w(1 + j10) & 255) << 8) | ((j1.w(2 + j10) & 255) << Tnaf.POW_2_WIDTH);
        }

        public long O() throws IOException {
            long L;
            byte L2;
            if (J() >= 8) {
                long j10 = this.f21834r;
                this.f21834r = 8 + j10;
                L = (((long) j1.w(j10)) & 255) | ((((long) j1.w(1 + j10)) & 255) << 8) | ((((long) j1.w(2 + j10)) & 255) << 16) | ((((long) j1.w(3 + j10)) & 255) << 24) | ((((long) j1.w(4 + j10)) & 255) << 32) | ((((long) j1.w(5 + j10)) & 255) << 40) | ((((long) j1.w(6 + j10)) & 255) << 48);
                L2 = j1.w(j10 + 7);
            } else {
                L = (((long) L()) & 255) | ((((long) L()) & 255) << 8) | ((((long) L()) & 255) << 16) | ((((long) L()) & 255) << 24) | ((((long) L()) & 255) << 32) | ((((long) L()) & 255) << 40) | ((((long) L()) & 255) << 48);
                L2 = L();
            }
            return ((((long) L2) & 255) << 56) | L;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
            if (com.google.protobuf.j1.w(r4) < 0) goto L_0x008a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int P() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f21834r
                long r2 = r10.f21837u
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x008a
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.j1.w(r0)
                if (r0 < 0) goto L_0x001a
                long r4 = r10.f21834r
                long r4 = r4 + r2
                r10.f21834r = r4
                return r0
            L_0x001a:
                long r6 = r10.f21837u
                long r8 = r10.f21834r
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0026
                goto L_0x008a
            L_0x0026:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0034
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0090
            L_0x0034:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0043
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x0041:
                r6 = r4
                goto L_0x0090
            L_0x0043:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0053
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x0090
            L_0x0053:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x0090
            L_0x008a:
                long r0 = r10.R()
                int r0 = (int) r0
                return r0
            L_0x0090:
                r10.f21834r = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.c.P():int");
        }

        public long Q() throws IOException {
            long j10;
            long j11;
            long j12;
            byte b10;
            long j13 = this.f21834r;
            if (this.f21837u != j13) {
                long j14 = j13 + 1;
                byte w10 = j1.w(j13);
                if (w10 >= 0) {
                    this.f21834r++;
                    return (long) w10;
                } else if (this.f21837u - this.f21834r >= 10) {
                    long j15 = j14 + 1;
                    byte w11 = w10 ^ (j1.w(j14) << 7);
                    if (w11 < 0) {
                        b10 = w11 ^ Byte.MIN_VALUE;
                    } else {
                        long j16 = j15 + 1;
                        byte w12 = w11 ^ (j1.w(j15) << 14);
                        if (w12 >= 0) {
                            j10 = (long) (w12 ^ 16256);
                        } else {
                            j15 = j16 + 1;
                            byte w13 = w12 ^ (j1.w(j16) << 21);
                            if (w13 < 0) {
                                b10 = w13 ^ -2080896;
                            } else {
                                j16 = j15 + 1;
                                long w14 = ((long) w13) ^ (((long) j1.w(j15)) << 28);
                                if (w14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    long j17 = j16 + 1;
                                    long w15 = w14 ^ (((long) j1.w(j16)) << 35);
                                    if (w15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        j16 = j17 + 1;
                                        w14 = w15 ^ (((long) j1.w(j17)) << 42);
                                        if (w14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            j17 = j16 + 1;
                                            w15 = w14 ^ (((long) j1.w(j16)) << 49);
                                            if (w15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                j16 = j17 + 1;
                                                j10 = (w15 ^ (((long) j1.w(j17)) << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    long j18 = 1 + j16;
                                                    if (((long) j1.w(j16)) >= 0) {
                                                        j15 = j18;
                                                        this.f21834r = j15;
                                                        return j10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j10 = w15 ^ j11;
                                    j15 = j17;
                                    this.f21834r = j15;
                                    return j10;
                                }
                                j10 = w14 ^ j12;
                            }
                        }
                        j15 = j16;
                        this.f21834r = j15;
                        return j10;
                    }
                    j10 = (long) b10;
                    this.f21834r = j15;
                    return j10;
                }
            }
            return R();
        }

        /* access modifiers changed from: package-private */
        public long R() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte L = L();
                j10 |= ((long) (L & Byte.MAX_VALUE)) << i10;
                if ((L & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void U() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.F()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.I(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.c.U():void");
        }

        public void V(int i10) throws IOException {
            if (i10 >= 0 && ((long) i10) <= (((long) (this.f21828l - this.f21832p)) - this.f21834r) + this.f21835s) {
                while (i10 > 0) {
                    if (J() == 0) {
                        K();
                    }
                    int min = Math.min(i10, (int) J());
                    i10 -= min;
                    this.f21834r += (long) min;
                }
            } else if (i10 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f21831o != i10) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public int d() {
            return (int) ((((long) (this.f21832p - this.f21833q)) + this.f21834r) - this.f21835s);
        }

        public boolean e() throws IOException {
            return (((long) this.f21832p) + this.f21834r) - this.f21835s == ((long) this.f21828l);
        }

        public void n(int i10) {
            this.f21830n = i10;
            S();
        }

        public int o(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int d10 = i10 + d();
                int i11 = this.f21830n;
                if (d10 <= i11) {
                    this.f21830n = d10;
                    S();
                    return i11;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean p() throws IOException {
            return Q() != 0;
        }

        public ByteString q() throws IOException {
            int P = P();
            if (P > 0) {
                long j10 = (long) P;
                long j11 = this.f21837u;
                long j12 = this.f21834r;
                if (j10 <= j11 - j12) {
                    if (!this.f21826j || !this.f21827k) {
                        byte[] bArr = new byte[P];
                        j1.p(j12, bArr, 0, j10);
                        this.f21834r += j10;
                        return ByteString.W(bArr);
                    }
                    int i10 = (int) (j12 - this.f21836t);
                    ByteString V = ByteString.V(X(i10, P + i10));
                    this.f21834r += j10;
                    return V;
                }
            }
            if (P <= 0 || P > T()) {
                if (P == 0) {
                    return ByteString.f21603a;
                }
                if (P < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            } else if (!this.f21826j || !this.f21827k) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return ByteString.W(bArr2);
            } else {
                ArrayList arrayList = new ArrayList();
                while (P > 0) {
                    if (J() == 0) {
                        K();
                    }
                    int min = Math.min(P, (int) J());
                    int i11 = (int) (this.f21834r - this.f21836t);
                    arrayList.add(ByteString.V(X(i11, i11 + min)));
                    P -= min;
                    this.f21834r += (long) min;
                }
                return ByteString.n(arrayList);
            }
        }

        public double r() throws IOException {
            return Double.longBitsToDouble(O());
        }

        public int s() throws IOException {
            return P();
        }

        public int t() throws IOException {
            return N();
        }

        public long u() throws IOException {
            return O();
        }

        public float v() throws IOException {
            return Float.intBitsToFloat(N());
        }

        public int w() throws IOException {
            return P();
        }

        public long x() throws IOException {
            return Q();
        }

        public int z() throws IOException {
            return N();
        }

        private c(Iterable<ByteBuffer> iterable, int i10, boolean z10) {
            super();
            this.f21830n = a.e.API_PRIORITY_OTHER;
            this.f21828l = i10;
            this.f21823g = iterable;
            this.f21824h = iterable.iterator();
            this.f21826j = z10;
            this.f21832p = 0;
            this.f21833q = 0;
            if (i10 == 0) {
                this.f21825i = w.f21956e;
                this.f21834r = 0;
                this.f21835s = 0;
                this.f21837u = 0;
                this.f21836t = 0;
                return;
            }
            Y();
        }
    }

    private static final class d extends h {

        /* renamed from: g  reason: collision with root package name */
        private final InputStream f21838g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f21839h;

        /* renamed from: i  reason: collision with root package name */
        private int f21840i;

        /* renamed from: j  reason: collision with root package name */
        private int f21841j;

        /* renamed from: k  reason: collision with root package name */
        private int f21842k;

        /* renamed from: l  reason: collision with root package name */
        private int f21843l;

        /* renamed from: m  reason: collision with root package name */
        private int f21844m;

        /* renamed from: n  reason: collision with root package name */
        private int f21845n;

        /* renamed from: o  reason: collision with root package name */
        private a f21846o;

        private interface a {
            void a();
        }

        private static int J(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e10) {
                e10.j();
                throw e10;
            }
        }

        private static int K(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
            try {
                return inputStream.read(bArr, i10, i11);
            } catch (InvalidProtocolBufferException e10) {
                e10.j();
                throw e10;
            }
        }

        private ByteString L(int i10) throws IOException {
            byte[] O = O(i10);
            if (O != null) {
                return ByteString.q(O);
            }
            int i11 = this.f21842k;
            int i12 = this.f21840i;
            int i13 = i12 - i11;
            this.f21844m += i12;
            this.f21842k = 0;
            this.f21840i = 0;
            List<byte[]> P = P(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f21839h, i11, bArr, 0, i13);
            for (byte[] next : P) {
                System.arraycopy(next, 0, bArr, i13, next.length);
                i13 += next.length;
            }
            return ByteString.W(bArr);
        }

        private byte[] N(int i10, boolean z10) throws IOException {
            byte[] O = O(i10);
            if (O == null) {
                int i11 = this.f21842k;
                int i12 = this.f21840i;
                int i13 = i12 - i11;
                this.f21844m += i12;
                this.f21842k = 0;
                this.f21840i = 0;
                List<byte[]> P = P(i10 - i13);
                byte[] bArr = new byte[i10];
                System.arraycopy(this.f21839h, i11, bArr, 0, i13);
                for (byte[] next : P) {
                    System.arraycopy(next, 0, bArr, i13, next.length);
                    i13 += next.length;
                }
                return bArr;
            } else if (z10) {
                return (byte[]) O.clone();
            } else {
                return O;
            }
        }

        private byte[] O(int i10) throws IOException {
            if (i10 == 0) {
                return w.f21955d;
            }
            if (i10 >= 0) {
                int i11 = this.f21844m;
                int i12 = this.f21842k;
                int i13 = i11 + i12 + i10;
                if (i13 - this.f21811c <= 0) {
                    int i14 = this.f21845n;
                    if (i13 <= i14) {
                        int i15 = this.f21840i - i12;
                        int i16 = i10 - i15;
                        if (i16 >= 4096 && i16 > J(this.f21838g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i10];
                        System.arraycopy(this.f21839h, this.f21842k, bArr, 0, i15);
                        this.f21844m += this.f21840i;
                        this.f21842k = 0;
                        this.f21840i = 0;
                        while (i15 < i10) {
                            int K = K(this.f21838g, bArr, i15, i10 - i15);
                            if (K != -1) {
                                this.f21844m += K;
                                i15 += K;
                            } else {
                                throw InvalidProtocolBufferException.m();
                            }
                        }
                        return bArr;
                    }
                    Z((i14 - i11) - i12);
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.g();
        }

        private List<byte[]> P(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, Opcodes.ACC_SYNTHETIC);
                byte[] bArr = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    int read = this.f21838g.read(bArr, i11, min - i11);
                    if (read != -1) {
                        this.f21844m += read;
                        i11 += read;
                    } else {
                        throw InvalidProtocolBufferException.m();
                    }
                }
                i10 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void V() {
            int i10 = this.f21840i + this.f21841j;
            this.f21840i = i10;
            int i11 = this.f21844m + i10;
            int i12 = this.f21845n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f21841j = i13;
                this.f21840i = i10 - i13;
                return;
            }
            this.f21841j = 0;
        }

        private void W(int i10) throws IOException {
            if (e0(i10)) {
                return;
            }
            if (i10 > (this.f21811c - this.f21844m) - this.f21842k) {
                throw InvalidProtocolBufferException.l();
            }
            throw InvalidProtocolBufferException.m();
        }

        private static long X(InputStream inputStream, long j10) throws IOException {
            try {
                return inputStream.skip(j10);
            } catch (InvalidProtocolBufferException e10) {
                e10.j();
                throw e10;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f21838g.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a0(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.f21844m
                int r1 = r8.f21842k
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.f21845n
                if (r2 > r3) goto L_0x008d
                com.google.protobuf.h$d$a r2 = r8.f21846o
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.f21844m = r0
                int r0 = r8.f21840i
                int r0 = r0 - r1
                r8.f21840i = r3
                r8.f21842k = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f21838g     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = X(r1, r4)     // Catch:{ all -> 0x005d }
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
                java.io.InputStream r4 = r8.f21838g     // Catch:{ all -> 0x005d }
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
                int r0 = r8.f21844m
                int r0 = r0 + r3
                r8.f21844m = r0
                r8.V()
                throw r9
            L_0x0067:
                int r0 = r8.f21844m
                int r0 = r0 + r3
                r8.f21844m = r0
                r8.V()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.f21840i
                int r1 = r8.f21842k
                int r1 = r0 - r1
                r8.f21842k = r0
                r0 = 1
                r8.W(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.f21840i
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.f21842k = r3
                r8.W(r0)
                goto L_0x007d
            L_0x008a:
                r8.f21842k = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.Z(r3)
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.m()
                throw r9
            L_0x0097:
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.g()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.d.a0(int):void");
        }

        private void b0() throws IOException {
            if (this.f21840i - this.f21842k >= 10) {
                c0();
            } else {
                d0();
            }
        }

        private void c0() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                byte[] bArr = this.f21839h;
                int i11 = this.f21842k;
                this.f21842k = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void d0() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (M() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean e0(int i10) throws IOException {
            int i11 = this.f21842k;
            if (i11 + i10 > this.f21840i) {
                int i12 = this.f21811c;
                int i13 = this.f21844m;
                if (i10 > (i12 - i13) - i11 || i13 + i11 + i10 > this.f21845n) {
                    return false;
                }
                a aVar = this.f21846o;
                if (aVar != null) {
                    aVar.a();
                }
                int i14 = this.f21842k;
                if (i14 > 0) {
                    int i15 = this.f21840i;
                    if (i15 > i14) {
                        byte[] bArr = this.f21839h;
                        System.arraycopy(bArr, i14, bArr, 0, i15 - i14);
                    }
                    this.f21844m += i14;
                    this.f21840i -= i14;
                    this.f21842k = 0;
                }
                InputStream inputStream = this.f21838g;
                byte[] bArr2 = this.f21839h;
                int i16 = this.f21840i;
                int K = K(inputStream, bArr2, i16, Math.min(bArr2.length - i16, (this.f21811c - this.f21844m) - i16));
                if (K == 0 || K < -1 || K > this.f21839h.length) {
                    throw new IllegalStateException(this.f21838g.getClass() + "#read(byte[]) returned invalid result: " + K + "\nThe InputStream implementation is buggy.");
                } else if (K <= 0) {
                    return false;
                } else {
                    this.f21840i += K;
                    V();
                    if (this.f21840i >= i10) {
                        return true;
                    }
                    return e0(i10);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
            }
        }

        public long A() throws IOException {
            return R();
        }

        public int B() throws IOException {
            return h.b(S());
        }

        public long C() throws IOException {
            return h.c(T());
        }

        public String D() throws IOException {
            int S = S();
            if (S > 0) {
                int i10 = this.f21840i;
                int i11 = this.f21842k;
                if (S <= i10 - i11) {
                    String str = new String(this.f21839h, i11, S, w.f21953b);
                    this.f21842k += S;
                    return str;
                }
            }
            if (S == 0) {
                return "";
            }
            if (S > this.f21840i) {
                return new String(N(S, false), w.f21953b);
            }
            W(S);
            String str2 = new String(this.f21839h, this.f21842k, S, w.f21953b);
            this.f21842k += S;
            return str2;
        }

        public String E() throws IOException {
            byte[] bArr;
            int S = S();
            int i10 = this.f21842k;
            int i11 = this.f21840i;
            if (S <= i11 - i10 && S > 0) {
                bArr = this.f21839h;
                this.f21842k = i10 + S;
            } else if (S == 0) {
                return "";
            } else {
                if (S <= i11) {
                    W(S);
                    bArr = this.f21839h;
                    this.f21842k = S + 0;
                } else {
                    bArr = N(S, false);
                }
                i10 = 0;
            }
            return Utf8.h(bArr, i10, S);
        }

        public int F() throws IOException {
            if (e()) {
                this.f21843l = 0;
                return 0;
            }
            int S = S();
            this.f21843l = S;
            if (WireFormat.a(S) != 0) {
                return this.f21843l;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int G() throws IOException {
            return S();
        }

        public long H() throws IOException {
            return T();
        }

        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                b0();
                return true;
            } else if (b10 == 1) {
                Z(8);
                return true;
            } else if (b10 == 2) {
                Z(S());
                return true;
            } else if (b10 == 3) {
                Y();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    Z(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public byte M() throws IOException {
            if (this.f21842k == this.f21840i) {
                W(1);
            }
            byte[] bArr = this.f21839h;
            int i10 = this.f21842k;
            this.f21842k = i10 + 1;
            return bArr[i10];
        }

        public int Q() throws IOException {
            int i10 = this.f21842k;
            if (this.f21840i - i10 < 4) {
                W(4);
                i10 = this.f21842k;
            }
            byte[] bArr = this.f21839h;
            this.f21842k = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
        }

        public long R() throws IOException {
            int i10 = this.f21842k;
            if (this.f21840i - i10 < 8) {
                W(8);
                i10 = this.f21842k;
            }
            byte[] bArr = this.f21839h;
            this.f21842k = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int S() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f21842k
                int r1 = r5.f21840i
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f21839h
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f21842k = r3
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
                long r0 = r5.U()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f21842k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.d.S():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long T() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f21842k
                int r1 = r11.f21840i
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f21839h
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f21842k = r3
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
                long r0 = r11.U()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f21842k = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.d.T():long");
        }

        /* access modifiers changed from: package-private */
        public long U() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte M = M();
                j10 |= ((long) (M & Byte.MAX_VALUE)) << i10;
                if ((M & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void Y() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.F()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.I(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.d.Y():void");
        }

        public void Z(int i10) throws IOException {
            int i11 = this.f21840i;
            int i12 = this.f21842k;
            if (i10 > i11 - i12 || i10 < 0) {
                a0(i10);
            } else {
                this.f21842k = i12 + i10;
            }
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f21843l != i10) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public int d() {
            return this.f21844m + this.f21842k;
        }

        public boolean e() throws IOException {
            return this.f21842k == this.f21840i && !e0(1);
        }

        public void n(int i10) {
            this.f21845n = i10;
            V();
        }

        public int o(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int i11 = i10 + this.f21844m + this.f21842k;
                int i12 = this.f21845n;
                if (i11 <= i12) {
                    this.f21845n = i11;
                    V();
                    return i12;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean p() throws IOException {
            return T() != 0;
        }

        public ByteString q() throws IOException {
            int S = S();
            int i10 = this.f21840i;
            int i11 = this.f21842k;
            if (S <= i10 - i11 && S > 0) {
                ByteString r10 = ByteString.r(this.f21839h, i11, S);
                this.f21842k += S;
                return r10;
            } else if (S == 0) {
                return ByteString.f21603a;
            } else {
                return L(S);
            }
        }

        public double r() throws IOException {
            return Double.longBitsToDouble(R());
        }

        public int s() throws IOException {
            return S();
        }

        public int t() throws IOException {
            return Q();
        }

        public long u() throws IOException {
            return R();
        }

        public float v() throws IOException {
            return Float.intBitsToFloat(Q());
        }

        public int w() throws IOException {
            return S();
        }

        public long x() throws IOException {
            return T();
        }

        public int z() throws IOException {
            return Q();
        }

        private d(InputStream inputStream, int i10) {
            super();
            this.f21845n = a.e.API_PRIORITY_OTHER;
            this.f21846o = null;
            w.b(inputStream, "input");
            this.f21838g = inputStream;
            this.f21839h = new byte[i10];
            this.f21840i = 0;
            this.f21842k = 0;
            this.f21844m = 0;
        }
    }

    private static final class e extends h {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f21847g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f21848h;

        /* renamed from: i  reason: collision with root package name */
        private final long f21849i;

        /* renamed from: j  reason: collision with root package name */
        private long f21850j;

        /* renamed from: k  reason: collision with root package name */
        private long f21851k;

        /* renamed from: l  reason: collision with root package name */
        private long f21852l;

        /* renamed from: m  reason: collision with root package name */
        private int f21853m;

        /* renamed from: n  reason: collision with root package name */
        private int f21854n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f21855o;

        /* renamed from: p  reason: collision with root package name */
        private int f21856p;

        private int J(long j10) {
            return (int) (j10 - this.f21849i);
        }

        static boolean K() {
            return j1.J();
        }

        private void R() {
            long j10 = this.f21850j + ((long) this.f21853m);
            this.f21850j = j10;
            int i10 = (int) (j10 - this.f21852l);
            int i11 = this.f21856p;
            if (i10 > i11) {
                int i12 = i10 - i11;
                this.f21853m = i12;
                this.f21850j = j10 - ((long) i12);
                return;
            }
            this.f21853m = 0;
        }

        private int S() {
            return (int) (this.f21850j - this.f21851k);
        }

        private void V() throws IOException {
            if (S() >= 10) {
                W();
            } else {
                X();
            }
        }

        private void W() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                long j10 = this.f21851k;
                this.f21851k = 1 + j10;
                if (j1.w(j10) < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void X() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (L() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer Y(long j10, long j11) throws IOException {
            int position = this.f21847g.position();
            int limit = this.f21847g.limit();
            ByteBuffer byteBuffer = this.f21847g;
            try {
                byteBuffer.position(J(j10));
                byteBuffer.limit(J(j11));
                ByteBuffer slice = this.f21847g.slice();
                byteBuffer.position(position);
                byteBuffer.limit(limit);
                return slice;
            } catch (IllegalArgumentException e10) {
                InvalidProtocolBufferException m10 = InvalidProtocolBufferException.m();
                m10.initCause(e10);
                throw m10;
            } catch (Throwable th2) {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
                throw th2;
            }
        }

        public long A() throws IOException {
            return N();
        }

        public int B() throws IOException {
            return h.b(O());
        }

        public long C() throws IOException {
            return h.c(P());
        }

        public String D() throws IOException {
            int O = O();
            if (O > 0 && O <= S()) {
                byte[] bArr = new byte[O];
                long j10 = (long) O;
                j1.p(this.f21851k, bArr, 0, j10);
                String str = new String(bArr, w.f21953b);
                this.f21851k += j10;
                return str;
            } else if (O == 0) {
                return "";
            } else {
                if (O < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        public String E() throws IOException {
            int O = O();
            if (O > 0 && O <= S()) {
                String g10 = Utf8.g(this.f21847g, J(this.f21851k), O);
                this.f21851k += (long) O;
                return g10;
            } else if (O == 0) {
                return "";
            } else {
                if (O <= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
        }

        public int F() throws IOException {
            if (e()) {
                this.f21854n = 0;
                return 0;
            }
            int O = O();
            this.f21854n = O;
            if (WireFormat.a(O) != 0) {
                return this.f21854n;
            }
            throw InvalidProtocolBufferException.c();
        }

        public int G() throws IOException {
            return O();
        }

        public long H() throws IOException {
            return P();
        }

        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                V();
                return true;
            } else if (b10 == 1) {
                U(8);
                return true;
            } else if (b10 == 2) {
                U(O());
                return true;
            } else if (b10 == 3) {
                T();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    U(4);
                    return true;
                }
                throw InvalidProtocolBufferException.e();
            }
        }

        public byte L() throws IOException {
            long j10 = this.f21851k;
            if (j10 != this.f21850j) {
                this.f21851k = 1 + j10;
                return j1.w(j10);
            }
            throw InvalidProtocolBufferException.m();
        }

        public int M() throws IOException {
            long j10 = this.f21851k;
            if (this.f21850j - j10 >= 4) {
                this.f21851k = 4 + j10;
                return ((j1.w(j10 + 3) & 255) << 24) | (j1.w(j10) & 255) | ((j1.w(1 + j10) & 255) << 8) | ((j1.w(2 + j10) & 255) << Tnaf.POW_2_WIDTH);
            }
            throw InvalidProtocolBufferException.m();
        }

        public long N() throws IOException {
            long j10 = this.f21851k;
            if (this.f21850j - j10 >= 8) {
                this.f21851k = 8 + j10;
                return ((((long) j1.w(j10 + 7)) & 255) << 56) | (((long) j1.w(j10)) & 255) | ((((long) j1.w(1 + j10)) & 255) << 8) | ((((long) j1.w(2 + j10)) & 255) << 16) | ((((long) j1.w(3 + j10)) & 255) << 24) | ((((long) j1.w(4 + j10)) & 255) << 32) | ((((long) j1.w(5 + j10)) & 255) << 40) | ((((long) j1.w(6 + j10)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (com.google.protobuf.j1.w(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int O() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f21851k
                long r2 = r10.f21850j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x0085
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.j1.w(r0)
                if (r0 < 0) goto L_0x0017
                r10.f21851k = r4
                return r0
            L_0x0017:
                long r6 = r10.f21850j
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0021
                goto L_0x0085
            L_0x0021:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002f
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x008b
            L_0x002f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003c:
                r6 = r4
                goto L_0x008b
            L_0x003e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x008b
            L_0x004e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.j1.w(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.j1.w(r4)
                if (r1 >= 0) goto L_0x008b
            L_0x0085:
                long r0 = r10.Q()
                int r0 = (int) r0
                return r0
            L_0x008b:
                r10.f21851k = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.e.O():int");
        }

        public long P() throws IOException {
            long j10;
            long j11;
            long j12;
            byte b10;
            long j13 = this.f21851k;
            if (this.f21850j != j13) {
                long j14 = j13 + 1;
                byte w10 = j1.w(j13);
                if (w10 >= 0) {
                    this.f21851k = j14;
                    return (long) w10;
                } else if (this.f21850j - j14 >= 9) {
                    long j15 = j14 + 1;
                    byte w11 = w10 ^ (j1.w(j14) << 7);
                    if (w11 < 0) {
                        b10 = w11 ^ Byte.MIN_VALUE;
                    } else {
                        long j16 = j15 + 1;
                        byte w12 = w11 ^ (j1.w(j15) << 14);
                        if (w12 >= 0) {
                            j10 = (long) (w12 ^ 16256);
                        } else {
                            j15 = j16 + 1;
                            byte w13 = w12 ^ (j1.w(j16) << 21);
                            if (w13 < 0) {
                                b10 = w13 ^ -2080896;
                            } else {
                                j16 = j15 + 1;
                                long w14 = ((long) w13) ^ (((long) j1.w(j15)) << 28);
                                if (w14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    long j17 = j16 + 1;
                                    long w15 = w14 ^ (((long) j1.w(j16)) << 35);
                                    if (w15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        j16 = j17 + 1;
                                        w14 = w15 ^ (((long) j1.w(j17)) << 42);
                                        if (w14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            j17 = j16 + 1;
                                            w15 = w14 ^ (((long) j1.w(j16)) << 49);
                                            if (w15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                j16 = j17 + 1;
                                                j10 = (w15 ^ (((long) j1.w(j17)) << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    long j18 = 1 + j16;
                                                    if (((long) j1.w(j16)) >= 0) {
                                                        j15 = j18;
                                                        this.f21851k = j15;
                                                        return j10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j10 = w15 ^ j11;
                                    j15 = j17;
                                    this.f21851k = j15;
                                    return j10;
                                }
                                j10 = w14 ^ j12;
                            }
                        }
                        j15 = j16;
                        this.f21851k = j15;
                        return j10;
                    }
                    j10 = (long) b10;
                    this.f21851k = j15;
                    return j10;
                }
            }
            return Q();
        }

        /* access modifiers changed from: package-private */
        public long Q() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte L = L();
                j10 |= ((long) (L & Byte.MAX_VALUE)) << i10;
                if ((L & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void T() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.F()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.I(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h.e.T():void");
        }

        public void U(int i10) throws IOException {
            if (i10 >= 0 && i10 <= S()) {
                this.f21851k += (long) i10;
            } else if (i10 < 0) {
                throw InvalidProtocolBufferException.g();
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }

        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f21854n != i10) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public int d() {
            return (int) (this.f21851k - this.f21852l);
        }

        public boolean e() throws IOException {
            return this.f21851k == this.f21850j;
        }

        public void n(int i10) {
            this.f21856p = i10;
            R();
        }

        public int o(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int d10 = i10 + d();
                int i11 = this.f21856p;
                if (d10 <= i11) {
                    this.f21856p = d10;
                    R();
                    return i11;
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        public boolean p() throws IOException {
            return P() != 0;
        }

        public ByteString q() throws IOException {
            int O = O();
            if (O <= 0 || O > S()) {
                if (O == 0) {
                    return ByteString.f21603a;
                }
                if (O < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            } else if (!this.f21848h || !this.f21855o) {
                byte[] bArr = new byte[O];
                long j10 = (long) O;
                j1.p(this.f21851k, bArr, 0, j10);
                this.f21851k += j10;
                return ByteString.W(bArr);
            } else {
                long j11 = this.f21851k;
                long j12 = (long) O;
                ByteBuffer Y = Y(j11, j11 + j12);
                this.f21851k += j12;
                return ByteString.V(Y);
            }
        }

        public double r() throws IOException {
            return Double.longBitsToDouble(N());
        }

        public int s() throws IOException {
            return O();
        }

        public int t() throws IOException {
            return M();
        }

        public long u() throws IOException {
            return N();
        }

        public float v() throws IOException {
            return Float.intBitsToFloat(M());
        }

        public int w() throws IOException {
            return O();
        }

        public long x() throws IOException {
            return P();
        }

        public int z() throws IOException {
            return M();
        }

        private e(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f21856p = a.e.API_PRIORITY_OTHER;
            this.f21847g = byteBuffer;
            long k10 = j1.k(byteBuffer);
            this.f21849i = k10;
            this.f21850j = ((long) byteBuffer.limit()) + k10;
            long position = k10 + ((long) byteBuffer.position());
            this.f21851k = position;
            this.f21852l = position;
            this.f21848h = z10;
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
            return k(w.f21955d);
        } else {
            return new d(inputStream, i10);
        }
    }

    static h h(Iterable<ByteBuffer> iterable, boolean z10) {
        boolean z11 = false;
        int i10 = 0;
        for (ByteBuffer next : iterable) {
            i10 += next.remaining();
            if (next.hasArray()) {
                z11 |= true;
            } else if (next.isDirect()) {
                z11 |= true;
            } else {
                z11 |= true;
            }
        }
        if (z11) {
            return new c(iterable, i10, z10);
        }
        return f(new x(iterable));
    }

    public static h i(ByteBuffer byteBuffer) {
        return j(byteBuffer, false);
    }

    static h j(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z10);
        }
        if (byteBuffer.isDirect() && e.K()) {
            return new e(byteBuffer, z10);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, remaining, true);
    }

    public static h k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static h l(byte[] bArr, int i10, int i11) {
        return m(bArr, i10, i11, false);
    }

    static h m(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.o(i11);
            return bVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int y(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & Opcodes.LAND;
        int i12 = 7;
        while (i12 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i11 |= (read & Opcodes.LAND) << i12;
                if ((read & 128) == 0) {
                    return i11;
                }
                i12 += 7;
            } else {
                throw InvalidProtocolBufferException.m();
            }
        }
        while (i12 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.m();
            } else if ((read2 & 128) == 0) {
                return i11;
            } else {
                i12 += 7;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public abstract long A() throws IOException;

    public abstract int B() throws IOException;

    public abstract long C() throws IOException;

    public abstract String D() throws IOException;

    public abstract String E() throws IOException;

    public abstract int F() throws IOException;

    public abstract int G() throws IOException;

    public abstract long H() throws IOException;

    public abstract boolean I(int i10) throws IOException;

    public abstract void a(int i10) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void n(int i10);

    public abstract int o(int i10) throws InvalidProtocolBufferException;

    public abstract boolean p() throws IOException;

    public abstract ByteString q() throws IOException;

    public abstract double r() throws IOException;

    public abstract int s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract float v() throws IOException;

    public abstract int w() throws IOException;

    public abstract long x() throws IOException;

    public abstract int z() throws IOException;

    private h() {
        this.f21810b = f21808f;
        this.f21811c = a.e.API_PRIORITY_OTHER;
        this.f21813e = false;
    }
}
