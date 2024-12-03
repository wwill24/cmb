package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

public class CFBBlockCipherMac implements Mac {
    private byte[] buf;
    private int bufOff;
    private MacCFBBlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private BlockCipherPadding padding;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, (BlockCipherPadding) null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i10, int i11) {
        this(blockCipher, i10, i11, (BlockCipherPadding) null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i10, int i11, BlockCipherPadding blockCipherPadding) {
        this.padding = null;
        if (i11 % 8 == 0) {
            this.mac = new byte[blockCipher.getBlockSize()];
            MacCFBBlockCipher macCFBBlockCipher = new MacCFBBlockCipher(blockCipher, i10);
            this.cipher = macCFBBlockCipher;
            this.padding = blockCipherPadding;
            this.macSize = i11 / 8;
            this.buf = new byte[macCFBBlockCipher.getBlockSize()];
            this.bufOff = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public int doFinal(byte[] bArr, int i10) {
        int blockSize = this.cipher.getBlockSize();
        BlockCipherPadding blockCipherPadding = this.padding;
        if (blockCipherPadding == null) {
            while (true) {
                int i11 = this.bufOff;
                if (i11 >= blockSize) {
                    break;
                }
                this.buf[i11] = 0;
                this.bufOff = i11 + 1;
            }
        } else {
            blockCipherPadding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        this.cipher.getMacBlock(this.mac);
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
        this.cipher.init(cipherParameters);
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
