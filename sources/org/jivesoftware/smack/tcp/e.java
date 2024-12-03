package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24151a;

    public /* synthetic */ e(XMPPTCPConnection xMPPTCPConnection) {
        this.f24151a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24151a.lambda$shutdown$4();
    }
}
