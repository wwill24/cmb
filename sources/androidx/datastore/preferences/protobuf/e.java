package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

abstract class e implements x0 {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5237a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5237a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f5237a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.e.a.<clinit>():void");
        }
    }

    private static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5238a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f5239b;

        /* renamed from: c  reason: collision with root package name */
        private int f5240c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5241d;

        /* renamed from: e  reason: collision with root package name */
        private int f5242e;

        /* renamed from: f  reason: collision with root package name */
        private int f5243f;

        /* renamed from: g  reason: collision with root package name */
        private int f5244g;

        public b(ByteBuffer byteBuffer, boolean z10) {
            super((a) null);
            this.f5238a = z10;
            this.f5239b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f5240c = arrayOffset;
            this.f5241d = arrayOffset;
            this.f5242e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            return this.f5240c == this.f5242e;
        }

        private byte S() throws IOException {
            int i10 = this.f5240c;
            if (i10 != this.f5242e) {
                byte[] bArr = this.f5239b;
                this.f5240c = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.k();
        }

        private Object T(WireFormat.FieldType fieldType, Class<?> cls, n nVar) throws IOException {
            switch (a.f5237a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(e());
                case 2:
                    return o();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(k());
                case 5:
                    return Integer.valueOf(u());
                case 6:
                    return Long.valueOf(b());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(p());
                case 9:
                    return Long.valueOf(H());
                case 10:
                    return M(cls, nVar);
                case 11:
                    return Integer.valueOf(E());
                case 12:
                    return Long.valueOf(f());
                case 13:
                    return Integer.valueOf(l());
                case 14:
                    return Long.valueOf(y());
                case 15:
                    return I();
                case 16:
                    return Integer.valueOf(h());
                case 17:
                    return Long.valueOf(s());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T U(y0<T> y0Var, n nVar) throws IOException {
            int i10 = this.f5244g;
            this.f5244g = WireFormat.c(WireFormat.a(this.f5243f), 4);
            try {
                T newInstance = y0Var.newInstance();
                y0Var.e(newInstance, this, nVar);
                y0Var.b(newInstance);
                if (this.f5243f == this.f5244g) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f5244g = i10;
            }
        }

        private int V() throws IOException {
            f0(4);
            return W();
        }

        private int W() {
            int i10 = this.f5240c;
            byte[] bArr = this.f5239b;
            this.f5240c = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
        }

        private long X() throws IOException {
            f0(8);
            return Y();
        }

        private long Y() {
            int i10 = this.f5240c;
            byte[] bArr = this.f5239b;
            this.f5240c = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        private <T> T Z(y0<T> y0Var, n nVar) throws IOException {
            int c02 = c0();
            f0(c02);
            int i10 = this.f5242e;
            int i11 = this.f5240c + c02;
            this.f5242e = i11;
            try {
                T newInstance = y0Var.newInstance();
                y0Var.e(newInstance, this, nVar);
                y0Var.b(newInstance);
                if (this.f5240c == i11) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f5242e = i10;
            }
        }

        private int c0() throws IOException {
            byte b10;
            int i10 = this.f5240c;
            int i11 = this.f5242e;
            if (i11 != i10) {
                byte[] bArr = this.f5239b;
                int i12 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 >= 0) {
                    this.f5240c = i12;
                    return b11;
                } else if (i11 - i12 < 9) {
                    return (int) e0();
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
                    this.f5240c = i13;
                    return b10;
                }
            } else {
                throw InvalidProtocolBufferException.k();
            }
        }

        private long e0() throws IOException {
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

        private void f0(int i10) throws IOException {
            if (i10 < 0 || i10 > this.f5242e - this.f5240c) {
                throw InvalidProtocolBufferException.k();
            }
        }

        private void g0(int i10) throws IOException {
            if (this.f5240c != i10) {
                throw InvalidProtocolBufferException.k();
            }
        }

        private void h0(int i10) throws IOException {
            if (WireFormat.b(this.f5243f) != i10) {
                throw InvalidProtocolBufferException.d();
            }
        }

        private void i0(int i10) throws IOException {
            f0(i10);
            this.f5240c += i10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void j0() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.f5244g
                int r1 = r3.f5243f
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.a(r1)
                r2 = 4
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.c(r1, r2)
                r3.f5244g = r1
            L_0x000f:
                int r1 = r3.A()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.D()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f5243f
                int r2 = r3.f5244g
                if (r1 != r2) goto L_0x0027
                r3.f5244g = r0
                return
            L_0x0027:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.e.b.j0():void");
        }

        private void k0() throws IOException {
            int i10 = this.f5242e;
            int i11 = this.f5240c;
            if (i10 - i11 >= 10) {
                byte[] bArr = this.f5239b;
                int i12 = 0;
                while (i12 < 10) {
                    int i13 = i11 + 1;
                    if (bArr[i11] >= 0) {
                        this.f5240c = i13;
                        return;
                    } else {
                        i12++;
                        i11 = i13;
                    }
                }
            }
            l0();
        }

        private void l0() throws IOException {
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

        private void m0(int i10) throws IOException {
            f0(i10);
            if ((i10 & 3) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void n0(int i10) throws IOException {
            f0(i10);
            if ((i10 & 7) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        public int A() throws IOException {
            if (R()) {
                return a.e.API_PRIORITY_OTHER;
            }
            int c02 = c0();
            this.f5243f = c02;
            if (c02 == this.f5244g) {
                return a.e.API_PRIORITY_OTHER;
            }
            return WireFormat.a(c02);
        }

        public void B(List<String> list) throws IOException {
            b0(list, false);
        }

        public void C(List<Float> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof t) {
                t tVar = (t) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 2) {
                    int c02 = c0();
                    m0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        tVar.g(Float.intBitsToFloat(W()));
                    }
                } else if (b10 == 5) {
                    do {
                        tVar.g(readFloat());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 2) {
                    int c03 = c0();
                    m0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Float.valueOf(Float.intBitsToFloat(W())));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public boolean D() throws IOException {
            int i10;
            if (R() || (i10 = this.f5243f) == this.f5244g) {
                return false;
            }
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                k0();
                return true;
            } else if (b10 == 1) {
                i0(8);
                return true;
            } else if (b10 == 2) {
                i0(c0());
                return true;
            } else if (b10 == 3) {
                j0();
                return true;
            } else if (b10 == 5) {
                i0(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }

        public int E() throws IOException {
            h0(5);
            return V();
        }

        public void F(List<ByteString> list) throws IOException {
            int i10;
            if (WireFormat.b(this.f5243f) == 2) {
                do {
                    list.add(o());
                    if (!R()) {
                        i10 = this.f5240c;
                    } else {
                        return;
                    }
                } while (c0() == this.f5243f);
                this.f5240c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public void G(List<Double> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof k) {
                k kVar = (k) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 1) {
                    do {
                        kVar.g(readDouble());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = c0();
                    n0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        kVar.g(Double.longBitsToDouble(Y()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Double.valueOf(Double.longBitsToDouble(Y())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long H() throws IOException {
            h0(0);
            return d0();
        }

        public String I() throws IOException {
            return a0(true);
        }

        public <T> T J(y0<T> y0Var, n nVar) throws IOException {
            h0(2);
            return Z(y0Var, nVar);
        }

        public <T> void K(List<T> list, y0<T> y0Var, n nVar) throws IOException {
            int i10;
            if (WireFormat.b(this.f5243f) == 2) {
                int i11 = this.f5243f;
                do {
                    list.add(Z(y0Var, nVar));
                    if (!R()) {
                        i10 = this.f5240c;
                    } else {
                        return;
                    }
                } while (c0() == i11);
                this.f5240c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public <T> T L(y0<T> y0Var, n nVar) throws IOException {
            h0(3);
            return U(y0Var, nVar);
        }

        public <T> T M(Class<T> cls, n nVar) throws IOException {
            h0(2);
            return Z(u0.a().d(cls), nVar);
        }

        public <T> T N(Class<T> cls, n nVar) throws IOException {
            h0(3);
            return U(u0.a().d(cls), nVar);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(2:22|35)(3:30|23|24)) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (D() != false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void O(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.e0.a<K, V> r9, androidx.datastore.preferences.protobuf.n r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.h0(r0)
                int r1 = r7.c0()
                r7.f0(r1)
                int r2 = r7.f5242e
                int r3 = r7.f5240c
                int r3 = r3 + r1
                r7.f5242e = r3
                K r1 = r9.f5249b     // Catch:{ all -> 0x005b }
                V r3 = r9.f5251d     // Catch:{ all -> 0x005b }
            L_0x0016:
                int r4 = r7.A()     // Catch:{ all -> 0x005b }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0025
                r8.put(r1, r3)     // Catch:{ all -> 0x005b }
                r7.f5242e = r2
                return
            L_0x0025:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0046
                if (r4 == r0) goto L_0x0039
                boolean r4 = r7.D()     // Catch:{ InvalidWireTypeException -> 0x004e }
                if (r4 == 0) goto L_0x0033
                goto L_0x0016
            L_0x0033:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004e }
                r4.<init>(r6)     // Catch:{ InvalidWireTypeException -> 0x004e }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x004e }
            L_0x0039:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f5250c     // Catch:{ InvalidWireTypeException -> 0x004e }
                V r5 = r9.f5251d     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x0046:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f5248a     // Catch:{ InvalidWireTypeException -> 0x004e }
                r5 = 0
                java.lang.Object r1 = r7.T(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x004e:
                boolean r4 = r7.D()     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x0055
                goto L_0x0016
            L_0x0055:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x005b }
                r8.<init>(r6)     // Catch:{ all -> 0x005b }
                throw r8     // Catch:{ all -> 0x005b }
            L_0x005b:
                r8 = move-exception
                r7.f5242e = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.e.b.O(java.util.Map, androidx.datastore.preferences.protobuf.e0$a, androidx.datastore.preferences.protobuf.n):void");
        }

        public <T> void P(List<T> list, y0<T> y0Var, n nVar) throws IOException {
            int i10;
            if (WireFormat.b(this.f5243f) == 3) {
                int i11 = this.f5243f;
                do {
                    list.add(U(y0Var, nVar));
                    if (!R()) {
                        i10 = this.f5240c;
                    } else {
                        return;
                    }
                } while (c0() == i11);
                this.f5240c = i10;
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        public int a() {
            return this.f5243f;
        }

        public String a0(boolean z10) throws IOException {
            h0(2);
            int c02 = c0();
            if (c02 == 0) {
                return "";
            }
            f0(c02);
            if (z10) {
                byte[] bArr = this.f5239b;
                int i10 = this.f5240c;
                if (!Utf8.n(bArr, i10, i10 + c02)) {
                    throw InvalidProtocolBufferException.c();
                }
            }
            String str = new String(this.f5239b, this.f5240c, c02, w.f5382a);
            this.f5240c += c02;
            return str;
        }

        public long b() throws IOException {
            h0(1);
            return X();
        }

        public void b0(List<String> list, boolean z10) throws IOException {
            int i10;
            int i11;
            if (WireFormat.b(this.f5243f) != 2) {
                throw InvalidProtocolBufferException.d();
            } else if (!(list instanceof a0) || z10) {
                do {
                    list.add(a0(z10));
                    if (!R()) {
                        i10 = this.f5240c;
                    } else {
                        return;
                    }
                } while (c0() == this.f5243f);
                this.f5240c = i10;
            } else {
                a0 a0Var = (a0) list;
                do {
                    a0Var.b1(o());
                    if (!R()) {
                        i11 = this.f5240c;
                    } else {
                        return;
                    }
                } while (c0() == this.f5243f);
                this.f5240c = i11;
            }
        }

        public void c(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 2) {
                    int c02 = c0();
                    m0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        vVar.U0(W());
                    }
                } else if (b10 == 5) {
                    do {
                        vVar.U0(E());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 2) {
                    int c03 = c0();
                    m0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Integer.valueOf(W()));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void d(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof c0) {
                c0 c0Var = (c0) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        c0Var.i(y());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        c0Var.i(h.c(d0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(y()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Long.valueOf(h.c(d0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long d0() throws IOException {
            long j10;
            int i10;
            long j11;
            long j12;
            byte b10;
            int i11 = this.f5240c;
            int i12 = this.f5242e;
            if (i12 != i11) {
                byte[] bArr = this.f5239b;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f5240c = i13;
                    return (long) b11;
                } else if (i12 - i13 < 9) {
                    return e0();
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
                        this.f5240c = i10;
                        return j10;
                    }
                    j10 = (long) b10;
                    this.f5240c = i10;
                    return j10;
                }
            } else {
                throw InvalidProtocolBufferException.k();
            }
        }

        public boolean e() throws IOException {
            h0(0);
            if (c0() != 0) {
                return true;
            }
            return false;
        }

        public long f() throws IOException {
            h0(1);
            return X();
        }

        public void g(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof c0) {
                c0 c0Var = (c0) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        c0Var.i(s());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        c0Var.i(d0());
                    }
                    g0(c02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(s()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int h() throws IOException {
            h0(0);
            return c0();
        }

        public void i(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof c0) {
                c0 c0Var = (c0) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        c0Var.i(H());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        c0Var.i(d0());
                    }
                    g0(c02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Long.valueOf(H()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void j(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        vVar.U0(k());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        vVar.U0(c0());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(k()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int k() throws IOException {
            h0(0);
            return c0();
        }

        public int l() throws IOException {
            h0(0);
            return h.b(c0());
        }

        public void m(List<Boolean> list) throws IOException {
            int i10;
            boolean z10;
            int i11;
            boolean z11;
            if (list instanceof f) {
                f fVar = (f) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        fVar.i(e());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        if (c0() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        fVar.i(z11);
                    }
                    g0(c02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Boolean.valueOf(e()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        if (c0() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        list.add(Boolean.valueOf(z10));
                    }
                    g0(c03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void n(List<String> list) throws IOException {
            b0(list, true);
        }

        public ByteString o() throws IOException {
            ByteString byteString;
            h0(2);
            int c02 = c0();
            if (c02 == 0) {
                return ByteString.f5064a;
            }
            f0(c02);
            if (this.f5238a) {
                byteString = ByteString.H(this.f5239b, this.f5240c, c02);
            } else {
                byteString = ByteString.j(this.f5239b, this.f5240c, c02);
            }
            this.f5240c += c02;
            return byteString;
        }

        public int p() throws IOException {
            h0(0);
            return c0();
        }

        public void q(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof c0) {
                c0 c0Var = (c0) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 1) {
                    do {
                        c0Var.i(b());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = c0();
                    n0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        c0Var.i(Y());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 1) {
                    do {
                        list.add(Long.valueOf(b()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Long.valueOf(Y()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void r(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        vVar.U0(l());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        vVar.U0(h.b(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(l()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Integer.valueOf(h.b(c0())));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public double readDouble() throws IOException {
            h0(1);
            return Double.longBitsToDouble(X());
        }

        public float readFloat() throws IOException {
            h0(5);
            return Float.intBitsToFloat(V());
        }

        public long s() throws IOException {
            h0(0);
            return d0();
        }

        public void t(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        vVar.U0(h());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        vVar.U0(c0());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(h()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public int u() throws IOException {
            h0(5);
            return V();
        }

        public void v(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof c0) {
                c0 c0Var = (c0) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 1) {
                    do {
                        c0Var.i(f());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = c0();
                    n0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        c0Var.i(Y());
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 1) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = c0();
                    n0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Long.valueOf(Y()));
                    }
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void w(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 0) {
                    do {
                        vVar.U0(p());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else if (b10 == 2) {
                    int c02 = this.f5240c + c0();
                    while (this.f5240c < c02) {
                        vVar.U0(c0());
                    }
                    g0(c02);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 0) {
                    do {
                        list.add(Integer.valueOf(p()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else if (b11 == 2) {
                    int c03 = this.f5240c + c0();
                    while (this.f5240c < c03) {
                        list.add(Integer.valueOf(c0()));
                    }
                    g0(c03);
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public void x(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (list instanceof v) {
                v vVar = (v) list;
                int b10 = WireFormat.b(this.f5243f);
                if (b10 == 2) {
                    int c02 = c0();
                    m0(c02);
                    int i12 = this.f5240c + c02;
                    while (this.f5240c < i12) {
                        vVar.U0(W());
                    }
                } else if (b10 == 5) {
                    do {
                        vVar.U0(u());
                        if (!R()) {
                            i11 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i11;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            } else {
                int b11 = WireFormat.b(this.f5243f);
                if (b11 == 2) {
                    int c03 = c0();
                    m0(c03);
                    int i13 = this.f5240c + c03;
                    while (this.f5240c < i13) {
                        list.add(Integer.valueOf(W()));
                    }
                } else if (b11 == 5) {
                    do {
                        list.add(Integer.valueOf(u()));
                        if (!R()) {
                            i10 = this.f5240c;
                        } else {
                            return;
                        }
                    } while (c0() == this.f5243f);
                    this.f5240c = i10;
                } else {
                    throw InvalidProtocolBufferException.d();
                }
            }
        }

        public long y() throws IOException {
            h0(0);
            return h.c(d0());
        }

        public String z() throws IOException {
            return a0(false);
        }
    }

    private e() {
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public static e Q(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z10);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
