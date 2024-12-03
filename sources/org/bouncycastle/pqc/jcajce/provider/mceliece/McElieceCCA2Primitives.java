package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

public final class McElieceCCA2Primitives {
    private McElieceCCA2Primitives() {
    }

    public static GF2Vector[] decryptionPrimitive(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters, GF2Vector gF2Vector) {
        int k10 = mcElieceCCA2PrivateKeyParameters.getK();
        Permutation p10 = mcElieceCCA2PrivateKeyParameters.getP();
        GF2mField field = mcElieceCCA2PrivateKeyParameters.getField();
        PolynomialGF2mSmallM goppaPoly = mcElieceCCA2PrivateKeyParameters.getGoppaPoly();
        GF2Matrix h10 = mcElieceCCA2PrivateKeyParameters.getH();
        PolynomialGF2mSmallM[] qInv = mcElieceCCA2PrivateKeyParameters.getQInv();
        GF2Vector gF2Vector2 = (GF2Vector) gF2Vector.multiply(p10.computeInverse());
        GF2Vector syndromeDecode = GoppaCode.syndromeDecode((GF2Vector) h10.rightMultiply((Vector) gF2Vector2), field, goppaPoly, qInv);
        return new GF2Vector[]{((GF2Vector) ((GF2Vector) gF2Vector2.add(syndromeDecode)).multiply(p10)).extractRightVector(k10), (GF2Vector) syndromeDecode.multiply(p10)};
    }

    public static GF2Vector[] decryptionPrimitive(BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey, GF2Vector gF2Vector) {
        int k10 = bCMcElieceCCA2PrivateKey.getK();
        Permutation p10 = bCMcElieceCCA2PrivateKey.getP();
        GF2mField field = bCMcElieceCCA2PrivateKey.getField();
        PolynomialGF2mSmallM goppaPoly = bCMcElieceCCA2PrivateKey.getGoppaPoly();
        GF2Matrix h10 = bCMcElieceCCA2PrivateKey.getH();
        PolynomialGF2mSmallM[] qInv = bCMcElieceCCA2PrivateKey.getQInv();
        GF2Vector gF2Vector2 = (GF2Vector) gF2Vector.multiply(p10.computeInverse());
        GF2Vector syndromeDecode = GoppaCode.syndromeDecode((GF2Vector) h10.rightMultiply((Vector) gF2Vector2), field, goppaPoly, qInv);
        return new GF2Vector[]{((GF2Vector) ((GF2Vector) gF2Vector2.add(syndromeDecode)).multiply(p10)).extractRightVector(k10), (GF2Vector) syndromeDecode.multiply(p10)};
    }

    public static GF2Vector encryptionPrimitive(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters, GF2Vector gF2Vector, GF2Vector gF2Vector2) {
        return (GF2Vector) mcElieceCCA2PublicKeyParameters.getG().leftMultiplyLeftCompactForm(gF2Vector).add(gF2Vector2);
    }

    public static GF2Vector encryptionPrimitive(BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey, GF2Vector gF2Vector, GF2Vector gF2Vector2) {
        return (GF2Vector) bCMcElieceCCA2PublicKey.getG().leftMultiplyLeftCompactForm(gF2Vector).add(gF2Vector2);
    }
}
