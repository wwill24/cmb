package org.jivesoftware.smack.util.stringencoder.android;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import org.jivesoftware.smack.util.stringencoder.StringEncoder;

public final class AndroidBase64UrlSafeEncoder implements StringEncoder<String> {
    private static final int BASE64_ENCODER_FLAGS = 10;
    private static AndroidBase64UrlSafeEncoder instance = new AndroidBase64UrlSafeEncoder();

    private AndroidBase64UrlSafeEncoder() {
    }

    public static AndroidBase64UrlSafeEncoder getInstance() {
        return instance;
    }

    public String decode(String str) {
        return new String(Base64.decode(str, 10), StandardCharsets.UTF_8);
    }

    public String encode(String str) {
        return Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 10);
    }
}
