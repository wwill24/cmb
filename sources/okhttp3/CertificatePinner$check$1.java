package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ll.c;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 6, 0})
final class CertificatePinner$check$1 extends Lambda implements Function0<List<? extends X509Certificate>> {
    final /* synthetic */ String $hostname;
    final /* synthetic */ List<Certificate> $peerCertificates;
    final /* synthetic */ CertificatePinner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CertificatePinner$check$1(CertificatePinner certificatePinner, List<? extends Certificate> list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    /* renamed from: a */
    public final List<X509Certificate> invoke() {
        List<Certificate> list;
        c d10 = this.this$0.d();
        if (d10 == null) {
            list = null;
        } else {
            list = d10.a(this.$peerCertificates, this.$hostname);
        }
        if (list == null) {
            list = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Certificate certificate : list) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
