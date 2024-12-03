package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.HashCode;

public final /* synthetic */ class b implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Message.Body f24133a;

    public /* synthetic */ b(Message.Body body) {
        this.f24133a = body;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24133a.lambda$hashCode$0(builder);
    }
}
