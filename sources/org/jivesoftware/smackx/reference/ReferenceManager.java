package org.jivesoftware.smackx.reference;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

public final class ReferenceManager extends Manager {
    private static final Map<XMPPConnection, ReferenceManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:reference:0";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ReferenceManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private ReferenceManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE);
    }

    public static synchronized ReferenceManager getInstanceFor(XMPPConnection xMPPConnection) {
        ReferenceManager referenceManager;
        synchronized (ReferenceManager.class) {
            Map<XMPPConnection, ReferenceManager> map = INSTANCES;
            referenceManager = map.get(xMPPConnection);
            if (referenceManager == null) {
                referenceManager = new ReferenceManager(xMPPConnection);
                map.put(xMPPConnection, referenceManager);
            }
        }
        return referenceManager;
    }
}
