package org.jivesoftware.smackx.ox;

import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.jid.EntityBareJid;

public final /* synthetic */ class b implements IncomingChatMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpenPgpManager f24219a;

    public /* synthetic */ b(OpenPgpManager openPgpManager) {
        this.f24219a = openPgpManager;
    }

    public final void newIncomingMessage(EntityBareJid entityBareJid, Message message, Chat chat) {
        this.f24219a.incomingChatMessageListener(entityBareJid, message, chat);
    }
}
