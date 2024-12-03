package org.jivesoftware.smackx.jingle;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.JingleIBBTransportManager;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.JingleS5BTransportManager;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.FullJid;

public final class JingleManager extends Manager {
    private static final Map<XMPPConnection, JingleManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(JingleManager.class.getName());
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    /* access modifiers changed from: private */
    public final Map<String, JingleHandler> descriptionHandlers = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Map<FullJidAndSessionId, JingleSessionHandler> jingleSessionHandlers = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final JingleUtil jutil;

    private JingleManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.jutil = new JingleUtil(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(Jingle.ELEMENT, "urn:xmpp:jingle:1", IQ.Type.set, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                Jingle jingle = (Jingle) iq;
                EntityFullJid A1 = jingle.getFrom().A1();
                String sid = jingle.getSid();
                JingleSessionHandler jingleSessionHandler = (JingleSessionHandler) JingleManager.this.jingleSessionHandlers.get(new FullJidAndSessionId(A1, sid));
                if (jingleSessionHandler != null) {
                    return jingleSessionHandler.handleJingleSessionRequest(jingle);
                }
                if (jingle.getAction() == JingleAction.session_initiate) {
                    JingleHandler jingleHandler = (JingleHandler) JingleManager.this.descriptionHandlers.get(jingle.getContents().get(0).getDescription().getNamespace());
                    if (jingleHandler != null) {
                        return jingleHandler.handleJingleRequest(jingle);
                    }
                    JingleManager.LOGGER.log(Level.WARNING, "Unsupported Jingle application.");
                    return JingleManager.this.jutil.createSessionTerminateUnsupportedApplications(A1, sid);
                }
                JingleManager.LOGGER.log(Level.WARNING, "Unknown session.");
                return JingleManager.this.jutil.createErrorUnknownSession(jingle);
            }
        });
        JingleTransportMethodManager instanceFor = JingleTransportMethodManager.getInstanceFor(xMPPConnection);
        instanceFor.registerTransportManager(JingleIBBTransportManager.getInstanceFor(xMPPConnection));
        instanceFor.registerTransportManager(JingleS5BTransportManager.getInstanceFor(xMPPConnection));
    }

    public static synchronized JingleManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleManager jingleManager;
        synchronized (JingleManager.class) {
            Map<XMPPConnection, JingleManager> map = INSTANCES;
            jingleManager = map.get(xMPPConnection);
            if (jingleManager == null) {
                jingleManager = new JingleManager(xMPPConnection);
                map.put(xMPPConnection, jingleManager);
            }
        }
        return jingleManager;
    }

    public static ExecutorService getThreadPool() {
        return threadPool;
    }

    public static String randomId() {
        return StringUtils.randomString(24);
    }

    public JingleHandler registerDescriptionHandler(String str, JingleHandler jingleHandler) {
        return this.descriptionHandlers.put(str, jingleHandler);
    }

    public JingleSessionHandler registerJingleSessionHandler(FullJid fullJid, String str, JingleSessionHandler jingleSessionHandler) {
        return this.jingleSessionHandlers.put(new FullJidAndSessionId(fullJid, str), jingleSessionHandler);
    }

    public JingleSessionHandler unregisterJingleSessionHandler(FullJid fullJid, String str, JingleSessionHandler jingleSessionHandler) {
        return this.jingleSessionHandlers.remove(new FullJidAndSessionId(fullJid, str));
    }
}
