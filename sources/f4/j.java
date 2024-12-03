package f4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collection;

public final class j {
    public static void a(boolean z10, @NonNull String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t10) {
        if (!t10.isEmpty()) {
            return t10;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    @NonNull
    public static <T> T d(T t10) {
        return e(t10, "Argument must not be null");
    }

    @NonNull
    public static <T> T e(T t10, @NonNull String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
