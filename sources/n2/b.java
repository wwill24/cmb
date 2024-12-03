package n2;

import android.net.Uri;
import coil.request.k;
import coil.util.j;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Ln2/b;", "Ln2/d;", "Landroid/net/Uri;", "Ljava/io/File;", "data", "", "b", "Lcoil/request/k;", "options", "c", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class b implements d<Uri, File> {
    private final boolean b(Uri uri) {
        boolean z10;
        if (!j.r(uri)) {
            String scheme = uri.getScheme();
            if (scheme == null || kotlin.jvm.internal.j.b(scheme, "file")) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                String path = uri.getPath();
                if (path == null) {
                    path = "";
                }
                if (StringsKt__StringsKt.H0(path, '/', false, 2, (Object) null) && j.i(uri) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public File a(Uri uri, k kVar) {
        if (!b(uri)) {
            return null;
        }
        if (uri.getScheme() != null) {
            uri = uri.buildUpon().scheme((String) null).build();
        }
        return new File(uri.toString());
    }
}
