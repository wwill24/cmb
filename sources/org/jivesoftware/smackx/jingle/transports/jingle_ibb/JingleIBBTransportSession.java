package org.jivesoftware.smackx.jingle.transports.jingle_ibb;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.transports.JingleTransportInitiationCallback;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;
import org.jxmpp.jid.Jid;

public class JingleIBBTransportSession extends JingleTransportSession<JingleIBBTransport> {
    private static final Logger LOGGER = Logger.getLogger(JingleIBBTransportSession.class.getName());
    private final JingleIBBTransportManager transportManager;

    public JingleIBBTransportSession(JingleSession jingleSession) {
        super(jingleSession);
        this.transportManager = JingleIBBTransportManager.getInstanceFor(jingleSession.getConnection());
    }

    public String getNamespace() {
        return this.transportManager.getNamespace();
    }

    public IQ handleTransportInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    public void initiateIncomingSession(final JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        LOGGER.log(Level.INFO, "Await Jingle InBandBytestream session.");
        InBandBytestreamManager.getByteStreamManager(this.jingleSession.getConnection()).addIncomingBytestreamListener(new BytestreamListener() {
            public void incomingBytestreamRequest(BytestreamRequest bytestreamRequest) {
                if (bytestreamRequest.getFrom().O().Y(JingleIBBTransportSession.this.jingleSession.getRemote()) && bytestreamRequest.getSessionID().equals(((JingleIBBTransport) JingleIBBTransportSession.this.theirProposal).getSessionId())) {
                    try {
                        jingleTransportInitiationCallback.onSessionInitiated(bytestreamRequest.accept());
                    } catch (InterruptedException | SmackException | XMPPException.XMPPErrorException e10) {
                        jingleTransportInitiationCallback.onException(e10);
                    }
                }
            }
        });
    }

    public void initiateOutgoingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        LOGGER.log(Level.INFO, "Initiate Jingle InBandBytestream session.");
        try {
            jingleTransportInitiationCallback.onSessionInitiated(InBandBytestreamManager.getByteStreamManager(this.jingleSession.getConnection()).establishSession((Jid) this.jingleSession.getRemote(), ((JingleIBBTransport) this.theirProposal).getSessionId()));
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
            jingleTransportInitiationCallback.onException(e10);
        }
    }

    public void setTheirProposal(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleIBBTransport) jingleContentTransport;
    }

    public JingleTransportManager<JingleIBBTransport> transportManager() {
        return JingleIBBTransportManager.getInstanceFor(this.jingleSession.getConnection());
    }

    public JingleIBBTransport createTransport() {
        T t10 = this.theirProposal;
        if (t10 == null) {
            return new JingleIBBTransport();
        }
        return new JingleIBBTransport(((JingleIBBTransport) t10).getBlockSize(), ((JingleIBBTransport) this.theirProposal).getSessionId());
    }
}
