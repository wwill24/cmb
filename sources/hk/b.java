package hk;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b {
    public static final <E> E[] d(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] e(T[] tArr, int i10) {
        j.g(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, i10);
        j.f(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final <E> void f(E[] eArr, int i10) {
        j.g(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void g(E[] eArr, int i10, int i11) {
        j.g(eArr, "<this>");
        while (i10 < i11) {
            f(eArr, i10);
            i10++;
        }
    }

    /* access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i10, int i11, List<?> list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!j.b(tArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i10, int i11) {
        int i12;
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            T t10 = tArr[i10 + i14];
            int i15 = i13 * 31;
            if (t10 != null) {
                i12 = t10.hashCode();
            } else {
                i12 = 0;
            }
            i13 = i15 + i12;
        }
        return i13;
    }

    /* access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(tArr[i10 + i12]);
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        j.f(sb3, "sb.toString()");
        return sb3;
    }
}
