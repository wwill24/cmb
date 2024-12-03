package org.jivesoftware.smackx.sid;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smackx.muc.MucMessageInterceptor;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.sid.StableUniqueStanzaIdManager;

public final /* synthetic */ class c implements MucMessageInterceptor {
    public final void intercept(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
        StableUniqueStanzaIdManager.AnonymousClass1.lambda$connectionCreated$0(messageBuilder, multiUserChat);
    }
}
