package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

public class CBCBlockCipherMac implements Mac {
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private BlockCipherPadding padding;

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, (BlockCipherPadding) null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i10) {
        this(blockCipher, i10, (BlockCipherPadding) null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i10, BlockCipherPadding blockCipherPadding) {
        if (i10 % 8 == 0) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.padding = blockCipherPadding;
            this.macSize = i10 / 8;
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public int doFinal(byte[] bArr, int i10) {
        int blockSize = this.cipher.getBlockSize();
        if (this.padding == null) {
            while (true) {
                int i11 = this.bufOff;
                if (i11 >= blockSize) {
                    break;
                }
                this.buf[i11] = 0;
                this.bufOff = i11 + 1;
            }
        } else {
            if (this.bufOff == blockSize) {
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
            }
            this.padding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        System.arraycopy(this.mac, 0, bArr, i10, this.macSize);
        reset();
        return this.macSize;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i10 < bArr.length) {
                bArr[i10] = 0;
                i10++;
            } else {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
        }
    }

    public void update(byte b10) {
        int i10 = this.bufOff;
        byte[] bArr = this.buf;
        if (i10 == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i11 = this.bufOff;
        this.bufOff = i11 + 1;
        bArr2[i11] = b10;
    }

    public void update(byte[] bArr, int i10, int i11) {
        if (i11 >= 0) {
            int blockSize = this.cipher.getBlockSize();
            int i12 = this.bufOff;
            int i13 = blockSize - i12;
            if (i11 > i13) {
                System.arraycopy(bArr, i10, this.buf, i12, i13);
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
                i11 -= i13;
                i10 += i13;
                while (i11 > blockSize) {
                    this.cipher.processBlock(bArr, i10, this.mac, 0);
                    i11 -= blockSize;
                    i10 += blockSize;
                }
            }
            System.arraycopy(bArr, i10, this.buf, this.bufOff, i11);
            this.bufOff += i11;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
