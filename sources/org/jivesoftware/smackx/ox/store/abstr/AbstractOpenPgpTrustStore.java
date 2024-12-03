package org.jivesoftware.smackx.ox.store.abstr;

import en.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jxmpp.jid.BareJid;

public abstract class AbstractOpenPgpTrustStore implements OpenPgpTrustStore {
    private final Map<BareJid, Map<a, OpenPgpTrustStore.Trust>> trustCache = new HashMap();

    public OpenPgpTrustStore.Trust getTrust(BareJid bareJid, a aVar) throws IOException {
        Map map = this.trustCache.get(bareJid);
        if (map != null) {
            OpenPgpTrustStore.Trust trust = (OpenPgpTrustStore.Trust) map.get(aVar);
            if (trust != null) {
                return trust;
            }
        } else {
            map = new HashMap();
            this.trustCache.put(bareJid, map);
        }
        OpenPgpTrustStore.Trust readTrust = readTrust(bareJid, aVar);
        map.put(aVar, readTrust);
        return readTrust;
    }

    /* access modifiers changed from: protected */
    public abstract OpenPgpTrustStore.Trust readTrust(BareJid bareJid, a aVar) throws IOException;

    public void setTrust(BareJid bareJid, a aVar, OpenPgpTrustStore.Trust trust) throws IOException {
        Map map = this.trustCache.get(bareJid);
        if (map == null) {
            map = new HashMap();
            this.trustCache.put(bareJid, map);
        }
        if (map.get(aVar) != trust) {
            map.put(aVar, trust);
            writeTrust(bareJid, aVar, trust);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeTrust(BareJid bareJid, a aVar, OpenPgpTrustStore.Trust trust) throws IOException;
}
