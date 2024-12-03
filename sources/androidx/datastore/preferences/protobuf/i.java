package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.List;

final class i implements x0 {

    /* renamed from: a  reason: collision with root package name */
    private final h f5292a;

    /* renamed from: b  reason: collision with root package name */
    private int f5293b;

    /* renamed from: c  reason: collision with root package name */
    private int f5294c;

    /* renamed from: d  reason: collision with root package name */
    private int f5295d = 0;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5296a;

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
                f5296a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f5296a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.a.<clinit>():void");
        }
    }

    private i(h hVar) {
        h hVar2 = (h) w.b(hVar, "input");
        this.f5292a = hVar2;
        hVar2.f5264d = this;
    }

    public static i Q(h hVar) {
        i iVar = hVar.f5264d;
        if (iVar != null) {
            return iVar;
        }
        return new i(hVar);
    }

    private Object R(WireFormat.FieldType fieldType, Class<?> cls, n nVar) throws IOException {
        switch (a.f5296a[fieldType.ordinal()]) {
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

    private <T> T S(y0<T> y0Var, n nVar) throws IOException {
        int i10 = this.f5294c;
        this.f5294c = WireFormat.c(WireFormat.a(this.f5293b), 4);
        try {
            T newInstance = y0Var.newInstance();
            y0Var.e(newInstance, this, nVar);
            y0Var.b(newInstance);
            if (this.f5293b == this.f5294c) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.g();
        } finally {
            this.f5294c = i10;
        }
    }

    private <T> T T(y0<T> y0Var, n nVar) throws IOException {
        int C = this.f5292a.C();
        h hVar = this.f5292a;
        if (hVar.f5261a < hVar.f5262b) {
            int l10 = hVar.l(C);
            T newInstance = y0Var.newInstance();
            this.f5292a.f5261a++;
            y0Var.e(newInstance, this, nVar);
            y0Var.b(newInstance);
            this.f5292a.a(0);
            h hVar2 = this.f5292a;
            hVar2.f5261a--;
            hVar2.k(l10);
            return newInstance;
        }
        throw InvalidProtocolBufferException.h();
    }

    private void V(int i10) throws IOException {
        if (this.f5292a.d() != i10) {
            throw InvalidProtocolBufferException.k();
        }
    }

    private void W(int i10) throws IOException {
        if (WireFormat.b(this.f5293b) != i10) {
            throw InvalidProtocolBufferException.d();
        }
    }

    private void X(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    private void Y(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    public int A() throws IOException {
        int i10 = this.f5295d;
        if (i10 != 0) {
            this.f5293b = i10;
            this.f5295d = 0;
        } else {
            this.f5293b = this.f5292a.B();
        }
        int i11 = this.f5293b;
        if (i11 == 0 || i11 == this.f5294c) {
            return a.e.API_PRIORITY_OTHER;
        }
        return WireFormat.a(i11);
    }

    public void B(List<String> list) throws IOException {
        U(list, false);
    }

    public void C(List<Float> list) throws IOException {
        int B;
        int B2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 2) {
                int C = this.f5292a.C();
                X(C);
                int d10 = this.f5292a.d() + C;
                do {
                    tVar.g(this.f5292a.s());
                } while (this.f5292a.d() < d10);
            } else if (b10 == 5) {
                do {
                    tVar.g(this.f5292a.s());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 2) {
                int C2 = this.f5292a.C();
                X(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Float.valueOf(this.f5292a.s()));
                } while (this.f5292a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Float.valueOf(this.f5292a.s()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public boolean D() throws IOException {
        int i10;
        if (this.f5292a.e() || (i10 = this.f5293b) == this.f5294c) {
            return false;
        }
        return this.f5292a.E(i10);
    }

    public int E() throws IOException {
        W(5);
        return this.f5292a.v();
    }

    public void F(List<ByteString> list) throws IOException {
        int B;
        if (WireFormat.b(this.f5293b) == 2) {
            do {
                list.add(o());
                if (!this.f5292a.e()) {
                    B = this.f5292a.B();
                } else {
                    return;
                }
            } while (B == this.f5293b);
            this.f5295d = B;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public void G(List<Double> list) throws IOException {
        int B;
        int B2;
        if (list instanceof k) {
            k kVar = (k) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 1) {
                do {
                    kVar.g(this.f5292a.o());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int C = this.f5292a.C();
                Y(C);
                int d10 = this.f5292a.d() + C;
                do {
                    kVar.g(this.f5292a.o());
                } while (this.f5292a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 1) {
                do {
                    list.add(Double.valueOf(this.f5292a.o()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int C2 = this.f5292a.C();
                Y(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Double.valueOf(this.f5292a.o()));
                } while (this.f5292a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public long H() throws IOException {
        W(0);
        return this.f5292a.u();
    }

    public String I() throws IOException {
        W(2);
        return this.f5292a.A();
    }

    public <T> T J(y0<T> y0Var, n nVar) throws IOException {
        W(2);
        return T(y0Var, nVar);
    }

    public <T> void K(List<T> list, y0<T> y0Var, n nVar) throws IOException {
        int B;
        if (WireFormat.b(this.f5293b) == 2) {
            int i10 = this.f5293b;
            do {
                list.add(T(y0Var, nVar));
                if (!this.f5292a.e() && this.f5295d == 0) {
                    B = this.f5292a.B();
                } else {
                    return;
                }
            } while (B == i10);
            this.f5295d = B;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public <T> T L(y0<T> y0Var, n nVar) throws IOException {
        W(3);
        return S(y0Var, nVar);
    }

    public <T> T M(Class<T> cls, n nVar) throws IOException {
        W(2);
        return T(u0.a().d(cls), nVar);
    }

    public <T> T N(Class<T> cls, n nVar) throws IOException {
        W(3);
        return S(u0.a().d(cls), nVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (D() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void O(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.e0.a<K, V> r9, androidx.datastore.preferences.protobuf.n r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.W(r0)
            androidx.datastore.preferences.protobuf.h r1 = r7.f5292a
            int r1 = r1.C()
            androidx.datastore.preferences.protobuf.h r2 = r7.f5292a
            int r1 = r2.l(r1)
            K r2 = r9.f5249b
            V r3 = r9.f5251d
        L_0x0014:
            int r4 = r7.A()     // Catch:{ all -> 0x0065 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005c
            androidx.datastore.preferences.protobuf.h r5 = r7.f5292a     // Catch:{ all -> 0x0065 }
            boolean r5 = r5.e()     // Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x0026
            goto L_0x005c
        L_0x0026:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0047
            if (r4 == r0) goto L_0x003a
            boolean r4 = r7.D()     // Catch:{ InvalidWireTypeException -> 0x004f }
            if (r4 == 0) goto L_0x0034
            goto L_0x0014
        L_0x0034:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004f }
            r4.<init>(r6)     // Catch:{ InvalidWireTypeException -> 0x004f }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x004f }
        L_0x003a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f5250c     // Catch:{ InvalidWireTypeException -> 0x004f }
            V r5 = r9.f5251d     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x0047:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f5248a     // Catch:{ InvalidWireTypeException -> 0x004f }
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x004f:
            boolean r4 = r7.D()     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0065 }
            r8.<init>(r6)     // Catch:{ all -> 0x0065 }
            throw r8     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r8.put(r2, r3)     // Catch:{ all -> 0x0065 }
            androidx.datastore.preferences.protobuf.h r8 = r7.f5292a
            r8.k(r1)
            return
        L_0x0065:
            r8 = move-exception
            androidx.datastore.preferences.protobuf.h r9 = r7.f5292a
            r9.k(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.O(java.util.Map, androidx.datastore.preferences.protobuf.e0$a, androidx.datastore.preferences.protobuf.n):void");
    }

    public <T> void P(List<T> list, y0<T> y0Var, n nVar) throws IOException {
        int B;
        if (WireFormat.b(this.f5293b) == 3) {
            int i10 = this.f5293b;
            do {
                list.add(S(y0Var, nVar));
                if (!this.f5292a.e() && this.f5295d == 0) {
                    B = this.f5292a.B();
                } else {
                    return;
                }
            } while (B == i10);
            this.f5295d = B;
            return;
        }
        throw InvalidProtocolBufferException.d();
    }

    public void U(List<String> list, boolean z10) throws IOException {
        String str;
        int B;
        int B2;
        if (WireFormat.b(this.f5293b) != 2) {
            throw InvalidProtocolBufferException.d();
        } else if (!(list instanceof a0) || z10) {
            do {
                if (z10) {
                    str = I();
                } else {
                    str = z();
                }
                list.add(str);
                if (!this.f5292a.e()) {
                    B = this.f5292a.B();
                } else {
                    return;
                }
            } while (B == this.f5293b);
            this.f5295d = B;
        } else {
            a0 a0Var = (a0) list;
            do {
                a0Var.b1(o());
                if (!this.f5292a.e()) {
                    B2 = this.f5292a.B();
                } else {
                    return;
                }
            } while (B2 == this.f5293b);
            this.f5295d = B2;
        }
    }

    public int a() {
        return this.f5293b;
    }

    public long b() throws IOException {
        W(1);
        return this.f5292a.r();
    }

    public void c(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 2) {
                int C = this.f5292a.C();
                X(C);
                int d10 = this.f5292a.d() + C;
                do {
                    vVar.U0(this.f5292a.v());
                } while (this.f5292a.d() < d10);
            } else if (b10 == 5) {
                do {
                    vVar.U0(this.f5292a.v());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 2) {
                int C2 = this.f5292a.C();
                X(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Integer.valueOf(this.f5292a.v()));
                } while (this.f5292a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5292a.v()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void d(List<Long> list) throws IOException {
        int B;
        int B2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    c0Var.i(this.f5292a.y());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    c0Var.i(this.f5292a.y());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f5292a.y()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Long.valueOf(this.f5292a.y()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public boolean e() throws IOException {
        W(0);
        return this.f5292a.m();
    }

    public long f() throws IOException {
        W(1);
        return this.f5292a.w();
    }

    public void g(List<Long> list) throws IOException {
        int B;
        int B2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    c0Var.i(this.f5292a.D());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    c0Var.i(this.f5292a.D());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f5292a.D()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Long.valueOf(this.f5292a.D()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int h() throws IOException {
        W(0);
        return this.f5292a.C();
    }

    public void i(List<Long> list) throws IOException {
        int B;
        int B2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    c0Var.i(this.f5292a.u());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    c0Var.i(this.f5292a.u());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f5292a.u()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Long.valueOf(this.f5292a.u()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void j(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f5292a.p());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    vVar.U0(this.f5292a.p());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5292a.p()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Integer.valueOf(this.f5292a.p()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int k() throws IOException {
        W(0);
        return this.f5292a.p();
    }

    public int l() throws IOException {
        W(0);
        return this.f5292a.x();
    }

    public void m(List<Boolean> list) throws IOException {
        int B;
        int B2;
        if (list instanceof f) {
            f fVar = (f) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    fVar.i(this.f5292a.m());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    fVar.i(this.f5292a.m());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f5292a.m()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Boolean.valueOf(this.f5292a.m()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void n(List<String> list) throws IOException {
        U(list, true);
    }

    public ByteString o() throws IOException {
        W(2);
        return this.f5292a.n();
    }

    public int p() throws IOException {
        W(0);
        return this.f5292a.t();
    }

    public void q(List<Long> list) throws IOException {
        int B;
        int B2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 1) {
                do {
                    c0Var.i(this.f5292a.r());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int C = this.f5292a.C();
                Y(C);
                int d10 = this.f5292a.d() + C;
                do {
                    c0Var.i(this.f5292a.r());
                } while (this.f5292a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f5292a.r()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int C2 = this.f5292a.C();
                Y(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Long.valueOf(this.f5292a.r()));
                } while (this.f5292a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void r(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f5292a.x());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    vVar.U0(this.f5292a.x());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5292a.x()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Integer.valueOf(this.f5292a.x()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public double readDouble() throws IOException {
        W(1);
        return this.f5292a.o();
    }

    public float readFloat() throws IOException {
        W(5);
        return this.f5292a.s();
    }

    public long s() throws IOException {
        W(0);
        return this.f5292a.D();
    }

    public void t(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f5292a.C());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    vVar.U0(this.f5292a.C());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5292a.C()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Integer.valueOf(this.f5292a.C()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public int u() throws IOException {
        W(5);
        return this.f5292a.q();
    }

    public void v(List<Long> list) throws IOException {
        int B;
        int B2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 1) {
                do {
                    c0Var.i(this.f5292a.w());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int C = this.f5292a.C();
                Y(C);
                int d10 = this.f5292a.d() + C;
                do {
                    c0Var.i(this.f5292a.w());
                } while (this.f5292a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f5292a.w()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int C2 = this.f5292a.C();
                Y(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Long.valueOf(this.f5292a.w()));
                } while (this.f5292a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void w(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f5292a.t());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else if (b10 == 2) {
                int d10 = this.f5292a.d() + this.f5292a.C();
                do {
                    vVar.U0(this.f5292a.t());
                } while (this.f5292a.d() < d10);
                V(d10);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f5292a.t()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else if (b11 == 2) {
                int d11 = this.f5292a.d() + this.f5292a.C();
                do {
                    list.add(Integer.valueOf(this.f5292a.t()));
                } while (this.f5292a.d() < d11);
                V(d11);
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public void x(List<Integer> list) throws IOException {
        int B;
        int B2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f5293b);
            if (b10 == 2) {
                int C = this.f5292a.C();
                X(C);
                int d10 = this.f5292a.d() + C;
                do {
                    vVar.U0(this.f5292a.q());
                } while (this.f5292a.d() < d10);
            } else if (b10 == 5) {
                do {
                    vVar.U0(this.f5292a.q());
                    if (!this.f5292a.e()) {
                        B2 = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B2 == this.f5293b);
                this.f5295d = B2;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        } else {
            int b11 = WireFormat.b(this.f5293b);
            if (b11 == 2) {
                int C2 = this.f5292a.C();
                X(C2);
                int d11 = this.f5292a.d() + C2;
                do {
                    list.add(Integer.valueOf(this.f5292a.q()));
                } while (this.f5292a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f5292a.q()));
                    if (!this.f5292a.e()) {
                        B = this.f5292a.B();
                    } else {
                        return;
                    }
                } while (B == this.f5293b);
                this.f5295d = B;
            } else {
                throw InvalidProtocolBufferException.d();
            }
        }
    }

    public long y() throws IOException {
        W(0);
        return this.f5292a.y();
    }

    public String z() throws IOException {
        W(2);
        return this.f5292a.z();
    }
}
