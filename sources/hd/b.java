package hd;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final b f40903b = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final d f40904a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d f40905a = null;

        a() {
        }

        public b a() {
            return new b(this.f40905a);
        }

        public a b(d dVar) {
            this.f40905a = dVar;
            return this;
        }
    }

    b(d dVar) {
        this.f40904a = dVar;
    }

    public static a b() {
        return new a();
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "storageMetrics")
    public d a() {
        return this.f40904a;
    }
}
