package yk;

import java.text.DecimalFormat;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f33998a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f33999b;

    static {
        Class<a> cls = a.class;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f33999b = threadLocalArr;
    }

    public static final boolean a() {
        return f33998a;
    }
}
