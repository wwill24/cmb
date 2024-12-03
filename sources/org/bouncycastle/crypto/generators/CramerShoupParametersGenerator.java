package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;

public class CramerShoupParametersGenerator {
    /* access modifiers changed from: private */
    public static final BigInteger ONE = BigInteger.valueOf(1);
    private int certainty;
    private SecureRandom random;
    private int size;

    private static class ParametersHelper {
        private static final BigInteger TWO = BigInteger.valueOf(2);

        private ParametersHelper() {
        }

        static BigInteger[] generateSafePrimes(int i10, int i11, SecureRandom secureRandom) {
            BigInteger createRandomPrime;
            BigInteger add;
            int i12 = i10 - 1;
            while (true) {
                createRandomPrime = BigIntegers.createRandomPrime(i12, 2, secureRandom);
                add = createRandomPrime.shiftLeft(1).add(CramerShoupParametersGenerator.ONE);
                if (!add.isProbablePrime(i11) || (i11 > 2 && !createRandomPrime.isProbablePrime(i11))) {
                }
            }
            return new BigInteger[]{add, createRandomPrime};
        }

        static BigInteger selectGenerator(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(TWO);
            do {
                BigInteger bigInteger2 = TWO;
                modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (modPow.equals(CramerShoupParametersGenerator.ONE));
            return modPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger selectGenerator;
        BigInteger bigInteger = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
        BigInteger selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        do {
            selectGenerator = ParametersHelper.selectGenerator(bigInteger, this.random);
        } while (selectGenerator2.equals(selectGenerator));
        return new CramerShoupParameters(bigInteger, selectGenerator2, selectGenerator, new SHA256Digest());
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger selectGenerator;
        BigInteger p10 = dHParameters.getP();
        BigInteger g10 = dHParameters.getG();
        do {
            selectGenerator = ParametersHelper.selectGenerator(p10, this.random);
        } while (g10.equals(selectGenerator));
        return new CramerShoupParameters(p10, g10, selectGenerator, new SHA256Digest());
    }

    public void init(int i10, int i11, SecureRandom secureRandom) {
        this.size = i10;
        this.certainty = i11;
        this.random = secureRandom;
    }
}
