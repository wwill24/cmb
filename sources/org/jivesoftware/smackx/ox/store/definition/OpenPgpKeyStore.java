package org.jivesoftware.smackx.ox.store.definition;

import en.a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jxmpp.jid.BareJid;

public interface OpenPgpKeyStore {
    void deletePublicKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException;

    void deleteSecretKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException;

    fn.a generateKeyRing(BareJid bareJid) throws PGPException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException;

    Map<a, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException;

    PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException;

    PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException;

    PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, a aVar) throws IOException, PGPException;

    PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException;

    void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException;

    void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws IOException, PGPException, MissingUserIdOnKeyException;

    void setPublicKeyFetchDates(BareJid bareJid, Map<a, Date> map) throws IOException;
}
