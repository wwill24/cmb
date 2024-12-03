package okhttp3;

import bl.d;
import il.j;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ll.c;
import okhttp3.e;
import okhttp3.internal.connection.g;
import okhttp3.q;

@Metadata(bv = {}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\t\u0010B\u0015\b\u0000\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001B\u000b\b\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8G¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8G¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158G¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158G¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010$\u001a\u00020\u001f8G¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8G¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010/\u001a\u00020+8G¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u001c\u0010.R\u0017\u00102\u001a\u00020%8G¢\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R\u0017\u00105\u001a\u00020%8G¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u0010)R\u0017\u0010:\u001a\u0002068G¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109R\u0017\u0010@\u001a\u00020;8G¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0019\u0010F\u001a\u0004\u0018\u00010A8G¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010L\u001a\u00020G8G¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010N\u001a\u00020+8G¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\bM\u0010.R\u0017\u0010S\u001a\u00020O8G¢\u0006\f\n\u0004\b>\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010V\u001a\u0004\u0018\u00010T8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010UR\u0019\u0010Y\u001a\u0004\u0018\u00010W8G¢\u0006\f\n\u0004\b\u0019\u0010X\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0\u00158G¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b<\u0010\u001aR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\u00158G¢\u0006\f\n\u0004\b^\u0010\u0018\u001a\u0004\b_\u0010\u001aR\u0017\u0010e\u001a\u00020a8G¢\u0006\f\n\u0004\b_\u0010b\u001a\u0004\bc\u0010dR\u0017\u0010j\u001a\u00020f8G¢\u0006\f\n\u0004\bM\u0010g\u001a\u0004\bh\u0010iR\u0019\u0010m\u001a\u0004\u0018\u00010k8G¢\u0006\f\n\u0004\bJ\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010s\u001a\u00020o8G¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\b0\u0010rR\u0017\u0010t\u001a\u00020o8G¢\u0006\f\n\u0004\b(\u0010q\u001a\u0004\b3\u0010rR\u0017\u0010u\u001a\u00020o8G¢\u0006\f\n\u0004\bQ\u0010q\u001a\u0004\bp\u0010rR\u0017\u0010w\u001a\u00020o8G¢\u0006\f\n\u0004\bv\u0010q\u001a\u0004\bq\u0010rR\u0017\u0010x\u001a\u00020o8G¢\u0006\f\n\u0004\b\u0005\u0010q\u001a\u0004\b^\u0010rR\u0017\u0010{\u001a\u00020y8G¢\u0006\f\n\u0004\bq\u0010z\u001a\u0004\b{\u0010|R\u0019\u0010\u0001\u001a\u00020}8\u0006¢\u0006\r\n\u0004\bz\u0010~\u001a\u0005\b\u0010\u0001R\u001e\u0010\u0001\u001a\u0005\u0018\u00010\u00018G¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b \u0010\u0001R\u0013\u0010\u0001\u001a\u00020T8G¢\u0006\u0007\u001a\u0005\bv\u0010\u0001¨\u0006\u0001"}, d2 = {"Lokhttp3/x;", "", "Lokhttp3/e$a;", "", "", "H", "Lokhttp3/y;", "request", "Lokhttp3/e;", "a", "Lokhttp3/o;", "Lokhttp3/o;", "p", "()Lokhttp3/o;", "dispatcher", "Lokhttp3/j;", "b", "Lokhttp3/j;", "k", "()Lokhttp3/j;", "connectionPool", "", "Lokhttp3/u;", "c", "Ljava/util/List;", "w", "()Ljava/util/List;", "interceptors", "d", "x", "networkInterceptors", "Lokhttp3/q$c;", "e", "Lokhttp3/q$c;", "r", "()Lokhttp3/q$c;", "eventListenerFactory", "", "f", "Z", "E", "()Z", "retryOnConnectionFailure", "Lokhttp3/b;", "g", "Lokhttp3/b;", "()Lokhttp3/b;", "authenticator", "h", "s", "followRedirects", "j", "t", "followSslRedirects", "Lokhttp3/m;", "Lokhttp3/m;", "o", "()Lokhttp3/m;", "cookieJar", "Lokhttp3/p;", "l", "Lokhttp3/p;", "q", "()Lokhttp3/p;", "dns", "Ljava/net/Proxy;", "m", "Ljava/net/Proxy;", "A", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "n", "Ljava/net/ProxySelector;", "C", "()Ljava/net/ProxySelector;", "proxySelector", "B", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "F", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/k;", "connectionSpecs", "Lokhttp3/Protocol;", "y", "z", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "v", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "Lokhttp3/CertificatePinner;", "i", "()Lokhttp3/CertificatePinner;", "certificatePinner", "Lll/c;", "Lll/c;", "certificateChainCleaner", "()Lll/c;", "", "D", "I", "()I", "callTimeoutMillis", "connectTimeoutMillis", "readTimeoutMillis", "G", "writeTimeoutMillis", "pingIntervalMillis", "", "J", "minWebSocketMessageToCompress", "()J", "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "u", "()Lokhttp3/internal/connection/g;", "routeDatabase", "Lokhttp3/c;", "cache", "Lokhttp3/c;", "()Lokhttp3/c;", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/x$a;", "builder", "<init>", "(Lokhttp3/x$a;)V", "()V", "K", "okhttp"}, k = 1, mv = {1, 6, 0})
public class x implements Cloneable, e.a {
    public static final b K = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<Protocol> L = d.w(Protocol.HTTP_2, Protocol.HTTP_1_1);
    /* access modifiers changed from: private */
    public static final List<k> M = d.w(k.f33118i, k.f33120k);
    private final CertificatePinner B;
    private final c C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final long I;
    private final g J;

