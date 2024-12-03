package jl;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import il.j;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017¨\u0006\u0011"}, d2 = {"Ljl/a;", "Ljl/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "isSupported", "", "b", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
@SuppressLint({"NewApi"})
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final C0364a f31892a = new C0364a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljl/a$a;", "", "Ljl/k;", "a", "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: jl.a$a  reason: collision with other inner class name */
    public static final class C0364a {
        private C0364a() {
        }

        public /* synthetic */ C0364a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return j.f30050a.h() && Build.VERSION.SDK_INT >= 29;
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @SuppressLint({"NewApi"})
    public String b(SSLSocket sSLSocket) {
        boolean z10;
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        String a10 = sSLSocket.getApplicationProtocol();
        if (a10 == null) {
            z10 = true;
        } else {
            z10 = kotlin.jvm.internal.j.b(a10, "");
        }
        if (z10) {
            return null;
        }
        return a10;
    }

    @SuppressLint({"NewApi"})
    public void c(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Object[] array2 = j.f30050a.b(list).toArray(new String[0]);
            if (array2 != null) {
                sSLParameters.setApplicationProtocols((String[]) array2);
                sSLSocket.setSSLParameters(sSLParameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }

    public boolean isSupported() {
        return f31892a.b();
    }
}
