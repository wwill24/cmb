package org.jivesoftware.smackx.disco;

import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.packet.Stanza;

public final /* synthetic */ class a implements StanzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceDiscoveryManager f24203a;

    public /* synthetic */ a(ServiceDiscoveryManager serviceDiscoveryManager) {
        this.f24203a = serviceDiscoveryManager;
    }

    public final void processStanza(Stanza stanza) {
        this.f24203a.lambda$new$0(stanza);
    }
}
