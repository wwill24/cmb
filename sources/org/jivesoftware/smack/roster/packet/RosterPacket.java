package org.jivesoftware.smack.roster.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

public final class RosterPacket extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:roster";
    private final List<Item> rosterItems = new ArrayList();
    private String rosterVersion;

    public static final class Item implements ExtensionElement {
        public static final String ELEMENT = "item";
        public static final String GROUP = "group";
        public static final QName QNAME = new QName(RosterPacket.NAMESPACE, "item");
        private boolean approved;
        private final Set<String> groupNames;
        private ItemType itemType;
        private final BareJid jid;
        private String name;
        private boolean subscriptionPending;

        public Item(BareJid bareJid, String str) {
            this(bareJid, str, false);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, Item item) {
            builder.append(this.groupNames, item.groupNames).append(this.subscriptionPending, item.subscriptionPending).append(this.itemType, item.itemType).append(this.name, item.name).append(this.jid, item.jid).append(this.approved, item.approved);
        }

        public void addGroupName(String str) {
            this.groupNames.add(str);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new a(this));
        }

        public String getElementName() {
            return QNAME.getLocalPart();
        }

        public Set<String> getGroupNames() {
            return Collections.unmodifiableSet(this.groupNames);
        }

        public ItemType getItemType() {
            return this.itemType;
        }

        public BareJid getJid() {
            return this.jid;
        }

        public String getName() {
            return this.name;
        }

        public String getNamespace() {
            return QNAME.getNamespaceURI();
        }

        @Deprecated
        public String getUser() {
            return this.jid.toString();
        }

        public int hashCode() {
            return HashCode.builder().append((Object) this.groupNames).append(this.subscriptionPending).append((Object) this.itemType).append((Object) this.name).append((Object) this.jid).append(this.approved).build();
        }

        public boolean isApproved() {
            return this.approved;
        }

        public boolean isSubscriptionPending() {
            return this.subscriptionPending;
        }

        public void removeGroupName(String str) {
            this.groupNames.remove(str);
        }

        public void setApproved(boolean z10) {
            this.approved = z10;
        }

        public void setItemType(ItemType itemType2) {
            this.itemType = (ItemType) Objects.requireNonNull(itemType2, "itemType must not be null");
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSubscriptionPending(boolean z10) {
            this.subscriptionPending = z10;
        }

        public Item(BareJid bareJid, String str, boolean z10) {
            this.itemType = ItemType.none;
            this.jid = (BareJid) Objects.requireNonNull(bareJid);
            this.name = str;
            this.subscriptionPending = z10;
            this.groupNames = new CopyOnWriteArraySet();
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", (CharSequence) this.jid);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute("subscription", (Enum<?>) this.itemType);
            if (this.subscriptionPending) {
                xmlStringBuilder.append((CharSequence) " ask='subscribe'");
            }
            xmlStringBuilder.optBooleanAttribute("approved", this.approved);
            xmlStringBuilder.rightAngleBracket();
            for (String escape : this.groupNames) {
                xmlStringBuilder.openElement("group").escape(escape).closeElement("group");
            }
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public enum ItemType {
        none(8869),
        to(8592),
        from(8594),
        both(8596),
        remove(9889);
        
        private static final char ME = '●';
        private final String symbol;

        private ItemType(char c10) {
            StringBuilder sb2 = new StringBuilder(2);
            sb2.append(ME);
            sb2.append(c10);
            this.symbol = sb2.toString();
        }

        public static ItemType fromString(String str) {
            if (StringUtils.isNullOrEmpty((CharSequence) str)) {
                return none;
            }
            return valueOf(str.toLowerCase(Locale.US));
        }

        public String asSymbol() {
            return this.symbol;
        }
    }

    public RosterPacket() {
        super("query", NAMESPACE);
    }

    public void addRosterItem(Item item) {
        synchronized (this.rosterItems) {
            this.rosterItems.add(item);
        }
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(RosterVer.ELEMENT, this.rosterVersion);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.rosterItems) {
            for (Item xml : this.rosterItems) {
                iQChildElementXmlStringBuilder.append(xml.toXML());
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public int getRosterItemCount() {
        int size;
        synchronized (this.rosterItems) {
            size = this.rosterItems.size();
        }
        return size;
    }

    public List<Item> getRosterItems() {
        ArrayList arrayList;
        synchronized (this.rosterItems) {
            arrayList = new ArrayList(this.rosterItems);
        }
        return arrayList;
    }

    public String getVersion() {
        return this.rosterVersion;
    }

    public void setVersion(String str) {
        this.rosterVersion = str;
    }
}
