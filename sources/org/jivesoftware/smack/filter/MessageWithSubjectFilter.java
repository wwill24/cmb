package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;

public final class MessageWithSubjectFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter INSTANCE = new MessageWithSubjectFilter();

    private MessageWithSubjectFilter() {
        super(Message.class);
    }

    public String toString() {
        return MessageWithSubjectFilter.class.getSimpleName();
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Message message) {
        return message.getSubject() != null;
    }
}
