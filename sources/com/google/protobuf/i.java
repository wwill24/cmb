package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

final class i implements y0 {

    /* renamed from: a  reason: collision with root package name */
    private final h f21857a;

    /* renamed from: b  reason: collision with root package name */
    private int f21858b;

    /* renamed from: c  reason: collision with root package name */
    private int f21859c;

    /* renamed from: d  reason: collision with root package name */
    private int f21860d = 0;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21861a;

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
                f21861a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f21861a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.i.a.<clinit>():void");
        }
    }

    private i(h hVar) {
        h hVar2 = (h) w.b(hVar, "input");
        this.f21857a = hVar2;
        hVar2.f21812d = this;
    }

    public static i Q(h hVar) {
        i iVar = hVar.f21812d;
        if (iVar != null) {
            return iVar;
        }
        return new i(hVar);
    }

    private <T> void R(T t10, z0<T> z0Var, n nVar) throws IOException {
        int i10 = this.f21859c;
        this.f21859c = WireFormat.c(WireFormat.a(this.f21858b), 4);
        try {
            z0Var.f(t10, this, nVar);
            if (this.f21858b != this.f21859c) {
                throw InvalidProtocolBufferException.h();
            }
        } finally {
            this.f21859c = i10;
        }
    }

    private <T> void S(T t10, z0<T> z0Var, n nVar) throws IOException {
        int G = this.f21857a.G();
        h hVar = this.f21857a;
        if (hVar.f21809a < hVar.f21810b) {
            int o10 = hVar.o(G);
            this.f21857a.f21809a++;
            z0Var.f(t10, this, nVar);
            this.f21857a.a(0);
            h hVar2 = this.f21857a;
            hVar2.f21809a--;
            hVar2.n(o10);
            return;
        }
        throw InvalidProtocolBufferException.i();
    }

    private Object T(WireFormat.FieldType fieldType, Class<?> cls, n nVar) throws IOException {
        switch (a.f21861a[fieldType.ordinal()]) {
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
                return N(cls, nVar);
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
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T U(z0<T> z0Var, n nVar) throws IOException {
        T newInstance = z0Var.newInstance();
        R(newInstance, z0Var, nVar);
        z0Var.b(newInstance);
        return newInstance;
    }

    private <T> T V(z0<T> z0Var, n nVar) throws IOException {
        T newInstance = z0Var.newInstance();
        S(newInstance, z0Var, nVar);
        z0Var.b(newInstance);
        return newInstance;
    }

    private void X(int i10) throws IOException {
        if (this.f21857a.d() != i10) {
            throw InvalidProtocolBufferException.m();
        }
    }

    private void Y(int i10) throws IOException {
        if (WireFormat.b(this.f21858b) != i10) {
            throw InvalidProtocolBufferException.e();
        }
    }

    private void Z(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    private void a0(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    public int A() throws IOException {
        int i10 = this.f21860d;
        if (i10 != 0) {
            this.f21858b = i10;
            this.f21860d = 0;
        } else {
            this.f21858b = this.f21857a.F();
        }
        int i11 = this.f21858b;
        if (i11 == 0 || i11 == this.f21859c) {
            return a.e.API_PRIORITY_OTHER;
        }
        return WireFormat.a(i11);
    }

    public void B(List<String> list) throws IOException {
        W(list, false);
    }

    public void C(List<Float> list) throws IOException {
        int F;
        int F2;
        if (list instanceof t) {
            t tVar = (t) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 2) {
                int G = this.f21857a.G();
                Z(G);
                int d10 = this.f21857a.d() + G;
                do {
                    tVar.g(this.f21857a.v());
                } while (this.f21857a.d() < d10);
            } else if (b10 == 5) {
                do {
                    tVar.g(this.f21857a.v());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 2) {
                int G2 = this.f21857a.G();
                Z(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Float.valueOf(this.f21857a.v()));
                } while (this.f21857a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Float.valueOf(this.f21857a.v()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public boolean D() throws IOException {
        int i10;
        if (this.f21857a.e() || (i10 = this.f21858b) == this.f21859c) {
            return false;
        }
        return this.f21857a.I(i10);
    }

    public int E() throws IOException {
        Y(5);
        return this.f21857a.z();
    }

    public void F(List<ByteString> list) throws IOException {
        int F;
        if (WireFormat.b(this.f21858b) == 2) {
            do {
                list.add(o());
                if (!this.f21857a.e()) {
                    F = this.f21857a.F();
                } else {
                    return;
                }
            } while (F == this.f21858b);
            this.f21860d = F;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    public void G(List<Double> list) throws IOException {
        int F;
        int F2;
        if (list instanceof k) {
            k kVar = (k) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 1) {
                do {
                    kVar.g(this.f21857a.r());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int G = this.f21857a.G();
                a0(G);
                int d10 = this.f21857a.d() + G;
                do {
                    kVar.g(this.f21857a.r());
                } while (this.f21857a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 1) {
                do {
                    list.add(Double.valueOf(this.f21857a.r()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int G2 = this.f21857a.G();
                a0(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Double.valueOf(this.f21857a.r()));
                } while (this.f21857a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public long H() throws IOException {
        Y(0);
        return this.f21857a.x();
    }

    public String I() throws IOException {
        Y(2);
        return this.f21857a.E();
    }

    @Deprecated
    public <T> void J(List<T> list, z0<T> z0Var, n nVar) throws IOException {
        int F;
        if (WireFormat.b(this.f21858b) == 3) {
            int i10 = this.f21858b;
            do {
                list.add(U(z0Var, nVar));
                if (!this.f21857a.e() && this.f21860d == 0) {
                    F = this.f21857a.F();
                } else {
                    return;
                }
            } while (F == i10);
            this.f21860d = F;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    public <T> void K(List<T> list, z0<T> z0Var, n nVar) throws IOException {
        int F;
        if (WireFormat.b(this.f21858b) == 2) {
            int i10 = this.f21858b;
            do {
                list.add(V(z0Var, nVar));
                if (!this.f21857a.e() && this.f21860d == 0) {
                    F = this.f21857a.F();
                } else {
                    return;
                }
            } while (F == i10);
            this.f21860d = F;
            return;
        }
        throw InvalidProtocolBufferException.e();
    }

    @Deprecated
    public <T> T L(Class<T> cls, n nVar) throws IOException {
        Y(3);
        return U(v0.a().c(cls), nVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (D() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        throw new com.google.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K, V> void M(java.util.Map<K, V> r8, com.google.protobuf.f0.a<K, V> r9, com.google.protobuf.n r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.Y(r0)
            com.google.protobuf.h r1 = r7.f21857a
            int r1 = r1.G()
            com.google.protobuf.h r2 = r7.f21857a
            int r1 = r2.o(r1)
            K r2 = r9.f21799b
            V r3 = r9.f21801d
        L_0x0014:
            int r4 = r7.A()     // Catch:{ all -> 0x0065 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005c
            com.google.protobuf.h r5 = r7.f21857a     // Catch:{ all -> 0x0065 }
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
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004f }
            r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004f }
            throw r4     // Catch:{ InvalidWireTypeException -> 0x004f }
        L_0x003a:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f21800c     // Catch:{ InvalidWireTypeException -> 0x004f }
            V r5 = r9.f21801d     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004f }
            java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x0047:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f21798a     // Catch:{ InvalidWireTypeException -> 0x004f }
            r5 = 0
            java.lang.Object r2 = r7.T(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004f }
            goto L_0x0014
        L_0x004f:
            boolean r4 = r7.D()     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0065 }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0065 }
            throw r8     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r8.put(r2, r3)     // Catch:{ all -> 0x0065 }
            com.google.protobuf.h r8 = r7.f21857a
            r8.n(r1)
            return
        L_0x0065:
            r8 = move-exception
            com.google.protobuf.h r9 = r7.f21857a
            r9.n(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.i.M(java.util.Map, com.google.protobuf.f0$a, com.google.protobuf.n):void");
    }

    public <T> T N(Class<T> cls, n nVar) throws IOException {
        Y(2);
        return V(v0.a().c(cls), nVar);
    }

    public <T> void O(T t10, z0<T> z0Var, n nVar) throws IOException {
        Y(3);
        R(t10, z0Var, nVar);
    }

    public <T> void P(T t10, z0<T> z0Var, n nVar) throws IOException {
        Y(2);
        S(t10, z0Var, nVar);
    }

    public void W(List<String> list, boolean z10) throws IOException {
        String str;
        int F;
        int F2;
        if (WireFormat.b(this.f21858b) != 2) {
            throw InvalidProtocolBufferException.e();
        } else if (!(list instanceof b0) || z10) {
            do {
                if (z10) {
                    str = I();
                } else {
                    str = z();
                }
                list.add(str);
                if (!this.f21857a.e()) {
                    F = this.f21857a.F();
                } else {
                    return;
                }
            } while (F == this.f21858b);
            this.f21860d = F;
        } else {
            b0 b0Var = (b0) list;
            do {
                b0Var.I(o());
                if (!this.f21857a.e()) {
                    F2 = this.f21857a.F();
                } else {
                    return;
                }
            } while (F2 == this.f21858b);
            this.f21860d = F2;
        }
    }

    public int a() {
        return this.f21858b;
    }

    public long b() throws IOException {
        Y(1);
        return this.f21857a.u();
    }

    public void c(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 2) {
                int G = this.f21857a.G();
                Z(G);
                int d10 = this.f21857a.d() + G;
                do {
                    vVar.U0(this.f21857a.z());
                } while (this.f21857a.d() < d10);
            } else if (b10 == 5) {
                do {
                    vVar.U0(this.f21857a.z());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 2) {
                int G2 = this.f21857a.G();
                Z(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Integer.valueOf(this.f21857a.z()));
                } while (this.f21857a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f21857a.z()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void d(List<Long> list) throws IOException {
        int F;
        int F2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f21857a.C());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    d0Var.i(this.f21857a.C());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f21857a.C()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Long.valueOf(this.f21857a.C()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public boolean e() throws IOException {
        Y(0);
        return this.f21857a.p();
    }

    public long f() throws IOException {
        Y(1);
        return this.f21857a.A();
    }

    public void g(List<Long> list) throws IOException {
        int F;
        int F2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f21857a.H());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    d0Var.i(this.f21857a.H());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f21857a.H()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Long.valueOf(this.f21857a.H()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public int h() throws IOException {
        Y(0);
        return this.f21857a.G();
    }

    public void i(List<Long> list) throws IOException {
        int F;
        int F2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    d0Var.i(this.f21857a.x());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    d0Var.i(this.f21857a.x());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Long.valueOf(this.f21857a.x()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Long.valueOf(this.f21857a.x()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void j(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f21857a.s());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    vVar.U0(this.f21857a.s());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f21857a.s()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Integer.valueOf(this.f21857a.s()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public int k() throws IOException {
        Y(0);
        return this.f21857a.s();
    }

    public int l() throws IOException {
        Y(0);
        return this.f21857a.B();
    }

    public void m(List<Boolean> list) throws IOException {
        int F;
        int F2;
        if (list instanceof f) {
            f fVar = (f) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    fVar.i(this.f21857a.p());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    fVar.i(this.f21857a.p());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f21857a.p()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Boolean.valueOf(this.f21857a.p()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void n(List<String> list) throws IOException {
        W(list, true);
    }

    public ByteString o() throws IOException {
        Y(2);
        return this.f21857a.q();
    }

    public int p() throws IOException {
        Y(0);
        return this.f21857a.w();
    }

    public void q(List<Long> list) throws IOException {
        int F;
        int F2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 1) {
                do {
                    d0Var.i(this.f21857a.u());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int G = this.f21857a.G();
                a0(G);
                int d10 = this.f21857a.d() + G;
                do {
                    d0Var.i(this.f21857a.u());
                } while (this.f21857a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f21857a.u()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int G2 = this.f21857a.G();
                a0(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Long.valueOf(this.f21857a.u()));
                } while (this.f21857a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void r(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f21857a.B());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    vVar.U0(this.f21857a.B());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f21857a.B()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Integer.valueOf(this.f21857a.B()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public double readDouble() throws IOException {
        Y(1);
        return this.f21857a.r();
    }

    public float readFloat() throws IOException {
        Y(5);
        return this.f21857a.v();
    }

    public long s() throws IOException {
        Y(0);
        return this.f21857a.H();
    }

    public void t(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f21857a.G());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    vVar.U0(this.f21857a.G());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f21857a.G()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Integer.valueOf(this.f21857a.G()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public int u() throws IOException {
        Y(5);
        return this.f21857a.t();
    }

    public void v(List<Long> list) throws IOException {
        int F;
        int F2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 1) {
                do {
                    d0Var.i(this.f21857a.A());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int G = this.f21857a.G();
                a0(G);
                int d10 = this.f21857a.d() + G;
                do {
                    d0Var.i(this.f21857a.A());
                } while (this.f21857a.d() < d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 1) {
                do {
                    list.add(Long.valueOf(this.f21857a.A()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int G2 = this.f21857a.G();
                a0(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Long.valueOf(this.f21857a.A()));
                } while (this.f21857a.d() < d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void w(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 0) {
                do {
                    vVar.U0(this.f21857a.w());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else if (b10 == 2) {
                int d10 = this.f21857a.d() + this.f21857a.G();
                do {
                    vVar.U0(this.f21857a.w());
                } while (this.f21857a.d() < d10);
                X(d10);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 0) {
                do {
                    list.add(Integer.valueOf(this.f21857a.w()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else if (b11 == 2) {
                int d11 = this.f21857a.d() + this.f21857a.G();
                do {
                    list.add(Integer.valueOf(this.f21857a.w()));
                } while (this.f21857a.d() < d11);
                X(d11);
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void x(List<Integer> list) throws IOException {
        int F;
        int F2;
        if (list instanceof v) {
            v vVar = (v) list;
            int b10 = WireFormat.b(this.f21858b);
            if (b10 == 2) {
                int G = this.f21857a.G();
                Z(G);
                int d10 = this.f21857a.d() + G;
                do {
                    vVar.U0(this.f21857a.t());
                } while (this.f21857a.d() < d10);
            } else if (b10 == 5) {
                do {
                    vVar.U0(this.f21857a.t());
                    if (!this.f21857a.e()) {
                        F2 = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F2 == this.f21858b);
                this.f21860d = F2;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        } else {
            int b11 = WireFormat.b(this.f21858b);
            if (b11 == 2) {
                int G2 = this.f21857a.G();
                Z(G2);
                int d11 = this.f21857a.d() + G2;
                do {
                    list.add(Integer.valueOf(this.f21857a.t()));
                } while (this.f21857a.d() < d11);
            } else if (b11 == 5) {
                do {
                    list.add(Integer.valueOf(this.f21857a.t()));
                    if (!this.f21857a.e()) {
                        F = this.f21857a.F();
                    } else {
                        return;
                    }
                } while (F == this.f21858b);
                this.f21860d = F;
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public long y() throws IOException {
        Y(0);
        return this.f21857a.C();
    }

    public String z() throws IOException {
        Y(2);
        return this.f21857a.D();
    }
}
