package cl;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.b;
import okhttp3.c0;
import okhttp3.g;
import okhttp3.n;
import okhttp3.p;
import okhttp3.t;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcl/a;", "Lokhttp3/b;", "Ljava/net/Proxy;", "Lokhttp3/t;", "url", "Lokhttp3/p;", "dns", "Ljava/net/InetAddress;", "b", "Lokhttp3/c0;", "route", "Lokhttp3/a0;", "response", "Lokhttp3/y;", "a", "d", "Lokhttp3/p;", "defaultDns", "<init>", "(Lokhttp3/p;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements b {

    /* renamed from: d  reason: collision with root package name */
    private final p f24949d;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cl.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0298a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24950a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            f24950a = iArr;
        }
    }

    public a(p pVar) {
        j.g(pVar, "defaultDns");
        this.f24949d = pVar;
    }

    private final InetAddress b(Proxy proxy, t tVar, p pVar) throws IOException {
        int i10;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i10 = -1;
        } else {
            i10 = C0298a.f24950a[type.ordinal()];
        }
        if (i10 == 1) {
            return (InetAddress) CollectionsKt___CollectionsKt.N(pVar.lookup(tVar.i()));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            j.f(address2, "address() as InetSocketAddress).address");
            return address2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    public y a(c0 c0Var, a0 a0Var) throws IOException {
        boolean z10;
        Proxy proxy;
        p pVar;
        PasswordAuthentication passwordAuthentication;
        String str;
        okhttp3.a a10;
        j.g(a0Var, "response");
        List<g> e10 = a0Var.e();
        y F = a0Var.F();
        t j10 = F.j();
        if (a0Var.f() == 407) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (c0Var == null) {
            proxy = null;
        } else {
            proxy = c0Var.b();
        }
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (g next : e10) {
            if (r.t("Basic", next.c(), true)) {
                if (c0Var == null || (a10 = c0Var.a()) == null) {
                    pVar = null;
                } else {
                    pVar = a10.c();
                }
                if (pVar == null) {
                    pVar = this.f24949d;
                }
                if (z10) {
                    SocketAddress address = proxy.address();
                    if (address != null) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                        String hostName = inetSocketAddress.getHostName();
                        j.f(proxy, "proxy");
                        passwordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, j10, pVar), inetSocketAddress.getPort(), j10.s(), next.b(), next.c(), j10.u(), Authenticator.RequestorType.PROXY);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                } else {
                    String i10 = j10.i();
                    j.f(proxy, "proxy");
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(i10, b(proxy, j10, pVar), j10.o(), j10.s(), next.b(), next.c(), j10.u(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    if (z10) {
                        str = "Proxy-Authorization";
                    } else {
                        str = "Authorization";
                    }
                    String userName = passwordAuthentication.getUserName();
                    j.f(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    j.f(password, "auth.password");
                    return F.h().f(str, n.a(userName, new String(password), next.a())).b();
                }
            }
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(p pVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? p.f33155b : pVar);
    }
}
