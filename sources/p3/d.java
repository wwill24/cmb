package p3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import i3.e;
import j3.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p3.n;

public class d implements n<File, ByteBuffer> {

    private static final class a implements j3.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f16916a;

        a(File file) {
            this.f16916a = file;
        }

        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(f4.a.a(this.f16916a));
            } catch (IOException e10) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.c(e10);
            }
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public static class b implements o<File, ByteBuffer> {
        public void a() {
        }

        @NonNull
        public n<File, ByteBuffer> c(@NonNull r rVar) {
            return new d();
        }
    }

    /* renamed from: c */
    public n.a<ByteBuffer> b(@NonNull File file, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(file), new a(file));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
