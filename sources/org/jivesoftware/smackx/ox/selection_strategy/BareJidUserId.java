package org.jivesoftware.smackx.ox.selection_strategy;

import java.util.Iterator;
import nn.b;
import nn.c;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.jxmpp.jid.BareJid;

public class BareJidUserId {

    public static class PubRingSelectionStrategy extends b<BareJid> {
        public boolean accept(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) {
            Iterator userIDs = pGPPublicKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (((String) userIDs.next()).equals("xmpp:" + bareJid.toString())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SecRingSelectionStrategy extends c<BareJid> {
        public boolean accept(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) {
            Iterator userIDs = pGPSecretKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (((String) userIDs.next()).equals("xmpp:" + bareJid.toString())) {
                    return true;
                }
            }
            return false;
        }
    }
}
