package org.bouncycastle.pqc.math.linearalgebra;

import com.facebook.appevents.AppEventsConstants;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

public class GF2mField {
    private int degree = 0;
    private int polynomial;

    public GF2mField(int i10) {
        if (i10 >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        } else if (i10 >= 1) {
            this.degree = i10;
            this.polynomial = PolynomialRingGF2.getIrreduciblePolynomial(i10);
        } else {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
    }

    public GF2mField(int i10, int i11) {
        if (i10 != PolynomialRingGF2.degree(i11)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        } else if (PolynomialRingGF2.isIrreducible(i11)) {
            this.degree = i10;
            this.polynomial = i11;
        } else {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
    }

    public GF2mField(GF2mField gF2mField) {
        this.degree = gF2mField.degree;
        this.polynomial = gF2mField.polynomial;
    }

    public GF2mField(byte[] bArr) {
        if (bArr.length == 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr);
            this.polynomial = OS2IP;
            if (PolynomialRingGF2.isIrreducible(OS2IP)) {
                this.degree = PolynomialRingGF2.degree(this.polynomial);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String polyToString(int i10) {
        if (i10 == 0) {
            return "0";
        }
        String str = ((byte) (i10 & 1)) == 1 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "";
        int i11 = i10 >>> 1;
        int i12 = 1;
        while (i11 != 0) {
            if (((byte) (i11 & 1)) == 1) {
                str = str + "+x^" + i12;
            }
            i11 >>>= 1;
            i12++;
        }
        return str;
    }

    public int add(int i10, int i11) {
        return i10 ^ i11;
    }

    public String elementToStr(int i10) {
        String str;
        StringBuilder sb2;
        String str2 = "";
        for (int i11 = 0; i11 < this.degree; i11++) {
            if ((((byte) i10) & 1) == 0) {
                sb2 = new StringBuilder();
                str = "0";
            } else {
                sb2 = new StringBuilder();
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            sb2.append(str);
            sb2.append(str2);
            str2 = sb2.toString();
            i10 >>>= 1;
        }
        return str2;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GF2mField)) {
            GF2mField gF2mField = (GF2mField) obj;
            return this.degree == gF2mField.degree && this.polynomial == gF2mField.polynomial;
        }
    }

    public int exp(int i10, int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i11 < 0) {
            i10 = inverse(i10);
            i11 = -i11;
        }
        int i12 = 1;
        while (i11 != 0) {
            if ((i11 & 1) == 1) {
                i12 = mult(i12, i10);
            }
            i10 = mult(i10, i10);
            i11 >>>= 1;
        }
        return i12;
    }

    public int getDegree() {
        return this.degree;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.polynomial);
    }

    public int getPolynomial() {
        return this.polynomial;
    }

    public int getRandomElement(SecureRandom secureRandom) {
        return RandUtils.nextInt(secureRandom, 1 << this.degree);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(CryptoServicesRegistrar.getSecureRandom());
    }

    public int getRandomNonZeroElement(SecureRandom secureRandom) {
        int nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
        int i10 = 0;
        while (nextInt == 0 && i10 < 1048576) {
            nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
            i10++;
        }
        if (i10 == 1048576) {
            return 1;
        }
        return nextInt;
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int i10) {
        return exp(i10, (1 << this.degree) - 2);
    }

    public boolean isElementOfThisField(int i10) {
        int i11 = this.degree;
        return i11 == 31 ? i10 >= 0 : i10 >= 0 && i10 < (1 << i11);
    }

    public int mult(int i10, int i11) {
        return PolynomialRingGF2.modMultiply(i10, i11, this.polynomial);
    }

    public int sqRoot(int i10) {
        for (int i11 = 1; i11 < this.degree; i11++) {
            i10 = mult(i10, i10);
        }
        return i10;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.degree + ") = GF(2)[X]/<" + polyToString(this.polynomial) + "> ";
    }
}
