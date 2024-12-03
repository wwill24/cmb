package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\rH&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\rH&J\b\u0010\u001f\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u0000H&R\u0014\u0010$\u001a\u00020!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/ByteString;", "byteString", "K1", "", "source", "write", "", "offset", "byteCount", "Lokio/Source;", "", "o0", "", "string", "h0", "beginIndex", "endIndex", "n0", "b", "writeByte", "s", "writeShort", "i", "writeInt", "v", "J0", "x1", "", "flush", "V", "Lokio/Buffer;", "d", "()Lokio/Buffer;", "buffer", "okio"}, k = 1, mv = {1, 6, 0})
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink J0(long j10) throws IOException;

    BufferedSink K1(ByteString byteString) throws IOException;

    BufferedSink V() throws IOException;

    Buffer d();

    void flush() throws IOException;

    BufferedSink h0(String str) throws IOException;

    BufferedSink n0(String str, int i10, int i11) throws IOException;

    long o0(Source source) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i10, int i11) throws IOException;

    BufferedSink writeByte(int i10) throws IOException;

    BufferedSink writeInt(int i10) throws IOException;

    BufferedSink writeShort(int i10) throws IOException;

    BufferedSink x1(long j10) throws IOException;
}
