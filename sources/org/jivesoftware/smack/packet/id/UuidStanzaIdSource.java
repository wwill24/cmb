package org.jivesoftware.smack.packet.id;

import java.util.UUID;

public final class UuidStanzaIdSource implements StanzaIdSource {
    public static final UuidStanzaIdSource INSTANCE = new UuidStanzaIdSource();

    public static class Factory implements StanzaIdSourceFactory {
        public UuidStanzaIdSource constructStanzaIdSource() {
            return UuidStanzaIdSource.INSTANCE;
        }
    }

    private UuidStanzaIdSource() {
    }

    public String getNewStanzaId() {
        return UUID.randomUUID().toString();
    }
}
