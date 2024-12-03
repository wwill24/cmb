package jl;

import il.d;
import java.util.List;
import javax.net.ssl.SSLSocket;
import jl.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\u0011"}, d2 = {"Ljl/i;", "Ljl/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "isSupported", "", "b", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class i implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31914a = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final j.a f31915b = new a();

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"jl/i$a", "Ljl/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Ljl/k;", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a implements j.a {
        a() {
        }

        public boolean a(SSLSocket sSLSocket) {
            kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
            return d.f30032e.c() && Conscrypt.isConscrypt(sSLSocket);
        }

        public k b(SSLSocket sSLSocket) {
            kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
            return new i();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Ljl/i$b;", "", "Ljl/j$a;", "factory", "Ljl/j$a;", "a", "()Ljl/j$a;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j.a a() {
            return i.f31915b;
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    public String b(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    public void c(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array2 = il.j.f30050a.b(list).toArray(new String[0]);
            if (array2 != null) {
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public boolean isSupported() {
        return d.f30032e.c();
    }
}
