package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

public interface IqView extends StanzaView {
    IQ.Type getType();
}
