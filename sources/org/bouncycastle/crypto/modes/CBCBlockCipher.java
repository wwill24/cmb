package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CBCBlockCipher implements BlockCipher {
    private byte[] IV;
    private int blockSize;
    private byte[] cbcNextV;
    private byte[] cbcV;
    private BlockCipher cipher;
    private boolean encrypting;

    public CBCBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.cbcV = new byte[blockSize2];
        this.cbcNextV = new byte[blockSize2];
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.blockSize;
        if (i10 + i12 <= bArr.length) {
            System.arraycopy(bArr, i10, this.cbcNextV, 0, i12);
            int processBlock = this.cipher.processBlock(bArr, i10, bArr2, i11);
            for (int i13 = 0; i13 < this.blockSize; i13++) {
                int i14 = i11 + i13;
                bArr2[i14] = (byte) (bArr2[i14] ^ this.cbcV[i13]);
            }
            byte[] bArr3 = this.cbcV;
            this.cbcV = this.cbcNextV;
            this.cbcNextV = bArr3;
            return processBlock;
        }
        throw new DataLengthException("input buffer too short");
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        if (this.blockSize + i10 <= bArr.length) {
            for (int i12 = 0; i12 < this.blockSize; i12++) {
                byte[] bArr3 = this.cbcV;
                bArr3[i12] = (byte) (bArr3[i12] ^ bArr[i10 + i12]);
            }
            int processBlock = this.cipher.processBlock(this.cbcV, 0, bArr2, i11);
            byte[] bArr4 = this.cbcV;
            System.arraycopy(bArr2, i11, bArr4, 0, bArr4.length);
            return processBlock;
        }
        throw new DataLengthException("input buffer too short");
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CBC";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        boolean z11 = this.encrypting;
        this.encrypting = z10;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length == this.blockSize) {
                System.arraycopy(iv, 0, this.IV, 0, iv.length);
                reset();
                if (parametersWithIV.getParameters() != null) {
                    blockCipher = this.cipher;
                    cipherParameters = parametersWithIV.getParameters();
                } else if (z11 != z10) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
        } else {
            reset();
            if (cipherParameters != null) {
                blockCipher = this.cipher;
            } else if (z11 != z10) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            } else {
                return;
            }
        }
        blockCipher.init(z10, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        return this.encrypting ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
    }

    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.cbcV, 0, bArr.length);
        Arrays.fill(this.cbcNextV, (byte) 0);
        this.cipher.reset();
    }
}
