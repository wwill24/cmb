package org.jivesoftware.smackx.ox.store.definition;

import jn.a;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.callback.SecretKeyPassphraseCallback;
import org.jxmpp.jid.BareJid;

public interface OpenPgpStore extends OpenPgpKeyStore, OpenPgpMetadataStore, OpenPgpTrustStore {
    a getKeyRingProtector();

    OpenPgpContact getOpenPgpContact(BareJid bareJid);

    void setKeyRingProtector(a aVar);

    void setSecretKeyPassphraseCallback(SecretKeyPassphraseCallback secretKeyPassphraseCallback);
}
