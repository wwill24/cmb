package org.jivesoftware.smackx.muc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PresenceListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.MessageWithSubjectFilter;
import org.jivesoftware.smack.filter.MessageWithThreadFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.PossibleFromTypeFilter;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.filter.ToMatchesFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jivesoftware.smackx.muc.MucEnterConfiguration;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.filter.MUCUserStatusCodeFilter;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCAdmin;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCOwner;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;

public class MultiUserChat {
    private static final StanzaFilter DECLINE_FILTER = new AndFilter(MessageTypeFilter.NORMAL, new StanzaExtensionFilter("x", MUCUser.NAMESPACE));
    private static final Logger LOGGER = Logger.getLogger(MultiUserChat.class.getName());
    private final XMPPConnection connection;
    private final StanzaListener declinesListener;
    private final StanzaFilter fromRoomFilter;
    private final StanzaFilter fromRoomGroupchatFilter;
    private final Set<InvitationRejectionListener> invitationRejectionListeners = new CopyOnWriteArraySet();
    private StanzaCollector messageCollector;
    private CopyOnWriteArrayList<MucMessageInterceptor> messageInterceptors;
    private final StanzaListener messageListener;
    /* access modifiers changed from: private */
    public final Set<MessageListener> messageListeners = new CopyOnWriteArraySet();
    private DiscoverInfo mucServiceDiscoInfo;
    private final MultiUserChatManager multiUserChatManager;
    /* access modifiers changed from: private */
    public EntityFullJid myRoomJid;
    /* access modifiers changed from: private */
    public final Map<EntityFullJid, Presence> occupantsMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Set<ParticipantStatusListener> participantStatusListeners = new CopyOnWriteArraySet();
    private final StanzaListener presenceInterceptor;
    /* access modifiers changed from: private */
    public final Set<PresenceListener> presenceInterceptors = new CopyOnWriteArraySet();
    private final StanzaListener presenceListener;
    /* access modifiers changed from: private */
    public final Set<PresenceListener> presenceListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public volatile boolean processedReflectedSelfPresence;
    private final EntityBareJid room;
    /* access modifiers changed from: private */
    public String subject;
    private final StanzaListener subjectListener;
    /* access modifiers changed from: private */
    public final Set<SubjectUpdatedListener> subjectUpdatedListeners = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public final Set<UserStatusListener> userStatusListeners = new CopyOnWriteArraySet();

