package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;

public final class PubSubManager extends Manager {
    public static final String AUTO_CREATE_FEATURE = "http://jabber.org/protocol/pubsub#auto-create";
    private static final Map<XMPPConnection, Map<BareJid, PubSubManager>> INSTANCES = new WeakHashMap();
    private static final Logger LOGGER = Logger.getLogger(PubSubManager.class.getName());
    public static final String PLUS_NOTIFY = "+notify";
    private final Map<String, Node> nodeMap = new ConcurrentHashMap();
    private final BareJid pubSubService;

    PubSubManager(XMPPConnection xMPPConnection, BareJid bareJid) {
        super(xMPPConnection);
        this.pubSubService = bareJid;
    }

    private void checkIfXmppErrorBecauseOfNotLeafNode(String str, XMPPException.XMPPErrorException xMPPErrorException) throws XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        if (xMPPErrorException.getStanzaError().getCondition() == StanzaError.Condition.feature_not_implemented) {
            throw new PubSubException.NotALeafNodeException(str, this.pubSubService);
        }
        throw xMPPErrorException;
    }

    @Deprecated
    public static PubSubManager getInstance(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[SYNTHETIC, Splitter:B:10:0x0027] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jivesoftware.smackx.pubsub.PubSubManager getInstanceFor(org.jivesoftware.smack.XMPPConnection r4) {
        /*
            boolean r0 = r4.isAuthenticated()
            if (r0 == 0) goto L_0x0024
            org.jxmpp.jid.DomainBareJid r0 = getPubSubService(r4)     // Catch:{ NoResponseException -> 0x001a, XMPPErrorException -> 0x0018, NotConnectedException -> 0x0016, InterruptedException -> 0x000b }
            goto L_0x0025
        L_0x000b:
            r0 = move-exception
            java.util.logging.Logger r1 = LOGGER
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.lang.String r3 = "Interrupted while trying to determine PubSub service"
            r1.log(r2, r3, r0)
            goto L_0x0024
        L_0x0016:
            r0 = move-exception
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            goto L_0x001b
        L_0x001a:
            r0 = move-exception
        L_0x001b:
            java.util.logging.Logger r1 = LOGGER
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.String r3 = "Could not determine PubSub service"
            r1.log(r2, r3, r0)
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 != 0) goto L_0x0048
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmppStringprepException -> 0x0041 }
            r0.<init>()     // Catch:{ XmppStringprepException -> 0x0041 }
            java.lang.String r1 = "pubsub."
            r0.append(r1)     // Catch:{ XmppStringprepException -> 0x0041 }
            org.jxmpp.jid.DomainBareJid r1 = r4.getXMPPServiceDomain()     // Catch:{ XmppStringprepException -> 0x0041 }
            r0.append(r1)     // Catch:{ XmppStringprepException -> 0x0041 }
            java.lang.String r0 = r0.toString()     // Catch:{ XmppStringprepException -> 0x0041 }
            org.jxmpp.jid.DomainBareJid r0 = org.jxmpp.jid.impl.a.e(r0)     // Catch:{ XmppStringprepException -> 0x0041 }
            goto L_0x0048
        L_0x0041:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r4)
            throw r0
        L_0x0048:
            org.jivesoftware.smackx.pubsub.PubSubManager r4 = getInstanceFor(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pubsub.PubSubManager.getInstanceFor(org.jivesoftware.smack.XMPPConnection):org.jivesoftware.smackx.pubsub.PubSubManager");
    }

    private LeafNode getLeafNodeProsodyWorkaround(String str) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        LeafNode leafNode = new LeafNode(this, str);
        try {
            leafNode.getItems(1);
        } catch (XMPPException.XMPPErrorException e10) {
            checkIfXmppErrorBecauseOfNotLeafNode(str, e10);
        }
        this.nodeMap.put(str, leafNode);
        return leafNode;
    }

    private LeafNode getOrCreateLeafNodeProsodyWorkaround(String str) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotALeafNodeException {
        try {
            return createNode(str);
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.conflict) {
                return getLeafNodeProsodyWorkaround(str);
            }
            throw e10;
        }
    }

    public static DomainBareJid getPubSubService(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).findService("http://jabber.org/protocol/pubsub", true, "pubsub", "service");
    }

    private PubSub sendPubsubPacket(IQ.Type type, ExtensionElement extensionElement, PubSubNamespace pubSubNamespace) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return sendPubsubPacket(this.pubSubService, type, Collections.singletonList(extensionElement), pubSubNamespace);
    }

    public boolean canCreateNodesAndPublishItems() throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            LeafNode createNode = createNode();
            if (createNode == null) {
                return true;
            }
            deleteNode(createNode.getId());
            return true;
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.forbidden) {
                return false;
            }
            throw e10;
        }
    }

    public LeafNode createNode() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        LeafNode leafNode = new LeafNode(this, ((NodeExtension) sendPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.CREATE), (PubSubNamespace) null).getExtension(new QName(PubSubNamespace.basic.getXmlns(), "create"))).getNode());
        this.nodeMap.put(leafNode.getId(), leafNode);
        return leafNode;
    }

    public boolean deleteNode(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        boolean z10;
        try {
            IQ.Type type = IQ.Type.set;
            PubSubElementType pubSubElementType = PubSubElementType.DELETE;
            sendPubsubPacket(type, new NodeExtension(pubSubElementType, str), pubSubElementType.getNamespace());
            z10 = true;
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.item_not_found) {
                z10 = false;
            } else {
                throw e10;
            }
        }
        this.nodeMap.remove(str);
        return z10;
    }

    public DiscoverItems discoverNodes(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DiscoverItems discoverItems = new DiscoverItems();
        if (str != null) {
            discoverItems.setNode(str);
        }
        discoverItems.setTo(this.pubSubService);
        return (DiscoverItems) connection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public List<Affiliation> getAffiliations() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.AFFILIATIONS;
        return ((AffiliationsExtension) sendPubsubPacket(type, new NodeExtension(pubSubElementType), (PubSubNamespace) null).getExtension(pubSubElementType)).getAffiliations();
    }

    /* access modifiers changed from: package-private */
    public XMPPConnection getConnection() {
        return connection();
    }

    public ConfigureForm getDefaultConfiguration() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.DEFAULT;
        return NodeUtils.getFormFromPacket(sendPubsubPacket(type, new NodeExtension(pubSubElementType), pubSubElementType.getNamespace()), pubSubElementType);
    }

    public LeafNode getLeafNode(String str) throws PubSubException.NotALeafNodeException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, PubSubException.NotAPubSubNodeException {
        try {
            Node node = getNode(str);
            if (node instanceof LeafNode) {
                return (LeafNode) node;
            }
            throw new PubSubException.NotALeafNodeException(str, this.pubSubService);
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.service_unavailable) {
                return getLeafNodeProsodyWorkaround(str);
            }
            throw e10;
        }
    }

    public Node getNode(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotAPubSubNodeException {
        StringUtils.requireNotNullNorEmpty(str, "The node ID can not be null or the empty string");
        Node node = this.nodeMap.get(str);
        if (node == null) {
            XMPPConnection connection = connection();
            DiscoverInfo discoverInfo = (DiscoverInfo) connection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(connection).to((Jid) this.pubSubService)).setNode(str).build()).nextResultOrThrow();
            if (discoverInfo.hasIdentity("pubsub", "leaf")) {
                node = new LeafNode(this, str);
            } else if (discoverInfo.hasIdentity("pubsub", "collection")) {
                node = new CollectionNode(this, str);
            } else {
                throw new PubSubException.NotAPubSubNodeException(str, discoverInfo);
            }
            this.nodeMap.put(str, node);
        }
        return node;
    }

    public LeafNode getOrCreateLeafNode(String str) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        try {
            return getLeafNode(str);
        } catch (PubSubException.NotAPubSubNodeException unused) {
            return createNode(str);
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.item_not_found) {
                try {
                    return createNode(str);
                } catch (XMPPException.XMPPErrorException e11) {
                    if (e11.getStanzaError().getCondition() == StanzaError.Condition.conflict) {
                        try {
                            return getLeafNode(str);
                        } catch (PubSubException.NotAPubSubNodeException e12) {
                            throw new IllegalStateException(e12);
                        }
                    } else {
                        throw e11;
                    }
                }
            } else if (e10.getStanzaError().getCondition() == StanzaError.Condition.service_unavailable) {
                Logger logger = LOGGER;
                logger.warning("The PubSub service " + this.pubSubService + " threw an DiscoInfoNodeAssertionError, trying workaround for Prosody bug #805 (https://prosody.im/issues/issue/805)");
                return getOrCreateLeafNodeProsodyWorkaround(str);
            } else {
                throw e10;
            }
        }
    }

    public BareJid getServiceJid() {
        return this.pubSubService;
    }

    public List<Subscription> getSubscriptions() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.SUBSCRIPTIONS;
        return ((SubscriptionsExtension) sendPubsubPacket(type, new NodeExtension(pubSubElementType), (PubSubNamespace) null).getExtensionElement(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns())).getSubscriptions();
    }

    public DiscoverInfo getSupportedFeatures() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).discoverInfo(this.pubSubService);
    }

    public boolean supportsAutomaticNodeCreation() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(this.pubSubService, AUTO_CREATE_FEATURE);
    }

    public <I extends Item> LeafNode tryToPublishAndPossibleAutoCreate(String str, I i10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, PubSubException.NotALeafNodeException {
        LeafNode leafNode = new LeafNode(this, str);
        try {
            leafNode.publish(i10);
        } catch (XMPPException.XMPPErrorException e10) {
            checkIfXmppErrorBecauseOfNotLeafNode(str, e10);
        }
        this.nodeMap.put(str, leafNode);
        return leafNode;
    }

    @Deprecated
    public static PubSubManager getInstance(XMPPConnection xMPPConnection, BareJid bareJid) {
        return getInstanceFor(xMPPConnection, bareJid);
    }

    /* access modifiers changed from: package-private */
    public PubSub sendPubsubPacket(Jid jid, IQ.Type type, List<ExtensionElement> list, PubSubNamespace pubSubNamespace) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSub pubSub = new PubSub(jid, type, pubSubNamespace);
        for (ExtensionElement addExtension : list) {
            pubSub.addExtension(addExtension);
        }
        return sendPubsubPacket(pubSub);
    }

    public LeafNode createNode(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return (LeafNode) createNode(str, (FillableConfigureForm) null);
    }

    /* access modifiers changed from: package-private */
    public PubSub sendPubsubPacket(PubSub pubSub) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        IQ iq = (IQ) connection().createStanzaCollectorAndSend(pubSub).nextResultOrThrow();
        if (iq instanceof EmptyResultIQ) {
            return null;
        }
        return (PubSub) iq;
    }

    public Node createNode(String str, FillableConfigureForm fillableConfigureForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSub createPubsubPacket = PubSub.createPubsubPacket(this.pubSubService, IQ.Type.set, new NodeExtension(PubSubElementType.CREATE, str));
        boolean z10 = true;
        if (fillableConfigureForm != null) {
            createPubsubPacket.addExtension(new FormNode(FormNodeType.CONFIGURE, fillableConfigureForm.getDataFormToSubmit()));
            NodeType nodeType = fillableConfigureForm.getNodeType();
            if (!(nodeType == null || nodeType == NodeType.leaf)) {
                z10 = false;
            }
        }
        sendPubsubPacket(createPubsubPacket);
        Node leafNode = z10 ? new LeafNode(this, str) : new CollectionNode(this, str);
        this.nodeMap.put(leafNode.getId(), leafNode);
        return leafNode;
    }

    public static PubSubManager getInstanceFor(XMPPConnection xMPPConnection, BareJid bareJid) {
        Map map;
        PubSubManager pubSubManager;
        if (bareJid != null && xMPPConnection.isAuthenticated() && xMPPConnection.getUser().i1().Y(bareJid)) {
            bareJid = null;
        }
        Map<XMPPConnection, Map<BareJid, PubSubManager>> map2 = INSTANCES;
        synchronized (map2) {
            map = map2.get(xMPPConnection);
            if (map == null) {
                map = new HashMap();
                map2.put(xMPPConnection, map);
            }
        }
        synchronized (map) {
            pubSubManager = (PubSubManager) map.get(bareJid);
            if (pubSubManager == null) {
                pubSubManager = new PubSubManager(xMPPConnection, bareJid);
                map.put(bareJid, pubSubManager);
            }
        }
        return pubSubManager;
    }
}
