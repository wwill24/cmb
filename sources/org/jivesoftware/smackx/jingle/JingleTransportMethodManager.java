package org.jivesoftware.smackx.jingle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

public final class JingleTransportMethodManager extends Manager {
    private static final WeakHashMap<XMPPConnection, JingleTransportMethodManager> INSTANCES = new WeakHashMap<>();
    private static final String[] transportPreference = {"urn:xmpp:jingle:transports:s5b:1", JingleIBBTransport.NAMESPACE_V1};
    private final HashMap<String, JingleTransportManager<?>> transportManagers = new HashMap<>();

    private JingleTransportMethodManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static JingleTransportManager<?> getBestAvailableTransportManager(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection).getBestAvailableTransportManager();
    }

    public static synchronized JingleTransportMethodManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleTransportMethodManager jingleTransportMethodManager;
        synchronized (JingleTransportMethodManager.class) {
            WeakHashMap<XMPPConnection, JingleTransportMethodManager> weakHashMap = INSTANCES;
            jingleTransportMethodManager = weakHashMap.get(xMPPConnection);
            if (jingleTransportMethodManager == null) {
                jingleTransportMethodManager = new JingleTransportMethodManager(xMPPConnection);
                weakHashMap.put(xMPPConnection, jingleTransportMethodManager);
            }
        }
        return jingleTransportMethodManager;
    }

    public static JingleTransportManager<?> getTransportManager(XMPPConnection xMPPConnection, String str) {
        return getInstanceFor(xMPPConnection).getTransportManager(str);
    }

    public void registerTransportManager(JingleTransportManager<?> jingleTransportManager) {
        this.transportManagers.put(jingleTransportManager.getNamespace(), jingleTransportManager);
    }

    public JingleTransportManager<?> getBestAvailableTransportManager() {
        for (String transportManager : transportPreference) {
            JingleTransportManager<?> transportManager2 = getTransportManager(transportManager);
            if (transportManager2 != null) {
                return transportManager2;
            }
        }
        Iterator<String> it = this.transportManagers.keySet().iterator();
        if (it.hasNext()) {
            return getTransportManager(it.next());
        }
        return null;
    }

    public JingleTransportManager<?> getTransportManager(String str) {
        return this.transportManagers.get(str);
    }

    public static JingleTransportManager<?> getTransportManager(XMPPConnection xMPPConnection, Jingle jingle) {
        return getInstanceFor(xMPPConnection).getTransportManager(jingle);
    }

    public JingleTransportManager<?> getTransportManager(Jingle jingle) {
        JingleContentTransport transport;
        JingleContent jingleContent = jingle.getContents().get(0);
        if (jingleContent == null || (transport = jingleContent.getTransport()) == null) {
            return null;
        }
        return getTransportManager(transport.getNamespace());
    }

    public JingleTransportManager<?> getBestAvailableTransportManager(Set<String> set) {
        for (String transportManager : transportPreference) {
            JingleTransportManager<?> transportManager2 = getTransportManager(transportManager);
            if (transportManager2 != null && !set.contains(transportManager2.getNamespace())) {
                return transportManager2;
            }
        }
        for (String next : this.transportManagers.keySet()) {
            if (!set.contains(next)) {
                return getTransportManager(next);
            }
        }
        return null;
    }
}
