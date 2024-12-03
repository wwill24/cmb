package org.jivesoftware.smack.sm.predicates.tcp;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.util.StringUtils;

public final class OnceForThisStanza implements StanzaFilter {
    private final XMPPTCPConnection connection;

    /* renamed from: id  reason: collision with root package name */
    private final String f24142id;

    private OnceForThisStanza(XMPPTCPConnection xMPPTCPConnection, Stanza stanza) {
        this.connection = xMPPTCPConnection;
        String stanzaId = stanza.getStanzaId();
        this.f24142id = stanzaId;
        if (StringUtils.isNullOrEmpty((CharSequence) stanzaId)) {
            throw new IllegalArgumentException("Stanza ID must be set");
        }
    }

    public static void setup(XMPPTCPConnection xMPPTCPConnection, Stanza stanza) {
        xMPPTCPConnection.addRequestAckPredicate(new OnceForThisStanza(xMPPTCPConnection, stanza));
    }

    public boolean accept(Stanza stanza) {
        String stanzaId = stanza.getStanzaId();
        if (StringUtils.isNullOrEmpty((CharSequence) stanzaId) || !this.f24142id.equals(stanzaId)) {
            return false;
        }
        this.connection.removeRequestAckPredicate(this);
        return true;
    }
}
