package org.jivesoftware.smack.util;

public class BooleansUtils {
    public static boolean contains(boolean[] zArr, boolean z10) {
        for (boolean z11 : zArr) {
            if (z11 == z10) {
                return true;
            }
        }
        return false;
    }

    public static int numberOf(boolean[] zArr, boolean z10) {
        int i10 = 0;
        for (boolean z11 : zArr) {
            if (z11 == z10) {
                i10++;
            }
        }
        return i10;
    }
}
