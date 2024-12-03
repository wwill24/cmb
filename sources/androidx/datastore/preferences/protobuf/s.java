package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.s.b;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class s<T extends b<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final s f5363d = new s(true);

    /* renamed from: a  reason: collision with root package name */
    private final b1<T, Object> f5364a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5365b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5366c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5367a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5368b;

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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5368b = r0
                r1 = 1
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r2 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5368b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5368b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f5368b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r5 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f5368b     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f5368b     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f5368b     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f5368b     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = f5368b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                f5367a = r9
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r10 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f5367a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r9 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x00fd }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x0107 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x0111 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x011b }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x0125 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x012f }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f5367a     // Catch:{ NoSuchFieldError -> 0x0139 }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s.a.<clinit>():void");
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        k0.a H0(k0.a aVar, k0 k0Var);

        boolean f();

        WireFormat.FieldType g();

        int getNumber();

        WireFormat.JavaType m();

        boolean n();
    }

    private s() {
        this.f5364a = b1.r(16);
    }

    static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f5368b[fieldType.ordinal()]) {
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
                codedOutputStream.C0((k0) obj);
                return;
            case 10:
                codedOutputStream.J0((k0) obj);
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
        switch (a.f5368b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.j(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.r(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.p(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.n(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.e(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.t((k0) obj);
            case 10:
                if (obj instanceof x) {
                    return CodedOutputStream.B((x) obj);
                }
                return CodedOutputStream.G((k0) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.h((ByteString) obj);
                }
                return CodedOutputStream.U((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.h((ByteString) obj);
                }
                return CodedOutputStream.f((byte[]) obj);
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
                    return CodedOutputStream.l(((w.c) obj).getNumber());
                }
                return CodedOutputStream.l(((Integer) obj).intValue());
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
            return CodedOutputStream.V(number) + i10 + CodedOutputStream.K(i10);
        }
        for (Object d10 : (List) obj) {
            i10 += d(g10, number, d10);
        }
        return i10;
    }

    public static <T extends b<T>> s<T> h() {
        return f5363d;
    }

    private int k(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (bVar.m() != WireFormat.JavaType.MESSAGE || bVar.f() || bVar.n()) {
            return f(bVar, value);
        }
        if (value instanceof x) {
            return CodedOutputStream.z(((b) entry.getKey()).getNumber(), (x) value);
        }
        return CodedOutputStream.D(((b) entry.getKey()).getNumber(), (k0) value);
    }

    static int m(WireFormat.FieldType fieldType, boolean z10) {
        if (z10) {
            return 2;
        }
        return fieldType.b();
    }

    private static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        if (bVar.m() == WireFormat.JavaType.MESSAGE) {
            if (bVar.f()) {
                for (k0 isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof k0) {
                    if (!((k0) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof x) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static boolean r(WireFormat.FieldType fieldType, Object obj) {
        w.a(obj);
        switch (a.f5367a[fieldType.a().ordinal()]) {
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
                if ((obj instanceof k0) || (obj instanceof x)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void v(Map.Entry<T, Object> entry) {
        b bVar = (b) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof x) {
            value = ((x) value).f();
        }
        if (bVar.f()) {
            Object i10 = i(bVar);
            if (i10 == null) {
                i10 = new ArrayList();
            }
            for (Object c10 : (List) value) {
                ((List) i10).add(c(c10));
            }
            this.f5364a.put(bVar, i10);
        } else if (bVar.m() == WireFormat.JavaType.MESSAGE) {
            Object i11 = i(bVar);
            if (i11 == null) {
                this.f5364a.put(bVar, c(value));
                return;
            }
            this.f5364a.put(bVar, bVar.H0(((k0) i11).toBuilder(), (k0) value).build());
        } else {
            this.f5364a.put(bVar, c(value));
        }
    }

    public static <T extends b<T>> s<T> w() {
        return new s<>();
    }

    private void y(WireFormat.FieldType fieldType, Object obj) {
        if (!r(fieldType, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    static void z(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.A0(i10, (k0) obj);
            return;
        }
        codedOutputStream.W0(i10, m(fieldType, false));
        A(codedOutputStream, fieldType, obj);
    }

    public void a(T t10, Object obj) {
        List list;
        if (t10.f()) {
            y(t10.g(), obj);
            Object i10 = i(t10);
            if (i10 == null) {
                list = new ArrayList();
                this.f5364a.put(t10, list);
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
        s<T> w10 = w();
        for (int i10 = 0; i10 < this.f5364a.l(); i10++) {
            Map.Entry<T, Object> k10 = this.f5364a.k(i10);
            w10.x((b) k10.getKey(), k10.getValue());
        }
        for (Map.Entry next : this.f5364a.n()) {
            w10.x((b) next.getKey(), next.getValue());
        }
        w10.f5366c = this.f5366c;
        return w10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        return this.f5364a.equals(((s) obj).f5364a);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        if (this.f5366c) {
            return new x.c(this.f5364a.h().iterator());
        }
        return this.f5364a.h().iterator();
    }

    public int hashCode() {
        return this.f5364a.hashCode();
    }

    public Object i(T t10) {
        Object obj = this.f5364a.get(t10);
        if (obj instanceof x) {
            return ((x) obj).f();
        }
        return obj;
    }

    public int j() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f5364a.l(); i11++) {
            i10 += k(this.f5364a.k(i11));
        }
        for (Map.Entry<T, Object> k10 : this.f5364a.n()) {
            i10 += k(k10);
        }
        return i10;
    }

    public int l() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f5364a.l(); i11++) {
            Map.Entry<T, Object> k10 = this.f5364a.k(i11);
            i10 += f((b) k10.getKey(), k10.getValue());
        }
        for (Map.Entry next : this.f5364a.n()) {
            i10 += f((b) next.getKey(), next.getValue());
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f5364a.isEmpty();
    }

    public boolean o() {
        return this.f5365b;
    }

    public boolean p() {
        for (int i10 = 0; i10 < this.f5364a.l(); i10++) {
            if (!q(this.f5364a.k(i10))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> q10 : this.f5364a.n()) {
            if (!q(q10)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        if (this.f5366c) {
            return new x.c(this.f5364a.entrySet().iterator());
        }
        return this.f5364a.entrySet().iterator();
    }

    public void t() {
        if (!this.f5365b) {
            this.f5364a.q();
            this.f5365b = true;
        }
    }

    public void u(s<T> sVar) {
        for (int i10 = 0; i10 < sVar.f5364a.l(); i10++) {
            v(sVar.f5364a.k(i10));
        }
        for (Map.Entry<T, Object> v10 : sVar.f5364a.n()) {
            v(v10);
        }
    }

    public void x(T t10, Object obj) {
        if (!t10.f()) {
            y(t10.g(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object y10 : arrayList) {
                y(t10.g(), y10);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof x) {
            this.f5366c = true;
        }
        this.f5364a.put(t10, obj);
    }

    private s(boolean z10) {
        this(b1.r(0));
        t();
    }

    private s(b1<T, Object> b1Var) {
        this.f5364a = b1Var;
        t();
    }
}
