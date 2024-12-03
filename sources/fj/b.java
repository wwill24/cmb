package fj;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class b {
    private static int a(int i10) {
        return i10 < 3 ? i10 + 1 : i10 < 1073741824 ? (int) ((((float) i10) / 0.75f) + 1.0f) : a.e.API_PRIORITY_OTHER;
    }

    static <T> HashSet<T> b(int i10) {
        return new HashSet<>(a(i10));
    }

    public static <K, V> LinkedHashMap<K, V> c(int i10) {
        return new LinkedHashMap<>(a(i10));
    }

    public static <T> List<T> d(int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i10);
    }
}
