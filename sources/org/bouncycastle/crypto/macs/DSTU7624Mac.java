package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class DSTU7624Mac implements Mac {
    private static final int BITS_IN_BYTE = 8;
    private int blockSize;
    private byte[] buf;
    private int bufOff;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f41451c;
    private byte[] cTemp;
    private DSTU7624Engine engine;
    private boolean initCalled = false;
    private byte[] kDelta;
    private int macSize;

    public DSTU7624Mac(int i10, int i11) {
        this.engine = new DSTU7624Engine(i10);
        int i12 = i10 / 8;
        this.blockSize = i12;
        this.macSize = i11 / 8;
        this.f41451c = new byte[i12];
        this.kDelta = new byte[i12];
        this.cTemp = new byte[i12];
        this.buf = new byte[i12];
    }

    private void processBlock(byte[] bArr, int i10) {
        xor(this.f41451c, 0, bArr, i10, this.cTemp);
        this.engine.processBlock(this.cTemp, 0, this.f41451c, 0);
    }

    private void xor(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3) {
        int length = bArr.length - i10;
        int i12 = this.blockSize;
        if (length < i12 || bArr2.length - i11 < i12 || bArr3.length < i12) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i13 = 0; i13 < this.blockSize; i13++) {
            bArr3[i13] = (byte) (bArr[i13 + i10] ^ bArr2[i13 + i11]);
        }
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        int i11 = this.bufOff;
        byte[] bArr2 = this.buf;
        if (i11 % bArr2.length == 0) {
            xor(this.f41451c, 0, bArr2, 0, this.cTemp);
            xor(this.cTemp, 0, this.kDelta, 0, this.f41451c);
            DSTU7624Engine dSTU7624Engine = this.engine;
            byte[] bArr3 = this.f41451c;
            dSTU7624Engine.processBlock(bArr3, 0, bArr3, 0);
            int i12 = this.macSize;
            if (i12 + i10 <= bArr.length) {
                System.arraycopy(this.f41451c, 0, bArr, i10, i12);
                reset();
                return this.macSize;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new DataLengthException("input must be a multiple of blocksize");
    }

    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.engine.init(true, cipherParameters);
            this.initCalled = true;
            reset();
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
    }

    public void reset() {
        Arrays.fill(this.f41451c, (byte) 0);
        Arrays.fill(this.cTemp, (byte) 0);
        Arrays.fill(this.kDelta, (byte) 0);
        Arrays.fill(this.buf, (byte) 0);
        this.engine.reset();
        if (this.initCalled) {
            DSTU7624Engine dSTU7624Engine = this.engine;
            byte[] bArr = this.kDelta;
            dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
        }
        this.bufOff = 0;
    }

    public void update(byte b10) {
        int i10 = this.bufOff;
        byte[] bArr = this.buf;
        if (i10 == bArr.length) {
            processBlock(bArr, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i11 = this.bufOff;
        this.bufOff = i11 + 1;
        bArr2[i11] = b10;
    }

    public void update(byte[] bArr, int i10, int i11) {
        if (i11 >= 0) {
            int blockSize2 = this.engine.getBlockSize();
            int i12 = this.bufOff;
            int i13 = blockSize2 - i12;
            if (i11 > i13) {
                System.arraycopy(bArr, i10, this.buf, i12, i13);
                processBlock(this.buf, 0);
                this.bufOff = 0;
                i11 -= i13;
                i10 += i13;
                while (i11 > blockSize2) {
                    processBlock(bArr, i10);
                    i11 -= blockSize2;
                    i10 += blockSize2;
                }
            }
            System.arraycopy(bArr, i10, this.buf, this.bufOff, i11);
            this.bufOff += i11;
            return;
        }
        throw new IllegalArgumentException("can't have a negative input length!");
    }
}
