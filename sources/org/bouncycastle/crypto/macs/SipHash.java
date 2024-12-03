package org.bouncycastle.crypto.macs;

import org.apache.commons.cli.HelpFormatter;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class SipHash implements Mac {

    /* renamed from: c  reason: collision with root package name */
    protected final int f41470c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f41471d;

    /* renamed from: k0  reason: collision with root package name */
    protected long f41472k0;

    /* renamed from: k1  reason: collision with root package name */
    protected long f41473k1;

    /* renamed from: m  reason: collision with root package name */
    protected long f41474m;

    /* renamed from: v0  reason: collision with root package name */
    protected long f41475v0;

    /* renamed from: v1  reason: collision with root package name */
    protected long f41476v1;

    /* renamed from: v2  reason: collision with root package name */
    protected long f41477v2;

    /* renamed from: v3  reason: collision with root package name */
    protected long f41478v3;
    protected int wordCount;
    protected int wordPos;

    public SipHash() {
        this.f41474m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f41470c = 2;
        this.f41471d = 4;
    }

    public SipHash(int i10, int i11) {
        this.f41474m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f41470c = i10;
        this.f41471d = i11;
    }

    protected static long rotateLeft(long j10, int i10) {
        return (j10 >>> (-i10)) | (j10 << i10);
    }

    /* access modifiers changed from: protected */
    public void applySipRounds(int i10) {
        long j10 = this.f41475v0;
        long j11 = this.f41476v1;
        long j12 = this.f41477v2;
        long j13 = this.f41478v3;
        for (int i11 = 0; i11 < i10; i11++) {
            long j14 = j10 + j11;
            long j15 = j12 + j13;
            long rotateLeft = rotateLeft(j11, 13) ^ j14;
            long rotateLeft2 = rotateLeft(j13, 16) ^ j15;
            long j16 = j15 + rotateLeft;
            j10 = rotateLeft(j14, 32) + rotateLeft2;
            j11 = rotateLeft(rotateLeft, 17) ^ j16;
            j13 = rotateLeft(rotateLeft2, 21) ^ j10;
            j12 = rotateLeft(j16, 32);
        }
        this.f41475v0 = j10;
        this.f41476v1 = j11;
        this.f41477v2 = j12;
        this.f41478v3 = j13;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), bArr, i10);
        return 8;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        long j10 = this.f41474m;
        int i10 = this.wordPos;
        this.f41474m = ((j10 >>> ((7 - i10) << 3)) >>> 8) | ((((long) ((this.wordCount << 3) + i10)) & 255) << 56);
        processMessageWord();
        this.f41477v2 ^= 255;
        applySipRounds(this.f41471d);
        long j11 = ((this.f41475v0 ^ this.f41476v1) ^ this.f41477v2) ^ this.f41478v3;
        reset();
        return j11;
    }

    public String getAlgorithmName() {
        return "SipHash-" + this.f41470c + HelpFormatter.DEFAULT_OPT_PREFIX + this.f41471d;
    }

    public int getMacSize() {
        return 8;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.f41472k0 = Pack.littleEndianToLong(key, 0);
                this.f41473k1 = Pack.littleEndianToLong(key, 8);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    /* access modifiers changed from: protected */
    public void processMessageWord() {
        this.wordCount++;
        this.f41478v3 ^= this.f41474m;
        applySipRounds(this.f41470c);
        this.f41475v0 ^= this.f41474m;
    }

    public void reset() {
        long j10 = this.f41472k0;
        this.f41475v0 = 8317987319222330741L ^ j10;
        long j11 = this.f41473k1;
        this.f41476v1 = 7237128888997146477L ^ j11;
        this.f41477v2 = j10 ^ 7816392313619706465L;
        this.f41478v3 = 8387220255154660723L ^ j11;
        this.f41474m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    public void update(byte b10) throws IllegalStateException {
        this.f41474m = (this.f41474m >>> 8) | ((((long) b10) & 255) << 56);
        int i10 = this.wordPos + 1;
        this.wordPos = i10;
        if (i10 == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    public void update(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = bArr;
        int i12 = i11;
        int i13 = i12 & -8;
        int i14 = this.wordPos;
        int i15 = 0;
        if (i14 == 0) {
            while (i15 < i13) {
                this.f41474m = Pack.littleEndianToLong(bArr2, i10 + i15);
                processMessageWord();
                i15 += 8;
            }
            while (i15 < i12) {
                this.f41474m = (this.f41474m >>> 8) | ((((long) bArr2[i10 + i15]) & 255) << 56);
                i15++;
            }
            this.wordPos = i12 - i13;
            return;
        }
        int i16 = i14 << 3;
        int i17 = 0;
        while (i17 < i13) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr2, i10 + i17);
            this.f41474m = (this.f41474m >>> (-i16)) | (littleEndianToLong << i16);
            processMessageWord();
            this.f41474m = littleEndianToLong;
            i17 += 8;
        }
        while (i17 < i12) {
            this.f41474m = (this.f41474m >>> 8) | ((((long) bArr2[i10 + i17]) & 255) << 56);
            int i18 = this.wordPos + 1;
            this.wordPos = i18;
            if (i18 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i17++;
        }
    }
}
