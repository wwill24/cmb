package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

public final /* synthetic */ class d implements NonzaCallback.NonzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f24150a;

    public /* synthetic */ d(XMPPTCPConnection xMPPTCPConnection) {
        this.f24150a = xMPPTCPConnection;
    }

    public final void accept(Nonza nonza) {
        this.f24150a.lambda$new$0((SaslNonza.Success) nonza);
    }
}
