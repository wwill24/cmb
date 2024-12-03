package org.jivesoftware.smackx.iqregister;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jxmpp.jid.parts.Localpart;

public final class AccountManager extends Manager {
    private static final Map<XMPPConnection, AccountManager> INSTANCES = new WeakHashMap();
    private static boolean allowSensitiveOperationOverInsecureConnectionDefault = false;
    private boolean accountCreationSupported = false;
    private boolean allowSensitiveOperationOverInsecureConnection = allowSensitiveOperationOverInsecureConnectionDefault;
    private Registration info = null;

    private AccountManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    private StanzaCollector createStanzaCollectorAndSend(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        return connection().createStanzaCollectorAndSend(new StanzaIdFilter(iq.getStanzaId()), iq);
    }

    public static synchronized AccountManager getInstance(XMPPConnection xMPPConnection) {
        AccountManager accountManager;
        synchronized (AccountManager.class) {
            Map<XMPPConnection, AccountManager> map = INSTANCES;
            accountManager = map.get(xMPPConnection);
            if (accountManager == null) {
                accountManager = new AccountManager(xMPPConnection);
                map.put(xMPPConnection, accountManager);
            }
        }
        return accountManager;
    }

    private synchronized void getRegistrationInfo() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Registration registration = new Registration();
        registration.setTo(connection().getXMPPServiceDomain());
        this.info = (Registration) createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public static void sensitiveOperationOverInsecureConnectionDefault(boolean z10) {
        allowSensitiveOperationOverInsecureConnectionDefault = z10;
    }

    public void changePassword(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (connection().isSecureConnection() || this.allowSensitiveOperationOverInsecureConnection) {
            HashMap hashMap = new HashMap();
            hashMap.put("username", connection().getUser().c1().toString());
            hashMap.put("password", str);
            Registration registration = new Registration(hashMap);
            registration.setType(IQ.Type.set);
            registration.setTo(connection().getXMPPServiceDomain());
            createStanzaCollectorAndSend(registration).nextResultOrThrow();
            return;
        }
        throw new IllegalStateException("Changing password over insecure connection.");
    }

    public void createAccount(Localpart localpart, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        for (String put : getAccountAttributes()) {
            hashMap.put(put, "");
        }
        createAccount(localpart, str, hashMap);
    }

    public void deleteAccount() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        hashMap.put("remove", "");
        Registration registration = new Registration(hashMap);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getXMPPServiceDomain());
        createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public String getAccountAttribute(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        return this.info.getAttributes().get(str);
    }

    public Set<String> getAccountAttributes() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        Map<String, String> attributes = this.info.getAttributes();
        if (attributes != null) {
            return Collections.unmodifiableSet(attributes.keySet());
        }
        return Collections.emptySet();
    }

    public String getAccountInstructions() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        return this.info.getInstructions();
    }

    public boolean isSupported() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        if (((ExtensionElement) connection.getFeature(Registration.Feature.class)) != null) {
            return true;
        }
        if (connection.isAuthenticated()) {
            return ServiceDiscoveryManager.getInstanceFor(connection).serverSupportsFeature(Registration.NAMESPACE);
        }
        return false;
    }

    public void sensitiveOperationOverInsecureConnection(boolean z10) {
        this.allowSensitiveOperationOverInsecureConnection = z10;
    }

    /* access modifiers changed from: package-private */
    public void setSupportsAccountCreation(boolean z10) {
        this.accountCreationSupported = z10;
    }

    public boolean supportsAccountCreation() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        boolean z10 = true;
        if (this.accountCreationSupported) {
            return true;
        }
        if (this.info == null) {
            getRegistrationInfo();
            if (this.info.getType() == IQ.Type.error) {
                z10 = false;
            }
            this.accountCreationSupported = z10;
        }
        return this.accountCreationSupported;
    }

    public void createAccount(Localpart localpart, String str, Map<String, String> map) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (!connection().isSecureConnection() && !this.allowSensitiveOperationOverInsecureConnection) {
            throw new IllegalStateException("Creating account over insecure connection");
        } else if (localpart == null) {
            throw new IllegalArgumentException("Username must not be null");
        } else if (!StringUtils.isNullOrEmpty((CharSequence) str)) {
            map.put("username", localpart.toString());
            map.put("password", str);
            Registration registration = new Registration(map);
            registration.setType(IQ.Type.set);
            registration.setTo(connection().getXMPPServiceDomain());
            createStanzaCollectorAndSend(registration).nextResultOrThrow();
        } else {
            throw new IllegalArgumentException("Password must not be null");
        }
    }
}
