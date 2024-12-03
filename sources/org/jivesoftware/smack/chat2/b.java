package org.jivesoftware.smack.chat2;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Predicate;

public final /* synthetic */ class b implements Predicate {
    public final boolean test(Object obj) {
        return ChatManager.OUTGOING_MESSAGE_FILTER.accept((Message) obj);
    }
}
