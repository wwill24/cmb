package gn;

import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketVector;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final hn.c f40881a;

    /* renamed from: b  reason: collision with root package name */
    private final PGPSignatureSubpacketGenerator f40882b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40883c;

    c(hn.c cVar, PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator, boolean z10) {
        this.f40881a = cVar;
        this.f40882b = pGPSignatureSubpacketGenerator;
        this.f40883c = z10;
    }

    public static d a(hn.c cVar) {
        return new d(cVar);
    }

    /* access modifiers changed from: package-private */
    public hn.c b() {
        return this.f40881a;
    }

    /* access modifiers changed from: package-private */
    public PGPSignatureSubpacketVector c() {
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = this.f40882b;
        if (pGPSignatureSubpacketGenerator != null) {
            return pGPSignatureSubpacketGenerator.generate();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f40883c;
    }
}
