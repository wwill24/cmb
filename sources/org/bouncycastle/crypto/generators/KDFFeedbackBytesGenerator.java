package org.bouncycastle.crypto.generators;

import com.google.android.gms.common.api.a;
import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFFeedbackParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f41447h;
    private byte[] ios;
    private byte[] iv;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f41448k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFFeedbackBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f41447h = macSize;
        this.f41448k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            Mac mac = this.prf;
            byte[] bArr = this.iv;
            mac.update(bArr, 0, bArr.length);
        } else {
            Mac mac2 = this.prf;
            byte[] bArr2 = this.f41448k;
            mac2.update(bArr2, 0, bArr2.length);
        }
        if (this.useCounter) {
            int i10 = (this.generatedBytes / this.f41447h) + 1;
            byte[] bArr3 = this.ios;
            int length = bArr3.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length == 4) {
                            bArr3[0] = (byte) (i10 >>> 24);
                        } else {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                    }
                    bArr3[bArr3.length - 3] = (byte) (i10 >>> 16);
                }
                bArr3[bArr3.length - 2] = (byte) (i10 >>> 8);
            }
            bArr3[bArr3.length - 1] = (byte) i10;
            this.prf.update(bArr3, 0, bArr3.length);
        }
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f41448k, 0);
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.generatedBytes;
        int i13 = i12 + i11;
        if (i13 < 0 || i13 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i12 % this.f41447h == 0) {
            generateNext();
        }
        int i14 = this.generatedBytes;
        int i15 = this.f41447h;
        int i16 = i14 % i15;
        int min = Math.min(i15 - (i14 % i15), i11);
        System.arraycopy(this.f41448k, i16, bArr, i10, min);
        this.generatedBytes += min;
        int i17 = i11 - min;
        while (true) {
            i10 += min;
            if (i17 <= 0) {
                return i11;
            }
            generateNext();
            min = Math.min(this.f41447h, i17);
            System.arraycopy(this.f41448k, 0, bArr, i10, min);
            this.generatedBytes += min;
            i17 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFFeedbackParameters) {
            KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFFeedbackParameters.getKI()));
            this.fixedInputData = kDFFeedbackParameters.getFixedInputData();
            int r10 = kDFFeedbackParameters.getR();
            this.ios = new byte[(r10 / 8)];
            boolean useCounter2 = kDFFeedbackParameters.useCounter();
            int i10 = a.e.API_PRIORITY_OTHER;
            if (useCounter2) {
                BigInteger multiply = TWO.pow(r10).multiply(BigInteger.valueOf((long) this.f41447h));
                if (multiply.compareTo(INTEGER_MAX) != 1) {
                    i10 = multiply.intValue();
                }
            }
            this.maxSizeExcl = i10;
            this.iv = kDFFeedbackParameters.getIV();
            this.useCounter = kDFFeedbackParameters.useCounter();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
