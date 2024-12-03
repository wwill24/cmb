package org.jivesoftware.smackx.iqversion;

import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.Smack;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqversion.packet.Version;
import org.jxmpp.jid.Jid;

public final class VersionManager extends Manager {
    private static final Map<XMPPConnection, VersionManager> INSTANCES = new WeakHashMap();
    private static boolean autoAppendSmackVersion = true;
    private static Version defaultVersion;
    /* access modifiers changed from: private */
    public Version ourVersion = defaultVersion;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                VersionManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private VersionManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(Version.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", Version.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                if (VersionManager.this.ourVersion == null) {
                    return IQ.createErrorResponse(iq, StanzaError.Condition.not_acceptable);
                }
                return Version.createResultFor(iq, VersionManager.this.ourVersion);
            }
        });
    }

    private static Version generateVersionFrom(String str, String str2, String str3) {
        if (autoAppendSmackVersion) {
            str = str + " (Smack " + Smack.getVersion() + PropertyUtils.MAPPED_DELIM2;
        }
        return new Version(str, str2, str3);
    }

    public static synchronized VersionManager getInstanceFor(XMPPConnection xMPPConnection) {
        VersionManager versionManager;
        synchronized (VersionManager.class) {
            Map<XMPPConnection, VersionManager> map = INSTANCES;
            versionManager = map.get(xMPPConnection);
            if (versionManager == null) {
                versionManager = new VersionManager(xMPPConnection);
                map.put(xMPPConnection, versionManager);
            }
        }
        return versionManager;
    }

    public static void setAutoAppendSmackVersion(boolean z10) {
        autoAppendSmackVersion = z10;
    }

    public static void setDefaultVersion(String str, String str2) {
        setDefaultVersion(str, str2, (String) null);
    }

    public Version getVersion(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (!isSupported(jid)) {
            return null;
        }
        return (Version) connection().createStanzaCollectorAndSend(new Version(jid)).nextResultOrThrow();
    }

    public boolean isSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Version.NAMESPACE);
    }

    public void setVersion(String str, String str2) {
        setVersion(str, str2, (String) null);
    }

    public void unsetVersion() {
        this.ourVersion = null;
    }

    public static void setDefaultVersion(String str, String str2, String str3) {
        defaultVersion = generateVersionFrom(str, str2, str3);
    }

    public void setVersion(String str, String str2, String str3) {
        this.ourVersion = generateVersionFrom(str, str2, str3);
    }
}
