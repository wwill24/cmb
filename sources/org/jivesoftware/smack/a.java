package org.jivesoftware.smack;

import org.jivesoftware.smack.packet.ErrorIQ;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ErrorIQ f24098b;

    public /* synthetic */ a(AbstractXMPPConnection abstractXMPPConnection, ErrorIQ errorIQ) {
        this.f24097a = abstractXMPPConnection;
        this.f24098b = errorIQ;
    }

    public final void run() {
        this.f24097a.lambda$invokeStanzaCollectorsAndNotifyRecvListeners$7(this.f24098b);
    }
}
