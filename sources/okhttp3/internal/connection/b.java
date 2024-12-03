package okhttp3.internal.connection;

import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.k;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/connection/b;", "", "Ljavax/net/ssl/SSLSocket;", "socket", "", "c", "sslSocket", "Lokhttp3/k;", "a", "Ljava/io/IOException;", "e", "b", "", "Ljava/util/List;", "connectionSpecs", "", "I", "nextModeIndex", "Z", "isFallbackPossible", "d", "isFallback", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f33016a;

    /* renamed from: b  reason: collision with root package name */
    private int f33017b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33018c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33019d;

    public b(List<k> list) {
        j.g(list, "connectionSpecs");
        this.f33016a = list;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int i10 = this.f33017b;
        int size = this.f33016a.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (this.f33016a.get(i10).e(sSLSocket)) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    public final k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        j.g(sSLSocket, "sslSocket");
        int i10 = this.f33017b;
        int size = this.f33016a.size();
        while (true) {
            if (i10 >= size) {
                kVar = null;
                break;
            }
            int i11 = i10 + 1;
            kVar = this.f33016a.get(i10);
            if (kVar.e(sSLSocket)) {
                this.f33017b = i11;
                break;
            }
            i10 = i11;
        }
        if (kVar != null) {
            this.f33018c = c(sSLSocket);
            kVar.c(sSLSocket, this.f33019d);
            return kVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f33019d);
        sb2.append(", modes=");
        sb2.append(this.f33016a);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        j.d(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        j.f(arrays, "toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean b(IOException iOException) {
        j.g(iOException, ReportingMessage.MessageType.EVENT);
        this.f33019d = true;
        if (this.f33018c && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException))) {
            return true;
        }
        return false;
    }
}
