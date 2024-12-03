package org.jivesoftware.smackx.jid_prep;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.jid_prep.element.JidPrepIq;
import org.jxmpp.jid.Jid;

public class JidPrepManager extends Manager {
    private static final Map<XMPPConnection, JidPrepManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:jidprep:0";
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    public JidPrepManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized JidPrepManager getInstanceFor(XMPPConnection xMPPConnection) {
        JidPrepManager jidPrepManager;
        synchronized (JidPrepManager.class) {
            Map<XMPPConnection, JidPrepManager> map = INSTANCES;
            jidPrepManager = map.get(xMPPConnection);
            if (jidPrepManager == null) {
                jidPrepManager = new JidPrepManager(xMPPConnection);
                map.put(xMPPConnection, jidPrepManager);
            }
        }
        return jidPrepManager;
    }

    public boolean isSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "urn:xmpp:jidprep:0");
    }

    public String requestJidPrep(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return requestJidPrep(this.serviceDiscoveryManager.findService("urn:xmpp:jidprep:0", true), str);
    }

    public String requestJidPrep(Jid jid, String str) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException {
        JidPrepIq jidPrepIq = new JidPrepIq(str);
        jidPrepIq.setTo(jid);
        try {
            return ((JidPrepIq) connection().sendIqRequestAndWaitForResponse(jidPrepIq)).getJid();
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.jid_malformed) {
                return null;
            }
            throw e10;
        }
    }
}
