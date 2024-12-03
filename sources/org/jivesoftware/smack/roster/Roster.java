package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.filter.ToMatchesFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.roster.packet.SubscriptionPreApproval;
import org.jivesoftware.smack.roster.rosterstore.RosterStore;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SuccessCallback;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.util.cache.LruCache;

public final class Roster extends Manager {
    public static final int INITIAL_DEFAULT_NON_ROSTER_PRESENCE_MAP_SIZE = 1024;
    private static final Map<XMPPConnection, Roster> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(Roster.class.getName());
    private static final StanzaFilter OUTGOING_USER_UNAVAILABLE_PRESENCE = new AndFilter(PresenceTypeFilter.UNAVAILABLE, ToMatchesFilter.MATCH_NO_TO_SET);
    private static final StanzaFilter PRESENCE_PACKET_FILTER = StanzaTypeFilter.PRESENCE;
    private static int defaultNonRosterPresenceMapMaxSize = 1024;
    private static SubscriptionMode defaultSubscriptionMode = SubscriptionMode.reject_all;
    private static boolean rosterLoadedAtLoginDefault = true;
    /* access modifiers changed from: private */
    public final AsyncButOrdered<BareJid> asyncButOrdered;
    /* access modifiers changed from: private */
    public final Map<BareJid, RosterEntry> entries = new ConcurrentHashMap();
    private final Map<String, RosterGroup> groups = new ConcurrentHashMap();
    private final LruCache<BareJid, Map<Resourcepart, Presence>> nonRosterPresenceMap = new LruCache<>(defaultNonRosterPresenceMapMaxSize);
    /* access modifiers changed from: private */
    public final Set<PresenceEventListener> presenceEventListeners = new CopyOnWriteArraySet();
    private final Map<BareJid, Map<Resourcepart, Presence>> presenceMap = new ConcurrentHashMap();
    private final PresencePacketListener presencePacketListener;
    private SubscriptionMode previousSubscriptionMode;
    private final Set<RosterListener> rosterListeners = new LinkedHashSet();
    private final Object rosterListenersAndEntriesLock = new Object();
    /* access modifiers changed from: private */
    public boolean rosterLoadedAtLogin;
    /* access modifiers changed from: private */
    public final Set<RosterLoadedListener> rosterLoadedListeners = new LinkedHashSet();
    /* access modifiers changed from: private */
    public RosterState rosterState = RosterState.uninitialized;
    /* access modifiers changed from: private */
    public RosterStore rosterStore;
    /* access modifiers changed from: private */
    public final Set<SubscribeListener> subscribeListeners;
    /* access modifiers changed from: private */
    public SubscriptionMode subscriptionMode;
    private final Set<RosterEntry> unfiledEntries = new CopyOnWriteArraySet();

