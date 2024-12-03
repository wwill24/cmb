package m2;

import coil.request.k;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lm2/a;", "Lm2/b;", "Ljava/io/File;", "data", "Lcoil/request/k;", "options", "", "b", "", "a", "Z", "addLastModifiedToFileCacheKey", "<init>", "(Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a implements b<File> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16284a;

    public a(boolean z10) {
        this.f16284a = z10;
    }

    /* renamed from: b */
    public String a(File file, k kVar) {
        if (!this.f16284a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
