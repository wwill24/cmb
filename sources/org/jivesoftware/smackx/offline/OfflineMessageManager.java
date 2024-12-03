package org.jivesoftware.smackx.offline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.offline.packet.OfflineMessageInfo;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public final class OfflineMessageManager extends Manager {
    private static final Map<XMPPConnection, OfflineMessageManager> INSTANCES = new WeakHashMap();
    private static final Logger LOGGER = Logger.getLogger(OfflineMessageManager.class.getName());
    public static final String NAMESPACE = "http://jabber.org/protocol/offline";
    private static final StanzaFilter PACKET_FILTER = new AndFilter(new StanzaExtensionFilter((ExtensionElement) new OfflineMessageInfo()), StanzaTypeFilter.MESSAGE);
    private ServiceDiscoveryManager serviceDiscoveryManager;

    private OfflineMessageManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized OfflineMessageManager getInstanceFor(XMPPConnection xMPPConnection) {
        OfflineMessageManager offlineMessageManager;
        synchronized (OfflineMessageManager.class) {
            Map<XMPPConnection, OfflineMessageManager> map = INSTANCES;
            offlineMessageManager = map.get(xMPPConnection);
            if (offlineMessageManager == null) {
                offlineMessageManager = new OfflineMessageManager(xMPPConnection);
                map.put(xMPPConnection, offlineMessageManager);
            }
        }
        return offlineMessageManager;
    }

    public void deleteMessages(List<String> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setType(IQ.Type.set);
        for (String item : list) {
            OfflineMessageRequest.Item item2 = new OfflineMessageRequest.Item(item);
            item2.setAction("remove");
            offlineMessageRequest.addItem(item2);
        }
        connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }

    public List<OfflineMessageHeader> getHeaders() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (DiscoverItems.Item offlineMessageHeader : this.serviceDiscoveryManager.discoverItems((Jid) null, "http://jabber.org/protocol/offline").getItems()) {
            arrayList.add(new OfflineMessageHeader(offlineMessageHeader));
        }
        return arrayList;
    }

    public int getMessageCount() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DataForm from = DataForm.from((StanzaView) this.serviceDiscoveryManager.discoverInfo((Jid) null, "http://jabber.org/protocol/offline"), "http://jabber.org/protocol/offline");
        if (from == null) {
            return 0;
        }
        return Integer.parseInt(from.getField("number_of_messages").getFirstValue());
    }

    public List<Message> getMessages(final List<String> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList(list.size());
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        for (String item : list) {
            OfflineMessageRequest.Item item2 = new OfflineMessageRequest.Item(item);
            item2.setAction("view");
            offlineMessageRequest.addItem(item2);
        }
        AndFilter andFilter = new AndFilter(PACKET_FILTER, new StanzaFilter() {
            public boolean accept(Stanza stanza) {
                return list.contains(((OfflineMessageInfo) stanza.getExtension(OfflineMessageInfo.class)).getNode());
            }
        });
        int size = list.size();
        StanzaCollector createStanzaCollector = connection().createStanzaCollector((StanzaFilter) andFilter);
        try {
            connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
            do {
                Message message = (Message) createStanzaCollector.nextResult();
                if (message != null) {
                    arrayList.add(message);
                    size--;
                } else if (message == null && size > 0) {
                    LOGGER.log(Level.WARNING, "Did not receive all expected offline messages. " + size + " are missing.");
                }
                if (message == null) {
                    break;
                }
            } while (size > 0);
            createStanzaCollector.close();
            return arrayList;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public boolean supportsFlexibleRetrieval() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.serverSupportsFeature("http://jabber.org/protocol/offline");
    }

    public void deleteMessages() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setType(IQ.Type.set);
        offlineMessageRequest.setPurge(true);
        connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }

    public List<Message> getMessages() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setFetch(true);
        StanzaCollector createStanzaCollectorAndSend = connection().createStanzaCollectorAndSend(offlineMessageRequest);
        StanzaCollector createStanzaCollector = connection().createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(PACKET_FILTER).setCollectorToReset(createStanzaCollectorAndSend));
        try {
            createStanzaCollectorAndSend.nextResultOrThrow();
            createStanzaCollector.cancel();
            ArrayList arrayList = new ArrayList(createStanzaCollector.getCollectedCount());
            while (true) {
                Message message = (Message) createStanzaCollector.pollResult();
                if (message != null) {
                    arrayList.add(message);
                } else {
                    createStanzaCollector.close();
                    return arrayList;
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
