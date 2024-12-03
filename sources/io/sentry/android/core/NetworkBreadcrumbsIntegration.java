package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.NonNull;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.ConnectivityChecker;
import io.sentry.d;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.util.l;
import io.sentry.w;
import java.io.Closeable;
import java.io.IOException;

public final class NetworkBreadcrumbsIntegration implements Integration, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30872a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f30873b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f30874c;

    /* renamed from: d  reason: collision with root package name */
    b f30875d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f30876a;

        /* renamed from: b  reason: collision with root package name */
        final int f30877b;

        /* renamed from: c  reason: collision with root package name */
        final int f30878c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f30879d;

        /* renamed from: e  reason: collision with root package name */
        final String f30880e;

        @SuppressLint({"NewApi", "ObsoleteSdkInt"})
        a(NetworkCapabilities networkCapabilities, i0 i0Var) {
            int i10;
            l.c(networkCapabilities, "NetworkCapabilities is required");
            l.c(i0Var, "BuildInfoProvider is required");
            this.f30876a = networkCapabilities.getLinkDownstreamBandwidthKbps();
            this.f30877b = networkCapabilities.getLinkUpstreamBandwidthKbps();
            int i11 = 0;
            if (i0Var.d() >= 29) {
                i10 = networkCapabilities.getSignalStrength();
            } else {
                i10 = 0;
            }
            this.f30878c = i10 > -100 ? i10 : i11;
            this.f30879d = networkCapabilities.hasTransport(4);
            String d10 = ConnectivityChecker.d(networkCapabilities, i0Var);
            this.f30880e = d10 == null ? "" : d10;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a aVar) {
            if (this.f30879d == aVar.f30879d && this.f30880e.equals(aVar.f30880e)) {
                int i10 = this.f30878c;
                int i11 = aVar.f30878c;
                if (-5 <= i10 - i11 && i10 - i11 <= 5) {
                    int i12 = this.f30876a;
                    int i13 = aVar.f30876a;
                    if (-1000 <= i12 - i13 && i12 - i13 <= 1000) {
                        int i14 = this.f30877b;
                        int i15 = aVar.f30877b;
                        if (-1000 > i14 - i15 || i14 - i15 > 1000) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    static final class b extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final g0 f30881a;

        /* renamed from: b  reason: collision with root package name */
        final i0 f30882b;

        /* renamed from: c  reason: collision with root package name */
        Network f30883c = null;

        /* renamed from: d  reason: collision with root package name */
        NetworkCapabilities f30884d = null;

        b(g0 g0Var, i0 i0Var) {
            this.f30881a = (g0) l.c(g0Var, "Hub is required");
            this.f30882b = (i0) l.c(i0Var, "BuildInfoProvider is required");
        }

        private d a(String str) {
            d dVar = new d();
            dVar.p("system");
            dVar.l("network.event");
            dVar.m("action", str);
            dVar.n(SentryLevel.INFO);
            return dVar;
        }

        private a b(NetworkCapabilities networkCapabilities, NetworkCapabilities networkCapabilities2) {
            if (networkCapabilities == null) {
                return new a(networkCapabilities2, this.f30882b);
            }
            a aVar = new a(networkCapabilities, this.f30882b);
            a aVar2 = new a(networkCapabilities2, this.f30882b);
            if (aVar2.a(aVar)) {
                return null;
            }
            return aVar2;
        }

        public void onAvailable(@NonNull Network network) {
            if (!network.equals(this.f30883c)) {
                this.f30881a.q(a("NETWORK_AVAILABLE"));
                this.f30883c = network;
                this.f30884d = null;
            }
        }

        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            a b10;
            if (network.equals(this.f30883c) && (b10 = b(this.f30884d, networkCapabilities)) != null) {
                this.f30884d = networkCapabilities;
                d a10 = a("NETWORK_CAPABILITIES_CHANGED");
                a10.m("download_bandwidth", Integer.valueOf(b10.f30876a));
                a10.m("upload_bandwidth", Integer.valueOf(b10.f30877b));
                a10.m("vpn_active", Boolean.valueOf(b10.f30879d));
                a10.m("network_type", b10.f30880e);
                int i10 = b10.f30878c;
                if (i10 != 0) {
                    a10.m("signal_strength", Integer.valueOf(i10));
                }
                w wVar = new w();
                wVar.i("android:networkCapabilities", b10);
                this.f30881a.t(a10, wVar);
            }
        }

        public void onLost(@NonNull Network network) {
            if (network.equals(this.f30883c)) {
                this.f30881a.q(a("NETWORK_LOST"));
                this.f30883c = null;
                this.f30884d = null;
            }
        }
    }

    public NetworkBreadcrumbsIntegration(Context context, i0 i0Var, h0 h0Var) {
        this.f30872a = (Context) l.c(context, "Context is required");
        this.f30873b = (i0) l.c(i0Var, "BuildInfoProvider is required");
        this.f30874c = (h0) l.c(h0Var, "ILogger is required");
    }

    @SuppressLint({"NewApi"})
    public void a(g0 g0Var, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions;
        l.c(g0Var, "Hub is required");
        if (sentryOptions instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions) sentryOptions;
        } else {
            sentryAndroidOptions = null;
        }
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        h0 h0Var = this.f30874c;
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        h0Var.c(sentryLevel, "NetworkBreadcrumbsIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions2.isEnableNetworkEventBreadcrumbs()));
        if (!sentryAndroidOptions2.isEnableNetworkEventBreadcrumbs()) {
            return;
        }
        if (this.f30873b.d() < 21) {
            this.f30875d = null;
            this.f30874c.c(sentryLevel, "NetworkBreadcrumbsIntegration requires Android 5+", new Object[0]);
            return;
        }
        b bVar = new b(g0Var, this.f30873b);
        this.f30875d = bVar;
        if (!ConnectivityChecker.f(this.f30872a, this.f30874c, this.f30873b, bVar)) {
            this.f30875d = null;
            this.f30874c.c(sentryLevel, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
            return;
        }
        this.f30874c.c(sentryLevel, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
        c();
    }

    public void close() throws IOException {
        b bVar = this.f30875d;
        if (bVar != null) {
            ConnectivityChecker.g(this.f30872a, this.f30874c, this.f30873b, bVar);
            this.f30874c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration remove.", new Object[0]);
        }
        this.f30875d = null;
    }
}
