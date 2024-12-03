package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24153a;

    public /* synthetic */ g(XMPPTCPConnection xMPPTCPConnection) {
        this.f24153a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24153a.lambda$loginInternal$2();
    }
}
