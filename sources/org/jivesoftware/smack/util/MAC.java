package org.jivesoftware.smack.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MAC {
    public static final String HMACSHA1 = "HmacSHA1";
    private static Mac HMAC_SHA1;

    static {
        try {
            HMAC_SHA1 = Mac.getInstance(HMACSHA1);
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static synchronized byte[] hmacsha1(SecretKeySpec secretKeySpec, byte[] bArr) throws InvalidKeyException {
        byte[] doFinal;
        synchronized (MAC.class) {
            HMAC_SHA1.init(secretKeySpec);
            doFinal = HMAC_SHA1.doFinal(bArr);
        }
        return doFinal;
    }

    public static byte[] hmacsha1(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        return hmacsha1(new SecretKeySpec(bArr, HMACSHA1), bArr2);
    }
}
