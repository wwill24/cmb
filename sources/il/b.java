package il;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import jl.f;
import jl.g;
import jl.h;
import jl.i;
import jl.k;
import jl.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ll.c;
import ll.e;
import okhttp3.Protocol;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010%¨\u0006+"}, d2 = {"Lil/b;", "Lil/j;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "", "f", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "e", "g", "closer", "", "h", "message", "stackTrace", "l", "", "i", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lll/c;", "c", "Lll/e;", "d", "Ljl/k;", "Ljava/util/List;", "socketAdapters", "Ljl/h;", "Ljl/h;", "closeGuard", "<init>", "()V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b extends j {

    /* renamed from: f  reason: collision with root package name */
    public static final a f30023f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f30024g;

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f30025d;

    /* renamed from: e  reason: collision with root package name */
    private final h f30026e;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lil/b$a;", "", "Lil/j;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f30024g;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lil/b$b;", "Lll/e;", "Ljava/security/cert/X509Certificate;", "cert", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: il.b$b  reason: collision with other inner class name */
    public static final class C0351b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f30027a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f30028b;

        public C0351b(X509TrustManager x509TrustManager, Method method) {
            j.g(x509TrustManager, "trustManager");
            j.g(method, "findByIssuerAndSignatureMethod");
            this.f30027a = x509TrustManager;
            this.f30028b = method;
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            j.g(x509Certificate, "cert");
            try {
                Object invoke = this.f30028b.invoke(this.f30027a, new Object[]{x509Certificate});
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0351b)) {
                return false;
            }
            C0351b bVar = (C0351b) obj;
            return j.b(this.f30027a, bVar.f30027a) && j.b(this.f30028b, bVar.f30028b);
        }

        public int hashCode() {
            return (this.f30027a.hashCode() * 31) + this.f30028b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f30027a + ", findByIssuerAndSignatureMethod=" + this.f30028b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    static {
        boolean z10 = false;
        if (j.f30050a.h() && Build.VERSION.SDK_INT < 30) {
            z10 = true;
        }
        f30024g = z10;
    }

    public b() {
        List o10 = q.o(l.a.b(l.f31918j, (String) null, 1, (Object) null), new jl.j(f.f31900f.d()), new jl.j(i.f31914a.a()), new jl.j(g.f31908a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object next : o10) {
            if (((k) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.f30025d = arrayList;
        this.f30026e = h.f31910d.a();
    }

    public c c(X509TrustManager x509TrustManager) {
        j.g(x509TrustManager, "trustManager");
        jl.b a10 = jl.b.f31893d.a(x509TrustManager);
        return a10 == null ? super.c(x509TrustManager) : a10;
    }

    public e d(X509TrustManager x509TrustManager) {
        j.g(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            j.f(declaredMethod, FirebaseAnalytics.Param.METHOD);
            return new C0351b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    public void e(SSLSocket sSLSocket, String str, List<Protocol> list) {
        T t10;
        j.g(sSLSocket, "sslSocket");
        j.g(list, "protocols");
        Iterator<T> it = this.f30025d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((k) t10).a(sSLSocket)) {
                break;
            }
        }
        k kVar = (k) t10;
        if (kVar != null) {
            kVar.c(sSLSocket, str, list);
        }
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        j.g(socket, "socket");
        j.g(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e10);
            }
            throw e10;
        }
    }

    public String g(SSLSocket sSLSocket) {
        T t10;
        j.g(sSLSocket, "sslSocket");
        Iterator<T> it = this.f30025d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((k) t10).a(sSLSocket)) {
                break;
            }
        }
        k kVar = (k) t10;
        if (kVar == null) {
            return null;
        }
        return kVar.b(sSLSocket);
    }

    public Object h(String str) {
        j.g(str, "closer");
        return this.f30026e.a(str);
    }

    public boolean i(String str) {
        j.g(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public void l(String str, Object obj) {
        j.g(str, "message");
        if (!this.f30026e.b(obj)) {
            j.k(this, str, 5, (Throwable) null, 4, (Object) null);
        }
    }
}
