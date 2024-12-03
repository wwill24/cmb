package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class GMSSLeaf {
    private byte[] concHashs;
    private GMSSRandom gmssRandom;

    /* renamed from: i  reason: collision with root package name */
    private int f23982i;

    /* renamed from: j  reason: collision with root package name */
    private int f23983j;
    private int keysize;
    private byte[] leaf;
    private int mdsize;
    private Digest messDigestOTS;
    byte[] privateKeyOTS;
    private byte[] seed;
    private int steps;
    private int two_power_w;

    /* renamed from: w  reason: collision with root package name */
    private int f23984w;

    GMSSLeaf(Digest digest, int i10, int i11) {
        this.f23984w = i10;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        double d10 = (double) i10;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d10);
        int ceil2 = ceil + ((int) Math.ceil(((double) getLog((ceil << i10) + 1)) / d10));
        this.keysize = ceil2;
        int i12 = 1 << i10;
        this.two_power_w = i12;
        this.steps = (int) Math.ceil(((double) ((((i12 - 1) * ceil2) + 1) + ceil2)) / ((double) i11));
        int i13 = this.mdsize;
        this.seed = new byte[i13];
        this.leaf = new byte[i13];
        this.privateKeyOTS = new byte[i13];
        this.concHashs = new byte[(i13 * this.keysize)];
    }

    public GMSSLeaf(Digest digest, int i10, int i11, byte[] bArr) {
        this.f23984w = i10;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        double d10 = (double) i10;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d10);
        int ceil2 = ceil + ((int) Math.ceil(((double) getLog((ceil << i10) + 1)) / d10));
        this.keysize = ceil2;
        int i12 = 1 << i10;
        this.two_power_w = i12;
        this.steps = (int) Math.ceil(((double) ((((i12 - 1) * ceil2) + 1) + ceil2)) / ((double) i11));
        int i13 = this.mdsize;
        this.seed = new byte[i13];
        this.leaf = new byte[i13];
        this.privateKeyOTS = new byte[i13];
        this.concHashs = new byte[(i13 * this.keysize)];
        initLeafCalc(bArr);
    }

    public GMSSLeaf(Digest digest, byte[][] bArr, int[] iArr) {
        this.f23982i = iArr[0];
        this.f23983j = iArr[1];
        this.steps = iArr[2];
        this.f23984w = iArr[3];
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / ((double) this.f23984w));
        this.keysize = ceil + ((int) Math.ceil(((double) getLog((ceil << this.f23984w) + 1)) / ((double) this.f23984w)));
        this.two_power_w = 1 << this.f23984w;
        this.privateKeyOTS = bArr[0];
        this.seed = bArr[1];
        this.concHashs = bArr[2];
        this.leaf = bArr[3];
    }

    private GMSSLeaf(GMSSLeaf gMSSLeaf) {
        this.messDigestOTS = gMSSLeaf.messDigestOTS;
        this.mdsize = gMSSLeaf.mdsize;
        this.keysize = gMSSLeaf.keysize;
        this.gmssRandom = gMSSLeaf.gmssRandom;
        this.leaf = Arrays.clone(gMSSLeaf.leaf);
        this.concHashs = Arrays.clone(gMSSLeaf.concHashs);
        this.f23982i = gMSSLeaf.f23982i;
        this.f23983j = gMSSLeaf.f23983j;
        this.two_power_w = gMSSLeaf.two_power_w;
        this.f23984w = gMSSLeaf.f23984w;
        this.steps = gMSSLeaf.steps;
        this.seed = Arrays.clone(gMSSLeaf.seed);
        this.privateKeyOTS = Arrays.clone(gMSSLeaf.privateKeyOTS);
    }

    private int getLog(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    private void updateLeafCalc() {
        byte[] bArr = new byte[this.messDigestOTS.getDigestSize()];
        for (int i10 = 0; i10 < this.steps + 10000; i10++) {
            int i11 = this.f23982i;
            if (i11 == this.keysize && this.f23983j == this.two_power_w - 1) {
                Digest digest = this.messDigestOTS;
                byte[] bArr2 = this.concHashs;
                digest.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.messDigestOTS.getDigestSize()];
                this.leaf = bArr3;
                this.messDigestOTS.doFinal(bArr3, 0);
                return;
            }
            if (i11 == 0 || this.f23983j == this.two_power_w - 1) {
                this.f23982i = i11 + 1;
                this.f23983j = 0;
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            } else {
                Digest digest2 = this.messDigestOTS;
                byte[] bArr4 = this.privateKeyOTS;
                digest2.update(bArr4, 0, bArr4.length);
                this.privateKeyOTS = bArr;
                this.messDigestOTS.doFinal(bArr, 0);
                int i12 = this.f23983j + 1;
                this.f23983j = i12;
                if (i12 == this.two_power_w - 1) {
                    byte[] bArr5 = this.privateKeyOTS;
                    byte[] bArr6 = this.concHashs;
                    int i13 = this.mdsize;
                    System.arraycopy(bArr5, 0, bArr6, (this.f23982i - 1) * i13, i13);
                }
            }
        }
        throw new IllegalStateException("unable to updateLeaf in steps: " + this.steps + " " + this.f23982i + " " + this.f23983j);
    }

    public byte[] getLeaf() {
        return Arrays.clone(this.leaf);
    }

    public byte[][] getStatByte() {
        return new byte[][]{this.privateKeyOTS, this.seed, this.concHashs, this.leaf};
    }

    public int[] getStatInt() {
        return new int[]{this.f23982i, this.f23983j, this.steps, this.f23984w};
    }

    /* access modifiers changed from: package-private */
    public void initLeafCalc(byte[] bArr) {
        this.f23982i = 0;
        this.f23983j = 0;
        byte[] bArr2 = new byte[this.mdsize];
        System.arraycopy(bArr, 0, bArr2, 0, this.seed.length);
        this.seed = this.gmssRandom.nextSeed(bArr2);
    }

    /* access modifiers changed from: package-private */
    public GMSSLeaf nextLeaf() {
        GMSSLeaf gMSSLeaf = new GMSSLeaf(this);
        gMSSLeaf.updateLeafCalc();
        return gMSSLeaf;
    }

    public String toString() {
        StringBuilder sb2;
        String str = "";
        for (int i10 = 0; i10 < 4; i10++) {
            str = str + getStatInt()[i10] + " ";
        }
        String str2 = str + " " + this.mdsize + " " + this.keysize + " " + this.two_power_w + " ";
        byte[][] statByte = getStatByte();
        for (int i11 = 0; i11 < 4; i11++) {
            if (statByte[i11] != null) {
                sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(new String(Hex.encode(statByte[i11])));
                sb2.append(" ");
            } else {
                sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("null ");
            }
            str2 = sb2.toString();
        }
        return str2;
    }
}
