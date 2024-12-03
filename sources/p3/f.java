package p3;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p3.n;

public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f16923a;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f16924a;

        public a(d<Data> dVar) {
            this.f16924a = dVar;
        }

        public final void a() {
        }

        @NonNull
        public final n<File, Data> c(@NonNull r rVar) {
            return new f(this.f16924a);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {

        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            /* renamed from: e */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    private static final class c<Data> implements j3.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f16925a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f16926b;

        /* renamed from: c  reason: collision with root package name */
        private Data f16927c;

        c(File file, d<Data> dVar) {
            this.f16925a = file;
            this.f16926b = dVar;
        }

        @NonNull
        public Class<Data> a() {
            return this.f16926b.a();
        }

        public void b() {
            Data data = this.f16927c;
            if (data != null) {
                try {
                    this.f16926b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data c10 = this.f16926b.c(this.f16925a);
                this.f16927c = c10;
                aVar.f(c10);
            } catch (FileNotFoundException e10) {
                Log.isLoggable("FileLoader", 3);
                aVar.c(e10);
            }
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    public static class e extends a<InputStream> {

        class a implements d<InputStream> {
            a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f16923a = dVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull File file, int i10, int i11, @NonNull i3.e eVar) {
        return new n.a<>(new e4.d(file), new c(file, this.f16923a));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
