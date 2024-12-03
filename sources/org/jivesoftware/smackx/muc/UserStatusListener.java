package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.Jid;

public interface UserStatusListener {
    void adminGranted() {
    }

    void adminRevoked() {
    }

    void banned(Jid jid, String str) {
    }

    void kicked(Jid jid, String str) {
    }

    void membershipGranted() {
    }

    void membershipRevoked() {
    }

    void moderatorGranted() {
    }

    void moderatorRevoked() {
    }

    void ownershipGranted() {
    }

    void ownershipRevoked() {
    }

    void removed(MUCUser mUCUser, Presence presence) {
    }

    void roomDestroyed(MultiUserChat multiUserChat, String str) {
    }

    void voiceGranted() {
    }

    void voiceRevoked() {
    }
}
