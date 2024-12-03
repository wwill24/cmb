package okhttp3.internal.connection;

import bl.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.q;
import okhttp3.t;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0002\f\tB'\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\bH\u0002J\t\u0010\u000e\u001a\u00020\rH\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001c¨\u0006+"}, d2 = {"Lokhttp3/internal/connection/h;", "", "Lokhttp3/t;", "url", "Ljava/net/Proxy;", "proxy", "", "f", "", "b", "d", "e", "a", "Lokhttp3/internal/connection/h$b;", "c", "Lokhttp3/a;", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "routeDatabase", "Lokhttp3/e;", "Lokhttp3/e;", "call", "Lokhttp3/q;", "Lokhttp3/q;", "eventListener", "", "Ljava/util/List;", "proxies", "", "I", "nextProxyIndex", "Ljava/net/InetSocketAddress;", "g", "inetSocketAddresses", "", "Lokhttp3/c0;", "h", "postponedRoutes", "<init>", "(Lokhttp3/a;Lokhttp3/internal/connection/g;Lokhttp3/e;Lokhttp3/q;)V", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* renamed from: i  reason: collision with root package name */
    public static final a f33078i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final okhttp3.a f33079a;

    /* renamed from: b  reason: collision with root package name */
    private final g f33080b;

    /* renamed from: c  reason: collision with root package name */
    private final e f33081c;

    /* renamed from: d  reason: collision with root package name */
    private final q f33082d;

    /* renamed from: e  reason: collision with root package name */
    private List<? extends Proxy> f33083e = q.j();

    /* renamed from: f  reason: collision with root package name */
    private int f33084f;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends InetSocketAddress> f33085g = q.j();

    /* renamed from: h  reason: collision with root package name */
    private final List<c0> f33086h = new ArrayList();

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/h$a;", "", "Ljava/net/InetSocketAddress;", "", "a", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            j.g(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                j.f(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            j.f(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/connection/h$b;", "", "", "b", "Lokhttp3/c0;", "c", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "routes", "", "I", "nextRouteIndex", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<c0> f33087a;

        /* renamed from: b  reason: collision with root package name */
        private int f33088b;

        public b(List<c0> list) {
            j.g(list, "routes");
            this.f33087a = list;
        }

        public final List<c0> a() {
            return this.f33087a;
        }

        public final boolean b() {
            return this.f33088b < this.f33087a.size();
        }

        public final c0 c() {
            if (b()) {
                List<c0> list = this.f33087a;
                int i10 = this.f33088b;
                this.f33088b = i10 + 1;
                return list.get(i10);
            }
            throw new NoSuchElementException();
        }
    }

    public h(okhttp3.a aVar, g gVar, e eVar, q qVar) {
        j.g(aVar, "address");
        j.g(gVar, "routeDatabase");
        j.g(eVar, "call");
        j.g(qVar, "eventListener");
        this.f33079a = aVar;
        this.f33080b = gVar;
        this.f33081c = eVar;
        this.f33082d = qVar;
        f(aVar.l(), aVar.g());
    }

    private final boolean b() {
        return this.f33084f < this.f33083e.size();
    }

    private final Proxy d() throws IOException {
        if (b()) {
            List<? extends Proxy> list = this.f33083e;
            int i10 = this.f33084f;
            this.f33084f = i10 + 1;
            Proxy proxy = (Proxy) list.get(i10);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f33079a.l().i() + "; exhausted proxy configurations: " + this.f33083e);
    }

    private final void e(Proxy proxy) throws IOException {
        String str;
        int i10;
        ArrayList arrayList = new ArrayList();
        this.f33085g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f33079a.l().i();
            i10 = this.f33079a.l().o();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                a aVar = f33078i;
                j.f(address, "proxyAddress");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = aVar.a(inetSocketAddress);
                i10 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(j.p("Proxy.address() is not an InetSocketAddress: ", address.getClass()).toString());
            }
        }
        boolean z10 = false;
        if (1 <= i10 && i10 < 65536) {
            z10 = true;
        }
        if (!z10) {
            throw new SocketException("No route to " + str + ':' + i10 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(str, i10));
        } else {
            this.f33082d.m(this.f33081c, str);
            List<InetAddress> lookup = this.f33079a.c().lookup(str);
            if (!lookup.isEmpty()) {
                this.f33082d.l(this.f33081c, str, lookup);
                for (InetAddress inetSocketAddress2 : lookup) {
                    arrayList.add(new InetSocketAddress(inetSocketAddress2, i10));
                }
                return;
            }
            throw new UnknownHostException(this.f33079a.c() + " returned no addresses for " + str);
        }
    }

    private final void f(t tVar, Proxy proxy) {
        this.f33082d.o(this.f33081c, tVar);
        List<Proxy> g10 = g(proxy, tVar, this);
        this.f33083e = g10;
        this.f33084f = 0;
        this.f33082d.n(this.f33081c, tVar, g10);
    }

    private static final List<Proxy> g(Proxy proxy, t tVar, h hVar) {
        boolean z10;
        if (proxy != null) {
            return p.e(proxy);
        }
        URI t10 = tVar.t();
        if (t10.getHost() == null) {
            return d.w(Proxy.NO_PROXY);
        }
        List<Proxy> select = hVar.f33079a.i().select(t10);
        if (select == null || select.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return d.w(Proxy.NO_PROXY);
        }
        j.f(select, "proxiesOrNull");
        return d.S(select);
    }

    public final boolean a() {
        return b() || (this.f33086h.isEmpty() ^ true);
    }

    public final b c() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (b()) {
                Proxy d10 = d();
                for (InetSocketAddress c0Var : this.f33085g) {
                    c0 c0Var2 = new c0(this.f33079a, d10, c0Var);
                    if (this.f33080b.c(c0Var2)) {
                        this.f33086h.add(c0Var2);
                    } else {
                        arrayList.add(c0Var2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                boolean unused = v.x(arrayList, this.f33086h);
                this.f33086h.clear();
            }
            return new b(arrayList);
        }
        throw new NoSuchElementException();
    }
}
