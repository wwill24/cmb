package org.jivesoftware.smack;

import org.jivesoftware.smack.packet.Stanza;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StanzaListener f24100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Stanza f24101b;

    public /* synthetic */ c(StanzaListener stanzaListener, Stanza stanza) {
        this.f24100a = stanzaListener;
        this.f24101b = stanza;
    }

    public final void run() {
        AbstractXMPPConnection.lambda$invokeStanzaCollectorsAndNotifyRecvListeners$8(this.f24100a, this.f24101b);
    }
}
