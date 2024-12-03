package org.jivesoftware.smackx.muclight;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.muclight.element.MUCLightBlockingIQ;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

public final class MultiUserChatLightManager extends Manager {
    private static final Map<XMPPConnection, MultiUserChatLightManager> INSTANCES = new WeakHashMap();
    private final Map<EntityBareJid, WeakReference<MultiUserChatLight>> multiUserChatLights = new HashMap();

    private MultiUserChatLightManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    private MultiUserChatLight createNewMucLightAndAddToMap(EntityBareJid entityBareJid) {
        MultiUserChatLight multiUserChatLight = new MultiUserChatLight(connection(), entityBareJid);
        this.multiUserChatLights.put(entityBareJid, new WeakReference(multiUserChatLight));
        return multiUserChatLight;
    }

    private MUCLightBlockingIQ getBlockingList(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ((HashMap<Jid, Boolean>) null, (HashMap<Jid, Boolean>) null);
        mUCLightBlockingIQ.setType(IQ.Type.get);
        mUCLightBlockingIQ.setTo(domainBareJid);
        return (MUCLightBlockingIQ) ((IQ) connection().createStanzaCollectorAndSend(new IQReplyFilter(mUCLightBlockingIQ, connection()), mUCLightBlockingIQ).nextResultOrThrow());
    }

    public static synchronized MultiUserChatLightManager getInstanceFor(XMPPConnection xMPPConnection) {
        MultiUserChatLightManager multiUserChatLightManager;
        synchronized (MultiUserChatLightManager.class) {
            Map<XMPPConnection, MultiUserChatLightManager> map = INSTANCES;
            multiUserChatLightManager = map.get(xMPPConnection);
            if (multiUserChatLightManager == null) {
                multiUserChatLightManager = new MultiUserChatLightManager(xMPPConnection);
                map.put(xMPPConnection, multiUserChatLightManager);
            }
        }
        return multiUserChatLightManager;
    }

    private void sendBlockRooms(DomainBareJid domainBareJid, HashMap<Jid, Boolean> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(hashMap, (HashMap<Jid, Boolean>) null);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    private void sendBlockUsers(DomainBareJid domainBareJid, HashMap<Jid, Boolean> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ((HashMap<Jid, Boolean>) null, hashMap);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    private void sendUnblockRooms(DomainBareJid domainBareJid, HashMap<Jid, Boolean> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(hashMap, (HashMap<Jid, Boolean>) null);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    private void sendUnblockUsers(DomainBareJid domainBareJid, HashMap<Jid, Boolean> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ((HashMap<Jid, Boolean>) null, hashMap);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    public void blockRoom(DomainBareJid domainBareJid, Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        hashMap.put(jid, Boolean.FALSE);
        sendBlockRooms(domainBareJid, hashMap);
    }

    public void blockRooms(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        for (Jid put : list) {
            hashMap.put(put, Boolean.FALSE);
        }
        sendBlockRooms(domainBareJid, hashMap);
    }

    public void blockUser(DomainBareJid domainBareJid, Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        hashMap.put(jid, Boolean.FALSE);
        sendBlockUsers(domainBareJid, hashMap);
    }

    public void blockUsers(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        for (Jid put : list) {
            hashMap.put(put, Boolean.FALSE);
        }
        sendBlockUsers(domainBareJid, hashMap);
    }

    public List<DomainBareJid> getLocalServices() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).findServices(MultiUserChatLight.NAMESPACE, false, false);
    }

    public synchronized MultiUserChatLight getMultiUserChatLight(EntityBareJid entityBareJid) {
        WeakReference weakReference = this.multiUserChatLights.get(entityBareJid);
        if (weakReference == null) {
            return createNewMucLightAndAddToMap(entityBareJid);
        }
        MultiUserChatLight multiUserChatLight = (MultiUserChatLight) weakReference.get();
        if (multiUserChatLight != null) {
            return multiUserChatLight;
        }
        return createNewMucLightAndAddToMap(entityBareJid);
    }

    public List<Jid> getOccupiedRooms(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<DiscoverItems.Item> items = ServiceDiscoveryManager.getInstanceFor(connection()).discoverItems(domainBareJid).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        for (DiscoverItems.Item entityID : items) {
            arrayList.add(entityID.getEntityID());
        }
        return arrayList;
    }

    public List<Jid> getRoomsBlocked(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getRooms() != null) {
            arrayList.addAll(blockingList.getRooms().keySet());
        }
        return arrayList;
    }

    public List<Jid> getUsersAndRoomsBlocked(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getRooms() != null) {
            arrayList.addAll(blockingList.getRooms().keySet());
        }
        if (blockingList.getUsers() != null) {
            arrayList.addAll(blockingList.getUsers().keySet());
        }
        return arrayList;
    }

    public List<Jid> getUsersBlocked(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getUsers() != null) {
            arrayList.addAll(blockingList.getUsers().keySet());
        }
        return arrayList;
    }

    public boolean isFeatureSupported(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).discoverInfo(domainBareJid).containsFeature(MultiUserChatLight.NAMESPACE);
    }

    public void unblockRoom(DomainBareJid domainBareJid, Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        hashMap.put(jid, Boolean.TRUE);
        sendUnblockRooms(domainBareJid, hashMap);
    }

    public void unblockRooms(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        for (Jid put : list) {
            hashMap.put(put, Boolean.TRUE);
        }
        sendUnblockRooms(domainBareJid, hashMap);
    }

    public void unblockUser(DomainBareJid domainBareJid, Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        hashMap.put(jid, Boolean.TRUE);
        sendUnblockUsers(domainBareJid, hashMap);
    }

    public void unblockUsers(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        HashMap hashMap = new HashMap();
        for (Jid put : list) {
            hashMap.put(put, Boolean.TRUE);
        }
        sendUnblockUsers(domainBareJid, hashMap);
    }
}
