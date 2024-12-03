package cn;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public InputStream f34069a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PGPSecretKeyRingCollection f34070b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public jn.a f34071c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<PGPSignature> f34072d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Set<PGPPublicKeyRing> f34073e = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public i f34074f = null;

    /* renamed from: g  reason: collision with root package name */
    private final KeyFingerPrintCalculator f34075g = new BcKeyFingerprintCalculator();

    /* renamed from: cn.a$a  reason: collision with other inner class name */
    class C0405a implements b {
        C0405a() {
        }

        public f build() throws IOException, PGPException {
            return g.a(a.this.f34069a, a.this.f34070b, a.this.f34071c, a.this.f34072d, a.this.f34073e, a.this.f34074f);
        }
    }

    class b implements c {
        b() {
        }

        public e a(jn.a aVar, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
            PGPSecretKeyRingCollection unused = a.this.f34070b = pGPSecretKeyRingCollection;
            jn.a unused2 = a.this.f34071c = aVar;
            return new d();
        }
    }

    class c implements d {
        c() {
        }

        public b a(i iVar) {
            i unused = a.this.f34074f = iVar;
            return new C0405a();
        }
    }

    class d implements e {
        d() {
        }

        public d a(PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            return new e().b(pGPPublicKeyRingCollection);
        }
    }

    class e {
        e() {
        }

        public d a(Set<PGPPublicKeyRing> set) {
            Set unused = a.this.f34073e = set;
            return new c();
        }

        public d b(PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            HashSet hashSet = new HashSet();
            Iterator keyRings = pGPPublicKeyRingCollection.getKeyRings();
            while (keyRings.hasNext()) {
                hashSet.add((PGPPublicKeyRing) keyRings.next());
            }
            return a(hashSet);
        }
    }

    public c k(InputStream inputStream) {
        this.f34069a = inputStream;
        return new b();
    }
}
