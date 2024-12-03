package org.jivesoftware.smackx.ox.store.definition;

import en.a;
import java.io.IOException;
import org.jxmpp.jid.BareJid;

public interface OpenPgpTrustStore {

    public enum Trust {
        trusted,
        untrusted,
        undecided
    }

    Trust getTrust(BareJid bareJid, a aVar) throws IOException;

    void setTrust(BareJid bareJid, a aVar, Trust trust) throws IOException;
}
