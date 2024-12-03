package org.jivesoftware.smack.fsm;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;

public interface ConnectionStateMachineListener {
    void onConnectionStateEvent(ConnectionStateEvent connectionStateEvent, ModularXmppClientToServerConnection modularXmppClientToServerConnection);
}
