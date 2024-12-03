package hd;

import com.google.firebase.encoders.proto.Protobuf;

public final class e {

    /* renamed from: c  reason: collision with root package name */
    private static final e f40916c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f40917a;

    /* renamed from: b  reason: collision with root package name */
    private final long f40918b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f40919a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f40920b = 0;

        a() {
        }

        public e a() {
            return new e(this.f40919a, this.f40920b);
        }

        public a b(long j10) {
            this.f40920b = j10;
            return this;
        }

        public a c(long j10) {
            this.f40919a = j10;
            return this;
        }
    }

    e(long j10, long j11) {
        this.f40917a = j10;
        this.f40918b = j11;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 2)
    public long a() {
        return this.f40918b;
    }

    @Protobuf(tag = 1)
    public long b() {
        return this.f40917a;
    }
}
