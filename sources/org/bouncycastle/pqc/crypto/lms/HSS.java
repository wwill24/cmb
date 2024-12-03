package org.bouncycastle.pqc.crypto.lms;

import java.util.Arrays;
import java.util.List;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;

class HSS {

    static class PlaceholderLMSPrivateKey extends LMSPrivateKeyParameters {
        public PlaceholderLMSPrivateKey(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i10, byte[] bArr, int i11, byte[] bArr2) {
            super(lMSigParameters, lMOtsParameters, i10, bArr, i11, bArr2);
        }

        /* access modifiers changed from: package-private */
        public LMOtsPrivateKey getNextOtsPrivateKey() {
            throw new RuntimeException("placeholder only");
        }

        public LMSPublicKeyParameters getPublicKey() {
            throw new RuntimeException("placeholder only");
        }
    }

    HSS() {
    }

    public static HSSPrivateKeyParameters generateHSSKeyPair(HSSKeyGenerationParameters hSSKeyGenerationParameters) {
        int i10;
        byte[] bArr;
        int depth = hSSKeyGenerationParameters.getDepth();
        LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr = new LMSPrivateKeyParameters[depth];
        LMSSignature[] lMSSignatureArr = new LMSSignature[(hSSKeyGenerationParameters.getDepth() - 1)];
        byte[] bArr2 = new byte[32];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr2);
        byte[] bArr3 = new byte[16];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr3);
        byte[] bArr4 = new byte[0];
        int i11 = 0;
        long j10 = 1;
        while (i11 < depth) {
            if (i11 == 0) {
                lMSPrivateKeyParametersArr[i11] = new LMSPrivateKeyParameters(hSSKeyGenerationParameters.getLmsParameters()[i11].getLMSigParam(), hSSKeyGenerationParameters.getLmsParameters()[i11].getLMOTSParam(), 0, bArr3, 1 << hSSKeyGenerationParameters.getLmsParameters()[i11].getLMSigParam().getH(), bArr2);
                i10 = i11;
                bArr = bArr4;
            } else {
                LMSigParameters lMSigParam = hSSKeyGenerationParameters.getLmsParameters()[i11].getLMSigParam();
                LMOtsParameters lMOTSParam = hSSKeyGenerationParameters.getLmsParameters()[i11].getLMOTSParam();
                int h10 = 1 << hSSKeyGenerationParameters.getLmsParameters()[i11].getLMSigParam().getH();
                i10 = i11;
                LMSigParameters lMSigParameters = lMSigParam;
                bArr = bArr4;
                lMSPrivateKeyParametersArr[i10] = new PlaceholderLMSPrivateKey(lMSigParameters, lMOTSParam, -1, bArr, h10, bArr);
            }
            j10 *= (long) (1 << hSSKeyGenerationParameters.getLmsParameters()[i10].getLMSigParam().getH());
            i11 = i10 + 1;
            bArr4 = bArr;
        }
        if (j10 == 0) {
            j10 = Long.MAX_VALUE;
        }
        return new HSSPrivateKeyParameters(hSSKeyGenerationParameters.getDepth(), Arrays.asList(lMSPrivateKeyParametersArr), Arrays.asList(lMSSignatureArr), 0, j10);
    }

    public static HSSSignature generateSignature(int i10, LMSContext lMSContext) {
        return new HSSSignature(i10 - 1, lMSContext.getSignedPubKeys(), LMS.generateSign(lMSContext));
    }

    public static HSSSignature generateSignature(HSSPrivateKeyParameters hSSPrivateKeyParameters, byte[] bArr) {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        LMSSignedPubKey[] lMSSignedPubKeyArr;
        int l10 = hSSPrivateKeyParameters.getL();
        synchronized (hSSPrivateKeyParameters) {
            rangeTestKeys(hSSPrivateKeyParameters);
            List<LMSPrivateKeyParameters> keys = hSSPrivateKeyParameters.getKeys();
            List<LMSSignature> sig = hSSPrivateKeyParameters.getSig();
            int i10 = l10 - 1;
            lMSPrivateKeyParameters = hSSPrivateKeyParameters.getKeys().get(i10);
            lMSSignedPubKeyArr = new LMSSignedPubKey[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                lMSSignedPubKeyArr[i11] = new LMSSignedPubKey(sig.get(i11), keys.get(i12).getPublicKey());
                i11 = i12;
            }
            hSSPrivateKeyParameters.incIndex();
        }
        LMSContext withSignedPublicKeys = lMSPrivateKeyParameters.generateLMSContext().withSignedPublicKeys(lMSSignedPubKeyArr);
        withSignedPublicKeys.update(bArr, 0, bArr.length);
        return generateSignature(l10, withSignedPublicKeys);
    }

    public static void incrementIndex(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            rangeTestKeys(hSSPrivateKeyParameters);
            hSSPrivateKeyParameters.incIndex();
            hSSPrivateKeyParameters.getKeys().get(hSSPrivateKeyParameters.getL() - 1).incIndex();
        }
    }

    static void rangeTestKeys(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            if (hSSPrivateKeyParameters.getIndex() >= hSSPrivateKeyParameters.getIndexLimit()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("hss private key");
                sb2.append(hSSPrivateKeyParameters.isShard() ? " shard" : "");
                sb2.append(" is exhausted");
                throw new ExhaustedPrivateKeyException(sb2.toString());
            }
            int l10 = hSSPrivateKeyParameters.getL();
            List<LMSPrivateKeyParameters> keys = hSSPrivateKeyParameters.getKeys();
            int i10 = l10;
            while (true) {
                int i11 = i10 - 1;
                if (keys.get(i11).getIndex() != (1 << keys.get(i11).getSigParameters().getH())) {
                    while (i10 < l10) {
                        hSSPrivateKeyParameters.replaceConsumedKey(i10);
                        i10++;
                    }
                } else if (i11 == 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("hss private key");
                    sb3.append(hSSPrivateKeyParameters.isShard() ? " shard" : "");
                    sb3.append(" is exhausted the maximum limit for this HSS private key");
                    throw new ExhaustedPrivateKeyException(sb3.toString());
                } else {
                    i10 = i11;
                }
            }
        }
    }

    public static boolean verifySignature(HSSPublicKeyParameters hSSPublicKeyParameters, HSSSignature hSSSignature, byte[] bArr) {
        int i10 = hSSSignature.getlMinus1();
        int i11 = i10 + 1;
        if (i11 != hSSPublicKeyParameters.getL()) {
            return false;
        }
        LMSSignature[] lMSSignatureArr = new LMSSignature[i11];
        LMSPublicKeyParameters[] lMSPublicKeyParametersArr = new LMSPublicKeyParameters[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            lMSSignatureArr[i12] = hSSSignature.getSignedPubKey()[i12].getSignature();
            lMSPublicKeyParametersArr[i12] = hSSSignature.getSignedPubKey()[i12].getPublicKey();
        }
        lMSSignatureArr[i10] = hSSSignature.getSignature();
        LMSPublicKeyParameters lMSPublicKey = hSSPublicKeyParameters.getLMSPublicKey();
        int i13 = 0;
        while (i13 < i10) {
            if (!LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i13], lMSPublicKeyParametersArr[i13].toByteArray())) {
                return false;
            }
            try {
                lMSPublicKey = lMSPublicKeyParametersArr[i13];
                i13++;
            } catch (Exception e10) {
                throw new IllegalStateException(e10.getMessage(), e10);
            }
        }
        return LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i10], bArr);
    }
}
