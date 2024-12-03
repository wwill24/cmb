package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Writer;
import com.google.crypto.tink.shaded.protobuf.f0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class k implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final CodedOutputStream f20858a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20859a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20859a = r0
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f20859a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.k.a.<clinit>():void");
        }
    }

    private k(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) x.b(codedOutputStream, "output");
        this.f20858a = codedOutputStream2;
        codedOutputStream2.f20625a = this;
    }

    public static k P(CodedOutputStream codedOutputStream) {
        k kVar = codedOutputStream.f20625a;
        if (kVar != null) {
            return kVar;
        }
        return new k(codedOutputStream);
    }

    private <K, V> void Q(int i10, f0.a<K, V> aVar, Map<K, V> map) throws IOException {
        int[] iArr = a.f20859a;
        throw null;
    }

    private void R(int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f20858a.L0(i10, (String) obj);
        } else {
            this.f20858a.j0(i10, (ByteString) obj);
        }
    }

    public void A(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.e(list.get(i13).booleanValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.i0(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.h0(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    public void B(int i10, float f10) throws IOException {
        this.f20858a.s0(i10, f10);
    }

    public void C(int i10) throws IOException {
        this.f20858a.M0(i10, 4);
    }

    public void D(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.P(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.I0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.H0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public void E(int i10, int i11) throws IOException {
        this.f20858a.m0(i10, i11);
    }

    public void F(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.y(list.get(i13).longValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.z0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.y0(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public void G(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.j(list.get(i13).doubleValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.l0(list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.k0(i10, list.get(i11).doubleValue());
            i11++;
        }
    }

    public void H(int i10, int i11) throws IOException {
        this.f20858a.H0(i10, i11);
    }

    public void I(int i10, List<ByteString> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f20858a.j0(i10, list.get(i11));
        }
    }

    public <K, V> void J(int i10, f0.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f20858a.c0()) {
            Q(i10, aVar, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.f20858a.M0(i10, 2);
            this.f20858a.O0(f0.b(aVar, next.getKey(), next.getValue()));
            f0.d(this.f20858a, aVar, next.getKey(), next.getValue());
        }
    }

    public void K(int i10, Object obj, z0 z0Var) throws IOException {
        this.f20858a.u0(i10, (l0) obj, z0Var);
    }

    public void L(int i10, List<?> list, z0 z0Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            N(i10, list.get(i11), z0Var);
        }
    }

    public void M(int i10, ByteString byteString) throws IOException {
        this.f20858a.j0(i10, byteString);
    }

    public void N(int i10, Object obj, z0 z0Var) throws IOException {
        this.f20858a.A0(i10, (l0) obj, z0Var);
    }

    public void O(int i10, List<?> list, z0 z0Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            K(i10, list.get(i11), z0Var);
        }
    }

    public void a(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.r(list.get(i13).floatValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.t0(list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.s0(i10, list.get(i11).floatValue());
            i11++;
        }
    }

    public final void b(int i10, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f20858a.C0(i10, (ByteString) obj);
        } else {
            this.f20858a.B0(i10, (l0) obj);
        }
    }

    public void c(int i10, int i11) throws IOException {
        this.f20858a.o0(i10, i11);
    }

    public void d(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            while (i11 < list.size()) {
                R(i10, b0Var.l(i11));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.L0(i10, list.get(i11));
            i11++;
        }
    }

    public void e(int i10, String str) throws IOException {
        this.f20858a.L0(i10, str);
    }

    public void f(int i10, long j10) throws IOException {
        this.f20858a.P0(i10, j10);
    }

    public void g(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.w(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.x0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.w0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public void h(int i10, int i11) throws IOException {
        this.f20858a.w0(i10, i11);
    }

    public void i(int i10, long j10) throws IOException {
        this.f20858a.F0(i10, j10);
    }

    public void j(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.n(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.p0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.o0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public void k(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.W(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.O0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.N0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public void l(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.R(list.get(i13).longValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.K0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.J0(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public void m(int i10, long j10) throws IOException {
        this.f20858a.J0(i10, j10);
    }

    public void n(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.l(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.n0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.m0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public void o(int i10, int i11) throws IOException {
        this.f20858a.N0(i10, i11);
    }

    public void p(int i10, double d10) throws IOException {
        this.f20858a.k0(i10, d10);
    }

    public void q(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.N(list.get(i13).longValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.G0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.F0(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public void r(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.Y(list.get(i13).longValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.Q0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.P0(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public void s(int i10, long j10) throws IOException {
        this.f20858a.q0(i10, j10);
    }

    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    public void u(int i10, long j10) throws IOException {
        this.f20858a.y0(i10, j10);
    }

    public void v(int i10, boolean z10) throws IOException {
        this.f20858a.h0(i10, z10);
    }

    public void w(int i10, int i11) throws IOException {
        this.f20858a.D0(i10, i11);
    }

    public void x(int i10) throws IOException {
        this.f20858a.M0(i10, 3);
    }

    public void y(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.p(list.get(i13).longValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.r0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.q0(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public void z(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f20858a.M0(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += CodedOutputStream.L(list.get(i13).intValue());
            }
            this.f20858a.O0(i12);
            while (i11 < list.size()) {
                this.f20858a.E0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f20858a.D0(i10, list.get(i11).intValue());
            i11++;
        }
    }
}
