package org.jivesoftware.smack.util.stringencoder;

import java.nio.charset.StandardCharsets;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;

public class Base64 {
    private static Encoder base64encoder;

    public interface Encoder {
        byte[] decode(String str);

        byte[] encode(byte[] bArr);

        String encodeToString(byte[] bArr);

        String encodeToStringWithoutPadding(byte[] bArr);
    }

    public static final byte[] decode(String str) {
        try {
            return base64encoder.decode(StringUtils.deleteXmlWhitespace(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final String decodeToString(String str) {
        return new String(decode(str), StandardCharsets.UTF_8);
    }

    public static final String encode(String str) {
        return encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static final String encodeToString(byte[] bArr) {
        return base64encoder.encodeToString(bArr);
    }

    public static final String encodeToStringWithoutPadding(byte[] bArr) {
        return base64encoder.encodeToStringWithoutPadding(bArr);
    }

    public static void setEncoder(Encoder encoder) {
        Objects.requireNonNull(encoder, "encoder must no be null");
        base64encoder = encoder;
    }

    private static byte[] slice(byte[] bArr, int i10, int i11) {
        if (i10 == 0 && i11 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    public static final byte[] encode(byte[] bArr) {
        return base64encoder.encode(bArr);
    }

    public static final String encodeToString(byte[] bArr, int i10, int i11) {
        return encodeToString(slice(bArr, i10, i11));
    }

    public static final byte[] decode(byte[] bArr) {
        return decode(new String(bArr, StandardCharsets.US_ASCII));
    }
}
