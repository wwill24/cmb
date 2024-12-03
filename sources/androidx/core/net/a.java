package androidx.core.net;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;

public final class a {

    /* renamed from: androidx.core.net.a$a  reason: collision with other inner class name */
    static class C0038a {
        static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    public static boolean a(@NonNull ConnectivityManager connectivityManager) {
        return C0038a.a(connectivityManager);
    }
}
