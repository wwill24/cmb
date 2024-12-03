package org.bouncycastle.crypto.engines;

public class AESWrapEngine extends RFC3394WrapEngine {
    public AESWrapEngine() {
        super(new AESEngine());
    }

    public AESWrapEngine(boolean z10) {
        super(new AESEngine(), z10);
    }
}
