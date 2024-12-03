package org.jivesoftware.smack;

import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;
import org.jxmpp.jid.Jid;

public abstract class SmackException extends Exception {
    private static final long serialVersionUID = 1844674365368214458L;

    public static class AlreadyConnectedException extends SmackException {
        private static final long serialVersionUID = 5011416918049135231L;

        public AlreadyConnectedException() {
            super("Client is already connected");
        }
    }

    public static class AlreadyLoggedInException extends SmackException {
        private static final long serialVersionUID = 5011416918049935231L;

        public AlreadyLoggedInException() {
            super("Client is already logged in");
        }
    }

    public static abstract class ConnectionException extends SmackException {
        private static final long serialVersionUID = 1;

        protected ConnectionException(Throwable th2) {
            super(th2);
        }

        protected ConnectionException(String str) {
            super(str);
        }
    }

    public static final class EndpointConnectionException extends ConnectionException {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        private final List<? extends RemoteConnectionException<?>> connectionExceptions;
        private final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

        static {
            Class<SmackException> cls = SmackException.class;
        }

        private EndpointConnectionException(String str, List<RemoteConnectionEndpointLookupFailure> list, List<? extends RemoteConnectionException<?>> list2) {
            super(str);
            this.lookupFailures = list;
            this.connectionExceptions = list2;
        }

        public static EndpointConnectionException from(List<RemoteConnectionEndpointLookupFailure> list, List<? extends RemoteConnectionException<?>> list2) {
            StringBuilder sb2 = new StringBuilder(256);
            if (!list.isEmpty()) {
                sb2.append("Could not lookup the following endpoints: ");
                StringUtils.appendTo(list, sb2);
            }
            if (!list2.isEmpty()) {
                sb2.append("The following addresses failed: ");
                StringUtils.appendTo(list2, sb2, new m(sb2));
            }
            return new EndpointConnectionException(sb2.toString(), list, list2);
        }

        public List<? extends RemoteConnectionException<? extends RemoteConnectionEndpoint>> getConnectionExceptions() {
            return this.connectionExceptions;
        }

        public List<RemoteConnectionEndpointLookupFailure> getLookupFailures() {
            return this.lookupFailures;
        }
    }

    public static class FeatureNotSupportedException extends SmackException {
        private static final long serialVersionUID = 4713404802621452016L;
        private final String feature;
        private final Jid jid;

        public FeatureNotSupportedException(String str) {
            this(str, (Jid) null);
        }

        public String getFeature() {
            return this.feature;
        }

