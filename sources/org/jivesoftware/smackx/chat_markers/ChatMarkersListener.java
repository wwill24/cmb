package org.jivesoftware.smackx.chat_markers;

import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.packet.Message;

public interface ChatMarkersListener {
    void newChatMarkerMessage(ChatMarkersState chatMarkersState, Message message, Chat chat);
}
