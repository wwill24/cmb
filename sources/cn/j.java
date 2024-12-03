package cn;

import en.a;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPOnePassSignature;
import org.bouncycastle.openpgp.PGPSignature;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final PGPOnePassSignature f34098a;

    /* renamed from: b  reason: collision with root package name */
    private final a f34099b;

    /* renamed from: c  reason: collision with root package name */
    private PGPSignature f34100c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34101d;

    public j(PGPOnePassSignature pGPOnePassSignature, a aVar) {
        this.f34098a = pGPOnePassSignature;
        this.f34099b = aVar;
    }

    public PGPOnePassSignature a() {
        return this.f34098a;
    }

    public PGPSignature b() {
        return this.f34100c;
    }

    public boolean c(PGPSignature pGPSignature) throws PGPException {
        boolean verify = a().verify(pGPSignature);
        this.f34101d = verify;
        if (verify) {
            this.f34100c = pGPSignature;
        }
        return verify;
    }
}
