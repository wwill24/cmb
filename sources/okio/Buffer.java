package okio;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.jivesoftware.smack.datatypes.UInt32;

@Metadata(bv = {}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\t¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0005\u001a\u00020\u0000H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020.2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020.2\u0006\u00102\u001a\u000201H\u0016J\u0018\u00104\u001a\u00020.2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00102\u001a\u000201H\u0016J\b\u00105\u001a\u00020.H\u0016J\u0010\u00107\u001a\u00020.2\u0006\u00106\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u000208H\u0016J\u0010\u0010:\u001a\u0002082\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u0010,\u001a\u000208H\u0016J \u0010<\u001a\u00020\u001e2\u0006\u0010,\u001a\u0002082\u0006\u0010\u0014\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001eH\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020=H\u0016J\u0006\u0010>\u001a\u00020\rJ\u0010\u0010?\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020\u00002\u0006\u0010@\u001a\u00020%H\u0016J\u0010\u0010C\u001a\u00020\u00002\u0006\u0010B\u001a\u00020.H\u0016J \u0010F\u001a\u00020\u00002\u0006\u0010B\u001a\u00020.2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001eH\u0016J\u0010\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u001eH\u0016J\u0018\u0010I\u001a\u00020\u00002\u0006\u0010B\u001a\u00020.2\u0006\u00102\u001a\u000201H\u0016J(\u0010J\u001a\u00020\u00002\u0006\u0010B\u001a\u00020.2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e2\u0006\u00102\u001a\u000201H\u0016J\u0010\u0010L\u001a\u00020\u00002\u0006\u0010K\u001a\u000208H\u0016J \u0010M\u001a\u00020\u00002\u0006\u0010K\u001a\u0002082\u0006\u0010\u0014\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001eH\u0016J\u0010\u0010N\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020=H\u0016J\u0010\u0010P\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020OH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001eH\u0016J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u001eH\u0016J\u0010\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u001eH\u0016J\u0010\u0010W\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u001eH\u0016J\u0010\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u000bH\u0016J\u0010\u0010Z\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u000bH\u0016J\u0017\u0010]\u001a\u00020\\2\u0006\u0010[\u001a\u00020\u001eH\u0000¢\u0006\u0004\b]\u0010^J\u0018\u0010_\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010`\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010c\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000bH\u0016J\u0010\u0010e\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020%H\u0016J\u0018\u0010f\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000bH\u0016J\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020%H\u0016J\u0018\u0010X\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000bH\u0016J\u0018\u0010i\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020%H\u0016J(\u0010k\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020%2\u0006\u0010j\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001eH\u0016J\b\u0010l\u001a\u00020\rH\u0016J\b\u0010m\u001a\u00020\tH\u0016J\b\u0010n\u001a\u00020\rH\u0016J\b\u0010p\u001a\u00020oH\u0016J\u0013\u0010s\u001a\u00020\t2\b\u0010r\u001a\u0004\u0018\u00010qH\u0002J\b\u0010t\u001a\u00020\u001eH\u0016J\b\u0010u\u001a\u00020.H\u0016J\u0006\u0010v\u001a\u00020\u0000J\b\u0010Q\u001a\u00020\u0000H\u0016J\u0006\u0010w\u001a\u00020%J\u000e\u0010x\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u001eR\u0018\u0010z\u001a\u0004\u0018\u00010\\8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b>\u0010yR*\u0010|\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020\u000b8G@@X\u000e¢\u0006\u0012\n\u0004\bQ\u0010w\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u0017\u0010\u0001\u001a\u00020\u00008VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "B", "Ljava/io/OutputStream;", "x", "k", "", "Y0", "", "byteCount", "", "G0", "r", "peek", "Ljava/io/InputStream;", "Z1", "out", "offset", "h", "c", "", "readByte", "pos", "l", "(J)B", "", "readShort", "", "readInt", "E", "C0", "D1", "D0", "Y1", "Lokio/ByteString;", "y1", "O0", "Lokio/Options;", "options", "a2", "Lokio/Sink;", "sink", "P1", "", "G", "L0", "Ljava/nio/charset/Charset;", "charset", "s1", "F", "w0", "limit", "X", "", "V0", "y0", "C", "read", "Ljava/nio/ByteBuffer;", "a", "skip", "byteString", "S", "string", "v0", "beginIndex", "endIndex", "x0", "codePoint", "A0", "u0", "t0", "source", "Y", "c0", "write", "Lokio/Source;", "o0", "b", "f0", "s", "s0", "i", "q0", "r0", "v", "i0", "m0", "minimumCapacity", "Lokio/Segment;", "O", "(I)Lokio/Segment;", "k0", "N1", "fromIndex", "toIndex", "T", "bytes", "M", "u", "targetBytes", "U", "j0", "bytesOffset", "y", "flush", "isOpen", "close", "Lokio/Timeout;", "p", "", "other", "equals", "hashCode", "toString", "e", "J", "N", "Lokio/Segment;", "head", "<set-?>", "size", "()J", "I", "(J)V", "d", "()Lokio/Buffer;", "buffer", "<init>", "()V", "UnsafeCursor", "okio"}, k = 1, mv = {1, 6, 0})
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: a  reason: collision with root package name */
    public Segment f33298a;

    /* renamed from: b  reason: collision with root package name */
    private long f33299b;

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\u0005\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001f"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "", "close", "Lokio/Buffer;", "a", "Lokio/Buffer;", "buffer", "Lokio/Segment;", "b", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "(Lokio/Segment;)V", "segment", "", "c", "J", "offset", "", "d", "[B", "data", "", "e", "I", "start", "f", "end", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class UnsafeCursor implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public Buffer f33300a;

        /* renamed from: b  reason: collision with root package name */
        private Segment f33301b;

        /* renamed from: c  reason: collision with root package name */
        public long f33302c = -1;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f33303d;

        /* renamed from: e  reason: collision with root package name */
        public int f33304e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f33305f = -1;

        public final void a(Segment segment) {
            this.f33301b = segment;
        }

        public void close() {
            boolean z10;
            if (this.f33300a != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f33300a = null;
                a((Segment) null);
                this.f33302c = -1;
                this.f33303d = null;
                this.f33304e = -1;
                this.f33305f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public Buffer A0(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            Segment O = O(2);
            byte[] bArr = O.f33408a;
            int i11 = O.f33410c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            O.f33410c = i11 + 2;
            I(size() + 2);
        } else {
            boolean z10 = false;
            if (55296 <= i10 && i10 < 57344) {
                z10 = true;
            }
            if (z10) {
                writeByte(63);
            } else if (i10 < 65536) {
                Segment O2 = O(3);
                byte[] bArr2 = O2.f33408a;
                int i12 = O2.f33410c;
                bArr2[i12] = (byte) ((i10 >> 12) | 224);
                bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                O2.f33410c = i12 + 3;
                I(size() + 3);
            } else if (i10 <= 1114111) {
                Segment O3 = O(4);
                byte[] bArr3 = O3.f33408a;
                int i13 = O3.f33410c;
                bArr3[i13] = (byte) ((i10 >> 18) | 240);
                bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                O3.f33410c = i13 + 4;
                I(size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.j(i10));
            }
        }
        return this;
    }

    public Buffer B() {
        return this;
    }

    public void C(byte[] bArr) throws EOFException {
        j.g(bArr, "sink");
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read != -1) {
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public short C0() throws EOFException {
        return _UtilKt.h(readShort());
    }

    public long D0() throws EOFException {
        return _UtilKt.g(E());
    }

    public int D1() throws EOFException {
        return _UtilKt.f(readInt());
    }

    public long E() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.f33298a;
            j.d(segment);
            int i10 = segment.f33409b;
            int i11 = segment.f33410c;
            if (((long) (i11 - i10)) < 8) {
                return ((((long) readInt()) & UInt32.MAX_VALUE_LONG) << 32) | (UInt32.MAX_VALUE_LONG & ((long) readInt()));
            }
            byte[] bArr = segment.f33408a;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            long j10 = ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i12]) & 255) << 48) | ((((long) bArr[i13]) & 255) << 40) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24) | ((((long) bArr[i16]) & 255) << 16);
            int i18 = i17 + 1;
            int i19 = i18 + 1;
            long j11 = j10 | ((((long) bArr[i17]) & 255) << 8) | (((long) bArr[i18]) & 255);
            I(size() - 8);
            if (i19 == i11) {
                this.f33298a = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f33409b = i19;
            }
            return j11;
        }
        throw new EOFException();
    }

    public String F(long j10, Charset charset) throws EOFException {
        boolean z10;
        j.g(charset, "charset");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (this.f33299b < j10) {
            throw new EOFException();
        } else if (i10 == 0) {
            return "";
        } else {
            Segment segment = this.f33298a;
            j.d(segment);
            int i11 = segment.f33409b;
            if (((long) i11) + j10 > ((long) segment.f33410c)) {
                return new String(y0(j10), charset);
            }
            int i12 = (int) j10;
            String str = new String(segment.f33408a, i11, i12, charset);
            int i13 = segment.f33409b + i12;
            segment.f33409b = i13;
            this.f33299b -= j10;
            if (i13 == segment.f33410c) {
                this.f33298a = segment.b();
                SegmentPool.b(segment);
            }
            return str;
        }
    }

    public String G() {
        return F(this.f33299b, d.f32216b);
    }

    public void G0(long j10) throws EOFException {
        if (this.f33299b < j10) {
            throw new EOFException();
        }
    }

    public final void I(long j10) {
        this.f33299b = j10;
    }

    public final ByteString J() {
        boolean z10;
        if (size() <= 2147483647L) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return N((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public String L0(long j10) throws EOFException {
        return F(j10, d.f32216b);
    }

    public long M(ByteString byteString) throws IOException {
        j.g(byteString, "bytes");
        return u(byteString, 0);
    }

    public final ByteString N(int i10) {
        if (i10 == 0) {
            return ByteString.f33309d;
        }
        _UtilKt.b(size(), 0, (long) i10);
        Segment segment = this.f33298a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            j.d(segment);
            int i14 = segment.f33410c;
            int i15 = segment.f33409b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                segment = segment.f33413f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[(i13 * 2)];
        Segment segment2 = this.f33298a;
        int i16 = 0;
        while (i11 < i10) {
            j.d(segment2);
            bArr[i16] = segment2.f33408a;
            i11 += segment2.f33410c - segment2.f33409b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = segment2.f33409b;
            segment2.f33411d = true;
            i16++;
            segment2 = segment2.f33413f;
        }
        return new SegmentedByteString(bArr, iArr);
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
        } else if (size() == 0) {
            return -1;
        } else {
            if (j10 > size()) {
                j10 = size();
            }
            buffer.k0(this, j10);
            return j10;
        }
    }

    public final Segment O(int i10) {
        boolean z10 = true;
        if (i10 < 1 || i10 > 8192) {
            z10 = false;
        }
        if (z10) {
            Segment segment = this.f33298a;
            if (segment == null) {
                Segment c10 = SegmentPool.c();
                this.f33298a = c10;
                c10.f33414g = c10;
                c10.f33413f = c10;
                return c10;
            }
            j.d(segment);
            Segment segment2 = segment.f33414g;
            j.d(segment2);
            if (segment2.f33410c + i10 > 8192 || !segment2.f33412e) {
                return segment2.c(SegmentPool.c());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public ByteString O0(long j10) throws EOFException {
        boolean z10;
        if (j10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (size() < j10) {
            throw new EOFException();
        } else if (j10 < 4096) {
            return new ByteString(y0(j10));
        } else {
            ByteString N = N((int) j10);
            skip(j10);
            return N;
        }
    }

    public long P1(Sink sink) throws IOException {
        j.g(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.k0(this, size);
        }
        return size;
    }

    /* renamed from: S */
    public Buffer K1(ByteString byteString) {
        j.g(byteString, "byteString");
        byteString.R(this, 0, byteString.H());
        return this;
    }

    public long T(byte b10, long j10, long j11) {
        Segment segment;
        int i10;
        long j12;
        long j13 = 0;
        boolean z10 = false;
        if (0 <= j10 && j10 <= j11) {
            z10 = true;
        }
        if (z10) {
            if (j11 > size()) {
                j11 = size();
            }
            if (j10 == j11 || (segment = this.f33298a) == null) {
                return -1;
            }
            if (size() - j10 < j10) {
                j12 = size();
                while (j12 > j10) {
                    segment = segment.f33414g;
                    j.d(segment);
                    j12 -= (long) (segment.f33410c - segment.f33409b);
                }
                while (j12 < j11) {
                    byte[] bArr = segment.f33408a;
                    int min = (int) Math.min((long) segment.f33410c, (((long) segment.f33409b) + j11) - j12);
                    i10 = (int) ((((long) segment.f33409b) + j10) - j12);
                    while (i10 < min) {
                        if (bArr[i10] != b10) {
                            i10++;
                        }
                    }
                    j12 += (long) (segment.f33410c - segment.f33409b);
                    segment = segment.f33413f;
                    j.d(segment);
                    j10 = j12;
                }
                return -1;
            }
            while (true) {
                long j14 = ((long) (segment.f33410c - segment.f33409b)) + j13;
                if (j14 > j10) {
                    break;
                }
                segment = segment.f33413f;
                j.d(segment);
                j13 = j14;
            }
            while (j12 < j11) {
                byte[] bArr2 = segment.f33408a;
                int min2 = (int) Math.min((long) segment.f33410c, (((long) segment.f33409b) + j11) - j12);
                int i11 = (int) ((((long) segment.f33409b) + j10) - j12);
                while (i10 < min2) {
                    if (bArr2[i10] != b10) {
                        i11 = i10 + 1;
                    }
                }
                j13 = j12 + ((long) (segment.f33410c - segment.f33409b));
                segment = segment.f33413f;
                j.d(segment);
                j10 = j13;
            }
            return -1;
            return ((long) (i10 - segment.f33409b)) + j12;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    public long U(ByteString byteString) {
        j.g(byteString, "targetBytes");
        return v(byteString, 0);
    }

    public byte[] V0() {
        return y0(size());
    }

    public String X(long j10) throws EOFException {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            long j11 = Long.MAX_VALUE;
            if (j10 != Long.MAX_VALUE) {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long T = T(b10, 0, j11);
            if (T != -1) {
                return okio.internal.d.c(this, T);
            }
            if (j11 < size() && l(j11 - 1) == ((byte) 13) && l(j11) == b10) {
                return okio.internal.d.c(this, j11);
            }
            Buffer buffer = new Buffer();
            h(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.y1().p() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    /* renamed from: Y */
    public Buffer write(byte[] bArr) {
        j.g(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public boolean Y0() {
        return this.f33299b == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        if (r8 != r9) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        r14.f33298a = r6.b();
        okio.SegmentPool.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r6.f33409b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        if (r1 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long Y1() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b8
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000d:
            okio.Segment r6 = r14.f33298a
            kotlin.jvm.internal.j.d(r6)
            byte[] r7 = r6.f33408a
            int r8 = r6.f33409b
            int r9 = r6.f33410c
        L_0x0018:
            if (r8 >= r9) goto L_0x009a
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0043
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0038
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0038
        L_0x0033:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0043
        L_0x0038:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x007b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x007b
            goto L_0x0033
        L_0x0043:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0053
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0053:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.x1(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.G()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x007b:
            if (r0 == 0) goto L_0x007f
            r1 = 1
            goto L_0x009a
        L_0x007f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio._UtilKt.i(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009a:
            if (r8 != r9) goto L_0x00a6
            okio.Segment r7 = r6.b()
            r14.f33298a = r7
            okio.SegmentPool.b(r6)
            goto L_0x00a8
        L_0x00a6:
            r6.f33409b = r8
        L_0x00a8:
            if (r1 != 0) goto L_0x00ae
            okio.Segment r6 = r14.f33298a
            if (r6 != 0) goto L_0x000d
        L_0x00ae:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.I(r1)
            return r4
        L_0x00b8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.Y1():long");
    }

    public InputStream Z1() {
        return new Buffer$inputStream$1(this);
    }

    public final void a() {
        skip(size());
    }

    public int a2(Options options) {
        j.g(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        int e10 = okio.internal.d.e(this, options, false, 2, (Object) null);
        if (e10 == -1) {
            return -1;
        }
        skip((long) options.g()[e10].H());
        return e10;
    }

    /* renamed from: b */
    public Buffer clone() {
        return e();
    }

    public final long c() {
        long size = size();
        if (size == 0) {
            return 0;
        }
        Segment segment = this.f33298a;
        j.d(segment);
        Segment segment2 = segment.f33414g;
        j.d(segment2);
        int i10 = segment2.f33410c;
        if (i10 < 8192 && segment2.f33412e) {
            size -= (long) (i10 - segment2.f33409b);
        }
        return size;
    }

    /* renamed from: c0 */
    public Buffer write(byte[] bArr, int i10, int i11) {
        j.g(bArr, "source");
        long j10 = (long) i11;
        _UtilKt.b((long) bArr.length, (long) i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment O = O(1);
            int min = Math.min(i12 - i10, 8192 - O.f33410c);
            int i13 = i10 + min;
            byte[] unused = k.f(bArr, O.f33408a, O.f33410c, i10, i13);
            O.f33410c += min;
            i10 = i13;
        }
        I(size() + j10);
        return this;
    }

    public void close() {
    }

    public Buffer d() {
        return this;
    }

    public final Buffer e() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.f33298a;
            j.d(segment);
            Segment d10 = segment.d();
            buffer.f33298a = d10;
            d10.f33414g = d10;
            d10.f33413f = d10;
            for (Segment segment2 = segment.f33413f; segment2 != segment; segment2 = segment2.f33413f) {
                Segment segment3 = d10.f33414g;
                j.d(segment3);
                j.d(segment2);
                segment3.c(segment2.d());
            }
            buffer.I(size());
        }
        return buffer;
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x000b
        L_0x0008:
            r2 = r3
            goto L_0x0082
        L_0x000b:
            boolean r4 = r1 instanceof okio.Buffer
            if (r4 != 0) goto L_0x0011
            goto L_0x0082
        L_0x0011:
            long r4 = r20.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r6 = r1.size()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0020
            goto L_0x0082
        L_0x0020:
            long r4 = r20.size()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x002b
            goto L_0x0008
        L_0x002b:
            okio.Segment r4 = r0.f33298a
            kotlin.jvm.internal.j.d(r4)
            okio.Segment r1 = r1.f33298a
            kotlin.jvm.internal.j.d(r1)
            int r5 = r4.f33409b
            int r8 = r1.f33409b
            r9 = r6
        L_0x003a:
            long r11 = r20.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0008
            int r11 = r4.f33410c
            int r11 = r11 - r5
            int r12 = r1.f33410c
            int r12 = r12 - r8
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r6
        L_0x004e:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x006a
            byte[] r15 = r4.f33408a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f33408a
            int r17 = r8 + 1
            byte r8 = r15[r8]
            if (r5 == r8) goto L_0x0061
            goto L_0x0082
        L_0x0061:
            r18 = 1
            long r13 = r13 + r18
            r5 = r16
            r8 = r17
            goto L_0x004e
        L_0x006a:
            int r13 = r4.f33410c
            if (r5 != r13) goto L_0x0075
            okio.Segment r4 = r4.f33413f
            kotlin.jvm.internal.j.d(r4)
            int r5 = r4.f33409b
        L_0x0075:
            int r13 = r1.f33410c
            if (r8 != r13) goto L_0x0080
            okio.Segment r1 = r1.f33413f
            kotlin.jvm.internal.j.d(r1)
            int r8 = r1.f33409b
        L_0x0080:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x0082:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    /* renamed from: f0 */
    public Buffer writeByte(int i10) {
        Segment O = O(1);
        byte[] bArr = O.f33408a;
        int i11 = O.f33410c;
        O.f33410c = i11 + 1;
        bArr[i11] = (byte) i10;
        I(size() + 1);
        return this;
    }

    public void flush() {
    }

    public final Buffer h(Buffer buffer, long j10, long j11) {
        j.g(buffer, "out");
        _UtilKt.b(size(), j10, j11);
        if (j11 != 0) {
            buffer.I(buffer.size() + j11);
            Segment segment = this.f33298a;
            while (true) {
                j.d(segment);
                int i10 = segment.f33410c;
                int i11 = segment.f33409b;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                segment = segment.f33413f;
            }
            while (j11 > 0) {
                j.d(segment);
                Segment d10 = segment.d();
                int i12 = d10.f33409b + ((int) j10);
                d10.f33409b = i12;
                d10.f33410c = Math.min(i12 + ((int) j11), d10.f33410c);
                Segment segment2 = buffer.f33298a;
                if (segment2 == null) {
                    d10.f33414g = d10;
                    d10.f33413f = d10;
                    buffer.f33298a = d10;
                } else {
                    j.d(segment2);
                    Segment segment3 = segment2.f33414g;
                    j.d(segment3);
                    segment3.c(d10);
                }
                j11 -= (long) (d10.f33410c - d10.f33409b);
                segment = segment.f33413f;
                j10 = 0;
            }
        }
        return this;
    }

    public int hashCode() {
        Segment segment = this.f33298a;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.f33410c;
            for (int i12 = segment.f33409b; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.f33408a[i12];
            }
            segment = segment.f33413f;
            j.d(segment);
        } while (segment != this.f33298a);
        return i10;
    }

    /* renamed from: i0 */
    public Buffer J0(long j10) {
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            return writeByte(48);
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return h0("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 < 100000000) {
            if (j10 < 10000) {
                if (j10 < 100) {
                    if (j10 >= 10) {
                        i11 = 2;
                    }
                } else if (j10 < 1000) {
                    i11 = 3;
                } else {
                    i11 = 4;
                }
            } else if (j10 < 1000000) {
                if (j10 < 100000) {
                    i11 = 5;
                } else {
                    i11 = 6;
                }
            } else if (j10 < 10000000) {
                i11 = 7;
            } else {
                i11 = 8;
            }
        } else if (j10 < 1000000000000L) {
            if (j10 < 10000000000L) {
                if (j10 < 1000000000) {
                    i11 = 9;
                } else {
                    i11 = 10;
                }
            } else if (j10 < 100000000000L) {
                i11 = 11;
            } else {
                i11 = 12;
            }
        } else if (j10 < 1000000000000000L) {
            if (j10 < 10000000000000L) {
                i11 = 13;
            } else if (j10 < 100000000000000L) {
                i11 = 14;
            } else {
                i11 = 15;
            }
        } else if (j10 < 100000000000000000L) {
            if (j10 < 10000000000000000L) {
                i11 = 16;
            } else {
                i11 = 17;
            }
        } else if (j10 < 1000000000000000000L) {
            i11 = 18;
        } else {
            i11 = 19;
        }
        if (z10) {
            i11++;
        }
        Segment O = O(i11);
        byte[] bArr = O.f33408a;
        int i12 = O.f33410c + i11;
        while (j10 != 0) {
            long j11 = (long) 10;
            i12--;
            bArr[i12] = okio.internal.d.a()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i12 - 1] = (byte) 45;
        }
        O.f33410c += i11;
        I(size() + ((long) i11));
        return this;
    }

    public boolean isOpen() {
        return true;
    }

    public boolean j0(long j10, ByteString byteString) {
        j.g(byteString, "bytes");
        return y(j10, byteString, 0, byteString.H());
    }

    /* renamed from: k */
    public Buffer V() {
        return this;
    }

    public void k0(Buffer buffer, long j10) {
        boolean z10;
        Segment segment;
        int i10;
        j.g(buffer, "source");
        if (buffer != this) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            _UtilKt.b(buffer.size(), 0, j10);
            while (j10 > 0) {
                Segment segment2 = buffer.f33298a;
                j.d(segment2);
                int i11 = segment2.f33410c;
                Segment segment3 = buffer.f33298a;
                j.d(segment3);
                if (j10 < ((long) (i11 - segment3.f33409b))) {
                    Segment segment4 = this.f33298a;
                    if (segment4 != null) {
                        j.d(segment4);
                        segment = segment4.f33414g;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.f33412e) {
                        long j11 = ((long) segment.f33410c) + j10;
                        if (segment.f33411d) {
                            i10 = 0;
                        } else {
                            i10 = segment.f33409b;
                        }
                        if (j11 - ((long) i10) <= 8192) {
                            Segment segment5 = buffer.f33298a;
                            j.d(segment5);
                            segment5.f(segment, (int) j10);
                            buffer.I(buffer.size() - j10);
                            I(size() + j10);
                            return;
                        }
                    }
                    Segment segment6 = buffer.f33298a;
                    j.d(segment6);
                    buffer.f33298a = segment6.e((int) j10);
                }
                Segment segment7 = buffer.f33298a;
                j.d(segment7);
                long j12 = (long) (segment7.f33410c - segment7.f33409b);
                buffer.f33298a = segment7.b();
                Segment segment8 = this.f33298a;
                if (segment8 == null) {
                    this.f33298a = segment7;
                    segment7.f33414g = segment7;
                    segment7.f33413f = segment7;
                } else {
                    j.d(segment8);
                    Segment segment9 = segment8.f33414g;
                    j.d(segment9);
                    segment9.c(segment7).a();
                }
                buffer.I(buffer.size() - j12);
                I(size() + j12);
                j10 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public final byte l(long j10) {
        _UtilKt.b(size(), j10, 1);
        Segment segment = this.f33298a;
        if (segment == null) {
            j.d((Object) null);
            throw null;
        } else if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                segment = segment.f33414g;
                j.d(segment);
                size -= (long) (segment.f33410c - segment.f33409b);
            }
            j.d(segment);
            return segment.f33408a[(int) ((((long) segment.f33409b) + j10) - size)];
        } else {
            long j11 = 0;
            while (true) {
                long j12 = ((long) (segment.f33410c - segment.f33409b)) + j11;
                if (j12 <= j10) {
                    segment = segment.f33413f;
                    j.d(segment);
                    j11 = j12;
                } else {
                    j.d(segment);
                    return segment.f33408a[(int) ((((long) segment.f33409b) + j10) - j11)];
                }
            }
        }
    }

    /* renamed from: m0 */
    public Buffer x1(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment O = O(i10);
        byte[] bArr = O.f33408a;
        int i11 = O.f33410c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = okio.internal.d.a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        O.f33410c += i10;
        I(size() + ((long) i10));
        return this;
    }

    public long o0(Source source) throws IOException {
        j.g(source, "source");
        long j10 = 0;
        while (true) {
            long N1 = source.N1(this, 8192);
            if (N1 == -1) {
                return j10;
            }
            j10 += N1;
        }
    }

    public Timeout p() {
        return Timeout.f33430e;
    }

    public BufferedSource peek() {
        return Okio.c(new PeekSource(this));
    }

    /* renamed from: q0 */
    public Buffer writeInt(int i10) {
        Segment O = O(4);
        byte[] bArr = O.f33408a;
        int i11 = O.f33410c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        O.f33410c = i14 + 1;
        I(size() + 4);
        return this;
    }

    public boolean r(long j10) {
        return this.f33299b >= j10;
    }

    public Buffer r0(int i10) {
        return writeInt(_UtilKt.f(i10));
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        j.g(byteBuffer, "sink");
        Segment segment = this.f33298a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.f33410c - segment.f33409b);
        byteBuffer.put(segment.f33408a, segment.f33409b, min);
        int i10 = segment.f33409b + min;
        segment.f33409b = i10;
        this.f33299b -= (long) min;
        if (i10 == segment.f33410c) {
            this.f33298a = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.f33298a;
            j.d(segment);
            int i10 = segment.f33409b;
            int i11 = segment.f33410c;
            int i12 = i10 + 1;
            byte b10 = segment.f33408a[i10];
            I(size() - 1);
            if (i12 == i11) {
                this.f33298a = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f33409b = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.f33298a;
            j.d(segment);
            int i10 = segment.f33409b;
            int i11 = segment.f33410c;
            if (((long) (i11 - i10)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << Tnaf.POW_2_WIDTH) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f33408a;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
            int i14 = i13 + 1;
            byte b11 = b10 | ((bArr[i13] & 255) << 8);
            int i15 = i14 + 1;
            byte b12 = b11 | (bArr[i14] & 255);
            I(size() - 4);
            if (i15 == i11) {
                this.f33298a = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f33409b = i15;
            }
            return b12;
        }
        throw new EOFException();
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.f33298a;
            j.d(segment);
            int i10 = segment.f33409b;
            int i11 = segment.f33410c;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f33408a;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
            I(size() - 2);
            if (i13 == i11) {
                this.f33298a = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f33409b = i13;
            }
            return (short) b10;
        }
        throw new EOFException();
    }

    /* renamed from: s0 */
    public Buffer writeShort(int i10) {
        Segment O = O(2);
        byte[] bArr = O.f33408a;
        int i11 = O.f33410c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        O.f33410c = i12 + 1;
        I(size() + 2);
        return this;
    }

    public String s1(Charset charset) {
        j.g(charset, "charset");
        return F(this.f33299b, charset);
    }

    public final long size() {
        return this.f33299b;
    }

    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            Segment segment = this.f33298a;
            if (segment != null) {
                int min = (int) Math.min(j10, (long) (segment.f33410c - segment.f33409b));
                long j11 = (long) min;
                I(size() - j11);
                j10 -= j11;
                int i10 = segment.f33409b + min;
                segment.f33409b = i10;
                if (i10 == segment.f33410c) {
                    this.f33298a = segment.b();
                    SegmentPool.b(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer t0(String str, int i10, int i11, Charset charset) {
        boolean z10;
        boolean z11;
        j.g(str, "string");
        j.g(charset, "charset");
        boolean z12 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 > str.length()) {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
                } else if (j.b(charset, d.f32216b)) {
                    return n0(str, i10, i11);
                } else {
                    String substring = str.substring(i10, i11);
                    j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    byte[] bytes = substring.getBytes(charset);
                    j.f(bytes, "this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
    }

    public String toString() {
        return J().toString();
    }

    public long u(ByteString byteString, long j10) throws IOException {
        boolean z10;
        boolean z11;
        long j11 = j10;
        j.g(byteString, "bytes");
        if (byteString.H() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            long j12 = 0;
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Segment segment = this.f33298a;
                if (segment != null) {
                    if (size() - j11 < j11) {
                        long size = size();
                        while (size > j11) {
                            segment = segment.f33414g;
                            j.d(segment);
                            size -= (long) (segment.f33410c - segment.f33409b);
                        }
                        byte[] t10 = byteString.t();
                        byte b10 = t10[0];
                        int H = byteString.H();
                        long size2 = (size() - ((long) H)) + 1;
                        while (size < size2) {
                            byte[] bArr = segment.f33408a;
                            long j13 = size;
                            int min = (int) Math.min((long) segment.f33410c, (((long) segment.f33409b) + size2) - size);
                            long j14 = ((long) segment.f33409b) + j11;
                            long j15 = j13;
                            for (int i10 = (int) (j14 - j15); i10 < min; i10++) {
                                if (bArr[i10] == b10 && okio.internal.d.b(segment, i10 + 1, t10, 1, H)) {
                                    return ((long) (i10 - segment.f33409b)) + j15;
                                }
                            }
                            size = j15 + ((long) (segment.f33410c - segment.f33409b));
                            segment = segment.f33413f;
                            j.d(segment);
                            j11 = size;
                        }
                    } else {
                        while (true) {
                            long j16 = ((long) (segment.f33410c - segment.f33409b)) + j12;
                            if (j16 > j11) {
                                break;
                            }
                            segment = segment.f33413f;
                            j.d(segment);
                            j12 = j16;
                        }
                        byte[] t11 = byteString.t();
                        byte b11 = t11[0];
                        int H2 = byteString.H();
                        long size3 = (size() - ((long) H2)) + 1;
                        while (j12 < size3) {
                            byte[] bArr2 = segment.f33408a;
                            long j17 = size3;
                            int min2 = (int) Math.min((long) segment.f33410c, (((long) segment.f33409b) + size3) - j12);
                            for (int i11 = (int) ((((long) segment.f33409b) + j11) - j12); i11 < min2; i11++) {
                                if (bArr2[i11] == b11) {
                                    if (okio.internal.d.b(segment, i11 + 1, t11, 1, H2)) {
                                        return ((long) (i11 - segment.f33409b)) + j12;
                                    }
                                }
                            }
                            j12 += (long) (segment.f33410c - segment.f33409b);
                            segment = segment.f33413f;
                            j.d(segment);
                            j11 = j12;
                            size3 = j17;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public Buffer u0(String str, Charset charset) {
        j.g(str, "string");
        j.g(charset, "charset");
        return t0(str, 0, str.length(), charset);
    }

    public long v(ByteString byteString, long j10) {
        boolean z10;
        int i10;
        long j11;
        int i11;
        int i12;
        j.g(byteString, "targetBytes");
        long j12 = 0;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Segment segment = this.f33298a;
            if (segment == null) {
                return -1;
            }
            if (size() - j10 < j10) {
                j11 = size();
                while (j11 > j10) {
                    segment = segment.f33414g;
                    j.d(segment);
                    j11 -= (long) (segment.f33410c - segment.f33409b);
                }
                if (byteString.H() == 2) {
                    byte i13 = byteString.i(0);
                    byte i14 = byteString.i(1);
                    while (j11 < size()) {
                        byte[] bArr = segment.f33408a;
                        i10 = (int) ((((long) segment.f33409b) + j10) - j11);
                        int i15 = segment.f33410c;
                        while (i10 < i15) {
                            byte b10 = bArr[i10];
                            if (!(b10 == i13 || b10 == i14)) {
                                i10++;
                            }
                        }
                        j11 += (long) (segment.f33410c - segment.f33409b);
                        segment = segment.f33413f;
                        j.d(segment);
                        j10 = j11;
                    }
                    return -1;
                }
                byte[] t10 = byteString.t();
                while (j11 < size()) {
                    byte[] bArr2 = segment.f33408a;
                    i12 = (int) ((((long) segment.f33409b) + j10) - j11);
                    int i16 = segment.f33410c;
                    while (i12 < i16) {
                        byte b11 = bArr2[i12];
                        for (byte b12 : t10) {
                            if (b11 == b12) {
                                i11 = segment.f33409b;
                                return ((long) (i10 - i11)) + j11;
                            }
                        }
                        i12++;
                    }
                    j11 += (long) (segment.f33410c - segment.f33409b);
                    segment = segment.f33413f;
                    j.d(segment);
                    j10 = j11;
                }
                return -1;
            }
            while (true) {
                long j13 = ((long) (segment.f33410c - segment.f33409b)) + j12;
                if (j13 > j10) {
                    break;
                }
                segment = segment.f33413f;
                j.d(segment);
                j12 = j13;
            }
            if (byteString.H() == 2) {
                byte i17 = byteString.i(0);
                byte i18 = byteString.i(1);
                while (j11 < size()) {
                    byte[] bArr3 = segment.f33408a;
                    int i19 = (int) ((((long) segment.f33409b) + j10) - j11);
                    int i20 = segment.f33410c;
                    while (i10 < i20) {
                        byte b13 = bArr3[i10];
                        if (!(b13 == i17 || b13 == i18)) {
                            i19 = i10 + 1;
                        }
                    }
                    j12 = j11 + ((long) (segment.f33410c - segment.f33409b));
                    segment = segment.f33413f;
                    j.d(segment);
                    j10 = j12;
                }
                return -1;
            }
            byte[] t11 = byteString.t();
            while (j11 < size()) {
                byte[] bArr4 = segment.f33408a;
                int i21 = (int) ((((long) segment.f33409b) + j10) - j11);
                int i22 = segment.f33410c;
                while (i12 < i22) {
                    byte b14 = bArr4[i12];
                    for (byte b15 : t11) {
                        if (b14 == b15) {
                            i11 = segment.f33409b;
                            return ((long) (i10 - i11)) + j11;
                        }
                    }
                    i21 = i12 + 1;
                }
                j12 = j11 + ((long) (segment.f33410c - segment.f33409b));
                segment = segment.f33413f;
                j.d(segment);
                j10 = j12;
            }
            return -1;
            i11 = segment.f33409b;
            return ((long) (i10 - i11)) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    /* renamed from: v0 */
    public Buffer h0(String str) {
        j.g(str, "string");
        return n0(str, 0, str.length());
    }

    public String w0() throws EOFException {
        return X(Long.MAX_VALUE);
    }

    public OutputStream x() {
        return new Buffer$outputStream$1(this);
    }

    /* renamed from: x0 */
    public Buffer n0(String str, int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        char c10;
        boolean z13;
        char charAt;
        j.g(str, "string");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= str.length()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    while (i10 < i11) {
                        char charAt2 = str.charAt(i10);
                        if (charAt2 < 128) {
                            Segment O = O(1);
                            byte[] bArr = O.f33408a;
                            int i12 = O.f33410c - i10;
                            int min = Math.min(i11, 8192 - i12);
                            int i13 = i10 + 1;
                            bArr[i10 + i12] = (byte) charAt2;
                            while (true) {
                                i10 = i13;
                                if (i10 >= min || (charAt = str.charAt(i10)) >= 128) {
                                    int i14 = O.f33410c;
                                    int i15 = (i12 + i10) - i14;
                                    O.f33410c = i14 + i15;
                                    I(size() + ((long) i15));
                                } else {
                                    i13 = i10 + 1;
                                    bArr[i10 + i12] = (byte) charAt;
                                }
                            }
                            int i142 = O.f33410c;
                            int i152 = (i12 + i10) - i142;
                            O.f33410c = i142 + i152;
                            I(size() + ((long) i152));
                        } else {
                            if (charAt2 < 2048) {
                                Segment O2 = O(2);
                                byte[] bArr2 = O2.f33408a;
                                int i16 = O2.f33410c;
                                bArr2[i16] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt2 & '?') | 128);
                                O2.f33410c = i16 + 2;
                                I(size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment O3 = O(3);
                                byte[] bArr3 = O3.f33408a;
                                int i17 = O3.f33410c;
                                bArr3[i17] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i17 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i17 + 2] = (byte) ((charAt2 & '?') | 128);
                                O3.f33410c = i17 + 3;
                                I(size() + 3);
                            } else {
                                int i18 = i10 + 1;
                                if (i18 < i11) {
                                    c10 = str.charAt(i18);
                                } else {
                                    c10 = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 > c10 || c10 >= 57344) {
                                        z13 = false;
                                    } else {
                                        z13 = true;
                                    }
                                    if (z13) {
                                        int i19 = (((charAt2 & 1023) << 10) | (c10 & 1023)) + 0;
                                        Segment O4 = O(4);
                                        byte[] bArr4 = O4.f33408a;
                                        int i20 = O4.f33410c;
                                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                                        O4.f33410c = i20 + 4;
                                        I(size() + 4);
                                        i10 += 2;
                                    }
                                }
                                writeByte(63);
                                i10 = i18;
                            }
                            i10++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }

    public boolean y(long j10, ByteString byteString, int i10, int i11) {
        j.g(byteString, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || size() - j10 < ((long) i11) || byteString.H() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (l(((long) i12) + j10) != byteString.i(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public byte[] y0(long j10) throws EOFException {
        boolean z10;
        if (j10 < 0 || j10 > 2147483647L) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (size() >= j10) {
            byte[] bArr = new byte[((int) j10)];
            C(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public ByteString y1() {
        return O0(size());
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        j.g(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            Segment O = O(1);
            int min = Math.min(i10, 8192 - O.f33410c);
            byteBuffer.get(O.f33408a, O.f33410c, min);
            i10 -= min;
            O.f33410c += min;
        }
        this.f33299b += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr, int i10, int i11) {
        j.g(bArr, "sink");
        _UtilKt.b((long) bArr.length, (long) i10, (long) i11);
        Segment segment = this.f33298a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.f33410c - segment.f33409b);
        byte[] bArr2 = segment.f33408a;
        int i12 = segment.f33409b;
        byte[] unused = k.f(bArr2, bArr, i10, i12, i12 + min);
        segment.f33409b += min;
        I(size() - ((long) min));
        if (segment.f33409b == segment.f33410c) {
            this.f33298a = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }
}
