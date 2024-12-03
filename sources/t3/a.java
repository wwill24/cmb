package t3;

import androidx.annotation.NonNull;
import j3.e;
import java.nio.ByteBuffer;

public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f17796a;

    /* renamed from: t3.a$a  reason: collision with other inner class name */
    public static class C0208a implements e.a<ByteBuffer> {
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @NonNull
        /* renamed from: c */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f17796a = byteBuffer;
    }

    public void b() {
    }

    @NonNull
    /* renamed from: c */
    public ByteBuffer a() {
        this.f17796a.position(0);
        return this.f17796a;
    }
}
