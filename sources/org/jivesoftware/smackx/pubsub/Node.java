package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.delay.DelayInformationManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.Affiliation;
import org.jivesoftware.smackx.pubsub.SubscriptionsExtension;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableSubscribeForm;
import org.jivesoftware.smackx.pubsub.form.SubscribeForm;
import org.jivesoftware.smackx.pubsub.listener.ItemDeleteListener;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.jivesoftware.smackx.pubsub.listener.NodeConfigListener;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;
import org.jivesoftware.smackx.shim.packet.Header;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class Node {
    protected ConcurrentHashMap<NodeConfigListener, StanzaListener> configEventToListenerMap = new ConcurrentHashMap<>();

    /* renamed from: id  reason: collision with root package name */
    protected final String f24221id;
    protected ConcurrentHashMap<ItemDeleteListener, StanzaListener> itemDeleteToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<ItemEventListener<Item>, StanzaListener> itemEventToListenerMap = new ConcurrentHashMap<>();
    protected final PubSubManager pubSubManager;

    class EventContentFilter extends FlexibleStanzaTypeFilter<Message> {
        private final boolean allowEmpty;
        private final String firstElement;
        private final String secondElement;

        EventContentFilter(Node node, String str) {
            this(str, (String) null);
        }

        EventContentFilter(String str, String str2) {
            this.firstElement = str;
            this.secondElement = str2;
            this.allowEmpty = str.equals(EventElementType.items.toString()) && "item".equals(str2);
        }

        public boolean acceptSpecific(Message message) {
            NodeExtension event;
            EventElement from = EventElement.from(message);
            if (from == null || (event = from.getEvent()) == null || !event.getElementName().equals(this.firstElement) || !event.getNode().equals(Node.this.getId())) {
                return false;
            }
            if (this.secondElement == null) {
                return true;
            }
            if (event instanceof EmbeddedPacketExtension) {
                List<ExtensionElement> extensions = ((EmbeddedPacketExtension) event).getExtensions();
                if (this.allowEmpty && extensions.isEmpty()) {
                    return true;
                }
                if (extensions.size() <= 0 || !extensions.get(0).getElementName().equals(this.secondElement)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    public static class ItemDeleteTranslator implements StanzaListener {
        private final ItemDeleteListener listener;

        public ItemDeleteTranslator(ItemDeleteListener itemDeleteListener) {
            this.listener = itemDeleteListener;
        }

        public void processStanza(Stanza stanza) {
            EventElement eventElement = (EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns());
            if (eventElement.getExtensions().get(0).getElementName().equals(PubSubElementType.PURGE_EVENT.getElementName())) {
                this.listener.handlePurge();
                return;
            }
            ItemsExtension itemsExtension = (ItemsExtension) eventElement.getEvent();
            List<? extends NamedElement> items = itemsExtension.getItems();
            ArrayList arrayList = new ArrayList(items.size());
            Iterator<? extends NamedElement> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(((RetractItem) it.next()).getId());
            }
            this.listener.handleDeletedItems(new ItemDeleteEvent(itemsExtension.getNode(), arrayList, Node.getSubscriptionIds(stanza)));
        }
    }

    public static class ItemEventTranslator implements StanzaListener {
        private final ItemEventListener listener;

        public ItemEventTranslator(ItemEventListener itemEventListener) {
            this.listener = itemEventListener;
        }

        public void processStanza(Stanza stanza) {
            ItemsExtension itemsExtension = (ItemsExtension) ((EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns())).getEvent();
            this.listener.handlePublishedItems(new ItemPublishEvent(itemsExtension.getNode(), itemsExtension.getItems(), Node.getSubscriptionIds(stanza), DelayInformationManager.getDelayTimestamp(stanza)));
        }
    }

    public static class NodeConfigTranslator implements StanzaListener {
        private final NodeConfigListener listener;

        public NodeConfigTranslator(NodeConfigListener nodeConfigListener) {
            this.listener = nodeConfigListener;
        }

        public void processStanza(Stanza stanza) {
            this.listener.handleNodeConfiguration((ConfigurationEvent) ((EventElement) stanza.getExtensionElement("event", PubSubNamespace.event.getXmlns())).getEvent());
        }
    }

    Node(PubSubManager pubSubManager2, String str) {
        this.pubSubManager = pubSubManager2;
        this.f24221id = str;
    }

    /* access modifiers changed from: private */
    public static List<String> getSubscriptionIds(Stanza stanza) {
        HeadersExtension headersExtension = (HeadersExtension) stanza.getExtension(HeadersExtension.class);
        if (headersExtension == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(headersExtension.getHeaders().size());
        for (Header value : headersExtension.getHeaders()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public void addConfigurationListener(NodeConfigListener nodeConfigListener) {
        NodeConfigTranslator nodeConfigTranslator = new NodeConfigTranslator(nodeConfigListener);
        this.configEventToListenerMap.put(nodeConfigListener, nodeConfigTranslator);
        this.pubSubManager.getConnection().addSyncStanzaListener(nodeConfigTranslator, new EventContentFilter(this, EventElementType.configuration.toString()));
    }

    public void addItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        ItemDeleteTranslator itemDeleteTranslator = new ItemDeleteTranslator(itemDeleteListener);
        this.itemDeleteToListenerMap.put(itemDeleteListener, itemDeleteTranslator);
        EventContentFilter eventContentFilter = new EventContentFilter(EventElementType.items.toString(), RetractElement.ELEMENT);
        EventContentFilter eventContentFilter2 = new EventContentFilter(this, EventElementType.purge.toString());
        this.pubSubManager.getConnection().addSyncStanzaListener(itemDeleteTranslator, new OrFilter(eventContentFilter, eventContentFilter2));
    }

    public void addItemEventListener(ItemEventListener itemEventListener) {
        ItemEventTranslator itemEventTranslator = new ItemEventTranslator(itemEventListener);
        this.itemEventToListenerMap.put(itemEventListener, itemEventTranslator);
        this.pubSubManager.getConnection().addSyncStanzaListener(itemEventTranslator, new EventContentFilter(EventElementType.items.toString(), "item"));
    }

    /* access modifiers changed from: protected */
    public PubSub createPubsubPacket(IQ.Type type, NodeExtension nodeExtension) {
        return PubSub.createPubsubPacket(this.pubSubManager.getServiceJid(), type, nodeExtension);
    }

    public DiscoverInfo discoverInfo() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = this.pubSubManager.getConnection();
        return (DiscoverInfo) connection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(connection).to((Jid) this.pubSubManager.getServiceJid())).setNode(getId()).build()).nextResultOrThrow();
    }

    public List<Affiliation> getAffiliations() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliations((List<ExtensionElement>) null, (Collection<ExtensionElement>) null);
    }

    public List<Affiliation> getAffiliationsAsOwner() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliationsAsOwner((List<ExtensionElement>) null, (Collection<ExtensionElement>) null);
    }

    public String getId() {
        return this.f24221id;
    }

    public ConfigureForm getNodeConfiguration() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.CONFIGURE_OWNER;
        return NodeUtils.getFormFromPacket(sendPubsubPacket(createPubsubPacket(type, new NodeExtension(pubSubElementType, getId()))), pubSubElementType);
    }

    public SubscribeForm getSubscriptionOptions(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getSubscriptionOptions(str, (String) null);
    }

    public List<Subscription> getSubscriptions() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getSubscriptions((List<ExtensionElement>) null, (Collection<ExtensionElement>) null);
    }

    public List<Subscription> getSubscriptionsAsOwner() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getSubscriptionsAsOwner((List<ExtensionElement>) null, (Collection<ExtensionElement>) null);
    }

    public PubSub modifyAffiliationAsOwner(List<Affiliation> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        for (Affiliation pubSubNamespace : list) {
            if (pubSubNamespace.getPubSubNamespace() != PubSubNamespace.owner) {
                throw new IllegalArgumentException("Must use Affiliation(BareJid, Type) affiliations");
            }
        }
        return sendPubsubPacket(createPubsubPacket(IQ.Type.set, new AffiliationsExtension(Affiliation.AffiliationNamespace.owner, list, getId())));
    }

    public PubSub modifySubscriptionsAsOwner(List<Subscription> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return sendPubsubPacket(createPubsubPacket(IQ.Type.set, new SubscriptionsExtension(SubscriptionsExtension.SubscriptionsNamespace.owner, getId(), list)));
    }

    public void removeConfigurationListener(NodeConfigListener nodeConfigListener) {
        StanzaListener remove = this.configEventToListenerMap.remove(nodeConfigListener);
        if (remove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(remove);
        }
    }

    public void removeItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        StanzaListener remove = this.itemDeleteToListenerMap.remove(itemDeleteListener);
        if (remove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(remove);
        }
    }

    public void removeItemEventListener(ItemEventListener itemEventListener) {
        StanzaListener remove = this.itemEventToListenerMap.remove(itemEventListener);
        if (remove != null) {
            this.pubSubManager.getConnection().removeSyncStanzaListener(remove);
        }
    }

    public void sendConfigurationForm(FillableConfigureForm fillableConfigureForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new FormNode(FormNodeType.CONFIGURE_OWNER, getId(), fillableConfigureForm.getDataFormToSubmit()))).nextResultOrThrow();
    }

    /* access modifiers changed from: protected */
    public PubSub sendPubsubPacket(PubSub pubSub) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.pubSubManager.sendPubsubPacket(pubSub);
    }

    public Subscription subscribe(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return (Subscription) sendPubsubPacket(createPubsubPacket(IQ.Type.set, new SubscribeExtension(jid, getId()))).getExtension(PubSubElementType.SUBSCRIPTION);
    }

    public String toString() {
        return super.toString() + " " + getClass().getName() + " id: " + this.f24221id;
    }

    public void unsubscribe(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        unsubscribe(str, (String) null);
    }

    public List<Affiliation> getAffiliations(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliations(Affiliation.AffiliationNamespace.basic, list, collection);
    }

    public List<Affiliation> getAffiliationsAsOwner(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliations(Affiliation.AffiliationNamespace.owner, list, collection);
    }

    public SubscribeForm getSubscriptionOptions(String str, String str2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return new SubscribeForm(((FormNode) sendPubsubPacket(createPubsubPacket(IQ.Type.get, new OptionsExtension(str, getId(), str2))).getExtension(PubSubElementType.OPTIONS)).getForm());
    }

    public List<Subscription> getSubscriptions(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace.basic, list, collection);
    }

    public List<Subscription> getSubscriptionsAsOwner(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace.owner, list, collection);
    }

    public void unsubscribe(String str, String str2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        sendPubsubPacket(createPubsubPacket(IQ.Type.set, new UnsubscribeExtension(str, getId(), str2)));
    }

    private List<Affiliation> getAffiliations(Affiliation.AffiliationNamespace affiliationNamespace, List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSubElementType pubSubElementType = affiliationNamespace.type;
        PubSub createPubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(pubSubElementType, getId()));
        if (list != null) {
            for (ExtensionElement addExtension : list) {
                createPubsubPacket.addExtension(addExtension);
            }
        }
        PubSub sendPubsubPacket = sendPubsubPacket(createPubsubPacket);
        if (collection != null) {
            collection.addAll(sendPubsubPacket.getExtensions());
        }
        return ((AffiliationsExtension) sendPubsubPacket.getExtension(pubSubElementType)).getAffiliations();
    }

    private List<Subscription> getSubscriptions(SubscriptionsExtension.SubscriptionsNamespace subscriptionsNamespace, List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSubElementType pubSubElementType = subscriptionsNamespace.type;
        PubSub createPubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(pubSubElementType, getId()));
        if (list != null) {
            for (ExtensionElement addExtension : list) {
                createPubsubPacket.addExtension(addExtension);
            }
        }
        PubSub sendPubsubPacket = sendPubsubPacket(createPubsubPacket);
        if (collection != null) {
            collection.addAll(sendPubsubPacket.getExtensions());
        }
        return ((SubscriptionsExtension) sendPubsubPacket.getExtension(pubSubElementType)).getSubscriptions();
    }

    @Deprecated
    public Subscription subscribe(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        try {
            return subscribe(a.o(str));
        } catch (XmppStringprepException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public Subscription subscribe(Jid jid, FillableSubscribeForm fillableSubscribeForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DataForm dataFormToSubmit = fillableSubscribeForm.getDataFormToSubmit();
        PubSub createPubsubPacket = createPubsubPacket(IQ.Type.set, new SubscribeExtension(jid, getId()));
        createPubsubPacket.addExtension(new FormNode(FormNodeType.OPTIONS, dataFormToSubmit));
        return (Subscription) sendPubsubPacket(createPubsubPacket).getExtension(PubSubElementType.SUBSCRIPTION);
    }

    @Deprecated
    public Subscription subscribe(String str, FillableSubscribeForm fillableSubscribeForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        try {
            return subscribe(a.o(str), fillableSubscribeForm);
        } catch (XmppStringprepException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
