package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Objects;

public final class IqData extends AbstractIqBuilder<IqData> {
    static final IqData EMPTY = new IqData((StanzaIdSource) StandardStanzaIdSource.DEFAULT);

    IqData(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    public Stanza build() {
        throw new UnsupportedOperationException();
    }

    public IqData getThis() {
        return this;
    }

    public IqData ofType(IQ.Type type) {
        this.type = (IQ.Type) Objects.requireNonNull(type);
        return getThis();
    }

    IqData(String str) {
        super(str);
    }
}
