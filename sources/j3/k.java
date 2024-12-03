package j3;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import j3.e;
import java.io.IOException;
import java.io.InputStream;
import m3.b;

public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f15574a;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f15575a;

        public a(b bVar) {
            this.f15575a = bVar;
        }

        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @NonNull
        /* renamed from: c */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f15575a);
        }
    }

    public k(InputStream inputStream, b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f15574a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void b() {
        this.f15574a.c();
    }

    public void c() {
        this.f15574a.b();
    }

    @NonNull
    /* renamed from: d */
    public InputStream a() throws IOException {
        this.f15574a.reset();
        return this.f15574a;
    }
}
