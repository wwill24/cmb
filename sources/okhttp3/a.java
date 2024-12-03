package okhttp3;

import bl.d;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.t;
import org.jivesoftware.smackx.dox.element.DnsIq;

@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010B\u001a\u00020\n\u0012\u0006\u0010C\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010+\u001a\u00020&\u0012\b\u00100\u001a\u0004\u0018\u00010,\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0;\u0012\u0006\u00105\u001a\u000201¢\u0006\u0004\bD\u0010EJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010!\u001a\u0004\u0018\u00010\u001d8\u0007¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u0004\u0018\u00010\"8\u0007¢\u0006\f\n\u0004\b\u001f\u0010#\u001a\u0004\b\r\u0010$R\u0017\u0010+\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00100\u001a\u0004\u0018\u00010,8\u0007¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R\u0017\u00105\u001a\u0002018\u0007¢\u0006\f\n\u0004\b)\u00102\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u0002068G¢\u0006\f\n\u0004\b3\u00107\u001a\u0004\b8\u00109R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8G¢\u0006\f\n\u0004\b\u0015\u0010=\u001a\u0004\b'\u0010>R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020@0;8G¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b\u0013\u0010>¨\u0006F"}, d2 = {"Lokhttp3/a;", "", "other", "", "equals", "", "hashCode", "that", "d", "(Lokhttp3/a;)Z", "", "toString", "Lokhttp3/p;", "a", "Lokhttp3/p;", "c", "()Lokhttp3/p;", "dns", "Ljavax/net/SocketFactory;", "b", "Ljavax/net/SocketFactory;", "j", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "k", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "e", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "certificatePinner", "Lokhttp3/b;", "f", "Lokhttp3/b;", "h", "()Lokhttp3/b;", "proxyAuthenticator", "Ljava/net/Proxy;", "g", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "Ljava/net/ProxySelector;", "i", "()Ljava/net/ProxySelector;", "proxySelector", "Lokhttp3/t;", "Lokhttp3/t;", "l", "()Lokhttp3/t;", "url", "", "Lokhttp3/Protocol;", "Ljava/util/List;", "()Ljava/util/List;", "protocols", "Lokhttp3/k;", "connectionSpecs", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/p;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/b;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final p f32847a;

    /* renamed from: b  reason: collision with root package name */
    private final SocketFactory f32848b;

    /* renamed from: c  reason: collision with root package name */
    private final SSLSocketFactory f32849c;

    /* renamed from: d  reason: collision with root package name */
    private final HostnameVerifier f32850d;

    /* renamed from: e  reason: collision with root package name */
    private final CertificatePinner f32851e;

    /* renamed from: f  reason: collision with root package name */
    private final b f32852f;

    /* renamed from: g  reason: collision with root package name */
    private final Proxy f32853g;

    /* renamed from: h  reason: collision with root package name */
    private final ProxySelector f32854h;

    /* renamed from: i  reason: collision with root package name */
    private final t f32855i;

    /* renamed from: j  reason: collision with root package name */
    private final List<Protocol> f32856j;

    /* renamed from: k  reason: collision with root package name */
    private final List<k> f32857k;

    public a(String str, int i10, p pVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, b bVar, Proxy proxy, List<? extends Protocol> list, List<k> list2, ProxySelector proxySelector) {
        String str2;
        j.g(str, "uriHost");
        j.g(pVar, DnsIq.ELEMENT);
        j.g(socketFactory, "socketFactory");
        j.g(bVar, "proxyAuthenticator");
        j.g(list, "protocols");
        j.g(list2, "connectionSpecs");
        j.g(proxySelector, "proxySelector");
        this.f32847a = pVar;
        this.f32848b = socketFactory;
        this.f32849c = sSLSocketFactory;
        this.f32850d = hostnameVerifier;
        this.f32851e = certificatePinner;
        this.f32852f = bVar;
        this.f32853g = proxy;
        this.f32854h = proxySelector;
        t.a aVar = new t.a();
        if (sSLSocketFactory != null) {
            str2 = "https";
        } else {
            str2 = "http";
        }
        this.f32855i = aVar.z(str2).o(str).u(i10).c();
        this.f32856j = d.S(list);
        this.f32857k = d.S(list2);
    }

    public final CertificatePinner a() {
        return this.f32851e;
    }

    public final List<k> b() {
        return this.f32857k;
    }

    public final p c() {
        return this.f32847a;
    }

    public final boolean d(a aVar) {
        j.g(aVar, "that");
        if (!j.b(this.f32847a, aVar.f32847a) || !j.b(this.f32852f, aVar.f32852f) || !j.b(this.f32856j, aVar.f32856j) || !j.b(this.f32857k, aVar.f32857k) || !j.b(this.f32854h, aVar.f32854h) || !j.b(this.f32853g, aVar.f32853g) || !j.b(this.f32849c, aVar.f32849c) || !j.b(this.f32850d, aVar.f32850d) || !j.b(this.f32851e, aVar.f32851e) || this.f32855i.o() != aVar.f32855i.o()) {
            return false;
        }
        return true;
    }

    public final HostnameVerifier e() {
        return this.f32850d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (!j.b(this.f32855i, aVar.f32855i) || !d(aVar)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final List<Protocol> f() {
        return this.f32856j;
    }

    public final Proxy g() {
        return this.f32853g;
    }

    public final b h() {
        return this.f32852f;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f32855i.hashCode()) * 31) + this.f32847a.hashCode()) * 31) + this.f32852f.hashCode()) * 31) + this.f32856j.hashCode()) * 31) + this.f32857k.hashCode()) * 31) + this.f32854h.hashCode()) * 31) + Objects.hashCode(this.f32853g)) * 31) + Objects.hashCode(this.f32849c)) * 31) + Objects.hashCode(this.f32850d)) * 31) + Objects.hashCode(this.f32851e);
    }

    public final ProxySelector i() {
        return this.f32854h;
    }

    public final SocketFactory j() {
        return this.f32848b;
    }

    public final SSLSocketFactory k() {
        return this.f32849c;
    }

    public final t l() {
        return this.f32855i;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f32855i.i());
        sb2.append(':');
        sb2.append(this.f32855i.o());
        sb2.append(", ");
        Object obj = this.f32853g;
        if (obj != null) {
            str = "proxy=";
        } else {
            obj = this.f32854h;
            str = "proxySelector=";
        }
        sb2.append(j.p(str, obj));
        sb2.append('}');
        return sb2.toString();
    }
}
