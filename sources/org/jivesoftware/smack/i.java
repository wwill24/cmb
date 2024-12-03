package org.jivesoftware.smack;

import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

public final /* synthetic */ class i implements NonzaCallback.NonzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24124a;

    public /* synthetic */ i(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24124a = abstractXMPPConnection;
    }

    public final void accept(Nonza nonza) {
        this.f24124a.lambda$new$2((SaslNonza.SASLFailure) nonza);
    }
}
