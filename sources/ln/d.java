package ln;

import kn.c;
import org.bouncycastle.openpgp.PGPSecretKey;

public class d<O> extends c<O> {
    /* renamed from: a */
    public boolean accept(O o10, PGPSecretKey pGPSecretKey) {
        return pGPSecretKey.isSigningKey();
    }
}
