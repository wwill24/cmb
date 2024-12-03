package org.jivesoftware.smackx.bytestreams.socks5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.filetransfer.StreamNegotiator;

final class InitiationListener extends AbstractIqRequestHandler {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(InitiationListener.class.getName());
    private final ExecutorService initiationListenerExecutor = Executors.newCachedThreadPool();
    private final Socks5BytestreamManager manager;

    protected InitiationListener(Socks5BytestreamManager socks5BytestreamManager) {
        super("query", Bytestream.NAMESPACE, IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = socks5BytestreamManager;
    }

    /* access modifiers changed from: private */
    public void processRequest(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        Bytestream bytestream = (Bytestream) stanza;
        StreamNegotiator.signal(bytestream.getFrom().toString() + 9 + bytestream.getSessionID(), bytestream);
        if (!this.manager.getIgnoredBytestreamRequests().remove(bytestream.getSessionID())) {
            Socks5BytestreamRequest socks5BytestreamRequest = new Socks5BytestreamRequest(this.manager, bytestream);
            BytestreamListener userListener = this.manager.getUserListener(bytestream.getFrom());
            if (userListener != null) {
                userListener.incomingBytestreamRequest(socks5BytestreamRequest);
            } else if (!this.manager.getAllRequestListeners().isEmpty()) {
                for (BytestreamListener incomingBytestreamRequest : this.manager.getAllRequestListeners()) {
                    incomingBytestreamRequest.incomingBytestreamRequest(socks5BytestreamRequest);
                }
            } else {
                this.manager.replyRejectPacket(bytestream);
            }
        }
    }

    public IQ handleIQRequest(final IQ iq) {
        this.initiationListenerExecutor.execute(new Runnable() {
            public void run() {
                try {
                    InitiationListener.this.processRequest(iq);
                } catch (InterruptedException | SmackException.NotConnectedException e10) {
                    InitiationListener.LOGGER.log(Level.WARNING, "process request", e10);
                }
            }
        });
        return null;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        this.initiationListenerExecutor.shutdownNow();
    }
}
