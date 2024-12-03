package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum HashAlgorithm {
    f41731a(1),
    SHA1(2),
    RIPEMD160(3),
    DOUBLE_SHA(4),
    MD2(5),
    TIGER_192(6),
    HAVAL_5_160(7),
    SHA256(8),
    SHA384(9),
    SHA512(10),
    SHA224(11);
    

    /* renamed from: m  reason: collision with root package name */
    private static final Map<Integer, HashAlgorithm> f41742m = null;
    private final int algorithmId;

    static {
        int i10;
        f41742m = new ConcurrentHashMap();
        for (HashAlgorithm hashAlgorithm : values()) {
            f41742m.put(Integer.valueOf(hashAlgorithm.algorithmId), hashAlgorithm);
        }
    }

    private HashAlgorithm(int i10) {
        this.algorithmId = i10;
    }

    public int a() {
        return this.algorithmId;
    }
}
