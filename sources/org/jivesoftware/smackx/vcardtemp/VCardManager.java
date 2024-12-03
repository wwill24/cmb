package org.jivesoftware.smackx.vcardtemp;

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
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

public final class VCardManager extends Manager {
    public static final String ELEMENT = "vCard";
    private static final Map<XMPPConnection, VCardManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "vcard-temp";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                VCardManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private VCardManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("vcard-temp");
    }

    public static synchronized VCardManager getInstanceFor(XMPPConnection xMPPConnection) {
        VCardManager vCardManager;
        synchronized (VCardManager.class) {
            Map<XMPPConnection, VCardManager> map = INSTANCES;
            vCardManager = map.get(xMPPConnection);
            if (vCardManager == null) {
                vCardManager = new VCardManager(xMPPConnection);
                map.put(xMPPConnection, vCardManager);
            }
        }
        return vCardManager;
    }

    @Deprecated
    public static boolean isSupported(Jid jid, XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getInstanceFor(xMPPConnection).isSupported(jid);
    }

    public VCard loadVCard() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return loadVCard((EntityBareJid) null);
    }

    public void saveVCard(VCard vCard) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        vCard.setTo((Jid) null);
        vCard.setType(IQ.Type.set);
        vCard.setStanzaId();
        connection().createStanzaCollectorAndSend(vCard).nextResultOrThrow();
    }

    public boolean isSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, "vcard-temp");
    }

    public VCard loadVCard(EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        VCard vCard = new VCard();
        vCard.setTo(entityBareJid);
        return (VCard) connection().createStanzaCollectorAndSend(vCard).nextResultOrThrow();
    }
}
