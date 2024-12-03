package org.jivesoftware.smackx.jingle.transports;

import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

public abstract class JingleTransportManager<D extends JingleContentTransport> implements ConnectionListener {
    private final XMPPConnection connection;

    public JingleTransportManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        xMPPConnection.addConnectionListener(this);
    }

    public void connected(XMPPConnection xMPPConnection) {
    }

    public XMPPConnection connection() {
        return this.connection;
    }

    public void connectionClosed() {
    }

    public void connectionClosedOnError(Exception exc) {
    }

    public XMPPConnection getConnection() {
        return connection();
    }

    public abstract String getNamespace();

    public abstract JingleTransportSession<D> transportSession(JingleSession jingleSession);
}
