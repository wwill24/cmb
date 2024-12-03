package com.leanplum.internal;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

class HybiParser {
    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final List<Integer> FRAGMENTED_OPCODES = Arrays.asList(new Integer[]{0, 1, 2});
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final List<Integer> OPCODES = Arrays.asList(new Integer[]{0, 1, 2, 8, 9, 10});
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
    private WebSocketClient mClient;
    private boolean mClosed = false;
    private boolean mFinal;
    private int mLength;
    private int mLengthSize;
    private byte[] mMask = new byte[0];
    private boolean mMasked;
    private boolean mMasking = true;
    private int mMode;
    private int mOpcode;
    private byte[] mPayload = new byte[0];
    private int mStage;

    static class HappyDataInputStream extends DataInputStream {
        public HappyDataInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public byte[] readBytes(int i10) throws IOException {
            byte[] bArr = new byte[i10];
            int i11 = 0;
            while (i11 < i10) {
                int read = read(bArr, i11, i10 - i11);
                if (read == -1) {
                    break;
                }
                i11 += read;
            }
            if (i11 == i10) {
                return bArr;
            }
            throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", new Object[]{Integer.valueOf(i11), Integer.valueOf(i10)}));
        }
    }

    static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    public HybiParser(WebSocketClient webSocketClient) {
        this.mClient = webSocketClient;
    }

