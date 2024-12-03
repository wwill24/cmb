package me;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class g {
    @NonNull
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @NonNull
    @Deprecated
    public static <T> List<T> b(@NonNull T t10) {
        return Collections.singletonList(t10);
    }

    @NonNull
    @Deprecated
    public static <T> List<T> c(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return b(tArr[0]);
    }
}
