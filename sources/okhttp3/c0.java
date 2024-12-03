package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lokhttp3/c0;", "", "", "c", "other", "equals", "", "hashCode", "", "toString", "Lokhttp3/a;", "a", "Lokhttp3/a;", "()Lokhttp3/a;", "address", "Ljava/net/Proxy;", "b", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "Ljava/net/InetSocketAddress;", "d", "()Ljava/net/InetSocketAddress;", "socketAddress", "<init>", "(Lokhttp3/a;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f32896a;

    /* renamed from: b  reason: collision with root package name */
    private final Proxy f32897b;

    /* renamed from: c  reason: collision with root package name */
    private final InetSocketAddress f32898c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        j.g(aVar, "address");
        j.g(proxy, "proxy");
        j.g(inetSocketAddress, "socketAddress");
        this.f32896a = aVar;
        this.f32897b = proxy;
        this.f32898c = inetSocketAddress;
    }

    public final a a() {
        return this.f32896a;
    }

    public final Proxy b() {
        return this.f32897b;
    }

    public final boolean c() {
        return this.f32896a.k() != null && this.f32897b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.f32898c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (!j.b(c0Var.f32896a, this.f32896a) || !j.b(c0Var.f32897b, this.f32897b) || !j.b(c0Var.f32898c, this.f32898c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f32896a.hashCode()) * 31) + this.f32897b.hashCode()) * 31) + this.f32898c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f32898c + '}';
    }
}
