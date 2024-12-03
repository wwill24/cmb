package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jivesoftware.smack.sm.packet.StreamManagement;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002J\f\u0010\n\u001a\u00020\b*\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016¨\u0006\""}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "dir", "", "throwOnFailure", "", "r", "", "t", "s", "path", "Lokio/FileMetadata;", "m", "k", "file", "Lokio/FileHandle;", "n", "Lokio/Source;", "q", "mustCreate", "Lokio/Sink;", "p", "mustExist", "b", "g", "source", "target", "c", "i", "", "toString", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
public class JvmSystemFileSystem extends FileSystem {
    private final List<Path> r(Path path, boolean z10) {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                j.f(str, "it");
                arrayList.add(path.k(str));
            }
            u.v(arrayList);
            return arrayList;
        } else if (!z10) {
            return null;
        } else {
            if (!file.exists()) {
                throw new FileNotFoundException("no such file: " + path);
            }
            throw new IOException("failed to list " + path);
        }
    }

    private final void s(Path path) {
        if (j(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void t(Path path) {
        if (!j(path)) {
            throw new IOException(path + " doesn't exist.");
        }
    }

    public Sink b(Path path, boolean z10) {
        j.g(path, "file");
        if (z10) {
            t(path);
        }
        return Okio.e(path.toFile(), true);
    }

    public void c(Path path, Path path2) {
        j.g(path, "source");
        j.g(path2, TypeProxy.INSTANCE_FIELD);
        if (!path.toFile().renameTo(path2.toFile())) {
            throw new IOException("failed to move " + path + " to " + path2);
        }
    }

    public void g(Path path, boolean z10) {
        j.g(path, "dir");
        if (!path.toFile().mkdir()) {
            FileMetadata m10 = m(path);
            boolean z11 = true;
            if (m10 == null || !m10.f()) {
                z11 = false;
            }
            if (!z11) {
                throw new IOException("failed to create directory: " + path);
            } else if (z10) {
                throw new IOException(path + " already exist.");
            }
        }
    }

    public void i(Path path, boolean z10) {
        j.g(path, "path");
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        } else if (z10) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public List<Path> k(Path path) {
        j.g(path, "dir");
        List<Path> r10 = r(path, true);
        j.d(r10);
        return r10;
    }

    public FileMetadata m(Path path) {
        j.g(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, (Path) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
    }

    public FileHandle n(Path path) {
        j.g(path, "file");
        return new JvmFileHandle(false, new RandomAccessFile(path.toFile(), StreamManagement.AckRequest.ELEMENT));
    }

    public Sink p(Path path, boolean z10) {
        j.g(path, "file");
        if (z10) {
            s(path);
        }
        return Okio__JvmOkioKt.f(path.toFile(), false, 1, (Object) null);
    }

    public Source q(Path path) {
        j.g(path, "file");
        return Okio.i(path.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
