package ln;

import kn.b;
import org.bouncycastle.openpgp.PGPPublicKey;

public class a<O> extends b<O> {
    /* renamed from: a */
    public boolean accept(O o10, PGPPublicKey pGPPublicKey) {
        return pGPPublicKey.isEncryptionKey();
    }
}
