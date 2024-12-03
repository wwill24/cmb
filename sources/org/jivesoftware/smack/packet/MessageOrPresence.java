package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.MessageOrPresenceBuilder;

public abstract class MessageOrPresence<MPB extends MessageOrPresenceBuilder<?, ?>> extends Stanza {
    @Deprecated
    protected MessageOrPresence() {
    }

    public abstract MPB asBuilder();

    public abstract MPB asBuilder(String str);

    public abstract MPB asBuilder(XMPPConnection xMPPConnection);

    protected MessageOrPresence(StanzaBuilder<?> stanzaBuilder) {
        super(stanzaBuilder);
    }

    protected MessageOrPresence(Stanza stanza) {
        super(stanza);
    }
}
