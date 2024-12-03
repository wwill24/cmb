package org.bouncycastle.crypto.engines;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class NaccacheSternEngine implements AsymmetricBlockCipher {
    private static BigInteger ONE = BigInteger.valueOf(1);
    private static BigInteger ZERO = BigInteger.valueOf(0);
    private boolean debug = false;
    private boolean forEncryption;
    private NaccacheSternKeyParameters key;
    private Vector[] lookup = null;

    private static BigInteger chineseRemainder(Vector vector, Vector vector2) {
        BigInteger bigInteger = ZERO;
        BigInteger bigInteger2 = ONE;
        for (int i10 = 0; i10 < vector2.size(); i10++) {
            bigInteger2 = bigInteger2.multiply((BigInteger) vector2.elementAt(i10));
        }
        for (int i11 = 0; i11 < vector2.size(); i11++) {
            BigInteger bigInteger3 = (BigInteger) vector2.elementAt(i11);
            BigInteger divide = bigInteger2.divide(bigInteger3);
            bigInteger = bigInteger.add(divide.multiply(divide.modInverse(bigInteger3)).multiply((BigInteger) vector.elementAt(i11)));
        }
        return bigInteger.mod(bigInteger2);
    }

    public byte[] addCryptedBlocks(byte[] bArr, byte[] bArr2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            if (bArr.length > getOutputBlockSize() || bArr2.length > getOutputBlockSize()) {
                throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
            }
        } else if (bArr.length > getInputBlockSize() || bArr2.length > getInputBlockSize()) {
            throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger mod = bigInteger.multiply(bigInteger2).mod(this.key.getModulus());
        if (this.debug) {
            PrintStream printStream = System.out;
            printStream.println("c(m1) as BigInteger:....... " + bigInteger);
            PrintStream printStream2 = System.out;
            printStream2.println("c(m2) as BigInteger:....... " + bigInteger2);
            PrintStream printStream3 = System.out;
            printStream3.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + mod);
        }
        byte[] byteArray = this.key.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        System.arraycopy(mod.toByteArray(), 0, byteArray, byteArray.length - mod.toByteArray().length, mod.toByteArray().length);
        return byteArray;
    }

    public byte[] encrypt(BigInteger bigInteger) {
        byte[] byteArray = this.key.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        byte[] byteArray2 = this.key.getG().modPow(bigInteger, this.key.getModulus()).toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, byteArray.length - byteArray2.length, byteArray2.length);
        if (this.debug) {
            PrintStream printStream = System.out;
            printStream.println("Encrypted value is:  " + new BigInteger(byteArray));
        }
        return byteArray;
    }

    public int getInputBlockSize() {
        return this.forEncryption ? ((this.key.getLowerSigmaBound() + 7) / 8) - 1 : this.key.getModulus().toByteArray().length;
    }

    public int getOutputBlockSize() {
        return this.forEncryption ? this.key.getModulus().toByteArray().length : ((this.key.getLowerSigmaBound() + 7) / 8) - 1;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forEncryption = z10;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.key = (NaccacheSternKeyParameters) cipherParameters;
        if (!this.forEncryption) {
            if (this.debug) {
                System.out.println("Constructing lookup Array");
            }
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.key;
            Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
            this.lookup = new Vector[smallPrimes.size()];
            for (int i10 = 0; i10 < smallPrimes.size(); i10++) {
                BigInteger bigInteger = (BigInteger) smallPrimes.elementAt(i10);
                int intValue = bigInteger.intValue();
                this.lookup[i10] = new Vector();
                this.lookup[i10].addElement(ONE);
                if (this.debug) {
                    PrintStream printStream = System.out;
                    printStream.println("Constructing lookup ArrayList for " + intValue);
                }
                BigInteger bigInteger2 = ZERO;
                for (int i11 = 1; i11 < intValue; i11++) {
                    bigInteger2 = bigInteger2.add(naccacheSternPrivateKeyParameters.getPhi_n());
                    this.lookup[i10].addElement(naccacheSternPrivateKeyParameters.getG().modPow(bigInteger2.divide(bigInteger), naccacheSternPrivateKeyParameters.getModulus()));
                }
            }
        }
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.key == null) {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        } else if (i11 > getInputBlockSize() + 1) {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        } else if (this.forEncryption || i11 >= getInputBlockSize()) {
            if (!(i10 == 0 && i11 == bArr.length)) {
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, i10, bArr2, 0, i11);
                bArr = bArr2;
            }
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (this.debug) {
                System.out.println("input as BigInteger: " + bigInteger);
            }
            if (this.forEncryption) {
                return encrypt(bigInteger);
            }
            Vector vector = new Vector();
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.key;
            Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
            for (int i12 = 0; i12 < smallPrimes.size(); i12++) {
                BigInteger modPow = bigInteger.modPow(naccacheSternPrivateKeyParameters.getPhi_n().divide((BigInteger) smallPrimes.elementAt(i12)), naccacheSternPrivateKeyParameters.getModulus());
                Vector vector2 = this.lookup[i12];
                if (vector2.size() != ((BigInteger) smallPrimes.elementAt(i12)).intValue()) {
                    if (this.debug) {
                        System.out.println("Prime is " + smallPrimes.elementAt(i12) + ", lookup table has size " + vector2.size());
                    }
                    throw new InvalidCipherTextException("Error in lookup Array for " + ((BigInteger) smallPrimes.elementAt(i12)).intValue() + ": Size mismatch. Expected ArrayList with length " + ((BigInteger) smallPrimes.elementAt(i12)).intValue() + " but found ArrayList of length " + this.lookup[i12].size());
                }
                int indexOf = vector2.indexOf(modPow);
                if (indexOf == -1) {
                    if (this.debug) {
                        System.out.println("Actual prime is " + smallPrimes.elementAt(i12));
                        System.out.println("Decrypted value is " + modPow);
                        System.out.println("LookupList for " + smallPrimes.elementAt(i12) + " with size " + this.lookup[i12].size() + " is: ");
                        for (int i13 = 0; i13 < this.lookup[i12].size(); i13++) {
                            System.out.println(this.lookup[i12].elementAt(i13));
                        }
                    }
                    throw new InvalidCipherTextException("Lookup failed");
                }
                vector.addElement(BigInteger.valueOf((long) indexOf));
            }
            return chineseRemainder(vector, smallPrimes).toByteArray();
        } else {
            throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
    }

    public byte[] processData(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.debug) {
            System.out.println();
        }
        if (bArr.length > getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize();
            int outputBlockSize = getOutputBlockSize();
            if (this.debug) {
                System.out.println("Input blocksize is:  " + inputBlockSize + " bytes");
                System.out.println("Output blocksize is: " + outputBlockSize + " bytes");
                System.out.println("Data has length:.... " + bArr.length + " bytes");
            }
            byte[] bArr3 = new byte[(((bArr.length / inputBlockSize) + 1) * outputBlockSize)];
            int i10 = 0;
            int i11 = 0;
            while (i10 < bArr.length) {
                int i12 = i10 + inputBlockSize;
                if (i12 < bArr.length) {
                    int i13 = i12;
                    bArr2 = processBlock(bArr, i10, inputBlockSize);
                    i10 = i13;
                } else {
                    bArr2 = processBlock(bArr, i10, bArr.length - i10);
                    i10 += bArr.length - i10;
                }
                if (this.debug) {
                    System.out.println("new datapos is " + i10);
                }
                if (bArr2 != null) {
                    System.arraycopy(bArr2, 0, bArr3, i11, bArr2.length);
                    i11 += bArr2.length;
                } else {
                    if (this.debug) {
                        System.out.println("cipher returned null");
                    }
                    throw new InvalidCipherTextException("cipher returned null");
                }
            }
            byte[] bArr4 = new byte[i11];
            System.arraycopy(bArr3, 0, bArr4, 0, i11);
            if (this.debug) {
                System.out.println("returning " + i11 + " bytes");
            }
            return bArr4;
        }
        if (this.debug) {
            System.out.println("data size is less then input block size, processing directly");
        }
        return processBlock(bArr, 0, bArr.length);
    }

    public void setDebug(boolean z10) {
        this.debug = z10;
    }
}
