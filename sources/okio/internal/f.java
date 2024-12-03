package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.j;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005H\u0000¨\u0006\u000b"}, d2 = {"Lokio/FileSystem;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "c", "", "b", "dir", "mustCreate", "", "a", "okio"}, k = 2, mv = {1, 6, 0})
public final class f {
    public static final void a(FileSystem fileSystem, Path path, boolean z10) throws IOException {
        j.g(fileSystem, "<this>");
        j.g(path, "dir");
        g gVar = new g();
        Path path2 = path;
        while (path2 != null && !fileSystem.j(path2)) {
            gVar.addFirst(path2);
            path2 = path2.i();
        }
        if (!z10 || !gVar.isEmpty()) {
            Iterator it = gVar.iterator();
            while (it.hasNext()) {
                fileSystem.f((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exist.");
    }

    public static final boolean b(FileSystem fileSystem, Path path) throws IOException {
        j.g(fileSystem, "<this>");
        j.g(path, "path");
        return fileSystem.m(path) != null;
    }

    public static final FileMetadata c(FileSystem fileSystem, Path path) throws IOException {
        j.g(fileSystem, "<this>");
        j.g(path, "path");
        FileMetadata m10 = fileSystem.m(path);
        if (m10 != null) {
            return m10;
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
