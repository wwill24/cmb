package org.jivesoftware.smackx.muc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import mm.b;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CleaningWeakReferenceMap;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public final class MultiUserChatManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<MucMessageInterceptor> DEFAULT_MESSAGE_INTERCEPTORS = new HashSet();
    private static final String DISCO_NODE = "http://jabber.org/protocol/muc#rooms";
    private static final Map<XMPPConnection, MultiUserChatManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter INVITATION_FILTER = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter((ExtensionElement) new MUCUser()), new NotFilter(MessageTypeFilter.ERROR));
    private static final b<DomainBareJid, DiscoverInfo> KNOWN_MUC_SERVICES = new b<>(100, 86400000);
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(MultiUserChatManager.class.getName());
    /* access modifiers changed from: private */
    public AutoJoinFailedCallback autoJoinFailedCallback;
    /* access modifiers changed from: private */
    public boolean autoJoinOnReconnect;
    /* access modifiers changed from: private */
    public AutoJoinSuccessCallback autoJoinSuccessCallback;
    /* access modifiers changed from: private */
    public final Set<InvitationListener> invitationsListeners = new CopyOnWriteArraySet();
    private final Set<EntityBareJid> joinedRooms = new CopyOnWriteArraySet();
    private final Map<EntityBareJid, WeakReference<MultiUserChat>> multiUserChats = new CleaningWeakReferenceMap();
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/muc");
                final WeakReference weakReference = new WeakReference(xMPPConnection);
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider(MultiUserChatManager.DISCO_NODE, new AbstractNodeInformationProvider() {
                    public List<DiscoverItems.Item> getNodeItems() {
                        XMPPConnection xMPPConnection = (XMPPConnection) weakReference.get();
                        if (xMPPConnection == null) {
                            return Collections.emptyList();
                        }
                        Set<EntityBareJid> joinedRooms = MultiUserChatManager.getInstanceFor(xMPPConnection).getJoinedRooms();
                        ArrayList arrayList = new ArrayList();
                        for (EntityBareJid item : joinedRooms) {
                            arrayList.add(new DiscoverItems.Item(item));
                        }
                        return arrayList;
                    }
                });
            }
        });
    }

    private MultiUserChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                MUCUser from = MUCUser.from(message);
                if (from.getInvite() != null) {
                    EntityBareJid h12 = message.getFrom().h1();
                    if (h12 == null) {
                        Logger access$000 = MultiUserChatManager.LOGGER;
                        access$000.warning("Invite to non bare JID: '" + message.toXML() + "'");
                        return;
                    }
                    MultiUserChat multiUserChat = MultiUserChatManager.this.getMultiUserChat(h12);
                    XMPPConnection access$100 = MultiUserChatManager.this.connection();
                    MUCUser.Invite invite = from.getInvite();
                    EntityJid from2 = invite.getFrom();
                    String reason = invite.getReason();
                    String password = from.getPassword();
                    for (InvitationListener invitationReceived : MultiUserChatManager.this.invitationsListeners) {
                        invitationReceived.invitationReceived(access$100, multiUserChat, from2, reason, password, message, invite);
                    }
                }
            }
        }, INVITATION_FILTER);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10 && MultiUserChatManager.this.autoJoinOnReconnect) {
                    final Set<EntityBareJid> joinedRooms = MultiUserChatManager.this.getJoinedRooms();
                    if (!joinedRooms.isEmpty()) {
                        Async.go(new Runnable() {
                            public void run() {
                                Resourcepart nickname;
                                AutoJoinFailedCallback access$400 = MultiUserChatManager.this.autoJoinFailedCallback;
                                AutoJoinSuccessCallback access$500 = MultiUserChatManager.this.autoJoinSuccessCallback;
                                for (EntityBareJid multiUserChat : joinedRooms) {
                                    MultiUserChat multiUserChat2 = MultiUserChatManager.this.getMultiUserChat(multiUserChat);
                                    if (multiUserChat2.isJoined() && (nickname = multiUserChat2.getNickname()) != null) {
                                        try {
                                            multiUserChat2.leave();
                                            try {
                                                multiUserChat2.join(nickname);
                                                if (access$500 != null) {
                                                    access$500.autoJoinSuccess(multiUserChat2, nickname);
                                                }
                                            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException | MultiUserChatException.NotAMucServiceException e10) {
                                                if (access$400 != null) {
                                                    access$400.autoJoinFailed(multiUserChat2, e10);
                                                    return;
                                                } else {
                                                    MultiUserChatManager.LOGGER.log(Level.WARNING, "Could not leave room", e10);
                                                    return;
                                                }
                                            }
                                        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException | MultiUserChatException.MucNotJoinedException e11) {
                                            if (access$400 != null) {
                                                access$400.autoJoinFailed(multiUserChat2, e11);
                                                return;
                                            } else {
                                                MultiUserChatManager.LOGGER.log(Level.WARNING, "Could not leave room", e11);
                                                return;
                                            }
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public static boolean addDefaultMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        boolean add;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            add = set.add(mucMessageInterceptor);
        }
        return add;
    }

    private MultiUserChat createNewMucAndAddToMap(EntityBareJid entityBareJid) {
        MultiUserChat multiUserChat = new MultiUserChat(connection(), entityBareJid, this);
        this.multiUserChats.put(entityBareJid, new WeakReference(multiUserChat));
        return multiUserChat;
    }

    public static synchronized MultiUserChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        MultiUserChatManager multiUserChatManager;
        synchronized (MultiUserChatManager.class) {
            Map<XMPPConnection, MultiUserChatManager> map = INSTANCES;
            multiUserChatManager = map.get(xMPPConnection);
            if (multiUserChatManager == null) {
                multiUserChatManager = new MultiUserChatManager(xMPPConnection);
                map.put(xMPPConnection, multiUserChatManager);
            }
        }
        return multiUserChatManager;
    }

    static CopyOnWriteArrayList<MucMessageInterceptor> getMessageInterceptors() {
        CopyOnWriteArrayList<MucMessageInterceptor> copyOnWriteArrayList;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>(set);
        }
        return copyOnWriteArrayList;
    }

    public static boolean removeDefaultMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        boolean remove;
        Set<MucMessageInterceptor> set = DEFAULT_MESSAGE_INTERCEPTORS;
        synchronized (set) {
            remove = set.remove(mucMessageInterceptor);
        }
        return remove;
    }

    public void addInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.add(invitationListener);
    }

    /* access modifiers changed from: package-private */
    public void addJoinedRoom(EntityBareJid entityBareJid) {
        this.joinedRooms.add(entityBareJid);
    }

    public void decline(EntityBareJid entityBareJid, EntityBareJid entityBareJid2, String str) throws SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        MessageBuilder messageBuilder = (MessageBuilder) connection.getStanzaFactory().buildMessageStanza().to((Jid) entityBareJid);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setDecline(new MUCUser.Decline(str, entityBareJid2));
        messageBuilder.addExtension(mUCUser);
        connection.sendStanza(messageBuilder.build());
    }

    public Set<EntityBareJid> getJoinedRooms() {
        return Collections.unmodifiableSet(this.joinedRooms);
    }

    /* access modifiers changed from: package-private */
    public DiscoverInfo getMucServiceDiscoInfo(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        b<DomainBareJid, DiscoverInfo> bVar = KNOWN_MUC_SERVICES;
        DiscoverInfo discoverInfo = bVar.get(domainBareJid);
        if (discoverInfo != null) {
            return discoverInfo;
        }
        DiscoverInfo discoverInfo2 = this.serviceDiscoveryManager.discoverInfo(domainBareJid);
        if (!discoverInfo2.containsFeature("http://jabber.org/protocol/muc")) {
            return null;
        }
        bVar.put(domainBareJid, discoverInfo2);
        return discoverInfo2;
    }

    public List<DomainBareJid> getMucServiceDomains() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.findServices("http://jabber.org/protocol/muc", false, false);
    }

    public synchronized MultiUserChat getMultiUserChat(EntityBareJid entityBareJid) {
        WeakReference weakReference = this.multiUserChats.get(entityBareJid);
        if (weakReference == null) {
            return createNewMucAndAddToMap(entityBareJid);
        }
        MultiUserChat multiUserChat = (MultiUserChat) weakReference.get();
        if (multiUserChat != null) {
            return multiUserChat;
        }
        return createNewMucAndAddToMap(entityBareJid);
    }

    public RoomInfo getRoomInfo(EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return new RoomInfo(this.serviceDiscoveryManager.discoverInfo(entityBareJid));
    }

    public Map<EntityBareJid, HostedRoom> getRoomsHostedBy(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, MultiUserChatException.NotAMucServiceException {
        if (providesMucService(domainBareJid)) {
            List<DiscoverItems.Item> items = this.serviceDiscoveryManager.discoverItems(domainBareJid).getItems();
            HashMap hashMap = new HashMap(items.size());
            for (DiscoverItems.Item hostedRoom : items) {
                HostedRoom hostedRoom2 = new HostedRoom(hostedRoom);
                HostedRoom hostedRoom3 = (HostedRoom) hashMap.put(hostedRoom2.getJid(), hostedRoom2);
            }
            return hashMap;
        }
        throw new MultiUserChatException.NotAMucServiceException(domainBareJid);
    }

    @Deprecated
    public List<DomainBareJid> getXMPPServiceDomains() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getMucServiceDomains();
    }

    public boolean isServiceEnabled(Jid jid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "http://jabber.org/protocol/muc");
    }

    public boolean providesMucService(DomainBareJid domainBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getMucServiceDiscoInfo(domainBareJid) != null;
    }

    public void removeInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.remove(invitationListener);
    }

    /* access modifiers changed from: package-private */
    public void removeJoinedRoom(EntityBareJid entityBareJid) {
        this.joinedRooms.remove(entityBareJid);
    }

    public void setAutoJoinFailedCallback(AutoJoinFailedCallback autoJoinFailedCallback2) {
        this.autoJoinFailedCallback = autoJoinFailedCallback2;
        if (autoJoinFailedCallback2 != null) {
            setAutoJoinOnReconnect(true);
        }
    }

    public void setAutoJoinOnReconnect(boolean z10) {
        this.autoJoinOnReconnect = z10;
    }

    public void setAutoJoinSuccessCallback(AutoJoinSuccessCallback autoJoinSuccessCallback2) {
        this.autoJoinSuccessCallback = autoJoinSuccessCallback2;
        if (autoJoinSuccessCallback2 != null) {
            setAutoJoinOnReconnect(true);
        }
    }

    public List<EntityBareJid> getJoinedRooms(EntityFullJid entityFullJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<DiscoverItems.Item> items = this.serviceDiscoveryManager.discoverItems(entityFullJid, DISCO_NODE).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        for (DiscoverItems.Item next : items) {
            EntityBareJid h12 = next.getEntityID().h1();
            if (h12 == null) {
                Logger logger = LOGGER;
                logger.warning("Not a bare JID: " + next.getEntityID());
            } else {
                arrayList.add(h12);
            }
        }
        return arrayList;
    }
}
