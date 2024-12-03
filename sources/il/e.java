package il;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u000bB7\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001d"}, d2 = {"Lil/e;", "Lil/j;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "e", "b", "g", "Ljava/lang/reflect/Method;", "d", "Ljava/lang/reflect/Method;", "putMethod", "getMethod", "f", "removeMethod", "Ljava/lang/Class;", "Ljava/lang/Class;", "clientProviderClass", "h", "serverProviderClass", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "i", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e extends j {

    /* renamed from: i  reason: collision with root package name */
    public static final b f30036i = new b((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final Method f30037d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f30038e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f30039f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f30040g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f30041h;

    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001c\u0010\u001dJ2\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lil/e$a;", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "", "", "a", "Ljava/util/List;", "protocols", "", "b", "Z", "()Z", "setUnsupported", "(Z)V", "unsupported", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "selected", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private static final class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f30042a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30043b;

        /* renamed from: c  reason: collision with root package name */
        private String f30044c;

        public a(List<String> list) {
            j.g(list, "protocols");
            this.f30042a = list;
        }

        public final String a() {
            return this.f30044c;
        }

        public final boolean b() {
            return this.f30043b;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            boolean z10;
            j.g(obj, "proxy");
            j.g(method, FirebaseAnalytics.Param.METHOD);
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (j.b(name, "supports") && j.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (!j.b(name, "unsupported") || !j.b(Void.TYPE, returnType)) {
                if (j.b(name, "protocols")) {
                    if (objArr.length == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        return this.f30042a;
                    }
                }
                if ((j.b(name, "selectProtocol") || j.b(name, "select")) && j.b(String.class, returnType) && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        if (obj2 != null) {
                            List list = (List) obj2;
                            int size = list.size();
                            if (size >= 0) {
                                int i10 = 0;
                                while (true) {
                                    int i11 = i10 + 1;
                                    Object obj3 = list.get(i10);
                                    if (obj3 != null) {
                                        String str = (String) obj3;
                                        if (this.f30042a.contains(str)) {
                                            this.f30044c = str;
                                            return str;
                                        } else if (i10 == size) {
                                            break;
                                        } else {
                                            i10 = i11;
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                }
                            }
                            String str2 = this.f30042a.get(0);
                            this.f30044c = str2;
                            return str2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                }
                if ((!j.b(name, "protocolSelected") && !j.b(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj4 = objArr[0];
                if (obj4 != null) {
                    this.f30044c = (String) obj4;
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f30043b = true;
            return null;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0006"}, d2 = {"Lil/e$b;", "", "Lil/j;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                j.f(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
                Class<?> cls2 = Class.forName(j.p("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, (ClassLoader) null);
                Class<?> cls3 = Class.forName(j.p("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, (ClassLoader) null);
                Class<?> cls4 = Class.forName(j.p("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, (ClassLoader) null);
                Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
                Method method2 = cls.getMethod("get", new Class[]{SSLSocket.class});
                Method method3 = cls.getMethod("remove", new Class[]{SSLSocket.class});
                j.f(method, "putMethod");
                j.f(method2, "getMethod");
                j.f(method3, "removeMethod");
                j.f(cls3, "clientProviderClass");
                j.f(cls4, "serverProviderClass");
                return new e(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        j.g(method, "putMethod");
        j.g(method2, "getMethod");
        j.g(method3, "removeMethod");
        j.g(cls, "clientProviderClass");
        j.g(cls2, "serverProviderClass");
        this.f30037d = method;
        this.f30038e = method2;
        this.f30039f = method3;
        this.f30040g = cls;
        this.f30041h = cls2;
    }

    public void b(SSLSocket sSLSocket) {
        j.g(sSLSocket, "sslSocket");
        try {
            this.f30039f.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    public void e(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        j.g(sSLSocket, "sslSocket");
        j.g(list, "protocols");
        List<String> b10 = j.f30050a.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(j.class.getClassLoader(), new Class[]{this.f30040g, this.f30041h}, new a(b10));
            this.f30037d.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    public String g(SSLSocket sSLSocket) {
        j.g(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f30038e.invoke((Object) null, new Object[]{sSLSocket}));
            if (invocationHandler != null) {
                a aVar = (a) invocationHandler;
                if (!aVar.b() && aVar.a() == null) {
                    j.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, (Throwable) null, 6, (Object) null);
                    return null;
                } else if (aVar.b()) {
                    return null;
                } else {
                    return aVar.a();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
