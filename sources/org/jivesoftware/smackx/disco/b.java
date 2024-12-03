package org.jivesoftware.smackx.disco;

import org.jivesoftware.smack.XMPPConnection;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceDiscoveryManager f24204a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XMPPConnection f24205b;

    public /* synthetic */ b(ServiceDiscoveryManager serviceDiscoveryManager, XMPPConnection xMPPConnection) {
        this.f24204a = serviceDiscoveryManager;
        this.f24205b = xMPPConnection;
    }

    public final void run() {
        this.f24204a.lambda$renewEntityCapsVersion$1(this.f24205b);
    }
}
