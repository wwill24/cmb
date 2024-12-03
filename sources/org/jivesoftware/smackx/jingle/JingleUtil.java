package org.jivesoftware.smackx.jingle;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentDescription;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleError;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jxmpp.jid.FullJid;

public class JingleUtil {
    private final XMPPConnection connection;

    public JingleUtil(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
    }

    public IQ createAck(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    public IQ createErrorMalformedRequest(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, StanzaError.Condition.bad_request);
    }

    public IQ createErrorOutOfOrder(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.unexpected_request).addExtension(JingleError.OUT_OF_ORDER)).build());
    }

    public IQ createErrorTieBreak(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.conflict).addExtension(JingleError.TIE_BREAK)).build());
    }

    public IQ createErrorUnknownInitiator(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, StanzaError.Condition.service_unavailable);
    }

    public IQ createErrorUnknownSession(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.item_not_found).addExtension(JingleError.UNKNOWN_SESSION)).build());
    }

    public IQ createErrorUnsupportedInfo(Jingle jingle) {
        return IQ.createErrorResponse((IQ) jingle, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.feature_not_implemented).addExtension(JingleError.UNSUPPORTED_INFO)).build());
    }

    public Jingle createSessionAccept(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContent.Senders senders, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setResponder(this.connection.getUser()).setAction(JingleAction.session_accept).setSessionId(str);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setCreator(creator).setName(str2).setSenders(senders).setDescription(jingleContentDescription).setTransport(jingleContentTransport);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setTo(fullJid);
        build.setFrom(this.connection.getUser());
        return build;
    }

    public Jingle createSessionInitiate(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContent.Senders senders, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setAction(JingleAction.session_initiate).setSessionId(str).setInitiator(this.connection.getUser());
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setCreator(creator).setName(str2).setSenders(senders).setDescription(jingleContentDescription).setTransport(jingleContentTransport);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setFrom(this.connection.getUser());
        build.setTo(fullJid);
        return build;
    }

    public Jingle createSessionInitiateFileOffer(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) {
        return createSessionInitiate(fullJid, str, creator, str2, JingleContent.Senders.initiator, jingleContentDescription, jingleContentTransport);
    }

    public Jingle createSessionPing(FullJid fullJid, String str) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setSessionId(str).setAction(JingleAction.session_info);
        Jingle build = builder.build();
        build.setFrom(this.connection.getUser());
        build.setTo(fullJid);
        return build;
    }

    public Jingle createSessionTerminate(FullJid fullJid, String str, JingleReason jingleReason) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setAction(JingleAction.session_terminate).setSessionId(str).setReason(jingleReason);
        Jingle build = builder.build();
        build.setFrom(this.connection.getUser());
        build.setTo(fullJid);
        return build;
    }

    public Jingle createSessionTerminateAlternativeSession(FullJid fullJid, String str, String str2) {
        return createSessionTerminate(fullJid, str, (JingleReason) JingleReason.AlternativeSession(str2));
    }

    public Jingle createSessionTerminateBusy(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.busy);
    }

    public Jingle createSessionTerminateCancel(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.cancel);
    }

    public Jingle createSessionTerminateContentCancel(FullJid fullJid, String str, JingleContent.Creator creator, String str2) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setAction(JingleAction.session_terminate).setSessionId(str);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setCreator(creator).setName(str2);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setFrom(this.connection.getUser());
        build.setTo(fullJid);
        return build;
    }

    public Jingle createSessionTerminateDecline(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.decline);
    }

    public Jingle createSessionTerminateFailedApplication(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.failed_application);
    }

    public Jingle createSessionTerminateFailedTransport(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.failed_transport);
    }

    public Jingle createSessionTerminateIncompatibleParameters(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.incompatible_parameters);
    }

    public Jingle createSessionTerminateSuccess(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.success);
    }

    public Jingle createSessionTerminateUnsupportedApplications(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.unsupported_applications);
    }

    public Jingle createSessionTerminateUnsupportedTransports(FullJid fullJid, String str) {
        return createSessionTerminate(fullJid, str, JingleReason.Reason.unsupported_transports);
    }

    public Jingle createTransportAccept(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setAction(JingleAction.transport_accept).setInitiator(fullJid2).setSessionId(str);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setCreator(creator).setName(str2).setTransport(jingleContentTransport);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setTo(fullJid);
        build.setFrom(this.connection.getUser());
        return build;
    }

    public Jingle createTransportReject(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setAction(JingleAction.transport_reject).setInitiator(fullJid2).setSessionId(str);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setCreator(creator).setName(str2).setTransport(jingleContentTransport);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setTo(fullJid);
        build.setFrom(this.connection.getUser());
        return build;
    }

    public Jingle createTransportReplace(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) {
        Jingle.Builder builder = Jingle.builder(this.connection);
        builder.setInitiator(fullJid2).setSessionId(str).setAction(JingleAction.transport_replace);
        JingleContent.Builder builder2 = JingleContent.getBuilder();
        builder2.setName(str2).setCreator(creator).setTransport(jingleContentTransport);
        Jingle build = builder.addJingleContent(builder2.build()).build();
        build.setTo(fullJid);
        build.setFrom(this.connection.getUser());
        return build;
    }

    public void sendAck(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createAck(jingle));
    }

    public IQ sendContentRejectFileNotAvailable(FullJid fullJid, String str, JingleContentDescription jingleContentDescription) {
        return null;
    }

    public void sendErrorMalformedRequest(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorMalformedRequest(jingle));
    }

    public void sendErrorOutOfOrder(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorOutOfOrder(jingle));
    }

    public void sendErrorTieBreak(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorTieBreak(jingle));
    }

    public void sendErrorUnknownInitiator(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorUnknownInitiator(jingle));
    }

    public void sendErrorUnknownSession(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorUnknownSession(jingle));
    }

    public void sendErrorUnsupportedInfo(Jingle jingle) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(createErrorUnsupportedInfo(jingle));
    }

    public IQ sendSessionAccept(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContent.Senders senders, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionAccept(fullJid, str, creator, str2, senders, jingleContentDescription, jingleContentTransport)).nextResult();
    }

    public IQ sendSessionInitiate(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContent.Senders senders, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionInitiate(fullJid, str, creator, str2, senders, jingleContentDescription, jingleContentTransport)).nextResult();
    }

    public IQ sendSessionInitiateFileOffer(FullJid fullJid, String str, JingleContent.Creator creator, String str2, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionInitiateFileOffer(fullJid, str, creator, str2, jingleContentDescription, jingleContentTransport)).nextResultOrThrow();
    }

    public IQ sendSessionPing(FullJid fullJid, String str) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionPing(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateAlternativeSession(FullJid fullJid, String str, String str2) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateAlternativeSession(fullJid, str, str2)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateBusy(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateBusy(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateCancel(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateCancel(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateContentCancel(FullJid fullJid, String str, JingleContent.Creator creator, String str2) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateContentCancel(fullJid, str, creator, str2)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateDecline(FullJid fullJid, String str) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateDecline(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateFailedApplication(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateFailedApplication(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateFailedTransport(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateFailedTransport(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateIncompatibleParameters(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateIncompatibleParameters(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateSuccess(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateSuccess(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateUnsupportedApplications(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateUnsupportedApplications(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendSessionTerminateUnsupportedTransports(FullJid fullJid, String str) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createSessionTerminateUnsupportedTransports(fullJid, str)).nextResultOrThrow();
    }

    public IQ sendTransportAccept(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createTransportAccept(fullJid, fullJid2, str, creator, str2, jingleContentTransport)).nextResultOrThrow();
    }

    public IQ sendTransportReject(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createTransportReject(fullJid, fullJid2, str, creator, str2, jingleContentTransport)).nextResultOrThrow();
    }

    public IQ sendTransportReplace(FullJid fullJid, FullJid fullJid2, String str, JingleContent.Creator creator, String str2, JingleContentTransport jingleContentTransport) throws SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException {
        return (IQ) this.connection.createStanzaCollectorAndSend(createTransportReplace(fullJid, fullJid2, str, creator, str2, jingleContentTransport)).nextResultOrThrow();
    }

    public Jingle createSessionTerminate(FullJid fullJid, String str, JingleReason.Reason reason) {
        return createSessionTerminate(fullJid, str, new JingleReason(reason));
    }
}
