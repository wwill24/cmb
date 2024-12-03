package org.jivesoftware.smack;

import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

public final /* synthetic */ class g implements NonzaCallback.NonzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24122a;

    public /* synthetic */ g(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24122a = abstractXMPPConnection;
    }

    public final void accept(Nonza nonza) {
        this.f24122a.lambda$new$0((SaslNonza.Challenge) nonza);
    }
}
