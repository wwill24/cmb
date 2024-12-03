package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24154a;

    public /* synthetic */ h(XMPPTCPConnection xMPPTCPConnection) {
        this.f24154a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24154a.lambda$loginInternal$3();
    }
}
