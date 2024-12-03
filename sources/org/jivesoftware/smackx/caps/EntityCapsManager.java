package org.jivesoftware.smackx.caps;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractPresenceEventListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.DiscoInfoLookupShortcutMechanism;
import org.jivesoftware.smackx.disco.EntityCapabilitiesChangedListener;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoView;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

public final class EntityCapsManager extends Manager {
    static final LruCache<String, DiscoverInfo> CAPS_CACHE = new LruCache<>(1000);
    private static String DEFAULT_ENTITY_NODE = SmackConfiguration.SMACK_URL_STRING;
    private static final String DEFAULT_HASH = "SHA-1";
    public static final String ELEMENT = "c";
    static final LruCache<Jid, NodeVerHash> JID_TO_NODEVER_CACHE = new LruCache<>(10000);
    public static final String NAMESPACE = "http://jabber.org/protocol/caps";
    private static final StanzaFilter PRESENCES_WITH_CAPS = new AndFilter(new StanzaTypeFilter(Presence.class), new StanzaExtensionFilter("c", "http://jabber.org/protocol/caps"));
    private static final Map<String, MessageDigest> SUPPORTED_HASHES;
    private static boolean autoEnableEntityCaps = true;
    private static final Map<XMPPConnection, EntityCapsManager> instances = new WeakHashMap();
    protected static EntityCapsPersistentCache persistentCache;
    private CapsVersionAndHash currentCapsVersion;
    private boolean entityCapsEnabled;
    private String entityNode = DEFAULT_ENTITY_NODE;
    private final Queue<CapsVersionAndHash> lastLocalCapsVersions = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public final ServiceDiscoveryManager sdm;

    public static class NodeVerHash {
        private String hash;
        private String node;
        /* access modifiers changed from: private */
        public String nodeVer;
        private String ver;

        NodeVerHash(String str, CapsVersionAndHash capsVersionAndHash) {
            this(str, capsVersionAndHash.version, capsVersionAndHash.hash);
        }

        public String getHash() {
            return this.hash;
        }

        public String getNode() {
            return this.node;
        }

        public String getNodeVer() {
            return this.nodeVer;
        }

        public String getVer() {
            return this.ver;
        }

