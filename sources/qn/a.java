package qn;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;
import ln.b;
import ln.e;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f41807a = Logger.getLogger(a.class.getName());

    public static PGPPublicKeyRingCollection a(PGPPublicKeyRing... pGPPublicKeyRingArr) throws IOException, PGPException {
        return new PGPPublicKeyRingCollection(Arrays.asList(pGPPublicKeyRingArr));
    }

    public static PGPSecretKeyRingCollection b(PGPSecretKeyRing... pGPSecretKeyRingArr) throws IOException, PGPException {
        return new PGPSecretKeyRingCollection(Arrays.asList(pGPSecretKeyRingArr));
    }

    public static PGPPublicKeyRing c(PGPSecretKeyRing pGPSecretKeyRing) throws PGPException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        Iterator it = pGPSecretKeyRing.iterator();
        while (it.hasNext()) {
            PGPPublicKey publicKey = ((PGPSecretKey) it.next()).getPublicKey();
            if (publicKey != null) {
                publicKey.encode(byteArrayOutputStream, false);
            }
        }
        return new PGPPublicKeyRing(byteArrayOutputStream.toByteArray(), new BcKeyFingerprintCalculator());
    }

    public static PGPPublicKeyRing d(PGPPublicKeyRing pGPPublicKeyRing, PGPPublicKey pGPPublicKey) {
        if (pGPPublicKey.isMasterKey()) {
            mn.a aVar = new mn.a(new e.a(), new b());
            Iterator publicKeys = pGPPublicKeyRing.getPublicKeys();
            while (publicKeys.hasNext()) {
                PGPPublicKey pGPPublicKey2 = (PGPPublicKey) publicKeys.next();
                if (!aVar.accept(pGPPublicKey, pGPPublicKey2)) {
                    pGPPublicKeyRing = PGPPublicKeyRing.removePublicKey(pGPPublicKeyRing, pGPPublicKey2);
                }
            }
            return pGPPublicKeyRing;
        }
        throw new IllegalArgumentException("Given key is not a master key.");
    }

    public static PGPSecretKeyRing e(PGPSecretKeyRing pGPSecretKeyRing, PGPPublicKey pGPPublicKey) {
        if (pGPPublicKey.isMasterKey()) {
            mn.a aVar = new mn.a(new e.a(), new b());
            Iterator secretKeys = pGPSecretKeyRing.getSecretKeys();
            while (secretKeys.hasNext()) {
                PGPSecretKey pGPSecretKey = (PGPSecretKey) secretKeys.next();
                if (!aVar.accept(pGPPublicKey, pGPSecretKey.getPublicKey())) {
                    pGPSecretKeyRing = PGPSecretKeyRing.removeSecretKey(pGPSecretKeyRing, pGPSecretKey);
                }
            }
            return pGPSecretKeyRing;
        }
        throw new IllegalArgumentException("Given key is not a master key.");
    }
}
