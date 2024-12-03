package org.jivesoftware.smack;

public interface ConnectionListener {
    void authenticated(XMPPConnection xMPPConnection, boolean z10) {
    }

    void connected(XMPPConnection xMPPConnection) {
    }

    void connecting(XMPPConnection xMPPConnection) {
    }

    void connectionClosed() {
    }

    void connectionClosedOnError(Exception exc) {
    }
}
