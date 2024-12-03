package org.jivesoftware.smackx.jingle.transports.jingle_s5b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamSession;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Client;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5ClientForInitiator;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Proxy;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Utils;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.JingleManager;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jivesoftware.smackx.jingle.transports.JingleTransportInitiationCallback;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo;

public class JingleS5BTransportSession extends JingleTransportSession<JingleS5BTransport> {
    private static final UsedCandidate CANDIDATE_FAILURE = new UsedCandidate((JingleS5BTransport) null, (JingleS5BTransportCandidate) null, (Socket) null);
    private static final Logger LOGGER = Logger.getLogger(JingleS5BTransportSession.class.getName());
    private JingleTransportInitiationCallback callback;
    private UsedCandidate ourChoice;
    private UsedCandidate theirChoice;

    private static final class UsedCandidate {
        /* access modifiers changed from: private */
        public final JingleS5BTransportCandidate candidate;
        /* access modifiers changed from: private */
        public final Socket socket;
        /* access modifiers changed from: private */
        public final JingleS5BTransport transport;

        private UsedCandidate(JingleS5BTransport jingleS5BTransport, JingleS5BTransportCandidate jingleS5BTransportCandidate, Socket socket2) {
            this.socket = socket2;
            this.transport = jingleS5BTransport;
            this.candidate = jingleS5BTransportCandidate;
        }
    }

    public JingleS5BTransportSession(JingleSession jingleSession) {
        super(jingleSession);
    }

    private UsedCandidate chooseFromProposedCandidates(JingleS5BTransport jingleS5BTransport) {
        Iterator<JingleContentTransportCandidate> it = jingleS5BTransport.getCandidates().iterator();
        while (it.hasNext()) {
            JingleS5BTransportCandidate jingleS5BTransportCandidate = (JingleS5BTransportCandidate) it.next();
            try {
                return connectToTheirCandidate(jingleS5BTransportCandidate);
            } catch (IOException | InterruptedException | TimeoutException | SmackException | XMPPException e10) {
                Logger logger = LOGGER;
                Level level = Level.WARNING;
                logger.log(level, "Could not connect to " + jingleS5BTransportCandidate.getHost(), e10);
            }
        }
        LOGGER.log(Level.WARNING, "Failed to connect to any candidate.");
        return null;
    }

