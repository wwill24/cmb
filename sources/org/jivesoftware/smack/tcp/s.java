package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.tcp.XmppTcpTransportModule;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XmppTcpTransportModule.TlsState f24163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f24164b;

    public /* synthetic */ s(XmppTcpTransportModule.TlsState tlsState, Runnable runnable) {
        this.f24163a = tlsState;
        this.f24164b = runnable;
    }

    public final void run() {
        this.f24163a.lambda$handleHandshakeStatus$1(this.f24164b);
    }
}