        NodeVerHash(String str, String str2, String str3) {
            this.node = str;
            this.ver = str2;
            this.hash = str3;
            this.nodeVer = str + "#" + str2;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        SUPPORTED_HASHES = hashMap;
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                EntityCapsManager.getInstanceFor(xMPPConnection);
            }
        });
        try {
            hashMap.put("SHA-1", MessageDigest.getInstance("SHA-1"));
        } catch (NoSuchAlgorithmException unused) {
        }
        ServiceDiscoveryManager.addDiscoInfoLookupShortcutMechanism(new DiscoInfoLookupShortcutMechanism("XEP-0115: Entity Capabilities", 100) {
            public DiscoverInfo getDiscoverInfoByUser(ServiceDiscoveryManager serviceDiscoveryManager, Jid jid) {
                DiscoverInfo discoverInfoByUser = EntityCapsManager.getDiscoverInfoByUser(jid);
                if (discoverInfoByUser != null) {
                    return discoverInfoByUser;
                }
                NodeVerHash nodeVerHashByJid = EntityCapsManager.getNodeVerHashByJid(jid);
                if (nodeVerHashByJid == null) {
                    return null;
                }
                try {
                    DiscoverInfo discoverInfo = serviceDiscoveryManager.discoverInfo(jid, nodeVerHashByJid.getNodeVer());
                    if (EntityCapsManager.verifyDiscoverInfoVersion(nodeVerHashByJid.getVer(), nodeVerHashByJid.getHash(), discoverInfo)) {
                        EntityCapsManager.addDiscoverInfoByNode(nodeVerHashByJid.getNodeVer(), discoverInfo);
                    }
                    return discoverInfo;
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException unused) {
                    return null;
                }
            }
        });
    }

    private EntityCapsManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.sdm = instanceFor;
        instances.put(xMPPConnection, this);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            private void processCapsStreamFeatureIfAvailable(XMPPConnection xMPPConnection) {
                CapsExtension capsExtension = (CapsExtension) xMPPConnection.getFeature(CapsExtension.class);
                if (capsExtension != null) {
                    EntityCapsManager.addCapsExtensionInfo(xMPPConnection.getXMPPServiceDomain(), capsExtension);
                }
            }

            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                processCapsStreamFeatureIfAvailable(xMPPConnection);
            }

            public void connected(XMPPConnection xMPPConnection) {
                processCapsStreamFeatureIfAvailable(xMPPConnection);
            }
        });
        if (autoEnableEntityCaps) {
            enableEntityCaps();
        }
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                if (EntityCapsManager.this.entityCapsEnabled()) {
                    EntityCapsManager.addCapsExtensionInfo(stanza.getFrom(), CapsExtension.from(stanza));
                }
            }
        }, PRESENCES_WITH_CAPS);
        Roster.getInstanceFor(xMPPConnection).addPresenceEventListener(new AbstractPresenceEventListener() {
            public void presenceUnavailable(FullJid fullJid, Presence presence) {
                EntityCapsManager.JID_TO_NODEVER_CACHE.remove(fullJid);
            }
        });
        instanceFor.addEntityCapabilitiesChangedListener(new EntityCapabilitiesChangedListener() {
            public void onEntityCapabilitiesChanged(DiscoverInfo discoverInfo) {
                if (EntityCapsManager.this.entityCapsEnabled()) {
                    EntityCapsManager.this.updateLocalEntityCaps(discoverInfo);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void addCapsExtension(PresenceBuilder presenceBuilder) {
        CapsVersionAndHash capsVersionAndHash = getCapsVersionAndHash();
        if (capsVersionAndHash != null) {
            presenceBuilder.overrideExtension(new CapsExtension(this.entityNode, capsVersionAndHash.version, capsVersionAndHash.hash));
        }
    }

    /* access modifiers changed from: private */
    public static void addCapsExtensionInfo(Jid jid, CapsExtension capsExtension) {
        String hash = capsExtension.getHash();
        Locale locale = Locale.US;
        if (SUPPORTED_HASHES.containsKey(hash.toUpperCase(locale))) {
            String lowerCase = hash.toLowerCase(locale);
            JID_TO_NODEVER_CACHE.put(jid, new NodeVerHash(capsExtension.getNode(), capsExtension.getVer(), lowerCase));
        }
    }

    static void addDiscoverInfoByNode(String str, DiscoverInfo discoverInfo) {
        CAPS_CACHE.put(str, discoverInfo);
        EntityCapsPersistentCache entityCapsPersistentCache = persistentCache;
        if (entityCapsPersistentCache != null) {
            entityCapsPersistentCache.addDiscoverInfoByNodePersistent(str, discoverInfo);
        }
    }

    public static void clearMemoryCache() {
        JID_TO_NODEVER_CACHE.clear();
        CAPS_CACHE.clear();
    }

    private static void formFieldValuesToCaps(List<? extends CharSequence> list, StringBuilder sb2) {
        TreeSet<CharSequence> treeSet = new TreeSet<>();
        treeSet.addAll(list);
        for (CharSequence append : treeSet) {
            sb2.append(append);
            sb2.append('<');
        }
    }

    protected static CapsVersionAndHash generateVerificationString(DiscoverInfoView discoverInfoView) {
        return generateVerificationString(discoverInfoView, (String) null);
    }

    public static DiscoverInfo getDiscoverInfoByUser(Jid jid) {
        NodeVerHash a10 = JID_TO_NODEVER_CACHE.a(jid);
        if (a10 == null) {
            return null;
        }
        return getDiscoveryInfoByNodeVer(a10.nodeVer);
    }

    public static DiscoverInfo getDiscoveryInfoByNodeVer(String str) {
        EntityCapsPersistentCache entityCapsPersistentCache;
        LruCache<String, DiscoverInfo> lruCache = CAPS_CACHE;
        DiscoverInfo a10 = lruCache.a(str);
        if (!(a10 != null || (entityCapsPersistentCache = persistentCache) == null || (a10 = entityCapsPersistentCache.lookup(str)) == null)) {
            lruCache.put(str, a10);
        }
        if (a10 != null) {
            return new DiscoverInfo(a10);
        }
        return a10;
    }

    public static synchronized EntityCapsManager getInstanceFor(XMPPConnection xMPPConnection) {
        EntityCapsManager entityCapsManager;
        synchronized (EntityCapsManager.class) {
            if (SUPPORTED_HASHES.size() > 0) {
                entityCapsManager = instances.get(xMPPConnection);
                if (entityCapsManager == null) {
                    entityCapsManager = new EntityCapsManager(xMPPConnection);
                }
            } else {
                throw new IllegalStateException("No supported hashes for EntityCapsManager");
            }
        }
        return entityCapsManager;
    }

    public static NodeVerHash getNodeVerHashByJid(Jid jid) {
        return JID_TO_NODEVER_CACHE.a(jid);
    }

    public static String getNodeVersionByJid(Jid jid) {
        NodeVerHash a10 = JID_TO_NODEVER_CACHE.a(jid);
        if (a10 != null) {
            return a10.nodeVer;
        }
        return null;
    }

    public static void removeUserCapsNode(Jid jid) {
        JID_TO_NODEVER_CACHE.remove(jid);
    }

    public static void setDefaultEntityNode(String str) {
        DEFAULT_ENTITY_NODE = str;
    }

    public static void setMaxsCacheSizes(int i10, int i11) {
        JID_TO_NODEVER_CACHE.b(i10);
        CAPS_CACHE.b(i11);
    }

    public static void setPersistentCache(EntityCapsPersistentCache entityCapsPersistentCache) {
        persistentCache = entityCapsPersistentCache;
    }

    /* access modifiers changed from: private */
    public void updateLocalEntityCaps(DiscoverInfo discoverInfo) {
        XMPPConnection connection = connection();
        DiscoverInfoBuilder asBuilder = discoverInfo.asBuilder("synthesized-disco-info-result");
        this.currentCapsVersion = generateVerificationString(asBuilder);
        String localNodeVer = getLocalNodeVer();
        asBuilder.setNode(localNodeVer);
        addDiscoverInfoByNode(localNodeVer, asBuilder.build());
        if (this.lastLocalCapsVersions.size() > 10) {
            ServiceDiscoveryManager serviceDiscoveryManager = this.sdm;
            serviceDiscoveryManager.removeNodeInformationProvider(this.entityNode + '#' + this.lastLocalCapsVersions.poll().version);
        }
        this.lastLocalCapsVersions.add(this.currentCapsVersion);
        if (connection != null) {
            JID_TO_NODEVER_CACHE.put(connection.getUser(), new NodeVerHash(this.entityNode, this.currentCapsVersion));
        }
        final LinkedList linkedList = new LinkedList(ServiceDiscoveryManager.getInstanceFor(connection).getIdentities());
        this.sdm.setNodeInformationProvider(localNodeVer, new AbstractNodeInformationProvider() {
            List<String> features;
            List<DataForm> packetExtensions;

            {
                this.features = EntityCapsManager.this.sdm.getFeatures();
                this.packetExtensions = EntityCapsManager.this.sdm.getExtendedInfo();
            }

            public List<String> getNodeFeatures() {
                return this.features;
            }

            public List<DiscoverInfo.Identity> getNodeIdentities() {
                return linkedList;
            }

            public List<DataForm> getNodePacketExtensions() {
                return this.packetExtensions;
            }
        });
    }

    public static boolean verifyDiscoverInfoVersion(String str, String str2, DiscoverInfo discoverInfo) {
        if (!discoverInfo.containsDuplicateIdentities() && !discoverInfo.containsDuplicateFeatures() && verifyPacketExtensions(discoverInfo) && str.equals(generateVerificationString(discoverInfo, str2).version)) {
            return true;
        }
        return false;
    }

    private static boolean verifyPacketExtensions(DiscoverInfo discoverInfo) {
        HashSet hashSet = new HashSet();
        for (E hiddenFormTypeField : discoverInfo.getExtensions(DataForm.class)) {
            TextSingleFormField hiddenFormTypeField2 = hiddenFormTypeField.getHiddenFormTypeField();
            if (hiddenFormTypeField2 != null && !hashSet.add(hiddenFormTypeField2.getFirstValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean areEntityCapsSupported(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.sdm.supportsFeature(jid, "http://jabber.org/protocol/caps");
    }

    public boolean areEntityCapsSupportedByServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return areEntityCapsSupported(connection().getXMPPServiceDomain());
    }

    public synchronized void disableEntityCaps() {
        this.entityCapsEnabled = false;
        this.sdm.removeFeature("http://jabber.org/protocol/caps");
        connection().removePresenceInterceptor(new a(this));
    }

    public synchronized void enableEntityCaps() {
        connection().addPresenceInterceptor(new a(this), new b());
        this.sdm.addFeature("http://jabber.org/protocol/caps");
        this.entityCapsEnabled = true;
    }

    public boolean entityCapsEnabled() {
        return this.entityCapsEnabled;
    }

    public CapsVersionAndHash getCapsVersionAndHash() {
        return this.currentCapsVersion;
    }

    public String getLocalNodeVer() {
        CapsVersionAndHash capsVersionAndHash = getCapsVersionAndHash();
        if (capsVersionAndHash == null) {
            return null;
        }
        return this.entityNode + '#' + capsVersionAndHash.version;
    }

    protected static CapsVersionAndHash generateVerificationString(DiscoverInfoView discoverInfoView, String str) {
        byte[] digest;
        if (str == null) {
            str = "SHA-1";
        }
        Map<String, MessageDigest> map = SUPPORTED_HASHES;
        Locale locale = Locale.US;
        MessageDigest messageDigest = map.get(str.toUpperCase(locale));
        if (messageDigest == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(locale);
        StringBuilder sb2 = new StringBuilder();
        TreeSet<DiscoverInfo.Identity> treeSet = new TreeSet<>();
        treeSet.addAll(discoverInfoView.getIdentities());
        for (DiscoverInfo.Identity identity : treeSet) {
            sb2.append(identity.getCategory());
            sb2.append('/');
            sb2.append(identity.getType());
            sb2.append('/');
            sb2.append(identity.getLanguage() == null ? "" : identity.getLanguage());
            sb2.append('/');
            sb2.append(identity.getName() == null ? "" : identity.getName());
            sb2.append('<');
        }
        TreeSet<String> treeSet2 = new TreeSet<>();
        for (DiscoverInfo.Feature var : discoverInfoView.getFeatures()) {
            treeSet2.add(var.getVar());
        }
        for (String append : treeSet2) {
            sb2.append(append);
            sb2.append('<');
        }
        for (E e10 : discoverInfoView.getExtensions(DataForm.class)) {
            if (e10.hasHiddenFormTypeField()) {
                TreeSet<FormField> treeSet3 = new TreeSet<>(new Comparator<FormField>() {
                    public int compare(FormField formField, FormField formField2) {
                        return formField.getFieldName().compareTo(formField2.getFieldName());
                    }
                });
                for (FormField next : e10.getFields()) {
                    if (!next.getFieldName().equals(FormField.FORM_TYPE)) {
                        treeSet3.add(next);
                    }
                }
                formFieldValuesToCaps(Collections.singletonList(e10.getFormType()), sb2);
                for (FormField formField : treeSet3) {
                    sb2.append(formField.getFieldName());
                    sb2.append('<');
                    formFieldValuesToCaps(formField.getRawValueCharSequences(), sb2);
                }
            }
        }
        byte[] bytes = sb2.toString().getBytes(StandardCharsets.UTF_8);
        synchronized (messageDigest) {
            digest = messageDigest.digest(bytes);
        }
        return new CapsVersionAndHash(Base64.encodeToString(digest), lowerCase);
    }
}
