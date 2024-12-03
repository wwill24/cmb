package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24152a;

    public /* synthetic */ f(XMPPTCPConnection xMPPTCPConnection) {
        this.f24152a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24152a.lambda$loginInternal$1();
    }
}