    /* renamed from: org.jivesoftware.smackx.muc.MultiUserChat$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.Presence$Type[] r0 = org.jivesoftware.smack.packet.Presence.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type = r0
                org.jivesoftware.smack.packet.Presence$Type r1 = org.jivesoftware.smack.packet.Presence.Type.available     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.Presence$Type r1 = org.jivesoftware.smack.packet.Presence.Type.unavailable     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.MultiUserChat.AnonymousClass7.<clinit>():void");
        }
    }

    public class MucCreateConfigFormHandle {
        public MucCreateConfigFormHandle() {
        }

        public MucConfigFormManager getConfigFormManager() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
            return MultiUserChat.this.getConfigFormManager();
        }

        public void makeInstant() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
            MultiUserChat.this.sendConfigurationForm((FillableForm) null);
        }
    }

    MultiUserChat(XMPPConnection xMPPConnection, EntityBareJid entityBareJid, final MultiUserChatManager multiUserChatManager2) {
        this.connection = xMPPConnection;
        this.room = entityBareJid;
        this.multiUserChatManager = multiUserChatManager2;
        this.messageInterceptors = MultiUserChatManager.getMessageInterceptors();
        FromMatchesFilter create = FromMatchesFilter.create(entityBareJid);
        this.fromRoomFilter = create;
        this.fromRoomGroupchatFilter = new AndFilter(create, MessageTypeFilter.GROUPCHAT);
        this.messageListener = new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                Message message = (Message) stanza;
                for (MessageListener processMessage : MultiUserChat.this.messageListeners) {
                    processMessage.processMessage(message);
                }
            }
        };
        this.subjectListener = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                EntityFullJid m12 = message.getFrom().m1();
                String unused = MultiUserChat.this.subject = message.getSubject();
                for (SubjectUpdatedListener subjectUpdated : MultiUserChat.this.subjectUpdatedListeners) {
                    subjectUpdated.subjectUpdated(message.getSubject(), m12);
                }
            }
        };
        this.presenceListener = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                MultiUserChat multiUserChat;
                Presence presence = (Presence) stanza;
                EntityFullJid m12 = presence.getFrom().m1();
                if (m12 != null) {
                    boolean Y = presence.getFrom().Y(MultiUserChat.this.myRoomJid);
                    MUCUser from = MUCUser.from(stanza);
                    int i10 = AnonymousClass7.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
                    if (i10 == 1) {
                        if (!MultiUserChat.this.processedReflectedSelfPresence && from.getStatus().contains(MUCUser.Status.PRESENCE_TO_SELF_110)) {
                            boolean unused = MultiUserChat.this.processedReflectedSelfPresence = true;
                            synchronized (this) {
                                notify();
                            }
                        }
                        Presence presence2 = (Presence) MultiUserChat.this.occupantsMap.put(m12, presence);
                        if (presence2 != null) {
                            MUCUser from2 = MUCUser.from(presence2);
                            MUCAffiliation affiliation = from2.getItem().getAffiliation();
                            MUCRole role = from2.getItem().getRole();
                            MUCAffiliation affiliation2 = from.getItem().getAffiliation();
                            MultiUserChat.this.checkRoleModifications(role, from.getItem().getRole(), Y, m12);
                            MultiUserChat.this.checkAffiliationModifications(affiliation, affiliation2, Y, m12);
                        } else {
                            for (ParticipantStatusListener joined : MultiUserChat.this.participantStatusListeners) {
                                joined.joined(m12);
                            }
                        }
                    } else if (i10 == 2) {
                        MultiUserChat.this.occupantsMap.remove(m12);
                        if (from != null && from.hasStatus()) {
                            if (Y) {
                                MultiUserChat.this.userHasLeft();
                            }
                            MultiUserChat.this.checkPresenceCode(from.getStatus(), Y, from, m12);
                        } else if (!Y) {
                            for (ParticipantStatusListener left : MultiUserChat.this.participantStatusListeners) {
                                left.left(m12);
                            }
                        }
                        Destroy destroy = from.getDestroy();
                        if (destroy != null) {
                            EntityBareJid jid = destroy.getJid();
                            if (jid == null) {
                                multiUserChat = null;
                            } else {
                                multiUserChat = multiUserChatManager2.getMultiUserChat(jid);
                            }
                            for (UserStatusListener roomDestroyed : MultiUserChat.this.userStatusListeners) {
                                roomDestroyed.roomDestroyed(multiUserChat, destroy.getReason());
                            }
                        }
                        if (Y) {
                            for (UserStatusListener removed : MultiUserChat.this.userStatusListeners) {
                                removed.removed(from, presence);
                            }
                        } else {
                            for (ParticipantStatusListener parted : MultiUserChat.this.participantStatusListeners) {
                                parted.parted(m12);
                            }
                        }
                    }
                    for (PresenceListener processPresence : MultiUserChat.this.presenceListeners) {
                        processPresence.processPresence(presence);
                    }
                }
            }
        };
        this.declinesListener = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                MUCUser.Decline decline = MUCUser.from(stanza).getDecline();
                if (decline != null) {
                    MultiUserChat.this.fireInvitationRejectionListeners(message, decline);
                }
            }
        };
        this.presenceInterceptor = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Presence presence = (Presence) stanza;
                for (PresenceListener processPresence : MultiUserChat.this.presenceInterceptors) {
                    processPresence.processPresence(presence);
                }
            }
        };
    }

    private void changeAffiliationByAdmin(Jid jid, MUCAffiliation mUCAffiliation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, mUCAffiliation, (String) null);
    }

    private void changeRole(Resourcepart resourcepart, MUCRole mUCRole, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCRole, resourcepart, str));
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    /* access modifiers changed from: private */
    public void checkAffiliationModifications(MUCAffiliation mUCAffiliation, MUCAffiliation mUCAffiliation2, boolean z10, EntityFullJid entityFullJid) {
        MUCAffiliation mUCAffiliation3 = MUCAffiliation.owner;
        if (!mUCAffiliation3.equals(mUCAffiliation) || mUCAffiliation3.equals(mUCAffiliation2)) {
            MUCAffiliation mUCAffiliation4 = MUCAffiliation.admin;
            if (!mUCAffiliation4.equals(mUCAffiliation) || mUCAffiliation4.equals(mUCAffiliation2)) {
                MUCAffiliation mUCAffiliation5 = MUCAffiliation.member;
                if (mUCAffiliation5.equals(mUCAffiliation) && !mUCAffiliation5.equals(mUCAffiliation2)) {
                    if (z10) {
                        for (UserStatusListener membershipRevoked : this.userStatusListeners) {
                            membershipRevoked.membershipRevoked();
                        }
                    } else {
                        for (ParticipantStatusListener membershipRevoked2 : this.participantStatusListeners) {
                            membershipRevoked2.membershipRevoked(entityFullJid);
                        }
                    }
                }
            } else if (z10) {
                for (UserStatusListener adminRevoked : this.userStatusListeners) {
                    adminRevoked.adminRevoked();
                }
            } else {
                for (ParticipantStatusListener adminRevoked2 : this.participantStatusListeners) {
                    adminRevoked2.adminRevoked(entityFullJid);
                }
            }
        } else if (z10) {
            for (UserStatusListener ownershipRevoked : this.userStatusListeners) {
                ownershipRevoked.ownershipRevoked();
            }
        } else {
            for (ParticipantStatusListener ownershipRevoked2 : this.participantStatusListeners) {
                ownershipRevoked2.ownershipRevoked(entityFullJid);
            }
        }
        MUCAffiliation mUCAffiliation6 = MUCAffiliation.owner;
        if (mUCAffiliation6.equals(mUCAffiliation) || !mUCAffiliation6.equals(mUCAffiliation2)) {
            MUCAffiliation mUCAffiliation7 = MUCAffiliation.admin;
            if (mUCAffiliation7.equals(mUCAffiliation) || !mUCAffiliation7.equals(mUCAffiliation2)) {
                MUCAffiliation mUCAffiliation8 = MUCAffiliation.member;
                if (!mUCAffiliation8.equals(mUCAffiliation) && mUCAffiliation8.equals(mUCAffiliation2)) {
                    if (z10) {
                        for (UserStatusListener membershipGranted : this.userStatusListeners) {
                            membershipGranted.membershipGranted();
                        }
                        return;
                    }
                    for (ParticipantStatusListener membershipGranted2 : this.participantStatusListeners) {
                        membershipGranted2.membershipGranted(entityFullJid);
                    }
                }
            } else if (z10) {
                for (UserStatusListener adminGranted : this.userStatusListeners) {
                    adminGranted.adminGranted();
                }
            } else {
                for (ParticipantStatusListener adminGranted2 : this.participantStatusListeners) {
                    adminGranted2.adminGranted(entityFullJid);
                }
            }
        } else if (z10) {
            for (UserStatusListener ownershipGranted : this.userStatusListeners) {
                ownershipGranted.ownershipGranted();
            }
        } else {
            for (ParticipantStatusListener ownershipGranted2 : this.participantStatusListeners) {
                ownershipGranted2.ownershipGranted(entityFullJid);
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkPresenceCode(Set<MUCUser.Status> set, boolean z10, MUCUser mUCUser, EntityFullJid entityFullJid) {
        if (set.contains(MUCUser.Status.KICKED_307)) {
            if (z10) {
                for (UserStatusListener kicked : this.userStatusListeners) {
                    kicked.kicked(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            } else {
                for (ParticipantStatusListener kicked2 : this.participantStatusListeners) {
                    kicked2.kicked(entityFullJid, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.BANNED_301)) {
            if (z10) {
                for (UserStatusListener banned : this.userStatusListeners) {
                    banned.banned(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            } else {
                for (ParticipantStatusListener banned2 : this.participantStatusListeners) {
                    banned2.banned(entityFullJid, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.REMOVED_AFFIL_CHANGE_321) && z10) {
            for (UserStatusListener membershipRevoked : this.userStatusListeners) {
                membershipRevoked.membershipRevoked();
            }
        }
        if (set.contains(MUCUser.Status.NEW_NICKNAME_303)) {
            for (ParticipantStatusListener nicknameChanged : this.participantStatusListeners) {
                nicknameChanged.nicknameChanged(entityFullJid, mUCUser.getItem().getNick());
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkRoleModifications(MUCRole mUCRole, MUCRole mUCRole2, boolean z10, EntityFullJid entityFullJid) {
        MUCRole mUCRole3 = MUCRole.visitor;
        if ((mUCRole3.equals(mUCRole) || MUCRole.none.equals(mUCRole)) && MUCRole.participant.equals(mUCRole2)) {
            if (z10) {
                for (UserStatusListener voiceGranted : this.userStatusListeners) {
                    voiceGranted.voiceGranted();
                }
            } else {
                for (ParticipantStatusListener voiceGranted2 : this.participantStatusListeners) {
                    voiceGranted2.voiceGranted(entityFullJid);
                }
            }
        } else if (MUCRole.participant.equals(mUCRole) && (mUCRole3.equals(mUCRole2) || MUCRole.none.equals(mUCRole2))) {
            if (z10) {
                for (UserStatusListener voiceRevoked : this.userStatusListeners) {
                    voiceRevoked.voiceRevoked();
                }
            } else {
                for (ParticipantStatusListener voiceRevoked2 : this.participantStatusListeners) {
                    voiceRevoked2.voiceRevoked(entityFullJid);
                }
            }
        }
        MUCRole mUCRole4 = MUCRole.moderator;
        if (!mUCRole4.equals(mUCRole) && mUCRole4.equals(mUCRole2)) {
            if (MUCRole.visitor.equals(mUCRole) || MUCRole.none.equals(mUCRole)) {
                if (z10) {
                    for (UserStatusListener voiceGranted3 : this.userStatusListeners) {
                        voiceGranted3.voiceGranted();
                    }
                } else {
                    for (ParticipantStatusListener voiceGranted4 : this.participantStatusListeners) {
                        voiceGranted4.voiceGranted(entityFullJid);
                    }
                }
            }
            if (z10) {
                for (UserStatusListener moderatorGranted : this.userStatusListeners) {
                    moderatorGranted.moderatorGranted();
                }
                return;
            }
            for (ParticipantStatusListener moderatorGranted2 : this.participantStatusListeners) {
                moderatorGranted2.moderatorGranted(entityFullJid);
            }
        } else if (mUCRole4.equals(mUCRole) && !mUCRole4.equals(mUCRole2)) {
            if (MUCRole.visitor.equals(mUCRole2) || MUCRole.none.equals(mUCRole2)) {
                if (z10) {
                    for (UserStatusListener voiceRevoked3 : this.userStatusListeners) {
                        voiceRevoked3.voiceRevoked();
                    }
                } else {
                    for (ParticipantStatusListener voiceRevoked4 : this.participantStatusListeners) {
                        voiceRevoked4.voiceRevoked(entityFullJid);
                    }
                }
            }
            if (z10) {
                for (UserStatusListener moderatorRevoked : this.userStatusListeners) {
                    moderatorRevoked.moderatorRevoked();
                }
                return;
            }
            for (ParticipantStatusListener moderatorRevoked2 : this.participantStatusListeners) {
                moderatorRevoked2.moderatorRevoked(entityFullJid);
            }
        }
    }

    private Presence enter(MucEnterConfiguration mucEnterConfiguration) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, MultiUserChatException.NotAMucServiceException {
        DiscoverInfo mucServiceDiscoInfo2 = this.multiUserChatManager.getMucServiceDiscoInfo(this.room.R0());
        this.mucServiceDiscoInfo = mucServiceDiscoInfo2;
        if (mucServiceDiscoInfo2 != null) {
            Presence joinPresence = mucEnterConfiguration.getJoinPresence(this);
            this.connection.addStanzaListener(this.messageListener, this.fromRoomGroupchatFilter);
            StanzaTypeFilter stanzaTypeFilter = StanzaTypeFilter.PRESENCE;
            AndFilter andFilter = new AndFilter(this.fromRoomFilter, stanzaTypeFilter, PossibleFromTypeFilter.ENTITY_FULL_JID);
            this.connection.addStanzaListener(this.presenceListener, andFilter);
            this.connection.addStanzaListener(this.subjectListener, new AndFilter(this.fromRoomFilter, MessageWithSubjectFilter.INSTANCE, new NotFilter(MessageTypeFilter.ERROR), new NotFilter(MessageWithBodiesFilter.INSTANCE), new NotFilter(MessageWithThreadFilter.INSTANCE)));
            this.connection.addStanzaListener(this.declinesListener, new AndFilter(this.fromRoomFilter, DECLINE_FILTER));
            this.connection.addStanzaSendingListener(this.presenceInterceptor, new AndFilter(ToMatchesFilter.create(this.room), stanzaTypeFilter));
            this.messageCollector = this.connection.createStanzaCollector(this.fromRoomGroupchatFilter);
            AndFilter andFilter2 = new AndFilter(stanzaTypeFilter, new OrFilter(new AndFilter(FromMatchesFilter.createBare(getRoom()), MUCUserStatusCodeFilter.STATUS_110_PRESENCE_TO_SELF), new AndFilter(FromMatchesFilter.createFull(joinPresence.getTo()), new StanzaIdFilter((Stanza) joinPresence), PresenceTypeFilter.ERROR)));
            this.processedReflectedSelfPresence = false;
            StanzaCollector stanzaCollector = null;
            try {
                StanzaCollector createStanzaCollectorAndSend = this.connection.createStanzaCollectorAndSend(andFilter2, joinPresence);
                stanzaCollector = this.connection.createStanzaCollector(StanzaCollector.newConfiguration().setCollectorToReset(createStanzaCollectorAndSend).setStanzaFilter(andFilter));
                Presence presence = (Presence) createStanzaCollectorAndSend.nextResultOrThrow(mucEnterConfiguration.getTimeout());
                if (stanzaCollector != null) {
                    stanzaCollector.cancel();
                }
                synchronized (this.presenceListener) {
                    while (!this.processedReflectedSelfPresence) {
                        this.presenceListener.wait();
                    }
                }
                setNickname(presence.getFrom().F());
                this.multiUserChatManager.addJoinedRoom(this.room);
                return presence;
            } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                removeConnectionCallbacks();
                throw e10;
            } catch (Throwable th2) {
                if (stanzaCollector != null) {
                    stanzaCollector.cancel();
                }
                throw th2;
            }
        } else {
            throw new MultiUserChatException.NotAMucServiceException(this);
        }
    }

    /* access modifiers changed from: private */
    public void fireInvitationRejectionListeners(Message message, MUCUser.Decline decline) {
        int size;
        InvitationRejectionListener[] invitationRejectionListenerArr;
        EntityBareJid from = decline.getFrom();
        String reason = decline.getReason();
        synchronized (this.invitationRejectionListeners) {
            size = this.invitationRejectionListeners.size();
            invitationRejectionListenerArr = new InvitationRejectionListener[size];
            this.invitationRejectionListeners.toArray(invitationRejectionListenerArr);
        }
        for (int i10 = 0; i10 < size; i10++) {
            invitationRejectionListenerArr[i10].invitationDeclined(from, reason, message, decline);
        }
    }

    private List<Affiliate> getAffiliatesByAdmin(MUCAffiliation mUCAffiliation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation));
        ArrayList arrayList = new ArrayList();
        for (MUCItem affiliate : ((MUCAdmin) this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow()).getItems()) {
            arrayList.add(new Affiliate(affiliate));
        }
        return arrayList;
    }

    private void removeConnectionCallbacks() {
        this.connection.removeStanzaListener(this.messageListener);
        this.connection.removeStanzaListener(this.presenceListener);
        this.connection.removeStanzaListener(this.subjectListener);
        this.connection.removeStanzaListener(this.declinesListener);
        this.connection.removeStanzaSendingListener(this.presenceInterceptor);
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            stanzaCollector.cancel();
            this.messageCollector = null;
        }
    }

    private void setNickname(Resourcepart resourcepart) {
        this.myRoomJid = a.m(this.room, resourcepart);
    }

    /* access modifiers changed from: private */
    public synchronized void userHasLeft() {
        this.occupantsMap.clear();
        this.myRoomJid = null;
        this.multiUserChatManager.removeJoinedRoom(this.room);
        removeConnectionCallbacks();
    }

    public boolean addInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.add(invitationRejectionListener);
    }

    public boolean addMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        return this.messageInterceptors.add(mucMessageInterceptor);
    }

    public boolean addMessageListener(MessageListener messageListener2) {
        return this.messageListeners.add(messageListener2);
    }

    public boolean addParticipantListener(PresenceListener presenceListener2) {
        return this.presenceListeners.add(presenceListener2);
    }

    public boolean addParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.add(participantStatusListener);
    }

    public void addPresenceInterceptor(PresenceListener presenceListener2) {
        this.presenceInterceptors.add(presenceListener2);
    }

    public boolean addSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.add(subjectUpdatedListener);
    }

    public boolean addUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.add(userStatusListener);
    }

    public void banUser(Jid jid, String str) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.outcast, str);
    }

    public void banUsers(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.outcast);
    }

    public MessageBuilder buildMessage() {
        return (MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room);
    }

    public void changeAvailabilityStatus(String str, Presence.Mode mode) throws SmackException.NotConnectedException, InterruptedException, MultiUserChatException.MucNotJoinedException {
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid != null) {
            this.connection.sendStanza(((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().to((Jid) entityFullJid)).ofType(Presence.Type.available).setStatus(str).setMode(mode).build());
            return;
        }
        throw new MultiUserChatException.MucNotJoinedException(this);
    }

    public synchronized void changeNickname(Resourcepart resourcepart) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, MultiUserChatException.MucNotJoinedException {
        Objects.requireNonNull(resourcepart, "Nickname must not be null or blank.");
        if (isJoined()) {
            EntityFullJid m10 = a.m(this.room, resourcepart);
            Presence build = ((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().to((Jid) m10)).ofType(Presence.Type.available).build();
            this.connection.createStanzaCollectorAndSend(new AndFilter(FromMatchesFilter.createFull(m10), new StanzaTypeFilter(Presence.class)), build).nextResultOrThrow();
            setNickname(resourcepart);
        } else {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
    }

    public void changeSubject(final String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MessageBuilder buildMessage = buildMessage();
        buildMessage.setSubject(str);
        this.connection.createStanzaCollectorAndSend(new AndFilter(this.fromRoomGroupchatFilter, new StanzaFilter() {
            public boolean accept(Stanza stanza) {
                return str.equals(((Message) stanza).getSubject());
            }
        }), buildMessage.build()).nextResultOrThrow();
    }

    public synchronized MucCreateConfigFormHandle create(Resourcepart resourcepart) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, MultiUserChatException.MucAlreadyJoinedException, SmackException.NotConnectedException, MultiUserChatException.MissingMucCreationAcknowledgeException, MultiUserChatException.NotAMucServiceException {
        MucCreateConfigFormHandle createOrJoin;
        if (!isJoined()) {
            createOrJoin = createOrJoin(resourcepart);
            if (createOrJoin == null) {
                try {
                    leave();
                } catch (MultiUserChatException.MucNotJoinedException e10) {
                    LOGGER.log(Level.INFO, "Unexpected MucNotJoinedException", e10);
                }
                throw new MultiUserChatException.MissingMucCreationAcknowledgeException();
            }
        } else {
            throw new MultiUserChatException.MucAlreadyJoinedException();
        }
        return createOrJoin;
    }

    @Deprecated
    public Message createMessage() {
        return ((MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room)).build();
    }

    public synchronized MucCreateConfigFormHandle createOrJoin(Resourcepart resourcepart) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, MultiUserChatException.MucAlreadyJoinedException, SmackException.NotConnectedException, MultiUserChatException.NotAMucServiceException {
        return createOrJoin(getEnterConfigurationBuilder(resourcepart).build());
    }

    public MucCreateConfigFormHandle createOrJoinIfNecessary(Resourcepart resourcepart, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, MultiUserChatException.NotAMucServiceException {
        if (isJoined()) {
            return null;
        }
        try {
            return createOrJoin(getEnterConfigurationBuilder(resourcepart).withPassword(str).build());
        } catch (MultiUserChatException.MucAlreadyJoinedException unused) {
            return null;
        }
    }

    public Chat createPrivateChat(EntityFullJid entityFullJid, ChatMessageListener chatMessageListener) {
        return ChatManager.getInstanceFor(this.connection).createChat(entityFullJid, chatMessageListener);
    }

    public void destroy(String str, EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        mUCOwner.setDestroy(new Destroy(entityBareJid, str));
        try {
            this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow();
            userHasLeft();
        } catch (XMPPException.XMPPErrorException e10) {
            throw e10;
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException e11) {
            userHasLeft();
            throw e11;
        }
    }

    public List<Affiliate> getAdmins() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliatesByAdmin(MUCAffiliation.admin);
    }

    public MucConfigFormManager getConfigFormManager() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return new MucConfigFormManager(this);
    }

    public Form getConfigurationForm() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.get);
        return new Form(DataForm.from((StanzaView) (IQ) this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow(), MucConfigFormManager.FORM_TYPE));
    }

    public MucEnterConfiguration.Builder getEnterConfigurationBuilder(Resourcepart resourcepart) {
        return new MucEnterConfiguration.Builder(resourcepart, this.connection);
    }

    public List<Affiliate> getMembers() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliatesByAdmin(MUCAffiliation.member);
    }

