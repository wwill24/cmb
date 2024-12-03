package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.MessageOrPresence;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.id.StanzaIdSource;

public abstract class MessageOrPresenceBuilder<MP extends MessageOrPresence<? extends MessageOrPresenceBuilder<MP, SB>>, SB extends StanzaBuilder<SB>> extends StanzaBuilder<SB> {
    protected MessageOrPresenceBuilder(Stanza stanza, StanzaIdSource stanzaIdSource) {
        super(stanza, stanzaIdSource);
    }

    public abstract MP build();

    protected MessageOrPresenceBuilder(Stanza stanza, String str) {
        super(stanza, str);
    }

    protected MessageOrPresenceBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    protected MessageOrPresenceBuilder(String str) {
        super(str);
    }
}
