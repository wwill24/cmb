package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.tcp.XmppTcpTransportModule;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XmppTcpTransportModule.TlsState f24161a;

    public /* synthetic */ q(XmppTcpTransportModule.TlsState tlsState) {
        this.f24161a = tlsState;
    }

    public final void run() {
        this.f24161a.lambda$input$0();
    }
}
