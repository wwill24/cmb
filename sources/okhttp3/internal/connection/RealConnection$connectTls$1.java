package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ll.c;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.a;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 6, 0})
final class RealConnection$connectTls$1 extends Lambda implements Function0<List<? extends Certificate>> {
    final /* synthetic */ a $address;
    final /* synthetic */ CertificatePinner $certificatePinner;
    final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, a aVar) {
        super(0);
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake;
        this.$address = aVar;
    }

    /* renamed from: a */
    public final List<Certificate> invoke() {
        c d10 = this.$certificatePinner.d();
        j.d(d10);
        return d10.a(this.$unverifiedHandshake.d(), this.$address.l().i());
    }
}
