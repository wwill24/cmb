package org.jivesoftware.smack.util.stringencoder;

import org.jivesoftware.smack.util.Objects;

public class Base64UrlSafeEncoder {
    private static StringEncoder<String> base64UrlSafeEncoder;

    public static final String decode(String str) {
        return base64UrlSafeEncoder.decode(str);
    }

    public static final String encode(String str) {
        return base64UrlSafeEncoder.encode(str);
    }

    public static StringEncoder<String> getStringEncoder() {
        return base64UrlSafeEncoder;
    }

    public static void setEncoder(StringEncoder<String> stringEncoder) {
        Objects.requireNonNull(stringEncoder, "encoder must no be null");
        base64UrlSafeEncoder = stringEncoder;
    }
}