    /* renamed from: org.jivesoftware.smack.roster.Roster$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ad */
        static {
            /*
                org.jivesoftware.smack.packet.Presence$Type[] r0 = org.jivesoftware.smack.packet.Presence.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type = r0
                r1 = 1
                org.jivesoftware.smack.packet.Presence$Type r2 = org.jivesoftware.smack.packet.Presence.Type.available     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.Presence$Type r3 = org.jivesoftware.smack.packet.Presence.Type.unavailable     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.packet.Presence$Type r4 = org.jivesoftware.smack.packet.Presence.Type.error     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smack.packet.Presence$Type r5 = org.jivesoftware.smack.packet.Presence.Type.subscribed     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$org$jivesoftware$smack$packet$Presence$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smack.packet.Presence$Type r5 = org.jivesoftware.smack.packet.Presence.Type.unsubscribed     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType[] r4 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType = r4
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r5 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.none     // Catch:{ NoSuchFieldError -> 0x004f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r4 = $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType     // Catch:{ NoSuchFieldError -> 0x0059 }
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r5 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.from     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r4 = $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType     // Catch:{ NoSuchFieldError -> 0x0063 }
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r5 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.to     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r4 = $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType     // Catch:{ NoSuchFieldError -> 0x006d }
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r5 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.both     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer[] r3 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer = r3
                org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r4 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.ApproveAndAlsoRequestIfRequired     // Catch:{ NoSuchFieldError -> 0x007e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                int[] r3 = $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer     // Catch:{ NoSuchFieldError -> 0x0088 }
                org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r4 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.Approve     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r3 = $SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer     // Catch:{ NoSuchFieldError -> 0x0092 }
                org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r4 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.Deny     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                org.jivesoftware.smack.roster.Roster$SubscriptionMode[] r3 = org.jivesoftware.smack.roster.Roster.SubscriptionMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode = r3
                org.jivesoftware.smack.roster.Roster$SubscriptionMode r4 = org.jivesoftware.smack.roster.Roster.SubscriptionMode.manual     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.jivesoftware.smack.roster.Roster$SubscriptionMode r3 = org.jivesoftware.smack.roster.Roster.SubscriptionMode.accept_all     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode     // Catch:{ NoSuchFieldError -> 0x00b7 }
                org.jivesoftware.smack.roster.Roster$SubscriptionMode r1 = org.jivesoftware.smack.roster.Roster.SubscriptionMode.reject_all     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.roster.Roster.AnonymousClass6.<clinit>():void");
        }
    }

    private class PresencePacketListener implements StanzaListener {
        private PresencePacketListener() {
        }

        public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
            final BareJid bareJid;
            if (Roster.this.rosterState == RosterState.loading) {
                try {
                    Roster.this.waitUntilLoaded();
                } catch (InterruptedException e10) {
                    Roster.LOGGER.log(Level.INFO, "Presence listener was interrupted", e10);
                }
            }
            if (!Roster.this.isLoaded() && Roster.this.rosterLoadedAtLogin) {
                Logger access$500 = Roster.LOGGER;
                access$500.warning("Roster not loaded while processing " + stanza);
            }
            final Presence presence = (Presence) stanza;
            final Jid from = presence.getFrom();
            if (from != null) {
                bareJid = from.i1();
            } else {
                XMPPConnection access$1100 = Roster.this.connection();
                if (access$1100 == null) {
                    Logger access$5002 = Roster.LOGGER;
                    access$5002.finest("Connection was null while trying to handle exotic presence stanza: " + presence);
                    return;
                }
                EntityFullJid user = access$1100.getUser();
                if (user == null) {
                    Logger access$5003 = Roster.LOGGER;
                    access$5003.info("Connection had no local address in Roster's presence listener. Possibly we received a presence without from before being authenticated. Presence: " + presence);
                    return;
                }
                Logger access$5004 = Roster.LOGGER;
                access$5004.info("Exotic presence stanza without from received: " + presence);
                bareJid = user.i1();
            }
            Roster.this.asyncButOrdered.performAsyncButOrdered(bareJid, new Runnable() {
                static final /* synthetic */ boolean $assertionsDisabled = false;

                public void run() {
                    FullJid fullJid;
                    Resourcepart resourcepart;
                    Resourcepart resourcepart2 = Resourcepart.f24273a;
                    Jid jid = from;
                    BareJid bareJid = null;
                    if (jid != null) {
                        resourcepart = jid.u();
                        if (resourcepart == null) {
                            fullJid = null;
                            bareJid = from.i1();
                            resourcepart = resourcepart2;
                        } else {
                            fullJid = from.O();
                        }
                    } else {
                        resourcepart = resourcepart2;
                        fullJid = null;
                    }
                    int i10 = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
                    if (i10 == 1) {
                        Map access$1200 = Roster.this.getOrCreatePresencesInternal(bareJid);
                        access$1200.remove(resourcepart2);
                        access$1200.put(resourcepart, presence);
                        if (Roster.this.contains(bareJid)) {
                            Roster.this.fireRosterPresenceEvent(presence);
                        }
                        for (PresenceEventListener presenceAvailable : Roster.this.presenceEventListeners) {
                            presenceAvailable.presenceAvailable(fullJid, presence);
                        }
                    } else if (i10 == 2) {
                        Map access$12002 = Roster.this.getOrCreatePresencesInternal(bareJid);
                        if (from.G1()) {
                            access$12002.put(resourcepart2, presence);
                        } else {
                            access$12002.put(resourcepart, presence);
                        }
                        if (Roster.this.contains(bareJid)) {
                            Roster.this.fireRosterPresenceEvent(presence);
                        }
                        if (fullJid != null) {
                            for (PresenceEventListener presenceUnavailable : Roster.this.presenceEventListeners) {
                                presenceUnavailable.presenceUnavailable(fullJid, presence);
                            }
                            return;
                        }
                        Roster.LOGGER.fine("Unavailable presence from bare JID: " + presence);
                    } else if (i10 == 3) {
                        Jid jid2 = from;
                        if (jid2 != null && jid2.t0()) {
                            Map access$12003 = Roster.this.getOrCreatePresencesInternal(bareJid);
                            access$12003.clear();
                            access$12003.put(resourcepart2, presence);
                            if (Roster.this.contains(bareJid)) {
                                Roster.this.fireRosterPresenceEvent(presence);
                            }
                            for (PresenceEventListener presenceError : Roster.this.presenceEventListeners) {
                                presenceError.presenceError(from, presence);
                            }
                        }
                    } else if (i10 == 4) {
                        for (PresenceEventListener presenceSubscribed : Roster.this.presenceEventListeners) {
                            presenceSubscribed.presenceSubscribed(bareJid, presence);
                        }
                    } else if (i10 == 5) {
                        for (PresenceEventListener presenceUnsubscribed : Roster.this.presenceEventListeners) {
                            presenceUnsubscribed.presenceUnsubscribed(bareJid, presence);
                        }
                    }
                }
            });
        }
    }

    private final class RosterPushListener extends AbstractIqRequestHandler {
        public IQ handleIQRequest(IQ iq) {
            XMPPConnection access$2400 = Roster.this.connection();
            RosterPacket rosterPacket = (RosterPacket) iq;
            EntityFullJid user = access$2400.getUser();
            if (user == null) {
                Logger access$500 = Roster.LOGGER;
                access$500.warning("Ignoring roster push " + iq + " while " + access$2400 + " has no bound resource. This may be a server bug.");
                return null;
            }
            EntityBareJid E0 = user.E0();
            Jid from = rosterPacket.getFrom();
            if (from != null) {
                if (from.Y(user)) {
                    Logger access$5002 = Roster.LOGGER;
                    access$5002.warning("Received roster push from full JID. This behavior is since RFC 6121 not longer standard compliant. Please ask your server vendor to fix this and comply to RFC 6121 § 2.1.6. IQ roster push stanza: " + iq);
                } else if (!from.Y(E0)) {
                    Logger access$5003 = Roster.LOGGER;
                    access$5003.warning("Ignoring roster push with a non matching 'from' ourJid='" + E0 + "' from='" + from + "'");
                    return IQ.createErrorResponse(iq, StanzaError.Condition.service_unavailable);
                }
            }
            List<RosterPacket.Item> rosterItems = rosterPacket.getRosterItems();
            if (rosterItems.size() != 1) {
                Logger access$5004 = Roster.LOGGER;
                access$5004.warning("Ignoring roster push with not exactly one entry. size=" + rosterItems.size());
                return IQ.createErrorResponse(iq, StanzaError.Condition.bad_request);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            RosterPacket.Item next = rosterItems.iterator().next();
            RosterEntry rosterEntry = new RosterEntry(next, Roster.this, access$2400);
            String version = rosterPacket.getVersion();
            if (next.getItemType().equals(RosterPacket.ItemType.remove)) {
                Roster.this.deleteEntry(arrayList3, rosterEntry);
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.removeEntry(rosterEntry.getJid(), version);
                }
            } else if (Roster.hasValidSubscriptionType(next)) {
                Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, next, rosterEntry);
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.addEntry(next, version);
                }
            }
            Roster.this.removeEmptyGroups();
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            return IQ.createResultIQ(rosterPacket);
        }

        private RosterPushListener() {
            super("query", RosterPacket.NAMESPACE, IQ.Type.set, IQRequestHandler.Mode.sync);
        }
    }

    private class RosterResultListener implements SuccessCallback<IQ> {
        private RosterResultListener() {
        }

        public void onSuccess(IQ iq) {
            XMPPConnection access$1600 = Roster.this.connection();
            Roster.LOGGER.log(Level.FINE, "RosterResultListener received {0}", iq);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (iq instanceof RosterPacket) {
                RosterPacket rosterPacket = (RosterPacket) iq;
                ArrayList arrayList5 = new ArrayList();
                for (RosterPacket.Item next : rosterPacket.getRosterItems()) {
                    if (Roster.hasValidSubscriptionType(next)) {
                        arrayList5.add(next);
                    }
                }
                Iterator it = arrayList5.iterator();
                while (it.hasNext()) {
                    RosterPacket.Item item = (RosterPacket.Item) it.next();
                    Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, item, new RosterEntry(item, Roster.this, access$1600));
                }
                HashSet<Jid> hashSet = new HashSet<>();
                for (RosterEntry jid : Roster.this.entries.values()) {
                    hashSet.add(jid.getJid());
                }
                hashSet.removeAll(arrayList);
                hashSet.removeAll(arrayList2);
                hashSet.removeAll(arrayList4);
                for (Jid jid2 : hashSet) {
                    Roster roster = Roster.this;
                    roster.deleteEntry(arrayList3, (RosterEntry) roster.entries.get(jid2));
                }
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.resetEntries(arrayList5, rosterPacket.getVersion());
                }
                Roster.this.removeEmptyGroups();
            } else {
                List<RosterPacket.Item> entries = Roster.this.rosterStore.getEntries();
                if (entries == null) {
                    Roster.this.rosterStore.resetStore();
                    try {
                        Roster.this.reload();
                        return;
                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e10) {
                        Roster.LOGGER.log(Level.FINE, "Exception while trying to load the roster after the roster store was corrupted", e10);
                        return;
                    }
                } else {
                    for (RosterPacket.Item next2 : entries) {
                        Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, next2, new RosterEntry(next2, Roster.this, access$1600));
                    }
                }
            }
            RosterState unused = Roster.this.rosterState = RosterState.loaded;
            synchronized (Roster.this) {
                Roster.this.notifyAll();
            }
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            try {
                synchronized (Roster.this.rosterLoadedListeners) {
                    for (RosterLoadedListener onRosterLoaded : Roster.this.rosterLoadedListeners) {
                        onRosterLoaded.onRosterLoaded(Roster.this);
                    }
                }
            } catch (Exception e11) {
                Roster.LOGGER.log(Level.WARNING, "RosterLoadedListener threw exception", e11);
            }
        }
    }

    private enum RosterState {
        uninitialized,
        loading,
        loaded
    }

    public enum SubscriptionMode {
        accept_all,
        reject_all,
        manual
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                Roster.getInstanceFor(xMPPConnection);
            }
        });
    }

    private Roster(final XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        PresencePacketListener presencePacketListener2 = new PresencePacketListener();
        this.presencePacketListener = presencePacketListener2;
        this.rosterLoadedAtLogin = rosterLoadedAtLoginDefault;
        this.subscriptionMode = getDefaultSubscriptionMode();
        this.subscribeListeners = new CopyOnWriteArraySet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        xMPPConnection.registerIQRequestHandler(new RosterPushListener());
        xMPPConnection.addSyncStanzaListener(presencePacketListener2, PRESENCE_PACKET_FILTER);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            /* JADX WARNING: Removed duplicated region for block: B:7:0x002f A[LOOP:0: B:7:0x002f->B:10:0x003f, LOOP_START, PHI: r5 
              PHI: (r5v3 org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer) = (r5v0 org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer), (r5v7 org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer) binds: [B:6:0x0025, B:10:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void processStanza(org.jivesoftware.smack.packet.Stanza r8) throws org.jivesoftware.smack.SmackException.NotConnectedException, java.lang.InterruptedException, org.jivesoftware.smack.SmackException.NotLoggedInException {
                /*
                    r7 = this;
                    org.jivesoftware.smack.packet.Presence r8 = (org.jivesoftware.smack.packet.Presence) r8
                    org.jxmpp.jid.Jid r0 = r8.getFrom()
                    int[] r1 = org.jivesoftware.smack.roster.Roster.AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode
                    org.jivesoftware.smack.roster.Roster r2 = org.jivesoftware.smack.roster.Roster.this
                    org.jivesoftware.smack.roster.Roster$SubscriptionMode r2 = r2.subscriptionMode
                    int r2 = r2.ordinal()
                    r1 = r1[r2]
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    r5 = 0
                    if (r1 == r4) goto L_0x0025
                    if (r1 == r3) goto L_0x0022
                    if (r1 == r2) goto L_0x001f
                    goto L_0x0044
                L_0x001f:
                    org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r5 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.Deny
                    goto L_0x0044
                L_0x0022:
                    org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r5 = org.jivesoftware.smack.roster.SubscribeListener.SubscribeAnswer.Approve
                    goto L_0x0044
                L_0x0025:
                    org.jivesoftware.smack.roster.Roster r1 = org.jivesoftware.smack.roster.Roster.this
                    java.util.Set r1 = r1.subscribeListeners
                    java.util.Iterator r1 = r1.iterator()
                L_0x002f:
                    boolean r6 = r1.hasNext()
                    if (r6 == 0) goto L_0x0041
                    java.lang.Object r5 = r1.next()
                    org.jivesoftware.smack.roster.SubscribeListener r5 = (org.jivesoftware.smack.roster.SubscribeListener) r5
                    org.jivesoftware.smack.roster.SubscribeListener$SubscribeAnswer r5 = r5.processSubscribe(r0, r8)
                    if (r5 == 0) goto L_0x002f
                L_0x0041:
                    if (r5 != 0) goto L_0x0044
                    return
                L_0x0044:
                    if (r5 != 0) goto L_0x0047
                    return
                L_0x0047:
                    int[] r1 = org.jivesoftware.smack.roster.Roster.AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$SubscribeListener$SubscribeAnswer
                    int r5 = r5.ordinal()
                    r1 = r1[r5]
                    if (r1 == r4) goto L_0x005e
                    if (r1 == r3) goto L_0x0067
                    if (r1 != r2) goto L_0x0058
                    org.jivesoftware.smack.packet.Presence$Type r0 = org.jivesoftware.smack.packet.Presence.Type.unsubscribed
                    goto L_0x0069
                L_0x0058:
                    java.lang.AssertionError r8 = new java.lang.AssertionError
                    r8.<init>()
                    throw r8
                L_0x005e:
                    org.jxmpp.jid.BareJid r0 = r0.i1()
                    org.jivesoftware.smack.roster.Roster r1 = org.jivesoftware.smack.roster.Roster.this
                    org.jivesoftware.smack.roster.RosterUtil.askForSubscriptionIfRequired(r1, r0)
                L_0x0067:
                    org.jivesoftware.smack.packet.Presence$Type r0 = org.jivesoftware.smack.packet.Presence.Type.subscribed
                L_0x0069:
                    org.jivesoftware.smack.XMPPConnection r1 = r4
                    org.jivesoftware.smack.packet.StanzaFactory r1 = r1.getStanzaFactory()
                    org.jivesoftware.smack.packet.PresenceBuilder r1 = r1.buildPresenceStanza()
                    org.jivesoftware.smack.packet.PresenceBuilder r0 = r1.ofType(r0)
                    org.jxmpp.jid.Jid r8 = r8.getFrom()
                    org.jivesoftware.smack.packet.StanzaBuilder r8 = r0.to((org.jxmpp.jid.Jid) r8)
                    org.jivesoftware.smack.packet.PresenceBuilder r8 = (org.jivesoftware.smack.packet.PresenceBuilder) r8
                    org.jivesoftware.smack.packet.Presence r8 = r8.build()
                    org.jivesoftware.smack.XMPPConnection r0 = r4
                    r0.sendStanza(r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.roster.Roster.AnonymousClass2.processStanza(org.jivesoftware.smack.packet.Stanza):void");
            }
        }, PresenceTypeFilter.SUBSCRIBE);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (Roster.this.isRosterLoadedAtLogin() && !z10) {
                    Roster.this.setOfflinePresencesAndResetLoaded();
                    try {
                        Roster.this.reload();
                    } catch (InterruptedException | SmackException e10) {
                        Roster.LOGGER.log(Level.SEVERE, "Could not reload Roster", e10);
                    }
                }
            }

            public void connectionClosed() {
                Roster.this.setOfflinePresencesAndResetLoaded();
            }
        });
        xMPPConnection.addStanzaSendingListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Roster.this.setOfflinePresences();
            }
        }, OUTGOING_USER_UNAVAILABLE_PRESENCE);
        if (xMPPConnection.isAuthenticated()) {
            try {
                reloadAndWait();
            } catch (InterruptedException | SmackException e10) {
                LOGGER.log(Level.SEVERE, "Could not reload Roster", e10);
            }
        }
    }

    /* access modifiers changed from: private */
    public void addUpdateEntry(Collection<Jid> collection, Collection<Jid> collection2, Collection<Jid> collection3, RosterPacket.Item item, RosterEntry rosterEntry) {
        RosterEntry put;
        synchronized (this.rosterListenersAndEntriesLock) {
            put = this.entries.put(item.getJid(), rosterEntry);
        }
        if (put == null) {
            BareJid jid = item.getJid();
            collection.add(jid);
            move(jid, this.nonRosterPresenceMap, this.presenceMap);
        } else {
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(put);
            if (!put.equalsDeep(rosterEntry) || !item.getGroupNames().equals(rosterItem.getGroupNames())) {
                collection2.add(item.getJid());
                put.updateItem(item);
            } else {
                collection3.add(item.getJid());
            }
        }
        if (item.getGroupNames().isEmpty()) {
            this.unfiledEntries.add(rosterEntry);
        } else {
            this.unfiledEntries.remove(rosterEntry);
        }
        ArrayList arrayList = new ArrayList();
        for (String next : item.getGroupNames()) {
            arrayList.add(next);
            RosterGroup group = getGroup(next);
            if (group == null) {
                group = createGroup(next);
                this.groups.put(next, group);
            }
            group.addEntryLocal(rosterEntry);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (RosterGroup name : getGroups()) {
            arrayList2.add(name.getName());
        }
        arrayList2.removeAll(arrayList);
        for (String str : arrayList2) {
            RosterGroup group2 = getGroup(str);
            group2.removeEntryLocal(rosterEntry);
            if (group2.getEntryCount() == 0) {
                this.groups.remove(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void deleteEntry(Collection<Jid> collection, RosterEntry rosterEntry) {
        BareJid jid = rosterEntry.getJid();
        this.entries.remove(jid);
        this.unfiledEntries.remove(rosterEntry);
        move(jid, this.presenceMap, this.nonRosterPresenceMap);
        collection.add(jid);
        for (Map.Entry next : this.groups.entrySet()) {
            RosterGroup rosterGroup = (RosterGroup) next.getValue();
            rosterGroup.removeEntryLocal(rosterEntry);
            if (rosterGroup.getEntryCount() == 0) {
                this.groups.remove(next.getKey());
            }
        }
    }

    /* access modifiers changed from: private */
    public void fireRosterChangedEvent(Collection<Jid> collection, Collection<Jid> collection2, Collection<Jid> collection3) {
        synchronized (this.rosterListenersAndEntriesLock) {
            for (RosterListener next : this.rosterListeners) {
                if (!collection.isEmpty()) {
                    next.entriesAdded(collection);
                }
                if (!collection2.isEmpty()) {
                    next.entriesUpdated(collection2);
                }
                if (!collection3.isEmpty()) {
                    next.entriesDeleted(collection3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void fireRosterPresenceEvent(Presence presence) {
        synchronized (this.rosterListenersAndEntriesLock) {
            for (RosterListener presenceChanged : this.rosterListeners) {
                presenceChanged.presenceChanged(presence);
            }
        }
    }

    public static SubscriptionMode getDefaultSubscriptionMode() {
        return defaultSubscriptionMode;
    }

    public static synchronized Roster getInstanceFor(XMPPConnection xMPPConnection) {
        Roster roster;
        synchronized (Roster.class) {
            Map<XMPPConnection, Roster> map = INSTANCES;
            roster = map.get(xMPPConnection);
            if (roster == null) {
                roster = new Roster(xMPPConnection);
                map.put(xMPPConnection, roster);
            }
        }
        return roster;
    }

    /* access modifiers changed from: private */
    public synchronized Map<Resourcepart, Presence> getOrCreatePresencesInternal(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal;
        presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            if (contains(bareJid)) {
                presencesInternal = new ConcurrentHashMap<>();
                this.presenceMap.put(bareJid, presencesInternal);
            } else {
                presencesInternal = new LruCache<>(32);
                this.nonRosterPresenceMap.put(bareJid, presencesInternal);
            }
        }
        return presencesInternal;
    }

    private Map<Resourcepart, Presence> getPresencesInternal(BareJid bareJid) {
        Map<Resourcepart, Presence> map = this.presenceMap.get(bareJid);
        if (map == null) {
            return this.nonRosterPresenceMap.a(bareJid);
        }
        return map;
    }

    /* access modifiers changed from: private */
    public static boolean hasValidSubscriptionType(RosterPacket.Item item) {
        int i10 = AnonymousClass6.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[item.getItemType().ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4;
    }

    private static void move(BareJid bareJid, Map<BareJid, Map<Resourcepart, Presence>> map, Map<BareJid, Map<Resourcepart, Presence>> map2) {
        Map remove = map.remove(bareJid);
        if (remove != null && !remove.isEmpty()) {
            map2.put(bareJid, remove);
        }
    }

    /* access modifiers changed from: private */
    public void removeEmptyGroups() {
        for (RosterGroup next : getGroups()) {
            if (next.getEntryCount() == 0) {
                this.groups.remove(next.getName());
            }
        }
    }

    public static void setDefaultNonRosterPresenceMapMaxSize(int i10) {
        defaultNonRosterPresenceMapMaxSize = i10;
    }

    public static void setDefaultSubscriptionMode(SubscriptionMode subscriptionMode2) {
        defaultSubscriptionMode = subscriptionMode2;
    }

    /* access modifiers changed from: private */
    public void setOfflinePresences() {
        for (Jid next : this.presenceMap.keySet()) {
            Map map = this.presenceMap.get(next);
            if (map != null) {
                for (Resourcepart resourcepart : map.keySet()) {
                    PresenceBuilder ofType = StanzaBuilder.buildPresence().ofType(Presence.Type.unavailable);
                    EntityBareJid h12 = next.h1();
                    if (h12 == null) {
                        Logger logger = LOGGER;
                        logger.warning("Can not transform user JID to bare JID: '" + next + "'");
                    } else {
                        ofType.from((Jid) a.r(h12, resourcepart));
                        try {
                            this.presencePacketListener.processStanza(ofType.build());
                        } catch (SmackException.NotConnectedException e10) {
                            throw new IllegalStateException("presencePacketListener should never throw a NotConnectedException when processStanza is called with a presence of type unavailable", e10);
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setOfflinePresencesAndResetLoaded() {
        setOfflinePresences();
        this.rosterState = RosterState.uninitialized;
    }

    public static void setRosterLoadedAtLoginDefault(boolean z10) {
        rosterLoadedAtLoginDefault = z10;
    }

    private static Presence synthesizeUnvailablePresence(Jid jid) {
        return ((PresenceBuilder) StanzaBuilder.buildPresence().ofType(Presence.Type.unavailable).from(jid)).build();
    }

    public boolean addPresenceEventListener(PresenceEventListener presenceEventListener) {
        return this.presenceEventListeners.add(presenceEventListener);
    }

    public boolean addRosterListener(RosterListener rosterListener) {
        boolean add;
        synchronized (this.rosterListenersAndEntriesLock) {
            add = this.rosterListeners.add(rosterListener);
        }
        return add;
    }

    public boolean addRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean add;
        synchronized (rosterLoadedListener) {
            add = this.rosterLoadedListeners.add(rosterLoadedListener);
        }
        return add;
    }

    public boolean addSubscribeListener(SubscribeListener subscribeListener) {
        Objects.requireNonNull(subscribeListener, "SubscribeListener argument must not be null");
        SubscriptionMode subscriptionMode2 = this.subscriptionMode;
        SubscriptionMode subscriptionMode3 = SubscriptionMode.manual;
        if (subscriptionMode2 != subscriptionMode3) {
            this.previousSubscriptionMode = subscriptionMode2;
            this.subscriptionMode = subscriptionMode3;
        }
        return this.subscribeListeners.add(subscribeListener);
    }

    public boolean contains(BareJid bareJid) {
        return getEntry(bareJid) != null;
    }

    @Deprecated
    public void createEntry(BareJid bareJid, String str, String[] strArr) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        createItemAndRequestSubscription(bareJid, str, strArr);
    }

    public RosterGroup createGroup(String str) {
        XMPPConnection connection = connection();
        if (this.groups.containsKey(str)) {
            return this.groups.get(str);
        }
        RosterGroup rosterGroup = new RosterGroup(str, connection);
        this.groups.put(str, rosterGroup);
        return rosterGroup;
    }

    public void createItem(BareJid bareJid, String str, String[] strArr) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setType(IQ.Type.set);
        RosterPacket.Item item = new RosterPacket.Item(bareJid, str);
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && str2.trim().length() > 0) {
                    item.addGroupName(str2);
                }
            }
        }
        rosterPacket.addRosterItem(item);
        authenticatedConnectionOrThrow.createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
    }

    public void createItemAndRequestSubscription(BareJid bareJid, String str, String[] strArr) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        createItem(bareJid, str, strArr);
        sendSubscriptionRequest(bareJid);
    }

    public List<Presence> getAllPresences(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return new ArrayList(Arrays.asList(new Presence[]{synthesizeUnvailablePresence(bareJid)}));
        }
        ArrayList arrayList = new ArrayList(presencesInternal.values().size());
        for (Presence add : presencesInternal.values()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public List<Presence> getAvailablePresences(BareJid bareJid) {
        List<Presence> allPresences = getAllPresences(bareJid);
        ArrayList arrayList = new ArrayList(allPresences.size());
        for (Presence next : allPresences) {
            if (next.isAvailable()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Set<RosterEntry> getEntries() {
        HashSet hashSet;
        synchronized (this.rosterListenersAndEntriesLock) {
            hashSet = new HashSet(this.entries.size());
            for (RosterEntry add : this.entries.values()) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public void getEntriesAndAddListener(RosterListener rosterListener, RosterEntries rosterEntries) {
        Objects.requireNonNull(rosterListener, "listener must not be null");
        Objects.requireNonNull(rosterEntries, "rosterEntries must not be null");
        synchronized (this.rosterListenersAndEntriesLock) {
            rosterEntries.rosterEntries(this.entries.values());
            addRosterListener(rosterListener);
        }
    }

    public RosterEntry getEntry(BareJid bareJid) {
        if (bareJid == null) {
            return null;
        }
        return this.entries.get(bareJid);
    }

    public int getEntryCount() {
        return getEntries().size();
    }

    public RosterGroup getGroup(String str) {
        return this.groups.get(str);
    }

    public int getGroupCount() {
        return this.groups.size();
    }

    public Collection<RosterGroup> getGroups() {
        return Collections.unmodifiableCollection(this.groups.values());
    }

    public Presence getPresence(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return synthesizeUnvailablePresence(bareJid);
        }
        Presence presence = null;
        Presence presence2 = null;
        for (Presence next : presencesInternal.values()) {
            if (!next.isAvailable()) {
                presence2 = next;
            } else {
                if (presence != null && next.getPriority() <= presence.getPriority()) {
                    if (next.getPriority() == presence.getPriority()) {
                        Presence.Mode mode = next.getMode();
                        if (mode == null) {
                            mode = Presence.Mode.available;
                        }
                        Presence.Mode mode2 = presence.getMode();
                        if (mode2 == null) {
                            mode2 = Presence.Mode.available;
                        }
                        if (mode.compareTo(mode2) >= 0) {
                        }
                    }
                }
                presence = next;
            }
        }
        if (presence != null) {
            return presence;
        }
        if (presence2 != null) {
            return presence2;
        }
        return synthesizeUnvailablePresence(bareJid);
    }

    public Presence getPresenceResource(FullJid fullJid) {
        BareJid i12 = fullJid.i1();
        Resourcepart q02 = fullJid.q0();
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(i12);
        if (presencesInternal == null) {
            return synthesizeUnvailablePresence(fullJid);
        }
        Presence presence = presencesInternal.get(q02);
        if (presence == null) {
            return synthesizeUnvailablePresence(fullJid);
        }
        return presence;
    }

    public List<Presence> getPresences(BareJid bareJid) {
        Map<Resourcepart, Presence> presencesInternal = getPresencesInternal(bareJid);
        if (presencesInternal == null) {
            return Arrays.asList(new Presence[]{synthesizeUnvailablePresence(bareJid)});
        }
        ArrayList arrayList = new ArrayList();
        Presence presence = null;
        for (Presence next : presencesInternal.values()) {
            if (next.isAvailable()) {
                arrayList.add(next);
            } else {
                presence = next;
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        if (presence != null) {
            return Arrays.asList(new Presence[]{presence});
        }
        return Arrays.asList(new Presence[]{synthesizeUnvailablePresence(bareJid)});
    }

    /* access modifiers changed from: package-private */
    public RosterStore getRosterStore() {
        return this.rosterStore;
    }

    public SubscriptionMode getSubscriptionMode() {
        return this.subscriptionMode;
    }

    public Set<RosterEntry> getUnfiledEntries() {
        return Collections.unmodifiableSet(this.unfiledEntries);
    }

    public int getUnfiledEntryCount() {
        return this.unfiledEntries.size();
    }

    public boolean iAmSubscribedTo(Jid jid) {
        RosterEntry entry;
        if (jid == null || (entry = getEntry(jid.i1())) == null) {
            return false;
        }
        return entry.canSeeHisPresence();
    }

    public boolean isLoaded() {
        return this.rosterState == RosterState.loaded;
    }

    public boolean isRosterLoadedAtLogin() {
        return this.rosterLoadedAtLogin;
    }

    public boolean isRosterVersioningSupported() {
        return connection().hasFeature(RosterVer.ELEMENT, RosterVer.NAMESPACE);
    }

    public boolean isSubscribedToMyPresence(Jid jid) {
        if (jid == null) {
            return false;
        }
        BareJid i12 = jid.i1();
        if (connection().getXMPPServiceDomain().Y(i12)) {
            return true;
        }
        RosterEntry entry = getEntry(i12);
        if (entry == null) {
            return false;
        }
        return entry.canSeeMyPresence();
    }

    public boolean isSubscriptionPreApprovalSupported() throws SmackException.NotLoggedInException {
        return getAuthenticatedConnectionOrThrow().hasFeature("sub", SubscriptionPreApproval.NAMESPACE);
    }

    public void preApprove(BareJid bareJid) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException, SmackException.FeatureNotSupportedException {
        XMPPConnection connection = connection();
        if (isSubscriptionPreApprovalSupported()) {
            connection.sendStanza(((PresenceBuilder) connection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribed).to((Jid) bareJid)).build());
            return;
        }
        throw new SmackException.FeatureNotSupportedException("Pre-approving");
    }

    public void preApproveAndCreateEntry(BareJid bareJid, String str, String[] strArr) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.FeatureNotSupportedException {
        preApprove(bareJid);
        createItemAndRequestSubscription(bareJid, str, strArr);
    }

    public void reload() throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        RosterPacket rosterPacket = new RosterPacket();
        if (this.rosterStore != null && isRosterVersioningSupported()) {
            rosterPacket.setVersion(this.rosterStore.getRosterVersion());
        }
        this.rosterState = RosterState.loading;
        authenticatedConnectionOrThrow.sendIqRequestAsync(rosterPacket).onSuccess(new RosterResultListener()).onError(new ExceptionCallback<Exception>() {
            public void processException(Exception exc) {
                Level level;
                RosterState unused = Roster.this.rosterState = RosterState.uninitialized;
                if (exc instanceof SmackException.NotConnectedException) {
                    level = Level.FINE;
                } else {
                    level = Level.SEVERE;
                }
                Roster.LOGGER.log(level, "Exception reloading roster", exc);
                for (RosterLoadedListener onRosterLoadingFailed : Roster.this.rosterLoadedListeners) {
                    onRosterLoadingFailed.onRosterLoadingFailed(exc);
                }
            }
        });
    }

    public void reloadAndWait() throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException {
        reload();
        waitUntilLoaded();
    }

    public void removeEntry(RosterEntry rosterEntry) throws SmackException.NotLoggedInException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        if (this.entries.containsKey(rosterEntry.getJid())) {
            RosterPacket rosterPacket = new RosterPacket();
            rosterPacket.setType(IQ.Type.set);
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
            rosterItem.setItemType(RosterPacket.ItemType.remove);
            rosterPacket.addRosterItem(rosterItem);
            authenticatedConnectionOrThrow.createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
        }
    }

    public boolean removePresenceEventListener(PresenceEventListener presenceEventListener) {
        return this.presenceEventListeners.remove(presenceEventListener);
    }

    public boolean removeRosterListener(RosterListener rosterListener) {
        boolean remove;
        synchronized (this.rosterListenersAndEntriesLock) {
            remove = this.rosterListeners.remove(rosterListener);
        }
        return remove;
    }

    public boolean removeRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean remove;
        synchronized (rosterLoadedListener) {
            remove = this.rosterLoadedListeners.remove(rosterLoadedListener);
        }
        return remove;
    }

    public boolean removeSubscribeListener(SubscribeListener subscribeListener) {
        boolean remove = this.subscribeListeners.remove(subscribeListener);
        if (remove && this.subscribeListeners.isEmpty()) {
            setSubscriptionMode(this.previousSubscriptionMode);
        }
        return remove;
    }

    public void sendSubscriptionRequest(BareJid bareJid) throws SmackException.NotLoggedInException, SmackException.NotConnectedException, InterruptedException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        authenticatedConnectionOrThrow.sendStanza(((PresenceBuilder) authenticatedConnectionOrThrow.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.subscribe).to((Jid) bareJid)).build());
    }

    public void setNonRosterPresenceMapMaxSize(int i10) {
        this.nonRosterPresenceMap.b(i10);
    }

    public void setRosterLoadedAtLogin(boolean z10) {
        this.rosterLoadedAtLogin = z10;
    }

    public boolean setRosterStore(RosterStore rosterStore2) {
        this.rosterStore = rosterStore2;
        try {
            reload();
            return true;
        } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e10) {
            LOGGER.log(Level.FINER, "Could not reload roster", e10);
            return false;
        }
    }

    public void setSubscriptionMode(SubscriptionMode subscriptionMode2) {
        this.subscriptionMode = subscriptionMode2;
    }

    /* access modifiers changed from: protected */
    public boolean waitUntilLoaded() throws InterruptedException {
        long replyTimeout = connection().getReplyTimeout();
        long currentTimeMillis = System.currentTimeMillis();
        while (!isLoaded() && replyTimeout > 0) {
            synchronized (this) {
                if (!isLoaded()) {
                    wait(replyTimeout);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            replyTimeout -= currentTimeMillis2 - currentTimeMillis;
            currentTimeMillis = currentTimeMillis2;
        }
        return isLoaded();
    }
}
