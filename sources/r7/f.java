package r7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.coffeemeetsbagel.utils.model.Optional;
import com.jakewharton.rxrelay2.b;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private Optional<NetworkInfo> f17381a = Optional.a();

    /* renamed from: b  reason: collision with root package name */
    private final b<Optional<NetworkInfo>> f17382b = b.D0(Optional.a());

    class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectivityManager f17383a;

        a(ConnectivityManager connectivityManager) {
            this.f17383a = connectivityManager;
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            f.this.e(this.f17383a.getActiveNetworkInfo());
        }

        public void onLost(Network network) {
            super.onLost(network);
            f.this.e(this.f17383a.getActiveNetworkInfo());
        }
    }

    public f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new a(connectivityManager));
    }

    /* access modifiers changed from: private */
    public void e(NetworkInfo networkInfo) {
        if (this.f17382b.F0()) {
            this.f17381a = this.f17382b.E0();
        }
        this.f17382b.accept(Optional.b(networkInfo));
    }

    public Optional<NetworkInfo> b() {
        return this.f17381a;
    }

    public b<Optional<NetworkInfo>> c() {
        return this.f17382b;
    }

    public boolean d() {
        return this.f17382b.E0().d();
    }
}
