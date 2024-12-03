package org.jivesoftware.smackx.ox.store.abstr;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jn.a;
import jn.b;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.callback.SecretKeyPassphraseCallback;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jxmpp.jid.BareJid;

public abstract class AbstractOpenPgpStore implements OpenPgpStore {
    protected final Map<BareJid, OpenPgpContact> contacts = new HashMap();
    protected final OpenPgpKeyStore keyStore;
    protected final OpenPgpMetadataStore metadataStore;
    protected SecretKeyPassphraseCallback secretKeyPassphraseCallback;
    protected final OpenPgpTrustStore trustStore;
    protected a unlocker = new b();

    protected AbstractOpenPgpStore(OpenPgpKeyStore openPgpKeyStore, OpenPgpMetadataStore openPgpMetadataStore, OpenPgpTrustStore openPgpTrustStore) {
        this.keyStore = (OpenPgpKeyStore) Objects.requireNonNull(openPgpKeyStore);
        this.metadataStore = (OpenPgpMetadataStore) Objects.requireNonNull(openPgpMetadataStore);
        this.trustStore = (OpenPgpTrustStore) Objects.requireNonNull(openPgpTrustStore);
    }

    public void deletePublicKeyRing(BareJid bareJid, en.a aVar) throws IOException, PGPException {
        this.keyStore.deletePublicKeyRing(bareJid, aVar);
    }

    public void deleteSecretKeyRing(BareJid bareJid, en.a aVar) throws IOException, PGPException {
        this.keyStore.deleteSecretKeyRing(bareJid, aVar);
    }

    public fn.a generateKeyRing(BareJid bareJid) throws PGPException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return this.keyStore.generateKeyRing(bareJid);
    }

    public Map<en.a, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        return this.metadataStore.getAnnouncedFingerprintsOf(bareJid);
    }

    public a getKeyRingProtector() {
        return this.unlocker;
    }

    public OpenPgpContact getOpenPgpContact(BareJid bareJid) {
        OpenPgpContact openPgpContact = this.contacts.get(bareJid);
        if (openPgpContact != null) {
            return openPgpContact;
        }
        OpenPgpContact openPgpContact2 = new OpenPgpContact(bareJid, this);
        this.contacts.put(bareJid, openPgpContact2);
        return openPgpContact2;
    }

    public Map<en.a, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException {
        return this.keyStore.getPublicKeyFetchDates(bareJid);
    }

    public PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, en.a aVar) throws IOException, PGPException {
        return this.keyStore.getPublicKeyRing(bareJid, aVar);
    }

    public PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        return this.keyStore.getPublicKeysOf(bareJid);
    }

    public PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, en.a aVar) throws IOException, PGPException {
        return this.keyStore.getSecretKeyRing(bareJid, aVar);
    }

    public PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        return this.keyStore.getSecretKeysOf(bareJid);
    }

    public OpenPgpTrustStore.Trust getTrust(BareJid bareJid, en.a aVar) throws IOException {
        return this.trustStore.getTrust(bareJid, aVar);
    }

    public void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException {
        this.keyStore.importPublicKey(bareJid, pGPPublicKeyRing);
    }

    public void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException {
        this.keyStore.importSecretKey(bareJid, pGPSecretKeyRing);
    }

    public void setAnnouncedFingerprintsOf(BareJid bareJid, Map<en.a, Date> map) throws IOException {
        this.metadataStore.setAnnouncedFingerprintsOf(bareJid, map);
    }

    public void setKeyRingProtector(a aVar) {
        this.unlocker = aVar;
    }

    public void setPublicKeyFetchDates(BareJid bareJid, Map<en.a, Date> map) throws IOException {
        this.keyStore.setPublicKeyFetchDates(bareJid, map);
    }

    public void setSecretKeyPassphraseCallback(SecretKeyPassphraseCallback secretKeyPassphraseCallback2) {
        this.secretKeyPassphraseCallback = secretKeyPassphraseCallback2;
    }

    public void setTrust(BareJid bareJid, en.a aVar, OpenPgpTrustStore.Trust trust) throws IOException {
        this.trustStore.setTrust(bareJid, aVar, trust);
    }
}
