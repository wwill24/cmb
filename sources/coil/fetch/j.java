package coil.fetch;

import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.l;
import coil.fetch.i;
import coil.request.k;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.c;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcoil/fetch/j;", "Lcoil/fetch/i;", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/io/File;", "Ljava/io/File;", "data", "<init>", "(Ljava/io/File;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final File f8197a;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcoil/fetch/j$a;", "Lcoil/fetch/i$a;", "Ljava/io/File;", "data", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements i.a<File> {
        /* renamed from: b */
        public i a(File file, k kVar, ImageLoader imageLoader) {
            return new j(file);
        }
    }

    public j(File file) {
        this.f8197a = file;
    }

    public Object a(c<? super h> cVar) {
        return new l(l.d(Path.Companion.d(Path.f33379b, this.f8197a, false, 1, (Object) null), (FileSystem) null, (String) null, (Closeable) null, 14, (Object) null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(j.l(this.f8197a)), DataSource.DISK);
    }
}
