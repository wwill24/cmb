package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSAKeyGenerationParameters param;

    private static int getNumberOfIterations(int i10, int i11) {
        if (i10 >= 1536) {
            if (i11 <= 100) {
                return 3;
            }
            if (i11 <= 128) {
                return 4;
            }
            return 4 + (((i11 - 128) + 1) / 2);
        } else if (i10 >= 1024) {
            if (i11 <= 100) {
                return 4;
            }
            if (i11 <= 112) {
                return 5;
            }
            return (((i11 - 112) + 1) / 2) + 5;
        } else if (i10 >= 512) {
            if (i11 <= 80) {
                return 5;
            }
            if (i11 <= 100) {
                return 7;
            }
            return (((i11 - 100) + 1) / 2) + 7;
        } else if (i11 <= 80) {
            return 40;
        } else {
            return 40 + (((i11 - 80) + 1) / 2);
        }
    }

    /* access modifiers changed from: protected */
    public BigInteger chooseRandomPrime(int i10, BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i11 = 0; i11 != i10 * 5; i11++) {
            BigInteger createRandomPrime = BigIntegers.createRandomPrime(i10, 1, this.param.getRandom());
            BigInteger mod = createRandomPrime.mod(bigInteger);
            BigInteger bigInteger3 = ONE;
            if (!mod.equals(bigInteger3) && createRandomPrime.multiply(createRandomPrime).compareTo(bigInteger2) >= 0 && isProbablePrime(createRandomPrime) && bigInteger.gcd(createRandomPrime.subtract(bigInteger3)).equals(bigInteger3)) {
                return createRandomPrime;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger chooseRandomPrime;
        BigInteger chooseRandomPrime2;
        BigInteger multiply;
        BigInteger bigInteger;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        int strength = rSAKeyPairGenerator.param.getStrength();
        int i10 = (strength + 1) / 2;
        int i11 = strength - i10;
        int i12 = strength / 2;
        int i13 = i12 - 100;
        int i14 = strength / 3;
        if (i13 < i14) {
            i13 = i14;
        }
        int i15 = strength >> 2;
        BigInteger pow = BigInteger.valueOf(2).pow(i12);
        BigInteger bigInteger2 = ONE;
        BigInteger shiftLeft = bigInteger2.shiftLeft(strength - 1);
        BigInteger shiftLeft2 = bigInteger2.shiftLeft(i13);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        boolean z10 = false;
        while (!z10) {
            BigInteger publicExponent = rSAKeyPairGenerator.param.getPublicExponent();
            do {
                chooseRandomPrime = rSAKeyPairGenerator.chooseRandomPrime(i10, publicExponent, shiftLeft);
                while (true) {
                    chooseRandomPrime2 = rSAKeyPairGenerator.chooseRandomPrime(i11, publicExponent, shiftLeft);
                    BigInteger abs = chooseRandomPrime2.subtract(chooseRandomPrime).abs();
                    if (abs.bitLength() >= i13 && abs.compareTo(shiftLeft2) > 0) {
                        multiply = chooseRandomPrime.multiply(chooseRandomPrime2);
                        if (multiply.bitLength() == strength) {
                            break;
                        }
                        chooseRandomPrime = chooseRandomPrime.max(chooseRandomPrime2);
                    } else {
                        rSAKeyPairGenerator = this;
                        strength = strength;
                    }
                }
            } while (WNafUtil.getNafWeight(multiply) < i15);
            if (chooseRandomPrime.compareTo(chooseRandomPrime2) < 0) {
                bigInteger = chooseRandomPrime;
                chooseRandomPrime = chooseRandomPrime2;
            } else {
                bigInteger = chooseRandomPrime2;
            }
            BigInteger bigInteger3 = ONE;
            BigInteger subtract = chooseRandomPrime.subtract(bigInteger3);
            BigInteger subtract2 = bigInteger.subtract(bigInteger3);
            int i16 = strength;
            BigInteger modInverse = publicExponent.modInverse(subtract.divide(subtract.gcd(subtract2)).multiply(subtract2));
            if (modInverse.compareTo(pow) <= 0) {
                rSAKeyPairGenerator = this;
                strength = i16;
            } else {
                BigInteger remainder = modInverse.remainder(subtract);
                BigInteger remainder2 = modInverse.remainder(subtract2);
                BigInteger modOddInverse = BigIntegers.modOddInverse(chooseRandomPrime, bigInteger);
                RSAKeyParameters rSAKeyParameters = new RSAKeyParameters(false, multiply, publicExponent);
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = r13;
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters2 = new RSAPrivateCrtKeyParameters(multiply, publicExponent, modInverse, chooseRandomPrime, bigInteger, remainder, remainder2, modOddInverse);
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair((AsymmetricKeyParameter) rSAKeyParameters, (AsymmetricKeyParameter) rSAPrivateCrtKeyParameters);
                z10 = true;
                strength = i16;
                rSAKeyPairGenerator = this;
            }
        }
        return asymmetricCipherKeyPair;
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (RSAKeyGenerationParameters) keyGenerationParameters;
    }

    /* access modifiers changed from: protected */
    public boolean isProbablePrime(BigInteger bigInteger) {
        return !Primes.hasAnySmallFactors(bigInteger) && Primes.isMRProbablePrime(bigInteger, this.param.getRandom(), getNumberOfIterations(bigInteger.bitLength(), this.param.getCertainty()));
    }
}
