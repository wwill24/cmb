package org.jivesoftware.smack.roster;

import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;

public abstract class AbstractPresenceEventListener implements PresenceEventListener {
    public void presenceAvailable(FullJid fullJid, Presence presence) {
    }

    public void presenceError(Jid jid, Presence presence) {
    }

    public void presenceSubscribed(BareJid bareJid, Presence presence) {
    }

    public void presenceUnavailable(FullJid fullJid, Presence presence) {
    }

    public void presenceUnsubscribed(BareJid bareJid, Presence presence) {
    }
}
