package com.appsflyer.internal;

import com.google.android.gms.common.api.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFf1hSDK extends FilterInputStream {
    private long[] AFInAppEventParameterName;
    private byte[] AFInAppEventType;
    private long[] AFKeystoreWrapper;
    private int AFLogger = a.e.API_PRIORITY_OTHER;
    private int afDebugLog;
    private int afErrorLog;
    private short valueOf;
    private final int values;

    public AFf1hSDK(InputStream inputStream, int i10, int i11, short s10, int i12, int i13) throws IOException {
        super(inputStream);
        int min = Math.min(Math.max(s10, 4), 8);
        this.values = min;
        this.AFInAppEventType = new byte[min];
        this.AFInAppEventParameterName = new long[4];
        this.AFKeystoreWrapper = new long[4];
        this.afErrorLog = min;
        this.afDebugLog = min;
        this.AFInAppEventParameterName = AFf1gSDK.AFKeystoreWrapper(i10 ^ i13, min ^ i13);
        this.AFKeystoreWrapper = AFf1gSDK.AFKeystoreWrapper(i11 ^ i13, i12 ^ i13);
    }

    private int AFInAppEventType() throws IOException {
        int read;
        int i10;
        if (this.AFLogger == Integer.MAX_VALUE) {
            this.AFLogger = this.in.read();
        }
        if (this.afErrorLog == this.values) {
            byte[] bArr = this.AFInAppEventType;
            int i11 = this.AFLogger;
            bArr[0] = (byte) i11;
            if (i11 >= 0) {
                int i12 = 1;
                do {
                    read = this.in.read(this.AFInAppEventType, i12, this.values - i12);
                    if (read <= 0 || (i12 = i12 + read) >= this.values) {
                    }
                    read = this.in.read(this.AFInAppEventType, i12, this.values - i12);
                    break;
                } while ((i12 = i12 + read) >= this.values);
                if (i12 >= this.values) {
                    AFKeystoreWrapper();
                    int read2 = this.in.read();
                    this.AFLogger = read2;
                    this.afErrorLog = 0;
                    if (read2 < 0) {
                        int i13 = this.values;
                        i10 = i13 - (this.AFInAppEventType[i13 - 1] & 255);
                    } else {
                        i10 = this.values;
                    }
                    this.afDebugLog = i10;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.afDebugLog;
    }

    private void AFKeystoreWrapper() {
        long[] jArr = this.AFInAppEventParameterName;
        long[] jArr2 = this.AFKeystoreWrapper;
        short s10 = this.valueOf;
        long j10 = jArr2[(s10 + 2) % 4];
        int i10 = (s10 + 3) % 4;
        jArr2[i10] = ((jArr[i10] * 2147483085) + j10) / 2147483647L;
        jArr[i10] = ((jArr[s10 % 4] * 2147483085) + j10) % 2147483647L;
        for (int i11 = 0; i11 < this.values; i11++) {
            byte[] bArr = this.AFInAppEventType;
            bArr[i11] = (byte) ((int) (((long) bArr[i11]) ^ ((this.AFInAppEventParameterName[this.valueOf] >> (i11 << 3)) & 255)));
        }
        this.valueOf = (short) ((this.valueOf + 1) % 4);
    }

    public final int available() throws IOException {
        AFInAppEventType();
        return this.afDebugLog - this.afErrorLog;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFInAppEventType();
        int i10 = this.afErrorLog;
        if (i10 >= this.afDebugLog) {
            return -1;
        }
        byte[] bArr = this.AFInAppEventType;
        this.afErrorLog = i10 + 1;
        return bArr[i10] & 255;
    }

    public final long skip(long j10) throws IOException {
        long j11 = 0;
        while (j11 < j10 && read() != -1) {
            j11++;
        }
        return j11;
    }

    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = i10 + i11;
        int i13 = i10;
        while (i13 < i12) {
            AFInAppEventType();
            int i14 = this.afErrorLog;
            if (i14 < this.afDebugLog) {
                byte[] bArr2 = this.AFInAppEventType;
                this.afErrorLog = i14 + 1;
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
