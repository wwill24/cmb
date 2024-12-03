package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

public class NullEngine implements BlockCipher {
    protected static final int DEFAULT_BLOCK_SIZE = 1;
    private final int blockSize;
    private boolean initialised;

    public NullEngine() {
        this(1);
    }

    public NullEngine(int i10) {
        this.blockSize = i10;
    }

    public String getAlgorithmName() {
        return "Null";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        if (this.initialised) {
            int i12 = this.blockSize;
            if (i10 + i12 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i12 + i11 <= bArr2.length) {
                int i13 = 0;
                while (true) {
                    int i14 = this.blockSize;
                    if (i13 >= i14) {
                        return i14;
                    }
                    bArr2[i11 + i13] = bArr[i10 + i13];
                    i13++;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Null engine not initialised");
        }
    }

    public void reset() {
    }
}
