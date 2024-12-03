package org.bouncycastle.crypto.generators;

import com.google.android.gms.common.api.a;
import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFCounterParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f41442h;
    private byte[] ios;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f41443k;
    private int maxSizeExcl;
    private final Mac prf;

    public KDFCounterBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f41442h = macSize;
        this.f41443k = new byte[macSize];
    }

    private void generateNext() {
        int i10 = (this.generatedBytes / this.f41442h) + 1;
        byte[] bArr = this.ios;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length == 4) {
                        bArr[0] = (byte) (i10 >>> 24);
                    } else {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                }
                bArr[bArr.length - 3] = (byte) (i10 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i10 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i10;
        Mac mac = this.prf;
        byte[] bArr2 = this.fixedInputDataCtrPrefix;
        mac.update(bArr2, 0, bArr2.length);
        Mac mac2 = this.prf;
        byte[] bArr3 = this.ios;
        mac2.update(bArr3, 0, bArr3.length);
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData_afterCtr;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f41443k, 0);
    }

    public int generateBytes(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.generatedBytes;
        int i13 = i12 + i11;
        if (i13 < 0 || i13 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i12 % this.f41442h == 0) {
            generateNext();
        }
        int i14 = this.generatedBytes;
        int i15 = this.f41442h;
        int i16 = i14 % i15;
        int min = Math.min(i15 - (i14 % i15), i11);
        System.arraycopy(this.f41443k, i16, bArr, i10, min);
        this.generatedBytes += min;
        int i17 = i11 - min;
        while (true) {
            i10 += min;
            if (i17 <= 0) {
                return i11;
            }
            generateNext();
            min = Math.min(this.f41442h, i17);
            System.arraycopy(this.f41443k, 0, bArr, i10, min);
            this.generatedBytes += min;
            i17 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFCounterParameters.getKI()));
            this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
            this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
            int r10 = kDFCounterParameters.getR();
            this.ios = new byte[(r10 / 8)];
            BigInteger multiply = TWO.pow(r10).multiply(BigInteger.valueOf((long) this.f41442h));
            this.maxSizeExcl = multiply.compareTo(INTEGER_MAX) == 1 ? a.e.API_PRIORITY_OTHER : multiply.intValue();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