    /* renamed from: a  reason: collision with root package name */
    private final o f33217a;

    /* renamed from: b  reason: collision with root package name */
    private final j f33218b;

    /* renamed from: c  reason: collision with root package name */
    private final List<u> f33219c;

    /* renamed from: d  reason: collision with root package name */
    private final List<u> f33220d;

    /* renamed from: e  reason: collision with root package name */
    private final q.c f33221e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f33222f;

    /* renamed from: g  reason: collision with root package name */
    private final b f33223g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f33224h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f33225j;

    /* renamed from: k  reason: collision with root package name */
    private final m f33226k;

    /* renamed from: l  reason: collision with root package name */
    private final p f33227l;

    /* renamed from: m  reason: collision with root package name */
    private final Proxy f33228m;

    /* renamed from: n  reason: collision with root package name */
    private final ProxySelector f33229n;

    /* renamed from: p  reason: collision with root package name */
    private final b f33230p;

    /* renamed from: q  reason: collision with root package name */
    private final SocketFactory f33231q;

    /* renamed from: t  reason: collision with root package name */
    private final SSLSocketFactory f33232t;

    /* renamed from: w  reason: collision with root package name */
    private final X509TrustManager f33233w;

    /* renamed from: x  reason: collision with root package name */
    private final List<k> f33234x;

    /* renamed from: y  reason: collision with root package name */
    private final List<Protocol> f33235y;

    /* renamed from: z  reason: collision with root package name */
    private final HostnameVerifier f33236z;

