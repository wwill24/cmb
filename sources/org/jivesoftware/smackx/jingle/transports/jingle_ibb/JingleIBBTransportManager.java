package org.jivesoftware.smackx.jingle.transports.jingle_ibb;

import java.util.WeakHashMap;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.provider.JingleContentProviderManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.provider.JingleIBBTransportProvider;

public final class JingleIBBTransportManager extends JingleTransportManager<JingleIBBTransport> {
    private static final WeakHashMap<XMPPConnection, JingleIBBTransportManager> INSTANCES = new WeakHashMap<>();

    private JingleIBBTransportManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        JingleContentProviderManager.addJingleContentTransportProvider(getNamespace(), new JingleIBBTransportProvider());
    }

    public static synchronized JingleIBBTransportManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleIBBTransportManager jingleIBBTransportManager;
        synchronized (JingleIBBTransportManager.class) {
            WeakHashMap<XMPPConnection, JingleIBBTransportManager> weakHashMap = INSTANCES;
            jingleIBBTransportManager = weakHashMap.get(xMPPConnection);
            if (jingleIBBTransportManager == null) {
                jingleIBBTransportManager = new JingleIBBTransportManager(xMPPConnection);
                weakHashMap.put(xMPPConnection, jingleIBBTransportManager);
            }
        }
        return jingleIBBTransportManager;
    }

    public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
    }

    public String getNamespace() {
        return JingleIBBTransport.NAMESPACE_V1;
    }

    public JingleTransportSession<JingleIBBTransport> transportSession(JingleSession jingleSession) {
        return new JingleIBBTransportSession(jingleSession);
    }
}
