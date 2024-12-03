package y3;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.a;
import y3.c;

public class f implements d {
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z10;
        if (a.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean isLoggable = Log.isLoggable("ConnectivityMonitor", 3);
        if (z10) {
            return new e(context, aVar);
        }
        return new j();
    }
}
