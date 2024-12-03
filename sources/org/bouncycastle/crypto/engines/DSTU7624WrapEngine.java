package org.bouncycastle.crypto.engines;

import java.util.ArrayList;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class DSTU7624WrapEngine implements Wrapper {
    private static final int BYTES_IN_INTEGER = 4;
    private byte[] B;
    private ArrayList<byte[]> Btemp = new ArrayList<>();
    private byte[] checkSumArray = new byte[this.engine.getBlockSize()];
    private DSTU7624Engine engine;
    private boolean forWrapping;
    private byte[] intArray = new byte[4];
    private byte[] zeroArray = new byte[this.engine.getBlockSize()];

    public DSTU7624WrapEngine(int i10) {
        DSTU7624Engine dSTU7624Engine = new DSTU7624Engine(i10);
        this.engine = dSTU7624Engine;
        this.B = new byte[(dSTU7624Engine.getBlockSize() / 2)];
    }

    private void intToBytes(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >> 24);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11] = (byte) i10;
    }

    public String getAlgorithmName() {
        return "DSTU7624WrapEngine";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.forWrapping = z10;
        if (cipherParameters instanceof KeyParameter) {
            this.engine.init(z10, cipherParameters);
            return;
        }
        throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
    }

    public byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        } else if (i11 % this.engine.getBlockSize() == 0) {
            int blockSize = (i11 * 2) / this.engine.getBlockSize();
            int i12 = blockSize - 1;
            int i13 = i12 * 6;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            byte[] bArr3 = new byte[(this.engine.getBlockSize() / 2)];
            System.arraycopy(bArr2, 0, bArr3, 0, this.engine.getBlockSize() / 2);
            this.Btemp.clear();
            int blockSize2 = i11 - (this.engine.getBlockSize() / 2);
            int blockSize3 = this.engine.getBlockSize() / 2;
            while (blockSize2 != 0) {
                byte[] bArr4 = new byte[(this.engine.getBlockSize() / 2)];
                System.arraycopy(bArr2, blockSize3, bArr4, 0, this.engine.getBlockSize() / 2);
                this.Btemp.add(bArr4);
                blockSize2 -= this.engine.getBlockSize() / 2;
                blockSize3 += this.engine.getBlockSize() / 2;
            }
            for (int i14 = 0; i14 < i13; i14++) {
                System.arraycopy(this.Btemp.get(blockSize - 2), 0, bArr2, 0, this.engine.getBlockSize() / 2);
                System.arraycopy(bArr3, 0, bArr2, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
                intToBytes(i13 - i14, this.intArray, 0);
                for (int i15 = 0; i15 < 4; i15++) {
                    int blockSize4 = (this.engine.getBlockSize() / 2) + i15;
                    bArr2[blockSize4] = (byte) (bArr2[blockSize4] ^ this.intArray[i15]);
                }
                this.engine.processBlock(bArr2, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr3, 0, this.engine.getBlockSize() / 2);
                for (int i16 = 2; i16 < blockSize; i16++) {
                    int i17 = blockSize - i16;
                    System.arraycopy(this.Btemp.get(i17 - 1), 0, this.Btemp.get(i17), 0, this.engine.getBlockSize() / 2);
                }
                System.arraycopy(bArr2, this.engine.getBlockSize() / 2, this.Btemp.get(0), 0, this.engine.getBlockSize() / 2);
            }
            System.arraycopy(bArr3, 0, bArr2, 0, this.engine.getBlockSize() / 2);
            int blockSize5 = this.engine.getBlockSize() / 2;
            for (int i18 = 0; i18 < i12; i18++) {
                System.arraycopy(this.Btemp.get(i18), 0, bArr2, blockSize5, this.engine.getBlockSize() / 2);
                blockSize5 += this.engine.getBlockSize() / 2;
            }
            System.arraycopy(bArr2, i11 - this.engine.getBlockSize(), this.checkSumArray, 0, this.engine.getBlockSize());
            byte[] bArr5 = new byte[(i11 - this.engine.getBlockSize())];
            if (Arrays.areEqual(this.checkSumArray, this.zeroArray)) {
                System.arraycopy(bArr2, 0, bArr5, 0, i11 - this.engine.getBlockSize());
                return bArr5;
            }
            throw new InvalidCipherTextException("checksum failed");
        } else {
            throw new DataLengthException("unwrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
        }
    }

    public byte[] wrap(byte[] bArr, int i10, int i11) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        } else if (i11 % this.engine.getBlockSize() != 0) {
            throw new DataLengthException("wrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
        } else if (i10 + i11 <= bArr.length) {
            int blockSize = ((i11 / this.engine.getBlockSize()) + 1) * 2;
            int i12 = blockSize - 1;
            int i13 = i12 * 6;
            int blockSize2 = this.engine.getBlockSize() + i11;
            byte[] bArr2 = new byte[blockSize2];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            System.arraycopy(bArr2, 0, this.B, 0, this.engine.getBlockSize() / 2);
            this.Btemp.clear();
            int blockSize3 = blockSize2 - (this.engine.getBlockSize() / 2);
            int blockSize4 = this.engine.getBlockSize() / 2;
            while (blockSize3 != 0) {
                byte[] bArr3 = new byte[(this.engine.getBlockSize() / 2)];
                System.arraycopy(bArr2, blockSize4, bArr3, 0, this.engine.getBlockSize() / 2);
                this.Btemp.add(bArr3);
                blockSize3 -= this.engine.getBlockSize() / 2;
                blockSize4 += this.engine.getBlockSize() / 2;
            }
            int i14 = 0;
            while (i14 < i13) {
                System.arraycopy(this.B, 0, bArr2, 0, this.engine.getBlockSize() / 2);
                System.arraycopy(this.Btemp.get(0), 0, bArr2, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
                this.engine.processBlock(bArr2, 0, bArr2, 0);
                i14++;
                intToBytes(i14, this.intArray, 0);
                for (int i15 = 0; i15 < 4; i15++) {
                    int blockSize5 = (this.engine.getBlockSize() / 2) + i15;
                    bArr2[blockSize5] = (byte) (bArr2[blockSize5] ^ this.intArray[i15]);
                }
                System.arraycopy(bArr2, this.engine.getBlockSize() / 2, this.B, 0, this.engine.getBlockSize() / 2);
                for (int i16 = 2; i16 < blockSize; i16++) {
                    System.arraycopy(this.Btemp.get(i16 - 1), 0, this.Btemp.get(i16 - 2), 0, this.engine.getBlockSize() / 2);
                }
                System.arraycopy(bArr2, 0, this.Btemp.get(blockSize - 2), 0, this.engine.getBlockSize() / 2);
            }
            System.arraycopy(this.B, 0, bArr2, 0, this.engine.getBlockSize() / 2);
            int blockSize6 = this.engine.getBlockSize() / 2;
            for (int i17 = 0; i17 < i12; i17++) {
                System.arraycopy(this.Btemp.get(i17), 0, bArr2, blockSize6, this.engine.getBlockSize() / 2);
                blockSize6 += this.engine.getBlockSize() / 2;
            }
            return bArr2;
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }
}
