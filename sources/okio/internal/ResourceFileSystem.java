package okio.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import gk.f;
import gk.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001)B\u0019\b\u0000\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R-\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u001d0\b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "path", "t", "", "v", "dir", "", "k", "file", "Lokio/FileHandle;", "n", "Lokio/FileMetadata;", "m", "Lokio/Source;", "q", "", "mustCreate", "Lokio/Sink;", "p", "mustExist", "b", "", "g", "source", "target", "c", "i", "Lkotlin/Pair;", "e", "Lgk/f;", "u", "()Ljava/util/List;", "roots", "Ljava/lang/ClassLoader;", "classLoader", "indexEagerly", "<init>", "(Ljava/lang/ClassLoader;Z)V", "f", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class ResourceFileSystem extends FileSystem {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f33444f = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final Path f33445g = Path.Companion.e(Path.f33379b, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final f f33446e;

    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n0\t*\u00020\bJ\u0018\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n*\u00020\rJ\u0018\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n*\u00020\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "Lokio/Path;", "path", "", "c", "base", "d", "Ljava/lang/ClassLoader;", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "e", "Ljava/net/URL;", "f", "g", "ROOT", "Lokio/Path;", "b", "()Lokio/Path;", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean c(Path path) {
            return !r.r(path.e(), ".class", true);
        }

        public final Path b() {
            return ResourceFileSystem.f33445g;
        }

        public final Path d(Path path, Path path2) {
            j.g(path, "<this>");
            j.g(path2, "base");
            return b().k(r.C(StringsKt__StringsKt.u0(path.toString(), path2.toString()), '\\', '/', false, 4, (Object) null));
        }

        public final List<Pair<FileSystem, Path>> e(ClassLoader classLoader) {
            j.g(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            j.f(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            j.f(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            for (T t10 : list) {
                Companion r10 = ResourceFileSystem.f33444f;
                j.f(t10, "it");
                Pair<FileSystem, Path> f10 = r10.f(t10);
                if (f10 != null) {
                    arrayList.add(f10);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            j.f(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            j.f(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (T t11 : list2) {
                Companion r11 = ResourceFileSystem.f33444f;
                j.f(t11, "it");
                Pair<FileSystem, Path> g10 = r11.g(t11);
                if (g10 != null) {
                    arrayList2.add(g10);
                }
            }
            return CollectionsKt___CollectionsKt.h0(arrayList, arrayList2);
        }

        public final Pair<FileSystem, Path> f(URL url) {
            j.g(url, "<this>");
            if (!j.b(url.getProtocol(), "file")) {
                return null;
            }
            return h.a(FileSystem.f33343b, Path.Companion.d(Path.f33379b, new File(url.toURI()), false, 1, (Object) null));
        }

        public final Pair<FileSystem, Path> g(URL url) {
            int g02;
            j.g(url, "<this>");
            String url2 = url.toString();
            j.f(url2, "toString()");
            if (!r.J(url2, "jar:file:", false, 2, (Object) null) || (g02 = StringsKt__StringsKt.g0(url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.f33379b;
            String substring = url2.substring(4, g02);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return h.a(ZipKt.d(Path.Companion.d(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.f33343b, ResourceFileSystem$Companion$toJarRoot$zip$1.f33447a), b());
        }
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z10) {
        j.g(classLoader, "classLoader");
        this.f33446e = b.b(new ResourceFileSystem$roots$2(classLoader));
        if (z10) {
            u().size();
        }
    }

    private final Path t(Path path) {
        return f33445g.l(path, true);
    }

    private final List<Pair<FileSystem, Path>> u() {
        return (List) this.f33446e.getValue();
    }

    private final String v(Path path) {
        return t(path).j(f33445g).toString();
    }

    public Sink b(Path path, boolean z10) {
        j.g(path, "file");
        throw new IOException(this + " is read-only");
    }

    public void c(Path path, Path path2) {
        j.g(path, "source");
        j.g(path2, TypeProxy.INSTANCE_FIELD);
        throw new IOException(this + " is read-only");
    }

    public void g(Path path, boolean z10) {
        j.g(path, "dir");
        throw new IOException(this + " is read-only");
    }

    public void i(Path path, boolean z10) {
        j.g(path, "path");
        throw new IOException(this + " is read-only");
    }

    public List<Path> k(Path path) {
        j.g(path, "dir");
        String v10 = v(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (Pair next : u()) {
            FileSystem fileSystem = (FileSystem) next.a();
            Path path2 = (Path) next.b();
            try {
                List<Path> k10 = fileSystem.k(path2.k(v10));
                ArrayList<Path> arrayList = new ArrayList<>();
                for (T next2 : k10) {
                    if (f33444f.c((Path) next2)) {
                        arrayList.add(next2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
                for (Path d10 : arrayList) {
                    arrayList2.add(f33444f.d(d10, path2));
                }
                boolean unused = v.x(linkedHashSet, arrayList2);
                z10 = true;
            } catch (IOException unused2) {
            }
        }
        if (z10) {
            return CollectionsKt___CollectionsKt.x0(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public FileMetadata m(Path path) {
        j.g(path, "path");
        if (!f33444f.c(path)) {
            return null;
        }
        String v10 = v(path);
        for (Pair next : u()) {
            FileMetadata m10 = ((FileSystem) next.a()).m(((Path) next.b()).k(v10));
            if (m10 != null) {
                return m10;
            }
        }
        return null;
    }

    public FileHandle n(Path path) {
        j.g(path, "file");
        if (f33444f.c(path)) {
            String v10 = v(path);
            for (Pair next : u()) {
                try {
                    return ((FileSystem) next.a()).n(((Path) next.b()).k(v10));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public Sink p(Path path, boolean z10) {
        j.g(path, "file");
        throw new IOException(this + " is read-only");
    }

    public Source q(Path path) {
        j.g(path, "file");
        if (f33444f.c(path)) {
            String v10 = v(path);
            for (Pair next : u()) {
                try {
                    return ((FileSystem) next.a()).q(((Path) next.b()).k(v10));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }
}
