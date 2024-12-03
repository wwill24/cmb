package com.facebook.stetho.websocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class Frame {
    public static final byte OPCODE_BINARY_FRAME = 2;
    public static final byte OPCODE_CONNECTION_CLOSE = 8;
    public static final byte OPCODE_CONNECTION_PING = 9;
    public static final byte OPCODE_CONNECTION_PONG = 10;
    public static final byte OPCODE_TEXT_FRAME = 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    Frame() {
    }

    private void decodeFirstByte(byte b10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if ((b10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.fin = z10;
        if ((b10 & 64) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.rsv1 = z11;
        if ((b10 & 32) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.rsv2 = z12;
        if ((b10 & Tnaf.POW_2_WIDTH) == 0) {
            z13 = false;
        }
        this.rsv3 = z13;
        this.opcode = (byte) (b10 & 15);
    }

    private long decodeLength(byte b10, InputStream inputStream) throws IOException {
        if (b10 <= 125) {
            return (long) b10;
        }
        if (b10 == 126) {
            return (long) (((readByteOrThrow(inputStream) & 255) << 8) | (readByteOrThrow(inputStream) & 255));
        }
        if (b10 == Byte.MAX_VALUE) {
            long j10 = 0;
            for (int i10 = 0; i10 < 8; i10++) {
                j10 = (j10 << 8) | ((long) (readByteOrThrow(inputStream) & 255));
            }
            return j10;
        }
        throw new IOException("Unexpected length byte: " + b10);
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, 4);
        return bArr;
    }

    private byte encodeFirstByte() {
        byte b10;
        if (this.fin) {
            b10 = (byte) 128;
        } else {
            b10 = 0;
        }
        if (this.rsv1) {
            b10 = (byte) (b10 | 64);
        }
        if (this.rsv2) {
            b10 = (byte) (b10 | 32);
        }
        if (this.rsv3) {
            b10 = (byte) (b10 | Tnaf.POW_2_WIDTH);
        }
        return (byte) (b10 | (this.opcode & 15));
    }

    private static byte[] encodeLength(long j10) {
        if (j10 <= 125) {
            return new byte[]{(byte) ((int) j10)};
        } else if (j10 <= 65535) {
            return new byte[]{126, (byte) ((int) ((j10 >> 8) & 255)), (byte) ((int) (j10 & 255))};
        } else {
            return new byte[]{Byte.MAX_VALUE, (byte) ((int) ((j10 >> 56) & 255)), (byte) ((int) ((j10 >> 48) & 255)), (byte) ((int) ((j10 >> 40) & 255)), (byte) ((int) ((j10 >> 32) & 255)), (byte) ((int) ((j10 >> 24) & 255)), (byte) ((int) ((j10 >> 16) & 255)), (byte) ((int) ((j10 >> 8) & 255)), (byte) ((int) (j10 & 255))};
        }
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new EOFException();
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        while (i11 > 0) {
            int read = inputStream.read(bArr, i10, i11);
            if (read != -1) {
                i11 -= read;
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z10;
        byte[] bArr;
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte readByteOrThrow = readByteOrThrow(bufferedInputStream);
        if ((readByteOrThrow & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.hasMask = z10;
        this.payloadLen = decodeLength((byte) (readByteOrThrow & -129), bufferedInputStream);
        if (this.hasMask) {
            bArr = decodeMaskingKey(bufferedInputStream);
        } else {
            bArr = null;
        }
        this.maskingKey = bArr;
        long j10 = this.payloadLen;
        byte[] bArr2 = new byte[((int) j10)];
        this.payloadData = bArr2;
        readBytesOrThrow(bufferedInputStream, bArr2, 0, (int) j10);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] encodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            encodeLength[0] = (byte) (encodeLength[0] | 128);
        }
        bufferedOutputStream.write(encodeLength, 0, encodeLength.length);
        if (!this.hasMask) {
            bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
            return;
        }
        throw new UnsupportedOperationException("Writing masked data not implemented");
    }
}
