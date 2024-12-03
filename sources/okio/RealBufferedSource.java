package okio;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.internal.d;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010E\u001a\u00020C¢\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\rH\u0016J \u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000fH\u0016J\u0018\u0010-\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000fH\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0018\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000fH\u0016J(\u0010:\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0001H\u0016J\b\u0010=\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020\u001dH\u0016R\u0014\u0010E\u001a\u00020C8\u0006X\u0004¢\u0006\u0006\n\u0004\b.\u0010DR\u0014\u0010G\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b-\u0010FR\u0016\u0010I\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b6\u0010HR\u001b\u0010N\u001a\u00020\u00028Ö\u0002X\u0004¢\u0006\f\u0012\u0004\bL\u0010M\u001a\u0004\bJ\u0010K¨\u0006Q"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "Lokio/Buffer;", "B", "sink", "", "byteCount", "N1", "", "Y0", "", "G0", "r", "", "readByte", "Lokio/ByteString;", "y1", "O0", "Lokio/Options;", "options", "", "a2", "", "V0", "y0", "Ljava/nio/ByteBuffer;", "read", "Lokio/Sink;", "P1", "", "L0", "Ljava/nio/charset/Charset;", "charset", "s1", "w0", "limit", "X", "", "readShort", "C0", "readInt", "D1", "D0", "Y1", "skip", "b", "a", "fromIndex", "toIndex", "T", "bytes", "M", "targetBytes", "U", "c", "offset", "j0", "bytesOffset", "e", "peek", "Ljava/io/InputStream;", "Z1", "isOpen", "close", "Lokio/Timeout;", "p", "toString", "Lokio/Source;", "Lokio/Source;", "source", "Lokio/Buffer;", "bufferField", "Z", "closed", "d", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Source;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a  reason: collision with root package name */
    public final Source f33403a;

    /* renamed from: b  reason: collision with root package name */
    public final Buffer f33404b = new Buffer();

    /* renamed from: c  reason: collision with root package name */
    public boolean f33405c;

    public RealBufferedSource(Source source) {
        j.g(source, "source");
        this.f33403a = source;
    }

    public Buffer B() {
        return this.f33404b;
    }

    public short C0() {
        G0(2);
        return this.f33404b.C0();
    }

    public long D0() {
        G0(8);
        return this.f33404b.D0();
    }

    public int D1() {
        G0(4);
        return this.f33404b.D1();
    }

    public void G0(long j10) {
        if (!r(j10)) {
            throw new EOFException();
        }
    }

    public String L0(long j10) {
        G0(j10);
        return this.f33404b.L0(j10);
    }

    public long M(ByteString byteString) {
        j.g(byteString, "bytes");
        return b(byteString, 0);
    }

    public long N1(Buffer buffer, long j10) {
        boolean z10;
        j.g(buffer, "sink");
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!this.f33405c)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f33404b.size() == 0 && this.f33403a.N1(this.f33404b, 8192) == -1) {
            return -1;
        } else {
            return this.f33404b.N1(buffer, Math.min(j10, this.f33404b.size()));
        }
    }

    public ByteString O0(long j10) {
        G0(j10);
        return this.f33404b.O0(j10);
    }

    public long P1(Sink sink) {
        j.g(sink, "sink");
        long j10 = 0;
        while (this.f33403a.N1(this.f33404b, 8192) != -1) {
            long c10 = this.f33404b.c();
            if (c10 > 0) {
                j10 += c10;
                sink.k0(this.f33404b, c10);
            }
        }
        if (this.f33404b.size() <= 0) {
            return j10;
        }
        long size = j10 + this.f33404b.size();
        Buffer buffer = this.f33404b;
        sink.k0(buffer, buffer.size());
        return size;
    }

    public long T(byte b10, long j10, long j11) {
        boolean z10 = true;
        if (!this.f33405c) {
            if (0 > j10 || j10 > j11) {
                z10 = false;
            }
            if (z10) {
                while (j10 < j11) {
                    long T = this.f33404b.T(b10, j10, j11);
                    if (T != -1) {
                        return T;
                    }
                    long size = this.f33404b.size();
                    if (size >= j11 || this.f33403a.N1(this.f33404b, 8192) == -1) {
                        return -1;
                    }
                    j10 = Math.max(j10, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public long U(ByteString byteString) {
        j.g(byteString, "targetBytes");
        return c(byteString, 0);
    }

    public byte[] V0() {
        this.f33404b.o0(this.f33403a);
        return this.f33404b.V0();
    }

    public String X(long j10) {
        boolean z10;
        long j11;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (j10 == Long.MAX_VALUE) {
                j11 = Long.MAX_VALUE;
            } else {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long T = T(b10, 0, j11);
            if (T != -1) {
                return d.c(this.f33404b, T);
            }
            if (j11 < Long.MAX_VALUE && r(j11) && this.f33404b.l(j11 - 1) == ((byte) 13) && r(1 + j11) && this.f33404b.l(j11) == b10) {
                return d.c(this.f33404b, j11);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f33404b;
            buffer2.h(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f33404b.size(), j10) + " content=" + buffer.y1().p() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public boolean Y0() {
        if (!(!this.f33405c)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.f33404b.Y0() || this.f33403a.N1(this.f33404b, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long Y1() {
        /*
            r5 = this;
            r0 = 1
            r5.G0(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.r(r2)
            if (r2 == 0) goto L_0x0064
            okio.Buffer r2 = r5.f33404b
            long r3 = (long) r0
            byte r2 = r2.l(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0020
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x0020:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002a
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x002a:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0037
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0006
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x0064
        L_0x003a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r3)
            r3 = 16
            int r3 = kotlin.text.b.a(r3)
            int r3 = kotlin.text.b.a(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.j.f(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0064:
            okio.Buffer r0 = r5.f33404b
            long r0 = r0.Y1()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.Y1():long");
    }

    public InputStream Z1() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public long a(byte b10) {
        return T(b10, 0, Long.MAX_VALUE);
    }

    public int a2(Options options) {
        j.g(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        if (!this.f33405c) {
            while (true) {
                int d10 = d.d(this.f33404b, options, true);
                if (d10 == -2) {
                    if (this.f33403a.N1(this.f33404b, 8192) == -1) {
                        break;
                    }
                } else if (d10 != -1) {
                    this.f33404b.skip((long) options.g()[d10].H());
                    return d10;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long b(ByteString byteString, long j10) {
        j.g(byteString, "bytes");
        if (!this.f33405c) {
            while (true) {
                long u10 = this.f33404b.u(byteString, j10);
                if (u10 != -1) {
                    return u10;
                }
                long size = this.f33404b.size();
                if (this.f33403a.N1(this.f33404b, 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, (size - ((long) byteString.H())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long c(ByteString byteString, long j10) {
        j.g(byteString, "targetBytes");
        if (!this.f33405c) {
            while (true) {
                long v10 = this.f33404b.v(byteString, j10);
                if (v10 != -1) {
                    return v10;
                }
                long size = this.f33404b.size();
                if (this.f33403a.N1(this.f33404b, 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public void close() {
        if (!this.f33405c) {
            this.f33405c = true;
            this.f33403a.close();
            this.f33404b.a();
        }
    }

    public Buffer d() {
        return this.f33404b;
    }

    public boolean e(long j10, ByteString byteString, int i10, int i11) {
        j.g(byteString, "bytes");
        if (!this.f33405c) {
            if (j10 >= 0 && i10 >= 0 && i11 >= 0 && byteString.H() - i10 >= i11) {
                int i12 = 0;
                while (i12 < i11) {
                    long j11 = ((long) i12) + j10;
                    if (r(1 + j11) && this.f33404b.l(j11) == byteString.i(i10 + i12)) {
                        i12++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.f33405c;
    }

    public boolean j0(long j10, ByteString byteString) {
        j.g(byteString, "bytes");
        return e(j10, byteString, 0, byteString.H());
    }

    public Timeout p() {
        return this.f33403a.p();
    }

    public BufferedSource peek() {
        return Okio.c(new PeekSource(this));
    }

    public boolean r(long j10) {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!this.f33405c) {
            while (this.f33404b.size() < j10) {
                if (this.f33403a.N1(this.f33404b, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public int read(ByteBuffer byteBuffer) {
        j.g(byteBuffer, "sink");
        if (this.f33404b.size() == 0 && this.f33403a.N1(this.f33404b, 8192) == -1) {
            return -1;
        }
        return this.f33404b.read(byteBuffer);
    }

    public byte readByte() {
        G0(1);
        return this.f33404b.readByte();
    }

    public int readInt() {
        G0(4);
        return this.f33404b.readInt();
    }

    public short readShort() {
        G0(2);
        return this.f33404b.readShort();
    }

    public String s1(Charset charset) {
        j.g(charset, "charset");
        this.f33404b.o0(this.f33403a);
        return this.f33404b.s1(charset);
    }

    public void skip(long j10) {
        if (!this.f33405c) {
            while (j10 > 0) {
                if (this.f33404b.size() == 0 && this.f33403a.N1(this.f33404b, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, this.f33404b.size());
                this.f33404b.skip(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public String toString() {
        return "buffer(" + this.f33403a + PropertyUtils.MAPPED_DELIM2;
    }

    public String w0() {
        return X(Long.MAX_VALUE);
    }

    public byte[] y0(long j10) {
        G0(j10);
        return this.f33404b.y0(j10);
    }

    public ByteString y1() {
        this.f33404b.o0(this.f33403a);
        return this.f33404b.y1();
    }
}
