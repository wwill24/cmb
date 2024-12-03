package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24156a;

    public /* synthetic */ j(XMPPTCPConnection xMPPTCPConnection) {
        this.f24156a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24156a.lambda$connectInternal$7();
    }
}
