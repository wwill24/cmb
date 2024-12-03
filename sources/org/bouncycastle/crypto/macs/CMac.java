package org.bouncycastle.crypto.macs;

import com.google.firebase.database.core.ValidationPath;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class CMac implements Mac {
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private byte[] poly;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int i10) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i10 <= blockCipher.getBlockSize() * 8) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.macSize = i10 / 8;
            this.poly = lookupPoly(blockCipher.getBlockSize());
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.ZEROES = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
        } else {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        }
    }

    private byte[] doubleLu(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        byte b10 = (-shiftLeft(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b11 = bArr2[length];
        byte[] bArr3 = this.poly;
        bArr2[length] = (byte) (b11 ^ (bArr3[1] & b10));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & b10) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((b10 & bArr3[3]) ^ bArr2[length3]);
        return bArr2;
    }

    private static byte[] lookupPoly(int i10) {
        int i11 = i10 * 8;
        int i12 = 135;
        switch (i11) {
            case 64:
            case 320:
                i12 = 27;
                break;
            case 128:
            case 192:
                break;
            case 160:
                i12 = 45;
                break;
            case 224:
                i12 = 777;
                break;
            case 256:
                i12 = 1061;
                break;
            case 384:
                i12 = 4109;
                break;
            case 448:
                i12 = 2129;
                break;
            case 512:
                i12 = 293;
                break;
            case ValidationPath.MAX_PATH_LENGTH_BYTES:
                i12 = 655377;
                break;
            case 1024:
                i12 = 524355;
                break;
            case 2048:
                i12 = 548865;
                break;
            default:
                throw new IllegalArgumentException("Unknown block size for CMAC: " + i11);
        }
        return Pack.intToBigEndian(i12);
    }

    private static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            byte b10 = bArr[length] & 255;
            bArr2[length] = (byte) (i10 | (b10 << 1));
            i10 = (b10 >>> 7) & 1;
        }
    }

    public int doFinal(byte[] bArr, int i10) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i11 < bArr3.length) {
                byte[] bArr4 = this.buf;
                bArr4[i11] = (byte) (bArr4[i11] ^ bArr2[i11]);
                i11++;
            } else {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i10, this.macSize);
                reset();
                return this.macSize;
            }
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        validate(cipherParameters);
        this.cipher.init(true, cipherParameters);
        byte[] bArr = this.ZEROES;
        byte[] bArr2 = new byte[bArr.length];
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        byte[] doubleLu = doubleLu(bArr2);
        this.Lu = doubleLu;
        this.Lu2 = doubleLu(doubleLu);
        reset();
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

    /* access modifiers changed from: package-private */
    public void validate(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }
}
