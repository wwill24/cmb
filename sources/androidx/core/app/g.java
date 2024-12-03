package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;

public final class g {

    static class a {
        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    public static IBinder a(@NonNull Bundle bundle, String str) {
        return a.a(bundle, str);
    }

    public static void b(@NonNull Bundle bundle, String str, IBinder iBinder) {
        a.b(bundle, str, iBinder);
    }
}
