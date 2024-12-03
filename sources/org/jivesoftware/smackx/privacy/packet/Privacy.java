package org.jivesoftware.smackx.privacy.packet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.IQ;

public class Privacy extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:privacy";
    private String activeName;
    private boolean declineActiveList = false;
    private boolean declineDefaultList = false;
    private String defaultName;
    private final Map<String, List<PrivacyItem>> itemLists = new HashMap();

    public Privacy() {
        super("query", "jabber:iq:privacy");
    }

    public boolean changeDefaultList(String str) {
        if (!getItemLists().containsKey(str)) {
            return false;
        }
        setDefaultName(str);
        return true;
    }

    public void deleteList(String str) {
        getItemLists().remove(str);
    }

    public void deletePrivacyList(String str) {
        getItemLists().remove(str);
        if (getDefaultName() != null && str.equals(getDefaultName())) {
            setDefaultName((String) null);
        }
    }

    public String getActiveName() {
        return this.activeName;
    }

    public List<PrivacyItem> getActivePrivacyList() {
        if (getActiveName() == null) {
            return null;
        }
        return getItemLists().get(getActiveName());
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public List<PrivacyItem> getDefaultPrivacyList() {
        if (getDefaultName() == null) {
            return null;
        }
        return getItemLists().get(getDefaultName());
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (isDeclineActiveList()) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<active/>");
        } else if (getActiveName() != null) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<active name=\"").escape(getActiveName()).append((CharSequence) "\"/>");
        }
        if (isDeclineDefaultList()) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<default/>");
        } else if (getDefaultName() != null) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<default name=\"").escape(getDefaultName()).append((CharSequence) "\"/>");
        }
        for (Map.Entry next : getItemLists().entrySet()) {
            String str = (String) next.getKey();
            List<PrivacyItem> list = (List) next.getValue();
            if (list.isEmpty()) {
                iQChildElementXmlStringBuilder.append((CharSequence) "<list name=\"").escape(str).append((CharSequence) "\"/>");
            } else {
                iQChildElementXmlStringBuilder.append((CharSequence) "<list name=\"").escape(str).append((CharSequence) "\">");
            }
            for (PrivacyItem xml : list) {
                iQChildElementXmlStringBuilder.append((CharSequence) xml.toXML());
            }
            if (!list.isEmpty()) {
                iQChildElementXmlStringBuilder.append((CharSequence) "</list>");
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public PrivacyItem getItem(String str, int i10) {
        return getItem(str, UInt32.from((long) i10));
    }

    public Map<String, List<PrivacyItem>> getItemLists() {
        return this.itemLists;
    }

    public List<PrivacyItem> getPrivacyList(String str) {
        return getItemLists().get(str);
    }

    public Set<String> getPrivacyListNames() {
        return this.itemLists.keySet();
    }

    public boolean isDeclineActiveList() {
        return this.declineActiveList;
    }

    public boolean isDeclineDefaultList() {
        return this.declineDefaultList;
    }

    public void setActiveName(String str) {
        this.activeName = str;
    }

    public List<PrivacyItem> setActivePrivacyList() {
        setActiveName(getDefaultName());
        return getItemLists().get(getActiveName());
    }

    public void setDeclineActiveList(boolean z10) {
        this.declineActiveList = z10;
    }

    public void setDeclineDefaultList(boolean z10) {
        this.declineDefaultList = z10;
    }

    public void setDefaultName(String str) {
        this.defaultName = str;
    }

    public List<PrivacyItem> setPrivacyList(String str, List<PrivacyItem> list) {
        getItemLists().put(str, list);
        return list;
    }

    public PrivacyItem getItem(String str, UInt32 uInt32) {
        Iterator<PrivacyItem> it = getPrivacyList(str).iterator();
        PrivacyItem privacyItem = null;
        while (privacyItem == null && it.hasNext()) {
            PrivacyItem next = it.next();
            if (next.getOrder().equals(uInt32)) {
                privacyItem = next;
            }
        }
        return privacyItem;
    }
}
