package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount = 0;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.counter = new byte[blockSize2];
        this.counterOut = new byte[blockSize2];
    }

    private void adjustCounter(long j10) {
        int i10 = 5;
        if (j10 >= 0) {
            long j11 = (((long) this.byteCount) + j10) / ((long) this.blockSize);
            long j12 = j11;
            if (j11 > 255) {
                while (i10 >= 1) {
                    long j13 = 1 << (i10 * 8);
                    while (j12 >= j13) {
                        incrementCounterAt(i10);
                        j12 -= j13;
                    }
                    i10--;
                }
            }
            incrementCounter((int) j12);
            this.byteCount = (int) ((j10 + ((long) this.byteCount)) - (((long) this.blockSize) * j11));
            return;
        }
        long j14 = ((-j10) - ((long) this.byteCount)) / ((long) this.blockSize);
        long j15 = j14;
        if (j14 > 255) {
            while (i10 >= 1) {
                long j16 = 1 << (i10 * 8);
                while (j15 > j16) {
                    decrementCounterAt(i10);
                    j15 -= j16;
                }
                i10--;
            }
        }
        for (long j17 = 0; j17 != j15; j17++) {
            decrementCounterAt(0);
        }
        int i11 = (int) (((long) this.byteCount) + j10 + (((long) this.blockSize) * j14));
        if (i11 >= 0) {
            this.byteCount = 0;
            return;
        }
        decrementCounterAt(0);
        this.byteCount = this.blockSize + i11;
    }

    private void checkCounter() {
        if (this.IV.length < this.blockSize) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.IV;
                if (i10 == bArr.length) {
                    return;
                }
                if (this.counter[i10] == bArr[i10]) {
                    i10++;
                } else {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    private void decrementCounterAt(int i10) {
        byte b10;
        int length = this.counter.length - i10;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.counter;
                b10 = (byte) (bArr[length] - 1);
                bArr[length] = b10;
            } else {
                return;
            }
        } while (b10 == -1);
    }

    private void incrementCounter(int i10) {
        byte[] bArr = this.counter;
        byte b10 = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + i10);
        if (b10 != 0 && bArr[bArr.length - 1] < b10) {
            incrementCounterAt(1);
        }
    }

    private void incrementCounterAt(int i10) {
        byte b10;
        int length = this.counter.length - i10;
        do {
            length--;
            if (length >= 0) {
                byte[] bArr = this.counter;
                b10 = (byte) (bArr[length] + 1);
                bArr[length] = b10;
            } else {
                return;
            }
        } while (b10 == 0);
    }

    private void incrementCounterChecked() {
        byte b10;
        int length = this.counter.length;
        do {
            length--;
            if (length < 0) {
                break;
            }
            byte[] bArr = this.counter;
            b10 = (byte) (bArr[length] + 1);
            bArr[length] = b10;
        } while (b10 == 0);
        byte[] bArr2 = this.IV;
        if (length < bArr2.length && bArr2.length < this.blockSize) {
            throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
        }
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) throws DataLengthException, IllegalStateException {
        int i10 = this.byteCount;
        if (i10 == 0) {
            this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i11 = this.byteCount;
            this.byteCount = i11 + 1;
            return (byte) (b10 ^ bArr[i11]);
        }
        byte[] bArr2 = this.counterOut;
        int i12 = i10 + 1;
        this.byteCount = i12;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        if (i12 == this.counter.length) {
            this.byteCount = 0;
            incrementCounterChecked();
        }
        return b11;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public long getPosition() {
        byte[] bArr = this.counter;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i10 = length - 1;
        while (i10 >= 1) {
            byte[] bArr3 = this.IV;
            int i11 = i10 < bArr3.length ? (bArr2[i10] & 255) - (bArr3[i10] & 255) : bArr2[i10] & 255;
            if (i11 < 0) {
                int i12 = i10 - 1;
                bArr2[i12] = (byte) (bArr2[i12] - 1);
                i11 += 256;
            }
            bArr2[i10] = (byte) i11;
            i10--;
        }
        return (Pack.bigEndianToLong(bArr2, length - 8) * ((long) this.blockSize)) + ((long) this.byteCount);
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] clone = Arrays.clone(parametersWithIV.getIV());
            this.IV = clone;
            int i10 = this.blockSize;
            if (i10 >= clone.length) {
                int i11 = 8;
                if (8 > i10 / 2) {
                    i11 = i10 / 2;
                }
                if (i10 - clone.length <= i11) {
                    if (parametersWithIV.getParameters() != null) {
                        this.cipher.init(true, parametersWithIV.getParameters());
                    }
                    reset();
                    return;
                }
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - i11) + " bytes.");
            }
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.blockSize + " bytes.");
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        if (this.byteCount != 0) {
            processBytes(bArr, i10, this.blockSize, bArr2, i11);
        } else {
            int i12 = this.blockSize;
            if (i10 + i12 > bArr.length) {
                throw new DataLengthException("input buffer too small");
            } else if (i12 + i11 <= bArr2.length) {
                this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
                for (int i13 = 0; i13 < this.blockSize; i13++) {
                    bArr2[i11 + i13] = (byte) (bArr[i10 + i13] ^ this.counterOut[i13]);
                }
                incrementCounterChecked();
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        }
        return this.blockSize;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        byte b10;
        int i13 = this.blockSize;
        if (i10 + i13 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = this.byteCount;
                if (i15 == 0) {
                    this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
                    byte b11 = bArr[i10 + i14];
                    byte[] bArr3 = this.counterOut;
                    int i16 = this.byteCount;
                    this.byteCount = i16 + 1;
                    b10 = (byte) (b11 ^ bArr3[i16]);
                } else {
                    byte b12 = bArr[i10 + i14];
                    byte[] bArr4 = this.counterOut;
                    int i17 = i15 + 1;
                    this.byteCount = i17;
                    b10 = (byte) (bArr4[i15] ^ b12);
                    if (i17 == this.counter.length) {
                        this.byteCount = 0;
                        incrementCounterChecked();
                    }
                }
                bArr2[i12 + i14] = b10;
            }
            return i11;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        Arrays.fill(this.counter, (byte) 0);
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.counter, 0, bArr.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    public long seekTo(long j10) {
        reset();
        return skip(j10);
    }

    public long skip(long j10) {
        adjustCounter(j10);
        checkCounter();
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return j10;
    }
}
