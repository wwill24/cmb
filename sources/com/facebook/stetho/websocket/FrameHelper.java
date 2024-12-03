package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

class FrameHelper {
    FrameHelper() {
    }

    public static Frame createBinaryFrame(byte[] bArr) {
        return createSimpleFrame((byte) 2, bArr);
    }

    public static Frame createCloseFrame(int i10, String str) {
        byte[] bArr;
        int i11;
        if (str != null) {
            bArr = Utf8Charset.encodeUTF8(str);
            i11 = bArr.length + 2;
        } else {
            bArr = null;
            i11 = 2;
        }
        byte[] bArr2 = new byte[i11];
        bArr2[0] = (byte) ((i10 >> 8) & 255);
        bArr2[1] = (byte) (i10 & 255);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        }
        return createSimpleFrame((byte) 8, bArr2);
    }

    public static Frame createPingFrame(byte[] bArr, int i10) {
        return createSimpleFrame((byte) 9, bArr, i10);
    }

    public static Frame createPongFrame(byte[] bArr, int i10) {
        return createSimpleFrame((byte) 10, bArr, i10);
    }

    private static Frame createSimpleFrame(byte b10, byte[] bArr) {
        return createSimpleFrame(b10, bArr, bArr.length);
    }

    public static Frame createTextFrame(String str) {
        return createSimpleFrame((byte) 1, Utf8Charset.encodeUTF8(str));
    }

    private static Frame createSimpleFrame(byte b10, byte[] bArr, int i10) {
        Frame frame = new Frame();
        frame.fin = true;
        frame.hasMask = false;
        frame.opcode = b10;
        frame.payloadLen = (long) i10;
        frame.payloadData = bArr;
        return frame;
    }
}
