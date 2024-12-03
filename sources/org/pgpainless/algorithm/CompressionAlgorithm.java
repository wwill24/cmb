package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum CompressionAlgorithm {
    UNCOMPRESSED(0),
    ZIP(1),
    ZLIB(2),
    BZIP2(3);
    

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Integer, CompressionAlgorithm> f41729e = null;
    private final int algorithmId;

    static {
        int i10;
        f41729e = new ConcurrentHashMap();
        for (CompressionAlgorithm compressionAlgorithm : values()) {
            f41729e.put(Integer.valueOf(compressionAlgorithm.algorithmId), compressionAlgorithm);
        }
    }

    private CompressionAlgorithm(int i10) {
        this.algorithmId = i10;
    }

    public static CompressionAlgorithm a(int i10) {
        return f41729e.get(Integer.valueOf(i10));
    }

    public int b() {
        return this.algorithmId;
    }
}
