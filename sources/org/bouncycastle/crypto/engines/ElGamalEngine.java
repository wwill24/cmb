package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ElGamalKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;

public class ElGamalEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private int bitSize;
    private boolean forEncryption;
    private ElGamalKeyParameters key;
    private SecureRandom random;

    public int getInputBlockSize() {
        return this.forEncryption ? (this.bitSize - 1) / 8 : ((this.bitSize + 7) / 8) * 2;
    }

    public int getOutputBlockSize() {
        return this.forEncryption ? ((this.bitSize + 7) / 8) * 2 : (this.bitSize - 1) / 8;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.key = (ElGamalKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            this.key = (ElGamalKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.random = secureRandom;
        this.forEncryption = z10;
        this.bitSize = this.key.getParameters().getP().bitLength();
        if (z10) {
            if (!(this.key instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.key instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) {
        BigInteger createRandomBigInteger;
        if (this.key != null) {
            if (i11 <= (this.forEncryption ? ((this.bitSize - 1) + 7) / 8 : getInputBlockSize())) {
                BigInteger p10 = this.key.getParameters().getP();
                if (this.key instanceof ElGamalPrivateKeyParameters) {
                    int i12 = i11 / 2;
                    byte[] bArr2 = new byte[i12];
                    byte[] bArr3 = new byte[i12];
                    System.arraycopy(bArr, i10, bArr2, 0, i12);
                    System.arraycopy(bArr, i10 + i12, bArr3, 0, i12);
                    return BigIntegers.asUnsignedByteArray(new BigInteger(1, bArr2).modPow(p10.subtract(ONE).subtract(((ElGamalPrivateKeyParameters) this.key).getX()), p10).multiply(new BigInteger(1, bArr3)).mod(p10));
                }
                if (!(i10 == 0 && i11 == bArr.length)) {
                    byte[] bArr4 = new byte[i11];
                    System.arraycopy(bArr, i10, bArr4, 0, i11);
                    bArr = bArr4;
                }
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.compareTo(p10) < 0) {
                    ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.key;
                    int bitLength = p10.bitLength();
                    while (true) {
                        createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
                        if (!createRandomBigInteger.equals(ZERO) && createRandomBigInteger.compareTo(p10.subtract(TWO)) <= 0) {
                            break;
                        }
                    }
                    BigInteger modPow = this.key.getParameters().getG().modPow(createRandomBigInteger, p10);
                    BigInteger mod = bigInteger.multiply(elGamalPublicKeyParameters.getY().modPow(createRandomBigInteger, p10)).mod(p10);
                    byte[] byteArray = modPow.toByteArray();
                    byte[] byteArray2 = mod.toByteArray();
                    int outputBlockSize = getOutputBlockSize();
                    byte[] bArr5 = new byte[outputBlockSize];
                    int i13 = outputBlockSize / 2;
                    if (byteArray.length > i13) {
                        System.arraycopy(byteArray, 1, bArr5, i13 - (byteArray.length - 1), byteArray.length - 1);
                    } else {
                        System.arraycopy(byteArray, 0, bArr5, i13 - byteArray.length, byteArray.length);
                    }
                    if (byteArray2.length > i13) {
                        System.arraycopy(byteArray2, 1, bArr5, outputBlockSize - (byteArray2.length - 1), byteArray2.length - 1);
                    } else {
                        System.arraycopy(byteArray2, 0, bArr5, outputBlockSize - byteArray2.length, byteArray2.length);
                    }
                    return bArr5;
                }
                throw new DataLengthException("input too large for ElGamal cipher.\n");
            }
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
