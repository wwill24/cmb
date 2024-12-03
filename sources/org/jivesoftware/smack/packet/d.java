package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.HashCode;

public final /* synthetic */ class d implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Message.Subject f24135a;

    public /* synthetic */ d(Message.Subject subject) {
        this.f24135a = subject;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24135a.lambda$hashCode$0(builder);
    }
}
