package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24157a;

    public /* synthetic */ k(XMPPTCPConnection xMPPTCPConnection) {
        this.f24157a = xMPPTCPConnection;
    }

    public final Object get() {
        return this.f24157a.lambda$maybeEnableCompression$5();
    }
}
