package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u000f\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "", "syncFlush", "", "a", "Lokio/Buffer;", "source", "", "byteCount", "k0", "flush", "b", "()V", "close", "Lokio/Timeout;", "p", "", "toString", "Lokio/BufferedSink;", "Lokio/BufferedSink;", "sink", "Ljava/util/zip/Deflater;", "Ljava/util/zip/Deflater;", "deflater", "c", "Z", "closed", "okio"}, k = 1, mv = {1, 6, 0})
public final class DeflaterSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f33322a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f33323b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33324c;

    @IgnoreJRERequirement
    private final void a(boolean z10) {
        Segment O;
        int i10;
        Buffer d10 = this.f33322a.d();
        while (true) {
            O = d10.O(1);
            if (z10) {
                Deflater deflater = this.f33323b;
                byte[] bArr = O.f33408a;
                int i11 = O.f33410c;
                i10 = deflater.deflate(bArr, i11, 8192 - i11, 2);
            } else {
                Deflater deflater2 = this.f33323b;
                byte[] bArr2 = O.f33408a;
                int i12 = O.f33410c;
                i10 = deflater2.deflate(bArr2, i12, 8192 - i12);
            }
            if (i10 > 0) {
                O.f33410c += i10;
                d10.I(d10.size() + ((long) i10));
                this.f33322a.V();
            } else if (this.f33323b.needsInput()) {
                break;
            }
        }
        if (O.f33409b == O.f33410c) {
            d10.f33298a = O.b();
            SegmentPool.b(O);
        }
    }

    public final void b() {
        this.f33323b.finish();
        a(false);
    }

    public void close() throws IOException {
        if (!this.f33324c) {
            Throwable th2 = null;
            try {
                b();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f33323b.end();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            try {
                this.f33322a.close();
            } catch (Throwable th5) {
                if (th2 == null) {
                    th2 = th5;
                }
            }
            this.f33324c = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public void flush() throws IOException {
        a(true);
        this.f33322a.flush();
    }

    public void k0(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "source");
        _UtilKt.b(buffer.size(), 0, j10);
        while (j10 > 0) {
            Segment segment = buffer.f33298a;
            j.d(segment);
            int min = (int) Math.min(j10, (long) (segment.f33410c - segment.f33409b));
            this.f33323b.setInput(segment.f33408a, segment.f33409b, min);
            a(false);
            long j11 = (long) min;
            buffer.I(buffer.size() - j11);
            int i10 = segment.f33409b + min;
            segment.f33409b = i10;
            if (i10 == segment.f33410c) {
                buffer.f33298a = segment.b();
                SegmentPool.b(segment);
            }
            j10 -= j11;
        }
    }

    public Timeout p() {
        return this.f33322a.p();
    }

    public String toString() {
        return "DeflaterSink(" + this.f33322a + PropertyUtils.MAPPED_DELIM2;
    }
}
