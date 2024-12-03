package org.jivesoftware.smack.tcp;

import java.io.IOException;
import org.jivesoftware.smack.fsm.ConnectionStateEvent;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

public abstract class TcpHostEvent extends ConnectionStateEvent.DetailedTransitionIntoInformation {
    protected final RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> address;

    public static final class ConnectedToHostEvent extends TcpHostEvent {
        private final boolean connectionEstablishedImmediately;

        ConnectedToHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling, boolean z10) {
            super(state, inetSocketAddressCoupling);
            this.connectionEstablishedImmediately = z10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(TcpHostEvent.super.toString());
            sb2.append(this.connectionEstablishedImmediately ? "" : " not");
            sb2.append(" connected immediately");
            return sb2.toString();
        }
    }

    public static final class ConnectingToHostEvent extends TcpHostEvent {
        ConnectingToHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
            super(state, inetSocketAddressCoupling);
        }
    }

    public static final class ConnectionToHostFailedEvent extends TcpHostEvent {
        private final IOException ioException;

        ConnectionToHostFailedEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling, IOException iOException) {
            super(state, inetSocketAddressCoupling);
            this.ioException = iOException;
        }

        public String toString() {
            return TcpHostEvent.super.toString() + this.ioException;
        }
    }

    protected TcpHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        super(state);
        this.address = inetSocketAddressCoupling;
    }

    public RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> getAddress() {
        return this.address;
    }

    public String toString() {
        return super.toString() + ": " + this.address;
    }
}