    @Metadata(bv = {}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0000X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b%\u0010#R\"\u0010-\u001a\u00020'8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010<\u001a\u0002068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b/\u00109\"\u0004\b:\u0010;R\"\u0010@\u001a\u00020.8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b=\u00100\u001a\u0004\b>\u00102\"\u0004\b?\u00104R\"\u0010D\u001a\u00020.8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bA\u00100\u001a\u0004\bB\u00102\"\u0004\bC\u00104R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010R\u001a\u00020K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010Y\u001a\u0004\u0018\u00010S8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010a\u001a\u0004\u0018\u00010Z8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010d\u001a\u0002068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bG\u00108\u001a\u0004\bb\u00109\"\u0004\bc\u0010;R\"\u0010k\u001a\u00020e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010r\u001a\u0004\u0018\u00010l8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bN\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010y\u001a\u0004\u0018\u00010s8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR(\u0010~\u001a\b\u0012\u0004\u0012\u00020{0z8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b>\u0010!\u001a\u0004\b[\u0010#\"\u0004\b|\u0010}R+\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200z8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0004\bB\u0010!\u001a\u0005\b\u0001\u0010#\"\u0005\b\u0001\u0010}R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0016\n\u0005\b\"\u0010\u0001\u001a\u0005\bE\u0010\u0001\"\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0000@\u0000X\u000e¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\bA\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0015\n\u0004\b%\u0010u\u001a\u0005\b=\u0010\u0001\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010u\u001a\u0005\bL\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010¡\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0017\n\u0005\b\u0001\u0010u\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010\u0001R(\u0010¤\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0016\n\u0004\bU\u0010u\u001a\u0006\b¢\u0001\u0010\u0001\"\u0006\b£\u0001\u0010\u0001R(\u0010¦\u0001\u001a\u00030\u00018\u0000@\u0000X\u000e¢\u0006\u0016\n\u0004\bb\u0010u\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b¥\u0001\u0010\u0001R'\u0010ª\u0001\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0004\b]\u0010\u000e\u001a\u0006\b\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R,\u0010±\u0001\u001a\u0005\u0018\u00010«\u00018\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R+\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0000@\u0000X\u000e¢\u0006\u0017\n\u0006\b³\u0001\u0010´\u0001\u001a\u0005\b7\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001¨\u0006º\u0001"}, d2 = {"Lokhttp3/x$a;", "", "Lokhttp3/u;", "interceptor", "a", "b", "Lokhttp3/m;", "cookieJar", "e", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "d", "J", "O", "Lokhttp3/x;", "c", "Lokhttp3/o;", "Lokhttp3/o;", "o", "()Lokhttp3/o;", "setDispatcher$okhttp", "(Lokhttp3/o;)V", "dispatcher", "Lokhttp3/j;", "Lokhttp3/j;", "l", "()Lokhttp3/j;", "setConnectionPool$okhttp", "(Lokhttp3/j;)V", "connectionPool", "", "Ljava/util/List;", "u", "()Ljava/util/List;", "interceptors", "w", "networkInterceptors", "Lokhttp3/q$c;", "Lokhttp3/q$c;", "q", "()Lokhttp3/q$c;", "setEventListenerFactory$okhttp", "(Lokhttp3/q$c;)V", "eventListenerFactory", "", "f", "Z", "D", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "retryOnConnectionFailure", "Lokhttp3/b;", "g", "Lokhttp3/b;", "()Lokhttp3/b;", "setAuthenticator$okhttp", "(Lokhttp3/b;)V", "authenticator", "h", "r", "setFollowRedirects$okhttp", "followRedirects", "i", "s", "setFollowSslRedirects$okhttp", "followSslRedirects", "j", "Lokhttp3/m;", "n", "()Lokhttp3/m;", "L", "(Lokhttp3/m;)V", "Lokhttp3/p;", "k", "Lokhttp3/p;", "p", "()Lokhttp3/p;", "setDns$okhttp", "(Lokhttp3/p;)V", "dns", "Ljava/net/Proxy;", "Ljava/net/Proxy;", "z", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxy", "Ljava/net/ProxySelector;", "m", "Ljava/net/ProxySelector;", "B", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxySelector", "A", "setProxyAuthenticator$okhttp", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "F", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "G", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "I", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "", "Lokhttp3/k;", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "connectionSpecs", "Lokhttp3/Protocol;", "y", "setProtocols$okhttp", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "t", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "certificatePinner", "Lll/c;", "v", "Lll/c;", "()Lll/c;", "setCertificateChainCleaner$okhttp", "(Lll/c;)V", "certificateChainCleaner", "", "()I", "setCallTimeout$okhttp", "(I)V", "callTimeout", "x", "K", "connectTimeout", "C", "M", "readTimeout", "H", "N", "writeTimeout", "setPingInterval$okhttp", "pingInterval", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "minWebSocketMessageToCompress", "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "E", "()Lokhttp3/internal/connection/g;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/g;)V", "routeDatabase", "Lokhttp3/c;", "cache", "Lokhttp3/c;", "()Lokhttp3/c;", "setCache$okhttp", "(Lokhttp3/c;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private int A;
        private long B;
        private g C;

        /* renamed from: a  reason: collision with root package name */
        private o f33237a = new o();

        /* renamed from: b  reason: collision with root package name */
        private j f33238b = new j();

        /* renamed from: c  reason: collision with root package name */
        private final List<u> f33239c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private final List<u> f33240d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private q.c f33241e = d.g(q.f33158b);

        /* renamed from: f  reason: collision with root package name */
        private boolean f33242f = true;

        /* renamed from: g  reason: collision with root package name */
        private b f33243g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f33244h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f33245i;

        /* renamed from: j  reason: collision with root package name */
        private m f33246j;

        /* renamed from: k  reason: collision with root package name */
        private p f33247k;

        /* renamed from: l  reason: collision with root package name */
        private Proxy f33248l;

        /* renamed from: m  reason: collision with root package name */
        private ProxySelector f33249m;

        /* renamed from: n  reason: collision with root package name */
        private b f33250n;

        /* renamed from: o  reason: collision with root package name */
        private SocketFactory f33251o;

        /* renamed from: p  reason: collision with root package name */
        private SSLSocketFactory f33252p;

        /* renamed from: q  reason: collision with root package name */
        private X509TrustManager f33253q;

        /* renamed from: r  reason: collision with root package name */
        private List<k> f33254r;

        /* renamed from: s  reason: collision with root package name */
        private List<? extends Protocol> f33255s;

        /* renamed from: t  reason: collision with root package name */
        private HostnameVerifier f33256t;

        /* renamed from: u  reason: collision with root package name */
        private CertificatePinner f33257u;

        /* renamed from: v  reason: collision with root package name */
        private c f33258v;

        /* renamed from: w  reason: collision with root package name */
        private int f33259w;

        /* renamed from: x  reason: collision with root package name */
        private int f33260x;

        /* renamed from: y  reason: collision with root package name */
        private int f33261y;

        /* renamed from: z  reason: collision with root package name */
        private int f33262z;

        public a() {
            b bVar = b.f32886b;
            this.f33243g = bVar;
            this.f33244h = true;
            this.f33245i = true;
            this.f33246j = m.f33144b;
            this.f33247k = p.f33155b;
            this.f33250n = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            j.f(socketFactory, "getDefault()");
            this.f33251o = socketFactory;
            b bVar2 = x.K;
            this.f33254r = bVar2.a();
            this.f33255s = bVar2.b();
            this.f33256t = ll.d.f32787a;
            this.f33257u = CertificatePinner.f32820d;
            this.f33260x = 10000;
            this.f33261y = 10000;
            this.f33262z = 10000;
            this.B = 1024;
        }

        public final b A() {
            return this.f33250n;
        }

        public final ProxySelector B() {
            return this.f33249m;
        }

        public final int C() {
            return this.f33261y;
        }

        public final boolean D() {
            return this.f33242f;
        }

        public final g E() {
            return this.C;
        }

        public final SocketFactory F() {
            return this.f33251o;
        }

        public final SSLSocketFactory G() {
            return this.f33252p;
        }

        public final int H() {
            return this.f33262z;
        }

        public final X509TrustManager I() {
            return this.f33253q;
        }

        public final a J(long j10, TimeUnit timeUnit) {
            j.g(timeUnit, "unit");
            M(d.k("timeout", j10, timeUnit));
            return this;
        }

        public final void K(int i10) {
            this.f33260x = i10;
        }

        public final void L(m mVar) {
            j.g(mVar, "<set-?>");
            this.f33246j = mVar;
        }

        public final void M(int i10) {
            this.f33261y = i10;
        }

        public final void N(int i10) {
            this.f33262z = i10;
        }

        public final a O(long j10, TimeUnit timeUnit) {
            j.g(timeUnit, "unit");
            N(d.k("timeout", j10, timeUnit));
            return this;
        }

        public final a a(u uVar) {
            j.g(uVar, "interceptor");
            u().add(uVar);
            return this;
        }

        public final a b(u uVar) {
            j.g(uVar, "interceptor");
            w().add(uVar);
            return this;
        }

        public final x c() {
            return new x(this);
        }

        public final a d(long j10, TimeUnit timeUnit) {
            j.g(timeUnit, "unit");
            K(d.k("timeout", j10, timeUnit));
            return this;
        }

        public final a e(m mVar) {
            j.g(mVar, "cookieJar");
            L(mVar);
            return this;
        }

        public final b f() {
            return this.f33243g;
        }

        public final c g() {
            return null;
        }

        public final int h() {
            return this.f33259w;
        }

        public final c i() {
            return this.f33258v;
        }

        public final CertificatePinner j() {
            return this.f33257u;
        }

        public final int k() {
            return this.f33260x;
        }

        public final j l() {
            return this.f33238b;
        }

        public final List<k> m() {
            return this.f33254r;
        }

        public final m n() {
            return this.f33246j;
        }

        public final o o() {
            return this.f33237a;
        }

        public final p p() {
            return this.f33247k;
        }

        public final q.c q() {
            return this.f33241e;
        }

        public final boolean r() {
            return this.f33244h;
        }

        public final boolean s() {
            return this.f33245i;
        }

        public final HostnameVerifier t() {
            return this.f33256t;
        }

        public final List<u> u() {
            return this.f33239c;
        }

        public final long v() {
            return this.B;
        }

        public final List<u> w() {
            return this.f33240d;
        }

        public final int x() {
            return this.A;
        }

        public final List<Protocol> y() {
            return this.f33255s;
        }

        public final Proxy z() {
            return this.f33248l;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lokhttp3/x$b;", "", "", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lokhttp3/k;", "DEFAULT_CONNECTION_SPECS", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<k> a() {
            return x.M;
        }

        public final List<Protocol> b() {
            return x.L;
        }
    }

    public x(a aVar) {
        ProxySelector proxySelector;
        j.g(aVar, "builder");
        this.f33217a = aVar.o();
        this.f33218b = aVar.l();
        this.f33219c = d.S(aVar.u());
        this.f33220d = d.S(aVar.w());
        this.f33221e = aVar.q();
        this.f33222f = aVar.D();
        this.f33223g = aVar.f();
        this.f33224h = aVar.r();
        this.f33225j = aVar.s();
        this.f33226k = aVar.n();
        aVar.g();
        this.f33227l = aVar.p();
        this.f33228m = aVar.z();
        if (aVar.z() != null) {
            proxySelector = kl.a.f32005a;
        } else {
            proxySelector = aVar.B();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = kl.a.f32005a;
            }
        }
        this.f33229n = proxySelector;
        this.f33230p = aVar.A();
        this.f33231q = aVar.F();
        List<k> m10 = aVar.m();
        this.f33234x = m10;
        this.f33235y = aVar.y();
        this.f33236z = aVar.t();
        this.D = aVar.h();
        this.E = aVar.k();
        this.F = aVar.C();
        this.G = aVar.H();
        this.H = aVar.x();
        this.I = aVar.v();
        g E2 = aVar.E();
        this.J = E2 == null ? new g() : E2;
        boolean z10 = true;
        if (!(m10 instanceof Collection) || !m10.isEmpty()) {
            Iterator<T> it = m10.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((k) it.next()).f()) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z10) {
            this.f33232t = null;
            this.C = null;
            this.f33233w = null;
            this.B = CertificatePinner.f32820d;
        } else if (aVar.G() != null) {
            this.f33232t = aVar.G();
            c i10 = aVar.i();
            j.d(i10);
            this.C = i10;
            X509TrustManager I2 = aVar.I();
            j.d(I2);
            this.f33233w = I2;
            CertificatePinner j10 = aVar.j();
            j.d(i10);
            this.B = j10.e(i10);
        } else {
            j.a aVar2 = il.j.f30050a;
            X509TrustManager o10 = aVar2.g().o();
            this.f33233w = o10;
            il.j g10 = aVar2.g();
            kotlin.jvm.internal.j.d(o10);
            this.f33232t = g10.n(o10);
            c.a aVar3 = c.f32786a;
            kotlin.jvm.internal.j.d(o10);
            c a10 = aVar3.a(o10);
            this.C = a10;
            CertificatePinner j11 = aVar.j();
            kotlin.jvm.internal.j.d(a10);
            this.B = j11.e(a10);
        }
        H();
    }

    private final void H() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (!(!this.f33219c.contains((Object) null))) {
            throw new IllegalStateException(kotlin.jvm.internal.j.p("Null interceptor: ", w()).toString());
        } else if (!this.f33220d.contains((Object) null)) {
            List<k> list = this.f33234x;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((k) it.next()).f()) {
                            z10 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z10 = true;
            if (z10) {
                if (this.f33232t == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (this.C == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if (this.f33233w != null) {
                            z13 = false;
                        }
                        if (!z13) {
                            throw new IllegalStateException("Check failed.".toString());
                        } else if (!kotlin.jvm.internal.j.b(this.B, CertificatePinner.f32820d)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else if (this.f33232t == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            } else if (this.C == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            } else if (this.f33233w == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
        } else {
            throw new IllegalStateException(kotlin.jvm.internal.j.p("Null network interceptor: ", x()).toString());
        }
    }

    public final Proxy A() {
        return this.f33228m;
    }

    public final b B() {
        return this.f33230p;
    }

    public final ProxySelector C() {
        return this.f33229n;
    }

    public final int D() {
        return this.F;
    }

    public final boolean E() {
        return this.f33222f;
    }

    public final SocketFactory F() {
        return this.f33231q;
    }

    public final SSLSocketFactory G() {
        SSLSocketFactory sSLSocketFactory = this.f33232t;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int I() {
        return this.G;
    }

    public e a(y yVar) {
        kotlin.jvm.internal.j.g(yVar, "request");
        return new okhttp3.internal.connection.e(this, yVar, false);
    }

    public Object clone() {
        return super.clone();
    }

    public final b d() {
        return this.f33223g;
    }

    public final c e() {
        return null;
    }

    public final int h() {
        return this.D;
    }

    public final CertificatePinner i() {
        return this.B;
    }

    public final int j() {
        return this.E;
    }

    public final j k() {
        return this.f33218b;
    }

    public final List<k> l() {
        return this.f33234x;
    }

    public final m o() {
        return this.f33226k;
    }

    public final o p() {
        return this.f33217a;
    }

    public final p q() {
        return this.f33227l;
    }

    public final q.c r() {
        return this.f33221e;
    }

    public final boolean s() {
        return this.f33224h;
    }

    public final boolean t() {
        return this.f33225j;
    }

    public final g u() {
        return this.J;
    }

    public final HostnameVerifier v() {
        return this.f33236z;
    }

    public final List<u> w() {
        return this.f33219c;
    }

    public final List<u> x() {
        return this.f33220d;
    }

    public final int y() {
        return this.H;
    }

    public final List<Protocol> z() {
        return this.f33235y;
    }

    public x() {
        this(new a());
    }
}
