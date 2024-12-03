package org.jivesoftware.smackx.pep;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.jidtype.FromJidTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.pubsub.EventElement;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubFeature;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.filter.EventItemsExtensionFilter;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

public final class PepManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<XMPPConnection, PepManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(PepManager.class.getName());
    private static final StanzaFilter PEP_EVENTS_FILTER = new AndFilter(MessageTypeFilter.NORMAL_OR_HEADLINE, FromJidTypeFilter.ENTITY_BARE_JID, EventItemsExtensionFilter.INSTANCE);
    private static final PubSubFeature[] REQUIRED_FEATURES = {PubSubFeature.auto_create, PubSubFeature.auto_subscribe, PubSubFeature.filtered_notifications};
    /* access modifiers changed from: private */
    public final AsyncButOrdered<EntityBareJid> asyncButOrdered = new AsyncButOrdered<>();
    private final Map<PepEventListener<?>, PepEventListenerCoupling<?>> listenerToCouplingMap = new HashMap();
    /* access modifiers changed from: private */
    public final MultiMap<String, PepEventListenerCoupling<? extends ExtensionElement>> pepEventListeners = new MultiMap<>();
    /* access modifiers changed from: private */
    public final Set<PepListener> pepListeners = new CopyOnWriteArraySet();
    private final PubSubManager pepPubSubManager;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    private static final class PepEventListenerCoupling<E extends ExtensionElement> {
        private final Class<E> extensionElementType;
        /* access modifiers changed from: private */
        public final String node;
        private final PepEventListener<E> pepEventListener;

        /* access modifiers changed from: private */
        public void invoke(EntityBareJid entityBareJid, ExtensionElement extensionElement, String str, Message message) {
            if (!this.extensionElementType.isInstance(extensionElement)) {
                Logger access$400 = PepManager.LOGGER;
                access$400.warning("Ignoring " + extensionElement + " from " + message + " as it is not of type " + this.extensionElementType);
                return;
            }
            this.pepEventListener.onPepEvent(entityBareJid, (ExtensionElement) this.extensionElementType.cast(extensionElement), str, message);
        }

        private PepEventListenerCoupling(String str, Class<E> cls, PepEventListener<E> pepEventListener2) {
            this.node = str;
            this.extensionElementType = cls;
            this.pepEventListener = pepEventListener2;
        }
    }

    private PepManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.pepPubSubManager = PubSubManager.getInstanceFor(xMPPConnection, (BareJid) null);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                final EventElement from = EventElement.from(stanza);
                final EntityBareJid h12 = message.getFrom().h1();
                PepManager.this.asyncButOrdered.performAsyncButOrdered(h12, new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0050, code lost:
                        r1 = r1.iterator();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
                        if (r1.hasNext() == false) goto L_0x0088;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
                        r2 = (org.jivesoftware.smackx.pep.PepManager.PepEventListenerCoupling) r1.next();
                        r3 = r0.getItems().iterator();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
                        if (r3.hasNext() == false) goto L_0x0054;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
                        r4 = (org.jivesoftware.smackx.pubsub.Item) ((org.jivesoftware.smack.packet.NamedElement) r3.next());
                        r5 = r4.getId();
                        org.jivesoftware.smackx.pep.PepManager.PepEventListenerCoupling.access$200(r2, r1, ((org.jivesoftware.smackx.pubsub.PayloadItem) r4).getPayload(), r5, r0);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
                        return;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r8 = this;
                            org.jivesoftware.smackx.pubsub.EventElement r0 = r5
                            org.jivesoftware.smackx.pubsub.NodeExtension r0 = r0.getEvent()
                            org.jivesoftware.smackx.pubsub.ItemsExtension r0 = (org.jivesoftware.smackx.pubsub.ItemsExtension) r0
                            java.lang.String r1 = r0.getNode()
                            org.jivesoftware.smackx.pep.PepManager$1 r2 = org.jivesoftware.smackx.pep.PepManager.AnonymousClass1.this
                            org.jivesoftware.smackx.pep.PepManager r2 = org.jivesoftware.smackx.pep.PepManager.this
                            java.util.Set r2 = r2.pepListeners
                            java.util.Iterator r2 = r2.iterator()
                        L_0x0018:
                            boolean r3 = r2.hasNext()
                            if (r3 == 0) goto L_0x002e
                            java.lang.Object r3 = r2.next()
                            org.jivesoftware.smackx.pep.PepListener r3 = (org.jivesoftware.smackx.pep.PepListener) r3
                            org.jxmpp.jid.EntityBareJid r4 = r1
                            org.jivesoftware.smackx.pubsub.EventElement r5 = r5
                            org.jivesoftware.smack.packet.Message r6 = r0
                            r3.eventReceived(r4, r5, r6)
                            goto L_0x0018
                        L_0x002e:
                            org.jivesoftware.smackx.pep.PepManager$1 r2 = org.jivesoftware.smackx.pep.PepManager.AnonymousClass1.this
                            org.jivesoftware.smackx.pep.PepManager r2 = org.jivesoftware.smackx.pep.PepManager.this
                            org.jivesoftware.smack.util.MultiMap r2 = r2.pepEventListeners
                            monitor-enter(r2)
                            org.jivesoftware.smackx.pep.PepManager$1 r3 = org.jivesoftware.smackx.pep.PepManager.AnonymousClass1.this     // Catch:{ all -> 0x0089 }
                            org.jivesoftware.smackx.pep.PepManager r3 = org.jivesoftware.smackx.pep.PepManager.this     // Catch:{ all -> 0x0089 }
                            org.jivesoftware.smack.util.MultiMap r3 = r3.pepEventListeners     // Catch:{ all -> 0x0089 }
                            java.util.List r1 = r3.getAll(r1)     // Catch:{ all -> 0x0089 }
                            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x0089 }
                            if (r3 == 0) goto L_0x004b
                            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
                            return
                        L_0x004b:
                            java.util.ArrayList r1 = org.jivesoftware.smack.util.CollectionUtil.newListWith(r1)     // Catch:{ all -> 0x0089 }
                            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
                            java.util.Iterator r1 = r1.iterator()
                        L_0x0054:
                            boolean r2 = r1.hasNext()
                            if (r2 == 0) goto L_0x0088
                            java.lang.Object r2 = r1.next()
                            org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling r2 = (org.jivesoftware.smackx.pep.PepManager.PepEventListenerCoupling) r2
                            java.util.List r3 = r0.getItems()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0068:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x0054
                            java.lang.Object r4 = r3.next()
                            org.jivesoftware.smack.packet.NamedElement r4 = (org.jivesoftware.smack.packet.NamedElement) r4
                            org.jivesoftware.smackx.pubsub.Item r4 = (org.jivesoftware.smackx.pubsub.Item) r4
                            java.lang.String r5 = r4.getId()
                            org.jivesoftware.smackx.pubsub.PayloadItem r4 = (org.jivesoftware.smackx.pubsub.PayloadItem) r4
                            org.jivesoftware.smack.packet.ExtensionElement r4 = r4.getPayload()
                            org.jxmpp.jid.EntityBareJid r6 = r1
                            org.jivesoftware.smack.packet.Message r7 = r0
                            r2.invoke(r6, r4, r5, r7)
                            goto L_0x0068
                        L_0x0088:
                            return
                        L_0x0089:
                            r0 = move-exception
                            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pep.PepManager.AnonymousClass1.AnonymousClass1.run():void");
                    }
                });
            }
        }, PEP_EVENTS_FILTER);
    }

    public static synchronized PepManager getInstanceFor(XMPPConnection xMPPConnection) {
        PepManager pepManager;
        synchronized (PepManager.class) {
            Map<XMPPConnection, PepManager> map = INSTANCES;
            pepManager = map.get(xMPPConnection);
            if (pepManager == null) {
                pepManager = new PepManager(xMPPConnection);
                map.put(xMPPConnection, pepManager);
            }
        }
        return pepManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E extends org.jivesoftware.smack.packet.ExtensionElement> boolean addPepEventListener(java.lang.String r3, java.lang.Class<E> r4, org.jivesoftware.smackx.pep.PepEventListener<E> r5) {
        /*
            r2 = this;
            org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling r0 = new org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling
            r1 = 0
            r0.<init>(r3, r4, r5)
            org.jivesoftware.smack.util.MultiMap<java.lang.String, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<? extends org.jivesoftware.smack.packet.ExtensionElement>> r4 = r2.pepEventListeners
            monitor-enter(r4)
            java.util.Map<org.jivesoftware.smackx.pep.PepEventListener<?>, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<?>> r1 = r2.listenerToCouplingMap     // Catch:{ all -> 0x003a }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0014
            r3 = 0
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            return r3
        L_0x0014:
            java.util.Map<org.jivesoftware.smackx.pep.PepEventListener<?>, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<?>> r1 = r2.listenerToCouplingMap     // Catch:{ all -> 0x003a }
            r1.put(r5, r0)     // Catch:{ all -> 0x003a }
            org.jivesoftware.smack.util.MultiMap<java.lang.String, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<? extends org.jivesoftware.smack.packet.ExtensionElement>> r5 = r2.pepEventListeners     // Catch:{ all -> 0x003a }
            boolean r5 = r5.put(r3, r0)     // Catch:{ all -> 0x003a }
            if (r5 != 0) goto L_0x0037
            org.jivesoftware.smackx.disco.ServiceDiscoveryManager r5 = r2.serviceDiscoveryManager     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            r0.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "+notify"
            r0.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x003a }
            r5.addFeature(r3)     // Catch:{ all -> 0x003a }
        L_0x0037:
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            r3 = 1
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pep.PepManager.addPepEventListener(java.lang.String, java.lang.Class, org.jivesoftware.smackx.pep.PepEventListener):boolean");
    }

    @Deprecated
    public boolean addPepListener(PepListener pepListener) {
        return this.pepListeners.add(pepListener);
    }

    public PubSubManager getPepPubSubManager() {
        return this.pepPubSubManager;
    }

    public boolean isSupported() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        return ServiceDiscoveryManager.getInstanceFor(connection).supportsFeatures((Jid) connection.getUser().i1(), (CharSequence[]) REQUIRED_FEATURES);
    }

    public LeafNode publish(String str, Item item) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        return this.pepPubSubManager.tryToPublishAndPossibleAutoCreate(str, item);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removePepEventListener(org.jivesoftware.smackx.pep.PepEventListener<?> r4) {
        /*
            r3 = this;
            org.jivesoftware.smack.util.MultiMap<java.lang.String, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<? extends org.jivesoftware.smack.packet.ExtensionElement>> r0 = r3.pepEventListeners
            monitor-enter(r0)
            java.util.Map<org.jivesoftware.smackx.pep.PepEventListener<?>, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<?>> r1 = r3.listenerToCouplingMap     // Catch:{ all -> 0x003e }
            java.lang.Object r4 = r1.remove(r4)     // Catch:{ all -> 0x003e }
            org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling r4 = (org.jivesoftware.smackx.pep.PepManager.PepEventListenerCoupling) r4     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x0010
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r4
        L_0x0010:
            java.lang.String r1 = r4.node     // Catch:{ all -> 0x003e }
            org.jivesoftware.smack.util.MultiMap<java.lang.String, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<? extends org.jivesoftware.smack.packet.ExtensionElement>> r2 = r3.pepEventListeners     // Catch:{ all -> 0x003e }
            r2.removeOne(r1, r4)     // Catch:{ all -> 0x003e }
            org.jivesoftware.smack.util.MultiMap<java.lang.String, org.jivesoftware.smackx.pep.PepManager$PepEventListenerCoupling<? extends org.jivesoftware.smack.packet.ExtensionElement>> r2 = r3.pepEventListeners     // Catch:{ all -> 0x003e }
            java.lang.String r4 = r4.node     // Catch:{ all -> 0x003e }
            boolean r4 = r2.containsKey(r4)     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x003b
            org.jivesoftware.smackx.disco.ServiceDiscoveryManager r4 = r3.serviceDiscoveryManager     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r2.<init>()     // Catch:{ all -> 0x003e }
            r2.append(r1)     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "+notify"
            r2.append(r1)     // Catch:{ all -> 0x003e }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x003e }
            r4.removeFeature(r1)     // Catch:{ all -> 0x003e }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            r4 = 1
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pep.PepManager.removePepEventListener(org.jivesoftware.smackx.pep.PepEventListener):boolean");
    }

    @Deprecated
    public boolean removePepListener(PepListener pepListener) {
        return this.pepListeners.remove(pepListener);
    }
}
