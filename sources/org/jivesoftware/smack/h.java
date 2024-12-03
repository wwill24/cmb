package org.jivesoftware.smack;

import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

public final /* synthetic */ class h implements NonzaCallback.NonzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractXMPPConnection f24123a;

    public /* synthetic */ h(AbstractXMPPConnection abstractXMPPConnection) {
        this.f24123a = abstractXMPPConnection;
    }

    public final void accept(Nonza nonza) {
        this.f24123a.lambda$new$1((SaslNonza.Success) nonza);
    }
}
