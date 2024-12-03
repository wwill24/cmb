package org.bouncycastle.util;

import com.facebook.internal.security.CertificateUtil;
import net.bytebuddy.asm.Advice;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

public class Fingerprint {
    private static char[] encodingTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
    private final byte[] fingerprint;

    public Fingerprint(byte[] bArr) {
        this(bArr, 160);
    }

    public Fingerprint(byte[] bArr, int i10) {
        this.fingerprint = calculateFingerprint(bArr, i10);
    }

    public Fingerprint(byte[] bArr, boolean z10) {
        if (z10) {
            this.fingerprint = calculateFingerprintSHA512_160(bArr);
        } else {
            this.fingerprint = calculateFingerprint(bArr);
        }
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        return calculateFingerprint(bArr, 160);
    }

    public static byte[] calculateFingerprint(byte[] bArr, int i10) {
        if (i10 % 8 == 0) {
            SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
            sHAKEDigest.update(bArr, 0, bArr.length);
            int i11 = i10 / 8;
            byte[] bArr2 = new byte[i11];
            sHAKEDigest.doFinal(bArr2, 0, i11);
            return bArr2;
        }
        throw new IllegalArgumentException("bitLength must be a multiple of 8");
    }

    public static byte[] calculateFingerprintSHA512_160(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest(160);
        sHA512tDigest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.getDigestSize()];
        sHA512tDigest.doFinal(bArr2, 0);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) obj).fingerprint, this.fingerprint);
        }
        return false;
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 != this.fingerprint.length; i10++) {
            if (i10 > 0) {
                stringBuffer.append(CertificateUtil.DELIMITER);
            }
            stringBuffer.append(encodingTable[(this.fingerprint[i10] >>> 4) & 15]);
            stringBuffer.append(encodingTable[this.fingerprint[i10] & 15]);
        }
        return stringBuffer.toString();
    }
}
