package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.f0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

abstract class f implements y0 {

    private static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f20791a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f20792b;

        /* renamed from: c  reason: collision with root package name */
        private int f20793c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20794d;

        /* renamed from: e  reason: collision with root package name */
        private int f20795e;

        /* renamed from: f  reason: collision with root package name */
        private int f20796f;

        /* renamed from: g  reason: collision with root package name */
        private int f20797g;

        public b(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f20791a = z10;
            this.f20792b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f20793c = arrayOffset;
            this.f20794d = arrayOffset;
            this.f20795e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            return this.f20793c == this.f20795e;
        }

        private byte S() throws IOException {
            int i10 = this.f20793c;
            if (i10 != this.f20795e) {
                byte[] bArr = this.f20792b;
                this.f20793c = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.j();
        }

        private <T> T T(z0<T> z0Var, o oVar) throws IOException {
            int i10 = this.f20797g;
            this.f20797g = WireFormat.c(WireFormat.a(this.f20796f), 4);
            try {
                T newInstance = z0Var.newInstance();
                z0Var.f(newInstance, this, oVar);
                z0Var.b(newInstance);
                if (this.f20796f == this.f20797g) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f20797g = i10;
            }
        }

        private int U() throws IOException {
            e0(4);
            return V();
        }

        private int V() {
            int i10 = this.f20793c;
            byte[] bArr = this.f20792b;
            this.f20793c = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
        }

        private long W() throws IOException {
            e0(8);
            return X();
        }

        private long X() {
            int i10 = this.f20793c;
            byte[] bArr = this.f20792b;
            this.f20793c = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        private <T> T Y(z0<T> z0Var, o oVar) throws IOException {
            int b02 = b0();
            e0(b02);
            int i10 = this.f20795e;
            int i11 = this.f20793c + b02;
            this.f20795e = i11;
            try {
                T newInstance = z0Var.newInstance();
                z0Var.f(newInstance, this, oVar);
                z0Var.b(newInstance);
                if (this.f20793c == i11) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f20795e = i10;
            }
        }

        private int b0() throws IOException {
            byte b10;
            int i10 = this.f20793c;
            int i11 = this.f20795e;
            if (i11 != i10) {
                byte[] bArr = this.f20792b;
                int i12 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 >= 0) {
                    this.f20793c = i12;
                    return b11;
                } else if (i11 - i12 < 9) {
                    return (int) d0();
                } else {
                    int i13 = i12 + 1;
                    byte b12 = b11 ^ (bArr[i12] << 7);
                    if (b12 < 0) {
                        b10 = b12 ^ Byte.MIN_VALUE;
                    } else {
                        int i14 = i13 + 1;
                        byte b13 = b12 ^ (bArr[i13] << 14);
                        if (b13 >= 0) {
                            b10 = b13 ^ 16256;
                        } else {
                            i13 = i14 + 1;
                            byte b14 = b13 ^ (bArr[i14] << 21);
                            if (b14 < 0) {
                                b10 = b14 ^ -2080896;
                            } else {
                                i14 = i13 + 1;
                                byte b15 = bArr[i13];
                                b10 = (b14 ^ (b15 << 28)) ^ 266354560;
                                if (b15 < 0) {
                                    i13 = i14 + 1;
                                    if (bArr[i14] < 0) {
                                        i14 = i13 + 1;
                                        if (bArr[i13] < 0) {
                                            i13 = i14 + 1;
                                            if (bArr[i14] < 0) {
                                                i14 = i13 + 1;
                                                if (bArr[i13] < 0) {
                                                    i13 = i14 + 1;
                                                    if (bArr[i14] < 0) {
                                                        throw InvalidProtocolBufferException.e();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i13 = i14;
                    }
                    this.f20793c = i13;
                    return b10;
                }
            } else {
                throw InvalidProtocolBufferException.j();
            }
        }

        private long d0() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte S = S();
                j10 |= ((long) (S & Byte.MAX_VALUE)) << i10;
                if ((S & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void e0(int i10) throws IOException {
            if (i10 < 0 || i10 > this.f20795e - this.f20793c) {
                throw InvalidProtocolBufferException.j();
            }
        }

        private void f0(int i10) throws IOException {
            if (this.f20793c != i10) {
                throw InvalidProtocolBufferException.j();
            }
        }

        private void g0(int i10) throws IOException {
            if (WireFormat.b(this.f20796f) != i10) {
                throw InvalidProtocolBufferException.d();
            }
        }

        private void h0(int i10) throws IOException {
            e0(i10);
            this.f20793c += i10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void i0() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.f20797g
                int r1 = r3.f20796f
                int r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.a(r1)
                r2 = 4
                int r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.c(r1, r2)
                r3.f20797g = r1
            L_0x000f:
                int r1 = r3.A()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.D()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f20796f
                int r2 = r3.f20797g
                if (r1 != r2) goto L_0x0027
                r3.f20797g = r0
                return
            L_0x0027:
                com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.f.b.i0():void");
        }

        private void j0() throws IOException {
            int i10 = this.f20795e;
            int i11 = this.f20793c;
            if (i10 - i11 >= 10) {
                byte[] bArr = this.f20792b;
                int i12 = 0;
                while (i12 < 10) {
                    int i13 = i11 + 1;
                    if (bArr[i11] >= 0) {
                        this.f20793c = i13;
                        return;
                    } else {
                        i12++;
                        i11 = i13;
                    }
                }
            }
            k0();
        }

        private void k0() throws IOException {
            int i10 = 0;
            while (i10 < 10) {
                if (S() < 0) {
                    i10++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void l0(int i10) throws IOException {
            e0(i10);
            if ((i10 & 3) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void m0(int i10) throws IOException {
            e0(i10);
            if ((i10 & 7) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int A() throws IOException {
            if (R()) {
                return a.e.API_PRIORITY_OTHER;
            }
            int b02 = b0();
            this.f20796f = b02;
            if (b02 == this.f20797g) {
                return a.e.API_PRIORITY_OTHER;
            }
            return WireFormat.a(b02);
        }

        public void B(List<String> list) throws IOException {
            a0(list, false);
        }

        public void C(List<Float> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof u) {
                u uVar = (u) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        uVar.g(Float.intBitsToFloat(V()));
                    }
                } else if (b10 == 5) {
                    do {
                        uVar.g(readFloat());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public boolean D() throws IOException {
            int i10;
            if (R() || (i10 = this.f20796f) == this.f20797g) {
                return false;
            }
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                j0();
                return true;
            } else if (b10 == 1) {
                h0(8);
                return true;
            } else if (b10 == 2) {
                h0(b0());
                return true;
            } else if (b10 == 3) {
                i0();
                return true;
            } else if (b10 == 5) {
                h0(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }

        public int E() throws IOException {
            g0(5);
            return U();
        }

        public void F(List<ByteString> list) throws IOException {
            int i10;
            if (WireFormat.b(this.f20796f) == 2) {
                do {
                    list.add(o());
                    if (!R()) {
                        i10 = this.f20793c;
                    } else {
                        return;
                    }
                } while (b0() == this.f20796f);
                this.f20793c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public void G(List<Double> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof l) {
                l lVar = (l) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 1) {
                    do {
                        lVar.g(readDouble());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        lVar.g(Double.longBitsToDouble(X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long H() throws IOException {
            g0(0);
            return c0();
        }

        public String I() throws IOException {
            return Z(true);
        }

        public <T> T J(z0<T> z0Var, o oVar) throws IOException {
            g0(3);
            return T(z0Var, oVar);
        }

        public <T> T K(Class<T> cls, o oVar) throws IOException {
            g0(3);
            return T(v0.a().d(cls), oVar);
        }

        public <K, V> void L(Map<K, V> map, f0.a<K, V> aVar, o oVar) throws IOException {
            g0(2);
            int b02 = b0();
            e0(b02);
            int i10 = this.f20795e;
            this.f20795e = this.f20793c + b02;
            try {
                throw null;
            } catch (Throwable th2) {
                this.f20795e = i10;
                throw th2;
            }
        }

        public <T> void M(List<T> list, z0<T> z0Var, o oVar) throws IOException {
            int i10;
            if (WireFormat.b(this.f20796f) == 2) {
                int i11 = this.f20796f;
                do {
                    list.add(Y(z0Var, oVar));
                    if (!R()) {
                        i10 = this.f20793c;
                    } else {
                        return;
                    }
                } while (b0() == i11);
                this.f20793c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public <T> T N(z0<T> z0Var, o oVar) throws IOException {
            g0(2);
            return Y(z0Var, oVar);
        }

        public <T> T O(Class<T> cls, o oVar) throws IOException {
            g0(2);
            return Y(v0.a().d(cls), oVar);
        }

        public <T> void P(List<T> list, z0<T> z0Var, o oVar) throws IOException {
            int i10;
            if (WireFormat.b(this.f20796f) == 3) {
                int i11 = this.f20796f;
                do {
                    list.add(T(z0Var, oVar));
                    if (!R()) {
                        i10 = this.f20793c;
                    } else {
                        return;
                    }
                } while (b0() == i11);
                this.f20793c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public String Z(boolean z10) throws IOException {
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return "";
            }
            e0(b02);
            if (z10) {
                byte[] bArr = this.f20792b;
                int i10 = this.f20793c;
                if (!Utf8.n(bArr, i10, i10 + b02)) {
                    throw InvalidProtocolBufferException.c();
                }
            }
            String str = new String(this.f20792b, this.f20793c, b02, x.f20917a);
            this.f20793c += b02;
            return str;
        }

        public int a() {
            return this.f20796f;
        }

        public void a0(List<String> list, boolean z10) throws IOException {
            int i10;
            int i11;
            if (WireFormat.b(this.f20796f) != 2) {
                throw InvalidProtocolBufferException.d();
            } else if (!(list instanceof b0) || z10) {
                do {
                    list.add(Z(z10));
                    if (!R()) {
                        i10 = this.f20793c;
                    } else {
                        return;
                    }
                } while (b0() == this.f20796f);
                this.f20793c = i10;
            } else {
                b0 b0Var = (b0) list;
                do {
                    b0Var.F1(o());
                    if (!R()) {
                        i11 = this.f20793c;
                    } else {
                        return;
                    }
                } while (b0() == this.f20796f);
                this.f20793c = i11;
            }
        }

        public long b() throws IOException {
            g0(1);
            return W();
        }

        public void c(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        wVar.U0(V());
                    }
                } else if (b10 == 5) {
                    do {
                        wVar.U0(E());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long c0() throws IOException {
            long j10;
            int i10;
            long j11;
            long j12;
            byte b10;
            int i11 = this.f20793c;
            int i12 = this.f20795e;
            if (i12 != i11) {
                byte[] bArr = this.f20792b;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f20793c = i13;
                    return (long) b11;
                } else if (i12 - i13 < 9) {
                    return d0();
                } else {
                    int i14 = i13 + 1;
                    byte b12 = b11 ^ (bArr[i13] << 7);
                    if (b12 < 0) {
                        b10 = b12 ^ Byte.MIN_VALUE;
                    } else {
                        int i15 = i14 + 1;
                        byte b13 = b12 ^ (bArr[i14] << 14);
                        if (b13 >= 0) {
                            i10 = i15;
                            j10 = (long) (b13 ^ 16256);
                        } else {
                            i14 = i15 + 1;
                            byte b14 = b13 ^ (bArr[i15] << 21);
                            if (b14 < 0) {
                                b10 = b14 ^ -2080896;
                            } else {
                                long j13 = (long) b14;
                                int i16 = i14 + 1;
                                long j14 = j13 ^ (((long) bArr[i14]) << 28);
                                if (j14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i17 = i16 + 1;
                                    long j15 = j14 ^ (((long) bArr[i16]) << 35);
                                    if (j15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i16 = i17 + 1;
                                        j14 = j15 ^ (((long) bArr[i17]) << 42);
                                        if (j14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i17 = i16 + 1;
                                            j15 = j14 ^ (((long) bArr[i16]) << 49);
                                            if (j15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                int i18 = i17 + 1;
                                                long j16 = (j15 ^ (((long) bArr[i17]) << 56)) ^ 71499008037633920L;
                                                if (j16 < 0) {
                                                    i10 = i18 + 1;
                                                    if (((long) bArr[i18]) < 0) {
                                                        throw InvalidProtocolBufferException.e();
                                                    }
                                                } else {
                                                    i10 = i18;
                                                }
                                                j10 = j16;
                                            }
                                        }
                                    }
                                    j10 = j15 ^ j11;
                                }
                                j10 = j14 ^ j12;
                                i10 = i16;
                            }
                        }
                        this.f20793c = i10;
                        return j10;
                    }
                    j10 = (long) b10;
                    this.f20793c = i10;
                    return j10;
                }
            } else {
                throw InvalidProtocolBufferException.j();
            }
        }

        public void d(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        d0Var.i(y());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        d0Var.i(i.c(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(y()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Long.valueOf(i.c(c0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public boolean e() throws IOException {
            g0(0);
            if (b0() != 0) {
                return true;
            }
            return false;
        }

        public long f() throws IOException {
            g0(1);
            return W();
        }

        public void g(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        d0Var.i(s());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        d0Var.i(c0());
                    }
                    f0(b02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(s()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int h() throws IOException {
            g0(0);
            return b0();
        }

        public void i(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        d0Var.i(H());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        d0Var.i(c0());
                    }
                    f0(b02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(H()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(b03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void j(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        wVar.U0(k());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        wVar.U0(b0());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(k()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int k() throws IOException {
            g0(0);
            return b0();
        }

        public int l() throws IOException {
            g0(0);
            return i.b(b0());
        }

        public void m(List<Boolean> list) throws IOException {
            int i10;
            boolean z10;
            int i11;
            boolean z11;
            if (list instanceof g) {
                g gVar = (g) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        gVar.i(e());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        if (b0() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        gVar.i(z11);
                    }
                    f0(b02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Boolean.valueOf(e()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        if (b0() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        list.add(Boolean.valueOf(z10));
                    }
                    f0(b03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void n(List<String> list) throws IOException {
            a0(list, true);
        }

        public ByteString o() throws IOException {
            ByteString byteString;
            g0(2);
            int b02 = b0();
            if (b02 == 0) {
                return ByteString.f20615a;
            }
            e0(b02);
            if (this.f20791a) {
                byteString = ByteString.J(this.f20792b, this.f20793c, b02);
            } else {
                byteString = ByteString.j(this.f20792b, this.f20793c, b02);
            }
            this.f20793c += b02;
            return byteString;
        }

        public int p() throws IOException {
            g0(0);
            return b0();
        }

        public void q(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 1) {
                    do {
                        d0Var.i(b());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        d0Var.i(X());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 1) {
                    do {
                        list.add(Long.valueOf(b()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void r(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        wVar.U0(l());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        wVar.U0(i.b(b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(l()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Integer.valueOf(i.b(b0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public double readDouble() throws IOException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        public float readFloat() throws IOException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        public long s() throws IOException {
            g0(0);
            return c0();
        }

        public void t(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        wVar.U0(h());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        wVar.U0(b0());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(h()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int u() throws IOException {
            g0(5);
            return U();
        }

        public void v(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 1) {
                    do {
                        d0Var.i(f());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = b0();
                    m0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        d0Var.i(X());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 1) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = b0();
                    m0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Long.valueOf(X()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void w(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 0) {
                    do {
                        wVar.U0(p());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else if (b10 == 2) {
                    int b02 = this.f20793c + b0();
                    while (this.f20793c < b02) {
                        wVar.U0(b0());
                    }
                    f0(b02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(p()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else if (b11 == 2) {
                    int b03 = this.f20793c + b0();
                    while (this.f20793c < b03) {
                        list.add(Integer.valueOf(b0()));
                    }
                    f0(b03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void x(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof w) {
                w wVar = (w) list;
                int b10 = WireFormat.b(this.f20796f);
                if (b10 == 2) {
                    int b02 = b0();
                    l0(b02);
                    int i12 = this.f20793c + b02;
                    while (this.f20793c < i12) {
                        wVar.U0(V());
                    }
                } else if (b10 == 5) {
                    do {
                        wVar.U0(u());
                        if (!R()) {
                            i11 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f20796f);
                if (b11 == 2) {
                    int b03 = b0();
                    l0(b03);
                    int i13 = this.f20793c + b03;
                    while (this.f20793c < i13) {
                        list.add(Integer.valueOf(V()));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Integer.valueOf(u()));
                        if (!R()) {
                            i10 = this.f20793c;
                        } else {
                            return;
                        }
                    } while (b0() == this.f20796f);
                    this.f20793c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long y() throws IOException {
            g0(0);
            return i.c(c0());
        }

        public String z() throws IOException {
            return Z(false);
        }
    }

    private f() {
    }

    public static f Q(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z10);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
