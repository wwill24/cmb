package kotlin.text;

import kotlin.ranges.IntRange;

class b {
    public static int a(int i10) {
        if (new IntRange(2, 36).m(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c10, int i10) {
        return Character.digit(c10, i10);
    }

    public static final boolean c(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }
}
