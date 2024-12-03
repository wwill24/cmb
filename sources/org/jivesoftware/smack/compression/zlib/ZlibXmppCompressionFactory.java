package org.jivesoftware.smack.compression.zlib;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.compression.XmppCompressionFactory;

public final class ZlibXmppCompressionFactory extends XmppCompressionFactory {
    public static final ZlibXmppCompressionFactory INSTANCE = new ZlibXmppCompressionFactory();

    public static final class Stats {
        public final double compressionRatio;
        public final long compressorInBytes;
        public final long compressorOutBytes;
        public final double decompressionRatio;
        public final long decompressorInBytes;
        public final long decompressorOutBytes;
        public final int maxBytesWrittenAfterFullFlush;
        public final int maxInputOutput;
        public final int maxOutputOutput;
        private transient String toStringCache;

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "compressor-in-bytes: " + this.compressorInBytes + 10 + "compressor-out-bytes: " + this.compressorOutBytes + 10 + "compression-ratio: " + this.compressionRatio + 10 + "decompressor-in-bytes: " + this.decompressorInBytes + 10 + "decompressor-out-bytes: " + this.decompressorOutBytes + 10 + "decompression-ratio: " + this.decompressionRatio + 10 + "max-output-output: " + this.maxOutputOutput + 10 + "max-input-output: " + this.maxInputOutput + 10 + "max-bytes-written-after-full-flush: " + this.maxBytesWrittenAfterFullFlush + 10;
            this.toStringCache = str2;
            return str2;
        }

