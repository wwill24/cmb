package fn;

import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private PGPPublicKeyRing f40816a;

    /* renamed from: b  reason: collision with root package name */
    private PGPSecretKeyRing f40817b;

    public a(PGPPublicKeyRing pGPPublicKeyRing, PGPSecretKeyRing pGPSecretKeyRing) {
        if (pGPPublicKeyRing.getPublicKey().getKeyID() == pGPSecretKeyRing.getPublicKey().getKeyID()) {
            this.f40816a = pGPPublicKeyRing;
            this.f40817b = pGPSecretKeyRing;
            return;
        }
        throw new IllegalArgumentException("publicKeys and secretKeys must have the same master key.");
    }

    public PGPPublicKeyRing a() {
        return this.f40816a;
    }

    public PGPSecretKeyRing b() {
        return this.f40817b;
    }
}
