package org.jivesoftware.smack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.core.ScramSha1PlusMechanism;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;

public final class SASLAuthentication {
    private static final Set<String> BLACKLISTED_MECHANISMS = new HashSet();
    private static final Logger LOGGER = Logger.getLogger(SASLAuthentication.class.getName());
    private static final List<SASLMechanism> REGISTERED_MECHANISMS = new ArrayList();
    private final ConnectionConfiguration configuration;
    private final AbstractXMPPConnection connection;
    private SASLMechanism currentMechanism = null;

    static {
        blacklistSASLMechanism(ScramSha1PlusMechanism.NAME);
    }

    SASLAuthentication(AbstractXMPPConnection abstractXMPPConnection, ConnectionConfiguration connectionConfiguration) {
        this.configuration = connectionConfiguration;
        this.connection = abstractXMPPConnection;
    }

    public static boolean blacklistSASLMechanism(String str) {
        boolean add;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            add = set.add(str);
        }
        return add;
    }

    public static Set<String> getBlacklistedSASLMechanisms() {
        return Collections.unmodifiableSet(BLACKLISTED_MECHANISMS);
    }

    public static Map<String, String> getRegisterdSASLMechanisms() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            for (SASLMechanism next : list) {
                linkedHashMap.put(next.getClass().getName(), next.toString());
            }
        }
        return linkedHashMap;
    }

    private List<String> getServerMechanisms() {
        Mechanisms mechanisms = (Mechanisms) this.connection.getFeature(Mechanisms.class);
        if (mechanisms == null) {
            return Collections.emptyList();
        }
        return mechanisms.getMechanisms();
    }

    public static boolean isSaslMechanismRegistered(String str) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            for (SASLMechanism name : list) {
                if (name.getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void registerSASLMechanism(SASLMechanism sASLMechanism) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            list.add(sASLMechanism);
            Collections.sort(list);
        }
    }

    private SASLMechanism selectMechanism(EntityBareJid entityBareJid, String str) throws SmackException.SmackSaslException {
        boolean isNotEmpty = StringUtils.isNotEmpty((CharSequence) str);
        List<String> serverMechanisms = getServerMechanisms();
        if (serverMechanisms.isEmpty()) {
            LOGGER.warning("Server did not report any SASL mechanisms");
        }
        ArrayList arrayList = new ArrayList();
        for (SASLMechanism next : REGISTERED_MECHANISMS) {
            String name = next.getName();
            if (serverMechanisms.contains(name)) {
                Set<String> set = BLACKLISTED_MECHANISMS;
                synchronized (set) {
                    if (!set.contains(name)) {
                        if (!this.configuration.isEnabledSaslMechanism(name)) {
                            continue;
                        } else if (entityBareJid != null && !next.authzidSupported()) {
                            arrayList.add("Skipping " + next + " because authzid is required by not supported by this SASL mechanism");
                        } else if (!next.requiresPassword() || isNotEmpty) {
                            return next.instanceForAuthentication(this.connection, this.configuration);
                        } else {
                            arrayList.add("Skipping " + next + " because a password is required for it, but none was provided to the connection configuration");
                        }
                    }
                }
            }
        }
        Set<String> set2 = BLACKLISTED_MECHANISMS;
        synchronized (set2) {
            throw new SmackException.SmackSaslException("No supported and enabled SASL Mechanism provided by server. Server announced mechanisms: " + serverMechanisms + ". Registered SASL mechanisms with Smack: " + REGISTERED_MECHANISMS + ". Enabled SASL mechanisms for this connection: " + this.configuration.getEnabledSaslMechanisms() + ". Blacklisted SASL mechanisms: " + set2 + ". Skip reasons: " + arrayList);
        }
    }

    public static boolean unBlacklistSASLMechanism(String str) {
        boolean remove;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            remove = set.remove(str);
        }
        return remove;
    }

    public static boolean unregisterSASLMechanism(String str) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            Iterator<SASLMechanism> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().getName().equals(str)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public SASLMechanism authenticate(String str, String str2, EntityBareJid entityBareJid, SSLSession sSLSession) throws XMPPException.XMPPErrorException, SASLErrorException, IOException, InterruptedException, SmackException.SmackSaslException, SmackException.NotConnectedException, SmackException.NoResponseException {
        SASLMechanism selectMechanism = selectMechanism(entityBareJid, str2);
        CallbackHandler callbackHandler = this.configuration.getCallbackHandler();
        String host = this.connection.getHost();
        DomainBareJid xMPPServiceDomain = this.connection.getXMPPServiceDomain();
        synchronized (this) {
            this.currentMechanism = selectMechanism;
            if (callbackHandler != null) {
                selectMechanism.authenticate(host, xMPPServiceDomain, callbackHandler, entityBareJid, sSLSession);
            } else {
                selectMechanism.authenticate(str, host, xMPPServiceDomain, str2, entityBareJid, sSLSession);
            }
            long currentTimeMillis = System.currentTimeMillis() + this.connection.getReplyTimeout();
            while (true) {
                if (selectMechanism.isFinished()) {
                    break;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                }
                wait(currentTimeMillis - currentTimeMillis2);
            }
        }
        selectMechanism.throwExceptionIfRequired();
        return selectMechanism;
    }

    /* access modifiers changed from: package-private */
    public void authenticated(SaslNonza.Success success) throws InterruptedException, SmackException.SmackSaslException, SmackException.NotConnectedException {
        if (success.getData() != null) {
            challengeReceived(success.getData(), true);
        }
        synchronized (this) {
            this.currentMechanism.afterFinalSaslChallenge();
            notify();
        }
    }

    /* access modifiers changed from: package-private */
    public void authenticationFailed(SaslNonza.SASLFailure sASLFailure) {
        SASLErrorException sASLErrorException;
        synchronized (this) {
            sASLErrorException = new SASLErrorException(this.currentMechanism.getName(), sASLFailure);
        }
        authenticationFailed((Exception) sASLErrorException);
    }

    public boolean authenticationSuccessful() {
        synchronized (this) {
            SASLMechanism sASLMechanism = this.currentMechanism;
            if (sASLMechanism == null) {
                return false;
            }
            boolean isAuthenticationSuccessful = sASLMechanism.isAuthenticationSuccessful();
            return isAuthenticationSuccessful;
        }
    }

    /* access modifiers changed from: package-private */
    public void challengeReceived(SaslNonza.Challenge challenge) throws SmackException, InterruptedException {
        challengeReceived(challenge.getData(), false);
    }

    /* access modifiers changed from: package-private */
    public String getNameOfLastUsedSaslMechansism() {
        SASLMechanism sASLMechanism = this.currentMechanism;
        if (sASLMechanism == null) {
            return null;
        }
        return sASLMechanism.getName();
    }

    private void challengeReceived(String str, boolean z10) throws SmackException.SmackSaslException, SmackException.NotConnectedException, InterruptedException {
        SASLMechanism sASLMechanism;
        synchronized (this) {
            sASLMechanism = this.currentMechanism;
        }
        sASLMechanism.challengeReceived(str, z10);
    }

    /* access modifiers changed from: package-private */
    public void authenticationFailed(Exception exc) {
        synchronized (this) {
            this.currentMechanism.setException(exc);
            notify();
        }
    }
}
