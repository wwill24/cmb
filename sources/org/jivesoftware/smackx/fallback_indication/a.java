package org.jivesoftware.smackx.fallback_indication;

import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.packet.Stanza;

public final /* synthetic */ class a implements StanzaListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FallbackIndicationManager f24209a;

    public /* synthetic */ a(FallbackIndicationManager fallbackIndicationManager) {
        this.f24209a = fallbackIndicationManager;
    }

    public final void processStanza(Stanza stanza) {
        this.f24209a.fallbackIndicationElementListener(stanza);
    }
}
