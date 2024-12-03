package f2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import d2.b;
import h2.k;
import h2.m;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lf2/j;", "Lf2/h;", "Ld2/b;", "", "h", "i", "Landroid/net/ConnectivityManager;", "f", "Landroid/net/ConnectivityManager;", "connectivityManager", "f2/j$a", "g", "Lf2/j$a;", "networkCallback", "k", "()Ld2/b;", "initialState", "Landroid/content/Context;", "context", "Li2/b;", "taskExecutor", "<init>", "(Landroid/content/Context;Li2/b;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class j extends h<b> {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ConnectivityManager f14654f;

    /* renamed from: g  reason: collision with root package name */
    private final a f14655g = new a(this);

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"f2/j$a", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "capabilities", "", "onCapabilitiesChanged", "onLost", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f14656a;

        a(j jVar) {
            this.f14656a = jVar;
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            kotlin.jvm.internal.j.g(network, "network");
            kotlin.jvm.internal.j.g(networkCapabilities, "capabilities");
            f e10 = f.e();
            String b10 = k.f14657a;
            e10.a(b10, "Network capabilities changed: " + networkCapabilities);
            j jVar = this.f14656a;
            jVar.g(k.c(jVar.f14654f));
        }

        public void onLost(Network network) {
            kotlin.jvm.internal.j.g(network, "network");
            f.e().a(k.f14657a, "Network connection lost");
            j jVar = this.f14656a;
            jVar.g(k.c(jVar.f14654f));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context, i2.b bVar) {
        super(context, bVar);
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(bVar, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        kotlin.jvm.internal.j.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f14654f = (ConnectivityManager) systemService;
    }

    public void h() {
        try {
            f.e().a(k.f14657a, "Registering network callback");
            m.a(this.f14654f, this.f14655g);
        } catch (IllegalArgumentException e10) {
            f.e().d(k.f14657a, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            f.e().d(k.f14657a, "Received exception while registering network callback", e11);
        }
    }

    public void i() {
        try {
            f.e().a(k.f14657a, "Unregistering network callback");
            k.c(this.f14654f, this.f14655g);
        } catch (IllegalArgumentException e10) {
            f.e().d(k.f14657a, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            f.e().d(k.f14657a, "Received exception while unregistering network callback", e11);
        }
    }

    /* renamed from: k */
    public b e() {
        return k.c(this.f14654f);
    }
}
