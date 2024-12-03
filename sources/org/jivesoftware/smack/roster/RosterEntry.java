package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

public final class RosterEntry extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private RosterPacket.Item item;
    private final Roster roster;

    /* renamed from: org.jivesoftware.smack.roster.RosterEntry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType[] r0 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType = r0
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r1 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.from     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r1 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.both     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.roster.packet.RosterPacket$ItemType r1 = org.jivesoftware.smack.roster.packet.RosterPacket.ItemType.to     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.roster.RosterEntry.AnonymousClass1.<clinit>():void");
        }
    }

    RosterEntry(RosterPacket.Item item2, Roster roster2, XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.item = item2;
        this.roster = roster2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, RosterEntry rosterEntry) {
        builder.append(getJid(), rosterEntry.getJid());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equalsDeep$1(EqualsUtil.Builder builder, RosterEntry rosterEntry) {
        builder.append(this.item, rosterEntry.item);
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry) {
        return toRosterItem(rosterEntry, rosterEntry.getName(), false);
    }

    public boolean canSeeHisPresence() {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[getType().ordinal()];
        return i10 == 2 || i10 == 3;
    }

    public boolean canSeeMyPresence() {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[getType().ordinal()];
        return i10 == 1 || i10 == 2;
    }

    public void cancelSubscription() throws SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = connection();
        connection.sendStanza(((PresenceBuilder) connection.getStanzaFactory().buildPresenceStanza().to((Jid) this.item.getJid())).ofType(Presence.Type.unsubscribed).build());
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new b(this));
    }

    public boolean equalsDeep(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public List<RosterGroup> getGroups() {
        ArrayList arrayList = new ArrayList();
        for (RosterGroup next : this.roster.getGroups()) {
            if (next.contains(this)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public BareJid getJid() {
        return this.item.getJid();
    }

    public String getName() {
        return this.item.getName();
    }

    public RosterPacket.ItemType getType() {
        return this.item.getItemType();
    }

    @Deprecated
    public String getUser() {
        return getJid().toString();
    }

    public int hashCode() {
        return getJid().hashCode();
    }

    public boolean isApproved() {
        return this.item.isApproved();
    }

    public boolean isSubscriptionPending() {
        return this.item.isSubscriptionPending();
    }

    public synchronized void setName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, InterruptedException {
        if (str != null) {
            if (str.equals(getName())) {
                return;
            }
        }
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setType(IQ.Type.set);
        rosterPacket.addRosterItem(toRosterItem(this, str));
        connection().createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
        this.item.setName(str);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getName() != null) {
            sb2.append(getName());
            sb2.append(": ");
        }
        sb2.append(getJid());
        List<RosterGroup> groups = getGroups();
        if (!groups.isEmpty()) {
            sb2.append(" [");
            Iterator<RosterGroup> it = groups.iterator();
            sb2.append(it.next().getName());
            while (it.hasNext()) {
                sb2.append(", ");
                sb2.append(it.next().getName());
            }
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public void updateItem(RosterPacket.Item item2) {
        this.item = item2;
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, String str) {
        return toRosterItem(rosterEntry, str, false);
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, boolean z10) {
        return toRosterItem(rosterEntry, rosterEntry.getName(), z10);
    }

    private static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, String str, boolean z10) {
        RosterPacket.Item item2 = new RosterPacket.Item(rosterEntry.getJid(), str);
        item2.setItemType(rosterEntry.getType());
        if (z10) {
            item2.setSubscriptionPending(rosterEntry.isSubscriptionPending());
        }
        item2.setApproved(rosterEntry.isApproved());
        for (RosterGroup name : rosterEntry.getGroups()) {
            item2.addGroupName(name.getName());
        }
        return item2;
    }
}
