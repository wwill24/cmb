package org.jivesoftware.smack;

public abstract class AbstractConnectionClosedListener implements ConnectionListener {
    public final void connectionClosed() {
        connectionTerminated();
    }

    public final void connectionClosedOnError(Exception exc) {
        connectionTerminated();
    }

    public abstract void connectionTerminated();
}
