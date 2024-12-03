package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ParallelHash implements Xof, Digest {
    private static final byte[] N_PARALLEL_HASH = Strings.toByteArray("ParallelHash");
    private final int B;
    private final int bitLength;
    private int bufOff;
    private final byte[] buffer;
    private final CSHAKEDigest compressor;
    private final byte[] compressorBuffer;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private int nCount;
    private final int outputLength;

    public ParallelHash(int i10, byte[] bArr, int i11) {
        this(i10, bArr, i11, i10 * 2);
    }

    public ParallelHash(int i10, byte[] bArr, int i11, int i12) {
        this.cshake = new CSHAKEDigest(i10, N_PARALLEL_HASH, bArr);
        this.compressor = new CSHAKEDigest(i10, new byte[0], new byte[0]);
        this.bitLength = i10;
        this.B = i11;
        this.outputLength = (i12 + 7) / 8;
        this.buffer = new byte[i11];
        this.compressorBuffer = new byte[((i10 * 2) / 8)];
        reset();
    }

    public ParallelHash(ParallelHash parallelHash) {
        this.cshake = new CSHAKEDigest(parallelHash.cshake);
        this.compressor = new CSHAKEDigest(parallelHash.compressor);
        this.bitLength = parallelHash.bitLength;
        this.B = parallelHash.B;
        this.outputLength = parallelHash.outputLength;
        this.buffer = Arrays.clone(parallelHash.buffer);
        this.compressorBuffer = Arrays.clone(parallelHash.compressorBuffer);
    }

    private void compress() {
        compress(this.buffer, 0, this.bufOff);
        this.bufOff = 0;
    }

    private void compress(byte[] bArr, int i10, int i11) {
        this.compressor.update(bArr, i10, i11);
        CSHAKEDigest cSHAKEDigest = this.compressor;
        byte[] bArr2 = this.compressorBuffer;
        cSHAKEDigest.doFinal(bArr2, 0, bArr2.length);
        CSHAKEDigest cSHAKEDigest2 = this.cshake;
        byte[] bArr3 = this.compressorBuffer;
        cSHAKEDigest2.update(bArr3, 0, bArr3.length);
        this.nCount++;
    }

    private void wrapUp(int i10) {
        if (this.bufOff != 0) {
            compress();
        }
        byte[] rightEncode = XofUtils.rightEncode((long) this.nCount);
        byte[] rightEncode2 = XofUtils.rightEncode((long) (i10 * 8));
        this.cshake.update(rightEncode, 0, rightEncode.length);
        this.cshake.update(rightEncode2, 0, rightEncode2.length);
        this.firstOutput = false;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int doFinal = this.cshake.doFinal(bArr, i10, getDigestSize());
        reset();
        return doFinal;
    }

    public int doFinal(byte[] bArr, int i10, int i11) {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int doFinal = this.cshake.doFinal(bArr, i10, i11);
        reset();
        return doFinal;
    }

    public int doOutput(byte[] bArr, int i10, int i11) {
        if (this.firstOutput) {
            wrapUp(0);
        }
        return this.cshake.doOutput(bArr, i10, i11);
    }

    public String getAlgorithmName() {
        return "ParallelHash" + this.cshake.getAlgorithmName().substring(6);
    }

    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    public int getDigestSize() {
        return this.outputLength;
    }

    public void reset() {
        this.cshake.reset();
        Arrays.clear(this.buffer);
        byte[] leftEncode = XofUtils.leftEncode((long) this.B);
        this.cshake.update(leftEncode, 0, leftEncode.length);
        this.nCount = 0;
        this.bufOff = 0;
        this.firstOutput = true;
    }

    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.buffer;
        int i10 = this.bufOff;
        int i11 = i10 + 1;
        this.bufOff = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            compress();
        }
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        int i12 = 0;
        int max = Math.max(0, i11);
        if (this.bufOff != 0) {
            while (i12 < max) {
                int i13 = this.bufOff;
                byte[] bArr2 = this.buffer;
                if (i13 == bArr2.length) {
                    break;
                }
                this.bufOff = i13 + 1;
                bArr2[i13] = bArr[i12 + i10];
                i12++;
            }
            if (this.bufOff == this.buffer.length) {
                compress();
            }
        }
        if (i12 < max) {
            while (true) {
                int i14 = max - i12;
                int i15 = this.B;
                if (i14 <= i15) {
                    break;
                }
                compress(bArr, i10 + i12, i15);
                i12 += this.B;
            }
        }
        while (i12 < max) {
            update(bArr[i12 + i10]);
            i12++;
        }
    }
}
