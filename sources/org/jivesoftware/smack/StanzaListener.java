package org.jivesoftware.smack;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Stanza;

public interface StanzaListener {
    void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException;
}
