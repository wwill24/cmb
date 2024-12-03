package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.Jid;

@Deprecated
public class DefaultUserStatusListener implements UserStatusListener {
    public void adminGranted() {
    }

    public void adminRevoked() {
    }

    public void banned(Jid jid, String str) {
    }

    public void kicked(Jid jid, String str) {
    }

    public void membershipGranted() {
    }

    public void membershipRevoked() {
    }

    public void moderatorGranted() {
    }

    public void moderatorRevoked() {
    }

    public void ownershipGranted() {
    }

    public void ownershipRevoked() {
    }

    public void roomDestroyed(MultiUserChat multiUserChat, String str) {
    }

    public void voiceGranted() {
    }

    public void voiceRevoked() {
    }
}
