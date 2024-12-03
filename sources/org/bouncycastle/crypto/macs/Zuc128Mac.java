package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;

public final class Zuc128Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc128Engine theEngine = new InternalZuc128Engine();
    private final int[] theKeyStream = new int[2];
    private int theMac;
    private Zuc128CoreEngine theState;
    private int theWordIndex;

    private static class InternalZuc128Engine extends Zuc128CoreEngine {
        private InternalZuc128Engine() {
        }

        /* access modifiers changed from: package-private */
        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    private int getFinalWord() {
        if (this.theByteIndex != 0) {
            return this.theEngine.createKeyStreamWord();
        }
        int[] iArr = this.theKeyStream;
        int length = (this.theWordIndex + 1) % iArr.length;
        this.theWordIndex = length;
        return iArr[length];
    }

    private int getKeyStreamWord(int i10) {
        int[] iArr = this.theKeyStream;
        int i11 = this.theWordIndex;
        int i12 = iArr[i11];
        if (i10 == 0) {
            return i12;
        }
        int i13 = iArr[(i11 + 1) % iArr.length];
        return (i13 >>> (32 - i10)) | (i12 << i10);
    }

    private void initKeyStream() {
        int i10 = 0;
        this.theMac = 0;
        while (true) {
            int[] iArr = this.theKeyStream;
            if (i10 < iArr.length - 1) {
                iArr[i10] = this.theEngine.createKeyStreamWord();
                i10++;
            } else {
                this.theWordIndex = iArr.length - 1;
                this.theByteIndex = 3;
                return;
            }
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
        this.theMac = getKeyStreamWord(i10) ^ this.theMac;
    }

    public int doFinal(byte[] bArr, int i10) {
        shift4NextByte();
        int keyStreamWord = this.theMac ^ getKeyStreamWord(this.theByteIndex * 8);
        this.theMac = keyStreamWord;
        int finalWord = keyStreamWord ^ getFinalWord();
        this.theMac = finalWord;
        Zuc128CoreEngine.encode32be(finalWord, bArr, i10);
        reset();
        return getMacSize();
    }

    public String getAlgorithmName() {
        return "Zuc128Mac";
    }

    public int getMacSize() {
        return 4;
    }

    public void init(CipherParameters cipherParameters) {
        this.theEngine.init(true, cipherParameters);
        this.theState = (Zuc128CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    public void reset() {
        Zuc128CoreEngine zuc128CoreEngine = this.theState;
        if (zuc128CoreEngine != null) {
            this.theEngine.reset(zuc128CoreEngine);
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
