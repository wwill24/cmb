package org.jivesoftware.smackx.disco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import mm.a;
import mm.b;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.internal.AbstractStats;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.ExtendedAppendable;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;

public final class ServiceDiscoveryManager extends Manager {
    private static final String DEFAULT_IDENTITY_CATEGORY = "client";
    private static final String DEFAULT_IDENTITY_NAME = "Smack";
    private static final String DEFAULT_IDENTITY_TYPE = "pc";
    private static final Logger LOGGER = Logger.getLogger(ServiceDiscoveryManager.class.getName());
    private static final int RENEW_ENTITY_CAPS_DELAY_MILLIS = 25;
    private static DiscoverInfo.Identity defaultIdentity = new DiscoverInfo.Identity("client", DEFAULT_IDENTITY_NAME, DEFAULT_IDENTITY_TYPE);
    private static final List<DiscoInfoLookupShortcutMechanism> discoInfoLookupShortcutMechanisms = new ArrayList(2);
    private static final Map<XMPPConnection, ServiceDiscoveryManager> instances = new WeakHashMap();
    private final Set<EntityCapabilitiesChangedListener> entityCapabilitiesChangedListeners = new CopyOnWriteArraySet();
    private List<DataForm> extendedInfos = new ArrayList(2);
    private final Set<String> features = new HashSet();
    private final Set<DiscoverInfo.Identity> identities = new HashSet();
    private DiscoverInfo.Identity identity = defaultIdentity;
    private final Map<String, NodeInformationProvider> nodeInformationProviders = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public volatile Presence presenceSend;
    /* access modifiers changed from: private */
    public final AtomicInteger renewEntityCapsPerformed = new AtomicInteger();
    /* access modifiers changed from: private */
    public int renewEntityCapsRequested = 0;
    private ScheduledAction renewEntityCapsScheduledAction;
    /* access modifiers changed from: private */
    public int scheduledRenewEntityCapsAvoided = 0;
    private final a<String, List<DiscoverInfo>> services = new b(25, 86400000);

    public static final class Stats extends AbstractStats {
        public final int renewEntityCapsPerformed;
        public final int renewEntityCapsRequested;
        public final int scheduledRenewEntityCapsAvoided;

        public void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException {
            StringUtils.appendHeading(extendedAppendable, "ServiceDiscoveryManager stats", '#').append(10);
            extendedAppendable.append((CharSequence) "renew-entitycaps-requested: ").append(this.renewEntityCapsRequested).append(10);
            extendedAppendable.append((CharSequence) "renew-entitycaps-performed: ").append(this.renewEntityCapsPerformed).append(10);
            extendedAppendable.append((CharSequence) "scheduled-renew-entitycaps-avoided: ").append(this.scheduledRenewEntityCapsAvoided).append(10);
        }

