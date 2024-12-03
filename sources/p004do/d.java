package p004do;

import kotlin.jvm.internal.j;

/* renamed from: do.d  reason: invalid package */
public final class d {
    public static final double a(String str) {
        j.g(str, "<this>");
        Double i10 = p.i(str);
        if (i10 != null) {
            return i10.doubleValue();
        }
        return 0.0d;
    }

    public static final int b(String str) {
        j.g(str, "<this>");
        return (int) a(str);
    }

    public static final long c(String str) {
        j.g(str, "<this>");
        return (long) a(str);
    }
}
