package ln;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import kn.b;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider;

public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f41179a = Logger.getLogger(e.class.getName());

    public static class a extends b<PGPPublicKey> {
        /* renamed from: a */
        public boolean accept(PGPPublicKey pGPPublicKey, PGPPublicKey pGPPublicKey2) {
            if (Arrays.equals(pGPPublicKey.getFingerprint(), pGPPublicKey2.getFingerprint())) {
                return true;
            }
            Iterator signaturesForKeyID = pGPPublicKey2.getSignaturesForKeyID(pGPPublicKey.getKeyID());
            while (signaturesForKeyID.hasNext()) {
                PGPSignature pGPSignature = (PGPSignature) signaturesForKeyID.next();
                if (pGPSignature.getSignatureType() == 24) {
                    try {
                        pGPSignature.init(new BcPGPContentVerifierBuilderProvider(), pGPPublicKey);
                        return pGPSignature.verifyCertification(pGPPublicKey, pGPPublicKey2);
                    } catch (PGPException unused) {
                        Logger a10 = e.f41179a;
                        Level level = Level.WARNING;
                        a10.log(level, "Could not verify subkey signature of key " + Long.toHexString(pGPPublicKey.getKeyID()) + " on key " + Long.toHexString(pGPPublicKey2.getKeyID()));
                    }
                }
            }
            return false;
        }
    }
}
