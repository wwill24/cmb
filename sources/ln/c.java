package ln;

import org.bouncycastle.openpgp.PGPSecretKey;

public class c<O> extends kn.c<O> {
    /* renamed from: a */
    public boolean accept(O o10, PGPSecretKey pGPSecretKey) {
        return !pGPSecretKey.getPublicKey().hasRevocation();
    }
}
