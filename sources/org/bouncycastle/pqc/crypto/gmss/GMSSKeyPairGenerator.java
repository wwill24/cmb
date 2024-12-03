package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    private int[] K;
    private byte[][] currentRootSigs;
    private byte[][] currentSeeds;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSKeyGenerationParameters gmssParams;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private boolean initialized = false;
    private int mdLength;
    private Digest messDigestTree;
    private byte[][] nextNextSeeds;
    private int numLayer;
    private int[] otsIndex;

    public GMSSKeyPairGenerator(GMSSDigestProvider gMSSDigestProvider) {
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        this.mdLength = digest.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTree);
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        int i10;
        int i11;
        if (!this.initialized) {
            initializeDefault();
        }
        int i12 = this.numLayer;
        byte[][][] bArr = new byte[i12][][];
        byte[][][] bArr2 = new byte[(i12 - 1)][][];
        Treehash[][] treehashArr = new Treehash[i12][];
        Treehash[][] treehashArr2 = new Treehash[(i12 - 1)][];
        Vector[] vectorArr = new Vector[i12];
        Vector[] vectorArr2 = new Vector[(i12 - 1)];
        Vector[][] vectorArr3 = new Vector[i12][];
        int i13 = 1;
        Vector[][] vectorArr4 = new Vector[(i12 - 1)][];
        int i14 = 0;
        while (true) {
            i10 = this.numLayer;
            if (i14 >= i10) {
                break;
            }
            int i15 = this.heightOfTrees[i14];
            int[] iArr = new int[2];
            iArr[1] = this.mdLength;
            iArr[0] = i15;
            bArr[i14] = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
            int i16 = this.heightOfTrees[i14];
            treehashArr[i14] = new Treehash[(i16 - this.K[i14])];
            if (i14 > 0) {
                int i17 = i14 - 1;
                int[] iArr2 = new int[2];
                iArr2[1] = this.mdLength;
                iArr2[0] = i16;
                bArr2[i17] = (byte[][]) Array.newInstance(Byte.TYPE, iArr2);
                treehashArr2[i17] = new Treehash[(this.heightOfTrees[i14] - this.K[i14])];
            }
            vectorArr[i14] = new Vector();
            if (i14 > 0) {
                vectorArr2[i14 - 1] = new Vector();
            }
            i14++;
        }
        int[] iArr3 = new int[2];
        iArr3[1] = this.mdLength;
        iArr3[0] = i10;
        byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, iArr3);
        int[] iArr4 = new int[2];
        iArr4[1] = this.mdLength;
        iArr4[0] = this.numLayer - 1;
        int i18 = this.numLayer;
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = this.mdLength;
        iArr5[0] = i18;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, iArr5);
        int i19 = 0;
        while (true) {
            i11 = this.numLayer;
            if (i19 >= i11) {
                break;
            }
            System.arraycopy(this.currentSeeds[i19], 0, bArr5[i19], 0, this.mdLength);
            i19++;
            i13 = 1;
        }
        Treehash[][] treehashArr3 = treehashArr2;
        int[] iArr6 = new int[2];
        iArr6[i13] = this.mdLength;
        iArr6[0] = i11 - i13;
        this.currentRootSigs = (byte[][]) Array.newInstance(Byte.TYPE, iArr6);
        int i20 = this.numLayer - i13;
        while (i20 >= 0) {
            GMSSRootCalc generateCurrentAuthpathAndRoot = i20 == this.numLayer - i13 ? generateCurrentAuthpathAndRoot((byte[]) null, vectorArr[i20], bArr5[i20], i20) : generateCurrentAuthpathAndRoot(bArr3[i20 + 1], vectorArr[i20], bArr5[i20], i20);
            int i21 = 0;
            while (i21 < this.heightOfTrees[i20]) {
                System.arraycopy(generateCurrentAuthpathAndRoot.getAuthPath()[i21], 0, bArr[i20][i21], 0, this.mdLength);
                i21++;
                vectorArr = vectorArr;
            }
            vectorArr3[i20] = generateCurrentAuthpathAndRoot.getRetain();
            treehashArr[i20] = generateCurrentAuthpathAndRoot.getTreehash();
            System.arraycopy(generateCurrentAuthpathAndRoot.getRoot(), 0, bArr3[i20], 0, this.mdLength);
            i20--;
            vectorArr = vectorArr;
            i13 = 1;
        }
        Vector[] vectorArr5 = vectorArr;
        int i22 = this.numLayer - 2;
        while (i22 >= 0) {
            int i23 = i22 + 1;
            GMSSRootCalc generateNextAuthpathAndRoot = generateNextAuthpathAndRoot(vectorArr2[i22], bArr5[i23], i23);
            int i24 = 0;
            while (i24 < this.heightOfTrees[i23]) {
                System.arraycopy(generateNextAuthpathAndRoot.getAuthPath()[i24], 0, bArr2[i22][i24], 0, this.mdLength);
                i24++;
                vectorArr3 = vectorArr3;
            }
            vectorArr4[i22] = generateNextAuthpathAndRoot.getRetain();
            treehashArr3[i22] = generateNextAuthpathAndRoot.getTreehash();
            System.arraycopy(generateNextAuthpathAndRoot.getRoot(), 0, bArr4[i22], 0, this.mdLength);
            System.arraycopy(bArr5[i23], 0, this.nextNextSeeds[i22], 0, this.mdLength);
            i22--;
            vectorArr3 = vectorArr3;
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GMSSPublicKeyParameters(bArr3[0], this.gmssPS), (AsymmetricKeyParameter) new GMSSPrivateKeyParameters(this.currentSeeds, this.nextNextSeeds, bArr, bArr2, treehashArr, treehashArr3, vectorArr5, vectorArr2, vectorArr3, vectorArr4, bArr4, this.currentRootSigs, this.gmssPS, this.digestProvider));
    }

    private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] bArr, Vector vector, byte[] bArr2, int i10) {
        byte[] bArr3;
        int i11 = this.mdLength;
        byte[] bArr4 = new byte[i11];
        byte[] bArr5 = new byte[i11];
        byte[] nextSeed = this.gmssRandom.nextSeed(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i10], this.K[i10], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        if (i10 == this.numLayer - 1) {
            bArr3 = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i10]).getPublicKey();
        } else {
            this.currentRootSigs[i10] = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i10]).getSignature(bArr);
            bArr3 = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[i10]).Verify(bArr, this.currentRootSigs[i10]);
        }
        gMSSRootCalc.update(bArr3);
        int i12 = 3;
        int i13 = 0;
        int i14 = 1;
        while (true) {
            int i15 = this.heightOfTrees[i10];
            if (i14 >= (1 << i15)) {
                break;
            }
            if (i14 == i12 && i13 < i15 - this.K[i10]) {
                gMSSRootCalc.initializeTreehashSeed(bArr2, i13);
                i12 *= 2;
                i13++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr2), this.digestProvider.get(), this.otsIndex[i10]).getPublicKey());
            i14++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private GMSSRootCalc generateNextAuthpathAndRoot(Vector vector, byte[] bArr, int i10) {
        byte[] bArr2 = new byte[this.numLayer];
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i10], this.K[i10], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        int i11 = 0;
        int i12 = 3;
        int i13 = 0;
        while (true) {
            int i14 = this.heightOfTrees[i10];
            if (i11 >= (1 << i14)) {
                break;
            }
            if (i11 == i12 && i13 < i14 - this.K[i10]) {
                gMSSRootCalc.initializeTreehashSeed(bArr, i13);
                i12 *= 2;
                i13++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr), this.digestProvider.get(), this.otsIndex[i10]).getPublicKey());
            i11++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private void initializeDefault() {
        initialize(new GMSSKeyGenerationParameters((SecureRandom) null, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(int i10, SecureRandom secureRandom) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters;
        if (i10 <= 10) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else {
            gMSSKeyGenerationParameters = i10 <= 20 ? new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2})) : new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        }
        initialize(gMSSKeyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters = (GMSSKeyGenerationParameters) keyGenerationParameters;
        this.gmssParams = gMSSKeyGenerationParameters;
        GMSSParameters gMSSParameters = new GMSSParameters(gMSSKeyGenerationParameters.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
        this.gmssPS = gMSSParameters;
        this.numLayer = gMSSParameters.getNumOfLayers();
        this.heightOfTrees = this.gmssPS.getHeightOfTrees();
        this.otsIndex = this.gmssPS.getWinternitzParameter();
        this.K = this.gmssPS.getK();
        int i10 = this.numLayer;
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i10;
        this.currentSeeds = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = this.mdLength;
        iArr2[0] = this.numLayer - 1;
        this.nextNextSeeds = (byte[][]) Array.newInstance(Byte.TYPE, iArr2);
        SecureRandom random = keyGenerationParameters.getRandom();
        for (int i11 = 0; i11 < this.numLayer; i11++) {
            random.nextBytes(this.currentSeeds[i11]);
            this.gmssRandom.nextSeed(this.currentSeeds[i11]);
        }
        this.initialized = true;
    }
}
