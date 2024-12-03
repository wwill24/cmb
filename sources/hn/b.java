package hn;

import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.curve.EllipticCurve;

public class b extends a {
    b(EllipticCurve ellipticCurve) {
        super(ellipticCurve);
    }

    public static b c(EllipticCurve ellipticCurve) {
        return new b(ellipticCurve);
    }

    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ECDSA;
    }

    public String getName() {
        return "ECDSA";
    }
}
