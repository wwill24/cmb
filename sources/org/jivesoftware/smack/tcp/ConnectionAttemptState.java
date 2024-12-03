package org.jivesoftware.smack.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.tcp.TcpHostEvent;
import org.jivesoftware.smack.tcp.XmppTcpTransportModule;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;

public final class ConnectionAttemptState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean connected;
    Rfc6120TcpRemoteConnectionEndpoint connectionEndpoint;
    final Iterator<Rfc6120TcpRemoteConnectionEndpoint> connectionEndpointIterator;
    SmackException.EndpointConnectionException connectionException;
    final List<RemoteConnectionException<?>> connectionExceptions;
    private final ModularXmppClientToServerConnectionInternal connectionInternal;
    long deadline;
    private final XmppTcpTransportModule.XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredEndpoints;
    private final XmppTcpTransportModule.EstablishingTcpConnectionState establishingTcpConnectionState;
    Iterator<? extends InetAddress> inetAddressIterator;
    final SocketChannel socketChannel;

    ConnectionAttemptState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, XmppTcpTransportModule.XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredTcpEndpoints, XmppTcpTransportModule.EstablishingTcpConnectionState establishingTcpConnectionState2) throws IOException {
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
        this.discoveredEndpoints = discoveredTcpEndpoints;
        this.establishingTcpConnectionState = establishingTcpConnectionState2;
        SocketChannel open = SocketChannel.open();
        this.socketChannel = open;
        open.configureBlocking(false);
        List<RCE> list = discoveredTcpEndpoints.result.discoveredRemoteConnectionEndpoints;
        this.connectionEndpointIterator = list.iterator();
        this.connectionExceptions = new ArrayList(list.size());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$establishTcpConnection$1(RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling) {
        lambda$establishTcpConnection$0(new IOException("finishConnect() failed"), inetSocketAddressCoupling);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$establishTcpConnection$2(RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling, SelectableChannel selectableChannel, SelectionKey selectionKey) {
        try {
            if (!((SocketChannel) selectableChannel).finishConnect()) {
                Async.go(new b(this, inetSocketAddressCoupling));
                return;
            }
            this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectedToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling, false));
            this.connected = true;
            synchronized (this) {
                notifyAll();
            }
        } catch (IOException e10) {
            Async.go(new a(this, e10, inetSocketAddressCoupling));
        }
    }

    private RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> nextAddress() {
        Iterator<? extends InetAddress> it = this.inetAddressIterator;
        if (it == null || !it.hasNext()) {
            if (!this.connectionEndpointIterator.hasNext()) {
                return null;
            }
            Rfc6120TcpRemoteConnectionEndpoint next = this.connectionEndpointIterator.next();
            this.connectionEndpoint = next;
            this.inetAddressIterator = next.getInetAddresses().iterator();
        }
        return new RemoteConnectionEndpoint.InetSocketAddressCoupling<>(this.connectionEndpoint, (InetAddress) this.inetAddressIterator.next());
    }

    /* access modifiers changed from: private */
    /* renamed from: onIOExceptionWhenEstablishingTcpConnection */
    public void lambda$establishTcpConnection$0(IOException iOException, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> nextAddress = nextAddress();
        if (nextAddress == null) {
            this.connectionException = SmackException.EndpointConnectionException.from(this.discoveredEndpoints.result.lookupFailures, this.connectionExceptions);
            synchronized (this) {
                notifyAll();
            }
            return;
        }
        this.connectionExceptions.add(new RemoteConnectionException(inetSocketAddressCoupling, iOException));
        this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectionToHostFailedEvent(this.establishingTcpConnectionState, nextAddress, iOException));
        establishTcpConnection(nextAddress);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r0 == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return new org.jivesoftware.smack.fsm.StateTransitionResult.FailureCausedByException(r5.connectionException);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smack.fsm.StateTransitionResult.Failure establishTcpConnection() throws java.lang.InterruptedException {
        /*
            r5 = this;
            org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint$InetSocketAddressCoupling r0 = r5.nextAddress()
            r5.establishTcpConnection(r0)
            monitor-enter(r5)
        L_0x0008:
            boolean r0 = r5.connected     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0028
            org.jivesoftware.smack.SmackException$EndpointConnectionException r1 = r5.connectionException     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0028
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0035 }
            long r2 = r5.deadline     // Catch:{ all -> 0x0035 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0023
            org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByTimeout r0 = new org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByTimeout     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "Timeout waiting to establish connection"
            r0.<init>(r1)     // Catch:{ all -> 0x0035 }
            monitor-exit(r5)     // Catch:{ all -> 0x0035 }
            return r0
        L_0x0023:
            long r2 = r2 - r0
            r5.wait(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x0008
        L_0x0028:
            monitor-exit(r5)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x002d
            r0 = 0
            return r0
        L_0x002d:
            org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByException r0 = new org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByException
            org.jivesoftware.smack.SmackException$EndpointConnectionException r1 = r5.connectionException
            r0.<init>(r1)
            return r0
        L_0x0035:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.ConnectionAttemptState.establishTcpConnection():org.jivesoftware.smack.fsm.StateTransitionResult$Failure");
    }

    private void establishTcpConnection(RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectingToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling));
        InetSocketAddress inetSocketAddress = inetSocketAddressCoupling.getInetSocketAddress();
        this.deadline = System.currentTimeMillis() + this.connectionInternal.connection.getReplyTimeout();
        try {
            boolean connect = this.socketChannel.connect(inetSocketAddress);
            this.connected = connect;
            if (connect) {
                this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectedToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling, true));
                synchronized (this) {
                    notifyAll();
                }
                return;
            }
            try {
                this.connectionInternal.registerWithSelector(this.socketChannel, 8, new c(this, inetSocketAddressCoupling));
            } catch (ClosedChannelException e10) {
                lambda$establishTcpConnection$0(e10, inetSocketAddressCoupling);
            }
        } catch (IOException e11) {
            lambda$establishTcpConnection$0(e11, inetSocketAddressCoupling);
        }
    }
}
