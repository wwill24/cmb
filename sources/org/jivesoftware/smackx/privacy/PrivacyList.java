package org.jivesoftware.smackx.privacy;

import java.util.List;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

public class PrivacyList {
    private final boolean isActiveList;
    private final boolean isDefaultList;
    private final List<PrivacyItem> items;
    private final String listName;

    protected PrivacyList(boolean z10, boolean z11, String str, List<PrivacyItem> list) {
        this.isActiveList = z10;
        this.isDefaultList = z11;
        this.listName = str;
        this.items = list;
    }

    public List<PrivacyItem> getItems() {
        return this.items;
    }

    public String getName() {
        return this.listName;
    }

    public boolean isActiveList() {
        return this.isActiveList;
    }

    public boolean isDefaultList() {
        return this.isDefaultList;
    }

    public String toString() {
        return "Privacy List: " + this.listName + "(active:" + this.isActiveList + ", default:" + this.isDefaultList + ")";
    }
}
