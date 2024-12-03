package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.MessageBuilder;

public interface MucMessageInterceptor {
    void intercept(MessageBuilder messageBuilder, MultiUserChat multiUserChat);
}
