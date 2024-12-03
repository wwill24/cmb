package org.jivesoftware.smack.chat2;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatManager f24105a;

    public /* synthetic */ a(ChatManager chatManager) {
        this.f24105a = chatManager;
    }

    public final void accept(Object obj) {
        this.f24105a.lambda$new$0((MessageBuilder) obj);
    }
}
