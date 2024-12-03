package org.bouncycastle.crypto.macs;

import org.apache.commons.cli.HelpFormatter;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Pack;

public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public SipHash128(int i10, int i11) {
        super(i10, i11);
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        long j10 = this.f41474m;
        int i11 = this.wordPos;
        this.f41474m = ((j10 >>> ((7 - i11) << 3)) >>> 8) | ((((long) ((this.wordCount << 3) + i11)) & 255) << 56);
        processMessageWord();
        this.f41477v2 ^= 238;
        applySipRounds(this.f41471d);
        long j11 = this.f41475v0;
        long j12 = this.f41476v1;
        long j13 = ((j11 ^ j12) ^ this.f41477v2) ^ this.f41478v3;
        this.f41476v1 = j12 ^ 221;
        applySipRounds(this.f41471d);
        reset();
        Pack.longToLittleEndian(j13, bArr, i10);
        Pack.longToLittleEndian(((this.f41475v0 ^ this.f41476v1) ^ this.f41477v2) ^ this.f41478v3, bArr, i10 + 8);
        return 16;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    public String getAlgorithmName() {
        return "SipHash128-" + this.f41470c + HelpFormatter.DEFAULT_OPT_PREFIX + this.f41471d;
    }

    public int getMacSize() {
        return 16;
    }

    public void reset() {
        super.reset();
        this.f41476v1 ^= 238;
    }
}
