package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okhttp3.Handshake;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 6, 0})
final class RealConnection$connectTls$2 extends Lambda implements Function0<List<? extends X509Certificate>> {
    final /* synthetic */ RealConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.this$0 = realConnection;
    }

    /* renamed from: a */
    public final List<X509Certificate> invoke() {
        Handshake c10 = this.this$0.f33001g;
        j.d(c10);
        List<Certificate> d10 = c10.d();
        ArrayList arrayList = new ArrayList(r.t(d10, 10));
        for (Certificate certificate : d10) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
