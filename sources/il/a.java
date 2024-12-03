package il;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import jl.b;
import jl.f;
import jl.g;
import jl.i;
import jl.j;
import jl.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ll.c;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lil/a;", "Lil/j;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "e", "g", "", "i", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lll/c;", "c", "Ljl/k;", "d", "Ljava/util/List;", "socketAdapters", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a extends j {

    /* renamed from: e  reason: collision with root package name */
    public static final C0350a f30020e = new C0350a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f30021f = (j.f30050a.h() && Build.VERSION.SDK_INT >= 29);

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f30022d;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lil/a$a;", "", "Lil/j;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: il.a$a  reason: collision with other inner class name */
    public static final class C0350a {
        private C0350a() {
        }

        public /* synthetic */ C0350a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f30021f;
        }
    }

    public a() {
        List o10 = q.o(jl.a.f31892a.a(), new j(f.f31900f.d()), new j(i.f31914a.a()), new j(g.f31908a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object next : o10) {
            if (((k) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.f30022d = arrayList;
    }

    public c c(X509TrustManager x509TrustManager) {
        kotlin.jvm.internal.j.g(x509TrustManager, "trustManager");
        b a10 = b.f31893d.a(x509TrustManager);
        return a10 == null ? super.c(x509TrustManager) : a10;
    }

    public void e(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        T t10;
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
        Iterator<T> it = this.f30022d.iterator();
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

    public String g(SSLSocket sSLSocket) {
        T t10;
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        Iterator<T> it = this.f30022d.iterator();
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

    @SuppressLint({"NewApi"})
    public boolean i(String str) {
        kotlin.jvm.internal.j.g(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