        private Stats(ZlibXmppInputOutputFilter zlibXmppInputOutputFilter) {
            long access$200 = zlibXmppInputOutputFilter.compressorOutBytes;
            this.compressorOutBytes = access$200;
            long access$300 = zlibXmppInputOutputFilter.compressorInBytes;
            this.compressorInBytes = access$300;
            this.compressionRatio = ((double) access$200) / ((double) access$300);
            long access$400 = zlibXmppInputOutputFilter.decompressorOutBytes;
            this.decompressorOutBytes = access$400;
            long access$500 = zlibXmppInputOutputFilter.decompressorInBytes;
            this.decompressorInBytes = access$500;
            this.decompressionRatio = ((double) access$500) / ((double) access$400);
            this.maxOutputOutput = zlibXmppInputOutputFilter.maxOutputOutput;
            this.maxInputOutput = zlibXmppInputOutputFilter.maxInputOutput;
            this.maxBytesWrittenAfterFullFlush = zlibXmppInputOutputFilter.maxBytesWrittenAfterFullFlush;
        }
    }

    private static final class ZlibXmppInputOutputFilter implements XmppInputOutputFilter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MINIMUM_OUTPUT_BUFFER_INCREASE = 480;
        private static final int MINIMUM_OUTPUT_BUFFER_INITIAL_SIZE = 4;
        private final Deflater compressor;
        /* access modifiers changed from: private */
        public long compressorInBytes;
        /* access modifiers changed from: private */
        public long compressorOutBytes;
        private final Inflater decompressor;
        /* access modifiers changed from: private */
        public long decompressorInBytes;
        /* access modifiers changed from: private */
        public long decompressorOutBytes;
        /* access modifiers changed from: private */
        public int maxBytesWrittenAfterFullFlush;
        /* access modifiers changed from: private */
        public int maxInputOutput;
        /* access modifiers changed from: private */
        public int maxOutputOutput;
        private ByteBuffer outputBuffer;

        static {
            Class<ZlibXmppCompressionFactory> cls = ZlibXmppCompressionFactory.class;
        }

        private int deflate(int i10) {
            int i11 = 0;
            while (true) {
                int position = this.outputBuffer.position();
                int deflate = this.compressor.deflate(this.outputBuffer.array(), position, this.outputBuffer.limit() - position, i10);
                this.outputBuffer.position(position + deflate);
                i11 += deflate;
                if (this.compressor.needsInput() && this.outputBuffer.hasRemaining()) {
                    return i11;
                }
                int capacity = this.outputBuffer.capacity() * 2;
                if (capacity < 480) {
                    capacity = 480;
                }
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                this.outputBuffer.flip();
                allocate.put(this.outputBuffer);
                this.outputBuffer = allocate;
            }
        }

        public String getFilterName() {
            return "Compression (zlib)";
        }

        public ByteBuffer input(ByteBuffer byteBuffer) throws IOException {
            int i10;
            byte[] bArr;
            int inflate;
            int remaining = byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                byte[] array2 = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset();
                byte[] bArr2 = array2;
                remaining = byteBuffer.remaining();
                i10 = arrayOffset;
                bArr = bArr2;
            } else {
                bArr = new byte[remaining];
                byteBuffer.get(bArr);
                i10 = 0;
            }
            this.decompressorInBytes += (long) remaining;
            this.decompressor.setInput(bArr, i10, remaining);
            ByteBuffer allocate = ByteBuffer.allocate(remaining * 2);
            while (true) {
                byte[] array3 = allocate.array();
                int position = allocate.position();
                try {
                    inflate = this.decompressor.inflate(array3, position, allocate.limit() - position);
                    allocate.position(position + inflate);
                    this.decompressorOutBytes += (long) inflate;
                    if (this.decompressor.needsInput()) {
                        break;
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(allocate.capacity() * 2);
                    allocate.flip();
                    allocate2.put(allocate);
                    allocate = allocate2;
                } catch (DataFormatException e10) {
                    throw new IOException(e10);
                }
            }
            if (inflate == 0) {
                return null;
            }
            this.maxInputOutput = Math.max(allocate.position(), this.maxInputOutput);
            return allocate;
        }

        public XmppInputOutputFilter.OutputResult output(ByteBuffer byteBuffer, boolean z10, boolean z11, boolean z12) throws IOException {
            byte[] bArr;
            int i10;
            int i11;
            if (z11 && XMPPInputOutputStream.getFlushMethod() == XMPPInputOutputStream.FlushMethod.FULL_FLUSH) {
                this.outputBuffer = ByteBuffer.allocate(256);
                int deflate = deflate(3);
                this.maxBytesWrittenAfterFullFlush = Math.max(deflate, this.maxBytesWrittenAfterFullFlush);
                this.compressorOutBytes += (long) deflate;
            }
            if (byteBuffer == null && this.outputBuffer == null) {
                return XmppInputOutputFilter.OutputResult.NO_OUTPUT;
            }
            int remaining = byteBuffer.remaining();
            if (this.outputBuffer == null) {
                if (remaining < 4) {
                    remaining = 4;
                }
                this.outputBuffer = ByteBuffer.allocate(remaining);
            }
            int i12 = 0;
            if (byteBuffer.hasArray()) {
                bArr = byteBuffer.array();
                i11 = byteBuffer.arrayOffset();
                i10 = byteBuffer.remaining();
            } else {
                int remaining2 = byteBuffer.remaining();
                byte[] bArr2 = new byte[remaining2];
                byteBuffer.get(bArr2);
                i10 = remaining2;
                bArr = bArr2;
                i11 = 0;
            }
            this.compressorInBytes += (long) i10;
            this.compressor.setInput(bArr, i11, i10);
            if (!z12) {
                i12 = 2;
            }
            int deflate2 = deflate(i12);
            this.maxOutputOutput = Math.max(this.outputBuffer.position(), this.maxOutputOutput);
            this.compressorOutBytes += (long) deflate2;
            XmppInputOutputFilter.OutputResult outputResult = new XmppInputOutputFilter.OutputResult(this.outputBuffer);
            this.outputBuffer = null;
            return outputResult;
        }

        private ZlibXmppInputOutputFilter() {
            this(-1);
        }

        public Stats getStats() {
            return new Stats(this);
        }

        private ZlibXmppInputOutputFilter(int i10) {
            this.decompressor = new Inflater();
            this.maxOutputOutput = -1;
            this.maxInputOutput = -1;
            this.maxBytesWrittenAfterFullFlush = -1;
            this.compressor = new Deflater(i10);
        }
    }

    private ZlibXmppCompressionFactory() {
        super("zlib", 100);
    }

    public XmppInputOutputFilter fabricate(ConnectionConfiguration connectionConfiguration) {
        return new ZlibXmppInputOutputFilter();
    }
}
