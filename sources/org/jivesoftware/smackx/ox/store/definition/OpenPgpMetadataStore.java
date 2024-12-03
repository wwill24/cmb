package org.jivesoftware.smackx.ox.store.definition;

import en.a;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.jxmpp.jid.BareJid;

public interface OpenPgpMetadataStore {
    Map<a, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException;

    void setAnnouncedFingerprintsOf(BareJid bareJid, Map<a, Date> map) throws IOException;
}
