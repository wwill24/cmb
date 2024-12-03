package coil.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"Lokio/FileSystem;", "Lokio/Path;", "file", "", "a", "directory", "b", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class e {
    public static final void a(FileSystem fileSystem, Path path) {
        if (!fileSystem.j(path)) {
            j.d(fileSystem.o(path));
        }
    }

    public static final void b(FileSystem fileSystem, Path path) {
        try {
            IOException iOException = null;
            for (Path next : fileSystem.k(path)) {
                try {
                    if (fileSystem.l(next).f()) {
                        b(fileSystem, next);
                    }
                    fileSystem.h(next);
                } catch (IOException e10) {
                    if (iOException == null) {
                        iOException = e10;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
