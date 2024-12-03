package coil.decode;

import coil.decode.k;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\b\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcoil/decode/j;", "Lcoil/decode/k;", "", "c", "Lokio/BufferedSource;", "b", "close", "Lokio/Path;", "a", "Lokio/Path;", "getFile$coil_base_release", "()Lokio/Path;", "file", "Lokio/FileSystem;", "Lokio/FileSystem;", "f", "()Lokio/FileSystem;", "fileSystem", "", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "diskCacheKey", "Ljava/io/Closeable;", "d", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/k$a;", "Lcoil/decode/k$a;", "()Lcoil/decode/k$a;", "metadata", "", "Z", "isClosed", "g", "Lokio/BufferedSource;", "source", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/io/Closeable;Lcoil/decode/k$a;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8104a;

    /* renamed from: b  reason: collision with root package name */
    private final FileSystem f8105b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8106c;

    /* renamed from: d  reason: collision with root package name */
    private final Closeable f8107d;

    /* renamed from: e  reason: collision with root package name */
    private final k.a f8108e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8109f;

    /* renamed from: g  reason: collision with root package name */
    private BufferedSource f8110g;

    public j(Path path, FileSystem fileSystem, String str, Closeable closeable, k.a aVar) {
        super((DefaultConstructorMarker) null);
        this.f8104a = path;
        this.f8105b = fileSystem;
        this.f8106c = str;
        this.f8107d = closeable;
        this.f8108e = aVar;
    }

    private final void c() {
        if (!(!this.f8109f)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    public k.a a() {
        return this.f8108e;
    }

    public synchronized BufferedSource b() {
        c();
        BufferedSource bufferedSource = this.f8110g;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource c10 = Okio.c(f().q(this.f8104a));
        this.f8110g = c10;
        return c10;
    }

    public synchronized void close() {
        this.f8109f = true;
        BufferedSource bufferedSource = this.f8110g;
        if (bufferedSource != null) {
            coil.util.j.d(bufferedSource);
        }
        Closeable closeable = this.f8107d;
        if (closeable != null) {
            coil.util.j.d(closeable);
        }
    }

    public final String e() {
        return this.f8106c;
    }

    public FileSystem f() {
        return this.f8105b;
    }
}
