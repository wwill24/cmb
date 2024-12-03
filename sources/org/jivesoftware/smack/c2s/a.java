package org.jivesoftware.smack.c2s;

import org.jivesoftware.smack.util.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModularXmppClientToServerConnection f24102a;

    public /* synthetic */ a(ModularXmppClientToServerConnection modularXmppClientToServerConnection) {
        this.f24102a = modularXmppClientToServerConnection;
    }

    public final Object get() {
        return this.f24102a.lambda$waitForFeaturesReceived$0();
    }
}
