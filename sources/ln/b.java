package ln;

import org.bouncycastle.openpgp.PGPPublicKey;

public class b<O> extends kn.b<O> {
    /* renamed from: a */
    public boolean accept(O o10, PGPPublicKey pGPPublicKey) {
        return !pGPPublicKey.hasRevocation();
    }
}
