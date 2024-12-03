package org.bouncycastle.crypto.params;

import java.security.SecureRandom;

public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* renamed from: l  reason: collision with root package name */
    private final int f41514l;

    /* renamed from: n  reason: collision with root package name */
    private final int f41515n;
    private final SecureRandom random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int i10, int i11, int i12, SecureRandom secureRandom) {
        this(i10, i11, i12, secureRandom, -1);
    }

    public DSAParameterGenerationParameters(int i10, int i11, int i12, SecureRandom secureRandom, int i13) {
        this.f41514l = i10;
        this.f41515n = i11;
        this.certainty = i12;
        this.usageIndex = i13;
        this.random = secureRandom;
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getL() {
        return this.f41514l;
    }

    public int getN() {
        return this.f41515n;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }
}
