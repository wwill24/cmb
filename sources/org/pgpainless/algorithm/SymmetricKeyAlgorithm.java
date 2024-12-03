package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum SymmetricKeyAlgorithm {
    NULL(0),
    IDEA(1),
    TRIPLE_DES(2),
    CAST5(3),
    BLOWFISH(4),
    SAFER(5),
    DES(6),
    AES_128(7),
    AES_192(8),
    AES_256(9),
    TWOFISH(10),
    CAMELLIA_128(11),
    CAMELLIA_192(12),
    CAMELLIA_256(13);
    

    /* renamed from: q  reason: collision with root package name */
    private static final Map<Integer, SymmetricKeyAlgorithm> f41778q = null;
    private final int algorithmId;

    static {
        f41778q = new ConcurrentHashMap();
        for (SymmetricKeyAlgorithm symmetricKeyAlgorithm : values()) {
            f41778q.put(Integer.valueOf(symmetricKeyAlgorithm.algorithmId), symmetricKeyAlgorithm);
        }
    }

    private SymmetricKeyAlgorithm(int i10) {
        this.algorithmId = i10;
    }

    public static SymmetricKeyAlgorithm a(int i10) {
        return f41778q.get(Integer.valueOf(i10));
    }

    public int b() {
        return this.algorithmId;
    }
}
