package md;

import md.e;

final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private final long f41182b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41183c;

    /* renamed from: d  reason: collision with root package name */
    private final int f41184d;

    /* renamed from: e  reason: collision with root package name */
    private final long f41185e;

    /* renamed from: f  reason: collision with root package name */
    private final int f41186f;

    static final class b extends e.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f41187a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f41188b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f41189c;

        /* renamed from: d  reason: collision with root package name */
        private Long f41190d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f41191e;

        b() {
        }

        /* access modifiers changed from: package-private */
        public e a() {
            String str = "";
            if (this.f41187a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f41188b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f41189c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f41190d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f41191e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f41187a.longValue(), this.f41188b.intValue(), this.f41189c.intValue(), this.f41190d.longValue(), this.f41191e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public e.a b(int i10) {
            this.f41189c = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public e.a c(long j10) {
            this.f41190d = Long.valueOf(j10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public e.a d(int i10) {
            this.f41188b = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public e.a e(int i10) {
            this.f41191e = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public e.a f(long j10) {
            this.f41187a = Long.valueOf(j10);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f41184d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f41185e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f41183c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f41186f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f41182b == eVar.f() && this.f41183c == eVar.d() && this.f41184d == eVar.b() && this.f41185e == eVar.c() && this.f41186f == eVar.e()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f41182b;
    }

    public int hashCode() {
        long j10 = this.f41182b;
        long j11 = this.f41185e;
        return ((((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f41183c) * 1000003) ^ this.f41184d) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f41186f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f41182b + ", loadBatchSize=" + this.f41183c + ", criticalSectionEnterTimeoutMs=" + this.f41184d + ", eventCleanUpAge=" + this.f41185e + ", maxBlobByteSizePerRow=" + this.f41186f + "}";
    }

    private a(long j10, int i10, int i11, long j11, int i12) {
        this.f41182b = j10;
        this.f41183c = i10;
        this.f41184d = i11;
        this.f41185e = j11;
        this.f41186f = i12;
    }
}
