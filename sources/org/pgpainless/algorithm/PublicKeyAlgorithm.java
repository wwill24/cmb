package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum PublicKeyAlgorithm {
    RSA_GENERAL(1),
    RSA_ENCRYPT(2),
    RSA_SIGN(3),
    ELGAMAL_ENCRYPT(16),
    DSA(17),
    EC(18),
    ECDH(18),
    ECDSA(19),
    ELGAMAL_GENERAL(20),
    DIFFIE_HELLMAN(21);
    

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Integer, PublicKeyAlgorithm> f41762l = null;
    private final int algorithmId;

    static {
        int i10;
        f41762l = new ConcurrentHashMap();
        for (PublicKeyAlgorithm publicKeyAlgorithm : values()) {
            f41762l.put(Integer.valueOf(publicKeyAlgorithm.algorithmId), publicKeyAlgorithm);
        }
    }

    private PublicKeyAlgorithm(int i10) {
        this.algorithmId = i10;
    }

    public int a() {
        return this.algorithmId;
    }
}