        public Jid getJid() {
            return this.jid;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FeatureNotSupportedException(java.lang.String r4, org.jxmpp.jid.Jid r5) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r4)
                java.lang.String r1 = " not supported"
                r0.append(r1)
                if (r5 != 0) goto L_0x0012
                java.lang.String r1 = ""
                goto L_0x0028
            L_0x0012:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = " by '"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = "'"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
            L_0x0028:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r3.<init>((java.lang.String) r0)
                r3.jid = r5
                r3.feature = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackException.FeatureNotSupportedException.<init>(java.lang.String, org.jxmpp.jid.Jid):void");
        }
    }

    public static final class GenericConnectionException extends ConnectionException {
        private static final long serialVersionUID = 1;

        @Deprecated
        public GenericConnectionException(Throwable th2) {
            super(th2);
        }
    }

    public static class IllegalStateChangeException extends SmackException {
        private static final long serialVersionUID = -1766023961577168927L;
    }

    public static final class NoEndpointsDiscoveredException extends ConnectionException {
        private static final long serialVersionUID = 1;
        private final List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> lookupFailures;

        private NoEndpointsDiscoveredException(String str, List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> list) {
            super(str);
            this.lookupFailures = Collections.unmodifiableList(list);
        }

        public static NoEndpointsDiscoveredException from(List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> list) {
            StringBuilder sb2 = new StringBuilder();
            if (list.isEmpty()) {
                sb2.append("No endpoint lookup finished within the timeout");
            } else {
                sb2.append("No endpoints could be discovered due the following lookup failures: ");
                StringUtils.appendTo(list, sb2);
            }
            return new NoEndpointsDiscoveredException(sb2.toString(), list);
        }

        public List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> getLookupFailures() {
            return this.lookupFailures;
        }
    }

    public static final class NoResponseException extends SmackException {
        private static final long serialVersionUID = -6523363748984543636L;
        private final StanzaFilter filter;

        private NoResponseException(String str) {
            this(str, (StanzaFilter) null);
        }

        private static StringBuilder getWaitingFor(XMPPConnection xMPPConnection) {
            return getWaitingFor(xMPPConnection.getReplyTimeout());
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, String str) {
            StringBuilder waitingFor = getWaitingFor(xMPPConnection);
            waitingFor.append(" While waiting for ");
            waitingFor.append(str);
            waitingFor.append(" [");
            waitingFor.append(xMPPConnection);
            waitingFor.append(PropertyUtils.INDEXED_DELIM2);
            return new NoResponseException(waitingFor.toString());
        }

        public StanzaFilter getFilter() {
            return this.filter;
        }

        private NoResponseException(String str, StanzaFilter stanzaFilter) {
            super(str);
            this.filter = stanzaFilter;
        }

        private static StringBuilder getWaitingFor(long j10) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("No response received within reply timeout. Timeout was " + j10 + "ms (~" + (j10 / 1000) + "s).");
            return sb2;
        }

        public static NoResponseException newWith(long j10, StanzaCollector stanzaCollector, boolean z10) {
            return newWith(j10, stanzaCollector.getStanzaFilter(), z10);
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter) {
            return newWith(xMPPConnection.getReplyTimeout(), stanzaFilter, false);
        }

        public static NoResponseException newWith(long j10, StanzaFilter stanzaFilter, boolean z10) {
            StringBuilder waitingFor = getWaitingFor(j10);
            if (z10) {
                waitingFor.append(" StanzaCollector has been cancelled.");
            }
            waitingFor.append(" Waited for response using: ");
            if (stanzaFilter != null) {
                waitingFor.append(stanzaFilter.toString());
            } else {
                waitingFor.append("No filter used or filter was 'null'");
            }
            waitingFor.append('.');
            return new NoResponseException(waitingFor.toString(), stanzaFilter);
        }
    }

    public static class NotConnectedException extends SmackException {
        private static final long serialVersionUID = 9197980400776001173L;

        public NotConnectedException() {
            this((String) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public NotConnectedException(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Client is not, or no longer, connected."
                r0.append(r1)
                if (r4 == 0) goto L_0x001e
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r2 = 32
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                goto L_0x0020
            L_0x001e:
                java.lang.String r4 = ""
            L_0x0020:
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r3.<init>((java.lang.String) r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackException.NotConnectedException.<init>(java.lang.String):void");
        }

        public NotConnectedException(XMPPConnection xMPPConnection, String str) {
            super("The connection " + xMPPConnection.toString() + " is no longer connected. " + str);
        }

        public NotConnectedException(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter) {
            super("The connection " + xMPPConnection + " is no longer connected while waiting for response with " + stanzaFilter);
        }

        public NotConnectedException(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter, Exception exc) {
            super("The connection " + xMPPConnection + " is no longer connected while waiting for response with " + stanzaFilter + " because of " + exc, exc);
        }
    }

    public static class NotLoggedInException extends SmackException {
        private static final long serialVersionUID = 3216216839100019278L;

        public NotLoggedInException() {
            super("Client is not logged in");
        }
    }

    public static class ResourceBindingNotOfferedException extends SmackException {
        private static final long serialVersionUID = 2346934138253437571L;

        public ResourceBindingNotOfferedException() {
            super("Resource binding was not offered by server");
        }
    }

    public static class SecurityNotPossibleException extends SmackException {
        private static final long serialVersionUID = -6836090872690331336L;

        public SecurityNotPossibleException(String str) {
            super(str);
        }
    }

    public static class SecurityRequiredByClientException extends SecurityRequiredException {
        private static final long serialVersionUID = 2395325821201543159L;

        public SecurityRequiredByClientException() {
            super("SSL/TLS required by client but not supported by server");
        }
    }

    public static class SecurityRequiredByServerException extends SecurityRequiredException {
        private static final long serialVersionUID = 8268148813117631819L;

        public SecurityRequiredByServerException() {
            super("SSL/TLS required by server but disabled in client");
        }
    }

    public static abstract class SecurityRequiredException extends SmackException {
        private static final long serialVersionUID = 384291845029773545L;

        public SecurityRequiredException(String str) {
            super(str);
        }
    }

    public static class SmackCertificateException extends SmackException {
        private static final long serialVersionUID = 1;
        private final CertificateException certificateException;

        public SmackCertificateException(CertificateException certificateException2) {
            this.certificateException = certificateException2;
        }

        public CertificateException getCertificateException() {
            return this.certificateException;
        }
    }

    public static class SmackMessageException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackMessageException(String str) {
            super(str);
        }
    }

    public static class SmackSaslException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackSaslException(Exception exc) {
            super((Throwable) exc);
        }

        public SmackSaslException(String str) {
            super(str);
        }

        public SmackSaslException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static class SmackWrappedException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackWrappedException(Exception exc) {
            super((Throwable) exc);
        }

        public SmackWrappedException(String str, Exception exc) {
            super(str, exc);
        }
    }

    protected SmackException(Throwable th2) {
        super(th2);
    }

    protected SmackException(String str) {
        super(str);
    }

    protected SmackException(String str, Throwable th2) {
        super(str, th2);
    }

    protected SmackException() {
    }
}
