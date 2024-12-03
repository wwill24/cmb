package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "", "l", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "k", "", "m", "h", "g", "Ljava/io/RandomAccessFile;", "d", "Ljava/io/RandomAccessFile;", "randomAccessFile", "", "readWrite", "<init>", "(ZLjava/io/RandomAccessFile;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class JvmFileHandle extends FileHandle {

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f33372d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z10, RandomAccessFile randomAccessFile) {
        super(z10);
        j.g(randomAccessFile, "randomAccessFile");
        this.f33372d = randomAccessFile;
    }

    /* access modifiers changed from: protected */
    public synchronized void g() {
        this.f33372d.close();
    }

    /* access modifiers changed from: protected */
    public synchronized void h() {
        this.f33372d.getFD().sync();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int k(long r2, byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.j.g(r4, r0)     // Catch:{ all -> 0x0021 }
            java.io.RandomAccessFile r0 = r1.f33372d     // Catch:{ all -> 0x0021 }
            r0.seek(r2)     // Catch:{ all -> 0x0021 }
            r2 = 0
        L_0x000c:
            if (r2 >= r6) goto L_0x001f
            java.io.RandomAccessFile r3 = r1.f33372d     // Catch:{ all -> 0x0021 }
            int r0 = r6 - r2
            int r3 = r3.read(r4, r5, r0)     // Catch:{ all -> 0x0021 }
            r0 = -1
            if (r3 != r0) goto L_0x001d
            if (r2 != 0) goto L_0x001f
            monitor-exit(r1)
            return r0
        L_0x001d:
            int r2 = r2 + r3
            goto L_0x000c
        L_0x001f:
            monitor-exit(r1)
            return r2
        L_0x0021:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.JvmFileHandle.k(long, byte[], int, int):int");
    }

    /* access modifiers changed from: protected */
    public synchronized long l() {
        return this.f33372d.length();
    }

    /* access modifiers changed from: protected */
    public synchronized void m(long j10, byte[] bArr, int i10, int i11) {
        j.g(bArr, "array");
        this.f33372d.seek(j10);
        this.f33372d.write(bArr, i10, i11);
    }
}
