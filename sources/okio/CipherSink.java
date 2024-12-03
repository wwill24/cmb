package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "remaining", "", "b", "", "a", "byteCount", "", "k0", "flush", "Lokio/Timeout;", "p", "close", "Lokio/BufferedSink;", "Lokio/BufferedSink;", "sink", "Ljavax/crypto/Cipher;", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "cipher", "c", "I", "blockSize", "", "d", "Z", "closed", "okio"}, k = 1, mv = {1, 6, 0})
public final class CipherSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f33312a;

    /* renamed from: b  reason: collision with root package name */
    private final Cipher f33313b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33314c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33315d;

    private final Throwable a() {
        int outputSize = this.f33313b.getOutputSize(0);
        Throwable th2 = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.f33312a;
                byte[] doFinal = this.f33313b.doFinal();
                j.f(doFinal, "cipher.doFinal()");
                bufferedSink.write(doFinal);
                return null;
            } catch (Throwable th3) {
                return th3;
            }
        } else {
            Buffer d10 = this.f33312a.d();
            Segment O = d10.O(outputSize);
            try {
                int doFinal2 = this.f33313b.doFinal(O.f33408a, O.f33410c);
                O.f33410c += doFinal2;
                d10.I(d10.size() + ((long) doFinal2));
            } catch (Throwable th4) {
                th2 = th4;
            }
            if (O.f33409b == O.f33410c) {
                d10.f33298a = O.b();
                SegmentPool.b(O);
            }
            return th2;
        }
    }

    private final int b(Buffer buffer, long j10) {
        Segment segment = buffer.f33298a;
        j.d(segment);
        int min = (int) Math.min(j10, (long) (segment.f33410c - segment.f33409b));
        Buffer d10 = this.f33312a.d();
        int outputSize = this.f33313b.getOutputSize(min);
        while (outputSize > 8192) {
            int i10 = this.f33314c;
            if (min <= i10) {
                BufferedSink bufferedSink = this.f33312a;
                byte[] update = this.f33313b.update(buffer.y0(j10));
                j.f(update, "cipher.update(source.readByteArray(remaining))");
                bufferedSink.write(update);
                return (int) j10;
            }
            min -= i10;
            outputSize = this.f33313b.getOutputSize(min);
        }
        Segment O = d10.O(outputSize);
        int update2 = this.f33313b.update(segment.f33408a, segment.f33409b, min, O.f33408a, O.f33410c);
        O.f33410c += update2;
        d10.I(d10.size() + ((long) update2));
        if (O.f33409b == O.f33410c) {
            d10.f33298a = O.b();
            SegmentPool.b(O);
        }
        this.f33312a.V();
        buffer.I(buffer.size() - ((long) min));
        int i11 = segment.f33409b + min;
        segment.f33409b = i11;
        if (i11 == segment.f33410c) {
            buffer.f33298a = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    public void close() throws IOException {
        if (!this.f33315d) {
            this.f33315d = true;
            Throwable a10 = a();
            try {
                this.f33312a.close();
            } catch (Throwable th2) {
                if (a10 == null) {
                    a10 = th2;
                }
            }
            if (a10 != null) {
                throw a10;
            }
        }
    }

    public void flush() {
        this.f33312a.flush();
    }

    public void k0(Buffer buffer, long j10) throws IOException {
        j.g(buffer, "source");
        _UtilKt.b(buffer.size(), 0, j10);
        if (!this.f33315d) {
            while (j10 > 0) {
                j10 -= (long) b(buffer, j10);
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public Timeout p() {
        return this.f33312a.p();
    }
}
