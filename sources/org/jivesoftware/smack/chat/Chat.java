package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

@Deprecated
public class Chat {
    private final ChatManager chatManager;
    private final Set<ChatMessageListener> listeners = new CopyOnWriteArraySet();
    private final EntityJid participant;
    private final String threadID;

    Chat(ChatManager chatManager2, EntityJid entityJid, String str) {
        if (!StringUtils.isEmpty(str)) {
            this.chatManager = chatManager2;
            this.participant = entityJid;
            this.threadID = str;
            return;
        }
        throw new IllegalArgumentException("Thread ID must not be null");
    }

    public void addMessageListener(ChatMessageListener chatMessageListener) {
        if (chatMessageListener != null) {
            this.listeners.add(chatMessageListener);
        }
    }

    public void close() {
        this.chatManager.closeChat(this);
        this.listeners.clear();
    }

    public StanzaCollector createCollector() {
        return this.chatManager.createStanzaCollector(this);
    }

    /* access modifiers changed from: package-private */
    public void deliver(Message message) {
        message.setThread(this.threadID);
        for (ChatMessageListener processMessage : this.listeners) {
            processMessage.processMessage(this, message);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Chat) {
            Chat chat = (Chat) obj;
            if (!this.threadID.equals(chat.getThreadID()) || !this.participant.Y(chat.getParticipant())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Set<ChatMessageListener> getListeners() {
        return Collections.unmodifiableSet(this.listeners);
    }

    public EntityJid getParticipant() {
        return this.participant;
    }

    public String getThreadID() {
        return this.threadID;
    }

    public int hashCode() {
        return ((this.threadID.hashCode() + 31) * 31) + this.participant.hashCode();
    }

    public void removeMessageListener(ChatMessageListener chatMessageListener) {
        this.listeners.remove(chatMessageListener);
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        sendMessage(StanzaBuilder.buildMessage().setBody(str));
    }

    public String toString() {
        return "Chat [(participant=" + this.participant + "), (thread=" + this.threadID + ")]";
    }

    public void sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        messageBuilder.to((Jid) this.participant);
        messageBuilder.ofType(Message.Type.chat);
        messageBuilder.setThread(this.threadID);
        this.chatManager.sendMessage(this, messageBuilder.build());
    }

    public void sendMessage(Message message) throws SmackException.NotConnectedException, InterruptedException {
        message.setTo(this.participant);
        message.setType(Message.Type.chat);
        message.setThread(this.threadID);
        this.chatManager.sendMessage(this, message);
    }
}
