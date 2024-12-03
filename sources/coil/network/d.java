package coil.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.a;
import coil.network.c;
import coil.util.g;
import coil.util.s;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "Lcoil/network/c$a;", "listener", "Lcoil/util/s;", "logger", "Lcoil/network/c;", "a", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class d {
    public static final c a(Context context, c.a aVar, s sVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) a.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null || !coil.util.d.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (sVar != null && sVar.getLevel() <= 5) {
                sVar.a("NetworkObserver", 5, "Unable to register network observer.", (Throwable) null);
            }
            return new b();
        }
        try {
            return new e(connectivityManager, aVar);
        } catch (Exception e10) {
            if (sVar != null) {
                g.a(sVar, "NetworkObserver", new RuntimeException("Failed to register network observer.", e10));
            }
            return new b();
        }
    }
}
