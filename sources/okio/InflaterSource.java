package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "", "c", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "a", "", "b", "Lokio/Timeout;", "p", "close", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "source", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "", "I", "bufferBytesHeldByInflater", "d", "Z", "closed", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class InflaterSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f33366a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f33367b;

    /* renamed from: c  reason: collision with root package name */
    private int f33368c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33369d;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        j.g(bufferedSource, "source");
        j.g(inflater, "inflater");
        this.f33366a = bufferedSource;
        this.f33367b = inflater;
    }

    private final void c() {
        int i10 = this.f33368c;
        if (i10 != 0) {
            int remaining = i10 - this.f33367b.getRemaining();
            this.f33368c -= remaining;
            this.f33366a.skip((long) remaining);
        }
    }

    public long N1(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "sink");
        do {
            long a10 = a(buffer, j10);
            if (a10 > 0) {
                return a10;
            }
            if (this.f33367b.finished() || this.f33367b.needsDictionary()) {
                return -1;
            }
        } while (!this.f33366a.Y0());
        throw new EOFException("source exhausted prematurely");
    }

    public final long a(Buffer buffer, long j10) throws IOException {
        boolean z10;
        j.g(buffer, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!this.f33369d)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            try {
                Segment O = buffer.O(1);
                b();
                int inflate = this.f33367b.inflate(O.f33408a, O.f33410c, (int) Math.min(j10, (long) (8192 - O.f33410c)));
                c();
                if (inflate > 0) {
                    O.f33410c += inflate;
                    long j11 = (long) inflate;
                    buffer.I(buffer.size() + j11);
                    return j11;
                }
                if (O.f33409b == O.f33410c) {
                    buffer.f33298a = O.b();
                    SegmentPool.b(O);
                }
                return 0;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
    }

    public final boolean b() throws IOException {
        if (!this.f33367b.needsInput()) {
            return false;
        }
        if (this.f33366a.Y0()) {
            return true;
        }
        Segment segment = this.f33366a.d().f33298a;
        j.d(segment);
        int i10 = segment.f33410c;
        int i11 = segment.f33409b;
        int i12 = i10 - i11;
        this.f33368c = i12;
        this.f33367b.setInput(segment.f33408a, i11, i12);
        return false;
    }

    public void close() throws IOException {
        if (!this.f33369d) {
            this.f33367b.end();
            this.f33369d = true;
            this.f33366a.close();
        }
    }

    public Timeout p() {
        return this.f33366a.p();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.c(source), inflater);
        j.g(source, "source");
        j.g(inflater, "inflater");
    }
}
