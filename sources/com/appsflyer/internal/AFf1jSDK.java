package com.appsflyer.internal;

import com.google.android.gms.common.api.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFf1jSDK extends FilterInputStream {
    private static final int[] AFInAppEventParameterName = AFf1kSDK.AFInAppEventParameterName;
    private static final byte[] AFInAppEventType = AFf1kSDK.values;
    private static final int[] AFKeystoreWrapper = AFf1kSDK.valueOf;
    private static final int[] valueOf = AFf1kSDK.AFInAppEventType;
    private static final int[] values = AFf1kSDK.AFKeystoreWrapper;
    private final int[] AFLogger = new int[4];
    private int AFLogger$LogLevel = 16;
    private final byte[] afDebugLog = new byte[16];
    private final byte[][] afErrorLog;
    private final byte[] afErrorLogForExcManagerOnly = new byte[16];
    private final int[] afInfoLog;
    private final int afRDLog;
    private int afWarnLog = a.e.API_PRIORITY_OTHER;
    private int getLevel = 16;

    public AFf1jSDK(InputStream inputStream, int i10, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.afRDLog = i10;
        this.afInfoLog = AFf1kSDK.values(bArr, i10);
        this.afErrorLog = AFInAppEventParameterName(bArr2);
    }

    private static byte[][] AFInAppEventParameterName(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = new byte[bArr[i10].length];
            int i11 = 0;
            while (true) {
                byte[] bArr3 = bArr[i10];
                if (i11 >= bArr3.length) {
                    break;
                }
                bArr2[i10][bArr3[i11]] = (byte) i11;
                i11++;
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFInAppEventType() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.afWarnLog
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afWarnLog = r0
        L_0x000f:
            int r0 = r7.AFLogger$LogLevel
            r1 = 16
            if (r0 != r1) goto L_0x005e
            byte[] r0 = r7.afDebugLog
            int r2 = r7.afWarnLog
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0058
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.afDebugLog
            int r6 = 16 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x0052
            byte[] r0 = r7.afDebugLog
            byte[] r2 = r7.afErrorLogForExcManagerOnly
            r7.AFKeystoreWrapper(r0, r2)
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afWarnLog = r0
            r7.AFLogger$LogLevel = r4
            if (r0 >= 0) goto L_0x004f
            byte[] r0 = r7.afErrorLogForExcManagerOnly
            r2 = 15
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004f:
            r7.getLevel = r1
            goto L_0x005e
        L_0x0052:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0058:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x005e:
            int r0 = r7.getLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1jSDK.AFInAppEventType():int");
    }

    private void AFKeystoreWrapper(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.AFLogger;
        char c10 = 1;
        byte b10 = (bArr[0] << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.afInfoLog;
        iArr[0] = b10 ^ iArr2[0];
        iArr[1] = ((((bArr[4] << 24) | ((bArr[5] & 255) << Tnaf.POW_2_WIDTH)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << 24) | ((bArr[9] & 255) << Tnaf.POW_2_WIDTH)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr2[2];
        iArr[3] = iArr2[3] ^ (((((bArr[13] & 255) << Tnaf.POW_2_WIDTH) | (bArr[12] << 24)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i10 = 4;
        int i11 = 1;
        while (i11 < this.afRDLog) {
            int[] iArr3 = valueOf;
            int[] iArr4 = this.AFLogger;
            byte[][] bArr3 = this.afErrorLog;
            byte[] bArr4 = bArr3[0];
            int i12 = iArr3[iArr4[bArr4[0]] >>> 24];
            int[] iArr5 = AFInAppEventParameterName;
            byte[] bArr5 = bArr3[c10];
            int i13 = i12 ^ iArr5[(iArr4[bArr5[0]] >>> 16) & 255];
            int[] iArr6 = values;
            byte[] bArr6 = bArr3[2];
            int i14 = iArr6[(iArr4[bArr6[0]] >>> 8) & 255] ^ i13;
            int[] iArr7 = AFKeystoreWrapper;
            byte[] bArr7 = bArr3[3];
            int i15 = iArr7[iArr4[bArr7[0]] & 255] ^ i14;
            int[] iArr8 = this.afInfoLog;
            int i16 = i15 ^ iArr8[i10];
            int i17 = ((iArr6[(iArr4[bArr6[c10]] >>> 8) & 255] ^ (iArr3[iArr4[bArr4[c10]] >>> 24] ^ iArr5[(iArr4[bArr5[c10]] >>> 16) & 255])) ^ iArr7[iArr4[bArr7[c10]] & 255]) ^ iArr8[i10 + 1];
            int i18 = (((iArr5[(iArr4[bArr5[2]] >>> 16) & 255] ^ iArr3[iArr4[bArr4[2]] >>> 24]) ^ iArr6[(iArr4[bArr6[2]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[2]] & 255]) ^ iArr8[i10 + 2];
            iArr4[0] = i16;
            iArr4[1] = i17;
            iArr4[2] = i18;
            iArr4[3] = (((iArr3[iArr4[bArr4[3]] >>> 24] ^ iArr5[(iArr4[bArr5[3]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[3]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[3]] & 255]) ^ iArr8[i10 + 3];
            i11++;
            i10 += 4;
            c10 = 1;
        }
        int[] iArr9 = this.afInfoLog;
        int i19 = iArr9[i10];
        byte[] bArr8 = AFInAppEventType;
        int[] iArr10 = this.AFLogger;
        byte[][] bArr9 = this.afErrorLog;
        byte[] bArr10 = bArr9[0];
        bArr2[0] = (byte) (bArr8[iArr10[bArr10[0]] >>> 24] ^ (i19 >>> 24));
        byte[] bArr11 = bArr9[1];
        bArr2[1] = (byte) (bArr8[(iArr10[bArr11[0]] >>> 16) & 255] ^ (i19 >>> 16));
        byte[] bArr12 = bArr9[2];
        bArr2[2] = (byte) (bArr8[(iArr10[bArr12[0]] >>> 8) & 255] ^ (i19 >>> 8));
        byte[] bArr13 = bArr9[3];
        bArr2[3] = (byte) (bArr8[iArr10[bArr13[0]] & 255] ^ i19);
        int i20 = iArr9[i10 + 1];
        bArr2[4] = (byte) (bArr8[iArr10[bArr10[1]] >>> 24] ^ (i20 >>> 24));
        bArr2[5] = (byte) (bArr8[(iArr10[bArr11[1]] >>> 16) & 255] ^ (i20 >>> 16));
        bArr2[6] = (byte) (bArr8[(iArr10[bArr12[1]] >>> 8) & 255] ^ (i20 >>> 8));
        bArr2[7] = (byte) (i20 ^ bArr8[iArr10[bArr13[1]] & 255]);
        int i21 = iArr9[i10 + 2];
        bArr2[8] = (byte) (bArr8[iArr10[bArr10[2]] >>> 24] ^ (i21 >>> 24));
        bArr2[9] = (byte) (bArr8[(iArr10[bArr11[2]] >>> 16) & 255] ^ (i21 >>> 16));
        bArr2[10] = (byte) (bArr8[(iArr10[bArr12[2]] >>> 8) & 255] ^ (i21 >>> 8));
        bArr2[11] = (byte) (i21 ^ bArr8[iArr10[bArr13[2]] & 255]);
        int i22 = iArr9[i10 + 3];
        bArr2[12] = (byte) (bArr8[iArr10[bArr10[3]] >>> 24] ^ (i22 >>> 24));
        bArr2[13] = (byte) (bArr8[(iArr10[bArr11[3]] >>> 16) & 255] ^ (i22 >>> 16));
        bArr2[14] = (byte) (bArr8[(iArr10[bArr12[3]] >>> 8) & 255] ^ (i22 >>> 8));
        bArr2[15] = (byte) (i22 ^ bArr8[iArr10[bArr13[3]] & 255]);
    }

    public final int available() throws IOException {
        AFInAppEventType();
        return this.getLevel - this.AFLogger$LogLevel;
    }

    public final void close() throws IOException {
        super.close();
    }

    public final synchronized void mark(int i10) {
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFInAppEventType();
        int i10 = this.AFLogger$LogLevel;
        if (i10 >= this.getLevel) {
            return -1;
        }
        byte[] bArr = this.afErrorLogForExcManagerOnly;
        this.AFLogger$LogLevel = i10 + 1;
        return bArr[i10] & 255;
    }

    public final synchronized void reset() throws IOException {
    }

    public final long skip(long j10) throws IOException {
        long j11 = 0;
        while (j11 < j10 && read() != -1) {
            j11++;
        }
        return j11;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = i10 + i11;
        int i13 = i10;
        while (i13 < i12) {
            AFInAppEventType();
            int i14 = this.AFLogger$LogLevel;
            if (i14 < this.getLevel) {
                byte[] bArr2 = this.afErrorLogForExcManagerOnly;
                this.AFLogger$LogLevel = i14 + 1;
                bArr[i13] = bArr2[i14];
                i13++;
            } else if (i13 == i10) {
                return -1;
            } else {
                return i11 - (i12 - i13);
            }
        }
        return i11;
    }
}
