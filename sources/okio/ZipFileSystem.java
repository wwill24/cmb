package okio;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.Path;
import okio.internal.ZipKt;
import okio.internal.b;
import okio.internal.c;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001-B7\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0001\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0#\u0012\b\u0010*\u001a\u0004\u0018\u00010'¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "path", "r", "dir", "", "throwOnFailure", "", "s", "Lokio/FileMetadata;", "m", "file", "Lokio/FileHandle;", "n", "k", "Lokio/Source;", "q", "mustCreate", "Lokio/Sink;", "p", "mustExist", "b", "", "g", "source", "target", "c", "i", "e", "Lokio/Path;", "zipPath", "f", "Lokio/FileSystem;", "fileSystem", "", "Lokio/internal/c;", "Ljava/util/Map;", "entries", "", "h", "Ljava/lang/String;", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class ZipFileSystem extends FileSystem {

    /* renamed from: i  reason: collision with root package name */
    private static final Companion f33434i = new Companion((DefaultConstructorMarker) null);
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    private static final Path f33435j = Path.Companion.e(Path.f33379b, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final Path f33436e;

    /* renamed from: f  reason: collision with root package name */
    private final FileSystem f33437f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Path, c> f33438g;

    /* renamed from: h  reason: collision with root package name */
    private final String f33439h;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, c> map, String str) {
        j.g(path, "zipPath");
        j.g(fileSystem, "fileSystem");
        j.g(map, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        this.f33436e = path;
        this.f33437f = fileSystem;
        this.f33438g = map;
        this.f33439h = str;
    }

    private final Path r(Path path) {
        return f33435j.l(path, true);
    }

    private final List<Path> s(Path path, boolean z10) {
        c cVar = this.f33438g.get(r(path));
        if (cVar != null) {
            return CollectionsKt___CollectionsKt.x0(cVar.b());
        }
        if (!z10) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }

    public Sink b(Path path, boolean z10) {
        j.g(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    public void c(Path path, Path path2) {
        j.g(path, "source");
        j.g(path2, TypeProxy.INSTANCE_FIELD);
        throw new IOException("zip file systems are read-only");
    }

    public void g(Path path, boolean z10) {
        j.g(path, "dir");
        throw new IOException("zip file systems are read-only");
    }

    public void i(Path path, boolean z10) {
        j.g(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    public List<Path> k(Path path) {
        j.g(path, "dir");
        List<Path> s10 = s(path, true);
        j.d(s10);
        return s10;
    }

    public FileMetadata m(Path path) {
        Long l10;
        BufferedSource bufferedSource;
        j.g(path, "path");
        c cVar = this.f33438g.get(r(path));
        Throwable th2 = null;
        if (cVar == null) {
            return null;
        }
        boolean z10 = !cVar.h();
        boolean h10 = cVar.h();
        if (cVar.h()) {
            l10 = null;
        } else {
            l10 = Long.valueOf(cVar.g());
        }
        FileMetadata fileMetadata = new FileMetadata(z10, h10, (Path) null, l10, (Long) null, cVar.e(), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
        if (cVar.f() == -1) {
            return fileMetadata;
        }
        FileHandle n10 = this.f33437f.n(this.f33436e);
        try {
            bufferedSource = Okio.c(n10.u(cVar.f()));
        } catch (Throwable th3) {
            th2 = th3;
            bufferedSource = null;
        }
        if (n10 != null) {
            try {
                n10.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    b.a(th2, th4);
                }
            }
        }
        if (th2 == null) {
            j.d(bufferedSource);
            return ZipKt.h(bufferedSource, fileMetadata);
        }
        throw th2;
    }

    public FileHandle n(Path path) {
        j.g(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public Sink p(Path path, boolean z10) {
        j.g(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    public Source q(Path path) throws IOException {
        BufferedSource bufferedSource;
        j.g(path, "file");
        c cVar = this.f33438g.get(r(path));
        if (cVar != null) {
            FileHandle n10 = this.f33437f.n(this.f33436e);
            Throwable th2 = null;
            try {
                bufferedSource = Okio.c(n10.u(cVar.f()));
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedSource = null;
                th2 = th4;
            }
            if (n10 != null) {
                try {
                    n10.close();
                } catch (Throwable th5) {
                    if (th2 == null) {
                        th2 = th5;
                    } else {
                        b.a(th2, th5);
                    }
                }
            }
            if (th2 == null) {
                j.d(bufferedSource);
                ZipKt.k(bufferedSource);
                if (cVar.d() == 0) {
                    return new b(bufferedSource, cVar.g(), true);
                }
                return new b(new InflaterSource((Source) new b(bufferedSource, cVar.c(), true), new Inflater(true)), cVar.g(), false);
            }
            throw th2;
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
