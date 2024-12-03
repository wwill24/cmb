package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lokio/Path;", "it", "a", "(Lokio/Path;)Lokio/Path;"}, k = 3, mv = {1, 6, 0})
final class ForwardingFileSystem$listRecursively$1 extends Lambda implements Function1<Path, Path> {
    final /* synthetic */ ForwardingFileSystem this$0;

    /* renamed from: a */
    public final Path invoke(Path path) {
        j.g(path, "it");
        return this.this$0.s(path, "listRecursively");
    }
}
