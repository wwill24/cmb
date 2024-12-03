package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Strings;

public class TupleHash implements Xof, Digest {
    private static final byte[] N_TUPLE_HASH = Strings.toByteArray("TupleHash");
    private final int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private final int outputLength;

    public TupleHash(int i10, byte[] bArr) {
        this(i10, bArr, i10 * 2);
    }

    public TupleHash(int i10, byte[] bArr, int i11) {
        this.cshake = new CSHAKEDigest(i10, N_TUPLE_HASH, bArr);
        this.bitLength = i10;
        this.outputLength = (i11 + 7) / 8;
        reset();
    }

    public TupleHash(TupleHash tupleHash) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(tupleHash.cshake);
        this.cshake = cSHAKEDigest;
        int i10 = cSHAKEDigest.fixedOutputLength;
        this.bitLength = i10;
        this.outputLength = (i10 * 2) / 8;
        this.firstOutput = tupleHash.firstOutput;
    }

    private void wrapUp(int i10) {
        byte[] rightEncode = XofUtils.rightEncode(((long) i10) * 8);
        this.cshake.update(rightEncode, 0, rightEncode.length);
        this.firstOutput = false;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        if (this.firstOutput) {
            wrapUp(getDigestSize());
        }
        int doFinal = this.cshake.doFinal(bArr, i10, getDigestSize());
        reset();
        return doFinal;
    }

    public int doFinal(byte[] bArr, int i10, int i11) {
        if (this.firstOutput) {
            wrapUp(getDigestSize());
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
        return "TupleHash" + this.cshake.getAlgorithmName().substring(6);
    }

    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    public int getDigestSize() {
        return this.outputLength;
    }

    public void reset() {
        this.cshake.reset();
        this.firstOutput = true;
    }

    public void update(byte b10) throws IllegalStateException {
        byte[] encode = XofUtils.encode(b10);
        this.cshake.update(encode, 0, encode.length);
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        byte[] encode = XofUtils.encode(bArr, i10, i11);
        this.cshake.update(encode, 0, encode.length);
    }
}
