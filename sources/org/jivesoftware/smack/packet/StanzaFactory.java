package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.id.StanzaIdSource;

public final class StanzaFactory {
    private final StanzaIdSource stanzaIdSource;

    public StanzaFactory(StanzaIdSource stanzaIdSource2) {
        this.stanzaIdSource = stanzaIdSource2;
    }

    public IqData buildIqData() {
        return new IqData(this.stanzaIdSource);
    }

    public MessageBuilder buildMessageStanza() {
        return new MessageBuilder(this.stanzaIdSource);
    }

    public MessageBuilder buildMessageStanzaFrom(Message message) {
        return new MessageBuilder(message, this.stanzaIdSource);
    }

    public PresenceBuilder buildPresenceStanza() {
        return new PresenceBuilder(this.stanzaIdSource);
    }

    public PresenceBuilder buildPresenceStanzaFrom(Presence presence) {
        return new PresenceBuilder(presence, this.stanzaIdSource);
    }

    /* access modifiers changed from: package-private */
    public StanzaIdSource getStanzaIdSource() {
        return this.stanzaIdSource;
    }
}
