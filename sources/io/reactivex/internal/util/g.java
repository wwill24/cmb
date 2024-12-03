package io.reactivex.internal.util;

public final class g {
    public static int a(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
