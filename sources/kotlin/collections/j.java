package kotlin.collections;

import gk.l;
import gk.n;
import gk.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

class j extends i {
    public static <T> String c(T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder((j.g(tArr.length, 429496729) * 5) + 2);
        d(tArr, sb2, new ArrayList());
        String sb3 = sb2.toString();
        kotlin.jvm.internal.j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    private static final <T> void d(T[] tArr, StringBuilder sb2, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb2.append("[...]");
            return;
        }
        list.add(tArr);
        sb2.append('[');
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(", ");
            }
            T t10 = tArr[i10];
            if (t10 == null) {
                sb2.append("null");
            } else if (t10 instanceof Object[]) {
                d((Object[]) t10, sb2, list);
            } else if (t10 instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t10);
                kotlin.jvm.internal.j.f(arrays, "toString(this)");
                sb2.append(arrays);
            } else if (t10 instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t10);
                kotlin.jvm.internal.j.f(arrays2, "toString(this)");
                sb2.append(arrays2);
            } else if (t10 instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t10);
                kotlin.jvm.internal.j.f(arrays3, "toString(this)");
                sb2.append(arrays3);
            } else if (t10 instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t10);
                kotlin.jvm.internal.j.f(arrays4, "toString(this)");
                sb2.append(arrays4);
            } else if (t10 instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t10);
                kotlin.jvm.internal.j.f(arrays5, "toString(this)");
                sb2.append(arrays5);
            } else if (t10 instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t10);
                kotlin.jvm.internal.j.f(arrays6, "toString(this)");
                sb2.append(arrays6);
            } else if (t10 instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t10);
                kotlin.jvm.internal.j.f(arrays7, "toString(this)");
                sb2.append(arrays7);
            } else if (t10 instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t10);
                kotlin.jvm.internal.j.f(arrays8, "toString(this)");
                sb2.append(arrays8);
            } else if (t10 instanceof gk.j) {
                sb2.append(c.a(((gk.j) t10).s()));
            } else if (t10 instanceof q) {
                sb2.append(c.c(((q) t10).s()));
            } else if (t10 instanceof l) {
                sb2.append(c.b(((l) t10).s()));
            } else if (t10 instanceof n) {
                sb2.append(c.d(((n) t10).s()));
            } else {
                sb2.append(t10.toString());
            }
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        list.remove(q.l(list));
    }
}
