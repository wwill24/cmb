package jl;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013¨\u0006\u0017"}, d2 = {"Ljl/j;", "Ljl/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "d", "", "isSupported", "a", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "c", "b", "Ljl/j$a;", "Ljl/j$a;", "socketAdapterFactory", "Ljl/k;", "delegate", "<init>", "(Ljl/j$a;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private final a f31916a;

    /* renamed from: b  reason: collision with root package name */
    private k f31917b;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Ljl/j$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Ljl/k;", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        boolean a(SSLSocket sSLSocket);

        k b(SSLSocket sSLSocket);
    }

    public j(a aVar) {
        kotlin.jvm.internal.j.g(aVar, "socketAdapterFactory");
        this.f31916a = aVar;
    }

    private final synchronized k d(SSLSocket sSLSocket) {
        if (this.f31917b == null && this.f31916a.a(sSLSocket)) {
            this.f31917b = this.f31916a.b(sSLSocket);
        }
        return this.f31917b;
    }

    public boolean a(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        return this.f31916a.a(sSLSocket);
    }

    public String b(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        k d10 = d(sSLSocket);
        if (d10 == null) {
            return null;
        }
        return d10.b(sSLSocket);
    }

    public void c(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
        k d10 = d(sSLSocket);
        if (d10 != null) {
            d10.c(sSLSocket, str, list);
        }
    }

    public boolean isSupported() {
        return true;
    }
}