    public List<Occupant> getModerators() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getOccupants(MUCRole.moderator);
    }

    public Resourcepart getNickname() {
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid == null) {
            return null;
        }
        return entityFullJid.q0();
    }

    public Occupant getOccupant(EntityFullJid entityFullJid) {
        Presence occupantPresence = getOccupantPresence(entityFullJid);
        if (occupantPresence != null) {
            return new Occupant(occupantPresence);
        }
        return null;
    }

    public Presence getOccupantPresence(EntityFullJid entityFullJid) {
        return this.occupantsMap.get(entityFullJid);
    }

    public List<EntityFullJid> getOccupants() {
        return new ArrayList(this.occupantsMap.keySet());
    }

    public int getOccupantsCount() {
        return this.occupantsMap.size();
    }

    public List<Affiliate> getOutcasts() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliatesByAdmin(MUCAffiliation.outcast);
    }

    public List<Affiliate> getOwners() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliatesByAdmin(MUCAffiliation.owner);
    }

    public List<Occupant> getParticipants() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getOccupants(MUCRole.participant);
    }

    public Form getRegistrationForm() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.get);
        registration.setTo(this.room);
        return new Form(DataForm.from((IQ) this.connection.createStanzaCollectorAndSend(registration).nextResultOrThrow()));
    }

    public String getReservedNickname() throws SmackException, InterruptedException {
        try {
            Iterator<DiscoverInfo.Identity> it = ServiceDiscoveryManager.getInstanceFor(this.connection).discoverInfo(this.room, "x-roomuser-item").getIdentities().iterator();
            if (it.hasNext()) {
                return it.next().getName();
            }
            return null;
        } catch (XMPPException e10) {
            LOGGER.log(Level.SEVERE, "Error retrieving room nickname", e10);
            return null;
        }
    }

    public EntityBareJid getRoom() {
        return this.room;
    }

    public String getSubject() {
        return this.subject;
    }

    public XMPPConnection getXmppConnection() {
        return this.connection;
    }

    public void grantAdmin(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void grantMembership(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.member);
    }

    public void grantModerator(Collection<Resourcepart> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(collection, MUCRole.moderator);
    }

    public void grantOwnership(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.owner);
    }

    public void grantVoice(Collection<Resourcepart> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(collection, MUCRole.participant);
    }

    public void invite(EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        invite(this.connection.getStanzaFactory().buildMessageStanza(), entityBareJid, str);
    }

    public boolean isJoined() {
        return this.myRoomJid != null;
    }

    public void join(Resourcepart resourcepart) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, MultiUserChatException.NotAMucServiceException {
        join(getEnterConfigurationBuilder(resourcepart).build());
    }

    public void kickParticipant(Resourcepart resourcepart, String str) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(resourcepart, MUCRole.none, str);
    }

    public synchronized Presence leave() throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, MultiUserChatException.MucNotJoinedException {
        Presence build;
        ArrayList arrayList;
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid != null) {
            build = ((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unavailable).to((Jid) entityFullJid)).build();
            arrayList = new ArrayList(3);
            arrayList.add(StanzaTypeFilter.PRESENCE);
            arrayList.add(new OrFilter(new AndFilter(FromMatchesFilter.createFull(entityFullJid), PresenceTypeFilter.UNAVAILABLE, MUCUserStatusCodeFilter.STATUS_110_PRESENCE_TO_SELF), new AndFilter(this.fromRoomFilter, PresenceTypeFilter.ERROR)));
            if (serviceSupportsStableIds()) {
                arrayList.add(new StanzaIdFilter((Stanza) build));
            }
            try {
            } finally {
                userHasLeft();
            }
        } else {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        return (Presence) this.connection.createStanzaCollectorAndSend(new AndFilter((List<StanzaFilter>) arrayList), build).nextResultOrThrow();
    }

    @Deprecated
    public synchronized Presence leaveSync() throws SmackException.NotConnectedException, InterruptedException, MultiUserChatException.MucNotJoinedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return leave();
    }

    public Message nextMessage() throws MultiUserChatException.MucNotJoinedException, InterruptedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            return (Message) stanzaCollector.nextResult();
        }
        throw new MultiUserChatException.MucNotJoinedException(this);
    }

    public Message pollMessage() throws MultiUserChatException.MucNotJoinedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            return (Message) stanzaCollector.pollResult();
        }
        throw new MultiUserChatException.MucNotJoinedException(this);
    }

    public boolean removeInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.remove(invitationRejectionListener);
    }

    public boolean removeMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        return this.messageInterceptors.remove(mucMessageInterceptor);
    }

    public boolean removeMessageListener(MessageListener messageListener2) {
        return this.messageListeners.remove(messageListener2);
    }

    public boolean removeParticipantListener(PresenceListener presenceListener2) {
        return this.presenceListeners.remove(presenceListener2);
    }

    public boolean removeParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.remove(participantStatusListener);
    }

    public void removePresenceInterceptor(PresenceListener presenceListener2) {
        this.presenceInterceptors.remove(presenceListener2);
    }

    public boolean removeSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.remove(subjectUpdatedListener);
    }

    public boolean removeUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.remove(userStatusListener);
    }

    public void requestVoice() throws SmackException.NotConnectedException, InterruptedException {
        DataForm.Builder formType = DataForm.builder().setFormType("http://jabber.org/protocol/muc#request");
        TextSingleFormField.Builder textSingleBuilder = FormField.textSingleBuilder("muc#role");
        textSingleBuilder.setLabel("Requested role");
        textSingleBuilder.setValue((CharSequence) "participant");
        formType.addField(textSingleBuilder.build());
        this.connection.sendStanza(((MessageBuilder) ((MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().to((Jid) this.room)).addExtension(formType.build())).build());
    }

    public void revokeAdmin(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeMembership(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.none);
    }

    public void revokeModerator(Collection<Resourcepart> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(collection, MUCRole.participant);
    }

    public void revokeOwnership(Collection<? extends Jid> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeVoice(Collection<Resourcepart> collection) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(collection, MUCRole.visitor);
    }

    public void sendConfigurationForm(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DataForm dataForm;
        if (fillableForm != null) {
            dataForm = fillableForm.getDataFormToSubmit();
        } else {
            dataForm = DataForm.builder().build();
        }
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        mUCOwner.addExtension(dataForm);
        this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow();
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(buildMessage().setBody(str).build());
    }

    public void sendRegistrationForm(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.set);
        registration.setTo(this.room);
        registration.addExtension(fillableForm.getDataFormToSubmit());
        this.connection.createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public boolean serviceSupportsStableIds() {
        return DiscoverInfo.nullSafeContainsFeature(this.mucServiceDiscoInfo, MultiUserChatConstants.STABLE_ID_FEATURE);
    }

    public String toString() {
        return "MUC: " + this.room + "(" + this.connection.getUser() + ")";
    }

    private void changeAffiliationByAdmin(Jid jid, MUCAffiliation mUCAffiliation, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation, jid, str));
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private List<Occupant> getOccupants(MUCRole mUCRole) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCRole));
        ArrayList arrayList = new ArrayList();
        for (MUCItem occupant : ((MUCAdmin) this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow()).getItems()) {
            arrayList.add(new Occupant(occupant));
        }
        return arrayList;
    }

    public void grantAdmin(Jid jid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.admin);
    }

    public void grantMembership(Jid jid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.member, (String) null);
    }

    public void grantModerator(Resourcepart resourcepart) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(resourcepart, MUCRole.moderator, (String) null);
    }

    public void grantOwnership(Jid jid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.owner, (String) null);
    }

    public void grantVoice(Resourcepart resourcepart) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(resourcepart, MUCRole.participant, (String) null);
    }

    @Deprecated
    public void invite(Message message, EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        message.setTo(this.room);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setInvite(new MUCUser.Invite(str, entityBareJid));
        message.addExtension(mUCUser);
        this.connection.sendStanza(message);
    }

    public void revokeAdmin(EntityJid entityJid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin((Jid) entityJid, MUCAffiliation.member);
    }

    public void revokeMembership(Jid jid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.none, (String) null);
    }

    public void revokeModerator(Resourcepart resourcepart) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(resourcepart, MUCRole.participant, (String) null);
    }

    public void revokeOwnership(Jid jid) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeAffiliationByAdmin(jid, MUCAffiliation.admin, (String) null);
    }

    public void revokeVoice(Resourcepart resourcepart) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        changeRole(resourcepart, MUCRole.visitor, (String) null);
    }

    public synchronized MucCreateConfigFormHandle createOrJoin(MucEnterConfiguration mucEnterConfiguration) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException, MultiUserChatException.MucAlreadyJoinedException, SmackException.NotConnectedException, MultiUserChatException.NotAMucServiceException {
        if (!isJoined()) {
            MUCUser from = MUCUser.from(enter(mucEnterConfiguration));
            if (from == null || !from.getStatus().contains(MUCUser.Status.ROOM_CREATED_201)) {
                return null;
            }
            return new MucCreateConfigFormHandle();
        }
        throw new MultiUserChatException.MucAlreadyJoinedException();
    }

    public void join(Resourcepart resourcepart, String str) throws XMPPException.XMPPErrorException, InterruptedException, SmackException.NoResponseException, SmackException.NotConnectedException, MultiUserChatException.NotAMucServiceException {
        join(getEnterConfigurationBuilder(resourcepart).withPassword(str).build());
    }

    public Message nextMessage(long j10) throws MultiUserChatException.MucNotJoinedException, InterruptedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            return (Message) stanzaCollector.nextResult(j10);
        }
        throw new MultiUserChatException.MucNotJoinedException(this);
    }

    public synchronized void join(MucEnterConfiguration mucEnterConfiguration) throws XMPPException.XMPPErrorException, SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, MultiUserChatException.NotAMucServiceException {
        if (isJoined()) {
            try {
                leaveSync();
            } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException | MultiUserChatException.MucNotJoinedException e10) {
                LOGGER.log(Level.WARNING, "Could not leave MUC prior joining, assuming we are not joined", e10);
            }
        }
        enter(mucEnterConfiguration);
    }

    @Deprecated
    public void sendMessage(Message message) throws SmackException.NotConnectedException, InterruptedException {
        sendMessage(message.asBuilder());
    }

    public MessageView sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        Iterator<MucMessageInterceptor> it = this.messageInterceptors.iterator();
        while (it.hasNext()) {
            it.next().intercept(messageBuilder, this);
        }
        Message build = ((MessageBuilder) messageBuilder.to((Jid) this.room)).ofType(Message.Type.groupchat).build();
        this.connection.sendStanza(build);
        return build;
    }

    private void changeRole(Collection<Resourcepart> collection, MUCRole mUCRole) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        for (Resourcepart mUCItem : collection) {
            mUCAdmin.addItem(new MUCItem(mUCRole, mUCItem));
        }
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private void changeAffiliationByAdmin(Collection<? extends Jid> collection, MUCAffiliation mUCAffiliation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        for (Jid mUCItem : collection) {
            mUCAdmin.addItem(new MUCItem(mUCAffiliation, mUCItem));
        }
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    public void invite(MessageBuilder messageBuilder, EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        messageBuilder.to((Jid) this.room);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setInvite(new MUCUser.Invite(str, entityBareJid));
        messageBuilder.addExtension(mUCUser);
        this.connection.sendStanza(messageBuilder.build());
    }
}
