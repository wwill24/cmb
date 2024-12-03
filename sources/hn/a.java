package hn;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.pgpainless.algorithm.PublicKeyAlgorithm;
import org.pgpainless.key.generation.type.curve.EllipticCurve;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final EllipticCurve f40925a;

    a(EllipticCurve ellipticCurve) {
        this.f40925a = ellipticCurve;
    }

    public static a b(EllipticCurve ellipticCurve) {
        return new a(ellipticCurve);
    }

    public AlgorithmParameterSpec a() {
        return new ECNamedCurveGenParameterSpec(this.f40925a.getName());
    }

    public PublicKeyAlgorithm getAlgorithm() {
        return PublicKeyAlgorithm.ECDH;
    }

    public String getName() {
        return "ECDH";
    }
}
