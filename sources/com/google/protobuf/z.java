package com.google.protobuf;

public class z {

    /* renamed from: e  reason: collision with root package name */
    private static final n f21979e = n.b();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f21980a;

    /* renamed from: b  reason: collision with root package name */
    private n f21981b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile l0 f21982c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f21983d;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f21982c = r4;
        r3.f21983d = com.google.protobuf.ByteString.f21603a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.protobuf.l0 r4) {
        /*
            r3 = this;
            com.google.protobuf.l0 r0 = r3.f21982c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.l0 r0 = r3.f21982c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.protobuf.ByteString r0 = r3.f21980a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.t0 r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r1 = r3.f21980a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.n r2 = r3.f21981b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.a(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.l0 r0 = (com.google.protobuf.l0) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f21982c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = r3.f21980a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f21983d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f21982c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.f21603a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f21983d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f21982c = r4     // Catch:{ all -> 0x0034 }
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.f21603a     // Catch:{ all -> 0x0034 }
            r3.f21983d = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z.a(com.google.protobuf.l0):void");
    }

    public int b() {
        if (this.f21983d != null) {
            return this.f21983d.size();
        }
        ByteString byteString = this.f21980a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f21982c != null) {
            return this.f21982c.getSerializedSize();
        }
        return 0;
    }

    public l0 c(l0 l0Var) {
        a(l0Var);
        return this.f21982c;
    }

    public l0 d(l0 l0Var) {
        l0 l0Var2 = this.f21982c;
        this.f21980a = null;
        this.f21983d = null;
        this.f21982c = l0Var;
        return l0Var2;
    }

    public ByteString e() {
        if (this.f21983d != null) {
            return this.f21983d;
        }
        ByteString byteString = this.f21980a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f21983d != null) {
                ByteString byteString2 = this.f21983d;
                return byteString2;
            }
            if (this.f21982c == null) {
                this.f21983d = ByteString.f21603a;
            } else {
                this.f21983d = this.f21982c.toByteString();
            }
            ByteString byteString3 = this.f21983d;
            return byteString3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        l0 l0Var = this.f21982c;
        l0 l0Var2 = zVar.f21982c;
        if (l0Var == null && l0Var2 == null) {
            return e().equals(zVar.e());
        }
        if (l0Var != null && l0Var2 != null) {
            return l0Var.equals(l0Var2);
        }
        if (l0Var != null) {
            return l0Var.equals(zVar.c(l0Var.getDefaultInstanceForType()));
        }
        return c(l0Var2.getDefaultInstanceForType()).equals(l0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
