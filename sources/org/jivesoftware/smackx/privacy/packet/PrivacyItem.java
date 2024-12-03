package org.jivesoftware.smackx.privacy.packet;

import java.util.Objects;
import org.jivesoftware.smack.datatypes.UInt32;

public class PrivacyItem {
    public static final String SUBSCRIPTION_BOTH = "both";
    public static final String SUBSCRIPTION_FROM = "from";
    public static final String SUBSCRIPTION_NONE = "none";
    public static final String SUBSCRIPTION_TO = "to";
    private final boolean allow;
    private boolean filterIQ;
    private boolean filterMessage;
    private boolean filterPresenceIn;
    private boolean filterPresenceOut;
    private final UInt32 order;
    private final Type type;
    private final String value;

    public enum Type {
        group,
        jid,
        subscription
    }

    public PrivacyItem(boolean z10, long j10) {
        this((Type) null, (String) null, z10, UInt32.from(j10));
    }

    public UInt32 getOrder() {
        return this.order;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isAllow() {
        return this.allow;
    }

    public boolean isFilterEverything() {
        if (isFilterIQ() || isFilterMessage() || isFilterPresenceIn() || isFilterPresenceOut()) {
            return false;
        }
        return true;
    }

    public boolean isFilterIQ() {
        return this.filterIQ;
    }

    public boolean isFilterMessage() {
        return this.filterMessage;
    }

    public boolean isFilterPresenceIn() {
        return this.filterPresenceIn;
    }

    public boolean isFilterPresenceOut() {
        return this.filterPresenceOut;
    }

    public void setFilterIQ(boolean z10) {
        this.filterIQ = z10;
    }

    public void setFilterMessage(boolean z10) {
        this.filterMessage = z10;
    }

    public void setFilterPresenceIn(boolean z10) {
        this.filterPresenceIn = z10;
    }

    public void setFilterPresenceOut(boolean z10) {
        this.filterPresenceOut = z10;
    }

    public String toXML() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<item");
        if (isAllow()) {
            sb2.append(" action=\"allow\"");
        } else {
            sb2.append(" action=\"deny\"");
        }
        sb2.append(" order=\"");
        sb2.append(getOrder());
        sb2.append('\"');
        if (getType() != null) {
            sb2.append(" type=\"");
            sb2.append(getType());
            sb2.append('\"');
        }
        if (getValue() != null) {
            sb2.append(" value=\"");
            sb2.append(getValue());
            sb2.append('\"');
        }
        if (isFilterEverything()) {
            sb2.append("/>");
        } else {
            sb2.append('>');
            if (isFilterIQ()) {
                sb2.append("<iq/>");
            }
            if (isFilterMessage()) {
                sb2.append("<message/>");
            }
            if (isFilterPresenceIn()) {
                sb2.append("<presence-in/>");
            }
            if (isFilterPresenceOut()) {
                sb2.append("<presence-out/>");
            }
            sb2.append("</item>");
        }
        return sb2.toString();
    }

    public PrivacyItem(boolean z10, UInt32 uInt32) {
        this((Type) null, (String) null, z10, uInt32);
    }

    public PrivacyItem(Type type2, String str, boolean z10, long j10) {
        this(type2, str, z10, UInt32.from(j10));
    }

    public PrivacyItem(Type type2, String str, boolean z10, UInt32 uInt32) {
        this.filterIQ = false;
        this.filterMessage = false;
        this.filterPresenceIn = false;
        this.filterPresenceOut = false;
        this.type = type2;
        this.value = str;
        this.allow = z10;
        Objects.requireNonNull(uInt32);
        UInt32 uInt322 = uInt32;
        this.order = uInt32;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PrivacyItem(Type type2, CharSequence charSequence, boolean z10, long j10) {
        this(type2, charSequence != null ? charSequence.toString() : null, z10, j10);
    }
}
