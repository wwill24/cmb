package okio;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020*¢\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0011\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0001H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016R\u0014\u0010,\u001a\u00020*8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010+R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010-R\u0016\u00101\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u00020\u00028Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b4\u00105\u001a\u0004\b2\u00103¨\u00069"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "Lokio/ByteString;", "byteString", "K1", "", "string", "h0", "", "beginIndex", "endIndex", "n0", "", "write", "offset", "Ljava/nio/ByteBuffer;", "Lokio/Source;", "o0", "b", "writeByte", "s", "writeShort", "i", "writeInt", "a", "v", "J0", "x1", "V", "flush", "", "isOpen", "close", "Lokio/Timeout;", "p", "toString", "Lokio/Sink;", "Lokio/Sink;", "sink", "Lokio/Buffer;", "bufferField", "c", "Z", "closed", "d", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a  reason: collision with root package name */
    public final Sink f33399a;

    /* renamed from: b  reason: collision with root package name */
    public final Buffer f33400b = new Buffer();

    /* renamed from: c  reason: collision with root package name */
    public boolean f33401c;

    public RealBufferedSink(Sink sink) {
        j.g(sink, "sink");
        this.f33399a = sink;
    }

    public BufferedSink J0(long j10) {
        if (!this.f33401c) {
            this.f33400b.J0(j10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink K1(ByteString byteString) {
        j.g(byteString, "byteString");
        if (!this.f33401c) {
            this.f33400b.K1(byteString);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink V() {
        if (!this.f33401c) {
            long c10 = this.f33400b.c();
            if (c10 > 0) {
                this.f33399a.k0(this.f33400b, c10);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink a(int i10) {
        if (!this.f33401c) {
            this.f33400b.r0(i10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public void close() {
        if (!this.f33401c) {
            Throwable th2 = null;
            try {
                if (this.f33400b.size() > 0) {
                    Sink sink = this.f33399a;
                    Buffer buffer = this.f33400b;
                    sink.k0(buffer, buffer.size());
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f33399a.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            this.f33401c = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public Buffer d() {
        return this.f33400b;
    }

    public void flush() {
        if (!this.f33401c) {
            if (this.f33400b.size() > 0) {
                Sink sink = this.f33399a;
                Buffer buffer = this.f33400b;
                sink.k0(buffer, buffer.size());
            }
            this.f33399a.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink h0(String str) {
        j.g(str, "string");
        if (!this.f33401c) {
            this.f33400b.h0(str);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.f33401c;
    }

    public void k0(Buffer buffer, long j10) {
        j.g(buffer, "source");
        if (!this.f33401c) {
            this.f33400b.k0(buffer, j10);
            V();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink n0(String str, int i10, int i11) {
        j.g(str, "string");
        if (!this.f33401c) {
            this.f33400b.n0(str, i10, i11);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public long o0(Source source) {
        j.g(source, "source");
        long j10 = 0;
        while (true) {
            long N1 = source.N1(this.f33400b, 8192);
            if (N1 == -1) {
                return j10;
            }
            j10 += N1;
            V();
        }
    }

    public Timeout p() {
        return this.f33399a.p();
    }

    public String toString() {
        return "buffer(" + this.f33399a + PropertyUtils.MAPPED_DELIM2;
    }

    public int write(ByteBuffer byteBuffer) {
        j.g(byteBuffer, "source");
        if (!this.f33401c) {
            int write = this.f33400b.write(byteBuffer);
            V();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeByte(int i10) {
        if (!this.f33401c) {
            this.f33400b.writeByte(i10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeInt(int i10) {
        if (!this.f33401c) {
            this.f33400b.writeInt(i10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShort(int i10) {
        if (!this.f33401c) {
            this.f33400b.writeShort(i10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink x1(long j10) {
        if (!this.f33401c) {
            this.f33400b.x1(j10);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr) {
        j.g(bArr, "source");
        if (!this.f33401c) {
            this.f33400b.write(bArr);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr, int i10, int i11) {
        j.g(bArr, "source");
        if (!this.f33401c) {
            this.f33400b.write(bArr, i10, i11);
            return V();
        }
        throw new IllegalStateException("closed".toString());
    }
}
