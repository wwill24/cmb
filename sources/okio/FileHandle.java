package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002&'B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b$\u0010%J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\nJ(\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012H$J(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012H$J\b\u0010\u0016\u001a\u00020\nH$J\b\u0010\u0017\u001a\u00020\u0003H$J\b\u0010\u0018\u001a\u00020\nH$R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "fileOffset", "Lokio/Buffer;", "sink", "byteCount", "n", "source", "", "v", "size", "Lokio/Source;", "u", "close", "", "array", "", "arrayOffset", "k", "m", "h", "l", "g", "", "a", "Z", "getReadWrite", "()Z", "readWrite", "b", "closed", "c", "I", "openStreamCount", "<init>", "(Z)V", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 6, 0})
public abstract class FileHandle implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33325a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f33326b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f33327c;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "Lokio/Timeout;", "p", "close", "Lokio/FileHandle;", "a", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "fileHandle", "b", "J", "getPosition", "()J", "setPosition", "(J)V", "position", "", "c", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "closed", "okio"}, k = 1, mv = {1, 6, 0})
    private static final class FileHandleSink implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final FileHandle f33328a;

        /* renamed from: b  reason: collision with root package name */
        private long f33329b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33330c;

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                boolean r0 = r3.f33330c
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 1
                r3.f33330c = r0
                okio.FileHandle r0 = r3.f33328a
                monitor-enter(r0)
                okio.FileHandle r1 = r3.f33328a     // Catch:{ all -> 0x0032 }
                int r2 = r1.f33327c     // Catch:{ all -> 0x0032 }
                int r2 = r2 + -1
                r1.f33327c = r2     // Catch:{ all -> 0x0032 }
                okio.FileHandle r1 = r3.f33328a     // Catch:{ all -> 0x0032 }
                int r1 = r1.f33327c     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                okio.FileHandle r1 = r3.f33328a     // Catch:{ all -> 0x0032 }
                boolean r1 = r1.f33326b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0027
                goto L_0x0030
            L_0x0027:
                kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0032 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.f33328a
                r0.g()
                return
            L_0x0030:
                monitor-exit(r0)
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSink.close():void");
        }

        public void flush() {
            if (!this.f33330c) {
                this.f33328a.h();
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        public void k0(Buffer buffer, long j10) {
            j.g(buffer, "source");
            if (!this.f33330c) {
                this.f33328a.v(this.f33329b, buffer, j10);
                this.f33329b += j10;
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        public Timeout p() {
            return Timeout.f33430e;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Lokio/Timeout;", "p", "", "close", "Lokio/FileHandle;", "a", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "fileHandle", "b", "J", "getPosition", "()J", "setPosition", "(J)V", "position", "", "c", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "closed", "<init>", "(Lokio/FileHandle;J)V", "okio"}, k = 1, mv = {1, 6, 0})
    private static final class FileHandleSource implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final FileHandle f33331a;

        /* renamed from: b  reason: collision with root package name */
        private long f33332b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33333c;

        public FileHandleSource(FileHandle fileHandle, long j10) {
            j.g(fileHandle, "fileHandle");
            this.f33331a = fileHandle;
            this.f33332b = j10;
        }

        public long N1(Buffer buffer, long j10) {
            j.g(buffer, "sink");
            if (!this.f33333c) {
                long c10 = this.f33331a.n(this.f33332b, buffer, j10);
                if (c10 != -1) {
                    this.f33332b += c10;
                }
                return c10;
            }
            throw new IllegalStateException("closed".toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                boolean r0 = r3.f33333c
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 1
                r3.f33333c = r0
                okio.FileHandle r0 = r3.f33331a
                monitor-enter(r0)
                okio.FileHandle r1 = r3.f33331a     // Catch:{ all -> 0x0032 }
                int r2 = r1.f33327c     // Catch:{ all -> 0x0032 }
                int r2 = r2 + -1
                r1.f33327c = r2     // Catch:{ all -> 0x0032 }
                okio.FileHandle r1 = r3.f33331a     // Catch:{ all -> 0x0032 }
                int r1 = r1.f33327c     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                okio.FileHandle r1 = r3.f33331a     // Catch:{ all -> 0x0032 }
                boolean r1 = r1.f33326b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0027
                goto L_0x0030
            L_0x0027:
                kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0032 }
                monitor-exit(r0)
                okio.FileHandle r0 = r3.f33331a
                r0.g()
                return
            L_0x0030:
                monitor-exit(r0)
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.FileHandle.FileHandleSource.close():void");
        }

        public Timeout p() {
            return Timeout.f33430e;
        }
    }

    public FileHandle(boolean z10) {
        this.f33325a = z10;
    }

    /* access modifiers changed from: private */
    public final long n(long j10, Buffer buffer, long j11) {
        boolean z10;
        Buffer buffer2 = buffer;
        long j12 = j11;
        if (j12 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            long j13 = j10 + j12;
            long j14 = j10;
            while (true) {
                if (j14 >= j13) {
                    break;
                }
                Segment O = buffer2.O(1);
                byte[] bArr = O.f33408a;
                int i10 = O.f33410c;
                int k10 = k(j14, bArr, i10, (int) Math.min(j13 - j14, (long) (8192 - i10)));
                if (k10 == -1) {
                    if (O.f33409b == O.f33410c) {
                        buffer2.f33298a = O.b();
                        SegmentPool.b(O);
                    }
                    if (j10 == j14) {
                        return -1;
                    }
                } else {
                    O.f33410c += k10;
                    long j15 = (long) k10;
                    j14 += j15;
                    buffer2.I(buffer.size() + j15);
                }
            }
            return j14 - j10;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j12).toString());
    }

    /* access modifiers changed from: private */
    public final void v(long j10, Buffer buffer, long j11) {
        _UtilKt.b(buffer.size(), 0, j11);
        long j12 = j11 + j10;
        while (j10 < j12) {
            Segment segment = buffer.f33298a;
            j.d(segment);
            int min = (int) Math.min(j12 - j10, (long) (segment.f33410c - segment.f33409b));
            m(j10, segment.f33408a, segment.f33409b, min);
            segment.f33409b += min;
            long j13 = (long) min;
            j10 += j13;
            buffer.I(buffer.size() - j13);
            if (segment.f33409b == segment.f33410c) {
                buffer.f33298a = segment.b();
                SegmentPool.b(segment);
            }
        }
    }

    public final void close() throws IOException {
        synchronized (this) {
            if (!this.f33326b) {
                this.f33326b = true;
                if (this.f33327c == 0) {
                    Unit unit = Unit.f32013a;
                    g();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void g() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void h() throws IOException;

    /* access modifiers changed from: protected */
    public abstract int k(long j10, byte[] bArr, int i10, int i11) throws IOException;

    /* access modifiers changed from: protected */
    public abstract long l() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void m(long j10, byte[] bArr, int i10, int i11) throws IOException;

    public final long size() throws IOException {
        synchronized (this) {
            if (!this.f33326b) {
                Unit unit = Unit.f32013a;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return l();
    }

    public final Source u(long j10) throws IOException {
        synchronized (this) {
            if (!this.f33326b) {
                this.f33327c++;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        return new FileHandleSource(this, j10);
    }
}
