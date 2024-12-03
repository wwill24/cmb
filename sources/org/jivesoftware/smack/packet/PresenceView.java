package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Presence;

public interface PresenceView extends StanzaView {
    Presence.Mode getMode();

    int getPriority();

    byte getPriorityByte();

    String getStatus();

    Presence.Type getType();
}
