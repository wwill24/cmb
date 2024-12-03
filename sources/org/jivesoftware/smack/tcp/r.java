package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.tcp.XmppTcpTransportModule;
import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class r implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XmppTcpTransportModule.TlsState f24162a;

    public /* synthetic */ r(XmppTcpTransportModule.TlsState tlsState) {
        this.f24162a = tlsState;
    }

    public final Object get() {
        return this.f24162a.lambda$waitForHandshakeFinished$2();
    }
}
