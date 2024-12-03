package h2;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0001\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¨\u0006\r"}, d2 = {"Landroid/net/ConnectivityManager;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "", "c", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "a", "", "capability", "", "b", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class k {
    public static final NetworkCapabilities a(ConnectivityManager connectivityManager, Network network) {
        j.g(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean b(NetworkCapabilities networkCapabilities, int i10) {
        j.g(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i10);
    }

    public static final void c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        j.g(connectivityManager, "<this>");
        j.g(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
