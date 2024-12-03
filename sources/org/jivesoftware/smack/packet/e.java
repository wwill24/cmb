package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class e implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Message.Subject f24136a;

    public /* synthetic */ e(Message.Subject subject) {
        this.f24136a = subject;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24136a.lambda$equals$1(builder, (Message.Subject) obj);
    }
}
