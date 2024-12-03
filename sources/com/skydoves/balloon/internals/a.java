package com.skydoves.balloon.internals;

public final class a {
    public static final /* synthetic */ Integer a(int i10) {
        Integer valueOf = Integer.valueOf(i10);
        valueOf.intValue();
        if (i10 != Integer.MIN_VALUE) {
            return valueOf;
        }
        return null;
    }

    public static final /* synthetic */ int b(int i10, boolean z10) {
        return z10 ? -i10 : i10;
    }
}