        private Stats(ServiceDiscoveryManager serviceDiscoveryManager) {
            this.renewEntityCapsRequested = serviceDiscoveryManager.renewEntityCapsRequested;
            this.renewEntityCapsPerformed = serviceDiscoveryManager.renewEntityCapsPerformed.get();
            this.scheduledRenewEntityCapsAvoided = serviceDiscoveryManager.scheduledRenewEntityCapsAvoided;
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private ServiceDiscoveryManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        addFeature(DiscoverInfo.NAMESPACE);
        addFeature(DiscoverItems.NAMESPACE);
        IQ.Type type = IQ.Type.get;
        IQRequestHandler.Mode mode = IQRequestHandler.Mode.async;
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverItems.NAMESPACE, type, mode) {
            public IQ handleIQRequest(IQ iq) {
                DiscoverItems discoverItems = (DiscoverItems) iq;
                DiscoverItems discoverItems2 = new DiscoverItems();
                discoverItems2.setType(IQ.Type.result);
                discoverItems2.setTo(discoverItems.getFrom());
                discoverItems2.setStanzaId(discoverItems.getStanzaId());
                discoverItems2.setNode(discoverItems.getNode());
                NodeInformationProvider access$000 = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverItems.getNode());
                if (access$000 != null) {
                    discoverItems2.addItems(access$000.getNodeItems());
                    discoverItems2.addExtensions(access$000.getNodePacketExtensions());
                } else if (discoverItems.getNode() != null) {
                    discoverItems2.setType(IQ.Type.error);
                    discoverItems2.setError(StanzaError.getBuilder(StanzaError.Condition.item_not_found).build());
                }
                return discoverItems2;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverInfo.NAMESPACE, type, mode) {
            public IQ handleIQRequest(IQ iq) {
                DiscoverInfo discoverInfo = (DiscoverInfo) iq;
                DiscoverInfoBuilder buildResponseFor = DiscoverInfoBuilder.buildResponseFor(discoverInfo, IQ.ResponseType.result);
                if (discoverInfo.getNode() == null) {
                    ServiceDiscoveryManager.this.addDiscoverInfoTo(buildResponseFor);
                } else {
                    NodeInformationProvider access$000 = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverInfo.getNode());
                    if (access$000 != null) {
                        buildResponseFor.addFeatures(access$000.getNodeFeatures());
                        buildResponseFor.addIdentities(access$000.getNodeIdentities());
                        buildResponseFor.addOptExtensions(access$000.getNodePacketExtensions());
                    } else {
                        buildResponseFor.ofType(IQ.Type.error);
                        buildResponseFor.setError(StanzaError.getBuilder(StanzaError.Condition.item_not_found).build());
                    }
                }
                return buildResponseFor.build();
            }
        });
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10) {
                    Presence unused = ServiceDiscoveryManager.this.presenceSend = null;
                }
            }
        });
        xMPPConnection.addStanzaSendingListener(new a(this), PresenceTypeFilter.OUTGOING_PRESENCE_BROADCAST);
    }

    public static void addDiscoInfoLookupShortcutMechanism(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            list.add(discoInfoLookupShortcutMechanism);
            Collections.sort(list);
        }
    }

    public static synchronized ServiceDiscoveryManager getInstanceFor(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager serviceDiscoveryManager;
        synchronized (ServiceDiscoveryManager.class) {
            Map<XMPPConnection, ServiceDiscoveryManager> map = instances;
            serviceDiscoveryManager = map.get(xMPPConnection);
            if (serviceDiscoveryManager == null) {
                serviceDiscoveryManager = new ServiceDiscoveryManager(xMPPConnection);
                map.put(xMPPConnection, serviceDiscoveryManager);
            }
        }
        return serviceDiscoveryManager;
    }

    /* access modifiers changed from: private */
    public NodeInformationProvider getNodeInformationProvider(String str) {
        if (str == null) {
            return null;
        }
        return this.nodeInformationProviders.get(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        this.presenceSend = (Presence) stanza;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$renewEntityCapsVersion$1(XMPPConnection xMPPConnection) {
        this.renewEntityCapsPerformed.incrementAndGet();
        DiscoverInfoBuilder discoverInfoBuilder = (DiscoverInfoBuilder) DiscoverInfo.builder("synthetized-disco-info-response").ofType(IQ.Type.result);
        addDiscoverInfoTo(discoverInfoBuilder);
        DiscoverInfo build = discoverInfoBuilder.build();
        for (EntityCapabilitiesChangedListener onEntityCapabilitiesChanged : this.entityCapabilitiesChangedListeners) {
            onEntityCapabilitiesChanged.onEntityCapabilitiesChanged(build);
        }
        Presence presence = this.presenceSend;
        if (xMPPConnection.isAuthenticated() && presence != null) {
            try {
                xMPPConnection.sendStanza(presence.asBuilder(xMPPConnection).build());
            } catch (InterruptedException | SmackException.NotConnectedException e10) {
                LOGGER.log(Level.WARNING, "Could could not update presence with caps info", e10);
            }
        }
    }

    public static void removeDiscoInfoLookupShortcutMechanism(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            list.remove(discoInfoLookupShortcutMechanism);
        }
    }

    private synchronized void renewEntityCapsVersion() {
        this.renewEntityCapsRequested++;
        ScheduledAction scheduledAction = this.renewEntityCapsScheduledAction;
        if (scheduledAction != null && scheduledAction.cancel()) {
            this.scheduledRenewEntityCapsAvoided++;
        }
        this.renewEntityCapsScheduledAction = Manager.scheduleBlocking(new b(this, connection()), 25, TimeUnit.MILLISECONDS);
    }

    public static void setDefaultIdentity(DiscoverInfo.Identity identity2) {
        defaultIdentity = identity2;
    }

    public boolean accountSupportsFeatures(CharSequence... charSequenceArr) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return accountSupportsFeatures((Collection<? extends CharSequence>) Arrays.asList(charSequenceArr));
    }

    public synchronized void addDiscoverInfoTo(DiscoverInfoBuilder discoverInfoBuilder) {
        discoverInfoBuilder.addIdentities(getIdentities());
        for (String addFeature : getFeatures()) {
            discoverInfoBuilder.addFeature(addFeature);
        }
        discoverInfoBuilder.addExtensions(this.extendedInfos);
    }

    public boolean addEntityCapabilitiesChangedListener(EntityCapabilitiesChangedListener entityCapabilitiesChangedListener) {
        return this.entityCapabilitiesChangedListeners.add(entityCapabilitiesChangedListener);
    }

    public DataForm addExtendedInfo(DataForm dataForm) {
        DataForm remove;
        String formType = dataForm.getFormType();
        StringUtils.requireNotNullNorEmpty(formType, "The data form must have a form type set");
        synchronized (this) {
            remove = DataForm.remove(this.extendedInfos, formType);
            this.extendedInfos.add(dataForm);
            renewEntityCapsVersion();
        }
        return remove;
    }

    public synchronized void addFeature(String str) {
        this.features.add(str);
        renewEntityCapsVersion();
    }

    public synchronized void addIdentity(DiscoverInfo.Identity identity2) {
        this.identities.add(identity2);
        renewEntityCapsVersion();
    }

    public DiscoverInfo discoverInfo(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (jid == null) {
            return discoverInfo((Jid) null, (String) null);
        }
        List<DiscoInfoLookupShortcutMechanism> list = discoInfoLookupShortcutMechanisms;
        synchronized (list) {
            for (DiscoInfoLookupShortcutMechanism discoverInfoByUser : list) {
                DiscoverInfo discoverInfoByUser2 = discoverInfoByUser.getDiscoverInfoByUser(this, jid);
                if (discoverInfoByUser2 != null) {
                    return discoverInfoByUser2;
                }
            }
            return discoverInfo(jid, (String) null);
        }
    }

    public DiscoverItems discoverItems(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return discoverItems(jid, (String) null);
    }

    public DomainBareJid findService(String str, boolean z10, String str2, String str3) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        boolean isNullOrEmpty = StringUtils.isNullOrEmpty((CharSequence) str2);
        boolean isNullOrEmpty2 = StringUtils.isNullOrEmpty((CharSequence) str3);
        if (isNullOrEmpty2 == isNullOrEmpty) {
            List<DiscoverInfo> findServicesDiscoverInfo = findServicesDiscoverInfo(str, false, z10);
            if (findServicesDiscoverInfo.isEmpty()) {
                return null;
            }
            if (!isNullOrEmpty && !isNullOrEmpty2) {
                for (DiscoverInfo next : findServicesDiscoverInfo) {
                    if (next.hasIdentity(str2, str3)) {
                        return next.getFrom().R0();
                    }
                }
            }
            return findServicesDiscoverInfo.get(0).getFrom().R0();
        }
        throw new IllegalArgumentException("Must specify either both, category and type, or none");
    }

    public List<DomainBareJid> findServices(String str, boolean z10, boolean z11) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<DiscoverInfo> findServicesDiscoverInfo = findServicesDiscoverInfo(str, z10, z11);
        ArrayList arrayList = new ArrayList(findServicesDiscoverInfo.size());
        for (DiscoverInfo from : findServicesDiscoverInfo) {
            arrayList.add(from.getFrom().R0());
        }
        return arrayList;
    }

    public List<DiscoverInfo> findServicesDiscoverInfo(String str, boolean z10, boolean z11) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return findServicesDiscoverInfo(str, z10, z11, (Map<? super Jid, Exception>) null);
    }

    public synchronized List<DataForm> getExtendedInfo() {
        return CollectionUtil.newListWith(this.extendedInfos);
    }

    @Deprecated
    public List<DataForm> getExtendedInfoAsList() {
        return getExtendedInfo();
    }

    public synchronized List<String> getFeatures() {
        return new ArrayList(this.features);
    }

    public Set<DiscoverInfo.Identity> getIdentities() {
        HashSet hashSet = new HashSet(this.identities);
        hashSet.add(this.identity);
        return Collections.unmodifiableSet(hashSet);
    }

    public DiscoverInfo.Identity getIdentity() {
        return this.identity;
    }

    public String getIdentityName() {
        return this.identity.getName();
    }

    public String getIdentityType() {
        return this.identity.getType();
    }

    public synchronized Stats getStats() {
        return new Stats();
    }

    public synchronized boolean includesFeature(String str) {
        return this.features.contains(str);
    }

    public synchronized void removeExtendedInfo(String str) {
        if (DataForm.remove(this.extendedInfos, str) != null) {
            renewEntityCapsVersion();
        }
    }

    public synchronized void removeFeature(String str) {
        this.features.remove(str);
        renewEntityCapsVersion();
    }

    public synchronized boolean removeIdentity(DiscoverInfo.Identity identity2) {
        if (identity2.equals(this.identity)) {
            return false;
        }
        this.identities.remove(identity2);
        renewEntityCapsVersion();
        return true;
    }

    public void removeNodeInformationProvider(String str) {
        this.nodeInformationProviders.remove(str);
    }

    public boolean serverSupportsFeature(CharSequence charSequence) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return serverSupportsFeatures(charSequence);
    }

    public boolean serverSupportsFeatures(CharSequence... charSequenceArr) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return serverSupportsFeatures((Collection<? extends CharSequence>) Arrays.asList(charSequenceArr));
    }

    @Deprecated
    public synchronized void setExtendedInfo(DataForm dataForm) {
        addExtendedInfo(dataForm);
    }

    public synchronized void setIdentity(DiscoverInfo.Identity identity2) {
        this.identity = (DiscoverInfo.Identity) Objects.requireNonNull(identity2, "Identity can not be null");
        renewEntityCapsVersion();
    }

    public void setNodeInformationProvider(String str, NodeInformationProvider nodeInformationProvider) {
        this.nodeInformationProviders.put(str, nodeInformationProvider);
    }

    public boolean supportsFeature(Jid jid, CharSequence charSequence) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return supportsFeatures(jid, charSequence);
    }

    public boolean supportsFeatures(Jid jid, CharSequence... charSequenceArr) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return supportsFeatures(jid, (Collection<? extends CharSequence>) Arrays.asList(charSequenceArr));
    }

    public boolean accountSupportsFeatures(Collection<? extends CharSequence> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return supportsFeatures((Jid) connection().getUser().E0(), collection);
    }

    public DiscoverItems discoverItems(Jid jid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setType(IQ.Type.get);
        discoverItems.setTo(jid);
        discoverItems.setNode(str);
        return (DiscoverItems) connection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public List<DiscoverInfo> findServicesDiscoverInfo(String str, boolean z10, boolean z11, Map<? super Jid, Exception> map) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return findServicesDiscoverInfo(connection().getXMPPServiceDomain(), str, z10, z11, map);
    }

    public boolean serverSupportsFeatures(Collection<? extends CharSequence> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return supportsFeatures((Jid) connection().getXMPPServiceDomain(), collection);
    }

    public boolean supportsFeatures(Jid jid, Collection<? extends CharSequence> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DiscoverInfo discoverInfo = discoverInfo(jid);
        for (CharSequence containsFeature : collection) {
            if (!discoverInfo.containsFeature(containsFeature)) {
                return false;
            }
        }
        return true;
    }

    public List<DiscoverInfo> findServicesDiscoverInfo(DomainBareJid domainBareJid, String str, boolean z10, boolean z11, Map<? super Jid, Exception> map) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<DiscoverInfo> a10;
        if (z11 && (a10 = this.services.a(str)) != null) {
            return a10;
        }
        LinkedList linkedList = new LinkedList();
        try {
            DiscoverInfo discoverInfo = discoverInfo(domainBareJid);
            if (discoverInfo.containsFeature(str)) {
                linkedList.add(discoverInfo);
                if (z10) {
                    if (z11) {
                        this.services.put(str, linkedList);
                    }
                    return linkedList;
                }
            }
            try {
                for (DiscoverItems.Item entityID : discoverItems(domainBareJid).getItems()) {
                    Jid entityID2 = entityID.getEntityID();
                    try {
                        DiscoverInfo discoverInfo2 = discoverInfo(entityID2);
                        if (discoverInfo2.containsFeature(str)) {
                            linkedList.add(discoverInfo2);
                            if (z10) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException e10) {
                        if (map != null) {
                            map.put(entityID2, e10);
                        }
                    }
                }
                if (z11) {
                    this.services.put(str, linkedList);
                }
                return linkedList;
            } catch (XMPPException.XMPPErrorException e11) {
                if (map != null) {
                    map.put(domainBareJid, e11);
                }
                return linkedList;
            }
        } catch (XMPPException.XMPPErrorException e12) {
            if (map != null) {
                map.put(domainBareJid, e12);
            }
            return linkedList;
        }
    }

    public synchronized void removeExtendedInfo() {
        int size = this.extendedInfos.size();
        this.extendedInfos.clear();
        if (size > 0) {
            renewEntityCapsVersion();
        }
    }

    public DiscoverInfo discoverInfo(Jid jid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        return (DiscoverInfo) connection.createStanzaCollectorAndSend(((DiscoverInfoBuilder) DiscoverInfo.builder(connection).to(jid)).setNode(str).build()).nextResultOrThrow();
    }

    public DomainBareJid findService(String str, boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return findService(str, z10, (String) null, (String) null);
    }
}
