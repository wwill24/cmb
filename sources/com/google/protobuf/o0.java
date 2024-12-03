package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.google.protobuf.e;
import com.google.protobuf.f0;
import com.google.protobuf.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class o0<T> implements z0<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f21907r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f21908s = j1.H();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21909a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f21910b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21911c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21912d;

    /* renamed from: e  reason: collision with root package name */
    private final l0 f21913e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21914f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21915g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21916h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f21917i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f21918j;

    /* renamed from: k  reason: collision with root package name */
    private final int f21919k;

    /* renamed from: l  reason: collision with root package name */
    private final int f21920l;

    /* renamed from: m  reason: collision with root package name */
    private final q0 f21921m;

    /* renamed from: n  reason: collision with root package name */
    private final c0 f21922n;

    /* renamed from: o  reason: collision with root package name */
    private final f1<?, ?> f21923o;

    /* renamed from: p  reason: collision with root package name */
    private final o<?> f21924p;

    /* renamed from: q  reason: collision with root package name */
    private final g0 f21925q;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21926a;

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
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21926a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f21926a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.a.<clinit>():void");
        }
    }

    private o0(int[] iArr, Object[] objArr, int i10, int i11, l0 l0Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, o<?> oVar, g0 g0Var) {
        boolean z12;
        this.f21909a = iArr;
        this.f21910b = objArr;
        this.f21911c = i10;
        this.f21912d = i11;
        this.f21915g = l0Var instanceof GeneratedMessageLite;
        this.f21916h = z10;
        if (oVar == null || !oVar.e(l0Var)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.f21914f = z12;
        this.f21917i = z11;
        this.f21918j = iArr2;
        this.f21919k = i12;
        this.f21920l = i13;
        this.f21921m = q0Var;
        this.f21922n = c0Var;
        this.f21923o = f1Var;
        this.f21924p = oVar;
        this.f21913e = l0Var;
        this.f21925q = g0Var;
    }

    private boolean A(T t10, int i10) {
        int j02 = j0(i10);
        long j10 = (long) (1048575 & j02);
        if (j10 == 1048575) {
            int v02 = v0(i10);
            long W = W(v02);
            switch (u0(v02)) {
                case 0:
                    if (Double.doubleToRawLongBits(j1.A(t10, W)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(j1.B(t10, W)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (j1.E(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (j1.E(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (j1.E(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return j1.t(t10, W);
                case 8:
                    Object G = j1.G(t10, W);
                    if (G instanceof String) {
                        return !((String) G).isEmpty();
                    }
                    if (G instanceof ByteString) {
                        return !ByteString.f21603a.equals(G);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (j1.G(t10, W) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.f21603a.equals(j1.G(t10, W));
                case 11:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (j1.E(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (j1.C(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (j1.E(t10, W) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (j1.G(t10, W) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((j1.C(t10, j10) & (1 << (j02 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private void A0(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.e(i10, (String) obj);
        } else {
            writer.L(i10, (ByteString) obj);
        }
    }

    private boolean B(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? A(t10, i10) : (i12 & i13) != 0;
    }

    private <UT, UB> void B0(f1<UT, UB> f1Var, T t10, Writer writer) throws IOException {
        f1Var.t(f1Var.g(t10), writer);
    }

    private static boolean C(Object obj, int i10, z0 z0Var) {
        return z0Var.c(j1.G(obj, W(i10)));
    }

    private <N> boolean D(Object obj, int i10, int i11) {
        List list = (List) j1.G(obj, W(i10));
        if (list.isEmpty()) {
            return true;
        }
        z0 t10 = t(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!t10.c(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    private boolean E(T t10, int i10, int i11) {
        Map<?, ?> e10 = this.f21925q.e(j1.G(t10, W(i10)));
        if (e10.isEmpty()) {
            return true;
        }
        if (this.f21925q.b(s(i11)).f21800c.b() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        z0<?> z0Var = null;
        for (Object next : e10.values()) {
            if (z0Var == null) {
                z0Var = v0.a().c(next.getClass());
            }
            if (!z0Var.c(next)) {
                return false;
            }
        }
        return true;
    }

    private static boolean F(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean G(T t10, T t11, int i10) {
        long j02 = (long) (j0(i10) & 1048575);
        if (j1.C(t10, j02) == j1.C(t11, j02)) {
            return true;
        }
        return false;
    }

    private boolean H(T t10, int i10, int i11) {
        if (j1.C(t10, (long) (j0(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static boolean I(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static List<?> J(Object obj, long j10) {
        return (List) j1.G(obj, j10);
    }

    private static <T> long K(T t10, long j10) {
        return j1.E(t10, j10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:98|97|157|174|175|(0)(0)|196|219|211) */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0649, code lost:
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x064d, code lost:
        if (r22.D() == false) goto L_0x064f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x064f, code lost:
        r0 = r8.f21919k;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0654, code lost:
        if (r0 < r8.f21920l) goto L_0x0656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0656, code lost:
        r4 = o(r21, r8.f21918j[r0], r4, r19, r21);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0669, code lost:
        if (r4 != null) goto L_0x066b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x066b, code lost:
        r14.o(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x066f, code lost:
        if (r5 == null) goto L_0x0671;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        r5 = r14.f(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0676, code lost:
        r1 = r14.m(r5, r0);
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x067a, code lost:
        if (r1 == false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x067c, code lost:
        r0 = r8.f21919k;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0681, code lost:
        if (r0 < r8.f21920l) goto L_0x0683;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0683, code lost:
        r4 = o(r21, r8.f21918j[r0], r4, r19, r21);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0696, code lost:
        if (r4 != null) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0698, code lost:
        r14.o(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x06a1, code lost:
        r0 = th;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0194, code lost:
        r12 = r5;
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0247, code lost:
        r14 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:174:0x0643 */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0649 A[Catch:{ all -> 0x06a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06b3 A[LOOP:6: B:205:0x06af->B:207:0x06b3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends com.google.protobuf.s.b<ET>> void L(com.google.protobuf.f1<UT, UB> r19, com.google.protobuf.o<ET> r20, T r21, com.google.protobuf.y0 r22, com.google.protobuf.n r23) throws java.io.IOException {
        /*
            r18 = this;
            r8 = r18
            r7 = r19
            r15 = r21
            r0 = r22
            r6 = r23
            r17 = 0
            r5 = r17
            r9 = r5
        L_0x000f:
            int r2 = r22.A()     // Catch:{ all -> 0x06a7 }
            int r3 = r8.h0(r2)     // Catch:{ all -> 0x06a7 }
            if (r3 >= 0) goto L_0x00b9
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x003e
            int r0 = r8.f21919k
            r4 = r5
        L_0x0021:
            int r1 = r8.f21920l
            if (r0 >= r1) goto L_0x0038
            int[] r1 = r8.f21918j
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0021
        L_0x0038:
            if (r4 == 0) goto L_0x003d
            r7.o(r15, r4)
        L_0x003d:
            return
        L_0x003e:
            boolean r1 = r8.f21914f     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x0047
            r4 = r20
            r12 = r17
            goto L_0x0050
        L_0x0047:
            com.google.protobuf.l0 r1 = r8.f21913e     // Catch:{ all -> 0x00b5 }
            r4 = r20
            java.lang.Object r1 = r4.b(r6, r1, r2)     // Catch:{ all -> 0x00b5 }
            r12 = r1
        L_0x0050:
            if (r12 == 0) goto L_0x0071
            if (r9 != 0) goto L_0x005c
            com.google.protobuf.s r1 = r20.d(r21)     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r0 = move-exception
            goto L_0x06a9
        L_0x005c:
            r1 = r9
        L_0x005d:
            r9 = r20
            r10 = r21
            r11 = r22
            r13 = r23
            r14 = r1
            r3 = r15
            r15 = r5
            r16 = r19
            java.lang.Object r5 = r9.g(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00b1 }
            r9 = r1
        L_0x006f:
            r15 = r3
            goto L_0x000f
        L_0x0071:
            r3 = r15
            boolean r1 = r7.q(r0)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x007f
            boolean r1 = r22.D()     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x008d
        L_0x007e:
            goto L_0x006f
        L_0x007f:
            if (r5 != 0) goto L_0x0086
            java.lang.Object r1 = r7.f(r3)     // Catch:{ all -> 0x00b1 }
            r5 = r1
        L_0x0086:
            boolean r1 = r7.m(r5, r0)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x008d
            goto L_0x007e
        L_0x008d:
            int r0 = r8.f21919k
            r4 = r5
        L_0x0090:
            int r1 = r8.f21920l
            if (r0 >= r1) goto L_0x00aa
            int[] r1 = r8.f21918j
            r5 = r1[r0]
            r1 = r18
            r2 = r21
            r10 = r3
            r3 = r5
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r3 = r10
            goto L_0x0090
        L_0x00aa:
            r10 = r3
            if (r4 == 0) goto L_0x00b0
            r7.o(r10, r4)
        L_0x00b0:
            return
        L_0x00b1:
            r0 = move-exception
            r10 = r3
            goto L_0x06a5
        L_0x00b5:
            r0 = move-exception
            r10 = r15
            goto L_0x06a5
        L_0x00b9:
            r4 = r20
            r10 = r15
            int r11 = r8.v0(r3)     // Catch:{ all -> 0x06a3 }
            int r1 = u0(r11)     // Catch:{ InvalidWireTypeException -> 0x0640 }
            switch(r1) {
                case 0: goto L_0x05fd;
                case 1: goto L_0x05eb;
                case 2: goto L_0x05d9;
                case 3: goto L_0x05c7;
                case 4: goto L_0x05b5;
                case 5: goto L_0x05a2;
                case 6: goto L_0x058f;
                case 7: goto L_0x057c;
                case 8: goto L_0x0571;
                case 9: goto L_0x055c;
                case 10: goto L_0x0549;
                case 11: goto L_0x0536;
                case 12: goto L_0x0510;
                case 13: goto L_0x04fd;
                case 14: goto L_0x04ea;
                case 15: goto L_0x04d7;
                case 16: goto L_0x04c4;
                case 17: goto L_0x04af;
                case 18: goto L_0x049d;
                case 19: goto L_0x048b;
                case 20: goto L_0x0479;
                case 21: goto L_0x0467;
                case 22: goto L_0x0455;
                case 23: goto L_0x0443;
                case 24: goto L_0x0431;
                case 25: goto L_0x041f;
                case 26: goto L_0x0417;
                case 27: goto L_0x0402;
                case 28: goto L_0x03f0;
                case 29: goto L_0x03de;
                case 30: goto L_0x03bd;
                case 31: goto L_0x03ab;
                case 32: goto L_0x0399;
                case 33: goto L_0x0387;
                case 34: goto L_0x0375;
                case 35: goto L_0x0363;
                case 36: goto L_0x0351;
                case 37: goto L_0x033f;
                case 38: goto L_0x032d;
                case 39: goto L_0x031b;
                case 40: goto L_0x0309;
                case 41: goto L_0x02f7;
                case 42: goto L_0x02e5;
                case 43: goto L_0x02d3;
                case 44: goto L_0x02b2;
                case 45: goto L_0x02a0;
                case 46: goto L_0x028e;
                case 47: goto L_0x027c;
                case 48: goto L_0x026a;
                case 49: goto L_0x024a;
                case 50: goto L_0x0235;
                case 51: goto L_0x021e;
                case 52: goto L_0x020a;
                case 53: goto L_0x01f7;
                case 54: goto L_0x01e4;
                case 55: goto L_0x01d1;
                case 56: goto L_0x01be;
                case 57: goto L_0x01ab;
                case 58: goto L_0x0198;
                case 59: goto L_0x018e;
                case 60: goto L_0x017d;
                case 61: goto L_0x016e;
                case 62: goto L_0x015b;
                case 63: goto L_0x0133;
                case 64: goto L_0x0120;
                case 65: goto L_0x010c;
                case 66: goto L_0x00f8;
                case 67: goto L_0x00e4;
                case 68: goto L_0x00d2;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            r12 = r5
            r13 = r6
            r14 = r7
            if (r12 != 0) goto L_0x0619
            java.lang.Object r1 = r14.f(r10)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x0617
        L_0x00d2:
            java.lang.Object r1 = r8.R(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.l0 r1 = (com.google.protobuf.l0) r1     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.z0 r11 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r0.O(r1, r11, r6)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.t0(r10, r2, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x00e4:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.y()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x00f8:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.l()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x010c:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.f()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0120:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.E()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0133:
            int r1 = r22.k()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.w$e r12 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            if (r12 == 0) goto L_0x014c
            boolean r12 = r12.isInRange(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            if (r12 == 0) goto L_0x0144
            goto L_0x014c
        L_0x0144:
            java.lang.Object r5 = com.google.protobuf.b1.L(r10, r2, r1, r5, r7)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r13 = r6
            r14 = r7
            goto L_0x069c
        L_0x014c:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x015b:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.h()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x016e:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.ByteString r1 = r22.o()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x017d:
            java.lang.Object r1 = r8.R(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.l0 r1 = (com.google.protobuf.l0) r1     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.z0 r11 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r0.P(r1, r11, r6)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.t0(r10, r2, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x018e:
            r8.m0(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
        L_0x0194:
            r12 = r5
            r13 = r6
            goto L_0x0247
        L_0x0198:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            boolean r1 = r22.e()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01ab:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.u()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01be:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.b()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01d1:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            int r1 = r22.p()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01e4:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.s()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x01f7:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            long r13 = r22.H()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x020a:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            float r1 = r22.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x021e:
            long r11 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            double r13 = r22.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            java.lang.Double r1 = java.lang.Double.valueOf(r13)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            com.google.protobuf.j1.V(r10, r11, r1)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            r8.q0(r10, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0641, all -> 0x0232 }
            goto L_0x0194
        L_0x0232:
            r0 = move-exception
            goto L_0x06a5
        L_0x0235:
            java.lang.Object r11 = r8.s(r3)     // Catch:{ InvalidWireTypeException -> 0x0640 }
            r1 = r18
            r2 = r21
            r4 = r11
            r12 = r5
            r5 = r23
            r13 = r6
            r6 = r22
            r1.M(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
        L_0x0247:
            r14 = r7
            goto L_0x060e
        L_0x024a:
            r12 = r5
            r13 = r6
            long r4 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
            com.google.protobuf.z0 r6 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0267, all -> 0x0263 }
            r1 = r18
            r2 = r21
            r3 = r4
            r5 = r22
            r14 = r7
            r7 = r23
            r1.k0(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0263:
            r0 = move-exception
            r14 = r7
            goto L_0x0612
        L_0x0267:
            r14 = r7
            goto L_0x0615
        L_0x026a:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x027c:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x028e:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02a0:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02b2:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r4 = r1.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.j(r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.w$e r5 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r21
            r3 = r4
            r4 = r5
            r5 = r12
            r6 = r19
            java.lang.Object r5 = com.google.protobuf.b1.A(r1, r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x02d3:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02e5:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x02f7:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0309:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x031b:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x032d:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x033f:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0351:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0363:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0375:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0387:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0399:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03ab:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03bd:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r4 = r1.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.j(r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.w$e r5 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r21
            r3 = r4
            r4 = r5
            r5 = r12
            r6 = r19
            java.lang.Object r5 = com.google.protobuf.b1.A(r1, r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x03de:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x03f0:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.F(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0402:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.z0 r5 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r1 = r18
            r2 = r21
            r3 = r11
            r4 = r22
            r6 = r23
            r1.l0(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0417:
            r12 = r5
            r13 = r6
            r14 = r7
            r8.n0(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x041f:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0431:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0443:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0455:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0467:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0479:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x048b:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x049d:
            r12 = r5
            r13 = r6
            r14 = r7
            com.google.protobuf.c0 r1 = r8.f21922n     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r2 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04af:
            r12 = r5
            r13 = r6
            r14 = r7
            java.lang.Object r1 = r8.Q(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.l0 r1 = (com.google.protobuf.l0) r1     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.z0 r2 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.O(r1, r2, r13)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.s0(r10, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04c4:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.y()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04d7:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.l()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04ea:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.f()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x04fd:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.E()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0510:
            r12 = r5
            r13 = r6
            r14 = r7
            int r1 = r22.k()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.w$e r4 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            if (r4 == 0) goto L_0x052a
            boolean r4 = r4.isInRange(r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            if (r4 == 0) goto L_0x0524
            goto L_0x052a
        L_0x0524:
            java.lang.Object r5 = com.google.protobuf.b1.L(r10, r2, r1, r12, r14)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x069c
        L_0x052a:
            long r4 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r4, r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0536:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.h()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0549:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.ByteString r4 = r22.o()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.V(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x055c:
            r12 = r5
            r13 = r6
            r14 = r7
            java.lang.Object r1 = r8.Q(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.l0 r1 = (com.google.protobuf.l0) r1     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.z0 r2 = r8.t(r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r0.P(r1, r2, r13)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.s0(r10, r3, r1)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x0571:
            r12 = r5
            r13 = r6
            r14 = r7
            r8.m0(r10, r11, r0)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x057c:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            boolean r4 = r22.e()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.L(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x058f:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.u()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05a2:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.b()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05b5:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            int r4 = r22.p()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.T(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05c7:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.s()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05d9:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            long r4 = r22.H()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.U(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05eb:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            float r4 = r22.readFloat()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.S(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            goto L_0x060e
        L_0x05fd:
            r12 = r5
            r13 = r6
            r14 = r7
            long r1 = W(r11)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            double r4 = r22.readDouble()     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            com.google.protobuf.j1.R(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
            r8.p0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x0615, all -> 0x0611 }
        L_0x060e:
            r5 = r12
            goto L_0x069c
        L_0x0611:
            r0 = move-exception
        L_0x0612:
            r5 = r12
            goto L_0x06ab
        L_0x0615:
            r5 = r12
            goto L_0x0643
        L_0x0617:
            r5 = r1
            goto L_0x061a
        L_0x0619:
            r5 = r12
        L_0x061a:
            boolean r1 = r14.m(r5, r0)     // Catch:{ InvalidWireTypeException -> 0x0643 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.f21919k
            r4 = r5
        L_0x0623:
            int r1 = r8.f21920l
            if (r0 >= r1) goto L_0x063a
            int[] r1 = r8.f21918j
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0623
        L_0x063a:
            if (r4 == 0) goto L_0x063f
            r14.o(r10, r4)
        L_0x063f:
            return
        L_0x0640:
            r12 = r5
        L_0x0641:
            r13 = r6
            r14 = r7
        L_0x0643:
            boolean r1 = r14.q(r0)     // Catch:{ all -> 0x06a1 }
            if (r1 == 0) goto L_0x066f
            boolean r1 = r22.D()     // Catch:{ all -> 0x06a1 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.f21919k
            r4 = r5
        L_0x0652:
            int r1 = r8.f21920l
            if (r0 >= r1) goto L_0x0669
            int[] r1 = r8.f21918j
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0652
        L_0x0669:
            if (r4 == 0) goto L_0x066e
            r14.o(r10, r4)
        L_0x066e:
            return
        L_0x066f:
            if (r5 != 0) goto L_0x0676
            java.lang.Object r1 = r14.f(r10)     // Catch:{ all -> 0x06a1 }
            r5 = r1
        L_0x0676:
            boolean r1 = r14.m(r5, r0)     // Catch:{ all -> 0x06a1 }
            if (r1 != 0) goto L_0x069c
            int r0 = r8.f21919k
            r4 = r5
        L_0x067f:
            int r1 = r8.f21920l
            if (r0 >= r1) goto L_0x0696
            int[] r1 = r8.f21918j
            r3 = r1[r0]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x067f
        L_0x0696:
            if (r4 == 0) goto L_0x069b
            r14.o(r10, r4)
        L_0x069b:
            return
        L_0x069c:
            r15 = r10
            r6 = r13
            r7 = r14
            goto L_0x000f
        L_0x06a1:
            r0 = move-exception
            goto L_0x06ab
        L_0x06a3:
            r0 = move-exception
            r12 = r5
        L_0x06a5:
            r14 = r7
            goto L_0x06ab
        L_0x06a7:
            r0 = move-exception
            r12 = r5
        L_0x06a9:
            r14 = r7
            r10 = r15
        L_0x06ab:
            int r1 = r8.f21919k
            r7 = r1
            r4 = r5
        L_0x06af:
            int r1 = r8.f21920l
            if (r7 >= r1) goto L_0x06c6
            int[] r1 = r8.f21918j
            r3 = r1[r7]
            r1 = r18
            r2 = r21
            r5 = r19
            r6 = r21
            java.lang.Object r4 = r1.o(r2, r3, r4, r5, r6)
            int r7 = r7 + 1
            goto L_0x06af
        L_0x06c6:
            if (r4 == 0) goto L_0x06cb
            r14.o(r10, r4)
        L_0x06cb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.L(com.google.protobuf.f1, com.google.protobuf.o, java.lang.Object, com.google.protobuf.y0, com.google.protobuf.n):void");
    }

    private final <K, V> void M(Object obj, int i10, Object obj2, n nVar, y0 y0Var) throws IOException {
        long W = W(v0(i10));
        Object G = j1.G(obj, W);
        if (G == null) {
            G = this.f21925q.d(obj2);
            j1.V(obj, W, G);
        } else if (this.f21925q.h(G)) {
            Object d10 = this.f21925q.d(obj2);
            this.f21925q.a(d10, G);
            j1.V(obj, W, d10);
            G = d10;
        }
        y0Var.M(this.f21925q.c(G), this.f21925q.b(obj2), nVar);
    }

    private void N(T t10, T t11, int i10) {
        if (A(t11, i10)) {
            long W = W(v0(i10));
            Unsafe unsafe = f21908s;
            Object object = unsafe.getObject(t11, W);
            if (object != null) {
                z0 t12 = t(i10);
                if (!A(t10, i10)) {
                    if (!F(object)) {
                        unsafe.putObject(t10, W, object);
                    } else {
                        Object newInstance = t12.newInstance();
                        t12.a(newInstance, object);
                        unsafe.putObject(t10, W, newInstance);
                    }
                    p0(t10, i10);
                    return;
                }
                Object object2 = unsafe.getObject(t10, W);
                if (!F(object2)) {
                    Object newInstance2 = t12.newInstance();
                    t12.a(newInstance2, object2);
                    unsafe.putObject(t10, W, newInstance2);
                    object2 = newInstance2;
                }
                t12.a(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + V(i10) + " is present but null: " + t11);
        }
    }

    private void O(T t10, T t11, int i10) {
        int V = V(i10);
        if (H(t11, V, i10)) {
            long W = W(v0(i10));
            Unsafe unsafe = f21908s;
            Object object = unsafe.getObject(t11, W);
            if (object != null) {
                z0 t12 = t(i10);
                if (!H(t10, V, i10)) {
                    if (!F(object)) {
                        unsafe.putObject(t10, W, object);
                    } else {
                        Object newInstance = t12.newInstance();
                        t12.a(newInstance, object);
                        unsafe.putObject(t10, W, newInstance);
                    }
                    q0(t10, V, i10);
                    return;
                }
                Object object2 = unsafe.getObject(t10, W);
                if (!F(object2)) {
                    Object newInstance2 = t12.newInstance();
                    t12.a(newInstance2, object2);
                    unsafe.putObject(t10, W, newInstance2);
                    object2 = newInstance2;
                }
                t12.a(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + V(i10) + " is present but null: " + t11);
        }
    }

    private void P(T t10, T t11, int i10) {
        int v02 = v0(i10);
        long W = W(v02);
        int V = V(i10);
        switch (u0(v02)) {
            case 0:
                if (A(t11, i10)) {
                    j1.R(t10, W, j1.A(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 1:
                if (A(t11, i10)) {
                    j1.S(t10, W, j1.B(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 2:
                if (A(t11, i10)) {
                    j1.U(t10, W, j1.E(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 3:
                if (A(t11, i10)) {
                    j1.U(t10, W, j1.E(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 4:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 5:
                if (A(t11, i10)) {
                    j1.U(t10, W, j1.E(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 6:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 7:
                if (A(t11, i10)) {
                    j1.L(t10, W, j1.t(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 8:
                if (A(t11, i10)) {
                    j1.V(t10, W, j1.G(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 9:
                N(t10, t11, i10);
                return;
            case 10:
                if (A(t11, i10)) {
                    j1.V(t10, W, j1.G(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 11:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 12:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 13:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 14:
                if (A(t11, i10)) {
                    j1.U(t10, W, j1.E(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 15:
                if (A(t11, i10)) {
                    j1.T(t10, W, j1.C(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 16:
                if (A(t11, i10)) {
                    j1.U(t10, W, j1.E(t11, W));
                    p0(t10, i10);
                    return;
                }
                return;
            case 17:
                N(t10, t11, i10);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f21922n.d(t10, t11, W);
                return;
            case 50:
                b1.F(this.f21925q, t10, t11, W);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (H(t11, V, i10)) {
                    j1.V(t10, W, j1.G(t11, W));
                    q0(t10, V, i10);
                    return;
                }
                return;
            case 60:
                O(t10, t11, i10);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (H(t11, V, i10)) {
                    j1.V(t10, W, j1.G(t11, W));
                    q0(t10, V, i10);
                    return;
                }
                return;
            case 68:
                O(t10, t11, i10);
                return;
            default:
                return;
        }
    }

    private Object Q(T t10, int i10) {
        z0 t11 = t(i10);
        long W = W(v0(i10));
        if (!A(t10, i10)) {
            return t11.newInstance();
        }
        Object object = f21908s.getObject(t10, W);
        if (F(object)) {
            return object;
        }
        Object newInstance = t11.newInstance();
        if (object != null) {
            t11.a(newInstance, object);
        }
        return newInstance;
    }

    private Object R(T t10, int i10, int i11) {
        z0 t11 = t(i11);
        if (!H(t10, i10, i11)) {
            return t11.newInstance();
        }
        Object object = f21908s.getObject(t10, W(v0(i11)));
        if (F(object)) {
            return object;
        }
        Object newInstance = t11.newInstance();
        if (object != null) {
            t11.a(newInstance, object);
        }
        return newInstance;
    }

    static <T> o0<T> S(Class<T> cls, j0 j0Var, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, o<?> oVar, g0 g0Var) {
        if (j0Var instanceof x0) {
            return U((x0) j0Var, q0Var, c0Var, f1Var, oVar, g0Var);
        }
        return T((d1) j0Var, q0Var, c0Var, f1Var, oVar, g0Var);
    }

    static <T> o0<T> T(d1 d1Var, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, o<?> oVar, g0 g0Var) {
        boolean z10;
        if (d1Var.c() == ProtoSyntax.PROTO3) {
            z10 = true;
        } else {
            z10 = false;
        }
        r[] e10 = d1Var.e();
        if (e10.length == 0) {
            int length = e10.length;
            int[] iArr = new int[(length * 3)];
            Object[] objArr = new Object[(length * 2)];
            if (e10.length <= 0) {
                int[] d10 = d1Var.d();
                if (d10 == null) {
                    d10 = f21907r;
                }
                if (e10.length <= 0) {
                    int[] iArr2 = f21907r;
                    int[] iArr3 = f21907r;
                    int[] iArr4 = new int[(d10.length + iArr2.length + iArr3.length)];
                    System.arraycopy(d10, 0, iArr4, 0, d10.length);
                    System.arraycopy(iArr2, 0, iArr4, d10.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d10.length + iArr2.length, iArr3.length);
                    return new o0(iArr, objArr, 0, 0, d1Var.b(), z10, true, iArr4, d10.length, d10.length + iArr2.length, q0Var, c0Var, f1Var, oVar, g0Var);
                }
                r rVar = e10[0];
                throw null;
            }
            r rVar2 = e10[0];
            throw null;
        }
        r rVar3 = e10[0];
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x036d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.protobuf.o0<T> U(com.google.protobuf.x0 r34, com.google.protobuf.q0 r35, com.google.protobuf.c0 r36, com.google.protobuf.f1<?, ?> r37, com.google.protobuf.o<?> r38, com.google.protobuf.g0 r39) {
        /*
            com.google.protobuf.ProtoSyntax r0 = r34.c()
            com.google.protobuf.ProtoSyntax r1 = com.google.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r34.e()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0028
            r4 = 1
        L_0x001e:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0029
            r4 = r6
            goto L_0x001e
        L_0x0028:
            r6 = 1
        L_0x0029:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0035:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0045
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0035
        L_0x0045:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0048:
            if (r6 != 0) goto L_0x0058
            int[] r6 = f21907r
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0162
        L_0x0058:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0077
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0064:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0074
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0064
        L_0x0074:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0077:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0096
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0083:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0093
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0083
        L_0x0093:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0096:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a2:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a2
        L_0x00b2:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b5:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c1:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c1
        L_0x00d1:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d4:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e0:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00f0
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e0
        L_0x00f0:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f3:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0112
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010f
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ff
        L_0x010f:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0112:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0133
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011e:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011e
        L_0x012f:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0133:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0156
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013f:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0151
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013f
        L_0x0151:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0156:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 * 2
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
        L_0x0162:
            sun.misc.Unsafe r15 = f21908s
            java.lang.Object[] r17 = r34.d()
            com.google.protobuf.l0 r18 = r34.b()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 * 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r20 = r14 + r12
            r22 = r14
            r23 = r20
            r12 = 0
            r21 = 0
        L_0x0181:
            if (r4 >= r1) goto L_0x03bd
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01a9
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0191:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a3
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0191
        L_0x01a3:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ab
        L_0x01a9:
            r3 = r24
        L_0x01ab:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01d8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01b9:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d2
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01b9
        L_0x01d2:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01dc
        L_0x01d8:
            r28 = r1
            r1 = r24
        L_0x01dc:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01e9
            int r14 = r12 + 1
            r13[r12] = r21
            r12 = r14
        L_0x01e9:
            r14 = 51
            r30 = r12
            if (r5 < r14) goto L_0x0286
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0218
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x01fe:
            int r33 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r12) goto L_0x0213
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r32
            r1 = r1 | r12
            int r32 = r32 + 13
            r14 = r33
            r12 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fe
        L_0x0213:
            int r12 = r14 << r32
            r1 = r1 | r12
            r14 = r33
        L_0x0218:
            int r12 = r5 + -51
            r32 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0238
            r14 = 17
            if (r12 != r14) goto L_0x0225
            goto L_0x0238
        L_0x0225:
            r14 = 12
            if (r12 != r14) goto L_0x0246
            if (r10 != 0) goto L_0x0246
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0244
        L_0x0238:
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0244:
            r16 = r14
        L_0x0246:
            int r1 = r1 * 2
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0251
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0259
        L_0x0251:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = o0(r2, r12)
            r17[r1] = r12
        L_0x0259:
            r14 = r8
            r33 = r9
            long r8 = r15.objectFieldOffset(r12)
            int r8 = (int) r8
            int r1 = r1 + 1
            r9 = r17[r1]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x026c
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0274
        L_0x026c:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = o0(r2, r9)
            r17[r1] = r9
        L_0x0274:
            r1 = r8
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r31 = r0
            r9 = r8
            r0 = r10
            r29 = r32
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0386
        L_0x0286:
            r14 = r8
            r33 = r9
            int r8 = r16 + 1
            r9 = r17[r16]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = o0(r2, r9)
            r12 = 9
            if (r5 == r12) goto L_0x02fe
            r12 = 17
            if (r5 != r12) goto L_0x029c
            goto L_0x02fe
        L_0x029c:
            r12 = 27
            if (r5 == r12) goto L_0x02ed
            r12 = 49
            if (r5 != r12) goto L_0x02a5
            goto L_0x02ed
        L_0x02a5:
            r12 = 12
            if (r5 == r12) goto L_0x02dc
            r12 = 30
            if (r5 == r12) goto L_0x02dc
            r12 = 44
            if (r5 != r12) goto L_0x02b2
            goto L_0x02dc
        L_0x02b2:
            r12 = 50
            if (r5 != r12) goto L_0x02d2
            int r12 = r22 + 1
            r13[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r22] = r8
            r8 = r3 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d5
            int r22 = r22 + 1
            int r8 = r27 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02d2:
            r25 = 1
            goto L_0x030c
        L_0x02d5:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x030d
        L_0x02dc:
            if (r10 != 0) goto L_0x02d2
            int r12 = r21 / 3
            int r12 = r12 * 2
            r25 = 1
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
            goto L_0x02fb
        L_0x02ed:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
        L_0x02fb:
            r12 = r27
            goto L_0x030d
        L_0x02fe:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            java.lang.Class r27 = r9.getType()
            r11[r12] = r27
        L_0x030c:
            r12 = r8
        L_0x030d:
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = r12
            r12 = 4096(0x1000, float:5.74E-42)
            if (r9 != r12) goto L_0x031d
            r9 = r25
            goto L_0x031e
        L_0x031d:
            r9 = 0
        L_0x031e:
            if (r9 == 0) goto L_0x036d
            r9 = 17
            if (r5 > r9) goto L_0x036d
            int r9 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0349
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x0333:
            int r29 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r12) goto L_0x0345
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r26
            r1 = r1 | r9
            int r26 = r26 + 13
            r9 = r29
            goto L_0x0333
        L_0x0345:
            int r9 = r9 << r26
            r1 = r1 | r9
            goto L_0x034b
        L_0x0349:
            r29 = r9
        L_0x034b:
            int r9 = r6 * 2
            int r26 = r1 / 32
            int r9 = r9 + r26
            r12 = r17[r9]
            r31 = r0
            boolean r0 = r12 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x035c
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0364
        L_0x035c:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = o0(r2, r12)
            r17[r9] = r12
        L_0x0364:
            r0 = r10
            long r9 = r15.objectFieldOffset(r12)
            int r9 = (int) r9
            int r1 = r1 % 32
            goto L_0x0376
        L_0x036d:
            r31 = r0
            r0 = r10
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r1
            r1 = 0
        L_0x0376:
            r10 = 18
            if (r5 < r10) goto L_0x0384
            r10 = 49
            if (r5 > r10) goto L_0x0384
            int r10 = r23 + 1
            r13[r23] = r8
            r23 = r10
        L_0x0384:
            r16 = r27
        L_0x0386:
            int r10 = r21 + 1
            r7[r21] = r4
            int r4 = r10 + 1
            r12 = r3 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0393
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0394
        L_0x0393:
            r12 = 0
        L_0x0394:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x039b
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039c
        L_0x039b:
            r3 = 0
        L_0x039c:
            r3 = r3 | r12
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r7[r10] = r3
            int r21 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r9
            r7[r4] = r1
            r10 = r0
            r8 = r14
            r14 = r24
            r1 = r28
            r4 = r29
            r12 = r30
            r0 = r31
            r9 = r33
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0181
        L_0x03bd:
            r33 = r9
            r0 = r10
            r24 = r14
            r14 = r8
            com.google.protobuf.o0 r1 = new com.google.protobuf.o0
            com.google.protobuf.l0 r9 = r34.b()
            r2 = 0
            r4 = r1
            r5 = r7
            r6 = r11
            r7 = r14
            r8 = r33
            r11 = r2
            r12 = r13
            r13 = r24
            r14 = r20
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.U(com.google.protobuf.x0, com.google.protobuf.q0, com.google.protobuf.c0, com.google.protobuf.f1, com.google.protobuf.o, com.google.protobuf.g0):com.google.protobuf.o0");
    }

    private int V(int i10) {
        return this.f21909a[i10];
    }

    private static long W(int i10) {
        return (long) (i10 & 1048575);
    }

    private static <T> boolean X(T t10, long j10) {
        return ((Boolean) j1.G(t10, j10)).booleanValue();
    }

    private static <T> double Y(T t10, long j10) {
        return ((Double) j1.G(t10, j10)).doubleValue();
    }

    private static <T> float Z(T t10, long j10) {
        return ((Float) j1.G(t10, j10)).floatValue();
    }

    private static <T> int a0(T t10, long j10) {
        return ((Integer) j1.G(t10, j10)).intValue();
    }

    private static <T> long b0(T t10, long j10) {
        return ((Long) j1.G(t10, j10)).longValue();
    }

    private <K, V> int c0(T t10, byte[] bArr, int i10, int i11, int i12, long j10, e.b bVar) throws IOException {
        T t11 = t10;
        long j11 = j10;
        Unsafe unsafe = f21908s;
        int i13 = i12;
        Object s10 = s(i12);
        Object object = unsafe.getObject(t10, j11);
        if (this.f21925q.h(object)) {
            Object d10 = this.f21925q.d(s10);
            this.f21925q.a(d10, object);
            unsafe.putObject(t10, j11, d10);
            object = d10;
        }
        return k(bArr, i10, i11, this.f21925q.b(s10), this.f21925q.c(object), bVar);
    }

    private int d0(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, e.b bVar) throws IOException {
        T t11 = t10;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i12;
        int i20 = i13;
        int i21 = i14;
        long j11 = j10;
        int i22 = i17;
        e.b bVar2 = bVar;
        Unsafe unsafe = f21908s;
        long j12 = (long) (this.f21909a[i22 + 2] & 1048575);
        switch (i16) {
            case 51:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Double.valueOf(e.d(bArr, i10)));
                    int i23 = i18 + 8;
                    unsafe.putInt(t11, j12, i20);
                    return i23;
                }
                break;
            case 52:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Float.valueOf(e.l(bArr, i10)));
                    int i24 = i18 + 4;
                    unsafe.putInt(t11, j12, i20);
                    return i24;
                }
                break;
            case 53:
            case 54:
                if (i21 == 0) {
                    int L = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Long.valueOf(bVar2.f21785b));
                    unsafe.putInt(t11, j12, i20);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i21 == 0) {
                    int I = e.I(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Integer.valueOf(bVar2.f21784a));
                    unsafe.putInt(t11, j12, i20);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Long.valueOf(e.j(bArr, i10)));
                    int i25 = i18 + 8;
                    unsafe.putInt(t11, j12, i20);
                    return i25;
                }
                break;
            case 57:
            case 64:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Integer.valueOf(e.h(bArr, i10)));
                    int i26 = i18 + 4;
                    unsafe.putInt(t11, j12, i20);
                    return i26;
                }
                break;
            case 58:
                if (i21 == 0) {
                    int L2 = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Boolean.valueOf(bVar2.f21785b != 0));
                    unsafe.putInt(t11, j12, i20);
                    return L2;
                }
                break;
            case 59:
                if (i21 == 2) {
                    int I2 = e.I(bArr2, i18, bVar2);
                    int i27 = bVar2.f21784a;
                    if (i27 == 0) {
                        unsafe.putObject(t11, j11, "");
                    } else if ((i15 & 536870912) == 0 || Utf8.t(bArr2, I2, I2 + i27)) {
                        unsafe.putObject(t11, j11, new String(bArr2, I2, i27, w.f21953b));
                        I2 += i27;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                    unsafe.putInt(t11, j12, i20);
                    return I2;
                }
                break;
            case 60:
                if (i21 == 2) {
                    Object R = R(t11, i20, i22);
                    int O = e.O(R, t(i22), bArr, i10, i11, bVar);
                    t0(t11, i20, i22, R);
                    return O;
                }
                break;
            case 61:
                if (i21 == 2) {
                    int b10 = e.b(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, bVar2.f21786c);
                    unsafe.putInt(t11, j12, i20);
                    return b10;
                }
                break;
            case 63:
                if (i21 == 0) {
                    int I3 = e.I(bArr2, i18, bVar2);
                    int i28 = bVar2.f21784a;
                    w.e r10 = r(i22);
                    if (r10 == null || r10.isInRange(i28)) {
                        unsafe.putObject(t11, j11, Integer.valueOf(i28));
                        unsafe.putInt(t11, j12, i20);
                    } else {
                        u(t10).r(i19, Long.valueOf((long) i28));
                    }
                    return I3;
                }
                break;
            case 66:
                if (i21 == 0) {
                    int I4 = e.I(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Integer.valueOf(h.b(bVar2.f21784a)));
                    unsafe.putInt(t11, j12, i20);
                    return I4;
                }
                break;
            case 67:
                if (i21 == 0) {
                    int L3 = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Long.valueOf(h.c(bVar2.f21785b)));
                    unsafe.putInt(t11, j12, i20);
                    return L3;
                }
                break;
            case 68:
                if (i21 == 3) {
                    Object R2 = R(t11, i20, i22);
                    int N = e.N(R2, t(i22), bArr, i10, i11, (i19 & -8) | 4, bVar);
                    t0(t11, i20, i22, R2);
                    return N;
                }
                break;
        }
        return i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x029b, code lost:
        if (r0 != r15) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02be, code lost:
        if (r0 != r15) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02c1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        r13 = r19;
        r19 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018f, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a4, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b6, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b9, code lost:
        r2 = r4;
        r28 = r10;
        r20 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0252, code lost:
        if (r0 != r15) goto L_0x0254;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int f0(T r31, byte[] r32, int r33, int r34, com.google.protobuf.e.b r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            j(r31)
            sun.misc.Unsafe r9 = f21908s
            r10 = -1
            r16 = 0
            r0 = r33
            r1 = r10
            r2 = r16
            r6 = r2
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001b:
            if (r0 >= r13) goto L_0x02e7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.protobuf.e.H(r0, r12, r3, r11)
            int r3 = r11.f21784a
            r4 = r0
            r17 = r3
            goto L_0x0030
        L_0x002d:
            r17 = r0
            r4 = r3
        L_0x0030:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003d
            int r2 = r2 / 3
            int r0 = r15.i0(r5, r2)
            goto L_0x0041
        L_0x003d:
            int r0 = r15.h0(r5)
        L_0x0041:
            r2 = r0
            if (r2 != r10) goto L_0x004f
            r2 = r4
            r19 = r5
            r28 = r9
            r18 = r10
            r20 = r16
            goto L_0x02c3
        L_0x004f:
            int[] r0 = r15.f21909a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = u0(r1)
            r18 = r9
            long r8 = W(r1)
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x01c2
            int[] r10 = r15.f21909a
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            r23 = r1
            r19 = r2
            if (r10 == r7) goto L_0x0093
            if (r7 == r13) goto L_0x0083
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0085
        L_0x0083:
            r7 = r18
        L_0x0085:
            if (r10 == r13) goto L_0x008d
            long r1 = (long) r10
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008d:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0095
        L_0x0093:
            r10 = r18
        L_0x0095:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x0197;
                case 2: goto L_0x017c;
                case 3: goto L_0x017c;
                case 4: goto L_0x016c;
                case 5: goto L_0x0155;
                case 6: goto L_0x0147;
                case 7: goto L_0x012d;
                case 8: goto L_0x0110;
                case 9: goto L_0x00f0;
                case 10: goto L_0x00de;
                case 11: goto L_0x016c;
                case 12: goto L_0x00cd;
                case 13: goto L_0x0147;
                case 14: goto L_0x0155;
                case 15: goto L_0x00b8;
                case 16: goto L_0x009f;
                default: goto L_0x0099;
            }
        L_0x0099:
            r13 = r19
            r19 = r33
            goto L_0x01b9
        L_0x009f:
            if (r3 != 0) goto L_0x0099
            int r17 = com.google.protobuf.e.L(r12, r4, r11)
            long r0 = r11.f21785b
            long r4 = com.google.protobuf.h.c(r0)
            r0 = r10
            r1 = r31
            r13 = r19
            r2 = r8
            r19 = r33
            r0.putLong(r1, r2, r4)
            goto L_0x018f
        L_0x00b8:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01b9
            int r0 = com.google.protobuf.e.I(r12, r4, r11)
            int r1 = r11.f21784a
            int r1 = com.google.protobuf.h.b(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x01b6
        L_0x00cd:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01b9
            int r0 = com.google.protobuf.e.I(r12, r4, r11)
            int r1 = r11.f21784a
            r10.putInt(r14, r8, r1)
            goto L_0x01b6
        L_0x00de:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x01b9
            int r0 = com.google.protobuf.e.b(r12, r4, r11)
            java.lang.Object r1 = r11.f21786c
            r10.putObject(r14, r8, r1)
            goto L_0x01b6
        L_0x00f0:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x01b9
            java.lang.Object r8 = r15.Q(r14, r13)
            com.google.protobuf.z0 r1 = r15.t(r13)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = com.google.protobuf.e.O(r0, r1, r2, r3, r4, r5)
            r15.s0(r14, r13, r8)
            goto L_0x01b6
        L_0x0110:
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x01b9
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0122
            int r0 = com.google.protobuf.e.C(r12, r4, r11)
            goto L_0x0126
        L_0x0122:
            int r0 = com.google.protobuf.e.F(r12, r4, r11)
        L_0x0126:
            java.lang.Object r1 = r11.f21786c
            r10.putObject(r14, r8, r1)
            goto L_0x01b6
        L_0x012d:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01b9
            int r0 = com.google.protobuf.e.L(r12, r4, r11)
            long r1 = r11.f21785b
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0140
            goto L_0x0142
        L_0x0140:
            r5 = r16
        L_0x0142:
            com.google.protobuf.j1.L(r14, r8, r5)
            goto L_0x01b6
        L_0x0147:
            r13 = r19
            r19 = r33
            if (r3 != r1) goto L_0x01b9
            int r0 = com.google.protobuf.e.h(r12, r4)
            r10.putInt(r14, r8, r0)
            goto L_0x01a4
        L_0x0155:
            r13 = r19
            r19 = r33
            if (r3 != r5) goto L_0x01b9
            long r22 = com.google.protobuf.e.j(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x01b6
        L_0x016c:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01b9
            int r0 = com.google.protobuf.e.I(r12, r4, r11)
            int r1 = r11.f21784a
            r10.putInt(r14, r8, r1)
            goto L_0x01b6
        L_0x017c:
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x01b9
            int r17 = com.google.protobuf.e.L(r12, r4, r11)
            long r4 = r11.f21785b
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
        L_0x018f:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x0204
        L_0x0197:
            r13 = r19
            r19 = r33
            if (r3 != r1) goto L_0x01b9
            float r0 = com.google.protobuf.e.l(r12, r4)
            com.google.protobuf.j1.S(r14, r8, r0)
        L_0x01a4:
            int r0 = r4 + 4
            goto L_0x01b6
        L_0x01a7:
            r13 = r19
            r19 = r33
            if (r3 != r5) goto L_0x01b9
            double r0 = com.google.protobuf.e.d(r12, r4)
            com.google.protobuf.j1.R(r14, r8, r0)
            int r0 = r4 + 8
        L_0x01b6:
            r6 = r6 | r21
            goto L_0x0202
        L_0x01b9:
            r2 = r4
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x02c3
        L_0x01c2:
            r19 = r33
            r23 = r1
            r13 = r2
            r10 = r18
            r1 = 27
            if (r0 != r1) goto L_0x0218
            r1 = 2
            if (r3 != r1) goto L_0x020b
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.protobuf.w$j r0 = (com.google.protobuf.w.j) r0
            boolean r1 = r0.h()
            if (r1 != 0) goto L_0x01ee
            int r1 = r0.size()
            if (r1 != 0) goto L_0x01e5
            r1 = 10
            goto L_0x01e7
        L_0x01e5:
            int r1 = r1 * 2
        L_0x01e7:
            com.google.protobuf.w$j r0 = r0.a(r1)
            r10.putObject(r14, r8, r0)
        L_0x01ee:
            r5 = r0
            com.google.protobuf.z0 r0 = r15.t(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0202:
            r9 = r10
            r2 = r13
        L_0x0204:
            r1 = r19
            r10 = -1
            r13 = r34
            goto L_0x001b
        L_0x020b:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r20 = r13
            r18 = -1
            goto L_0x029e
        L_0x0218:
            r1 = 49
            if (r0 > r1) goto L_0x026a
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r19
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r20 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.g0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02c1
        L_0x0254:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r1 = r19
            r2 = r20
            r6 = r24
            r7 = r25
            goto L_0x02e3
        L_0x026a:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r20 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02a4
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x029e
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r20
            r6 = r26
            r8 = r35
            int r0 = r0.c0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02c1
            goto L_0x0254
        L_0x029e:
            r2 = r15
        L_0x029f:
            r6 = r24
            r7 = r25
            goto L_0x02c3
        L_0x02a4:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r19
            r10 = r26
            r12 = r20
            r13 = r35
            int r0 = r0.d0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02c1
            goto L_0x0254
        L_0x02c1:
            r2 = r0
            goto L_0x029f
        L_0x02c3:
            com.google.protobuf.g1 r4 = u(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.protobuf.e.G(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r1 = r19
            r2 = r20
        L_0x02e3:
            r9 = r28
            goto L_0x001b
        L_0x02e7:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x02fa
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x02fa:
            r1 = r34
            if (r0 != r1) goto L_0x02ff
            return r0
        L_0x02ff:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.f0(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):int");
    }

    private int g0(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, e.b bVar) throws IOException {
        int i17;
        T t11 = t10;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i14;
        int i20 = i15;
        long j12 = j11;
        e.b bVar2 = bVar;
        Unsafe unsafe = f21908s;
        w.j jVar = (w.j) unsafe.getObject(t10, j12);
        if (!jVar.h()) {
            int size = jVar.size();
            jVar = jVar.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(t10, j12, jVar);
        }
        switch (i16) {
            case 18:
            case 35:
                if (i19 == 2) {
                    return e.s(bArr, i18, jVar, bVar2);
                }
                if (i19 == 1) {
                    return e.e(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 19:
            case 36:
                if (i19 == 2) {
                    return e.v(bArr, i18, jVar, bVar2);
                }
                if (i19 == 5) {
                    return e.m(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i19 == 2) {
                    return e.z(bArr, i18, jVar, bVar2);
                }
                if (i19 == 0) {
                    return e.M(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i19 == 2) {
                    return e.y(bArr, i18, jVar, bVar2);
                }
                if (i19 == 0) {
                    return e.J(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i19 == 2) {
                    return e.u(bArr, i18, jVar, bVar2);
                }
                if (i19 == 1) {
                    return e.k(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i19 == 2) {
                    return e.t(bArr, i18, jVar, bVar2);
                }
                if (i19 == 5) {
                    return e.i(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 25:
            case 42:
                if (i19 == 2) {
                    return e.r(bArr, i18, jVar, bVar2);
                }
                if (i19 == 0) {
                    return e.a(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 26:
                if (i19 == 2) {
                    if ((j10 & 536870912) == 0) {
                        return e.D(i12, bArr, i10, i11, jVar, bVar);
                    }
                    return e.E(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 27:
                if (i19 == 2) {
                    return e.q(t(i20), i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 28:
                if (i19 == 2) {
                    return e.c(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 30:
            case 44:
                if (i19 == 2) {
                    i17 = e.y(bArr, i18, jVar, bVar2);
                } else if (i19 == 0) {
                    i17 = e.J(i12, bArr, i10, i11, jVar, bVar);
                }
                b1.A(t10, i13, jVar, r(i20), null, this.f21923o);
                return i17;
            case 33:
            case 47:
                if (i19 == 2) {
                    return e.w(bArr, i18, jVar, bVar2);
                }
                if (i19 == 0) {
                    return e.A(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 34:
            case 48:
                if (i19 == 2) {
                    return e.x(bArr, i18, jVar, bVar2);
                }
                if (i19 == 0) {
                    return e.B(i12, bArr, i10, i11, jVar, bVar);
                }
                break;
            case 49:
                if (i19 == 3) {
                    return e.o(t(i20), i12, bArr, i10, i11, jVar, bVar);
                }
                break;
        }
        return i18;
    }

    private boolean h(T t10, T t11, int i10) {
        return A(t10, i10) == A(t11, i10);
    }

    private int h0(int i10) {
        if (i10 < this.f21911c || i10 > this.f21912d) {
            return -1;
        }
        return r0(i10, 0);
    }

    private static <T> boolean i(T t10, long j10) {
        return j1.t(t10, j10);
    }

    private int i0(int i10, int i11) {
        if (i10 < this.f21911c || i10 > this.f21912d) {
            return -1;
        }
        return r0(i10, i11);
    }

    private static void j(Object obj) {
        if (!F(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    private int j0(int i10) {
        return this.f21909a[i10 + 2];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [int, byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int k(byte[] r15, int r16, int r17, com.google.protobuf.f0.a<K, V> r18, java.util.Map<K, V> r19, com.google.protobuf.e.b r20) throws java.io.IOException {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = com.google.protobuf.e.I(r15, r0, r10)
            int r1 = r10.f21784a
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            K r1 = r9.f21799b
            V r2 = r9.f21801d
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.protobuf.e.H(r0, r15, r1, r10)
            int r1 = r10.f21784a
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            com.google.protobuf.WireFormat$FieldType r1 = r9.f21800c
            int r1 = r1.c()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.f21800c
            V r0 = r9.f21801d
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.l(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.f21786c
            goto L_0x001d
        L_0x0057:
            com.google.protobuf.WireFormat$FieldType r1 = r9.f21798a
            int r1 = r1.c()
            if (r3 != r1) goto L_0x006f
            com.google.protobuf.WireFormat$FieldType r4 = r9.f21798a
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.l(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.f21786c
            goto L_0x001d
        L_0x006f:
            int r0 = com.google.protobuf.e.P(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r0
        L_0x0081:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.m()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.k(byte[], int, int, com.google.protobuf.f0$a, java.util.Map, com.google.protobuf.e$b):int");
    }

    private <E> void k0(Object obj, long j10, y0 y0Var, z0<E> z0Var, n nVar) throws IOException {
        y0Var.J(this.f21922n.e(obj, j10), z0Var, nVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int l(byte[] r2, int r3, int r4, com.google.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, com.google.protobuf.e.b r7) throws java.io.IOException {
        /*
            r1 = this;
            int[] r0 = com.google.protobuf.o0.a.f21926a
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "unsupported field type."
            r2.<init>(r3)
            throw r2
        L_0x0013:
            int r2 = com.google.protobuf.e.F(r2, r3, r7)
            goto L_0x00ae
        L_0x0019:
            int r2 = com.google.protobuf.e.L(r2, r3, r7)
            long r3 = r7.f21785b
            long r3 = com.google.protobuf.h.c(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.f21786c = r3
            goto L_0x00ae
        L_0x002b:
            int r2 = com.google.protobuf.e.I(r2, r3, r7)
            int r3 = r7.f21784a
            int r3 = com.google.protobuf.h.b(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.f21786c = r3
            goto L_0x00ae
        L_0x003d:
            com.google.protobuf.v0 r5 = com.google.protobuf.v0.a()
            com.google.protobuf.z0 r5 = r5.c(r6)
            int r2 = com.google.protobuf.e.p(r5, r2, r3, r4, r7)
            goto L_0x00ae
        L_0x004a:
            int r2 = com.google.protobuf.e.L(r2, r3, r7)
            long r3 = r7.f21785b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.f21786c = r3
            goto L_0x00ae
        L_0x0057:
            int r2 = com.google.protobuf.e.I(r2, r3, r7)
            int r3 = r7.f21784a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.f21786c = r3
            goto L_0x00ae
        L_0x0064:
            float r2 = com.google.protobuf.e.l(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r7.f21786c = r2
            goto L_0x0084
        L_0x006f:
            long r4 = com.google.protobuf.e.j(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r7.f21786c = r2
            goto L_0x0091
        L_0x007a:
            int r2 = com.google.protobuf.e.h(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.f21786c = r2
        L_0x0084:
            int r2 = r3 + 4
            goto L_0x00ae
        L_0x0087:
            double r4 = com.google.protobuf.e.d(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r7.f21786c = r2
        L_0x0091:
            int r2 = r3 + 8
            goto L_0x00ae
        L_0x0094:
            int r2 = com.google.protobuf.e.b(r2, r3, r7)
            goto L_0x00ae
        L_0x0099:
            int r2 = com.google.protobuf.e.L(r2, r3, r7)
            long r3 = r7.f21785b
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00a7
            r3 = 1
            goto L_0x00a8
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r7.f21786c = r3
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.l(byte[], int, int, com.google.protobuf.WireFormat$FieldType, java.lang.Class, com.google.protobuf.e$b):int");
    }

    private <E> void l0(Object obj, int i10, y0 y0Var, z0<E> z0Var, n nVar) throws IOException {
        y0Var.K(this.f21922n.e(obj, W(i10)), z0Var, nVar);
    }

    private static <T> double m(T t10, long j10) {
        return j1.A(t10, j10);
    }

    private void m0(Object obj, int i10, y0 y0Var) throws IOException {
        if (z(i10)) {
            j1.V(obj, W(i10), y0Var.I());
        } else if (this.f21915g) {
            j1.V(obj, W(i10), y0Var.z());
        } else {
            j1.V(obj, W(i10), y0Var.o());
        }
    }

    private boolean n(T t10, T t11, int i10) {
        int v02 = v0(i10);
        long W = W(v02);
        switch (u0(v02)) {
            case 0:
                if (!h(t10, t11, i10) || Double.doubleToLongBits(j1.A(t10, W)) != Double.doubleToLongBits(j1.A(t11, W))) {
                    return false;
                }
                return true;
            case 1:
                if (!h(t10, t11, i10) || Float.floatToIntBits(j1.B(t10, W)) != Float.floatToIntBits(j1.B(t11, W))) {
                    return false;
                }
                return true;
            case 2:
                if (!h(t10, t11, i10) || j1.E(t10, W) != j1.E(t11, W)) {
                    return false;
                }
                return true;
            case 3:
                if (!h(t10, t11, i10) || j1.E(t10, W) != j1.E(t11, W)) {
                    return false;
                }
                return true;
            case 4:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 5:
                if (!h(t10, t11, i10) || j1.E(t10, W) != j1.E(t11, W)) {
                    return false;
                }
                return true;
            case 6:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 7:
                if (!h(t10, t11, i10) || j1.t(t10, W) != j1.t(t11, W)) {
                    return false;
                }
                return true;
            case 8:
                if (!h(t10, t11, i10) || !b1.K(j1.G(t10, W), j1.G(t11, W))) {
                    return false;
                }
                return true;
            case 9:
                if (!h(t10, t11, i10) || !b1.K(j1.G(t10, W), j1.G(t11, W))) {
                    return false;
                }
                return true;
            case 10:
                if (!h(t10, t11, i10) || !b1.K(j1.G(t10, W), j1.G(t11, W))) {
                    return false;
                }
                return true;
            case 11:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 12:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 13:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 14:
                if (!h(t10, t11, i10) || j1.E(t10, W) != j1.E(t11, W)) {
                    return false;
                }
                return true;
            case 15:
                if (!h(t10, t11, i10) || j1.C(t10, W) != j1.C(t11, W)) {
                    return false;
                }
                return true;
            case 16:
                if (!h(t10, t11, i10) || j1.E(t10, W) != j1.E(t11, W)) {
                    return false;
                }
                return true;
            case 17:
                if (!h(t10, t11, i10) || !b1.K(j1.G(t10, W), j1.G(t11, W))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return b1.K(j1.G(t10, W), j1.G(t11, W));
            case 50:
                return b1.K(j1.G(t10, W), j1.G(t11, W));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!G(t10, t11, i10) || !b1.K(j1.G(t10, W), j1.G(t11, W))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void n0(Object obj, int i10, y0 y0Var) throws IOException {
        if (z(i10)) {
            y0Var.n(this.f21922n.e(obj, W(i10)));
        } else {
            y0Var.B(this.f21922n.e(obj, W(i10)));
        }
    }

    private <UT, UB> UB o(Object obj, int i10, UB ub2, f1<UT, UB> f1Var, Object obj2) {
        w.e r10;
        int V = V(i10);
        Object G = j1.G(obj, W(v0(i10)));
        if (G == null || (r10 = r(i10)) == null) {
            return ub2;
        }
        return p(i10, V, this.f21925q.c(G), r10, ub2, f1Var, obj2);
    }

    private static Field o0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private <K, V, UT, UB> UB p(int i10, int i11, Map<K, V> map, w.e eVar, UB ub2, f1<UT, UB> f1Var, Object obj) {
        f0.a<?, ?> b10 = this.f21925q.b(s(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = f1Var.f(obj);
                }
                ByteString.g C = ByteString.C(f0.b(b10, next.getKey(), next.getValue()));
                try {
                    f0.e(C.b(), b10, next.getKey(), next.getValue());
                    f1Var.d(ub2, i11, C.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private void p0(T t10, int i10) {
        int j02 = j0(i10);
        long j10 = (long) (1048575 & j02);
        if (j10 != 1048575) {
            j1.T(t10, j10, (1 << (j02 >>> 20)) | j1.C(t10, j10));
        }
    }

    private static <T> float q(T t10, long j10) {
        return j1.B(t10, j10);
    }

    private void q0(T t10, int i10, int i11) {
        j1.T(t10, (long) (j0(i11) & 1048575), i10);
    }

    private w.e r(int i10) {
        return (w.e) this.f21910b[((i10 / 3) * 2) + 1];
    }

    private int r0(int i10, int i11) {
        int length = (this.f21909a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int V = V(i13);
            if (i10 == V) {
                return i13;
            }
            if (i10 < V) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private Object s(int i10) {
        return this.f21910b[(i10 / 3) * 2];
    }

    private void s0(T t10, int i10, Object obj) {
        f21908s.putObject(t10, W(v0(i10)), obj);
        p0(t10, i10);
    }

    private z0 t(int i10) {
        int i11 = (i10 / 3) * 2;
        z0 z0Var = (z0) this.f21910b[i11];
        if (z0Var != null) {
            return z0Var;
        }
        z0 c10 = v0.a().c((Class) this.f21910b[i11 + 1]);
        this.f21910b[i11] = c10;
        return c10;
    }

    private void t0(T t10, int i10, int i11, Object obj) {
        f21908s.putObject(t10, W(v0(i11)), obj);
        q0(t10, i10, i11);
    }

    static g1 u(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        g1 g1Var = generatedMessageLite.unknownFields;
        if (g1Var != g1.c()) {
            return g1Var;
        }
        g1 o10 = g1.o();
        generatedMessageLite.unknownFields = o10;
        return o10;
    }

    private static int u0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0344, code lost:
        r4 = (r4 + r9) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0410, code lost:
        r6 = r6 + r3;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0462, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0519, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int v(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = f21908s
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r3
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x000d:
            int[] r9 = r0.f21909a
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0520
            int r9 = r0.v0(r5)
            int r10 = r0.V(r5)
            int r11 = u0(r9)
            r12 = 17
            r13 = 1
            if (r11 > r12) goto L_0x0038
            int[] r12 = r0.f21909a
            int r14 = r5 + 2
            r12 = r12[r14]
            r14 = r12 & r3
            int r15 = r12 >>> 20
            int r15 = r13 << r15
            if (r14 == r7) goto L_0x0056
            long r7 = (long) r14
            int r8 = r2.getInt(r1, r7)
            r7 = r14
            goto L_0x0056
        L_0x0038:
            boolean r12 = r0.f21917i
            if (r12 == 0) goto L_0x0054
            com.google.protobuf.FieldType r12 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r12 = r12.b()
            if (r11 < r12) goto L_0x0054
            com.google.protobuf.FieldType r12 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r12 = r12.b()
            if (r11 > r12) goto L_0x0054
            int[] r12 = r0.f21909a
            int r14 = r5 + 2
            r12 = r12[r14]
            r12 = r12 & r3
            goto L_0x0055
        L_0x0054:
            r12 = 0
        L_0x0055:
            r15 = 0
        L_0x0056:
            long r13 = W(r9)
            r9 = 0
            r3 = 0
            switch(r11) {
                case 0: goto L_0x050d;
                case 1: goto L_0x0503;
                case 2: goto L_0x04f5;
                case 3: goto L_0x04e7;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04cf;
                case 6: goto L_0x04c5;
                case 7: goto L_0x04ba;
                case 8: goto L_0x049e;
                case 9: goto L_0x048d;
                case 10: goto L_0x047e;
                case 11: goto L_0x0471;
                case 12: goto L_0x0464;
                case 13: goto L_0x0459;
                case 14: goto L_0x0450;
                case 15: goto L_0x0443;
                case 16: goto L_0x0436;
                case 17: goto L_0x0423;
                case 18: goto L_0x0414;
                case 19: goto L_0x0405;
                case 20: goto L_0x03f9;
                case 21: goto L_0x03ed;
                case 22: goto L_0x03e1;
                case 23: goto L_0x03d5;
                case 24: goto L_0x03c9;
                case 25: goto L_0x03bd;
                case 26: goto L_0x03b2;
                case 27: goto L_0x03a2;
                case 28: goto L_0x0396;
                case 29: goto L_0x0389;
                case 30: goto L_0x037c;
                case 31: goto L_0x036f;
                case 32: goto L_0x0362;
                case 33: goto L_0x0355;
                case 34: goto L_0x0348;
                case 35: goto L_0x0328;
                case 36: goto L_0x030b;
                case 37: goto L_0x02ee;
                case 38: goto L_0x02d1;
                case 39: goto L_0x02b3;
                case 40: goto L_0x0295;
                case 41: goto L_0x0277;
                case 42: goto L_0x0259;
                case 43: goto L_0x023b;
                case 44: goto L_0x021d;
                case 45: goto L_0x01ff;
                case 46: goto L_0x01e1;
                case 47: goto L_0x01c3;
                case 48: goto L_0x01a5;
                case 49: goto L_0x0195;
                case 50: goto L_0x0185;
                case 51: goto L_0x0177;
                case 52: goto L_0x016b;
                case 53: goto L_0x015b;
                case 54: goto L_0x014b;
                case 55: goto L_0x013b;
                case 56: goto L_0x012f;
                case 57: goto L_0x0122;
                case 58: goto L_0x0115;
                case 59: goto L_0x00f7;
                case 60: goto L_0x00e3;
                case 61: goto L_0x00d1;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00b1;
                case 64: goto L_0x00a4;
                case 65: goto L_0x0098;
                case 66: goto L_0x0088;
                case 67: goto L_0x0078;
                case 68: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0420
        L_0x0062:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.l0 r3 = (com.google.protobuf.l0) r3
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.CodedOutputStream.t(r10, r3, r4)
            goto L_0x041f
        L_0x0078:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = b0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.R(r10, r3)
            goto L_0x041f
        L_0x0088:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = a0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.P(r10, r3)
            goto L_0x041f
        L_0x0098:
            boolean r9 = r0.H(r1, r10, r5)
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.protobuf.CodedOutputStream.N(r10, r3)
            goto L_0x041f
        L_0x00a4:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.L(r10, r3)
            goto L_0x0462
        L_0x00b1:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = a0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.l(r10, r3)
            goto L_0x041f
        L_0x00c1:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = a0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.W(r10, r3)
            goto L_0x041f
        L_0x00d1:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.h(r10, r3)
            goto L_0x041f
        L_0x00e3:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.b1.o(r10, r3, r4)
            goto L_0x041f
        L_0x00f7:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x010d
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.h(r10, r3)
            goto L_0x041f
        L_0x010d:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.T(r10, r3)
            goto L_0x041f
        L_0x0115:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.e(r10, r3)
            goto L_0x041f
        L_0x0122:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.n(r10, r3)
            goto L_0x0462
        L_0x012f:
            boolean r9 = r0.H(r1, r10, r5)
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.protobuf.CodedOutputStream.p(r10, r3)
            goto L_0x041f
        L_0x013b:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = a0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.w(r10, r3)
            goto L_0x041f
        L_0x014b:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = b0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.Y(r10, r3)
            goto L_0x041f
        L_0x015b:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = b0(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.y(r10, r3)
            goto L_0x041f
        L_0x016b:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = com.google.protobuf.CodedOutputStream.r(r10, r9)
            goto L_0x041f
        L_0x0177:
            boolean r3 = r0.H(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.j(r10, r3)
            goto L_0x041f
        L_0x0185:
            com.google.protobuf.g0 r3 = r0.f21925q
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.lang.Object r9 = r0.s(r5)
            int r3 = r3.g(r10, r4, r9)
            goto L_0x041f
        L_0x0195:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.b1.j(r10, r3, r4)
            goto L_0x041f
        L_0x01a5:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.t(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x01b9
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01b9:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x01c3:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.r(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x01d7
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01d7:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x01e1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x01f5
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01f5:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x01ff:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x0213
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0213:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x021d:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.e(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x0231
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0231:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x023b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.w(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x024f
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x024f:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x0259:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.b(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x026d
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x026d:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x0277:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x028b
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x028b:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x0295:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x02a9
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02a9:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x02b3:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.l(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x02c7
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02c7:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x02d1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.y(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x02e5
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02e5:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x02ee:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.n(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x0302
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0302:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x030b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x031f
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x031f:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
            goto L_0x0344
        L_0x0328:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.f21917i
            if (r4 == 0) goto L_0x033c
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x033c:
            int r4 = com.google.protobuf.CodedOutputStream.V(r10)
            int r9 = com.google.protobuf.CodedOutputStream.X(r3)
        L_0x0344:
            int r4 = r4 + r9
            int r4 = r4 + r3
            goto L_0x0462
        L_0x0348:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.b1.s(r10, r3, r4)
            goto L_0x0410
        L_0x0355:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.q(r10, r3, r4)
            goto L_0x0410
        L_0x0362:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.h(r10, r3, r4)
            goto L_0x0410
        L_0x036f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.f(r10, r3, r4)
            goto L_0x0410
        L_0x037c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.d(r10, r3, r4)
            goto L_0x0410
        L_0x0389:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.v(r10, r3, r4)
            goto L_0x041f
        L_0x0396:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.c(r10, r3)
            goto L_0x041f
        L_0x03a2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.b1.p(r10, r3, r4)
            goto L_0x041f
        L_0x03b2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.u(r10, r3)
            goto L_0x041f
        L_0x03bd:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.protobuf.b1.a(r10, r3, r4)
            goto L_0x0410
        L_0x03c9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.f(r10, r3, r4)
            goto L_0x0410
        L_0x03d5:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.h(r10, r3, r4)
            goto L_0x0410
        L_0x03e1:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.k(r10, r3, r4)
            goto L_0x0410
        L_0x03ed:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.x(r10, r3, r4)
            goto L_0x0410
        L_0x03f9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.m(r10, r3, r4)
            goto L_0x0410
        L_0x0405:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.f(r10, r3, r4)
        L_0x0410:
            int r6 = r6 + r3
            r11 = r4
            goto L_0x0519
        L_0x0414:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.protobuf.b1.h(r10, r3, r4)
        L_0x041f:
            int r6 = r6 + r3
        L_0x0420:
            r11 = 0
            goto L_0x0519
        L_0x0423:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.l0 r3 = (com.google.protobuf.l0) r3
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.CodedOutputStream.t(r10, r3, r4)
            goto L_0x041f
        L_0x0436:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.R(r10, r3)
            goto L_0x041f
        L_0x0443:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.P(r10, r3)
            goto L_0x041f
        L_0x0450:
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.protobuf.CodedOutputStream.N(r10, r3)
            goto L_0x041f
        L_0x0459:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.protobuf.CodedOutputStream.L(r10, r3)
        L_0x0462:
            int r6 = r6 + r4
            goto L_0x0420
        L_0x0464:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.l(r10, r3)
            goto L_0x041f
        L_0x0471:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.W(r10, r3)
            goto L_0x041f
        L_0x047e:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.h(r10, r3)
            goto L_0x041f
        L_0x048d:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.protobuf.z0 r4 = r0.t(r5)
            int r3 = com.google.protobuf.b1.o(r10, r3, r4)
            goto L_0x041f
        L_0x049e:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.protobuf.ByteString
            if (r4 == 0) goto L_0x04b2
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            int r3 = com.google.protobuf.CodedOutputStream.h(r10, r3)
            goto L_0x041f
        L_0x04b2:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.protobuf.CodedOutputStream.T(r10, r3)
            goto L_0x041f
        L_0x04ba:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r3 = 1
            int r3 = com.google.protobuf.CodedOutputStream.e(r10, r3)
            goto L_0x041f
        L_0x04c5:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r11 = 0
            int r3 = com.google.protobuf.CodedOutputStream.n(r10, r11)
            goto L_0x0518
        L_0x04cf:
            r11 = 0
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0519
            int r3 = com.google.protobuf.CodedOutputStream.p(r10, r3)
            goto L_0x0518
        L_0x04d9:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.w(r10, r3)
            goto L_0x0518
        L_0x04e7:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.Y(r10, r3)
            goto L_0x0518
        L_0x04f5:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.protobuf.CodedOutputStream.y(r10, r3)
            goto L_0x0518
        L_0x0503:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            int r3 = com.google.protobuf.CodedOutputStream.r(r10, r9)
            goto L_0x0518
        L_0x050d:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            r3 = 0
            int r3 = com.google.protobuf.CodedOutputStream.j(r10, r3)
        L_0x0518:
            int r6 = r6 + r3
        L_0x0519:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x0520:
            com.google.protobuf.f1<?, ?> r2 = r0.f21923o
            int r2 = r0.x(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f21914f
            if (r2 == 0) goto L_0x0536
            com.google.protobuf.o<?> r2 = r0.f21924p
            com.google.protobuf.s r1 = r2.c(r1)
            int r1 = r1.l()
            int r6 = r6 + r1
        L_0x0536:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.v(java.lang.Object):int");
    }

    private int v0(int i10) {
        return this.f21909a[i10 + 1];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int w(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f21908s
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.f21909a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04e3
            int r6 = r15.v0(r4)
            int r7 = u0(r6)
            int r8 = r15.V(r4)
            long r9 = W(r6)
            com.google.protobuf.FieldType r6 = com.google.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.b()
            if (r7 < r6) goto L_0x0038
            com.google.protobuf.FieldType r6 = com.google.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.b()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f21909a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            r11 = 1
            r12 = 0
            r13 = 0
            switch(r7) {
                case 0: goto L_0x04d1;
                case 1: goto L_0x04c5;
                case 2: goto L_0x04b5;
                case 3: goto L_0x04a5;
                case 4: goto L_0x0495;
                case 5: goto L_0x0489;
                case 6: goto L_0x047d;
                case 7: goto L_0x0471;
                case 8: goto L_0x0453;
                case 9: goto L_0x043f;
                case 10: goto L_0x042e;
                case 11: goto L_0x041f;
                case 12: goto L_0x0410;
                case 13: goto L_0x0405;
                case 14: goto L_0x03fa;
                case 15: goto L_0x03eb;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03bc;
                case 19: goto L_0x03b3;
                case 20: goto L_0x03aa;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0398;
                case 23: goto L_0x038f;
                case 24: goto L_0x0386;
                case 25: goto L_0x037d;
                case 26: goto L_0x0374;
                case 27: goto L_0x0367;
                case 28: goto L_0x035e;
                case 29: goto L_0x0355;
                case 30: goto L_0x034b;
                case 31: goto L_0x0341;
                case 32: goto L_0x0337;
                case 33: goto L_0x032d;
                case 34: goto L_0x0323;
                case 35: goto L_0x0303;
                case 36: goto L_0x02e6;
                case 37: goto L_0x02c9;
                case 38: goto L_0x02ac;
                case 39: goto L_0x028e;
                case 40: goto L_0x0270;
                case 41: goto L_0x0252;
                case 42: goto L_0x0234;
                case 43: goto L_0x0216;
                case 44: goto L_0x01f8;
                case 45: goto L_0x01da;
                case 46: goto L_0x01bc;
                case 47: goto L_0x019e;
                case 48: goto L_0x0180;
                case 49: goto L_0x0172;
                case 50: goto L_0x0162;
                case 51: goto L_0x0154;
                case 52: goto L_0x0148;
                case 53: goto L_0x0138;
                case 54: goto L_0x0128;
                case 55: goto L_0x0118;
                case 56: goto L_0x010c;
                case 57: goto L_0x0100;
                case 58: goto L_0x00f4;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00b0;
                case 62: goto L_0x00a0;
                case 63: goto L_0x0090;
                case 64: goto L_0x0084;
                case 65: goto L_0x0078;
                case 66: goto L_0x0068;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x04df
        L_0x0042:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.l0 r6 = (com.google.protobuf.l0) r6
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.CodedOutputStream.t(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = b0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.R(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.P(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.N(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.L(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.l(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.W(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.h(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.b1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.h(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.protobuf.CodedOutputStream.T(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.e(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.n(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.p(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = a0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.w(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = b0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.Y(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = b0(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.y(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.r(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.H(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.protobuf.CodedOutputStream.j(r8, r6)
            goto L_0x03c4
        L_0x0162:
            com.google.protobuf.g0 r6 = r0.f21925q
            java.lang.Object r7 = com.google.protobuf.j1.G(r1, r9)
            java.lang.Object r9 = r15.s(r4)
            int r6 = r6.g(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = J(r1, r9)
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.b1.j(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.t(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.r(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.e(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.w(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.b(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.l(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.y(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.n(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f21917i
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = com.google.protobuf.CodedOutputStream.V(r8)
            int r8 = com.google.protobuf.CodedOutputStream.X(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.s(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.q(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.d(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.v(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.c(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = J(r1, r9)
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.b1.p(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.u(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.a(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.k(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.x(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.m(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = J(r1, r9)
            int r6 = com.google.protobuf.b1.h(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.l0 r6 = (com.google.protobuf.l0) r6
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.CodedOutputStream.t(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.j1.E(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.R(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.j1.C(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.P(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.N(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.L(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.j1.C(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.l(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.j1.C(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.W(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.h(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            com.google.protobuf.z0 r7 = r15.t(r4)
            int r6 = com.google.protobuf.b1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.protobuf.j1.G(r1, r9)
            boolean r7 = r6 instanceof com.google.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            int r6 = com.google.protobuf.CodedOutputStream.h(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.protobuf.CodedOutputStream.T(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.e(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.n(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.p(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.j1.C(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.w(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.j1.E(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.Y(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.protobuf.j1.E(r1, r9)
            int r6 = com.google.protobuf.CodedOutputStream.y(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.protobuf.CodedOutputStream.r(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.A(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.protobuf.CodedOutputStream.j(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            com.google.protobuf.f1<?, ?> r2 = r0.f21923o
            int r1 = r15.x(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.w(java.lang.Object):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w0(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f21914f
            if (r3 == 0) goto L_0x0021
            com.google.protobuf.o<?> r3 = r0.f21924p
            com.google.protobuf.s r3 = r3.c(r1)
            boolean r5 = r3.n()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.t()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.f21909a
            int r6 = r6.length
            sun.misc.Unsafe r7 = f21908s
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r8
            r10 = 0
            r12 = 0
        L_0x002e:
            if (r10 >= r6) goto L_0x048d
            int r13 = r0.v0(r10)
            int r14 = r0.V(r10)
            int r15 = u0(r13)
            r4 = 17
            if (r15 > r4) goto L_0x0056
            int[] r4 = r0.f21909a
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0050
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0050:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x0075
            com.google.protobuf.o<?> r9 = r0.f21924p
            int r9 = r9.a(r5)
            if (r9 > r14) goto L_0x0075
            com.google.protobuf.o<?> r9 = r0.f21924p
            r9.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0057
        L_0x0073:
            r5 = 0
            goto L_0x0057
        L_0x0075:
            long r8 = W(r13)
            switch(r15) {
                case 0: goto L_0x047b;
                case 1: goto L_0x046f;
                case 2: goto L_0x0463;
                case 3: goto L_0x0457;
                case 4: goto L_0x044b;
                case 5: goto L_0x043f;
                case 6: goto L_0x0433;
                case 7: goto L_0x0427;
                case 8: goto L_0x041b;
                case 9: goto L_0x040a;
                case 10: goto L_0x03fb;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03e1;
                case 13: goto L_0x03d4;
                case 14: goto L_0x03c7;
                case 15: goto L_0x03ba;
                case 16: goto L_0x03ad;
                case 17: goto L_0x039c;
                case 18: goto L_0x038c;
                case 19: goto L_0x037c;
                case 20: goto L_0x036c;
                case 21: goto L_0x035c;
                case 22: goto L_0x034c;
                case 23: goto L_0x033c;
                case 24: goto L_0x032c;
                case 25: goto L_0x031c;
                case 26: goto L_0x030d;
                case 27: goto L_0x02fa;
                case 28: goto L_0x02eb;
                case 29: goto L_0x02db;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bb;
                case 32: goto L_0x02ab;
                case 33: goto L_0x029b;
                case 34: goto L_0x028b;
                case 35: goto L_0x027b;
                case 36: goto L_0x026b;
                case 37: goto L_0x025b;
                case 38: goto L_0x024b;
                case 39: goto L_0x023b;
                case 40: goto L_0x022b;
                case 41: goto L_0x021b;
                case 42: goto L_0x020b;
                case 43: goto L_0x01fb;
                case 44: goto L_0x01eb;
                case 45: goto L_0x01db;
                case 46: goto L_0x01cb;
                case 47: goto L_0x01bb;
                case 48: goto L_0x01ab;
                case 49: goto L_0x0198;
                case 50: goto L_0x018f;
                case 51: goto L_0x0180;
                case 52: goto L_0x0171;
                case 53: goto L_0x0162;
                case 54: goto L_0x0153;
                case 55: goto L_0x0144;
                case 56: goto L_0x0135;
                case 57: goto L_0x0126;
                case 58: goto L_0x0117;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d7;
                case 63: goto L_0x00c9;
                case 64: goto L_0x00bb;
                case 65: goto L_0x00ad;
                case 66: goto L_0x009f;
                case 67: goto L_0x0091;
                case 68: goto L_0x007f;
                default: goto L_0x007c;
            }
        L_0x007c:
            r13 = 0
            goto L_0x0486
        L_0x007f:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.z0 r8 = r0.t(r10)
            r2.K(r14, r4, r8)
            goto L_0x007c
        L_0x0091:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = b0(r1, r8)
            r2.m(r14, r8)
            goto L_0x007c
        L_0x009f:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.H(r14, r4)
            goto L_0x007c
        L_0x00ad:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = b0(r1, r8)
            r2.i(r14, r8)
            goto L_0x007c
        L_0x00bb:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.w(r14, r4)
            goto L_0x007c
        L_0x00c9:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.E(r14, r4)
            goto L_0x007c
        L_0x00d7:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.o(r14, r4)
            goto L_0x007c
        L_0x00e5:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.L(r14, r4)
            goto L_0x007c
        L_0x00f5:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.z0 r8 = r0.t(r10)
            r2.N(r14, r4, r8)
            goto L_0x007c
        L_0x0108:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.A0(r14, r4, r2)
            goto L_0x007c
        L_0x0117:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            boolean r4 = X(r1, r8)
            r2.v(r14, r4)
            goto L_0x007c
        L_0x0126:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.c(r14, r4)
            goto L_0x007c
        L_0x0135:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = b0(r1, r8)
            r2.s(r14, r8)
            goto L_0x007c
        L_0x0144:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = a0(r1, r8)
            r2.h(r14, r4)
            goto L_0x007c
        L_0x0153:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = b0(r1, r8)
            r2.f(r14, r8)
            goto L_0x007c
        L_0x0162:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = b0(r1, r8)
            r2.u(r14, r8)
            goto L_0x007c
        L_0x0171:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            float r4 = Z(r1, r8)
            r2.B(r14, r4)
            goto L_0x007c
        L_0x0180:
            boolean r4 = r0.H(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            double r8 = Y(r1, r8)
            r2.p(r14, r8)
            goto L_0x007c
        L_0x018f:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.z0(r2, r14, r4, r10)
            goto L_0x007c
        L_0x0198:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.z0 r9 = r0.t(r10)
            com.google.protobuf.b1.U(r4, r8, r2, r9)
            goto L_0x007c
        L_0x01ab:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 1
            com.google.protobuf.b1.b0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01bb:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.a0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01cb:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Z(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01db:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Y(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01eb:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Q(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01fb:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.d0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x020b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.N(r4, r8, r2, r13)
            goto L_0x007c
        L_0x021b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.R(r4, r8, r2, r13)
            goto L_0x007c
        L_0x022b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.S(r4, r8, r2, r13)
            goto L_0x007c
        L_0x023b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.V(r4, r8, r2, r13)
            goto L_0x007c
        L_0x024b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.e0(r4, r8, r2, r13)
            goto L_0x007c
        L_0x025b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.W(r4, r8, r2, r13)
            goto L_0x007c
        L_0x026b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.T(r4, r8, r2, r13)
            goto L_0x007c
        L_0x027b:
            r13 = 1
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.P(r4, r8, r2, r13)
            goto L_0x007c
        L_0x028b:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.b1.b0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x029b:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.a0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02ab:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Z(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02bb:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Y(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02cb:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.Q(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02db:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.d0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02eb:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.O(r4, r8, r2)
            goto L_0x007c
        L_0x02fa:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.z0 r9 = r0.t(r10)
            com.google.protobuf.b1.X(r4, r8, r2, r9)
            goto L_0x007c
        L_0x030d:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.c0(r4, r8, r2)
            goto L_0x007c
        L_0x031c:
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.protobuf.b1.N(r4, r8, r2, r13)
            goto L_0x0486
        L_0x032c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.R(r4, r8, r2, r13)
            goto L_0x0486
        L_0x033c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.S(r4, r8, r2, r13)
            goto L_0x0486
        L_0x034c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.V(r4, r8, r2, r13)
            goto L_0x0486
        L_0x035c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.e0(r4, r8, r2, r13)
            goto L_0x0486
        L_0x036c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.W(r4, r8, r2, r13)
            goto L_0x0486
        L_0x037c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.T(r4, r8, r2, r13)
            goto L_0x0486
        L_0x038c:
            r13 = 0
            int r4 = r0.V(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.protobuf.b1.P(r4, r8, r2, r13)
            goto L_0x0486
        L_0x039c:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.z0 r8 = r0.t(r10)
            r2.K(r14, r4, r8)
            goto L_0x0486
        L_0x03ad:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.m(r14, r8)
            goto L_0x0486
        L_0x03ba:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.H(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.i(r14, r8)
            goto L_0x0486
        L_0x03d4:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.w(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.E(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.o(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r2.L(r14, r4)
            goto L_0x0486
        L_0x040a:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.protobuf.z0 r8 = r0.t(r10)
            r2.N(r14, r4, r8)
            goto L_0x0486
        L_0x041b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.A0(r14, r4, r2)
            goto L_0x0486
        L_0x0427:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            boolean r4 = i(r1, r8)
            r2.v(r14, r4)
            goto L_0x0486
        L_0x0433:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.c(r14, r4)
            goto L_0x0486
        L_0x043f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.s(r14, r8)
            goto L_0x0486
        L_0x044b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.h(r14, r4)
            goto L_0x0486
        L_0x0457:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.f(r14, r8)
            goto L_0x0486
        L_0x0463:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.u(r14, r8)
            goto L_0x0486
        L_0x046f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            float r4 = q(r1, r8)
            r2.B(r14, r4)
            goto L_0x0486
        L_0x047b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            double r8 = m(r1, r8)
            r2.p(r14, r8)
        L_0x0486:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x002e
        L_0x048d:
            if (r5 == 0) goto L_0x04a4
            com.google.protobuf.o<?> r4 = r0.f21924p
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a2
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048d
        L_0x04a2:
            r5 = 0
            goto L_0x048d
        L_0x04a4:
            com.google.protobuf.f1<?, ?> r3 = r0.f21923o
            r0.B0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.w0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <UT, UB> int x(f1<UT, UB> f1Var, T t10) {
        return f1Var.h(f1Var.g(t10));
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x0(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.f21914f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.protobuf.o<?> r0 = r12.f21924p
            com.google.protobuf.s r0 = r0.c(r13)
            boolean r2 = r0.n()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.t()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f21909a
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.v0(r5)
            int r7 = r12.V(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.protobuf.o<?> r8 = r12.f21924p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            com.google.protobuf.o<?> r8 = r12.f21924p
            r8.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = u0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.z0 r8 = r12.t(r5)
            r14.K(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = b0(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = b0(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.L(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.z0 r8 = r12.t(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            r12.A0(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            boolean r6 = X(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = b0(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = a0(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = b0(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = b0(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            float r6 = Z(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.H(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            double r8 = Y(r13, r8)
            r14.p(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            r12.z0(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.z0 r8 = r12.t(r5)
            com.google.protobuf.b1.U(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.b0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.a0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Z(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Y(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Q(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.d0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.N(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.R(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.S(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.V(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.e0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.W(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.T(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.V(r5)
            long r10 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.P(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.b0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.a0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Z(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Y(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.Q(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.d0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.O(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.z0 r8 = r12.t(r5)
            com.google.protobuf.b1.X(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.c0(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.N(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.R(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.S(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.V(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.e0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.W(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.T(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.V(r5)
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.protobuf.b1.P(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.z0 r8 = r12.t(r5)
            r14.K(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = K(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = K(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            r14.L(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            com.google.protobuf.z0 r8 = r12.t(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            java.lang.Object r6 = com.google.protobuf.j1.G(r13, r8)
            r12.A0(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            boolean r6 = i(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = K(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            int r6 = y(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = K(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            long r8 = K(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            float r6 = q(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.A(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = W(r6)
            double r8 = m(r13, r8)
            r14.p(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            com.google.protobuf.o<?> r3 = r12.f21924p
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            com.google.protobuf.f1<?, ?> r0 = r12.f21923o
            r12.B0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.x0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private static <T> int y(T t10, long j10) {
        return j1.C(t10, j10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y0(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            com.google.protobuf.f1<?, ?> r0 = r10.f21923o
            r10.B0(r0, r11, r12)
            boolean r0 = r10.f21914f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.protobuf.o<?> r0 = r10.f21924p
            com.google.protobuf.s r0 = r0.c(r11)
            boolean r2 = r0.n()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.g()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f21909a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.v0(r3)
            int r5 = r10.V(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.protobuf.o<?> r6 = r10.f21924p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.protobuf.o<?> r6 = r10.f21924p
            r6.j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = u0(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.z0 r6 = r10.t(r3)
            r12.K(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = b0(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = b0(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.L(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.z0 r6 = r10.t(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            r10.A0(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            boolean r4 = X(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = b0(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = a0(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = b0(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = b0(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            float r4 = Z(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.H(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            double r6 = Y(r11, r6)
            r12.p(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            r10.z0(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.z0 r6 = r10.t(r3)
            com.google.protobuf.b1.U(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.b0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.a0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Z(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Y(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Q(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.d0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.N(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.R(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.S(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.V(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.e0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.W(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.T(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.V(r3)
            long r8 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.P(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.b0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.a0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Z(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Y(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.Q(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.d0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.O(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.z0 r6 = r10.t(r3)
            com.google.protobuf.b1.X(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.c0(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.N(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.R(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.S(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.V(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.e0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.W(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.T(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.V(r3)
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.protobuf.b1.P(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.z0 r6 = r10.t(r3)
            r12.K(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = K(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = K(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.ByteString r4 = (com.google.protobuf.ByteString) r4
            r12.L(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            com.google.protobuf.z0 r6 = r10.t(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            java.lang.Object r4 = com.google.protobuf.j1.G(r11, r6)
            r10.A0(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            boolean r4 = i(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = K(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            int r4 = y(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = K(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            long r6 = K(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            float r4 = q(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.A(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = W(r4)
            double r6 = m(r11, r6)
            r12.p(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            com.google.protobuf.o<?> r11 = r10.f21924p
            r11.j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.y0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private static boolean z(int i10) {
        return (i10 & 536870912) != 0;
    }

    private <K, V> void z0(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            writer.O(i10, this.f21925q.b(s(i11)), this.f21925q.e(obj));
        }
    }

    public void a(T t10, T t11) {
        j(t10);
        t11.getClass();
        for (int i10 = 0; i10 < this.f21909a.length; i10 += 3) {
            P(t10, t11, i10);
        }
        b1.G(this.f21923o, t10, t11);
        if (this.f21914f) {
            b1.E(this.f21924p, t10, t11);
        }
    }

    public void b(T t10) {
        if (F(t10)) {
            if (t10 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t10;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.f21909a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int v02 = v0(i10);
                long W = W(v02);
                int u02 = u0(v02);
                if (u02 != 9) {
                    switch (u02) {
                        case 17:
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.f21922n.c(t10, W);
                            continue;
                        case 50:
                            Unsafe unsafe = f21908s;
                            Object object = unsafe.getObject(t10, W);
                            if (object != null) {
                                unsafe.putObject(t10, W, this.f21925q.f(object));
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                if (A(t10, i10)) {
                    t(i10).b(f21908s.getObject(t10, W));
                }
            }
            this.f21923o.j(t10);
            if (this.f21914f) {
                this.f21924p.f(t10);
            }
        }
    }

    public final boolean c(T t10) {
        int i10;
        int i11;
        T t11 = t10;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f21919k) {
            int i15 = this.f21918j[i14];
            int V = V(i15);
            int v02 = v0(i15);
            int i16 = this.f21909a[i15 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i12) {
                if (i17 != 1048575) {
                    i13 = f21908s.getInt(t11, (long) i17);
                }
                i10 = i13;
                i11 = i17;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if (I(v02) && !B(t10, i15, i11, i10, i18)) {
                return false;
            }
            int u02 = u0(v02);
            if (u02 != 9 && u02 != 17) {
                if (u02 != 27) {
                    if (u02 == 60 || u02 == 68) {
                        if (H(t11, V, i15) && !C(t11, v02, t(i15))) {
                            return false;
                        }
                    } else if (u02 != 49) {
                        if (u02 == 50 && !E(t11, v02, i15)) {
                            return false;
                        }
                    }
                }
                if (!D(t11, v02, i15)) {
                    return false;
                }
            } else if (B(t10, i15, i11, i10, i18) && !C(t11, v02, t(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        if (!this.f21914f || this.f21924p.c(t11).p()) {
            return true;
        }
        return false;
    }

    public int d(T t10) {
        return this.f21916h ? w(t10) : v(t10);
    }

    public void e(T t10, Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            y0(t10, writer);
        } else if (this.f21916h) {
            x0(t10, writer);
        } else {
            w0(t10, writer);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.protobuf.g1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0335, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0378, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0399, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x039c, code lost:
        r8 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025e, code lost:
        r5 = r11 | r17;
        r11 = r31;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027a, code lost:
        r0 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0296, code lost:
        r5 = r11 | r17;
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x029a, code lost:
        r2 = r8;
        r3 = r12;
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x029e, code lost:
        r12 = r6;
        r6 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a3, code lost:
        r17 = r29;
        r2 = r3;
        r20 = r8;
        r25 = r10;
        r19 = r11;
        r9 = r12;
        r8 = r31;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e0(T r27, byte[] r28, int r29, int r30, int r31, com.google.protobuf.e.b r32) throws java.io.IOException {
        /*
            r26 = this;
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            j(r27)
            sun.misc.Unsafe r10 = f21908s
            r16 = 0
            r0 = r29
            r2 = r16
            r3 = r2
            r5 = r3
            r1 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r0 >= r13) goto L_0x03f7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.protobuf.e.H(r0, r12, r3, r9)
            int r3 = r9.f21784a
            r4 = r3
            r3 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x003c
            int r2 = r2 / r8
            int r1 = r15.i0(r0, r2)
            goto L_0x0040
        L_0x003c:
            int r1 = r15.h0(r0)
        L_0x0040:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0055
            r22 = r0
            r18 = r1
            r2 = r3
            r9 = r4
            r19 = r5
            r17 = r6
            r25 = r10
            r8 = r11
            r20 = r16
            goto L_0x03a0
        L_0x0055:
            int[] r1 = r15.f21909a
            int r19 = r2 + 1
            r1 = r1[r19]
            int r8 = u0(r1)
            long r11 = W(r1)
            r19 = r4
            r4 = 17
            r20 = r11
            if (r8 > r4) goto L_0x02b1
            int[] r4 = r15.f21909a
            int r12 = r2 + 2
            r4 = r4[r12]
            int r12 = r4 >>> 20
            r11 = 1
            int r12 = r11 << r12
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r11
            r17 = r12
            if (r4 == r6) goto L_0x008c
            if (r6 == r11) goto L_0x0084
            long r11 = (long) r6
            r10.putInt(r14, r11, r5)
        L_0x0084:
            long r5 = (long) r4
            int r5 = r10.getInt(r14, r5)
            r12 = r4
            r11 = r5
            goto L_0x008e
        L_0x008c:
            r11 = r5
            r12 = r6
        L_0x008e:
            r4 = 5
            switch(r8) {
                case 0: goto L_0x027d;
                case 1: goto L_0x0264;
                case 2: goto L_0x023e;
                case 3: goto L_0x023e;
                case 4: goto L_0x0224;
                case 5: goto L_0x0201;
                case 6: goto L_0x01e9;
                case 7: goto L_0x01c5;
                case 8: goto L_0x01a0;
                case 9: goto L_0x017a;
                case 10: goto L_0x015f;
                case 11: goto L_0x0224;
                case 12: goto L_0x0123;
                case 13: goto L_0x01e9;
                case 14: goto L_0x0201;
                case 15: goto L_0x0105;
                case 16: goto L_0x00e1;
                case 17: goto L_0x009f;
                default: goto L_0x0092;
            }
        L_0x0092:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            goto L_0x02a3
        L_0x009f:
            r5 = 3
            if (r7 != r5) goto L_0x00d4
            java.lang.Object r7 = r15.Q(r14, r2)
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.protobuf.z0 r1 = r15.t(r2)
            r22 = r0
            r0 = r7
            r18 = -1
            r8 = r2
            r2 = r28
            r6 = r19
            r4 = r30
            r29 = r12
            r12 = r6
            r6 = r32
            int r0 = com.google.protobuf.e.N(r0, r1, r2, r3, r4, r5, r6)
            r15.s0(r14, r8, r7)
            r5 = r11 | r17
            r6 = r29
            r11 = r31
            r2 = r8
            r3 = r12
            r1 = r22
            r12 = r28
            goto L_0x001d
        L_0x00d4:
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            r6 = r28
            goto L_0x02a3
        L_0x00e1:
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            r6 = r28
            if (r7 != 0) goto L_0x02a3
            r4 = r20
            int r7 = com.google.protobuf.e.L(r6, r3, r9)
            long r0 = r9.f21785b
            long r19 = com.google.protobuf.h.c(r0)
            r0 = r10
            r1 = r27
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x025e
        L_0x0105:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r7 != 0) goto L_0x02a3
            int r0 = com.google.protobuf.e.I(r6, r3, r9)
            int r1 = r9.f21784a
            int r1 = com.google.protobuf.h.b(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x0296
        L_0x0123:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r7 != 0) goto L_0x02a3
            int r0 = com.google.protobuf.e.I(r6, r3, r9)
            int r1 = r9.f21784a
            com.google.protobuf.w$e r2 = r15.r(r8)
            if (r2 == 0) goto L_0x015a
            boolean r2 = r2.isInRange(r1)
            if (r2 == 0) goto L_0x0145
            goto L_0x015a
        L_0x0145:
            com.google.protobuf.g1 r2 = u(r27)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.r(r12, r1)
            r2 = r8
            r5 = r11
            r3 = r12
            r1 = r22
            r11 = r31
            goto L_0x029e
        L_0x015a:
            r10.putInt(r14, r4, r1)
            goto L_0x0296
        L_0x015f:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x02a3
            int r0 = com.google.protobuf.e.b(r6, r3, r9)
            java.lang.Object r1 = r9.f21786c
            r10.putObject(r14, r4, r1)
            goto L_0x0296
        L_0x017a:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x02a3
            java.lang.Object r7 = r15.Q(r14, r8)
            com.google.protobuf.z0 r1 = r15.t(r8)
            r0 = r7
            r2 = r28
            r4 = r30
            r5 = r32
            int r0 = com.google.protobuf.e.O(r0, r1, r2, r3, r4, r5)
            r15.s0(r14, r8, r7)
            goto L_0x0296
        L_0x01a0:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x02a3
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01ba
            int r0 = com.google.protobuf.e.C(r6, r3, r9)
            goto L_0x01be
        L_0x01ba:
            int r0 = com.google.protobuf.e.F(r6, r3, r9)
        L_0x01be:
            java.lang.Object r1 = r9.f21786c
            r10.putObject(r14, r4, r1)
            goto L_0x0296
        L_0x01c5:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r7 != 0) goto L_0x02a3
            int r0 = com.google.protobuf.e.L(r6, r3, r9)
            long r1 = r9.f21785b
            r19 = 0
            int r1 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01e2
            r1 = 1
            goto L_0x01e4
        L_0x01e2:
            r1 = r16
        L_0x01e4:
            com.google.protobuf.j1.L(r14, r4, r1)
            goto L_0x0296
        L_0x01e9:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r1 = r20
            r18 = -1
            if (r7 != r4) goto L_0x02a3
            int r0 = com.google.protobuf.e.h(r6, r3)
            r10.putInt(r14, r1, r0)
            goto L_0x027a
        L_0x0201:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r1 = r20
            r0 = 1
            r18 = -1
            if (r7 != r0) goto L_0x02a3
            long r4 = com.google.protobuf.e.j(r6, r3)
            r0 = r10
            r20 = r1
            r1 = r27
            r7 = r3
            r2 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0296
        L_0x0224:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r18 = -1
            if (r7 != 0) goto L_0x02a3
            int r0 = com.google.protobuf.e.I(r6, r3, r9)
            int r1 = r9.f21784a
            r4 = r20
            r10.putInt(r14, r4, r1)
            goto L_0x0296
        L_0x023e:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r4 = r20
            r18 = -1
            if (r7 != 0) goto L_0x02a3
            int r7 = com.google.protobuf.e.L(r6, r3, r9)
            long r2 = r9.f21785b
            r0 = r10
            r1 = r27
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x025e:
            r5 = r11 | r17
            r11 = r31
            r0 = r7
            goto L_0x029a
        L_0x0264:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r0 = r20
            r18 = -1
            if (r7 != r4) goto L_0x02a3
            float r2 = com.google.protobuf.e.l(r6, r3)
            com.google.protobuf.j1.S(r14, r0, r2)
        L_0x027a:
            int r0 = r3 + 4
            goto L_0x0296
        L_0x027d:
            r6 = r28
            r22 = r0
            r8 = r2
            r29 = r12
            r12 = r19
            r0 = r20
            r2 = 1
            r18 = -1
            if (r7 != r2) goto L_0x02a3
            double r4 = com.google.protobuf.e.d(r6, r3)
            com.google.protobuf.j1.R(r14, r0, r4)
            int r0 = r3 + 8
        L_0x0296:
            r5 = r11 | r17
            r11 = r31
        L_0x029a:
            r2 = r8
            r3 = r12
            r1 = r22
        L_0x029e:
            r12 = r6
            r6 = r29
            goto L_0x001d
        L_0x02a3:
            r17 = r29
            r2 = r3
            r20 = r8
            r25 = r10
            r19 = r11
            r9 = r12
            r8 = r31
            goto L_0x03a0
        L_0x02b1:
            r22 = r0
            r11 = r2
            r17 = r6
            r12 = r19
            r18 = -1
            r19 = r5
            r5 = r20
            r0 = 27
            if (r8 != r0) goto L_0x030a
            r0 = 2
            if (r7 != r0) goto L_0x0301
            java.lang.Object r0 = r10.getObject(r14, r5)
            com.google.protobuf.w$j r0 = (com.google.protobuf.w.j) r0
            boolean r1 = r0.h()
            if (r1 != 0) goto L_0x02e3
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02da
            r1 = 10
            goto L_0x02dc
        L_0x02da:
            int r1 = r1 * 2
        L_0x02dc:
            com.google.protobuf.w$j r0 = r0.a(r1)
            r10.putObject(r14, r5, r0)
        L_0x02e3:
            r5 = r0
            com.google.protobuf.z0 r0 = r15.t(r11)
            r1 = r12
            r2 = r28
            r4 = r30
            r6 = r32
            int r0 = com.google.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r2 = r11
            r3 = r12
            r6 = r17
            r5 = r19
            r1 = r22
            r12 = r28
            r11 = r31
            goto L_0x001d
        L_0x0301:
            r15 = r3
            r25 = r10
            r20 = r11
            r21 = r12
            goto L_0x037b
        L_0x030a:
            r0 = 49
            if (r8 > r0) goto L_0x0351
            long r1 = (long) r1
            r0 = r26
            r20 = r1
            r1 = r27
            r2 = r28
            r4 = r3
            r15 = r4
            r4 = r30
            r23 = r5
            r5 = r12
            r6 = r22
            r29 = r8
            r8 = r11
            r25 = r10
            r9 = r20
            r20 = r11
            r11 = r29
            r21 = r12
            r12 = r23
            r14 = r32
            int r0 = r0.g0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x039c
        L_0x0337:
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            r6 = r17
            r5 = r19
            r2 = r20
            r3 = r21
            r1 = r22
            r10 = r25
            goto L_0x001d
        L_0x0351:
            r15 = r3
            r23 = r5
            r29 = r8
            r25 = r10
            r20 = r11
            r21 = r12
            r0 = 50
            r9 = r29
            if (r9 != r0) goto L_0x0381
            r0 = 2
            if (r7 != r0) goto L_0x037b
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r20
            r6 = r23
            r8 = r32
            int r0 = r0.c0(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x039c
            goto L_0x0337
        L_0x037b:
            r8 = r31
            r2 = r15
        L_0x037e:
            r9 = r21
            goto L_0x03a0
        L_0x0381:
            r0 = r26
            r8 = r1
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r21
            r6 = r22
            r10 = r23
            r12 = r20
            r13 = r32
            int r0 = r0.d0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x039c
            goto L_0x0337
        L_0x039c:
            r8 = r31
            r2 = r0
            goto L_0x037e
        L_0x03a0:
            if (r9 != r8) goto L_0x03b0
            if (r8 == 0) goto L_0x03b0
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r26
            r6 = r2
            r0 = r17
            r5 = r19
            goto L_0x0406
        L_0x03b0:
            r10 = r26
            boolean r0 = r10.f21914f
            r11 = r32
            if (r0 == 0) goto L_0x03d2
            com.google.protobuf.n r0 = r11.f21787d
            com.google.protobuf.n r1 = com.google.protobuf.n.b()
            if (r0 == r1) goto L_0x03d2
            com.google.protobuf.l0 r5 = r10.f21913e
            com.google.protobuf.f1<?, ?> r6 = r10.f21923o
            r0 = r9
            r1 = r28
            r3 = r30
            r4 = r27
            r7 = r32
            int r0 = com.google.protobuf.e.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x03e1
        L_0x03d2:
            com.google.protobuf.g1 r4 = u(r27)
            r0 = r9
            r1 = r28
            r3 = r30
            r5 = r32
            int r0 = com.google.protobuf.e.G(r0, r1, r2, r3, r4, r5)
        L_0x03e1:
            r14 = r27
            r12 = r28
            r13 = r30
            r3 = r9
            r15 = r10
            r9 = r11
            r6 = r17
            r5 = r19
            r2 = r20
            r1 = r22
            r10 = r25
            r11 = r8
            goto L_0x001d
        L_0x03f7:
            r19 = r5
            r17 = r6
            r25 = r10
            r8 = r11
            r10 = r15
            r6 = r0
            r9 = r3
            r0 = r17
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0406:
            if (r0 == r1) goto L_0x0411
            long r0 = (long) r0
            r7 = r27
            r2 = r25
            r2.putInt(r7, r0, r5)
            goto L_0x0413
        L_0x0411:
            r7 = r27
        L_0x0413:
            r0 = 0
            int r1 = r10.f21919k
            r3 = r0
            r11 = r1
        L_0x0418:
            int r0 = r10.f21920l
            if (r11 >= r0) goto L_0x0432
            int[] r0 = r10.f21918j
            r2 = r0[r11]
            com.google.protobuf.f1<?, ?> r4 = r10.f21923o
            r0 = r26
            r1 = r27
            r5 = r27
            java.lang.Object r0 = r0.o(r1, r2, r3, r4, r5)
            r3 = r0
            com.google.protobuf.g1 r3 = (com.google.protobuf.g1) r3
            int r11 = r11 + 1
            goto L_0x0418
        L_0x0432:
            if (r3 == 0) goto L_0x0439
            com.google.protobuf.f1<?, ?> r0 = r10.f21923o
            r0.o(r7, r3)
        L_0x0439:
            if (r8 != 0) goto L_0x0445
            r0 = r30
            if (r6 != r0) goto L_0x0440
            goto L_0x044b
        L_0x0440:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r0
        L_0x0445:
            r0 = r30
            if (r6 > r0) goto L_0x044c
            if (r9 != r8) goto L_0x044c
        L_0x044b:
            return r6
        L_0x044c:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.e0(java.lang.Object, byte[], int, int, int, com.google.protobuf.e$b):int");
    }

    public boolean equals(T t10, T t11) {
        int length = this.f21909a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!n(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.f21923o.g(t10).equals(this.f21923o.g(t11))) {
            return false;
        }
        if (this.f21914f) {
            return this.f21924p.c(t10).equals(this.f21924p.c(t11));
        }
        return true;
    }

    public void f(T t10, y0 y0Var, n nVar) throws IOException {
        nVar.getClass();
        j(t10);
        L(this.f21923o, this.f21924p, t10, y0Var, nVar);
    }

    public void g(T t10, byte[] bArr, int i10, int i11, e.b bVar) throws IOException {
        if (this.f21916h) {
            f0(t10, bArr, i10, i11, bVar);
        } else {
            e0(t10, bArr, i10, i11, 0, bVar);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0225, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f21909a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.v0(r1)
            int r4 = r8.V(r1)
            long r5 = W(r3)
            int r3 = u0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0217;
                case 1: goto L_0x020c;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01dd;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0226
        L_0x001e:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = X(r9, r5)
            int r3 = com.google.protobuf.w.c(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = a0(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = b0(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = Z(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.H(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = Y(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.j1.E(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.j1.E(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.protobuf.j1.G(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = com.google.protobuf.j1.t(r9, r5)
            int r3 = com.google.protobuf.w.c(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.j1.E(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = com.google.protobuf.j1.C(r9, r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.j1.E(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = com.google.protobuf.j1.E(r9, r5)
            int r3 = com.google.protobuf.w.f(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = com.google.protobuf.j1.B(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = com.google.protobuf.j1.A(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.protobuf.w.f(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            com.google.protobuf.f1<?, ?> r0 = r8.f21923o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f21914f
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            com.google.protobuf.o<?> r0 = r8.f21924p
            com.google.protobuf.s r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o0.hashCode(java.lang.Object):int");
    }

    public T newInstance() {
        return this.f21921m.a(this.f21913e);
    }
}
