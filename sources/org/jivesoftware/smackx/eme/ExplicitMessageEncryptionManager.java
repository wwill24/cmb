package org.jivesoftware.smackx.eme;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

public final class ExplicitMessageEncryptionManager {
    private static final Map<XMPPConnection, ExplicitMessageEncryptionManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE_V0 = "urn:xmpp:eme:0";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ExplicitMessageEncryptionManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private ExplicitMessageEncryptionManager(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:eme:0");
    }

    public static synchronized ExplicitMessageEncryptionManager getInstanceFor(XMPPConnection xMPPConnection) {
        ExplicitMessageEncryptionManager explicitMessageEncryptionManager;
        synchronized (ExplicitMessageEncryptionManager.class) {
            Map<XMPPConnection, ExplicitMessageEncryptionManager> map = INSTANCES;
            explicitMessageEncryptionManager = map.get(xMPPConnection);
            if (explicitMessageEncryptionManager == null) {
                explicitMessageEncryptionManager = new ExplicitMessageEncryptionManager(xMPPConnection);
                map.put(xMPPConnection, explicitMessageEncryptionManager);
            }
        }
        return explicitMessageEncryptionManager;
    }
}
