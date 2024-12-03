package jl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB3\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005¨\u0006\u000f"}, d2 = {"Ljl/l;", "Ljl/f;", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocketFactory;", "h", "Ljava/lang/Class;", "sslSocketFactoryClass", "i", "paramClass", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "j", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class l extends f {

    /* renamed from: j  reason: collision with root package name */
    public static final a f31918j = new a((DefaultConstructorMarker) null);

    /* renamed from: h  reason: collision with root package name */
    private final Class<? super SSLSocketFactory> f31919h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<?> f31920i;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Ljl/l$a;", "", "", "packageName", "Ljl/k;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ k b(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final k a(String str) {
            j.g(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            try {
                Class<?> cls = Class.forName(j.p(str, ".OpenSSLSocketImpl"));
                Class<?> cls2 = Class.forName(j.p(str, ".OpenSSLSocketFactoryImpl"));
                Class<?> cls3 = Class.forName(j.p(str, ".SSLParametersImpl"));
                j.f(cls3, "paramsClass");
                return new l(cls, cls2, cls3);
            } catch (Exception e10) {
                il.j.f30050a.g().j("unable to load android socket classes", 5, e10);
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        j.g(cls, "sslSocketClass");
        j.g(cls2, "sslSocketFactoryClass");
        j.g(cls3, "paramClass");
        this.f31919h = cls2;
        this.f31920i = cls3;
    }
}
