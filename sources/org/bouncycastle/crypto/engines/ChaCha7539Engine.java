package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;
import org.jivesoftware.smack.datatypes.UInt32;

public class ChaCha7539Engine extends Salsa20Engine {
    /* access modifiers changed from: protected */
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[12] + 1;
        iArr[12] = i10;
        if (i10 == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 <= 0) {
            int[] iArr = this.engineState;
            int i12 = iArr[12];
            int i13 = i11 + i12;
            iArr[12] = i13;
            if (i12 != 0 && i13 < i12) {
                throw new IllegalStateException("attempt to increase counter past 2^32.");
            }
            return;
        }
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    /* access modifiers changed from: protected */
    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.f41435x);
        Pack.intToLittleEndian(this.f41435x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    /* access modifiers changed from: protected */
    public long getCounter() {
        return ((long) this.engineState[12]) & UInt32.MAX_VALUE_LONG;
    }

    /* access modifiers changed from: protected */
    public int getNonceSize() {
        return 12;
    }

    /* access modifiers changed from: protected */
    public void resetCounter() {
        this.engineState[12] = 0;
    }

    /* access modifiers changed from: protected */
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[12];
        if (i10 != 0) {
            iArr[12] = i10 - 1;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    /* access modifiers changed from: protected */
    public void retreatCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 == 0) {
            int[] iArr = this.engineState;
            int i12 = iArr[12];
            if ((((long) i12) & UInt32.MAX_VALUE_LONG) >= (UInt32.MAX_VALUE_LONG & ((long) i11))) {
                iArr[12] = i12 - i11;
                return;
            }
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    /* access modifiers changed from: protected */
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }
}
