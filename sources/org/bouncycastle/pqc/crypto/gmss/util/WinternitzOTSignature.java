package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;

    /* renamed from: w  reason: collision with root package name */
    private int f23990w;

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i10) {
        this.f23990w = i10;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int i11 = (((digestSize << 3) + i10) - 1) / i10;
        this.messagesize = i11;
        int log = getLog((i11 << i10) + 1);
        this.checksumsize = log;
        int i12 = this.messagesize + (((log + i10) - 1) / i10);
        this.keysize = i12;
        this.privateKeyOTS = new byte[i12][];
        int i13 = this.mdsize;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, 0, i13);
        for (int i14 = 0; i14 < this.keysize; i14++) {
            this.privateKeyOTS[i14] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    private void hashPrivateKeyBlock(int i10, int i11, byte[] bArr, int i12) {
        if (i11 < 1) {
            System.arraycopy(this.privateKeyOTS[i10], 0, bArr, i12, this.mdsize);
            return;
        }
        this.messDigestOTS.update(this.privateKeyOTS[i10], 0, this.mdsize);
        while (true) {
            this.messDigestOTS.doFinal(bArr, i12);
            i11--;
            if (i11 > 0) {
                this.messDigestOTS.update(bArr, i12, this.mdsize);
            } else {
                return;
            }
        }
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

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i10 = this.keysize * this.mdsize;
        byte[] bArr = new byte[i10];
        int i11 = (1 << this.f23990w) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < this.keysize; i13++) {
            hashPrivateKeyBlock(i13, i11, bArr, i12);
            i12 += this.mdsize;
        }
        this.messDigestOTS.update(bArr, 0, i10);
        byte[] bArr2 = new byte[this.mdsize];
        this.messDigestOTS.doFinal(bArr2, 0);
        return bArr2;
    }

    public byte[] getSignature(byte[] bArr) {
        int i10;
        byte[] bArr2 = bArr;
        int i11 = this.keysize;
        int i12 = this.mdsize;
        byte[] bArr3 = new byte[(i11 * i12)];
        byte[] bArr4 = new byte[i12];
        int i13 = 0;
        this.messDigestOTS.update(bArr2, 0, bArr2.length);
        this.messDigestOTS.doFinal(bArr4, 0);
        int i14 = this.f23990w;
        int i15 = 8;
        if (8 % i14 == 0) {
            int i16 = 8 / i14;
            int i17 = (1 << i14) - 1;
            int i18 = 0;
            int i19 = 0;
            for (int i20 = 0; i20 < i12; i20++) {
                for (int i21 = 0; i21 < i16; i21++) {
                    byte b10 = bArr4[i20] & i17;
                    i18 += b10;
                    hashPrivateKeyBlock(i19, b10, bArr3, this.mdsize * i19);
                    bArr4[i20] = (byte) (bArr4[i20] >>> this.f23990w);
                    i19++;
                }
            }
            int i22 = (this.messagesize << this.f23990w) - i18;
            while (i13 < this.checksumsize) {
                hashPrivateKeyBlock(i19, i22 & i17, bArr3, this.mdsize * i19);
                int i23 = this.f23990w;
                i22 >>>= i23;
                i19++;
                i13 += i23;
            }
        } else if (i14 < 8) {
            int i24 = this.mdsize / i14;
            int i25 = (1 << i14) - 1;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            while (i26 < i24) {
                long j10 = 0;
                for (int i30 = 0; i30 < this.f23990w; i30++) {
                    j10 ^= (long) ((bArr4[i27] & 255) << (i30 << 3));
                    i27++;
                }
                int i31 = 0;
                long j11 = j10;
                while (i31 < i15) {
                    int i32 = ((int) j11) & i25;
                    i29 += i32;
                    hashPrivateKeyBlock(i28, i32, bArr3, this.mdsize * i28);
                    j11 >>>= this.f23990w;
                    i28++;
                    i31++;
                    i15 = 8;
                }
                i26++;
                i15 = 8;
            }
            int i33 = this.mdsize % this.f23990w;
            long j12 = 0;
            for (int i34 = 0; i34 < i33; i34++) {
                j12 ^= (long) ((bArr4[i27] & 255) << (i34 << 3));
                i27++;
            }
            int i35 = i33 << 3;
            int i36 = 0;
            while (i36 < i35) {
                int i37 = ((int) j12) & i25;
                i29 += i37;
                hashPrivateKeyBlock(i28, i37, bArr3, this.mdsize * i28);
                int i38 = this.f23990w;
                j12 >>>= i38;
                i28++;
                i36 += i38;
            }
            int i39 = (this.messagesize << this.f23990w) - i29;
            while (i13 < this.checksumsize) {
                hashPrivateKeyBlock(i28, i39 & i25, bArr3, this.mdsize * i28);
                int i40 = this.f23990w;
                i39 >>>= i40;
                i28++;
                i13 += i40;
            }
        } else if (i14 < 57) {
            int i41 = this.mdsize;
            int i42 = (i41 << 3) - i14;
            int i43 = (1 << i14) - 1;
            byte[] bArr5 = new byte[i41];
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            while (i44 <= i42) {
                int i47 = i44 >>> 3;
                int i48 = i44 % 8;
                i44 += this.f23990w;
                int i49 = (i44 + 7) >>> 3;
                int i50 = i13;
                long j13 = 0;
                while (i47 < i49) {
                    j13 ^= (long) ((bArr4[i47] & 255) << (i50 << 3));
                    i50++;
                    i47++;
                    bArr4 = bArr4;
                    i42 = i42;
                }
                byte[] bArr6 = bArr4;
                int i51 = i42;
                long j14 = (j13 >>> i48) & ((long) i43);
                i46 = (int) (((long) i46) + j14);
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr5, 0, this.mdsize);
                while (j14 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i41);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j14--;
                }
                int i52 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i45 * i52, i52);
                i45++;
                bArr4 = bArr6;
                i42 = i51;
                i13 = 0;
            }
            byte[] bArr7 = bArr4;
            int i53 = i44 >>> 3;
            if (i53 < this.mdsize) {
                int i54 = i44 % 8;
                int i55 = 0;
                long j15 = 0;
                while (true) {
                    i10 = this.mdsize;
                    if (i53 >= i10) {
                        break;
                    }
                    j15 ^= (long) ((bArr7[i53] & 255) << (i55 << 3));
                    i55++;
                    i53++;
                }
                long j16 = (j15 >>> i54) & ((long) i43);
                i46 = (int) (((long) i46) + j16);
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr5, 0, i10);
                while (j16 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i41);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j16--;
                }
                int i56 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i45 * i56, i56);
                i45++;
            }
            int i57 = (this.messagesize << this.f23990w) - i46;
            int i58 = 0;
            while (i58 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr5, 0, this.mdsize);
                for (long j17 = (long) (i57 & i43); j17 > 0; j17--) {
                    this.messDigestOTS.update(bArr5, 0, i41);
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i59 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i45 * i59, i59);
                int i60 = this.f23990w;
                i57 >>>= i60;
                i45++;
                i58 += i60;
            }
        }
        return bArr3;
    }
}
