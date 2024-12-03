package hd;

import com.google.firebase.encoders.proto.Protobuf;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    private static final d f40911c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f40912a;

    /* renamed from: b  reason: collision with root package name */
    private final long f40913b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f40914a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f40915b = 0;

        a() {
        }

        public d a() {
            return new d(this.f40914a, this.f40915b);
        }

        public a b(long j10) {
            this.f40914a = j10;
            return this;
        }

        public a c(long j10) {
            this.f40915b = j10;
            return this;
        }
    }

    d(long j10, long j11) {
        this.f40912a = j10;
        this.f40913b = j11;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f40912a;
    }

    @Protobuf(tag = 2)
    public long b() {
        return this.f40913b;
    }
}