    private static long byteArrayToLong(byte[] bArr, int i10, int i11) {
        if (bArr.length >= i11) {
            long j10 = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                j10 += (long) ((bArr[i12 + i10] & 255) << (((i11 - 1) - i12) * 8));
            }
            return j10;
        }
        throw new IllegalArgumentException("length must be less than or equal to b.length");
    }

    private static byte[] copyOfRange(byte[] bArr, int i10, int i11) {
        if (i10 <= i11) {
            int length = bArr.length;
            if (i10 < 0 || i10 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = i11 - i10;
            int min = Math.min(i12, length - i10);
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i10, bArr2, 0, min);
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    private byte[] decode(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    private void emitFrame() throws IOException {
        String str;
        int i10 = 0;
        byte[] mask = mask(this.mPayload, this.mMask, 0);
        int i11 = this.mOpcode;
        if (i11 == 0) {
            if (this.mMode != 0) {
                this.mBuffer.write(mask);
                if (this.mFinal) {
                    byte[] byteArray = this.mBuffer.toByteArray();
                    if (this.mMode == 1) {
                        this.mClient.getListener().onMessage(encode(byteArray));
                    } else {
                        this.mClient.getListener().onMessage(byteArray);
                    }
                    reset();
                    return;
                }
                return;
            }
            throw new ProtocolError("Mode was not set.");
        } else if (i11 == 1) {
            if (this.mFinal) {
                this.mClient.getListener().onMessage(encode(mask));
                return;
            }
            this.mMode = 1;
            this.mBuffer.write(mask);
        } else if (i11 == 2) {
            if (this.mFinal) {
                this.mClient.getListener().onMessage(mask);
                return;
            }
            this.mMode = 2;
            this.mBuffer.write(mask);
        } else if (i11 == 8) {
            if (mask.length >= 2) {
                i10 = mask[1] + (mask[0] * 256);
            }
            if (mask.length > 2) {
                str = encode(slice(mask, 2));
            } else {
                str = null;
            }
            this.mClient.getListener().onDisconnect(i10, str);
        } else if (i11 != 9) {
        } else {
            if (mask.length <= 125) {
                this.mClient.sendFrame(frame(mask, 10, -1));
                return;
            }
            throw new ProtocolError("Ping payload too large");
        }
    }

    private String encode(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    private int getInteger(byte[] bArr) throws ProtocolError {
        long byteArrayToLong = byteArrayToLong(bArr, 0, bArr.length);
        if (byteArrayToLong >= 0 && byteArrayToLong <= 2147483647L) {
            return (int) byteArrayToLong;
        }
        throw new ProtocolError("Bad integer: " + byteArrayToLong);
    }

    private static byte[] mask(byte[] bArr, byte[] bArr2, int i10) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i11 = 0; i11 < bArr.length - i10; i11++) {
            int i12 = i10 + i11;
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i11 % 4]);
        }
        return bArr;
    }

    private void parseExtendedLength(byte[] bArr) throws ProtocolError {
        int i10;
        this.mLength = getInteger(bArr);
        if (this.mMasked) {
            i10 = 3;
        } else {
            i10 = 4;
        }
        this.mStage = i10;
    }

    private void parseLength(byte b10) {
        boolean z10;
        int i10;
        int i11;
        if ((b10 & 128) == 128) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mMasked = z10;
        byte b11 = b10 & Byte.MAX_VALUE;
        this.mLength = b11;
        if (b11 < 0 || b11 > 125) {
            if (b11 == 126) {
                i10 = 2;
            } else {
                i10 = 8;
            }
            this.mLengthSize = i10;
            this.mStage = 2;
            return;
        }
        if (z10) {
            i11 = 3;
        } else {
            i11 = 4;
        }
        this.mStage = i11;
    }

    private void parseOpcode(byte b10) throws ProtocolError {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if ((b10 & 64) == 64) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((b10 & 32) == 32) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((b10 & Tnaf.POW_2_WIDTH) == 16) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10 || z11 || z12) {
            throw new ProtocolError("RSV not zero");
        }
        if ((b10 & 128) == 128) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.mFinal = z13;
        byte b11 = b10 & 15;
        this.mOpcode = b11;
        this.mMask = new byte[0];
        this.mPayload = new byte[0];
        if (!OPCODES.contains(Integer.valueOf(b11))) {
            throw new ProtocolError("Bad opcode");
        } else if (FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) || this.mFinal) {
            this.mStage = 1;
        } else {
            throw new ProtocolError("Expected non-final packet");
        }
    }

    private void reset() {
        this.mMode = 0;
        this.mBuffer.reset();
    }

    private byte[] slice(byte[] bArr, int i10) {
        return copyOfRange(bArr, i10, bArr.length);
    }

    public void close(int i10, String str) {
        if (!this.mClosed) {
            this.mClient.send(frame(str, 8, i10));
            this.mClosed = true;
        }
    }

    public byte[] frame(String str) {
        return frame(str, 1, -1);
    }

    public void ping(String str) {
        this.mClient.send(frame(str, 9, -1));
    }

    public void start(HappyDataInputStream happyDataInputStream) throws IOException {
        while (happyDataInputStream.available() != -1) {
            int i10 = this.mStage;
            if (i10 == 0) {
                parseOpcode(happyDataInputStream.readByte());
            } else if (i10 == 1) {
                parseLength(happyDataInputStream.readByte());
            } else if (i10 == 2) {
                parseExtendedLength(happyDataInputStream.readBytes(this.mLengthSize));
            } else if (i10 == 3) {
                this.mMask = happyDataInputStream.readBytes(4);
                this.mStage = 4;
            } else if (i10 == 4) {
                this.mPayload = happyDataInputStream.readBytes(this.mLength);
                emitFrame();
                this.mStage = 0;
            }
        }
        this.mClient.getListener().onDisconnect(0, "EOF");
    }

    public byte[] frame(byte[] bArr) {
        return frame(bArr, 2, -1);
    }

    private byte[] frame(byte[] bArr, int i10, int i11) {
        return frame((Object) bArr, i10, i11);
    }

    private byte[] frame(String str, int i10, int i11) {
        return frame((Object) str, i10, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] frame(java.lang.Object r19, int r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            boolean r3 = r0.mClosed
            if (r3 == 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0017
            java.lang.String r1 = (java.lang.String) r1
            byte[] r1 = r0.decode(r1)
            goto L_0x0019
        L_0x0017:
            byte[] r1 = (byte[]) r1
        L_0x0019:
            r3 = 2
            r4 = 0
            if (r2 <= 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r4
        L_0x0020:
            int r6 = r1.length
            int r6 = r6 + r5
            r7 = 65535(0xffff, float:9.1834E-41)
            r8 = 125(0x7d, float:1.75E-43)
            if (r6 > r8) goto L_0x002b
            r10 = r3
            goto L_0x0031
        L_0x002b:
            if (r6 > r7) goto L_0x002f
            r10 = 4
            goto L_0x0031
        L_0x002f:
            r10 = 10
        L_0x0031:
            boolean r11 = r0.mMasking
            if (r11 == 0) goto L_0x0037
            r12 = 4
            goto L_0x0038
        L_0x0037:
            r12 = r4
        L_0x0038:
            int r12 = r12 + r10
            if (r11 == 0) goto L_0x003e
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x003f
        L_0x003e:
            r11 = r4
        L_0x003f:
            int r13 = r6 + r12
            byte[] r13 = new byte[r13]
            r14 = r20
            byte r14 = (byte) r14
            r14 = r14 | -128(0xffffffffffffff80, float:NaN)
            byte r14 = (byte) r14
            r13[r4] = r14
            r14 = 1132462080(0x43800000, float:256.0)
            r15 = 3
            r16 = 1
            if (r6 > r8) goto L_0x005b
            r6 = r6 | r11
            byte r6 = (byte) r6
            r13[r16] = r6
        L_0x0056:
            r11 = r5
            r17 = r10
            goto L_0x0108
        L_0x005b:
            if (r6 > r7) goto L_0x0073
            r7 = r11 | 126(0x7e, float:1.77E-43)
            byte r7 = (byte) r7
            r13[r16] = r7
            float r7 = (float) r6
            float r7 = r7 / r14
            double r7 = (double) r7
            double r7 = java.lang.Math.floor(r7)
            int r7 = (int) r7
            byte r7 = (byte) r7
            r13[r3] = r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r13[r15] = r6
            goto L_0x0056
        L_0x0073:
            r7 = r11 | 127(0x7f, float:1.78E-43)
            byte r7 = (byte) r7
            r13[r16] = r7
            double r7 = (double) r6
            r11 = r5
            r4 = 4633078116657397760(0x404c000000000000, double:56.0)
            r17 = r10
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r3] = r4
            r4 = 4631952216750555136(0x4048000000000000, double:48.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r15] = r4
            r4 = 4630826316843712512(0x4044000000000000, double:40.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 4
            r13[r5] = r4
            r4 = 5
            r14 = 4629700416936869888(0x4040000000000000, double:32.0)
            double r14 = java.lang.Math.pow(r9, r14)
            double r14 = r7 / r14
            double r14 = java.lang.Math.floor(r14)
            int r14 = (int) r14
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r14 = (byte) r14
            r13[r4] = r14
            r4 = 6
            r14 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r14 = java.lang.Math.pow(r9, r14)
            double r14 = r7 / r14
            double r14 = java.lang.Math.floor(r14)
            int r14 = (int) r14
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r14 = (byte) r14
            r13[r4] = r14
            r4 = 7
            r14 = 4625196817309499392(0x4030000000000000, double:16.0)
            double r14 = java.lang.Math.pow(r9, r14)
            double r14 = r7 / r14
            double r14 = java.lang.Math.floor(r14)
            int r14 = (int) r14
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r14 = (byte) r14
            r13[r4] = r14
            r4 = 8
            r14 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r9 = java.lang.Math.pow(r9, r14)
            double r7 = r7 / r9
            double r7 = java.lang.Math.floor(r7)
            int r7 = (int) r7
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r13[r4] = r7
            r4 = 9
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r13[r4] = r6
        L_0x0108:
            if (r2 <= 0) goto L_0x0120
            float r4 = (float) r2
            r6 = 1132462080(0x43800000, float:256.0)
            float r4 = r4 / r6
            double r6 = (double) r4
            double r6 = java.lang.Math.floor(r6)
            int r4 = (int) r6
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r12] = r4
            int r4 = r12 + 1
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r13[r4] = r2
        L_0x0120:
            int r2 = r12 + r11
            int r4 = r1.length
            r6 = 0
            java.lang.System.arraycopy(r1, r6, r13, r2, r4)
            boolean r1 = r0.mMasking
            if (r1 == 0) goto L_0x016f
            r1 = 4
            byte[] r2 = new byte[r1]
            double r7 = java.lang.Math.random()
            r9 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r7 = r7 * r9
            double r7 = java.lang.Math.floor(r7)
            int r1 = (int) r7
            byte r1 = (byte) r1
            r2[r6] = r1
            double r6 = java.lang.Math.random()
            double r6 = r6 * r9
            double r6 = java.lang.Math.floor(r6)
            int r1 = (int) r6
            byte r1 = (byte) r1
            r2[r16] = r1
            double r6 = java.lang.Math.random()
            double r6 = r6 * r9
            double r6 = java.lang.Math.floor(r6)
            int r1 = (int) r6
            byte r1 = (byte) r1
            r2[r3] = r1
            double r3 = java.lang.Math.random()
            double r3 = r3 * r9
            double r3 = java.lang.Math.floor(r3)
            int r1 = (int) r3
            byte r1 = (byte) r1
            r3 = 3
            r2[r3] = r1
            r3 = r17
            r1 = 4
            r4 = 0
            java.lang.System.arraycopy(r2, r4, r13, r3, r1)
            mask(r13, r2, r12)
        L_0x016f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.HybiParser.frame(java.lang.Object, int, int):byte[]");
    }
}
