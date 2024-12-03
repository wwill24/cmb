package coil.disk;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.x0;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0003\u0007\u000e\u000fJ\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H'R\u001a\u0010\r\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/disk/a;", "", "", "key", "Lcoil/disk/a$c;", "get", "Lcoil/disk/a$b;", "a", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "getFileSystem$annotations", "()V", "fileSystem", "b", "c", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface a {

    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcoil/disk/a$a;", "", "Ljava/io/File;", "directory", "b", "Lokio/Path;", "c", "Lcoil/disk/a;", "a", "Lokio/Path;", "Lokio/FileSystem;", "Lokio/FileSystem;", "fileSystem", "", "D", "maxSizePercent", "", "d", "J", "minimumMaxSizeBytes", "e", "maximumMaxSizeBytes", "f", "maxSizeBytes", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.disk.a$a  reason: collision with other inner class name */
    public static final class C0101a {

        /* renamed from: a  reason: collision with root package name */
        private Path f8157a;

        /* renamed from: b  reason: collision with root package name */
        private FileSystem f8158b = FileSystem.f33343b;

        /* renamed from: c  reason: collision with root package name */
        private double f8159c = 0.02d;

        /* renamed from: d  reason: collision with root package name */
        private long f8160d = 10485760;

        /* renamed from: e  reason: collision with root package name */
        private long f8161e = 262144000;

        /* renamed from: f  reason: collision with root package name */
        private long f8162f;

        /* renamed from: g  reason: collision with root package name */
        private CoroutineDispatcher f8163g = x0.b();

        public final a a() {
            long j10;
            Path path = this.f8157a;
            if (path != null) {
                if (this.f8159c > 0.0d) {
                    try {
                        StatFs statFs = new StatFs(path.toFile().getAbsolutePath());
                        j10 = j.k((long) (this.f8159c * ((double) statFs.getBlockCountLong()) * ((double) statFs.getBlockSizeLong())), this.f8160d, this.f8161e);
                    } catch (Exception unused) {
                        j10 = this.f8160d;
                    }
                } else {
                    j10 = this.f8162f;
                }
                return new c(j10, path, this.f8158b, this.f8163g);
            }
            throw new IllegalStateException("directory == null".toString());
        }

        public final C0101a b(File file) {
            return c(Path.Companion.d(Path.f33379b, file, false, 1, (Object) null));
        }

        public final C0101a c(Path path) {
            this.f8157a = path;
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcoil/disk/a$b;", "", "Lcoil/disk/a$c;", "t", "", "abort", "Lokio/Path;", "s", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public interface b {
        void abort();

        Path getData();

        Path s();

        c t();
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00060\u0001j\u0002`\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcoil/disk/a$c;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lcoil/disk/a$b;", "v1", "Lokio/Path;", "s", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public interface c extends Closeable {
        Path getData();

        Path s();

        b v1();
    }

    b a(String str);

    c get(String str);

    FileSystem getFileSystem();
}
