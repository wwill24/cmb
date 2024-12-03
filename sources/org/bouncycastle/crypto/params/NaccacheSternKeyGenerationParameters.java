package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class NaccacheSternKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private int cntSmallPrimes;
    private boolean debug;

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i10, int i11, int i12) {
        this(secureRandom, i10, i11, i12, false);
    }

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i10, int i11, int i12, boolean z10) {
        super(secureRandom, i10);
        this.debug = false;
        this.certainty = i11;
        if (i12 % 2 == 1) {
            throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
        } else if (i12 >= 30) {
            this.cntSmallPrimes = i12;
            this.debug = z10;
        } else {
            throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
        }
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getCntSmallPrimes() {
        return this.cntSmallPrimes;
    }

    public boolean isDebug() {
        return this.debug;
    }
}
