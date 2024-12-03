package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootSig {
    private long big8;
    private int checksum;
    private int counter;
    private GMSSRandom gmssRandom;
    private byte[] hash;
    private int height;

    /* renamed from: ii  reason: collision with root package name */
    private int f23985ii;

    /* renamed from: k  reason: collision with root package name */
    private int f23986k;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[] privateKeyOTS;

    /* renamed from: r  reason: collision with root package name */
    private int f23987r;
    private byte[] seed;
    private byte[] sign;
    private int steps;
    private int test;
    private long test8;

    /* renamed from: w  reason: collision with root package name */
    private int f23988w;

    public GMSSRootSig(Digest digest, int i10, int i11) {
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        this.f23988w = i10;
        this.height = i11;
        this.f23986k = (1 << i10) - 1;
        this.messagesize = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i10));
    }

    public GMSSRootSig(Digest digest, byte[][] bArr, int[] iArr) {
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        this.counter = iArr[0];
        this.test = iArr[1];
        this.f23985ii = iArr[2];
        this.f23987r = iArr[3];
        this.steps = iArr[4];
        this.keysize = iArr[5];
        this.height = iArr[6];
        this.f23988w = iArr[7];
        this.checksum = iArr[8];
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int i10 = this.f23988w;
        this.f23986k = (1 << i10) - 1;
        this.messagesize = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i10));
        this.privateKeyOTS = bArr[0];
        this.seed = bArr[1];
        this.hash = bArr[2];
        this.sign = bArr[3];
        byte[] bArr2 = bArr[4];
        this.test8 = (((long) (bArr2[1] & 255)) << 8) | ((long) (bArr2[0] & 255)) | (((long) (bArr2[2] & 255)) << 16) | (((long) (bArr2[3] & 255)) << 24) | (((long) (bArr2[4] & 255)) << 32) | (((long) (bArr2[5] & 255)) << 40) | (((long) (bArr2[6] & 255)) << 48) | (((long) (bArr2[7] & 255)) << 56);
        this.big8 = ((long) (bArr2[8] & 255)) | (((long) (bArr2[9] & 255)) << 8) | (((long) (bArr2[10] & 255)) << 16) | (((long) (bArr2[11] & 255)) << 24) | (((long) (bArr2[12] & 255)) << 32) | (((long) (bArr2[13] & 255)) << 40) | (((long) (bArr2[14] & 255)) << 48) | (((long) (bArr2[15] & 255)) << 56);
    }

    private void oneStep() {
        long j10;
        int i10;
        int i11 = this.f23988w;
        if (8 % i11 == 0) {
            int i12 = this.test;
            if (i12 == 0) {
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
                int i13 = this.f23985ii;
                if (i13 < this.mdsize) {
                    byte[] bArr = this.hash;
                    byte b10 = bArr[i13];
                    this.test = this.f23986k & b10;
                    bArr[i13] = (byte) (b10 >>> this.f23988w);
                } else {
                    int i14 = this.checksum;
                    this.test = this.f23986k & i14;
                    this.checksum = i14 >>> this.f23988w;
                }
            } else if (i12 > 0) {
                Digest digest = this.messDigestOTS;
                byte[] bArr2 = this.privateKeyOTS;
                digest.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr3;
                this.messDigestOTS.doFinal(bArr3, 0);
                this.test--;
            }
            if (this.test == 0) {
                byte[] bArr4 = this.privateKeyOTS;
                byte[] bArr5 = this.sign;
                int i15 = this.counter;
                int i16 = this.mdsize;
                System.arraycopy(bArr4, 0, bArr5, i15 * i16, i16);
                int i17 = this.counter + 1;
                this.counter = i17;
                if (i17 % (8 / this.f23988w) == 0) {
                    this.f23985ii++;
                    return;
                }
                return;
            }
            return;
        }
        if (i11 < 8) {
            int i18 = this.test;
            if (i18 == 0) {
                int i19 = this.counter;
                if (i19 % 8 == 0 && this.f23985ii < (i10 = this.mdsize)) {
                    this.big8 = 0;
                    if (i19 < ((i10 / i11) << 3)) {
                        for (int i20 = 0; i20 < this.f23988w; i20++) {
                            long j11 = this.big8;
                            byte[] bArr6 = this.hash;
                            int i21 = this.f23985ii;
                            this.big8 = j11 ^ ((long) ((bArr6[i21] & 255) << (i20 << 3)));
                            this.f23985ii = i21 + 1;
                        }
                    } else {
                        for (int i22 = 0; i22 < this.mdsize % this.f23988w; i22++) {
                            long j12 = this.big8;
                            byte[] bArr7 = this.hash;
                            int i23 = this.f23985ii;
                            this.big8 = j12 ^ ((long) ((bArr7[i23] & 255) << (i22 << 3)));
                            this.f23985ii = i23 + 1;
                        }
                    }
                }
                if (this.counter == this.messagesize) {
                    this.big8 = (long) this.checksum;
                }
                this.test = (int) (this.big8 & ((long) this.f23986k));
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            } else if (i18 > 0) {
                Digest digest2 = this.messDigestOTS;
                byte[] bArr8 = this.privateKeyOTS;
                digest2.update(bArr8, 0, bArr8.length);
                byte[] bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr9;
                this.messDigestOTS.doFinal(bArr9, 0);
                this.test--;
            }
            if (this.test == 0) {
                byte[] bArr10 = this.privateKeyOTS;
                byte[] bArr11 = this.sign;
                int i24 = this.counter;
                int i25 = this.mdsize;
                System.arraycopy(bArr10, 0, bArr11, i24 * i25, i25);
                this.big8 >>>= this.f23988w;
            } else {
                return;
            }
        } else if (i11 < 57) {
            long j13 = this.test8;
            if (j13 == 0) {
                this.big8 = 0;
                this.f23985ii = 0;
                int i26 = this.f23987r;
                int i27 = i26 % 8;
                int i28 = i26 >>> 3;
                int i29 = this.mdsize;
                if (i28 < i29) {
                    if (i26 <= (i29 << 3) - i11) {
                        int i30 = i26 + i11;
                        this.f23987r = i30;
                        i29 = (i30 + 7) >>> 3;
                    } else {
                        this.f23987r = i26 + i11;
                    }
                    while (true) {
                        j10 = this.big8;
                        if (i28 >= i29) {
                            break;
                        }
                        int i31 = this.f23985ii;
                        this.big8 = j10 ^ ((long) ((this.hash[i28] & 255) << (i31 << 3)));
                        this.f23985ii = i31 + 1;
                        i28++;
                    }
                    long j14 = j10 >>> i27;
                    this.big8 = j14;
                    this.test8 = j14 & ((long) this.f23986k);
                } else {
                    int i32 = this.checksum;
                    this.test8 = (long) (this.f23986k & i32);
                    this.checksum = i32 >>> i11;
                }
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            } else if (j13 > 0) {
                Digest digest3 = this.messDigestOTS;
                byte[] bArr12 = this.privateKeyOTS;
                digest3.update(bArr12, 0, bArr12.length);
                byte[] bArr13 = new byte[this.messDigestOTS.getDigestSize()];
                this.privateKeyOTS = bArr13;
                this.messDigestOTS.doFinal(bArr13, 0);
                this.test8--;
            }
            if (this.test8 == 0) {
                byte[] bArr14 = this.privateKeyOTS;
                byte[] bArr15 = this.sign;
                int i33 = this.counter;
                int i34 = this.mdsize;
                System.arraycopy(bArr14, 0, bArr15, i33 * i34, i34);
            } else {
                return;
            }
        } else {
            return;
        }
        this.counter++;
    }

    public int getLog(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public byte[] getSig() {
        return this.sign;
    }

    public byte[][] getStatByte() {
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        bArr[0] = this.privateKeyOTS;
        bArr[1] = this.seed;
        bArr[2] = this.hash;
        bArr[3] = this.sign;
        bArr[4] = getStatLong();
        return bArr;
    }

    public int[] getStatInt() {
        return new int[]{this.counter, this.test, this.f23985ii, this.f23987r, this.steps, this.keysize, this.height, this.f23988w, this.checksum};
    }

    public byte[] getStatLong() {
        long j10 = this.test8;
        long j11 = this.big8;
        return new byte[]{(byte) ((int) (j10 & 255)), (byte) ((int) ((j10 >> 8) & 255)), (byte) ((int) ((j10 >> 16) & 255)), (byte) ((int) ((j10 >> 24) & 255)), (byte) ((int) ((j10 >> 32) & 255)), (byte) ((int) ((j10 >> 40) & 255)), (byte) ((int) ((j10 >> 48) & 255)), (byte) ((int) ((j10 >> 56) & 255)), (byte) ((int) (j11 & 255)), (byte) ((int) ((j11 >> 8) & 255)), (byte) ((int) ((j11 >> 16) & 255)), (byte) ((int) ((j11 >> 24) & 255)), (byte) ((int) ((j11 >> 32) & 255)), (byte) ((int) ((j11 >> 40) & 255)), (byte) ((int) ((j11 >> 48) & 255)), (byte) ((int) ((j11 >> 56) & 255))};
    }

    public void initSign(byte[] bArr, byte[] bArr2) {
        int i10;
        int i11;
        byte[] bArr3 = bArr2;
        this.hash = new byte[this.mdsize];
        this.messDigestOTS.update(bArr3, 0, bArr3.length);
        byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
        this.hash = bArr4;
        this.messDigestOTS.doFinal(bArr4, 0);
        int i12 = this.mdsize;
        byte[] bArr5 = new byte[i12];
        System.arraycopy(this.hash, 0, bArr5, 0, i12);
        int log = getLog((this.messagesize << this.f23988w) + 1);
        int i13 = this.f23988w;
        int i14 = 8;
        if (8 % i13 == 0) {
            int i15 = 8 / i13;
            i10 = 0;
            for (int i16 = 0; i16 < this.mdsize; i16++) {
                for (int i17 = 0; i17 < i15; i17++) {
                    byte b10 = bArr5[i16];
                    i10 += this.f23986k & b10;
                    bArr5[i16] = (byte) (b10 >>> this.f23988w);
                }
            }
            int i18 = (this.messagesize << this.f23988w) - i10;
            this.checksum = i18;
            int i19 = 0;
            while (i19 < log) {
                i10 += this.f23986k & i18;
                int i20 = this.f23988w;
                i18 >>>= i20;
                i19 += i20;
            }
        } else if (i13 < 8) {
            int i21 = this.mdsize / i13;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < i21) {
                long j10 = 0;
                for (int i25 = 0; i25 < this.f23988w; i25++) {
                    j10 ^= (long) ((bArr5[i23] & 255) << (i25 << 3));
                    i23++;
                }
                int i26 = 0;
                while (i26 < i14) {
                    i24 += (int) (((long) this.f23986k) & j10);
                    j10 >>>= this.f23988w;
                    i26++;
                    i21 = i21;
                    i14 = 8;
                }
                int i27 = i21;
                i22++;
                i14 = 8;
            }
            int i28 = this.mdsize % this.f23988w;
            long j11 = 0;
            for (int i29 = 0; i29 < i28; i29++) {
                j11 ^= (long) ((bArr5[i23] & 255) << (i29 << 3));
                i23++;
            }
            int i30 = i28 << 3;
            int i31 = 0;
            while (i31 < i30) {
                i24 += (int) (((long) this.f23986k) & j11);
                int i32 = this.f23988w;
                j11 >>>= i32;
                i31 += i32;
            }
            int i33 = (this.messagesize << this.f23988w) - i24;
            this.checksum = i33;
            int i34 = 0;
            int i35 = i24;
            while (i34 < log) {
                i35 = i10 + (this.f23986k & i33);
                int i36 = this.f23988w;
                i33 >>>= i36;
                i34 += i36;
            }
        } else if (i13 < 57) {
            int i37 = 0;
            int i38 = 0;
            while (true) {
                i11 = this.mdsize;
                int i39 = this.f23988w;
                if (i37 > (i11 << 3) - i39) {
                    break;
                }
                int i40 = i37 % 8;
                i37 += i39;
                int i41 = (i37 + 7) >>> 3;
                int i42 = 0;
                long j12 = 0;
                for (int i43 = i37 >>> 3; i43 < i41; i43++) {
                    j12 ^= (long) ((bArr5[i43] & 255) << (i42 << 3));
                    i42++;
                }
                i38 = (int) (((long) i38) + ((j12 >>> i40) & ((long) this.f23986k)));
            }
            int i44 = i37 >>> 3;
            if (i44 < i11) {
                int i45 = i37 % 8;
                int i46 = 0;
                long j13 = 0;
                while (i44 < this.mdsize) {
                    j13 ^= (long) ((bArr5[i44] & 255) << (i46 << 3));
                    i46++;
                    i44++;
                }
                i38 = (int) (((long) i38) + ((j13 >>> i45) & ((long) this.f23986k)));
            }
            int i47 = (this.messagesize << this.f23988w) - i38;
            this.checksum = i47;
            int i48 = 0;
            int i49 = i38;
            while (i48 < log) {
                i49 = i10 + (this.f23986k & i47);
                int i50 = this.f23988w;
                i47 >>>= i50;
                i48 += i50;
            }
        } else {
            i10 = 0;
        }
        int ceil = this.messagesize + ((int) Math.ceil(((double) log) / ((double) this.f23988w)));
        this.keysize = ceil;
        this.steps = (int) Math.ceil(((double) (ceil + i10)) / ((double) (1 << this.height)));
        int i51 = this.keysize;
        int i52 = this.mdsize;
        this.sign = new byte[(i51 * i52)];
        this.counter = 0;
        this.test = 0;
        this.f23985ii = 0;
        this.test8 = 0;
        this.f23987r = 0;
        this.privateKeyOTS = new byte[i52];
        byte[] bArr6 = new byte[i52];
        this.seed = bArr6;
        System.arraycopy(bArr, 0, bArr6, 0, i52);
    }

    public String toString() {
        String str = "" + this.big8 + "  ";
        int[] statInt = getStatInt();
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        byte[][] statByte = getStatByte();
        for (int i10 = 0; i10 < 9; i10++) {
            str = str + statInt[i10] + " ";
        }
        for (int i11 = 0; i11 < 5; i11++) {
            str = str + new String(Hex.encode(statByte[i11])) + " ";
        }
        return str;
    }

    public boolean updateSign() {
        for (int i10 = 0; i10 < this.steps; i10++) {
            if (this.counter < this.keysize) {
                oneStep();
            }
            if (this.counter == this.keysize) {
                return true;
            }
        }
        return false;
    }
}
