package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class c implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Message.Body f24134a;

    public /* synthetic */ c(Message.Body body) {
        this.f24134a = body;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24134a.lambda$equals$1(builder, (Message.Body) obj);
    }
}
