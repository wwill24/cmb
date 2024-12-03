package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

public class Layer {
    private short[][][] coeff_alpha;
    private short[][][] coeff_beta;
    private short[] coeff_eta;
    private short[][] coeff_gamma;

    /* renamed from: oi  reason: collision with root package name */
    private int f24041oi;

    /* renamed from: vi  reason: collision with root package name */
    private int f24042vi;
    private int viNext;

    public Layer(byte b10, byte b11, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        byte b12 = b10 & 255;
        this.f24042vi = b12;
        byte b13 = b11 & 255;
        this.viNext = b13;
        this.f24041oi = b13 - b12;
        this.coeff_alpha = sArr;
        this.coeff_beta = sArr2;
        this.coeff_gamma = sArr3;
        this.coeff_eta = sArr4;
    }

    public Layer(int i10, int i11, SecureRandom secureRandom) {
        this.f24042vi = i10;
        this.viNext = i11;
        int i12 = i11 - i10;
        this.f24041oi = i12;
        int[] iArr = new int[3];
        iArr[2] = i10;
        iArr[1] = i12;
        iArr[0] = i12;
        this.coeff_alpha = (short[][][]) Array.newInstance(Short.TYPE, iArr);
        int i13 = this.f24041oi;
        int i14 = this.f24042vi;
        int[] iArr2 = new int[3];
        iArr2[2] = i14;
        iArr2[1] = i14;
        iArr2[0] = i13;
        this.coeff_beta = (short[][][]) Array.newInstance(Short.TYPE, iArr2);
        int i15 = this.f24041oi;
        int[] iArr3 = new int[2];
        iArr3[1] = this.viNext;
        iArr3[0] = i15;
        this.coeff_gamma = (short[][]) Array.newInstance(Short.TYPE, iArr3);
        int i16 = this.f24041oi;
        this.coeff_eta = new short[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            for (int i18 = 0; i18 < this.f24041oi; i18++) {
                for (int i19 = 0; i19 < this.f24042vi; i19++) {
                    this.coeff_alpha[i17][i18][i19] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i20 = 0; i20 < i16; i20++) {
            for (int i21 = 0; i21 < this.f24042vi; i21++) {
                for (int i22 = 0; i22 < this.f24042vi; i22++) {
                    this.coeff_beta[i20][i21][i22] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i23 = 0; i23 < i16; i23++) {
            for (int i24 = 0; i24 < this.viNext; i24++) {
                this.coeff_gamma[i23][i24] = (short) (secureRandom.nextInt() & 255);
            }
        }
        for (int i25 = 0; i25 < i16; i25++) {
            this.coeff_eta[i25] = (short) (secureRandom.nextInt() & 255);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer) obj;
        return this.f24042vi == layer.getVi() && this.viNext == layer.getViNext() && this.f24041oi == layer.getOi() && RainbowUtil.equals(this.coeff_alpha, layer.getCoeffAlpha()) && RainbowUtil.equals(this.coeff_beta, layer.getCoeffBeta()) && RainbowUtil.equals(this.coeff_gamma, layer.getCoeffGamma()) && RainbowUtil.equals(this.coeff_eta, layer.getCoeffEta());
    }

    public short[][][] getCoeffAlpha() {
        return this.coeff_alpha;
    }

    public short[][][] getCoeffBeta() {
        return this.coeff_beta;
    }

    public short[] getCoeffEta() {
        return this.coeff_eta;
    }

    public short[][] getCoeffGamma() {
        return this.coeff_gamma;
    }

    public int getOi() {
        return this.f24041oi;
    }

    public int getVi() {
        return this.f24042vi;
    }

    public int getViNext() {
        return this.viNext;
    }

    public int hashCode() {
        return (((((((((((this.f24042vi * 37) + this.viNext) * 37) + this.f24041oi) * 37) + Arrays.hashCode(this.coeff_alpha)) * 37) + Arrays.hashCode(this.coeff_beta)) * 37) + Arrays.hashCode(this.coeff_gamma)) * 37) + Arrays.hashCode(this.coeff_eta);
    }

    public short[][] plugInVinegars(short[] sArr) {
        int i10 = this.f24041oi;
        int[] iArr = new int[2];
        iArr[1] = i10 + 1;
        int i11 = 0;
        iArr[0] = i10;
        short[][] sArr2 = (short[][]) Array.newInstance(Short.TYPE, iArr);
        short[] sArr3 = new short[this.f24041oi];
        for (int i12 = 0; i12 < this.f24041oi; i12++) {
            for (int i13 = 0; i13 < this.f24042vi; i13++) {
                for (int i14 = 0; i14 < this.f24042vi; i14++) {
                    sArr3[i12] = GF2Field.addElem(sArr3[i12], GF2Field.multElem(GF2Field.multElem(this.coeff_beta[i12][i13][i14], sArr[i13]), sArr[i14]));
                }
            }
        }
        for (int i15 = 0; i15 < this.f24041oi; i15++) {
            for (int i16 = 0; i16 < this.f24041oi; i16++) {
                for (int i17 = 0; i17 < this.f24042vi; i17++) {
                    short multElem = GF2Field.multElem(this.coeff_alpha[i15][i16][i17], sArr[i17]);
                    short[] sArr4 = sArr2[i15];
                    sArr4[i16] = GF2Field.addElem(sArr4[i16], multElem);
                }
            }
        }
        for (int i18 = 0; i18 < this.f24041oi; i18++) {
            for (int i19 = 0; i19 < this.f24042vi; i19++) {
                sArr3[i18] = GF2Field.addElem(sArr3[i18], GF2Field.multElem(this.coeff_gamma[i18][i19], sArr[i19]));
            }
        }
        for (int i20 = 0; i20 < this.f24041oi; i20++) {
            for (int i21 = this.f24042vi; i21 < this.viNext; i21++) {
                short[] sArr5 = sArr2[i20];
                int i22 = this.f24042vi;
                sArr5[i21 - i22] = GF2Field.addElem(this.coeff_gamma[i20][i21], sArr5[i21 - i22]);
            }
        }
        for (int i23 = 0; i23 < this.f24041oi; i23++) {
            sArr3[i23] = GF2Field.addElem(sArr3[i23], this.coeff_eta[i23]);
        }
        while (true) {
            int i24 = this.f24041oi;
            if (i11 >= i24) {
                return sArr2;
            }
            sArr2[i11][i24] = sArr3[i11];
            i11++;
        }
    }
}
