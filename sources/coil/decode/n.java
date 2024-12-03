package coil.decode;

import coil.decode.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\b\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcoil/decode/n;", "Lcoil/decode/k;", "", "c", "Lokio/BufferedSource;", "b", "close", "Ljava/io/File;", "a", "Ljava/io/File;", "cacheDirectory", "Lcoil/decode/k$a;", "Lcoil/decode/k$a;", "()Lcoil/decode/k$a;", "metadata", "", "Z", "isClosed", "d", "Lokio/BufferedSource;", "source", "Lokio/Path;", "e", "Lokio/Path;", "file", "Lokio/FileSystem;", "()Lokio/FileSystem;", "fileSystem", "<init>", "(Lokio/BufferedSource;Ljava/io/File;Lcoil/decode/k$a;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class n extends k {

    /* renamed from: a  reason: collision with root package name */
    private final File f8114a;

    /* renamed from: b  reason: collision with root package name */
    private final k.a f8115b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8116c;

    /* renamed from: d  reason: collision with root package name */
    private BufferedSource f8117d;

    /* renamed from: e  reason: collision with root package name */
    private Path f8118e;

    public n(BufferedSource bufferedSource, File file, k.a aVar) {
        super((DefaultConstructorMarker) null);
        this.f8114a = file;
        this.f8115b = aVar;
        this.f8117d = bufferedSource;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("cacheDirectory must be a directory.".toString());
        }
    }

    private final void c() {
        if (!(!this.f8116c)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    public k.a a() {
        return this.f8115b;
    }

    public synchronized BufferedSource b() {
        c();
        BufferedSource bufferedSource = this.f8117d;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        FileSystem e10 = e();
        Path path = this.f8118e;
        j.d(path);
        BufferedSource c10 = Okio.c(e10.q(path));
        this.f8117d = c10;
        return c10;
    }

    public synchronized void close() {
        this.f8116c = true;
        BufferedSource bufferedSource = this.f8117d;
        if (bufferedSource != null) {
            coil.util.j.d(bufferedSource);
        }
        Path path = this.f8118e;
        if (path != null) {
            e().h(path);
        }
    }

    public FileSystem e() {
        return FileSystem.f33343b;
    }
}
