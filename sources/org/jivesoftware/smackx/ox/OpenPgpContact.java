package org.jivesoftware.smackx.ox;

import com.facebook.internal.security.CertificateUtil;
import en.a;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.selection_strategy.BareJidUserId;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.OpenPgpPubSubUtil;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jxmpp.jid.BareJid;

public class OpenPgpContact {
    private final Logger LOGGER;
    protected final BareJid jid;
    protected final OpenPgpStore store;
    protected final Map<a, Throwable> unfetchableKeys = new HashMap();

    public OpenPgpContact(BareJid bareJid, OpenPgpStore openPgpStore) {
        this.jid = bareJid;
        this.store = openPgpStore;
        this.LOGGER = Logger.getLogger(OpenPgpContact.class.getName() + CertificateUtil.DELIMITER + bareJid.toString());
    }

    public void distrust(a aVar) throws IOException {
        this.store.setTrust(getJid(), aVar, OpenPgpTrustStore.Trust.untrusted);
    }

    public PGPPublicKeyRingCollection getAnnouncedPublicKeys() throws IOException, PGPException {
        PGPPublicKeyRingCollection anyPublicKeys = getAnyPublicKeys();
        Map<a, Date> announcedFingerprintsOf = this.store.getAnnouncedFingerprintsOf(this.jid);
        BareJidUserId.PubRingSelectionStrategy pubRingSelectionStrategy = new BareJidUserId.PubRingSelectionStrategy();
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = null;
        for (a next : announcedFingerprintsOf.keySet()) {
            PGPPublicKeyRing publicKeyRing = anyPublicKeys.getPublicKeyRing(next.b());
            if (publicKeyRing != null) {
                PGPPublicKeyRing d10 = qn.a.d(publicKeyRing, publicKeyRing.getPublicKey(next.b()));
                if (!pubRingSelectionStrategy.accept(getJid(), d10)) {
                    Logger logger = this.LOGGER;
                    Level level = Level.WARNING;
                    logger.log(level, "Ignore key " + Long.toHexString(d10.getPublicKey().getKeyID()) + " as it lacks the user-id \"xmpp" + getJid().toString() + "\"");
                } else if (pGPPublicKeyRingCollection == null) {
                    pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(Collections.singleton(d10));
                } else {
                    pGPPublicKeyRingCollection = PGPPublicKeyRingCollection.addPublicKeyRing(pGPPublicKeyRingCollection, d10);
                }
            }
        }
        return pGPPublicKeyRingCollection;
    }

    public PGPPublicKeyRingCollection getAnyPublicKeys() throws IOException, PGPException {
        return this.store.getPublicKeysOf(this.jid);
    }

    public Set<a> getFingerprintsOfKeysWithState(PGPPublicKeyRingCollection pGPPublicKeyRingCollection, OpenPgpTrustStore.Trust trust) throws IOException {
        PGPPublicKeyRingCollection publicKeysOfTrustState = getPublicKeysOfTrustState(pGPPublicKeyRingCollection, trust);
        HashSet hashSet = new HashSet();
        if (publicKeysOfTrustState == null) {
            return hashSet;
        }
        Iterator it = publicKeysOfTrustState.iterator();
        while (it.hasNext()) {
            hashSet.add(new a((PGPPublicKeyRing) it.next()));
        }
        return hashSet;
    }

    public BareJid getJid() {
        return this.jid;
    }

    /* access modifiers changed from: protected */
    public PGPPublicKeyRingCollection getPublicKeysOfTrustState(PGPPublicKeyRingCollection pGPPublicKeyRingCollection, OpenPgpTrustStore.Trust trust) throws IOException {
        if (pGPPublicKeyRingCollection == null) {
            return null;
        }
        HashSet<PGPPublicKeyRing> hashSet = new HashSet<>();
        Iterator it = pGPPublicKeyRingCollection.iterator();
        while (it.hasNext()) {
            PGPPublicKeyRing pGPPublicKeyRing = (PGPPublicKeyRing) it.next();
            if (this.store.getTrust(getJid(), new a(pGPPublicKeyRing)) != trust) {
                hashSet.add(pGPPublicKeyRing);
            }
        }
        for (PGPPublicKeyRing removePublicKeyRing : hashSet) {
            pGPPublicKeyRingCollection = PGPPublicKeyRingCollection.removePublicKeyRing(pGPPublicKeyRingCollection, removePublicKeyRing);
        }
        if (!pGPPublicKeyRingCollection.iterator().hasNext()) {
            return null;
        }
        return pGPPublicKeyRingCollection;
    }

