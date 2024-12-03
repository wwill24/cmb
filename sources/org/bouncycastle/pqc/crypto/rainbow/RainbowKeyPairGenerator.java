package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;

    /* renamed from: b1  reason: collision with root package name */
    private short[] f24043b1;

    /* renamed from: b2  reason: collision with root package name */
    private short[] f24044b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;
    private SecureRandom sr;

    /* renamed from: vi  reason: collision with root package name */
    private int[] f24045vi;

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = ((length2 + 1) * length2) / 2;
        iArr[0] = length;
        this.pub_quadratic = (short[][]) Array.newInstance(Short.TYPE, iArr);
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < length2; i12++) {
                for (int i13 = i12; i13 < length2; i13++) {
                    short[][] sArr2 = this.pub_quadratic;
                    if (i13 == i12) {
                        sArr2[i10][i11] = sArr[i10][i12][i13];
                    } else {
                        short[] sArr3 = sArr2[i10];
                        short[][] sArr4 = sArr[i10];
                        sArr3[i11] = GF2Field.addElem(sArr4[i12][i13], sArr4[i13][i12]);
                    }
                    i11++;
                }
            }
        }
    }

    private void computePublicKey() {
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.f24045vi;
        int i10 = 0;
        int i11 = iArr[iArr.length - 1] - iArr[0];
        int i12 = iArr[iArr.length - 1];
        int i13 = 3;
        int[] iArr2 = new int[3];
        iArr2[2] = i12;
        iArr2[1] = i12;
        iArr2[0] = i11;
        short[][][] sArr = (short[][][]) Array.newInstance(Short.TYPE, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = i12;
        iArr3[0] = i11;
        this.pub_singular = (short[][]) Array.newInstance(Short.TYPE, iArr3);
        this.pub_scalar = new short[i11];
        short[] sArr2 = new short[i12];
        int i14 = 0;
        int i15 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i14 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i14].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i14].getCoeffBeta();
            short[][] coeffGamma = this.layers[i14].getCoeffGamma();
            short[] coeffEta = this.layers[i14].getCoeffEta();
            int length = coeffAlpha[i10].length;
            int length2 = coeffBeta[i10].length;
            while (i10 < length) {
                for (int i16 = 0; i16 < length; i16++) {
                    int i17 = 0;
                    while (i17 < length2) {
                        int i18 = i11;
                        int i19 = i12;
                        int i20 = i16 + length2;
                        short[] multVect = computeInField.multVect(coeffAlpha[i10][i16][i17], this.A2[i20]);
                        int i21 = i15 + i10;
                        int i22 = i14;
                        sArr[i21] = computeInField.addSquareMatrix(sArr[i21], computeInField.multVects(multVect, this.A2[i17]));
                        short[] multVect2 = computeInField.multVect(this.f24044b2[i17], multVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i21] = computeInField.addVect(multVect2, sArr3[i21]);
                        short[] multVect3 = computeInField.multVect(this.f24044b2[i20], computeInField.multVect(coeffAlpha[i10][i16][i17], this.A2[i17]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i21] = computeInField.addVect(multVect3, sArr4[i21]);
                        short multElem = GF2Field.multElem(coeffAlpha[i10][i16][i17], this.f24044b2[i20]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i21] = GF2Field.addElem(sArr5[i21], GF2Field.multElem(multElem, this.f24044b2[i17]));
                        i17++;
                        i12 = i19;
                        i11 = i18;
                        coeffAlpha = coeffAlpha;
                        i14 = i22;
                        coeffEta = coeffEta;
                    }
                    int i23 = i12;
                    int i24 = i11;
                    int i25 = i14;
                    short[][][] sArr6 = coeffAlpha;
                    short[] sArr7 = coeffEta;
                }
                int i26 = i12;
                int i27 = i11;
                int i28 = i14;
                short[][][] sArr8 = coeffAlpha;
                short[] sArr9 = coeffEta;
                for (int i29 = 0; i29 < length2; i29++) {
                    for (int i30 = 0; i30 < length2; i30++) {
                        short[] multVect4 = computeInField.multVect(coeffBeta[i10][i29][i30], this.A2[i29]);
                        int i31 = i15 + i10;
                        sArr[i31] = computeInField.addSquareMatrix(sArr[i31], computeInField.multVects(multVect4, this.A2[i30]));
                        short[] multVect5 = computeInField.multVect(this.f24044b2[i30], multVect4);
                        short[][] sArr10 = this.pub_singular;
                        sArr10[i31] = computeInField.addVect(multVect5, sArr10[i31]);
                        short[] multVect6 = computeInField.multVect(this.f24044b2[i29], computeInField.multVect(coeffBeta[i10][i29][i30], this.A2[i30]));
                        short[][] sArr11 = this.pub_singular;
                        sArr11[i31] = computeInField.addVect(multVect6, sArr11[i31]);
                        short multElem2 = GF2Field.multElem(coeffBeta[i10][i29][i30], this.f24044b2[i29]);
                        short[] sArr12 = this.pub_scalar;
                        sArr12[i31] = GF2Field.addElem(sArr12[i31], GF2Field.multElem(multElem2, this.f24044b2[i30]));
                    }
                }
                for (int i32 = 0; i32 < length2 + length; i32++) {
                    short[] multVect7 = computeInField.multVect(coeffGamma[i10][i32], this.A2[i32]);
                    short[][] sArr13 = this.pub_singular;
                    int i33 = i15 + i10;
                    sArr13[i33] = computeInField.addVect(multVect7, sArr13[i33]);
                    short[] sArr14 = this.pub_scalar;
                    sArr14[i33] = GF2Field.addElem(sArr14[i33], GF2Field.multElem(coeffGamma[i10][i32], this.f24044b2[i32]));
                }
                short[] sArr15 = this.pub_scalar;
                int i34 = i15 + i10;
                sArr15[i34] = GF2Field.addElem(sArr15[i34], sArr9[i10]);
                i10++;
                i12 = i26;
                i11 = i27;
                coeffAlpha = sArr8;
                i14 = i28;
                coeffEta = sArr9;
            }
            int i35 = i12;
            int i36 = i11;
            i15 += length;
            i14++;
            i10 = 0;
            i13 = 3;
        }
        int i37 = i12;
        int i38 = i11;
        int[] iArr4 = new int[i13];
        iArr4[2] = i37;
        iArr4[1] = i37;
        iArr4[0] = i38;
        short[][][] sArr16 = (short[][][]) Array.newInstance(Short.TYPE, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = i37;
        iArr5[0] = i38;
        short[][] sArr17 = (short[][]) Array.newInstance(Short.TYPE, iArr5);
        int i39 = i38;
        short[] sArr18 = new short[i39];
        for (int i40 = 0; i40 < i39; i40++) {
            int i41 = 0;
            while (true) {
                short[][] sArr19 = this.A1;
                if (i41 >= sArr19.length) {
                    break;
                }
                sArr16[i40] = computeInField.addSquareMatrix(sArr16[i40], computeInField.multMatrix(sArr19[i40][i41], sArr[i41]));
                sArr17[i40] = computeInField.addVect(sArr17[i40], computeInField.multVect(this.A1[i40][i41], this.pub_singular[i41]));
                sArr18[i40] = GF2Field.addElem(sArr18[i40], GF2Field.multElem(this.A1[i40][i41], this.pub_scalar[i41]));
                i41++;
            }
            sArr18[i40] = GF2Field.addElem(sArr18[i40], this.f24043b1[i40]);
        }
        this.pub_singular = sArr17;
        this.pub_scalar = sArr18;
        compactPublicKey(sArr16);
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i10 = 0;
        while (i10 < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.f24045vi;
            int i11 = i10 + 1;
            layerArr[i10] = new Layer(iArr[i10], iArr[i11], this.sr);
            i10 = i11;
        }
    }

    private void generateL1() {
        int[] iArr = this.f24045vi;
        int i10 = iArr[iArr.length - 1] - iArr[0];
        int[] iArr2 = new int[2];
        iArr2[1] = i10;
        iArr2[0] = i10;
        this.A1 = (short[][]) Array.newInstance(Short.TYPE, iArr2);
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i10; i12++) {
                    this.A1[i11][i12] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.A1);
        }
        this.f24043b1 = new short[i10];
        for (int i13 = 0; i13 < i10; i13++) {
            this.f24043b1[i13] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int[] iArr = this.f24045vi;
        int i10 = iArr[iArr.length - 1];
        int[] iArr2 = new int[2];
        iArr2[1] = i10;
        iArr2[0] = i10;
        this.A2 = (short[][]) Array.newInstance(Short.TYPE, iArr2);
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A2inv == null) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i10; i12++) {
                    this.A2[i11][i12] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.A2);
        }
        this.f24044b2 = new short[i10];
        for (int i13 = 0; i13 < i10; i13++) {
            this.f24044b2[i13] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.f24043b1, this.A2inv, this.f24044b2, this.f24045vi, this.layers);
        int[] iArr = this.f24045vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.rainbowParams = rainbowKeyGenerationParameters;
        this.sr = rainbowKeyGenerationParameters.getRandom();
        this.f24045vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }
}
