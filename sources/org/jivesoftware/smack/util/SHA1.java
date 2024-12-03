package org.jivesoftware.smack.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
    private static MessageDigest SHA1_DIGEST;

    static {
        try {
            SHA1_DIGEST = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static synchronized byte[] bytes(byte[] bArr) {
        byte[] digest;
        synchronized (SHA1.class) {
            SHA1_DIGEST.update(bArr);
            digest = SHA1_DIGEST.digest();
        }
        return digest;
    }

    public static String hex(byte[] bArr) {
        return StringUtils.encodeHex(bytes(bArr));
    }

    public static String hex(String str) {
        return hex(StringUtils.toUtf8Bytes(str));
    }

    public static byte[] bytes(String str) {
        return bytes(StringUtils.toUtf8Bytes(str));
    }
}
