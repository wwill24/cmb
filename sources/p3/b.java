package p3;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import i3.e;
import j3.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p3.n;

public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0186b<Data> f16911a;

    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: p3.b$a$a  reason: collision with other inner class name */
        class C0185a implements C0186b<ByteBuffer> {
            C0185a() {
            }

            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        public void a() {
        }

        @NonNull
        public n<byte[], ByteBuffer> c(@NonNull r rVar) {
            return new b(new C0185a());
        }
    }

    /* renamed from: p3.b$b  reason: collision with other inner class name */
    public interface C0186b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class c<Data> implements j3.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f16913a;

        /* renamed from: b  reason: collision with root package name */
        private final C0186b<Data> f16914b;

        c(byte[] bArr, C0186b<Data> bVar) {
            this.f16913a = bArr;
            this.f16914b = bVar;
        }

        @NonNull
        public Class<Data> a() {
            return this.f16914b.a();
        }

        public void b() {
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.f(this.f16914b.b(this.f16913a));
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public static class d implements o<byte[], InputStream> {

        class a implements C0186b<InputStream> {
            a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        public void a() {
        }

        @NonNull
        public n<byte[], InputStream> c(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(C0186b<Data> bVar) {
        this.f16911a = bVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull byte[] bArr, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(bArr), new c(bArr, this.f16911a));
    }

    /* renamed from: d */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
