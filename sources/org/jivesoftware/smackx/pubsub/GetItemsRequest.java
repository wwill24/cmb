package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

public class GetItemsRequest extends NodeExtension {
    protected final int maxItems;
    protected final String subId;

    public GetItemsRequest(String str) {
        this(str, (String) null, -1);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("subid", getSubscriptionId());
        xmlStringBuilder.optIntAttribute("max_items", getMaxItems());
        xmlStringBuilder.closeEmptyElement();
    }

    public int getMaxItems() {
        return this.maxItems;
    }

    public String getSubscriptionId() {
        return this.subId;
    }

    public GetItemsRequest(String str, String str2) {
        this(str, str2, -1);
    }

    public GetItemsRequest(String str, int i10) {
        this(str, (String) null, i10);
    }

    public GetItemsRequest(String str, String str2, int i10) {
        super(PubSubElementType.ITEMS, str);
        this.maxItems = i10;
        this.subId = str2;
    }
}
