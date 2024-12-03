package gn;

import hn.c;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.pgpainless.algorithm.KeyFlag;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f40884a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PGPSignatureSubpacketGenerator f40885b = new PGPSignatureSubpacketGenerator();

    class a implements e {
        a() {
        }

        public c a() {
            bn.a b10 = bn.a.b();
            d.this.f40885b.setPreferredCompressionAlgorithms(false, b10.a());
            d.this.f40885b.setPreferredSymmetricAlgorithms(false, b10.d());
            d.this.f40885b.setPreferredHashAlgorithms(false, b10.c());
            d.this.f40885b.setFeature(false, (byte) 1);
            return new c(d.this.f40884a, d.this.f40885b, false);
        }
    }

    d(c cVar) {
        this.f40884a = cVar;
    }

    public e c(KeyFlag... keyFlagArr) {
        this.f40885b.setKeyFlags(false, KeyFlag.c(keyFlagArr));
        return new a();
    }
}
