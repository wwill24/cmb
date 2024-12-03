package org.jivesoftware.smackx.message_fastening;

import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

public final class MessageFasteningManager extends Manager {
    /* access modifiers changed from: private */
    public static boolean ENABLED_BY_DEFAULT = false;
    private static final WeakHashMap<XMPPConnection, MessageFasteningManager> INSTANCES = new WeakHashMap<>();
    public static final String NAMESPACE = "urn:xmpp:fasten:0";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (MessageFasteningManager.ENABLED_BY_DEFAULT) {
                    MessageFasteningManager.getInstanceFor(xMPPConnection).announceSupport();
                }
            }
        });
    }

    private MessageFasteningManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static synchronized MessageFasteningManager getInstanceFor(XMPPConnection xMPPConnection) {
        MessageFasteningManager messageFasteningManager;
        synchronized (MessageFasteningManager.class) {
            WeakHashMap<XMPPConnection, MessageFasteningManager> weakHashMap = INSTANCES;
            messageFasteningManager = weakHashMap.get(xMPPConnection);
            if (messageFasteningManager == null) {
                messageFasteningManager = new MessageFasteningManager(xMPPConnection);
                weakHashMap.put(xMPPConnection, messageFasteningManager);
            }
        }
        return messageFasteningManager;
    }

    public static synchronized void setEnabledByDefault(boolean z10) {
        synchronized (MessageFasteningManager.class) {
            ENABLED_BY_DEFAULT = z10;
        }
    }

    public void announceSupport() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature("urn:xmpp:fasten:0");
    }

    public void stopAnnouncingSupport() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature("urn:xmpp:fasten:0");
    }
}
