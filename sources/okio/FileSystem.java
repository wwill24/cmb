package okio;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal.f;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000 \u00172\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0002H&J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0007H&J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0002J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0007H&J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0002J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0007H&J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0002J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0007H&J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006%"}, d2 = {"Lokio/FileSystem;", "", "Lokio/Path;", "path", "Lokio/FileMetadata;", "l", "m", "", "j", "dir", "", "k", "file", "Lokio/FileHandle;", "n", "Lokio/Source;", "q", "mustCreate", "Lokio/Sink;", "p", "o", "mustExist", "b", "a", "", "g", "f", "e", "d", "source", "target", "c", "i", "h", "<init>", "()V", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public abstract class FileSystem {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33342a = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public static final FileSystem f33343b;

    /* renamed from: c  reason: collision with root package name */
    public static final Path f33344c;

    /* renamed from: d  reason: collision with root package name */
    public static final FileSystem f33345d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FileSystem fileSystem;
        try {
            Class.forName("java.nio.file.Files");
            fileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            fileSystem = new JvmSystemFileSystem();
        }
        f33343b = fileSystem;
        Path.Companion companion = Path.f33379b;
        String property = System.getProperty("java.io.tmpdir");
        j.f(property, "getProperty(\"java.io.tmpdir\")");
        f33344c = Path.Companion.e(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        j.f(classLoader, "ResourceFileSystem::class.java.classLoader");
        f33345d = new ResourceFileSystem(classLoader, false);
    }

    public final Sink a(Path path) throws IOException {
        j.g(path, "file");
        return b(path, false);
    }

    public abstract Sink b(Path path, boolean z10) throws IOException;

    public abstract void c(Path path, Path path2) throws IOException;

    public final void d(Path path) throws IOException {
        j.g(path, "dir");
        e(path, false);
    }

    public final void e(Path path, boolean z10) throws IOException {
        j.g(path, "dir");
        f.a(this, path, z10);
    }

    public final void f(Path path) throws IOException {
        j.g(path, "dir");
        g(path, false);
    }

    public abstract void g(Path path, boolean z10) throws IOException;

    public final void h(Path path) throws IOException {
        j.g(path, "path");
        i(path, false);
    }

    public abstract void i(Path path, boolean z10) throws IOException;

    public final boolean j(Path path) throws IOException {
        j.g(path, "path");
        return f.b(this, path);
    }

    public abstract List<Path> k(Path path) throws IOException;

    public final FileMetadata l(Path path) throws IOException {
        j.g(path, "path");
        return f.c(this, path);
    }

    public abstract FileMetadata m(Path path) throws IOException;

    public abstract FileHandle n(Path path) throws IOException;

    public final Sink o(Path path) throws IOException {
        j.g(path, "file");
        return p(path, false);
    }

    public abstract Sink p(Path path, boolean z10) throws IOException;

    public abstract Source q(Path path) throws IOException;
}
