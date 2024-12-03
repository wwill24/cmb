package org.jivesoftware.smackx.softwareinfo;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public final class SoftwareInfoManager extends Manager {
    private static final Map<XMPPConnection, SoftwareInfoManager> INSTANCES = new WeakHashMap();
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    private SoftwareInfoManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized SoftwareInfoManager getInstanceFor(XMPPConnection xMPPConnection) {
        SoftwareInfoManager softwareInfoManager;
        synchronized (SoftwareInfoManager.class) {
            Map<XMPPConnection, SoftwareInfoManager> map = INSTANCES;
            softwareInfoManager = map.get(xMPPConnection);
            if (softwareInfoManager == null) {
                softwareInfoManager = new SoftwareInfoManager(xMPPConnection);
                map.put(xMPPConnection, softwareInfoManager);
            }
        }
        return softwareInfoManager;
    }

    public SoftwareInfoForm fromJid(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DataForm from = DataForm.from((StanzaView) this.serviceDiscoveryManager.discoverInfo(jid), SoftwareInfoForm.FORM_TYPE);
        if (from == null) {
            return null;
        }
        return SoftwareInfoForm.getBuilder().setDataForm(from).build();
    }

    public void publishSoftwareInformationForm(SoftwareInfoForm softwareInfoForm) {
        this.serviceDiscoveryManager.addExtendedInfo(softwareInfoForm.getDataForm());
    }
}
