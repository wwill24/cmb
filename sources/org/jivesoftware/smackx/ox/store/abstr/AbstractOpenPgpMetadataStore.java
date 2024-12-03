package org.jivesoftware.smackx.ox.store.abstr;

import en.a;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore;
import org.jxmpp.jid.BareJid;

public abstract class AbstractOpenPgpMetadataStore implements OpenPgpMetadataStore {
    private final Map<BareJid, Map<a, Date>> announcedFingerprints = new HashMap();

    public Map<a, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        Map<a, Date> map = this.announcedFingerprints.get(bareJid);
        if (map != null) {
            return map;
        }
        Map<a, Date> readAnnouncedFingerprintsOf = readAnnouncedFingerprintsOf(bareJid);
        this.announcedFingerprints.put(bareJid, readAnnouncedFingerprintsOf);
        return readAnnouncedFingerprintsOf;
    }

    /* access modifiers changed from: protected */
    public abstract Map<a, Date> readAnnouncedFingerprintsOf(BareJid bareJid) throws IOException;

    public void setAnnouncedFingerprintsOf(BareJid bareJid, Map<a, Date> map) throws IOException {
        this.announcedFingerprints.put(bareJid, map);
        writeAnnouncedFingerprintsOf(bareJid, map);
    }

    /* access modifiers changed from: protected */
    public abstract void writeAnnouncedFingerprintsOf(BareJid bareJid, Map<a, Date> map) throws IOException;
}
