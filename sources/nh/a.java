package nh;

public final class a extends k {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f23803a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f23804b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f23805c = {'A', 'B', 'C', 'D'};

    static boolean a(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }
}