    public OpenPgpTrustStore.Trust getTrust(a aVar) throws IOException {
        return this.store.getTrust(getJid(), aVar);
    }

    public PGPPublicKeyRingCollection getTrustedAnnouncedKeys() throws IOException, PGPException {
        return getPublicKeysOfTrustState(getAnnouncedPublicKeys(), OpenPgpTrustStore.Trust.trusted);
    }

    public Set<a> getTrustedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.trusted);
    }

    public Set<a> getUndecidedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.undecided);
    }

    public Map<a, Throwable> getUnfetchableKeys() {
        return new HashMap(this.unfetchableKeys);
    }

    public Set<a> getUntrustedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.untrusted);
    }

    public boolean hasUndecidedKeys() throws IOException, PGPException {
        return getUndecidedFingerprints().size() != 0;
    }

    public boolean isTrusted(a aVar) throws IOException {
        return getTrust(aVar) == OpenPgpTrustStore.Trust.trusted;
    }

    public void trust(a aVar) throws IOException {
        this.store.setTrust(getJid(), aVar, OpenPgpTrustStore.Trust.trusted);
    }

    public void updateKeys(XMPPConnection xMPPConnection) throws InterruptedException, SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException, PubSubException.NotAPubSubNodeException, IOException {
        PublicKeysListElement fetchPubkeysList = OpenPgpPubSubUtil.fetchPubkeysList(xMPPConnection, getJid());
        if (fetchPubkeysList != null) {
            updateKeys(xMPPConnection, fetchPubkeysList);
        }
    }

    public void updateKeys(XMPPConnection xMPPConnection, PublicKeysListElement publicKeysListElement) throws InterruptedException, SmackException.NotConnectedException, SmackException.NoResponseException, IOException {
        HashMap hashMap = new HashMap();
        for (a next : publicKeysListElement.getMetadata().keySet()) {
            hashMap.put(next, publicKeysListElement.getMetadata().get(next).getDate());
        }
        this.store.setAnnouncedFingerprintsOf(getJid(), hashMap);
        Map<a, Date> publicKeyFetchDates = this.store.getPublicKeyFetchDates(getJid());
        for (a next2 : publicKeysListElement.getMetadata().keySet()) {
            Date date = publicKeyFetchDates.get(next2);
            if (date == null || hashMap.get(next2) == null || !date.after((Date) hashMap.get(next2))) {
                try {
                    PubkeyElement fetchPubkey = OpenPgpPubSubUtil.fetchPubkey(xMPPConnection, getJid(), next2);
                    this.unfetchableKeys.remove(next2);
                    publicKeyFetchDates.put(next2, new Date());
                    if (fetchPubkey == null) {
                        Logger logger = this.LOGGER;
                        Level level = Level.WARNING;
                        logger.log(level, "Public key " + Long.toHexString(next2.b()) + " can not be imported: Is null");
                        this.unfetchableKeys.put(next2, new NullPointerException("Public key is null."));
                    } else {
                        this.store.importPublicKey(getJid(), new PGPPublicKeyRing(Base64.decode(fetchPubkey.getDataElement().getB64Data()), new BcKeyFingerprintCalculator()));
                    }
                } catch (XMPPException.XMPPErrorException | PubSubException.NotALeafNodeException | PubSubException.NotAPubSubNodeException e10) {
                    Logger logger2 = this.LOGGER;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Error fetching public key " + Long.toHexString(next2.b()), e10);
                    this.unfetchableKeys.put(next2, e10);
                } catch (IOException | PGPException e11) {
                    Logger logger3 = this.LOGGER;
                    Level level3 = Level.WARNING;
                    logger3.log(level3, "Public key " + Long.toHexString(next2.b()) + " can not be imported.", e11);
                    this.unfetchableKeys.put(next2, e11);
                } catch (MissingUserIdOnKeyException e12) {
                    Logger logger4 = this.LOGGER;
                    Level level4 = Level.WARNING;
                    logger4.log(level4, "Public key " + Long.toHexString(next2.b()) + " is missing the user-id \"xmpp:" + getJid() + "\". Refuse to import it.", e12);
                    this.unfetchableKeys.put(next2, e12);
                }
            } else {
                Logger logger5 = this.LOGGER;
                Level level5 = Level.FINE;
                logger5.log(level5, "Skip key " + Long.toHexString(next2.b()) + " as we already have the most recent version. Last announced: " + ((Date) hashMap.get(next2)).toString() + " Last fetched: " + date.toString());
            }
        }
        this.store.setPublicKeyFetchDates(getJid(), publicKeyFetchDates);
    }
}
