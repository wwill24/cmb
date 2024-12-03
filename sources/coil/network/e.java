package coil.network;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import coil.network.c;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u0004*\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcoil/network/e;", "Lcoil/network/c;", "Landroid/net/Network;", "network", "", "isOnline", "", "d", "c", "shutdown", "Landroid/net/ConnectivityManager;", "a", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lcoil/network/c$a;", "b", "Lcoil/network/c$a;", "listener", "coil/network/e$a", "Lcoil/network/e$a;", "networkCallback", "()Z", "<init>", "(Landroid/net/ConnectivityManager;Lcoil/network/c$a;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"MissingPermission"})
final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectivityManager f8250a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f8251b;

    /* renamed from: c  reason: collision with root package name */
    private final a f8252c;

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"coil/network/e$a", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "", "onAvailable", "onLost", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f8253a;

        a(e eVar) {
            this.f8253a = eVar;
        }

        public void onAvailable(Network network) {
            this.f8253a.d(network, true);
        }

        public void onLost(Network network) {
            this.f8253a.d(network, false);
        }
    }

    public e(ConnectivityManager connectivityManager, c.a aVar) {
        this.f8250a = connectivityManager;
        this.f8251b = aVar;
        a aVar2 = new a(this);
        this.f8252c = aVar2;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar2);
    }

    private final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.f8250a.getNetworkCapabilities(network);
        if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void d(Network network, boolean z10) {
        boolean z11;
        Network[] allNetworks = this.f8250a.getAllNetworks();
        int length = allNetworks.length;
        boolean z12 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Network network2 = allNetworks[i10];
            if (j.b(network2, network)) {
                z11 = z10;
            } else {
                z11 = c(network2);
            }
            if (z11) {
                z12 = true;
                break;
            }
            i10++;
        }
        this.f8251b.a(z12);
    }

    public boolean a() {
        for (Network c10 : this.f8250a.getAllNetworks()) {
            if (c(c10)) {
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
        this.f8250a.unregisterNetworkCallback(this.f8252c);
    }
}
