package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.NonNull;

public final class f {

    static class a {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    @NonNull
    public static j a(@NonNull Configuration configuration) {
        return j.h(a.a(configuration));
    }
}
