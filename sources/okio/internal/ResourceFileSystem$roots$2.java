package okio.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lkotlin/Pair;", "Lokio/FileSystem;", "Lokio/Path;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 6, 0})
final class ResourceFileSystem$roots$2 extends Lambda implements Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResourceFileSystem$roots$2(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    /* renamed from: a */
    public final List<Pair<FileSystem, Path>> invoke() {
        return ResourceFileSystem.f33444f.e(this.$classLoader);
    }
}
