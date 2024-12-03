package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.x;
import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

final class e {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20782a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20782a = r0
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f20782a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.a.<clinit>():void");
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f20783a;

        /* renamed from: b  reason: collision with root package name */
        public long f20784b;

        /* renamed from: c  reason: collision with root package name */
        public Object f20785c;

        /* renamed from: d  reason: collision with root package name */
        public final o f20786d;

        b(o oVar) {
            oVar.getClass();
            this.f20786d = oVar;
        }
    }

    static int A(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        w wVar = (w) iVar;
        int I = I(bArr, i11, bVar);
        wVar.U0(i.b(bVar.f20783a));
        while (I < i12) {
            int I2 = I(bArr, I, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            I = I(bArr, I2, bVar);
            wVar.U0(i.b(bVar.f20783a));
        }
        return I;
    }

    static int B(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        d0 d0Var = (d0) iVar;
        int L = L(bArr, i11, bVar);
        d0Var.i(i.c(bVar.f20784b));
        while (L < i12) {
            int I = I(bArr, L, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            L = L(bArr, I, bVar);
            d0Var.i(i.c(bVar.f20784b));
        }
        return L;
    }

    static int C(byte[] bArr, int i10, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.f();
        } else if (i11 == 0) {
            bVar.f20785c = "";
            return I;
        } else {
            bVar.f20785c = new String(bArr, I, i11, x.f20917a);
            return I + i11;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    static int D(int r4, byte[] r5, int r6, int r7, com.google.crypto.tink.shaded.protobuf.x.i<?> r8, com.google.crypto.tink.shaded.protobuf.e.b r9) throws com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f20783a
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.crypto.tink.shaded.protobuf.x.f20917a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = I(r5, r6, r9)
            int r2 = r9.f20783a
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f20783a
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.crypto.tink.shaded.protobuf.x.f20917a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r4 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r4 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.D(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.x$i, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (com.google.crypto.tink.shaded.protobuf.Utf8.n(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.crypto.tink.shaded.protobuf.x.f20917a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.c();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int E(int r5, byte[] r6, int r7, int r8, com.google.crypto.tink.shaded.protobuf.x.i<?> r9, com.google.crypto.tink.shaded.protobuf.e.b r10) throws com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f20783a
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = com.google.crypto.tink.shaded.protobuf.Utf8.n(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.crypto.tink.shaded.protobuf.x.f20917a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = I(r6, r7, r10)
            int r2 = r10.f20783a
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f20783a
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = com.google.crypto.tink.shaded.protobuf.Utf8.n(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.crypto.tink.shaded.protobuf.x.f20917a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.c()
            throw r5
        L_0x0054:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.c()
            throw r5
        L_0x005f:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.E(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.x$i, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    static int F(byte[] bArr, int i10, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.f();
        } else if (i11 == 0) {
            bVar.f20785c = "";
            return I;
        } else {
            bVar.f20785c = Utf8.e(bArr, I, i11);
            return I + i11;
        }
    }

    static int G(int i10, byte[] bArr, int i11, int i12, g1 g1Var, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i10) != 0) {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                int L = L(bArr, i11, bVar);
                g1Var.n(i10, Long.valueOf(bVar.f20784b));
                return L;
            } else if (b10 == 1) {
                g1Var.n(i10, Long.valueOf(j(bArr, i11)));
                return i11 + 8;
            } else if (b10 == 2) {
                int I = I(bArr, i11, bVar);
                int i13 = bVar.f20783a;
                if (i13 < 0) {
                    throw InvalidProtocolBufferException.f();
                } else if (i13 <= bArr.length - I) {
                    if (i13 == 0) {
                        g1Var.n(i10, ByteString.f20615a);
                    } else {
                        g1Var.n(i10, ByteString.j(bArr, I, i13));
                    }
                    return I + i13;
                } else {
                    throw InvalidProtocolBufferException.j();
                }
            } else if (b10 == 3) {
                g1 l10 = g1.l();
                int i14 = (i10 & -8) | 4;
                int i15 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int I2 = I(bArr, i11, bVar);
                    int i16 = bVar.f20783a;
                    if (i16 == i14) {
                        i15 = i16;
                        i11 = I2;
                        break;
                    }
                    i15 = i16;
                    i11 = G(i16, bArr, I2, i12, l10, bVar);
                }
                if (i11 > i12 || i15 != i14) {
                    throw InvalidProtocolBufferException.g();
                }
                g1Var.n(i10, l10);
                return i11;
            } else if (b10 == 5) {
                g1Var.n(i10, Integer.valueOf(h(bArr, i11)));
                return i11 + 4;
            } else {
                throw InvalidProtocolBufferException.b();
            }
        } else {
            throw InvalidProtocolBufferException.b();
        }
    }

    static int H(int i10, byte[] bArr, int i11, b bVar) {
        int i12 = i10 & Opcodes.LAND;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            bVar.f20783a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            bVar.f20783a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            bVar.f20783a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            bVar.f20783a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                bVar.f20783a = i20;
                return i21;
            }
        }
    }

    static int I(byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return H(b10, bArr, i11, bVar);
        }
        bVar.f20783a = b10;
        return i11;
    }

    static int J(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        w wVar = (w) iVar;
        int I = I(bArr, i11, bVar);
        wVar.U0(bVar.f20783a);
        while (I < i12) {
            int I2 = I(bArr, I, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            I = I(bArr, I2, bVar);
            wVar.U0(bVar.f20783a);
        }
        return I;
    }

    static int K(long j10, byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        long j11 = (j10 & 127) | (((long) (b10 & Byte.MAX_VALUE)) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            i12 += 7;
            j11 |= ((long) (b11 & Byte.MAX_VALUE)) << i12;
            byte b12 = b11;
            i11 = i13;
            b10 = b12;
        }
        bVar.f20784b = j11;
        return i11;
    }

    static int L(byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        long j10 = (long) bArr[i10];
        if (j10 < 0) {
            return K(j10, bArr, i11, bVar);
        }
        bVar.f20784b = j10;
        return i11;
    }

    static int M(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        d0 d0Var = (d0) iVar;
        int L = L(bArr, i11, bVar);
        d0Var.i(bVar.f20784b);
        while (L < i12) {
            int I = I(bArr, L, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            L = L(bArr, I, bVar);
            d0Var.i(bVar.f20784b);
        }
        return L;
    }

    static int N(int i10, byte[] bArr, int i11, int i12, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i10) != 0) {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                return L(bArr, i11, bVar);
            }
            if (b10 == 1) {
                return i11 + 8;
            }
            if (b10 == 2) {
                return I(bArr, i11, bVar) + bVar.f20783a;
            }
            if (b10 == 3) {
                int i13 = (i10 & -8) | 4;
                int i14 = 0;
                while (i11 < i12) {
                    i11 = I(bArr, i11, bVar);
                    i14 = bVar.f20783a;
                    if (i14 == i13) {
                        break;
                    }
                    i11 = N(i14, bArr, i11, i12, bVar);
                }
                if (i11 <= i12 && i14 == i13) {
                    return i11;
                }
                throw InvalidProtocolBufferException.g();
            } else if (b10 == 5) {
                return i11 + 4;
            } else {
                throw InvalidProtocolBufferException.b();
            }
        } else {
            throw InvalidProtocolBufferException.b();
        }
    }

    static int a(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        boolean z10;
        boolean z11;
        g gVar = (g) iVar;
        int L = L(bArr, i11, bVar);
        if (bVar.f20784b != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        gVar.i(z10);
        while (L < i12) {
            int I = I(bArr, L, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            L = L(bArr, I, bVar);
            if (bVar.f20784b != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            gVar.i(z11);
        }
        return L;
    }

    static int b(byte[] bArr, int i10, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.f();
        } else if (i11 > bArr.length - I) {
            throw InvalidProtocolBufferException.j();
        } else if (i11 == 0) {
            bVar.f20785c = ByteString.f20615a;
            return I;
        } else {
            bVar.f20785c = ByteString.j(bArr, I, i11);
            return I + i11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int c(int r2, byte[] r3, int r4, int r5, com.google.crypto.tink.shaded.protobuf.x.i<?> r6, com.google.crypto.tink.shaded.protobuf.e.b r7) throws com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f20783a
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = com.google.crypto.tink.shaded.protobuf.ByteString.f20615a
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            com.google.crypto.tink.shaded.protobuf.ByteString r1 = com.google.crypto.tink.shaded.protobuf.ByteString.j(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = I(r3, r4, r7)
            int r1 = r7.f20783a
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f20783a
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = com.google.crypto.tink.shaded.protobuf.ByteString.f20615a
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            com.google.crypto.tink.shaded.protobuf.ByteString r1 = com.google.crypto.tink.shaded.protobuf.ByteString.j(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.j()
            throw r2
        L_0x0048:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.j()
            throw r2
        L_0x0053:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.f()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.c(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.x$i, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    static double d(byte[] bArr, int i10) {
        return Double.longBitsToDouble(j(bArr, i10));
    }

    static int e(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        l lVar = (l) iVar;
        lVar.g(d(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int I = I(bArr, i13, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            lVar.g(d(bArr, I));
            i13 = I + 8;
        }
        return i13;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ff, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int f(int r7, byte[] r8, int r9, int r10, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.c<?, ?> r11, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.e<?, ?> r12, com.google.crypto.tink.shaded.protobuf.f1<com.google.crypto.tink.shaded.protobuf.g1, com.google.crypto.tink.shaded.protobuf.g1> r13, com.google.crypto.tink.shaded.protobuf.e.b r14) throws java.io.IOException {
        /*
            com.google.crypto.tink.shaded.protobuf.t<com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d> r0 = r11.extensions
            int r7 = r7 >>> 3
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r1 = r12.f20686b
            boolean r1 = r1.f()
            r2 = 0
            if (r1 == 0) goto L_0x00fb
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r1 = r12.f20686b
            boolean r1 = r1.n()
            if (r1 == 0) goto L_0x00fb
            int[] r10 = com.google.crypto.tink.shaded.protobuf.e.a.f20782a
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = r12.a()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00ab;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x008b;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r9 = r9.g()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            com.google.crypto.tink.shaded.protobuf.w r10 = new com.google.crypto.tink.shaded.protobuf.w
            r10.<init>()
            int r8 = y(r8, r9, r10, r14)
            com.google.crypto.tink.shaded.protobuf.g1 r9 = r11.unknownFields
            com.google.crypto.tink.shaded.protobuf.g1 r14 = com.google.crypto.tink.shaded.protobuf.g1.e()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            com.google.crypto.tink.shaded.protobuf.x$d r9 = r9.b()
            java.lang.Object r7 = com.google.crypto.tink.shaded.protobuf.b1.z(r7, r10, r9, r2, r13)
            com.google.crypto.tink.shaded.protobuf.g1 r7 = (com.google.crypto.tink.shaded.protobuf.g1) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r7 = r12.f20686b
            r0.w(r7, r10)
            goto L_0x0234
        L_0x006b:
            com.google.crypto.tink.shaded.protobuf.d0 r7 = new com.google.crypto.tink.shaded.protobuf.d0
            r7.<init>()
            int r8 = x(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x007b:
            com.google.crypto.tink.shaded.protobuf.w r7 = new com.google.crypto.tink.shaded.protobuf.w
            r7.<init>()
            int r8 = w(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x008b:
            com.google.crypto.tink.shaded.protobuf.g r7 = new com.google.crypto.tink.shaded.protobuf.g
            r7.<init>()
            int r8 = r(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x009b:
            com.google.crypto.tink.shaded.protobuf.w r7 = new com.google.crypto.tink.shaded.protobuf.w
            r7.<init>()
            int r8 = t(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00ab:
            com.google.crypto.tink.shaded.protobuf.d0 r7 = new com.google.crypto.tink.shaded.protobuf.d0
            r7.<init>()
            int r8 = u(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00bb:
            com.google.crypto.tink.shaded.protobuf.w r7 = new com.google.crypto.tink.shaded.protobuf.w
            r7.<init>()
            int r8 = y(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00cb:
            com.google.crypto.tink.shaded.protobuf.d0 r7 = new com.google.crypto.tink.shaded.protobuf.d0
            r7.<init>()
            int r8 = z(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00db:
            com.google.crypto.tink.shaded.protobuf.u r7 = new com.google.crypto.tink.shaded.protobuf.u
            r7.<init>()
            int r8 = v(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00eb:
            com.google.crypto.tink.shaded.protobuf.l r7 = new com.google.crypto.tink.shaded.protobuf.l
            r7.<init>()
            int r8 = s(r8, r9, r7, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r9 = r12.f20686b
            r0.w(r9, r7)
            goto L_0x0234
        L_0x00fb:
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = r12.a()
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0131
            int r9 = I(r8, r9, r14)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r8 = r12.f20686b
            com.google.crypto.tink.shaded.protobuf.x$d r8 = r8.b()
            int r10 = r14.f20783a
            com.google.crypto.tink.shaded.protobuf.x$c r8 = r8.findValueByNumber(r10)
            if (r8 != 0) goto L_0x0129
            com.google.crypto.tink.shaded.protobuf.g1 r8 = r11.unknownFields
            com.google.crypto.tink.shaded.protobuf.g1 r10 = com.google.crypto.tink.shaded.protobuf.g1.e()
            if (r8 != r10) goto L_0x0123
            com.google.crypto.tink.shaded.protobuf.g1 r8 = com.google.crypto.tink.shaded.protobuf.g1.l()
            r11.unknownFields = r8
        L_0x0123:
            int r10 = r14.f20783a
            com.google.crypto.tink.shaded.protobuf.b1.L(r7, r10, r8, r13)
            return r9
        L_0x0129:
            int r7 = r14.f20783a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x0131:
            int[] r11 = com.google.crypto.tink.shaded.protobuf.e.a.f20782a
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r13 = r12.a()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ec;
                case 3: goto L_0x01e1;
                case 4: goto L_0x01e1;
                case 5: goto L_0x01d6;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01cd;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01c4;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a1;
                case 13: goto L_0x0192;
                case 14: goto L_0x018a;
                case 15: goto L_0x0182;
                case 16: goto L_0x017a;
                case 17: goto L_0x015a;
                case 18: goto L_0x0142;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0201
        L_0x0142:
            com.google.crypto.tink.shaded.protobuf.v0 r7 = com.google.crypto.tink.shaded.protobuf.v0.a()
            com.google.crypto.tink.shaded.protobuf.l0 r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r7.d(r11)
            int r9 = p(r7, r8, r9, r10, r14)
            java.lang.Object r2 = r14.f20785c
            goto L_0x0201
        L_0x015a:
            int r7 = r7 << 3
            r5 = r7 | 4
            com.google.crypto.tink.shaded.protobuf.v0 r7 = com.google.crypto.tink.shaded.protobuf.v0.a()
            com.google.crypto.tink.shaded.protobuf.l0 r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            com.google.crypto.tink.shaded.protobuf.z0 r1 = r7.d(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r14.f20785c
            goto L_0x0201
        L_0x017a:
            int r9 = C(r8, r9, r14)
            java.lang.Object r2 = r14.f20785c
            goto L_0x0201
        L_0x0182:
            int r9 = b(r8, r9, r14)
            java.lang.Object r2 = r14.f20785c
            goto L_0x0201
        L_0x018a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0192:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f20784b
            long r7 = com.google.crypto.tink.shaded.protobuf.i.c(r7)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01a1:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f20783a
            int r7 = com.google.crypto.tink.shaded.protobuf.i.b(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01b0:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f20784b
            r10 = 0
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x01be
            r7 = 1
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x0201
        L_0x01c4:
            int r7 = h(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x01f4
        L_0x01cd:
            long r7 = j(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x01ff
        L_0x01d6:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f20783a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01e1:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f20784b
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01ec:
            float r7 = l(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
        L_0x01f4:
            int r9 = r9 + 4
            goto L_0x0201
        L_0x01f7:
            double r7 = d(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
        L_0x01ff:
            int r9 = r9 + 8
        L_0x0201:
            boolean r7 = r12.d()
            if (r7 == 0) goto L_0x020d
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r7 = r12.f20686b
            r0.a(r7, r2)
            goto L_0x0233
        L_0x020d:
            int[] r7 = com.google.crypto.tink.shaded.protobuf.e.a.f20782a
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r8 = r12.a()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x0222
            r8 = 18
            if (r7 == r8) goto L_0x0222
            goto L_0x022e
        L_0x0222:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r7 = r12.f20686b
            java.lang.Object r7 = r0.i(r7)
            if (r7 == 0) goto L_0x022e
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.x.h(r7, r2)
        L_0x022e:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$d r7 = r12.f20686b
            r0.w(r7, r2)
        L_0x0233:
            r8 = r9
        L_0x0234:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.f(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$c, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$e, com.google.crypto.tink.shaded.protobuf.f1, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    static int g(int i10, byte[] bArr, int i11, int i12, Object obj, l0 l0Var, f1<g1, g1> f1Var, b bVar) throws IOException {
        GeneratedMessageLite.e a10 = bVar.f20786d.a(l0Var, i10 >>> 3);
        if (a10 == null) {
            return G(i10, bArr, i11, i12, o0.s(obj), bVar);
        }
        GeneratedMessageLite.c cVar = (GeneratedMessageLite.c) obj;
        cVar.C();
        return f(i10, bArr, i11, i12, cVar, a10, f1Var, bVar);
    }

    static int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static int i(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        w wVar = (w) iVar;
        wVar.U0(h(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int I = I(bArr, i13, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            wVar.U0(h(bArr, I));
            i13 = I + 4;
        }
        return i13;
    }

    static long j(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    static int k(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        d0 d0Var = (d0) iVar;
        d0Var.i(j(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int I = I(bArr, i13, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            d0Var.i(j(bArr, I));
            i13 = I + 8;
        }
        return i13;
    }

    static float l(byte[] bArr, int i10) {
        return Float.intBitsToFloat(h(bArr, i10));
    }

    static int m(int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) {
        u uVar = (u) iVar;
        uVar.g(l(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int I = I(bArr, i13, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            uVar.g(l(bArr, I));
            i13 = I + 4;
        }
        return i13;
    }

    static int n(z0 z0Var, byte[] bArr, int i10, int i11, int i12, b bVar) throws IOException {
        o0 o0Var = (o0) z0Var;
        Object newInstance = o0Var.newInstance();
        int Z = o0Var.Z(newInstance, bArr, i10, i11, i12, bVar);
        o0Var.b(newInstance);
        bVar.f20785c = newInstance;
        return Z;
    }

    static int o(z0 z0Var, int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) throws IOException {
        int i13 = (i10 & -8) | 4;
        int n10 = n(z0Var, bArr, i11, i12, i13, bVar);
        iVar.add(bVar.f20785c);
        while (n10 < i12) {
            int I = I(bArr, n10, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            n10 = n(z0Var, bArr, I, i12, i13, bVar);
            iVar.add(bVar.f20785c);
        }
        return n10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int p(com.google.crypto.tink.shaded.protobuf.z0 r6, byte[] r7, int r8, int r9, com.google.crypto.tink.shaded.protobuf.e.b r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = H(r8, r7, r0, r10)
            int r8 = r10.f20783a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.e(r1, r2, r3, r4, r5)
            r6.b(r9)
            r10.f20785c = r9
            return r8
        L_0x0025:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r6 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.j()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.e.p(com.google.crypto.tink.shaded.protobuf.z0, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    static int q(z0<?> z0Var, int i10, byte[] bArr, int i11, int i12, x.i<?> iVar, b bVar) throws IOException {
        int p10 = p(z0Var, bArr, i11, i12, bVar);
        iVar.add(bVar.f20785c);
        while (p10 < i12) {
            int I = I(bArr, p10, bVar);
            if (i10 != bVar.f20783a) {
                break;
            }
            p10 = p(z0Var, bArr, I, i12, bVar);
            iVar.add(bVar.f20785c);
        }
        return p10;
    }

    static int r(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        boolean z10;
        g gVar = (g) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            I = L(bArr, I, bVar);
            if (bVar.f20784b != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            gVar.i(z10);
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int s(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        l lVar = (l) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            lVar.g(d(bArr, I));
            I += 8;
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int t(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        w wVar = (w) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            wVar.U0(h(bArr, I));
            I += 4;
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int u(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        d0 d0Var = (d0) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            d0Var.i(j(bArr, I));
            I += 8;
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int v(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        u uVar = (u) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            uVar.g(l(bArr, I));
            I += 4;
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int w(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        w wVar = (w) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            I = I(bArr, I, bVar);
            wVar.U0(i.b(bVar.f20783a));
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int x(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        d0 d0Var = (d0) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            I = L(bArr, I, bVar);
            d0Var.i(i.c(bVar.f20784b));
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int y(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        w wVar = (w) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            I = I(bArr, I, bVar);
            wVar.U0(bVar.f20783a);
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }

    static int z(byte[] bArr, int i10, x.i<?> iVar, b bVar) throws IOException {
        d0 d0Var = (d0) iVar;
        int I = I(bArr, i10, bVar);
        int i11 = bVar.f20783a + I;
        while (I < i11) {
            I = L(bArr, I, bVar);
            d0Var.i(bVar.f20784b);
        }
        if (I == i11) {
            return I;
        }
        throw InvalidProtocolBufferException.j();
    }
}
