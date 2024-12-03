package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H&J\u0010\u0010$\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010%\u001a\u00020#H&J\u0010\u0010'\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0007H&J\u0010\u0010*\u001a\u00020#2\u0006\u0010)\u001a\u00020(H&J \u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H&J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0017H&J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H&J\u0018\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0017H&J\b\u00105\u001a\u00020\u0000H&J\b\u00107\u001a\u000206H&R\u0014\u0010:\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006;À\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "B", "", "Y0", "", "byteCount", "", "G0", "r", "", "readByte", "", "readShort", "C0", "", "readInt", "D1", "D0", "Y1", "skip", "Lokio/ByteString;", "y1", "O0", "Lokio/Options;", "options", "a2", "", "V0", "y0", "Lokio/Sink;", "sink", "P1", "", "L0", "w0", "limit", "X", "Ljava/nio/charset/Charset;", "charset", "s1", "b", "fromIndex", "toIndex", "T", "bytes", "M", "targetBytes", "U", "offset", "j0", "peek", "Ljava/io/InputStream;", "Z1", "d", "()Lokio/Buffer;", "buffer", "okio"}, k = 1, mv = {1, 6, 0})
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer B();

    short C0() throws IOException;

    long D0() throws IOException;

    int D1() throws IOException;

    void G0(long j10) throws IOException;

    String L0(long j10) throws IOException;

    long M(ByteString byteString) throws IOException;

    ByteString O0(long j10) throws IOException;

    long P1(Sink sink) throws IOException;

    long T(byte b10, long j10, long j11) throws IOException;

    long U(ByteString byteString) throws IOException;

    byte[] V0() throws IOException;

    String X(long j10) throws IOException;

    boolean Y0() throws IOException;

    long Y1() throws IOException;

    InputStream Z1();

    int a2(Options options) throws IOException;

    Buffer d();

    boolean j0(long j10, ByteString byteString) throws IOException;

    BufferedSource peek();

    boolean r(long j10) throws IOException;

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    String s1(Charset charset) throws IOException;

    void skip(long j10) throws IOException;

    String w0() throws IOException;

    byte[] y0(long j10) throws IOException;

    ByteString y1() throws IOException;
}
