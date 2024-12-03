package org.jivesoftware.smack.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtil {
    static final ThreadLocal<Random> RANDOM = new ThreadLocal<Random>() {
        /* access modifiers changed from: protected */
        public Random initialValue() {
            return new Random();
        }
    };
    static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>() {
        /* access modifiers changed from: protected */
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };

    public static void fillWithSecureRandom(byte[] bArr) {
        SECURE_RANDOM.get().nextBytes(bArr);
    }

    public static int nextSecureRandomInt(int i10) {
        return SECURE_RANDOM.get().nextInt(i10);
    }

    public static int nextSecureRandomInt() {
        return SECURE_RANDOM.get().nextInt();
    }
}
