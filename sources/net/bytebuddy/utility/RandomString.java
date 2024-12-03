package net.bytebuddy.utility;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Random;
import net.bytebuddy.utility.nullability.MaybeNull;

public class RandomString {
    public static final int DEFAULT_LENGTH = 8;
    private static final int KEY_BITS;
    private static final char[] SYMBOL;
    private final int length;
    private final Random random;

    static {
        int i10;
        StringBuilder sb2 = new StringBuilder();
        for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
            sb2.append(c10);
        }
        for (char c11 = 'a'; c11 <= 'z'; c11 = (char) (c11 + 1)) {
            sb2.append(c11);
        }
        for (char c12 = 'A'; c12 <= 'Z'; c12 = (char) (c12 + 1)) {
            sb2.append(c12);
        }
        char[] charArray = sb2.toString().toCharArray();
        SYMBOL = charArray;
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(charArray.length);
        if (Integer.bitCount(charArray.length) == numberOfLeadingZeros) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        KEY_BITS = numberOfLeadingZeros - i10;
    }

    public RandomString() {
        this(8);
    }

    public static String hashOf(@MaybeNull Object obj) {
        int i10;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = System.identityHashCode(obj) ^ obj.getClass().hashCode();
        }
        return hashOf(i10);
    }

    public static String make() {
        return make(8);
    }

    @SuppressFBWarnings(justification = "Random value is used on each invocation.", value = {"DMI_RANDOM_USED_ONLY_ONCE"})
    public String nextString() {
        char[] cArr = new char[this.length];
        for (int i10 = 0; i10 < this.length; i10++) {
            char[] cArr2 = SYMBOL;
            cArr[i10] = cArr2[this.random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public RandomString(int i10) {
        this(i10, new Random());
    }

    public static String make(int i10) {
        return new RandomString(i10).nextString();
    }

    public RandomString(int i10, Random random2) {
        if (i10 > 0) {
            this.length = i10;
            this.random = random2;
            return;
        }
        throw new IllegalArgumentException("A random string's length cannot be zero or negative");
    }

    public static String hashOf(int i10) {
        int i11 = KEY_BITS;
        int i12 = (32 / i11) + (32 % i11 == 0 ? 0 : 1);
        char[] cArr = new char[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            char[] cArr2 = SYMBOL;
            int i14 = KEY_BITS;
            cArr[i13] = cArr2[(-1 >>> (32 - i14)) & (i10 >>> (i13 * i14))];
        }
        return new String(cArr);
    }
}
