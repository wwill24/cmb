package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

public class ThreadFilter extends FlexibleStanzaTypeFilter<Message> {
    private final String thread;

    public ThreadFilter(String str) {
        StringUtils.requireNotNullNorEmpty(str, "Thread must not be null nor empty.");
        this.thread = str;
    }

    public String toString() {
        return getClass().getSimpleName() + ": thread=" + this.thread;
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Message message) {
        return this.thread.equals(message.getThread());
    }
}
