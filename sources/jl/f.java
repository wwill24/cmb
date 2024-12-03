package jl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import il.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import jl.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.d;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0006B\u0017\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u001c\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00120\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00120\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u001c\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00120\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006\u001e"}, d2 = {"Ljl/f;", "Ljl/k;", "", "isSupported", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "a", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "c", "b", "Ljava/lang/Class;", "Ljava/lang/Class;", "sslSocketClass", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "setUseSessionTickets", "kotlin.jvm.PlatformType", "setHostname", "d", "getAlpnSelectedProtocol", "e", "setAlpnProtocols", "<init>", "(Ljava/lang/Class;)V", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
public class f implements k {

    /* renamed from: f  reason: collision with root package name */
    public static final a f31900f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final j.a f31901g;

    /* renamed from: a  reason: collision with root package name */
    private final Class<? super SSLSocket> f31902a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f31903b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f31904c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f31905d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f31906e;

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ljl/f$a;", "", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "Ljl/f;", "b", "", "packageName", "Ljl/j$a;", "c", "playProviderFactory", "Ljl/j$a;", "d", "()Ljl/j$a;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"jl/f$a$a", "Ljl/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "Ljl/k;", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
        /* renamed from: jl.f$a$a  reason: collision with other inner class name */
        public static final class C0365a implements j.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f31907a;

            C0365a(String str) {
                this.f31907a = str;
            }

            public boolean a(SSLSocket sSLSocket) {
                kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                kotlin.jvm.internal.j.f(name, "sslSocket.javaClass.name");
                return r.J(name, kotlin.jvm.internal.j.p(this.f31907a, "."), false, 2, (Object) null);
            }

            public k b(SSLSocket sSLSocket) {
                kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
                return f.f31900f.b(sSLSocket.getClass());
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final f b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && !kotlin.jvm.internal.j.b(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError(kotlin.jvm.internal.j.p("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            kotlin.jvm.internal.j.d(cls2);
            return new f(cls2);
        }

        public final j.a c(String str) {
            kotlin.jvm.internal.j.g(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            return new C0365a(str);
        }

        public final j.a d() {
            return f.f31901g;
        }
    }

    static {
        a aVar = new a((DefaultConstructorMarker) null);
        f31900f = aVar;
        f31901g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> cls) {
        kotlin.jvm.internal.j.g(cls, "sslSocketClass");
        this.f31902a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        kotlin.jvm.internal.j.f(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f31903b = declaredMethod;
        this.f31904c = cls.getMethod("setHostname", new Class[]{String.class});
        this.f31905d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f31906e = cls.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public boolean a(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        return this.f31902a.isInstance(sSLSocket);
    }

    public String b(SSLSocket sSLSocket) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f31905d.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, d.f32216b);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if ((cause instanceof NullPointerException) && kotlin.jvm.internal.j.b(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e11);
        }
    }

    public void c(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        kotlin.jvm.internal.j.g(sSLSocket, "sslSocket");
        kotlin.jvm.internal.j.g(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.f31903b.invoke(sSLSocket, new Object[]{Boolean.TRUE});
                if (str != null) {
                    this.f31904c.invoke(sSLSocket, new Object[]{str});
                }
                this.f31906e.invoke(sSLSocket, new Object[]{il.j.f30050a.c(list)});
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public boolean isSupported() {
        return b.f30023f.b();
    }
}
