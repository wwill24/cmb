package com.google.crypto.tink.shaded.protobuf;

public class z {

    /* renamed from: e  reason: collision with root package name */
    private static final o f20929e = o.b();

    /* renamed from: a  reason: collision with root package name */
    private ByteString f20930a;

    /* renamed from: b  reason: collision with root package name */
    private o f20931b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile l0 f20932c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f20933d;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f20932c = r4;
        r3.f20933d = com.google.crypto.tink.shaded.protobuf.ByteString.f20615a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.crypto.tink.shaded.protobuf.l0 r4) {
        /*
            r3 = this;
            com.google.crypto.tink.shaded.protobuf.l0 r0 = r3.f20932c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.crypto.tink.shaded.protobuf.l0 r0 = r3.f20932c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = r3.f20930a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.crypto.tink.shaded.protobuf.t0 r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.crypto.tink.shaded.protobuf.ByteString r1 = r3.f20930a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.crypto.tink.shaded.protobuf.o r2 = r3.f20931b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.b(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.crypto.tink.shaded.protobuf.l0 r0 = (com.google.crypto.tink.shaded.protobuf.l0) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f20932c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = r3.f20930a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f20933d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f20932c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = com.google.crypto.tink.shaded.protobuf.ByteString.f20615a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f20933d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f20932c = r4     // Catch:{ all -> 0x0034 }
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = com.google.crypto.tink.shaded.protobuf.ByteString.f20615a     // Catch:{ all -> 0x0034 }
            r3.f20933d = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.z.a(com.google.crypto.tink.shaded.protobuf.l0):void");
    }

    public int b() {
        if (this.f20933d != null) {
            return this.f20933d.size();
        }
        ByteString byteString = this.f20930a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f20932c != null) {
            return this.f20932c.getSerializedSize();
        }
        return 0;
    }

    public l0 c(l0 l0Var) {
        a(l0Var);
        return this.f20932c;
    }

    public l0 d(l0 l0Var) {
        l0 l0Var2 = this.f20932c;
        this.f20930a = null;
        this.f20933d = null;
        this.f20932c = l0Var;
        return l0Var2;
    }

    public ByteString e() {
        if (this.f20933d != null) {
            return this.f20933d;
        }
        ByteString byteString = this.f20930a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f20933d != null) {
                ByteString byteString2 = this.f20933d;
                return byteString2;
            }
            if (this.f20932c == null) {
                this.f20933d = ByteString.f20615a;
            } else {
                this.f20933d = this.f20932c.toByteString();
            }
            ByteString byteString3 = this.f20933d;
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
        l0 l0Var = this.f20932c;
        l0 l0Var2 = zVar.f20932c;
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
