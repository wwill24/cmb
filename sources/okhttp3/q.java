package okhttp3;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 ;2\u00020\u0001:\u000295B\u0007¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J*\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J2\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u00020/H\u0016¨\u0006>"}, d2 = {"Lokhttp3/q;", "", "Lokhttp3/e;", "call", "", "e", "Lokhttp3/t;", "url", "o", "", "Ljava/net/Proxy;", "proxies", "n", "", "domainName", "m", "Ljava/net/InetAddress;", "inetAddressList", "l", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "i", "B", "Lokhttp3/Handshake;", "handshake", "A", "Lokhttp3/Protocol;", "protocol", "g", "Ljava/io/IOException;", "ioe", "h", "Lokhttp3/i;", "connection", "j", "k", "t", "Lokhttp3/y;", "request", "s", "q", "", "byteCount", "p", "r", "y", "Lokhttp3/a0;", "response", "x", "v", "u", "w", "c", "d", "f", "z", "b", "cachedResponse", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33157a = new b((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public static final q f33158b = new a();

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"okhttp3/q$a", "Lokhttp3/q;", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends q {
        a() {
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/q$b;", "", "Lokhttp3/q;", "NONE", "Lokhttp3/q;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lokhttp3/q$c;", "", "Lokhttp3/e;", "call", "Lokhttp3/q;", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface c {
        q a(e eVar);
    }

    public void A(e eVar, Handshake handshake) {
        j.g(eVar, "call");
    }

    public void B(e eVar) {
        j.g(eVar, "call");
    }

    public void a(e eVar, a0 a0Var) {
        j.g(eVar, "call");
        j.g(a0Var, "cachedResponse");
    }

    public void b(e eVar, a0 a0Var) {
        j.g(eVar, "call");
        j.g(a0Var, "response");
    }

    public void c(e eVar) {
        j.g(eVar, "call");
    }

    public void d(e eVar, IOException iOException) {
        j.g(eVar, "call");
        j.g(iOException, "ioe");
    }

    public void e(e eVar) {
        j.g(eVar, "call");
    }

    public void f(e eVar) {
        j.g(eVar, "call");
    }

    public void g(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        j.g(eVar, "call");
        j.g(inetSocketAddress, "inetSocketAddress");
        j.g(proxy, "proxy");
    }

    public void h(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        j.g(eVar, "call");
        j.g(inetSocketAddress, "inetSocketAddress");
        j.g(proxy, "proxy");
        j.g(iOException, "ioe");
    }

    public void i(e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        j.g(eVar, "call");
        j.g(inetSocketAddress, "inetSocketAddress");
        j.g(proxy, "proxy");
    }

    public void j(e eVar, i iVar) {
        j.g(eVar, "call");
        j.g(iVar, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
    }

    public void k(e eVar, i iVar) {
        j.g(eVar, "call");
        j.g(iVar, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
    }

    public void l(e eVar, String str, List<InetAddress> list) {
        j.g(eVar, "call");
        j.g(str, "domainName");
        j.g(list, "inetAddressList");
    }

    public void m(e eVar, String str) {
        j.g(eVar, "call");
        j.g(str, "domainName");
    }

    public void n(e eVar, t tVar, List<Proxy> list) {
        j.g(eVar, "call");
        j.g(tVar, "url");
        j.g(list, "proxies");
    }

    public void o(e eVar, t tVar) {
        j.g(eVar, "call");
        j.g(tVar, "url");
    }

    public void p(e eVar, long j10) {
        j.g(eVar, "call");
    }

    public void q(e eVar) {
        j.g(eVar, "call");
    }

    public void r(e eVar, IOException iOException) {
        j.g(eVar, "call");
        j.g(iOException, "ioe");
    }

    public void s(e eVar, y yVar) {
        j.g(eVar, "call");
        j.g(yVar, "request");
    }

    public void t(e eVar) {
        j.g(eVar, "call");
    }

    public void u(e eVar, long j10) {
        j.g(eVar, "call");
    }

    public void v(e eVar) {
        j.g(eVar, "call");
    }

    public void w(e eVar, IOException iOException) {
        j.g(eVar, "call");
        j.g(iOException, "ioe");
    }

    public void x(e eVar, a0 a0Var) {
        j.g(eVar, "call");
        j.g(a0Var, "response");
    }

    public void y(e eVar) {
        j.g(eVar, "call");
    }

    public void z(e eVar, a0 a0Var) {
        j.g(eVar, "call");
        j.g(a0Var, "response");
    }
}
