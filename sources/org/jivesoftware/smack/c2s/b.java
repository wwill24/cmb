package org.jivesoftware.smack.c2s;

import org.jivesoftware.smack.fsm.ConnectionStateEvent;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModularXmppClientToServerConnection f24103a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConnectionStateEvent f24104b;

    public /* synthetic */ b(ModularXmppClientToServerConnection modularXmppClientToServerConnection, ConnectionStateEvent connectionStateEvent) {
        this.f24103a = modularXmppClientToServerConnection;
        this.f24104b = connectionStateEvent;
    }

    public final void run() {
        this.f24103a.lambda$invokeConnectionStateMachineListener$1(this.f24104b);
    }
}
