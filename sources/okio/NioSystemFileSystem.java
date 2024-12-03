package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0012"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "Ljava/nio/file/attribute/FileTime;", "", "u", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "m", "source", "target", "", "c", "", "toString", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
@IgnoreJRERequirement
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    private final Long u(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public void c(Path path, Path path2) {
        j.g(path, "source");
        j.g(path2, TypeProxy.INSTANCE_FIELD);
        try {
            Files.move(path.o(), path2.o(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
        } catch (NoSuchFileException e10) {
            throw new FileNotFoundException(e10.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        }
    }

    public FileMetadata m(Path path) {
        Path path2;
        Path path3;
        Long l10;
        Long l11;
        j.g(path, "path");
        Path o10 = path.o();
        Long l12 = null;
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(o10, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (readAttributes.isSymbolicLink()) {
                path2 = Files.readSymbolicLink(o10);
            } else {
                path2 = null;
            }
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            if (path2 != null) {
                path3 = Path.Companion.f(Path.f33379b, path2, false, 1, (Object) null);
            } else {
                path3 = null;
            }
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            if (creationTime != null) {
                l10 = u(creationTime);
            } else {
                l10 = null;
            }
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            if (lastModifiedTime != null) {
                l11 = u(lastModifiedTime);
            } else {
                l11 = null;
            }
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            if (lastAccessTime != null) {
                l12 = u(lastAccessTime);
            }
            return new FileMetadata(isRegularFile, isDirectory, path3, valueOf, l10, l11, l12, (Map) null, 128, (DefaultConstructorMarker) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    public String toString() {
        return "NioSystemFileSystem";
    }
}