    private void connectIfReady() {
        UsedCandidate usedCandidate;
        boolean z10 = false;
        JingleContent jingleContent = this.jingleSession.getContents().get(0);
        UsedCandidate usedCandidate2 = this.ourChoice;
        if (usedCandidate2 == null || (usedCandidate = this.theirChoice) == null) {
            LOGGER.log(Level.INFO, "Not ready.");
            return;
        }
        UsedCandidate usedCandidate3 = CANDIDATE_FAILURE;
        if (usedCandidate2 == usedCandidate3 && usedCandidate == usedCandidate3) {
            LOGGER.log(Level.INFO, "Failure.");
            this.jingleSession.onTransportMethodFailed(getNamespace());
            return;
        }
        Logger logger = LOGGER;
        logger.log(Level.INFO, "Ready.");
        UsedCandidate usedCandidate4 = this.ourChoice;
        if (usedCandidate4 == usedCandidate3 || this.theirChoice == usedCandidate3) {
            if (usedCandidate4 == usedCandidate3) {
                usedCandidate4 = this.theirChoice;
            }
        } else if (usedCandidate4.candidate.getPriority() > this.theirChoice.candidate.getPriority()) {
            usedCandidate4 = this.ourChoice;
        } else if (this.ourChoice.candidate.getPriority() < this.theirChoice.candidate.getPriority()) {
            usedCandidate4 = this.theirChoice;
        } else if (this.jingleSession.isInitiator()) {
            usedCandidate4 = this.ourChoice;
        } else {
            usedCandidate4 = this.theirChoice;
        }
        if (usedCandidate4 == this.theirChoice) {
            logger.log(Level.INFO, "Their choice, so our proposed candidate is used.");
            if (usedCandidate4.candidate.getType() == JingleS5BTransportCandidate.Type.proxy) {
                z10 = true;
            }
            try {
                UsedCandidate connectToOurCandidate = connectToOurCandidate(usedCandidate4.candidate);
                if (z10) {
                    logger.log(Level.INFO, "Is external proxy. Activate it.");
                    Bytestream bytestream = new Bytestream(((JingleS5BTransport) this.ourProposal).getStreamId());
                    bytestream.setMode((Bytestream.Mode) null);
                    bytestream.setType(IQ.Type.set);
                    bytestream.setTo(connectToOurCandidate.candidate.getJid());
                    bytestream.setToActivate(this.jingleSession.getRemote());
                    bytestream.setFrom(this.jingleSession.getLocal());
                    try {
                        this.jingleSession.getConnection().createStanzaCollectorAndSend(bytestream).nextResultOrThrow();
                        logger.log(Level.INFO, "Send candidate-activate.");
                        try {
                            this.jingleSession.getConnection().createStanzaCollectorAndSend(transportManager().createCandidateActivated(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), connectToOurCandidate.transport.getStreamId(), connectToOurCandidate.candidate.getCandidateId())).nextResultOrThrow();
                        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                            LOGGER.log(Level.WARNING, "Could not send candidate-activated", e10);
                            return;
                        }
                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e11) {
                        LOGGER.log(Level.WARNING, "Could not activate proxy.", e11);
                        return;
                    }
                }
                logger.log(Level.INFO, "Start transmission.");
                this.callback.onSessionInitiated(new Socks5BytestreamSession(connectToOurCandidate.socket, !z10));
            } catch (IOException | InterruptedException | TimeoutException | SmackException | XMPPException e12) {
                LOGGER.log(Level.INFO, "Could not connect to our candidate.", e12);
            }
        } else {
            logger.log(Level.INFO, "Our choice, so their candidate was used.");
            if (usedCandidate4.candidate.getType() == JingleS5BTransportCandidate.Type.proxy) {
                z10 = true;
            }
            if (!z10) {
                logger.log(Level.INFO, "Direct connection.");
                this.callback.onSessionInitiated(new Socks5BytestreamSession(usedCandidate4.socket, true));
                return;
            }
            logger.log(Level.INFO, "Our choice was their external proxy. wait for candidate-activate.");
        }
    }

    private UsedCandidate connectToOurCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) throws InterruptedException, TimeoutException, SmackException, XMPPException, IOException {
        Bytestream.StreamHost streamHost = jingleS5BTransportCandidate.getStreamHost();
        InetAddress asInetAddress = streamHost.getAddress().asInetAddress();
        Socket socket = new Socks5ClientForInitiator(streamHost, ((JingleS5BTransport) this.ourProposal).getDestinationAddress(), this.jingleSession.getConnection(), ((JingleS5BTransport) this.ourProposal).getStreamId(), this.jingleSession.getRemote()).getSocket(10000);
        Logger logger = LOGGER;
        Level level = Level.INFO;
        logger.log(level, "Connected to our StreamHost " + asInetAddress + " using dstAddr " + ((JingleS5BTransport) this.ourProposal).getDestinationAddress());
        return new UsedCandidate((JingleS5BTransport) this.ourProposal, jingleS5BTransportCandidate, socket);
    }

    private UsedCandidate connectToTheirCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) throws InterruptedException, TimeoutException, SmackException, XMPPException, IOException {
        Bytestream.StreamHost streamHost = jingleS5BTransportCandidate.getStreamHost();
        InetAddress asInetAddress = streamHost.getAddress().asInetAddress();
        Socket socket = new Socks5Client(streamHost, ((JingleS5BTransport) this.theirProposal).getDestinationAddress()).getSocket(10000);
        Logger logger = LOGGER;
        Level level = Level.INFO;
        logger.log(level, "Connected to their StreamHost " + asInetAddress + " using dstAddr " + ((JingleS5BTransport) this.theirProposal).getDestinationAddress());
        return new UsedCandidate((JingleS5BTransport) this.theirProposal, jingleS5BTransportCandidate, socket);
    }

    private void initiateSession() {
        Socks5Proxy.getSocks5Proxy().addTransfer(createTransport().getDestinationAddress());
        JingleContent jingleContent = this.jingleSession.getContents().get(0);
        UsedCandidate chooseFromProposedCandidates = chooseFromProposedCandidates((JingleS5BTransport) this.theirProposal);
        if (chooseFromProposedCandidates == null) {
            this.ourChoice = CANDIDATE_FAILURE;
            try {
                this.jingleSession.getConnection().sendStanza(transportManager().createCandidateError(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), ((JingleS5BTransport) this.theirProposal).getStreamId()));
            } catch (InterruptedException | SmackException.NotConnectedException e10) {
                LOGGER.log(Level.WARNING, "Could not send candidate-error.", e10);
            }
        } else {
            this.ourChoice = chooseFromProposedCandidates;
            try {
                this.jingleSession.getConnection().createStanzaCollectorAndSend(transportManager().createCandidateUsed(this.jingleSession.getRemote(), this.jingleSession.getInitiator(), this.jingleSession.getSessionId(), jingleContent.getSenders(), jingleContent.getCreator(), jingleContent.getName(), ((JingleS5BTransport) this.theirProposal).getStreamId(), this.ourChoice.candidate.getCandidateId())).nextResultOrThrow();
            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e11) {
                LOGGER.log(Level.WARNING, "Could not send candidate-used.", e11);
            }
        }
        connectIfReady();
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    public IQ handleCandidateActivate(Jingle jingle) {
        LOGGER.log(Level.INFO, "handleCandidateActivate");
        this.callback.onSessionInitiated(new Socks5BytestreamSession(this.ourChoice.socket, this.ourChoice.candidate.getJid().i1().Y(this.jingleSession.getRemote().i1())));
        return IQ.createResultIQ(jingle);
    }

    public IQ handleCandidateError(Jingle jingle) {
        this.theirChoice = CANDIDATE_FAILURE;
        connectIfReady();
        return IQ.createResultIQ(jingle);
    }

    public IQ handleCandidateUsed(Jingle jingle) {
        String candidateId = ((JingleS5BTransportInfo.CandidateUsed) ((JingleS5BTransportInfo) jingle.getContents().get(0).getTransport().getInfo())).getCandidateId();
        T t10 = this.ourProposal;
        UsedCandidate usedCandidate = new UsedCandidate((JingleS5BTransport) t10, ((JingleS5BTransport) t10).getCandidate(candidateId), (Socket) null);
        this.theirChoice = usedCandidate;
        JingleS5BTransportCandidate unused = usedCandidate.candidate;
        connectIfReady();
        return IQ.createResultIQ(jingle);
    }

    public IQ handleProxyError(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r0.equals(org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo.CandidateError.ELEMENT) == false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smack.packet.IQ handleTransportInfo(org.jivesoftware.smackx.jingle.element.Jingle r5) {
        /*
            r4 = this;
            java.util.List r0 = r5.getContents()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            org.jivesoftware.smackx.jingle.element.JingleContent r0 = (org.jivesoftware.smackx.jingle.element.JingleContent) r0
            org.jivesoftware.smackx.jingle.element.JingleContentTransport r0 = r0.getTransport()
            org.jivesoftware.smackx.jingle.element.JingleContentTransportInfo r0 = r0.getInfo()
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo r0 = (org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo) r0
            java.lang.String r0 = r0.getElementName()
            r0.hashCode()
            int r2 = r0.hashCode()
            r3 = -1
            switch(r2) {
                case -1033040578: goto L_0x0047;
                case 995927529: goto L_0x003c;
                case 1352626631: goto L_0x0031;
                case 2000321031: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            r1 = r3
            goto L_0x0050
        L_0x0026:
            java.lang.String r1 = "candidate-activated"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002f
            goto L_0x0024
        L_0x002f:
            r1 = 3
            goto L_0x0050
        L_0x0031:
            java.lang.String r1 = "candidate-used"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003a
            goto L_0x0024
        L_0x003a:
            r1 = 2
            goto L_0x0050
        L_0x003c:
            java.lang.String r1 = "proxy-error"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0045
            goto L_0x0024
        L_0x0045:
            r1 = 1
            goto L_0x0050
        L_0x0047:
            java.lang.String r2 = "candidate-error"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0050
            goto L_0x0024
        L_0x0050:
            switch(r1) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0062;
                case 2: goto L_0x005d;
                case 3: goto L_0x0058;
                default: goto L_0x0053;
            }
        L_0x0053:
            org.jivesoftware.smack.packet.IQ r5 = org.jivesoftware.smack.packet.IQ.createResultIQ(r5)
            return r5
        L_0x0058:
            org.jivesoftware.smack.packet.IQ r5 = r4.handleCandidateActivate(r5)
            return r5
        L_0x005d:
            org.jivesoftware.smack.packet.IQ r5 = r4.handleCandidateUsed(r5)
            return r5
        L_0x0062:
            org.jivesoftware.smack.packet.IQ r5 = r4.handleProxyError(r5)
            return r5
        L_0x0067:
            org.jivesoftware.smack.packet.IQ r5 = r4.handleCandidateError(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.transports.jingle_s5b.JingleS5BTransportSession.handleTransportInfo(org.jivesoftware.smackx.jingle.element.Jingle):org.jivesoftware.smack.packet.IQ");
    }

    public void initiateIncomingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        this.callback = jingleTransportInitiationCallback;
        initiateSession();
    }

    public void initiateOutgoingSession(JingleTransportInitiationCallback jingleTransportInitiationCallback) {
        this.callback = jingleTransportInitiationCallback;
        initiateSession();
    }

    public void setTheirProposal(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleS5BTransport) jingleContentTransport;
    }

    public void setTheirTransport(JingleContentTransport jingleContentTransport) {
        this.theirProposal = (JingleS5BTransport) jingleContentTransport;
    }

    public JingleS5BTransport createTransport() {
        if (this.ourProposal == null) {
            this.ourProposal = createTransport(JingleManager.randomId(), Bytestream.Mode.tcp);
        }
        return (JingleS5BTransport) this.ourProposal;
    }

    public JingleS5BTransportManager transportManager() {
        return JingleS5BTransportManager.getInstanceFor(this.jingleSession.getConnection());
    }

    public JingleS5BTransport createTransport(String str, Bytestream.Mode mode) {
        JingleS5BTransport.Builder destinationAddress = JingleS5BTransport.getBuilder().setStreamId(str).setMode(mode).setDestinationAddress(Socks5Utils.createDigest(str, this.jingleSession.getLocal(), this.jingleSession.getRemote()));
        if (JingleS5BTransportManager.isUseLocalCandidates()) {
            for (Bytestream.StreamHost jingleS5BTransportCandidate : transportManager().getLocalStreamHosts()) {
                destinationAddress.addTransportCandidate(new JingleS5BTransportCandidate(jingleS5BTransportCandidate, 100, JingleS5BTransportCandidate.Type.direct));
            }
        }
        List<Bytestream.StreamHost> emptyList = Collections.emptyList();
        if (JingleS5BTransportManager.isUseExternalCandidates()) {
            try {
                emptyList = transportManager().getAvailableStreamHosts();
            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                LOGGER.log(Level.WARNING, "Could not determine available StreamHosts.", e10);
            }
        }
        for (Bytestream.StreamHost jingleS5BTransportCandidate2 : emptyList) {
            destinationAddress.addTransportCandidate(new JingleS5BTransportCandidate(jingleS5BTransportCandidate2, 0, JingleS5BTransportCandidate.Type.proxy));
        }
        return destinationAddress.build();
    }
}
