package org.jivesoftware.smack;

public interface ReconnectionListener {
    void reconnectingIn(int i10);

    void reconnectionFailed(Exception exc);
}
