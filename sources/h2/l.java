package h2;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¨\u0006\u0003"}, d2 = {"Landroid/net/ConnectivityManager;", "Landroid/net/Network;", "a", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class l {
    public static final Network a(ConnectivityManager connectivityManager) {
        j.g(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
