package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "", "b", "c", "a", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Lokio/Timeout;", "p", "close", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "source", "Ljavax/crypto/Cipher;", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "cipher", "", "I", "blockSize", "d", "Lokio/Buffer;", "buffer", "", "e", "Z", "final", "f", "closed", "okio"}, k = 1, mv = {1, 6, 0})
public final class CipherSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f33316a;

    /* renamed from: b  reason: collision with root package name */
    private final Cipher f33317b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33318c;

    /* renamed from: d  reason: collision with root package name */
    private final Buffer f33319d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33320e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33321f;

    private final void a() {
        int outputSize = this.f33317b.getOutputSize(0);
        if (outputSize != 0) {
            Segment O = this.f33319d.O(outputSize);
            int doFinal = this.f33317b.doFinal(O.f33408a, O.f33409b);
            O.f33410c += doFinal;
            Buffer buffer = this.f33319d;
            buffer.I(buffer.size() + ((long) doFinal));
            if (O.f33409b == O.f33410c) {
                this.f33319d.f33298a = O.b();
                SegmentPool.b(O);
            }
        }
    }

    private final void b() {
        while (this.f33319d.size() == 0 && !this.f33320e) {
            if (this.f33316a.Y0()) {
                this.f33320e = true;
                a();
                return;
            }
            c();
        }
    }

    private final void c() {
        Segment segment = this.f33316a.d().f33298a;
        j.d(segment);
        int i10 = segment.f33410c - segment.f33409b;
        int outputSize = this.f33317b.getOutputSize(i10);
        while (outputSize > 8192) {
            int i11 = this.f33318c;
            if (i10 <= i11) {
                this.f33320e = true;
                Buffer buffer = this.f33319d;
                byte[] doFinal = this.f33317b.doFinal(this.f33316a.V0());
                j.f(doFinal, "cipher.doFinal(source.readByteArray())");
                buffer.write(doFinal);
                return;
            }
            i10 -= i11;
            outputSize = this.f33317b.getOutputSize(i10);
        }
        Segment O = this.f33319d.O(outputSize);
        int update = this.f33317b.update(segment.f33408a, segment.f33409b, i10, O.f33408a, O.f33409b);
        this.f33316a.skip((long) i10);
        O.f33410c += update;
        Buffer buffer2 = this.f33319d;
        buffer2.I(buffer2.size() + ((long) update));
        if (O.f33409b == O.f33410c) {
            this.f33319d.f33298a = O.b();
            SegmentPool.b(O);
        }
    }

    public long N1(Buffer buffer, long j10) throws IOException {
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
        } else if (!(true ^ this.f33321f)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            b();
            return this.f33319d.N1(buffer, j10);
        }
    }

    public void close() throws IOException {
        this.f33321f = true;
        this.f33316a.close();
    }

    public Timeout p() {
        return this.f33316a.p();
    }
}
