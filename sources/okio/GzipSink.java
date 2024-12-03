package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00128G¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "", "b", "Lokio/Buffer;", "buffer", "", "byteCount", "a", "source", "k0", "flush", "Lokio/Timeout;", "p", "close", "Lokio/RealBufferedSink;", "Lokio/RealBufferedSink;", "sink", "Ljava/util/zip/Deflater;", "Ljava/util/zip/Deflater;", "deflater", "()Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "c", "Lokio/DeflaterSink;", "deflaterSink", "", "d", "Z", "closed", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", "crc", "okio"}, k = 1, mv = {1, 6, 0})
public final class GzipSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final RealBufferedSink f33350a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f33351b;

    /* renamed from: c  reason: collision with root package name */
    private final DeflaterSink f33352c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33353d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f33354e;

    private final void a(Buffer buffer, long j10) {
        Segment segment = buffer.f33298a;
        j.d(segment);
        while (j10 > 0) {
            int min = (int) Math.min(j10, (long) (segment.f33410c - segment.f33409b));
            this.f33354e.update(segment.f33408a, segment.f33409b, min);
            j10 -= (long) min;
            segment = segment.f33413f;
            j.d(segment);
        }
    }

    private final void b() {
        this.f33350a.a((int) this.f33354e.getValue());
        this.f33350a.a((int) this.f33351b.getBytesRead());
    }

    public void close() throws IOException {
        if (!this.f33353d) {
            Throwable th2 = null;
            try {
                this.f33352c.b();
                b();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f33351b.end();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            try {
                this.f33350a.close();
            } catch (Throwable th5) {
                if (th2 == null) {
                    th2 = th5;
                }
            }
            this.f33353d = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public void flush() throws IOException {
        this.f33352c.flush();
    }

    public void k0(Buffer buffer, long j10) throws IOException {
        boolean z10;
        j.g(buffer, "source");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 != 0) {
            a(buffer, j10);
            this.f33352c.k0(buffer, j10);
        }
    }

    public Timeout p() {
        return this.f33350a.p();
    }
}
