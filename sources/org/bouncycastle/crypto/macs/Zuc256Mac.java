package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;
import org.bouncycastle.crypto.engines.Zuc256CoreEngine;

public final class Zuc256Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc256Engine theEngine;
    private final int[] theKeyStream;
    private final int[] theMac;
    private final int theMacLength;
    private Zuc256CoreEngine theState;
    private int theWordIndex;

    private static class InternalZuc256Engine extends Zuc256CoreEngine {
        public InternalZuc256Engine(int i10) {
            super(i10);
        }

        /* access modifiers changed from: package-private */
        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    public Zuc256Mac(int i10) {
        this.theEngine = new InternalZuc256Engine(i10);
        this.theMacLength = i10;
        int i11 = i10 / 32;
        this.theMac = new int[i11];
        this.theKeyStream = new int[(i11 + 1)];
    }

    private int getKeyStreamWord(int i10, int i11) {
        int[] iArr = this.theKeyStream;
        int i12 = this.theWordIndex;
        int i13 = iArr[(i12 + i10) % iArr.length];
        if (i11 == 0) {
            return i13;
        }
        int i14 = iArr[((i12 + i10) + 1) % iArr.length];
        return (i14 >>> (32 - i11)) | (i13 << i11);
    }

    private void initKeyStream() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i11 >= iArr.length) {
                break;
            }
            iArr[i11] = this.theEngine.createKeyStreamWord();
            i11++;
        }
        while (true) {
            int[] iArr2 = this.theKeyStream;
            if (i10 < iArr2.length - 1) {
                iArr2[i10] = this.theEngine.createKeyStreamWord();
                i10++;
            } else {
                this.theWordIndex = iArr2.length - 1;
                this.theByteIndex = 3;
                return;
            }
        }
    }

    private void shift4Final() {
        int i10 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i10;
        if (i10 == 0) {
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void shift4NextByte() {
        int i10 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i10;
        if (i10 == 0) {
            this.theKeyStream[this.theWordIndex] = this.theEngine.createKeyStreamWord();
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void updateMac(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i11 < iArr.length) {
                iArr[i11] = iArr[i11] ^ getKeyStreamWord(i11, i10);
                i11++;
            } else {
                return;
            }
        }
    }

    public int doFinal(byte[] bArr, int i10) {
        shift4Final();
        updateMac(this.theByteIndex * 8);
        int i11 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i11 < iArr.length) {
                Zuc128CoreEngine.encode32be(iArr[i11], bArr, (i11 * 4) + i10);
                i11++;
            } else {
                reset();
                return getMacSize();
            }
        }
    }

    public String getAlgorithmName() {
        return "Zuc256Mac-" + this.theMacLength;
    }

    public int getMacSize() {
        return this.theMacLength / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.theEngine.init(true, cipherParameters);
        this.theState = (Zuc256CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    public void reset() {
        Zuc256CoreEngine zuc256CoreEngine = this.theState;
        if (zuc256CoreEngine != null) {
            this.theEngine.reset(zuc256CoreEngine);
        }
        initKeyStream();
    }

    public void update(byte b10) {
        shift4NextByte();
        int i10 = this.theByteIndex * 8;
        int i11 = 128;
        int i12 = 0;
        while (i11 > 0) {
            if ((b10 & i11) != 0) {
                updateMac(i10 + i12);
            }
            i11 >>= 1;
            i12++;
        }
    }

    public void update(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            update(bArr[i10 + i12]);
        }
    }
}
