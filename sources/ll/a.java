package ll;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0018"}, d2 = {"Lll/a;", "Lll/c;", "Ljava/security/cert/X509Certificate;", "toVerify", "signingCert", "", "b", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "a", "", "hashCode", "", "other", "equals", "Lll/e;", "Lll/e;", "trustRootIndex", "<init>", "(Lll/e;)V", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public static final C0374a f32783c = new C0374a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final e f32784b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lll/a$a;", "", "", "MAX_SIGNERS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: ll.a$a  reason: collision with other inner class name */
    public static final class C0374a {
        private C0374a() {
        }

        public /* synthetic */ C0374a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(e eVar) {
        j.g(eVar, "trustRootIndex");
        this.f32784b = eVar;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!j.b(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        j.g(list, "chain");
        j.g(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        j.f(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < 9) {
            i10++;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate a10 = this.f32784b.a(x509Certificate);
            if (a10 != null) {
                if (arrayList.size() > 1 || !j.b(x509Certificate, a10)) {
                    arrayList.add(a10);
                }
                if (b(a10, a10)) {
                    return arrayList;
                }
                z10 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                j.f(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null) {
                        X509Certificate x509Certificate2 = (X509Certificate) next;
                        if (b(x509Certificate, x509Certificate2)) {
                            it.remove();
                            arrayList.add(x509Certificate2);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException(j.p("Failed to find a trusted cert that signed ", x509Certificate));
            }
        }
        throw new SSLPeerUnverifiedException(j.p("Certificate chain too long: ", arrayList));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && j.b(((a) obj).f32784b, this.f32784b);
    }

    public int hashCode() {
        return this.f32784b.hashCode();
    }
}
