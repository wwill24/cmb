package org.jivesoftware.smack.sasl;

import java.text.Normalizer;
import javax.net.ssl.SSLSession;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;

public abstract class SASLMechanism implements Comparable<SASLMechanism> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CRAMMD5 = "CRAM-MD5";
    public static final String DIGESTMD5 = "DIGEST-MD5";
    public static final String EXTERNAL = "EXTERNAL";
    public static final String GSSAPI = "GSSAPI";
    public static final String PLAIN = "PLAIN";
    protected String authenticationId;
    private boolean authenticationSuccessful;
    protected EntityBareJid authorizationId;
    protected XMPPConnection connection;
    protected ConnectionConfiguration connectionConfiguration;
    private Exception exception;
    protected String host;
    protected String password;
    protected DomainBareJid serviceName;
    protected SSLSession sslSession;

    static {
        Class<SASLMechanism> cls = SASLMechanism.class;
    }

    protected static String saslPrep(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFKC);
    }

    protected static byte[] toBytes(String str) {
        return StringUtils.toUtf8Bytes(str);
    }

    public final void afterFinalSaslChallenge() throws SmackException.SmackSaslException {
        checkIfSuccessfulOrThrow();
        this.authenticationSuccessful = true;
    }

    public final void authenticate(String str, String str2, DomainBareJid domainBareJid, String str3, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.SmackSaslException, SmackException.NotConnectedException, InterruptedException {
        this.authenticationId = str;
        this.host = str2;
        this.serviceName = domainBareJid;
        this.password = str3;
        this.authorizationId = entityBareJid;
        this.sslSession = sSLSession;
        authenticateInternal();
        authenticate();
    }

    /* access modifiers changed from: protected */
    public void authenticateInternal() throws SmackException.SmackSaslException {
    }

    /* access modifiers changed from: protected */
    public abstract void authenticateInternal(CallbackHandler callbackHandler) throws SmackException.SmackSaslException;

    public boolean authzidSupported() {
        return false;
    }

    public final void challengeReceived(String str, boolean z10) throws SmackException.SmackSaslException, InterruptedException, SmackException.NotConnectedException {
        SaslNonza.Response response;
        if (str != null && str.equals("=")) {
            str = "";
        }
        byte[] evaluateChallenge = evaluateChallenge(Base64.decode(str));
        if (!z10) {
            if (evaluateChallenge == null) {
                response = new SaslNonza.Response();
            } else {
                response = new SaslNonza.Response(Base64.encodeToString(evaluateChallenge));
            }
            this.connection.sendNonza(response);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException;

    /* access modifiers changed from: protected */
    public byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] getAuthenticationText() throws SmackException.SmackSaslException;

    public abstract String getName();

    public abstract int getPriority();

    public SASLMechanism instanceForAuthentication(XMPPConnection xMPPConnection, ConnectionConfiguration connectionConfiguration2) {
        SASLMechanism newInstance = newInstance();
        newInstance.connection = xMPPConnection;
        newInstance.connectionConfiguration = connectionConfiguration2;
        return newInstance;
    }

    public boolean isAuthenticationSuccessful() {
        return this.authenticationSuccessful;
    }

    public boolean isFinished() {
        return isAuthenticationSuccessful() || this.exception != null;
    }

    /* access modifiers changed from: protected */
    public abstract SASLMechanism newInstance();

    public boolean requiresPassword() {
        return true;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public void throwExceptionIfRequired() throws SmackException.SmackSaslException, SASLErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        Exception exc = this.exception;
        if (exc != null) {
            if (exc instanceof SmackException.SmackSaslException) {
                throw ((SmackException.SmackSaslException) exc);
            } else if (exc instanceof SASLErrorException) {
                throw ((SASLErrorException) exc);
            } else if (exc instanceof SmackException.NotConnectedException) {
                throw ((SmackException.NotConnectedException) exc);
            } else if (exc instanceof InterruptedException) {
                throw ((InterruptedException) exc);
            } else {
                throw new IllegalStateException("Unexpected exception type", this.exception);
            }
        } else if (!this.authenticationSuccessful) {
            throw SmackException.NoResponseException.newWith(this.connection, "successful SASL authentication");
        }
    }

    public final String toString() {
        return "SASL Mech: " + getName() + ", Prio: " + getPriority();
    }

    public final int compareTo(SASLMechanism sASLMechanism) {
        return Integer.compare(Integer.valueOf(getPriority()).intValue(), sASLMechanism.getPriority());
    }

    public void authenticate(String str, DomainBareJid domainBareJid, CallbackHandler callbackHandler, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.SmackSaslException, SmackException.NotConnectedException, InterruptedException {
        this.host = str;
        this.serviceName = domainBareJid;
        this.authorizationId = entityBareJid;
        this.sslSession = sSLSession;
        authenticateInternal(callbackHandler);
        authenticate();
    }

    private void authenticate() throws SmackException.SmackSaslException, SmackException.NotConnectedException, InterruptedException {
        byte[] authenticationText = getAuthenticationText();
        this.connection.sendNonza(new SaslNonza.AuthMechanism(getName(), (authenticationText == null || authenticationText.length <= 0) ? "=" : Base64.encodeToString(authenticationText)));
    }
}
