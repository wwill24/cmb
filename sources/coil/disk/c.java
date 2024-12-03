package coil.disk;

import coil.disk.DiskLruCache;
import coil.disk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0003\b\u000f\u000bB'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006 "}, d2 = {"Lcoil/disk/c;", "Lcoil/disk/a;", "", "d", "key", "Lcoil/disk/a$c;", "get", "Lcoil/disk/a$b;", "a", "", "J", "c", "()J", "maxSize", "Lokio/Path;", "b", "Lokio/Path;", "()Lokio/Path;", "directory", "Lokio/FileSystem;", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "fileSystem", "Lcoil/disk/DiskLruCache;", "Lcoil/disk/DiskLruCache;", "cache", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", "<init>", "(JLokio/Path;Lokio/FileSystem;Lkotlinx/coroutines/CoroutineDispatcher;)V", "e", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class c implements a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8166e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f8167a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f8168b;

    /* renamed from: c  reason: collision with root package name */
    private final FileSystem f8169c;

    /* renamed from: d  reason: collision with root package name */
    private final DiskLruCache f8170d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcoil/disk/c$a;", "", "", "ENTRY_DATA", "I", "ENTRY_METADATA", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u00060\u0006R\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u00060\u0006R\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcoil/disk/c$b;", "Lcoil/disk/a$b;", "Lcoil/disk/c$c;", "a", "", "abort", "Lcoil/disk/DiskLruCache$b;", "Lcoil/disk/DiskLruCache;", "Lcoil/disk/DiskLruCache$b;", "editor", "Lokio/Path;", "s", "()Lokio/Path;", "metadata", "getData", "data", "<init>", "(Lcoil/disk/DiskLruCache$b;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    private static final class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private final DiskLruCache.b f8171a;

        public b(DiskLruCache.b bVar) {
            this.f8171a = bVar;
        }

        /* renamed from: a */
        public C0102c t() {
            DiskLruCache.d c10 = this.f8171a.c();
            if (c10 != null) {
                return new C0102c(c10);
            }
            return null;
        }

        public void abort() {
            this.f8171a.a();
        }

        public Path getData() {
            return this.f8171a.f(1);
        }

        public Path s() {
            return this.f8171a.f(0);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u00060\u0006R\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\t\u001a\u00060\u0006R\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcoil/disk/c$c;", "Lcoil/disk/a$c;", "", "close", "Lcoil/disk/c$b;", "a", "Lcoil/disk/DiskLruCache$d;", "Lcoil/disk/DiskLruCache;", "Lcoil/disk/DiskLruCache$d;", "snapshot", "Lokio/Path;", "s", "()Lokio/Path;", "metadata", "getData", "data", "<init>", "(Lcoil/disk/DiskLruCache$d;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.disk.c$c  reason: collision with other inner class name */
    private static final class C0102c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final DiskLruCache.d f8172a;

        public C0102c(DiskLruCache.d dVar) {
            this.f8172a = dVar;
        }

        /* renamed from: a */
        public b v1() {
            DiskLruCache.b a10 = this.f8172a.a();
            if (a10 != null) {
                return new b(a10);
            }
            return null;
        }

        public void close() {
            this.f8172a.close();
        }

        public Path getData() {
            return this.f8172a.b(1);
        }

        public Path s() {
            return this.f8172a.b(0);
        }
    }

    public c(long j10, Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) {
        this.f8167a = j10;
        this.f8168b = path;
        this.f8169c = fileSystem;
        this.f8170d = new DiskLruCache(getFileSystem(), b(), coroutineDispatcher, c(), 1, 2);
    }

    private final String d(String str) {
        return ByteString.f33308c.c(str).G().p();
    }

    public a.b a(String str) {
        DiskLruCache.b F = this.f8170d.F(d(str));
        if (F != null) {
            return new b(F);
        }
        return null;
    }

    public Path b() {
        return this.f8168b;
    }

    public long c() {
        return this.f8167a;
    }

    public a.c get(String str) {
        DiskLruCache.d G = this.f8170d.G(d(str));
        if (G != null) {
            return new C0102c(G);
        }
        return null;
    }

    public FileSystem getFileSystem() {
        return this.f8169c;
    }
}
