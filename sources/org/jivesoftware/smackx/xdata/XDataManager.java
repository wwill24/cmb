package org.jivesoftware.smackx.xdata;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xdata.provider.DescriptionProvider;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProviderManager;
import org.jxmpp.jid.Jid;

public final class XDataManager extends Manager {
    private static final Map<XMPPConnection, XDataManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "jabber:x:data";

    static {
        FormFieldChildElementProviderManager.addFormFieldChildElementProvider(new DescriptionProvider());
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                XDataManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private XDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("jabber:x:data");
    }

    public static synchronized XDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        XDataManager xDataManager;
        synchronized (XDataManager.class) {
            Map<XMPPConnection, XDataManager> map = INSTANCES;
            xDataManager = map.get(xMPPConnection);
            if (xDataManager == null) {
                xDataManager = new XDataManager(xMPPConnection);
                map.put(xMPPConnection, xDataManager);
            }
        }
        return xDataManager;
    }

    public boolean isSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, "jabber:x:data");
    }
}
