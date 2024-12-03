package org.jivesoftware.smackx.push_notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.push_notifications.element.DisablePushNotificationsIQ;
import org.jivesoftware.smackx.push_notifications.element.EnablePushNotificationsIQ;
import org.jxmpp.jid.Jid;

public final class PushNotificationsManager extends Manager {
    private static final Map<XMPPConnection, PushNotificationsManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PushNotificationsManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private PushNotificationsManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    private boolean changePushNotificationsStatus(IQ iq) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (((IQ) connection().createStanzaCollectorAndSend(iq).nextResultOrThrow()).getType() != IQ.Type.error) {
            return true;
        }
        return false;
    }

    public static synchronized PushNotificationsManager getInstanceFor(XMPPConnection xMPPConnection) {
        PushNotificationsManager pushNotificationsManager;
        synchronized (PushNotificationsManager.class) {
            Map<XMPPConnection, PushNotificationsManager> map = INSTANCES;
            pushNotificationsManager = map.get(xMPPConnection);
            if (pushNotificationsManager == null) {
                pushNotificationsManager = new PushNotificationsManager(xMPPConnection);
                map.put(xMPPConnection, pushNotificationsManager);
            }
        }
        return pushNotificationsManager;
    }

    public boolean disable(Jid jid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return changePushNotificationsStatus(new DisablePushNotificationsIQ(jid, str));
    }

    public boolean disableAll(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return disable(jid, (String) null);
    }

    public boolean enable(Jid jid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return enable(jid, str, (HashMap<String, String>) null);
    }

    public boolean isSupported() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).accountSupportsFeatures("urn:xmpp:push:0");
    }

    public boolean enable(Jid jid, String str, HashMap<String, String> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return changePushNotificationsStatus(new EnablePushNotificationsIQ(jid, str, hashMap));
    }
}
