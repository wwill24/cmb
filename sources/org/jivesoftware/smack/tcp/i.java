package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24155a;

    public /* synthetic */ i(XMPPTCPConnection xMPPTCPConnection) {
        this.f24155a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24155a.lambda$connectInternal$6();
    }
}
