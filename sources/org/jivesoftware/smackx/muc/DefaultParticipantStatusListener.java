package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

@Deprecated
public class DefaultParticipantStatusListener implements ParticipantStatusListener {
    public void adminGranted(EntityFullJid entityFullJid) {
    }

    public void adminRevoked(EntityFullJid entityFullJid) {
    }

    public void banned(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    public void joined(EntityFullJid entityFullJid) {
    }

    public void kicked(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    public void left(EntityFullJid entityFullJid) {
    }

    public void membershipGranted(EntityFullJid entityFullJid) {
    }

    public void membershipRevoked(EntityFullJid entityFullJid) {
    }

    public void moderatorGranted(EntityFullJid entityFullJid) {
    }

    public void moderatorRevoked(EntityFullJid entityFullJid) {
    }

    public void nicknameChanged(EntityFullJid entityFullJid, Resourcepart resourcepart) {
    }

    public void ownershipGranted(EntityFullJid entityFullJid) {
    }

    public void ownershipRevoked(EntityFullJid entityFullJid) {
    }

    public void voiceGranted(EntityFullJid entityFullJid) {
    }

    public void voiceRevoked(EntityFullJid entityFullJid) {
    }
}
