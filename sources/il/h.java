package il;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0017J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0010"}, d2 = {"Lil/h;", "Lil/j;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "e", "g", "<init>", "()V", "d", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public class h extends j {

    /* renamed from: d  reason: collision with root package name */
    public static final a f30045d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f30046e;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lil/h$a;", "", "Lil/h;", "a", "", "isAvailable", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            if (b()) {
                return new h();
            }
            return null;
        }

        public final boolean b() {
            return h.f30046e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        if (r1.intValue() >= 9) goto L_0x002d;
     */
    static {
        /*
            il.h$a r0 = new il.h$a
            r1 = 0
            r0.<init>(r1)
            f30045d = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            java.lang.Integer r1 = kotlin.text.q.j(r0)
        L_0x0015:
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L_0x0024
            int r1 = r1.intValue()
            r3 = 9
            if (r1 < r3) goto L_0x0022
            goto L_0x002d
        L_0x0022:
            r0 = r2
            goto L_0x002d
        L_0x0024:
            java.lang.Class<javax.net.ssl.SSLSocket> r1 = javax.net.ssl.SSLSocket.class
            java.lang.String r3 = "getApplicationProtocol"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0022 }
            r1.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0022 }
        L_0x002d:
            f30046e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: il.h.<clinit>():void");
    }

    public void e(SSLSocket sSLSocket, String str, List<Protocol> list) {
        j.g(sSLSocket, "sslSocket");
        j.g(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        Object[] array2 = j.f30050a.b(list).toArray(new String[0]);
        if (array2 != null) {
            sSLParameters.setApplicationProtocols((String[]) array2);
            sSLSocket.setSSLParameters(sSLParameters);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public String g(SSLSocket sSLSocket) {
        boolean z10;
        j.g(sSLSocket, "sslSocket");
        try {
            String a10 = sSLSocket.getApplicationProtocol();
            if (a10 == null) {
                z10 = true;
            } else {
                z10 = j.b(a10, "");
            }
            if (z10) {
                return null;
            }
            return a10;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
