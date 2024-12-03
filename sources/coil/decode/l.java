package coil.decode;

import android.content.Context;
import coil.decode.k;
import coil.util.j;
import java.io.Closeable;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lokio/Path;", "file", "Lokio/FileSystem;", "fileSystem", "", "diskCacheKey", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/k;", "c", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/io/Closeable;)Lcoil/decode/k;", "Lokio/BufferedSource;", "source", "Landroid/content/Context;", "context", "a", "(Lokio/BufferedSource;Landroid/content/Context;)Lcoil/decode/k;", "Lcoil/decode/k$a;", "metadata", "b", "(Lokio/BufferedSource;Landroid/content/Context;Lcoil/decode/k$a;)Lcoil/decode/k;", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class l {
    public static final k a(BufferedSource bufferedSource, Context context) {
        return new n(bufferedSource, j.n(context), (k.a) null);
    }

    public static final k b(BufferedSource bufferedSource, Context context, k.a aVar) {
        return new n(bufferedSource, j.n(context), aVar);
    }

    public static final k c(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        return new j(path, fileSystem, str, closeable, (k.a) null);
    }

    public static /* synthetic */ k d(Path path, FileSystem fileSystem, String str, Closeable closeable, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fileSystem = FileSystem.f33343b;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            closeable = null;
        }
        return c(path, fileSystem, str, closeable);
    }
}
