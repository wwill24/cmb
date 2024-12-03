package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;

public final class MessageTypeFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter CHAT;
    public static final StanzaFilter ERROR = new MessageTypeFilter(Message.Type.error);
    public static final StanzaFilter GROUPCHAT = new MessageTypeFilter(Message.Type.groupchat);
    public static final StanzaFilter HEADLINE;
    public static final StanzaFilter NORMAL;
    public static final StanzaFilter NORMAL_OR_CHAT;
    public static final StanzaFilter NORMAL_OR_CHAT_OR_HEADLINE;
    public static final StanzaFilter NORMAL_OR_HEADLINE;
    private final Message.Type type;

    static {
        MessageTypeFilter messageTypeFilter = new MessageTypeFilter(Message.Type.normal);
        NORMAL = messageTypeFilter;
        MessageTypeFilter messageTypeFilter2 = new MessageTypeFilter(Message.Type.chat);
        CHAT = messageTypeFilter2;
        MessageTypeFilter messageTypeFilter3 = new MessageTypeFilter(Message.Type.headline);
        HEADLINE = messageTypeFilter3;
        OrFilter orFilter = new OrFilter(messageTypeFilter, messageTypeFilter2);
        NORMAL_OR_CHAT = orFilter;
        NORMAL_OR_HEADLINE = new OrFilter(messageTypeFilter, messageTypeFilter3);
        NORMAL_OR_CHAT_OR_HEADLINE = new OrFilter(orFilter, messageTypeFilter3);
    }

    private MessageTypeFilter(Message.Type type2) {
        super(Message.class);
        this.type = type2;
    }

    public String toString() {
        return MessageTypeFilter.class.getSimpleName() + ": type=" + this.type;
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Message message) {
        return message.getType() == this.type;
    }
}
