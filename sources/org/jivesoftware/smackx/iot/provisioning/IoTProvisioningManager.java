package org.jivesoftware.smackx.iot.provisioning;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractPresenceEventListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.SubscribeListener;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCache;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCacheResponse;
import org.jivesoftware.smackx.iot.provisioning.element.Friend;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriend;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriendResponse;
import org.jivesoftware.smackx.iot.provisioning.element.Unfriend;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

public final class IoTProvisioningManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final StanzaFilter FRIEND_MESSAGE;
    private static final Map<XMPPConnection, IoTProvisioningManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(IoTProvisioningManager.class.getName());
    private static final StanzaFilter UNFRIEND_MESSAGE;
    /* access modifiers changed from: private */
    public final Set<BecameFriendListener> becameFriendListeners = new CopyOnWriteArraySet();
    private Jid configuredProvisioningServer;
    /* access modifiers changed from: private */
    public final LruCache<BareJid, Void> friendshipDeniedCache = new LruCache<>(16);
    /* access modifiers changed from: private */
    public final LruCache<BareJid, Void> friendshipRequestedCache = new LruCache<>(16);
    /* access modifiers changed from: private */
    public final LruCache<Jid, LruCache<BareJid, Void>> negativeFriendshipRequestCache = new LruCache<>(8);
    private final Roster roster;
    /* access modifiers changed from: private */
    public final Set<WasUnfriendedListener> wasUnfriendedListeners = new CopyOnWriteArraySet();

    static {
        StanzaTypeFilter stanzaTypeFilter = StanzaTypeFilter.MESSAGE;
        FRIEND_MESSAGE = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter(Friend.ELEMENT, "urn:xmpp:iot:provisioning"));
        UNFRIEND_MESSAGE = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter(Unfriend.ELEMENT, "urn:xmpp:iot:provisioning"));
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTProvisioningManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    private IoTProvisioningManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                if (IoTProvisioningManager.this.isFromProvisioningService(stanza, true)) {
                    BareJid jid = Unfriend.from((Message) stanza).getJid();
                    XMPPConnection access$100 = IoTProvisioningManager.this.connection();
                    if (!Roster.getInstanceFor(access$100).isSubscribedToMyPresence(jid)) {
                        Logger access$200 = IoTProvisioningManager.LOGGER;
                        access$200.warning("Ignoring <unfriend/> request '" + stanza + "' because " + jid + " is already not subscribed to our presence.");
                        return;
                    }
                    access$100.sendStanza(((PresenceBuilder) access$100.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unsubscribed).to((Jid) jid)).build());
                }
            }
        }, UNFRIEND_MESSAGE);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Message message = (Message) stanza;
                BareJid friend = Friend.from(message).getFriend();
                if (IoTProvisioningManager.this.isFromProvisioningService(message, false)) {
                    XMPPConnection access$300 = IoTProvisioningManager.this.connection();
                    access$300.sendStanza(((MessageBuilder) ((MessageBuilder) access$300.getStanzaFactory().buildMessageStanza().to((Jid) friend)).addExtension(new Friend(access$300.getUser().i1()))).build());
                    return;
                }
                BareJid i12 = message.getFrom().i1();
                if (!IoTProvisioningManager.this.friendshipDeniedCache.containsKey(i12)) {
                    Logger access$200 = IoTProvisioningManager.LOGGER;
                    Level level = Level.WARNING;
                    access$200.log(level, "Ignoring friendship recommendation " + message + " because friendship to this JID was not previously denied.");
                } else if (!i12.Y(friend)) {
                    Logger access$2002 = IoTProvisioningManager.LOGGER;
                    Level level2 = Level.WARNING;
                    access$2002.log(level2, "Ignoring friendship recommendation " + message + " because it does not recommend itself, but " + friend + '.');
                } else {
                    IoTProvisioningManager.this.sendFriendshipRequest(friend);
                }
            }
        }, FRIEND_MESSAGE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(ClearCache.ELEMENT, "urn:xmpp:iot:provisioning", IQ.Type.set, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                if (!IoTProvisioningManager.this.isFromProvisioningService(iq, true)) {
                    return null;
                }
                ClearCache clearCache = (ClearCache) iq;
                LruCache lruCache = (LruCache) IoTProvisioningManager.this.negativeFriendshipRequestCache.a(iq.getFrom());
                if (lruCache != null) {
                    lruCache.clear();
                }
                return new ClearCacheResponse(clearCache);
            }
        });
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        this.roster = instanceFor;
        instanceFor.addSubscribeListener(new SubscribeListener() {
            public SubscribeListener.SubscribeAnswer processSubscribe(Jid jid, Presence presence) {
                Jid jid2;
                try {
                    if (IoTDiscoveryManager.getInstanceFor(IoTProvisioningManager.this.connection()).isRegistry(jid.i1())) {
                        return SubscribeListener.SubscribeAnswer.Approve;
                    }
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                    Logger access$200 = IoTProvisioningManager.LOGGER;
                    Level level = Level.WARNING;
                    access$200.log(level, "Could not determine if " + jid + " is a registry", e10);
                }
                try {
                    jid2 = IoTProvisioningManager.this.getConfiguredProvisioningServer();
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e11) {
                    Logger access$2002 = IoTProvisioningManager.LOGGER;
                    Level level2 = Level.WARNING;
                    access$2002.log(level2, "Could not determine provisioning server. Ignoring friend request from " + jid, e11);
                    jid2 = null;
                }
                if (jid2 == null) {
                    return null;
                }
                try {
                    if (IoTProvisioningManager.this.isFriend(jid2, jid.i1())) {
                        return SubscribeListener.SubscribeAnswer.Approve;
                    }
                    return SubscribeListener.SubscribeAnswer.Deny;
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e12) {
                    Logger access$2003 = IoTProvisioningManager.LOGGER;
                    Level level3 = Level.WARNING;
                    access$2003.log(level3, "Could not determine if " + jid + " is a friend.", e12);
                    return null;
                }
            }
        });
        instanceFor.addPresenceEventListener(new AbstractPresenceEventListener() {
            public void presenceSubscribed(BareJid bareJid, Presence presence) {
                IoTProvisioningManager.this.friendshipRequestedCache.remove(bareJid);
                for (BecameFriendListener becameFriend : IoTProvisioningManager.this.becameFriendListeners) {
                    becameFriend.becameFriend(bareJid, presence);
                }
            }

            public void presenceUnsubscribed(BareJid bareJid, Presence presence) {
                if (IoTProvisioningManager.this.friendshipRequestedCache.containsKey(bareJid)) {
                    IoTProvisioningManager.this.friendshipDeniedCache.put(bareJid, null);
                }
                for (WasUnfriendedListener wasUnfriendedListener : IoTProvisioningManager.this.wasUnfriendedListeners) {
                    wasUnfriendedListener.wasUnfriendedListener(bareJid, presence);
                }
            }
        });
    }

    public static synchronized IoTProvisioningManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTProvisioningManager ioTProvisioningManager;
        synchronized (IoTProvisioningManager.class) {
            Map<XMPPConnection, IoTProvisioningManager> map = INSTANCES;
            ioTProvisioningManager = map.get(xMPPConnection);
            if (ioTProvisioningManager == null) {
                ioTProvisioningManager = new IoTProvisioningManager(xMPPConnection);
                map.put(xMPPConnection, ioTProvisioningManager);
            }
        }
        return ioTProvisioningManager;
    }

    /* access modifiers changed from: private */
    public boolean isFromProvisioningService(Stanza stanza, boolean z10) {
        try {
            Jid configuredProvisioningServer2 = getConfiguredProvisioningServer();
            if (configuredProvisioningServer2 == null) {
                if (z10) {
                    Logger logger = LOGGER;
                    logger.warning("Ignoring request '" + stanza + "' because no provisioning server configured.");
                }
                return false;
            } else if (configuredProvisioningServer2.Y(stanza.getFrom())) {
                return true;
            } else {
                if (z10) {
                    Logger logger2 = LOGGER;
                    logger2.warning("Ignoring  request '" + stanza + "' because not from provisioning server '" + configuredProvisioningServer2 + "'.");
                }
                return false;
            }
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
            LOGGER.log(Level.WARNING, "Could determine provisioning server", e10);
            return false;
        }
    }

    public boolean addBecameFriendListener(BecameFriendListener becameFriendListener) {
        return this.becameFriendListeners.add(becameFriendListener);
    }

    public boolean addWasUnfriendedListener(WasUnfriendedListener wasUnfriendedListener) {
        return this.wasUnfriendedListeners.add(wasUnfriendedListener);
    }

    public DomainBareJid findProvisioningServerComponent() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<DiscoverInfo> findServicesDiscoverInfo = ServiceDiscoveryManager.getInstanceFor(connection()).findServicesDiscoverInfo("urn:xmpp:iot:provisioning", true, true);
        if (findServicesDiscoverInfo.isEmpty()) {
            return null;
        }
        return findServicesDiscoverInfo.get(0).getFrom().R0();
    }

    public Jid getConfiguredProvisioningServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.configuredProvisioningServer == null) {
            this.configuredProvisioningServer = findProvisioningServerComponent();
        }
        return this.configuredProvisioningServer;
    }

    public boolean iAmFriendOf(BareJid bareJid) {
        return this.roster.iAmSubscribedTo(bareJid);
    }

    public boolean isFriend(Jid jid, BareJid bareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        LruCache a10 = this.negativeFriendshipRequestCache.a(jid);
        if (a10 != null && a10.containsKey(bareJid)) {
            return false;
        }
        IoTIsFriend ioTIsFriend = new IoTIsFriend(bareJid);
        ioTIsFriend.setTo(jid);
        boolean isFriendResult = ((IoTIsFriendResponse) connection().createStanzaCollectorAndSend(ioTIsFriend).nextResultOrThrow()).getIsFriendResult();
        if (!isFriendResult) {
            if (a10 == null) {
                a10 = new LruCache(1024);
                this.negativeFriendshipRequestCache.put(jid, a10);
            }
            a10.put(bareJid, null);
        }
        return isFriendResult;
    }

    public boolean isMyFriend(Jid jid) {
        return this.roster.isSubscribedToMyPresence(jid);
    }

    public boolean removeBecameFriendListener(BecameFriendListener becameFriendListener) {
        return this.becameFriendListeners.remove(becameFriendListener);
    }

    public boolean removeWasUnfriendedListener(WasUnfriendedListener wasUnfriendedListener) {
        return this.wasUnfriendedListeners.remove(wasUnfriendedListener);
    }

    public void sendFriendshipRequest(BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        Presence build = ((PresenceBuilder) connection().getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribe).to((Jid) bareJid)).build();
        this.friendshipRequestedCache.put(bareJid, null);
        connection().sendStanza(build);
    }

    public void sendFriendshipRequestIfRequired(BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        if (!iAmFriendOf(bareJid)) {
            sendFriendshipRequest(bareJid);
        }
    }

    public void setConfiguredProvisioningServer(Jid jid) {
        this.configuredProvisioningServer = jid;
    }

    public void unfriend(Jid jid) throws SmackException.NotConnectedException, InterruptedException {
        if (isMyFriend(jid)) {
            XMPPConnection connection = connection();
            connection.sendStanza(((PresenceBuilder) connection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unsubscribed).to(jid)).build());
        }
    }
}
