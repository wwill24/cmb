package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.tcp.XmppTcpTransportModule;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XmppTcpTransportModule.XmppTcpNioTransport f24165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmackFuture.InternalSmackFuture f24166b;

    public /* synthetic */ t(XmppTcpTransportModule.XmppTcpNioTransport xmppTcpNioTransport, SmackFuture.InternalSmackFuture internalSmackFuture) {
        this.f24165a = xmppTcpNioTransport;
        this.f24166b = internalSmackFuture;
    }

    public final void run() {
        this.f24165a.lambda$lookupConnectionEndpoints$0(this.f24166b);
    }
}
