package il;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import jl.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ll.b;
import ll.e;
import okhttp3.Protocol;
import okhttp3.x;
import okio.Buffer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jivesoftware.smack.util.TLSUtils;

@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\bH\u0016¨\u0006."}, d2 = {"Lil/j;", "", "Ljavax/net/ssl/SSLContext;", "m", "Ljavax/net/ssl/X509TrustManager;", "o", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "e", "b", "g", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "f", "message", "level", "", "t", "j", "", "i", "closer", "h", "stackTrace", "l", "trustManager", "Lll/c;", "c", "Lll/e;", "d", "Ljavax/net/ssl/SSLSocketFactory;", "n", "toString", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30050a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f30051b;

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f30052c = Logger.getLogger(x.class.getName());

    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001c\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lil/j$a;", "", "Lil/j;", "f", "d", "e", "g", "", "Lokhttp3/Protocol;", "protocols", "", "b", "", "c", "", "j", "()Z", "isConscryptPreferred", "k", "isOpenJSSEPreferred", "i", "isBouncyCastlePreferred", "h", "isAndroid", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "platform", "Lil/j;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final j d() {
            c.f31896a.b();
            j a10 = a.f30020e.a();
            if (a10 != null) {
                return a10;
            }
            j a11 = b.f30023f.a();
            kotlin.jvm.internal.j.d(a11);
            return a11;
        }

        private final j e() {
            i a10;
            c a11;
            d b10;
            if (j() && (b10 = d.f30032e.b()) != null) {
                return b10;
            }
            if (i() && (a11 = c.f30029e.a()) != null) {
                return a11;
            }
            if (k() && (a10 = i.f30047e.a()) != null) {
                return a10;
            }
            h a12 = h.f30045d.a();
            if (a12 != null) {
                return a12;
            }
            j a13 = e.f30036i.a();
            if (a13 != null) {
                return a13;
            }
            return new j();
        }

        /* access modifiers changed from: private */
        public final j f() {
            if (h()) {
                return d();
            }
            return e();
        }

        private final boolean i() {
            return kotlin.jvm.internal.j.b(BouncyCastleProvider.PROVIDER_NAME, Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return kotlin.jvm.internal.j.b("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return kotlin.jvm.internal.j.b("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final List<String> b(List<? extends Protocol> list) {
            boolean z10;
            kotlin.jvm.internal.j.g(list, "protocols");
            ArrayList<Protocol> arrayList = new ArrayList<>();
            for (T next : list) {
                if (((Protocol) next) != Protocol.HTTP_1_0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
            for (Protocol protocol : arrayList) {
                arrayList2.add(protocol.toString());
            }
            return arrayList2;
        }

        public final byte[] c(List<? extends Protocol> list) {
            kotlin.jvm.internal.j.g(list, "protocols");
            Buffer buffer = new Buffer();
            for (String next : b(list)) {
                buffer.writeByte(next.length());
                buffer.h0(next);
            }
            return buffer.V0();
        }

        public final j g() {
            return j.f30051b;
        }

        public final boolean h() {
            return kotlin.jvm.internal.j.b("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    static {
        a aVar = new a((DefaultConstructorMarker) null);
        f30050a = aVar;
        f30051b = aVar.f();
    }

    public static /* synthetic */ void k(j jVar, String str, int i10, Throwable th2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 4;
            }
            if ((i11 & 4) != 0) {
                th2 = null;
            }
            jVar.j(str, i10, th2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void b(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
    }

    public ll.c c(X509TrustManager x509TrustManager) {
        kotlin.jvm.internal.j.g(x509TrustManager, "trustManager");
        return new ll.a(d(x509TrustManager));
    }

    public e d(X509TrustManager x509TrustManager) {
        kotlin.jvm.internal.j.g(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        kotlin.jvm.internal.j.f(acceptedIssuers, "trustManager.acceptedIssuers");
        return new b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sSLSocket, String str, List<Protocol> list) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        kotlin.jvm.internal.j.g(socket, "socket");
        kotlin.jvm.internal.j.g(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i10);
    }

    public String g(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        return null;
    }

    public Object h(String str) {
        kotlin.jvm.internal.j.g(str, "closer");
        if (f30052c.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean i(String str) {
        kotlin.jvm.internal.j.g(str, "hostname");
        return true;
    }

    public void j(String str, int i10, Throwable th2) {
        Level level;
        kotlin.jvm.internal.j.g(str, "message");
        if (i10 == 5) {
            level = Level.WARNING;
        } else {
            level = Level.INFO;
        }
        f30052c.log(level, str, th2);
    }

    public void l(String str, Object obj) {
        kotlin.jvm.internal.j.g(str, "message");
        if (obj == null) {
            str = kotlin.jvm.internal.j.p(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        j(str, 5, (Throwable) obj);
    }

    public SSLContext m() {
        SSLContext instance = SSLContext.getInstance(TLSUtils.TLS);
        kotlin.jvm.internal.j.f(instance, "getInstance(\"TLS\")");
        return instance;
    }

    public SSLSocketFactory n(X509TrustManager x509TrustManager) {
        kotlin.jvm.internal.j.g(x509TrustManager, "trustManager");
        try {
            SSLContext m10 = m();
            m10.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            SSLSocketFactory socketFactory = m10.getSocketFactory();
            kotlin.jvm.internal.j.f(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError(kotlin.jvm.internal.j.p("No System TLS: ", e10), e10);
        }
    }

    public X509TrustManager o() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        kotlin.jvm.internal.j.d(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        String arrays = Arrays.toString(trustManagers);
        kotlin.jvm.internal.j.f(arrays, "toString(this)");
        throw new IllegalStateException(kotlin.jvm.internal.j.p("Unexpected default trust managers: ", arrays).toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
