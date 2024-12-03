package p3;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import p3.n;

public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f16917a;

    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    private static final class b<Data> implements d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f16918a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f16919b;

        /* renamed from: c  reason: collision with root package name */
        private Data f16920c;

        b(String str, a<Data> aVar) {
            this.f16918a = str;
            this.f16919b = aVar;
        }

        @NonNull
        public Class<Data> a() {
            return this.f16919b.a();
        }

        public void b() {
            try {
                this.f16919b.b(this.f16920c);
            } catch (IOException unused) {
            }
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data decode = this.f16919b.decode(this.f16918a);
                this.f16920c = decode;
                aVar.f(decode);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f16921a = new a();

        class a implements a<InputStream> {
            a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: d */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        public void a() {
        }

        @NonNull
        public n<Model, InputStream> c(@NonNull r rVar) {
            return new e(this.f16921a);
        }
    }

    public e(a<Data> aVar) {
        this.f16917a = aVar;
    }

    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    public n.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull i3.e eVar) {
        return new n.a<>(new e4.d(model), new b(model.toString(), this.f16917a));
    }
}
