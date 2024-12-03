package org.jivesoftware.smackx.ox.store.abstr;

import en.a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.selection_strategy.BareJidUserId;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore;
import org.jxmpp.jid.BareJid;

public abstract class AbstractOpenPgpKeyStore implements OpenPgpKeyStore {
    protected static final Logger LOGGER = Logger.getLogger(AbstractOpenPgpKeyStore.class.getName());
    protected Map<BareJid, Map<a, Date>> keyFetchDates = new HashMap();
    protected Map<BareJid, PGPPublicKeyRingCollection> publicKeyRingCollections = new HashMap();
    protected Map<BareJid, PGPSecretKeyRingCollection> secretKeyRingCollections = new HashMap();

    public void deletePublicKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeysOf = getPublicKeysOf(bareJid);
        if (publicKeysOf.contains(aVar.b())) {
            PGPPublicKeyRingCollection removePublicKeyRing = PGPPublicKeyRingCollection.removePublicKeyRing(publicKeysOf, publicKeysOf.getPublicKeyRing(aVar.b()));
            if (!removePublicKeyRing.iterator().hasNext()) {
                removePublicKeyRing = null;
            }
            this.publicKeyRingCollections.put(bareJid, removePublicKeyRing);
            writePublicKeysOf(bareJid, removePublicKeyRing);
        }
    }

    public void deleteSecretKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeysOf = getSecretKeysOf(bareJid);
        if (secretKeysOf.contains(aVar.b())) {
            PGPSecretKeyRingCollection removeSecretKeyRing = PGPSecretKeyRingCollection.removeSecretKeyRing(secretKeysOf, secretKeysOf.getSecretKeyRing(aVar.b()));
            if (!removeSecretKeyRing.iterator().hasNext()) {
                removeSecretKeyRing = null;
            }
            this.secretKeyRingCollections.put(bareJid, removeSecretKeyRing);
            writeSecretKeysOf(bareJid, removeSecretKeyRing);
        }
    }

    public fn.a generateKeyRing(BareJid bareJid) throws PGPException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        gn.a e10 = an.a.e();
        return e10.h("xmpp:" + bareJid.toString());
    }

    public Map<a, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException {
        Map<a, Date> map = this.keyFetchDates.get(bareJid);
        if (map != null) {
            return map;
        }
        Map<a, Date> readKeyFetchDates = readKeyFetchDates(bareJid);
        this.keyFetchDates.put(bareJid, readKeyFetchDates);
        return readKeyFetchDates;
    }

    public PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeysOf = getPublicKeysOf(bareJid);
        if (publicKeysOf != null) {
            return publicKeysOf.getPublicKeyRing(aVar.b());
        }
        return null;
    }

    public PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = this.publicKeyRingCollections.get(bareJid);
        if (pGPPublicKeyRingCollection == null && (pGPPublicKeyRingCollection = readPublicKeysOf(bareJid)) != null) {
            this.publicKeyRingCollections.put(bareJid, pGPPublicKeyRingCollection);
        }
        return pGPPublicKeyRingCollection;
    }

    public PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeysOf = getSecretKeysOf(bareJid);
        if (secretKeysOf != null) {
            return secretKeysOf.getSecretKeyRing(aVar.b());
        }
        return null;
    }

    public PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        PGPSecretKeyRingCollection pGPSecretKeyRingCollection = this.secretKeyRingCollections.get(bareJid);
        if (pGPSecretKeyRingCollection == null && (pGPSecretKeyRingCollection = readSecretKeysOf(bareJid)) != null) {
            this.secretKeyRingCollections.put(bareJid, pGPSecretKeyRingCollection);
        }
        return pGPSecretKeyRingCollection;
    }

    public void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException {
        PGPPublicKeyRingCollection a10;
        if (new BareJidUserId.PubRingSelectionStrategy().accept(bareJid, pGPPublicKeyRing)) {
            PGPPublicKeyRing d10 = qn.a.d(pGPPublicKeyRing, pGPPublicKeyRing.getPublicKey());
            PGPPublicKeyRingCollection publicKeysOf = getPublicKeysOf(bareJid);
            if (publicKeysOf != null) {
                try {
                    a10 = PGPPublicKeyRingCollection.addPublicKeyRing(publicKeysOf, d10);
                } catch (IllegalArgumentException unused) {
                    Logger logger = LOGGER;
                    Level level = Level.INFO;
                    logger.log(level, "Skipping public key ring " + Long.toHexString(d10.getPublicKey().getKeyID()) + " as it is already in the key ring of " + bareJid.toString());
                }
            } else {
                a10 = qn.a.a(d10);
            }
            publicKeysOf = a10;
            this.publicKeyRingCollections.put(bareJid, publicKeysOf);
            writePublicKeysOf(bareJid, publicKeysOf);
            return;
        }
        throw new MissingUserIdOnKeyException(bareJid, new a(pGPPublicKeyRing));
    }

    public void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException {
        PGPSecretKeyRingCollection b10;
        if (new BareJidUserId.SecRingSelectionStrategy().accept(bareJid, pGPSecretKeyRing)) {
            PGPSecretKeyRing e10 = qn.a.e(pGPSecretKeyRing, pGPSecretKeyRing.getPublicKey());
            PGPSecretKeyRingCollection secretKeysOf = getSecretKeysOf(bareJid);
            if (secretKeysOf != null) {
                try {
                    b10 = PGPSecretKeyRingCollection.addSecretKeyRing(secretKeysOf, e10);
                } catch (IllegalArgumentException unused) {
                    Logger logger = LOGGER;
                    Level level = Level.INFO;
                    logger.log(level, "Skipping secret key ring " + Long.toHexString(e10.getPublicKey().getKeyID()) + " as it is already in the key ring of " + bareJid.toString());
                }
            } else {
                b10 = qn.a.b(e10);
            }
            secretKeysOf = b10;
            this.secretKeyRingCollections.put(bareJid, secretKeysOf);
            writeSecretKeysOf(bareJid, secretKeysOf);
            return;
        }
        throw new MissingUserIdOnKeyException(bareJid, new a(pGPSecretKeyRing));
    }

    /* access modifiers changed from: protected */
    public abstract Map<a, Date> readKeyFetchDates(BareJid bareJid) throws IOException;

    /* access modifiers changed from: protected */
    public abstract PGPPublicKeyRingCollection readPublicKeysOf(BareJid bareJid) throws IOException, PGPException;

    /* access modifiers changed from: protected */
    public abstract PGPSecretKeyRingCollection readSecretKeysOf(BareJid bareJid) throws IOException, PGPException;

    public void setPublicKeyFetchDates(BareJid bareJid, Map<a, Date> map) throws IOException {
        this.keyFetchDates.put(bareJid, map);
        writeKeyFetchDates(bareJid, map);
    }

    /* access modifiers changed from: protected */
    public abstract void writeKeyFetchDates(BareJid bareJid, Map<a, Date> map) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void writePublicKeysOf(BareJid bareJid, PGPPublicKeyRingCollection pGPPublicKeyRingCollection) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void writeSecretKeysOf(BareJid bareJid, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) throws IOException;
}
