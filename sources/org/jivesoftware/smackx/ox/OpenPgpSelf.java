package org.jivesoftware.smackx.ox;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jxmpp.jid.BareJid;
import qn.a;

public class OpenPgpSelf extends OpenPgpContact {
    OpenPgpSelf(BareJid bareJid, OpenPgpStore openPgpStore) {
        super(bareJid, openPgpStore);
    }

    public PGPPublicKeyRingCollection getAnnouncedPublicKeys() throws IOException, PGPException {
        PGPSecretKeyRing signingKeyRing = getSigningKeyRing();
        return new PGPPublicKeyRingCollection(Collections.singleton(a.d(getAnyPublicKeys().getPublicKeyRing(signingKeyRing.getPublicKey().getKeyID()), signingKeyRing.getPublicKey())));
    }

    public PGPSecretKeyRingCollection getSecretKeys() throws IOException, PGPException {
        return this.store.getSecretKeysOf(this.jid);
    }

    public en.a getSigningKeyFingerprint() throws IOException, PGPException {
        PGPSecretKeyRing signingKeyRing = getSigningKeyRing();
        if (signingKeyRing != null) {
            return new en.a(signingKeyRing.getPublicKey());
        }
        return null;
    }

    public PGPSecretKeyRing getSigningKeyRing() throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeys = getSecretKeys();
        PGPSecretKeyRing pGPSecretKeyRing = null;
        if (secretKeys == null) {
            return null;
        }
        Iterator it = secretKeys.iterator();
        while (it.hasNext()) {
            PGPSecretKeyRing pGPSecretKeyRing2 = (PGPSecretKeyRing) it.next();
            if (pGPSecretKeyRing == null || pGPSecretKeyRing2.getPublicKey().getCreationTime().after(pGPSecretKeyRing.getPublicKey().getCreationTime())) {
                pGPSecretKeyRing = pGPSecretKeyRing2;
            }
        }
        return pGPSecretKeyRing;
    }

    public boolean hasSecretKeyAvailable() throws IOException, PGPException {
        return getSecretKeys() != null;
    }
}
