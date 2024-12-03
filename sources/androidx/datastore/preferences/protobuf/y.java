package androidx.datastore.preferences.protobuf;

public class y {

    /* renamed from: e  reason: collision with root package name */
    private static final n f5394e = n.b();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f5395a;

    /* renamed from: b  reason: collision with root package name */
    private n f5396b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile k0 f5397c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f5398d;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f5397c = r4;
        r3.f5398d = androidx.datastore.preferences.protobuf.ByteString.f5064a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.datastore.preferences.protobuf.k0 r4) {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.k0 r0 = r3.f5397c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            androidx.datastore.preferences.protobuf.k0 r0 = r3.f5397c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f5395a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.s0 r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r1 = r3.f5395a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.n r2 = r3.f5396b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.a(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.k0 r0 = (androidx.datastore.preferences.protobuf.k0) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f5397c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.f5395a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f5398d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f5397c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.f5064a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f5398d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f5397c = r4     // Catch:{ all -> 0x0034 }
            androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.f5064a     // Catch:{ all -> 0x0034 }
            r3.f5398d = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.y.a(androidx.datastore.preferences.protobuf.k0):void");
    }

    public int b() {
        if (this.f5398d != null) {
            return this.f5398d.size();
        }
        ByteString byteString = this.f5395a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f5397c != null) {
            return this.f5397c.getSerializedSize();
        }
        return 0;
    }

    public k0 c(k0 k0Var) {
        a(k0Var);
        return this.f5397c;
    }

    public k0 d(k0 k0Var) {
        k0 k0Var2 = this.f5397c;
        this.f5395a = null;
        this.f5398d = null;
        this.f5397c = k0Var;
        return k0Var2;
    }

    public ByteString e() {
        if (this.f5398d != null) {
            return this.f5398d;
        }
        ByteString byteString = this.f5395a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f5398d != null) {
                ByteString byteString2 = this.f5398d;
                return byteString2;
            }
            if (this.f5397c == null) {
                this.f5398d = ByteString.f5064a;
            } else {
                this.f5398d = this.f5397c.toByteString();
            }
            ByteString byteString3 = this.f5398d;
            return byteString3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        k0 k0Var = this.f5397c;
        k0 k0Var2 = yVar.f5397c;
        if (k0Var == null && k0Var2 == null) {
            return e().equals(yVar.e());
        }
        if (k0Var != null && k0Var2 != null) {
            return k0Var.equals(k0Var2);
        }
        if (k0Var != null) {
            return k0Var.equals(yVar.c(k0Var.getDefaultInstanceForType()));
        }
        return c(k0Var2.getDefaultInstanceForType()).equals(k0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
