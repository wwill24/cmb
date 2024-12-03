package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.l0;
import com.google.protobuf.s.b;
import com.google.protobuf.w;
import com.google.protobuf.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class s<T extends b<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final s f21934d = new s(true);

    /* renamed from: a  reason: collision with root package name */
    private final c1<T, Object> f21935a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21936b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21937c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21938a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f21939b;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21939b = r0
                r1 = 1
                com.google.protobuf.WireFormat$FieldType r2 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f21939b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r3 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f21939b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r4 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f21939b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r5 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f21939b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r6 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f21939b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r7 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f21939b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r8 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f21939b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r9 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = f21939b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r10 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                com.google.protobuf.WireFormat$JavaType[] r9 = com.google.protobuf.WireFormat.JavaType.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                f21938a = r9
                com.google.protobuf.WireFormat$JavaType r10 = com.google.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f21938a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                com.google.protobuf.WireFormat$JavaType r9 = com.google.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x00fd }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x0111 }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x011b }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x012f }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f21938a     // Catch:{ NoSuchFieldError -> 0x0139 }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s.a.<clinit>():void");
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        l0.a P(l0.a aVar, l0 l0Var);

        boolean f();

        WireFormat.FieldType g();

        int getNumber();

        WireFormat.JavaType m();

        boolean n();
    }

    private s() {
        this.f21935a = c1.r(16);
    }

    static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.A0(i10, (l0) obj);
            return;
        }
        codedOutputStream.W0(i10, m(fieldType, false));
        B(codedOutputStream, fieldType, obj);
    }

    static void B(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f21939b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.r0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.z0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.H0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.a1(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.F0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.x0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.v0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.l0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.C0((l0) obj);
                return;
            case 10:
                codedOutputStream.J0((l0) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.p0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.V0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.p0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.m0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.Y0(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.N0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.P0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.R0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.T0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof w.c) {
                    codedOutputStream.t0(((w.c) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.t0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int d(WireFormat.FieldType fieldType, int i10, Object obj) {
        int V = CodedOutputStream.V(i10);
        if (fieldType == WireFormat.FieldType.GROUP) {
            V *= 2;
        }
        return V + e(fieldType, obj);
    }

    static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f21939b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((l0) obj);
            case 10:
                if (obj instanceof y) {
                    return CodedOutputStream.C((y) obj);
                }
                return CodedOutputStream.H((l0) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.U((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.X(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.M(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.O(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.Q(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.S(((Long) obj).longValue());
            case 18:
                if (obj instanceof w.c) {
                    return CodedOutputStream.m(((w.c) obj).getNumber());
                }
                return CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        WireFormat.FieldType g10 = bVar.g();
        int number = bVar.getNumber();
        if (!bVar.f()) {
            return d(g10, number, obj);
        }
        int i10 = 0;
        if (bVar.n()) {
            for (Object e10 : (List) obj) {
                i10 += e(g10, e10);
            }
            return CodedOutputStream.V(number) + i10 + CodedOutputStream.X(i10);
        }
        for (Object d10 : (List) obj) {
            i10 += d(g10, number, d10);
        }
        return i10;
    }

    public static <T extends b<T>> s<T> h() {
        return f21934d;
    }

    private int k(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.m() != WireFormat.JavaType.MESSAGE || bVar.f() || bVar.n()) {
            return f(bVar, value);
        }
        if (value instanceof y) {
            return CodedOutputStream.A(((b) entry.getKey()).getNumber(), (y) value);
        }
        return CodedOutputStream.E(((b) entry.getKey()).getNumber(), (l0) value);
    }

    static int m(WireFormat.FieldType fieldType, boolean z10) {
        if (z10) {
            return 2;
        }
        return fieldType.c();
    }

    private static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        if (bVar.m() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!bVar.f()) {
            return r(entry.getValue());
        }
        for (Object r10 : (List) entry.getValue()) {
            if (!r(r10)) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(Object obj) {
        if (obj instanceof m0) {
            return ((m0) obj).isInitialized();
        }
        if (obj instanceof y) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean s(WireFormat.FieldType fieldType, Object obj) {
        w.a(obj);
        switch (a.f21938a[fieldType.b().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof w.c)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof l0) || (obj instanceof y)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void w(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof y) {
            value = ((y) value).f();
        }
        if (bVar.f()) {
            Object i10 = i(bVar);
            if (i10 == null) {
                i10 = new ArrayList();
            }
            for (Object c10 : (List) value) {
                ((List) i10).add(c(c10));
            }
            this.f21935a.put(bVar, i10);
        } else if (bVar.m() == WireFormat.JavaType.MESSAGE) {
            Object i11 = i(bVar);
            if (i11 == null) {
                this.f21935a.put(bVar, c(value));
                return;
            }
            this.f21935a.put(bVar, bVar.P(((l0) i11).toBuilder(), (l0) value).build());
        } else {
            this.f21935a.put(bVar, c(value));
        }
    }

    public static <T extends b<T>> s<T> x() {
        return new s<>();
    }

    private void z(T t10, Object obj) {
        if (!s(t10.g(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t10.getNumber()), t10.g().b(), obj.getClass().getName()}));
        }
    }

    public void a(T t10, Object obj) {
        List list;
        if (t10.f()) {
            z(t10, obj);
            Object i10 = i(t10);
            if (i10 == null) {
                list = new ArrayList();
                this.f21935a.put(t10, list);
            } else {
                list = (List) i10;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public s<T> clone() {
        s<T> x10 = x();
        for (int i10 = 0; i10 < this.f21935a.l(); i10++) {
            Map.Entry<T, Object> k10 = this.f21935a.k(i10);
            x10.y((b) k10.getKey(), k10.getValue());
        }
        for (Map.Entry next : this.f21935a.n()) {
            x10.y((b) next.getKey(), next.getValue());
        }
        x10.f21937c = this.f21937c;
        return x10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        return this.f21935a.equals(((s) obj).f21935a);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        if (this.f21937c) {
            return new y.c(this.f21935a.h().iterator());
        }
        return this.f21935a.h().iterator();
    }

    public int hashCode() {
        return this.f21935a.hashCode();
    }

    public Object i(T t10) {
        Object obj = this.f21935a.get(t10);
        if (obj instanceof y) {
            return ((y) obj).f();
        }
        return obj;
    }

    public int j() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f21935a.l(); i11++) {
            i10 += k(this.f21935a.k(i11));
        }
        for (Map.Entry<T, Object> k10 : this.f21935a.n()) {
            i10 += k(k10);
        }
        return i10;
    }

    public int l() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f21935a.l(); i11++) {
            Map.Entry<T, Object> k10 = this.f21935a.k(i11);
            i10 += f((b) k10.getKey(), k10.getValue());
        }
        for (Map.Entry next : this.f21935a.n()) {
            i10 += f((b) next.getKey(), next.getValue());
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f21935a.isEmpty();
    }

    public boolean o() {
        return this.f21936b;
    }

    public boolean p() {
        for (int i10 = 0; i10 < this.f21935a.l(); i10++) {
            if (!q(this.f21935a.k(i10))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> q10 : this.f21935a.n()) {
            if (!q(q10)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> t() {
        if (this.f21937c) {
            return new y.c(this.f21935a.entrySet().iterator());
        }
        return this.f21935a.entrySet().iterator();
    }

    public void u() {
        if (!this.f21936b) {
            for (int i10 = 0; i10 < this.f21935a.l(); i10++) {
                Map.Entry<T, Object> k10 = this.f21935a.k(i10);
                if (k10.getValue() instanceof GeneratedMessageLite) {
                    ((GeneratedMessageLite) k10.getValue()).makeImmutable();
                }
            }
            this.f21935a.q();
            this.f21936b = true;
        }
    }

    public void v(s<T> sVar) {
        for (int i10 = 0; i10 < sVar.f21935a.l(); i10++) {
            w(sVar.f21935a.k(i10));
        }
        for (Map.Entry<T, Object> w10 : sVar.f21935a.n()) {
            w(w10);
        }
    }

    public void y(T t10, Object obj) {
        if (!t10.f()) {
            z(t10, obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object z10 : arrayList) {
                z(t10, z10);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof y) {
            this.f21937c = true;
        }
        this.f21935a.put(t10, obj);
    }

    private s(boolean z10) {
        this(c1.r(0));
        u();
    }

    private s(c1<T, Object> c1Var) {
        this.f21935a = c1Var;
        u();
    }
}
